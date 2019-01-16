package com.xfj.spider.service;

import com.xfj.spider.model.HouseQuestion;
import com.xfj.spider.model.vo.DataTableVo;
import com.xfj.spider.model.vo.HouseQuestionVo;

import java.util.List;
import java.util.Map;

/**
 * 房天下问答表 服务类
 * HouseQuestionService
 * @author xnc
 * @since 2019-01-10
 */
public interface HouseQuestionService extends IService<HouseQuestion> {

    public String getQuestionList(DataTableVo dataTableVo,Map<String, Object> map);

    public String getCommentList(DataTableVo dataTableVo,Map<String, Object> map);
}
