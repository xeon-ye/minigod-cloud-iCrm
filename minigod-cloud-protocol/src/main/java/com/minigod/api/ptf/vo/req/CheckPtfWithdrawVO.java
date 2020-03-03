/**
 * @Title: CheckPtfWithdrawVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.req;

import java.io.Serializable;

import com.minigod.api.vo.BaseVO;

/**
 * @description 组合撤单预检值对象
 *
 * @author minigod
 * @date 2015-3-31 下午4:21:07
 * @version v1.0
 */

public class CheckPtfWithdrawVO  extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer brkId; // 券商id
	
	private String custId; // 券商端客户编号
	
	private Integer ptfTransId; // 交易id

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

	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}
	
}
