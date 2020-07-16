package com.sunline.modules.account.online.helper;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.entity.OpenAccountOtherDisclosureEntity;
import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;
import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;
import com.sunline.modules.account.online.manager.CustomerAccountOpenManager;
import com.sunline.modules.account.online.protocol.OtherAccountDetailInfo;
import com.sunline.modules.account.online.protocol.OwnerOfAccountDetail;
import com.sunline.modules.account.online.service.*;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.PdfOperater;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * @author LiYangFeng
 * @createDate 2017/3/3
 * @description
 * @email justbelyf@gmail.com
 */
@Component("customerAccountOpenReportGenerate")
public class CustomerAccOpenReportGenerate {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerAccOpenReportGenerate.class);
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccountOpenManager customerAccountOpenManager;
    @Autowired
    OpenAccountTaxationInfoService openAccountTaxationInfoService;
    @Autowired
    OpenAccountOtherDisclosureService openAccountOtherDisclosureService;
    @Autowired
    OpenAccountPropertyTypeService openAccountPropertyTypeService;

//    public enum ReportType {
//        USER_FORM_REPORT, // 开户报表
//        USER_W8_REPORT,   // W8报表
//        USER_SELF_PROVE_REPORT, // 自我证明报表
//        USER_SELF_CERTIFICATION_ON_US_REPORT // 美国公民身份证明报表
//    }

    /**
     * @param customerAccountOpenInfoId
     * @return 文件URI
     */
    public String generateReport(String customerAccountOpenInfoId, BpmCommonEnum.AccountOpenReport reportType) {
        if (null == reportType || null == customerAccountOpenInfoId) {
            return null;
        }

        Map<String, Object> reportData = loadAllReportData(customerAccountOpenInfoId, reportType);

        if (!reportData.isEmpty()) {
            String pdfFilePath = makeOutputPath(customerAccountOpenInfoId, reportType);
            if (PdfOperater.fillFile(getReportTemplatePathByReportType(reportType), pdfFilePath, reportData)) {
                return pdfFilePath;
            }
        }

        return null;
    }


    /**
     * 加载报表需要的数据集
     *
     * @param customerAccountOpenInfoId
     * @param reportType
     * @return
     */
    public Map<String, Object> loadAllReportData(String customerAccountOpenInfoId, BpmCommonEnum.AccountOpenReport reportType) {
        Map<String, Object> reportData = getUserOpenAccountInfo(customerAccountOpenInfoId);
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = customerAccountOpenInfoService.queryObject(customerAccountOpenInfoId);
        try {
            if (reportData.isEmpty()) {
                return reportData;
            }

            if (null != reportData.get("otherAccountDetailInfo") && StringUtils.isNoneBlank(reportData.get("otherAccountDetailInfo").toString())) {
                List<OtherAccountDetailInfo> ownerOfAccountsDetail = JSON.parseArray(reportData.get("otherAccountDetailInfo").toString(), OtherAccountDetailInfo.class);
                StringBuilder otherAccountsDetail = new StringBuilder();
                for (OtherAccountDetailInfo otherAccountDetailInfo : ownerOfAccountsDetail) {
                    otherAccountsDetail.append("银行名称:").append(otherAccountDetailInfo.getBankName())
                            .append(",").append("账号：").append(otherAccountDetailInfo.getAccountNumber()).append(";");
                }
                reportData.put("otherAccountDetailInfo", otherAccountsDetail.toString());
            }

            if (null != reportData.get("ownerOfAccountDetail") && StringUtils.isNoneBlank(reportData.get("ownerOfAccountDetail").toString())) {
                List<OwnerOfAccountDetail> ownerOfAccountsDetail = JSON.parseArray(reportData.get("ownerOfAccountDetail").toString(), OwnerOfAccountDetail.class);
                StringBuilder ownerOfAccountDetail = new StringBuilder();
                for (OwnerOfAccountDetail ownerOfAccountDetail1 : ownerOfAccountsDetail) {
                    ownerOfAccountDetail.append("姓名:").append(ownerOfAccountDetail1.getOwnName())
                            .append(",").append("地址：").append(ownerOfAccountDetail1.getOwnAddress()).append(";");
                }
                reportData.put("ownerOfAccountDetail", ownerOfAccountDetail.toString());
            }
            if ("1".equals(reportData.get("is_clerk_relation"))) {
                String clerkDetailInfo = "姓名：" + reportData.get("relatedClerkName") + ";   " + "关系：" + reportData.get("clerk_relation_info");
                reportData.put("clerkDetailInfo", clerkDetailInfo);
            }


            String userSignImage = customerAccountOpenManager.getAccountOpenCustomerSignImage(customerAccountOpenInfoId);
            if (null != userSignImage && StringUtils.isNoneBlank(userSignImage)) {
                reportData.put("signImage", userSignImage);
                reportData.put("signImageFatca", userSignImage);
            }


            contentSpecialHandling(reportData, reportType);
        } catch (Exception e) {
            LOGGER.error("报表生成错误:" + reportType, e);
        }

        return reportData;
    }


    /**
     * 根据报表类型做特殊处理
     *
     * @param values
     * @param reportType
     */
    private void contentSpecialHandling(Map<String, Object> values, BpmCommonEnum.AccountOpenReport reportType) {
        try {
            switch (reportType) {
                case ACCOUNT_OPEN_REPORT_USER_FORM_REPORT:
                    values.put("birthday", DateFormatUtils.format(DateUtil.parseDate(values.get("birthday").toString()), "dd/MM/yyyy"));
//                values.put("applicationTime", DateFormatUtils.format(new Date(values.get("applicationTime").toString()),"yyyy-MM-dd"));
                    if (null != values.get("investTarget")) {
                        for (String value : JSON.parseArray(values.get("investTarget").toString(), String.class)) {
                            values.put("investTarget" + "_" + value, value);
                        }
                    }

                    if (null != values.get("capitalSource")) {
                        for (String value : JSON.parseArray(values.get("capitalSource").toString(), String.class)) {
                            values.put("capitalSource_" + value, value);
                        }
                    }

                    //转译所属行业  职位信息
                    values.put("professionTypeName", values.get("professionType") != null ? CodeUtils.getCodeName("AO_OCCUPATION_TYPE", values.get("professionType").toString()) : "");
                    values.put("jobPositionName", values.get("jobPosition") != null ? CodeUtils.getCodeName("AO_JOB_POSITION", values.get("jobPosition").toString()) : "");


                    //财产种类
                    List<OpenAccountPropertyTypeEntity> openAccountPropertyTypeList = openAccountPropertyTypeService.queryByApplicationId(values.get("applicationId").toString());
                    for (int i = 0; i < openAccountPropertyTypeList.size(); i++) {
                        StringBuffer typeAmountCode = new StringBuffer("AO_PROPERTY_TYPE_");
                        values.put("propertyType_" + (openAccountPropertyTypeList.get(i).getPropertyType() != null ? openAccountPropertyTypeList.get(i).getPropertyType() : ""), openAccountPropertyTypeList.get(i).getPropertyType() != null ? openAccountPropertyTypeList.get(i).getPropertyType().toString() : "");

                        values.put("propertyTypeAmount_" + (openAccountPropertyTypeList.get(i).getPropertyType() != null ? openAccountPropertyTypeList.get(i).getPropertyType() : ""), openAccountPropertyTypeList.get(i).getPropertyAmount() != null ? openAccountPropertyTypeList.get(i).getPropertyAmount() : "");
                    }

                    //其他资料披露
                    List<OpenAccountOtherDisclosureEntity> openAccountOtherDisclosureList = openAccountOtherDisclosureService.queryByApplicationId(values.get("applicationId").toString());
                    for (int i = 0; i < openAccountOtherDisclosureList.size(); i++) {
                        values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : ""), openAccountOtherDisclosureList.get(i).getDisclosureIsTrue() != null ? openAccountOtherDisclosureList.get(i).getDisclosureIsTrue() : "");

                        values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure1",
                                openAccountOtherDisclosureList.get(i).getDisclosure1() != null ? openAccountOtherDisclosureList.get(i).getDisclosure1() : "");
                        values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure2",
                                openAccountOtherDisclosureList.get(i).getDisclosure2() != null ? openAccountOtherDisclosureList.get(i).getDisclosure2() : "");
                        values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure3",
                                openAccountOtherDisclosureList.get(i).getDisclosure3() != null ? openAccountOtherDisclosureList.get(i).getDisclosure3() : "");
                        values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure4",
                                openAccountOtherDisclosureList.get(i).getDisclosure4() != null ? openAccountOtherDisclosureList.get(i).getDisclosure4() : "");

                        if (openAccountOtherDisclosureList.get(i).getDisclosureCode() == 15) {
                            String[] disclosure1 = openAccountOtherDisclosureList.get(i).getDisclosure1() != null ? openAccountOtherDisclosureList.get(i).getDisclosure1().split(",") : new String[]{};
                            String[] disclosure2 = openAccountOtherDisclosureList.get(i).getDisclosure2() != null ? openAccountOtherDisclosureList.get(i).getDisclosure2().split(",") : new String[]{};
                            String[] disclosure3 = openAccountOtherDisclosureList.get(i).getDisclosure3() != null ? openAccountOtherDisclosureList.get(i).getDisclosure3().split(",") : new String[]{};
                            String[] disclosure4 = openAccountOtherDisclosureList.get(i).getDisclosure4() != null ? openAccountOtherDisclosureList.get(i).getDisclosure4().split(",") : new String[]{};

                            for (int j = 0; j < disclosure1.length; j++) {
                                values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure1_" + (j + 1), disclosure1[j]);
                            }

                            for (int j = 0; j < disclosure2.length; j++) {
                                values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure2_" + (j + 1), disclosure2[j]);
                            }

                            for (int j = 0; j < disclosure3.length; j++) {
                                values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure3_" + (j + 1), disclosure3[j]);
                            }

                            for (int j = 0; j < disclosure4.length; j++) {
                                values.put("otherInfoCode_" + (openAccountOtherDisclosureList.get(i).getDisclosureCode() != null ? openAccountOtherDisclosureList.get(i).getDisclosureCode() : "") + "_disclosure4_" + (j + 1), disclosure4[j]);
                            }
                        }

                        StringBuffer nameJoinDetailStr = new StringBuffer();
                        if (null != openAccountOtherDisclosureList.get(i).getDisclosure1() &&
                                !"".equals(openAccountOtherDisclosureList.get(i).getDisclosure1())) {
                            String[] nameArray = openAccountOtherDisclosureList.get(i).getDisclosure1().split(",");
                            if (openAccountOtherDisclosureList.get(i).getDisclosure2() != null && !"".equals(openAccountOtherDisclosureList.get(i).getDisclosure2())) {
                                String[] detailArray = openAccountOtherDisclosureList.get(i).getDisclosure2().split(",");
                                for (int j = 0; j < nameArray.length; j++) {
                                    nameJoinDetailStr.append(nameArray[j]);
                                    if (null != detailArray[j]) {
                                        nameJoinDetailStr.append(",").append(detailArray[j]).append(";");
                                    } else {
                                        nameJoinDetailStr.append(";");
                                    }
                                }
                            } else {
                                for (int j = 0; j < nameArray.length; j++) {
                                    nameJoinDetailStr.append(nameArray[j]);
                                }
                            }

                            values.put("otherInfoName_" + openAccountOtherDisclosureList.get(i).getDisclosureCode(), nameJoinDetailStr.toString());
                        }
                    }

                    //税务信息
                    List<OpenAccountTaxationInfoEntity> taxationInfoList = openAccountTaxationInfoService.queryByApplicationId(values.get("applicationId").toString());
                    for (int i = 0; i < taxationInfoList.size(); i++) {
                        values.put("taxCountry_" + i, taxationInfoList.get(i).getTaxCountry() != null ? taxationInfoList.get(i).getTaxCountry() : "");
                        values.put("taxNumber_" + i, taxationInfoList.get(i).getTaxNumber() != null ? taxationInfoList.get(i).getTaxNumber() : "");
                        values.put("reasonType_" + i, taxationInfoList.get(i).getReasonType() != null ? CodeUtils.getCodeName("AO_REASON_TYPE", taxationInfoList.get(i).getReasonType()) : "");
                        values.put("reasonDesc_" + i, taxationInfoList.get(i).getReasonDesc() != null ? taxationInfoList.get(i).getReasonDesc() : "");

                        String taxNumber = "";
                        if (taxationInfoList.get(i).getHasTaxNumber() == 1) {
                            taxNumber = taxationInfoList.get(i).getTaxNumber() != null ? taxationInfoList.get(i).getTaxNumber() : "";
                        } else {
                            taxNumber = !"B".equals(taxationInfoList.get(i).getReasonType()) ? taxationInfoList.get(i).getReasonType() : taxationInfoList.get(i).getReasonType() + "-" + taxationInfoList.get(i).getReasonDesc();
                        }

                        values.put("taxNumber_" + i, taxNumber);
                    }

                    break;
                case ACCOUNT_OPEN_REPORT_USER_W8_REPORT:
                    values.put("birthday", DateFormatUtils.format(DateUtil.parseDate(values.get("birthday").toString()), "MM-dd-yyyy"));
                    values.put("applicationTime", DateUtil.format(DateUtil.parse(values.get("applicationTime").toString(), "yyyy-MM-dd"), "MM-dd-yyyy"));

                    // 通讯地址转义
                    StringBuilder contactDetailAddress1 = new StringBuilder();
                    StringBuilder contactDetailAddress2 = new StringBuilder();

                    if (null != values.get("contactRepublicName") && StringUtils.isNoneBlank(values.get("contactRepublicName").toString())) {
                        contactDetailAddress1.append(values.get("contactRepublicName"));
                    }
                    if (null != values.get("provinceName") && StringUtils.isNoneBlank(values.get("provinceName").toString())) {
                        contactDetailAddress1.append(values.get("provinceName"));
                    }
                    if (null != values.get("cityName") && StringUtils.isNoneBlank(values.get("cityName").toString())) {
                        contactDetailAddress1.append(values.get("cityName"));
                    }
                    if (null != values.get("countyName") && StringUtils.isNoneBlank(values.get("countyName").toString())) {
                        contactDetailAddress1.append(values.get("countyName"));
                    }

                    if (null != values.get("detailAddress") && StringUtils.isNoneBlank(values.get("detailAddress").toString())) {
                        contactDetailAddress2.append(values.get("detailAddress"));
                    }

                    String contactDetailAddressEn1 = PinyinHelper.convertToPinyinString(contactDetailAddress1.toString(), " ", PinyinFormat.WITHOUT_TONE);
                    values.put("contactDetailAddress1", contactDetailAddressEn1);

                    String contactDetailAddressEn2 = PinyinHelper.convertToPinyinString(contactDetailAddress2.toString(), " ", PinyinFormat.WITHOUT_TONE);
                    values.put("contactDetailAddress2", contactDetailAddressEn2);

                    // 住宅地址转义
                    StringBuilder familyDetailAddress1 = new StringBuilder();
                    StringBuilder familyDetailAddress2 = new StringBuilder();

                    if (null != values.get("familyRepublicName") && StringUtils.isNoneBlank(values.get("familyRepublicName").toString())) {
                        familyDetailAddress1.append(values.get("familyRepublicName"));
                    }
                    if (null != values.get("familyProvinceName") && StringUtils.isNoneBlank(values.get("familyProvinceName").toString())) {
                        familyDetailAddress1.append(values.get("familyProvinceName"));
                    }
                    if (null != values.get("familyCityName") && StringUtils.isNoneBlank(values.get("familyCityName").toString())) {
                        familyDetailAddress1.append(values.get("familyCityName"));
                    }
                    if (null != values.get("familyCountyName") && StringUtils.isNoneBlank(values.get("familyCountyName").toString())) {
                        familyDetailAddress1.append(values.get("familyCountyName"));
                    }

                    if (null != values.get("familyDetailAddress") && StringUtils.isNoneBlank(values.get("familyDetailAddress").toString())) {
                        familyDetailAddress2.append(values.get("familyDetailAddress"));
                    }

                    String familyDetailAddressEn1 = PinyinHelper.convertToPinyinString(familyDetailAddress1.toString(), " ", PinyinFormat.WITHOUT_TONE);
                    values.put("familyDetailAddress1", familyDetailAddressEn1);

                    String familyDetailAddressEn2 = PinyinHelper.convertToPinyinString(familyDetailAddress2.toString(), " ", PinyinFormat.WITHOUT_TONE);
                    values.put("familyDetailAddress2", familyDetailAddressEn2);

