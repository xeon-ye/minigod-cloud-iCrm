/**
 * @Title: IMFetchGroupListRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.im.vo.resp;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

import java.io.Serializable;

/**
 * @description
 * 
 * @author chenyouhuo
 * @date 2016-6-20 下午1:16:02
 * @version v1.0
 */
@TransferBean
public class IMGetChatRoomListVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String groupId; // 聊天室的ID
	private String groupName; // 聊天室的名称
	private String icon; // 聊天室头像
	private Integer memberCount; // 聊天室人数
	private String chatRoomKind;//聊天室种类：1官方，2港股，3美股，4期货
	private String ownerId;//群主ID
	private Integer isNodisturbing; // 是否免打扰 1 – 是, 0 – 否
	
	public Integer getIsNodisturbing() {
		return isNodisturbing;
	}

	public void setIsNodisturbing(Integer isNodisturbing) {
		this.isNodisturbing = isNodisturbing;
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

	public Integer getMemberCount() {
		return memberCount;
	}

	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	public String getChatRoomKind() {
		return chatRoomKind;
	}

	public void setChatRoomKind(String chatRoomKind) {
		this.chatRoomKind = chatRoomKind;
	}
}
