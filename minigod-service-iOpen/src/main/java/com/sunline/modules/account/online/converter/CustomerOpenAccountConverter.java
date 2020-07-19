package com.sunline.modules.account.online.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.account.online.entity.*;
import com.sunline.modules.account.online.helper.CustomerAccountOpenHelper;
import com.sunline.modules.account.online.helper.IdCardHelper;
import com.sunline.modules.account.online.model.CustomerAccOpenApplyModel;
import com.sunline.modules.account.online.model.CustomerAccOpenDetailModel;
import com.sunline.modules.account.online.model.CustomerAccOpenInfoModel;
import com.sunline.modules.account.online.protocol.*;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.sys.entity.CodeEntity;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2018/3/27
 * @description
 * @email justbelyf@gmail.com
 */
public class CustomerOpenAccountConverter {
    public static CustomerAccOpenInfoModel entityToModel(CustomerAccountOpenInfoEntity entity) {
        CustomerAccOpenInfoModel model = new CustomerAccOpenInfoModel();
        model.setId(entity.getId());
        model.setApplicationId(entity.getApplicationId());
        model.setOpenAccountType(entity.getOpenAccountType());
        model.setOpenAccountAccessWay(entity.getOpenAccountAccessWay());
        model.setFundAccountType(entity.getFundAccountType());
        model.setSourceChannelId(entity.getSourceChannelId());
        model.setSourceChannelName(entity.getSourceChannelName());
        model.setUserId(entity.getUserId());
        model.setInviterId(entity.getInviterId());
        model.setClientId(entity.getClientId());
        model.setFundAccount(entity.getFundAccount());
        model.setClientName(entity.getClientName());
        model.setFamilyName(entity.getFamilyName());
        model.setGivenName(entity.getGivenName());
        model.setClientNameSpell(entity.getClientNameSpell());
        model.setFamilyNameSpell(entity.getFamilyNameSpell());
        model.setGivenNameSpell(entity.getGivenNameSpell());
        model.setIdKind(entity.getIdKind());
        model.setIdNo(entity.getIdNo());
        model.setSex(entity.getSex());
        model.setBirthday(entity.getBirthday());
        model.setIdCardAddress(entity.getIdCardAddress());
        model.setIdCardValidDateStart(entity.getIdCardValidDateStart());
        model.setIdCardValidDateEnd(entity.getIdCardValidDateEnd());
        model.setIdentitySimilarityPercent(entity.getIdentitySimilarityPercent());
        model.setIsPassIdentityAuthentication(entity.getIsPassIdentityAuthentication());
        model.setBankId(entity.getBankId());
        model.setBankNo(entity.getBankNo());
        model.setBankAccountName(entity.getBankAccountName());
        model.setNationality(entity.getNationality());
        model.setIsAmericanGreenCardHolder(entity.getIsAmericanGreenCardHolder());
        model.setContactProvinceName(entity.getContactProvinceName());
        model.setContactCityName(entity.getContactCityName());
        model.setContactCountyName(entity.getContactCountyName());
        model.setContactDetailAddress(entity.getContactDetailAddress());
        model.setFamilyAddress(entity.getFamilyAddress());
        model.setEmail(entity.getEmail());
        model.setContactAddress(entity.getContactAddress());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setProfessionCode(entity.getProfessionCode());
        model.setFreelanceCode(entity.getFreelanceCode());
        model.setFreelanceOther(entity.getFreelanceOther());
        model.setProfessionType(entity.getProfessionType());
        model.setCompanyName(entity.getCompanyName());
        model.setCompanyAddress(entity.getCompanyAddress());
        model.setCompanyPhoneNumber(entity.getCompanyPhoneNumber());
        model.setJobPosition(entity.getJobPosition());
        model.setIndustryRange(entity.getIndustryRange());
        model.setCapitalSource(entity.getCapitalSource());
        model.setAnnualIncome(entity.getAnnualIncome());
        model.setInvestTarget(entity.getInvestTarget());
        model.setInvestTargetOther(entity.getInvestTargetOther());
        model.setStocksInvestmentExperienceType(entity.getStocksInvestmentExperienceType());
        model.setWarrantsInvestmentExperienceType(entity.getWarrantsInvestmentExperienceType());
        model.setFuturesInvestmentExperienceType(entity.getFuturesInvestmentExperienceType());
        model.setIsKnowDerivativeProducts(entity.getIsKnowDerivativeProducts());
        model.setDerivativeProductsStudyType(entity.getDerivativeProductsStudyType());
        model.setDerivativeProductsStudyTypeOther(entity.getDerivativeProductsStudyTypeOther());
        model.setFinancingInstitutionWorkExperienceType(entity.getFinancingInstitutionWorkExperienceType());
        model.setFinancingInstitutionWorkExperienceTypeOther(entity.getFinancingInstitutionWorkExperienceTypeOther());
        model.setIsTradedDerivativeProducts(entity.getIsTradedDerivativeProducts());
        model.setIsOpenUsaStockMarket(entity.getIsOpenUsaStockMarket());
        model.setIsOpenHkStockMarket(entity.getIsOpenHkStockMarket());
        model.setIsAllowProvidePrivacy(entity.getIsAllowProvidePrivacy());
        model.setIsAmlSuspicious(entity.getIsAmlSuspicious());
        model.setIsAllowDerivativesTransaction(entity.getIsAllowDerivativesTransaction());
        model.setInitialAccountPassword(entity.getInitialAccountPassword());
        model.setApplicationTime(entity.getApplicationTime());
        model.setRecordStatus(entity.getRecordStatus());
        model.setOpenAccountBankVerityList(entity.getOpenAccountBankVerityList());
        model.setPropertyTypeList(entity.getPropertyTypeList());
        model.setOtherDisclosureList(entity.getOtherDisclosureList());
        model.setTaxationInfoList(entity.getTaxationInfoList());
        model.setOpenAccountImagesInfo(entity.getOpenAccountImagesInfo());
        model.setBankType(entity.getBankType());
        model.setOtherBankName(entity.getOtherBankName());
        model.setNation(entity.getNation());
        model.setSigningOrganization(entity.getSigningOrganization());
        model.setCaSignHashCode(entity.getCaSignHashCode());
        model.setAcceptRisk(entity.getAcceptRisk());
        model.setFatca(entity.getFatca());
        model.setTheUSTaxNum(entity.getTheUSTaxNum());
        model.setNorthTrade(entity.getNorthTrade());
        model.setOtherNationality(entity.getOtherNationality());
        //add 公司地址，住宅地址拆分
        model.setContactRepublicName(entity.getContactRepublicName());
        model.setCompanyRepublicName(entity.getCompanyRepublicName());
        model.setCompanyProvinceName(entity.getCompanyProvinceName());
        model.setCompanyCityName(entity.getCompanyCityName());
        model.setCompanyCountyName(entity.getCompanyCountyName());
        model.setCompanyDetailAddress(entity.getCompanyDetailAddress());
        model.setFamilyRepublicName(entity.getFamilyRepublicName());
        model.setFamilyProvinceName(entity.getFamilyProvinceName());
        model.setFamilyCityName(entity.getFamilyCityName());
        model.setFamilyCountyName(entity.getFamilyCountyName());
        model.setFamilyDetailAddress(entity.getFamilyDetailAddress());
        model.setOtherCompanyRepublic(entity.getOtherCompanyRepublic());
        model.setOtherContactRepublic(entity.getOtherContactRepublic());
        model.setOtherFamilyRepublic(entity.getOtherFamilyRepublic());

        model.setLanguage(entity.getLan());
        model.setHomePhone(entity.getHomePhone());
        model.setAccountType(entity.getAccountType());
        model.setEducationLevel(entity.getEducationLevel());
        model.setWorkingSeniority(entity.getWorkingSeniority());
        model.setOfficePhone(entity.getOfficePhone());
        model.setIsBankrupted(entity.getIsBankrupted());
        model.setdStatementReceiveMode(entity.getdStatementReceiveMode());
        model.setUnitTrustsExperience(entity.getUnitTrustsExperience());
        model.setOtherProductsExperience(entity.getOtherProductsExperience());
        model.setOtherProductsName(entity.getOtherProductsName());
        model.setOptionsExperience(entity.getOptionsExperience());
        model.setTradeStockFrequency(entity.getTradeStockFrequency());
        model.setTradeWarrantsFrequency(entity.getTradeWarrantsFrequency());
        model.setTradeOptionsFrequency(entity.getTradeOptionsFrequency());
        model.setTradeFuturesFrequency(entity.getTradeFuturesFrequency());
        model.setTradeUnitTrustsFrequency(entity.getTradeUnitTrustsFrequency());
        model.setTradeOtherProductsFrequency(entity.getTradeOtherProductsFrequency());
        model.setIsAgreeCollectPersonalInfo(entity.getIsAgreeCollectPersonalInfo());

        return model;
    }

