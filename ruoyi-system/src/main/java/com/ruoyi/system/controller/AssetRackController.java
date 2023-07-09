package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.AssetRack;
import com.ruoyi.system.service.IAssetRackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@Controller
@RequestMapping("/system/rack")
public class AssetRackController extends BaseController
{
    private String prefix = "system/rack";

    @Autowired
    private IAssetRackService assetRackService;

    @RequiresPermissions("system:rack:view")
    @GetMapping()
    public String rack()
    {
        return prefix + "/rack";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:rack:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetRack assetRack)
    {
        startPage();
        List<AssetRack> list = assetRackService.selectAssetRackList(assetRack);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:rack:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetRack assetRack)
    {
        List<AssetRack> list = assetRackService.selectAssetRackList(assetRack);
        ExcelUtil<AssetRack> util = new ExcelUtil<AssetRack>(AssetRack.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:rack:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetRack assetRack)
    {
        return toAjax(assetRackService.insertAssetRack(assetRack));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:rack:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetRack assetRack = assetRackService.selectAssetRackById(id);
        mmap.put("assetRack", assetRack);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:rack:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetRack assetRack)
    {
        return toAjax(assetRackService.updateAssetRack(assetRack));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:rack:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetRackService.deleteAssetRackByIds(ids));
    }
    /**
     * 按模板导入
     */
    @PostMapping("/importData")
    @RequiresPermissions("system:rack:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetRack> util = new ExcelUtil<AssetRack>(AssetRack.class);
        List<AssetRack> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetRack assetRack=userList.get(i);             assetRackService.insertAssetRack(assetRack);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetRack> util=new ExcelUtil<AssetRack>(AssetRack.class);
        return util.importTemplateExcel("机柜信息");
    }
}
