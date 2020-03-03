package com.minigod.api.user.vo.response;

import java.io.Serializable;

public class RespUnreadCntVO implements Serializable {

	private static final long serialVersionUID = 3176672955281189535L;

	private Integer invCnt;//投资圈未读数量
	private Integer sysCnt;//系统通知未读数量
	private Integer nfCnt;//新的好友未读数量
	private Integer ncCnt;//新的好友仅统计需同意的，投顾CRM用
	
	public Integer getInvCnt() {
		return invCnt;
	}
	public void setInvCnt(Integer invCnt) {
		this.invCnt = invCnt;
	}
	public Integer getSysCnt() {
		return sysCnt;
	}
	public void setSysCnt(Integer sysCnt) {
		this.sysCnt = sysCnt;
	}
	public Integer getNfCnt() {
		return nfCnt;
	}
	public void setNfCnt(Integer nfCnt) {
		this.nfCnt = nfCnt;
	}
	public Integer getNcCnt() {
		return ncCnt;
	}
	public void setNcCnt(Integer ncCnt) {
		this.ncCnt = ncCnt;
	}
	
}
