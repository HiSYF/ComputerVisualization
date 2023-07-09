package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AssetHeatmap;

/**
 * 云图可视化Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface AssetHeatmapMapper 
{
    /**
     * 查询云图可视化
     * 
     * @param id 云图可视化主键
     * @return 云图可视化
     */
    public AssetHeatmap selectAssetHeatmapById(Long id);

    /**
     * 查询云图可视化列表
     * 
     * @param assetHeatmap 云图可视化
     * @return 云图可视化集合
     */
    public List<AssetHeatmap> selectAssetHeatmapList(AssetHeatmap assetHeatmap);
    public List<AssetHeatmap> selectAssetHeatmap(String code);

    /**
     * 新增云图可视化
     * 
     * @param assetHeatmap 云图可视化
     * @return 结果
     */
    public int insertAssetHeatmap(AssetHeatmap assetHeatmap);

    /**
     * 修改云图可视化
     * 
     * @param assetHeatmap 云图可视化
     * @return 结果
     */
    public int updateAssetHeatmap(AssetHeatmap assetHeatmap);

    /**
     * 删除云图可视化
     * 
     * @param id 云图可视化主键
     * @return 结果
     */
    public int deleteAssetHeatmapById(Long id);

    /**
     * 批量删除云图可视化
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetHeatmapByIds(String[] ids);
}
