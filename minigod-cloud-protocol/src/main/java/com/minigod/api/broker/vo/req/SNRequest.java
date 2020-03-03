/**
 * @Title: QNBaseRquest.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.broker.vo.req;

import java.io.Serializable;

/**
 * @description 券商请求类
 * 
 * @author Jimmy
 * @date 2015-3-9 下午8:35:01
 * @version v1.0
 */
public class SNRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	// 券商ID
	private Integer brokerId;
	// 用户ID
	private Integer userId;
	// 客户号
	private String custId;
	// 资金账号
	private String depositAcc;
	// 请求的条数
	private Integer reqNum;
	// 定位串 分页书签
	private String positionStr;
	// 股东账号
	private String stkAcc;

	public String getStkAcc() {
		return stkAcc;
	}

	public void setStkAcc(String stkAcc) {
		this.stkAcc = stkAcc;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDepositAcc() {
		return depositAcc;
	}

	public void setDepositAcc(String depositAcc) {
		this.depositAcc = depositAcc;
	}

	public Integer getReqNum() {
		return reqNum;
	}

	public void setReqNum(Integer reqNum) {
		this.reqNum = reqNum;
	}

	public String getPositionStr() {
		return positionStr;
	}

	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}
