package com.minigod.api.securitiesUser;

import java.io.Serializable;

/**
 * @author LiYangFeng
 * @createDate 2017/10/11
 * @description
 * @email justbelyf@gmail.com
 */
public class SecuritiesUserModel {
    SecuritiesUserModel(){}

    public static class SecuritiesUserFullInfo implements Serializable {
        // gid
        private Integer gid;

        // 开户类型[1=互联网、2=见证宝 3=BPM]
        private Integer openAccountType;

        // 客户号（犇犇号）
        private Integer userId;

        // 客户中文名
        private String clientName;

        // 姓氏
        private String familyName;

        // 名字
        private String givenName;

        // 中文名拼音
        private String clientNameSpell;

        // 证件类型 [0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
        private Integer idKind;

        // 证件号码
        private String idNo;

        // 身份证地址
        private String idCardAddress;

        // 生日
        private String birthday;

        // 性别[0=男 1=女 2=其它]
        private Integer sex;

        // 银行编号
        private Integer bankId;

        // 银行卡号
        private String bankNo;

        // 国籍',
        private String nationality;

        // 是否美国绿卡持有人[0=否 1=是]
        private Integer isAmericanGreenCardHolder;

        // 联系地址的省份
        private String contactProvinceName;

        // 联系地址的城市
        private String contactCityName;

        // 联系地址的区域
        private String contactCountyName;

        // 联系地址的详细地址
        private String contactDetailAddress;

        // 电子邮箱
        private String email;

        // 手机号
        private String phoneNumber;

        // 就业情况类型 [1=受雇 2=自营 3=退休 4=学生 5=其他 6 =务农 7=待业 8=自由职业者]
        private Integer professionCode;

        // 就业情况其它说明
        private String otherProfession;

        // 公司名称
        private String companyName;

        // 公司电话
        private String companyPhoneNumber;

        // 职位
        private String jobPosition;

        // 公司业务性质或行业类型
        private String industryRange;

        // 年收入范围类型  [1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]
        private Integer income;

        // 净资产范围类型   [1=<50万 2=50万-250万 3=250万-500万 4=>500万]
        private Integer netCapital;

        // 投资目标类型 [1=股息收入 2=短期投资 3=长期投资 4=其他]
        private String investTarget;

        // 投资目标其它类型说明
        private String investTargetOther;

        // 股票投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
        private Integer stocksInvestmentExperienceType;

        // 认证股权投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
        private Integer warrantsInvestmentExperienceType;

        // 期货投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
        private Integer futuresInvestmentExperienceType;

        // 是否了解衍生产品 [0=否 1=是]
        private Integer isKnowDerivativeProducts;

        // 衍生产品学习途径 [0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它]
        private Integer derivativeProductsStudyType;

        // 衍生产品其他学习途径
        private String derivativeProductsStudyTypeOther;

        // 在金融机构工作经验类型 [0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它]
        private Integer financingInstitutionWorkExperienceType;

        // 在金融机构其它工作经验类型
        private String financingInstitutionWorkExperienceTypeOther;

        // 是否在过去三年曾买卖过至少五次任何衍生产品的交易 [0=否 1=是]
        private Integer isTradedDerivativeProducts;

        // 账户受益人类型[0=自己 1=其他]
        private Integer ownerOfAccountType;

        // 账户其他受益人详细信息，json[{ownName:xxx, ownAddress:xxx},{ownName:xxx, ownAddress:xxx}]
        private String ownerOfAccountsDetail;

        // 是否证券及期货事务监察委员会之注册公司雇员或注册人 [0=否 1=是]
        private Integer isSfcEmployee;

        // 注册人名称
        private String registeredPersonName;

        // 是否与玖富集团之任何董事、职员或代表有亲属关系 [0=否 1=是]
        private Integer isClerkRelation;

        // 董事、职员或代表的亲属关系信息
        private String clerkRelationInfo;

        // 关联关系的人员姓名
        private String relatedClerkName;

        // 是否有其他股票行或银行的股票户口资料[0=否 1=是]
        private Integer hasOtherAccount;

        // 其它账号详细信息,json[{bankName:xxx, accountNumber:xxx},{bankName:xxx, accountNumber:xxx}]
        private String otherAccountsDetailInfo;

        // 开户邀请人的userId
        private String inviterId;

        // 开户客户来源渠道ID[dataRef t_crm_channel]
        private String sourceChannelId;

        // 开户客户来源渠道名称[dataRef t_crm_channel]
        private String sourceChannelName;

        // 是否开通美股市场[0=否 1=是]
        private Integer isOpenUsaStockMarket;

