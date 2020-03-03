package com.minigod.api.mktinfo.vo;

import com.minigod.common.utils.DateUtils;

import java.io.*;
import java.util.Date;

/**
 * <code>QuotationVO<code> 实时行情
 */
public class QuotationVO implements QuotOperator, Serializable {

	protected static final long serialVersionUID = 7184505879193249169L;

	/** 资产ID */
	protected String assetId;
	/** 时区 **/
	protected String timeZoneId;
	/** 日期 */
	protected String date;
	/** 时间 */
	protected String time;
	/** 名称 */
	protected String stkName;
	/** 代码 */
	protected String stkCode;
	/** 公司代码 */
	protected int corpCode;
	/** 最新价 */
	protected double price;
	/** 昨收 */
	protected double prevClose;
	/** 今开 */
	protected double open;
	/** 最高 */
	protected double high;
	/** 最低 */
	protected double low;
	/** 交易总额 */
	protected double turnOver = 0;
	/** 交易总量 */
	protected double totalVolume = 0;
	/** 上一分钟交易总量 */
	protected double lastVol = 0;
	/** 上一分钟交易总额 */
	protected double lastTurnover = 0;
	/** 均价 */
	protected double avgPrice;
	/** 涨跌幅 */
	protected double changePct;
	/** 涨跌额 */
	protected double change;
	/** 每手股数 */
	protected int lotSize;
	/** 委买数量 */
	protected double commissionBuyVol;
	/** 委卖数量 */
	protected double commissionSellVol;
	/** 详细类型 101:A股 */
	protected int secSType;
	/** 大类:1.股票 2.债券 3.基金 4.权证 5.指数 */
	protected int secType;
	/** 交易市场 1 : 深交所 ， 2 - 上交所 */
	protected int market;
	/** 判断市场状态 false.收市状态，true.开市状态 */
	protected boolean isOpenMkt = true;
	/** 更新时间 */
	protected long updateTime;//
	/** 小数点后有效数字个数 */
	protected int pointnum;
	// TODO 暂无涨跌幅数据
	protected double changeLimit;// 涨跌幅限制
	/** 只有涨停, 跌停, 正常三种状态; 0 - 正常, 1 - 涨停, 2 - 跌停 */
	protected int status;
	/** 五档委托买量 */
	protected long b1;
	protected long b2;
	protected long b3;
	protected long b4;
	protected long b5;

	// 五档 委买价格
	protected double b1Price;
	protected double b2Price;
	protected double b3Price;
	protected double b4Price;
	protected double b5Price;
	// 委卖5
	protected long s1;
	protected long s2;
	protected long s3;
	protected long s4;
	protected long s5;

	protected double s1Price;
	protected double s2Price;
	protected double s3Price;
	protected double s4Price;
	protected double s5Price;

	/** 每分钟成交量 **/
	private Double volm;

	public Double getVolm() {
		return volm;
	}

