/**
 * @Title: StkInduListMoreRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-19 下午6:58:22
 * @version v1.0
 */

public class StkInduListMoreRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String induCode;// 行业编码
	private String induName;// 行业名称
	private String induChgPct;
	private StkBaseInfo stk;

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

	public String getInduChgPct() {
		return induChgPct;
	}

	public void setInduChgPct(String induChgPct) {
		this.induChgPct = induChgPct;
	}

	public StkBaseInfo getStk() {
		return stk;
	}

	public void setStk(StkBaseInfo stk) {
		this.stk = stk;
	}

}
