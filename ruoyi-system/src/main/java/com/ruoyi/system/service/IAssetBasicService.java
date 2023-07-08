package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.AssetBasic;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
public interface IAssetBasicService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AssetBasic selectAssetBasicById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param assetBasic 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AssetBasic> selectAssetBasicList(AssetBasic assetBasic);

    /**
     * 新增【请填写功能名称】
     * 
     * @param assetBasic 【请填写功能名称】
     * @return 结果
     */
    public int insertAssetBasic(AssetBasic assetBasic);

    /**
     * 修改【请填写功能名称】
     * 
     * @param assetBasic 【请填写功能名称】
     * @return 结果
     */
    public int updateAssetBasic(AssetBasic assetBasic);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteAssetBasicByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAssetBasicById(Long id);
}
