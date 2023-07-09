package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 asset_alarm
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
public class AssetAlarm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 告警类型（温湿度、烟感） */
    @Excel(name = "告警类型")
    private String type;

    /** 告警位置 */
    @Excel(name = "告警位置")
    private String position;

    /** 告警等级 */
    @Excel(name = "告警等级")
    private String level;

    /** 告警值 */
    @Excel(name = "告警值")
    private String value;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setValue(String value) 
    {
        this.value = value;
    }

    public String getValue() 
    {
        return value;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("position", getPosition())
            .append("level", getLevel())
            .append("value", getValue())
            .toString();
    }
}
