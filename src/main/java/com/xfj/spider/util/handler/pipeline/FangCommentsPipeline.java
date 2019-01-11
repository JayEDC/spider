package com.xfj.spider.util.handler.pipeline;

import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.service.ReplyCommentsService;
import com.xfj.spider.util.handler.base.ConstantFangTianXia;
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


    @Autowired
    ReplyCommentsService replyCommentsService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Object keyObject = resultItems.get(ConstantFangTianXia.COMMENTS);

        if(null!= keyObject && keyObject.toString().equals(ConstantFangTianXia.COMMENTS)){

            Integer id = resultItems.get("hqId");
            if(id != null){
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
                    replyComments.setHqId(id);
                    int i = replyCommentsService.save(replyComments);
                    if(i>0){
                        commIdMaps.put(commId,replyComments.getCommentsId());
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
                            replyComments.setHqId(id);
                            replyComments.setParent(parentId);
                            replyCommentsService.save(replyComments);
                        }
                    }
                }
            }
        }
    }
}
