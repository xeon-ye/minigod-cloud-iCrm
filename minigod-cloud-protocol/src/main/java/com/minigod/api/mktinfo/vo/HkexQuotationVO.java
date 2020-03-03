package com.minigod.api.mktinfo.vo;

import com.minigod.api.mktinfo.vo.QuotOperator;
import com.minigod.api.mktinfo.vo.QuotationVO;
import com.minigod.api.mktinfo.vo.enums.ETradeType;
import com.minigod.common.utils.DateUtils;

import java.util.Date;

/**
 * <code>QuotationVO<code> 实时行情
 */
public class HkexQuotationVO extends QuotationVO implements QuotOperator {


    private static final long serialVersionUID = 7184505879193249169L;
    protected long b6;
    protected long b7;
    protected long b8;
    protected long b9;
    protected long b10;
    protected double b6Price;
    protected double b7Price;
    protected double b8Price;
    protected double b9Price;
    protected double b10Price;
    protected long s6;
    protected long s7;
    protected long s8;
    protected long s9;
    protected long s10;
    protected double s6Price;
    protected double s7Price;
    protected double s8Price;
    protected double s9Price;
    protected double s10Price;
    //十档 买入排队数量
    protected long b1Ordcount;
    protected long b2Ordcount;
    protected long b3Ordcount;
    protected long b4Ordcount;
    protected long b5Ordcount;
    protected long b6Ordcount;
    protected long b7Ordcount;
    protected long b8Ordcount;
    protected long b9Ordcount;
    protected long b10Ordcount;

    //十档 卖出排队数量
    protected long s1Ordcount;
    protected long s2Ordcount;
    protected long s3Ordcount;
    protected long s4Ordcount;
    protected long s5Ordcount;
    protected long s6Ordcount;
    protected long s7Ordcount;
    protected long s8Ordcount;
    protected long s9Ordcount;
    protected long s10Ordcount;
    /**
     * 港股的成交类型，
     */
    private String tradeType;

/*    // order imbalance
    String			szOrderImbDirection;	// IEP时，买卖盘差额方向 'N'=(买=卖) 'B'=(买>卖) 'S'=(买<卖)
    String			szOrderImbQuantity;	// IEP时，买卖盘差值的绝对值*/

    // Reference Price
    protected double casReferPrice;    // 收盘竞价(CAS)时的参考价
    protected double casReferLowerPrice;    // CAS允许的最低价
    protected double casReferUpperPrice;    // CAS允许的最高价

    // VCM Trigger
    protected Date vcmStartTime;        // 熔断的开始时间 time_t 的%u值
    protected Date vcmEndTime;        // 熔断的结束时间 time_t 的%u值
    protected double vcmReferPrice;    // VCM时的参考价
    protected double vcmLowerPrice;        // VCM允许最低价
    protected double vcmUpperPrice;        // VCM允许最高价

    // shortsell
    protected double shortSellTraded;        //
    protected double shortSellTurnover;    //
    
	private Boolean opriceSet = false; // 开盘价已设置
	
    public Boolean isOpriceSet() {
		return opriceSet;
	}

	public void setOpriceSet(Boolean opriceSet) {
		this.opriceSet = opriceSet;
	}

	@Override
    public void resetQuote() {
        super.resetQuote();
        resetHkexQuote();
        this.setTradeType(ETradeType.NONE.toString());
    }

