package com.minigod.api.mktinfo.vo;

import java.io.Serializable;
/**
 * 
 * 
 * <code>QuotShowVO.java<code>
 * 
 * @author Colin
 * @date 2015-1-13 下午3:47:51
 * 
 */
public class QuotShowVO implements Serializable {

	private static final long serialVersionUID = 7184505879193249169L;

	/** 资产ID */
	private String assetId;
	/** 日期 */
	private String date;
	/** 时间 */
	private String time;
	/** 名称 */
	private String stkName;
	/** 代码 */
	private String stkCode;
	/** 最新价 */
	private String price;
	/** 昨收 */
	private String prevClose;
	/** 今开 */
	private String open;
	/** 最高 */
	private String high;
	/** 最低 */
	private String low;
	/** 交易总额 */
	private String turnOver;
	/** 交易总量 */
	private String totalVolume;
	/** 涨跌幅 */
	private double changePct;
	/** 涨跌额 */
	private double change;
	/** 更新时间 */
	private long updateTime;//
	/** 五档委托买量 */
	private String b1;
	private String b2;
	private String b3;
	private String b4;
	private String b5;
	// 五档 委买价格
	private String b1Price;
	private String b2Price;
	private String b3Price;
	private String b4Price;
	private String b5Price;
	// 委卖5
	private String s1;
	private String s2;
	private String s3;
	private String s4;
	private String s5;

	private String s1Price;
	private String s2Price;
	private String s3Price;
	private String s4Price;
	private String s5Price;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStkName() {
		return stkName;
	}
	public void setStkName(String stkName) {
		this.stkName = stkName;
	}
	public String getStkCode() {
		return stkCode;
	}
	public void setStkCode(String stkCode) {
		this.stkCode = stkCode;
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
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getTurnOver() {
		return turnOver;
	}
	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}
	public String getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}
	public double getChangePct() {
		return changePct;
	}
	public void setChangePct(double changePct) {
		this.changePct = changePct;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = b2;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = b3;
	}
	public String getB4() {
		return b4;
	}
	public void setB4(String b4) {
		this.b4 = b4;
	}
	public String getB5() {
		return b5;
	}
	public void setB5(String b5) {
		this.b5 = b5;
	}
	public String getB1Price() {
		return b1Price;
	}
	public void setB1Price(String b1Price) {
		this.b1Price = b1Price;
	}
	public String getB2Price() {
		return b2Price;
	}
	public void setB2Price(String b2Price) {
		this.b2Price = b2Price;
	}
	public String getB3Price() {
		return b3Price;
	}
	public void setB3Price(String b3Price) {
		this.b3Price = b3Price;
	}
	public String getB4Price() {
		return b4Price;
	}
	public void setB4Price(String b4Price) {
		this.b4Price = b4Price;
	}
	public String getB5Price() {
		return b5Price;
	}
	public void setB5Price(String b5Price) {
		this.b5Price = b5Price;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	public String getS4() {
		return s4;
	}
	public void setS4(String s4) {
		this.s4 = s4;
	}
	public String getS5() {
		return s5;
	}
	public void setS5(String s5) {
		this.s5 = s5;
	}
	public String getS1Price() {
		return s1Price;
	}
	public void setS1Price(String s1Price) {
		this.s1Price = s1Price;
	}
	public String getS2Price() {
		return s2Price;
	}
	public void setS2Price(String s2Price) {
		this.s2Price = s2Price;
	}
	public String getS3Price() {
		return s3Price;
	}
	public void setS3Price(String s3Price) {
		this.s3Price = s3Price;
	}
	public String getS4Price() {
		return s4Price;
	}
	public void setS4Price(String s4Price) {
		this.s4Price = s4Price;
	}
	public String getS5Price() {
		return s5Price;
	}
	public void setS5Price(String s5Price) {
		this.s5Price = s5Price;
	}

}
