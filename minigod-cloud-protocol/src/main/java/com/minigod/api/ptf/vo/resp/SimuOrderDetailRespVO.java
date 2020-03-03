/**
 * @Title: OrderDetailRespVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 
 *
 * @author MiniGod
 * @date 2015-6-30 下午12:34:08
 * @version v1.0
 */

@TransferBean
public class SimuOrderDetailRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	@TransferID
	private Long ptfId; // pcminigod證券國際需返回
	@Emoji
	private String ptfName;
	private String isReal; // pcminigod證券國際需返回,Y-实盘，N-模拟盘
	private String ptfOrdStat;
	private Long ptfOrdTs;
	private String ptfTransType;
	private String tips;
	private String comStat;
	private Double cfmAmt;
	private List<SimuOrderDetailRespVO_stkOrd> stkOrds;
	
	public Long getPtfId() {
		return ptfId;
	}

	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}

	public String getPtfName() {
		return ptfName;
	}

	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}

	public String getIsReal() {
		return isReal;
	}

	public void setIsReal(String isReal) {
		this.isReal = isReal;
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

	public String getComStat() {
		return comStat;
	}

	public void setComStat(String comStat) {
		this.comStat = comStat;
	}

	public Double getCfmAmt() {
		return cfmAmt;
	}

	public void setCfmAmt(Double cfmAmt) {
		this.cfmAmt = cfmAmt;
	}

	public List<SimuOrderDetailRespVO_stkOrd> getStkOrds() {
		return stkOrds;
	}

	public void setStkOrds(List<SimuOrderDetailRespVO_stkOrd> stkOrds) {
		this.stkOrds = stkOrds;
	}

	public static class SimuOrderDetailRespVO_stkOrd implements Serializable {
		private static final long serialVersionUID = 1L;
		private String assetId;
		private String stkName;
		private String ordProp;
		private String ordBS;
		private String ordId;
		private String ordPrc;
		private Double ordQty;
		private String cfmPrc;
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
		public String getOrdProp() {
			return ordProp;
		}
		public void setOrdProp(String ordProp) {
			this.ordProp = ordProp;
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
