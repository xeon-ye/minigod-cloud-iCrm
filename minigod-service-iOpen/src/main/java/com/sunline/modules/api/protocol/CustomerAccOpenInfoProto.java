package com.sunline.modules.api.protocol;

import com.sunline.modules.common.pojo.rest.BaseParameter;

/**
 * @description: 获取客户开户资料请求协议
 * @author: Larry Lai
 * @date: 2019/1/2 13:26
 * @version: v1.0
 */

public class CustomerAccOpenInfoProto {

    public static class CustomerAccOpenInfoRequest extends BaseParameter {

        private static final long serialVersionUID = 6594451181087747085L;

        private String applicationId;

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }
    }

    public static class CustomerAccOpenInfoResponse {

        private static final long serialVersionUID = 3127989345835914964L;

        // 姓名
        private String userName;
        // 身份证号码
        private String idNo;
        // 性别
        private String sex;
        // 手机号
        private String mobileNo;
        // 身份证上省份
        private String province;
        // 身份证上城市
        private String city;
        // 身份证上联系地址
        private String contactAddr;
        // 身份证签发机关
        private String cardedPlace;
        // 身份证有效期
        private String cardedExpiryDate;
        // 银行卡号
        private String card;
        // 生日
        private String birthday;
        // 民族
        private String folk;
        // 身份证上地址（包括省、市、详细地址）
        private String wholeAddr;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getContactAddr() {
            return contactAddr;
        }

        public void setContactAddr(String contactAddr) {
            this.contactAddr = contactAddr;
        }

        public String getCardedPlace() {
            return cardedPlace;
        }

        public void setCardedPlace(String cardedPlace) {
            this.cardedPlace = cardedPlace;
        }

        public String getCardedExpiryDate() {
            return cardedExpiryDate;
        }

        public void setCardedExpiryDate(String cardedExpiryDate) {
            this.cardedExpiryDate = cardedExpiryDate;
        }

        public String getCard() {
            return card;
        }

        public void setCard(String card) {
            this.card = card;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getFolk() {
            return folk;
        }

        public void setFolk(String folk) {
            this.folk = folk;
        }

        public String getWholeAddr() {
            return wholeAddr;
        }

        public void setWholeAddr(String wholeAddr) {
            this.wholeAddr = wholeAddr;
        }
    }
}
