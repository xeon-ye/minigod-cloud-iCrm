package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;
@TransferBean
public class RespTelContactVO implements Serializable {

	private static final long serialVersionUID = 3176672955281189535L;

	private Integer contId;//联系人ID
	@TransferID
	private Long userId;//用户ID,已是minigod用户才有userId,不是minigod用户不传此字段
	
	@Emoji
	private String nickname;//用户昵称,已是minigod用户才有userId,不是minigod用户不传此字段
	
	private String userIcon;//头像绝对地址
	
	@Emoji
	private String relaName;//通讯录名称
	private Integer status;//状态信息
	private String phone;//手机号码
	private Integer uType;//用户类型(默认所有用户均为1类型;1：普通用户；2：认证投顾，表示已经审核通过的投顾用户；)
	
	public Integer getContId() {
		return contId;
	}
	public void setContId(Integer contId) {
		this.contId = contId;
	}
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
	public String getRelaName() {
		return relaName;
	}
	public void setRelaName(String relaName) {
		this.relaName = relaName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getuType() {
		return uType;
	}
	public void setuType(Integer uType) {
		this.uType = uType;
	}
}
