package com.xfj.spider.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "esf_tools_spider_record")
public class EsfToolsSpiderRecord {
    @Id
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * 采集的站点
     */
    @Column(name = "source_site")
    private String sourceSite;

    /**
     * 城市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 小区ID,esf_project
     */
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 小区名字
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 原始站点的ID
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * 原始站点路径
     */
    @Column(name = "source_url")
    private String sourceUrl;

    /**
     * 售卖标题
     */
    @Column(name = "source_title")
    private String sourceTitle;

    /**
     * 联系人
     */
    private String creator;

    /**
     * 联系电话
     */
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 区域名
     */
    @Column(name = "area_name")
    private String areaName;

    /**
     * 总价（万元）
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 面积
     */
    @Column(name = "area_units")
    private BigDecimal areaUnits;

    /**
     * 户型描述（几房几厅）
     */
    @Column(name = "house_format")
    private String houseFormat;

    /**
     * 楼层描述
     */
    private String floors;

    /**
     * html存档路径(无意义)
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 是否已经处理
     */
    @Column(name = "is_processd")
    private Boolean isProcessd;

    /**
     * 是经纪人发布还是个人发布，1为经纪人
     */
    @Column(name = "is_agent_source")
    private Boolean isAgentSource;

    /**
     * 需求ID,无意义
     */
    @Column(name = "demand_id")
    private Integer demandId;

    /**
     * 1, 出售
            2, 出租
     */
    @Column(name = "demand_type")
    private Integer demandType;

    /**
     * @标签内容@标签内容
     */
    private String tags;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 图片总数量
     */
    @Column(name = "pic_count")
    private Integer picCount;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 失败次数，无意义
     */
    @Column(name = "inactive_times")
    private Integer inactiveTimes;

    /**
     * MD5值，无意义，但不能为空
     */
    @Column(name = "md5_code")
    private String md5Code;

    /**
     * 装修描述
     */
    private String decorating;

    /**
     * 朝向描述
     */
    private String chaoxiang;

    /**
     * 房屋类型描述
     */
    private String cagegory;

    /**
     * 图片路径，英文分号隔开
     */
    @Column(name = "images_url")
    private String imagesUrl;

    /**
     * 售卖详情
     */
    private String description;

    /**
     * @return record_id
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * @param recordId
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    /**
     * 获取采集的站点
     *
     * @return source_site - 采集的站点
     */
    public String getSourceSite() {
        return sourceSite;
    }

    /**
     * 设置采集的站点
     *
     * @param sourceSite 采集的站点
     */
    public void setSourceSite(String sourceSite) {
        this.sourceSite = sourceSite;
    }

    /**
     * 获取城市ID
     *
     * @return city_id - 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置城市ID
     *
     * @param cityId 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取小区ID,esf_project
     *
     * @return project_id - 小区ID,esf_project
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置小区ID,esf_project
     *
     * @param projectId 小区ID,esf_project
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取小区名字
     *
     * @return project_name - 小区名字
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置小区名字
     *
     * @param projectName 小区名字
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取原始站点的ID
     *
     * @return source_id - 原始站点的ID
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * 设置原始站点的ID
     *
     * @param sourceId 原始站点的ID
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * 获取原始站点路径
     *
     * @return source_url - 原始站点路径
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * 设置原始站点路径
     *
     * @param sourceUrl 原始站点路径
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    /**
     * 获取售卖标题
     *
     * @return source_title - 售卖标题
     */
    public String getSourceTitle() {
        return sourceTitle;
    }

    /**
     * 设置售卖标题
     *
     * @param sourceTitle 售卖标题
     */
    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    /**
     * 获取联系人
     *
     * @return creator - 联系人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置联系人
     *
     * @param creator 联系人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone - 联系电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系电话
     *
     * @param contactPhone 联系电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 获取区域名
     *
     * @return area_name - 区域名
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置区域名
     *
     * @param areaName 区域名
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取总价（万元）
     *
     * @return total_price - 总价（万元）
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 设置总价（万元）
     *
     * @param totalPrice 总价（万元）
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 获取面积
     *
     * @return area_units - 面积
     */
    public BigDecimal getAreaUnits() {
        return areaUnits;
    }

    /**
     * 设置面积
     *
     * @param areaUnits 面积
     */
    public void setAreaUnits(BigDecimal areaUnits) {
        this.areaUnits = areaUnits;
    }

    /**
     * 获取户型描述（几房几厅）
     *
     * @return house_format - 户型描述（几房几厅）
     */
    public String getHouseFormat() {
        return houseFormat;
    }

    /**
     * 设置户型描述（几房几厅）
     *
     * @param houseFormat 户型描述（几房几厅）
     */
    public void setHouseFormat(String houseFormat) {
        this.houseFormat = houseFormat;
    }

