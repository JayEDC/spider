package com.xfj.spider.controller;


import com.xfj.spider.service.HouseQuestionService;
import com.xfj.spider.vo.DataTable;
import com.xfj.spider.vo.DataTableVo;
import com.xfj.spider.vo.HouseQuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HouseQuestionController控制器
 * 房天下问答表
 * @author xnc
 * @since 2019-01-10
 */
@RestController
@RequestMapping("/houseQuestion")
public class HouseQuestionController {

    @Autowired
    HouseQuestionService houseQuestionService;


    @RequestMapping("/getQuestionList")
    @ResponseBody
    public String getQuestionList(DataTableVo dataTableVo, String keyWord,String type,String tag){
        Map<String, Object> map = new HashMap<>();
        map.put("hqContent",keyWord);
        map.put("hqType",type);
        map.put("hqTag",tag);
        return houseQuestionService.getQuestionList(dataTableVo,map);
    }




}

