/**
 * @Title: IMFetchChargeSettingResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午4:02:21
 * @version v1.0
 */

public class IMFetchChargeSettingRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long startTs; // 开始的时间 格式:yyyy-MM-dd
	private String priceType;
	private String price; // 每月的费用
	private String salesPrice; // 促销每月的费用
	private String vipPrice; // VIP优惠价
	private String description;
	private String groupName;

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(String vipPrice) {
		this.vipPrice = vipPrice;
	}

	public Long getStartTs() {
		return startTs;
	}

	public void setStartTs(Long startTs) {
		this.startTs = startTs;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(String salesPrice) {
		this.salesPrice = salesPrice;
	}
}
