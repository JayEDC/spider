package com.xfj.spider.model.vo;

import com.xfj.spider.model.HouseQuestion;

/**
 * @ClassName HouseQuestionVo
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/145:53 PM
 * @return 1.0
 **/
public class HouseQuestionVo extends HouseQuestion {

    /**
     * 状态
     */
    private Integer hsStatus;

    /**
     * 回答
     */
    private String commentsContent;

    /**
     * 回答人
     */
    private String commentsUserName;

    /**
     * 回复 id
     */
    private Integer commentsId;

    public Integer getHsStatus() {
        return hsStatus;
    }

    public void setHsStatus(Integer hsStatus) {
        this.hsStatus = hsStatus;
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent;
    }

    public String getCommentsUserName() {
        return commentsUserName;
    }

    public void setCommentsUserName(String commentsUserName) {
        this.commentsUserName = commentsUserName;
    }

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }
}
