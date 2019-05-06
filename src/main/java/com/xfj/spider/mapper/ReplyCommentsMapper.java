package com.xfj.spider.mapper;

import com.xfj.spider.model.ReplyComments;
import com.xfj.spider.util.MyMapper;

import java.util.List;

/**
 * 房天下问答评论回复表 Mapper 接口
 * ReplyCommentsMapper
 * @author xnc
 * @since 2019-01-11
 */
public interface ReplyCommentsMapper extends MyMapper<ReplyComments> {
    public List<ReplyComments> commentsCheck(String url);
}
