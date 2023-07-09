package com.ruoyi.system.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.RetInfo;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.AssetServerInfoMapper;
import com.ruoyi.system.service.*;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/asset/")
public class AssetController extends BaseController {

    @Autowired
    private IAssetBasicService assetBasicService;
    @Autowired
    private IAssetAlarmService assetAlarmService;
    @Autowired
    private IAssetDeviceService assetDeviceService;
    @Autowired
    private IAssetPueService assetPueService;
    @Autowired
    private IAssetRackService assetRackService;
    @Autowired
    private IAssetServerInfoService assetServerInfoService;
    @Autowired
    private IAssetCapacityService assetCapacityService;
    @Autowired
    private IAssetHeatmapService assetHeatmapService;
    @Autowired
    private IAssetIpcService assetIpcService;

    //  接口说明：返回机房基础数据情况
    @GetMapping("basic/data")
    @ResponseBody
    private RetInfo basic(AssetBasic assetBasic){


        List<AssetBasic> list = assetBasicService.selectAssetBasicList(assetBasic);
        System.out.println(list);
        return RetInfo.success(list);
    }

    //  接口说明：返回告警统计
    @GetMapping("alarm/statistics")
    @ResponseBody
    private RetInfo alarmStatistics(AssetAlarm assetAlarm){

        Integer serious = 0;
        Integer important = 0;
        Integer secondary = 0;
        Integer alarm = 0;

        List<AssetAlarm> list = assetAlarmService.selectAssetAlarmList(assetAlarm);

        for (int i=0;i<list.size();i++){
            switch (list.get(i).getLevel()) {
                case "严重": {
                    serious += 1;
                    break;
                }
                case "重要": {
                    important += 1;
                    break;
                }
                case "次要": {
                    secondary += 1;
                    break;
                }
                case "告警": {
                    alarm += 1;
                    break;
                }
            }

        }

        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("serious", serious);
        hashMap.put("important", important);
        hashMap.put("secondary", secondary);
        hashMap.put("alarm", alarm);
        System.out.println(list);
        return RetInfo.success(hashMap);
    }

    //  接口说明：返回告警信息
    @GetMapping("alarm/info")
    @ResponseBody
    private RetInfo alarmInfo(AssetAlarm assetAlarm){

        List<AssetAlarm> list = assetAlarmService.selectAssetAlarmList(assetAlarm);
        return RetInfo.success(list);
    }

    //  接口说明：返回PUE详情
    @GetMapping("search/pue")
    @ResponseBody
    private RetInfo pue(@Param("start") String start, @Param("end") String end){
        List<AssetPue> list = assetPueService.selectAssetPueByTime(start,end);
        return RetInfo.success(list);
    }

    //  接口说明：返回设备性能报表信息
    @GetMapping("device/report")
    @ResponseBody
    private RetInfo deviceReport(AssetDevice assetDevice){

        List<AssetDevice> list = assetDeviceService.selectAssetDeviceList(assetDevice);
        return RetInfo.success(list);
    }

    //  接口说明：返回设备报警信息
    @GetMapping("device/alarm")
    @ResponseBody
    private RetInfo deviceAlarm(AssetDevice assetDevice){
        assetDevice.setState("离线");

        List<AssetDevice> list = assetDeviceService.selectAssetDeviceList(assetDevice);
        return RetInfo.success(list);
    }

    //  接口说明：返回设备信息
    @GetMapping("device/info")
    @ResponseBody
    private RetInfo deviceInfo(@RequestParam(name = "id") Long id){

        AssetDevice device = assetDeviceService.selectAssetDeviceById(id);
        return RetInfo.success(device);
    }
    //  接口说明：返回机柜内的设备及其布局信息
    @GetMapping("device/getRackDeviceById")
    @ResponseBody
    private RetInfo getRackDeviceById(@RequestParam(name = "id") String id){
        List<AssetServerInfo> rack = assetServerInfoService.selectAssetServerInfoListByRockId(id);
        return RetInfo.success(rack);
    }

    //  接口说明：返回监控可视化信息
    //  接口说明：监控可视化
    @GetMapping("monitoring/url")
    @ResponseBody
    private RetInfo monitoring(@RequestParam(name = "id") String ipc){

        AssetIpc assetIpc= assetIpcService.selectAssetIpcByIpc(ipc);
        return RetInfo.success(assetIpc);
    }

    //  接口说明：返回机柜信息
    @GetMapping("device/cabinet")
    @ResponseBody
    private RetInfo deviceCabinet(@RequestParam(name = "id") String id){

        AssetRack assetRack = assetRackService.selectAssetRackByRackNo(id);
        return RetInfo.success(assetRack);
    }

    //  接口说明：配电统计数据
    @GetMapping("device/statistics")
    @ResponseBody
    private RetInfo deviceStatistics(@RequestParam(name = "id") String id){

        AssetRack assetRack = assetRackService.selectAssetRackByRackNo(id);
        return RetInfo.success(assetRack);
    }

    //  接口说明：服务器基础信息
    @GetMapping("device/serverBasic")
    @ResponseBody
    private RetInfo deviceServerBasic(@RequestParam("id") String rackId, @RequestParam("server_id") String serverId){
        List<AssetServerInfo> list = assetServerInfoService.selectAssetServerInfo(rackId,serverId);
        return RetInfo.success(list);
    }
    //  接口说明：云图可视化
    @GetMapping("cloud/heatmap")
    @ResponseBody
    private RetInfo heatmap(@RequestParam(name = "code") String code){

        List<AssetHeatmap> assetHeatmaps = assetHeatmapService.selectAssetHeatmap(code);
        return RetInfo.success(assetHeatmaps);
    }
    //  接口说明：容量可视化
    @GetMapping("capacity")
    @ResponseBody
    private RetInfo capacity(AssetCapacity assetCapacity){

        List<AssetCapacity> assetCapacities = assetCapacityService.selectAssetCapacityList(assetCapacity);
        return RetInfo.success(assetCapacities);
    }

}
