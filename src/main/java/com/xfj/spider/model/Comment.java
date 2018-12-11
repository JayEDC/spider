package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * 经纪人评论表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id,自增
     */
    @TableId(value = "ct_id", type = IdType.AUTO)
    private Integer ctId;
    /**
     * 经纪人平台ID
     */
    @TableField("am_id")
    private Integer amId;
    /**
     * 评论内容
     */
    @TableField("ct_content")
    private String ctContent;
    /**
     * 评论日期
     */
    @TableField("ct_date")
    private Date ctDate;
    /**
     * 评论分数
     */
    @TableField("ct_score")
    private Integer ctScore;


    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getAmId() {
        return amId;
    }

    public void setAmId(Integer amId) {
        this.amId = amId;
    }

    public String getCtContent() {
        return ctContent;
    }

    public void setCtContent(String ctContent) {
        this.ctContent = ctContent;
    }

    public Date getCtDate() {
        return ctDate;
    }

    public void setCtDate(Date ctDate) {
        this.ctDate = ctDate;
    }

    public Integer getCtScore() {
        return ctScore;
    }

    public void setCtScore(Integer ctScore) {
        this.ctScore = ctScore;
    }

    @Override
    protected Serializable pkVal() {
        return this.ctId;
    }

    @Override
    public String toString() {
        return "Comment{" +
        ", ctId=" + ctId +
        ", amId=" + amId +
        ", ctContent=" + ctContent +
        ", ctDate=" + ctDate +
        ", ctScore=" + ctScore +
        "}";
    }
}