	public void setVolm(Double volm) {
		this.volm = volm;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

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

	public double getPrevClose() {
		return prevClose;
	}

	public void setPrevClose(double prevClose) {
		this.prevClose = prevClose;
	}

	public double getOpen() {
		return open;
	}

	public double getCommissionBuyVol() {
		return commissionBuyVol;
	}

	public void setCommissionBuyVol(double commissionBuyVol) {
		this.commissionBuyVol = commissionBuyVol;
	}

	public double getCommissionSellVol() {
		return commissionSellVol;
	}

	public void setCommissionSellVol(double commissionSellVol) {
		this.commissionSellVol = commissionSellVol;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getChangePct() {
		return changePct;
	}

	public void setChangePct(double changePct) {
		this.changePct = changePct;
	}

	public double getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(double turnOver) {
		this.turnOver = turnOver;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

	public int getLotSize() {
		return lotSize;
	}

	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}

	public int getSecSType() {
		return secSType;
	}

	public void setSecSType(int secSType) {
		this.secSType = secSType;
	}

	public int getSecType() {
		return secType;
	}

	public void setSecType(int secType) {
		this.secType = secType;
	}

	public int getMarket() {
		return market;
	}

	public void setMarket(int market) {
		this.market = market;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public int getPointnum() {
		return pointnum;
	}

	public void setPointnum(int pointnum) {
		this.pointnum = pointnum;
	}

	public long getB1() {
		return b1;
	}

	public void setB1(long b1) {
		this.b1 = b1;
	}

	public long getB2() {
		return b2;
	}

	public void setB2(long b2) {
		this.b2 = b2;
	}

	public long getB3() {
		return b3;
	}

	public void setB3(long b3) {
		this.b3 = b3;
	}

	public long getB4() {
		return b4;
	}

	public void setB4(long b4) {
		this.b4 = b4;
	}

	public long getB5() {
		return b5;
	}

	public void setB5(long b5) {
		this.b5 = b5;
	}

	public double getB1Price() {
		return b1Price;
	}

	public void setB1Price(double b1Price) {
		this.b1Price = b1Price;
	}

	public double getB2Price() {
		return b2Price;
	}

	public void setB2Price(double b2Price) {
		this.b2Price = b2Price;
	}

	public double getB3Price() {
		return b3Price;
	}

	public void setB3Price(double b3Price) {
		this.b3Price = b3Price;
	}

	public double getB4Price() {
		return b4Price;
	}

	public void setB4Price(double b4Price) {
		this.b4Price = b4Price;
	}

	public double getB5Price() {
		return b5Price;
	}

	public void setB5Price(double b5Price) {
		this.b5Price = b5Price;
	}

	public long getS1() {
		return s1;
	}

	public void setS1(long s1) {
		this.s1 = s1;
	}

	public long getS2() {
		return s2;
	}

	public void setS2(long s2) {
		this.s2 = s2;
	}

	public long getS3() {
		return s3;
	}

	public void setS3(long s3) {
		this.s3 = s3;
	}

	public long getS4() {
		return s4;
	}

	public void setS4(long s4) {
		this.s4 = s4;
	}

	public long getS5() {
		return s5;
	}

	public void setS5(long s5) {
		this.s5 = s5;
	}

	public double getS1Price() {
		return s1Price;
	}

	public void setS1Price(double s1Price) {
		this.s1Price = s1Price;
	}

	public double getS2Price() {
		return s2Price;
	}

	public void setS2Price(double s2Price) {
		this.s2Price = s2Price;
	}

	public double getS3Price() {
		return s3Price;
	}

	public void setS3Price(double s3Price) {
		this.s3Price = s3Price;
	}

	public double getS4Price() {
		return s4Price;
	}

	public void setS4Price(double s4Price) {
		this.s4Price = s4Price;
	}

	public double getS5Price() {
		return s5Price;
	}

	public void setS5Price(double s5Price) {
		this.s5Price = s5Price;
	}

	public double getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(double totalVolume) {
		this.totalVolume = totalVolume;
	}

	public double getLastVol() {
		return lastVol;
	}

	public void setLastVol(double lastVol) {
		this.lastVol = lastVol;
	}

	public boolean isOpenMkt() {
		return isOpenMkt;
	}

	public void setOpenMkt(boolean isOpenMkt) {
		this.isOpenMkt = isOpenMkt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(int corpCode) {
		this.corpCode = corpCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getChangeLimit() {
		return changeLimit;
	}

	public void setChangeLimit(double changeLimit) {
		this.changeLimit = changeLimit;
	}

	public double getLastTurnover() {
		return lastTurnover;
	}

	public void setLastTurnover(double lastTurnover) {
		this.lastTurnover = lastTurnover;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}




	@Override
	public void resetQuote() {
		Date date = new Date();
		String sDate = DateUtils.dateToString(date, DateUtils.TimeFormatter.YYYY_MM_DD);
		String sTime = DateUtils.dateToString(date, "HH:mm:00");
		double price = this.getPrice();
		this.setHigh(0);
		this.setLow(0);
		this.setOpen(0);
		this.setTotalVolume(0);
		this.setLastVol(0);
		this.setTurnOver(0);
		this.setLastTurnover(0);
		this.setDate(sDate);
		this.setTime(sTime);
		this.setPrice(0d);
		this.setAvgPrice(0d);
		this.setPrevClose(0d);
		this.setChange(0);
		this.setChangePct(0);
		this.setCommissionBuyVol(0);
		this.setCommissionSellVol(0);

		this.setB1(0);
		this.setB1Price(0);
		this.setB2(0);
		this.setB2Price(0);
		this.setB3(0);
		this.setB3Price(0);
		this.setB4(0);
		this.setB4Price(0);
		this.setB5(0);
		this.setB5Price(0);

		this.setS1(0);
		this.setS1Price(0);
		this.setS2(0);
		this.setS2Price(0);
		this.setS3(0);
		this.setS3Price(0);
		this.setS4(0);
		this.setS4Price(0);
		this.setS5(0);
		this.setS5Price(0);

		//this.setStatus(0);
	}

	/**
	 * 深层拷贝 - 需要类继承序列化接口
	 * @param <T>
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T extends QuotationVO>  T deepCopy(T obj) throws Exception {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;

		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;

		Object o = null;
		//如果子类没有继承该接口，这一步会报错
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bais = new ByteArrayInputStream(baos.toByteArray());
			ois = new ObjectInputStream(bais);

			o = ois.readObject();
			return (T) o;
		} catch (Exception e) {
			throw new Exception("对象中包含没有继承序列化的对象");
		} finally{
			try {
				baos.close();
				oos.close();
				bais.close();
				ois.close();
			} catch (Exception e2) {
				//这里报错不需要处理
			}
		}
	}

	@Override
	public String toString() {
		return "QuotationVO{" +
				"assetId='" + assetId + '\'' +
				", date='" + date + '\'' +
				", time='" + time + '\'' +
				", stkName='" + stkName + '\'' +
				", stkCode='" + stkCode + '\'' +
				", corpCode=" + corpCode +
				", price=" + price +
				", prevClose=" + prevClose +
				", open=" + open +
				", high=" + high +
				", low=" + low +
				", turnOver=" + turnOver +
				", totalVolume=" + totalVolume +
				", lastVol=" + lastVol +
				", lastTurnover=" + lastTurnover +
				", avgPrice=" + avgPrice +
				", changePct=" + changePct +
				", change=" + change +
				", lotSize=" + lotSize +
				", secSType=" + secSType +
				", secType=" + secType +
				", market=" + market +
				", isOpenMkt=" + isOpenMkt +
				", updateTime=" + updateTime +
				", pointnum=" + pointnum +
				", changeLimit=" + changeLimit +
				", status=" + status +
				", b1=" + b1 +
				", b2=" + b2 +
				", b3=" + b3 +
				", b4=" + b4 +
				", b5=" + b5 +
				", b1Price=" + b1Price +
				", b2Price=" + b2Price +
				", b3Price=" + b3Price +
				", b4Price=" + b4Price +
				", b5Price=" + b5Price +
				", s1=" + s1 +
				", s2=" + s2 +
				", s3=" + s3 +
				", s4=" + s4 +
				", s5=" + s5 +
				", s1Price=" + s1Price +
				", s2Price=" + s2Price +
				", s3Price=" + s3Price +
				", s4Price=" + s4Price +
				", s5Price=" + s5Price +
				'}';
	}
}
