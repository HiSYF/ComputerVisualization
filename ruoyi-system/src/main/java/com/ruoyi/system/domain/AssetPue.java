package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * pue对象 asset_pue
 * 
 * @author ruoyi
 * @date 2023-07-07
 */
public class AssetPue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** puekw */
    @Excel(name = "puekw")
    private Long puekw;

    /** 进度占比 */
    @Excel(name = "进度占比")
    private Long percent;

    /** 总负载 */
    @Excel(name = "总负载")
    private Long totalLoad;

    /** IT负载 */
    @Excel(name = "IT负载")
    private Long itLoad;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String startTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPuekw(Long puekw) 
    {
        this.puekw = puekw;
    }

    public Long getPuekw() 
    {
        return puekw;
    }
    public void setPercent(Long percent) 
    {
        this.percent = percent;
    }

    public Long getPercent() 
    {
        return percent;
    }
    public void setTotalLoad(Long totalLoad) 
    {
        this.totalLoad = totalLoad;
    }

    public Long getTotalLoad() 
    {
        return totalLoad;
    }
    public void setItLoad(Long itLoad) 
    {
        this.itLoad = itLoad;
    }

    public Long getItLoad() 
    {
        return itLoad;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("puekw", getPuekw())
            .append("percent", getPercent())
            .append("totalLoad", getTotalLoad())
            .append("itLoad", getItLoad())
            .append("startTime", getStartTime())
            .toString();
    }
}
