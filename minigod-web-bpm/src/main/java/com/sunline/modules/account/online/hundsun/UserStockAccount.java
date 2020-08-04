package com.sunline.modules.account.online.hundsun;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/18
 * @description
 * @email justbelyf@gmail.com
 */
public final class UserStockAccount {
    private UserStockAccount(){}

    /**
     * 证券账户开户
     */
    public static final class UserStockAccountCreateRequest{
        // 复核类型（传1）		必须传1
//        @JSONField(name = "audit_action")
//        private String auditAction;
        // 证件类别（对应字典项编号：1041[0=香港身份证,1=中国身份证，2=护照，3=公司注册证，4=营业执照]		必填
        @JSONField(name = "id_kind")
        private String idKind;
        // 证件号码		必填
        @JSONField(name = "id_no")
        private String idNo;
        // 帐户姓名		必填
        @JSONField(name = "holder_name")
        private String holderName;
        // 客户编号		必填
        @JSONField(name = "client_id")
        private String clientID;
        // 资金帐号		必填
        @JSONField(name = "fund_account")
        private Integer fundAccount;
        // 交易类别/市场（对应字典项编号：1301[1=上海A股，2=深圳A股，D=上海B股，H=深圳B股，K=香港联交所,P=USA] ）		必填 K
        @JSONField(name = "exchange_type")
        private String exchangeType;
        // 证券帐号		必填 和资金帐号一致
        @JSONField(name = "stock_account")
        private String stockAccount;
        // 帐户类别 0 普通帐户，1  基金帐户，2  法人帐户，...		必填 0
//        @JSONField(name = "holder_kind")
//        private String holderKind;
        // 股东级别 0 一级股东(实)，1   二级股东(虚)，2   虚拟股东(纯虚),   3 借用股东(纯虚)		必填 0
//        @JSONField(name = "holder_level")
//        private String holderLevel;
        // 申报级别 0 普通 1 特殊		必填 0
//        @JSONField(name = "report_level")
//        private String reportLevel;
        // 股东权限 0 自动配股，1  红利领取		必填 0
//        @JSONField(name = "holder_rights")
//        private String holderRights;
        // 是否指定 0 未指定，1 已指定，2 新指定，其它非法		必填 0
//        @JSONField(name = "regflag")
//        private String regflag;
        // 回购登记 0 未指定，1 已指定		必填 0
//        @JSONField(name = "bondreg")
//        private String bondreg;
        // 临时股东状态		必填 0
//        @JSONField(name = "holder_status_temp")
//        private String holderStatusTemp;


        public String getIdKind() {
            return idKind;
        }

        public void setIdKind(String idKind) {
            this.idKind = idKind;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getHolderName() {
            return holderName;
        }

        public void setHolderName(String holderName) {
            this.holderName = holderName;
        }

        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public Integer getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(Integer fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getStockAccount() {
            return stockAccount;
        }

        public void setStockAccount(String stockAccount) {
            this.stockAccount = stockAccount;
        }

        public String getExchangeType() {
            return exchangeType;
        }

        public void setExchangeType(String exchangeType) {
            this.exchangeType = exchangeType;
        }
    }

    public static final class UserStockAccountCreateResponse{

    }
}
