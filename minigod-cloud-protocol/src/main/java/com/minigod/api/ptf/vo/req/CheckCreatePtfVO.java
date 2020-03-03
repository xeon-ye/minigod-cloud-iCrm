package com.minigod.api.ptf.vo.req;

import com.minigod.api.vo.BaseVO;


/**
 * 
 * @description 已有持仓创建组合预检
 *
 * @author MiniGod
 * @date 2015-3-30 上午11:14:22
 * @version v1.0
 */
public class CheckCreatePtfVO extends BaseVO {

	private static final long serialVersionUID = 1L;
	
	private Integer brkId; // 券商ID
	private String custId; // 券商用户ID
	
	public Integer getBrkId() {
		return brkId;
	}
	public void setBrkId(Integer brkId) {
		this.brkId = brkId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
}
