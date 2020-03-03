package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;

public class PtfCntRespVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rsPtfCnt = 0; // 实+模拟盘数量
	private Integer realPtfCnt = 0; // 实盘数量
	private Integer simuPtfCnt = 0; // 模拟盘数量
	private Integer favPtfCnt = 0; // 关注组合数量
	private Integer myPtfCnt = 0; // 我的组合数量
	private Integer allPtfCnt = 0; // 全部组合数量
	
	public Integer getRsPtfCnt() {
		return rsPtfCnt;
	}
	public void setRsPtfCnt(Integer rsPtfCnt) {
		this.rsPtfCnt = rsPtfCnt;
	}
	public Integer getRealPtfCnt() {
		return realPtfCnt;
	}
	public void setRealPtfCnt(Integer realPtfCnt) {
		this.realPtfCnt = realPtfCnt;
	}
	public Integer getSimuPtfCnt() {
		return simuPtfCnt;
	}
	public void setSimuPtfCnt(Integer simuPtfCnt) {
		this.simuPtfCnt = simuPtfCnt;
	}
	public Integer getFavPtfCnt() {
		return favPtfCnt;
	}
	public void setFavPtfCnt(Integer favPtfCnt) {
		this.favPtfCnt = favPtfCnt;
	}
	public Integer getMyPtfCnt() {
		return myPtfCnt;
	}
	public void setMyPtfCnt(Integer myPtfCnt) {
		this.myPtfCnt = myPtfCnt;
	}
	public Integer getAllPtfCnt() {
		return allPtfCnt;
	}
	public void setAllPtfCnt(Integer allPtfCnt) {
		this.allPtfCnt = allPtfCnt;
	}
	
	
}
