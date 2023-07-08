package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetAlarmMapper;
import com.ruoyi.system.domain.AssetAlarm;
import com.ruoyi.system.service.IAssetAlarmService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
@Service
public class AssetAlarmServiceImpl implements IAssetAlarmService 
{
    @Autowired
    private AssetAlarmMapper assetAlarmMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AssetAlarm selectAssetAlarmById(Long id)
    {
        return assetAlarmMapper.selectAssetAlarmById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetAlarm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetAlarm> selectAssetAlarmList(AssetAlarm assetAlarm)
    {
        return assetAlarmMapper.selectAssetAlarmList(assetAlarm);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetAlarm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetAlarm(AssetAlarm assetAlarm)
    {
        return assetAlarmMapper.insertAssetAlarm(assetAlarm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetAlarm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetAlarm(AssetAlarm assetAlarm)
    {
        return assetAlarmMapper.updateAssetAlarm(assetAlarm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetAlarmByIds(String ids)
    {
        return assetAlarmMapper.deleteAssetAlarmByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetAlarmById(Long id)
    {
        return assetAlarmMapper.deleteAssetAlarmById(id);
    }
}
