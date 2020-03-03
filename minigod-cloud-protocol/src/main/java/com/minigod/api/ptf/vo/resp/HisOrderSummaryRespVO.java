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
public class HisOrderSummaryRespVO extends SNVersion {
	private static final long serialVersionUID = 1L;
	
	@Emoji
	private List<HisOrderSummaryRespVO_tran> ptfOrds;
	
	public List<HisOrderSummaryRespVO_tran> getPtfOrds() {
		return ptfOrds;
	}
	public void setPtfOrds(List<HisOrderSummaryRespVO_tran> ptfOrds) {
		this.ptfOrds = ptfOrds;
	}

	public static class HisOrderSummaryRespVO_tran {
		private Integer ptfTransId;
		@Emoji
		private String ptfName;
		private String ptfTransType;
		private String ptfOrdStat;
		private Double cfmAmt;
		private Long ptfOrdTs;
		private String tips;
		public Integer getPtfTransId() {
			return ptfTransId;
		}
		public void setPtfTransId(Integer ptfTransId) {
			this.ptfTransId = ptfTransId;
		}
		public String getPtfName() {
			return ptfName;
		}
		public void setPtfName(String ptfName) {
			this.ptfName = ptfName;
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
		public Double getCfmAmt() {
			return cfmAmt;
		}
		public void setCfmAmt(Double cfmAmt) {
			this.cfmAmt = cfmAmt;
		}
		public Long getPtfOrdTs() {
			return ptfOrdTs;
		}
		public void setPtfOrdTs(Long ptfOrdTs) {
			this.ptfOrdTs = ptfOrdTs;
		}
		public String getTips() {
			return tips;
		}
		public void setTips(String tips) {
			this.tips = tips;
		}
		
	}
}
