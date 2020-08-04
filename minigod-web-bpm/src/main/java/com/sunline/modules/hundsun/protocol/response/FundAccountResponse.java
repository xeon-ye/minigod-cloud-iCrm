package com.sunline.modules.hundsun.protocol.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 服务_海外_资金账户信息查询
 * @author: Larry Lai
 * @date: 2019/12/26 20:06
 * @version: v1.0
 */

public class FundAccountResponse {

    public static class FundAccountGetResponse {

        /**
         * 错误提示
         */
        @JSONField(name = "error_info")
        private String errorInfo;

        /**
         * 错误编号
         */
        @JSONField(name = "error_no")
        private Integer errorNo;

        /**
         * 客户编号
         */
        @JSONField(name = "client_id")
        private String clientId;

        /**
         * 柜台资金账号
         */
        @JSONField(name = "fund_account")
        private Integer fundAccount;

        /**
         * 客户状态
         */
        @JSONField(name = "fundacct_status")
        private String fundacctStatus;

        /**
         * 主账标志
         */
        @JSONField(name = "main_flag")
        private String mainFlag;

        /**
         * 客户开户银行
         */
        @JSONField(name = "bank_no")
        private String bankNo;

        /**
         * 分支银行
         */
        @JSONField(name = "bank_batch")
        private String bankBatch;

        /**
         * 客户银行账户
         */
        @JSONField(name = "bank_AC")
        private String bankAC;

        /**
         * 允许委托方式
         */
        @JSONField(name = "en_entrust_way")
        private String enEntrustWay;

        /**
         * 客户限制
         */
        @JSONField(name = "restriction")
        private String restriction;

        /**
         * 大户室号
         */
        @JSONField(name = "room_code")
        private Integer roomCode;

        /**
         * 客户类别
         */
        @JSONField(name = "client_group")
        private Integer clientGroup;

        /**
         * 费用类别串
         */
        @JSONField(name = "fare_kind_str")
        private String fareKindStr;

        /**
         * 资金管理用
         */
        @JSONField(name = "open_trades")
        private String openTrades;

        /**
         * 盈亏计算方式
         */
        @JSONField(name = "profit_flag")
        private String profitFlag;

        /**
         * 备注
         */
        @JSONField(name = "remark")
        private String remark;

        /**
         * 资产属性
         */
        @JSONField(name = "asset_prop")
        private String assetProp;

        /**
         * 机构标志
         */
        @JSONField(name = "organ_flag")
        private String organFlag;

        /**
         * 券托管在本券商处
         */
        @JSONField(name = "save_keeping")
        private String saveKeeping;

        /**
         * 客户标识
         */
        @JSONField(name = "client_marked")
        private String clientMarked;

        /**
         * 欠款结余方式
         */
        @JSONField(name = "cash_RA")
        private String cashRA;

        /**
         * 生效日期
         */
        @JSONField(name = "valid_date")
        private Integer validDate;

        /**
         * 截止日期
         */
        @JSONField(name = "expiry_date_expiry")
        private Integer expiryDateExpiry;

        /**
         * 优惠费用套餐类型串
         */
        @JSONField(name = "fare_kind_prior")
        private String fareKindPrior;

        /**
         * 默认费用套餐类型串
         */
        @JSONField(name = "fare_kind_post")
        private String fareKindPost;

        public String getErrorInfo() {
            return errorInfo;
        }

        public void setErrorInfo(String errorInfo) {
            this.errorInfo = errorInfo;
        }

        public Integer getErrorNo() {
            return errorNo;
        }

