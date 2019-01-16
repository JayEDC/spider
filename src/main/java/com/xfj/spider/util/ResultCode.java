package com.xfj.spider.util;

/**
 * 指示本次请求的结果
 * @author xiaoxie
 *
 */
public class ResultCode {
	/**
	 * 失败
	 */
	public final static int FAIL =  0;
	/**
	 * 成功
	 */
	public final static int SUCCESS = 1;
	/**
	 * 提示有逻辑判断上的错误
	 */
	public final static int TIP_WARN = 2;
	/**
	 * 未登录
	 */
	public final static int NEED_LOGIN = 3;
	/**
	 * 指示权限不够
	 */
	public final static int NOT_AUTH = 4;
	
	/**
	 * 后台报错提示
	 */
	public final static String FAIL_MESSAGE = "服务器异常";
}

