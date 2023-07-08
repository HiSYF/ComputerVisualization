package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.AssetPue;

/**
 * pueMapper接口
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
public interface AssetPueMapper 
{
    /**
     * 查询pue
     * 
     * @param id pue主键
     * @return pue
     */
    public AssetPue selectAssetPueById(Long id);

    /**
     * 查询pue列表
     * 
     * @param assetPue pue
     * @return pue集合
     */
    public List<AssetPue> selectAssetPueList(AssetPue assetPue);
    public List<AssetPue> selectAssetPueByTime(String start,String end);

    /**
     * 新增pue
     * 
     * @param assetPue pue
     * @return 结果
     */
    public int insertAssetPue(AssetPue assetPue);

    /**
     * 修改pue
     * 
     * @param assetPue pue
     * @return 结果
     */
    public int updateAssetPue(AssetPue assetPue);

    /**
     * 删除pue
     * 
     * @param id pue主键
     * @return 结果
     */
    public int deleteAssetPueById(Long id);

    /**
     * 批量删除pue
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAssetPueByIds(String[] ids);
}
