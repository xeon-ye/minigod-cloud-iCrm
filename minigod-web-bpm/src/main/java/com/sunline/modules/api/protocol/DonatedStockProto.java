package com.sunline.modules.api.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * @description: 赠股业务请求协议
 * @author: Larry Lai
 * @date: 2018/12/21 10:17
 * @version: v1.0
 */

public class DonatedStockProto {

    public static class DonatedStockProtoRequest extends BaseParameter {

        private static final long serialVersionUID = 5799005412225842491L;

        @JSONField(name = "applicationId")
        private String applicationId;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }
    }

    public static class DonatedStockProtoResponse {

        private static final long serialVersionUID = 5799005412225842491L;

        //流水号
        @JSONField(name = "applicationId")
        private String applicationId;
        //交易帐号
        @JSONField(name = "clientId")
        private String clientId;
        //资金帐号
        @JSONField(name = "fundAccount")
        private String fundAccount;
        //股票代码
        @JSONField(name = "stockCode")
        private String stockCode;
        //股票名称
        @JSONField(name = "stockName")
        private String stockName;
        //股票数量
        @JSONField(name = "stockQuantity")
        private Integer stockQuantity;
        //活动ID
        @JSONField(name = "activityId")
        private Integer activityId;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

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

        public String getStockCode() {
            return stockCode;
        }

        public void setStockCode(String stockCode) {
            this.stockCode = stockCode;
        }

        public String getStockName() {
            return stockName;
        }

        public void setStockName(String stockName) {
            this.stockName = stockName;
        }

        public Integer getStockQuantity() {
            return stockQuantity;
        }

        public void setStockQuantity(Integer stockQuantity) {
            this.stockQuantity = stockQuantity;
        }

        public Integer getActivityId() {
            return activityId;
        }

        public void setActivityId(Integer activityId) {
            this.activityId = activityId;
        }
    }
}
