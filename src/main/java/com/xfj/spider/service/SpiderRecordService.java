package com.xfj.spider.service;


import org.springframework.stereotype.Service;

/**
 * Created by lee on 2017/5/22.
 */

public interface SpiderRecordService {

    public void loadProxyIp();

    public void loadLocalProxyIp();
}