//                    // 国家英文
//                    if ("OTH".equals(values.get("familyRepublicName").toString())) {
//                        values.put("familyNationalityEnligish", values.get("otherFamilyRepublic") != null ? values.get("otherFamilyRepublic").toString() : "");
//                    } else {
//                        values.put("familyNationalityEnligish", values.get("familyRepublicName") != null ? CodeUtils.getCodeName("AO_NATIONALITY_ENGLISH", values.get("familyRepublicName").toString()) : "");
//                    }
//
//                    if ("OTH".equals(values.get("contactRepublicName").toString())) {
//                        values.put("nationalityEnligish", values.get("otherContactRepublic") != null ? values.get("otherContactRepublic").toString() : "");
//                    } else {
//                        values.put("nationalityEnligish", values.get("contactRepublicName") != null ? CodeUtils.getCodeName("AO_NATIONALITY_ENGLISH", values.get("contactRepublicName").toString()) : "");
//                    }

                    break;
                case ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT:
                    values.put("birthday", DateFormatUtils.format(DateUtil.parseDate(values.get("birthday").toString()), "dd/MM/yyyy"));
                    values.put("applicationTime", DateUtil.format(DateUtil.parse(values.get("applicationTime").toString(), "yyyy-MM-dd"), "dd/MM/yyyy"));

                    if (StringUtils.isBlank(values.get("familyName").toString())) {
                        values.put("familyName", values.get("familyNameSpell").toString());
                    }

                    if (StringUtils.isBlank(values.get("givenName").toString())) {
                        values.put("givenName", values.get("givenNameSpell").toString());
                    }

                    //税务信息
                    List<OpenAccountTaxationInfoEntity> openAccountTaxationInfoList = openAccountTaxationInfoService.queryByApplicationId(values.get("applicationId").toString());
                    for (int i = 0; i < openAccountTaxationInfoList.size(); i++) {
                        values.put("taxCountry_" + i, openAccountTaxationInfoList.get(i).getTaxCountry() != null ? openAccountTaxationInfoList.get(i).getTaxCountry() : "");
                        values.put("taxNumber_" + i, openAccountTaxationInfoList.get(i).getTaxNumber() != null ? openAccountTaxationInfoList.get(i).getTaxNumber() : "");
                        values.put("reasonType_" + i, openAccountTaxationInfoList.get(i).getReasonType() != null ? CodeUtils.getCodeName("AO_REASON_TYPE", openAccountTaxationInfoList.get(i).getReasonType().toString()) : "");
                        values.put("reasonDesc_" + i, openAccountTaxationInfoList.get(i).getReasonDesc() != null ? openAccountTaxationInfoList.get(i).getReasonDesc() : "");
                    }


                    break;
                case ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT:
