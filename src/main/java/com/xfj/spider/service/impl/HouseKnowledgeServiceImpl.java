package com.xfj.spider.service.impl;

import com.xfj.spider.model.HouseKnowledge;
import com.xfj.spider.mapper.HouseKnowledgeMapper;
import com.xfj.spider.service.HouseKnowledgeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 * HouseKnowledgeServiceImpl
 * @author xnc
 * @since 2019-01-08
 */
@Service
public class HouseKnowledgeServiceImpl extends BaseService<HouseKnowledge> implements HouseKnowledgeService {

    @Autowired
    HouseKnowledgeMapper houseKnowledgeMapper;

    @Override
    public boolean check(String url) {
        List<HouseKnowledge> list = houseKnowledgeMapper.check(url);
        if(list.size()==0){
            return true;
        }
        return false;
    }
}
