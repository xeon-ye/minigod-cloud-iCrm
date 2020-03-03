/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

/**
 * @description
 * 
 * @author 谢尚河
 * @date 2016-2-25 下午3:29:09
 * @version v1.0
 */

public class GetPtfTransRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<GetPtfTransRespPtfOrds> ptfOrds;

	public List<GetPtfTransRespPtfOrds> getPtfOrds() {
		return ptfOrds;
	}

	public void setPtfOrds(List<GetPtfTransRespPtfOrds> ptfOrds) {
		this.ptfOrds = ptfOrds;
	}

	public static class GetPtfTransRespPtfOrds implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long ptfTransId;// 交易编号
		private Long ptfOrdTs;// 组合委托的时间戳
		private String comStat;// 是否允许写投资理念
		private String withdrawable;// 是否可撤单
		private List<GetPtfTransRespStkOrds> stkOrds;

		public Long getPtfTransId() {
			return ptfTransId;
		}

		public void setPtfTransId(Long ptfTransId) {
			this.ptfTransId = ptfTransId;
		}

		public Long getPtfOrdTs() {
			return ptfOrdTs;
		}

		public void setPtfOrdTs(Long ptfOrdTs) {
			this.ptfOrdTs = ptfOrdTs;
		}

		public String getComStat() {
			return comStat;
		}

		public void setComStat(String comStat) {
			this.comStat = comStat;
		}

		public String getWithdrawable() {
			return withdrawable;
		}

		public void setWithdrawable(String withdrawable) {
			this.withdrawable = withdrawable;
		}

		public List<GetPtfTransRespStkOrds> getStkOrds() {
			return stkOrds;
		}

		public void setStkOrds(List<GetPtfTransRespStkOrds> stkOrds) {
			this.stkOrds = stkOrds;
		}

	}

	public static class GetPtfTransRespStkOrds implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String ordProp;// 报价方式
		private String assetId;// 资产ID
		private String stkName;// 股票名称
		private String ordBS;// 买卖方向
		private String ordId;// 委托号
		private String ordPrc;// 委托价格
		private Double ordQty;// 委托数量
		private String cfmPrc;// 成交价格
		private Double cfmQty;// 成交数量
		private String ordStat;// 个股委托状态
		private String msg;// 提示信息

		public String getOrdProp() {
			return ordProp;
		}

		public void setOrdProp(String ordProp) {
			this.ordProp = ordProp;
		}

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public String getStkName() {
			return stkName;
		}

		public void setStkName(String stkName) {
			this.stkName = stkName;
		}

		public String getOrdBS() {
			return ordBS;
		}

		public void setOrdBS(String ordBS) {
			this.ordBS = ordBS;
		}

		public String getOrdId() {
			return ordId;
		}

		public void setOrdId(String ordId) {
			this.ordId = ordId;
		}

		public String getOrdPrc() {
			return ordPrc;
		}

		public void setOrdPrc(String ordPrc) {
			this.ordPrc = ordPrc;
		}

		public Double getOrdQty() {
			return ordQty;
		}

		public void setOrdQty(Double ordQty) {
			this.ordQty = ordQty;
		}

		public String getCfmPrc() {
			return cfmPrc;
		}

		public void setCfmPrc(String cfmPrc) {
			this.cfmPrc = cfmPrc;
		}

		public Double getCfmQty() {
			return cfmQty;
		}

		public void setCfmQty(Double cfmQty) {
			this.cfmQty = cfmQty;
		}

		public String getOrdStat() {
			return ordStat;
		}

		public void setOrdStat(String ordStat) {
			this.ordStat = ordStat;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

	}

}
