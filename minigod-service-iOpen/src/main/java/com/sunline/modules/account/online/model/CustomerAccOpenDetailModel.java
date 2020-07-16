package com.sunline.modules.account.online.model;

/**
 * @author LiYangFeng
 * @createDate 2018/3/20
 * @description
 * @email justbelyf@gmail.com
 */
public class CustomerAccOpenDetailModel {
    private CustomerAccOpenInfoModel customerAccountOpenInfoModel;
    private CustomerAccOpenApplyModel customerAccountOpenApplicationModel;

    public CustomerAccOpenInfoModel getCustomerAccountOpenInfoModel() {
        return customerAccountOpenInfoModel;
    }

    public void setCustomerAccountOpenInfoModel(CustomerAccOpenInfoModel customerAccountOpenInfoModel) {
        this.customerAccountOpenInfoModel = customerAccountOpenInfoModel;
    }

    public CustomerAccOpenApplyModel getCustomerAccountOpenApplicationModel() {
        return customerAccountOpenApplicationModel;
    }

    public void setCustomerAccountOpenApplicationModel(CustomerAccOpenApplyModel customerAccountOpenApplicationModel) {
        this.customerAccountOpenApplicationModel = customerAccountOpenApplicationModel;
    }
}
