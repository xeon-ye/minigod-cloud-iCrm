package com.minigod.api.user.vo.response.adviser.crm;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 获取推荐好友信息对象
 */
@TransferBean
public class RespNewFriendVO implements Serializable {

	private static final long serialVersionUID = 340831528495266018L;

	@TransferID
	private Long userId;//用户ID

	@Emoji
	private String nickname;//用户昵称

	private String userIcon;//用户图像

	@Emoji
	private String message;//推荐信息提示

	private Integer isRead; // 信息是否已读

	private String srcMsg;//请求来源信息

	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)
	
	private Long uTime ;//时间

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}

	public String getSrcMsg() {
		return srcMsg;
	}

	public void setSrcMsg(String srcMsg) {
		this.srcMsg = srcMsg;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Long getuTime() {
		return uTime;
	}

	public void setuTime(Long uTime) {
		this.uTime = uTime;
	}
	
}
