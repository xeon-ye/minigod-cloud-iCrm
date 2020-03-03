/**
 * @Title: RegisterConceptVo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-19 下午3:47:31
 * @version v1.0
 */

public class RegisterInfoWithoutMkt implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	private String flag;

	public RegisterInfoWithoutMkt(String flag) {
		super();
		this.flag = flag;
	}

	public RegisterInfoWithoutMkt() {
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
