/**
 * @Title: BrokerLoginInfoRequestVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.ptf.vo.resp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.minigod.api.user.vo.SNVersion;
import com.minigod.common.anno.Emoji;
import com.minigod.common.anno.TransferBean;
import com.minigod.common.anno.TransferID;

/**
 * @description 委托概要查询返回类
 *
 * @author 许德佑
 * @date 2015-3-10 上午10:07:49
 * @version v1.0
 */
@TransferBean
public class SimuPtfOrderSummaryRespVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	@TransferID
	private Long ptfId; // pcminigod證券國際需返回
	@Emoji
	private String ptfName;
	
	private List<SimuPtfOrderSummaryRespVO_ord> ptfOrds;
	

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

	public List<SimuPtfOrderSummaryRespVO_ord> getPtfOrds() {
		return ptfOrds;
	}

	public void setPtfOrds(List<SimuPtfOrderSummaryRespVO_ord> ptfOrds) {
		this.ptfOrds = ptfOrds;
	}

	public static class SimuPtfOrderSummaryRespVO_ord implements Serializable {
		private static final long serialVersionUID = 1L;
		private Long ptfTransId;
		
		private String ptfOrdStat;
		
		private Date ptfOrdTs;
		
		private Double cfmAmt;
		
		private String ptfTransType;
		
		private String tips;

		public Long getPtfTransId() {
			return ptfTransId;
		}

		public void setPtfTransId(Long ptfTransId) {
			this.ptfTransId = ptfTransId;
		}

		public String getPtfTransType() {
			return ptfTransType;
		}

		public void setPtfTransType(String ptfTransType) {
			this.ptfTransType = ptfTransType;
		}

		public String getPtfOrdStat() {
			return ptfOrdStat;
		}

		public void setPtfOrdStat(String ptfOrdStat) {
			this.ptfOrdStat = ptfOrdStat;
		}

		public Date getPtfOrdTs() {
			return ptfOrdTs;
		}

		public void setPtfOrdTs(Date ptfOrdTs) {
			this.ptfOrdTs = ptfOrdTs;
		}

		public Double getCfmAmt() {
			return cfmAmt;
		}

		public void setCfmAmt(Double cfmAmt) {
			this.cfmAmt = cfmAmt;
		}

		public String getTips() {
			return tips;
		}

		public void setTips(String tips) {
			this.tips = tips;
		}
		
		

		

	}
	
	
}
