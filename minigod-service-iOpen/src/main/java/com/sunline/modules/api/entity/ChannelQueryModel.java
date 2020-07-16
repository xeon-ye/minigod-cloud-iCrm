package com.sunline.modules.api.entity;


import java.io.Serializable;

/**
 * @author lcs
 * @date 2018-7-26
 */
public class ChannelQueryModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 注册人数
     */
    private String regCount;
    /**
     * 开户人数
     */
    private String openCount;
    /**
     * 首次入金人数
     */
    private String firstIncomeCount;
    /**
     * 首次转股人数
     */
    private String firstTrsCount;
    /**
     * 首次转出人数
     */
    private String firstTrsOutCount;
    /**
     * 首次转入人数
     */
    private String firstTrsInCount;
    /**
     * 现金打新次数
     */
    private String cashHitNewCount;
    /**
     * 融资打新次数
     */
    private String finHitNewCount;
    /**
     * 打新总次数
     */
    private String hitNewCount;
    /**
     * 交易次数
     */
    private String tradeCount;
    /**
     * 交易总金额
     */
    private String tradeMoney;
    /**
     * 出金人次
     */
    private String outComeCount;

    public String getRegCount() {
        return regCount;
    }

    public void setRegCount(String regCount) {
        this.regCount = regCount;
    }

    public String getOpenCount() {
        return openCount;
    }

    public void setOpenCount(String openCount) {
        this.openCount = openCount;
    }

    public String getFirstIncomeCount() {
        return firstIncomeCount;
    }

    public void setFirstIncomeCount(String firstIncomeCount) {
        this.firstIncomeCount = firstIncomeCount;
    }

    public String getFirstTrsCount() {
        return firstTrsCount;
    }

    public void setFirstTrsCount(String firstTrsCount) {
        this.firstTrsCount = firstTrsCount;
    }


    public String getFirstTrsOutCount() {
        return firstTrsOutCount;
    }

    public void setFirstTrsOutCount(String firstTrsOutCount) {
        this.firstTrsOutCount = firstTrsOutCount;
    }

    public String getFirstTrsInCount() {
        return firstTrsInCount;
    }

    public void setFirstTrsInCount(String firstTrsInCount) {
        this.firstTrsInCount = firstTrsInCount;
    }

    public String getCashHitNewCount() {
        return cashHitNewCount;
    }

    public void setCashHitNewCount(String cashHitNewCount) {
        this.cashHitNewCount = cashHitNewCount;
    }

    public String getFinHitNewCount() {
        return finHitNewCount;
    }

    public void setFinHitNewCount(String finHitNewCount) {
        this.finHitNewCount = finHitNewCount;
    }

    public String getHitNewCount() {
        return hitNewCount;
    }

    public void setHitNewCount(String hitNewCount) {
        this.hitNewCount = hitNewCount;
    }

    public String getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(String tradeCount) {
        this.tradeCount = tradeCount;
    }

    public String getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(String tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public String getOutComeCount() {
        return outComeCount;
    }

    public void setOutComeCount(String outComeCount) {
        this.outComeCount = outComeCount;
    }
}
