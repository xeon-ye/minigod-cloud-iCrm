/**
 * @Title: IMFetchChargeSettingVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.vo.BaseVO;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午3:56:00
 * @version v1.0
 */

public class IMFetchChargeSettingVO extends BaseVO {
	private static final long serialVersionUID = 1L;
	private String  groupId;
	private String isOpenAcc; // 是否是开户客户 Y – 是 N – 不是
	private String startDate; // 开始的时间 格式: yyyy-MM-dd
	private String price; // 每月的费用
	private String salesPrice; // 促销每月的费用
	private String salesDesc; // 促销说明
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getIsOpenAcc() {
		return isOpenAcc;
	}
	public void setIsOpenAcc(String isOpenAcc) {
		this.isOpenAcc = isOpenAcc;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
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
	public String getSalesDesc() {
		return salesDesc;
	}
	public void setSalesDesc(String salesDesc) {
		this.salesDesc = salesDesc;
	}
}
