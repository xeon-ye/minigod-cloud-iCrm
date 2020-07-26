package com.sunline.modules.account.online.entity;

import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 客户开户详细资料表
 * 将CustomerAccOpenInfoModel转化为此Entity（保存数据库）
 *
 * @author lcs
 * @email
 * @date 2018-09-28 14:10:22
 */
public class CustomerAccountOpenInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //自增ID
    private Long id;
    //预约流水号
    private String applicationId;
    //开户类型[0=未知 1=互联网 2=线下开户]
    private Integer openAccountType;
    //开户接入方式[1=H5开户 2=APP]
    private Integer openAccountAccessWay;
    //账户类型[1=现金账户 2=融资账户]
    private Integer fundAccountType;
    //开户客户来源渠道ID
    private String sourceChannelId;
    //开户客户来源渠道名称
    private String sourceChannelName;
    //小神号
    private Integer userId;
    //开户邀请人的userId
    private String inviterId;
    //交易帐号
    private String clientId;
    //资金帐号
    private String fundAccount;
    //客户中文名
    private String clientName;
    //姓氏
    private String familyName;
    //名字
    private String givenName;
    //中文名拼音
    private String clientNameSpell;
    // 英文名字
    private String givenNameSpell;
    // 英文姓氏
    private String familyNameSpell;
    //证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
    private Integer idKind;
    //证件号码
    private String idNo;
    //性别[0=男 1=女 2=其它]
    private Integer sex;
    //生日日期
    private String birthday;
    //证件地址
    private String idCardAddress;
    //身份证生效日期
    private String idCardValidDateStart;
    //身份证失效日期
    private String idCardValidDateEnd;
    //身份相似百分数
    private Double identitySimilarityPercent;
    //是否通过身份验证[0=否 1=是]
    private Integer isPassIdentityAuthentication;
    //银行编号
    private String bankId;
    //银行卡号
    private String bankNo;
    //银行账户名
    private String bankAccountName;
    //国籍
    private String nationality;
    //其它国家/地区名称
    private String otherNationality;
    //是否美国绿卡持有人[0=否 1=是]
    private Integer isAmericanGreenCardHolder;
    // 联系地址的国家
    private String contactRepublicName;
    // 联系地址的国家(其它填写内容)
    private String otherContactRepublic;
    //联系地址的省份
    private String contactProvinceName;
    //联系地址的城市
    private String contactCityName;
    //联系地址的区域
    private String contactCountyName;
    //联系地址的详细地址
    private String contactDetailAddress;
    // 公司地址的国家
    private String companyRepublicName;
    // 公司地址的国家(其它填写内容)
    private String otherCompanyRepublic;
    // 公司地址的省份
    private String companyProvinceName;

    // 公司地址的城市
    private String companyCityName;

    // 公司地址的区域
    private String companyCountyName;

    // 公司地址的详细地址
    private String companyDetailAddress;
    // 住宅地址的国家
    private String familyRepublicName;

    // 住宅地址的国家(其它填写内容)
    private String otherFamilyRepublic;

    // 住宅地址的省份
    private String familyProvinceName;

    // 住宅地址的城市
    private String familyCityName;

    // 住宅地址的区域
    private String familyCountyName;

    // 住宅地址的详细地址
    private String familyDetailAddress;
    //住宅地址
    private String familyAddress;
    //通讯地址
    private String contactAddress;
    //电子邮箱
    private String email;
    //手机号
    private String phoneNumber;
    //就业情况类型[0-未知 1=受雇 2=自营/个体户 3=退休 4=学生 5=其他 6 =农林牧副渔 7=待业 8=自由职业者 9-投资者 10-家庭主妇]
    private Integer professionCode;
    //自由职业细化选项 [字典=AO_FREELANCE_CODE]
    private Integer freelanceCode;
    //自由职业细化其他说明
    private String freelanceOther;
    //职业类型[待定]
    private Integer professionType;
    //公司名称
    private String companyName;
    //公司地址
    private String companyAddress;
    //公司电话
    private String companyPhoneNumber;
    //职位级别[1-普通员工 2-中层管理 3-高层管理]
    private String jobPosition;
    //公司业务性质或行业类型
    private String industryRange;
    //收入来源[0-工资和奖金 1-投资回报 2-劳务报酬 3-租金收入 4-营业收入 5-退休金 6-家人给予 7-兼职收入 8-生产收入]
    private String capitalSource;
    //年收入范围类型[1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]
    private Integer annualIncome;
    //投资目标类型[1=股息收入 2=短期投资 3=长期投资 4=其他 5=保本 6-资本增值 7-投机 8-对冲]
    private String investTarget;
    //投资目标其它类型说明
    private String investTargetOther;
    //股票投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
    private Integer stocksInvestmentExperienceType;
    //认证股权投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
    private Integer warrantsInvestmentExperienceType;
    //期货投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
    private Integer futuresInvestmentExperienceType;
    //是否了解衍生产品[0=否 1=是]
    private Integer isKnowDerivativeProducts;
    //衍生产品学习途径[0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它]
    private Integer derivativeProductsStudyType;
    //衍生产品其他学习途径
    private String derivativeProductsStudyTypeOther;
    //在金融机构工作经验类型[0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它]
    private Integer financingInstitutionWorkExperienceType;
    //在金融机构其它工作经验类型
    private String financingInstitutionWorkExperienceTypeOther;
    //是否在过去三年曾买卖过至少五次任何衍生产品的交易[0=否 1=是]
    private Integer isTradedDerivativeProducts;
    //是否开通美股市场[0=否 1=是]
    private Integer isOpenUsaStockMarket;
    //是否开通港股市场[0=否 1=是]
    private Integer isOpenHkStockMarket;
    //您是否确认个人资料（私隐）条例通知并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途[0=否 1=是]
    private Integer isAllowProvidePrivacy;
    //增加北向交易的资料收集声明（[0=否 1=是]）必须二选一，此选项会影响到后续的中华通交易权限，选择“否”的客户，无法进行中华通交易
    private Integer northTrade;
    //增加FATCA声明（[0=否 1=是]）必须二选一；编辑资料改成“是”时出现弹窗，保留继续“否”的选择
    private Integer fatca;
    //美国纳税人识别号码
    private String theUSTaxNum;
    //风险承受程度（必须三选一）：[1=低风险 2=中风险 3=高风险]
    private Integer acceptRisk;
    //有无AML可疑信息[0=无可疑 1=有可疑]
    private Integer isAmlSuspicious;
    //是否允许衍生品交易[0=否 1=是]
    private Integer isAllowDerivativesTransaction;
    private Integer accountLevel;
    //初始密码
    private String initialAccountPassword;
    //开户时间
    private Date openAccountTime;
    //申请时间,用户实际提交申请的时间
    private Date applicationTime;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    //记录状态[0-无效 1-有效]
    private Integer recordStatus;

    //四要素
    private List<OpenAccountBankVerityInfoEntity> openAccountBankVerityList;
    //财产种类
    private List<OpenAccountPropertyTypeEntity> propertyTypeList;
    //其他信息
    private List<OpenAccountOtherDisclosureEntity> otherDisclosureList;
    //税务信息
    private List<OpenAccountTaxationInfoEntity> taxationInfoList;

    // 图片信息
    private List<OpenAccountImageInfo> openAccountImagesInfo;

    // 账户类型[0-香港银行卡 1-大陆银行卡 2-未知]
    private Integer bankType;

    private String taxInfo;
    private String otherInfo;
    private String propertyInfo;

    //其他银行名称
    private String otherBankName;

    //见证人
    private String witnessUser;
    //见证人类型
    private String witnessesType;
    //牌照号码
    private String licenseNumber;
    //提交审批人
    private String submitApprovalUser;

    //地址类型[1=大陆地址 2=香港地址 3=其他地区]
    private Integer addressType;

    // 签发机关
    private String signingOrganization;

    // 名族
    private String nation;

    // CA签署码
    private String caSignHashCode;

    // 是否转入复审[0-不转入 1-转入]
    private Integer isRecheck;

    //转入复审的审批意见
    private String remark;

    //语言[0=未知 1=英文 2=繁体中文 3=简体中文]
    private Integer lan;

    //账户类型[0、未知  1、个人账户  2、联名账户   3、公司账户]
    private Integer accountType;

    //住所电话
    private String familyPhone;

    //教育程度[0、未知  1、小学   2、中学   3、专上学院   4、大学或以上]
    private Integer educationLevel;

    //从业年限[0、未知  1、1-2年   2、2-5年   3、5-10年   4、>10年]
    private Integer workingSeniority;

    //办公室电话
    private String officePhone;

    //你是否曾经破产或被送达要将你破产的申请[0、否   1是]
    private Integer isBankrupted;

    //日结单及月结单发送方式[0、未知  1、电子邮箱  2、邮寄到住宅地址  3、邮寄到营业地址]
    private Integer dStatementReceiveMode;

    //单位信托基金/互惠基金[0、未知 1、没有  2、<1年   3、 1-2年   4、>2年]
    private Integer unitTrustsExperience;

    //其它投资产品 [0、未知  1、<10年  2、10-40年   3、 >40年]
    private Integer otherProductsExperience;

    //其它投资产品名称
    private String otherProductsName;

    //期权投资经验 [0、未知 1、没有  2、<1年   3、 1-2年   4、>2年]
    private Integer optionsExperience;

    //股票交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    private Integer tradeStockFrequency;

    //认股证交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    private Integer tradeWarrantsFrequency;

    //期权交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    private Integer tradeOptionsFrequency;

    //期货交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    private Integer tradeFuturesFrequency;

    //单位信托基金/互惠基金交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    private Integer tradeUnitTrustsFrequency;

    //其它投资产品交易频率次/年 [0、未知 1、<10  2、10-40   3、 >40]
    private Integer tradeOtherProductsFrequency;

    //是否开通期权 [0、不同意    1、同意]
    private Integer isOpenOptions;

    //期权账户使用场景 [1、互联网交易（默认）   2、全权委托交易]
    private Integer optionsAccUsageScenarios;

    //是否开通期货 [0、不同意    1、同意]
    private Integer isOpenFutures;

    //期货账户使用场景 [1、互联网交易（默认）  2、全权委托交易]
    private Integer futuresAccUsageScenarios;

    //期货交易账号
    private String futuresTradeAccount;
    //证券交易账号
    private String stockTradeAccount;

    //通讯电话
    private String contactPhone;

    //银行卡币种 [0-綜合賬戶 1-港幣賬戶 2-美元賬戶 3-人民币账户]
    private Integer bankCurrency;

    /**
     * 设置：自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：预约流水号
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取：预约流水号
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * 设置：开户类型[0=未知 1=互联网 2=线下开户]
     */
    public void setOpenAccountType(Integer openAccountType) {
        this.openAccountType = openAccountType;
    }

    /**
     * 获取：开户类型[0=未知 1=互联网 2=线下开户]
     */
    public Integer getOpenAccountType() {
        return openAccountType;
    }

    /**
     * 设置：开户接入方式[1=H5开户 2=商汤开户]
     */
    public void setOpenAccountAccessWay(Integer openAccountAccessWay) {
        this.openAccountAccessWay = openAccountAccessWay;
    }

    /**
     * 获取：开户接入方式[1=H5开户 2=商汤开户]
     */
    public Integer getOpenAccountAccessWay() {
        return openAccountAccessWay;
    }

    /**
     * 设置：账户类型[1=现金账户 2=融资账户]
     */
    public void setFundAccountType(Integer fundAccountType) {
        this.fundAccountType = fundAccountType;
    }

    /**
     * 获取：账户类型[1=现金账户 2=融资账户]
     */
    public Integer getFundAccountType() {
        return fundAccountType;
    }

    /**
     * 设置：开户客户来源渠道ID
     */
    public void setSourceChannelId(String sourceChannelId) {
        this.sourceChannelId = sourceChannelId;
    }

    /**
     * 获取：开户客户来源渠道ID
     */
    public String getSourceChannelId() {
        return sourceChannelId;
    }

    /**
     * 设置：开户客户来源渠道名称
     */
    public void setSourceChannelName(String sourceChannelName) {
        this.sourceChannelName = sourceChannelName;
    }

    /**
     * 获取：开户客户来源渠道名称
     */
    public String getSourceChannelName() {
        return sourceChannelName;
    }

    /**
     * 设置：小神号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取：小神号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置：开户邀请人的userId
     */
    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
    }

    /**
     * 获取：开户邀请人的userId
     */
    public String getInviterId() {
        return inviterId;
    }

    /**
     * 设置：交易帐号
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取：交易帐号
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置：资金帐号
     */
    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount;
    }

    /**
     * 获取：资金帐号
     */
    public String getFundAccount() {
        return fundAccount;
    }

    /**
     * 设置：客户中文名
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * 获取：客户中文名
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * 设置：姓氏
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * 获取：姓氏
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * 设置：名字
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * 获取：名字
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * 设置：中文名拼音
     */
    public void setClientNameSpell(String clientNameSpell) {
        this.clientNameSpell = clientNameSpell;
    }

    /**
     * 获取：中文名拼音
     */
    public String getClientNameSpell() {
        return clientNameSpell;
    }

    /**
     * 设置：证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
     */
    public void setIdKind(Integer idKind) {
        this.idKind = idKind;
    }

    /**
     * 获取：证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=驾驶证]
     */
    public Integer getIdKind() {
        return idKind;
    }

    /**
     * 设置：证件号码
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    /**
     * 获取：证件号码
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 设置：性别[0=男 1=女 2=其它]
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取：性别[0=男 1=女 2=其它]
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置：生日日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取：生日日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置：证件地址
     */
    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress;
    }

    /**
     * 获取：证件地址
     */
    public String getIdCardAddress() {
        return idCardAddress;
    }

    /**
     * 设置：身份证生效日期
     */
    public void setIdCardValidDateStart(String idCardValidDateStart) {
        this.idCardValidDateStart = idCardValidDateStart;
    }

    /**
     * 获取：身份证生效日期
     */
    public String getIdCardValidDateStart() {
        return idCardValidDateStart;
    }

    /**
     * 设置：身份证失效日期
     */
    public void setIdCardValidDateEnd(String idCardValidDateEnd) {
        this.idCardValidDateEnd = idCardValidDateEnd;
    }

    /**
     * 获取：身份证失效日期
     */
    public String getIdCardValidDateEnd() {
        return idCardValidDateEnd;
    }

    /**
     * 设置：身份相似百分数
     */
    public void setIdentitySimilarityPercent(Double identitySimilarityPercent) {
        this.identitySimilarityPercent = identitySimilarityPercent;
    }

    /**
     * 获取：身份相似百分数
     */
    public Double getIdentitySimilarityPercent() {
        return identitySimilarityPercent;
    }

    /**
     * 设置：是否通过身份验证[0=否 1=是]
     */
    public void setIsPassIdentityAuthentication(Integer isPassIdentityAuthentication) {
        this.isPassIdentityAuthentication = isPassIdentityAuthentication;
    }

    /**
     * 获取：是否通过身份验证[0=否 1=是]
     */
    public Integer getIsPassIdentityAuthentication() {
        return isPassIdentityAuthentication;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * 设置：银行卡号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    /**
     * 获取：银行卡号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 设置：银行账户名
     */
    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    /**
     * 获取：银行账户名
     */
    public String getBankAccountName() {
        return bankAccountName;
    }

    /**
     * 设置：国籍
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * 获取：国籍
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * 设置：是否美国绿卡持有人[0=否 1=是]
     */
    public void setIsAmericanGreenCardHolder(Integer isAmericanGreenCardHolder) {
        this.isAmericanGreenCardHolder = isAmericanGreenCardHolder;
    }

    /**
     * 获取：是否美国绿卡持有人[0=否 1=是]
     */
    public Integer getIsAmericanGreenCardHolder() {
        return isAmericanGreenCardHolder;
    }

    /**
     * 设置：联系地址的省份
     */
    public void setContactProvinceName(String contactProvinceName) {
        this.contactProvinceName = contactProvinceName;
    }

    /**
     * 获取：联系地址的省份
     */
    public String getContactProvinceName() {
        return contactProvinceName;
    }

    /**
     * 设置：联系地址的城市
     */
    public void setContactCityName(String contactCityName) {
        this.contactCityName = contactCityName;
    }

    /**
     * 获取：联系地址的城市
     */
    public String getContactCityName() {
        return contactCityName;
    }

    /**
     * 设置：联系地址的区域
     */
    public void setContactCountyName(String contactCountyName) {
        this.contactCountyName = contactCountyName;
    }

    /**
     * 获取：联系地址的区域
     */
    public String getContactCountyName() {
        return contactCountyName;
    }

    /**
     * 设置：联系地址的详细地址
     */
    public void setContactDetailAddress(String contactDetailAddress) {
        this.contactDetailAddress = contactDetailAddress;
    }

    /**
     * 获取：联系地址的详细地址
     */
    public String getContactDetailAddress() {
        return contactDetailAddress;
    }

    /**
     * 设置：住宅地址
     */
    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    /**
     * 获取：住宅地址
     */
    public String getFamilyAddress() {
        return familyAddress;
    }

    /**
     * 设置：通讯地址
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     * 获取：通讯地址
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     * 设置：电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取：电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置：手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取：手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置：就业情况类型[0-未知 1=受雇 2=自营/个体户 3=退休 4=学生 5=其他 6 =农林牧副渔 7=待业 8=自由职业者 9-投资者 10-家庭主妇]
     */
    public void setProfessionCode(Integer professionCode) {
        this.professionCode = professionCode;
    }

    /**
     * 获取：就业情况类型[0-未知 1=受雇 2=自营/个体户 3=退休 4=学生 5=其他 6 =农林牧副渔 7=待业 8=自由职业者 9-投资者 10-家庭主妇]
     */
    public Integer getProfessionCode() {
        return professionCode;
    }

    /**
     * 设置：职业类型[待定]
     */
    public void setProfessionType(Integer professionType) {
        this.professionType = professionType;
    }

    /**
     * 获取：职业类型[待定]
     */
    public Integer getProfessionType() {
        return professionType;
    }

    /**
     * 设置：公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取：公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置：公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 获取：公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置：公司电话
     */
    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    /**
     * 获取：公司电话
     */
    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    /**
     * 设置：职位级别[1-普通员工 2-中层管理 3-高层管理]
     */
    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    /**
     * 获取：职位级别[1-普通员工 2-中层管理 3-高层管理]
     */
    public String getJobPosition() {
        return jobPosition;
    }

    /**
     * 设置：公司业务性质或行业类型
     */
    public void setIndustryRange(String industryRange) {
        this.industryRange = industryRange;
    }

    /**
     * 获取：公司业务性质或行业类型
     */
    public String getIndustryRange() {
        return industryRange;
    }

    /**
     * 设置：收入来源[0-工资和奖金 1-投资回报 2-劳务报酬 3-租金收入 4-营业收入 5-退休金 6-家人给予 7-兼职收入 8-生产收入]
     */
    public void setCapitalSource(String capitalSource) {
        this.capitalSource = capitalSource;
    }

    /**
     * 获取：收入来源[0-工资和奖金 1-投资回报 2-劳务报酬 3-租金收入 4-营业收入 5-退休金 6-家人给予 7-兼职收入 8-生产收入]
     */
    public String getCapitalSource() {
        return capitalSource;
    }

    /**
     * 设置：年收入范围类型[1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]
     */
    public void setAnnualIncome(Integer annualIncome) {
        this.annualIncome = annualIncome;
    }

    /**
     * 获取：年收入范围类型[1=<20万 2=20万-50万 3=50万-100万 4=100万-500万 5=>500万]
     */
    public Integer getAnnualIncome() {
        return annualIncome;
    }

    /**
     * 设置：投资目标类型[1=股息收入 2=短期投资 3=长期投资 4=其他]
     */
    public void setInvestTarget(String investTarget) {
        this.investTarget = investTarget;
    }

    /**
     * 获取：投资目标类型[1=股息收入 2=短期投资 3=长期投资 4=其他]
     */
    public String getInvestTarget() {
        return investTarget;
    }

    /**
     * 设置：投资目标其它类型说明
     */
    public void setInvestTargetOther(String investTargetOther) {
        this.investTargetOther = investTargetOther;
    }

    /**
     * 获取：投资目标其它类型说明
     */
    public String getInvestTargetOther() {
        return investTargetOther;
    }

    /**
     * 设置：股票投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
     */
    public void setStocksInvestmentExperienceType(Integer stocksInvestmentExperienceType) {
        this.stocksInvestmentExperienceType = stocksInvestmentExperienceType;
    }

    /**
     * 获取：股票投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
     */
    public Integer getStocksInvestmentExperienceType() {
        return stocksInvestmentExperienceType;
    }

    /**
     * 设置：认证股权投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
     */
    public void setWarrantsInvestmentExperienceType(Integer warrantsInvestmentExperienceType) {
        this.warrantsInvestmentExperienceType = warrantsInvestmentExperienceType;
    }

    /**
     * 获取：认证股权投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
     */
    public Integer getWarrantsInvestmentExperienceType() {
        return warrantsInvestmentExperienceType;
    }

    /**
     * 设置：期货投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
     */
    public void setFuturesInvestmentExperienceType(Integer futuresInvestmentExperienceType) {
        this.futuresInvestmentExperienceType = futuresInvestmentExperienceType;
    }

    /**
     * 获取：期货投资经验类型[0=没有经验 1=少于一年 2=一至三年 3=三至五年 4=五年以上]
     */
    public Integer getFuturesInvestmentExperienceType() {
        return futuresInvestmentExperienceType;
    }

    /**
     * 设置：是否了解衍生产品[0=否 1=是]
     */
    public void setIsKnowDerivativeProducts(Integer isKnowDerivativeProducts) {
        this.isKnowDerivativeProducts = isKnowDerivativeProducts;
    }

    /**
     * 获取：是否了解衍生产品[0=否 1=是]
     */
    public Integer getIsKnowDerivativeProducts() {
        return isKnowDerivativeProducts;
    }

    /**
     * 设置：衍生产品学习途径[0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它]
     */
    public void setDerivativeProductsStudyType(Integer derivativeProductsStudyType) {
        this.derivativeProductsStudyType = derivativeProductsStudyType;
    }

    /**
     * 获取：衍生产品学习途径[0=未知 1=金融机构 2=监管机构 3=交易所 4=大专院校 5=进修学院 6=线上课程 7=其它]
     */
    public Integer getDerivativeProductsStudyType() {
        return derivativeProductsStudyType;
    }

    /**
     * 设置：衍生产品其他学习途径
     */
    public void setDerivativeProductsStudyTypeOther(String derivativeProductsStudyTypeOther) {
        this.derivativeProductsStudyTypeOther = derivativeProductsStudyTypeOther;
    }

    /**
     * 获取：衍生产品其他学习途径
     */
    public String getDerivativeProductsStudyTypeOther() {
        return derivativeProductsStudyTypeOther;
    }

    /**
     * 设置：在金融机构工作经验类型[0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它]
     */
    public void setFinancingInstitutionWorkExperienceType(Integer financingInstitutionWorkExperienceType) {
        this.financingInstitutionWorkExperienceType = financingInstitutionWorkExperienceType;
    }

    /**
     * 获取：在金融机构工作经验类型[0=未知 1=受监管持牌人士 2=与衍生工具相关后勤 3=管理层 4=其它]
     */
    public Integer getFinancingInstitutionWorkExperienceType() {
        return financingInstitutionWorkExperienceType;
    }

    /**
     * 设置：在金融机构其它工作经验类型
     */
    public void setFinancingInstitutionWorkExperienceTypeOther(String financingInstitutionWorkExperienceTypeOther) {
        this.financingInstitutionWorkExperienceTypeOther = financingInstitutionWorkExperienceTypeOther;
    }

    /**
     * 获取：在金融机构其它工作经验类型
     */
    public String getFinancingInstitutionWorkExperienceTypeOther() {
        return financingInstitutionWorkExperienceTypeOther;
    }

    /**
     * 设置：是否在过去三年曾买卖过至少五次任何衍生产品的交易[0=否 1=是]
     */
    public void setIsTradedDerivativeProducts(Integer isTradedDerivativeProducts) {
        this.isTradedDerivativeProducts = isTradedDerivativeProducts;
    }

    /**
     * 获取：是否在过去三年曾买卖过至少五次任何衍生产品的交易[0=否 1=是]
     */
    public Integer getIsTradedDerivativeProducts() {
        return isTradedDerivativeProducts;
    }

    /**
     * 设置：是否开通美股市场[0=否 1=是]
     */
    public void setIsOpenUsaStockMarket(Integer isOpenUsaStockMarket) {
        this.isOpenUsaStockMarket = isOpenUsaStockMarket;
    }

    /**
     * 获取：是否开通美股市场[0=否 1=是]
     */
    public Integer getIsOpenUsaStockMarket() {
        return isOpenUsaStockMarket;
    }

    /**
     * 设置：是否开通港股市场[0=否 1=是]
     */
    public void setIsOpenHkStockMarket(Integer isOpenHkStockMarket) {
        this.isOpenHkStockMarket = isOpenHkStockMarket;
    }

    /**
     * 获取：是否开通港股市场[0=否 1=是]
     */
    public Integer getIsOpenHkStockMarket() {
        return isOpenHkStockMarket;
    }

    /**
     * 设置：您是否确认个人资料（私隐）条例通知并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途[0=否 1=是]
     */
    public void setIsAllowProvidePrivacy(Integer isAllowProvidePrivacy) {
        this.isAllowProvidePrivacy = isAllowProvidePrivacy;
    }

    /**
     * 获取：您是否确认个人资料（私隐）条例通知并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途[0=否 1=是]
     */
    public Integer getIsAllowProvidePrivacy() {
        return isAllowProvidePrivacy;
    }

    /**
     * 设置：有无AML可疑信息[0=无可疑 1=有可疑]
     */
    public void setIsAmlSuspicious(Integer isAmlSuspicious) {
        this.isAmlSuspicious = isAmlSuspicious;
    }

    /**
     * 获取：有无AML可疑信息[0=无可疑 1=有可疑]
     */
    public Integer getIsAmlSuspicious() {
        return isAmlSuspicious;
    }

    /**
     * 设置：是否允许衍生品交易[0=否 1=是]
     */
    public void setIsAllowDerivativesTransaction(Integer isAllowDerivativesTransaction) {
        this.isAllowDerivativesTransaction = isAllowDerivativesTransaction;
    }

    /**
     * 获取：是否允许衍生品交易[0=否 1=是]
     */
    public Integer getIsAllowDerivativesTransaction() {
        return isAllowDerivativesTransaction;
    }

    /**
     * 设置：初始密码
     */
    public void setInitialAccountPassword(String initialAccountPassword) {
        this.initialAccountPassword = initialAccountPassword;
    }

    /**
     * 获取：初始密码
     */
    public String getInitialAccountPassword() {
        return initialAccountPassword;
    }

    /**
     * 设置：开户时间
     */
    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    /**
     * 获取：开户时间
     */
    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    /**
     * 设置：申请时间,用户实际提交申请的时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 获取：申请时间,用户实际提交申请的时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置：记录状态[0-无效 1-有效]
     */
    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    /**
     * 获取：记录状态[0-无效 1-有效]
     */
    public Integer getRecordStatus() {
        return recordStatus;
    }

    public List<OpenAccountBankVerityInfoEntity> getOpenAccountBankVerityList() {
        return openAccountBankVerityList;
    }

    public void setOpenAccountBankVerityList(List<OpenAccountBankVerityInfoEntity> openAccountBankVerityList) {
        this.openAccountBankVerityList = openAccountBankVerityList;
    }

    public List<OpenAccountPropertyTypeEntity> getPropertyTypeList() {
        return propertyTypeList;
    }

    public void setPropertyTypeList(List<OpenAccountPropertyTypeEntity> propertyTypeList) {
        this.propertyTypeList = propertyTypeList;
    }

    public List<OpenAccountOtherDisclosureEntity> getOtherDisclosureList() {
        return otherDisclosureList;
    }

    public void setOtherDisclosureList(List<OpenAccountOtherDisclosureEntity> otherDisclosureList) {
        this.otherDisclosureList = otherDisclosureList;
    }

    public List<OpenAccountTaxationInfoEntity> getTaxationInfoList() {
        return taxationInfoList;
    }

    public void setTaxationInfoList(List<OpenAccountTaxationInfoEntity> taxationInfoList) {
        this.taxationInfoList = taxationInfoList;
    }

    public List<OpenAccountImageInfo> getOpenAccountImagesInfo() {
        return openAccountImagesInfo;
    }

    public void setOpenAccountImagesInfo(List<OpenAccountImageInfo> openAccountImagesInfo) {
        this.openAccountImagesInfo = openAccountImagesInfo;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    public String getTaxInfo() {
        return taxInfo;
    }

    public void setTaxInfo(String taxInfo) {
        this.taxInfo = taxInfo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getPropertyInfo() {
        return propertyInfo;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public String getOtherBankName() {
        return otherBankName;
    }

    public void setOtherBankName(String otherBankName) {
        this.otherBankName = otherBankName;
    }

    public Integer getAccountLevel() {
        return accountLevel;
    }

    public void setAccountLevel(Integer accountLevel) {
        this.accountLevel = accountLevel;
    }

    public String getWitnessUser() {
        return witnessUser;
    }

    public void setWitnessUser(String witnessUser) {
        this.witnessUser = witnessUser;
    }

    public String getWitnessesType() {
        return witnessesType;
    }

    public void setWitnessesType(String witnessesType) {
        this.witnessesType = witnessesType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getSubmitApprovalUser() {
        return submitApprovalUser;
    }

    public void setSubmitApprovalUser(String submitApprovalUser) {
        this.submitApprovalUser = submitApprovalUser;
    }

    public Integer getAddressType() {
        return addressType;
    }

    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
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

    public String getCaSignHashCode() {
        return caSignHashCode;
    }

    public void setCaSignHashCode(String caSignHashCode) {
        this.caSignHashCode = caSignHashCode;
    }

    public Integer getIsRecheck() {
        return isRecheck;
    }

    public void setIsRecheck(Integer isRecheck) {
        this.isRecheck = isRecheck;
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

    public Integer getAcceptRisk() {
        return acceptRisk;
    }

    public void setAcceptRisk(Integer acceptRisk) {
        this.acceptRisk = acceptRisk;
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

    public String getTheUSTaxNum() {
        return theUSTaxNum;
    }

    public void setTheUSTaxNum(String theUSTaxNum) {
        this.theUSTaxNum = theUSTaxNum;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getLan() {
        return lan;
    }

    public void setLan(Integer lan) {
        this.lan = lan;
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

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getBankCurrency() {
        return bankCurrency;
    }

    public void setBankCurrency(Integer bankCurrency) {
        this.bankCurrency = bankCurrency;
    }
}
