/**
 * @Title: GameFightWinRankResp.java
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
public class GameFightWinRankResp implements Serializable {
	private static final long serialVersionUID = 1L;

	@TransferID
	private String uId; // 用户id
	private Integer myRank; // 我的排名
	private String myUserIcon; // 我的头像
	private String myUserName; // 我的昵称
	private Integer myWinNum; // 我的连胜天数

	private List<WinRankResp> datas;

	public List<WinRankResp> getDatas() {
		return datas;
	}

	public void setDatas(List<WinRankResp> datas) {
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

	public Integer getMyWinNum() {
		return myWinNum;
	}

	public void setMyWinNum(Integer myWinNum) {
		this.myWinNum = myWinNum;
	}

	public static class WinRankResp implements Serializable {
		private static final long serialVersionUID = 1L;
		private Integer rank; // 排名
		private String userIcon; // 头像
		private String userName; // 昵称
		private Integer winNum; // 连胜天数

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

		public Integer getWinNum() {
			return winNum;
		}

		public void setWinNum(Integer winNum) {
			this.winNum = winNum;
		}
	}

}
