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
import com.ruoyi.system.domain.AssetServerInfo;
import com.ruoyi.system.service.IAssetServerInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 服务器基础信息Controller
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@Controller
@RequestMapping("/system/info")
public class AssetServerInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IAssetServerInfoService assetServerInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询服务器基础信息列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetServerInfo assetServerInfo)
    {
        startPage();
        List<AssetServerInfo> list = assetServerInfoService.selectAssetServerInfoList(assetServerInfo);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
    @RequiresPermissions("system:info:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetServerInfo> util = new ExcelUtil<AssetServerInfo>(AssetServerInfo.class);
        List<AssetServerInfo> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetServerInfo assetServerInfo=userList.get(i);             assetServerInfoService.insertAssetServerInfo(assetServerInfo);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetServerInfo> util=new ExcelUtil<AssetServerInfo>(AssetServerInfo.class);
        return util.importTemplateExcel("服务器基础信息");
    }
    /**
     * 导出服务器基础信息列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "服务器基础信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetServerInfo assetServerInfo)
    {
        List<AssetServerInfo> list = assetServerInfoService.selectAssetServerInfoList(assetServerInfo);
        ExcelUtil<AssetServerInfo> util = new ExcelUtil<AssetServerInfo>(AssetServerInfo.class);
        return util.exportExcel(list, "服务器基础信息数据");
    }

    /**
     * 新增服务器基础信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存服务器基础信息
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "服务器基础信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetServerInfo assetServerInfo)
    {
        return toAjax(assetServerInfoService.insertAssetServerInfo(assetServerInfo));
    }

    /**
     * 修改服务器基础信息
     */
    @RequiresPermissions("system:info:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetServerInfo assetServerInfo = assetServerInfoService.selectAssetServerInfoById(id);
        mmap.put("assetServerInfo", assetServerInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存服务器基础信息
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "服务器基础信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetServerInfo assetServerInfo)
    {
        return toAjax(assetServerInfoService.updateAssetServerInfo(assetServerInfo));
    }

    /**
     * 删除服务器基础信息
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "服务器基础信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetServerInfoService.deleteAssetServerInfoByIds(ids));
    }
}
