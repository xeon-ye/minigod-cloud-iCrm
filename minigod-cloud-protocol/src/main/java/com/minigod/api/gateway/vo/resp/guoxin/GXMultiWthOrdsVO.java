/**
 * @Title: GXMultiWthOrds.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.gateway.vo.resp.guoxin;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-3-24 下午6:55:37
 * @version v1.0
 */

public class GXMultiWthOrdsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 委托编号 */
	private String orderno;
	/** 返回状态 */
	private String status;
	/** 错误码 */
	private Integer orgcode;
	/** 错误信息 */
	private String orgmsg;
	/** 成功信息 */
	private String msgok;

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(Integer orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgmsg() {
		return orgmsg;
	}

	public void setOrgmsg(String orgmsg) {
		this.orgmsg = orgmsg;
	}

	public String getMsgok() {
		return msgok;
	}

	public void setMsgok(String msgok) {
		this.msgok = msgok;
	}

}
