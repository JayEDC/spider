package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * 平台表信息表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("agent_platform")
public class AgentPlatform extends Model<AgentPlatform> {

    private static final long serialVersionUID = 1L;

    /**
     * 经纪人id,自增
     */
    @TableId(value = "am_id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer amId;
    /**
     * 经纪人id 
     */
    @TableField("at_id")
    private Integer atId;
    /**
     * platform平台表ID,在那个平台采集
     */
    @TableField("pm_id")
    private Integer pmId;
    /**
     * 工作年限或者注册平台时间
     */
    @TableField("am_work_day")
    private Integer amWorkDay;
    /**
     * 获取日期
     */
    @TableField("am_create_date")
    private Date amCreateDate;

    /**
     * 更新信息日期
     */
    @TableField("am_update_date")
    private Date amUpdateDate;
    /**
     * 经纪人链接
     */
    @TableField("am_url")
    private String amUrl;


    public Date getAmUpdateDate() {
        return amUpdateDate;
    }

    public void setAmUpdateDate(Date amUpdateDate) {
        this.amUpdateDate = amUpdateDate;
    }

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public Integer getAtId() {
        return atId;
    }

    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public Integer getAmWorkDay() {
        return amWorkDay;
    }

    public void setAmWorkDay(Integer amWorkDay) {
        this.amWorkDay = amWorkDay;
    }

    public Date getAmCreateDate() {
        return amCreateDate;
    }

    public void setAmCreateDate(Date amCreateDate) {
        this.amCreateDate = amCreateDate;
    }

    public String getAmUrl() {
        return amUrl;
    }

    public void setAmUrl(String amUrl) {
        this.amUrl = amUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.amId;
    }

    @Override
    public String toString() {
        return "AgentPlatform{" +
        ", amId=" + amId +
        ", atId=" + atId +
        ", pmId=" + pmId +
        ", amWorkDay=" + amWorkDay +
        ", amCreateDate=" + amCreateDate +
        ", amUrl=" + amUrl +
        "}";
    }
}
