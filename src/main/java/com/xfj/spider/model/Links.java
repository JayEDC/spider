package com.xfj.spider.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * Http连接表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("links")
public class Links extends Model<Links> {

    private static final long serialVersionUID = 1L;

    /**
     * 链接id,自增
     */
    @TableId("ls_id")
    private Integer lsId;
    /**
     * 链接
     */
    @TableField("ls_url")
    private String lsUrl;
    /**
     * 是抓取过的链接 0否，1是
     */
    @TableField("ls_crawl_status")
    private Integer lsCrawlStatus;
    /**
     * 平台id
     */
    @TableField("pm_id")
    private Integer pmId;
    /**
     * 链接类型
     */
    @TableField("ls_type")
    private String lsType;
    /**
     * 获取链接时间
     */
    @TableField("ls_create_date")
    private Date lsCreateDate;


    public Integer getLsId() {
        return lsId;
    }

    public void setLsId(Integer lsId) {
        this.lsId = lsId;
    }

    public String getLsUrl() {
        return lsUrl;
    }

    public void setLsUrl(String lsUrl) {
        this.lsUrl = lsUrl;
    }

    public Integer getLsCrawlStatus() {
        return lsCrawlStatus;
    }

    public void setLsCrawlStatus(Integer lsCrawlStatus) {
        this.lsCrawlStatus = lsCrawlStatus;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getLsType() {
        return lsType;
    }

    public void setLsType(String lsType) {
        this.lsType = lsType;
    }

    public Date getLsCreateDate() {
        return lsCreateDate;
    }

    public void setLsCreateDate(Date lsCreateDate) {
        this.lsCreateDate = lsCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.lsId;
    }

    @Override
    public String toString() {
        return "Links{" +
        ", lsId=" + lsId +
        ", lsUrl=" + lsUrl +
        ", lsCrawlStatus=" + lsCrawlStatus +
        ", pmId=" + pmId +
        ", lsType=" + lsType +
        ", lsCreateDate=" + lsCreateDate +
        "}";
    }
}
