package com.xfj.spider.model;

import javax.persistence.*;

@Table(name = "esf_tools_spider_config")
public class EsfToolsSpiderConfig {
    @Id
    @Column(name = "config_id")
    private Integer configId;

    /**
     * 要采集的站点名字
     */
    @Column(name = "site_name")
    private String siteName;

    /**
     * 所属城市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 连接地址
     */
    @Column(name = "data_url")
    private String dataUrl;

    /**
     * 分页标志
     */
    @Column(name = "page_split_flag")
    private String pageSplitFlag;

    /**
     * 城市主域名
     */
    @Column(name = "city_domain")
    private String cityDomain;

    /**
     * 采集的类型,自定义使用
     */
    @Column(name = "spider_type")
    private Integer spiderType;

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
     * 获取要采集的站点名字
     *
     * @return site_name - 要采集的站点名字
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * 设置要采集的站点名字
     *
     * @param siteName 要采集的站点名字
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 获取所属城市ID
     *
     * @return city_id - 所属城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置所属城市ID
     *
     * @param cityId 所属城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取连接地址
     *
     * @return data_url - 连接地址
     */
    public String getDataUrl() {
        return dataUrl;
    }

    /**
     * 设置连接地址
     *
     * @param dataUrl 连接地址
     */
    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }

    /**
     * 获取分页标志
     *
     * @return page_split_flag - 分页标志
     */
    public String getPageSplitFlag() {
        return pageSplitFlag;
    }

    /**
     * 设置分页标志
     *
     * @param pageSplitFlag 分页标志
     */
    public void setPageSplitFlag(String pageSplitFlag) {
        this.pageSplitFlag = pageSplitFlag;
    }

    /**
     * 获取城市主域名
     *
     * @return city_domain - 城市主域名
     */
    public String getCityDomain() {
        return cityDomain;
    }

    /**
     * 设置城市主域名
     *
     * @param cityDomain 城市主域名
     */
    public void setCityDomain(String cityDomain) {
        this.cityDomain = cityDomain;
    }

    /**
     * 获取采集的类型,自定义使用
     *
     * @return spider_type - 采集的类型,自定义使用
     */
    public Integer getSpiderType() {
        return spiderType;
    }

    /**
     * 设置采集的类型,自定义使用
     *
     * @param spiderType 采集的类型,自定义使用
     */
    public void setSpiderType(Integer spiderType) {
        this.spiderType = spiderType;
    }
}