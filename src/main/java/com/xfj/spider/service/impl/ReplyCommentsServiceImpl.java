package com.xfj.spider.service.impl;

import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.mapper.ReplyCommentsMapper;
import com.xfj.spider.service.ReplyCommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 房天下问答评论回复表 服务实现类
 * ReplyCommentsServiceImpl
 * @author xnc
 * @since 2019-01-11
 */
@Service
public class ReplyCommentsServiceImpl extends BaseService<ReplyComments> implements ReplyCommentsService {

    @Autowired
    ReplyCommentsMapper replyCommentsMapper;

    @Override
    public Boolean CommentsCheck(String url) {
        List<ReplyComments> replyComments = replyCommentsMapper.commentsCheck(url);
        if(replyComments.size()>0){
            return true;
        }
        return false;
    }
}
