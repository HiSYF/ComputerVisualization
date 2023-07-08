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
import com.ruoyi.system.domain.AssetPue;
import com.ruoyi.system.service.IAssetPueService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * pueController
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
@Controller
@RequestMapping("/system/pue")
public class AssetPueController extends BaseController
{
    private String prefix = "system/pue";

    @Autowired
    private IAssetPueService assetPueService;

    @RequiresPermissions("system:pue:view")
    @GetMapping()
    public String pue()
    {
        return prefix + "/pue";
    }

    /**
     * 查询pue列表
     */
    @RequiresPermissions("system:pue:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetPue assetPue)
    {
        startPage();
        List<AssetPue> list = assetPueService.selectAssetPueList(assetPue);
        return getDataTable(list);
    }

    /**
     * 导出pue列表
     */
    @RequiresPermissions("system:pue:export")
    @Log(title = "pue", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetPue assetPue)
    {
        List<AssetPue> list = assetPueService.selectAssetPueList(assetPue);
        ExcelUtil<AssetPue> util = new ExcelUtil<AssetPue>(AssetPue.class);
        return util.exportExcel(list, "pue数据");
    }

    /**
     * 新增pue
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存pue
     */
    @RequiresPermissions("system:pue:add")
    @Log(title = "pue", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetPue assetPue)
    {
        return toAjax(assetPueService.insertAssetPue(assetPue));
    }

    /**
     * 修改pue
     */
    @RequiresPermissions("system:pue:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetPue assetPue = assetPueService.selectAssetPueById(id);
        mmap.put("assetPue", assetPue);
        return prefix + "/edit";
    }

    /**
     * 修改保存pue
     */
    @RequiresPermissions("system:pue:edit")
    @Log(title = "pue", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetPue assetPue)
    {
        return toAjax(assetPueService.updateAssetPue(assetPue));
    }

    /**
     * 删除pue
     */
    @RequiresPermissions("system:pue:remove")
    @Log(title = "pue", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetPueService.deleteAssetPueByIds(ids));
    }
}
