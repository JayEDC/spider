package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 经纪人租房表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("rent")
public class Rent extends Model<Rent> {

    private static final long serialVersionUID = 1L;

    /**
     * 租房id,自增
     */
    @TableId(value = "rt_id", type = IdType.AUTO)
    private Integer rtId;
    /**
     * 经纪人平台ID
     */
    @TableField("am_id")
    private Integer amId;
    /**
     * 租房名称
     */
    @TableField("rt_name")
    private String rtName;
    /**
     * 出租价格
     */
    @TableField("rt_price")
    private BigDecimal rtPrice;
    /**
     * 是否已租。 在租：已租
     */
    @TableField("rt_status")
    private String rtStatus;
    /**
     * 租房所在区域-小区
     */
    @TableField("rt_location")
    private String rtLocation;
    /**
     * 发布日期
     */
    @TableField("rt_date")
    private Date rtDate;
    /**
     * 房源链接
     */
    @TableField("rt_url")
    private String rtUrl;

    @TableField("rt_create_date")
    private Date rtCreateDate;

    public Date getRtCreateDate() {
        return rtCreateDate;
    }

    public void setRtCreateDate(Date rtCreateDate) {
        this.rtCreateDate = rtCreateDate;
    }

    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public String getRtName() {
        return rtName;
    }

    public void setRtName(String rtName) {
        this.rtName = rtName;
    }

    public BigDecimal getRtPrice() {
        return rtPrice;
    }

    public void setRtPrice(BigDecimal rtPrice) {
        this.rtPrice = rtPrice;
    }

    public String getRtStatus() {
        return rtStatus;
    }

    public void setRtStatus(String rtStatus) {
        this.rtStatus = rtStatus;
    }

    public String getRtLocation() {
        return rtLocation;
    }

    public void setRtLocation(String rtLocation) {
        this.rtLocation = rtLocation;
    }

    public Date getRtDate() {
        return rtDate;
    }

    public void setRtDate(Date rtDate) {
        this.rtDate = rtDate;
    }

    public String getRtUrl() {
        return rtUrl;
    }

    public void setRtUrl(String rtUrl) {
        this.rtUrl = rtUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.rtId;
    }

    @Override
    public String toString() {
        return "Rent{" +
        ", rtId=" + rtId +
        ", amId=" + amId +
        ", rtName=" + rtName +
        ", rtPrice=" + rtPrice +
        ", rtStatus=" + rtStatus +
        ", rtLocation=" + rtLocation +
        ", rtDate=" + rtDate +
        ", rtUrl=" + rtUrl +
        "}";
    }
}
