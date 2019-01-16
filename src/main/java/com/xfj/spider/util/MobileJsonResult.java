package com.xfj.spider.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户端与服务器段的标准交互协议
 * <p>
 * 参数：Extend可以存放任意对象数据
 * </p>
 * 
 * @author xiaoxie
 */
public class MobileJsonResult {

	/** 服务结果code */
	private int resultCode = ResultCode.SUCCESS;
	/** 返回的标题 */
	private String title = "";
	/** 返回的正文 */
	private String content = "";
	/** 要跳转的URL */
	private String urlPath = "";
	/** 返回的附加数据 */
	private Object extend = "";

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Object getExtend() {
		return extend;
	}

	public void setExtend(Object extend) {
		this.extend = extend;
	}

	/**
	 * 放入集合和总数
	 * @param list
	 * @param total
	 */
	public void setListAndTotal(List<?> list, Object total) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (list != null) {
			map.put("list", list);
		}
		if (total != null) {
			map.put("total", total);
		}
		this.extend = map;
	}

	// 返回json格式字符串
	@Override
	public String toString() {
		Gson g = new Gson();
		return g.toJson(this);
	}
	/**
	 * 
	 * @Title: toStringKeepHtmlEscaping
	 * @Description: Gson转变为字符串，转变的字符串保留=,&等特殊符号
	 * @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String toStringKeepHtmlEscaping() {
		Gson g = new GsonBuilder().disableHtmlEscaping().create();
		return g.toJson(this);
	}
	public String toString(String pattern) {
		Gson g = new GsonBuilder().setDateFormat(pattern).create();
		return g.toJson(this);
	}
	/**
	 * 
	 * @Title: toStringKeepHtmlEscaping
	 * @Description: Gson转变为字符串，转变的字符串保留=,&等特殊符号
	 * @param pattern
	 * @return    参数
	 * @return String    返回类型
	 * @throws
	 */
	public String toStringKeepHtmlEscaping(String pattern) {
		Gson g = new GsonBuilder().setDateFormat(pattern).create();
		return g.toJson(this);
	}

}