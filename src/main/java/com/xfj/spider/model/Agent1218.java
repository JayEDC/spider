package com.xfj.spider.model;

import java.util.Date;
import javax.persistence.*;

public class Agent1218 {
    /**
     * 经纪人id,自增
     */
    @Column(name = "at_id")
    private Integer atId;

    /**
     * 经纪人id
     */
    @Column(name = "te_id")
    private Integer teId;

    /**
     * 采集城市
     */
    @Column(name = "at_city")
    private String atCity;

    @Column(name = "at_name")
    private String atName;

    @Column(name = "at_sex")
    private String atSex;

    /**
     * 公司
     */
    @Column(name = "at_company")
    private String atCompany;

    /**
     * 经纪人照片
     */
    @Column(name = "at_photo")
    private String atPhoto;

    /**
     * 主营区域
     */
    @Column(name = "at_main_area")
    private String atMainArea;

    /**
     * 主营小区
     */
    @Column(name = "at_main_location")
    private String atMainLocation;

    /**
     * 获取日期
     */
    @Column(name = "at_create_date")
    private Date atCreateDate;

    @Column(name = "at_active_date")
    private Date atActiveDate;

    @Column(name = "at_house_count")
    private Integer atHouseCount;

    /**
     * 获取经纪人id,自增
     *
     * @return at_id - 经纪人id,自增
     */
    public Integer getAtId() {
        return atId;
    }

    /**
     * 设置经纪人id,自增
     *
     * @param atId 经纪人id,自增
     */
    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    /**
     * 获取经纪人id
     *
     * @return te_id - 经纪人id
     */
    public Integer getTeId() {
        return teId;
    }

    /**
     * 设置经纪人id
     *
     * @param teId 经纪人id
     */
    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    /**
     * 获取采集城市
     *
     * @return at_city - 采集城市
     */
    public String getAtCity() {
        return atCity;
    }

    /**
     * 设置采集城市
     *
     * @param atCity 采集城市
     */
    public void setAtCity(String atCity) {
        this.atCity = atCity;
    }

    /**
     * @return at_name
     */
    public String getAtName() {
        return atName;
    }

    /**
     * @param atName
     */
    public void setAtName(String atName) {
        this.atName = atName;
    }

    /**
     * @return at_sex
     */
    public String getAtSex() {
        return atSex;
    }

    /**
     * @param atSex
     */
    public void setAtSex(String atSex) {
        this.atSex = atSex;
    }

    /**
     * 获取公司
     *
     * @return at_company - 公司
     */
    public String getAtCompany() {
        return atCompany;
    }

    /**
     * 设置公司
     *
     * @param atCompany 公司
     */
    public void setAtCompany(String atCompany) {
        this.atCompany = atCompany;
    }

    /**
     * 获取经纪人照片
     *
     * @return at_photo - 经纪人照片
     */
    public String getAtPhoto() {
        return atPhoto;
    }

    /**
     * 设置经纪人照片
     *
     * @param atPhoto 经纪人照片
     */
    public void setAtPhoto(String atPhoto) {
        this.atPhoto = atPhoto;
    }

    /**
     * 获取主营区域
     *
     * @return at_main_area - 主营区域
     */
    public String getAtMainArea() {
        return atMainArea;
    }

    /**
     * 设置主营区域
     *
     * @param atMainArea 主营区域
     */
    public void setAtMainArea(String atMainArea) {
        this.atMainArea = atMainArea;
    }

    /**
     * 获取主营小区
     *
     * @return at_main_location - 主营小区
     */
    public String getAtMainLocation() {
        return atMainLocation;
    }

    /**
     * 设置主营小区
     *
     * @param atMainLocation 主营小区
     */
    public void setAtMainLocation(String atMainLocation) {
        this.atMainLocation = atMainLocation;
    }

    /**
     * 获取获取日期
     *
     * @return at_create_date - 获取日期
     */
    public Date getAtCreateDate() {
        return atCreateDate;
    }

    /**
     * 设置获取日期
     *
     * @param atCreateDate 获取日期
     */
    public void setAtCreateDate(Date atCreateDate) {
        this.atCreateDate = atCreateDate;
    }

    /**
     * @return at_active_date
     */
    public Date getAtActiveDate() {
        return atActiveDate;
    }

    /**
     * @param atActiveDate
     */
    public void setAtActiveDate(Date atActiveDate) {
        this.atActiveDate = atActiveDate;
    }

    /**
     * @return at_house_count
     */
    public Integer getAtHouseCount() {
        return atHouseCount;
    }

    /**
     * @param atHouseCount
     */
    public void setAtHouseCount(Integer atHouseCount) {
        this.atHouseCount = atHouseCount;
    }
}