/**
 * @Title: StkType.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-25 下午8:14:33
 * @version v1.0
 */

public class StkType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String thirpartNo;
	private String qnNo;
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
