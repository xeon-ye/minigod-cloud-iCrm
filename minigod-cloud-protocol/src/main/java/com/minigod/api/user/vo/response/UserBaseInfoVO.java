package com.minigod.api.user.vo.response;

import java.io.Serializable;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * 登录用户信息输出
 */
@TransferBean
public class UserBaseInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@TransferID
	private Long userId; // 用户ID
	private Integer gender;// 用户性别(1男，0女)
	private String phoneNum;// 手机号
	private String userCode;//犇犇号 为用户ID ，平台ID做了加密混淆。暂用一个字段代替
	private Integer invUserId;//推荐人ID,邀请该用户的用户ID
	private String userSourceChannelId;//渠道id
	@Emoji
	private String profile;// 用户简介z

	@Emoji
	private String signature;// 用户签名
	private String bigUserIcon;// 大图像

	@Emoji
	private String nickname;// 用户昵称
	private String vTitle;// 认证头衔 1. 认证用户返回认证头衔 2. 非认证用户不返回
	private String userIcon;// 头像下载地址 缩略头像下载地址
	private Integer vType;// 认证标识 0为没有认证,1为已认证

	private Integer uType;// 默认所有用户均为1类型 1：普通用户；2：认证投顾，表示已经审核通过的投顾用户
	
	private String imId; // 第三方IM平台的ID
	
	private String imPwd; // 第三方IM平台的密码

	private String trdAccount;

	private String email;

	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTrdAccount() {
		return trdAccount;
	}

	public void setTrdAccount(String trdAccount) {
		this.trdAccount = trdAccount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public String getImPwd() {
		return imPwd;
	}

	public void setImPwd(String imPwd) {
		this.imPwd = imPwd;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getBigUserIcon() {
		return bigUserIcon;
	}

	public void setBigUserIcon(String bigUserIcon) {
		this.bigUserIcon = bigUserIcon;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getvTitle() {
		return vTitle;
	}

	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public Integer getvType() {
		return vType;
	}

	public void setvType(Integer vType) {
		this.vType = vType;
	}

	public Integer getuType() {
		return uType;
	}

	public void setuType(Integer uType) {
		this.uType = uType;
	}

	public Integer getInvUserId() {
		return invUserId;
	}

	public void setInvUserId(Integer invUserId) {
		this.invUserId = invUserId;
	}

	public String getUserSourceChannelId() {
		return userSourceChannelId;
	}

	public void setUserSourceChannelId(String userSourceChannelId) {
		this.userSourceChannelId = userSourceChannelId;
	}
}
