package com.xfj.spider.util.handler.pipeline;


import com.xfj.spider.dao.TelephoneAgentPlatformDao;
import com.xfj.spider.model.Agent;
import com.xfj.spider.model.AgentPlatform;
import com.xfj.spider.model.Telephone;
import com.xfj.spider.service.AgentService;
import com.xfj.spider.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import com.xfj.spider.util.handler.base.ConstantAnjuke;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
@Component
public class AgentDetailPipeline implements Pipeline {
    @Autowired
    AgentService agentService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        Object keyObject = resultItems.get(ConstantAnjuke.PIPEKEY);
        // 判断是否经纪人信息页
        if(null != keyObject
                && ConstantAnjuke.AGENTINFO.equals(keyObject.toString())){
            String name = resultItems.get("name");
            String photo = resultItems.get("photo");
            String company = resultItems.get("company");
            String tel = resultItems.get("telephone");
            String city = resultItems.get("city");
            String mainArea = resultItems.get("mainArea");
            String mainCommunity = resultItems.get("mainCommunity");
            String workDay = resultItems.get("workDay");
            String url = resultItems.get("url");


            //数据组装
            Telephone telephone = new Telephone();
            telephone.setTeTelephone(tel);
            //telephone.setTeCreateDate(new Date());

            Agent agent = new Agent();
            agent.setAtCity(city);
            agent.setAtName(name);
            agent.setAtCompany(company);
            agent.setAtPhoto(photo);
            agent.setAtMainArea(mainArea);
            agent.setAtMainLocation(mainCommunity);
            //agent.setAtCreateDate(new Date());

            AgentPlatform agentPlatform = new AgentPlatform();
           // agentPlatform.setAmCreateDate(new Date());
            agentPlatform.setAmUrl(url);
            agentPlatform.setAmWorkDay(workDay);
            agentPlatform.setPmId(3);

            agentService.createTelephoneAgentPlatform(telephone, agent, agentPlatform);
        }
    }
}
