package com.xfj.spider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "agent_platform1218")
public class AgentPlatform1218 {
    /**
     * 经纪人id,自增
     */
    @Column(name = "am_id")
    private Integer amId;

    /**
     * 经纪人id 
     */
    @Column(name = "at_id")
    private Integer atId;

    /**
     * platform平台表ID,在那个平台采集
     */
    @Column(name = "pm_id")
    private Integer pmId;

    /**
     * 工作年限或者注册平台时间
     */
    @Column(name = "am_work_day")
    private String amWorkDay;

    /**
     * 获取日期
     */
    @Column(name = "am_create_date")
    private Date amCreateDate;

    /**
     * 更新信息日期
     */
    @Column(name = "am_update_date")
    private Date amUpdateDate;

    /**
     * 经纪人链接
     */
    @Column(name = "am_url")
    private String amUrl;

    /**
     * 获取经纪人id,自增
     *
     * @return am_id - 经纪人id,自增
     */
    public Integer getAmId() {
        return amId;
    }

    /**
     * 设置经纪人id,自增
     *
     * @param amId 经纪人id,自增
     */
    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    /**
     * 获取经纪人id 
     *
     * @return at_id - 经纪人id 
     */
    public Integer getAtId() {
        return atId;
    }

    /**
     * 设置经纪人id 
     *
     * @param atId 经纪人id 
     */
    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    /**
     * 获取platform平台表ID,在那个平台采集
     *
     * @return pm_id - platform平台表ID,在那个平台采集
     */
    public Integer getPmId() {
        return pmId;
    }

    /**
     * 设置platform平台表ID,在那个平台采集
     *
     * @param pmId platform平台表ID,在那个平台采集
     */
    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    /**
     * 获取工作年限或者注册平台时间
     *
     * @return am_work_day - 工作年限或者注册平台时间
     */
    public String getAmWorkDay() {
        return amWorkDay;
    }

    /**
     * 设置工作年限或者注册平台时间
     *
     * @param amWorkDay 工作年限或者注册平台时间
     */
    public void setAmWorkDay(String amWorkDay) {
        this.amWorkDay = amWorkDay;
    }

    /**
     * 获取获取日期
     *
     * @return am_create_date - 获取日期
     */
    public Date getAmCreateDate() {
        return amCreateDate;
    }

    /**
     * 设置获取日期
     *
     * @param amCreateDate 获取日期
     */
    public void setAmCreateDate(Date amCreateDate) {
        this.amCreateDate = amCreateDate;
    }

    /**
     * 获取更新信息日期
     *
     * @return am_update_date - 更新信息日期
     */
    public Date getAmUpdateDate() {
        return amUpdateDate;
    }

    /**
     * 设置更新信息日期
     *
     * @param amUpdateDate 更新信息日期
     */
    public void setAmUpdateDate(Date amUpdateDate) {
        this.amUpdateDate = amUpdateDate;
    }

    /**
     * 获取经纪人链接
     *
     * @return am_url - 经纪人链接
     */
    public String getAmUrl() {
        return amUrl;
    }

    /**
     * 设置经纪人链接
     *
     * @param amUrl 经纪人链接
     */
    public void setAmUrl(String amUrl) {
        this.amUrl = amUrl;
    }
}