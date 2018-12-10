package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * TActiveAgent modle
 * 
 * @author xnc
 * @since 2018-12-04
 */
@TableName("t_active_agent")
public class TActiveAgent extends Model<TActiveAgent> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 经纪人姓名
     */
    @TableField("agent_name")
    private String agentName;
    /**
     * 经纪人电话
     */
    @TableField("agent_phone")
    private String agentPhone;
    /**
     * 经纪人所在地
     */
    @TableField("agent_location")
    private String agentLocation;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 最后活跃时间
     */
    @TableField("active_date")
    private Date activeDate;
    /**
     * 废弃字段
     */
    @TableField("last_active_time")
    private Long lastActiveTime;
    @TableField("city_id")
    private Integer cityId;
    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;
    /**
     * 门店
     */
    @TableField("store_name")
    private String storeName;
    /**
     * 当前跟进经纪人
     */
    @TableField("follow_agent")
    private Integer followAgent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone;
    }

    public String getAgentLocation() {
        return agentLocation;
    }

    public void setAgentLocation(String agentLocation) {
        this.agentLocation = agentLocation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Long getLastActiveTime() {
        return lastActiveTime;
    }

    public void setLastActiveTime(Long lastActiveTime) {
        this.lastActiveTime = lastActiveTime;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getFollowAgent() {
        return followAgent;
    }

    public void setFollowAgent(Integer followAgent) {
        this.followAgent = followAgent;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TActiveAgent{" +
        ", id=" + id +
        ", agentName=" + agentName +
        ", agentPhone=" + agentPhone +
        ", agentLocation=" + agentLocation +
        ", createTime=" + createTime +
        ", activeDate=" + activeDate +
        ", lastActiveTime=" + lastActiveTime +
        ", cityId=" + cityId +
        ", companyName=" + companyName +
        ", storeName=" + storeName +
        ", followAgent=" + followAgent +
        "}";
    }
}
