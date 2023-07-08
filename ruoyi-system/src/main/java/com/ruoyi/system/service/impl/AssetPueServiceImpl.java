package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetPueMapper;
import com.ruoyi.system.domain.AssetPue;
import com.ruoyi.system.service.IAssetPueService;
import com.ruoyi.common.core.text.Convert;

/**
 * pueService业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
@Service
public class AssetPueServiceImpl implements IAssetPueService 
{
    @Autowired
    private AssetPueMapper assetPueMapper;

    /**
     * 查询pue
     * 
     * @param id pue主键
     * @return pue
     */
    @Override
    public AssetPue selectAssetPueById(Long id)
    {
        return assetPueMapper.selectAssetPueById(id);
    }

    /**
     * 查询pue列表
     * 
     * @param assetPue pue
     * @return pue
     */
    @Override
    public List<AssetPue> selectAssetPueList(AssetPue assetPue)
    {
        return assetPueMapper.selectAssetPueList(assetPue);
    }

    public List<AssetPue> selectAssetPueByTime(String start,String end)
    {
        return assetPueMapper.selectAssetPueByTime(start,end);
    }


    /**
     * 新增pue
     * 
     * @param assetPue pue
     * @return 结果
     */
    @Override
    public int insertAssetPue(AssetPue assetPue)
    {
        return assetPueMapper.insertAssetPue(assetPue);
    }

    /**
     * 修改pue
     * 
     * @param assetPue pue
     * @return 结果
     */
    @Override
    public int updateAssetPue(AssetPue assetPue)
    {
        return assetPueMapper.updateAssetPue(assetPue);
    }

    /**
     * 批量删除pue
     * 
     * @param ids 需要删除的pue主键
     * @return 结果
     */
    @Override
    public int deleteAssetPueByIds(String ids)
    {
        return assetPueMapper.deleteAssetPueByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除pue信息
     * 
     * @param id pue主键
     * @return 结果
     */
    @Override
    public int deleteAssetPueById(Long id)
    {
        return assetPueMapper.deleteAssetPueById(id);
    }
}
