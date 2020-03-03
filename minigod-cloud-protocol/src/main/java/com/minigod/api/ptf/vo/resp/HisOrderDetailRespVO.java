/**
 * @Title: HisOrderSummaryRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-30 下午1:48:28
 * @version v1.0
 */
@TransferBean
public class HisOrderDetailRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	@Emoji
	private String ptfName;
	private String ptfOrdStat;
	private Long ptfOrdTs; // 组合委托的时间戳
	private String ptfTransType; // 组合交易类型
	private String tips;// 提示信息
	private Double cfmAmt; // 成交金额
	private List<HisOrderDetailRespVO_ord> stkOrds;
	
	public String getPtfName() {
		return ptfName;
	}
	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}
	public String getPtfOrdStat() {
		return ptfOrdStat;
	}
	public void setPtfOrdStat(String ptfOrdStat) {
		this.ptfOrdStat = ptfOrdStat;
	}
	public Long getPtfOrdTs() {
		return ptfOrdTs;
	}
	public void setPtfOrdTs(Long ptfOrdTs) {
		this.ptfOrdTs = ptfOrdTs;
	}
	public String getPtfTransType() {
		return ptfTransType;
	}
	public void setPtfTransType(String ptfTransType) {
		this.ptfTransType = ptfTransType;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Double getCfmAmt() {
		return cfmAmt;
	}
	public void setCfmAmt(Double cfmAmt) {
		this.cfmAmt = cfmAmt;
	}
	public List<HisOrderDetailRespVO_ord> getStkOrds() {
		return stkOrds;
	}
	public void setStkOrds(List<HisOrderDetailRespVO_ord> stkOrds) {
		this.stkOrds = stkOrds;
	}
	
	public static class HisOrderDetailRespVO_ord {
		private String assetId;
		private String stkName;
		private String ordBS;
		private String ordProp;
		private String ordPrc;
		private String cfmPrc;
		private Double ordQty;
		private Double cfmQty;
		private String ordStat;
		private String msg;
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
		public String getOrdProp() {
			return ordProp;
		}
		public void setOrdProp(String ordProp) {
			this.ordProp = ordProp;
		}
		public String getOrdPrc() {
			return ordPrc;
		}
		public void setOrdPrc(String ordPrc) {
			this.ordPrc = ordPrc;
		}
		public String getCfmPrc() {
			return cfmPrc;
		}
		public void setCfmPrc(String cfmPrc) {
			this.cfmPrc = cfmPrc;
		}
		public Double getOrdQty() {
			return ordQty;
		}
		public void setOrdQty(Double ordQty) {
			this.ordQty = ordQty;
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