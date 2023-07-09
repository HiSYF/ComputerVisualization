package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 云图可视化对象 asset_heatmap
 * 
 * @author ruoyi
 * @date 2023-07-09
 */
public class AssetHeatmap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String code;

    /** x坐标 */
    @Excel(name = "x坐标")
    private String x;

    /** y坐标 */
    @Excel(name = "y坐标")
    private String y;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setX(String x) 
    {
        this.x = x;
    }

    public String getX() 
    {
        return x;
    }
    public void setY(String y) 
    {
        this.y = y;
    }

    public String getY() 
    {
        return y;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("x", getX())
            .append("y", getY())
            .toString();
    }
}
