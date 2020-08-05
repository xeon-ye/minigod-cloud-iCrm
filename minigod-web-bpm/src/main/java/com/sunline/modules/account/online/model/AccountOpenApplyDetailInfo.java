package com.sunline.modules.account.online.model;

import com.sunline.modules.account.online.entity.CustomerAccountMarginOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;

/**
 * @author LiYangFeng
 * @createDate 2018/3/20
 * @description
 * @email justbelyf@gmail.com
 */
public class AccountOpenApplyDetailInfo {
    /**
     * 正股开户申请
     */
    private CustomerAccountOpenApplyEntity customerAccountOpenApplyEntity;

    /**
     * 用户信息
     */
    private CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity;

    /**
     * 增开申请
     */
    private CustomerAccountMarginOpenApplyEntity customerAccountMarginOpenApplyEntity;
    
    public CustomerAccountOpenApplyEntity getCustomerAccountOpenApplyEntity() {
        return customerAccountOpenApplyEntity;
    }

    public void setCustomerAccountOpenApplyEntity(CustomerAccountOpenApplyEntity customerAccountOpenApplyEntity) {
        this.customerAccountOpenApplyEntity = customerAccountOpenApplyEntity;
    }

    public CustomerAccountOpenInfoEntity getCustomerAccountOpenInfoEntity() {
        return customerAccountOpenInfoEntity;
    }

    public void setCustomerAccountOpenInfoEntity(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity) {
        this.customerAccountOpenInfoEntity = customerAccountOpenInfoEntity;
    }

    public CustomerAccountMarginOpenApplyEntity getCustomerAccountMarginOpenApplyEntity() {
        return customerAccountMarginOpenApplyEntity;
    }

    public void setCustomerAccountMarginOpenApplyEntity(CustomerAccountMarginOpenApplyEntity customerAccountMarginOpenApplyEntity) {
        this.customerAccountMarginOpenApplyEntity = customerAccountMarginOpenApplyEntity;
    }
}