    /**
     * 获取楼层描述
     *
     * @return floors - 楼层描述
     */
    public String getFloors() {
        return floors;
    }

    /**
     * 设置楼层描述
     *
     * @param floors 楼层描述
     */
    public void setFloors(String floors) {
        this.floors = floors;
    }

    /**
     * 获取html存档路径(无意义)
     *
     * @return file_url - html存档路径(无意义)
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置html存档路径(无意义)
     *
     * @param fileUrl html存档路径(无意义)
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取是否已经处理
     *
     * @return is_processd - 是否已经处理
     */
    public Boolean getIsProcessd() {
        return isProcessd;
    }

    /**
     * 设置是否已经处理
     *
     * @param isProcessd 是否已经处理
     */
    public void setIsProcessd(Boolean isProcessd) {
        this.isProcessd = isProcessd;
    }

    /**
     * 获取是经纪人发布还是个人发布，1为经纪人
     *
     * @return is_agent_source - 是经纪人发布还是个人发布，1为经纪人
     */
    public Boolean getIsAgentSource() {
        return isAgentSource;
    }

    /**
     * 设置是经纪人发布还是个人发布，1为经纪人
     *
     * @param isAgentSource 是经纪人发布还是个人发布，1为经纪人
     */
    public void setIsAgentSource(Boolean isAgentSource) {
        this.isAgentSource = isAgentSource;
    }

    /**
     * 获取需求ID,无意义
     *
     * @return demand_id - 需求ID,无意义
     */
    public Integer getDemandId() {
        return demandId;
    }

    /**
     * 设置需求ID,无意义
     *
     * @param demandId 需求ID,无意义
     */
    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    /**
     * 获取1, 出售
            2, 出租
     *
     * @return demand_type - 1, 出售
            2, 出租
     */
    public Integer getDemandType() {
        return demandType;
    }

    /**
     * 设置1, 出售
            2, 出租
     *
     * @param demandType 1, 出售
            2, 出租
     */
    public void setDemandType(Integer demandType) {
        this.demandType = demandType;
    }

    /**
     * 获取@标签内容@标签内容
     *
     * @return tags - @标签内容@标签内容
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置@标签内容@标签内容
     *
     * @param tags @标签内容@标签内容
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取图片总数量
     *
     * @return pic_count - 图片总数量
     */
    public Integer getPicCount() {
        return picCount;
    }

    /**
     * 设置图片总数量
     *
     * @param picCount 图片总数量
     */
    public void setPicCount(Integer picCount) {
        this.picCount = picCount;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取失败次数，无意义
     *
     * @return inactive_times - 失败次数，无意义
     */
    public Integer getInactiveTimes() {
        return inactiveTimes;
    }

    /**
     * 设置失败次数，无意义
     *
     * @param inactiveTimes 失败次数，无意义
     */
    public void setInactiveTimes(Integer inactiveTimes) {
        this.inactiveTimes = inactiveTimes;
    }

    /**
     * 获取MD5值，无意义，但不能为空
     *
     * @return md5_code - MD5值，无意义，但不能为空
     */
    public String getMd5Code() {
        return md5Code;
    }

    /**
     * 设置MD5值，无意义，但不能为空
     *
     * @param md5Code MD5值，无意义，但不能为空
     */
    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

    /**
     * 获取装修描述
     *
     * @return decorating - 装修描述
     */
    public String getDecorating() {
        return decorating;
    }

    /**
     * 设置装修描述
     *
     * @param decorating 装修描述
     */
    public void setDecorating(String decorating) {
        this.decorating = decorating;
    }

    /**
     * 获取朝向描述
     *
     * @return chaoxiang - 朝向描述
     */
    public String getChaoxiang() {
        return chaoxiang;
    }

    /**
     * 设置朝向描述
     *
     * @param chaoxiang 朝向描述
     */
    public void setChaoxiang(String chaoxiang) {
        this.chaoxiang = chaoxiang;
    }

    /**
     * 获取房屋类型描述
     *
     * @return cagegory - 房屋类型描述
     */
    public String getCagegory() {
        return cagegory;
    }

    /**
     * 设置房屋类型描述
     *
     * @param cagegory 房屋类型描述
     */
    public void setCagegory(String cagegory) {
        this.cagegory = cagegory;
    }

    /**
     * 获取图片路径，英文分号隔开
     *
     * @return images_url - 图片路径，英文分号隔开
     */
    public String getImagesUrl() {
        return imagesUrl;
    }

    /**
     * 设置图片路径，英文分号隔开
     *
     * @param imagesUrl 图片路径，英文分号隔开
     */
    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    /**
     * 获取售卖详情
     *
     * @return description - 售卖详情
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置售卖详情
     *
     * @param description 售卖详情
     */
    public void setDescription(String description) {
        this.description = description;
    }
}