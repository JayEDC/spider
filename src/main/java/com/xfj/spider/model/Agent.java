package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 经纪人表 model
 * @author xnc
 * @since 2018-12-13
 */
@TableName("agent")
public class Agent extends Model<Agent> {

    private static final long serialVersionUID = 1L;

    /**
     * 经纪人id,自增
     */
    @Id
    @TableId(value = "at_id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer atId;
    /**
     * 经纪人id
     */
    @TableField("te_id")
    private Integer teId;
    /**
     * 采集城市
     */
    @TableField("at_city")
    private String atCity;
    @TableField("at_name")
    private String atName;
    @TableField("at_sex")
    private String atSex;
    /**
     * 公司
     */
    @TableField("at_company")
    private String atCompany;
    /**
     * 经纪人照片
     */
    @TableField("at_photo")
    private String atPhoto;
    /**
     * 主营区域
     */
    @TableField("at_main_area")
    private String atMainArea;
    /**
     * 主营小区
     */
    @TableField("at_main_location")
    private String atMainLocation;
    /**
     * 获取日期
     */
    @TableField("at_create_date")
    private Date atCreateDate;
    /**
     * 获取日期
     */
    @TableField("at_active_date")
    private Date atActiveDate;
    /**
     * 获取日期
     */
    @TableField("at_house_count")
    private int atHouseCount;

    /**
     * 获取日期
     */
    @TableField("at_email")
    private String atEmail;

    public Date getAtActiveDate() {
        return atActiveDate;
    }

    public void setAtActiveDate(Date atActiveDate) {
        this.atActiveDate = atActiveDate;
    }

    public int getAtHouseCount() {
        return atHouseCount;
    }

    public void setAtHouseCount(int atHouseCount) {
        this.atHouseCount = atHouseCount;
    }

    public Integer getAtId() {
        return atId;
    }

    public void setAtId(Integer atId) {
        this.atId = atId;
    }

    public Integer getTeId() {
        return teId;
    }

    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    public String getAtCity() {
        return atCity;
    }

    public void setAtCity(String atCity) {
        this.atCity = atCity;
    }

    public String getAtName() {
        return atName;
    }

    public void setAtName(String atName) {
        this.atName = atName;
    }

    public String getAtSex() {
        return atSex;
    }

    public void setAtSex(String atSex) {
        this.atSex = atSex;
    }

    public String getAtCompany() {
        return atCompany;
    }

    public void setAtCompany(String atCompany) {
        this.atCompany = atCompany;
    }

    public String getAtPhoto() {
        return atPhoto;
    }

    public void setAtPhoto(String atPhoto) {
        this.atPhoto = atPhoto;
    }

    public String getAtMainArea() {
        return atMainArea;
    }

    public void setAtMainArea(String atMainArea) {
        this.atMainArea = atMainArea;
    }

    public String getAtMainLocation() {
        return atMainLocation;
    }

    public void setAtMainLocation(String atMainLocation) {
        this.atMainLocation = atMainLocation;
    }

    public Date getAtCreateDate() {
        return atCreateDate;
    }

    public void setAtCreateDate(Date atCreateDate) {
        this.atCreateDate = atCreateDate;
    }

    public String getAtEmail() {
        return atEmail;
    }

    public void setAtEmail(String atEmail) {
        this.atEmail = atEmail;
    }

    @Override
    protected Serializable pkVal() {
        return this.atId;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "atId=" + atId +
                ", teId=" + teId +
                ", atCity='" + atCity + '\'' +
                ", atName='" + atName + '\'' +
                ", atSex='" + atSex + '\'' +
                ", atCompany='" + atCompany + '\'' +
                ", atPhoto='" + atPhoto + '\'' +
                ", atMainArea='" + atMainArea + '\'' +
                ", atMainLocation='" + atMainLocation + '\'' +
                ", atCreateDate=" + atCreateDate +
                ", atActiveDate=" + atActiveDate +
                ", atHouseCount=" + atHouseCount +
                ", atEmail='" + atEmail + '\'' +
                '}';
    }
}
