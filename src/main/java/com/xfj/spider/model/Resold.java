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
 * 经纪人二手房表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("resold")
public class Resold extends Model<Resold> {

    private static final long serialVersionUID = 1L;

    /**
     * 二手房源id,自增
     */
    @TableId(value = "rd_id", type = IdType.AUTO)
    private Integer rdId;
    /**
     * 经纪人平台ID
     */
    @TableField("am_id")
    private Integer amId;
    /**
     * 房源名称
     */
    @TableField("rd_name")
    private String rdName;
    /**
     * 房源价格
     */
    @TableField("rd_price")
    private BigDecimal rdPrice;
    /**
     * 是否已售。 出售：已售
     */
    @TableField("td_status")
    private String tdStatus;
    /**
     * 房源所在区域-小区
     */
    @TableField("td_location")
    private String tdLocation;
    /**
     * 发布日期
     */
    @TableField("rd_date")
    private Date rdDate;
    /**
     * 房源链接
     */
    @TableField("rd_url")
    private String rdUrl;


    @TableField("rd_create_date")
    private Date rdCreateDate;

    public Date getRdCreateDate() {
        return rdCreateDate;
    }

    public void setRdCreateDate(Date rdCreateDate) {
        this.rdCreateDate = rdCreateDate;
    }

    public Integer getRdId() {
        return rdId;
    }

    public void setRdId(Integer rdId) {
        this.rdId = rdId;
    }

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public String getRdName() {
        return rdName;
    }

    public void setRdName(String rdName) {
        this.rdName = rdName;
    }

    public BigDecimal getRdPrice() {
        return rdPrice;
    }

    public void setRdPrice(BigDecimal rdPrice) {
        this.rdPrice = rdPrice;
    }

    public String getTdStatus() {
        return tdStatus;
    }

    public void setTdStatus(String tdStatus) {
        this.tdStatus = tdStatus;
    }

    public String getTdLocation() {
        return tdLocation;
    }

    public void setTdLocation(String tdLocation) {
        this.tdLocation = tdLocation;
    }

    public Date getRdDate() {
        return rdDate;
    }

    public void setRdDate(Date rdDate) {
        this.rdDate = rdDate;
    }

    public String getRdUrl() {
        return rdUrl;
    }

    public void setRdUrl(String rdUrl) {
        this.rdUrl = rdUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.rdId;
    }

    @Override
    public String toString() {
        return "Resold{" +
        ", rdId=" + rdId +
        ", amId=" + amId +
        ", rdName=" + rdName +
        ", rdPrice=" + rdPrice +
        ", tdStatus=" + tdStatus +
        ", tdLocation=" + tdLocation +
        ", rdDate=" + rdDate +
        ", rdUrl=" + rdUrl +
        "}";
    }
}
