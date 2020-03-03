/**
 * @Title: SpLabelBaseInfo.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2015-8-19 下午10:30:40
 * @version v1.0
 */

public class SpLabelBaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer labId;// 概念ID
	private String labName;
	private Double labChgPct;

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

	public Double getLabChgPct() {
		return labChgPct;
	}

	public void setLabChgPct(Double labChgPct) {
		this.labChgPct = labChgPct;
	}

}
