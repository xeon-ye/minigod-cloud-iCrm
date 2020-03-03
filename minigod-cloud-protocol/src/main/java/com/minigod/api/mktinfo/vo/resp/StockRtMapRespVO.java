package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 *
 * @author panlz
 * @since  MiniGod 1.0 (2015-06-09)
 *
 */
public class StockRtMapRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private StockRtVo lastPrice;
	private StockRtVo averagePrice;
	private StockRtVo volume;

	public StockRtVo getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(StockRtVo lastPrice) {
		this.lastPrice = lastPrice;
	}

	public StockRtVo getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(StockRtVo averagePrice) {
		this.averagePrice = averagePrice;
	}

	public StockRtVo getVolume() {
		return volume;
	}

	public void setVolume(StockRtVo volume) {
		this.volume = volume;
	}

	public static class StockRtVo implements Serializable {
		private static final long serialVersionUID = 1L;
		private Double basePrice;
		private Object[][] data;

		public Double getBasePrice() {
			return basePrice;
		}

		public void setBasePrice(Double basePrice) {
			this.basePrice = basePrice;
		}

		public Object[][] getData() {
			return data;
		}

		public void setData(Object[][] data) {
			this.data = data;
		}
	}
}
