/**
 * @Title: SpInduBaseInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-20 上午10:44:05
 * @version v1.0
 */

public class SpInduBaseInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String induCode;// 行业编码
	private String induName;// 行业名称
	private Double induChgPct;

	public String getInduCode() {
		return induCode;
	}

	public void setInduCode(String induCode) {
		this.induCode = induCode;
	}

	public String getInduName() {
		return induName;
	}

	public void setInduName(String induName) {
		this.induName = induName;
	}

	public Double getInduChgPct() {
		return induChgPct;
	}

	public void setInduChgPct(Double induChgPct) {
		this.induChgPct = induChgPct;
	}

}
