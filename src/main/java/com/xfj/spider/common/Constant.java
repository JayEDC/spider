package com.xfj.spider.common;

import org.apache.commons.configuration.PropertiesConfiguration;

import javax.naming.ConfigurationException;

/**
 * @ClassName Constant
 * @description 常量类
 * @Author xnc
 * @Date 2018/12/43:10 PM
 * @return 1.0
 **/
public class Constant {

    private static PropertiesConfiguration propertiesConfig;

    static {

        try {
            propertiesConfig = new PropertiesConfiguration("properties/config.properties");
            propertiesConfig.setEncoding("UTF-8");
        } catch (org.apache.commons.configuration.ConfigurationException e) {
            e.printStackTrace();
        }
    }

    //获取代理IP的URL地址(快代理)
    public static final String GET_PROXY_IP_URL = propertiesConfig.getString("ip.proxyUrl");

    public static final String [] TEST_ADDR = new String [10];

    //房源详情采集任务线程池大小
    public static final Integer DETAIL_THREAD_POOL_SIZE = 200;

    //连接超时时长
    public static final Integer CONNECT_TIME_OUT = 3000;

    //代理连接超时时长
    public static final Integer PROXY_CONNECT_TIME_OUT = 3000;

    static{
        //代理IP测试池

        //新浪
        TEST_ADDR[0] = "http://www.sina.com.cn";
        //搜狐
        TEST_ADDR[1] = "http://www.sohu.com";
        //qq
        TEST_ADDR[2] = "http://www.qq.com";
        //网易
        TEST_ADDR[3] = "http://www.163.com";
        //凤凰
        TEST_ADDR[4] = "http://www.ifeng.com";
        //37游戏
        TEST_ADDR[5] = "http://www.37.com";
        //人民网
        TEST_ADDR[6] = "http://www.people.com.cn";
        //中华网
        TEST_ADDR[7] = "http://www.xinhuanet.com";
        //中国日报
        TEST_ADDR[8] = "http://cn.chinadaily.com.cn";
        //中青网
        TEST_ADDR[9] = "http://www.youth.cn";

    }

}
