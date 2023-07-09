package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.AssetServerInfo;
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
import com.ruoyi.system.domain.AssetIpc;
import com.ruoyi.system.service.IAssetIpcService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 监控可视化Controller
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Controller
@RequestMapping("/system/ipc")
public class AssetIpcController extends BaseController
{
    private String prefix = "system/ipc";

    @Autowired
    private IAssetIpcService assetIpcService;

    @RequiresPermissions("system:ipc:view")
    @GetMapping()
    public String ipc()
    {
        return prefix + "/ipc";
    }

    /**
     * 查询监控可视化列表
     */
    @RequiresPermissions("system:ipc:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AssetIpc assetIpc)
    {
        startPage();
        List<AssetIpc> list = assetIpcService.selectAssetIpcList(assetIpc);
        return getDataTable(list);
    }

    /**
     * 按模板导入
     */
    @PostMapping("/importData")
//    @RequiresPermissions("system:ipc:import")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception     {
        ExcelUtil<AssetIpc> util = new ExcelUtil<AssetIpc>(AssetIpc.class);
        List<AssetIpc> userList = util.importExcel(file.getInputStream());
        for (int i=0;i<userList.size();i++){
            AssetIpc assetIpc=userList.get(i);             assetIpcService.insertAssetIpc(assetIpc);
        }
        return AjaxResult.success();
    }
    /*     下载模板     * */
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult   importTemplate(){
        ExcelUtil<AssetIpc> util=new ExcelUtil<AssetIpc>(AssetIpc.class);
        return util.importTemplateExcel("监控可视化");
    }
    /**
     * 导出监控可视化列表
     */
    @RequiresPermissions("system:ipc:export")
    @Log(title = "监控可视化", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AssetIpc assetIpc)
    {
        List<AssetIpc> list = assetIpcService.selectAssetIpcList(assetIpc);
        ExcelUtil<AssetIpc> util = new ExcelUtil<AssetIpc>(AssetIpc.class);
        return util.exportExcel(list, "监控可视化数据");
    }

    /**
     * 新增监控可视化
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存监控可视化
     */
    @RequiresPermissions("system:ipc:add")
    @Log(title = "监控可视化", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AssetIpc assetIpc)
    {
        return toAjax(assetIpcService.insertAssetIpc(assetIpc));
    }

    /**
     * 修改监控可视化
     */
    @RequiresPermissions("system:ipc:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AssetIpc assetIpc = assetIpcService.selectAssetIpcById(id);
        mmap.put("assetIpc", assetIpc);
        return prefix + "/edit";
    }

    /**
     * 修改保存监控可视化
     */
    @RequiresPermissions("system:ipc:edit")
    @Log(title = "监控可视化", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AssetIpc assetIpc)
    {
        return toAjax(assetIpcService.updateAssetIpc(assetIpc));
    }

    /**
     * 删除监控可视化
     */
    @RequiresPermissions("system:ipc:remove")
    @Log(title = "监控可视化", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(assetIpcService.deleteAssetIpcByIds(ids));
    }
}
