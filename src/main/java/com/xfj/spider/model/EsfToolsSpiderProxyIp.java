package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * EsfToolsSpiderProxyIp modle
 * 
 * @author xnc
 * @since 2018-12-04
 */
@TableName("esf_tools_spider_proxy_ip")
public class EsfToolsSpiderProxyIp extends Model<EsfToolsSpiderProxyIp> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ip_id", type = IdType.AUTO)
    private Integer ipId;
    /**
     * IP地址
     */
    @TableField("ip_addr")
    private String ipAddr;
    /**
     * 端口
     */
    @TableField("ip_port")
    private Integer ipPort;
    /**
     * 成功的次数
     */
    @TableField("successed_count")
    private Integer successedCount;
    /**
     * 失败的次数
     */
    @TableField("failed_count")
    private Integer failedCount;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 上一次成功时间
     */
    @TableField("success_time")
    private Date successTime;
    /**
     * 上一次失败时间
     */
    @TableField("fail_time")
    private Date failTime;


    public Integer getIpId() {
        return ipId;
    }

    public void setIpId(Integer ipId) {
        this.ipId = ipId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Integer getIpPort() {
        return ipPort;
    }

    public void setIpPort(Integer ipPort) {
        this.ipPort = ipPort;
    }

    public Integer getSuccessedCount() {
        return successedCount;
    }

    public void setSuccessedCount(Integer successedCount) {
        this.successedCount = successedCount;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getFailTime() {
        return failTime;
    }

    public void setFailTime(Date failTime) {
        this.failTime = failTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.ipId;
    }

    @Override
    public String toString() {
        return "EsfToolsSpiderProxyIp{" +
        ", ipId=" + ipId +
        ", ipAddr=" + ipAddr +
        ", ipPort=" + ipPort +
        ", successedCount=" + successedCount +
        ", failedCount=" + failedCount +
        ", createTime=" + createTime +
        ", successTime=" + successTime +
        ", failTime=" + failTime +
        "}";
    }
}
