package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetRack;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public interface IAssetRackService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AssetRack selectAssetRackById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetRack 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetRack> selectAssetRackList(AssetRack assetRack);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetRack 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetRack(AssetRack assetRack);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetRack 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetRack(AssetRack assetRack);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAssetRackByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAssetRackById(Long id);
}
