package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 *  modle
 * @author xnc
 * @since 2019-01-14
 */
@TableName("house_question_status")
public class HouseQuestionStatus extends Model<HouseQuestionStatus> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "hs_id", type = IdType.AUTO)
    private Integer hsId;
    /**
     * house_question 问题表id
     */
    @TableField("hq_id")
    private Integer hqId;
    /**
     * reply_coments 回复问题表id
     */
    @TableField("rc_id")
    private Integer rcId;
    /**
     * 问题回复引用情况 0 未看， 1 引用， 2 待用， 3 弃用
     */
    @TableField("hs_status")
    private Integer hsStatus;


    public Integer getHsId() {
        return hsId;
    }

    public void setHsId(Integer hsId) {
        this.hsId = hsId;
    }

    public Integer getHqId() {
        return hqId;
    }

    public void setHqId(Integer hqId) {
        this.hqId = hqId;
    }

    public Integer getRcId() {
        return rcId;
    }

    public void setRcId(Integer rcId) {
        this.rcId = rcId;
    }

    public Integer getHsStatus() {
        return hsStatus;
    }

    public void setHsStatus(Integer hsStatus) {
        this.hsStatus = hsStatus;
    }

    @Override
    protected Serializable pkVal() {
        return this.hsId;
    }

    @Override
    public String toString() {
        return "HouseQuestionStatus{" +
        ", hsId=" + hsId +
        ", hqId=" + hqId +
        ", rcId=" + rcId +
        ", hsStatus=" + hsStatus +
        "}";
    }
}
