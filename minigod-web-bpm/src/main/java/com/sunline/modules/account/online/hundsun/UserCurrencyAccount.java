package com.sunline.modules.account.online.hundsun;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/18
 * @description
 * @email justbelyf@gmail.com
 */
public final class UserCurrencyAccount {
    private UserCurrencyAccount(){}

    /**
     * 用户币种开户
     */
    public static final class UserCurrencyAccountCreateRequest{
        // 复核类型（传1）		必须传1
//        @JSONField(name = "audit_action")
//        private String auditAction;
        // 客户号				必填
        @JSONField(name = "client_id")
        private String clientID;
        // 柜台资金帐号		必填
        @JSONField(name = "fund_account")
        private Integer fundAccount;
        // 币种类别[0=CNY,1=USK,2=HKD]			必填
        @JSONField(name = "en_money_type")
        private String enMoneyType;
        // 利率类别		默认为0
//        @JSONField(name = "rate_kind")
//        private String rateKind;
        // 结算标志（用来标志资产账户的结算模式。0-本地客户，1-银证通客户，2-第三方存管客户）		必须传0
//        @JSONField(name = "square_flag")
//        private String squareFlag;
        // 结算银行号			必填
//        @JSONField(name = "bank_no")
//        private String bankNo;
        // 操作备注			必填
//        @JSONField(name = "op_remark")
//        private String opRemark;


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

        public String getEnMoneyType() {
            return enMoneyType;
        }

        public void setEnMoneyType(String enMoneyType) {
            this.enMoneyType = enMoneyType;
        }
    }

    public static final class UserCurrencyAccountCreateResponse{

    }
}
