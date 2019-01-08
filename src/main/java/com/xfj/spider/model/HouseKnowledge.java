package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 *  modle
 * @author xnc
 * @since 2019-01-08
 */
@TableName("house_knowledge")
public class HouseKnowledge extends Model<HouseKnowledge> {

    private static final long serialVersionUID = 1L;

    /**
     * 房产知识id，自增
     */
    @TableId(value = "hs_id", type = IdType.AUTO)
    private Integer hsId;
    /**
     * 平台 id，外键
     */
    @TableField("pm_id")
    private Integer pmId;
    /**
     * 房产知识类型
     */
    @TableField("hs_type")
    private String hsType;
    /**
     * 房产知识标题
     */
    @TableField("hs_title")
    private String hsTitle;
    /**
     * 房产知识二级标题
     */
    @TableField("hs_sub_title")
    private String hsSubTitle;
    /**
     * 房产知识标签, XXX#XXX（#号分隔）
     */
    @TableField("hs_tag")
    private String hsTag;
    /**
     * 房产知识路径地址
     */
    @TableField("hs_url")
    private String hsUrl;
    /**
     * 房产知识摘要
     */
    @TableField("hs_abstract")
    private String hsAbstract;
    /**
     * 房产知识发布时间
     */
    @TableField("hs_time")
    private String hsTime;
    /**
     * 采集时间
     */
    @TableField("hs_spider_time")
    private Date hsSpiderTime;
    /**
     * 房产知识浏览量
     */
    @TableField("hs_page_view")
    private String hsPageView;
    /**
     * 房产知识来源
     */
    @TableField("hs_source")
    private String hsSource;
    /**
     * 房产知识正文(html)
     */
    @TableField("hs_html_part")
    private String hsHtmlPart;
    /**
     * 房产知识正文
     */
    @TableField("hs_text_part")
    private String hsTextPart;


    public Integer getHsId() {
        return hsId;
    }

    public void setHsId(Integer hsId) {
        this.hsId = hsId;
    }

    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getHsType() {
        return hsType;
    }

    public void setHsType(String hsType) {
        this.hsType = hsType;
    }

    public String getHsTitle() {
        return hsTitle;
    }

    public void setHsTitle(String hsTitle) {
        this.hsTitle = hsTitle;
    }

    public String getHsSubTitle() {
        return hsSubTitle;
    }

    public void setHsSubTitle(String hsSubTitle) {
        this.hsSubTitle = hsSubTitle;
    }

    public String getHsTag() {
        return hsTag;
    }

    public void setHsTag(String hsTag) {
        this.hsTag = hsTag;
    }

    public String getHsUrl() {
        return hsUrl;
    }

    public void setHsUrl(String hsUrl) {
        this.hsUrl = hsUrl;
    }

    public String getHsAbstract() {
        return hsAbstract;
    }

    public void setHsAbstract(String hsAbstract) {
        this.hsAbstract = hsAbstract;
    }

    public String getHsTime() {
        return hsTime;
    }

    public void setHsTime(String hsTime) {
        this.hsTime = hsTime;
    }

    public Date getHsSpiderTime() {
        return hsSpiderTime;
    }

    public void setHsSpiderTime(Date hsSpiderTime) {
        this.hsSpiderTime = hsSpiderTime;
    }

    public String getHsPageView() {
        return hsPageView;
    }

    public void setHsPageView(String hsPageView) {
        this.hsPageView = hsPageView;
    }

    public String getHsSource() {
        return hsSource;
    }

    public void setHsSource(String hsSource) {
        this.hsSource = hsSource;
    }

    public String getHsHtmlPart() {
        return hsHtmlPart;
    }

    public void setHsHtmlPart(String hsHtmlPart) {
        this.hsHtmlPart = hsHtmlPart;
    }

    public String getHsTextPart() {
        return hsTextPart;
    }

    public void setHsTextPart(String hsTextPart) {
        this.hsTextPart = hsTextPart;
    }

    @Override
    protected Serializable pkVal() {
        return this.hsId;
    }

    @Override
    public String toString() {
        return "HouseKnowledge{" +
        ", hsId=" + hsId +
        ", pmId=" + pmId +
        ", hsType=" + hsType +
        ", hsTitle=" + hsTitle +
        ", hsSubTitle=" + hsSubTitle +
        ", hsTag=" + hsTag +
        ", hsUrl=" + hsUrl +
        ", hsAbstract=" + hsAbstract +
        ", hsTime=" + hsTime +
        ", hsSpiderTime=" + hsSpiderTime +
        ", hsPageView=" + hsPageView +
        ", hsSource=" + hsSource +
        ", hsHtmlPart=" + hsHtmlPart +
        ", hsTextPart=" + hsTextPart +
        "}";
    }
}
