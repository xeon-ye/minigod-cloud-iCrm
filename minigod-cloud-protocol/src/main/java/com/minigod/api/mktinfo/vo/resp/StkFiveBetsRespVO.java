/**
 * @Title: StkFiveBetsResoVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo.resp;

import java.io.Serializable;

/**
 * @description 个股五档行情返回VO
 *
 * @author 余俊斌
 * @date 2015年3月11日 下午3:06:48
 * @version v1.0
 */

public class StkFiveBetsRespVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private double changePct;
	private String price;
	private String prevClose;
	private String limitup;
	private String limitdown;
	private Bid bid;
	private Ask ask;

	public StkFiveBetsRespVO() {
		super();
		this.bid = new Bid();
		this.ask = new Ask();
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public Ask getAsk() {
		return ask;
	}

	public void setAsk(Ask ask) {
		this.ask = ask;
	}

	public double getChangePct() {
		return changePct;
	}

	public void setChangePct(double changePct) {
		this.changePct = changePct;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(String prevClose) {
		this.prevClose = prevClose;
	}

	public String getLimitup() {
		return limitup;
	}

	public void setLimitup(String limitup) {
		this.limitup = limitup;
	}

	public String getLimitdown() {
		return limitdown;
	}

	public void setLimitdown(String limitdown) {
		this.limitdown = limitdown;
	}

	/**
	 * 买盘价格
	 * 
	 * @description 买盘价格
	 *
	 * @author 余俊斌
	 * @date 2015年3月11日 下午3:10:33
	 * @version v1.0
	 */
	public class Bid implements Serializable {
		private static final long serialVersionUID = 1L;
		private String[] price;
		private long[] vol;

		public String[] getPrice() {
			return price;
		}

		public void setPrice(String[] price) {
			this.price = price;
		}

		public long[] getVol() {
			return vol;
		}

		public void setVol(long[] vol) {
			this.vol = vol;
		}
	}

	/**
	 * 卖盘价格
	 * 
	 * @description 卖盘价格
	 *
	 * @author 余俊斌
	 * @date 2015年3月11日 下午3:10:54
	 * @version v1.0
	 */
	public class Ask  implements Serializable {
		private static final long serialVersionUID = 1L;
		private String[] price;
		private long[] vol;

		public String[] getPrice() {
			return price;
		}

		public void setPrice(String[] price) {
			this.price = price;
		}

		public long[] getVol() {
			return vol;
		}

		public void setVol(long[] vol) {
			this.vol = vol;
		}
	}
}
