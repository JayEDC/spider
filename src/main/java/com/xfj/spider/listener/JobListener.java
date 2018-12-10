package com.xfj.spider.listener;



import com.xfj.spider.job.JobManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**代理IP可用状态监听线程
 * Created by lee on 2017/5/23.
 */
public class JobListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        new JobManager();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
