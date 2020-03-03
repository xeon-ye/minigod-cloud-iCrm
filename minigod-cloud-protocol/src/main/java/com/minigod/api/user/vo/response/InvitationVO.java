package com.minigod.api.user.vo.response;

import com.minigod.api.user.vo.request.UserBaseVO;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 登录用户申请邀请码 
 */
@TransferBean
public class InvitationVO extends UserBaseVO {

	private static final long serialVersionUID = -7474468467007263622L;

	private Integer invId;//邀请码ID
	@TransferID
	private Long userId;//创建人userID
	private String userName;//创建者姓名
	private String invCode;// 邀请码
	private Integer invStatus;// 0已经使用 1还未使用
	private Integer invUserId;//使用者ID
	private String invUserName;// 使用者姓名
	private Long invUseTimestamp;//使用的时间戳

	public Integer getInvId() {
		return invId;
	}

	public void setInvId(Integer invId) {
		this.invId = invId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInvCode() {
		return invCode;
	}

	public void setInvCode(String invCode) {
		this.invCode = invCode;
	}

	public Integer getInvStatus() {
		return invStatus;
	}

	public void setInvStatus(Integer invStatus) {
		this.invStatus = invStatus;
	}

	public Integer getInvUserId() {
		return invUserId;
	}

	public void setInvUserId(Integer invUserId) {
		this.invUserId = invUserId;
	}

	public String getInvUserName() {
		return invUserName;
	}

	public void setInvUserName(String invUserName) {
		this.invUserName = invUserName;
	}

	public Long getInvUseTimestamp() {
		return invUseTimestamp;
	}

	public void setInvUseTimestamp(Long invUseTimestamp) {
		this.invUseTimestamp = invUseTimestamp;
	}
}
