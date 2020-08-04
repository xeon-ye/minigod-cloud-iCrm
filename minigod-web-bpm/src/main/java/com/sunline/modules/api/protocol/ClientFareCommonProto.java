package com.sunline.modules.api.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;
import io.swagger.models.auth.In;

/**
 * @description: 客户佣金费率请求协议
 * @author: Larry Lai
 * @date: 2018/8/21 20:36
 * @version: v1.0
 */

public class ClientFareCommonProto {

    public static class ClientFreeCommRequest extends BaseParameter {

        private static final long serialVersionUID = 6719037768601808356L;

        @JSONField(name = "clientId")
        private String clientId;

        @JSONField(name = "fundAccount")
        private String fundAccount;

        @JSONField(name = "exchangeType")
        private String exchangeType;

        @JSONField(name = "beginDate")
        private String beginDate;

        @JSONField(name = "endDate")
        private String endDate;

        /**
         * 免佣类型[0-开户免佣 1-推荐股友免佣 2-入金免佣]
         */
        @JSONField(name = "freeCommType")
        private Integer freeCommType;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(String fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getExchangeType() {
            return exchangeType;
        }

        public void setExchangeType(String exchangeType) {
            this.exchangeType = exchangeType;
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

        public Integer getFreeCommType() {
            return freeCommType;
        }

        public void setFreeCommType(Integer freeCommType) {
            this.freeCommType = freeCommType;
        }
    }

}
