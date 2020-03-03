/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/
package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.List;

import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * <code>PtfFollowerRspVO<code>
 *
 * @author Jimmy
 * @since MiniGod v0.0.1 (2014-12-5)
 *
 */
@TransferBean
public class CheckSimuAdjustRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@TransferID
	private Long ptfId; // pcminigod需返回
	@Emoji
	private String ptfName; // pcminigod需返回
	private Double avlBal; // 可用资金
	private Double ttlBal; // 所有资金
	private Double cashPct; // pcminigod需返回，现金仓位占比
	private Double assets; // 总资产
	private List<CheckSimuAdjustRespVO_stk> stks;// 股票列表

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

	public Double getAvlBal() {
		return avlBal;
	}

	public void setAvlBal(Double avlBal) {
		this.avlBal = avlBal;
	}

	public Double getTtlBal() {
		return ttlBal;
	}

	public void setTtlBal(Double ttlBal) {
		this.ttlBal = ttlBal;
	}

	public Double getCashPct() {
		return cashPct;
	}

	public void setCashPct(Double cashPct) {
		this.cashPct = cashPct;
	}

	public List<CheckSimuAdjustRespVO_stk> getStks() {
		return stks;
	}

	public void setStks(List<CheckSimuAdjustRespVO_stk> stks) {
		this.stks = stks;
	}

	public Double getAssets() {
		return assets;
	}

	public void setAssets(Double assets) {
		this.assets = assets;
	}



	public static class CheckSimuAdjustRespVO_stk implements Serializable {

		private static final long serialVersionUID = 1L;
		
		private String assetId;// 资产ID
		private String stkName;// 股票名
		private double tBal;// 总余额
		private String price;// 现价
		private String buyCalPrc;//计算最大可买股数用的单股价格
		private double aBal;// 可用余额
		private Integer status;// 股票状态标示
		private double changePct;// 涨跌幅
		private double weight;// 仓位
		private double pct;//pcminigod用,市值所占百分比 总市值= ttlBal+ stks中的所有股票 tBal* price
		
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
		public double gettBal() {
			return tBal;
		}
		public void settBal(double tBal) {
			this.tBal = tBal;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getBuyCalPrc() {
			return buyCalPrc;
		}
		public void setBuyCalPrc(String buyCalPrc) {
			this.buyCalPrc = buyCalPrc;
		}
		public double getaBal() {
			return aBal;
		}
		public void setaBal(double aBal) {
			this.aBal = aBal;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public double getPct() {
			return pct;
		}
		public void setPct(double pct) {
			this.pct = pct;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getChangePct() {
			return changePct;
		}
		public void setChangePct(double changePct) {
			this.changePct = changePct;
		}
		

	}

}
