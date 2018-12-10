package com.xfj.spider.job;

import com.xfj.spider.cache.IPDataCache;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lee on 2017/5/23.
 */
public class JobManager {

    private static final long PERIOD_DAY= 60 * 1000;  //每隔六秒执行一次
    public JobManager() {

        Timer timer = new Timer();     //定时器实例化

        TimerTask loadLocalIptask = new TimerTask(){
            @Override
            public void run() {
                IPDataCache.loadLocalProxyIp();
            }
        };

        /*TimerTask loadProxyIpTask = new TimerTask(){

            @Override
            public void run() {
                logger.info("更新代理IP，就检测IP可用性任务开始执行。。。");
                DataCache.loadProxyIp();
                DataCache.filterAvailable();
            }
        };*/

        //读取库表代理IP数据
        timer.schedule(loadLocalIptask,new Date(),60 *60* 3 * 1000);

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, 2);

        //更新代理IP，就检测IP可用性
       // timer.schedule(loadProxyIpTask,calendar.getTime(),60 * 60 * 2 * 1000);

    }
}
