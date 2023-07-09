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
import com.ruoyi.system.domain.AssetAlarm;
import com.ruoyi.system.service.IAssetAlarmService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【告警】Controller
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
@Controller
@RequestMapping("/system/alarm")
public class AssetAlarmController extends BaseController
{
    private String prefix = "system/alarm";

    @Autowired
    private IAssetAlarmService assetAlarmService;

    @RequiresPermissions("system:alarm:view")
    @GetMapping()
    public String alarm()
    {
        return prefix + "/alarm";
    }

    /**
     * 查询【告警】列表
     */
    @RequiresPermissions("system:alarm:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetAlarm assetAlarm)
    {
        startPage();
        List<AssetAlarm> list = assetAlarmService.selectAssetAlarmList(assetAlarm);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
    @RequiresPermissions("system:alarm:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetAlarm> util = new ExcelUtil<AssetAlarm>(AssetAlarm.class);
        List<AssetAlarm> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetAlarm assetAlarm=userList.get(i);             assetAlarmService.insertAssetAlarm(assetAlarm);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetAlarm> util=new ExcelUtil<AssetAlarm>(AssetAlarm.class);
        return util.importTemplateExcel("告警");
    }
    /**
     * 导出【告警】列表
     */
    @RequiresPermissions("system:alarm:export")
    @Log(title = "【告警】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetAlarm assetAlarm)
    {
        List<AssetAlarm> list = assetAlarmService.selectAssetAlarmList(assetAlarm);
        ExcelUtil<AssetAlarm> util = new ExcelUtil<AssetAlarm>(AssetAlarm.class);
        return util.exportExcel(list, "【告警】数据");
    }

    /**
     * 新增【告警】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【告警】
     */
    @RequiresPermissions("system:alarm:add")
    @Log(title = "【告警】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetAlarm assetAlarm)
    {
        return toAjax(assetAlarmService.insertAssetAlarm(assetAlarm));
    }

    /**
     * 修改【告警】
     */
    @RequiresPermissions("system:alarm:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetAlarm assetAlarm = assetAlarmService.selectAssetAlarmById(id);
        mmap.put("assetAlarm", assetAlarm);
        return prefix + "/edit";
    }

    /**
     * 修改保存【告警】
     */
    @RequiresPermissions("system:alarm:edit")
    @Log(title = "【告警】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetAlarm assetAlarm)
    {
        return toAjax(assetAlarmService.updateAssetAlarm(assetAlarm));
    }

    /**
     * 删除【告警】
     */
    @RequiresPermissions("system:alarm:remove")
    @Log(title = "【告警】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetAlarmService.deleteAssetAlarmByIds(ids));
    }
}
