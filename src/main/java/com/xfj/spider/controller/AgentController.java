package com.xfj.spider.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * AgentController控制器
 * 经纪人表
 * @author xnc
 * @since 2018-12-11
 */
@RestController
@RequestMapping("/agent")
public class AgentController {
    @RequestMapping("/hello" +
            "")
    public String hello(){
        return "hello world";
    }

}

