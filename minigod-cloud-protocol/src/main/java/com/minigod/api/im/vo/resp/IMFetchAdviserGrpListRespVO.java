/**
 * @Title: IMFetchAdviserGrpListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import java.io.Serializable;
import java.util.Date;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2015-11-4 下午7:57:17
 * @version v1.0
 */
@TransferBean
public class IMFetchAdviserGrpListRespVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String groupId; // 群组的ID
	private String ownerId; // 群主ID 第三方IM平台IM ID
	@TransferID
	private Long ownerUserId; // 群主的用户ID
	private String groupName; // 群组的名称
	private String icon; // 群头像
	private Integer memberCount; // 群人数
	private String isCharge; // 是否收费 Y – 收费, N – 免费
	private String isFull; // 是否满员 Y – 满员 N – 未满员, C - 即将满员
	private String isJoined; // 是否已经加入 Y – 已经加入, N – 未加入
	private String description;
	private String needVerify; // 是否需要验证,Y – 需要, N – 不需要 (收费的群组只能取值为N)
	private transient Date createTime; // 创建的时间
	private Integer maxUsers;
	
	public Integer getMaxUsers() {
		return maxUsers;
	}
	public void setMaxUsers(Integer maxUsers) {
		this.maxUsers = maxUsers;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNeedVerify() {
		return needVerify;
	}

	public void setNeedVerify(String needVerify) {
		this.needVerify = needVerify;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Long getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
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

	public String getIsFull() {
		return isFull;
	}

	public void setIsFull(String isFull) {
		this.isFull = isFull;
	}

	public String getIsJoined() {
		return isJoined;
	}

	public void setIsJoined(String isJoined) {
		this.isJoined = isJoined;
	}
}
