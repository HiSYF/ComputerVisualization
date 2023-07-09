package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 监控可视化对象 asset_ipc
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public class AssetIpc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 摄像头id */
    @Excel(name = "摄像头id")
    private String ipcId;

    /** 摄像头名称 */
    @Excel(name = "摄像头名称")
    private String ipcName;

    /** 视频地址 */
    @Excel(name = "视频url地址")
    private String ipcUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIpcId(String ipcId)
    {
        this.ipcId = ipcId;
    }

    public String getIpcId()
    {
        return ipcId;
    }
    public void setIpcName(String ipcName) 
    {
        this.ipcName = ipcName;
    }

    public String getIpcName() 
    {
        return ipcName;
    }
    public void setIpcUrl(String ipcUrl) 
    {
        this.ipcUrl = ipcUrl;
    }

    public String getIpcUrl() 
    {
        return ipcUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ipcId", getIpcId())
            .append("ipcName", getIpcName())
            .append("ipcUrl", getIpcUrl())
            .toString();
    }
}
