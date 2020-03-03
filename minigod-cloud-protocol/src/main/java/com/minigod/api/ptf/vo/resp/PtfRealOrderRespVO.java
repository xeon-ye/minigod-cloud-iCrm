package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.api.ptf.vo.enums.ERealPtfOrderActionType;


/**
 * @description 组合委托请求值对象
 *
 * @author 许德佑
 * @date 2015-3-16
 * @version v2.0
 */
public class PtfRealOrderRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer ptfTransId; // 组合委托编号
	private ERealPtfOrderActionType actionType;
	

	public Integer getPtfTransId() {
		return ptfTransId;
	}

	public void setPtfTransId(Integer ptfTransId) {
		this.ptfTransId = ptfTransId;
	}

	public ERealPtfOrderActionType getActionType() {
		return actionType;
	}

	public void setActionType(ERealPtfOrderActionType actionType) {
		this.actionType = actionType;
	}

}
