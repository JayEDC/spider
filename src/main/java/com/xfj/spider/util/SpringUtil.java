package com.xfj.spider.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringUtil
 * @Description 从spring上下文中获取对象实例
 * @Author xnc
 * @Date 2018/12/44:58 PM
 * @return 1.0
 **/
@Component
public class SpringUtil{

    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    /**
     * 获取上下文
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringUtil.applicationContext = context;
        System.out.println("---------------"+applicationContext);

    }

    /**
     * 通过class获取Bean
     */
    public static <T> T getBean(Class<T> clazz) {
        System.out.println("---------------"+applicationContext);
        return applicationContext.getBean(clazz);
    }

}