package com.xfj.spider.util.handler.crawl;

import com.xfj.spider.util.handler.base.ConstantFangTianXia;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FangZhiShiCrawl
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/72:46 PM
 * @return 1.0
 **/
public class FangZhiShiCrawl extends AbstractCrawl {

    @Override
    public boolean run(Page page) {

        if(this.checkUrlWithKey(page, ConstantFangTianXia.ZHISHI)){
            /**
             * 判断在房天下知识板块下
             */
            if(page.getHtml().css(".head_details a","text").all().toString().trim().contains("房天下知识")){
                /**
                 * 获取一级标题的所有 url 地址
                 */
                List<String> linksTitle = page.getHtml().css(".paixu").links().all();
                page.addTargetRequests(linksTitle);
                /**
                 * 获取二级标题的所有 url 地址
                 */
                List<String> linksSubTitle = page.getHtml().css(".nav li ul").links().all();
                page.addTargetRequests(linksSubTitle);

                /**
                 * 获取文章分页link
                 */
                List<String> linksNext = page.getHtml().css(".news-page .next").links().all();

                page.addTargetRequests(linksNext);

                /**
                 * 获取所有文章的url 地址
                 */
                List<String> linksText = page.getHtml().css(".clearfix .list-right h3").css("a").links().all();
                List<String> linksTextTrim = new ArrayList<>();
                for (int i = 0;i<linksText.size();i++){
                    if(!linksText.get(i).equals("")){
                        linksTextTrim.add(linksText.get(i));
                    }
                }
                page.addTargetRequests(linksTextTrim);
            }
            System.out.println("========================="+page.getHtml().css(".head_details span","text").all().toString()+"==================");
            System.out.println("========================="+page.getTargetRequests().size()+"==================");
            if(this.checkUrlWithKey(page,"qg_")){
                /**
                 * 获取文章类型
                 */
                String type = strip(page.getHtml().css(".details_mt .head_details").css("a","text").all().toString().trim()) + strip(page.getHtml().css(".details_mt .head_details").css("em","text").all().toString().trim());
                page.putField("type",type);
                /**
                 * 获取文章标题
                 */
                String title = page.getHtml().css(".essay_title","text").all().toString().trim();
                page.putField("title",strip(title));
                /**
                 * 获取文章发布时间
                 */
                String time = page.getHtml().css(".time","text").all().toString().trim();
                page.putField("time",strip(time));
                /**
                 * 获取文章来源
                 */
                String source =  page.getHtml().css(".essay_laiyuan","text").all().toString().trim();
                page.putField("source",strip(source));
                /**
                 * 获取文章浏览量
                 */
                String pageView = page.getHtml().css(".essay_view","text").all().toString().trim();
                page.putField("pageView",strip(pageView));
                /**
                 * 获取文章摘要
                 */
                String abstractText = page.getHtml().css(".essay_abstract p","text").all().toString().trim();
                page.putField("abstractText",strip(abstractText));
                /**
                 * 获取文章正文list
                 */
                List<Selectable> list= page.getHtml().css(".essay_zw").css("p").nodes();
                /**
                 * 正文
                 */
                StringBuffer textPart = new StringBuffer();
                for (int i=0;i<list.size();i++){
                    /**
                     * 判断P标签中的内容（图片、段落）
                     */
                    if(list.get(i).css("p","text").toString().equals("")){

                        if(list.get(i).css("img","src").all().size()!=0){
                            if(!list.get(i).css("img","src").toString().equals("")){
                                textPart.append("https:"+list.get(i).css("img","src").toString());
                            }
                        }else if(list.get(i).css("strong","text").all().size()!=0){
                            if(!list.get(i).css("strong","text").toString().equals("")){
                                textPart.append(list.get(i).css("strong","text").toString());
                            }
                        }
                    }
                    textPart.append(list.get(i).css("p","text").toString());
                }

                page.putField("text",strip(textPart.toString()));
                /**
                 * 获取文章正文Html
                 */
                String htmlText = page.getHtml().css(".essay_zw").all().toString();
                page.putField("htmlText",strip(htmlText));
                /**
                 * 获取文章标签
                 */
                String tag = page.getHtml().css(".wordsBox a","text").all().toString().trim();
                page.putField("tag",strip(tag));
                page.putField("url",page.getUrl().toString());
                page.putField("pm_id",1);
                page.putField(ConstantFangTianXia.PIPEKEY,ConstantFangTianXia.ZS);
                return true;
            }
        }
        return false;
    }

    private String strip(String val){
        if(val != null){
            return StringUtils.strip(val,"[]");
        }
        return  val;
    }

}
