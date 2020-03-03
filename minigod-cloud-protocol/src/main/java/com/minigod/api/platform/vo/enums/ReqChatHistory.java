package com.minigod.api.platform.vo.enums;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

public class ReqChatHistory extends BaseVO implements Serializable  {

	private static final long serialVersionUID = 7049754063884151898L;

	private String key;//用户ID
	private String page;//请求页数
	private String type;//类型:HS-A A股  HK 港股  KF 客服
	private String limit;//单页数量限制
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	
	
	

	
	

}
