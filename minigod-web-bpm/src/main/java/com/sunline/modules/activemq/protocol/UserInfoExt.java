package com.sunline.modules.activemq.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * @description: 用户中心扩展信息
 * @author: Larry Lai
 * @date: 2020/1/3 11:14
 * @version: v1.0
 */

public class UserInfoExt extends BaseParameter {

    /**
     * 小神号
     */
    private Integer userId;

    /**
     * 交易账号
     */
    private String tradeAccount;

    /**
     * 资金账号
     */
    private String fundAccount;

    /**
     * 账户类型
     */
    private Integer fundAccountType;

    /**
     * 开户状态[0=否 1=是]
     */
    private Integer openAccountStatus;

    /**
     * 转入状态[0=否 1=是]
     */
    private Integer transferInStatus;

    /**
     * 转出状态[0=否 1=是]
     */
    private Integer transferOutStatus;

    /**
     * 交易状态[0=否 1=是]
     */
    private Integer tradeStatus;

    /**
     * 入金状态[0=否 1=是]
     */
    private Integer depositStatus;

    /**
     * 出金状态[0=否 1=是]
     */
    private Integer withdrawalStatus;

    /**
     * 注册状态[0=否 1=是]
     */
    private Integer userRegStatus;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;

    /**
     * 客户状态[0-正常 1-冻结 2-挂失 3-销户 D-休眠 E-不合格 F-锁定]
     */
    private String clientStatus;

    /**
     * [1=开户 2=转入仓 3=转出仓 4=交易状态 5=入金状态 6=出金状态]
     */
    private Integer optType;

    /**
     * 证件类型:0=未知,1=大陆居民身份证,2=香港居民身份证,3=护照,4=驾驶证
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idNo;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    public Integer getFundAccountType() {
        return fundAccountType;
    }

    public void setFundAccountType(Integer fundAccountType) {
        this.fundAccountType = fundAccountType;
    }

    public Integer getOpenAccountStatus() {
        return openAccountStatus;
    }

    public void setOpenAccountStatus(Integer openAccountStatus) {
        this.openAccountStatus = openAccountStatus;
    }

    public Integer getTransferInStatus() {
        return transferInStatus;
    }

    public void setTransferInStatus(Integer transferInStatus) {
        this.transferInStatus = transferInStatus;
    }

    public Integer getTransferOutStatus() {
        return transferOutStatus;
    }

    public void setTransferOutStatus(Integer transferOutStatus) {
        this.transferOutStatus = transferOutStatus;
    }

    public Integer getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(Integer tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public Integer getDepositStatus() {
        return depositStatus;
    }

    public void setDepositStatus(Integer depositStatus) {
        this.depositStatus = depositStatus;
    }

    public Integer getWithdrawalStatus() {
        return withdrawalStatus;
    }

    public void setWithdrawalStatus(Integer withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public Integer getUserRegStatus() {
        return userRegStatus;
    }

    public void setUserRegStatus(Integer userRegStatus) {
        this.userRegStatus = userRegStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Integer getOptType() {
        return optType;
    }

    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }
}
