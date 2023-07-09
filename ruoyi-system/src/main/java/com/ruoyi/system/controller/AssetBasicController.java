package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.AssetRack;
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
import com.ruoyi.system.domain.AssetBasic;
import com.ruoyi.system.service.IAssetBasicService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【基础信息】Controller
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
@Controller
@RequestMapping("/system/basic")
public class AssetBasicController extends BaseController
{
    private String prefix = "system/basic";

    @Autowired
    private IAssetBasicService assetBasicService;

    @RequiresPermissions("system:basic:view")
    @GetMapping()
    public String basic()
    {
        return prefix + "/basic";
    }

    /**
     * 查询【基础信息】列表
     */
    @RequiresPermissions("system:basic:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetBasic assetBasic)
    {
        startPage();
        List<AssetBasic> list = assetBasicService.selectAssetBasicList(assetBasic);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
    @RequiresPermissions("system:basic:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetBasic> util = new ExcelUtil<AssetBasic>(AssetBasic.class);
        List<AssetBasic> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetBasic assetBasic=userList.get(i);             assetBasicService.insertAssetBasic(assetBasic);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetBasic> util=new ExcelUtil<AssetBasic>(AssetBasic.class);
        return util.importTemplateExcel("基础信息");
    }
    /**
     * 导出【基础信息】列表
     */
    @RequiresPermissions("system:basic:export")
    @Log(title = "【基础信息】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetBasic assetBasic)
    {
        List<AssetBasic> list = assetBasicService.selectAssetBasicList(assetBasic);
        ExcelUtil<AssetBasic> util = new ExcelUtil<AssetBasic>(AssetBasic.class);
        return util.exportExcel(list, "【基础信息】数据");
    }

    /**
     * 新增【基础信息】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【基础信息】
     */
    @RequiresPermissions("system:basic:add")
    @Log(title = "【基础信息】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetBasic assetBasic)
    {
        return toAjax(assetBasicService.insertAssetBasic(assetBasic));
    }

    /**
     * 修改【基础信息】
     */
    @RequiresPermissions("system:basic:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetBasic assetBasic = assetBasicService.selectAssetBasicById(id);
        mmap.put("assetBasic", assetBasic);
        return prefix + "/edit";
    }

    /**
     * 修改保存【基础信息】
     */
    @RequiresPermissions("system:basic:edit")
    @Log(title = "【基础信息】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetBasic assetBasic)
    {
        return toAjax(assetBasicService.updateAssetBasic(assetBasic));
    }

    /**
     * 删除【基础信息】
     */
    @RequiresPermissions("system:basic:remove")
    @Log(title = "【基础信息】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetBasicService.deleteAssetBasicByIds(ids));
    }
}
