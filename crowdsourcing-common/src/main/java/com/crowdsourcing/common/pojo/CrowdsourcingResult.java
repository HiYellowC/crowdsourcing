package com.crowdsourcing.common.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

/***
* 自定义相应结构
* @author  HiYellowC
* @date 创建时间：2017年3月20日 上午10:41:17 
* @version 1.0 * @parameter  
* @since  
* @return
*/

public class CrowdsourcingResult {

	//定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	//响应业务状态
	private Integer status;
	
	//响应信息
	private String msg;
	
	//响应中的数据
	private Object data;
	
	public static CrowdsourcingResult build(Integer status, String msg, Object data) {
		return new CrowdsourcingResult(status, msg, data);
	}
	
	public static CrowdsourcingResult ok(Object data) {
		return new CrowdsourcingResult(data);
	}
	
	public static CrowdsourcingResult ok() {
		return new CrowdsourcingResult(null);
	}
	
	public CrowdsourcingResult() {
		
	}
	
	public static CrowdsourcingResult build(Integer status, String msg) {
		return new CrowdsourcingResult(status, msg, null);
	}
	
	public CrowdsourcingResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public CrowdsourcingResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
