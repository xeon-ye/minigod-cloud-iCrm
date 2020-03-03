package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * 
 * <code>StkSumVO<code>[个股概要信息查询类]
 *
 * @author Colin
 * @since MiniGod v0.0.1(2014-11-20)
 *
 */
public class StkPirceReminderMsgVO extends BaseVO {
	/**  */
	private static final long serialVersionUID = 6162966329716046378L;

	private Integer targetUserId;
	private String assetId;
	private String stkName;
	private double price;
	private double changePct;
	private Integer upOrDown; //1：股价上涨 2：股价下跌 3：涨幅 4：跌幅
	private double setValue;

	public StkPirceReminderMsgVO(Integer targetUserId, String assetId, String stkName, double price, double changePct, Integer upOrDown, double setValue){
		this.targetUserId = targetUserId;
		this.assetId = assetId;
		this.stkName = stkName;
		this.price = price;
		this.changePct = changePct;
		this.upOrDown = upOrDown;
		this.setValue = setValue;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Integer getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(Integer targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getChangePct() {
		return changePct;
	}

	public void setChangePct(double changePct) {
		this.changePct = changePct;
	}

	public Integer getUpOrDown() {
		return upOrDown;
	}

	public void setUpOrDown(Integer upOrDown) {
		this.upOrDown = upOrDown;
	}

	public double getSetValue() {
		return setValue;
	}

	public void setSetValue(double setValue) {
		this.setValue = setValue;
	}
}
