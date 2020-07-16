package com.sunline.modules.report.entity;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 交易统计表表
 *
 * @author LCS
 * @email jim@zszhizhu.com
 * @date 2019-03-19 15:56:19
 */
public class TradeReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
     * 时间
     */
	private String date;

    /**
     * 客户类型
     */
    private Integer clientType;

    /**
     * 委托客户数
     */
    private int entrustClientCount;

    /**
     * 委托笔数
     */
    private int entrustCount;

    /**
     * 委托类型
     */
    private String entrustWay;

    /**
     * 成交笔数
     */
    private int tradeCount;

    /**
     * 成交金额
     */
    private BigDecimal tradeBalance;

    /**
     * 去年成交笔数
     */
    private int yesTradeCount;

    /**
     * 昨日成交笔数
     */
    private int lasTradeCount;

    /**
     * 去年成交金额
     */
    private BigDecimal yesTradeBalance;

    /**
     * 昨日成交金额
     */
    private BigDecimal lasTradeBalance;

    /**
     * 去年成交笔数同比
     */
    private double countRatioT;

    /**
     * 去年成交笔数环比
     */
    private double countRatioH;

    /**
     * 去年成交金额同比
     */
    private double balanceRatioT;

    /**
     * 去年成交金额环比
     */
    private double balanceRatioH;

    /**
     * 开始日期 和 结束日期
     */

    private String beginDate;
    private String endDate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public int getEntrustClientCount() {
        return entrustClientCount;
    }

    public void setEntrustClientCount(int entrustClientCount) {
        this.entrustClientCount = entrustClientCount;
    }

    public int getEntrustCount() {
        return entrustCount;
    }

    public void setEntrustCount(int entrustCount) {
        this.entrustCount = entrustCount;
    }

    public int getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(int tradeCount) {
        this.tradeCount = tradeCount;
    }

    public BigDecimal getTradeBalance() {
        return tradeBalance;
    }

    public void setTradeBalance(BigDecimal tradeBalance) {
        this.tradeBalance = tradeBalance;
    }

    public int getYesTradeCount() {
        return yesTradeCount;
    }

    public void setYesTradeCount(int yesTradeCount) {
        this.yesTradeCount = yesTradeCount;
    }

    public BigDecimal getYesTradeBalance() {
        return yesTradeBalance;
    }

    public void setYesTradeBalance(BigDecimal yesTradeBalance) {
        this.yesTradeBalance = yesTradeBalance;
    }

    public double getCountRatioT() {
        return countRatioT;
    }

    public void setCountRatioT(double countRatioT) {
        this.countRatioT = countRatioT;
    }

    public double getCountRatioH() {
        return countRatioH;
    }

    public void setCountRatioH(double countRatioH) {
        this.countRatioH = countRatioH;
    }

    public double getBalanceRatioT() {
        return balanceRatioT;
    }

    public void setBalanceRatioT(double balanceRatioT) {
        this.balanceRatioT = balanceRatioT;
    }

    public double getBalanceRatioH() {
        return balanceRatioH;
    }

    public void setBalanceRatioH(double balanceRatioH) {
        this.balanceRatioH = balanceRatioH;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEntrustWay() {
        return entrustWay;
    }

    public void setEntrustWay(String entrustWay) {
        this.entrustWay = entrustWay;
    }

    public int getLasTradeCount() {
        return lasTradeCount;
    }

    public void setLasTradeCount(int lasTradeCount) {
        this.lasTradeCount = lasTradeCount;
    }

    public BigDecimal getLasTradeBalance() {
        return lasTradeBalance;
    }

    public void setLasTradeBalance(BigDecimal lasTradeBalance) {
        this.lasTradeBalance = lasTradeBalance;
    }
}
