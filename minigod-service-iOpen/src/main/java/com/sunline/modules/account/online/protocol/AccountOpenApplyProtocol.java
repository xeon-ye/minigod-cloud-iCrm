package com.sunline.modules.account.online.protocol;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.sunline.modules.common.pojo.rest.BaseParameter;

import java.util.Date;
import java.util.List;


/**
 * 客户详细资料（由中台送过来，中台有一个定时调度任务）
 * @author LiYangFeng
 * @createDate 2017/2/8
 * @description 互联网开户申请协议
 * @email justbelyf@gmail.com
 */

public class AccountOpenApplyProtocol extends BaseParameter {

    private static final long serialVersionUID = 5643282110965780507L;

    //开户类型[0=未知 1=互联网 2=见证宝 3=BPM]
    private Integer openAccountType;

    // 开户接入方式[1=H5开户 2=APP开户]
    @JSONField(name = "openAccountAccessWay")
    private Integer openAccountAccessWay;

    //账户类型[1=现金账户 2=融资账户]
    @JSONField(name = "fundAccountType")
    private Integer fundAccountType;

    // 中文名
    @JSONField(name = "clientName")
    private String clientName;

    // 中文名拼音
    @JSONField(name = "clientNameSpell")
    private String clientNameSpell;

    // 中文名字
    @JSONField(name = "givenName")
    private String givenName;

    // 中文姓氏
    @JSONField(name = "familyName")
    private String familyName;

    // 英文名字
    @JSONField(name = "givenNameSpell")
    private String givenNameSpell;

    // 英文姓氏
    @JSONField(name = "familyNameSpell")
    private String familyNameSpell;

    // 性别[0=男 1=女 2=其它]
    @JSONField(name = "sex")
    private Integer sex;

    // 生日
    @JSONField(name = "birthday")
    private String birthday;

    //国籍
    @JSONField(name = "nationality")
    private String nationality;

    //其它国籍/地区名称
    @JSONField(name = "otherNationality")
    private String otherNationality;

    // 证件类型
    @JSONField(name = "idKind")
    private Integer idKind;

    // 证件号码
    @JSONField(name = "idNo")
    private String idNo;

    //证件地址
    @JSONField(name = "idCardAddress")
    private String idCardAddress;

    // 身份证生效日期
    @JSONField(name = "idCardValidDateStart")
    private String idCardValidDateStart;

    // 身份证失效日期
    @JSONField(name = "idCardValidDateEnd")
    private String idCardValidDateEnd;

    // 身份相似百分数
    @JSONField(name = "identitySimilarityPercent")
    private Double identitySimilarityPercent;

    //住宅住址
    @JSONField(name = "familyAddress")
    private String familyAddress;

    // 通讯地址
    @JSONField(name = "contactAddress")
    private String contactAddress;

    // 手机号
    @JSONField(name = "phoneNumber")
    private String phoneNumber;

    // 邮箱
    @JSONField(name = "email")
    private String email;

    //银行编号
    @JSONField(name = "bankId")
    private String bankId;
    //银行卡号
    @JSONField(name = "bankNo")
    private String bankNo;
    //银行账户名
    @JSONField(name = "bankAccountName")
    private String bankAccountName;

    // 就业情况类型 [1=受雇 2=自营/个体户 3=退休 4=学生 5=其他 6 =农林牧副渔 7=待业 8=自由职业者 9=投资者 10=家庭主妇]
    @JSONField(name = "professionCode")
    private Integer professionCode;

    //自由职业细化选项 [字典=AO_FREELANCE_CODE]
    @JSONField(name = "freelanceCode")
    private Integer freelanceCode;

    //自由职业细化其他说明
    @JSONField(name = "freelanceOther")
    private String freelanceOther;

    //所属行业[待定]
    @JSONField(name = "professionType")
    private Integer professionType;

    //公司业务性质或行业类型
//    @JSONField(name = "industryRange")
//    private String industryRange;

    // 公司名称
    @JSONField(name = "companyName")
    private String companyName;

    //公司地址
    @JSONField(name = "companyAddress")
    private String companyAddress;

    // 职位
    @JSONField(name = "jobPosition")
    private String jobPosition;

    //年收入范围类型[1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]
    @JSONField(name = "annualIncome")
    private Integer annualIncome;

    // 收入来源
    @JSONField(name = "capitalSource")
    private List<Integer> capitalSource;

    //财产种类
    @JSONField(name = "propertyType")
    private List<OpenAccountPropertyTypeProtocol> propertyType;

