package com.sunline.modules.analysis.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 打新活动 出入金 entity
 *
 * @author  lcs
 * @date 2018-06-22 14:00:00
 * @
 */

public class ClientIpoIncomeEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 小神号
     */
    private String userId;
    /**
     * 注册时间
     */
    private String registerDate;
    /**
     * 开户时间
     */
    private String openAccountDate;
    /**
     * 首次入金日期
     */
    private String firstIncomeDate;
    /**
     * 首次入金金额
     */
    private String firstIncomeMoney;
    /**
     * 活动入金金额
     */
    private String ipoIncomeMoney;
    /**
     * 活动认购笔数
     */
    private String ipoApplyCount;
    /**
     * 邀请人数
     */
    private String inviteCount;
    /**
     * 邀请人入金金额
     */
    private String inviteIncomeMoney;

    /**
     * 开始日期
     */
    private String beginDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 渠道授权
     */
    List<String> channelIds;

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getOpenAccountDate() {
        return openAccountDate;
    }

    public void setOpenAccountDate(String openAccountDate) {
        this.openAccountDate = openAccountDate;
    }

    public String getFirstIncomeDate() {
        return firstIncomeDate;
    }

    public void setFirstIncomeDate(String firstIncomeDate) {
        this.firstIncomeDate = firstIncomeDate;
    }

    public String getFirstIncomeMoney() {
        return firstIncomeMoney;
    }

    public void setFirstIncomeMoney(String firstIncomeMoney) {
        this.firstIncomeMoney = firstIncomeMoney;
    }

    public String getIpoIncomeMoney() {
        return ipoIncomeMoney;
    }

    public void setIpoIncomeMoney(String ipoIncomeMoney) {
        this.ipoIncomeMoney = ipoIncomeMoney;
    }

    public String getIpoApplyCount() {
        return ipoApplyCount;
    }

    public void setIpoApplyCount(String ipoApplyCount) {
        this.ipoApplyCount = ipoApplyCount;
    }

    public String getInviteCount() {
        return inviteCount;
    }

    public void setInviteCount(String inviteCount) {
        this.inviteCount = inviteCount;
    }

    public String getInviteIncomeMoney() {
        return inviteIncomeMoney;
    }

    public void setInviteIncomeMoney(String inviteIncomeMoney) {
        this.inviteIncomeMoney = inviteIncomeMoney;
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
}
