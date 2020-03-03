package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

/**
 * @Title: PtfUpdateNotifyVO.java
 * @Description: 跟单组合通知返回VO类
 * @Copyright: © 2014 minigod
 * @Company: minigod
 *
 * @author panlz
 * @date 2015-03-16 上午11:33:48
 * @version v1.0
 */

public class PtfUpdateDetailStksVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private String assetId; // 资产ID
	
	private String stkName; // 股票名称
	
	private Double avgPrc; // 成交均价
	
	private String optType; // 操作类型 B-加仓 S-减仓 A-新增 C-清仓

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

	

	public Double getAvgPrc() {
		return avgPrc;
	}

	public void setAvgPrc(Double avgPrc) {
		this.avgPrc = avgPrc;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}
	
	

	

}
