package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 asset_device
 * 
 * @author ruoyi
 * @date 2023-07-05
 */
public class AssetDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String type;

    /** 设备区域 */
    @Excel(name = "设备区域")
    private String area;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String state;

    /** 温度 */
    @Excel(name = "温度")
    private Long temperature;

    /** 湿度 */
    @Excel(name = "湿度")
    private Long humidity;

    /** 基础数据 */
    @Excel(name = "基础数据")
    private String basic;

    /** 监测数据 */
    @Excel(name = "监测数据")
    private String monitor;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setTemperature(Long temperature) 
    {
        this.temperature = temperature;
    }

    public Long getTemperature() 
    {
        return temperature;
    }
    public void setHumidity(Long humidity) 
    {
        this.humidity = humidity;
    }

    public Long getHumidity() 
    {
        return humidity;
    }
    public void setBasic(String basic) 
    {
        this.basic = basic;
    }

    public String getBasic() 
    {
        return basic;
    }
    public void setMonitor(String monitor) 
    {
        this.monitor = monitor;
    }

    public String getMonitor() 
    {
        return monitor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("area", getArea())
            .append("state", getState())
            .append("temperature", getTemperature())
            .append("humidity", getHumidity())
            .append("basic", getBasic())
            .append("monitor", getMonitor())
            .toString();
    }
}
