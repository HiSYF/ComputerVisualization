package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AssetServerInfo;

/**
 * 服务器基础信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public interface AssetServerInfoMapper 
{
    /**
     * 查询服务器基础信息
     * 
     * @param id 服务器基础信息主键
     * @return 服务器基础信息
     */
    public AssetServerInfo selectAssetServerInfoById(Long id);

    /**
     * 查询服务器基础信息列表
     * 
     * @param assetServerInfo 服务器基础信息
     * @return 服务器基础信息集合
     */
    public List<AssetServerInfo> selectAssetServerInfoList(AssetServerInfo assetServerInfo);

    /**
     * 新增服务器基础信息
     * 
     * @param assetServerInfo 服务器基础信息
     * @return 结果
     */
    public int insertAssetServerInfo(AssetServerInfo assetServerInfo);

    /**
     * 修改服务器基础信息
     * 
     * @param assetServerInfo 服务器基础信息
     * @return 结果
     */
    public int updateAssetServerInfo(AssetServerInfo assetServerInfo);

    /**
     * 删除服务器基础信息
     * 
     * @param id 服务器基础信息主键
     * @return 结果
     */
    public int deleteAssetServerInfoById(Long id);

    /**
     * 批量删除服务器基础信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetServerInfoByIds(String[] ids);
}
