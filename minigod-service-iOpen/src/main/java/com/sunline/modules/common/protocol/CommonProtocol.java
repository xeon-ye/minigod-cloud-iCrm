package com.sunline.modules.common.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.sunline.modules.account.online.protocol.OtherAccountDetailInfo;
import com.sunline.modules.account.online.protocol.OwnerOfAccountDetail;

import java.util.List;

/**
 * @author LiYangFeng
 * @createDate 2017/8/3
 * @description 所有协议对象在此处定义
 * @email justbelyf@gmail.com
 */
public class CommonProtocol {
    /**
     * 文件的详细业务信息
     */
    public static class FileDetailBusinessInfo {
        // 文件的业务信息ID
        @JSONField(name = "fileBusinessInfoId")
        @JsonSerialize(using = ToStringSerializer.class)
        private Long fileBusinessInfoId;

        // 所有者类型[enum FileBusinessInfoOwnerType]
        @JSONField(name = "ownerType")
        private Integer ownerType;

        // 所有者ID
        @JSONField(name = "ownerId")
        private String ownerId;

        // 业务主类型[enum FileBusinessPrincipalType]
        @JSONField(name = "businessPrincipalType")
        private Integer businessPrincipalType;

        // 业务主类型的附属类型[enum FileBusinessSubordinateType]
        @JSONField(name = "businessSubordinateType")
        private Integer businessSubordinateType;

        // 文件ID
       @JSONField(name = "fileStorageId")
        private Long fileStorageId;

        // 文件类型[enum FileStorageType]
       @JSONField(name = "fileType")
        private Integer fileType;

        // 文件名称
        @JSONField(name = "fileName")
        private String fileName;

        // 文件扩展名
        @JSONField(name = "extendName")
        private String extendName;

        // 存储路径类型[enum FilePathType]
        @JSONField(name = "filePathType")
        private Integer filePathType;

        // 存储路径
        @JSONField(name = "filePath")
        private String filePath;

        // 文件描述信息
        @JSONField(name = "fileDiscription")
        private String fileDiscription;

        public Long getFileBusinessInfoId() {
            return fileBusinessInfoId;
        }

        public void setFileBusinessInfoId(Long fileBusinessInfoId) {
            this.fileBusinessInfoId = fileBusinessInfoId;
        }

        public Integer getOwnerType() {
            return ownerType;
        }

        public void setOwnerType(Integer ownerType) {
            this.ownerType = ownerType;
        }

        public String getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(String ownerId) {
            this.ownerId = ownerId;
        }

        public Integer getBusinessPrincipalType() {
            return businessPrincipalType;
        }

        public void setBusinessPrincipalType(Integer businessPrincipalType) {
            this.businessPrincipalType = businessPrincipalType;
        }

        public Integer getBusinessSubordinateType() {
            return businessSubordinateType;
        }

        public void setBusinessSubordinateType(Integer businessSubordinateType) {
            this.businessSubordinateType = businessSubordinateType;
        }

        public Long getFileStorageId() {
            return fileStorageId;
        }

        public void setFileStorageId(Long fileStorageId) {
            this.fileStorageId = fileStorageId;
        }

        public Integer getFileType() {
            return fileType;
        }