    // 投资目标类型 [NEW 1=股息收入 2=短期投资 3=长期投资 4=其他 5=保本 6-资本增值 7-投机 8-对冲]
    @JSONField(name = "investTarget")
    private List<Integer> investTarget;

    // 投资目标其它类型说明
    @JSONField(name = "investTargetOther")
    private String investTargetOther;

    // 股票投资经验类型 [0=未知 1=没有经验 2=少于一年 3=一至三年 4=三至五年 5=五年以上]
    @JSONField(name = "stocksInvestmentExperienceType")
    private Integer stocksInvestmentExperienceType;

    //风险承受程度（必须三选一=：[1=低风险 2=中风险 3=高风险]
    @JSONField(name = "acceptRisk")
    private Integer acceptRisk;

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

    //您是否确认个人资料（私隐=条例通知并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途[0=否 1=是]
    @JSONField(name = "isAllowProvidePrivacy")
    private Integer isAllowProvidePrivacy;

    //北向交易的资料收集声明（[0=否 1=是]=必须二选一，此选项会影响到后续的中华通交易权限，选择“否”的客户，无法进行中华通交易
    @JSONField(name = "northTrade")
    private Integer northTrade;

    //FATCA声明（[0=否 1=是]=必须二选一；编辑资料改成“是”时出现弹窗，保留继续“否”的选择
    @JSONField(name = "fatca")
    private Integer fatca;

    // 税务信息
    @JSONField(name = "taxationInfo")
    private List<OpenAccountTaxationInfoProtocol> taxationInfo;

    //其他信息披露
    @JSONField(name = "otherDisclosure")
    private List<OpenAccountOtherDisclosureProtocol> otherDisclosure;

    //四要素
    @JSONField(name = "bankVerityInfo")
    private List<OpenAccountBankVerityInfoProtocol> bankVerityInfo;

    //是否开通美股市场[0=否 1=是]
    @JSONField(name = "isOpenUsaStockMarket")
    private Integer isOpenUsaStockMarket;

    //是否开通港股市场[0=否 1=是]
    @JSONField(name = "isOpenHkStockMarket")
    private Integer isOpenHkStockMarket;

    // 用户来源渠道ID
    @JSONField(name = "sourceChannelId")
    private String sourceChannelId;

    // 开户邀请人的userId
    @JSONField(name = "inviterId")
    private String inviterId;

    // 客户小神号
    @JSONField(name = "userId")
    private Integer userId;

    // 是否通过身份验证[0=否 1=是]
    @JSONField(name = "isPassIdentityAuthentication")
    private Integer isPassIdentityAuthentication;

    // 图片信息
    @JSONField(name = "openAccountImagesInfo")
    private List<OpenAccountImageInfo> openAccountImagesInfo;

    // 最后更新时间
    @JSONField(name = "lastUpdateTime")
    private Date lastUpdateTime;

    //公司电话
    @JSONField(name = "companyPhoneNumber")
    private String companyPhoneNumber;

    // 银行账户类型
    @JSONField(name = "bankType")
    private Integer bankType;

    //开户提交时间
    @JSONField(name = "isAmlSuspicious")
    private String isAmlSuspicious;

    //开户提交时间
    @JSONField(name = "applicationTime")
    private Date applicationTime;

    //其他银行名称
    @JSONField(name = "otherBankName")
    private String otherBankName;

    // 联系地址的国家
    @JSONField(name = "contactRepublicName")
    private String contactRepublicName;

    // 联系地址的国家(其它填写内容)
    @JSONField(name = "otherContactRepublic")
    private String otherContactRepublic;

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

    // 公司地址的国家
    @JSONField(name = "companyRepublicName")
    private String companyRepublicName;

    // 公司地址的国家(其它填写内容)
    @JSONField(name = "otherCompanyRepublic")
    private String otherCompanyRepublic;

    // 公司地址的省份
    @JSONField(name = "companyProvinceName")
    private String companyProvinceName;

    // 公司地址的城市
    @JSONField(name = "companyCityName")
    private String companyCityName;

    // 公司地址的区域
    @JSONField(name = "companyCountyName")
    private String companyCountyName;

    // 公司地址的详细地址
    @JSONField(name = "companyDetailAddress")
    private String companyDetailAddress;

    // 住宅地址的国家
    @JSONField(name = "familyRepublicName")
    private String familyRepublicName;

    // 住宅地址的国家(其它填写内容)
    @JSONField(name = "otherFamilyRepublic")
    private String otherFamilyRepublic;

