package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

/**
 * <code>PtfInfoHtmlVO<code>
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-10)
 * 
 */
public class PtfInfoHtmlVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ptfId;// 组合id

	private String ptfName;// 组合名称

	private Double tYield;// 累计指数

	private Double mYield;// 月累计

	private Double ptfIdx;// 组合指数

	private String uImage;// 用户头像

	private String uName;// 用户名称

	public String getPtfId() {
		return ptfId;
	}

	public void setPtfId(String ptfId) {
		this.ptfId = ptfId;
	}

	public String getPtfName() {
		return ptfName;
	}

	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}

	public Double gettYield() {
		return tYield;
	}

	public void settYield(Double tYield) {
		this.tYield = tYield;
	}

	public Double getmYield() {
		return mYield;
	}

	public void setmYield(Double mYield) {
		this.mYield = mYield;
	}

	public Double getPtfIdx() {
		return ptfIdx;
	}

	public void setPtfIdx(Double ptfIdx) {
		this.ptfIdx = ptfIdx;
	}

	public String getuImage() {
		return uImage;
	}

	public void setuImage(String uImage) {
		this.uImage = uImage;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

}
