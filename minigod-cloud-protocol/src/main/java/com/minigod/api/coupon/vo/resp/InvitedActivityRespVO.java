/**
 * @Title: InvitedActivityRespVO.java
 * @Copyright: © 2016 minigod
 * @Company: minigod
 */

package com.minigod.api.coupon.vo.resp;

import java.io.Serializable;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author Jimmy
 * @date 2016-1-26 上午11:10:34
 * @version v1.0
 */
@TransferBean
public class InvitedActivityRespVO implements Serializable {
	private static final long serialVersionUID = -1277901888514472036L;
	@TransferID
	private String userId;

	private Inviter inviter;

	private Invited invited;

	private String nickname; // 昵称
	
	private String icon; // 头像
	
	private Integer userType; // 用户类型

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Inviter getInviter() {
		return inviter;
	}

	public void setInviter(Inviter inviter) {
		this.inviter = inviter;
	}

	public Invited getInvited() {
		return invited;
	}

	public void setInvited(Invited invited) {
		this.invited = invited;
	}
	
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public static class Invited implements Serializable {
		private static final long serialVersionUID = -6695182695548926492L;

		private String myRate; // 我的加息利率
		private String friendRate; // 好友的加息利率
		private String baseRate; // minigod證券國際活期起始利率
		private String profit; // 收益

		public String getMyRate() {
			return myRate;
		}

		public void setMyRate(String myRate) {
			this.myRate = myRate;
		}

		public String getFriendRate() {
			return friendRate;
		}

		public void setFriendRate(String friendRate) {
			this.friendRate = friendRate;
		}

		public String getBaseRate() {
			return baseRate;
		}

		public void setBaseRate(String baseRate) {
			this.baseRate = baseRate;
		}

		public String getProfit() {
			return profit;
		}

		public void setProfit(String profit) {
			this.profit = profit;
		}

	}

	public static class Inviter implements Serializable {
		private static final long serialVersionUID = -6695182695548926492L;
		private MyReward myReward;
		private FriendReward friendReward;

		public MyReward getMyReward() {
			return myReward;
		}

		public void setMyReward(MyReward myReward) {
			this.myReward = myReward;
		}

		public FriendReward getFriendReward() {
			return friendReward;
		}

		public void setFriendReward(FriendReward friendReward) {
			this.friendReward = friendReward;
		}

	}

	public static class FriendReward implements Serializable {
		/** */
		private static final long serialVersionUID = -8475553280077043904L;

		private String maxRate;// 最高的加息利率
		private String reg;// 注册获得的加息利率

		public String getMaxRate() {
			return maxRate;
		}

		public void setMaxRate(String maxRate) {
			this.maxRate = maxRate;
		}

		public String getReg() {
			return reg;
		}

		public void setReg(String reg) {
			this.reg = reg;
		}

	}

	public static class MyReward implements Serializable {
		/** */
		private static final long serialVersionUID = -6044093343574305740L;
		private String maxRate; // 最高的加息利率
		private String regInvite; // 邀请好友注册的加息利率
		private String fnlInvite; // 邀请好友入金的加息利率

		public String getMaxRate() {
			return maxRate;
		}

		public void setMaxRate(String maxRate) {
			this.maxRate = maxRate;
		}

		public String getRegInvite() {
			return regInvite;
		}

		public void setRegInvite(String regInvite) {
			this.regInvite = regInvite;
		}

		public String getFnlInvite() {
			return fnlInvite;
		}

		public void setFnlInvite(String fnlInvite) {
			this.fnlInvite = fnlInvite;
		}

	}

}
