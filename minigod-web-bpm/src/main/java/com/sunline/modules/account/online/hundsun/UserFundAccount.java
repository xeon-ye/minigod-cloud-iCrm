package com.sunline.modules.account.online.hundsun;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/18
 * @description
 * @email justbelyf@gmail.com
 */
public final class UserFundAccount {
    private UserFundAccount(){}

    /**
     * 资金账户创建
     */
    public static final class UserFundAccountCreateRequest{
        // 复核类型（传1）		必须传1
//        @JSONField(name = "audit_action")
//        private String auditAction;
        // 客户编号		必填
        @JSONField(name = "client_id")
        private String clientID;
        // 结算银行号		必填 可以不填
//        @JSONField(name = "bank_no")
//        private String bankNo;
        // 主账标志（对应字典项编号：1012[0=增开户，1=新开户] 全新开户：1 增开户：0）		必填
//        @JSONField(name = "main_flag")
//        private String mainFlag;
        // 结算方式（对应字典项编号：1051[1=common,4=DAP,6=escrow]		必填 1
//        @JSONField(name = "client_group")
//        private Integer clientGroup;
        // 客户级别（对应字典项编号：1052[1=一般,2=重要,3=VIP,4=PI,5=资金,6=CIES,7=委托,8=CIES委托]		必填 1
//        @JSONField(name = "room_code")
//        private Integer roomCode;
        // 账户类型（对应字典项编号：3002[0=现金账户，M=Margin账户]		必填 0
//        @JSONField(name = "asset_prop")
//        private String assetProp;
        // 客户类型（对应字典项编号：1048[0=个人，1=团体，3=职员，4=公共机构，5=家庭]		必填 0
//        @JSONField(name = "organ_flag")
//        private String organFlag;
        // 费用类别串(采用默认费用类别的话，送“0000000000000000000000000000000000000000000000009999999900000000”                                1-4:上海标准前台费用类型 5-8:上海标准后台费用类型 9-12:上海标准回购费用类型 13-16:上海标准场内交易费用类型 17-20:上海前台费用类型 21-24:上海后台费用类型 25-28:上海回购费用类型 29-32:上海场内交易费用类型 33-36:深圳标准前台费用类型 37-40:深圳标准后台费用类型 41-44:深圳标准回购费用类型 45-48:深圳标准场内交易费用类型 49-52:深圳前台费用类型 53-56:深圳后台费用类型 57-60:深圳回购费用类型 61-64:深圳场内)"		必填
//        @JSONField(name = "fare_kind_str")
//        private String fareKindStr;
        // 允许委托方式 1201[4=电话，7=互联网]		必填 7
//        @JSONField(name = "en_entrust_way")
//        private String enEntrustWay;
        // 客户权限（对应字典项编号：1021[B=Mail Statement,C=cross branch permit,E=remind flag,L=overdraft right,V=A.E.Client]		必填 c
//        @JSONField(name = "client_rights")
//        private String clientRights;
        // 成本类型（对应字典项编号：3004[0=average price,1=position cost,2=capital preservation price]		必填 0
//        @JSONField(name = "profit_flag")
//        private String profitFlag;
        // 临时股东状态		必填 0
//        @JSONField(name = "holder_status_temp")
//        private String holderStatusTemp;
        // 券托管在本券商处（1为托管在本券商 0：非托管在本券商下 ）		必填 1
//        @JSONField(name = "save_keeping")
//        private String saveKeeping;
        // 开户合约上的日期		必填
        @JSONField(name = "contract_date")
        private Integer contractDate;
        // 客户标识（对应字典项编号：629002[1=US trade]		必填 1
//        @JSONField(name = "client_marked")
//        private String clientMarked;
        // 客户信用比率		必填 1 好像可以不填
        @JSONField(name = "credit_ratio")
        private Double creditRatio;
        // 是否加入产品标志 0 - 未加入 1 - 加入													必须传0
//        @JSONField(name = "product_flag")
//        private String productFlag;
        // 结算标志（用来标志资产账户的结算模式。0-本地客户，1-银证通客户，2-第三方存管客户）		必须传0
//        @JSONField(name = "square_flag")
//        private String squareFlag;


        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public Integer getContractDate() {
            return contractDate;
        }

        public void setContractDate(Integer contractDate) {
            this.contractDate = contractDate;
        }

        public Double getCreditRatio() {
            return creditRatio;
        }

        public void setCreditRatio(Double creditRatio) {
            this.creditRatio = creditRatio;
        }
    }

    public static final class UserFundAccountCreateResponse{

    }

    /**
     * 资金账户认证
     */
    public static final class UserFundAccountIdentifyRequest{
        // 复核类型（传1）	必须传1
//        @JSONField(name = "audit_action")
//        private String auditAction;
        // 用户编号		必填
        @JSONField(name = "user_id")
        private String userID;
        // 资产账号		必填
        @JSONField(name = "fund_account")
        private Integer fundAccount;
        // 备注  			必填
        @JSONField(name = "remark")
        private String remark;

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public Integer getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(Integer fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    public static final class UserFundAccountIdentifyResponse{

    }
}
