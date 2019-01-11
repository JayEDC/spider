package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * 房天下问答评论回复表 modle
 * @author xnc
 * @since 2019-01-11
 */
@TableName("reply_comments")
public class ReplyComments extends Model<ReplyComments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comments_id", type = IdType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentsId;
    /**
     * 评论用户头像
     */
    @TableField("comments_user_photo")
    private String commentsUserPhoto;
    /**
     * 评论用户名
     */
    @TableField("comments_user_name")
    private String commentsUserName;
    /**
     * 评论时间
     */
    @TableField("comments_time")
    private String commentsTime;
    /**
     * 评论内容
     */
    @TableField("comments_content")
    private String commentsContent;
    private Integer parent;
    @TableField("hq_id")
    private Integer hqId;


    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public String getCommentsUserPhoto() {
        return commentsUserPhoto;
    }

    public void setCommentsUserPhoto(String commentsUserPhoto) {
        this.commentsUserPhoto = commentsUserPhoto;
    }

    public String getCommentsUserName() {
        return commentsUserName;
    }

    public void setCommentsUserName(String commentsUserName) {
        this.commentsUserName = commentsUserName;
    }

    public String getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(String commentsTime) {
        this.commentsTime = commentsTime;
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public Integer getHqId() {
        return hqId;
    }

    public void setHqId(Integer hqId) {
        this.hqId = hqId;
    }

    @Override
    protected Serializable pkVal() {
        return this.commentsId;
    }

    @Override
    public String toString() {
        return "ReplyComments{" +
        ", commentsId=" + commentsId +
        ", commentsUserPhoto=" + commentsUserPhoto +
        ", commentsUserName=" + commentsUserName +
        ", commentsTime=" + commentsTime +
        ", commentsContent=" + commentsContent +
        ", parent=" + parent +
        ", hqId=" + hqId +
        "}";
    }
}
