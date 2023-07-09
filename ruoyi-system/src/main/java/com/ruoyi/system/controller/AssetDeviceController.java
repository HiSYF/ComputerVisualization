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
import com.ruoyi.system.domain.AssetDevice;
import com.ruoyi.system.service.IAssetDeviceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【设备信息】Controller
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
@Controller
@RequestMapping("/system/device")
public class AssetDeviceController extends BaseController
{
    private String prefix = "system/device";

    @Autowired
    private IAssetDeviceService assetDeviceService;

    @RequiresPermissions("system:device:view")
    @GetMapping()
    public String device()
    {
        return prefix + "/device";
    }

    /**
     * 查询【设备信息】列表
     */
    @RequiresPermissions("system:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetDevice assetDevice)
    {
        startPage();
        List<AssetDevice> list = assetDeviceService.selectAssetDeviceList(assetDevice);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
    @RequiresPermissions("system:device:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetDevice> util = new ExcelUtil<AssetDevice>(AssetDevice.class);
        List<AssetDevice> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetDevice assetDevice=userList.get(i);             assetDeviceService.insertAssetDevice(assetDevice);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetDevice> util=new ExcelUtil<AssetDevice>(AssetDevice.class);
        return util.importTemplateExcel("设备信息");
    }
    /**
     * 导出【设备信息】列表
     */
    @RequiresPermissions("system:device:export")
    @Log(title = "【设备信息】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetDevice assetDevice)
    {
        List<AssetDevice> list = assetDeviceService.selectAssetDeviceList(assetDevice);
        ExcelUtil<AssetDevice> util = new ExcelUtil<AssetDevice>(AssetDevice.class);
        return util.exportExcel(list, "【设备信息】数据");
    }

    /**
     * 新增【设备信息】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【设备信息】
     */
    @RequiresPermissions("system:device:add")
    @Log(title = "【设备信息】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetDevice assetDevice)
    {
        return toAjax(assetDeviceService.insertAssetDevice(assetDevice));
    }

    /**
     * 修改【设备信息】
     */
    @RequiresPermissions("system:device:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetDevice assetDevice = assetDeviceService.selectAssetDeviceById(id);
        mmap.put("assetDevice", assetDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存【设备信息】
     */
    @RequiresPermissions("system:device:edit")
    @Log(title = "【设备信息】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetDevice assetDevice)
    {
        return toAjax(assetDeviceService.updateAssetDevice(assetDevice));
    }

    /**
     * 删除【设备信息】
     */
    @RequiresPermissions("system:device:remove")
    @Log(title = "【设备信息】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetDeviceService.deleteAssetDeviceByIds(ids));
    }
}
