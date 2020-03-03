/**
 * @Title: StkLabListMoreRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-19 下午6:57:08
 * @version v1.0
 */

public class StkLabListMoreRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer labId;// 概念ID
	private String labName;
	private String labChgPct;
	private StkBaseInfo stk;

	public Integer getLabId() {
		return labId;
	}

	public void setLabId(Integer labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getLabChgPct() {
		return labChgPct;
	}

	public void setLabChgPct(String labChgPct) {
		this.labChgPct = labChgPct;
	}

	public StkBaseInfo getStk() {
		return stk;
	}

	public void setStk(StkBaseInfo stk) {
		this.stk = stk;
	}

}
