package com.minigod.api.mktinfo.vo.req;

import com.minigod.api.user.vo.SNVersion;
public class StockAnalyzeReqVO extends SNVersion {

	private static final long serialVersionUID = 1L;
	
	private ShortSellingParamVO params;
	
	public ShortSellingParamVO getParams() {
		return params;
	}
	public void setParams(ShortSellingParamVO params) {
		this.params = params;
	}

	public class ShortSellingParamVO {
		
		private String assetId;
		
		private Long date;
		
		private String buyOrSaleStatus;
		
		private String dateInterval;
		
		public String getAssetId() {
			return assetId;
		}
		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}
		public Long getDate() {
			return date;
		}
		public void setDate(Long date) {
			this.date = date;
		}
		public String getBuyOrSaleStatus() {
			return buyOrSaleStatus;
		}
		public void setBuyOrSaleStatus(String buyOrSaleStatus) {
			this.buyOrSaleStatus = buyOrSaleStatus;
		}
		public String getDateInterval() {
			return dateInterval;
		}
		public void setDateInterval(String dateInterval) {
			this.dateInterval = dateInterval;
		}
	}
}
