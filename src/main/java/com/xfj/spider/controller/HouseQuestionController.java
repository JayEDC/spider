package com.xfj.spider.controller;


import com.xfj.spider.common.Constant;
import com.xfj.spider.model.HouseQuestion;
import com.xfj.spider.model.HouseQuestionStatus;
import com.xfj.spider.service.HouseQuestionService;
import com.xfj.spider.model.vo.DataTable;
import com.xfj.spider.model.vo.DataTableVo;
import com.xfj.spider.model.vo.HouseQuestionVo;
import com.xfj.spider.service.HouseQuestionStatusService;
import com.xfj.spider.service.impl.HouseQuestionStatusServiceImpl;
import com.xfj.spider.util.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    @Autowired
    HouseQuestionStatusServiceImpl houseQuestionStatusService;

    private final static String UPLOADQUESTION = Constant.getInterfaceType();

    @RequestMapping("/getQuestionList")
    @ResponseBody
    public String getQuestionList(DataTableVo dataTableVo, String keyWord,String type,String tag){
        Map<String, Object> map = new HashMap<>();
        map.put("hqContent",keyWord);
        map.put("hqType",type);
        map.put("hqTag",tag);
        return houseQuestionService.getQuestionList(dataTableVo,map);
    }

    @RequestMapping("/getCommentList")
    @ResponseBody
    public String getCommentList(DataTableVo dataTableVo,String hqUrl){
        Map<String, Object> map = new HashMap<>();
        map.put("hqUrl",hqUrl);
        //houseQuestionService.getCommentList(dataTableVo,map)
        return null;
    }

    @RequestMapping("/uploadQuestion")
    @ResponseBody
    public Object uploadQuestion(String hqId,String commentId,String questionContent,String answerContent){
        MobileJsonResult result = new MobileJsonResult();
        Map<String, String> params = new HashMap<>();
        params.put("secretKey","3f021b55-b188-425b-ab14-557605fedb9e");
        params.put("sourceId",hqId);
        params.put("questionContent",questionContent);
        params.put("answerContent",answerContent);
        try {
            HttpRespons httpRespons = new HttpRequester().sendPost(UPLOADQUESTION, params);
            int code = httpRespons.getCode();
            if(code == 200){
                HouseQuestionStatus houseQuestionStatus = new HouseQuestionStatus();
                houseQuestionStatus.setHqId(Integer.parseInt(hqId));
                houseQuestionStatus.setRcId(Integer.parseInt(commentId));
                houseQuestionStatus.setHsStatus(1);
                int i = houseQuestionStatusService.save(houseQuestionStatus);
                if(i>0){
                    result.setResultCode(ResultCode.SUCCESS);
                    result.setContent("上传成功！");
                }
            }else {
                result.setResultCode(ResultCode.FAIL);
                result.setContent("上传失败！");
            }
        } catch (IOException e) {
            e.printStackTrace();
            result.setResultCode(ResultCode.FAIL);
            result.setContent("接口异常！");
        }

        return result;
    }

    @RequestMapping("/deprecatedQuestion")
    @ResponseBody
    public Object deprecatedQuestion(String hqId,String commentId){
        MobileJsonResult result = new MobileJsonResult();
        HouseQuestionStatus houseQuestionStatus = new HouseQuestionStatus();
        houseQuestionStatus.setHqId(Integer.parseInt(hqId));
        houseQuestionStatus.setRcId(Integer.parseInt(commentId));
        houseQuestionStatus.setHsStatus(2);
        int i = houseQuestionStatusService.save(houseQuestionStatus);
        if(i>0){
            result.setContent("操作成功！");
            result.setResultCode(ResultCode.SUCCESS);
        }else {
            result.setContent("操作失败！");
            result.setResultCode(ResultCode.FAIL);
        }
        return result;
    }




}

