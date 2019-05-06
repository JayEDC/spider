package com.xfj.spider.service;

import com.xfj.spider.model.HouseKnowledge;

import java.util.Map;

/**
 *  服务类
 * HouseKnowledgeService
 * @author xnc
 * @since 2019-01-08
 */
public interface HouseKnowledgeService extends IService<HouseKnowledge> {

    /**
     * 去重
     * @param title
     * @return
     */
    public boolean check(String url);
}