    public void resetHkexQuote() {
    	setOpriceSet(false);
        this.setB6(0);
        this.setB6Price(0);
        this.setB7(0);
        this.setB7Price(0);
        this.setB8(0);
        this.setB8Price(0);
        this.setB9(0);
        this.setB9Price(0);
        this.setB10(0);
        this.setB10Price(0);

        this.setS6(0);
        this.setS6Price(0);
        this.setS7(0);
        this.setS7Price(0);
        this.setS8(0);
        this.setS8Price(0);
        this.setS9(0);
        this.setS9Price(0);
        this.setS10(0);
        this.setS10Price(0);

        this.setB1Ordcount(0);
        this.setB2Ordcount(0);
        this.setB3Ordcount(0);
        this.setB4Ordcount(0);
        this.setB5Ordcount(0);
        this.setB6Ordcount(0);
        this.setB7Ordcount(0);
        this.setB8Ordcount(0);
        this.setB9Ordcount(0);
        this.setB10Ordcount(0);

        this.setS1Ordcount(0);
        this.setS2Ordcount(0);
        this.setS3Ordcount(0);
        this.setS4Ordcount(0);
        this.setS5Ordcount(0);
        this.setS6Ordcount(0);
        this.setS7Ordcount(0);
        this.setS8Ordcount(0);
        this.setS9Ordcount(0);
        this.setS10Ordcount(0);

        this.setCasReferLowerPrice(0);
        this.setCasReferLowerPrice(0);
        this.setCasReferUpperPrice(0);
        this.setVcmStartTime(null);
        this.setVcmEndTime(null);
        this.setVcmReferPrice(0);
        this.setVcmLowerPrice(0);
        this.setVcmUpperPrice(0);
        this.setShortSellTraded(0);
        this.setShortSellTurnover(0);
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public long getB1Ordcount() {
        return b1Ordcount;
    }

    public void setB1Ordcount(long b1Ordcount) {
        this.b1Ordcount = b1Ordcount;
    }

    public long getB2Ordcount() {
        return b2Ordcount;
    }

    public void setB2Ordcount(long b2Ordcount) {
        this.b2Ordcount = b2Ordcount;
    }

    public long getB3Ordcount() {
        return b3Ordcount;
    }

    public void setB3Ordcount(long b3Ordcount) {
        this.b3Ordcount = b3Ordcount;
    }

    public long getB4Ordcount() {
        return b4Ordcount;
    }

    public void setB4Ordcount(long b4Ordcount) {
        this.b4Ordcount = b4Ordcount;
    }

    public long getB5Ordcount() {
        return b5Ordcount;
    }

    public void setB5Ordcount(long b5Ordcount) {
        this.b5Ordcount = b5Ordcount;
    }

    public long getS1Ordcount() {
        return s1Ordcount;
    }

    public void setS1Ordcount(long s1Ordcount) {
        this.s1Ordcount = s1Ordcount;
    }

    public long getS2Ordcount() {
        return s2Ordcount;
    }

    public void setS2Ordcount(long s2Ordcount) {
        this.s2Ordcount = s2Ordcount;
    }

    public long getS3Ordcount() {
        return s3Ordcount;
    }

    public void setS3Ordcount(long s3Ordcount) {
        this.s3Ordcount = s3Ordcount;
    }

    public long getS4Ordcount() {
        return s4Ordcount;
    }

    public void setS4Ordcount(long s4Ordcount) {
        this.s4Ordcount = s4Ordcount;
    }

    public long getS5Ordcount() {
        return s5Ordcount;
    }

    public void setS5Ordcount(long s5Ordcount) {
        this.s5Ordcount = s5Ordcount;
    }

    public long getB6() {
        return b6;
    }

    public void setB6(long b6) {
        this.b6 = b6;
    }

    public long getB7() {
        return b7;
    }

    public void setB7(long b7) {
        this.b7 = b7;
    }

    public long getB8() {
        return b8;
    }

    public void setB8(long b8) {
        this.b8 = b8;
    }

    public long getB9() {
        return b9;
    }

    public void setB9(long b9) {
        this.b9 = b9;
    }

    public long getB10() {
        return b10;
    }

    public void setB10(long b10) {
        this.b10 = b10;
    }

    public double getB6Price() {
        return b6Price;
    }

    public void setB6Price(double b6Price) {
        this.b6Price = b6Price;
    }

    public double getB7Price() {
        return b7Price;
    }

    public void setB7Price(double b7Price) {
        this.b7Price = b7Price;
    }

    public double getB8Price() {
        return b8Price;
    }

    public void setB8Price(double b8Price) {
        this.b8Price = b8Price;
    }

    public double getB9Price() {
        return b9Price;
    }

    public void setB9Price(double b9Price) {
        this.b9Price = b9Price;
    }

    public double getB10Price() {
        return b10Price;
    }

    public void setB10Price(double b10Price) {
        this.b10Price = b10Price;
    }

    public long getS6() {
        return s6;
    }

    public void setS6(long s6) {
        this.s6 = s6;
    }

    public long getS7() {
        return s7;
    }

    public void setS7(long s7) {
        this.s7 = s7;
    }

    public long getS8() {
        return s8;
    }

    public void setS8(long s8) {
        this.s8 = s8;
    }

    public long getS9() {
        return s9;
    }

    public void setS9(long s9) {
        this.s9 = s9;
    }

    public long getS10() {
        return s10;
    }

    public void setS10(long s10) {
        this.s10 = s10;
    }

    public double getS6Price() {
        return s6Price;
    }

    public void setS6Price(double s6Price) {
        this.s6Price = s6Price;
    }

    public double getS7Price() {
        return s7Price;
    }

    public void setS7Price(double s7Price) {
        this.s7Price = s7Price;
    }

    public double getS8Price() {
        return s8Price;
    }

    public void setS8Price(double s8Price) {
        this.s8Price = s8Price;
    }

    public double getS9Price() {
        return s9Price;
    }

    public void setS9Price(double s9Price) {
        this.s9Price = s9Price;
    }

    public double getS10Price() {
        return s10Price;
    }

    public void setS10Price(double s10Price) {
        this.s10Price = s10Price;
    }

    public long getB6Ordcount() {
        return b6Ordcount;
    }

    public void setB6Ordcount(long b6Ordcount) {
        this.b6Ordcount = b6Ordcount;
    }

    public long getB7Ordcount() {
        return b7Ordcount;
    }

    public void setB7Ordcount(long b7Ordcount) {
        this.b7Ordcount = b7Ordcount;
    }

    public long getB8Ordcount() {
        return b8Ordcount;
    }

    public void setB8Ordcount(long b8Ordcount) {
        this.b8Ordcount = b8Ordcount;
    }

    public long getB9Ordcount() {
        return b9Ordcount;
    }

    public void setB9Ordcount(long b9Ordcount) {
        this.b9Ordcount = b9Ordcount;
    }

    public long getB10Ordcount() {
        return b10Ordcount;
    }

    public void setB10Ordcount(long b10Ordcount) {
        this.b10Ordcount = b10Ordcount;
    }

    public long getS6Ordcount() {
        return s6Ordcount;
    }

    public void setS6Ordcount(long s6Ordcount) {
        this.s6Ordcount = s6Ordcount;
    }

    public long getS7Ordcount() {
        return s7Ordcount;
    }

    public void setS7Ordcount(long s7Ordcount) {
        this.s7Ordcount = s7Ordcount;
    }

    public long getS8Ordcount() {
        return s8Ordcount;
    }

    public void setS8Ordcount(long s8Ordcount) {
        this.s8Ordcount = s8Ordcount;
    }

    public long getS9Ordcount() {
        return s9Ordcount;
    }

    public void setS9Ordcount(long s9Ordcount) {
        this.s9Ordcount = s9Ordcount;
    }

    public long getS10Ordcount() {
        return s10Ordcount;
    }

    public void setS10Ordcount(long s10Ordcount) {
        this.s10Ordcount = s10Ordcount;
    }

    public double getCasReferPrice() {
        return casReferPrice;
    }

    public void setCasReferPrice(double casReferPrice) {
        this.casReferPrice = casReferPrice;
    }

    public double getCasReferLowerPrice() {
        return casReferLowerPrice;
    }

    public void setCasReferLowerPrice(double casReferLowerPrice) {
        this.casReferLowerPrice = casReferLowerPrice;
    }

    public double getCasReferUpperPrice() {
        return casReferUpperPrice;
    }

    public void setCasReferUpperPrice(double casReferUpperPrice) {
        this.casReferUpperPrice = casReferUpperPrice;
    }

    public Date getVcmStartTime() {
        return vcmStartTime;
    }

    public void setVcmStartTime(Date vcmStartTime) {
        this.vcmStartTime = vcmStartTime;
    }

    public Date getVcmEndTime() {
        return vcmEndTime;
    }

    public void setVcmEndTime(Date vcmEndTime) {
        this.vcmEndTime = vcmEndTime;
    }

    public double getVcmReferPrice() {
        return vcmReferPrice;
    }

    public void setVcmReferPrice(double vcmReferPrice) {
        this.vcmReferPrice = vcmReferPrice;
    }

    public double getVcmLowerPrice() {
        return vcmLowerPrice;
    }

    public void setVcmLowerPrice(double vcmLowerPrice) {
        this.vcmLowerPrice = vcmLowerPrice;
    }

    public double getVcmUpperPrice() {
        return vcmUpperPrice;
    }

    public void setVcmUpperPrice(double vcmUpperPrice) {
        this.vcmUpperPrice = vcmUpperPrice;
    }

    public double getShortSellTraded() {
        return shortSellTraded;
    }

    public void setShortSellTraded(double shortSellTraded) {
        this.shortSellTraded = shortSellTraded;
    }

    public double getShortSellTurnover() {
        return shortSellTurnover;
    }

    public void setShortSellTurnover(double shortSellTurnover) {
        this.shortSellTurnover = shortSellTurnover;
    }

    @Override
    public String toString() {
        return "HkexQuotationVO{" +
                "b6=" + b6 +
                ", b7=" + b7 +
                ", b8=" + b8 +
                ", b9=" + b9 +
                ", b10=" + b10 +
                ", b6Price=" + b6Price +
                ", b7Price=" + b7Price +
                ", b8Price=" + b8Price +
                ", b9Price=" + b9Price +
                ", b10Price=" + b10Price +
                ", s6=" + s6 +
                ", s7=" + s7 +
                ", s8=" + s8 +
                ", s9=" + s9 +
                ", s10=" + s10 +
                ", s6Price=" + s6Price +
                ", s7Price=" + s7Price +
                ", s8Price=" + s8Price +
                ", s9Price=" + s9Price +
                ", s10Price=" + s10Price +
                ", b1Ordcount=" + b1Ordcount +
                ", b2Ordcount=" + b2Ordcount +
                ", b3Ordcount=" + b3Ordcount +
                ", b4Ordcount=" + b4Ordcount +
                ", b5Ordcount=" + b5Ordcount +
                ", b6Ordcount=" + b6Ordcount +
                ", b7Ordcount=" + b7Ordcount +
                ", b8Ordcount=" + b8Ordcount +
                ", b9Ordcount=" + b9Ordcount +
                ", b10Ordcount=" + b10Ordcount +
                ", s1Ordcount=" + s1Ordcount +
                ", s2Ordcount=" + s2Ordcount +
                ", s3Ordcount=" + s3Ordcount +
                ", s4Ordcount=" + s4Ordcount +
                ", s5Ordcount=" + s5Ordcount +
                ", s6Ordcount=" + s6Ordcount +
                ", s7Ordcount=" + s7Ordcount +
                ", s8Ordcount=" + s8Ordcount +
                ", s9Ordcount=" + s9Ordcount +
                ", s10Ordcount=" + s10Ordcount +
                ", tradeType='" + tradeType + '\'' +
                ", casReferPrice=" + casReferPrice +
                ", casReferLowerPrice=" + casReferLowerPrice +
                ", casReferUpperPrice=" + casReferUpperPrice +
                ", vcmStartTime=" + vcmStartTime +
                ", vcmEndTime=" + vcmEndTime +
                ", vcmReferPrice=" + vcmReferPrice +
                ", vcmLowerPrice=" + vcmLowerPrice +
                ", vcmUpperPrice=" + vcmUpperPrice +
                ", shortSellTraded=" + shortSellTraded +
                ", shortSellTurnover=" + shortSellTurnover +
                '}';
    }
}
