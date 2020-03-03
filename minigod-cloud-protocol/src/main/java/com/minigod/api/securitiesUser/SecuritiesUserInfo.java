package com.minigod.api.securitiesUser;


import com.minigod.common.CommonErrorCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author LiYangFeng
 * @createDate 2017/10/11
 * @description
 * @email justbelyf@gmail.com
 */
public class SecuritiesUserInfo {
    private SecuritiesUserInfo() {
    }

    public static class AddSecuritiesUserInfoRequest implements Serializable{
        private SecuritiesUserModel.SecuritiesUserFullInfo securitiesUserInfo;

        public SecuritiesUserModel.SecuritiesUserFullInfo getSecuritiesUserInfo() {
            return securitiesUserInfo;
        }

        public void setSecuritiesUserInfo(SecuritiesUserModel.SecuritiesUserFullInfo securitiesUserInfo) {
            this.securitiesUserInfo = securitiesUserInfo;
        }
    }

    public static class AddSecuritiesUserInfoResponse implements Serializable{
        private CommonErrorCode commonErrorCode;

        public CommonErrorCode getCommonErrorCode() {
            return commonErrorCode;
        }

        public void setCommonErrorCode(CommonErrorCode commonErrorCode) {
            this.commonErrorCode = commonErrorCode;
        }
    }


    public static class UpdateSecuritiesUserInfoRequest implements Serializable{
        private SecuritiesUserModel.SecuritiesUserFullInfo securitiesUserInfo;

        public SecuritiesUserModel.SecuritiesUserFullInfo getSecuritiesUserInfo() {
            return securitiesUserInfo;
        }

        public void setSecuritiesUserInfo(SecuritiesUserModel.SecuritiesUserFullInfo securitiesUserInfo) {
            this.securitiesUserInfo = securitiesUserInfo;
        }
    }

    public static class UpdateSecuritiesUserInfoResponse implements Serializable{
        private CommonErrorCode commonErrorCode;

        public CommonErrorCode getCommonErrorCode() {
            return commonErrorCode;
        }

        public void setCommonErrorCode(CommonErrorCode commonErrorCode) {
            this.commonErrorCode = commonErrorCode;
        }
    }


    public static class QuerySecuritiesUserInfoRequest implements Serializable{
        // gid
        private Integer gid;
        // 开户类型[1=互联网、2=见证宝 3=BPM]
        private Integer openAccountType;
        // 客户号(犇犇号)
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
        // 交易账号
        private String tradeAccount;
        // 资金账号
        private String fundAccount;

        public Integer getGid() {
            return gid;
        }

        public void setGid(Integer gid) {
            this.gid = gid;
        }

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
    }

    public static class QuerySecuritiesUserInfoResponse implements Serializable{
        private List<SecuritiesUserModel.SecuritiesUserFullInfo> recordList;
        private CommonErrorCode commonErrorCode;

        public List<SecuritiesUserModel.SecuritiesUserFullInfo> getRecordList() {
            return recordList;
        }

        public void setRecordList(List<SecuritiesUserModel.SecuritiesUserFullInfo> recordList) {
            this.recordList = recordList;
        }

        public CommonErrorCode getCommonErrorCode() {
            return commonErrorCode;
        }

        public void setCommonErrorCode(CommonErrorCode commonErrorCode) {
            this.commonErrorCode = commonErrorCode;
        }
    }

    public static class QuerySecuritiesUserInfoSingleRequest implements Serializable{
        // gid
        private Integer gid;
        // 证件号码
        private String idNo;
        // 电子邮箱
        private String email;
        // 手机号
        private String phoneNumber;
        // 交易账号
        private String tradeAccount;
        // 资金账号
        private String fundAccount;

        public Integer getGid() {
            return gid;
        }

        public void setGid(Integer gid) {
            this.gid = gid;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
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
    }

    public static class QuerySecuritiesUserInfoSingleResponse implements Serializable{
        private SecuritiesUserModel.SecuritiesUserFullInfo securitiesUserFullInfo;
        private CommonErrorCode commonErrorCode;

        public SecuritiesUserModel.SecuritiesUserFullInfo getSecuritiesUserFullInfo() {
            return securitiesUserFullInfo;
        }

        public void setSecuritiesUserFullInfo(SecuritiesUserModel.SecuritiesUserFullInfo securitiesUserFullInfo) {
            this.securitiesUserFullInfo = securitiesUserFullInfo;
        }

        public CommonErrorCode getCommonErrorCode() {
            return commonErrorCode;
        }

        public void setCommonErrorCode(CommonErrorCode commonErrorCode) {
            this.commonErrorCode = commonErrorCode;
        }
    }
}
