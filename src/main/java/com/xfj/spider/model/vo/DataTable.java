
/**
 * Project Name:CityManager
 * File Name:DataTable.java
 * Package Name:com.xfj.base.common.vo
 * Date:2016年1月20日下午3:58:22
 * Copyright (c) 2016, www.xfj100.com All Rights Reserved
 *
*/
package com.xfj.spider.model.vo;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;


import java.util.List;

/**
 * ClassName:DataTableResultVo
 * Function: TODO ADD FUNCTION
 * Reason:   TODO ADD REASON
 * Date:     2016年1月20日 下午3:58:22
 * @author   Yorke
 * @version 
 * @since    JDK 1.6
 * @see     
 */
public class DataTable {
	private Integer draw;
	private Integer recordsTotal;
	private Integer recordsFiltered;
	private List data;
	private String error;
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

	public DataTable(List list){
		PageInfo appsPageInfo = new PageInfo<>(list);
		recordsTotal = (int) appsPageInfo.getTotal();
		recordsFiltered = (int)appsPageInfo.getTotal();
		data = appsPageInfo.getList();
	}

	public DataTable(){

	}

	@Override
	public String toString(){
		ObjectMapper mapper = new ObjectMapper();
		String str = null;
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return str;
	}

	public static DataTable getInstance(List list){
		return new DataTable(list);
	}

}

