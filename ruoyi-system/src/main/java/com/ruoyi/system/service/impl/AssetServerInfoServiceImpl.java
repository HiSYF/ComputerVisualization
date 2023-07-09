package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetServerInfoMapper;
import com.ruoyi.system.domain.AssetServerInfo;
import com.ruoyi.system.service.IAssetServerInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 服务器基础信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@Service
public class AssetServerInfoServiceImpl implements IAssetServerInfoService
{
    @Autowired
    private AssetServerInfoMapper assetServerInfoMapper;

    /**
     * 查询服务器基础信息
     * 
     * @param id 服务器基础信息主键
     * @return 服务器基础信息
     */
    @Override
    public AssetServerInfo selectAssetServerInfoById(Long id)
    {
        return assetServerInfoMapper.selectAssetServerInfoById(id);
    }

    /**
     * 查询服务器基础信息列表
     * 
     * @param assetServerInfo 服务器基础信息
     * @return 服务器基础信息
     */
    @Override
    public List<AssetServerInfo> selectAssetServerInfoList(AssetServerInfo assetServerInfo)
    {
        return assetServerInfoMapper.selectAssetServerInfoList(assetServerInfo);
    }

    @Override
    public List<AssetServerInfo> selectAssetServerInfo(String rackId, String serverId) {
        return assetServerInfoMapper.selectAssetServerInfo(rackId,serverId);
    }

    @Override
    public List<AssetServerInfo> selectAssetServerInfoListByRockId(String rackId) {
        return assetServerInfoMapper.selectAssetServerInfoListByRockId(rackId);
    }
    /**
     * 新增服务器基础信息
     * 
     * @param assetServerInfo 服务器基础信息
     * @return 结果
     */
    @Override
    public int insertAssetServerInfo(AssetServerInfo assetServerInfo)
    {
        return assetServerInfoMapper.insertAssetServerInfo(assetServerInfo);
    }

    /**
     * 修改服务器基础信息
     * 
     * @param assetServerInfo 服务器基础信息
     * @return 结果
     */
    @Override
    public int updateAssetServerInfo(AssetServerInfo assetServerInfo)
    {
        return assetServerInfoMapper.updateAssetServerInfo(assetServerInfo);
    }

    /**
     * 批量删除服务器基础信息
     * 
     * @param ids 需要删除的服务器基础信息主键
     * @return 结果
     */
    @Override
    public int deleteAssetServerInfoByIds(String ids)
    {
        return assetServerInfoMapper.deleteAssetServerInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除服务器基础信息信息
     * 
     * @param id 服务器基础信息主键
     * @return 结果
     */
    @Override
    public int deleteAssetServerInfoById(Long id)
    {
        return assetServerInfoMapper.deleteAssetServerInfoById(id);
    }
}
