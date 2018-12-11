package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 经纪人电话信息表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("tephone")
public class Tephone extends Model<Tephone> {

    private static final long serialVersionUID = 1L;

    /**
     * 电话主键，自增
     */
    @TableId(value = "te_id", type = IdType.AUTO)
    private Integer teId;
    /**
     * 电话号码，长度11
     */
    @TableField("te_telephone")
    private String teTelephone;
    /**
     * 电话归属地
     */
    @TableField("te_location")
    private String teLocation;
    /**
     * 获取日期
     */
    @TableField("te_create_date")
    private Date teCreateDate;


    public Integer getTeId() {
        return teId;
    }

    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    public String getTeTelephone() {
        return teTelephone;
    }

    public void setTeTelephone(String teTelephone) {
        this.teTelephone = teTelephone;
    }

    public String getTeLocation() {
        return teLocation;
    }

    public void setTeLocation(String teLocation) {
        this.teLocation = teLocation;
    }

    public Date getTeCreateDate() {
        return teCreateDate;
    }

    public void setTeCreateDate(Date teCreateDate) {
        this.teCreateDate = teCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.teId;
    }

    @Override
    public String toString() {
        return "Tephone{" +
        ", teId=" + teId +
        ", teTelephone=" + teTelephone +
        ", teLocation=" + teLocation +
        ", teCreateDate=" + teCreateDate +
        "}";
    }
}
