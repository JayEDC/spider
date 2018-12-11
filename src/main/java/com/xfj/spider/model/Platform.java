package com.xfj.spider.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * Platform modle
 * 平台表
 * @author xnc
 * @since 2018-12-11
 */
@TableName("platform")
public class Platform extends Model<Platform> {

    private static final long serialVersionUID = 1L;

    /**
     * 平台ID，自增
     */
    @TableId(value = "pm_id", type = IdType.AUTO)
    private Integer pmId;
    /**
     * 平台名称
     */
    @TableField("pm_name")
    private String pmName;
    /**
     * 平台链接
     */
    @TableField("pm_url")
    private String pmUrl;


    public Integer getPmId() {
        return pmId;
    }

    public void setPmId(Integer pmId) {
        this.pmId = pmId;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName;
    }

    public String getPmUrl() {
        return pmUrl;
    }

    public void setPmUrl(String pmUrl) {
        this.pmUrl = pmUrl;
    }

    @Override
    protected Serializable pkVal() {
        return this.pmId;
    }

    @Override
    public String toString() {
        return "Platform{" +
        ", pmId=" + pmId +
        ", pmName=" + pmName +
        ", pmUrl=" + pmUrl +
        "}";
    }
}
