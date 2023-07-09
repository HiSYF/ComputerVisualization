package com.ruoyi.system.controller;

import java.util.List;

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
import com.ruoyi.system.domain.AssetHeatmap;
import com.ruoyi.system.service.IAssetHeatmapService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 云图可视化Controller
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Controller
@RequestMapping("/system/heatmap")
public class AssetHeatmapController extends BaseController
{
    private String prefix = "system/heatmap";

    @Autowired
    private IAssetHeatmapService assetHeatmapService;

    @RequiresPermissions("system:heatmap:view")
    @GetMapping()
    public String heatmap()
    {
        return prefix + "/heatmap";
    }

    /**
     * 查询云图可视化列表
     */
    @RequiresPermissions("system:heatmap:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetHeatmap assetHeatmap)
    {
        startPage();
        List<AssetHeatmap> list = assetHeatmapService.selectAssetHeatmapList(assetHeatmap);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
//    @RequiresPermissions("system:heatmap:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetHeatmap> util = new ExcelUtil<AssetHeatmap>(AssetHeatmap.class);
        List<AssetHeatmap> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetHeatmap assetHeatmap=userList.get(i);
            assetHeatmapService.insertAssetHeatmap(assetHeatmap);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetHeatmap> util=new ExcelUtil<AssetHeatmap>(AssetHeatmap.class);
        return util.importTemplateExcel("云图可视化");
    }
    /**
     * 导出云图可视化列表
     */
    @RequiresPermissions("system:heatmap:export")
    @Log(title = "云图可视化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetHeatmap assetHeatmap)
    {
        List<AssetHeatmap> list = assetHeatmapService.selectAssetHeatmapList(assetHeatmap);
        ExcelUtil<AssetHeatmap> util = new ExcelUtil<AssetHeatmap>(AssetHeatmap.class);
        return util.exportExcel(list, "云图可视化数据");
    }

    /**
     * 新增云图可视化
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存云图可视化
     */
    @RequiresPermissions("system:heatmap:add")
    @Log(title = "云图可视化", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetHeatmap assetHeatmap)
    {
        return toAjax(assetHeatmapService.insertAssetHeatmap(assetHeatmap));
    }

    /**
     * 修改云图可视化
     */
    @RequiresPermissions("system:heatmap:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetHeatmap assetHeatmap = assetHeatmapService.selectAssetHeatmapById(id);
        mmap.put("assetHeatmap", assetHeatmap);
        return prefix + "/edit";
    }

    /**
     * 修改保存云图可视化
     */
    @RequiresPermissions("system:heatmap:edit")
    @Log(title = "云图可视化", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetHeatmap assetHeatmap)
    {
        return toAjax(assetHeatmapService.updateAssetHeatmap(assetHeatmap));
    }

    /**
     * 删除云图可视化
     */
    @RequiresPermissions("system:heatmap:remove")
    @Log(title = "云图可视化", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetHeatmapService.deleteAssetHeatmapByIds(ids));
    }
}
