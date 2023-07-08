package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 asset_basic
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
public class AssetBasic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** IT 设备总数 */
    @Excel(name = "IT 设备总数")
    private Long itDevicesTotal;

    /** 机架总数 */
    @Excel(name = "机架总数")
    private Long racksTotal;

    /** 安全运营天数 */
    @Excel(name = "安全运营天数")
    private Long safeDays;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setItDevicesTotal(Long itDevicesTotal) 
    {
        this.itDevicesTotal = itDevicesTotal;
    }

    public Long getItDevicesTotal() 
    {
        return itDevicesTotal;
    }
    public void setRacksTotal(Long racksTotal) 
    {
        this.racksTotal = racksTotal;
    }

    public Long getRacksTotal() 
    {
        return racksTotal;
    }
    public void setSafeDays(Long safeDays) 
    {
        this.safeDays = safeDays;
    }

    public Long getSafeDays() 
    {
        return safeDays;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("itDevicesTotal", getItDevicesTotal())
            .append("racksTotal", getRacksTotal())
            .append("safeDays", getSafeDays())
            .toString();
    }
}