    public static CustomerAccountOpenInfoEntity modelToEntity(CustomerAccOpenInfoModel model) {
        CustomerAccountOpenInfoEntity entity = new CustomerAccountOpenInfoEntity();
        entity.setId(model.getId());
        entity.setApplicationId(model.getApplicationId());
        entity.setOpenAccountType(model.getOpenAccountType());
        entity.setOpenAccountAccessWay(model.getOpenAccountAccessWay());
        entity.setFundAccountType(model.getFundAccountType());
        entity.setSourceChannelId(model.getSourceChannelId());
        entity.setSourceChannelName(model.getSourceChannelName());
        entity.setUserId(model.getUserId());
        entity.setInviterId(model.getInviterId());
        entity.setClientId(model.getClientId());
        entity.setFundAccount(model.getFundAccount());
        entity.setClientName(model.getClientName());
        entity.setFamilyName(model.getFamilyName());
        entity.setGivenName(model.getGivenName());
        entity.setClientNameSpell(model.getClientNameSpell());
        entity.setFamilyNameSpell(model.getFamilyNameSpell());
        entity.setGivenNameSpell(model.getGivenNameSpell());
        entity.setIdKind(model.getIdKind());
        entity.setIdNo(model.getIdNo());
        entity.setSex(model.getSex());
        entity.setBirthday(model.getBirthday());
        entity.setIdCardAddress(model.getIdCardAddress());
        entity.setIdCardValidDateStart(model.getIdCardValidDateStart());
        entity.setIdCardValidDateEnd(model.getIdCardValidDateEnd());
        entity.setIdentitySimilarityPercent(model.getIdentitySimilarityPercent());
        entity.setIsPassIdentityAuthentication(model.getIsPassIdentityAuthentication());
        entity.setBankId(model.getBankId());
        entity.setBankNo(model.getBankNo());
        entity.setBankAccountName(model.getBankAccountName());
        entity.setNationality(model.getNationality());
        entity.setIsAmericanGreenCardHolder(model.getIsAmericanGreenCardHolder());
        entity.setContactProvinceName(model.getContactProvinceName());
        entity.setContactCityName(model.getContactCityName());
        entity.setContactCountyName(model.getContactCountyName());
        entity.setContactDetailAddress(model.getContactDetailAddress());
        entity.setFamilyAddress(model.getFamilyAddress());
        entity.setEmail(model.getEmail());
        entity.setContactAddress(model.getContactAddress());
        entity.setPhoneNumber(model.getPhoneNumber());
        entity.setProfessionCode(model.getProfessionCode());
        entity.setFreelanceCode(model.getFreelanceCode());
        entity.setFreelanceOther(model.getFreelanceOther());
        entity.setProfessionType(model.getProfessionType());
        entity.setCompanyName(model.getCompanyName());
        entity.setCompanyAddress(model.getCompanyAddress());
        entity.setCompanyPhoneNumber(model.getCompanyPhoneNumber());
        entity.setJobPosition(model.getJobPosition());
        entity.setIndustryRange(model.getIndustryRange());
        entity.setCapitalSource(model.getCapitalSource());
        entity.setAnnualIncome(model.getAnnualIncome());
        entity.setInvestTarget(model.getInvestTarget());
        entity.setInvestTargetOther(model.getInvestTargetOther());
        entity.setStocksInvestmentExperienceType(model.getStocksInvestmentExperienceType());
        entity.setWarrantsInvestmentExperienceType(model.getWarrantsInvestmentExperienceType());
        entity.setFuturesInvestmentExperienceType(model.getFuturesInvestmentExperienceType());
        entity.setIsKnowDerivativeProducts(model.getIsKnowDerivativeProducts());
        entity.setDerivativeProductsStudyType(model.getDerivativeProductsStudyType());
        entity.setDerivativeProductsStudyTypeOther(model.getDerivativeProductsStudyTypeOther());
        entity.setFinancingInstitutionWorkExperienceType(model.getFinancingInstitutionWorkExperienceType());
        entity.setFinancingInstitutionWorkExperienceTypeOther(model.getFinancingInstitutionWorkExperienceTypeOther());
        entity.setIsTradedDerivativeProducts(model.getIsTradedDerivativeProducts());
        entity.setIsOpenUsaStockMarket(model.getIsOpenUsaStockMarket());
        entity.setIsOpenHkStockMarket(model.getIsOpenHkStockMarket());
        entity.setIsAllowProvidePrivacy(model.getIsAllowProvidePrivacy());
        entity.setIsAmlSuspicious(model.getIsAmlSuspicious());
        entity.setIsAllowDerivativesTransaction(model.getIsAllowDerivativesTransaction());
        entity.setInitialAccountPassword(model.getInitialAccountPassword());
        entity.setApplicationTime(model.getApplicationTime());
        entity.setRecordStatus(model.getRecordStatus());
        entity.setOpenAccountBankVerityList(model.getOpenAccountBankVerityList());
        entity.setPropertyTypeList(model.getPropertyTypeList());
        entity.setOtherDisclosureList(model.getOtherDisclosureList());
        entity.setTaxationInfoList(model.getTaxationInfoList());
        entity.setOpenAccountImagesInfo(model.getOpenAccountImagesInfo());
        entity.setBankType(model.getBankType());
        entity.setOtherBankName(model.getOtherBankName());
        entity.setAddressType(model.getAddressType());

        //名族和签发机关
        entity.setSigningOrganization(model.getSigningOrganization());
        entity.setNation(model.getNation());

        entity.setNorthTrade(model.getNorthTrade());
        entity.setFatca(model.getFatca());
        entity.setTheUSTaxNum(model.getTheUSTaxNum());
        entity.setAcceptRisk(model.getAcceptRisk());
        entity.setOtherNationality(model.getOtherNationality());

        //add 公司地址，住宅地址拆分
        entity.setContactRepublicName(model.getContactRepublicName());
        entity.setCompanyRepublicName(model.getCompanyRepublicName());
        entity.setCompanyProvinceName(model.getCompanyProvinceName());
        entity.setCompanyCityName(model.getCompanyCityName());
        entity.setCompanyCountyName(model.getCompanyCountyName());
        entity.setCompanyDetailAddress(model.getCompanyDetailAddress());
        entity.setFamilyRepublicName(model.getFamilyRepublicName());
        entity.setFamilyProvinceName(model.getFamilyProvinceName());
        entity.setFamilyCityName(model.getFamilyCityName());
        entity.setFamilyCountyName(model.getFamilyCountyName());
        entity.setFamilyDetailAddress(model.getFamilyDetailAddress());
        entity.setOtherCompanyRepublic(model.getOtherCompanyRepublic());
        entity.setOtherContactRepublic(model.getOtherContactRepublic());
        entity.setOtherFamilyRepublic(model.getOtherFamilyRepublic());

        entity.setLan(model.getLanguage());
        entity.setHomePhone(model.getHomePhone());
        entity.setAccountType(model.getAccountType());
        entity.setEducationLevel(model.getEducationLevel());
        entity.setWorkingSeniority(model.getWorkingSeniority());
        entity.setOfficePhone(model.getOfficePhone());
        entity.setIsBankrupted(model.getIsBankrupted());
        entity.setdStatementReceiveMode(model.getdStatementReceiveMode());
        entity.setUnitTrustsExperience(model.getUnitTrustsExperience());
        entity.setOtherProductsExperience(model.getOtherProductsExperience());
        entity.setOtherProductsName(model.getOtherProductsName());
        entity.setOptionsExperience(model.getOptionsExperience());
        entity.setTradeStockFrequency(model.getTradeStockFrequency());
        entity.setTradeWarrantsFrequency(model.getTradeWarrantsFrequency());
        entity.setTradeOptionsFrequency(model.getTradeOptionsFrequency());
        entity.setTradeFuturesFrequency(model.getTradeFuturesFrequency());
        entity.setTradeUnitTrustsFrequency(model.getTradeUnitTrustsFrequency());
        entity.setTradeOtherProductsFrequency(model.getTradeOtherProductsFrequency());
        entity.setIsAgreeCollectPersonalInfo(model.getIsAgreeCollectPersonalInfo());

        return entity;
    }