    // 住宅地址的省份
    @JSONField(name = "familyProvinceName")
    private String familyProvinceName;

    // 住宅地址的城市
    @JSONField(name = "familyCityName")
    private String familyCityName;

    // 住宅地址的区域
    @JSONField(name = "familyCountyName")
    private String familyCountyName;

    // 住宅地址的详细地址
    @JSONField(name = "familyDetailAddress")
    private String familyDetailAddress;

    // 地址类型
    @JSONField(name = "addressType")
    private Integer addressType;

    // 签发机关
    @JSONField(name = "signingOrganization")
    private String signingOrganization;

    // 名族
    @JSONField(name = "nation")
    private String nation;

    //语言[0=未知 1=英文 2=繁体中文 3=简体中文]
    @JSONField(name = "language")
    private Integer language;

    //账户类型[0、未知  1、个人账户  2、联名账户   3、公司账户]
    @JSONField(name = "accountType")
    private Integer accountType;

    //住所电话
    @JSONField(name = "familyPhone")
    private String familyPhone;

    //教育程度[0、未知  1、小学   2、中学   3、专上学院   4、大学或以上]
    @JSONField(name = "educationLevel")
    private Integer educationLevel;

    //从业年限[0、未知  1、1-2年   2、2-5年   3、5-10年   4、>10年]
    @JSONField(name = "workingSeniority")
    private Integer workingSeniority;

    //办公室电话
    @JSONField(name = "officePhone")
    private String officePhone;

    //你是否曾经破产或被送达要将你破产的申请[0、否   1是]
    @JSONField(name = "isBankrupted")
    private Integer isBankrupted;

    //日结单及月结单发送方式[0、未知  1、电子邮箱  2、邮寄到住宅地址  3、邮寄到营业地址]
    @JSONField(name = "dStatementReceiveMode")
    private Integer dStatementReceiveMode;

    //单位信托基金/互惠基金[0、未知 1、没有  2、<1年   3、 1-2年   4、>2年]
    @JSONField(name = "unitTrustsExperience")
    private Integer unitTrustsExperience;

    //其它投资产品 [0、未知  1、<10年  2、10-40年   3、 >40年]
    @JSONField(name = "otherProductsExperience")
    private Integer otherProductsExperience;

    //其它投资产品名称
    @JSONField(name = "otherProductsName")
    private String otherProductsName;

    //期权投资经验 [0、未知 1、没有  2、<1年   3、 1-2年   4、>2年]
    @JSONField(name = "optionsExperience")
    private Integer optionsExperience;

    //股票交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    @JSONField(name = "tradeStockFrequency")
    private Integer tradeStockFrequency;

    //认股证交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    @JSONField(name = "tradeWarrantsFrequency")
    private Integer tradeWarrantsFrequency;

    //期权交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    @JSONField(name = "tradeOptionsFrequency")
    private Integer tradeOptionsFrequency;

    //期货交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    @JSONField(name = "tradeFuturesFrequency")
    private Integer tradeFuturesFrequency;

    //单位信托基金/互惠基金交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    @JSONField(name = "tradeUnitTrustsFrequency")
    private Integer tradeUnitTrustsFrequency;

    //其它投资产品交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    @JSONField(name = "tradeOtherProductsFrequency")
    private Integer tradeOtherProductsFrequency;

    //是否开通期权 [0、不同意    1、同意]
    @JSONField(name = "isOpenOptions")
    private Integer isOpenOptions;

    //期权账户使用场景 [1、互联网交易（默认）   2、全权委托交易]
    @JSONField(name = "optionsAccUsageScenarios")
    private Integer optionsAccUsageScenarios;

    //是否开通期货 [0、不同意    1、同意]
    @JSONField(name = "isOpenFutures")
    private Integer isOpenFutures;

    //期货账户使用场景 [1、互联网交易（默认）  2、全权委托交易]
    @JSONField(name = "futuresAccUsageScenarios")
    private Integer futuresAccUsageScenarios;

    //通讯电话
    @JSONField(name = "contactPhone")
    private String contactPhone;

    //期货交易账号
    @JSONField(name = "futuresTradeAccount")
    private String futuresTradeAccount;

    //证券交易账号
    @JSONField(name = "stockTradeAccount")
    private String stockTradeAccount;

    //银行卡币种 [0-綜合賬戶 1-港幣賬戶 2-美元賬戶 3-人民币账户]
    @JSONField(name = "bankCurrency")
    private Integer bankCurrency;

