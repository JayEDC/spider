package com.xfj.spider.mapper;

import com.xfj.spider.model.Agent;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.util.MyMapper;

/**
 * 经纪人表 Mapper 接口
 * AgentMapper
 * @author xnc
 * @since 2018-12-13
 */
public interface AgentMapper extends MyMapper<Agent> {
    AgentPlatform getAgentByUrl(String url);

}
