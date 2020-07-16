package com.sunline.modules.account.online.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/2/13
 * @description
 * @email justbelyf@gmail.com
 */

public class OtherAccountDetailInfo {

    @JSONField(name ="bankName")
    private String bankName;

    @JSONField(name ="accountNumber")
    private String accountNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "OtherAccountDetailInfo{" +
                "bankName='" + bankName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
