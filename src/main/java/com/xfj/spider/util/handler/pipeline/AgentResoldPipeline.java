package com.xfj.spider.util.handler.pipeline;


import com.xfj.spider.model.Resold;
import com.xfj.spider.service.AgentPlatformService;
import com.xfj.spider.service.ResoldService;
import com.xfj.spider.util.handler.base.ConstantAnjuke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author Lao SiCheng
 * @version 0.1
 */
@Component
public class AgentResoldPipeline implements Pipeline {
    @Autowired
    ResoldService resoldService;

    @Autowired
    AgentPlatformService agentPlatformService;
    @Override
    public void process(ResultItems resultItems, Task task) {
        Object keyObject = resultItems.get(ConstantAnjuke.PIPEKEY);
        // 判断是否经纪人二手房信息
        if(null != keyObject
                && ConstantAnjuke.RESOLD.equals(keyObject.toString())){
            String name = resultItems.get("name");
            String company = resultItems.get("company");
            String tel = resultItems.get("telephone");
            List<String> listResoldLinks = resultItems.get("listResoldLinks");
            Integer amId= agentPlatformService.getAgentPlatformIdByKey(tel,name,company,3);
            Resold resold = new Resold();
            resold.setAmId(amId);
            for(String link : listResoldLinks){
                resold.setRdUrl(link);
                resoldService.save(resold);
            }
        }
    }
}
