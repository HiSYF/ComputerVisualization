package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetHeatmapMapper;
import com.ruoyi.system.domain.AssetHeatmap;
import com.ruoyi.system.service.IAssetHeatmapService;
import com.ruoyi.common.core.text.Convert;

/**
 * 云图可视化Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Service
public class AssetHeatmapServiceImpl implements IAssetHeatmapService 
{
    @Autowired
    private AssetHeatmapMapper assetHeatmapMapper;

    /**
     * 查询云图可视化
     * 
     * @param id 云图可视化主键
     * @return 云图可视化
     */
    @Override
    public AssetHeatmap selectAssetHeatmapById(Long id)
    {
        return assetHeatmapMapper.selectAssetHeatmapById(id);
    }

    /**
     * 查询云图可视化列表
     * 
     * @param assetHeatmap 云图可视化
     * @return 云图可视化
     */
    @Override
    public List<AssetHeatmap> selectAssetHeatmapList(AssetHeatmap assetHeatmap)
    {
        return assetHeatmapMapper.selectAssetHeatmapList(assetHeatmap);
    }

    @Override
    public List<AssetHeatmap> selectAssetHeatmap(String code) {
        return assetHeatmapMapper.selectAssetHeatmap(code);
    }

    /**
     * 新增云图可视化
     * 
     * @param assetHeatmap 云图可视化
     * @return 结果
     */
    @Override
    public int insertAssetHeatmap(AssetHeatmap assetHeatmap)
    {
        return assetHeatmapMapper.insertAssetHeatmap(assetHeatmap);
    }

    /**
     * 修改云图可视化
     * 
     * @param assetHeatmap 云图可视化
     * @return 结果
     */
    @Override
    public int updateAssetHeatmap(AssetHeatmap assetHeatmap)
    {
        return assetHeatmapMapper.updateAssetHeatmap(assetHeatmap);
    }

    /**
     * 批量删除云图可视化
     * 
     * @param ids 需要删除的云图可视化主键
     * @return 结果
     */
    @Override
    public int deleteAssetHeatmapByIds(String ids)
    {
        return assetHeatmapMapper.deleteAssetHeatmapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除云图可视化信息
     * 
     * @param id 云图可视化主键
     * @return 结果
     */
    @Override
    public int deleteAssetHeatmapById(Long id)
    {
        return assetHeatmapMapper.deleteAssetHeatmapById(id);
    }
}
