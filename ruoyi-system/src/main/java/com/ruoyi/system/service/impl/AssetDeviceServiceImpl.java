package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetDeviceMapper;
import com.ruoyi.system.domain.AssetDevice;
import com.ruoyi.system.service.IAssetDeviceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
@Service
public class AssetDeviceServiceImpl implements IAssetDeviceService 
{
    @Autowired
    private AssetDeviceMapper assetDeviceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AssetDevice selectAssetDeviceById(Long id)
    {
        return assetDeviceMapper.selectAssetDeviceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetDevice 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetDevice> selectAssetDeviceList(AssetDevice assetDevice)
    {
        return assetDeviceMapper.selectAssetDeviceList(assetDevice);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetDevice 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetDevice(AssetDevice assetDevice)
    {
        return assetDeviceMapper.insertAssetDevice(assetDevice);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetDevice 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetDevice(AssetDevice assetDevice)
    {
        return assetDeviceMapper.updateAssetDevice(assetDevice);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetDeviceByIds(String ids)
    {
        return assetDeviceMapper.deleteAssetDeviceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetDeviceById(Long id)
    {
        return assetDeviceMapper.deleteAssetDeviceById(id);
    }
}