        // 是否开通港股市场[0=否 1=是]
        private Integer isOpenHkStockMarket;

        // 是否允许衍生品交易[0=否 1=是]
        private Integer isAllowDerivativesTransaction;

        // 交易账号
        private String tradeAccount;

        // 资金账号
        private String fundAccount;

        // 记录状态[enums CommonRecordStatus]
        private Integer recordStatus;

        // 创建时间
        private Long createTime;

        // 更新时间
        private Long updateTime;

        // 开户时间
        private Long openAccountTime;

        public Integer getGid() {
            return gid;
        }

        public void setGid(Integer gid) {
            this.gid = gid;
        }

        public Integer getOpenAccountType() {
            return openAccountType;
        }

        public void setOpenAccountType(Integer openAccountType) {
            this.openAccountType = openAccountType;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public void setFamilyName(String familyName) {
            this.familyName = familyName;
        }

        public String getGivenName() {
            return givenName;
        }

        public void setGivenName(String givenName) {
            this.givenName = givenName;
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

        public String getIdCardAddress() {
            return idCardAddress;
        }

        public void setIdCardAddress(String idCardAddress) {
            this.idCardAddress = idCardAddress;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public Integer getBankId() {
            return bankId;
        }

        public void setBankId(Integer bankId) {
            this.bankId = bankId;
        }

        public String getBankNo() {
            return bankNo;
        }

        public void setBankNo(String bankNo) {
            this.bankNo = bankNo;
        }

        public String getNationality() {
            return nationality;
        }

        public void setNationality(String nationality) {
            this.nationality = nationality;
        }

        public Integer getIsAmericanGreenCardHolder() {
            return isAmericanGreenCardHolder;
        }

        public void setIsAmericanGreenCardHolder(Integer isAmericanGreenCardHolder) {
            this.isAmericanGreenCardHolder = isAmericanGreenCardHolder;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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

        public String getInvestTarget() {
            return investTarget;
        }

        public void setInvestTarget(String investTarget) {
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

        public String getOwnerOfAccountsDetail() {
            return ownerOfAccountsDetail;
        }

        public void setOwnerOfAccountsDetail(String ownerOfAccountsDetail) {
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

        public String getOtherAccountsDetailInfo() {
            return otherAccountsDetailInfo;
        }

        public void setOtherAccountsDetailInfo(String otherAccountsDetailInfo) {
            this.otherAccountsDetailInfo = otherAccountsDetailInfo;
        }

        public String getInviterId() {
            return inviterId;
        }

        public void setInviterId(String inviterId) {
            this.inviterId = inviterId;
        }

        public String getSourceChannelId() {
            return sourceChannelId;
        }

        public void setSourceChannelId(String sourceChannelId) {
            this.sourceChannelId = sourceChannelId;
        }

        public String getSourceChannelName() {
            return sourceChannelName;
        }

        public void setSourceChannelName(String sourceChannelName) {
            this.sourceChannelName = sourceChannelName;
        }

        public Integer getIsOpenUsaStockMarket() {
            return isOpenUsaStockMarket;
        }

        public void setIsOpenUsaStockMarket(Integer isOpenUsaStockMarket) {
            this.isOpenUsaStockMarket = isOpenUsaStockMarket;
        }

        public Integer getIsOpenHkStockMarket() {
            return isOpenHkStockMarket;
        }

        public void setIsOpenHkStockMarket(Integer isOpenHkStockMarket) {
            this.isOpenHkStockMarket = isOpenHkStockMarket;
        }

        public Integer getIsAllowDerivativesTransaction() {
            return isAllowDerivativesTransaction;
        }

        public void setIsAllowDerivativesTransaction(Integer isAllowDerivativesTransaction) {
            this.isAllowDerivativesTransaction = isAllowDerivativesTransaction;
        }

        public String getTradeAccount() {
            return tradeAccount;
        }

        public void setTradeAccount(String tradeAccount) {
            this.tradeAccount = tradeAccount;
        }

        public String getFundAccount() {
            return fundAccount;
        }

        public void setFundAccount(String fundAccount) {
            this.fundAccount = fundAccount;
        }

        public Integer getRecordStatus() {
            return recordStatus;
        }

        public void setRecordStatus(Integer recordStatus) {
            this.recordStatus = recordStatus;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }

        public String getRelatedClerkName() {
            return relatedClerkName;
        }

        public void setRelatedClerkName(String relatedClerkName) {
            this.relatedClerkName = relatedClerkName;
        }

        public Long getOpenAccountTime() {
            return openAccountTime;
        }

        public void setOpenAccountTime(Long openAccountTime) {
            this.openAccountTime = openAccountTime;
        }
    }

    }
