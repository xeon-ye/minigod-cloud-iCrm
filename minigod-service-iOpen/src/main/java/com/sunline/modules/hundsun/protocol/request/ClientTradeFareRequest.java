package com.sunline.modules.hundsun.protocol.request;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @description: 客户交易费用设置请求协议
 * @author: Larry Lai
 * @date: 2018/8/21 16:26
 * @version: v1.0
 */

public class ClientTradeFareRequest {
    /**
     * 用户类型
     */
    @JSONField(name = "userType")
    private String userType;

    /**
     * 客户号
     */
    @JSONField(name = "clientId")
    private String clientId;

    /**
     * 资金帐号
     */
    @JSONField(name = "fundAccount")
    private String fundAccount;

    /**
     * 费率代码
     */
    @JSONField(name = "fareKindStr")
    private String fareKindStr;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getFareKindStr() {
        return fareKindStr;
    }

    public void setFareKindStr(String fareKindStr) {
        this.fareKindStr = fareKindStr;
    }
}
