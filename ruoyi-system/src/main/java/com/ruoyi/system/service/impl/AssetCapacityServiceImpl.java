package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetCapacityMapper;
import com.ruoyi.system.domain.AssetCapacity;
import com.ruoyi.system.service.IAssetCapacityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 容量可视化Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Service
public class AssetCapacityServiceImpl implements IAssetCapacityService 
{
    @Autowired
    private AssetCapacityMapper assetCapacityMapper;

    /**
     * 查询容量可视化
     * 
     * @param id 容量可视化主键
     * @return 容量可视化
     */
    @Override
    public AssetCapacity selectAssetCapacityById(Long id)
    {
        return assetCapacityMapper.selectAssetCapacityById(id);
    }

    /**
     * 查询容量可视化列表
     * 
     * @param assetCapacity 容量可视化
     * @return 容量可视化
     */
    @Override
    public List<AssetCapacity> selectAssetCapacityList(AssetCapacity assetCapacity)
    {
        return assetCapacityMapper.selectAssetCapacityList(assetCapacity);
    }

    /**
     * 新增容量可视化
     * 
     * @param assetCapacity 容量可视化
     * @return 结果
     */
    @Override
    public int insertAssetCapacity(AssetCapacity assetCapacity)
    {
        return assetCapacityMapper.insertAssetCapacity(assetCapacity);
    }

    /**
     * 修改容量可视化
     * 
     * @param assetCapacity 容量可视化
     * @return 结果
     */
    @Override
    public int updateAssetCapacity(AssetCapacity assetCapacity)
    {
        return assetCapacityMapper.updateAssetCapacity(assetCapacity);
    }

    /**
     * 批量删除容量可视化
     * 
     * @param ids 需要删除的容量可视化主键
     * @return 结果
     */
    @Override
    public int deleteAssetCapacityByIds(String ids)
    {
        return assetCapacityMapper.deleteAssetCapacityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除容量可视化信息
     * 
     * @param id 容量可视化主键
     * @return 结果
     */
    @Override
    public int deleteAssetCapacityById(Long id)
    {
        return assetCapacityMapper.deleteAssetCapacityById(id);
    }
}
