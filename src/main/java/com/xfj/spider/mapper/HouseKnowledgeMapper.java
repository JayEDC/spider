package com.xfj.spider.mapper;

import com.xfj.spider.model.HouseKnowledge;
import com.xfj.spider.util.MyMapper;

import java.util.List;

/**
 *  Mapper 接口
 * HouseKnowledgeMapper
 * @author xnc
 * @since 2019-01-08
 */
public interface HouseKnowledgeMapper extends MyMapper<HouseKnowledge> {
  public List<HouseKnowledge> check(String url);
}
