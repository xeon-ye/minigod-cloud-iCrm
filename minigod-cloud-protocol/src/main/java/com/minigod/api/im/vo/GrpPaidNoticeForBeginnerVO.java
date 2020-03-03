/**
 * @Title： GroupPaidNoticeVO.java
 * @Copyright： © 2015 minigod
 * @Company： minigod
 */

package com.minigod.api.im.vo;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;

import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.DateUtils.TimeFormatter;

/**
 * @description 直播间交易通知
 * 
 * @author Jimmy
 * @date 2015-11-19 下午4：45：19
 * @version v1.0
 */

public class GrpPaidNoticeForBeginnerVO implements Serializable {
	private static final long serialVersionUID = 1L;
	// 群ID
	private String groupId;
	// 群名字
	private String groupName;
	// 金额
	private String amount;
	// 群管理人
	private String name;
	// 服务期
	private Integer qty;
	// 起始时间戳
	private Long startTs;
	// 结束时间戳
	private Long endTs;
	// 实际金额
	private String actAmount;

	public String getActAmount() {
		return actAmount;
	}

	public void setActAmount(String actAmount) {
		this.actAmount = actAmount;
	}

	public String toString() {
		StringBuilder oBuilder = new StringBuilder();
		oBuilder.append(MessageFormat.format("<font color=#666666>你好，你已经成功购买了【{0}】</font><br><br>", groupName))
				.append("<font color=#999999>金额：</font><font color=#666666>")
				.append(amount)
				.append("元</font><br>")
				.append("<font color=#999999>群管理人：</font><font color=#666666>")
				.append(name)
				.append("</font><br>")
				.append("<font color=#999999>服务期：</font><font color=#666666>")
				.append(qty)
				.append("个月，")
				.append(DateUtils.dateToString(new Date(startTs), TimeFormatter.YYYY_MM_DD))
				.append("至")
				.append(DateUtils.dateToString(new Date(endTs), TimeFormatter.YYYY_MM_DD))
				.append("</font><br>");
		return oBuilder.toString();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Long getStartTs() {
		return startTs;
	}

	public void setStartTs(Long startTs) {
		this.startTs = startTs;
	}

	public Long getEndTs() {
		return endTs;
	}

	public void setEndTs(Long endTs) {
		this.endTs = endTs;
	}
}
