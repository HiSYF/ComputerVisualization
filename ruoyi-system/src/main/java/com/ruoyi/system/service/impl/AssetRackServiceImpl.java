package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetRackMapper;
import com.ruoyi.system.domain.AssetRack;
import com.ruoyi.system.service.IAssetRackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@Service
public class AssetRackServiceImpl implements IAssetRackService 
{
    @Autowired
    private AssetRackMapper assetRackMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AssetRack selectAssetRackById(Long id)
    {
        return assetRackMapper.selectAssetRackById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetRack 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetRack> selectAssetRackList(AssetRack assetRack)
    {
        return assetRackMapper.selectAssetRackList(assetRack);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetRack 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetRack(AssetRack assetRack)
    {
        return assetRackMapper.insertAssetRack(assetRack);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetRack 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetRack(AssetRack assetRack)
    {
        return assetRackMapper.updateAssetRack(assetRack);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetRackByIds(String ids)
    {
        return assetRackMapper.deleteAssetRackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetRackById(Long id)
    {
        return assetRackMapper.deleteAssetRackById(id);
    }
}
