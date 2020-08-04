package com.sunline.modules.account.online.model;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;

/**
 * @author LiYangFeng
 * @createDate 2018/3/20
 * @description
 * @email justbelyf@gmail.com
 */
public class AccountOpenApplyDetailInfo {
    private CustomerAccountOpenApplyEntity customerAccountOpenApplyEntity;
    private CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity;
    
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
}
