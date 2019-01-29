package com.xfj.spider.service.impl;

import com.xfj.spider.dao.TelephoneAgentPlatformDao;
import com.xfj.spider.model.Agent;
import com.xfj.spider.mapper.AgentMapper;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.model.Telephone;
import com.xfj.spider.service.AgentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Aes128;

import java.net.Inet4Address;
import java.util.List;

/**
 * 经纪人表 服务实现类
 * AgentServiceImpl
 * @author xnc
 * @since 2018-12-11
 */
@Service
public class AgentServiceImpl extends BaseService<Agent> implements AgentService {

    @Autowired
    TelephoneAgentPlatformDao telephoneAgentPlatformDao;

    @Override
    public void createTelephoneAgentPlatform(Telephone telephone, Agent agent, AgentPlatform agentPlatform){
        // 判断电话是否存在
        List<Telephone> listTelephones = telephoneAgentPlatformDao.getTelephones(telephone);
        if(listTelephones == null || listTelephones.size()==0){
            Integer res = telephoneAgentPlatformDao.insertTelephoneAgentPlatForm(telephone, agent, agentPlatform);
            if(res >0){
                System.out.println("添加经纪人成功！姓名："+agent.getAtName());
            }
        } else {
            // 电话存在，判断经纪人是否存在

            // 获取存在电话id
            Integer teId = listTelephones.get(0).getTeId();
            // 电话， 姓名， 公司 为关键标志
            Agent agentKey = new Agent();
            agentKey.setTeId(teId);
            agentKey.setAtName(agent.getAtName());
            agentKey.setAtCompany(agent.getAtCompany());

            List<Agent> listAgents = telephoneAgentPlatformDao.getAgents(agentKey);
            if(listAgents == null || listAgents.size() == 0){
                agent.setTeId(teId);
                telephoneAgentPlatformDao.insertAgentPlatForm(agent,agentPlatform);
            } else {
                // 经纪人存在，判断经纪人平台是否存在，如果存在进行数据对比
               // 平台id 作为主键进行对比
                Integer atId = listAgents.get(0).getAtId();
                AgentPlatform agentPlat = new AgentPlatform();
                agentPlat.setAtId(atId);
                agentPlat.setPmId(agentPlatform.getPmId());
                List<AgentPlatform> listAgentPlatforms = telephoneAgentPlatformDao.getAgentPlatform(agentPlat);
                if(listAgentPlatforms== null || listAgentPlatforms.size()==0){
                    agentPlatform.setAtId(atId);
                    telephoneAgentPlatformDao.insertPlatForm(agentPlatform);
                } else {
                    // todo 可以进行对比数据是否修改
                    Integer amId = listAgentPlatforms.get(0).getAmId();
                    //Integer atId = listAgentPlatforms.get(0).getAtId();
                    agentPlatform.setAmId(amId);
                    agentPlatform.setAtId(atId);
                    telephoneAgentPlatformDao.updateAgentPlatform(agentPlatform);

                }
            }
        }

    }

}