        public void setErrorNo(Integer errorNo) {
            this.errorNo = errorNo;
        }

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public Integer getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(Integer fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getFundacctStatus() {
            return fundacctStatus;
        }

        public void setFundacctStatus(String fundacctStatus) {
            this.fundacctStatus = fundacctStatus;
        }

        public String getMainFlag() {
            return mainFlag;
        }

        public void setMainFlag(String mainFlag) {
            this.mainFlag = mainFlag;
        }

        public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

        public String getBankBatch() {
            return bankBatch;
        }

        public void setBankBatch(String bankBatch) {
            this.bankBatch = bankBatch;
        }

        public String getBankAC() {
            return bankAC;
        }

        public void setBankAC(String bankAC) {
            this.bankAC = bankAC;
        }

        public String getEnEntrustWay() {
            return enEntrustWay;
        }

        public void setEnEntrustWay(String enEntrustWay) {
            this.enEntrustWay = enEntrustWay;
        }

        public String getRestriction() {
            return restriction;
        }

        public void setRestriction(String restriction) {
            this.restriction = restriction;
        }

        public Integer getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(Integer roomCode) {
            this.roomCode = roomCode;
        }

        public Integer getClientGroup() {
            return clientGroup;
        }

        public void setClientGroup(Integer clientGroup) {
            this.clientGroup = clientGroup;
        }

        public String getFareKindStr() {
            return fareKindStr;
        }

        public void setFareKindStr(String fareKindStr) {
            this.fareKindStr = fareKindStr;
        }

        public String getOpenTrades() {
            return openTrades;
        }

        public void setOpenTrades(String openTrades) {
            this.openTrades = openTrades;
        }

        public String getProfitFlag() {
            return profitFlag;
        }

        public void setProfitFlag(String profitFlag) {
            this.profitFlag = profitFlag;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getAssetProp() {
            return assetProp;
        }

        public void setAssetProp(String assetProp) {
            this.assetProp = assetProp;
        }

        public String getOrganFlag() {
            return organFlag;
        }

        public void setOrganFlag(String organFlag) {
            this.organFlag = organFlag;
        }

        public String getSaveKeeping() {
            return saveKeeping;
        }

        public void setSaveKeeping(String saveKeeping) {
            this.saveKeeping = saveKeeping;
        }

        public String getClientMarked() {
            return clientMarked;
        }

        public void setClientMarked(String clientMarked) {
            this.clientMarked = clientMarked;
        }

        public String getCashRA() {
            return cashRA;
        }

        public void setCashRA(String cashRA) {
            this.cashRA = cashRA;
        }

        public Integer getValidDate() {
            return validDate;
        }

        public void setValidDate(Integer validDate) {
            this.validDate = validDate;
        }

        public Integer getExpiryDateExpiry() {
            return expiryDateExpiry;
        }

        public void setExpiryDateExpiry(Integer expiryDateExpiry) {
            this.expiryDateExpiry = expiryDateExpiry;
        }

        public String getFareKindPrior() {
            return fareKindPrior;
        }

        public void setFareKindPrior(String fareKindPrior) {
            this.fareKindPrior = fareKindPrior;
        }

        public String getFareKindPost() {
            return fareKindPost;
        }

        public void setFareKindPost(String fareKindPost) {
            this.fareKindPost = fareKindPost;
        }
    }

    public static class FundAccountModiResponse {

        /**
         * 错误提示
         */
        @JSONField(name = "error_info")
        private String errorInfo;

        /**
         * 错误编号
         */
        @JSONField(name = "error_no")
        private Integer errorNo;

        /**
         * 操作备注
         */
        @JSONField(name = "op_remark")
        private String opRemark;

        /**
         * 流水号
         */
        @JSONField(name = "serial_no")
        private Integer serialNo;

        /**
         * 业务标志
         */
        @JSONField(name = "business_flag")
        private String businessFlag;

        public String getErrorInfo() {
            return errorInfo;
        }

        public void setErrorInfo(String errorInfo) {
            this.errorInfo = errorInfo;
        }

        public Integer getErrorNo() {
            return errorNo;
        }

        public void setErrorNo(Integer errorNo) {
            this.errorNo = errorNo;
        }

        public String getOpRemark() {
            return opRemark;
        }

        public void setOpRemark(String opRemark) {
            this.opRemark = opRemark;
        }

        public Integer getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(Integer serialNo) {
            this.serialNo = serialNo;
        }

        public String getBusinessFlag() {
            return businessFlag;
        }

        public void setBusinessFlag(String businessFlag) {
            this.businessFlag = businessFlag;
        }
    }

}
