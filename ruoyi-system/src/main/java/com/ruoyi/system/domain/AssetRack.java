package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 机柜信息对象 asset_rack
 *
 * @author ruoyi
 * @date 2023-07-10
 */
public class AssetRack extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机柜唯一编号 */
    private String id;

    /** 机柜名称 */
    @Excel(name = "机柜名称")
    private String rackName;

    /** 设备数量 */
    @Excel(name = "设备数量")
    private String devices;

    /** 占用空间 */
    @Excel(name = "占用空间")
    private String rackSpace;

    /** 机柜功耗 */
    @Excel(name = "机柜功耗")
    private String consumption;

    /** 主机SSID */
    @Excel(name = "主机SSID")
    private String sn;

    /** 机柜编号 */
    @Excel(name = "机柜编号")
    private String rackNo;

    /** 机柜总空间 */
    @Excel(name = "机柜总空间")
    private String totalSpace;

    /** 主机型号 */
    @Excel(name = "主机型号")
    private String hostType;

    /** 信号强度 */
    @Excel(name = "信号强度")
    private String rackSignal;

    /** 总输入相电压 */
    @Excel(name = "总输入相电压")
    private String voltage;

    /** 电流 */
    @Excel(name = "电流")
    private String rackCurrent;

    /** 功率因数 */
    @Excel(name = "功率因数")
    private String powerFactor;

    /** 频率 */
    @Excel(name = "频率")
    private String frequency;

    /** 电能 */
    @Excel(name = "电能")
    private String electric;

    /** 有功功率 */
    @Excel(name = "有功功率")
    private String powerActive;

    /** 视在功率 */
    @Excel(name = "视在功率")
    private String powerApparent;

    /** 负载率 */
    @Excel(name = "负载率")
    private String loadRate;

    /** 电压电流谐波率 */
    @Excel(name = "电压电流谐波率")
    private String harmonicRate;

    /** 柜内母排温度 */
    @Excel(name = "柜内母排温度")
    private String temperature;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setRackName(String rackName)
    {
        this.rackName = rackName;
    }

    public String getRackName()
    {
        return rackName;
    }
    public void setDevices(String devices)
    {
        this.devices = devices;
    }

    public String getDevices()
    {
        return devices;
    }
    public void setRackSpace(String rackSpace)
    {
        this.rackSpace = rackSpace;
    }

    public String getRackSpace()
    {
        return rackSpace;
    }
    public void setConsumption(String consumption)
    {
        this.consumption = consumption;
    }

    public String getConsumption()
    {
        return consumption;
    }
    public void setSn(String sn)
    {
        this.sn = sn;
    }

    public String getSn()
    {
        return sn;
    }
    public void setRackNo(String rackNo)
    {
        this.rackNo = rackNo;
    }

    public String getRackNo()
    {
        return rackNo;
    }
    public void setTotalSpace(String totalSpace)
    {
        this.totalSpace = totalSpace;
    }

    public String getTotalSpace()
    {
        return totalSpace;
    }
    public void setHostType(String hostType)
    {
        this.hostType = hostType;
    }

    public String getHostType()
    {
        return hostType;
    }
    public void setRackSignal(String rackSignal)
    {
        this.rackSignal = rackSignal;
    }

    public String getRackSignal()
    {
        return rackSignal;
    }
    public void setVoltage(String voltage)
    {
        this.voltage = voltage;
    }

    public String getVoltage()
    {
        return voltage;
    }
    public void setRackCurrent(String rackCurrent)
    {
        this.rackCurrent = rackCurrent;
    }

    public String getRackCurrent()
    {
        return rackCurrent;
    }
    public void setPowerFactor(String powerFactor)
    {
        this.powerFactor = powerFactor;
    }

    public String getPowerFactor()
    {
        return powerFactor;
    }
    public void setFrequency(String frequency)
    {
        this.frequency = frequency;
    }

    public String getFrequency()
    {
        return frequency;
    }
    public void setElectric(String electric)
    {
        this.electric = electric;
    }

    public String getElectric()
    {
        return electric;
    }
    public void setPowerActive(String powerActive)
    {
        this.powerActive = powerActive;
    }

    public String getPowerActive()
    {
        return powerActive;
    }
    public void setPowerApparent(String powerApparent)
    {
        this.powerApparent = powerApparent;
    }

    public String getPowerApparent()
    {
        return powerApparent;
    }
    public void setLoadRate(String loadRate)
    {
        this.loadRate = loadRate;
    }

    public String getLoadRate()
    {
        return loadRate;
    }
    public void setHarmonicRate(String harmonicRate)
    {
        this.harmonicRate = harmonicRate;
    }

    public String getHarmonicRate()
    {
        return harmonicRate;
    }
    public void setTemperature(String temperature)
    {
        this.temperature = temperature;
    }

    public String getTemperature()
    {
        return temperature;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("rackName", getRackName())
                .append("devices", getDevices())
                .append("rackSpace", getRackSpace())
                .append("consumption", getConsumption())
                .append("sn", getSn())
                .append("rackNo", getRackNo())
                .append("totalSpace", getTotalSpace())
                .append("hostType", getHostType())
                .append("rackSignal", getRackSignal())
                .append("voltage", getVoltage())
                .append("rackCurrent", getRackCurrent())
                .append("powerFactor", getPowerFactor())
                .append("frequency", getFrequency())
                .append("electric", getElectric())
                .append("powerActive", getPowerActive())
                .append("powerApparent", getPowerApparent())
                .append("loadRate", getLoadRate())
                .append("harmonicRate", getHarmonicRate())
                .append("temperature", getTemperature())
                .toString();
    }
}
