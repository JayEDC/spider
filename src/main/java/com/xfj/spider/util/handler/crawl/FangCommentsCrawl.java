package com.xfj.spider.util.handler.crawl;

import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.util.handler.base.ConstantFangTianXia;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * @ClassName FangCommentsCrawl
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/109:42 AM
 * @return 1.0
 **/
public class FangCommentsCrawl extends AbstractCrawl{
    @Override
    public boolean run(Page page) {

        if(this.checkUrlWithKey(page, ConstantFangTianXia.ASK)){

            /**
             * 获取问答分类
             */
            List<String> listQuestion = page.getHtml().css(".sec-menu").css(".pop-trade dd").links().all();
            page.addTargetRequests(listQuestion);
            /**
             * 获取业主生活
             */
            List<String> listLife = page.getHtml().css(".sec-menu").css(".pop-life").links().all();
            page.addTargetRequests(listLife);

            if(this.checkUrlWithKey(page, ConstantFangTianXia.CLASS)){
                /**
                 * 获取问题 url
                 */
                page.addTargetRequests(page.getHtml().css(".question-list").css(".question-item h3").links().all());

                /**
                 * 获取下一页url
                 */
                page.addTargetRequests(page.getHtml().css(".pagebar-right").css("a").links().all());
            }
            if(page.getHtml().css(".breadcrum").all().toString().contains("问题详情")){
                page.addTargetRequests(page.getHtml().css(".pagebar-right").links().all());
                /**
                 * 获取问题类型
                 */
                String type = page.getHtml().css(".breadcrum").css("a","text").all().toString();
                page.putField("type",type);

                /**
                 * 获取问题标题
                 */
                String title = page.getHtml().css(".questionTit","text").get();
                page.putField("title",title);

                /**
                 * 获取问题发起人信息
                 */
                String userName = page.getHtml().css(".question-from").css(".ans-name","text").get();
                page.putField("user",userName);

                /**
                 * 获取发布时间
                 */
                List<String> timeList = page.getHtml().css(".question-from").css("span","text").all();
                String time = "";
                if(timeList.size()>0){
                    time = timeList.get(2);
                }
                page.putField("time",time);
                /**
                 * 获取浏览次数
                 */
                String view = page.getHtml().css(".question-from").css("em","text").get();

                if(view == null){

                }

                page.putField("view",view);

                /**
                 * 获取标签
                 */
                String tag = page.getHtml().css(".tag-item a","text").all().toString();
                page.putField("tag",tag);
                page.putField("url",page.getUrl());


                /**
                 * 评论
                 */
                List<List<ReplyComments>> replyCommentList = new ArrayList<>();

                List<ReplyComments> replyComments = new ArrayList<>();

                Selectable comments = page.getHtml().css(".Ans_list").css(".Ans-area:not(div[id])");

                /**
                 * 获取评论用户头像
                 */
                List<String> photoList = comments.css(".Ans-img a img","src").all();

                /**
                 * 获取评论用户姓名
                 */
                List<String> userNameList= comments.css(".ans-name","text").all();
                /**
                 * 获取所有评论 id
                 */
                List<String> commentId = comments.css(".comment-list","id").all();
                /**
                 * 获取评论内容
                 */
                List<String> userCountList = comments.css(".Ans-text .Ans-text-part","text").all();
                List<String> userTimeList = comments.css(".ansTime","text").all();
                Map<String,ReplyComments> userCountMap = new HashMap<>();
                for (int j=0;j<userCountList.size();j++){
                    ReplyComments comment = new ReplyComments();
                    comment.setCommentsUserName(userNameList.get(j));
                    comment.setCommentsTime(userTimeList.get(j));
                    comment.setCommentsContent(userCountList.get(j));
                    userCountMap.put(commentId.get(j),comment);
                }
                page.putField("userCountMap",userCountMap);
                /**
                 * 获取评论数量
                 */
                List<String> list = comments.css(".com_agree em","text").all();
                Map<String,List<ReplyComments>> commentMap = new HashMap<>();
                for (int i=0;i<commentId.size();i++){
                    int count = parseInt(list.get(i));
                    if(count!=0){
                        String id = commentId.get(i);
                        List<String> commTimeList = comments.css("#"+id).css(".comment-box .comment-item .user-info span:last-child","text").all();
                        List<String> commCount = comments.css("#"+id).css(".comment-box .comment-item .comment-cont","text").all();
                        List<String> commNameList = comments.css("#"+id).css(".comment-box .comment-item .user-info a","text").all();
                        List<ReplyComments> replyCommentsList = new ArrayList<>();
                        for(int k=0;k<commCount.size();k++){
                            ReplyComments comment = new ReplyComments();
                            comment.setCommentsUserName(commNameList.get(k));
                            comment.setCommentsTime(commTimeList.get(k));
                            comment.setCommentsContent(commCount.get(k));
                            replyCommentsList.add(comment);
                        }

                        commentMap.put(id,replyCommentsList);
                    }
                }
                page.putField("commentMap",commentMap);
                page.putField(ConstantFangTianXia.COMMENTS,ConstantFangTianXia.COMMENTS);
                page.putField(ConstantFangTianXia.QUESTIONPIPEKEY,ConstantFangTianXia.QUESTIONPIPEKEY);

                return true;
            }

        }

        return false;
    }
}
