package com.sunline.modules.api.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * @description: 客户开户资料
 * @author: Larry Lai
 * @date: 2019/1/16 17:18
 * @version: v1.0
 */

public class AccountOpenInfoProto {

    public static class AccountOpenInfoRequest extends BaseParameter {

        private static final long serialVersionUID = -614772473837346281L;

        // 交易帐号
        @JSONField(name = "tradeAccount")
        private String tradeAccount;

        // 签发机关
        @JSONField(name = "signingOrganization")
        private String signingOrganization;

        // 名族
        @JSONField(name = "nation")
        private String nation;

        public String getTradeAccount() {
            return tradeAccount;
        }

        public void setTradeAccount(String tradeAccount) {
            this.tradeAccount = tradeAccount;
        }

        public String getSigningOrganization() {
            return signingOrganization;
        }

        public void setSigningOrganization(String signingOrganization) {
            this.signingOrganization = signingOrganization;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }
    }

    public static class AccountOpenInfoResponse {

        private static final long serialVersionUID = 4391934719865430996L;

        @JSONField(name = "applicationId")
        private String applicationId;

        @JSONField(name = "openAccountFileUrl")
        private String openAccountFileUrl;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public String getOpenAccountFileUrl() {
            return openAccountFileUrl;
        }

        public void setOpenAccountFileUrl(String openAccountFileUrl) {
            this.openAccountFileUrl = openAccountFileUrl;
        }
    }
}
