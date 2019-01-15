package com.xfj.spider.mapper;

import com.xfj.spider.model.HouseQuestion;
import com.xfj.spider.util.MyMapper;
import com.xfj.spider.model.vo.HouseQuestionVo;

import java.util.List;
import java.util.Map;

/**
 * 房天下问答表 Mapper 接口
 * HouseQuestionMapper
 * @author xnc
 * @since 2019-01-10
 */
public interface HouseQuestionMapper extends MyMapper<HouseQuestion> {

    public List<HouseQuestionVo> getQuestionList(Map<String, Object> map);

}
