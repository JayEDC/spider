package com.xfj.spider.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * PropertiesFileUtil
 * 读取Properties 文件
 *
 * @author Lao SiCheng
 * @version 0.1
 **/
public class PropertiesFileUtil {
    /**
     * 读取properties文件，保存Map
     * @param fileName 文件名
     * @return 保存Map
     */
    public static Map<String, String>  readPropertiesFile(String fileName) {
        Map<String, String> mapData = new HashMap<>();
        //获得properties文件属性
        ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
        Enumeration enumeration = resourceBundle.getKeys();
        while (enumeration.hasMoreElements()){
            String key = (String)enumeration.nextElement();
            mapData.put(key, resourceBundle.getString(key));
        }
        return mapData;
    }

    public static String getPropertiesByKey(String fileName, String key) {
        //获得properties文件属性
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
            String propertiesValue = resourceBundle.getString(key);
           // propertiesValue = new String(propertiesValue.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            return propertiesValue;
        } catch (MissingResourceException me){
            //me.printStackTrace();
            System.out.println("key not found : " + key);
            return "";
        }

    }


}
