package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.AssetHeatmap;
import com.ruoyi.system.domain.AssetIpc;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.AssetCapacity;
import com.ruoyi.system.service.IAssetCapacityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 容量可视化Controller
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Controller
@RequestMapping("/system/capacity")
public class AssetCapacityController extends BaseController
{
    private String prefix = "system/capacity";

    @Autowired
    private IAssetCapacityService assetCapacityService;

    @RequiresPermissions("system:capacity:view")
    @GetMapping()
    public String capacity()
    {
        return prefix + "/capacity";
    }

    /**
     * 查询容量可视化列表
     */
    @RequiresPermissions("system:capacity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetCapacity assetCapacity)
    {
        startPage();
        List<AssetCapacity> list = assetCapacityService.selectAssetCapacityList(assetCapacity);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
//    @RequiresPermissions("system:heatmap:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetCapacity> util = new ExcelUtil<AssetCapacity>(AssetCapacity.class);
        List<AssetCapacity> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetCapacity assetCapacity=userList.get(i);
            assetCapacityService.insertAssetCapacity(assetCapacity);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetCapacity> util=new ExcelUtil<AssetCapacity>(AssetCapacity.class);
        return util.importTemplateExcel("容量可视化");
    }

    /**
     * 导出容量可视化列表
     */
    @RequiresPermissions("system:capacity:export")
    @Log(title = "容量可视化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetCapacity assetCapacity)
    {
        List<AssetCapacity> list = assetCapacityService.selectAssetCapacityList(assetCapacity);
        ExcelUtil<AssetCapacity> util = new ExcelUtil<AssetCapacity>(AssetCapacity.class);
        return util.exportExcel(list, "容量可视化数据");
    }

    /**
     * 新增容量可视化
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存容量可视化
     */
    @RequiresPermissions("system:capacity:add")
    @Log(title = "容量可视化", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetCapacity assetCapacity)
    {
        return toAjax(assetCapacityService.insertAssetCapacity(assetCapacity));
    }

    /**
     * 修改容量可视化
     */
    @RequiresPermissions("system:capacity:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetCapacity assetCapacity = assetCapacityService.selectAssetCapacityById(id);
        mmap.put("assetCapacity", assetCapacity);
        return prefix + "/edit";
    }

    /**
     * 修改保存容量可视化
     */
    @RequiresPermissions("system:capacity:edit")
    @Log(title = "容量可视化", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetCapacity assetCapacity)
    {
        return toAjax(assetCapacityService.updateAssetCapacity(assetCapacity));
    }

    /**
     * 删除容量可视化
     */
    @RequiresPermissions("system:capacity:remove")
    @Log(title = "容量可视化", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetCapacityService.deleteAssetCapacityByIds(ids));
    }
}
