package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AssetIpcMapper;
import com.ruoyi.system.domain.AssetIpc;
import com.ruoyi.system.service.IAssetIpcService;
import com.ruoyi.common.core.text.Convert;

/**
 * 监控可视化Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
@Service
public class AssetIpcServiceImpl implements IAssetIpcService 
{
    @Autowired
    private AssetIpcMapper assetIpcMapper;

    /**
     * 查询监控可视化
     * 
     * @param id 监控可视化主键
     * @return 监控可视化
     */
    @Override
    public AssetIpc selectAssetIpcById(Long id)
    {
        return assetIpcMapper.selectAssetIpcById(id);
    }
    @Override
    public AssetIpc selectAssetIpcByIpc(String ipc)
    {
        return assetIpcMapper.selectAssetIpcByIpc(ipc);
    }

    /**
     * 查询监控可视化列表
     * 
     * @param assetIpc 监控可视化
     * @return 监控可视化
     */
    @Override
    public List<AssetIpc> selectAssetIpcList(AssetIpc assetIpc)
    {
        return assetIpcMapper.selectAssetIpcList(assetIpc);
    }

    /**
     * 新增监控可视化
     * 
     * @param assetIpc 监控可视化
     * @return 结果
     */
    @Override
    public int insertAssetIpc(AssetIpc assetIpc)
    {
        return assetIpcMapper.insertAssetIpc(assetIpc);
    }

    /**
     * 修改监控可视化
     * 
     * @param assetIpc 监控可视化
     * @return 结果
     */
    @Override
    public int updateAssetIpc(AssetIpc assetIpc)
    {
        return assetIpcMapper.updateAssetIpc(assetIpc);
    }

    /**
     * 批量删除监控可视化
     * 
     * @param ids 需要删除的监控可视化主键
     * @return 结果
     */
    @Override
    public int deleteAssetIpcByIds(String ids)
    {
        return assetIpcMapper.deleteAssetIpcByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除监控可视化信息
     * 
     * @param id 监控可视化主键
     * @return 结果
     */
    @Override
    public int deleteAssetIpcById(Long id)
    {
        return assetIpcMapper.deleteAssetIpcById(id);
    }
}
