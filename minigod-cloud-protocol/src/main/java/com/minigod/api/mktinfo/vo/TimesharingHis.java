/**
 * @Title: TimesharingHis.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
import java.util.List;
import java.util.TreeMap;

/**
 * <code>TimesharingHis</code>
 * 
 * @author Jimmy
 * @date 2015-7-17 下午5:40:00
 * @version v1.0
 */
public class TimesharingHis implements Serializable {
	private static final long serialVersionUID = 1L;
	private TreeMap<String, List<Timeshare>> data;

	public TreeMap<String, List<Timeshare>> getData() {
		return data;
	}

	public void setData(TreeMap<String, List<Timeshare>> data) {
		this.data = data;
	}

	public static class Timeshare implements Serializable {
		private static final long serialVersionUID = 1L;
		private String assetId;
		private Long ts;
		private String price; // 价格
		private String avg; // 均价
		private String vol; // 分钟成交量
		private String open; // 今开

		public String getOpen() {
			return open;
		}

		public void setOpen(String open) {
			this.open = open;
		}

		public String getAssetId() {
			return assetId;
		}

		public void setAssetId(String assetId) {
			this.assetId = assetId;
		}

		public Long getTs() {
			return ts;
		}

		public void setTs(Long ts) {
			this.ts = ts;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getAvg() {
			return avg;
		}

		public void setAvg(String avg) {
			this.avg = avg;
		}

		public String getVol() {
			return vol;
		}

		public void setVol(String vol) {
			this.vol = vol;
		}
	}
}
