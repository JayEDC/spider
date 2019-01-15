package com.xfj.spider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "esf_tools_spider_task")
public class EsfToolsSpiderTask {
    @Id
    @Column(name = "task_id")
    private Integer taskId;

    /**
     * 城市ID
     */
    @Column(name = "city_id")
    private Integer cityId;

    /**
     * 任务级别,1-3,1最高
     */
    @Column(name = "task_rank")
    private Integer taskRank;

    /**
     * 站点名字
     */
    @Column(name = "site_name")
    private String siteName;

    /**
     * 任务URL
     */
    @Column(name = "task_url")
    private String taskUrl;

    /**
     * 任务类型，1：出售采集
     */
    @Column(name = "task_type")
    private Integer taskType;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 失败次数
     */
    @Column(name = "faided_count")
    private Integer faidedCount;

    /**
     * 文件存储路径
     */
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 任务开始时间（进入队列开始计算）
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 开始采集的时间
     */
    @Column(name = "spider_time")
    private Date spiderTime;

    /**
     * 采集任务完成的时间
     */
    @Column(name = "finished_time")
    private Date finishedTime;

    /**
     * 0:未开始,1:进入队列,2:完成采集
     */
    @Column(name = "task_status")
    private Integer taskStatus;

    /**
     * 采集结果的ID, esf_tools_spider_record
     */
    @Column(name = "record_id")
    private Integer recordId;

    /**
     * @return task_id
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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
     * 获取任务级别,1-3,1最高
     *
     * @return task_rank - 任务级别,1-3,1最高
     */
    public Integer getTaskRank() {
        return taskRank;
    }

    /**
     * 设置任务级别,1-3,1最高
     *
     * @param taskRank 任务级别,1-3,1最高
     */
    public void setTaskRank(Integer taskRank) {
        this.taskRank = taskRank;
    }

    /**
     * 获取站点名字
     *
     * @return site_name - 站点名字
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * 设置站点名字
     *
     * @param siteName 站点名字
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 获取任务URL
     *
     * @return task_url - 任务URL
     */
    public String getTaskUrl() {
        return taskUrl;
    }

    /**
     * 设置任务URL
     *
     * @param taskUrl 任务URL
     */
    public void setTaskUrl(String taskUrl) {
        this.taskUrl = taskUrl;
    }

    /**
     * 获取任务类型，1：出售采集
     *
     * @return task_type - 任务类型，1：出售采集
     */
    public Integer getTaskType() {
        return taskType;
    }

    /**
     * 设置任务类型，1：出售采集
     *
     * @param taskType 任务类型，1：出售采集
     */
    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
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
     * 获取失败次数
     *
     * @return faided_count - 失败次数
     */
    public Integer getFaidedCount() {
        return faidedCount;
    }

    /**
     * 设置失败次数
     *
     * @param faidedCount 失败次数
     */
    public void setFaidedCount(Integer faidedCount) {
        this.faidedCount = faidedCount;
    }

    /**
     * 获取文件存储路径
     *
     * @return file_url - 文件存储路径
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * 设置文件存储路径
     *
     * @param fileUrl 文件存储路径
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * 获取任务开始时间（进入队列开始计算）
     *
     * @return start_time - 任务开始时间（进入队列开始计算）
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置任务开始时间（进入队列开始计算）
     *
     * @param startTime 任务开始时间（进入队列开始计算）
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取开始采集的时间
     *
     * @return spider_time - 开始采集的时间
     */
    public Date getSpiderTime() {
        return spiderTime;
    }

    /**
     * 设置开始采集的时间
     *
     * @param spiderTime 开始采集的时间
     */
    public void setSpiderTime(Date spiderTime) {
        this.spiderTime = spiderTime;
    }

    /**
     * 获取采集任务完成的时间
     *
     * @return finished_time - 采集任务完成的时间
     */
    public Date getFinishedTime() {
        return finishedTime;
    }

    /**
     * 设置采集任务完成的时间
     *
     * @param finishedTime 采集任务完成的时间
     */
    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    /**
     * 获取0:未开始,1:进入队列,2:完成采集
     *
     * @return task_status - 0:未开始,1:进入队列,2:完成采集
     */
    public Integer getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置0:未开始,1:进入队列,2:完成采集
     *
     * @param taskStatus 0:未开始,1:进入队列,2:完成采集
     */
    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * 获取采集结果的ID, esf_tools_spider_record
     *
     * @return record_id - 采集结果的ID, esf_tools_spider_record
     */
    public Integer getRecordId() {
        return recordId;
    }

    /**
     * 设置采集结果的ID, esf_tools_spider_record
     *
     * @param recordId 采集结果的ID, esf_tools_spider_record
     */
    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }
}