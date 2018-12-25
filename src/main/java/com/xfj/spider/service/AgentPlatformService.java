package com.xfj.spider.service;

import com.xfj.spider.model.AgentPlatform;
/**
 * 平台表信息表 服务类
 * AgentPlatformService
 * @author xnc
 * @since 2018-12-11
 */
public interface AgentPlatformService extends IService<AgentPlatform> {
    Integer getAgentPlatformIdByKey(String telephoneNum, String name, String company,Integer pmId);

}
