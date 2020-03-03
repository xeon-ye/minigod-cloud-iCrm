package com.minigod.api.mktmgr.vo.req;

import com.minigod.api.user.vo.SNVersion;

public class SubRtVO extends SNVersion {

	private static final long serialVersionUID = -3594324540170625743L;
	private String startDate;//yyyy-mm-dd
	private String endDate;//yyyy-mm-dd
	private String marketType = "1";
	private Integer year;
	private Integer month;
	
	private Boolean isPage = true;
	
	private String userIds;
	
	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}

	public Boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(Boolean isPage) {
		this.isPage = isPage;
	}

	// 当前页码
	private Integer curPage = 1;
	// 页码条数
	private Integer pageNum = Integer.MAX_VALUE;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getCurPage() {
		curPage = (curPage-1)*pageNum;
		return curPage;
	}

	public void setCurPage(Integer curPage) {
//		curPage = curPage != null ? curPage : 1;
		this.curPage = curPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
//		pageNum = pageNum != null ? pageNum : Integer.MAX_VALUE;
		this.pageNum = pageNum;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}
	
}
