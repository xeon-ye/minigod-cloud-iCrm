package com.sunline.modules.api.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;
import io.swagger.models.auth.In;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description: CRM外部接口通用协议
 * @author: Larry Lai
 * @date: 2018/12/26 10:36
 * @version: v1.0
 */
public class CrmExternalCommonProto {

    public static class CrmExternalCommonRequest extends BaseParameter {

        private static final long serialVersionUID = -2475469254922773351L;

        // 开户类型[1=互联网、2=见证宝 3=BPM]
        private Integer openAccountType;
        // 客户号(小神号)
        private Integer userId;
        // 客户中文名
        private String clientName;
        // 证件号码
        private String idNo;
        // 银行卡号
        private String bankNo;
        // 是否美国绿卡持有人[0=否 1=是]
        private Integer isAmericanGreenCardHolder;
        // 电子邮箱
        private String email;
        // 手机号
        private String phoneNumber;
        // 开户邀请人的userId
        private String inviterId;
        // 开户客户来源渠道ID[dataRef t_crm_channel]
        private String sourceChannelId;
        // 是否开通美股市场[0=否 1=是]
        private Integer isOpenUsaStockMarket;
        // 是否开通港股市场[0=否 1=是]
        private Integer isOpenHkStockMarket;
        // 是否允许衍生品交易[0=否 1=是]
        private Integer isAllowDerivativesTransaction;
        // 交易帐号
        private String tradeAccount;
        // 资金帐号
        private String fundAccount;
        //交易帐号（批量查询）
        private List<String> batchTradeAccountList;
        // 开户时间
        private String openAccountTime;
        //注册状态
        private String userRegStatus;
        //入金状态
        private String depositStatus;
        //出金状态
        private String withdrawalStatus;
        //转仓状态
        private String transferStatus;
        // 交易状态
        private String tradeStatus;
        // 开户状态
        private String openAccountStatus;
        // 证券市场[K-港交所 P-美国市场]
        private String exchangeType;
        // 渠道号
        private Integer channelId;
        // 码值唯一标识
        private String mark;
        // 交易日期
        private String tradeDate;
        // 交易开始日期
        private String trdBeginDate;
        // 交易结束日期
        private String trdEndDate;
        // 操作类型[D-入金 W-出金]
        private String depositType;
        //小神帐号（批量查询）
        private List<String> batchUserIdList;
        //股票代码（批量查询）
        private List<String> batchStkCodeList;

        // 码值状态[0-无效 1-有效]
        private String codeStatus;

        //金额
        private BigDecimal amount;

        public Integer getOpenAccountType() {
            return openAccountType;
        }

        public void setOpenAccountType(Integer openAccountType) {
            this.openAccountType = openAccountType;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

        public Integer getIsAmericanGreenCardHolder() {
            return isAmericanGreenCardHolder;
        }

        public void setIsAmericanGreenCardHolder(Integer isAmericanGreenCardHolder) {
            this.isAmericanGreenCardHolder = isAmericanGreenCardHolder;
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

        public String getInviterId() {
            return inviterId;
        }

        public void setInviterId(String inviterId) {
            this.inviterId = inviterId;
        }

        public String getSourceChannelId() {
            return sourceChannelId;
        }

        public void setSourceChannelId(String sourceChannelId) {
            this.sourceChannelId = sourceChannelId;
        }

        public Integer getIsOpenUsaStockMarket() {
            return isOpenUsaStockMarket;
        }

        public void setIsOpenUsaStockMarket(Integer isOpenUsaStockMarket) {
            this.isOpenUsaStockMarket = isOpenUsaStockMarket;
        }

        public Integer getIsOpenHkStockMarket() {
            return isOpenHkStockMarket;
        }

        public void setIsOpenHkStockMarket(Integer isOpenHkStockMarket) {
            this.isOpenHkStockMarket = isOpenHkStockMarket;
        }

        public Integer getIsAllowDerivativesTransaction() {
            return isAllowDerivativesTransaction;
        }

        public void setIsAllowDerivativesTransaction(Integer isAllowDerivativesTransaction) {
            this.isAllowDerivativesTransaction = isAllowDerivativesTransaction;
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

        public List<String> getBatchTradeAccountList() {
            return batchTradeAccountList;
        }

        public void setBatchTradeAccountList(List<String> batchTradeAccountList) {
            this.batchTradeAccountList = batchTradeAccountList;
        }

        public String getOpenAccountTime() {
            return openAccountTime;
        }

        public void setOpenAccountTime(String openAccountTime) {
            this.openAccountTime = openAccountTime;
        }

        public String getUserRegStatus() {
            return userRegStatus;
        }

        public void setUserRegStatus(String userRegStatus) {
            this.userRegStatus = userRegStatus;
        }

        public String getDepositStatus() {
            return depositStatus;
        }

        public void setDepositStatus(String depositStatus) {
            this.depositStatus = depositStatus;
        }

        public String getWithdrawalStatus() {
            return withdrawalStatus;
        }

        public void setWithdrawalStatus(String withdrawalStatus) {
            this.withdrawalStatus = withdrawalStatus;
        }

        public String getTransferStatus() {
            return transferStatus;
        }

        public void setTransferStatus(String transferStatus) {
            this.transferStatus = transferStatus;
        }

        public String getTradeStatus() {
            return tradeStatus;
        }

        public void setTradeStatus(String tradeStatus) {
            this.tradeStatus = tradeStatus;
        }

        public String getOpenAccountStatus() {
            return openAccountStatus;
        }

        public void setOpenAccountStatus(String openAccountStatus) {
            this.openAccountStatus = openAccountStatus;
        }

        public String getExchangeType() {
            return exchangeType;
        }

        public void setExchangeType(String exchangeType) {
            this.exchangeType = exchangeType;
        }

        public Integer getChannelId() {
            return channelId;
        }

        public void setChannelId(Integer channelId) {
            this.channelId = channelId;
        }

        public String getMark() {
            return mark;
        }

        public void setMark(String mark) {
            this.mark = mark;
        }

        public String getTradeDate() {
            return tradeDate;
        }

        public void setTradeDate(String tradeDate) {
            this.tradeDate = tradeDate;
        }

        public String getTrdBeginDate() {
            return trdBeginDate;
        }

        public void setTrdBeginDate(String trdBeginDate) {
            this.trdBeginDate = trdBeginDate;
        }

        public String getTrdEndDate() {
            return trdEndDate;
        }

        public void setTrdEndDate(String trdEndDate) {
            this.trdEndDate = trdEndDate;
        }

        public String getDepositType() {
            return depositType;
        }

        public void setDepositType(String depositType) {
            this.depositType = depositType;
        }

        public List<String> getBatchUserIdList() {
            return batchUserIdList;
        }

        public void setBatchUserIdList(List<String> batchUserIdList) {
            this.batchUserIdList = batchUserIdList;
        }

        public List<String> getBatchStkCodeList() {
            return batchStkCodeList;
        }

        public void setBatchStkCodeList(List<String> batchStkCodeList) {
            this.batchStkCodeList = batchStkCodeList;
        }

        public String getCodeStatus() {
            return codeStatus;
        }

        public void setCodeStatus(String codeStatus) {
            this.codeStatus = codeStatus;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }
    }
}



