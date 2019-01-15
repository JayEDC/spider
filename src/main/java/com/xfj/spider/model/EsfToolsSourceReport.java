package com.xfj.spider.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "esf_tools_source_report")
public class EsfToolsSourceReport {
    @Id
    @Column(name = "report_id")
    private Integer reportId;

    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "agent_id")
    private Integer agentId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return report_id
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * @param reportId
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

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
     * @return agent_id
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * @param agentId
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
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
}