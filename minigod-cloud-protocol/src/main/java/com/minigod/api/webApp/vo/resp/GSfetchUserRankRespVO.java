/**
 * @Title: GSfetchUserRankRespVO.java
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
 * @author MiniGod
 * @date 2015-9-16 下午3:55:55
 * @version v1.0
 */

@TransferBean
public class GSfetchUserRankRespVO  implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer myRank;
	private String myUserName;
	private String myUserIcon;
	private Double myTotalYield;
	@TransferID
	private String gameUserId;
	private List<GSfetchUserRankRespVO_data> datas;
	
	public String getGameUserId() {
		return gameUserId;
	}

	public void setGameUserId(String gameUserId) {
		this.gameUserId = gameUserId;
	}

	public Integer getMyRank() {
		return myRank;
	}

	public void setMyRank(Integer myRank) {
		this.myRank = myRank;
	}

	public String getMyUserName() {
		return myUserName;
	}

	public void setMyUserName(String myUserName) {
		this.myUserName = myUserName;
	}

	public String getMyUserIcon() {
		return myUserIcon;
	}

	public void setMyUserIcon(String myUserIcon) {
		this.myUserIcon = myUserIcon;
	}

	public Double getMyTotalYield() {
		return myTotalYield;
	}

	public void setMyTotalYield(Double myTotalYield) {
		this.myTotalYield = myTotalYield;
	}

	public List<GSfetchUserRankRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<GSfetchUserRankRespVO_data> datas) {
		this.datas = datas;
	}

	public static class GSfetchUserRankRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private Integer rank;
		private String userName;
		private String userIcon;
		private Double totalYield;
		public Integer getRank() {
			return rank;
		}
		public void setRank(Integer rank) {
			this.rank = rank;
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
		public Double getTotalYield() {
			return totalYield;
		}
		public void setTotalYield(Double totalYield) {
			this.totalYield = totalYield;
		}
	}
}
