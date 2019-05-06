package com.xfj.spider.util.handler.pipeline;

import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.model.vo.CheckHouse;
import com.xfj.spider.service.HouseQuestionService;
import com.xfj.spider.service.ReplyCommentsService;
import com.xfj.spider.util.handler.base.ConstantFangTianXia;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * @ClassName FangCommentsPipeline
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/104:35 PM
 * @return 1.0
 **/
@Component
public class FangCommentsPipeline implements Pipeline {
    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    ReplyCommentsService replyCommentsService;

    @Autowired
    HouseQuestionService houseQuestionService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Object keyObject = resultItems.get(ConstantFangTianXia.COMMENTS);
        int j = 0;
        if(null != resultItems.get("url")){
            Map<String,Object> map = new HashMap<>();
            map.put("hqUrl",resultItems.get("url").toString());
            j = houseQuestionService.checkHouseQuestionUrl(map);
        }
        if(null!= keyObject && keyObject.toString().equals(ConstantFangTianXia.COMMENTS) && !replyCommentsService.CommentsCheck(resultItems.get("URL"))&& j > 0){
            /**
             * 回复 Map 包含 标识id 与父 id
             */
            Map<String,Integer> commIdMaps = new HashMap<>();
            /**
             * 评论 Map
             */
            Map<String,ReplyComments> userCountMap = resultItems.get("userCountMap");
            /**
             * 回复 Map
             */
            Map<String, List<ReplyComments>> commentMap = resultItems.get("commentMap");
            /**
             * 保存评论数据
             */
            Set<String> userSet= userCountMap.keySet();
            Iterator<String> userIt = userSet.iterator();
            while (userIt.hasNext()) {
                String commId = userIt.next();
                ReplyComments replyComments= userCountMap.get(commId);
                replyComments.setHqUrl(resultItems.get("url").toString());
                int i = replyCommentsService.save(replyComments);
                if (i > 0) {
                    commIdMaps.put(commId, replyComments.getCommentsId());
                    logger.info(" 添加回答成功！回答内容：" + replyComments.getCommentsContent() + "==== URL:" + replyComments.getHqUrl());
                }
            }

            /**
             * 保存回复数据
             */
            Set<String> commentSet= userCountMap.keySet();
            Iterator<String> commentIt = userSet.iterator();
            while (commentIt.hasNext()) {
                String commentId = commentIt.next();
                List<ReplyComments> replyCommentsList = commentMap.get(commentId);
                if(replyCommentsList!=null){
                    for (int i=0;i<replyCommentsList.size();i++){
                        Integer parentId = commIdMaps.get(commentId);
                        ReplyComments replyComments = replyCommentsList.get(i);
                        replyComments.setHqUrl(resultItems.get("url").toString());
                        replyComments.setParent(parentId);
                        if(j>0) {
                            int k = replyCommentsService.save(replyComments);
                            if (k > 0) {
                                logger.info("====== 添加回复成功！回复内容：" + replyComments.getCommentsContent() + "==== URL:" + replyComments.getHqUrl());
                            }
                        }
                    }
                }
            }
        }
    }
}
