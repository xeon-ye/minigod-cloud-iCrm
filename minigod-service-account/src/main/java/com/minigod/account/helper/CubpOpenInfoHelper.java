package com.minigod.account.helper;

import com.alibaba.fastjson.JSON;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountAppointmentReqVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class CubpOpenInfoHelper {
    // 日志对象

    /**
     * 开户预约接口数据完整性校验
     *
     * @param openInfo
     * @return
     */
    public static boolean openInfoValid(CubpOpenAccountAppointmentReqVo openInfo) {
        if (null == openInfo.getFundAccountType()) {
            log.info("【开户预约接口数据完整性校验】：请填写账户类型");
            return false;
        }

        if (StringUtils.isBlank(openInfo.getBankType())) {
            log.info("【开户预约接口数据完整性校验】：请填写银行类型");
            return false;
        }

        //香港账户 = 0  非香港账户 = 1
        if ("0".equals(openInfo.getBankType())) {
            if ("0".equals(openInfo.getNationality())) {
                if (StringUtils.isBlank(openInfo.getClientName())) {
                    log.info("【开户预约接口数据完整性校验】：请填写用户中文名");
                    return false;
                }
            }
        }
        if ("1".equals(openInfo.getBankType())) {
//            if (StringUtils.isBlank(openInfo.getBankAccountName())) {
//                log.info("【开户预约接口数据完整性校验】：请填写银行户名");
//                return false;
//            }
            if (StringUtils.isBlank(openInfo.getBankNo())) {
                log.info("【开户预约接口数据完整性校验】：请填写银行卡号");
                return false;
            }
            if (openInfo.getOpenAccountAccessWay() == 2) {
                if (StringUtils.isBlank(openInfo.getIdCardValidDateStart())) {
                    log.info("【开户预约接口数据完整性校验】：请填写身份证生效日期");
                    return false;
                }
                if (StringUtils.isBlank(openInfo.getIdCardValidDateEnd())) {
                    log.info("【开户预约接口数据完整性校验】：请填写身份证失效日期");
                    return false;
                }
                if (null == openInfo.getBankId()) {
                    log.info("【开户预约接口数据完整性校验】：请填写银行编号");
                    return false;
                }
                if (StringUtils.isBlank(openInfo.getClientName())) {
                    log.info("【开户预约接口数据完整性校验】：请填写用户中文名");
                    return false;
                }
                if (StringUtils.isBlank(openInfo.getIdCardAddress())) {
                    log.info("【开户预约接口数据完整性校验】：请填写证件地址");
                    return false;
                }
            }
        }

        if (StringUtils.isBlank(openInfo.getNationality())) {
            log.info("【开户预约接口数据完整性校验】：请填写国籍");
            return false;
        }

        if (StringUtils.isBlank(openInfo.getClientNameSpell())) {
            log.info("【开户预约接口数据完整性校验】：请填写用户英文名");
            return false;
        }
        if (null == openInfo.getIdKind()) {
            log.info("【开户预约接口数据完整性校验】：请填写身份证类型");
            return false;
        }
        if (StringUtils.isBlank(openInfo.getIdNo())) {
            log.info("【开户预约接口数据完整性校验】：请填写身份证号码");
            return false;
        }
        if (null == openInfo.getSex()) {
            log.info("【开户预约接口数据完整性校验】：请填写性别");
            return false;
        }
        if (StringUtils.isBlank(openInfo.getEmail())) {
            log.info("【开户预约接口数据完整性校验】：请填写用邮箱");
            return false;
        }
        if (StringUtils.isBlank(openInfo.getBirthday())) {
            log.info("【开户预约接口数据完整性校验】：请填写生日");
            return false;
        }

        if (CollectionUtils.isEmpty(openInfo.getPropertyType())) {
            log.info("【开户预约接口数据完整性校验】：请填写财产种类");
            return false;
        }
        if (CollectionUtils.isEmpty(openInfo.getOtherDisclosure())) {
            log.info("【开户预约接口数据完整性校验】：请填写其他信息披露");
            return false;
        }
        if (CollectionUtils.isEmpty(openInfo.getTaxationInfo())) {
            log.info("【开户预约接口数据完整性校验】：请填写税务信息");
            return false;
        }
        if (null == openInfo.getIsAllowProvidePrivacy()) {
            log.info("【开户预约接口数据完整性校验】：请填写私隐信息");
            return false;
        }
        if (StringUtils.isBlank(openInfo.getFamilyAddress())) {
            log.info("【开户预约接口数据完整性校验】：请填写住宅住址");
            return false;
        }
        if (StringUtils.isBlank(openInfo.getContactAddress())) {
            log.info("【开户预约接口数据完整性校验】：请填写通讯地址");
            return false;
        }

        if (null == openInfo.getProfessionCode()) {
            log.info("【开户预约接口数据完整性校验】：请填写就业信息");
            return false;
        }
        if (1 == openInfo.getProfessionCode() || 2 == openInfo.getProfessionCode()) {
            if (null == openInfo.getProfessionType()) {
                log.info("【开户预约接口数据完整性校验】：请填写所属行业");
                return false;
            }
            if (null == openInfo.getJobPosition()) {
                log.info("【开户预约接口数据完整性校验】：请填写职位级别");
                return false;
            }
            if (StringUtils.isBlank(openInfo.getCompanyName())) {
                log.info("【开户预约接口数据完整性校验】：请填写公司名称");
                return false;
            }
            if (StringUtils.isBlank(openInfo.getCompanyAddress())) {
                log.info("【开户预约接口数据完整性校验】：请填写公司地址");
                return false;
            }

            if (CollectionUtils.isEmpty(openInfo.getCapitalSource())) {
                log.info("【开户预约接口数据完整性校验】：请填写资金来源");
                return false;
            }
            if (1 == openInfo.getProfessionCode()) {
                if (StringUtils.isBlank(openInfo.getJobPosition())) {
                    log.info("【开户预约接口数据完整性校验】：请填写职位");
                    return false;
                }
            }
        }

        if (null == openInfo.getAnnualIncome()) {
            log.info("【开户预约接口数据完整性校验】：请填写年收入");
            return false;
        }

        if (CollectionUtils.isEmpty(openInfo.getInvestTarget())) {
            log.info("【开户预约接口数据完整性校验】：请填写投资目标");
            return false;
        }

        if (openInfo.getInvestTarget().contains("4")) {
            if (StringUtils.isBlank(openInfo.getInvestTargetOther())) {
                log.info("【开户预约接口数据完整性校验】：请填写其他投资目标");
                return false;
            }
        }

        if (null == openInfo.getStocksInvestmentExperienceType()) {
            log.info("【开户预约接口数据完整性校验】：请填写股票投资经验");
            return false;
        }
        if (null == openInfo.getWarrantsInvestmentExperienceType()) {
            log.info("【开户预约接口数据完整性校验】：请填写认证股权投资经验");
            return false;
        }
        if (null == openInfo.getFuturesInvestmentExperienceType()) {
            log.info("【开户预约接口数据完整性校验】：请填写期货投资经验");
            return false;
        }
        if (null == openInfo.getIsKnowDerivativeProducts()) {
            log.info("【开户预约接口数据完整性校验】：请填写是否了解衍生品性质和风险");
            return false;
        }

        if (1 == openInfo.getIsKnowDerivativeProducts()) {
            if (null != openInfo.getDerivativeProductsStudyType() || null != openInfo.getFinancingInstitutionWorkExperienceType()
                    || null != openInfo.getIsTradedDerivativeProducts()) {
                if (null != openInfo.getDerivativeProductsStudyType() && 7 == openInfo.getDerivativeProductsStudyType()) {
                    if (null == openInfo.getDerivativeProductsStudyTypeOther() || StringUtils.isBlank(openInfo.getDerivativeProductsStudyTypeOther())) {
                        log.info("【开户预约接口数据完整性校验】：请填写衍生产品其它学习方式");
                        return false;
                    }
                }
                if (null != openInfo.getFinancingInstitutionWorkExperienceType() && 4 == openInfo.getFinancingInstitutionWorkExperienceType()) {
                    if (null == openInfo.getFinancingInstitutionWorkExperienceTypeOther() || StringUtils.isBlank(openInfo.getFinancingInstitutionWorkExperienceTypeOther())) {
                        log.info("【开户预约接口数据完整性校验】：请填写在金融机构其它工作经验类型");
                        return false;
                    }
                }
            } else {
                log.info("【开户预约接口数据完整性校验】：请填写衍生品相关内容");
                return false;
            }
        }

        if (openInfo.getAddressType() == null) {
            log.info("【开户预约接口数据完整性校验】：请填写地址类型");
            return false;
        }

        if (StringUtils.isEmpty(openInfo.getPhoneNumber())) {
            log.info("【开户预约接口数据完整性校验】：请填写手机号码");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String info = "{\"idCardAddress\":\"广东省广州市白云区金融科技大厦\",\"openAccountType\":1,\"birthday\":\"1991-02-03\",\"companyAddress\":\"\",\"sex\":1,\"fundAccountType\":1,\"jobPosition\":\"\",\"idCardValidDateEnd\":\"2024-10-30\",\"familyAddress\":\"广东省广州市白云区金融科技大厦\",\"isTradedDerivativeProducts\":0,\"bankNo\":\"87346455\",\"annualIncome\":1,\"phoneNumber\":\"18000003039\",\"taxationInfo\":[{\"taxNumber\":\"649789199102036589\",\"taxCountry\":\"中国大陆\",\"hasTaxNumber\":1}],\"userId\":2002144,\"clientName\":\"哦搜狗\",\"professionType\":\"\",\"isKnowDerivativeProducts\":0,\"clientNameSpell\":\"POSIJ\",\"otherDisclosure\":[{\"disclosureDetail\":\",\",\"disclosureName\":\",\",\"disclosureIsTrue\":1,\"disclosureCode\":1},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":2},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":3},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":4},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":5},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":6},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":7},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":8},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":9},{\"disclosureDetail\":\"\",\"disclosureName\":\"\",\"disclosureIsTrue\":1,\"disclosureCode\":10}],\"openAccountAccessWay\":\"2\",\"idCardValidDateStart\":\"2018-10-30\",\"isAllowProvidePrivacy\":1,\"investTarget\":[1,2,3],\"derivativeProductsStudyTypeOther\":\"\",\"idNo\":\"649789199102036589\",\"sourceChannelId\":\"1\",\"financingInstitutionWorkExperienceType\":\"\",\"professionCode\":4,\"derivativeProductsStudyType\":\"\",\"investTargetOther\":false,\"inviterId\":1,\"idKind\":1,\"capitalSource\":[6],\"futuresInvestmentExperienceType\":0,\"companyName\":\"\",\"warrantsInvestmentExperienceType\":0,\"bankId\":\"ABC\",\"nationality\":0,\"propertyType\":[{\"propertyType\":1,\"propertyAmount\":\"6\"}],\"email\":\"jpeg@sonp.com\",\"bankType\":1,\"stocksInvestmentExperienceType\":0,\"financingInstitutionWorkExperienceTypeOther\":\"\",\"contactAddress\":\"广东省广州市白云区金融科技大厦\"}";
        CubpOpenAccountAppointmentReqVo openInfo = JSON.parseObject(info, CubpOpenAccountAppointmentReqVo.class);
        openInfoValid(openInfo);
    }

}
