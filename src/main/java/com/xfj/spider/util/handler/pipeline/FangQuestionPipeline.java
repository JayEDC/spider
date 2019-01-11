package com.xfj.spider.util.handler.pipeline;
import java.util.Date;

import com.xfj.spider.model.HouseQuestion;
import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.service.HouseQuestionService;
import com.xfj.spider.service.ReplyCommentsService;
import com.xfj.spider.util.handler.base.ConstantFangTianXia;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @ClassName FangQuestionPipeline
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/109:21 AM
 * @return 1.0
 **/
@Component
public class FangQuestionPipeline implements Pipeline {
    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    HouseQuestionService houseQuestionService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Object keyObject = resultItems.get(ConstantFangTianXia.QUESTIONPIPEKEY);

        /**
         * 判断是否是房产问答类型数据
         */
        if(null!= keyObject && keyObject.toString().equals(ConstantFangTianXia.QUESTIONPIPEKEY)){

            HouseQuestion houseQuestion = new HouseQuestion();
            houseQuestion.setPmId(1);
            houseQuestion.setHqType(resultItems.get("type"));
            houseQuestion.setHqContent(resultItems.get("title"));
            houseQuestion.setHqPublishTime(resultItems.get("time"));
            houseQuestion.setHqSpiderTime(new Date());
            houseQuestion.setHqPageView(resultItems.get("view"));
            houseQuestion.setHqQuestionUser(resultItems.get("user"));
            houseQuestion.setHqQuestionUserPhoto(resultItems.get(""));
            houseQuestion.setHqUrl(resultItems.get("url").toString());
            houseQuestion.setHqTag(resultItems.get("tag"));

            int i = houseQuestionService.save(houseQuestion);
            if(i>0){
                resultItems.put("hqId",houseQuestion.getHqId());
                logger.info("---------添加问答成功！问答内容：" + houseQuestion.getHqContent());
            }
        }
    }
}
