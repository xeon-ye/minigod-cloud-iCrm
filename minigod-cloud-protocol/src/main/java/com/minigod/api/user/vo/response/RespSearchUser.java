package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class RespSearchUser implements Serializable {
	private static final long serialVersionUID = 8345171190733276415L;
	@TransferID
	private Long userId;//		用户ID	Int64	用户ID
	@Emoji
	private String nickname;//	用户昵称	String	用户昵称
	
	private String userIcon; //	头像绝对地址	String	头像地址
	private Integer gender;//	性别	Int8	1男，0女
	
	@Emoji
	private String signature;//		签名	String	用户签名信息
	private Integer status; //	状态信息	Int8	0表示待接受添加请求的好友，1表示还未成为好友但可发送添加邀请的好友，2表示已添加的好友。
	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)
	
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

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}
}
