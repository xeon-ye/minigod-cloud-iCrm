package com.sunline.modules.account.online.hundsun;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/3/18
 * @description 服务_海外_客户开户
 * @email justbelyf@gmail.com
 */
public final class UserAccount {
    private UserAccount() {
    }

    /**
     * 用户开户
     */
    public static final class UserAccountCreateRequest {
        // 复核类型（传1）		必须传1
//        @JSONField(name = "audit_action")
//        private String auditAction;
        // 客户姓名		必填
        @JSONField(name = "client_name")
        private String clientName;
        // 客户性别（对应字典项编号：1049[0=男,1=女,2=其他]		必填
        @JSONField(name = "client_sex")
        private String clientSex;
        // 国籍地区（对应字典项编号：1040[0=中国大陆,1=美国,2=中国香港]		必填
        @JSONField(name = "nationality")
        private String nationality;
        // 身份类别（对应字典项编号：1041[0=香港身份证,1=中国身份证，2=护照，3=公司注册证，4=营业执照]		必填
        @JSONField(name = "id_kind")
        private String idKind;
        // 证件号码		必填
        @JSONField(name = "id_no")
        private String idNo;
        // 客户类型（对应字典项编号：1048[0=个人，1=团体，3=职员，4=公共机构，5=家庭]		必填
//        @JSONField(name = "organ_flag")
//        private String organFlag;
        // 资金帐号状态	0[0=正常，1=挂起，3=取消，D=休眠]	必填
//        @JSONField(name = "holder_status_temp")
//        private String holderStatusTemp;
        // 对账单寄送选择 1. 不寄送2..按月3. 按季4.半年5.一年		必填
//        @JSONField(name = "statement_flag")
//        private String statementFlag;
        // 资产属性（对应字典项编号：3002[0=现金账户，M=Margin账户]		必填
//        @JSONField(name = "asset_prop")
//        private String assetProp;
        // 境外标志（对应字典项编号：1088[0=国内，1=国外] 默认为0）		必填
//        @JSONField(name = "foreign_flag")
//        private String foreignFlag;
        // 风险级别（对应字典项编号：1053[1=高，2=中，3=低]		必填
        @JSONField(name = "risk_level")
        private Integer riskLevel;

        // 身份证地址
        @JSONField(name = "id_address")
        private String idAddress;

        // 出生日期
        @JSONField(name = "birthday")
        private Integer birthday;

        // 本地客户名
        @JSONField(name = "locale_name")
        private String localeName;

        // 客户编号
        @JSONField(name = "client_id")
        private String clientId;

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getLocaleName() {
            return localeName;
        }

        public void setLocaleName(String localeName) {
            this.localeName = localeName;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientSex() {
            return clientSex;
        }

        public void setClientSex(String clientSex) {
            this.clientSex = clientSex;
        }

        public String getIdKind() {
            return idKind;
        }

        public void setIdKind(String idKind) {
            this.idKind = idKind;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getIdAddress() {
            return idAddress;
        }

        public void setIdAddress(String idAddress) {
            this.idAddress = idAddress;
        }

        public Integer getBirthday() {
            return birthday;
        }

        public void setBirthday(Integer birthday) {
            this.birthday = birthday;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public Integer getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(Integer riskLevel) {
            this.riskLevel = riskLevel;
        }
    }


    public static final class UserAccountCreateResponse {

    }

    /**
     * 用户认证
     */
    public static final class UserAccountIdentifyRequest {
        // 复核类型（传1）		必须传1
//        @JSONField(name = "audit_action")
//        private String auditAction;
        // 用户类别（1 柜员2 经纪人3 客户）   		    必填
//        @JSONField(name = "user_type")
//        private String userType;
        // 用户编号                  		                必填
        @JSONField(name = "user_id")
        private String userID;
        // 客户：客户号 柜员：柜员号 经纪人：经纪人号		必填
        @JSONField(name = "user_account")
        private String userAccount;
        // 只读标志（0:可操作 1:只读）      	0	    必填
//        @JSONField(name = "read_flag")
//        private String readFlag;
        // 备注                    		                    必填
//        @JSONField(name = "remark")
//        private String remark;

        // 登录密码
        @JSONField(name = "password")
        private String password;

        // 查询密码
        @JSONField(name = "querypwd")
        private String queryPwd;

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(String userAccount) {
            this.userAccount = userAccount;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getQueryPwd() {
            return queryPwd;
        }

        public void setQueryPwd(String queryPwd) {
            this.queryPwd = queryPwd;
        }
    }

    public static final class UserAccountIdentifyResponse {

    }
}
