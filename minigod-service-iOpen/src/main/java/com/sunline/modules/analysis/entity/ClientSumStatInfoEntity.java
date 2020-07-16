package com.sunline.modules.analysis.entity;

import java.io.Serializable;
import java.util.List;


/**
 * 客户数汇总统计表
 *
 * @author lcs
 * @email
 * @date 2018-05-03 13:15:29
 */
public class ClientSumStatInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 平台用户总数
     */
    private Integer userCount;

    /**
     * 注册用户总数
     */
    private Integer regUserCount;

    /**
     * 开户用户总数
     */
    private Integer openUserCount;

    /**
     * 安卓用户总数
     */
    private Integer androidUserCount;

    /**
     * IOS用户总数
     */
    private Integer iosUserCount;

    /**
     * 开始日期
     */
    private String beginDate;

    //渠道授权
    private List<String> channelIds;

    private String dateTime;
    private String monday;
    private String sunday;
    private String type;

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

    public Integer getInComeCount() {
        return inComeCount;
    }

    public void setInComeCount(Integer inComeCount) {
        this.inComeCount = inComeCount;
    }

    public Integer getOutComeCount() {
        return outComeCount;
    }

    public void setOutComeCount(Integer outComeCount) {
        this.outComeCount = outComeCount;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    /**
     * 结束日期
     */
    private String endDate;

    private Integer inComeCount;
    private Integer outComeCount;
    private Integer tradeCount;

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getRegUserCount() {
        return regUserCount;
    }

    public void setRegUserCount(Integer regUserCount) {
        this.regUserCount = regUserCount;
    }

    public Integer getOpenUserCount() {
        return openUserCount;
    }

    public void setOpenUserCount(Integer openUserCount) {
        this.openUserCount = openUserCount;
    }

    public Integer getAndroidUserCount() {
        return androidUserCount;
    }

    public void setAndroidUserCount(Integer androidUserCount) {
        this.androidUserCount = androidUserCount;
    }

    public Integer getIosUserCount() {
        return iosUserCount;
    }
    public void setIosUserCount(Integer iosUserCount) {
        this.iosUserCount = iosUserCount;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }
}
