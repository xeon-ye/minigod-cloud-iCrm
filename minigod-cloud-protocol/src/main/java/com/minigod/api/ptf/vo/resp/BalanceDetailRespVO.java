/*******************************************************************************
 * Copyright (c) 2016 minigod minigod.Co.Ltd. All rights reserved.
 ******************************************************************************/

package com.minigod.api.ptf.vo.resp;

import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 持仓详情查询返回类
 *
 * @author 许德佑
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class BalanceDetailRespVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	@TransferID
	private Long ptfId;
	@Emoji
	private String ptfName;
	
	@TransferID
	private Long uId;
	@Emoji
	private String uName;
	private Double stkVal;
	private Double avlBal;
	private Double mktVal;
	private Double incBal;
	private Double tdInc;
	private String isOwner;
	private List<BalanceDetailRespVO_stk> stks;
	
	
	
	public Long getPtfId() {
		return ptfId;
	}



	public void setPtfId(Long ptfId) {
		this.ptfId = ptfId;
	}



	public Double getStkVal() {
		return stkVal;
	}



	public void setStkVal(Double stkVal) {
		this.stkVal = stkVal;
	}



	public Double getAvlBal() {
		return avlBal;
	}



	public void setAvlBal(Double avlBal) {
		this.avlBal = avlBal;
	}



	public String getPtfName() {
		return ptfName;
	}



	public void setPtfName(String ptfName) {
		this.ptfName = ptfName;
	}



	public Long getuId() {
		return uId;
	}



	public void setuId(Long uId) {
		this.uId = uId;
	}



	public String getuName() {
		return uName;
	}



	public void setuName(String uName) {
		this.uName = uName;
	}



	public Double getMktVal() {
		return mktVal;
	}



	public void setMktVal(Double mktVal) {
		this.mktVal = mktVal;
	}



	public Double getIncBal() {
		return incBal;
	}



	public void setIncBal(Double incBal) {
		this.incBal = incBal;
	}



	public Double getTdInc() {
		return tdInc;
	}



	public void setTdInc(Double tdInc) {
		this.tdInc = tdInc;
	}



	public String getIsOwner() {
		return isOwner;
	}



	public void setIsOwner(String isOwner) {
		this.isOwner = isOwner;
	}



	public List<BalanceDetailRespVO_stk> getStks() {
		return stks;
	}



	public void setStks(List<BalanceDetailRespVO_stk> stks) {
		this.stks = stks;
	}



	public static class BalanceDetailRespVO_stk{
		private String assetId;
		private String stkName;
		private Double tBal;
		private Double aBal;
		private String price;
		private String costPrc;
		private Double mktVal;
		private Double incBal;
		private Double weight;
		private Double hldYld;
		
		public Double getHldYld() {
			return hldYld;
		}
		public void setHldYld(Double hldYld) {
			this.hldYld = hldYld;
		}
		public Double getWeight() {
			return weight;
		}
		public void setWeight(Double weight) {
			this.weight = weight;
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
		public Double gettBal() {
			return tBal;
		}
		public void settBal(Double tBal) {
			this.tBal = tBal;
		}
		public Double getaBal() {
			return aBal;
		}
		public void setaBal(Double aBal) {
			this.aBal = aBal;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getCostPrc() {
			return costPrc;
		}
		public void setCostPrc(String costPrc) {
			this.costPrc = costPrc;
		}
		public Double getMktVal() {
			return mktVal;
		}
		public void setMktVal(Double mktVal) {
			this.mktVal = mktVal;
		}
		public Double getIncBal() {
			return incBal;
		}
		public void setIncBal(Double incBal) {
			this.incBal = incBal;
		}

	}
	
	
}
