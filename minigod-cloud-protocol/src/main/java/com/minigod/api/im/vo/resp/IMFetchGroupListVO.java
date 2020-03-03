/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-8-16 下午1:16:02
 * @version v1.0
 */
@TransferBean
public class IMFetchGroupListVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String groupId; // 群组的ID
	private String groupName; // 群组的名称
	private String icon; // 群头像
	@Emoji
	private String nickname; // 群主昵称
	private String ownerId; // 群主IM ID
	private Integer isNodisturbing; // 是否免打扰 1 – 是, 0 – 否
	private Integer memberCount; // 群人数
	private Integer isOwner;// 是否是群主0-不是，1-是
	@TransferID
	private Long ownerUserId;
	private String isCharge; // 是否收费	String	Y – 收费 N - 免费;
	private String isFull	; //	是否满员	String	Y – 满员, N – 未满员
	private String groupType;
	public Long getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
	}

	public String getIsFull() {
		return isFull;
	}

	public void setIsFull(String isFull) {
		this.isFull = isFull;
	}

	public Integer getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Integer isOwner) {
		this.isOwner = isOwner;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getIsNodisturbing() {
		return isNodisturbing;
	}

	public void setIsNodisturbing(Integer isNodisturbing) {
		this.isNodisturbing = isNodisturbing;
	}

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}
}
