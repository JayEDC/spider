package com.xfj.spider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "esf_tools_spider_feed_config")
public class EsfToolsSpiderFeedConfig {
    @Id
    @Column(name = "fee_config_id")
    private Integer feeConfigId;

    @Column(name = "config_id")
    private Integer configId;

    /**
     * 字段名字，采用Javabeen命名方式，例如projectName
     */
    @Column(name = "feed_name")
    private String feedName;

    /**
     * 值的类型，1：text，2：attr
     */
    @Column(name = "result_type")
    private Integer resultType;

    /**
     * 父元素选择器的表达式，例如select(#xxx), select(.xxx)
     */
    @Column(name = "parent_element")
    private String parentElement;

    /**
     * 规则创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 规则最近修改时间
     */
    @Column(name = "update_tme")
    private Date updateTme;

    /**
     * 当前是否生效,1生效，0作废
     */
    @Column(name = "valid_config")
    private Integer validConfig;

    /**
     * 规则的版本号，递增
     */
    @Column(name = "config_version")
    private Integer configVersion;

    /**
     * 配置文件存放路径
     */
    @Column(name = "config_file")
    private String configFile;

    /**
     * @return fee_config_id
     */
    public Integer getFeeConfigId() {
        return feeConfigId;
    }

    /**
     * @param feeConfigId
     */
    public void setFeeConfigId(Integer feeConfigId) {
        this.feeConfigId = feeConfigId;
    }

    /**
     * @return config_id
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * @param configId
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 获取字段名字，采用Javabeen命名方式，例如projectName
     *
     * @return feed_name - 字段名字，采用Javabeen命名方式，例如projectName
     */
    public String getFeedName() {
        return feedName;
    }

    /**
     * 设置字段名字，采用Javabeen命名方式，例如projectName
     *
     * @param feedName 字段名字，采用Javabeen命名方式，例如projectName
     */
    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }

    /**
     * 获取值的类型，1：text，2：attr
     *
     * @return result_type - 值的类型，1：text，2：attr
     */
    public Integer getResultType() {
        return resultType;
    }

    /**
     * 设置值的类型，1：text，2：attr
     *
     * @param resultType 值的类型，1：text，2：attr
     */
    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    /**
     * 获取父元素选择器的表达式，例如select(#xxx), select(.xxx)
     *
     * @return parent_element - 父元素选择器的表达式，例如select(#xxx), select(.xxx)
     */
    public String getParentElement() {
        return parentElement;
    }

    /**
     * 设置父元素选择器的表达式，例如select(#xxx), select(.xxx)
     *
     * @param parentElement 父元素选择器的表达式，例如select(#xxx), select(.xxx)
     */
    public void setParentElement(String parentElement) {
        this.parentElement = parentElement;
    }

    /**
     * 获取规则创建时间
     *
     * @return create_time - 规则创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置规则创建时间
     *
     * @param createTime 规则创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取规则最近修改时间
     *
     * @return update_tme - 规则最近修改时间
     */
    public Date getUpdateTme() {
        return updateTme;
    }

    /**
     * 设置规则最近修改时间
     *
     * @param updateTme 规则最近修改时间
     */
    public void setUpdateTme(Date updateTme) {
        this.updateTme = updateTme;
    }

    /**
     * 获取当前是否生效,1生效，0作废
     *
     * @return valid_config - 当前是否生效,1生效，0作废
     */
    public Integer getValidConfig() {
        return validConfig;
    }

    /**
     * 设置当前是否生效,1生效，0作废
     *
     * @param validConfig 当前是否生效,1生效，0作废
     */
    public void setValidConfig(Integer validConfig) {
        this.validConfig = validConfig;
    }

    /**
     * 获取规则的版本号，递增
     *
     * @return config_version - 规则的版本号，递增
     */
    public Integer getConfigVersion() {
        return configVersion;
    }

    /**
     * 设置规则的版本号，递增
     *
     * @param configVersion 规则的版本号，递增
     */
    public void setConfigVersion(Integer configVersion) {
        this.configVersion = configVersion;
    }

    /**
     * 获取配置文件存放路径
     *
     * @return config_file - 配置文件存放路径
     */
    public String getConfigFile() {
        return configFile;
    }

    /**
     * 设置配置文件存放路径
     *
     * @param configFile 配置文件存放路径
     */
    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }
}