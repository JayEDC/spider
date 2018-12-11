package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 经纪人服务表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("agent_service")
public class AgentService extends Model<AgentService> {

    private static final long serialVersionUID = 1L;

    /**
     * 服务id,自增
     */
    @TableId(value = "ae_id", type = IdType.AUTO)
    private Integer aeId;
    /**
     * 经纪人平台ID
     */
    @TableField("am_id")
    private Integer amId;
    /**
     * 服务等级 1到5
     */
    @TableField("ae_level")
    private Integer aeLevel;
    /**
     * 服务评分
     */
    @TableField("ae_score")
    private Integer aeScore;
    /**
     * 获取日期
     */
    @TableField("ae_create_date")
    private Date aeCreateDate;


    public Integer getAeId() {
        return aeId;
    }

    public void setAeId(Integer aeId) {
        this.aeId = aeId;
    }

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public Integer getAeLevel() {
        return aeLevel;
    }

    public void setAeLevel(Integer aeLevel) {
        this.aeLevel = aeLevel;
    }

    public Integer getAeScore() {
        return aeScore;
    }

    public void setAeScore(Integer aeScore) {
        this.aeScore = aeScore;
    }

    public Date getAeCreateDate() {
        return aeCreateDate;
    }

    public void setAeCreateDate(Date aeCreateDate) {
        this.aeCreateDate = aeCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.aeId;
    }

    @Override
    public String toString() {
        return "AgentService{" +
        ", aeId=" + aeId +
        ", amId=" + amId +
        ", aeLevel=" + aeLevel +
        ", aeScore=" + aeScore +
        ", aeCreateDate=" + aeCreateDate +
        "}";
    }
}
