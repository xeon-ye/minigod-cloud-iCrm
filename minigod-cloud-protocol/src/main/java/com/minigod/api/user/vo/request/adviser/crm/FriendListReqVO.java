package com.minigod.api.user.vo.request.adviser.crm;


import com.minigod.api.user.vo.SNUserBase;


public class FriendListReqVO  extends SNUserBase {

	private static final long serialVersionUID = -4023476842698514503L;

	private Integer page; //页数
	private Integer count;//数量
	private String sortFld;//排序方式
	private String sortDir;//排序方向
	
	private FriendAttribScreen screenObj;//筛选属性对象

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSortFld() {
		return sortFld;
	}

	public void setSortFld(String sortFld) {
		this.sortFld = sortFld;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

	public FriendAttribScreen getScreenObj() {
		return screenObj;
	}

	public void setScreenObj(FriendAttribScreen screenObj) {
		this.screenObj = screenObj;
	}
	
}
