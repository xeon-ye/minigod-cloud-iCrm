/**
 * @Title: PtfFollowCheckVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import com.minigod.api.ptf.vo.resp.PtfFollowStkVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 跟单预检返回
 *
 * @author 余俊斌
 * @date 2015年3月26日 上午11:03:57
 * @version v1.0
 */

public class PtfFollowCheckRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Double avlBal;
	// 预检结果
	private List<PtfFollowStkVO> stks;
	// 组合买入提示信息
	private List<String> rstMsgs;
	// 组合版本
	private Integer ptfVer;

	public PtfFollowCheckRespVO() {
		super();
		stks = new ArrayList<PtfFollowStkVO>();
		rstMsgs = new ArrayList<String>();
	}
	
	

	public Double getAvlBal() {
		return avlBal;
	}

	public void setAvlBal(Double avlBal) {
		this.avlBal = avlBal;
	}

	public Integer getPtfVer() {
		return ptfVer;
	}

	public void setPtfVer(Integer ptfVer) {
		this.ptfVer = ptfVer;
	}

	public List<PtfFollowStkVO> getStks() {
		return stks;
	}

	public void setStks(List<PtfFollowStkVO> stks) {
		this.stks = stks;
	}

	public List<String> getRstMsgs() {
		return rstMsgs;
	}

	public void setRstMsgs(List<String> rstMsgs) {
		this.rstMsgs = rstMsgs;
	}

}
