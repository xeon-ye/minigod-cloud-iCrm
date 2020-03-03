package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * <code>SType</code>
 * 
 * @author Jimmy
 * @date 2015-7-9 下午6:56:08
 * @version v1.0
 */

public class StkSType implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;

	private String thirpartNo;
	private String qnNo;
	private String sName;

	public String getThirpartNo() {
		return thirpartNo;
	}

	public void setThirpartNo(String thirpartNo) {
		this.thirpartNo = thirpartNo;
	}

	public String getQnNo() {
		return qnNo;
	}

	public void setQnNo(String qnNo) {
		this.qnNo = qnNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
}
