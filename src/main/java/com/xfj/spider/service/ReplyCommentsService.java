package com.xfj.spider.service;

import com.xfj.spider.model.ReplyComments;
/**
 * 房天下问答评论回复表 服务类
 * ReplyCommentsService
 * @author xnc
 * @since 2019-01-11
 */
public interface ReplyCommentsService extends IService<ReplyComments> {
    public Boolean CommentsCheck(String url);
}
