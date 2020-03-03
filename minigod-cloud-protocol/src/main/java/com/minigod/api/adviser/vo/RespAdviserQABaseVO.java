package com.minigod.api.adviser.vo;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;

/**
 * 投顾问答返回基类
 */
@TransferBean
public class RespAdviserQABaseVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	private Integer qId; //问题id

	private Integer aId; //答案id
	
	private String successMsg; //成功信息

	public Integer getqId() {
		return qId;
	}

	public void setqId(Integer qId) {
		this.qId = qId;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	
}