//                values.put("applicationTime", DateFormatUtils.format(new Date(values.get("applicationTime").toString()),"yyyy-MM-dd"));
                    if (values.containsKey("signImage")) {
                        values.put("signImage2", values.get("signImage"));
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            LOGGER.error("报表数据填充错误", e);
        }
    }

    /**
     * 根据报表类型获取获取相应模板路径
     *
     * @return
     */
    private String getReportTemplatePathByReportType(BpmCommonEnum.AccountOpenReport reportType) {
        String reportTemplatePath = null;
//        String contextRoot = protitesMap.get("项目路径");
        String contextRoot = ConfigUtils.get("openAccount.user.report.rootPath");
        switch (reportType) {
            case ACCOUNT_OPEN_REPORT_USER_FORM_REPORT:
                reportTemplatePath = ConfigUtils.get("openAccount.user.report.userForm.template");
//                reportTemplatePath = "account_opening_application_form_individual_template.pdf";
                break;
            case ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT:
                reportTemplatePath = ConfigUtils.get("openAccount.user.report.user.selfProve.template");
//                reportTemplatePath = "account_opening_self_prove.pdf";
                break;
            case ACCOUNT_OPEN_REPORT_USER_W8_REPORT:
                reportTemplatePath = ConfigUtils.get("openAccount.user.report.user.w8.template");
//                reportTemplatePath = "W8.pdf";
                break;
            case ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT:
                reportTemplatePath = ConfigUtils.get("openAccount.user.report.user.certification.on.us.template");
//                reportTemplatePath = "self_certification_on_us.pdf";
                break;
            default:
                break;
        }

        if (null == reportTemplatePath) {
            throw new UnsupportedOperationException("无法获取报表模板信息");
        }

        return contextRoot + "/" + reportTemplatePath;
    }


    /**
     * 生成报表输出路径
     *
     * @param customerAccountOpenInfoId
     * @param reportType
     * @return
     */
    public String makeOutputPath(String customerAccountOpenInfoId, BpmCommonEnum.AccountOpenReport reportType) {
        StringBuilder outPutPath = new StringBuilder(getAccountOpenUserReportRootPath(customerAccountOpenInfoId));

        switch (reportType) {
            case ACCOUNT_OPEN_REPORT_USER_FORM_REPORT:
                outPutPath.append("开户表格.pdf");
                break;
            case ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT:
                outPutPath.append("自我证明表格-个人.pdf");
                break;
            case ACCOUNT_OPEN_REPORT_USER_W8_REPORT:
                outPutPath.append("W8.pdf");
                break;
            case ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT:
                outPutPath.append("有关美国公民身份证明书.pdf");
                break;
            default:
                break;
        }

        return outPutPath.toString();
    }


    public static String getAccountOpenUserReportRootPath(String customerAccountOpenInfoId) {

        return ConfigUtils.get("openAccount.user.report.userForm") + customerAccountOpenInfoId + "/";
    }


    private Map<String, Object> getUserOpenAccountInfo(String id) {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = customerAccountOpenInfoService.queryObject(id);
        Map<String, Object> reportData = Maps.newHashMap();
//        reportData.put("registeredPersonName", customerAccountOpenInfoEntity.getFamilyName());
//        reportData.put("contact_address", customerAccountOpenInfoEntity.getIdCardAddress());
//        reportData.put("contact_address_cn", customerAccountOpenInfoEntity.getIdCardAddress());
//        reportData.put("birthday", customerAccountOpenInfoEntity.getBirthday());
//        reportData.put("sex", customerAccountOpenInfoEntity.getSex());
//        reportData.put("profession_code", customerAccountOpenInfoEntity.getProfessionCode());
//        reportData.put("job_position", customerAccountOpenInfoEntity.getJobPosition());
//        reportData.put("invest_target", customerAccountOpenInfoEntity.getInvestTarget());
//        reportData.put("isTradedDerivativeProducts", customerAccountOpenInfoEntity.getIsTradedDerivativeProducts());
//        reportData.put("company_name", customerAccountOpenInfoEntity.getCompanyName());
//        reportData.put("companyPhoneNumber", customerAccountOpenInfoEntity.getCompanyPhoneNumber());
//        reportData.put("income", customerAccountOpenInfoEntity.getAnnualIncome());
//        reportData.put("isKnowDerivativeProducts", customerAccountOpenInfoEntity.getIsKnowDerivativeProducts());
//        reportData.put("industry_range", customerAccountOpenInfoEntity.getIndustryRange());
//        reportData.put("e_mail", customerAccountOpenInfoEntity.getEmail());
//        reportData.put("contact_address", customerAccountOpenInfoEntity.getIdCardAddress());
//        reportData.put("client_name", customerAccountOpenInfoEntity.getClientNameSpell());
//        reportData.put("derivativeProductsStudyTypeOther", customerAccountOpenInfoEntity.getDerivativeProductsStudyTypeOther());
//        reportData.put("client_name_cn", customerAccountOpenInfoEntity.getClientName());
//        reportData.put("financingInstitutionWorkExperienceType", customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceType());
//        reportData.put("derivativeProductsStudyType", customerAccountOpenInfoEntity.getDerivativeProductsStudyType());
//        reportData.put("invest_target_other", customerAccountOpenInfoEntity.getInvestTargetOther());
//        reportData.put("mobile_tel", customerAccountOpenInfoEntity.getPhoneNumber());
//        reportData.put("futuresInvestmentExperienceType", customerAccountOpenInfoEntity.getFuturesInvestmentExperienceType());
//        reportData.put("id_no", customerAccountOpenInfoEntity.getIdNo());
//        reportData.put("create_date", customerAccountOpenInfoEntity.getApplicationTime());
//        reportData.put("firstName", customerAccountOpenInfoEntity.getFamilyName());
//        reportData.put("lastName", customerAccountOpenInfoEntity.getGivenName());
//        reportData.put("nationality", customerAccountOpenInfoEntity.getNationality());
//        reportData.put("province_id", customerAccountOpenInfoEntity.getContactProvinceName());
//        reportData.put("city_id", customerAccountOpenInfoEntity.getContactCityName());
//        reportData.put("county_id", customerAccountOpenInfoEntity.getContactCountyName());
//        reportData.put("detailAddress", customerAccountOpenInfoEntity.getContactDetailAddress());

        reportData.put("id", customerAccountOpenInfoEntity.getId());
        reportData.put("applicationId", customerAccountOpenInfoEntity.getApplicationId());
        reportData.put("openAccountType", customerAccountOpenInfoEntity.getOpenAccountType());
        reportData.put("openAccountAccessWay", customerAccountOpenInfoEntity.getOpenAccountAccessWay());
        reportData.put("fundAccountType", customerAccountOpenInfoEntity.getFundAccountType());
        reportData.put("sourceChannelId", customerAccountOpenInfoEntity.getSourceChannelId());
        reportData.put("sourceChannelName", customerAccountOpenInfoEntity.getSourceChannelName());
        reportData.put("userId", customerAccountOpenInfoEntity.getUserId());
        reportData.put("inviterId", customerAccountOpenInfoEntity.getInviterId());
        reportData.put("clientId", customerAccountOpenInfoEntity.getClientId());
        reportData.put("fundAccount", customerAccountOpenInfoEntity.getFundAccount());
        reportData.put("clientName", customerAccountOpenInfoEntity.getClientName());
        reportData.put("familyName", customerAccountOpenInfoEntity.getFamilyName());
        reportData.put("givenName", customerAccountOpenInfoEntity.getGivenName());

        reportData.put("familyNameSpell", customerAccountOpenInfoEntity.getFamilyNameSpell());
        reportData.put("givenNameSpell", customerAccountOpenInfoEntity.getGivenNameSpell());

        reportData.put("clientNameSpell", customerAccountOpenInfoEntity.getClientNameSpell());
        // 香港临时身份证处理
        reportData.put("idKind", customerAccountOpenInfoEntity.getIdKind());
        reportData.put("idNo", customerAccountOpenInfoEntity.getIdNo());
        reportData.put("sex", customerAccountOpenInfoEntity.getSex());
        reportData.put("birthday", customerAccountOpenInfoEntity.getBirthday());
        reportData.put("idCardAddress", customerAccountOpenInfoEntity.getIdCardAddress());
        reportData.put("idCardValidDateStart", customerAccountOpenInfoEntity.getIdCardValidDateStart());
        reportData.put("idCardValidDateEnd", customerAccountOpenInfoEntity.getIdCardValidDateEnd());
        reportData.put("identitySimilarityPercent", customerAccountOpenInfoEntity.getIdentitySimilarityPercent());
        reportData.put("isPassIdentityAuthentication", customerAccountOpenInfoEntity.getIsPassIdentityAuthentication());
        reportData.put("bankId", customerAccountOpenInfoEntity.getBankId());
        reportData.put("bankNo", customerAccountOpenInfoEntity.getBankNo());
        reportData.put("bankAccountName", customerAccountOpenInfoEntity.getBankAccountName());
        reportData.put("nationality", customerAccountOpenInfoEntity.getNationality());
        reportData.put("isAmericanGreenCardHolder", customerAccountOpenInfoEntity.getIsAmericanGreenCardHolder());
        reportData.put("contactProvinceName", customerAccountOpenInfoEntity.getContactProvinceName());
        reportData.put("contactCityName", customerAccountOpenInfoEntity.getContactCityName());
        reportData.put("contactCountyName", customerAccountOpenInfoEntity.getContactCountyName());
        reportData.put("contactDetailAddress", customerAccountOpenInfoEntity.getContactDetailAddress());
        reportData.put("contactDetailAddressFull", customerAccountOpenInfoEntity.getContactCountyName() + customerAccountOpenInfoEntity.getContactDetailAddress());
        reportData.put("familyAddress", customerAccountOpenInfoEntity.getFamilyAddress());
        reportData.put("email", customerAccountOpenInfoEntity.getEmail());
        reportData.put("contactAddress", customerAccountOpenInfoEntity.getContactAddress());
        reportData.put("phoneNumber", customerAccountOpenInfoEntity.getPhoneNumber());
//        reportData.put("professionCode", customerAccountOpenInfoEntity.getProfessionCode() != null ? CodeUtils.getCodeName("AO_PROFESSION_CODE", String.valueOf(customerAccountOpenInfoEntity.getProfessionCode())) : "");
        reportData.put("professionCode", customerAccountOpenInfoEntity.getProfessionCode());
        reportData.put("professionType", customerAccountOpenInfoEntity.getProfessionType());
        reportData.put("companyName", customerAccountOpenInfoEntity.getCompanyName());
        reportData.put("companyAddress", customerAccountOpenInfoEntity.getCompanyAddress());
        reportData.put("companyPhoneNumber", customerAccountOpenInfoEntity.getCompanyPhoneNumber());
        reportData.put("jobPosition", customerAccountOpenInfoEntity.getJobPosition());
        reportData.put("industryRange", customerAccountOpenInfoEntity.getIndustryRange());
        reportData.put("capitalSource", customerAccountOpenInfoEntity.getCapitalSource());
        reportData.put("annualIncome", customerAccountOpenInfoEntity.getAnnualIncome());
        reportData.put("investTarget", customerAccountOpenInfoEntity.getInvestTarget());
        reportData.put("investTargetOther", customerAccountOpenInfoEntity.getInvestTargetOther());
        reportData.put("stocksInvestmentExperienceType", customerAccountOpenInfoEntity.getStocksInvestmentExperienceType());
        reportData.put("warrantsInvestmentExperienceType", customerAccountOpenInfoEntity.getWarrantsInvestmentExperienceType());
        reportData.put("futuresInvestmentExperienceType", customerAccountOpenInfoEntity.getFuturesInvestmentExperienceType());
        reportData.put("isKnowDerivativeProducts", customerAccountOpenInfoEntity.getIsKnowDerivativeProducts());
        reportData.put("derivativeProductsStudyType", customerAccountOpenInfoEntity.getDerivativeProductsStudyType());
        reportData.put("derivativeProductsStudyTypeOther", customerAccountOpenInfoEntity.getDerivativeProductsStudyTypeOther());
        reportData.put("financingInstitutionWorkExperienceType", customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceType());
        reportData.put("financingInstitutionWorkExperienceTypeOther", customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceTypeOther());
        reportData.put("isTradedDerivativeProducts", customerAccountOpenInfoEntity.getIsTradedDerivativeProducts());
        reportData.put("isOpenUsaStockMarket", customerAccountOpenInfoEntity.getIsOpenUsaStockMarket());
        reportData.put("isOpenHkStockMarket", customerAccountOpenInfoEntity.getIsOpenHkStockMarket());
        reportData.put("isAllowProvidePrivacy", customerAccountOpenInfoEntity.getIsAllowProvidePrivacy());
        reportData.put("isAmlSuspicious", customerAccountOpenInfoEntity.getIsAmlSuspicious());
        reportData.put("isAllowDerivativesTransaction", customerAccountOpenInfoEntity.getIsAllowDerivativesTransaction());
        reportData.put("initialAccountPassword", customerAccountOpenInfoEntity.getInitialAccountPassword());
        reportData.put("applicationTime", DateUtil.format(customerAccountOpenInfoEntity.getApplicationTime(), "yyyy-MM-dd"));
        reportData.put("recordStatus", customerAccountOpenInfoEntity.getRecordStatus());
        reportData.put("openAccountBankVerityList", customerAccountOpenInfoEntity.getOpenAccountBankVerityList());
        reportData.put("propertyTypeList", customerAccountOpenInfoEntity.getPropertyTypeList());
        reportData.put("otherDisclosureList", customerAccountOpenInfoEntity.getOtherDisclosureList());
        reportData.put("taxationInfoList", customerAccountOpenInfoEntity.getTaxationInfoList());
        reportData.put("openAccountImagesInfo", customerAccountOpenInfoEntity.getOpenAccountImagesInfo());
        reportData.put("bankType", customerAccountOpenInfoEntity.getBankType());
        reportData.put("provinceName", customerAccountOpenInfoEntity.getContactProvinceName());
        reportData.put("cityName", customerAccountOpenInfoEntity.getContactCityName());
        reportData.put("countyName", customerAccountOpenInfoEntity.getContactCountyName());
        reportData.put("detailAddress", customerAccountOpenInfoEntity.getContactDetailAddress());

        if (3 == customerAccountOpenInfoEntity.getIdKind()) {
            reportData.put("nationalityName", CodeUtils.getCodeName("AO_NATIONALITY", customerAccountOpenInfoEntity.getNationality()));
        }

        reportData.put("acceptRisk", customerAccountOpenInfoEntity.getAcceptRisk());

        if (!"OTH".equals(customerAccountOpenInfoEntity.getContactRepublicName())) {
            reportData.put("contactRepublicName", customerAccountOpenInfoEntity.getContactRepublicName() != null ? CodeUtils.getCodeName("AO_NATIONALITY", customerAccountOpenInfoEntity.getContactRepublicName()) : "");
        } else {
            reportData.put("contactRepublicName", customerAccountOpenInfoEntity.getOtherContactRepublic());
        }

        reportData.put("companyRepublicName", customerAccountOpenInfoEntity.getCompanyRepublicName() != null ? CodeUtils.getCodeName("AO_NATIONALITY", customerAccountOpenInfoEntity.getCompanyRepublicName()) : "");
        reportData.put("companyProvinceName", customerAccountOpenInfoEntity.getCompanyProvinceName());
        reportData.put("companyCityName", customerAccountOpenInfoEntity.getCompanyCityName());
        reportData.put("companyCountyName", customerAccountOpenInfoEntity.getCompanyCountyName());
        reportData.put("companyDetailAddress", customerAccountOpenInfoEntity.getCompanyDetailAddress());

        if (!"OTH".equals(customerAccountOpenInfoEntity.getFamilyRepublicName())) {
            reportData.put("familyRepublicName", customerAccountOpenInfoEntity.getFamilyRepublicName() != null ? CodeUtils.getCodeName("AO_NATIONALITY", customerAccountOpenInfoEntity.getFamilyRepublicName()) : "");
        } else {
            reportData.put("familyRepublicName", customerAccountOpenInfoEntity.getOtherFamilyRepublic());
        }

        reportData.put("familyProvinceName", customerAccountOpenInfoEntity.getFamilyProvinceName());
        reportData.put("familyCityName", customerAccountOpenInfoEntity.getFamilyCityName());
        reportData.put("familyCountyName", customerAccountOpenInfoEntity.getFamilyCountyName());
        reportData.put("familyDetailAddress", customerAccountOpenInfoEntity.getFamilyDetailAddress());
        reportData.put("familyDetailAddressFull", customerAccountOpenInfoEntity.getFamilyCountyName() + customerAccountOpenInfoEntity.getFamilyDetailAddress());
        reportData.put("fatca", customerAccountOpenInfoEntity.getFatca());
        reportData.put("northTrade", customerAccountOpenInfoEntity.getNorthTrade());

        // 住宅地址国家英文
        if ("OTH".equals(customerAccountOpenInfoEntity.getFamilyRepublicName())) {
            reportData.put("familyNationalityEnligish", customerAccountOpenInfoEntity.getOtherFamilyRepublic() != null ? customerAccountOpenInfoEntity.getOtherFamilyRepublic() : "");
        } else {
            reportData.put("familyNationalityEnligish", customerAccountOpenInfoEntity.getFamilyRepublicName() != null ? CodeUtils.getCodeName("AO_NATIONALITY_ENGLISH", customerAccountOpenInfoEntity.getFamilyRepublicName()) : "");
        }

        // 联系地址国家英文
        if ("OTH".equals(customerAccountOpenInfoEntity.getContactRepublicName())) {
            reportData.put("contactNationalityEnligish", customerAccountOpenInfoEntity.getOtherContactRepublic() != null ? customerAccountOpenInfoEntity.getOtherContactRepublic() : "");
        } else {
            reportData.put("contactNationalityEnligish", customerAccountOpenInfoEntity.getContactRepublicName() != null ? CodeUtils.getCodeName("AO_NATIONALITY_ENGLISH", customerAccountOpenInfoEntity.getContactRepublicName()) : "");
        }

        if ("OTH".equals(customerAccountOpenInfoEntity.getNationality())) {
            reportData.put("nationalityEnligish", customerAccountOpenInfoEntity.getOtherNationality() != null ? customerAccountOpenInfoEntity.getOtherNationality() : "");
        } else {
            reportData.put("nationalityEnligish", customerAccountOpenInfoEntity.getNationality() != null ? CodeUtils.getCodeName("AO_NATIONALITY_ENGLISH", customerAccountOpenInfoEntity.getNationality()) : "");
        }

        reportData.put("hashCode", customerAccountOpenInfoEntity.getCaSignHashCode());
        reportData.put("signingOrganization", customerAccountOpenInfoEntity.getSigningOrganization());

        String openAccountWay = "";
        if (customerAccountOpenInfoEntity.getOpenAccountType() == 1 && customerAccountOpenInfoEntity.getBankType() == 0) {
            openAccountWay = "香港银行账户开户";
        } else if (customerAccountOpenInfoEntity.getOpenAccountType() == 1 && customerAccountOpenInfoEntity.getBankType() == 1) {
            openAccountWay = "电子证书开户";
        } else if (customerAccountOpenInfoEntity.getOpenAccountType() == 2) {
            openAccountWay = "线下开户";
        }
        reportData.put("openAccountWay", openAccountWay);

        String freelance = "";
        if (null != customerAccountOpenInfoEntity.getFreelanceCode()) {
            if (0 == customerAccountOpenInfoEntity.getFreelanceCode()) {
                freelance = customerAccountOpenInfoEntity.getFreelanceOther();
            } else {
                freelance = CodeUtils.getCodeName("AO_FREELANCE_CODE", String.valueOf(customerAccountOpenInfoEntity.getFreelanceCode()));
            }
        }

        reportData.put("freelanceOther", freelance);

        return reportData;
    }
}
