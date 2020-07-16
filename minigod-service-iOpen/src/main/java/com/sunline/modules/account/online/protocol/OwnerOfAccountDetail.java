package com.sunline.modules.account.online.protocol;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/2/13
 * @description
 * @email justbelyf@gmail.com
 */

public class OwnerOfAccountDetail {

    @JSONField(name ="ownName")
    private String ownName;

    @JSONField(name ="ownAddress")
    private String ownAddress;

    public String getOwnName() {
        return ownName;
    }

    public void setOwnName(String ownName) {
        this.ownName = ownName;
    }

    public String getOwnAddress() {
        return ownAddress;
    }

    public void setOwnAddress(String ownAddress) {
        this.ownAddress = ownAddress;
    }

    @Override
    public String toString() {
        return "OwnerOfAccountDetail{" +
                "ownName='" + ownName + '\'' +
                ", ownAddress='" + ownAddress + '\'' +
                '}';
    }
}
