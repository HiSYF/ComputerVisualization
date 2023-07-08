package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetAlarm;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
public interface IAssetAlarmService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AssetAlarm selectAssetAlarmById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetAlarm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetAlarm> selectAssetAlarmList(AssetAlarm assetAlarm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetAlarm 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetAlarm(AssetAlarm assetAlarm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetAlarm 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetAlarm(AssetAlarm assetAlarm);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAssetAlarmByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAssetAlarmById(Long id);
}
