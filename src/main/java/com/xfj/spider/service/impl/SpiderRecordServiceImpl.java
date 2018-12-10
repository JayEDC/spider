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
                logger.info("【"+spiderProxyIp.getIpAddr()+":"+spiderProxyIp.getIpPort()+"】（快代理）"+"总数："+proxyList.length()+","+"当前数："+i);
                IpUtil.checkIp(spiderProxyIp);
            }

        }catch(Exception e){
            logger.error("加载代理IP至缓存发生异常："+e.getMessage());
        }
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
