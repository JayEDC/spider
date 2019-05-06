package com.xfj.spider.util.handler.crawl;

import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.util.HttpClientUtil;
import com.xfj.spider.util.handler.base.ConstantFangTianXia;
import net.sf.json.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.xfj.spider.util.HttpClientUtil.doGet;
import static java.lang.Integer.parseInt;

/**
 * @ClassName FangQuestionCrawl
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/95:17 PM
 * @return 1.0
 **/
public class FangQuestionCrawl extends AbstractCrawl{

    private List<String> url;

    public FangQuestionCrawl( List<String> url){
        this.url = url;
    }

    @Override
    public boolean run(Page page) {
        if(this.checkUrlWithKey(page, ConstantFangTianXia.ASK)){
            List<String> links = page.getHtml().css(".f17").links().all();
            page.addTargetRequests(links);
            page.addTargetRequests(url);

            if(page.getHtml().css(".breadcrum").all().toString().contains("问题详情")){

                /**
                 * 获取问题类型
                 */
                String type = page.getHtml().css(".breadcrum").css("a","text").all().toString();
                page.putField("type",type);

                /**
                 * 获取问题标题
                 */
                String title = page.getHtml().css(".intro-part","text").get();
                /*//如果没有标题，或者没有评论就跳过
                if(page.getHtml().css(".Ans_list").css(".Ans-area:not(div[id])").all().size() == 0){
                    return false;
                }*/
                //判断标题在那个地方
                /*if(page.getHtml().css(".questionIntro").get() == null ){*/
                String titles = page.getHtml().css(".questionTit").replace("\n","").replace("<span.*span>","").replace("<[^>]*>","").get();
                page.putField("title",titles);
                if(titles.indexOf("来自")!= -1){
                    String city = titles.substring(titles.indexOf("来自"),titles.indexOf("来自")+4);
                    page.putField("city",city);
                }

                    /*}else {
                    page.putField("title",title);
                }*/

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

                if(view != null){
                    page.putField("view",view);
                }

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
                page.putField("URL",page.getUrl().get());
                return true;
            }

        }
        return  false;
    }



}
