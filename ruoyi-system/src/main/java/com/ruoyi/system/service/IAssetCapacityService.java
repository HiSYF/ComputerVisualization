package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetCapacity;

/**
 * 容量可视化Service接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface IAssetCapacityService 
{
    /**
     * 查询容量可视化
     * 
     * @param id 容量可视化主键
     * @return 容量可视化
     */
    public AssetCapacity selectAssetCapacityById(Long id);

    /**
     * 查询容量可视化列表
     * 
     * @param assetCapacity 容量可视化
     * @return 容量可视化集合
     */
    public List<AssetCapacity> selectAssetCapacityList(AssetCapacity assetCapacity);

    /**
     * 新增容量可视化
     * 
     * @param assetCapacity 容量可视化
     * @return 结果
     */
    public int insertAssetCapacity(AssetCapacity assetCapacity);

    /**
     * 修改容量可视化
     * 
     * @param assetCapacity 容量可视化
     * @return 结果
     */
    public int updateAssetCapacity(AssetCapacity assetCapacity);

    /**
     * 批量删除容量可视化
     * 
     * @param ids 需要删除的容量可视化主键集合
     * @return 结果
     */
    public int deleteAssetCapacityByIds(String ids);

    /**
     * 删除容量可视化信息
     * 
     * @param id 容量可视化主键
     * @return 结果
     */
    public int deleteAssetCapacityById(Long id);
}
