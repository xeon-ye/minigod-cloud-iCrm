package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

/**
 * <code>NetworkRankingVO<code> 投资人脉用户排名实体
 * 
 * @author Jane
 * @since MiniGod v0.0.1 (2014-12-26)
 * 
 */
public class NetworkRankingVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userRanking;// 用户排名

	private String userName;// 用户名称

	private String userImage;// 用户头像

	private String friendsState;// 好友状态

	public String getUserRanking() {
		return userRanking;
	}

	public void setUserRanking(String userRanking) {
		this.userRanking = userRanking;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getFriendsState() {
		return friendsState;
	}

	public void setFriendsState(String friendsState) {
		this.friendsState = friendsState;
	}

}
