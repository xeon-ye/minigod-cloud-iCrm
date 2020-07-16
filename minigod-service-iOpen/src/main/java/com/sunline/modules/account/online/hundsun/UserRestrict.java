package com.sunline.modules.account.online.hundsun;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/18
 * @description
 * @email justbelyf@gmail.com
 */
public final class UserRestrict {
    private UserRestrict() {
    }

    /**
     * 证券账户开户
     */
    public static final class UserStockRestrictOperatorRequest {
        // 输入字符（1：新增，2：修改，3：删除）
        @JSONField(name = "action_in")
        private Integer actionIn;

        // 交易类别（对应字典项编号：1301[1=上海A股，2=深圳A股，D=上海B股，H=深圳B股，K=香港联交所,P=USA] ）
        @JSONField(name = "exchange_type")
        private String exchangeType;

        // 证券类别（值取至数据字典1206）
        @JSONField(name = "stock_type")
        private String stockType;

        // 证券代码（不传默认是!）
        @JSONField(name = "stock_code")
        private String stockCode;

        // 委托方向
        @JSONField(name = "entrust_bs")
        private String entrustBs;

        // 结算方式（传资金帐号时该字段可不传。值取至数据字典1051）
        @JSONField(name = "client_group")
        private Integer clientGroup;

        // 客户标识（传资金帐号时该字段可不传。值取至数据字典629002）
        @JSONField(name = "client_marked")
        private String clientMarked;

        // 客户级别（传资金帐号时该字段可不传。值取至数据字典1052）
        @JSONField(name = "room_code")
        private Integer roomCode;

        // 资金账户
        @JSONField(name = "fund_account")
        private String fundAccount;

        // 限制委托方式（委托方式之间用','字符分割。值取至数据字典1201）
        @JSONField(name = "res_entrust_way")
        private String resEntrustWay;

        // 板块代码（传柜台存在的板块代码，值取至数据字典610010）
        @JSONField(name = "market_code")
        private String marketCode;

        // 客户类型（传资金帐号时该字段可不传。值取至数据字典1048）
        @JSONField(name = "organ_flag")
        private String organFlag;

        // 资产属性（传该值时，不能传资金帐号。值取至数据字典3002）
        @JSONField(name = "asset_prop")
        private String assetProp;

        // 开始日期（修改：不能修改开始日期，该值与原始开始日期一样）
        @JSONField(name = "start_date")
        private Integer startDate;

        // 开始时间（修改：不能修改开始时间，该值与原始开始时间一样）
        @JSONField(name = "start_time")
        private Integer startTime;

        // 结束日期
        @JSONField(name = "end_date")
        private Integer endDate;

        // 结束时间
        @JSONField(name = "end_time")
        private Integer endTime;

        // 原始开始日期（修改需要传原始的开始日期）
        @JSONField(name = "old_start_date")
        private Integer oldStartDate;

        // 原始开始时间（修改需要传原始的开始时间）
        @JSONField(name = "old_start_time")
        private Integer oldStartTime;

        // 原始结束日期（修改需要传原始的结束日期）
        @JSONField(name = "old_end_date")
        private Integer oldEndDate;

        // 原始结束时间（修改需要传原始的结束时间）
        @JSONField(name = "old_end_time")
        private Integer oldEndTime;

        // 原始限制委托方式（委托方式之间用','字符分割，传柜台存在的委托方式。值取至数据字典1201）
        @JSONField(name = "old_res_entrust_way")
        private String oldResEntrustWay;

        public Integer getActionIn() {
            return actionIn;
        }

        public void setActionIn(Integer actionIn) {
            this.actionIn = actionIn;
        }

        public String getExchangeType() {
            return exchangeType;
        }

        public void setExchangeType(String exchangeType) {
            this.exchangeType = exchangeType;
        }

        public String getStockType() {
            return stockType;
        }

        public void setStockType(String stockType) {
            this.stockType = stockType;
        }

        public String getStockCode() {
            return stockCode;
        }

        public void setStockCode(String stockCode) {
            this.stockCode = stockCode;
        }

        public String getEntrustBs() {
            return entrustBs;
        }

        public void setEntrustBs(String entrustBs) {
            this.entrustBs = entrustBs;
        }

        public Integer getClientGroup() {
            return clientGroup;
        }

        public void setClientGroup(Integer clientGroup) {
            this.clientGroup = clientGroup;
        }

        public String getClientMarked() {
            return clientMarked;
        }

        public void setClientMarked(String clientMarked) {
            this.clientMarked = clientMarked;
        }

        public Integer getRoomCode() {
            return roomCode;
        }

        public void setRoomCode(Integer roomCode) {
            this.roomCode = roomCode;
        }

        public String getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(String fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getResEntrustWay() {
            return resEntrustWay;
        }

        public void setResEntrustWay(String resEntrustWay) {
            this.resEntrustWay = resEntrustWay;
        }

        public String getMarketCode() {
            return marketCode;
        }

        public void setMarketCode(String marketCode) {
            this.marketCode = marketCode;
        }

        public String getOrganFlag() {
            return organFlag;
        }

        public void setOrganFlag(String organFlag) {
            this.organFlag = organFlag;
        }

        public String getAssetProp() {
            return assetProp;
        }

        public void setAssetProp(String assetProp) {
            this.assetProp = assetProp;
        }

        public Integer getStartDate() {
            return startDate;
        }

        public void setStartDate(Integer startDate) {
            this.startDate = startDate;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public void setStartTime(Integer startTime) {
            this.startTime = startTime;
        }

        public Integer getEndDate() {
            return endDate;
        }

        public void setEndDate(Integer endDate) {
            this.endDate = endDate;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public void setEndTime(Integer endTime) {
            this.endTime = endTime;
        }

        public Integer getOldStartDate() {
            return oldStartDate;
        }

        public void setOldStartDate(Integer oldStartDate) {
            this.oldStartDate = oldStartDate;
        }

        public Integer getOldStartTime() {
            return oldStartTime;
        }

        public void setOldStartTime(Integer oldStartTime) {
            this.oldStartTime = oldStartTime;
        }

        public Integer getOldEndDate() {
            return oldEndDate;
        }

        public void setOldEndDate(Integer oldEndDate) {
            this.oldEndDate = oldEndDate;
        }

        public Integer getOldEndTime() {
            return oldEndTime;
        }

        public void setOldEndTime(Integer oldEndTime) {
            this.oldEndTime = oldEndTime;
        }

        public String getOldResEntrustWay() {
            return oldResEntrustWay;
        }

        public void setOldResEntrustWay(String oldResEntrustWay) {
            this.oldResEntrustWay = oldResEntrustWay;
        }
    }

    public static final class UserStockRestrictOperatorResponse {
        // 错误序号
        @JSONField(name = "error_no")
        private Integer errorNo;
        // 错误提示
        @JSONField(name = "error_info")
        private String errorInfo;
        // 流水号
        @JSONField(name = "serial_no")
        private int serialNo;
        // 操作备注
        @JSONField(name = "op_remark")
        private String opRemark;

        public Integer getErrorNo() {
            return errorNo;
        }

        public void setErrorNo(Integer errorNo) {
            this.errorNo = errorNo;
        }

        public String getErrorInfo() {
            return errorInfo;
        }

        public void setErrorInfo(String errorInfo) {
            this.errorInfo = errorInfo;
        }

        public int getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }

        public String getOpRemark() {
            return opRemark;
        }

        public void setOpRemark(String opRemark) {
            this.opRemark = opRemark;
        }
    }
}