    public static CustomerAccountOpenApplyEntity modelToEntity(CustomerAccOpenApplyModel model) {
        CustomerAccountOpenApplyEntity entity = new CustomerAccountOpenApplyEntity();
        model.setId(entity.getId());
        model.setApplicationTitle(entity.getApplicationTitle());
        model.setCurrentNode(entity.getCurrentNode());
        model.setApproveResult(entity.getApproveResult());
        model.setCurrentAccountOpenStep(BpmCommonEnum.OpenAccountStep.valueOf(entity.getCurrentAccountOpenStep()));
        model.setCurrentAccountOpenStepStatus(BpmCommonEnum.CommonProcessStatus.valueOf(entity.getCurrentAccountOpenStepStatus()));
        model.setAccountOpenResultStatus(BpmCommonEnum.CommonProcessStatus.valueOf(entity.getAccountOpenResultStatus()));
        model.setLastApprovalUser(entity.getLastApprovalUser());
        model.setAssignDrafter(entity.getAssignDrafter());
        model.setApprovalOpinion(entity.getApprovalOpinion());
        model.setErrorImages(entity.getErrorImages());
        model.setErrorContentTypes(entity.getErrorContentTypes());
        model.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.valueOf(entity.getCallbackStatus()));
        model.setStatus(entity.getStatus());
        model.setInstanceId(entity.getInstanceId());
        model.setDefid(entity.getDefid());
        model.setStartUserId(entity.getStartUserId());
        model.setCode(entity.getCode());
        model.setCreateUser(entity.getCreateId());
        model.setUpdateUser(entity.getUpdateId());
        model.setStartTime(entity.getStartTime());
        model.setCreateTime(entity.getCreateTime());
        model.setUpdateTime(entity.getUpdateTime());
        model.setRemark(entity.getRemark());
        model.setActResult(entity.getActResult());
        model.setApplicationId(entity.getApplicationId());

