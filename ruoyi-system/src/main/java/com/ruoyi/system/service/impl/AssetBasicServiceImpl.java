package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetBasicMapper;
import com.ruoyi.system.domain.AssetBasic;
import com.ruoyi.system.service.IAssetBasicService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
@Service
public class AssetBasicServiceImpl implements IAssetBasicService 
{
    @Autowired
    private AssetBasicMapper assetBasicMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AssetBasic selectAssetBasicById(Long id)
    {
        return assetBasicMapper.selectAssetBasicById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetBasic 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AssetBasic> selectAssetBasicList(AssetBasic assetBasic)
    {
        return assetBasicMapper.selectAssetBasicList(assetBasic);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetBasic 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAssetBasic(AssetBasic assetBasic)
    {
        return assetBasicMapper.insertAssetBasic(assetBasic);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetBasic 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAssetBasic(AssetBasic assetBasic)
    {
        return assetBasicMapper.updateAssetBasic(assetBasic);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetBasicByIds(String ids)
    {
        return assetBasicMapper.deleteAssetBasicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAssetBasicById(Long id)
    {
        return assetBasicMapper.deleteAssetBasicById(id);
    }
}
