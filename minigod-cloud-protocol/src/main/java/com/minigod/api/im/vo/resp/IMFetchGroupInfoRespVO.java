/**
 * @Title: IMFetchGroupInfoRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

import com.minigod.api.im.vo.Announcement;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午1:11:39
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupInfoRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String groupId; // 群组ID
	@Emoji
	private String groupName; // 群组的名称
	private String ownerId; // 群主ID
	@TransferID
	private Long ownerUserId;
	private String icon; // 群头像
	@Emoji
	private String description; // 群描述

	private Announcement announcement; // 公告
	@Emoji
	private String nickname; // 群主昵称
	private Integer maxUsers; // 群成员上限数
	private Integer memberCount; // 群成员数量,包括群主

	private String isCharge;// 是否收费 Y – 收费, N – 免费
	private String price;// 每月的费用 当isCharge为Y时,此字段有效
	private String salesPrice;// 开户客户每月的费用 当isCharge为Y时,此字段有效
	private String vipPrice; // VIP优惠价
	private Integer isNodisturbing; // 是否免打扰 1 – 是, 0 – 否
	private String affiliation; // 与群的从属关系 M – 普通成员,P – 付费的成员, O – 群主 ,G - 非群内成员
	private Long startTs; // 服务的起始时间戳 此字段仅当isCharge为Y, affiliation不为O时有效
	private Long endTs;// 服务的结束时间戳
	private String needVerify; // 是否需要验证,Y – 需要, N – 不需要 (收费的群组只能取值为N)

	private String groupType;

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

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public Long getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getMaxUsers() {
		return maxUsers;
	}

	public void setMaxUsers(Integer maxUsers) {
		this.maxUsers = maxUsers;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public String getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
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

	public Integer getIsNodisturbing() {
		return isNodisturbing;
	}

	public void setIsNodisturbing(Integer isNodisturbing) {
		this.isNodisturbing = isNodisturbing;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
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

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
}
