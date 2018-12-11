package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 经纪人认证表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("authentication")
public class Authentication extends Model<Authentication> {

    private static final long serialVersionUID = 1L;

    /**
     * 认证id，自增
     */
    @TableId(value = "an_id", type = IdType.AUTO)
    private Integer anId;
    /**
     * 经纪人平台ID
     */
    @TableField("am_id")
    private Integer amId;
    /**
     * 已认证选项：微信，身份证，银行卡，等
     */
    @TableField("an_type")
    private String anType;
    /**
     * 认证日期
     */
    @TableField("an_date")
    private Date anDate;


    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public String getAnType() {
        return anType;
    }

    public void setAnType(String anType) {
        this.anType = anType;
    }

    public Date getAnDate() {
        return anDate;
    }

    public void setAnDate(Date anDate) {
        this.anDate = anDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.anId;
    }

    @Override
    public String toString() {
        return "Authentication{" +
        ", anId=" + anId +
        ", amId=" + amId +
        ", anType=" + anType +
        ", anDate=" + anDate +
        "}";
    }
}
