package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 入金交易统计
 *
 * @author lcs
 * @email
 * @date 2018-06-19 14:15:29
 */
public class ClienIncomeCountEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     *  入金金额
     */
    private String incomeMoney;
    /**
     * 入金笔数
     */
    private String incomeCount;
    /**
     * 交易金额
     */
    private String tradeMoney;
    /**
     * 交易笔数
     */
    private String tradeCount;
    /**
     * 开始日期
     */
    private String beginDate;
    /**
     * 结束日期
     */
    private String endDate;
    /**
     * 维度时间
     */
    private String dateTime;

    /**
     *周一
     * @return
     */
    private String monday;
    /**
     *周日
     * @return
     */
    private String sunday;

    /**
     * type
     */
    private String type;

    //渠道授权
    private List<String> channelIds;

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
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

    public String getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(String incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public String getIncomeCount() {
        return incomeCount;
    }

    public void setIncomeCount(String incomeCount) {
        this.incomeCount = incomeCount;
    }

    public String getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(String tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    public String getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(String tradeCount) {
        this.tradeCount = tradeCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
