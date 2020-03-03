/**
 * @Title: AdAdviserMonthWinRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.webApp.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-10-29 上午9:05:53
 * @version v1.0
 */

public class AdAdviserMonthWinRespVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer isJoin; // 是否报名 0-未报名，1-已报名
	private Integer adStatus; // 活动状态  0-活动未结束，1-活动已结束，2-报名结束
	private Integer myRank; // 我的排名
	private String myYield; // 我的组合收益率
	private List<AdAdviserMonthWinRespVO_data> datas; 
	
	public Integer getAdStatus() {
		return adStatus;
	}

	public void setAdStatus(Integer adStatus) {
		this.adStatus = adStatus;
	}

	public Integer getIsJoin() {
		return isJoin;
	}

	public void setIsJoin(Integer isJoin) {
		this.isJoin = isJoin;
	}

	public Integer getMyRank() {
		return myRank;
	}

	public void setMyRank(Integer myRank) {
		this.myRank = myRank;
	}

	public String getMyYield() {
		return myYield;
	}

	public void setMyYield(String myYield) {
		this.myYield = myYield;
	}

	public List<AdAdviserMonthWinRespVO_data> getDatas() {
		return datas;
	}

	public void setDatas(List<AdAdviserMonthWinRespVO_data> datas) {
		this.datas = datas;
	}

	public static class AdAdviserMonthWinRespVO_data implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String ptfName; // 组合名
		private String yield; // 组合收益率
		private String userName; // 组合创建者名称
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
		}
		public String getYield() {
			return yield;
		}
		public void setYield(String yield) {
			this.yield = yield;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
	}
}
