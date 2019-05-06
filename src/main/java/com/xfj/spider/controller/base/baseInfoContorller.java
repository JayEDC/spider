package com.xfj.spider.controller.base;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName baseInfoContorller
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/1411:39 AM
 * @return 1.0
 **/
@RequestMapping("/")
@Controller
public class baseInfoContorller {

    private final static String HOUSE_QUESTION = "html/house_question_comments.html";
    private final static String INDEX = "html/index";

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/")
    public String toIndex(){
        return INDEX;
    }


    /**
     * 跳转到问答页
     * @return
     */
    @RequestMapping("/toGeQuestion")
    public String toGeQuestion(){
        return HOUSE_QUESTION;
    }
    @ResponseBody
    @GetMapping("/toHello")
    public String toHello(){
        return "hello world";
    }




}