        model.setWitnessUser(entity.getWitnessUser());
        model.setWitnessesType(entity.getWitnessesType());
        model.setLicenseNumber(entity.getLicenseNumber());
        model.setSubmitApprovalUser(entity.getSubmitApprovalUser());
        return entity;
    }

    public static CustomerAccOpenApplyModel entityToModel(CustomerAccountOpenApplyEntity entity) {
        CustomerAccOpenApplyModel model = new CustomerAccOpenApplyModel();
        entity.setId(model.getId());
        entity.setApplicationTitle(model.getApplicationTitle());
        entity.setCurrentNode(model.getCurrentNode());
        entity.setApproveResult(model.getApproveResult());
        entity.setCurrentAccountOpenStep(model.getCurrentAccountOpenStep().getNumber());
        entity.setCurrentAccountOpenStepStatus(model.getCurrentAccountOpenStepStatus().getNumber());
        entity.setAccountOpenResultStatus(model.getAccountOpenResultStatus().getNumber());
        entity.setLastApprovalUser(model.getLastApprovalUser());
        entity.setAssignDrafter(model.getAssignDrafter());
        entity.setApprovalOpinion(model.getApprovalOpinion());
        entity.setErrorImages(model.getErrorImages());
        entity.setErrorContentTypes(model.getErrorContentTypes());
        entity.setCallbackStatus(model.getCallbackStatus().getNumber());
        entity.setStatus(model.getStatus());
        entity.setInstanceId(model.getInstanceId());
        entity.setDefid(model.getDefid());
        entity.setStartUserId(model.getStartUserId());
        entity.setCode(model.getCode());
        entity.setCreateUser(model.getCreateUser());
        entity.setUpdateUser(model.getUpdateUser());
        entity.setStartTime(model.getStartTime());
        entity.setCreateTime(model.getCreateTime());
        entity.setUpdateTime(model.getUpdateTime());
        entity.setRemark(model.getRemark());
        entity.setActResult(model.getActResult());
        entity.setApplicationId(model.getApplicationId());
        entity.setWitnessUser(model.getWitnessUser());
        entity.setWitnessesType(model.getWitnessesType());
        entity.setLicenseNumber(model.getLicenseNumber());
        entity.setSubmitApprovalUser(model.getSubmitApprovalUser());
        return model;
    }

    public static OpenAccountBankVerityInfoEntity protocolToEntity(OpenAccountBankVerityInfoProtocol protocol) {
        OpenAccountBankVerityInfoEntity entity = new OpenAccountBankVerityInfoEntity();
        entity.setUserId(protocol.getUserId());
        entity.setIdNo(protocol.getIdNo());
        entity.setClientName(protocol.getClientName());
        entity.setPhoneNumber(protocol.getPhoneNumber());
        entity.setVerityTime(protocol.getVerityTime());
        entity.setVerifyStatus(protocol.getVerifyStatus());
        entity.setBankCard(protocol.getBankCard());
        entity.setVerifyCount(protocol.getVerifyCount());
        return entity;
    }

    public static OpenAccountPropertyTypeEntity protocolToEntity(OpenAccountPropertyTypeProtocol protocol) {
        OpenAccountPropertyTypeEntity entity = new OpenAccountPropertyTypeEntity();
        entity.setPropertyType(protocol.getPropertyType());
        entity.setPropertyAmount(protocol.getPropertyAmount());
        return entity;
    }

    public static OpenAccountTaxationInfoEntity protocolToEntity(OpenAccountTaxationInfoProtocol protocol) {
        OpenAccountTaxationInfoEntity entity = new OpenAccountTaxationInfoEntity();
        entity.setTaxCountry(protocol.getTaxCountry());
        entity.setHasTaxNumber(protocol.getHasTaxNumber());
        entity.setTaxNumber(protocol.getTaxNumber());
        entity.setReasonType(protocol.getReasonType());
        entity.setReasonDesc(protocol.getReasonDesc());
        return entity;
    }

    public static OpenAccountOtherDisclosureEntity protocolToEntity(OpenAccountOtherDisclosureProtocol protocol) {
        OpenAccountOtherDisclosureEntity entity = new OpenAccountOtherDisclosureEntity();
        entity.setDisclosureCode(protocol.getDisclosureCode());
        //21~40条前后端文案相反，结果取反
        if (20 < protocol.getDisclosureCode() && protocol.getDisclosureCode() < 41) {
            entity.setDisclosureIsTrue(Math.abs((protocol.getDisclosureIsTrue() - 1)));
        } else {
            entity.setDisclosureIsTrue(protocol.getDisclosureIsTrue());
        }
        entity.setDisclosure1(protocol.getDisclosure1());
        entity.setDisclosure2(protocol.getDisclosure2());
        entity.setDisclosure3(protocol.getDisclosure3());
        entity.setDisclosure4(protocol.getDisclosure4());
        return entity;
    }


    public static CustomerAccOpenInfoModel protocolToModel(AccountOpenApplyProtocol accountOpenApplicationprotocol) {
        CustomerAccOpenInfoModel customerAccountOpenInfoEntity = new CustomerAccOpenInfoModel();
        customerAccountOpenInfoEntity.setOpenAccountAccessWay(accountOpenApplicationprotocol.getOpenAccountAccessWay());
        customerAccountOpenInfoEntity.setOpenAccountType(1);
        customerAccountOpenInfoEntity.setUserId(accountOpenApplicationprotocol.getUserId());
        customerAccountOpenInfoEntity.setClientName(accountOpenApplicationprotocol.getClientName());
        customerAccountOpenInfoEntity.setFamilyName(StringUtils.isNotBlank(accountOpenApplicationprotocol.getFamilyName())?
                accountOpenApplicationprotocol.getFamilyName() : IdCardHelper.getFamilyName(accountOpenApplicationprotocol.getClientName()));
        customerAccountOpenInfoEntity.setGivenName(StringUtils.isNotBlank(accountOpenApplicationprotocol.getGivenName())?
                accountOpenApplicationprotocol.getGivenName() : IdCardHelper.getGivenName(accountOpenApplicationprotocol.getClientName()));
        customerAccountOpenInfoEntity.setClientNameSpell(accountOpenApplicationprotocol.getClientNameSpell());
        customerAccountOpenInfoEntity.setFamilyNameSpell(accountOpenApplicationprotocol.getFamilyNameSpell());
        customerAccountOpenInfoEntity.setGivenNameSpell(accountOpenApplicationprotocol.getGivenNameSpell());
        customerAccountOpenInfoEntity.setIdKind(accountOpenApplicationprotocol.getIdKind());
        customerAccountOpenInfoEntity.setIdNo(accountOpenApplicationprotocol.getIdNo());
        customerAccountOpenInfoEntity.setIdCardAddress(accountOpenApplicationprotocol.getIdCardAddress());
        customerAccountOpenInfoEntity.setBirthday(accountOpenApplicationprotocol.getBirthday());
        customerAccountOpenInfoEntity.setIdCardValidDateStart(accountOpenApplicationprotocol.getIdCardValidDateStart());
        customerAccountOpenInfoEntity.setIdCardValidDateEnd(accountOpenApplicationprotocol.getIdCardValidDateEnd());
        customerAccountOpenInfoEntity.setIdentitySimilarityPercent(accountOpenApplicationprotocol.getIdentitySimilarityPercent());
        customerAccountOpenInfoEntity.setIsPassIdentityAuthentication(accountOpenApplicationprotocol.getIsPassIdentityAuthentication());
        customerAccountOpenInfoEntity.setSex(accountOpenApplicationprotocol.getSex());
        customerAccountOpenInfoEntity.setBankId(accountOpenApplicationprotocol.getBankId());
        customerAccountOpenInfoEntity.setBankNo(accountOpenApplicationprotocol.getBankNo());
//        customerAccountOpenInfoEntity.setNationality("中国");
        customerAccountOpenInfoEntity.setNationality(accountOpenApplicationprotocol.getNationality());
//        customerAccountOpenInfoEntity.setIsAmericanGreenCardHolder(0);
        //ContactProvinceName ContactCityName ContactCountyName ContactDetailAddress 都为空时才做拆分，其他情况前端做拆分
        if(StringUtils.isNotBlank(accountOpenApplicationprotocol.getContactProvinceName())
                &&StringUtils.isNotBlank(accountOpenApplicationprotocol.getContactCityName())
                &&StringUtils.isNotBlank(accountOpenApplicationprotocol.getContactCountyName())
                &&StringUtils.isNotBlank(accountOpenApplicationprotocol.getContactDetailAddress())){

            customerAccountOpenInfoEntity.setContactProvinceName(accountOpenApplicationprotocol.getContactProvinceName());
            customerAccountOpenInfoEntity.setContactCityName(accountOpenApplicationprotocol.getContactCityName());
            customerAccountOpenInfoEntity.setContactCountyName(accountOpenApplicationprotocol.getContactCountyName());
            customerAccountOpenInfoEntity.setContactDetailAddress(accountOpenApplicationprotocol.getContactDetailAddress());

        } else{
            customerAccountOpenInfoEntity.setContactProvinceName(IdCardHelper.getProvinceName(accountOpenApplicationprotocol.getContactAddress()));
            customerAccountOpenInfoEntity.setContactCityName(IdCardHelper.getCityName(accountOpenApplicationprotocol.getContactAddress()));
            customerAccountOpenInfoEntity.setContactCountyName(IdCardHelper.getCountyName(accountOpenApplicationprotocol.getContactAddress()));
            customerAccountOpenInfoEntity.setContactDetailAddress(IdCardHelper.getAddressDetailName(accountOpenApplicationprotocol.getContactAddress()));
        }

        if(StringUtils.isNotBlank(accountOpenApplicationprotocol.getFamilyProvinceName())
                &&StringUtils.isNotBlank(accountOpenApplicationprotocol.getFamilyCityName())
                &&StringUtils.isNotBlank(accountOpenApplicationprotocol.getFamilyCountyName())
                &&StringUtils.isNotBlank(accountOpenApplicationprotocol.getFamilyDetailAddress())){

            customerAccountOpenInfoEntity.setFamilyProvinceName(accountOpenApplicationprotocol.getFamilyProvinceName());
            customerAccountOpenInfoEntity.setFamilyCityName(accountOpenApplicationprotocol.getFamilyCityName());
            customerAccountOpenInfoEntity.setFamilyCountyName(accountOpenApplicationprotocol.getFamilyCountyName());
            customerAccountOpenInfoEntity.setFamilyDetailAddress(accountOpenApplicationprotocol.getFamilyDetailAddress());

        } else{
            customerAccountOpenInfoEntity.setFamilyProvinceName(IdCardHelper.getProvinceName(accountOpenApplicationprotocol.getFamilyAddress()));
            customerAccountOpenInfoEntity.setFamilyCityName(IdCardHelper.getCityName(accountOpenApplicationprotocol.getFamilyAddress()));
            customerAccountOpenInfoEntity.setFamilyCountyName(IdCardHelper.getCountyName(accountOpenApplicationprotocol.getFamilyAddress()));
            customerAccountOpenInfoEntity.setFamilyDetailAddress(IdCardHelper.getAddressDetailName(accountOpenApplicationprotocol.getFamilyAddress()));
        }
        customerAccountOpenInfoEntity.setAddressType(accountOpenApplicationprotocol.getAddressType());
        customerAccountOpenInfoEntity.setEmail(accountOpenApplicationprotocol.getEmail());
        customerAccountOpenInfoEntity.setPhoneNumber(accountOpenApplicationprotocol.getPhoneNumber());
        customerAccountOpenInfoEntity.setProfessionCode(accountOpenApplicationprotocol.getProfessionCode());
        customerAccountOpenInfoEntity.setFreelanceCode(accountOpenApplicationprotocol.getFreelanceCode());
        customerAccountOpenInfoEntity.setFreelanceOther(accountOpenApplicationprotocol.getFreelanceOther());
        customerAccountOpenInfoEntity.setProfessionType(accountOpenApplicationprotocol.getProfessionType());
        customerAccountOpenInfoEntity.setCompanyName(accountOpenApplicationprotocol.getCompanyName());
        customerAccountOpenInfoEntity.setCompanyPhoneNumber(accountOpenApplicationprotocol.getCompanyPhoneNumber());
        customerAccountOpenInfoEntity.setJobPosition(accountOpenApplicationprotocol.getJobPosition());
//        customerAccountOpenInfoEntity.setIndustryRange(accountOpenApplicationprotocol.getIndustryRange());
        customerAccountOpenInfoEntity.setAnnualIncome(accountOpenApplicationprotocol.getAnnualIncome());

        if (accountOpenApplicationprotocol.getInvestTarget() != null && accountOpenApplicationprotocol.getInvestTarget().size() > 0) {
            StringBuffer investTargets = new StringBuffer();
            investTargets.append("[");
            for (Integer investTarget : accountOpenApplicationprotocol.getInvestTarget()) {
                investTargets.append(investTarget + ",");
            }
            if (investTargets.length() > 1) {
                StringBuffer investTarget = new StringBuffer();
                investTarget.append(investTargets.substring(0,investTargets.length()-1)).append("]");
                customerAccountOpenInfoEntity.setInvestTarget(investTarget.toString());
            }else{
                customerAccountOpenInfoEntity.setInvestTarget(investTargets.toString());
            }

        }
        customerAccountOpenInfoEntity.setInvestTargetOther(accountOpenApplicationprotocol.getInvestTargetOther());
        customerAccountOpenInfoEntity.setStocksInvestmentExperienceType(accountOpenApplicationprotocol.getStocksInvestmentExperienceType());
        customerAccountOpenInfoEntity.setWarrantsInvestmentExperienceType(accountOpenApplicationprotocol.getWarrantsInvestmentExperienceType());
        customerAccountOpenInfoEntity.setFuturesInvestmentExperienceType(accountOpenApplicationprotocol.getFuturesInvestmentExperienceType());
        customerAccountOpenInfoEntity.setIsKnowDerivativeProducts(accountOpenApplicationprotocol.getIsKnowDerivativeProducts());
        customerAccountOpenInfoEntity.setDerivativeProductsStudyType(accountOpenApplicationprotocol.getDerivativeProductsStudyType());
        customerAccountOpenInfoEntity.setDerivativeProductsStudyTypeOther(accountOpenApplicationprotocol.getDerivativeProductsStudyTypeOther());
        customerAccountOpenInfoEntity.setFinancingInstitutionWorkExperienceType(accountOpenApplicationprotocol.getFinancingInstitutionWorkExperienceType());
        customerAccountOpenInfoEntity.setFinancingInstitutionWorkExperienceTypeOther(accountOpenApplicationprotocol.getFinancingInstitutionWorkExperienceTypeOther());
        customerAccountOpenInfoEntity.setIsTradedDerivativeProducts(accountOpenApplicationprotocol.getIsTradedDerivativeProducts());
        customerAccountOpenInfoEntity.setInviterId(accountOpenApplicationprotocol.getInviterId());
        customerAccountOpenInfoEntity.setSourceChannelId(accountOpenApplicationprotocol.getSourceChannelId());
//        customerAccountOpenInfoEntity.setSourceChannelName(accountOpenApplicationprotocol.getSourceChannelName());
        customerAccountOpenInfoEntity.setIsOpenUsaStockMarket(1);
        customerAccountOpenInfoEntity.setIsOpenHkStockMarket(1);

        customerAccountOpenInfoEntity.setIsAllowDerivativesTransaction(accountOpenApplicationprotocol.getIsKnowDerivativeProducts());
        customerAccountOpenInfoEntity.setApplicationTime(accountOpenApplicationprotocol.getApplicationTime());
        customerAccountOpenInfoEntity.setRecordStatus(1);
        customerAccountOpenInfoEntity.setOpenAccountImagesInfo(accountOpenApplicationprotocol.getOpenAccountImagesInfo());
        customerAccountOpenInfoEntity.setFundAccountType(accountOpenApplicationprotocol.getFundAccountType());
        customerAccountOpenInfoEntity.setBankType(accountOpenApplicationprotocol.getBankType());
        customerAccountOpenInfoEntity.setFamilyAddress(accountOpenApplicationprotocol.getFamilyAddress());
        customerAccountOpenInfoEntity.setCompanyAddress(accountOpenApplicationprotocol.getCompanyAddress());
        customerAccountOpenInfoEntity.setContactAddress(accountOpenApplicationprotocol.getContactAddress());
        if (accountOpenApplicationprotocol.getCapitalSource() != null && accountOpenApplicationprotocol.getCapitalSource().size() > 0) {
            StringBuffer capitals = new StringBuffer();
            capitals.append("[");
            for (Integer capital : accountOpenApplicationprotocol.getCapitalSource()) {
                capitals.append(capital + ",");
            }
            if (capitals.length() > 1) {
                StringBuffer capital = new StringBuffer();
                capital.append(capitals.substring(0,capitals.length()-1)).append("]");
                customerAccountOpenInfoEntity.setCapitalSource(capital.toString());
            }else{
                customerAccountOpenInfoEntity.setCapitalSource(capitals.toString());
            }

        }
        if (accountOpenApplicationprotocol.getIsAmlSuspicious() != null && !"".equals(accountOpenApplicationprotocol.getIsAmlSuspicious())) {
            customerAccountOpenInfoEntity.setIsAmlSuspicious(Integer.parseInt(accountOpenApplicationprotocol.getIsAmlSuspicious()));
        }
        customerAccountOpenInfoEntity.setIsAllowProvidePrivacy(accountOpenApplicationprotocol.getIsAllowProvidePrivacy());
        List<OpenAccountPropertyTypeEntity> propertyTypeList = Lists.newArrayList();
        for (OpenAccountPropertyTypeProtocol protocol : accountOpenApplicationprotocol.getPropertyType()) {

            propertyTypeList.add(protocolToEntity(protocol));
        }
        customerAccountOpenInfoEntity.setPropertyTypeList(propertyTypeList);

        List<OpenAccountTaxationInfoEntity> taxationInfoList = Lists.newArrayList();
        for (OpenAccountTaxationInfoProtocol protocol : accountOpenApplicationprotocol.getTaxationInfo()) {
            taxationInfoList.add(protocolToEntity(protocol));
        }
        customerAccountOpenInfoEntity.setTaxationInfoList(taxationInfoList);

        List<OpenAccountOtherDisclosureEntity> otherDisclosureList = Lists.newArrayList();
        for (OpenAccountOtherDisclosureProtocol protocol : accountOpenApplicationprotocol.getOtherDisclosure()) {
            otherDisclosureList.add(protocolToEntity(protocol));
        }
        customerAccountOpenInfoEntity.setOtherDisclosureList(otherDisclosureList);


        if (1 == accountOpenApplicationprotocol.getBankType()) {
            List<OpenAccountBankVerityInfoEntity> bankVerityInfoList = Lists.newArrayList();
            for (OpenAccountBankVerityInfoProtocol protocol : accountOpenApplicationprotocol.getBankVerityInfo()) {
                bankVerityInfoList.add(protocolToEntity(protocol));
            }
            customerAccountOpenInfoEntity.setOpenAccountBankVerityList(bankVerityInfoList);
        }

        customerAccountOpenInfoEntity.setBankAccountName(accountOpenApplicationprotocol.getBankAccountName());
        customerAccountOpenInfoEntity.setOtherBankName(accountOpenApplicationprotocol.getOtherBankName());

        //名族和签发机关
        customerAccountOpenInfoEntity.setSigningOrganization(accountOpenApplicationprotocol.getSigningOrganization());
        customerAccountOpenInfoEntity.setNation(accountOpenApplicationprotocol.getNation());
        //增加北向交易，FATCA声明，风险承受程度
        customerAccountOpenInfoEntity.setNorthTrade(accountOpenApplicationprotocol.getNorthTrade());
        customerAccountOpenInfoEntity.setFatca(accountOpenApplicationprotocol.getFatca());
        customerAccountOpenInfoEntity.setAcceptRisk(accountOpenApplicationprotocol.getAcceptRisk());
        customerAccountOpenInfoEntity.setOtherNationality(accountOpenApplicationprotocol.getOtherNationality());

        //add 公司地址，住宅地址拆分
        customerAccountOpenInfoEntity.setContactRepublicName(accountOpenApplicationprotocol.getContactRepublicName());
        customerAccountOpenInfoEntity.setCompanyRepublicName(accountOpenApplicationprotocol.getCompanyRepublicName());
        customerAccountOpenInfoEntity.setCompanyProvinceName(accountOpenApplicationprotocol.getCompanyProvinceName());
        customerAccountOpenInfoEntity.setCompanyCityName(accountOpenApplicationprotocol.getCompanyCityName());
        customerAccountOpenInfoEntity.setCompanyCountyName(accountOpenApplicationprotocol.getCompanyCountyName());
        customerAccountOpenInfoEntity.setCompanyDetailAddress(accountOpenApplicationprotocol.getCompanyDetailAddress());
        customerAccountOpenInfoEntity.setFamilyRepublicName(accountOpenApplicationprotocol.getFamilyRepublicName());
        customerAccountOpenInfoEntity.setFamilyProvinceName(accountOpenApplicationprotocol.getFamilyProvinceName());
        customerAccountOpenInfoEntity.setFamilyCityName(accountOpenApplicationprotocol.getFamilyCityName());
        customerAccountOpenInfoEntity.setFamilyCountyName(accountOpenApplicationprotocol.getFamilyCountyName());
        customerAccountOpenInfoEntity.setFamilyDetailAddress(accountOpenApplicationprotocol.getFamilyDetailAddress());
        customerAccountOpenInfoEntity.setOtherCompanyRepublic(accountOpenApplicationprotocol.getOtherCompanyRepublic());
        customerAccountOpenInfoEntity.setOtherContactRepublic(accountOpenApplicationprotocol.getOtherContactRepublic());
        customerAccountOpenInfoEntity.setOtherFamilyRepublic(accountOpenApplicationprotocol.getOtherFamilyRepublic());

        customerAccountOpenInfoEntity.setLanguage(accountOpenApplicationprotocol.getLanguage());
        customerAccountOpenInfoEntity.setHomePhone(accountOpenApplicationprotocol.getHomePhone());
        customerAccountOpenInfoEntity.setAccountType(accountOpenApplicationprotocol.getAccountType());
        customerAccountOpenInfoEntity.setEducationLevel(accountOpenApplicationprotocol.getEducationLevel());
        customerAccountOpenInfoEntity.setWorkingSeniority(accountOpenApplicationprotocol.getWorkingSeniority());
        customerAccountOpenInfoEntity.setOfficePhone(accountOpenApplicationprotocol.getOfficePhone());
        customerAccountOpenInfoEntity.setIsBankrupted(accountOpenApplicationprotocol.getIsBankrupted());
        customerAccountOpenInfoEntity.setdStatementReceiveMode(accountOpenApplicationprotocol.getdStatementReceiveMode());
        customerAccountOpenInfoEntity.setUnitTrustsExperience(accountOpenApplicationprotocol.getUnitTrustsExperience());
        customerAccountOpenInfoEntity.setOtherProductsExperience(accountOpenApplicationprotocol.getOtherProductsExperience());
        customerAccountOpenInfoEntity.setOtherProductsName(accountOpenApplicationprotocol.getOtherProductsName());
        customerAccountOpenInfoEntity.setOptionsExperience(accountOpenApplicationprotocol.getOptionsExperience());
        customerAccountOpenInfoEntity.setTradeStockFrequency(accountOpenApplicationprotocol.getTradeStockFrequency());
        customerAccountOpenInfoEntity.setTradeWarrantsFrequency(accountOpenApplicationprotocol.getTradeWarrantsFrequency());
        customerAccountOpenInfoEntity.setTradeOptionsFrequency(accountOpenApplicationprotocol.getTradeOptionsFrequency());
        customerAccountOpenInfoEntity.setTradeFuturesFrequency(accountOpenApplicationprotocol.getTradeFuturesFrequency());
        customerAccountOpenInfoEntity.setTradeUnitTrustsFrequency(accountOpenApplicationprotocol.getTradeUnitTrustsFrequency());
        customerAccountOpenInfoEntity.setTradeOtherProductsFrequency(accountOpenApplicationprotocol.getTradeOtherProductsFrequency());
        customerAccountOpenInfoEntity.setIsAgreeCollectPersonalInfo(accountOpenApplicationprotocol.getIsAgreeCollectPersonalInfo());

        return customerAccountOpenInfoEntity;
    }


    public static JSONArray converterToAccountOpenErrorReport(Map<String, Integer> accountOpenErrors) {
        Map<String, String> allErrorDescription = Maps.newHashMap();
        List<CodeEntity> accountOpenContentErrorTypes = CodeUtils.getCodeInfoByParentMark("AO_CONTENT_ERROR_TYPE");
        for (CodeEntity accountOpenContentErrorType : accountOpenContentErrorTypes) {
            allErrorDescription.put(accountOpenContentErrorType.getValue(), accountOpenContentErrorType.getName());
        }
        allErrorDescription.putAll(CustomerAccountOpenHelper.getAllOpenAccountImagesLocationType());

        JSONArray jsonArray = new JSONArray();
        for (String errorType : accountOpenErrors.keySet()) {
            JSONObject json = new JSONObject();
            json.put("errorType", allErrorDescription.get(errorType));
            if (null != accountOpenErrors.get(errorType)) {
                json.put("errorsCount", accountOpenErrors.get(errorType));
            } else {
                json.put("errorsCount", "0");
            }

            jsonArray.add(json);
        }
        return jsonArray;
    }


    public static JSONArray converterToAccountOpenInfoReport(List<CustomerAccOpenDetailModel> accountsOpenInfo) {
        JSONArray jsonArray = new JSONArray();
        for (CustomerAccOpenDetailModel customerAccountOpenDetailInfoModel : accountsOpenInfo) {
            CustomerAccOpenInfoModel userInfo = customerAccountOpenDetailInfoModel.getCustomerAccountOpenInfoModel();
            CustomerAccOpenApplyModel applicationInfo = customerAccountOpenDetailInfoModel.getCustomerAccountOpenApplicationModel();

            Map<String, String> data = Maps.newHashMap();
            data.put("userId", String.valueOf(userInfo.getUserId()));
            data.put("clientName", userInfo.getClientName());
            data.put("sex", CodeUtils.getCodeName("COMMON_SEX", String.valueOf(userInfo.getSex())));
            data.put("tradeAccount", userInfo.getClientId());
            data.put("idNo", userInfo.getIdNo());
            data.put("phoneNumber", userInfo.getPhoneNumber());
            data.put("email", userInfo.getEmail());
            data.put("idCardAddress", userInfo.getIdCardAddress());
            data.put("contactAddress", userInfo.getContactProvinceName() + userInfo.getContactCityName() + userInfo.getContactCountyName() + userInfo.getContactDetailAddress());
            data.put("professionCode", CodeUtils.getCodeName("AO_PROFESSION_TYPE", String.valueOf(userInfo.getProfessionCode())));
            data.put("companyName", userInfo.getCompanyName());
            data.put("companyPhoneNumber", userInfo.getCompanyPhoneNumber());
            data.put("industryRange", userInfo.getIndustryRange());
            data.put("income", CodeUtils.getCodeName("AO_INCOME", String.valueOf(userInfo.getAnnualIncome())));
            data.put("stocksInvestmentExperienceType", CodeUtils.getCodeName("AO_STOCKS_INVESTMENT_EXPERIENCE_TYPE", String.valueOf(userInfo.getStocksInvestmentExperienceType())));
            data.put("warrantsInvestmentExperienceType", CodeUtils.getCodeName("AO_WARRANTS_INVESTMENT_EXPERIENCE_TYPE", String.valueOf(userInfo.getWarrantsInvestmentExperienceType())));
            data.put("futuresInvestmentExperienceType", CodeUtils.getCodeName("AO_FUTURES_INVESTMENT_EXPERIENCE_TYPE", String.valueOf(userInfo.getFuturesInvestmentExperienceType())));
            data.put("applicationTime", new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").format(userInfo.getApplicationTime()));
            data.put("currentNode", applicationInfo.getCurrentNode());
            data.put("updateTime", new SimpleDateFormat("YYYY-mm-dd HH:mm:ss").format(userInfo.getUpdateTime()));

            jsonArray.add(JSON.toJSON(data));
        }

        return jsonArray;
    }

    public static SecuritiesUserModel converterToSecuritiesUserInfo(CustomerAccountOpenInfoEntity entity) {
        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
        securitiesUserModel.setOpenAccountType(entity.getOpenAccountType());
        if (null != entity.getUserId()) {
            securitiesUserModel.setUserId(entity.getUserId());
        }
        securitiesUserModel.setClientName(entity.getClientName());
        securitiesUserModel.setFamilyName(entity.getFamilyName());
        securitiesUserModel.setGivenName(entity.getGivenName());
        securitiesUserModel.setClientNameSpell(entity.getClientNameSpell());
        securitiesUserModel.setFamilyNameSpell(entity.getFamilyNameSpell());
        securitiesUserModel.setGivenNameSpell(entity.getGivenNameSpell());
        securitiesUserModel.setIdKind(entity.getIdKind());
        securitiesUserModel.setIdNo(entity.getIdNo());
        securitiesUserModel.setIdCardAddress(entity.getIdCardAddress());
        securitiesUserModel.setBirthday(entity.getBirthday());
        securitiesUserModel.setSex(entity.getSex());
        securitiesUserModel.setBankId(entity.getBankId());
        securitiesUserModel.setBankNo(entity.getBankNo());
        securitiesUserModel.setNationality(entity.getNationality());
        securitiesUserModel.setIsAmericanGreenCardHolder(entity.getIsAmericanGreenCardHolder());
        securitiesUserModel.setContactProvinceName(entity.getContactProvinceName());
        securitiesUserModel.setContactCityName(entity.getContactCityName());
        securitiesUserModel.setContactCountyName(entity.getContactCountyName());
        securitiesUserModel.setContactDetailAddress(entity.getContactDetailAddress());
        securitiesUserModel.setEmail(entity.getEmail());
        securitiesUserModel.setPhoneNumber(entity.getPhoneNumber());
        securitiesUserModel.setProfessionCode(entity.getProfessionCode());
        securitiesUserModel.setFreelanceCode(entity.getFreelanceCode());
        securitiesUserModel.setFreelanceOther(entity.getFreelanceOther());
        securitiesUserModel.setCompanyName(entity.getCompanyName());
        securitiesUserModel.setCompanyPhoneNumber(entity.getCompanyPhoneNumber());
        securitiesUserModel.setJobPosition(entity.getJobPosition());
        securitiesUserModel.setIndustryRange(entity.getIndustryRange());
        securitiesUserModel.setAnnualIncome(entity.getAnnualIncome());
        securitiesUserModel.setInvestTarget(entity.getInvestTarget());
        securitiesUserModel.setInvestTargetOther(entity.getInvestTargetOther());
        securitiesUserModel.setStocksInvestmentExperienceType(entity.getStocksInvestmentExperienceType());
        securitiesUserModel.setWarrantsInvestmentExperienceType(entity.getWarrantsInvestmentExperienceType());
        securitiesUserModel.setFuturesInvestmentExperienceType(entity.getFuturesInvestmentExperienceType());
        securitiesUserModel.setIsKnowDerivativeProducts(entity.getIsKnowDerivativeProducts());
        securitiesUserModel.setDerivativeProductsStudyType(entity.getDerivativeProductsStudyType());
        securitiesUserModel.setDerivativeProductsStudyTypeOther(entity.getDerivativeProductsStudyTypeOther());
        securitiesUserModel.setFinancingInstitutionWorkExperienceType(entity.getFinancingInstitutionWorkExperienceType());
        securitiesUserModel.setFinancingInstitutionWorkExperienceTypeOther(entity.getFinancingInstitutionWorkExperienceTypeOther());
        securitiesUserModel.setInviterId(entity.getInviterId());
        securitiesUserModel.setSourceChannelId(entity.getSourceChannelId());
        securitiesUserModel.setIsOpenUsaStockMarket(entity.getIsOpenUsaStockMarket());
        securitiesUserModel.setIsOpenHkStockMarket(entity.getIsOpenHkStockMarket());
        securitiesUserModel.setIsAllowDerivativesTransaction(entity.getIsAllowDerivativesTransaction());
        securitiesUserModel.setTradeAccount(entity.getClientId());
        securitiesUserModel.setFundAccount(entity.getFundAccount());
        if (null != entity.getOpenAccountTime()) {
            securitiesUserModel.setOpenAccountTime(entity.getOpenAccountTime());
        }
        securitiesUserModel.setCreateTime(new Date());
        securitiesUserModel.setUpdateTime(new Date());
        securitiesUserModel.setApplicationId(entity.getApplicationId());
        securitiesUserModel.setOpenAccountAccessWay(entity.getOpenAccountAccessWay());
        securitiesUserModel.setFundAccountType(entity.getFundAccountType());
        securitiesUserModel.setBankType(entity.getBankType());
        securitiesUserModel.setBankAccountName(entity.getBankAccountName());
        securitiesUserModel.setOtherBankName(entity.getOtherBankName());
        securitiesUserModel.setProfessionType(entity.getProfessionType());
        securitiesUserModel.setFamilyAddress(entity.getFamilyAddress());
        securitiesUserModel.setContactAddress(entity.getContactAddress());
        securitiesUserModel.setCompanyAddress(entity.getCompanyAddress());
        securitiesUserModel.setCapitalSource(entity.getCapitalSource());
        securitiesUserModel.setIsAllowProvidePrivacy(entity.getIsAllowProvidePrivacy());
        securitiesUserModel.setIsAmlSuspicious(entity.getIsAmlSuspicious());
        securitiesUserModel.setIsTradedDerivativeProducts(entity.getIsTradedDerivativeProducts());
        securitiesUserModel.setIdCardValidDateEnd(entity.getIdCardValidDateEnd());

        //增加北向交易，FATCA声明，风险承受程度
        securitiesUserModel.setNorthTrade(entity.getNorthTrade());
        securitiesUserModel.setFatca(entity.getFatca());
        securitiesUserModel.setTheUSTaxNum(entity.getTheUSTaxNum());
        securitiesUserModel.setAcceptRisk(entity.getAcceptRisk());
        securitiesUserModel.setOtherNationality(entity.getOtherNationality());

        //add 公司地址，住宅地址拆分
        securitiesUserModel.setContactRepublicName(entity.getContactRepublicName());
        securitiesUserModel.setCompanyRepublicName(entity.getCompanyRepublicName());
        securitiesUserModel.setCompanyProvinceName(entity.getCompanyProvinceName());
        securitiesUserModel.setCompanyCityName(entity.getCompanyCityName());
        securitiesUserModel.setCompanyCountyName(entity.getCompanyCountyName());
        securitiesUserModel.setCompanyDetailAddress(entity.getCompanyDetailAddress());
        securitiesUserModel.setFamilyRepublicName(entity.getFamilyRepublicName());
        securitiesUserModel.setFamilyProvinceName(entity.getFamilyProvinceName());
        securitiesUserModel.setFamilyCityName(entity.getFamilyCityName());
        securitiesUserModel.setFamilyCountyName(entity.getFamilyCountyName());
        securitiesUserModel.setFamilyDetailAddress(entity.getFamilyDetailAddress());
        securitiesUserModel.setOtherCompanyRepublic(entity.getOtherCompanyRepublic());
        securitiesUserModel.setOtherContactRepublic(entity.getOtherContactRepublic());
        securitiesUserModel.setOtherFamilyRepublic(entity.getOtherFamilyRepublic());

        securitiesUserModel.setLanguage(entity.getLan());
        securitiesUserModel.setAccountType(entity.getAccountType());
        securitiesUserModel.setHomePhone(entity.getHomePhone());
        securitiesUserModel.setEducationLevel(entity.getEducationLevel());
        securitiesUserModel.setWorkingSeniority(entity.getWorkingSeniority());
        securitiesUserModel.setOfficePhone(entity.getOfficePhone());
        securitiesUserModel.setIsBankrupted(entity.getIsBankrupted());
        securitiesUserModel.setdStatementReceiveMode(entity.getdStatementReceiveMode());
        securitiesUserModel.setUnitTrustsExperience(entity.getUnitTrustsExperience());
        securitiesUserModel.setOtherProductsExperience(entity.getOtherProductsExperience());
        securitiesUserModel.setOtherProductsName(entity.getOtherProductsName());
        securitiesUserModel.setOptionsExperience(entity.getOptionsExperience());
        securitiesUserModel.setTradeStockFrequency(entity.getTradeStockFrequency());
        securitiesUserModel.setTradeWarrantsFrequency(entity.getTradeWarrantsFrequency());
        securitiesUserModel.setTradeOptionsFrequency(entity.getTradeOptionsFrequency());
        securitiesUserModel.setTradeFuturesFrequency(entity.getTradeFuturesFrequency());
        securitiesUserModel.setTradeUnitTrustsFrequency(entity.getTradeUnitTrustsFrequency());
        securitiesUserModel.setTradeOtherProductsFrequency(entity.getTradeOtherProductsFrequency());
        securitiesUserModel.setIsAgreeCollectPersonalInfo(entity.getIsAgreeCollectPersonalInfo());

        return securitiesUserModel;
    }
}
