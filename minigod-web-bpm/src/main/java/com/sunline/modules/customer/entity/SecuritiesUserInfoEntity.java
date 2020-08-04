package com.sunline.modules.customer.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 证券客户资料表
 *
 * @author lcs
 * @email aljqiang@163.com
 * @date 2018-11-13 14:22:10
 */
public class SecuritiesUserInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据库表对应字段
     */
    //主键ID
    private Integer id;
    //预约流水号
    private String applicationId;
    //开户类型[0=未知 1=互联网 2=线下开户 3=BPM]
    private Integer openAccountType;
    //开户接入方式[1=H5开户 2=APP开户]
    private Integer openAccountAccessWay;
    //开户时间
    private Date openAccountTime;
    //小神号
    private Integer userId;
    //开户邀请人小神号
    private String inviterId;
    //交易帐号
    private String tradeAccount;
    //资金帐号
    private String fundAccount;
    //客户状态[0-正常 1-冻结 2-挂失 3-销户 D-休眠 E-不合格 F-锁定]
    private String clientStatus;
    //账户类型[1=现金账户 2=融资账户]
    private Integer fundAccountType;
    //渠道ID
    private String channelId;
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
    //银行账户类型[0-香港账户 1-非香港帐号]
    private Integer bankType;
    //银行编号
    private String bankId;
    //银行卡号
    private String bankNo;
    //银行账户名
    private String bankAccountName;
    //其他银行名称
    private String otherBankName;
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
    //手机号码
    private String phoneNumber;
    //就业情况类型[0-未知 1=受雇 2=自营/个体户 3=退休 4=学生 5=其他 6 =农林牧副渔 7=待业 8=自由职业者 9-投资者 10-家庭主妇]
    private Integer professionCode;
    //自由职业细化选项 [字典=AO_FREELANCE_CODE]
    private Integer freelanceCode;
    //自由职业细化其他说明
    private String freelanceOther;
    //就业情况其它说明
    private String otherProfession;
    //所属行业[数据字典-AO_OCCUPATION_TYPE]
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
    //净资产范围类型[1=<50万 2=50万-250万 3=250万-500万 4=>500万]
    private Integer netCapital;
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
    //是否允许衍生品交易[0=否 1=是]
    private Integer isAllowDerivativesTransaction;
    //您是否确认个人资料（私隐）条例通知并同意智珠证券及其控股集团使用及向其他人士提供本人的个人资料作直接促销用途[0=否 1=是]
    private Integer isAllowProvidePrivacy;
    //增加北向交易的资料收集声明（[0=否 1=是]）必须二选一，此选项会影响到后续的中华通交易权限，选择“否”的客户，无法进行中华通交易
    private Integer northTrade;
    //增加FATCA声明（[0=否 1=是]）必须二选一；编辑资料改成“是”时出现弹窗，保留继续“否”的选择
    private Integer fatca;
    //美国纳税人识别码
    private String theUSTaxNum;
    //风险承受程度（必须三选一）：[1=低风险 2=中风险 3=高风险]
    private Integer acceptRisk;
    //有无AML可疑信息[0=无可疑 1=有可疑]
    private Integer isAmlSuspicious;
    //记录状态[0-无效 1-有效]
    private Integer recordStatus;
    private String addressId;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    //大户室号(客户级别1-Common 2-Important 3- VIP 4-PI 5-Capital)
    private Integer roomCode;

    /**
     * 补充业务字段
     */

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 推荐人姓名
     */
    private String inviterName;

    /**
     * 免佣结束日期
     */
    private String freeEndDate;
    /**
     * 免佣次数
     */
    private String freeCount;
    /**
     * 免佣总时长
     */
    private String freeTotalTime;

    /**
     * 行情结束日期
     */
    private String hqEndTime;
    /**
     * 行情次数
     */
    private String hqCount;
    /**
     * 行情总时长
     */
    private String hqTotalTime;
    /**
     * 出入金状态
     */
    private String depositType;
    /**
     * 入金次数
     */
    private String depositCount;
    /**
     * 入金总时长
     */
    private String depositTime;
    /**
     * 注册状态
     */
    private String userStatus;

    /**
     * 开户客户来源渠道ID[dataRef t_crm_channel]
     */
    private String sourceChannelId;

    /**
     * 开户客户来源渠道名称[dataRef t_crm_channel]
     */
    private String sourceChannelName;

    /**
     * 开户次数
     */
    private String openAccountCount;

    /**
     * 分组编号
     */
    private String groupNo;
    /**
     * id范围查询时的下限
     */
    private String beginId;
    /**
     * id范围查询时的上限
     */
    private String endId;

    /**
     * 客户类型
     */
    private String clientType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 行情状态
     */
    private String hqStatus;
    /**
     * 免佣状态
     */
    private String freeStatus;
    /**
     * 注册时间
     */
    private String registerTime;

    /**
     * 入金状态
     */
    private String depositStatusD;
    /**
     * 出金状态
     */
    private String depositStatusW;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 渠道IDs
     *
     * @return
     */
    private List<String> channelIds;

    /**
     * 注册来源
     *
     * @return
     */
    private String regSourceType;

    /**
     * 最后一次登录时间
     *
     * @return
     */
    private String lastLoginTime;

    /**
     * 好友上限
     *
     * @return
     */
    private String friendLimit;

    /**
     * 注册时间区间
     */
    private String registerStartTime;
    private String registerEndTime;

    /**
     * 开户时间区间
     */
    private String openAccountStartTime;
    private String openAccountEndTime;

    private String startTime;
    private String endTime;

    /**
     * 活跃时间区间
     */
    private String lastLoginStartTime;
    private String lastLoginEndTime;

    /**
     * 注册来源标识
     */
    private String regSource;
    /**
     * 好友数量
     */
    private Integer friendCount;
    /**
     * 微信号
     */
    private String certCode;


    /**
     * 弹出菜单选择的 渠道号
     *
     * @return
     */
    private String checkedChannelId;

    /**
     * 菜单选择 多渠道号查询params
     *
     * @return
     */

    private List<String> checkedChannelIds;

    /**
     * 入金次数
     *
     * @return
     */
    private Integer depositInCount;
    /**
     * 出金次数
     *
     * @return
     */
    private Integer depositOutCount;
    /**
     * 总资产
     *
     * @return
     */
    private String totalAssets;
    /**
     * 交易次数
     *
     * @return
     */
    private Integer tradeCount;
    /**
     * 打新次数
     *
     * @return
     */
    private Integer ipoCount;


    /**
     * 免佣套餐
     */
    private String clientFareCase;

    /**
     * 首次入金时间
     *
     * @return
     */
    private String firstIncomeTime;

    /**
     * 首次交易时间
     *
     * @return
     */
    private String firstTradeTime;

    /**
     * 最近入金时间
     *
     * @return
     */
    private String nearIncomeTime;

    /**
     * 最近出金时间
     *
     * @return
     */
    private String nearOutcomeTime;

    /**
     * 最近交易时间
     *
     * @return
     */
    private String nearTradeTime;

    /**
     * 最近打新时间
     *
     * @return
     */
    private String nearIpoTime;


    /**
     * 表名
     *
     * @return
     */
    private String tableName;
    public Integer getId() {
        return id;
    }

    /**
     * 销户时间*/
    private String cancelDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
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

    public Date getOpenAccountTime() {
        return openAccountTime;
    }

    public void setOpenAccountTime(Date openAccountTime) {
        this.openAccountTime = openAccountTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInviterId() {
        return inviterId;
    }

    public void setInviterId(String inviterId) {
        this.inviterId = inviterId;
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

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public Integer getFundAccountType() {
        return fundAccountType;
    }

    public void setFundAccountType(Integer fundAccountType) {
        this.fundAccountType = fundAccountType;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
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

    public Integer getIsPassIdentityAuthentication() {
        return isPassIdentityAuthentication;
    }

    public void setIsPassIdentityAuthentication(Integer isPassIdentityAuthentication) {
        this.isPassIdentityAuthentication = isPassIdentityAuthentication;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
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

    public String getOtherBankName() {
        return otherBankName;
    }

    public void setOtherBankName(String otherBankName) {
        this.otherBankName = otherBankName;
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

    public String getCapitalSource() {
        return capitalSource;
    }

    public void setCapitalSource(String capitalSource) {
        this.capitalSource = capitalSource;
    }

    public Integer getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Integer annualIncome) {
        this.annualIncome = annualIncome;
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

    public Integer getIsAllowProvidePrivacy() {
        return isAllowProvidePrivacy;
    }

    public void setIsAllowProvidePrivacy(Integer isAllowProvidePrivacy) {
        this.isAllowProvidePrivacy = isAllowProvidePrivacy;
    }

    public Integer getIsAmlSuspicious() {
        return isAmlSuspicious;
    }

    public void setIsAmlSuspicious(Integer isAmlSuspicious) {
        this.isAmlSuspicious = isAmlSuspicious;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName;
    }

    public String getFreeEndDate() {
        return freeEndDate;
    }

    public void setFreeEndDate(String freeEndDate) {
        this.freeEndDate = freeEndDate;
    }

    public String getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(String freeCount) {
        this.freeCount = freeCount;
    }

    public String getFreeTotalTime() {
        return freeTotalTime;
    }

    public void setFreeTotalTime(String freeTotalTime) {
        this.freeTotalTime = freeTotalTime;
    }

    public String getHqEndTime() {
        return hqEndTime;
    }

    public void setHqEndTime(String hqEndTime) {
        this.hqEndTime = hqEndTime;
    }

    public String getHqCount() {
        return hqCount;
    }

    public void setHqCount(String hqCount) {
        this.hqCount = hqCount;
    }

    public String getHqTotalTime() {
        return hqTotalTime;
    }

    public void setHqTotalTime(String hqTotalTime) {
        this.hqTotalTime = hqTotalTime;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getDepositCount() {
        return depositCount;
    }

    public void setDepositCount(String depositCount) {
        this.depositCount = depositCount;
    }

    public String getDepositTime() {
        return depositTime;
    }

    public void setDepositTime(String depositTime) {
        this.depositTime = depositTime;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
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

    public String getOpenAccountCount() {
        return openAccountCount;
    }

    public void setOpenAccountCount(String openAccountCount) {
        this.openAccountCount = openAccountCount;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
        this.groupNo = groupNo;
    }

    public String getBeginId() {
        return beginId;
    }

    public void setBeginId(String beginId) {
        this.beginId = beginId;
    }

    public String getEndId() {
        return endId;
    }

    public void setEndId(String endId) {
        this.endId = endId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHqStatus() {
        return hqStatus;
    }

    public void setHqStatus(String hqStatus) {
        this.hqStatus = hqStatus;
    }

    public String getFreeStatus() {
        return freeStatus;
    }

    public void setFreeStatus(String freeStatus) {
        this.freeStatus = freeStatus;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getDepositStatusD() {
        return depositStatusD;
    }

    public void setDepositStatusD(String depositStatusD) {
        this.depositStatusD = depositStatusD;
    }

    public String getDepositStatusW() {
        return depositStatusW;
    }

    public void setDepositStatusW(String depositStatusW) {
        this.depositStatusW = depositStatusW;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public List<String> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<String> channelIds) {
        this.channelIds = channelIds;
    }

    public String getRegSourceType() {
        return regSourceType;
    }

    public void setRegSourceType(String regSourceType) {
        this.regSourceType = regSourceType;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getFriendLimit() {
        return friendLimit;
    }

    public void setFriendLimit(String friendLimit) {
        this.friendLimit = friendLimit;
    }

    public String getRegisterStartTime() {
        return registerStartTime;
    }

    public void setRegisterStartTime(String registerStartTime) {
        this.registerStartTime = registerStartTime;
    }

    public String getRegisterEndTime() {
        return registerEndTime;
    }

    public void setRegisterEndTime(String registerEndTime) {
        this.registerEndTime = registerEndTime;
    }

    public String getOpenAccountStartTime() {
        return openAccountStartTime;
    }

    public void setOpenAccountStartTime(String openAccountStartTime) {
        this.openAccountStartTime = openAccountStartTime;
    }

    public String getOpenAccountEndTime() {
        return openAccountEndTime;
    }

    public void setOpenAccountEndTime(String openAccountEndTime) {
        this.openAccountEndTime = openAccountEndTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLastLoginStartTime() {
        return lastLoginStartTime;
    }

    public void setLastLoginStartTime(String lastLoginStartTime) {
        this.lastLoginStartTime = lastLoginStartTime;
    }

    public String getLastLoginEndTime() {
        return lastLoginEndTime;
    }

    public void setLastLoginEndTime(String lastLoginEndTime) {
        this.lastLoginEndTime = lastLoginEndTime;
    }

    public String getRegSource() {
        return regSource;
    }

    public void setRegSource(String regSource) {
        this.regSource = regSource;
    }

    public Integer getFriendCount() {
        return friendCount;
    }

    public void setFriendCount(Integer friendCount) {
        this.friendCount = friendCount;
    }

    public String getCertCode() {
        return certCode;
    }

    public void setCertCode(String certCode) {
        this.certCode = certCode;
    }

    public String getCheckedChannelId() {
        return checkedChannelId;
    }

    public void setCheckedChannelId(String checkedChannelId) {
        this.checkedChannelId = checkedChannelId;
    }

    public List<String> getCheckedChannelIds() {
        return checkedChannelIds;
    }

    public void setCheckedChannelIds(List<String> checkedChannelIds) {
        this.checkedChannelIds = checkedChannelIds;
    }

    public Integer getDepositInCount() {
        return depositInCount;
    }

    public void setDepositInCount(Integer depositInCount) {
        this.depositInCount = depositInCount;
    }

    public Integer getDepositOutCount() {
        return depositOutCount;
    }

    public void setDepositOutCount(Integer depositOutCount) {
        this.depositOutCount = depositOutCount;
    }

    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    public Integer getIpoCount() {
        return ipoCount;
    }

    public void setIpoCount(Integer ipoCount) {
        this.ipoCount = ipoCount;
    }

    public String getClientFareCase() {
        return clientFareCase;
    }

    public void setClientFareCase(String clientFareCase) {
        this.clientFareCase = clientFareCase;
    }

    public String getFirstIncomeTime() {
        return firstIncomeTime;
    }

    public void setFirstIncomeTime(String firstIncomeTime) {
        this.firstIncomeTime = firstIncomeTime;
    }

    public String getFirstTradeTime() {
        return firstTradeTime;
    }

    public void setFirstTradeTime(String firstTradeTime) {
        this.firstTradeTime = firstTradeTime;
    }

    public String getNearIncomeTime() {
        return nearIncomeTime;
    }

    public void setNearIncomeTime(String nearIncomeTime) {
        this.nearIncomeTime = nearIncomeTime;
    }

    public String getNearOutcomeTime() {
        return nearOutcomeTime;
    }

    public void setNearOutcomeTime(String nearOutcomeTime) {
        this.nearOutcomeTime = nearOutcomeTime;
    }

    public String getNearTradeTime() {
        return nearTradeTime;
    }

    public void setNearTradeTime(String nearTradeTime) {
        this.nearTradeTime = nearTradeTime;
    }

    public String getNearIpoTime() {
        return nearIpoTime;
    }

    public void setNearIpoTime(String nearIpoTime) {
        this.nearIpoTime = nearIpoTime;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getOtherNationality() {
        return otherNationality;
    }

    public void setOtherNationality(String otherNationality) {
        this.otherNationality = otherNationality;
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

    public String getFamilyRepublicName() {
        return familyRepublicName;
    }

    public void setFamilyRepublicName(String familyRepublicName) {
        this.familyRepublicName = familyRepublicName;
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

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
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

    public Integer getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(Integer roomCode) {
        this.roomCode = roomCode;
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
}
