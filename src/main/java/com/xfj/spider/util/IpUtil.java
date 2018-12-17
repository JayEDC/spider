package com.xfj.spider.util;

import com.xfj.spider.cache.IPDataCache;
import com.xfj.spider.model.EsfToolsSpiderProxyIp;

/**
 * @ClassName IpUtil
 * @Description 添加ip至对应的缓存
 * @Author xnc
 * @Date 2018/12/59:29 AM
 * @return 1.0
 **/
public class IpUtil {

    public static void checkIp(EsfToolsSpiderProxyIp esfToolsSpiderProxyIp){
        try {
           /* String htmlJump = HttpUtil.getData("https://jxjump.58.com", esfToolsSpiderProxyIp.getIpAddr(), esfToolsSpiderProxyIp.getIpPort());
            if(htmlJump != null){
                IPDataCache.loadProxyIp(esfToolsSpiderProxyIp,"proxyIpCacheforJump58");
            }

            String htmlZh = HttpUtil.getData("https://zh.58.com",esfToolsSpiderProxyIp.getIpAddr(),esfToolsSpiderProxyIp.getIpPort());
            if(htmlZh != null){
                IPDataCache.loadProxyIp(esfToolsSpiderProxyIp,"proxyIpCacheforZh58");

            }

            String htmlShort = HttpUtil.getData("https://short.58.com",esfToolsSpiderProxyIp.getIpAddr(),esfToolsSpiderProxyIp.getIpPort());
            if(htmlShort != null){
                IPDataCache.loadProxyIp(esfToolsSpiderProxyIp,"proxyIpCacheforShort58");
            }*/

            IPDataCache.loadProxyIp(esfToolsSpiderProxyIp,"proxyIpCache");


        }catch(Exception e){

        }
    }

}
