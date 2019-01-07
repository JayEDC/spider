package com.xfj.spider.util.handler.crawl;

import com.xfj.spider.util.handler.base.ConstantAnjuke;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Selectable;
import java.util.List;

/**
 * 经纪人具体信息页，需要获取并保存信息
 *
 * @author Lao SiCheng
 * @version 0.1
 */
public class AgentDetailCrawl extends AbstractCrawl {

    @Override
    public boolean run(Page page) {
        // 获取url进行页面区分,判断是否经纪人信息页面
        // etc : https://zhongzhidichan11.anjuke.com/gongsi-jjr-6849737/js/
        // etc : https://zhongzhidichan11.anjuke.com/gongsi-jjr-6849737/
        // etc : https://zhongzhidichan11.anjuke.com/gongsi-jjr-6849737/zf/
        if (this.checkUrlWithKey(page, ConstantAnjuke.AGENTPAGEINFO)) {
            // 获取共同信息，并判断信息是否存在
            if (this.getAgentBaseInfo(page)) {
                //进行页面区分
                if (this.checkUrlWithKey(page, ConstantAnjuke.ZUFANG)) {
                    // 获取租房信息
                    // todo
                } else if (this.checkUrlWithKey(page, ConstantAnjuke.AGENTINFO)) {
                    // 获取经纪人个人信息
                    this.getAgentInfoDetail(page);

                } else {
                    // 获取二手房信息
                    // 获取公司名字  //*[@id="shop-content"]/div[2]/div[2]/div/div[1]/dl[1]/dd/p[1]/a
                    String company = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[2]/div/div[1]/dl[1]/dd/p[1]/a/text()").get();
                    if(company == null){
                        company = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[2]/div/div[1]/dl[1]/dd/p/text()").get();
                    }
                    // 获取租房和个人信息页面链接

                    // 获取tab的所有链接，包括二手房，租房，个人信息，问答，参考具体页面
                    //List<String> listLinks = page.getHtml().xpath("/html/body/div[5]").links().all();

                    // 获取下一页链接
                    List<String> nextPageLinks = page.getHtml().css(".multi-page .aNxt").links().all();
                    page.addTargetRequests(nextPageLinks);

                    // 获取二手房链接，保存并加入下载队列
                    // 先做保存
                    List<String> listResoldLinks = page.getHtml().xpath("//*[@id=\"houselist-mod\"]").css(".house-title").links().all();
                    //page.getHtml().xpath("//*[@id=\"houselist-mod\"]").css(".house-title nth-child(1)").links().all();
                    // 保存信息
                    page.putField("company",company);

                    page.putField("listResoldLinks",listResoldLinks);
                    //page.addTargetRequests(listLinks);
                    // 设置保存信息
                    page.putField(ConstantAnjuke.PIPEKEY, ConstantAnjuke.RESOLD);


                }
                return true;
            }
            //按标签进行页面信息获取


        }
        return false;
    }

    private Boolean getAgentBaseInfo(Page page) {
        // 页面共同信息
        // 包括电话和姓名
        String telephone = page.getHtml().xpath("//*[@id=\"broker-nav-phone\"]/span/text()").get();

        if (telephone != null) {
            //对电话信息进行字符处理
            telephone = telephone.replace(" ", "");
            page.putField("telephone", telephone);
            //获取姓名，去掉（xxx的店铺）店铺字眼
            Selectable mainInfoPage = page.getHtml().css(".firstline");
            String name = mainInfoPage.css(".hd", "text").replace("的店铺", "").get();
            page.putField("name", name);
            return true;
        }
        return false;

    }

    private void getAgentResoldDetail(Page page) {

    }

    private void getAgentRentDetail(Page page) {

    }

    private void getAgentInfoDetail(Page page) {

        String photo = page.getHtml().css(".portrait").css("img", "src").get();
        //List<String> photoList =page.getHtml().xpath("/html/body/div[2]/div[2]/a/img").links().all();

        String company = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]/div[3]").css(".item-content").css("a", "text").get();

        // 店铺 ， 主营区域 ， 主营小区
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

        //获取工作年限
        String workDay = page.getHtml().xpath("//*[@id=\"shop-content\"]/div[2]/div[1]/div[3]/div[3]/span/text()").get();

        //保存数据
        page.putField("photo", photo);
        page.putField("company", company);
        page.putField("mainArea", mainArea);
        page.putField("mainCommunity", mainCommunity);
        page.putField("city", city);
        page.putField("workDay", workDay);
        page.putField("url", url);
        // 设置进行pipeline经纪人信息保存
        page.putField(ConstantAnjuke.PIPEKEY, ConstantAnjuke.AGENTINFO);


    }
}
