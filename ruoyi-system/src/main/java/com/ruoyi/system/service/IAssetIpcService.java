package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetIpc;

/**
 * 监控可视化Service接口
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public interface IAssetIpcService 
{
    /**
     * 查询监控可视化
     * 
     * @param id 监控可视化主键
     * @return 监控可视化
     */
    public AssetIpc selectAssetIpcById(Long id);
    public AssetIpc selectAssetIpcByIpc(String ipc);

    /**
     * 查询监控可视化列表
     * 
     * @param assetIpc 监控可视化
     * @return 监控可视化集合
     */
    public List<AssetIpc> selectAssetIpcList(AssetIpc assetIpc);

    /**
     * 新增监控可视化
     * 
     * @param assetIpc 监控可视化
     * @return 结果
     */
    public int insertAssetIpc(AssetIpc assetIpc);

    /**
     * 修改监控可视化
     * 
     * @param assetIpc 监控可视化
     * @return 结果
     */
    public int updateAssetIpc(AssetIpc assetIpc);

    /**
     * 批量删除监控可视化
     * 
     * @param ids 需要删除的监控可视化主键集合
     * @return 结果
     */
    public int deleteAssetIpcByIds(String ids);

    /**
     * 删除监控可视化信息
     * 
     * @param id 监控可视化主键
     * @return 结果
     */
    public int deleteAssetIpcById(Long id);
}
