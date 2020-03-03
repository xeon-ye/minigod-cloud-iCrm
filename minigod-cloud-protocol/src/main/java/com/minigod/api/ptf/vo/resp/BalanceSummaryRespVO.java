/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 持仓查询返回类
 *
 * @author 许德佑
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class BalanceSummaryRespVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private Double assets; 
	private Double stkMktVal;
	private Double avlBal;
	private Double brkMktVal;
	private Double othVal;
	
	List<BalanceSummaryRespVO_BrkBal> brkBals;
	
	@TransferID
	@Emoji
	List<BalanceSummaryRespVO_PtfBal> ptfBals;
	
	public Double getOthVal() {
		return othVal;
	}


	public void setOthVal(Double othVal) {
		this.othVal = othVal;
	}


	public Double getAssets() {
		return assets;
	}


	public void setAssets(Double assets) {
		this.assets = assets;
	}


	public Double getStkMktVal() {
		return stkMktVal;
	}


	public void setStkMktVal(Double stkMktVal) {
		this.stkMktVal = stkMktVal;
	}


	public Double getAvlBal() {
		return avlBal;
	}


	public void setAvlBal(Double avlBal) {
		this.avlBal = avlBal;
	}


	public Double getBrkMktVal() {
		return brkMktVal;
	}


	public void setBrkMktVal(Double brkMktVal) {
		this.brkMktVal = brkMktVal;
	}


	public List<BalanceSummaryRespVO_BrkBal> getBrkBals() {
		return brkBals;
	}


	public void setBrkBals(List<BalanceSummaryRespVO_BrkBal> brkBals) {
		this.brkBals = brkBals;
	}


	public List<BalanceSummaryRespVO_PtfBal> getPtfBals() {
		return ptfBals;
	}


	public void setPtfBals(List<BalanceSummaryRespVO_PtfBal> ptfBals) {
		this.ptfBals = ptfBals;
	}


	public static class BalanceSummaryRespVO_BrkBal{
		private String assetId;
		private String stkName;
		
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

	}
	
	@TransferBean
	public static class BalanceSummaryRespVO_PtfBal{
		
		@TransferID
		private Long ptfId;
		
		private Integer ptfBalId;
		@Emoji
		private String ptfName;
		
		@TransferID
		private Long uId;
		@Emoji
		private String uName;
		
		private Double mktVal;
		
		private Double incBal;
		
		private Double tdInc;
		
		private String candel;

		public String getCandel() {
			return candel;
		}

		public void setCandel(String candel) {
			this.candel = candel;
		}

		public Long getPtfId() {
			return ptfId;
		}

		public void setPtfId(Long ptfId) {
			this.ptfId = ptfId;
		}

		public Integer getPtfBalId() {
			return ptfBalId;
		}

		public void setPtfBalId(Integer ptfBalId) {
			this.ptfBalId = ptfBalId;
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
		
	}
	

}







