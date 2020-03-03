package com.minigod.api.platform.vo.enums;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

public class ReqChatAnswer extends BaseVO implements Serializable  {

	private static final long serialVersionUID = 7049754063884151898L;
	private String msgid;//用户ID
	private String key;//用户ID
	private String ask;//问题
	private String type;//类型:HS-A A股  HK 港股  KF 客服
	private String name;//用户昵称
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAsk() {
		return ask;
	}
	public void setAsk(String ask) {
		this.ask = ask;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	
	
	

	
	

}
