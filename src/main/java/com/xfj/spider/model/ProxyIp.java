package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 *  代理IP表 modle
 * @author xnc
 * @since 2018-12-11
 */
@TableName("proxy_ip")
public class ProxyIp extends Model<ProxyIp> {

    private static final long serialVersionUID = 1L;

    /**
     * 代理id,自增
     */
    @TableId(value = "pp_id", type = IdType.AUTO)
    private Integer ppId;
    @TableField("pp_ip")
    private String ppIp;
    @TableField("pp_port")
    private String ppPort;
    /**
     * 是否能用 否0 ，能1 
     */
    @TableField("pp_status")
    private Integer ppStatus;
    /**
     * 获得ip日期
     */
    @TableField("pp_create_date")
    private Date ppCreateDate;


    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getPpIp() {
        return ppIp;
    }

    public void setPpIp(String ppIp) {
        this.ppIp = ppIp;
    }

    public String getPpPort() {
        return ppPort;
    }

    public void setPpPort(String ppPort) {
        this.ppPort = ppPort;
    }

    public Integer getPpStatus() {
        return ppStatus;
    }

    public void setPpStatus(Integer ppStatus) {
        this.ppStatus = ppStatus;
    }

    public Date getPpCreateDate() {
        return ppCreateDate;
    }

    public void setPpCreateDate(Date ppCreateDate) {
        this.ppCreateDate = ppCreateDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.ppId;
    }

    @Override
    public String toString() {
        return "ProxyIp{" +
        ", ppId=" + ppId +
        ", ppIp=" + ppIp +
        ", ppPort=" + ppPort +
        ", ppStatus=" + ppStatus +
        ", ppCreateDate=" + ppCreateDate +
        "}";
    }
}
