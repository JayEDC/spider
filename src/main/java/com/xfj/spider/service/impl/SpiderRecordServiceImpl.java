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
                String str = "{\"code\":200,\"msg\":\"\",\"data\":[{\"ip\":\"122.243.9.251\",\"port\":894,\"expire_time\":\"2018-12-17 17:46:19\",\"city\":\"浙江 金华\",\"isp\":\"电信\"},{\"ip\":\"116.248.187.79\",\"port\":23564,\"expire_time\":\"2018-12-17 17:26:04\",\"city\":\"云南 迪庆藏族自治州\",\"isp\":\"电信\"},{\"ip\":\"106.56.78.226\",\"port\":36410,\"expire_time\":\"2018-12-17 17:31:36\",\"city\":\"云南 玉溪\",\"isp\":\"电信\"},{\"ip\":\"117.94.0.192\",\"port\":36410,\"expire_time\":\"2018-12-17 17:26:36\",\"city\":\"江苏 泰州\",\"isp\":\"电信\"},{\"ip\":\"60.185.66.165\",\"port\":894,\"expire_time\":\"2018-12-17 17:37:07\",\"city\":\"浙江 衢州\",\"isp\":\"电信\"},{\"ip\":\"114.99.0.71\",\"port\":23564,\"expire_time\":\"2018-12-17 17:36:26\",\"city\":\"安徽 铜陵\",\"isp\":\"电信\"},{\"ip\":\"112.113.68.186\",\"port\":36410,\"expire_time\":\"2018-12-17 17:36:13\",\"city\":\"云南 德宏傣族景颇族自治州\",\"isp\":\"电信\"},{\"ip\":\"123.188.101.107\",\"port\":23564,\"expire_time\":\"2018-12-17 17:42:23\",\"city\":\"辽宁 抚顺\",\"isp\":\"联通\"},{\"ip\":\"115.153.166.199\",\"port\":3617,\"expire_time\":\"2018-12-17 17:28:08\",\"city\":\"江西 萍乡\",\"isp\":\"电信\"},{\"ip\":\"125.87.111.207\",\"port\":3617,\"expire_time\":\"2018-12-17 17:26:35\",\"city\":\"重庆 重庆\",\"isp\":\"电信\"},{\"ip\":\"182.247.61.36\",\"port\":766,\"expire_time\":\"2018-12-17 17:41:37\",\"city\":\"云南 文山壮族苗族自治州\",\"isp\":\"电信\"},{\"ip\":\"116.248.186.134\",\"port\":894,\"expire_time\":\"2018-12-17 17:36:46\",\"city\":\"云南 迪庆藏族自治州\",\"isp\":\"电信\"},{\"ip\":\"42.243.164.58\",\"port\":766,\"expire_time\":\"2018-12-17 17:46:04\",\"city\":\"云南 玉溪\",\"isp\":\"电信\"},{\"ip\":\"27.202.35.192\",\"port\":23564,\"expire_time\":\"2018-12-17 17:22:31\",\"city\":\"山东 东营\",\"isp\":\"联通\"},{\"ip\":\"123.134.249.125\",\"port\":36410,\"expire_time\":\"2018-12-17 17:31:30\",\"city\":\"山东 莱芜\",\"isp\":\"联通\"},{\"ip\":\"117.85.80.119\",\"port\":894,\"expire_time\":\"2018-12-17 17:28:20\",\"city\":\"江苏 无锡\",\"isp\":\"电信\"},{\"ip\":\"125.87.100.76\",\"port\":766,\"expire_time\":\"2018-12-17 17:36:25\",\"city\":\"重庆 重庆\",\"isp\":\"电信\"},{\"ip\":\"180.125.83.249\",\"port\":894,\"expire_time\":\"2018-12-17 17:32:51\",\"city\":\"江苏 淮安\",\"isp\":\"电信\"},{\"ip\":\"117.68.1.72\",\"port\":3617,\"expire_time\":\"2018-12-17 17:36:34\",\"city\":\"安徽 六安\",\"isp\":\"电信\"},{\"ip\":\"218.93.84.155\",\"port\":5412,\"expire_time\":\"2018-12-17 17:36:11\",\"city\":\"江苏 常州\",\"isp\":\"电信\"},{\"ip\":\"113.231.255.81\",\"port\":36410,\"expire_time\":\"2018-12-17 17:38:56\",\"city\":\"辽宁 抚顺\",\"isp\":\"联通\"},{\"ip\":\"124.94.188.181\",\"port\":23564,\"expire_time\":\"2018-12-17 17:42:57\",\"city\":\"辽宁 辽阳\",\"isp\":\"联通\"},{\"ip\":\"114.103.136.10\",\"port\":766,\"expire_time\":\"2018-12-17 17:42:35\",\"city\":\"安徽 宣城\",\"isp\":\"电信\"},{\"ip\":\"116.248.187.240\",\"port\":23564,\"expire_time\":\"2018-12-17 17:47:08\",\"city\":\"云南 迪庆藏族自治州\",\"isp\":\"电信\"},{\"ip\":\"182.87.140.60\",\"port\":5412,\"expire_time\":\"2018-12-17 17:33:18\",\"city\":\"江西 萍乡\",\"isp\":\"电信\"},{\"ip\":\"60.18.97.210\",\"port\":23564,\"expire_time\":\"2018-12-17 17:42:06\",\"city\":\"辽宁 抚顺\",\"isp\":\"联通\"},{\"ip\":\"59.62.105.212\",\"port\":23564,\"expire_time\":\"2018-12-17 17:30:58\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"},{\"ip\":\"60.185.64.231\",\"port\":894,\"expire_time\":\"2018-12-17 17:31:30\",\"city\":\"浙江 衢州\",\"isp\":\"电信\"},{\"ip\":\"59.62.105.182\",\"port\":766,\"expire_time\":\"2018-12-17 17:26:17\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"},{\"ip\":\"117.94.183.156\",\"port\":5412,\"expire_time\":\"2018-12-17 17:41:19\",\"city\":\"江苏 泰州\",\"isp\":\"电信\"},{\"ip\":\"59.62.81.8\",\"port\":23564,\"expire_time\":\"2018-12-17 17:37:08\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"},{\"ip\":\"122.243.12.61\",\"port\":3617,\"expire_time\":\"2018-12-17 17:26:07\",\"city\":\"浙江 金华\",\"isp\":\"电信\"},{\"ip\":\"182.44.220.19\",\"port\":894,\"expire_time\":\"2018-12-17 17:44:19\",\"city\":\"山东 日照\",\"isp\":\"电信\"},{\"ip\":\"122.247.82.88\",\"port\":23564,\"expire_time\":\"2018-12-17 17:46:28\",\"city\":\"浙江 宁波\",\"isp\":\"电信\"},{\"ip\":\"114.105.173.188\",\"port\":5412,\"expire_time\":\"2018-12-17 17:41:56\",\"city\":\"安徽 亳州\",\"isp\":\"电信\"},{\"ip\":\"124.135.100.180\",\"port\":36410,\"expire_time\":\"2018-12-17 17:28:42\",\"city\":\"山东 枣庄\",\"isp\":\"联通\"},{\"ip\":\"183.150.63.49\",\"port\":894,\"expire_time\":\"2018-12-17 17:41:07\",\"city\":\"浙江 衢州\",\"isp\":\"电信\"},{\"ip\":\"117.69.239.149\",\"port\":5412,\"expire_time\":\"2018-12-17 17:22:15\",\"city\":\"安徽 淮北\",\"isp\":\"电信\"},{\"ip\":\"60.185.79.95\",\"port\":766,\"expire_time\":\"2018-12-17 17:36:53\",\"city\":\"浙江 衢州\",\"isp\":\"电信\"},{\"ip\":\"180.127.83.140\",\"port\":23564,\"expire_time\":\"2018-12-17 17:31:43\",\"city\":\"江苏 连云港\",\"isp\":\"电信\"},{\"ip\":\"117.86.22.12\",\"port\":766,\"expire_time\":\"2018-12-17 17:31:38\",\"city\":\"江苏 南通\",\"isp\":\"电信\"},{\"ip\":\"49.76.23.183\",\"port\":894,\"expire_time\":\"2018-12-17 17:44:14\",\"city\":\"江苏 无锡\",\"isp\":\"电信\"},{\"ip\":\"106.59.59.248\",\"port\":766,\"expire_time\":\"2018-12-17 17:26:35\",\"city\":\"云南 文山壮族苗族自治州\",\"isp\":\"电信\"},{\"ip\":\"106.57.6.141\",\"port\":23564,\"expire_time\":\"2018-12-17 17:26:29\",\"city\":\"云南 曲靖\",\"isp\":\"电信\"},{\"ip\":\"49.85.7.103\",\"port\":894,\"expire_time\":\"2018-12-17 17:43:39\",\"city\":\"江苏 泰州\",\"isp\":\"电信\"},{\"ip\":\"180.127.251.61\",\"port\":894,\"expire_time\":\"2018-12-17 17:26:04\",\"city\":\"江苏 连云港\",\"isp\":\"电信\"},{\"ip\":\"218.90.3.208\",\"port\":3617,\"expire_time\":\"2018-12-17 17:24:10\",\"city\":\"江苏 无锡\",\"isp\":\"电信\"},{\"ip\":\"180.127.32.169\",\"port\":23564,\"expire_time\":\"2018-12-17 17:41:10\",\"city\":\"江苏 连云港\",\"isp\":\"电信\"},{\"ip\":\"125.87.96.110\",\"port\":36410,\"expire_time\":\"2018-12-17 17:41:22\",\"city\":\"重庆 重庆\",\"isp\":\"电信\"},{\"ip\":\"42.243.3.243\",\"port\":5412,\"expire_time\":\"2018-12-17 17:36:33\",\"city\":\"云南 昆明\",\"isp\":\"电信\"},{\"ip\":\"124.94.190.52\",\"port\":23564,\"expire_time\":\"2018-12-17 17:38:08\",\"city\":\"辽宁 辽阳\",\"isp\":\"联通\"},{\"ip\":\"116.55.75.127\",\"port\":894,\"expire_time\":\"2018-12-17 17:31:26\",\"city\":\"云南 丽江\",\"isp\":\"电信\"},{\"ip\":\"182.100.237.189\",\"port\":894,\"expire_time\":\"2018-12-17 17:32:33\",\"city\":\"江西 吉安\",\"isp\":\"电信\"},{\"ip\":\"123.186.158.120\",\"port\":894,\"expire_time\":\"2018-12-17 17:27:07\",\"city\":\"辽宁 本溪\",\"isp\":\"电信\"},{\"ip\":\"182.87.241.118\",\"port\":5412,\"expire_time\":\"2018-12-17 17:46:19\",\"city\":\"江西 上饶\",\"isp\":\"电信\"},{\"ip\":\"183.164.243.133\",\"port\":3617,\"expire_time\":\"2018-12-17 17:26:14\",\"city\":\"安徽 淮北\",\"isp\":\"电信\"},{\"ip\":\"49.71.150.216\",\"port\":23564,\"expire_time\":\"2018-12-17 17:37:02\",\"city\":\"江苏 泰州\",\"isp\":\"电信\"},{\"ip\":\"113.230.89.228\",\"port\":23564,\"expire_time\":\"2018-12-17 17:38:40\",\"city\":\"辽宁 抚顺\",\"isp\":\"联通\"},{\"ip\":\"59.63.74.200\",\"port\":5412,\"expire_time\":\"2018-12-17 17:31:12\",\"city\":\"江西 景德镇\",\"isp\":\"电信\"},{\"ip\":\"115.220.45.59\",\"port\":894,\"expire_time\":\"2018-12-17 17:36:23\",\"city\":\"浙江 宁波\",\"isp\":\"电信\"},{\"ip\":\"59.62.105.28\",\"port\":5412,\"expire_time\":\"2018-12-17 17:31:09\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"},{\"ip\":\"115.219.129.26\",\"port\":894,\"expire_time\":\"2018-12-17 17:45:43\",\"city\":\"浙江 温州\",\"isp\":\"电信\"},{\"ip\":\"42.242.162.133\",\"port\":36410,\"expire_time\":\"2018-12-17 17:25:22\",\"city\":\"云南 红河哈尼族彝族自治州\",\"isp\":\"电信\"},{\"ip\":\"114.238.125.86\",\"port\":36410,\"expire_time\":\"2018-12-17 17:41:31\",\"city\":\"江苏 淮安\",\"isp\":\"电信\"},{\"ip\":\"59.47.4.153\",\"port\":23564,\"expire_time\":\"2018-12-17 17:22:29\",\"city\":\"辽宁 本溪\",\"isp\":\"电信\"},{\"ip\":\"180.116.110.107\",\"port\":36410,\"expire_time\":\"2018-12-17 17:22:11\",\"city\":\"江苏 常州\",\"isp\":\"电信\"},{\"ip\":\"59.63.67.82\",\"port\":766,\"expire_time\":\"2018-12-17 17:42:02\",\"city\":\"江西 景德镇\",\"isp\":\"电信\"},{\"ip\":\"117.57.20.150\",\"port\":894,\"expire_time\":\"2018-12-17 17:37:00\",\"city\":\"安徽 铜陵\",\"isp\":\"电信\"},{\"ip\":\"115.226.141.192\",\"port\":23564,\"expire_time\":\"2018-12-17 17:31:29\",\"city\":\"浙江 丽水\",\"isp\":\"电信\"},{\"ip\":\"60.185.78.0\",\"port\":766,\"expire_time\":\"2018-12-17 17:26:13\",\"city\":\"浙江 衢州\",\"isp\":\"电信\"},{\"ip\":\"182.247.168.124\",\"port\":36410,\"expire_time\":\"2018-12-17 17:31:31\",\"city\":\"云南 丽江\",\"isp\":\"电信\"},{\"ip\":\"183.165.28.238\",\"port\":766,\"expire_time\":\"2018-12-17 17:36:33\",\"city\":\"安徽 宣城\",\"isp\":\"电信\"},{\"ip\":\"112.117.45.177\",\"port\":23564,\"expire_time\":\"2018-12-17 17:26:41\",\"city\":\"云南 昆明\",\"isp\":\"电信\"},{\"ip\":\"182.246.159.232\",\"port\":894,\"expire_time\":\"2018-12-17 17:36:07\",\"city\":\"云南 玉溪\",\"isp\":\"电信\"},{\"ip\":\"121.236.231.71\",\"port\":23564,\"expire_time\":\"2018-12-17 17:31:56\",\"city\":\"江苏 苏州\",\"isp\":\"电信\"},{\"ip\":\"49.87.175.109\",\"port\":36410,\"expire_time\":\"2018-12-17 17:37:36\",\"city\":\"江苏 淮安\",\"isp\":\"电信\"},{\"ip\":\"222.220.128.145\",\"port\":5412,\"expire_time\":\"2018-12-17 17:36:47\",\"city\":\"云南 昭通\",\"isp\":\"电信\"},{\"ip\":\"59.32.21.168\",\"port\":766,\"expire_time\":\"2018-12-17 17:46:18\",\"city\":\"广东 河源\",\"isp\":\"电信\"},{\"ip\":\"106.56.79.95\",\"port\":23564,\"expire_time\":\"2018-12-17 17:31:18\",\"city\":\"云南 玉溪\",\"isp\":\"电信\"},{\"ip\":\"222.189.89.210\",\"port\":5412,\"expire_time\":\"2018-12-17 17:26:38\",\"city\":\"江苏 连云港\",\"isp\":\"电信\"},{\"ip\":\"114.228.202.62\",\"port\":23564,\"expire_time\":\"2018-12-17 17:36:06\",\"city\":\"江苏 常州\",\"isp\":\"电信\"},{\"ip\":\"125.87.111.143\",\"port\":3617,\"expire_time\":\"2018-12-17 17:26:38\",\"city\":\"重庆 重庆\",\"isp\":\"电信\"},{\"ip\":\"114.105.170.108\",\"port\":5412,\"expire_time\":\"2018-12-17 17:41:50\",\"city\":\"安徽 亳州\",\"isp\":\"电信\"},{\"ip\":\"112.245.252.11\",\"port\":5412,\"expire_time\":\"2018-12-17 17:46:23\",\"city\":\"山东 滨州\",\"isp\":\"联通\"},{\"ip\":\"106.57.150.23\",\"port\":23564,\"expire_time\":\"2018-12-17 17:31:10\",\"city\":\"云南 大理白族自治州\",\"isp\":\"电信\"},{\"ip\":\"106.57.6.172\",\"port\":23564,\"expire_time\":\"2018-12-17 17:27:08\",\"city\":\"云南 曲靖\",\"isp\":\"电信\"},{\"ip\":\"116.248.187.202\",\"port\":894,\"expire_time\":\"2018-12-17 17:46:32\",\"city\":\"云南 迪庆藏族自治州\",\"isp\":\"电信\"},{\"ip\":\"112.113.68.155\",\"port\":5412,\"expire_time\":\"2018-12-17 17:32:05\",\"city\":\"云南 德宏傣族景颇族自治州\",\"isp\":\"电信\"},{\"ip\":\"123.133.116.162\",\"port\":5412,\"expire_time\":\"2018-12-17 17:27:06\",\"city\":\"山东 潍坊\",\"isp\":\"联通\"},{\"ip\":\"116.55.184.78\",\"port\":894,\"expire_time\":\"2018-12-17 17:31:07\",\"city\":\"云南 西双版纳傣族自治州\",\"isp\":\"电信\"},{\"ip\":\"112.243.203.162\",\"port\":5412,\"expire_time\":\"2018-12-17 17:41:07\",\"city\":\"山东 潍坊\",\"isp\":\"联通\"},{\"ip\":\"223.241.178.247\",\"port\":3617,\"expire_time\":\"2018-12-17 17:36:05\",\"city\":\"安徽 马鞍山\",\"isp\":\"电信\"},{\"ip\":\"42.54.80.219\",\"port\":766,\"expire_time\":\"2018-12-17 17:46:33\",\"city\":\"辽宁 鞍山\",\"isp\":\"联通\"},{\"ip\":\"180.107.213.225\",\"port\":766,\"expire_time\":\"2018-12-17 17:31:17\",\"city\":\"江苏 苏州\",\"isp\":\"电信\"},{\"ip\":\"123.134.75.201\",\"port\":3617,\"expire_time\":\"2018-12-17 17:33:18\",\"city\":\"山东 莱芜\",\"isp\":\"联通\"},{\"ip\":\"180.115.222.128\",\"port\":23564,\"expire_time\":\"2018-12-17 17:46:57\",\"city\":\"江苏 常州\",\"isp\":\"电信\"},{\"ip\":\"115.219.129.62\",\"port\":36410,\"expire_time\":\"2018-12-17 17:28:19\",\"city\":\"浙江 温州\",\"isp\":\"电信\"},{\"ip\":\"115.216.190.224\",\"port\":23564,\"expire_time\":\"2018-12-17 17:26:19\",\"city\":\"浙江 台州\",\"isp\":\"电信\"},{\"ip\":\"183.147.221.247\",\"port\":3617,\"expire_time\":\"2018-12-17 17:26:24\",\"city\":\"浙江 金华\",\"isp\":\"电信\"},{\"ip\":\"59.62.81.152\",\"port\":766,\"expire_time\":\"2018-12-17 17:46:14\",\"city\":\"江西 鹰潭\",\"isp\":\"电信\"}]}";
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
