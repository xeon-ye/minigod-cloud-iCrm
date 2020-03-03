package com.minigod.api.invconns.vo;

import java.io.Serializable;

/**
 * 
 * 
 * <code>FriInvConnsVO.java<code>[好友人脉信息实体]
 * 
 * @author Colin
 * @date 2015-1-3 下午4:07:07
 * 
 */

public class FriInvConnsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int userId; // 用户Id

	protected int userRanking;// 用户排名

	protected String userName;// 用户名称

	protected String userIcon;// 用户头像

	protected int userInfluence;// 当前用户影响力分数

	protected boolean isFriends = false;// 是否为minigod好友

	protected boolean isOwn = false;

	public int getUserRanking() {
		return userRanking;
	}

	public void setUserRanking(int userRanking) {
		this.userRanking = userRanking;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public boolean isFriends() {
		return isFriends;
	}

	public void setFriends(boolean isFriends) {
		this.isFriends = isFriends;
	}

	public int getUserInfluence() {
		return userInfluence;
	}

	public void setUserInfluence(int userInfluence) {
		this.userInfluence = userInfluence;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isOwn() {
		return isOwn;
	}

	public void setOwn(boolean isOwn) {
		this.isOwn = isOwn;
	}

}
