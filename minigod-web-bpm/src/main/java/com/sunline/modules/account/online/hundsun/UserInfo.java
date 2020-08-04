package com.sunline.modules.account.online.hundsun;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/18
 * @description
 * @email justbelyf@gmail.com
 */
public final class UserInfo {
    private UserInfo(){}

    /**
     * 建立经纪人关系
     */
    public static final class BrokerRelationCreateRequest{
        // 客户编号 		必填
        @JSONField(name = "client_id")
        private String clientID;
        // 资金帐号 		必填
        @JSONField(name = "fund_account")
        private Integer fundAccount;
        // 经纪人帐号		必填
        @JSONField(name = "broker_account")
        private String brokerAccount;

        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public Integer getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(Integer fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getBrokerAccount() {
            return brokerAccount;
        }

        public void setBrokerAccount(String brokerAccount) {
            this.brokerAccount = brokerAccount;
        }
    }

    public static final class BrokerRelationCreateResponse{

    }

    /**
     * 用户交易费用设置
     */
    public static final class TradeFareSettingRequest{
        // 客户编号     		必填
        @JSONField(name = "client_id")
        private String clientID;
        // 资金帐号     		必填
        @JSONField(name = "fund_account")
        private Integer fundAccount;
        // 交易费用串（4位）[610003]		必填
        @JSONField(name = "fare_kind_str")
        private String fareKindStr;

        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public Integer getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(Integer fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getFareKindStr() {
            return fareKindStr;
        }

        public void setFareKindStr(String fareKindStr) {
            this.fareKindStr = fareKindStr;
        }
    }

    public static final class TradeFareSettingResponse{

    }

    /**
     * 通讯地址管理
     */
    public static final class AddressOperateRequest{
        //	地址编号		必填
        @JSONField(name = "address_id")
        private String addressID;

        //	地址名称		必填
        @JSONField(name = "short_name")
        private String shortName;

        //	本地名称中文名
        @JSONField(name = "locale_name")
        private String localeName;

        //	收件人		必填
        @JSONField(name = "addressee")
        private String addressee;

        //	收件人本地名称
        @JSONField(name = "locale_addressee")
        private String localeAddressee;

        //	城市
        @JSONField(name = "city")
        private String city;

        //	地址1
        @JSONField(name = "address1")
        private String address1;

        //	地址2
        @JSONField(name = "address2")
        private String address2;

        //	地址3
        @JSONField(name = "address3")
        private String address3;

        //	地址4
        @JSONField(name = "address4")
        private String address4;

        //	本地地址1
        @JSONField(name = "locale_address1")
        private String localeAddress1;

        //	本地地址2
        @JSONField(name = "locale_address2")
        private String localeAddress2;

        //	本地地址3
        @JSONField(name = "locale_address3")
        private String localeAddress3;

        //	本地地址4
        @JSONField(name = "locale_address4")
        private String localeAddress4;

        //	联系电话
        @JSONField(name = "phone")
        private String phone;

        //	传真号码
        @JSONField(name = "fax")
        private String fax;

        //	电子邮箱		必填
        @JSONField(name = "e_mail")
        private String email;

        //	备注
        @JSONField(name = "Remark")
        private String remark;

        //	移动电话
        @JSONField(name = "mobile")
        private String mobile;

        //	输入字符（0：新增 1：修改 2：删除）		必填
        @JSONField(name = "action_in")
        private Integer actionIn;

        //	客户编号		必填
        @JSONField(name = "client_id")
        private String clientID;

        public String getAddressID() {
            return addressID;
        }

        public void setAddressID(String addressID) {
            this.addressID = addressID;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getLocaleName() {
            return localeName;
        }

        public void setLocaleName(String localeName) {
            this.localeName = localeName;
        }

        public String getAddressee() {
            return addressee;
        }

        public void setAddressee(String addressee) {
            this.addressee = addressee;
        }

        public String getLocaleAddressee() {
            return localeAddressee;
        }

        public void setLocaleAddressee(String localeAddressee) {
            this.localeAddressee = localeAddressee;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getAddress3() {
            return address3;
        }

        public void setAddress3(String address3) {
            this.address3 = address3;
        }

        public String getAddress4() {
            return address4;
        }

        public void setAddress4(String address4) {
            this.address4 = address4;
        }

        public String getLocaleAddress1() {
            return localeAddress1;
        }

        public void setLocaleAddress1(String localeAddress1) {
            this.localeAddress1 = localeAddress1;
        }

        public String getLocaleAddress2() {
            return localeAddress2;
        }

        public void setLocaleAddress2(String localeAddress2) {
            this.localeAddress2 = localeAddress2;
        }

        public String getLocaleAddress3() {
            return localeAddress3;
        }

        public void setLocaleAddress3(String localeAddress3) {
            this.localeAddress3 = localeAddress3;
        }

        public String getLocaleAddress4() {
            return localeAddress4;
        }

        public void setLocaleAddress4(String localeAddress4) {
            this.localeAddress4 = localeAddress4;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Integer getActionIn() {
            return actionIn;
        }

        public void setActionIn(Integer actionIn) {
            this.actionIn = actionIn;
        }

        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }
    }

    public static final class AddressOperateResponse{

    }

    /**
     * 账户通讯信息管理
     */
    public static final class CommunicationInfoOperateRequest{
        // 客户编号		必填
        @JSONField(name = "client_id")
        private String clientID;
        // 资金帐号		必填
        @JSONField(name = "fund_account")
        private Integer fundAccount;
        // 确认函类型（字典项编号：610053[],2：日结单3：月结单）		必填 2
        @JSONField(name = "notification_type")
        private String notificationType;
        // 地址代码（10132接口设置的地址编号）		必填
        @JSONField(name = "address_id")
        private String addressID;
        // 发送方式（字典项编号：610054[E=Email,F=Fax,H=By Hand,M=Mail,S=SMS]		必填 E
//        @JSONField(name = "distribution_media")
//        private String distributionMedia;
        // 确认方式（字典项编号：610055[...4=日结中文版，5=日结英文版，6=月结中文版，7=月结英文版])		必填 4
        @JSONField(name = "notification_format")
        private String notificationFormat;
        // 输入字符（0：新增 1：修改 2：删除）		必填
        @JSONField(name = "action_in")
        private Integer actionIn;

        public String getClientID() {
            return clientID;
        }

        public void setClientID(String clientID) {
            this.clientID = clientID;
        }

        public Integer getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(Integer fundAccount) {
            this.fundAccount = fundAccount;
        }

        public String getNotificationType() {
            return notificationType;
        }

        public void setNotificationType(String notificationType) {
            this.notificationType = notificationType;
        }

        public String getAddressID() {
            return addressID;
        }

        public void setAddressID(String addressID) {
            this.addressID = addressID;
        }

        public String getNotificationFormat() {
            return notificationFormat;
        }

        public void setNotificationFormat(String notificationFormat) {
            this.notificationFormat = notificationFormat;
        }

        public Integer getActionIn() {
            return actionIn;
        }

        public void setActionIn(Integer actionIn) {
            this.actionIn = actionIn;
        }
    }

    public static final class CommunicationInfoOperateResponse{

    }
}
