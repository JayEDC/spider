package com.xfj.spider.util.handler.pipeline;
import java.util.Date;

import com.xfj.spider.model.HouseKnowledge;
import com.xfj.spider.service.HouseKnowledgeService;
import com.xfj.spider.util.handler.base.ConstantFangTianXia;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @ClassName FangZhiShiPipeline
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/72:55 PM
 * @return 1.0
 **/
@Component
public class FangZhiShiPipeline implements Pipeline {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    HouseKnowledgeService houseKnowledgeService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Object keyObject = resultItems.get(ConstantFangTianXia.PIPEKEY);
        /**
         * 判断是否是房产知识类型数据
         */
        if(null!= keyObject && keyObject.toString().equals(ConstantFangTianXia.ZS)){

            HouseKnowledge houseKnowledge = new HouseKnowledge();
            houseKnowledge.setPmId(resultItems.get("pm_id"));
            houseKnowledge.setHsType(resultItems.get("type"));
            houseKnowledge.setHsTitle(resultItems.get("title"));
            houseKnowledge.setHsSubTitle(resultItems.get("type"));
            houseKnowledge.setHsTag(resultItems.get("tag"));
            houseKnowledge.setHsUrl(resultItems.get("url"));
            houseKnowledge.setHsAbstract(resultItems.get("abstractText"));
            houseKnowledge.setHsTime(resultItems.get("time"));
            houseKnowledge.setHsSpiderTime(new Date());
            houseKnowledge.setHsPageView(resultItems.get("pageView"));
            houseKnowledge.setHsSource(resultItems.get("source"));
            houseKnowledge.setHsHtmlPart(resultItems.get("text"));
            houseKnowledge.setHsTextPart(resultItems.get("htmlText"));

            boolean check = houseKnowledgeService.check(resultItems.get("url").toString().trim());
            if(check){
                int i = houseKnowledgeService.save(houseKnowledge);
                if (i>0){
                    logger.info("---------添加文章成功！文章标题：" + houseKnowledge.getHsTitle());
                }
            }
        }
    }


}
