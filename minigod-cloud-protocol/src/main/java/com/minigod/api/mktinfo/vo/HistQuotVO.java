/**
 * @Title: HistQuotVO.java
 * @Copyright: © 2015 minigod
 * @Company: minigod
 */

package com.minigod.api.mktinfo.vo;

import java.io.Serializable;

/**
 * @description 历史行情（根父类）
 *
 * @author 余俊斌
 * @date 2015年7月20日 下午3:00:45
 * @version v1.0
 */

public class HistQuotVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String assetId; // 资产ID 如：600900.SH
	private String date; // 日期
	private String stkCode; // 股票代码 如：600900
	private Double open; // 开市价
	private Double close; // 收市价
	private Double prevClose; // 前收市价
	private Double high; // 最高价
	private Double low; // 最低价
	private Double volume; // 成交量
	private Double turnover; // 成交额
	private Double turnRate; // 换手率
	private Double kVal; // K值(KDJ)
	private Double dVal; // D值(KDJ)
	private Double jVal; // J值(KDJ)
	private Double ema1; // ema1值(MACD)
	private Double ema2; // ema2值(MACD)
	private Double dea; // dea值(MACD)
	private Double upSeq1; // 6日涨序列值(RSI)
	private Double downSeq1; // 6日跌序列值(RSI)
	private Double upSeq2; // 12日涨序列值(RSI)
	private Double downSeq2; // 12日跌序列值(RSI)
	private Double upSeq3; // 24日涨序列值(RSI)
	private Double downSeq3; // 24日跌序列值(RSI)

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStkCode() {
		return stkCode;
	}

	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Double getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(Double prevClose) {
		this.prevClose = prevClose;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getTurnover() {
		return turnover;
	}

	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}

	public Double getTurnRate() {
		return turnRate;
	}

	public void setTurnRate(Double turnRate) {
		this.turnRate = turnRate;
	}

	public Double getkVal() {
		return kVal;
	}

	public void setkVal(Double kVal) {
		this.kVal = kVal;
	}

	public Double getdVal() {
		return dVal;
	}

	public void setdVal(Double dVal) {
		this.dVal = dVal;
	}

	public Double getjVal() {
		return jVal;
	}

	public void setjVal(Double jVal) {
		this.jVal = jVal;
	}

	public Double getEma1() {
		return ema1;
	}

	public void setEma1(Double ema1) {
		this.ema1 = ema1;
	}

	public Double getEma2() {
		return ema2;
	}

	public void setEma2(Double ema2) {
		this.ema2 = ema2;
	}

	public Double getDea() {
		return dea;
	}

	public void setDea(Double dea) {
		this.dea = dea;
	}

	public Double getUpSeq1() {
		return upSeq1;
	}

	public void setUpSeq1(Double upSeq1) {
		this.upSeq1 = upSeq1;
	}

	public Double getDownSeq1() {
		return downSeq1;
	}

	public void setDownSeq1(Double downSeq1) {
		this.downSeq1 = downSeq1;
	}

	public Double getUpSeq2() {
		return upSeq2;
	}

	public void setUpSeq2(Double upSeq2) {
		this.upSeq2 = upSeq2;
	}

	public Double getDownSeq2() {
		return downSeq2;
	}

	public void setDownSeq2(Double downSeq2) {
		this.downSeq2 = downSeq2;
	}

	public Double getUpSeq3() {
		return upSeq3;
	}

	public void setUpSeq3(Double upSeq3) {
		this.upSeq3 = upSeq3;
	}

	public Double getDownSeq3() {
		return downSeq3;
	}

	public void setDownSeq3(Double downSeq3) {
		this.downSeq3 = downSeq3;
	}

}
