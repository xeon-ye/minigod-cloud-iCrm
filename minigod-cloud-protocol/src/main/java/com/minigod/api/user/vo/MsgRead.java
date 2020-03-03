package com.minigod.api.user.vo;

import java.io.Serializable;

/**
 * @Title: MsgRead.java
 * @Description: 消息已读值对象
 * @Copyright: © 2015 minigod
 * @Company: minigod
 * 
 * @author minigod
 * @date 2015-1-4 下午8:10:52
 * @version v1.0
 */

public class MsgRead extends SNUserBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer msgCode; // 消息类别
	private String msgType; // 消息类型，若msgCode=2004， A所有消息数，G待同意的消息数，扩展字段
	private Long readVersion; // 已读版本号

	public Integer getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(Integer msgCode) {
		this.msgCode = msgCode;
	}
	
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Long getReadVersion() {
		return readVersion;
	}

	public void setReadVersion(Long readVersion) {
		this.readVersion = readVersion;
	}
	
}