    //投资年期 [0-未知 1、<1年  2、1-3年  3、3年以上]
    @JSONField(name = "investmentHorizon")
    private Integer investmentHorizon;

    public String getIsAmlSuspicious() {
        return isAmlSuspicious;
    }

    public void setIsAmlSuspicious(String isAmlSuspicious) {
        this.isAmlSuspicious = isAmlSuspicious;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public Integer getOpenAccountType() {
        return openAccountType;
    }

    public void setOpenAccountType(Integer openAccountType) {
        this.openAccountType = openAccountType;
    }

    public Integer getOpenAccountAccessWay() {
        return openAccountAccessWay;
    }

    public void setOpenAccountAccessWay(Integer openAccountAccessWay) {
        this.openAccountAccessWay = openAccountAccessWay;
    }

    public Integer getFundAccountType() {
        return fundAccountType;
    }

    public void setFundAccountType(Integer fundAccountType) {
        this.fundAccountType = fundAccountType;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public String getIdCardValidDateStart() {
        return idCardValidDateStart;
    }

    public void setIdCardValidDateStart(String idCardValidDateStart) {
        this.idCardValidDateStart = idCardValidDateStart;
    }

    public String getIdCardValidDateEnd() {
        return idCardValidDateEnd;
    }

    public void setIdCardValidDateEnd(String idCardValidDateEnd) {
        this.idCardValidDateEnd = idCardValidDateEnd;
    }

    public Double getIdentitySimilarityPercent() {
        return identitySimilarityPercent;
    }

    public void setIdentitySimilarityPercent(Double identitySimilarityPercent) {
        this.identitySimilarityPercent = identitySimilarityPercent;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public Integer getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(Integer professionCode) {
        this.professionCode = professionCode;
    }

    public Integer getProfessionType() {
        return professionType;
    }

    public void setProfessionType(Integer professionType) {
        this.professionType = professionType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Integer getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Integer annualIncome) {
        this.annualIncome = annualIncome;
    }

    public List<Integer> getCapitalSource() {
        return capitalSource;
    }

    public void setCapitalSource(List<Integer> capitalSource) {
        this.capitalSource = capitalSource;
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

    public Integer getIsAllowProvidePrivacy() {
        return isAllowProvidePrivacy;
    }

    public void setIsAllowProvidePrivacy(Integer isAllowProvidePrivacy) {
        this.isAllowProvidePrivacy = isAllowProvidePrivacy;
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

    public String getSourceChannelId() {
        return sourceChannelId;
    }

    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsPassIdentityAuthentication() {
        return isPassIdentityAuthentication;
    }

    public void setIsPassIdentityAuthentication(Integer isPassIdentityAuthentication) {
        this.isPassIdentityAuthentication = isPassIdentityAuthentication;
    }

    public List<OpenAccountImageInfo> getOpenAccountImagesInfo() {
        return openAccountImagesInfo;
    }

    public void setOpenAccountImagesInfo(List<OpenAccountImageInfo> openAccountImagesInfo) {
        this.openAccountImagesInfo = openAccountImagesInfo;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

//    public String getIndustryRange() {
//        return industryRange;
//    }
//
//    public void setIndustryRange(String industryRange) {
//        this.industryRange = industryRange;
//    }


    public List<OpenAccountPropertyTypeProtocol> getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(List<OpenAccountPropertyTypeProtocol> propertyType) {
        this.propertyType = propertyType;
    }

    public List<OpenAccountTaxationInfoProtocol> getTaxationInfo() {
        return taxationInfo;
    }

    public void setTaxationInfo(List<OpenAccountTaxationInfoProtocol> taxationInfo) {
        this.taxationInfo = taxationInfo;
    }

    public List<OpenAccountOtherDisclosureProtocol> getOtherDisclosure() {
        return otherDisclosure;
    }

    public void setOtherDisclosure(List<OpenAccountOtherDisclosureProtocol> otherDisclosure) {
        this.otherDisclosure = otherDisclosure;
    }

    public List<OpenAccountBankVerityInfoProtocol> getBankVerityInfo() {
        return bankVerityInfo;
    }

    public void setBankVerityInfo(List<OpenAccountBankVerityInfoProtocol> bankVerityInfo) {
        this.bankVerityInfo = bankVerityInfo;
    }

    public String getOtherBankName() {
        return otherBankName;
    }

    public void setOtherBankName(String otherBankName) {
        this.otherBankName = otherBankName;
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

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public String getSigningOrganization() {
        return signingOrganization;
    }

    public void setSigningOrganization(String signingOrganization) {
        this.signingOrganization = signingOrganization;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getAcceptRisk() {
        return acceptRisk;
    }

    public void setAcceptRisk(Integer acceptRisk) {
        this.acceptRisk = acceptRisk;
    }

    public Integer getNorthTrade() {
        return northTrade;
    }

    public void setNorthTrade(Integer northTrade) {
        this.northTrade = northTrade;
    }

    public Integer getFatca() {
        return fatca;
    }

    public void setFatca(Integer fatca) {
        this.fatca = fatca;
    }

    public String getOtherNationality() {
        return otherNationality;
    }

    public void setOtherNationality(String otherNationality) {
        this.otherNationality = otherNationality;
    }

    public String getCompanyProvinceName() {
        return companyProvinceName;
    }

    public void setCompanyProvinceName(String companyProvinceName) {
        this.companyProvinceName = companyProvinceName;
    }

    public String getCompanyCityName() {
        return companyCityName;
    }

    public void setCompanyCityName(String companyCityName) {
        this.companyCityName = companyCityName;
    }

    public String getCompanyCountyName() {
        return companyCountyName;
    }

    public void setCompanyCountyName(String companyCountyName) {
        this.companyCountyName = companyCountyName;
    }

    public String getCompanyDetailAddress() {
        return companyDetailAddress;
    }

    public void setCompanyDetailAddress(String companyDetailAddress) {
        this.companyDetailAddress = companyDetailAddress;
    }

    public String getFamilyProvinceName() {
        return familyProvinceName;
    }

    public void setFamilyProvinceName(String familyProvinceName) {
        this.familyProvinceName = familyProvinceName;
    }

    public String getFamilyCityName() {
        return familyCityName;
    }

    public void setFamilyCityName(String familyCityName) {
        this.familyCityName = familyCityName;
    }

    public String getFamilyCountyName() {
        return familyCountyName;
    }

    public void setFamilyCountyName(String familyCountyName) {
        this.familyCountyName = familyCountyName;
    }

    public String getFamilyDetailAddress() {
        return familyDetailAddress;
    }

    public void setFamilyDetailAddress(String familyDetailAddress) {
        this.familyDetailAddress = familyDetailAddress;
    }

    public String getContactRepublicName() {
        return contactRepublicName;
    }

    public void setContactRepublicName(String contactRepublicName) {
        this.contactRepublicName = contactRepublicName;
    }

    public String getCompanyRepublicName() {
        return companyRepublicName;
    }

    public void setCompanyRepublicName(String companyRepublicName) {
        this.companyRepublicName = companyRepublicName;
    }

    public String getFamilyRepublicName() {
        return familyRepublicName;
    }

    public void setFamilyRepublicName(String familyRepublicName) {
        this.familyRepublicName = familyRepublicName;
    }

    public String getOtherContactRepublic() {
        return otherContactRepublic;
    }

    public void setOtherContactRepublic(String otherContactRepublic) {
        this.otherContactRepublic = otherContactRepublic;
    }

    public String getOtherCompanyRepublic() {
        return otherCompanyRepublic;
    }

    public void setOtherCompanyRepublic(String otherCompanyRepublic) {
        this.otherCompanyRepublic = otherCompanyRepublic;
    }

    public String getOtherFamilyRepublic() {
        return otherFamilyRepublic;
    }

    public void setOtherFamilyRepublic(String otherFamilyRepublic) {
        this.otherFamilyRepublic = otherFamilyRepublic;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenNameSpell() {
        return givenNameSpell;
    }

    public void setGivenNameSpell(String givenNameSpell) {
        this.givenNameSpell = givenNameSpell;
    }

    public String getFamilyNameSpell() {
        return familyNameSpell;
    }

    public void setFamilyNameSpell(String familyNameSpell) {
        this.familyNameSpell = familyNameSpell;
    }

    public Integer getFreelanceCode() {
        return freelanceCode;
    }

    public void setFreelanceCode(Integer freelanceCode) {
        this.freelanceCode = freelanceCode;
    }

    public String getFreelanceOther() {
        return freelanceOther;
    }

    public void setFreelanceOther(String freelanceOther) {
        this.freelanceOther = freelanceOther;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    public Integer getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Integer educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Integer getWorkingSeniority() {
        return workingSeniority;
    }

    public void setWorkingSeniority(Integer workingSeniority) {
        this.workingSeniority = workingSeniority;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public Integer getIsBankrupted() {
        return isBankrupted;
    }

    public void setIsBankrupted(Integer isBankrupted) {
        this.isBankrupted = isBankrupted;
    }

    public Integer getdStatementReceiveMode() {
        return dStatementReceiveMode;
    }

    public void setdStatementReceiveMode(Integer dStatementReceiveMode) {
        this.dStatementReceiveMode = dStatementReceiveMode;
    }

    public Integer getUnitTrustsExperience() {
        return unitTrustsExperience;
    }

    public void setUnitTrustsExperience(Integer unitTrustsExperience) {
        this.unitTrustsExperience = unitTrustsExperience;
    }

    public Integer getOtherProductsExperience() {
        return otherProductsExperience;
    }

    public void setOtherProductsExperience(Integer otherProductsExperience) {
        this.otherProductsExperience = otherProductsExperience;
    }

    public String getOtherProductsName() {
        return otherProductsName;
    }

    public void setOtherProductsName(String otherProductsName) {
        this.otherProductsName = otherProductsName;
    }

    public Integer getOptionsExperience() {
        return optionsExperience;
    }

    public void setOptionsExperience(Integer optionsExperience) {
        this.optionsExperience = optionsExperience;
    }

    public Integer getTradeStockFrequency() {
        return tradeStockFrequency;
    }

    public void setTradeStockFrequency(Integer tradeStockFrequency) {
        this.tradeStockFrequency = tradeStockFrequency;
    }

    public Integer getTradeWarrantsFrequency() {
        return tradeWarrantsFrequency;
    }

    public void setTradeWarrantsFrequency(Integer tradeWarrantsFrequency) {
        this.tradeWarrantsFrequency = tradeWarrantsFrequency;
    }

    public Integer getTradeOptionsFrequency() {
        return tradeOptionsFrequency;
    }

    public void setTradeOptionsFrequency(Integer tradeOptionsFrequency) {
        this.tradeOptionsFrequency = tradeOptionsFrequency;
    }

    public Integer getTradeFuturesFrequency() {
        return tradeFuturesFrequency;
    }

    public void setTradeFuturesFrequency(Integer tradeFuturesFrequency) {
        this.tradeFuturesFrequency = tradeFuturesFrequency;
    }

    public Integer getTradeUnitTrustsFrequency() {
        return tradeUnitTrustsFrequency;
    }

    public void setTradeUnitTrustsFrequency(Integer tradeUnitTrustsFrequency) {
        this.tradeUnitTrustsFrequency = tradeUnitTrustsFrequency;
    }

    public Integer getTradeOtherProductsFrequency() {
        return tradeOtherProductsFrequency;
    }

    public void setTradeOtherProductsFrequency(Integer tradeOtherProductsFrequency) {
        this.tradeOtherProductsFrequency = tradeOtherProductsFrequency;
    }

    public Integer getIsOpenOptions() {
        return isOpenOptions;
    }

    public void setIsOpenOptions(Integer isOpenOptions) {
        this.isOpenOptions = isOpenOptions;
    }

    public Integer getOptionsAccUsageScenarios() {
        return optionsAccUsageScenarios;
    }

    public void setOptionsAccUsageScenarios(Integer optionsAccUsageScenarios) {
        this.optionsAccUsageScenarios = optionsAccUsageScenarios;
    }

    public Integer getIsOpenFutures() {
        return isOpenFutures;
    }

    public void setIsOpenFutures(Integer isOpenFutures) {
        this.isOpenFutures = isOpenFutures;
    }

    public Integer getFuturesAccUsageScenarios() {
        return futuresAccUsageScenarios;
    }

    public void setFuturesAccUsageScenarios(Integer futuresAccUsageScenarios) {
        this.futuresAccUsageScenarios = futuresAccUsageScenarios;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getFuturesTradeAccount() {
        return futuresTradeAccount;
    }

    public void setFuturesTradeAccount(String futuresTradeAccount) {
        this.futuresTradeAccount = futuresTradeAccount;
    }

    public String getStockTradeAccount() {
        return stockTradeAccount;
    }

    public void setStockTradeAccount(String stockTradeAccount) {
        this.stockTradeAccount = stockTradeAccount;
    }

    public Integer getBankCurrency() {
        return bankCurrency;
    }

    public void setBankCurrency(Integer bankCurrency) {
        this.bankCurrency = bankCurrency;
    }

    public Integer getInvestmentHorizon() {
        return investmentHorizon;
    }

    public void setInvestmentHorizon(Integer investmentHorizon) {
        this.investmentHorizon = investmentHorizon;
    }
}
