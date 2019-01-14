package com.xfj.spider.service.impl;

import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.xfj.spider.model.HouseQuestion;
import com.xfj.spider.mapper.HouseQuestionMapper;
import com.xfj.spider.service.HouseQuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xfj.spider.vo.DataTable;
import com.xfj.spider.vo.DataTableVo;
import com.xfj.spider.vo.HouseQuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 房天下问答表 服务实现类
 * HouseQuestionServiceImpl
 * @author xnc
 * @since 2019-01-10
 */
@Service
public class HouseQuestionServiceImpl extends BaseService<HouseQuestion> implements HouseQuestionService {

    @Autowired
    HouseQuestionMapper houseQuestionMapper;

    @Override
    public String getQuestionList(DataTableVo dataTableVo, Map<String, Object> map) {
        int pageNum = dataTableVo.getStart()/dataTableVo.getLength()+1;
        int pageSize = dataTableVo.getLength();
        PageHelper.startPage(pageNum,pageSize);
        List<HouseQuestionVo> list  = houseQuestionMapper.getQuestionList(map);
        return DataTable.getInstance(list).toString();
    }


}
