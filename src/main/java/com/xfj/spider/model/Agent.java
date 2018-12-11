package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 经纪人表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("agent")
public class Agent extends Model<Agent> {

    private static final long serialVersionUID = 1L;

    /**
     * 经纪人id,自增
     */
    @TableId(value = "at_id", type = IdType.AUTO)
    private Integer atId;
    /**
     * 经纪人id
     */
    @TableField("te_id")
    private Integer teId;
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
    @TableField("at_mian_location")
    private String atMianLocation;
    /**
     * 获取日期
     */
    @TableField("at_create_date")
    private Date atCreateDate;


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

    public String getAtMianLocation() {
        return atMianLocation;
    }

    public void setAtMianLocation(String atMianLocation) {
        this.atMianLocation = atMianLocation;
    }

    public Date getAtCreateDate() {
        return atCreateDate;
    }

    public void setAtCreateDate(Date atCreateDate) {
        this.atCreateDate = atCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.atId;
    }

    @Override
    public String toString() {
        return "Agent{" +
        ", atId=" + atId +
        ", teId=" + teId +
        ", atName=" + atName +
        ", atSex=" + atSex +
        ", atCompany=" + atCompany +
        ", atPhoto=" + atPhoto +
        ", atMainArea=" + atMainArea +
        ", atMianLocation=" + atMianLocation +
        ", atCreateDate=" + atCreateDate +
        "}";
    }
}
