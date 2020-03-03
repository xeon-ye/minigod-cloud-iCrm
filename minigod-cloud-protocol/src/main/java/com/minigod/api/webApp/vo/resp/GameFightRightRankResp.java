/**
 * @Title: GameFightRightRankResp.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description
 * 
 * @author panlz
 * @date 2016-01-18 下午5:17:02
 * @version v1.0
 */

@TransferBean
public class GameFightRightRankResp implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private String uId; // 用户id
	private Integer myRank; // 我的排名
	private String myUserIcon; // 我的头像
	private String myUserName; // 我的昵称
	private Integer myRightNum; // 猜对次数
	private Integer myScore; // 分数

	private List<RightRankResp> datas;

	public List<RightRankResp> getDatas() {
		return datas;
	}

	public void setDatas(List<RightRankResp> datas) {
		this.datas = datas;
	}
	
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public Integer getMyRank() {
		return myRank;
	}

	public void setMyRank(Integer myRank) {
		this.myRank = myRank;
	}

	public String getMyUserIcon() {
		return myUserIcon;
	}

	public void setMyUserIcon(String myUserIcon) {
		this.myUserIcon = myUserIcon;
	}

	public String getMyUserName() {
		return myUserName;
	}

	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
	}

	public Integer getMyRightNum() {
		return myRightNum;
	}

	public void setMyRightNum(Integer myRightNum) {
		this.myRightNum = myRightNum;
	}

	public Integer getMyScore() {
		return myScore;
	}

	public void setMyScore(Integer myScore) {
		this.myScore = myScore;
	}

	public static class RightRankResp implements Serializable {
		private static final long serialVersionUID = 1L;
		private Integer rank; // 排名
		private String userIcon; // 头像
		private String userName; // 昵称
		private Integer rightNum; // 猜对次数
		private Integer score; // 分数 

		public Integer getRank() {
			return rank;
		}

		public void setRank(Integer rank) {
			this.rank = rank;
		}

		public String getUserIcon() {
			return userIcon;
		}

		public void setUserIcon(String userIcon) {
			this.userIcon = userIcon;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Integer getRightNum() {
			return rightNum;
		}

		public void setRightNum(Integer rightNum) {
			this.rightNum = rightNum;
		}

		public Integer getScore() {
			return score;
		}

		public void setScore(Integer score) {
			this.score = score;
		}
		
	}

}
