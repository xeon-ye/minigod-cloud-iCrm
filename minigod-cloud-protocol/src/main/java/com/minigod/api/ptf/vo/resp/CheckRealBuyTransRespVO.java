/*
 * FileName: AdjInfoRespVO.java
 * Copyright: Copyright 2014-11-10 MiniGod Tech. Co. Ltd.All right reserved.
 * Description: 
 *
 */
package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 
 * @description 实盘组合买入预检返回值对象
 *
 * @author minigod
 * @date 2015-3-16 下午5:07:39
 * @version v1.0
 */
public class CheckRealBuyTransRespVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double avlBal; // 可用资金
	private int maxPiece; // 最大份数
	
	//组合股票
	private List<Map<String, Object>> stks = new ArrayList<Map<String,Object>>();
	
	private String rstMsgs;

	public Double getAvlBal() {
		return avlBal;
	}

	public void setAvlBal(Double avlBal) {
		this.avlBal = avlBal;
	}

	public int getMaxPiece() {
		return maxPiece;
	}

	public void setMaxPiece(int maxPiece) {
		this.maxPiece = maxPiece;
	}

	public List<Map<String, Object>> getStks() {
		return stks;
	}

	public void setStks(List<Map<String, Object>> stks) {
		this.stks = stks;
	}

	public String getRstMsgs() {
		return rstMsgs;
	}

	public void setRstMsgs(String rstMsgs) {
		this.rstMsgs = rstMsgs;
	}	
}
