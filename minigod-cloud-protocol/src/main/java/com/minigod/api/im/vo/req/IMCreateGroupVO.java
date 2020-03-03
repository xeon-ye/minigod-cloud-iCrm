/**
 * @Title: ImCreateGroupVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.req;

import com.minigod.api.im.enums.EIsCharge;
import com.minigod.api.vo.BaseVO;
import com.minigod.common.anno.TransferBean;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-15 下午1:00:12
 * @version v1.0
 */
@TransferBean
public class IMCreateGroupVO extends BaseVO {
	private static final long serialVersionUID = 1L;

	private String groupName; // 群组的名称

	private EIsCharge isCharge; // 是否收费

	private String price; // 价格

	private String salesPrice; // 优惠价

	private String vipPrice; // VIP优惠价

	private String description; // 群描述

	private String icon; // 群头像

	private String needVerify = "N"; // 是否需要验证,Y – 需要, N – 不需要 （默认）

	private Integer maxUsers=5000;//成员上限数，直播群的从投顾表里获取

	private String chatroomKind;//聊天室种类：1官方，2港股，3美股，4期货

	private String groupType;//1群组；2聊天室；3直播室
	
	private int public1 = 0;
	private int approval = 0;
	private int isauth = 0;
	
	public int getIsauth() {
		return isauth;
	}

	public void setIsauth(int isauth) {
		this.isauth = isauth;
	}

	public int getPublic1() {
		return public1;
	}

	public void setPublic1(int public1) {
		this.public1 = public1;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public String getVipPrice() {
		return vipPrice;
	}

	public void setVipPrice(String vipPrice) {
		this.vipPrice = vipPrice;
	}

	public String getNeedVerify() {
		return needVerify;
	}

	public void setNeedVerify(String needVerify) {
		this.needVerify = needVerify;
	}

	public EIsCharge getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(EIsCharge isCharge) {
		this.isCharge = isCharge;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(Integer maxUsers) {
		this.maxUsers = maxUsers;
	}

	public String getChatroomKind() {
		return chatroomKind;
	}

	public void setChatroomKind(String chatroomKind) {
		this.chatroomKind = chatroomKind;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
}
