package com.xfj.spider.dao;

import com.xfj.spider.mapper.AgentMapper;
import com.xfj.spider.mapper.AgentPlatformMapper;
import com.xfj.spider.mapper.TelephoneMapper;
import com.xfj.spider.model.Agent;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.model.Telephone;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
@Transactional
@Component
public class TelephoneAgentPlatformDao {

    @Resource
    TelephoneMapper telephoneMapper;

    @Resource
    AgentMapper agentMapper;

    @Resource
    AgentPlatformMapper agentPlatformMapper;

    /**
     * 插入经纪人平台表
     * @param agentPlatform 经纪人平台信息
     * @return 经纪人平台id
     */
    public Integer insertPlatForm(AgentPlatform agentPlatform){
        agentPlatformMapper.insert(agentPlatform);
        return agentPlatform.getAmId();
    }

    public Integer insertAgentPlatForm(Agent agent, AgentPlatform agentPlatform){
        agentMapper.insert(agent);
        agentPlatform.setAtId(agent.getAtId());
        this.insertPlatForm(agentPlatform);
        return agent.getAtId();
    }

    public Integer insertTelephoneAgentPlatForm(Telephone telephone, Agent agent, AgentPlatform agentPlatform){
        telephoneMapper.insert(telephone);
        agent.setTeId(telephone.getTeId());
        this.insertAgentPlatForm(agent, agentPlatform);
        return telephone.getTeId();
    }

    /**
     * 查询电话表，电话号码信息
     * @param telephone 电话内容
     * @return 电话信息
     */
    public List<Telephone> getTelephones(Telephone telephone){
        return telephoneMapper.select(telephone);
    }

    public List<Agent> getAgents(Agent agent){
        return agentMapper.select(agent);
    }
    public List<AgentPlatform> getAgentPlatform(AgentPlatform agentPlatform){
        return agentPlatformMapper.select(agentPlatform);
    }


    public void updateAgentPlatform(AgentPlatform agentPlatform){
        agentPlatformMapper.updateByPrimaryKey(agentPlatform);
    }

    public Integer getAgentPlatformIdByKey(String telephone, String name, String company,Integer pmId){

        Map<String ,Object> map = new HashMap<>();
        map.put("telephone",telephone);
        map.put("name",name);
        map.put("company",company);
        map.put("pmId",pmId);
        return agentPlatformMapper.getAgentPlatform(map);
       // return agentPlatformMapper.getAgentPlatformId(telephone,name, company, pmId);
    }

}
