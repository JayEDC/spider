package com.xfj.spider.util;

/**
 * @ClassName StringUtil
 * @Description //TODO
 * @Author xnc
 * @Date 2018/12/1410:47 PM
 * @return 1.0
 **/
public class StringUtil {


    public static Integer stringToInt(String str){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }



}
