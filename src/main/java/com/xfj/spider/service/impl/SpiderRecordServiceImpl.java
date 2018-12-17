package com.xfj.spider.service.impl;

import com.xfj.spider.cache.IPDataCache;
import com.xfj.spider.common.Constant;
import com.xfj.spider.model.EsfToolsSpiderProxyIp;
import com.xfj.spider.service.SpiderRecordService;
import com.xfj.spider.util.HttpUtil;
import com.xfj.spider.util.IpUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.xfj.spider.cache.IPDataCache.esfToolsSpiderProxyIpMapper;

/**
 * @ClassName SpiderRecordServiceImpl
 * @Description //TODO
 * @Author xnc
 * @Date 2018/12/43:31 PM
 * @return 1.0
 **/
@Service
public class SpiderRecordServiceImpl implements SpiderRecordService {

    Logger logger = LoggerFactory.getLogger(SpiderRecordServiceImpl.class);

    @Override
    public void loadProxyIp() {

        try {
            List<String> list = new ArrayList<>();
            for(int x = 0;x<1;x++){
                Thread.sleep(6000);
                //String str = HttpUtil.getData(Constant.GET_PROXY_IP_URL);
                String str = "{\"code\":200,\"msg\":\"\",\"data\":[{\"ip\":\"114.226.63.245\",\"port\":23564,\"expire_time\":\"2018-12-17 09:37:14\",\"city\":\"江苏 常州\",\"isp\":\"电信\"},{\"ip\":\"175.167.22.86\",\"port\":5412,\"expire_time\":\"2018-12-17 09:27:28\",\"city\":\"辽宁 鞍山\",\"isp\":\"联通\"},{\"ip\":\"125.117.133.63\",\"port\":894,\"expire_time\":\"2018-12-17 09:31:56\",\"city\":\"浙江 金华\",\"isp\":\"电信\"},{\"ip\":\"106.59.35.197\",\"port\":36410,\"expire_time\":\"2018-12-17 09:31:07\",\"city\":\"云南 文山壮族苗族自治州\",\"isp\":\"电信\"},{\"ip\":\"59.63.67.234\",\"port\":36410,\"expire_time\":\"2018-12-17 09:32:40\",\"city\":\"江西 景德镇\",\"isp\":\"电信\"},{\"ip\":\"115.213.225.245\",\"port\":23564,\"expire_time\":\"2018-12-17 09:31:34\",\"city\":\"浙江 丽水\",\"isp\":\"电信\"},{\"ip\":\"106.57.157.154\",\"port\":36410,\"expire_time\":\"2018-12-17 09:36:54\",\"city\":\"云南 大理白族自治州\",\"isp\":\"电信\"},{\"ip\":\"112.113.155.122\",\"port\":766,\"expire_time\":\"2018-12-17 09:21:43\",\"city\":\"云南 保山\",\"isp\":\"电信\"},{\"ip\":\"116.55.179.168\",\"port\":5412,\"expire_time\":\"2018-12-17 09:36:48\",\"city\":\"云南 西双版纳傣族自治州\",\"isp\":\"电信\"},{\"ip\":\"116.55.78.119\",\"port\":3617,\"expire_time\":\"2018-12-17 09:36:29\",\"city\":\"云南 丽江\",\"isp\":\"电信\"},{\"ip\":\"125.87.98.179\",\"port\":3617,\"expire_time\":\"2018-12-17 09:36:26\",\"city\":\"重庆 重庆\",\"isp\":\"电信\"},{\"ip\":\"183.165.29.33\",\"port\":3617,\"expire_time\":\"2018-12-17 09:36:49\",\"city\":\"安徽 宣城\",\"isp\":\"电信\"},{\"ip\":\"115.211.37.237\",\"port\":3617,\"expire_time\":\"2018-12-17 09:21:25\",\"city\":\"浙江 金华\",\"isp\":\"电信\"},{\"ip\":\"223.243.204.92\",\"port\":894,\"expire_time\":\"2018-12-17 09:21:08\",\"city\":\"安徽 蚌埠\",\"isp\":\"电信\"},{\"ip\":\"112.117.45.214\",\"port\":5412,\"expire_time\":\"2018-12-17 09:36:52\",\"city\":\"云南 昆明\",\"isp\":\"电信\"},{\"ip\":\"124.135.99.129\",\"port\":766,\"expire_time\":\"2018-12-17 09:29:08\",\"city\":\"山东 枣庄\",\"isp\":\"联通\"},{\"ip\":\"111.77.20.4\",\"port\":3617,\"expire_time\":\"2018-12-17 09:31:38\",\"city\":\"江西 九江\",\"isp\":\"电信\"},{\"ip\":\"106.56.79.253\",\"port\":36410,\"expire_time\":\"2018-12-17 09:26:51\",\"city\":\"云南 玉溪\",\"isp\":\"电信\"},{\"ip\":\"114.231.68.136\",\"port\":36410,\"expire_time\":\"2018-12-17 09:26:10\",\"city\":\"江苏 南通\",\"isp\":\"电信\"},{\"ip\":\"60.161.179.196\",\"port\":36410,\"expire_time\":\"2018-12-17 09:26:12\",\"city\":\"云南 临沧\",\"isp\":\"电信\"},{\"ip\":\"114.96.97.188\",\"port\":23564,\"expire_time\":\"2018-12-17 09:31:25\",\"city\":\"安徽 六安\",\"isp\":\"电信\"},{\"ip\":\"113.229.173.32\",\"port\":894,\"expire_time\":\"2018-12-17 09:22:08\",\"city\":\"辽宁 鞍山\",\"isp\":\"联通\"},{\"ip\":\"123.133.196.135\",\"port\":23564,\"expire_time\":\"2018-12-17 09:41:31\",\"city\":\"山东 菏泽\",\"isp\":\"联通\"},{\"ip\":\"106.57.150.39\",\"port\":23564,\"expire_time\":\"2018-12-17 09:41:49\",\"city\":\"云南 大理白族自治州\",\"isp\":\"电信\"},{\"ip\":\"182.247.181.163\",\"port\":23564,\"expire_time\":\"2018-12-17 09:31:43\",\"city\":\"云南 丽江\",\"isp\":\"电信\"},{\"ip\":\"59.63.75.26\",\"port\":894,\"expire_time\":\"2018-12-17 09:38:10\",\"city\":\"江西 景德镇\",\"isp\":\"电信\"},{\"ip\":\"121.230.252.211\",\"port\":23564,\"expire_time\":\"2018-12-17 09:41:11\",\"city\":\"江苏 泰州\",\"isp\":\"电信\"},{\"ip\":\"117.68.80.44\",\"port\":23564,\"expire_time\":\"2018-12-17 09:41:41\",\"city\":\"安徽 六安\",\"isp\":\"电信\"},{\"ip\":\"116.248.186.219\",\"port\":766,\"expire_time\":\"2018-12-17 09:31:37\",\"city\":\"云南 迪庆藏族自治州\",\"isp\":\"电信\"},{\"ip\":\"116.53.238.208\",\"port\":5412,\"expire_time\":\"2018-12-17 09:21:33\",\"city\":\"云南 昆明\",\"isp\":\"电信\"},{\"ip\":\"114.104.17.166\",\"port\":766,\"expire_time\":\"2018-12-17 09:31:19\",\"city\":\"安徽 六安\",\"isp\":\"电信\"},{\"ip\":\"182.87.242.116\",\"port\":766,\"expire_time\":\"2018-12-17 09:21:07\",\"city\":\"江西 上饶\",\"isp\":\"电信\"},{\"ip\":\"220.180.5.127\",\"port\":36410,\"expire_time\":\"2018-12-17 09:32:00\",\"city\":\"安徽 六安\",\"isp\":\"电信\"},{\"ip\":\"114.225.170.236\",\"port\":36410,\"expire_time\":\"2018-12-17 09:23:57\",\"city\":\"江苏 无锡\",\"isp\":\"电信\"},{\"ip\":\"123.134.231.165\",\"port\":894,\"expire_time\":\"2018-12-17 09:22:55\",\"city\":\"山东 莱芜\",\"isp\":\"联通\"},{\"ip\":\"175.147.97.86\",\"port\":23564,\"expire_time\":\"2018-12-17 09:41:08\",\"city\":\"辽宁 鞍山\",\"isp\":\"联通\"},{\"ip\":\"114.99.5.72\",\"port\":766,\"expire_time\":\"2018-12-17 09:21:39\",\"city\":\"安徽 铜陵\",\"isp\":\"电信\"},{\"ip\":\"114.103.136.71\",\"port\":5412,\"expire_time\":\"2018-12-17 09:36:55\",\"city\":\"安徽 宣城\",\"isp\":\"电信\"},{\"ip\":\"218.63.190.51\",\"port\":36410,\"expire_time\":\"2018-12-17 09:21:34\",\"city\":\"云南 大理白族自治州\",\"isp\":\"电信\"},{\"ip\":\"59.62.105.35\",\"port\":23564,\"expire_time\":\"2018-12-17 09:36:23\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"},{\"ip\":\"117.85.80.174\",\"port\":36410,\"expire_time\":\"2018-12-17 09:38:20\",\"city\":\"江苏 无锡\",\"isp\":\"电信\"},{\"ip\":\"59.62.105.22\",\"port\":766,\"expire_time\":\"2018-12-17 09:41:20\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"},{\"ip\":\"112.113.154.2\",\"port\":23564,\"expire_time\":\"2018-12-17 09:32:34\",\"city\":\"云南 保山\",\"isp\":\"电信\"},{\"ip\":\"117.90.252.163\",\"port\":5412,\"expire_time\":\"2018-12-17 09:27:58\",\"city\":\"江苏 镇江\",\"isp\":\"电信\"},{\"ip\":\"116.55.180.117\",\"port\":23564,\"expire_time\":\"2018-12-17 09:41:35\",\"city\":\"云南 西双版纳傣族自治州\",\"isp\":\"电信\"},{\"ip\":\"112.117.45.182\",\"port\":766,\"expire_time\":\"2018-12-17 09:32:14\",\"city\":\"云南 昆明\",\"isp\":\"电信\"},{\"ip\":\"59.54.124.86\",\"port\":5412,\"expire_time\":\"2018-12-17 09:36:34\",\"city\":\"江西 九江\",\"isp\":\"电信\"},{\"ip\":\"49.87.135.189\",\"port\":3617,\"expire_time\":\"2018-12-17 09:31:06\",\"city\":\"江苏 淮安\",\"isp\":\"电信\"},{\"ip\":\"116.248.186.16\",\"port\":36410,\"expire_time\":\"2018-12-17 09:41:24\",\"city\":\"云南 迪庆藏族自治州\",\"isp\":\"电信\"},{\"ip\":\"42.243.3.73\",\"port\":3617,\"expire_time\":\"2018-12-17 09:32:08\",\"city\":\"云南 昆明\",\"isp\":\"电信\"}]}";
                list.add(str);
                logger.info("当前获取代理数量-------"+list.size());
            }

            for(int j =0;j<list.size();j++){
                JSONObject object = new JSONObject(list.get(j));
                JSONArray proxyList = (JSONArray) object.get("data");
                for(int i=0;i< proxyList.length();i++) {

                    JSONObject o = (JSONObject) proxyList.get(i);
                    String proxyIp = o.get("ip").toString();
                    Integer port = (Integer) o.get("port");

                    EsfToolsSpiderProxyIp spiderProxyIp = new EsfToolsSpiderProxyIp();
                    spiderProxyIp.setIpAddr(proxyIp);
                    spiderProxyIp.setIpPort(port);
                    logger.info("【"+spiderProxyIp.getIpAddr()+":"+spiderProxyIp.getIpPort()+"-----城市--"+o.get("city")+"】（快代理）"+"总数："+proxyList.length()+","+"当前数："+i);
                    IpUtil.checkIp(spiderProxyIp);
                }
            }

        }catch(Exception e){
            logger.error("加载代理IP至缓存发生异常："+e.getMessage());
        }
        /*try {
            String str = HttpUtil.getData(Constant.GET_PROXY_IP_URL);
            JSONObject object = new JSONObject(str);
            JSONObject data = object.getJSONObject("data");
            JSONArray proxyList = data.getJSONArray("proxy_list");

            for(int i=0;i< proxyList.length();i++) {

                String proxyIp = (String) proxyList.get(i);
                String ipAddress = proxyIp.split(":")[0];
                Integer port = Integer.parseInt(proxyIp.split(":")[1]);

                EsfToolsSpiderProxyIp spiderProxyIp = new EsfToolsSpiderProxyIp();
                spiderProxyIp.setIpAddr(ipAddress);
                spiderProxyIp.setIpPort(port);
                IpUtil.checkIp(spiderProxyIp);
                logger.info("【"+spiderProxyIp.getIpAddr()+":"+spiderProxyIp.getIpPort()+"】（快代理）"+"总数："+proxyList.length()+","+"当前数："+i);
            }

        }catch(Exception e){
            logger.error("加载代理IP至缓存发生异常："+e.getMessage());
        }*/
    }

    @Override
    public void loadLocalProxyIp() {

        try {
            IPDataCache.proxyIpCache.clear();
            IPDataCache.proxyIpCacheforShort58.clear();
            IPDataCache.proxyIpCacheforJump58.clear();
            IPDataCache.proxyIpCacheforZh58.clear();
            List<EsfToolsSpiderProxyIp> list = esfToolsSpiderProxyIpMapper.getFastProxyIpAll();
            int i= 0;
            for(EsfToolsSpiderProxyIp spiderProxyIp : list) {
                i++;
                logger.info("【"+spiderProxyIp.getIpAddr()+":"+spiderProxyIp.getIpPort()+"】（本地）"+"总数："+list.size()+","+"当前数："+i);
                IpUtil.checkIp(spiderProxyIp);
            }

        }catch(Exception e){
            logger.error("加载本地IP至缓存发生异常："+e.getMessage());
        }
    }



}
