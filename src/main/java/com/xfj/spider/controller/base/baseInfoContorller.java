package com.xfj.spider.controller.base;

import com.xfj.spider.common.Constant;
import com.xfj.spider.util.PropertiesFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName baseInfoContorller
 * @Description //TODO
 * @Author xnc
 * @Date 2019/1/1411:39 AM
 * @return 1.0
 **/
@RequestMapping("/base")
@Controller
public class baseInfoContorller {

    private final static String HOUSE_QUESTION = "html/house_question_comments.html";
    private final static String INDEX = "html/index";

    /**
     * 跳转到首页
     * @return
     */
    @RequestMapping("/toIndex")
    public String toIndex(){
        return INDEX;
    }


    /**
     * 跳转到问答页
     * @return
     */
    @RequestMapping("/toGeQuestion")
    public String toGeQuestion(ModelMap model){
        model.put("interfaceType", Constant.getInterfaceName());
        return HOUSE_QUESTION;
    }
    @ResponseBody
    @GetMapping("/toHello")
    public String toHello(){
        return "hello world";
    }

    @RequestMapping("/setInterface")
    @ResponseBody
    public String setInterface(String interfaceType){
        Constant.setInterface(interfaceType);
        return "成功";
    }


}
