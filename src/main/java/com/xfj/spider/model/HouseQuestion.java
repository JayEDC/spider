package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * 房天下问答表 modle
 * @author xnc
 * @since 2019-01-10
 */
@TableName("house_question_comments.html")
public class HouseQuestion extends Model<HouseQuestion> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "hq_id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hqId;
    /**
     * 平台 id（外键）
     */
    @TableField("pm_id")
    private Integer pmId;
    /**
     * 问答类型
     */
    @TableField("hq_type")
    private String hqType;
    /**
     * 问题内容
     */
    @TableField("hq_content")
    private String hqContent;
    /**
     * 问答回答数量
     */
    @TableField("hq_question_count")

    private Integer hqQuestionCount;
    /**
     * 问答发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("hq_publish_time")
    private String hqPublishTime;
    /**
     * 问答采集时间
     */
    @TableField("hq_spider_time")
    private Date hqSpiderTime;
    /**
     * 问答浏览量
     */
    @TableField("hq_page_view")
    private String hqPageView;
    /**
     * 问答发布人
     */
    @TableField("hq_question_user")
    private String hqQuestionUser;
    /**
     * 问答发布人头像
     */
    @TableField("hq_question_user_photo")
    private String hqQuestionUserPhoto;
    @TableField("hq_url")
    private String hqUrl;
    /**
     * 问答标签
     */
    @TableField("hq_tag")
    private String hqTag;


    public Integer getHqId() {
        return hqId;
    }

    public void setHqId(Integer hqId) {
        this.hqId = hqId;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getHqType() {
        return hqType;
    }

    public void setHqType(String hqType) {
        this.hqType = hqType;
    }

    public String getHqContent() {
        return hqContent;
    }

    public void setHqContent(String hqContent) {
        this.hqContent = hqContent;
    }

    public Integer getHqQuestionCount() {
        return hqQuestionCount;
    }

    public void setHqQuestionCount(Integer hqQuestionCount) {
        this.hqQuestionCount = hqQuestionCount;
    }

    public String getHqPublishTime() {
        return hqPublishTime;
    }

    public void setHqPublishTime(String hqPublishTime) {
        this.hqPublishTime = hqPublishTime;
    }

    public Date getHqSpiderTime() {
        return hqSpiderTime;
    }

    public void setHqSpiderTime(Date hqSpiderTime) {
        this.hqSpiderTime = hqSpiderTime;
    }

    public String getHqPageView() {
        return hqPageView;
    }

    public void setHqPageView(String hqPageView) {
        this.hqPageView = hqPageView;
    }

    public String getHqQuestionUser() {
        return hqQuestionUser;
    }

    public void setHqQuestionUser(String hqQuestionUser) {
        this.hqQuestionUser = hqQuestionUser;
    }

    public String getHqQuestionUserPhoto() {
        return hqQuestionUserPhoto;
    }

    public void setHqQuestionUserPhoto(String hqQuestionUserPhoto) {
        this.hqQuestionUserPhoto = hqQuestionUserPhoto;
    }

    public String getHqUrl() {
        return hqUrl;
    }

    public void setHqUrl(String hqUrl) {
        this.hqUrl = hqUrl;
    }

    public String getHqTag() {
        return hqTag;
    }

    public void setHqTag(String hqTag) {
        this.hqTag = hqTag;
    }

    @Override
    protected Serializable pkVal() {
        return this.hqId;
    }

    @Override
    public String toString() {
        return "HouseQuestion{" +
        ", hqId=" + hqId +
        ", pmId=" + pmId +
        ", hqType=" + hqType +
        ", hqContent=" + hqContent +
        ", hqQuestionCount=" + hqQuestionCount +
        ", hqPublishTime=" + hqPublishTime +
        ", hqSpiderTime=" + hqSpiderTime +
        ", hqPageView=" + hqPageView +
        ", hqQuestionUser=" + hqQuestionUser +
        ", hqQuestionUserPhoto=" + hqQuestionUserPhoto +
        ", hqUrl=" + hqUrl +
        ", hqTag=" + hqTag +
        "}";
    }
}
