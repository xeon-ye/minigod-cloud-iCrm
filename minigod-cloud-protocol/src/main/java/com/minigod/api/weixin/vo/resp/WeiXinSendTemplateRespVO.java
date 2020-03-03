/**
 * @Title: WeiXinSendTemplateRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.weixin.vo.resp;

import java.io.Serializable;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-9-15 下午8:28:17
 * @version v1.0
 */

public class WeiXinSendTemplateRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String errcode;
	private String errmsg;
	private String msgid;
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
}
