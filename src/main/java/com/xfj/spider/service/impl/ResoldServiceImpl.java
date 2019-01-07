package com.xfj.spider.service.impl;

import com.xfj.spider.model.Resold;
import com.xfj.spider.mapper.ResoldMapper;
import com.xfj.spider.service.ResoldService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 经纪人二手房表 服务实现类
 * ResoldServiceImpl
 * @author xnc
 * @since 2018-12-11
 */
@Service
public class ResoldServiceImpl extends BaseService<Resold> implements ResoldService {
    @Override
    public Integer createResold(Resold resold) {
        //判断resold 是否窜在
        List<Resold> resoldList = this.selectByExample(resold);
        if(resoldList ==null || resoldList.size() == 0){
            this.save(resold);
            return resold.getRdId();
        }
        //链接已经存在
        return 0;
    }
}
