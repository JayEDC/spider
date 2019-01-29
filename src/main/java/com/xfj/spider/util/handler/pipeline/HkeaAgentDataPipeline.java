package com.xfj.spider.util.handler.pipeline;
import java.util.Date;
import java.util.List;

import com.xfj.spider.model.Agent;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.model.Telephone;
import com.xfj.spider.service.AgentPlatformService;
import com.xfj.spider.service.AgentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @ClassName HkeaAgentDataPipeline
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/284:37 PM
 * @return 1.0
 **/
@Component
public class HkeaAgentDataPipeline implements Pipeline {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    AgentService agentService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        if(("1").equals(resultItems.get("type"))){
            Telephone telephone = new Telephone();
            telephone.setTeTelephone(resultItems.get("phone").toString().trim());
            telephone.setTeLocation("香港");
            telephone.setTeCreateDate(new Date());

            Agent agent = new Agent();
            agent.setAtActiveDate(new Date());
            agent.setAtCity("香港");
            agent.setAtName(resultItems.get("name"));
            agent.setAtCreateDate(new Date());
            agent.setAtEmail(resultItems.get("email"));

            AgentPlatform agentPlatform = new AgentPlatform();
            agentPlatform.setAmUpdateDate(new Date());
            agentPlatform.setPmId(4);
            agentPlatform.setAmCreateDate(new Date());
            agentPlatform.setAmUrl(resultItems.get("url").toString());
            agentService.createTelephoneAgentPlatform(telephone,agent,agentPlatform);


        }


    }


}
