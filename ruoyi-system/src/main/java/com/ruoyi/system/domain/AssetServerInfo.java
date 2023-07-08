package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 服务器基础信息对象 asset_server_info
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public class AssetServerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备厂商 */
    @Excel(name = "设备厂商")
    private String factory;

    /** 序列号 */
    @Excel(name = "序列号")
    private String number;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String type;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String state;

    /** 起始U位 */
    @Excel(name = "起始U位")
    private Long start;

    /** 结束U位 */
    @Excel(name = "结束U位")
    private Long end;

    /** RFID */
    @Excel(name = "RFID")
    private String rfid;

    /** 设备高度 */
    @Excel(name = "设备高度")
    private Long height;

    /** BMC IP */
    @Excel(name = "BMC IP")
    private String bmcip;

    /** 业务IP */
    @Excel(name = "业务IP")
    private String ip;

    /** 领用人 */
    @Excel(name = "领用人")
    private String recipient;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

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
    public void setFactory(String factory) 
    {
        this.factory = factory;
    }

    public String getFactory() 
    {
        return factory;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setStart(Long start) 
    {
        this.start = start;
    }

    public Long getStart() 
    {
        return start;
    }
    public void setEnd(Long end) 
    {
        this.end = end;
    }

    public Long getEnd() 
    {
        return end;
    }
    public void setRfid(String rfid) 
    {
        this.rfid = rfid;
    }

    public String getRfid() 
    {
        return rfid;
    }
    public void setHeight(Long height) 
    {
        this.height = height;
    }

    public Long getHeight() 
    {
        return height;
    }
    public void setBmcip(String bmcip) 
    {
        this.bmcip = bmcip;
    }

    public String getBmcip() 
    {
        return bmcip;
    }
    public void setIp(String ip) 
    {
        this.ip = ip;
    }

    public String getIp() 
    {
        return ip;
    }
    public void setRecipient(String recipient) 
    {
        this.recipient = recipient;
    }

    public String getRecipient() 
    {
        return recipient;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("factory", getFactory())
            .append("number", getNumber())
            .append("type", getType())
            .append("state", getState())
            .append("start", getStart())
            .append("end", getEnd())
            .append("rfid", getRfid())
            .append("height", getHeight())
            .append("bmcip", getBmcip())
            .append("ip", getIp())
            .append("recipient", getRecipient())
            .append("phone", getPhone())
            .toString();
    }
}
