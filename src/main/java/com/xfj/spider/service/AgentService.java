package com.xfj.spider.service;

import com.xfj.spider.model.Agent;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.model.Telephone;

/**
 * 经纪人表 服务类
 * AgentService
 * @author xnc
 * @since 2018-12-11
 */
public interface AgentService extends IService<Agent> {
    void createTelephoneAgentPlatform(Telephone telephone, Agent agent, AgentPlatform agentPlatform);
}
