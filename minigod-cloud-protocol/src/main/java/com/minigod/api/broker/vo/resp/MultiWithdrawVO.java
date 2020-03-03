/**
 * @Title: MultiWithdrawVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.resp;

import java.io.Serializable;

import com.minigod.api.broker.vo.enums.EBrkHandleStatus;

/**
 * @description 批量撤单返回
 *
 * @author 余俊斌
 * @date 2015年7月6日 下午8:35:16
 * @version v1.0
 */

public class MultiWithdrawVO implements Serializable {

	private static final long serialVersionUID = 1L;
	// 委托编号
	private String ordSeq;
	// 发送状态
	private EBrkHandleStatus status;
	// 原始委托编号
	private String orgOrdSeq;
	// 返回码
	private String brkRetCode;
	// 返回信息
	private String brkRetMsg;

	public String getOrdSeq() {
		return ordSeq;
	}

	public void setOrdSeq(String ordSeq) {
		this.ordSeq = ordSeq;
	}

	public EBrkHandleStatus getStatus() {
		return status;
	}

	public void setStatus(EBrkHandleStatus status) {
		this.status = status;
	}

	public String getOrgOrdSeq() {
		return orgOrdSeq;
	}

	public void setOrgOrdSeq(String orgOrdSeq) {
		this.orgOrdSeq = orgOrdSeq;
	}

	public String getBrkRetCode() {
		return brkRetCode;
	}

	public void setBrkRetCode(String brkRetCode) {
		this.brkRetCode = brkRetCode;
	}

	public String getBrkRetMsg() {
		return brkRetMsg;
	}

	public void setBrkRetMsg(String brkRetMsg) {
		this.brkRetMsg = brkRetMsg;
	}

}
