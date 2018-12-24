package com.xfj.spider.util.handler.crawl;

import com.xfj.spider.util.handler.base.ConstantAnjuke;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * 经纪人具体信息页，需要获取并保存信息
 * @author Lao SiCheng
 * @version 0.1
 */
public class AgentDetailCrawl extends AbstractCrawl {

    @Override
    public boolean run(Page page) {
        // 获取url进行页面区分

        if(this.checkUrlWithKey(page, ConstantAnjuke.AGENTPAGEINFO)){
            //进行页面区分
            if(this.checkUrlWithKey(page, ConstantAnjuke.ZUFANG)){
                // 获取租房信息
                // todo
            } else if(this.checkUrlWithKey(page, ConstantAnjuke.AGENTINFO)){
                // 获取经纪人个人信息
                this.getAgentInfoDetail(page);


            } else {
                // 获取二手房信息
                // todo
                // 获取租房和个人信息页面链接
                String telephone =page.getHtml().xpath("//*[@id=\"broker-nav-phone\"]/span/text()").get();

                if(telephone != null) {
                    // 获取tab的所有链接，包括二手房，租房，个人信息，问答，参考具体页面
                    List<String> listLinks = page.getHtml().xpath("/html/body/div[5]").links().all();

                    // 获取下一页链接
                    List<String> nextPageLinks = page.getHtml().css(".multi-page .aNxt").links().all();
                    page.addTargetRequests(nextPageLinks);

                    // 获取二手房链接，保存并加入下载队列
                    // 先做保存
                    //List<String> listResoldLinks = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]").links().all();
                    //page.addTargetRequests(listLinks);
                    this.getAgentResoldDetail(page);
                }
            }
            //按标签进行页面信息获取

            return true;

        }
        return false;
    }
    public void getAgentBaseInfo(Page page){
        // 页面共同信息
        //String telephone =page.getHtml().xpath("//*[@id=\"broker-nav-phone\"]/span/text()").get();


    }
    public void getAgentResoldDetail(Page page){
        //  进一步判断
        String telephone =page.getHtml().xpath("//*[@id=\"broker-nav-phone\"]/span/text()").get();

        if(telephone != null) {

        }
    }
    public void getAgentRentDetail(Page page){

    }
    public void getAgentInfoDetail(Page page){
        // 进一步判断
        String telephone =page.getHtml().xpath("//*[@id=\"broker-nav-phone\"]/span/text()").get();

        if(telephone != null){

            telephone = telephone.replace(" ", "");


            String photo = page.getHtml().css(".portrait").css("img", "src").get();
            //List<String> photoList =page.getHtml().xpath("/html/body/div[2]/div[2]/a/img").links().all();

            String company = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]/div[3]").css(".item-content").css("a", "text").get();

            // 店铺 ， 主营区域 ， 主营小区
            Selectable mainInfoPage = page.getHtml().css(".firstline");
            String name = mainInfoPage.css(".hd", "text").replace("的店铺", "").get();
            String mainArea = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]/div[3]/div[4]/p/a/text()").get();

            // <br> 分割多个小区
            // 去掉换行符
            // 去掉Html标签
            String mainCommunity = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]/div[3]/div[5]")
                    .replace("<br>", " - ")
                    .replace("\\n", "")
                    .replace("<[^>]*>", "").get();
            // 城市
            String city = page.getHtml().xpath("//*[@id='switch_apf_id_5']/text()").get();
            city = (city == null ? "" : city.trim());

            // 个人信息链接
            String url = page.getUrl().get();

            //
            String workDay = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]/div[3]/div[3]/span/text()").get();


            page.putField("telephone", telephone);
            page.putField("photo", photo);
            page.putField("company", company);
            page.putField("name", name);
            page.putField("mainArea", mainArea);
            page.putField("mainCommunity", mainCommunity);
            page.putField("city", city);
            page.putField("workDay",workDay);
            page.putField("url", url);
            // 设置进行pipeline经纪人信息保存
            page.putField(ConstantAnjuke.PIPEKEY, ConstantAnjuke.AGENTINFO);
        }
    }
}
