/**
 * @Title: PtfFollowStkVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

import com.minigod.api.ptf.vo.enums.EOrderDirection;

/**
 * @description 跟单预检结果
 *
 * @author 余俊斌
 * @date 2015年3月26日 上午11:04:57
 * @version v1.0
 */

public class PtfFollowStkVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 资产ID
	private String assetId;
	// 股票名
	private String stkName;
	// 总余额
	private double tBal;
	// 现价
	private String price;
	// 现价
	private String buyCalPrc;
	// 委托数量
	private double ordQty;
	// 可用余额
	private double aBal;
	// 委托方向
	private EOrderDirection ordBS;
	// 股票状态标示
	private Integer status;
	// 提示信息
	private String msg;
	
	

	public String getBuyCalPrc() {
		return buyCalPrc;
	}

	public void setBuyCalPrc(String buyCalPrc) {
		this.buyCalPrc = buyCalPrc;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public double gettBal() {
		return tBal;
	}

	public void settBal(double tBal) {
		this.tBal = tBal;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public double getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(double ordQty) {
		this.ordQty = ordQty;
	}

	public double getaBal() {
		return aBal;
	}

	public void setaBal(double aBal) {
		this.aBal = aBal;
	}

	public EOrderDirection getOrdBS() {
		return ordBS;
	}

	public void setOrdBS(EOrderDirection ordBS) {
		this.ordBS = ordBS;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
