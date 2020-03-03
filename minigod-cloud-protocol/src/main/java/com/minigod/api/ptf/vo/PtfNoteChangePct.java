/**
 * @Title: PtfNoteChangePct.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-5-20 下午7:55:42
 * @version v1.0
 */

public class PtfNoteChangePct implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<String, Double> assetCmfPrice; // 资产id
	private Date startDate; // 开始时间(成交日当天的日期)
	private Date endDate; // 结束时间(10日内为当天日期,超过10日为第10日日期)

	public Map<String, Double> getAssetCmfPrice() {
		return assetCmfPrice;
	}
	public void setAssetCmfPrice(Map<String, Double> assetCmfPrice) {
		this.assetCmfPrice = assetCmfPrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