        public void setFileType(Integer fileType) {
            this.fileType = fileType;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getExtendName() {
            return extendName;
        }

        public void setExtendName(String extendName) {
            this.extendName = extendName;
        }

        public Integer getFilePathType() {
            return filePathType;
        }

        public void setFilePathType(Integer filePathType) {
            this.filePathType = filePathType;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getFileDiscription() {
            return fileDiscription;
        }

        public void setFileDiscription(String fileDiscription) {
            this.fileDiscription = fileDiscription;
        }
    }

    /**
     * 开户资料的信息
     */
    public static class OpenAccountDetailInfo {
        // 见证预约申请iD
        @JSONField(name = "witnessOpenAccountApplyId")
        private Long witnessOpenAccountApplyId;

        // 开户申请详细信息id
        @JSONField(name = "openAccountApplyDetailInfoId")
        private Long openAccountApplyDetailInfoId;

        // 客户中文名
        @JSONField(name = "clientName")
        private String clientName;

        // 中文名拼音
        @JSONField(name = "clientNameSpell")
        private String clientNameSpell;

        // 证件类型 [ 0=香港居民身份证 1=大陆居民身份证 2=护照 3=驾驶证 4=营业执照]
        @JSONField(name = "idKind")
        private Integer idKind;

        // 证件号码
        @JSONField(name = "idNo")
        private String idNo;

        // 性别[0=男 1=女 2=其它]
        @JSONField(name = "sex")
        private Integer sex;

        // 邮箱
        @JSONField(name = "email")
        private String email;

        // 身份证地址
        @JSONField(name = "idCardAddress")
        private String idCardAddress;

        // 联系地址的省份
        @JSONField(name = "contactProvinceName")

        private String contactProvinceName;
        // 联系地址的城市
        @JSONField(name = "contactCityName")

        private String contactCityName;
        // 联系地址的区域
        @JSONField(name = "contactCountyName")

        private String contactCountyName;
        // 联系地址的详细地址
        @JSONField(name = "contactDetailAddress")

        private String contactDetailAddress;


        // 手机号
        @JSONField(name = "phoneNumber")
        private String phoneNumber;

        // 生日
        @JSONField(name = "birthday")
        private String birthday;

        // 就业情况类型 [1=受雇 2=自营 3=退休 4=学生 5=其他 6 =务农 7=待业 8=自由职业者]
        @JSONField(name = "professionCode")
        private Integer professionCode;

        // 就业情况其它说明
        @JSONField(name = "otherProfession")
        private String otherProfession;

        // 公司名称
        @JSONField(name = "companyName")
        private String companyName;

        // 公司电话
        @JSONField(name = "companyPhoneNumber")
        private String companyPhoneNumber;

        // 职位
        @JSONField(name = "jobPosition")
        private String jobPosition;

        // 公司业务性质或行业类型
        @JSONField(name = "industryRange")
        private String industryRange;

        // 年收入范围类型  [1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]
        @JSONField(name = "income")
        private Integer income;

        // 净资产范围类型   [1=<50万 2=50万-250万 3=250万-500万 4=>500万]
        @JSONField(name = "netCapital")
        private Integer netCapital;

        // 投资目标类型 [1=股息收入 2=短期投资 3=长期投资 4=其他]
        @JSONField(name = "investTarget")
        private List<Integer> investTarget;

        // 投资目标其它类型说明
        @JSONField(name = "investTargetOther")
        private String investTargetOther;

        // 股票投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
        @JSONField(name = "stocksInvestmentExperienceType")
        private Integer stocksInvestmentExperienceType;

        // 认证股权投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
        @JSONField(name = "warrantsInvestmentExperienceType")
        private Integer warrantsInvestmentExperienceType;

        // 期货投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
        @JSONField(name = "futuresInvestmentExperienceType")
        private Integer futuresInvestmentExperienceType;

        // 是否了解衍生产品 [0=否 1=是]
        @JSONField(name = "isKnowDerivativeProducts")
        private Integer isKnowDerivativeProducts;

        // 衍生产品学习途径 [0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它]
        @JSONField(name = "derivativeProductsStudyType")
        private Integer derivativeProductsStudyType;

        // 衍生产品其他学习途径
        @JSONField(name = "derivativeProductsStudyTypeOther")
        private String derivativeProductsStudyTypeOther;

        // 在金融机构工作经验类型 [0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它]
        @JSONField(name = "financingInstitutionWorkExperienceType")
        private Integer financingInstitutionWorkExperienceType;

        //  在金融机构其它工作经验类型
        @JSONField(name = "financingInstitutionWorkExperienceTypeOther")
        private String financingInstitutionWorkExperienceTypeOther;

        // 是否在过去三年曾买卖过至少五次任何衍生产品的交易 [0=否 1=是]
        @JSONField(name = "isTradedDerivativeProducts")
        private Integer isTradedDerivativeProducts;

        // 账户受益人类型[0=自己 1=其他]
        @JSONField(name = "ownerOfAccountType")
        private Integer ownerOfAccountType;

        // 账户其他受益人详细信息，json[{ownName:xxx, ownAddress:xxx},{ownName:xxx, ownAddress:xxx}]
        @JSONField(name = "ownerOfAccountsDetail")
        private List<OwnerOfAccountDetail> ownerOfAccountsDetail;

        // 是否证券及期货事务监察委员会之注册公司雇员或注册人 [0=否 1=是]
        @JSONField(name = "isSfcEmployee")
        private Integer isSfcEmployee;

        // 注册人名称
        @JSONField(name = "registeredPersonName")
        private String registeredPersonName;

        // 是否与智珠集团之任何董事、职员或代表有亲属关系 [0=否 1=是]
        @JSONField(name = "isClerkRelation")
        private Integer isClerkRelation;

        // 董事、职员或代表的亲属关系信息
        @JSONField(name = "clerkRelationInfo")
        private String clerkRelationInfo;

        // 关联关系的人员姓名
        @JSONField(name = "relatedClerkName")
        private String relatedClerkName;

        // 是否有其他股票行或银行的股票户口资料[0=否 1=是]
        @JSONField(name = "hasOtherAccount")
        private Integer hasOtherAccount;

        // 其它账号详细信息,json[{bankName:xxx, accountNumber:xxx},{bankName:xxx, accountNumber:xxx}]
        @JSONField(name = "otherAccountsDetailInfo")
        private List<OtherAccountDetailInfo> otherAccountsDetailInfo;

        // 是否美国绿卡持有人[0=否 1=是]
        @JSONField(name = "isAmericanGreenCardHolder")
        private Integer isAmericanGreenCardHolder;

        public Long getWitnessOpenAccountApplyId() {
            return witnessOpenAccountApplyId;
        }

        public void setWitnessOpenAccountApplyId(Long witnessOpenAccountApplyId) {
            this.witnessOpenAccountApplyId = witnessOpenAccountApplyId;
        }

        public Long getOpenAccountApplyDetailInfoId() {
            return openAccountApplyDetailInfoId;
        }

        public void setOpenAccountApplyDetailInfoId(Long openAccountApplyDetailInfoId) {
            this.openAccountApplyDetailInfoId = openAccountApplyDetailInfoId;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getClientNameSpell() {
            return clientNameSpell;
        }

        public void setClientNameSpell(String clientNameSpell) {
            this.clientNameSpell = clientNameSpell;
        }

        public Integer getIdKind() {
            return idKind;
        }

        public void setIdKind(Integer idKind) {
            this.idKind = idKind;
        }

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getIdCardAddress() {
            return idCardAddress;
        }

        public void setIdCardAddress(String idCardAddress) {
            this.idCardAddress = idCardAddress;
        }

        public String getContactProvinceName() {
            return contactProvinceName;
        }

        public void setContactProvinceName(String contactProvinceName) {
            this.contactProvinceName = contactProvinceName;
        }

        public String getContactCityName() {
            return contactCityName;
        }

        public void setContactCityName(String contactCityName) {
            this.contactCityName = contactCityName;
        }

        public String getContactCountyName() {
            return contactCountyName;
        }

        public void setContactCountyName(String contactCountyName) {
            this.contactCountyName = contactCountyName;
        }

        public String getContactDetailAddress() {
            return contactDetailAddress;
        }

        public void setContactDetailAddress(String contactDetailAddress) {
            this.contactDetailAddress = contactDetailAddress;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Integer getProfessionCode() {
            return professionCode;
        }

        public void setProfessionCode(Integer professionCode) {
            this.professionCode = professionCode;
        }

        public String getOtherProfession() {
            return otherProfession;
        }

        public void setOtherProfession(String otherProfession) {
            this.otherProfession = otherProfession;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyPhoneNumber() {
            return companyPhoneNumber;
        }

        public void setCompanyPhoneNumber(String companyPhoneNumber) {
            this.companyPhoneNumber = companyPhoneNumber;
        }

        public String getJobPosition() {
            return jobPosition;
        }

        public void setJobPosition(String jobPosition) {
            this.jobPosition = jobPosition;
        }

        public String getIndustryRange() {
            return industryRange;
        }

        public void setIndustryRange(String industryRange) {
            this.industryRange = industryRange;
        }

        public Integer getIncome() {
            return income;
        }

        public void setIncome(Integer income) {
            this.income = income;
        }

        public Integer getNetCapital() {
            return netCapital;
        }

        public void setNetCapital(Integer netCapital) {
            this.netCapital = netCapital;
        }

        public List<Integer> getInvestTarget() {
            return investTarget;
        }

        public void setInvestTarget(List<Integer> investTarget) {
            this.investTarget = investTarget;
        }

        public String getInvestTargetOther() {
            return investTargetOther;
        }

        public void setInvestTargetOther(String investTargetOther) {
            this.investTargetOther = investTargetOther;
        }

        public Integer getStocksInvestmentExperienceType() {
            return stocksInvestmentExperienceType;
        }

        public void setStocksInvestmentExperienceType(Integer stocksInvestmentExperienceType) {
            this.stocksInvestmentExperienceType = stocksInvestmentExperienceType;
        }

        public Integer getWarrantsInvestmentExperienceType() {
            return warrantsInvestmentExperienceType;
        }

        public void setWarrantsInvestmentExperienceType(Integer warrantsInvestmentExperienceType) {
            this.warrantsInvestmentExperienceType = warrantsInvestmentExperienceType;
        }

        public Integer getFuturesInvestmentExperienceType() {
            return futuresInvestmentExperienceType;
        }

        public void setFuturesInvestmentExperienceType(Integer futuresInvestmentExperienceType) {
            this.futuresInvestmentExperienceType = futuresInvestmentExperienceType;
        }

        public Integer getIsKnowDerivativeProducts() {
            return isKnowDerivativeProducts;
        }

        public void setIsKnowDerivativeProducts(Integer isKnowDerivativeProducts) {
            this.isKnowDerivativeProducts = isKnowDerivativeProducts;
        }

        public Integer getDerivativeProductsStudyType() {
            return derivativeProductsStudyType;
        }

        public void setDerivativeProductsStudyType(Integer derivativeProductsStudyType) {
            this.derivativeProductsStudyType = derivativeProductsStudyType;
        }

        public String getDerivativeProductsStudyTypeOther() {
            return derivativeProductsStudyTypeOther;
        }

        public void setDerivativeProductsStudyTypeOther(String derivativeProductsStudyTypeOther) {
            this.derivativeProductsStudyTypeOther = derivativeProductsStudyTypeOther;
        }

        public Integer getFinancingInstitutionWorkExperienceType() {
            return financingInstitutionWorkExperienceType;
        }

        public void setFinancingInstitutionWorkExperienceType(Integer financingInstitutionWorkExperienceType) {
            this.financingInstitutionWorkExperienceType = financingInstitutionWorkExperienceType;
        }

        public String getFinancingInstitutionWorkExperienceTypeOther() {
            return financingInstitutionWorkExperienceTypeOther;
        }

        public void setFinancingInstitutionWorkExperienceTypeOther(String financingInstitutionWorkExperienceTypeOther) {
            this.financingInstitutionWorkExperienceTypeOther = financingInstitutionWorkExperienceTypeOther;
        }

        public Integer getIsTradedDerivativeProducts() {
            return isTradedDerivativeProducts;
        }

        public void setIsTradedDerivativeProducts(Integer isTradedDerivativeProducts) {
            this.isTradedDerivativeProducts = isTradedDerivativeProducts;
        }

        public Integer getOwnerOfAccountType() {
            return ownerOfAccountType;
        }

        public void setOwnerOfAccountType(Integer ownerOfAccountType) {
            this.ownerOfAccountType = ownerOfAccountType;
        }

        public List<OwnerOfAccountDetail> getOwnerOfAccountsDetail() {
            return ownerOfAccountsDetail;
        }

        public void setOwnerOfAccountsDetail(List<OwnerOfAccountDetail> ownerOfAccountsDetail) {
            this.ownerOfAccountsDetail = ownerOfAccountsDetail;
        }

        public Integer getIsSfcEmployee() {
            return isSfcEmployee;
        }

        public void setIsSfcEmployee(Integer isSfcEmployee) {
            this.isSfcEmployee = isSfcEmployee;
        }

        public String getRegisteredPersonName() {
            return registeredPersonName;
        }

        public void setRegisteredPersonName(String registeredPersonName) {
            this.registeredPersonName = registeredPersonName;
        }

        public Integer getIsClerkRelation() {
            return isClerkRelation;
        }

        public void setIsClerkRelation(Integer isClerkRelation) {
            this.isClerkRelation = isClerkRelation;
        }

        public String getClerkRelationInfo() {
            return clerkRelationInfo;
        }

        public void setClerkRelationInfo(String clerkRelationInfo) {
            this.clerkRelationInfo = clerkRelationInfo;
        }

        public Integer getHasOtherAccount() {
            return hasOtherAccount;
        }

        public void setHasOtherAccount(Integer hasOtherAccount) {
            this.hasOtherAccount = hasOtherAccount;
        }

        public List<OtherAccountDetailInfo> getOtherAccountsDetailInfo() {
            return otherAccountsDetailInfo;
        }

        public void setOtherAccountsDetailInfo(List<OtherAccountDetailInfo> otherAccountsDetailInfo) {
            this.otherAccountsDetailInfo = otherAccountsDetailInfo;
        }

        public Integer getIsAmericanGreenCardHolder() {
            return isAmericanGreenCardHolder;
        }

        public void setIsAmericanGreenCardHolder(Integer isAmericanGreenCardHolder) {
            this.isAmericanGreenCardHolder = isAmericanGreenCardHolder;
        }

        public String getRelatedClerkName() {
            return relatedClerkName;
        }

        public void setRelatedClerkName(String relatedClerkName) {
            this.relatedClerkName = relatedClerkName;
        }
    }
}
