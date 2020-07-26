package com.sunline.modules.account.online.helper;

import com.google.common.collect.Maps;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.model.CustomerAccOpenInfoModel;
import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @description: 开户校验工作类
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

public class CustomerAccountOpenHelper {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountOpenHelper.class);

    /**
     * 图片位置数据内容验证
     * [0=未知 1=身份证 2=银行卡 3=签名照 4=正面照 5=活体照 6=凭证照]
     *
     * @param imageLocation
     * @return
     */
    public static boolean imageLocationValidate(Integer imageLocation) {

        return 1 == imageLocation || 2 == imageLocation || 3 == imageLocation
                || 4 == imageLocation || 5 == imageLocation || 6 == imageLocation;
    }

    /**
     * 图片位置类型数据内容验证
     * <p>
     * [101-身份证正面 102-身份证反面 105-香港非永久身份证 201-银行卡 301-签名 302-签名信息 401-手持身份证正面照 402-正面照 501-1根手指 502-2根手指 503-3根手指 504-4根手指 505-5根手指 506-眨眼睛 507-张嘴巴 508-点头 509-摇头]
     *
     * @param imageLocationType
     * @return
     */
    public static boolean imageLocationTypeValidate(Integer imageLocationType) {
        return 101 == imageLocationType || 102 == imageLocationType || 103 == imageLocationType
                || 104 == imageLocationType || 105 == imageLocationType || 201 == imageLocationType || 301 == imageLocationType
                || 302 == imageLocationType || 401 == imageLocationType || 402 == imageLocationType
                || 501 == imageLocationType || 502 == imageLocationType || 503 == imageLocationType
                || 504 == imageLocationType || 505 == imageLocationType || 506 == imageLocationType
                || 507 == imageLocationType || 508 == imageLocationType || 509 == imageLocationType
                || 601 == imageLocationType || 602 == imageLocationType || 603 == imageLocationType;
    }


    public static boolean isLivingPhoto(Integer imageLocationType) {

        if (506 == imageLocationType || 507 == imageLocationType || 508 == imageLocationType || 509 == imageLocationType) {
            return true;
        }

        return false;
    }


    /**
     * 获取图片位置类型的中文描述
     *
     * @param imageLocationType
     * @return
     */
    public static String getImageName(int imageLocationType) {
        Map<String, String> allOpenAccountImagesLocationType = getAllOpenAccountImagesLocationType();

        return allOpenAccountImagesLocationType.get(String.valueOf(imageLocationType));
    }


    public static Map<String, String> getAllOpenAccountImagesLocationType() {
        Map<String, String> imagesLocationType = Maps.newHashMap();
        imagesLocationType.put("0", "未知");
        imagesLocationType.put("101", "身份证正面");
        imagesLocationType.put("102", "身份证反面");
        imagesLocationType.put("103", "香港身份证");
        imagesLocationType.put("104", "护照");
        imagesLocationType.put("105", "补充身份证明");
        imagesLocationType.put("201", "银行卡");
        imagesLocationType.put("301", "签名");
        imagesLocationType.put("302", "签名信息");
        imagesLocationType.put("401", "手持身份证正面照");
        imagesLocationType.put("402", "正面照");
        imagesLocationType.put("501", "1根手指");
        imagesLocationType.put("502", "2根手指");
        imagesLocationType.put("503", "3根手指");
        imagesLocationType.put("504", "4根手指");
        imagesLocationType.put("505", "5根手指");
        imagesLocationType.put("506", "眨眼睛");
        imagesLocationType.put("507", "张嘴巴");
        imagesLocationType.put("508", "点头");
        imagesLocationType.put("509", "摇头");
        imagesLocationType.put("601", "接收衍生产品的方式凭证图");
        imagesLocationType.put("602", "金融机构工作经验凭证图");
        imagesLocationType.put("603", "衍生产品的交易凭证图");

        return imagesLocationType;
    }


    /**
     * 开户预约接口数据完整性校验
     *
     * @param openAccountInfo
     * @return
     */
    public static ResponseVO validateAccountOpenInfo(CustomerAccOpenInfoModel openAccountInfo) {

        ResponseVO responseVO = new ResponseVO();

        if (null == openAccountInfo.getOpenAccountType()) {
            logger.error("【开户预约接口数据完整性校验】：开户类型为空");
            responseVO.setCode(-1);
            responseVO.setMessage("开户类型为空");
            return responseVO;
        }

        if (null == openAccountInfo.getOpenAccountAccessWay()) {

            logger.error("【开户预约接口数据完整性校验】：开户接入方式为空");
            responseVO.setCode(-1);
            responseVO.setMessage("开户接入方式为空");
            return responseVO;
        }
//        if (2 == openAccountInfo.getOpenAccountAccessWay()) {
//            if (null == openAccountInfo.getIdentitySimilarityPercent()) {
//
//                logger.error("【开户预约接口数据完整性校验】：识别精度为空");
//                responseVO.setCode(-1);
//                responseVO.setMessage("识别精度为空");
//                return responseVO;
//            }
//            if (null == openAccountInfo.getIsPassIdentityAuthentication()) {
//                logger.error("【开户预约接口数据完整性校验】：是否通过验证为空");
//                responseVO.setCode(-1);
//                responseVO.setMessage("是否通过验证为空");
//                return responseVO;
//            }
//        }

        if (null == openAccountInfo.getFundAccountType()) {
            logger.error("【开户预约接口数据完整性校验】：请填写账户类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写账户类型");
            return responseVO;
        }

        if (null == openAccountInfo.getSourceChannelId() || StringUtils.isBlank(openAccountInfo.getSourceChannelId())) {
            logger.error("【开户预约接口数据完整性校验】：请填写渠道号");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写渠道号");
            return responseVO;
        }
        if (null == openAccountInfo.getUserId()) {
            logger.error("【开户预约接口数据完整性校验】：请填写小神号");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写小神号");
            return responseVO;
        }
        if (null == openAccountInfo.getClientNameSpell() || StringUtils.isBlank(openAccountInfo.getClientNameSpell())) {
            logger.error("【开户预约接口数据完整性校验】：请填写用户英文名");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写用户英文名");
            return responseVO;
        }

        if (null == openAccountInfo.getGivenNameSpell() || StringUtils.isBlank(openAccountInfo.getGivenNameSpell())) {
            logger.error("【开户预约接口数据完整性校验】：请填写用户英文名字");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写用户英文名字");
            return responseVO;
        }

        if (null == openAccountInfo.getFamilyNameSpell() || StringUtils.isBlank(openAccountInfo.getFamilyNameSpell())) {
            logger.error("【开户预约接口数据完整性校验】：请填写用户英文姓氏");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写用户英文姓氏");
            return responseVO;
        }

        if (1 == openAccountInfo.getIdKind()) {
            if (null == openAccountInfo.getClientName() || StringUtils.isBlank(openAccountInfo.getClientName())) {
                logger.error("【开户预约接口数据完整性校验】：请填写用户中文名");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写用户中文名");
                return responseVO;
            }

            if (null == openAccountInfo.getGivenName() || StringUtils.isBlank(openAccountInfo.getGivenName())) {
                logger.error("【开户预约接口数据完整性校验】：请填写用户中文名字");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写用户中文名字");
                return responseVO;
            }

            if (null == openAccountInfo.getFamilyName() || StringUtils.isBlank(openAccountInfo.getFamilyName())) {
                logger.error("【开户预约接口数据完整性校验】：请填写用户中文姓氏");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写用户中文姓氏");
                return responseVO;
            }

            if (null == openAccountInfo.getIdCardAddress() || StringUtils.isBlank(openAccountInfo.getIdCardAddress())) {
                logger.error("【开户预约接口数据完整性校验】：请填写证件地址");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写证件地址");
                return responseVO;
            }
        }

        if (1 == openAccountInfo.getIdKind()) {
            if (2 == openAccountInfo.getOpenAccountAccessWay()) {
                if (null == openAccountInfo.getIdCardValidDateStart() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateStart())) {
                    logger.error("【开户预约接口数据完整性校验】：请填写证件生效日期");
                    responseVO.setCode(-1);
                    responseVO.setMessage("请填写证件生效日期");
                    return responseVO;
                }
                if (null == openAccountInfo.getIdCardValidDateEnd() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateEnd())) {
                    logger.error("【开户预约接口数据完整性校验】：请填写证件失效日期");
                    responseVO.setCode(-1);
                    responseVO.setMessage("请填写证件失效日期");
                    return responseVO;
                }
            }
        }

        if (3 == openAccountInfo.getIdKind()) {
            if (2 == openAccountInfo.getOpenAccountAccessWay()) {
                if (null == openAccountInfo.getIdCardValidDateEnd() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateEnd())) {
                    logger.error("【开户预约接口数据完整性校验】：请填写证件失效日期");
                    responseVO.setCode(-1);
                    responseVO.setMessage("请填写证件失效日期");
                    return responseVO;
                }
            }
        }


        if (null == openAccountInfo.getNationality() || StringUtils.isBlank(openAccountInfo.getNationality())) {
            logger.error("【开户预约接口数据完整性校验】：请填写国籍");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写国籍");
            return responseVO;
        }

//        if (0==openAccountInfo.getBankType()) {
//            if ("0".equals(openAccountInfo.getNationality())) {
//                if (StringUtils.isBlank(openAccountInfo.getClientName())) {
//                    logger.info("【开户预约接口数据完整性校验】：请填写用户中文名");
//                    responseVO.setCode(-1);
//                    responseVO.setMessage("请填写用户中文名");
//                    return responseVO;
//                }
//            }
//        }

        if (null == openAccountInfo.getIdKind()) {
            logger.error("【开户预约接口数据完整性校验】：请填写身份证类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写身份证类型");
            return responseVO;
        }
        if (null == openAccountInfo.getIdNo() || StringUtils.isBlank(openAccountInfo.getIdNo())) {
            logger.error("【开户预约接口数据完整性校验】：请填写身份证号码");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写身份证号码");
            return responseVO;
        }
        if (null == openAccountInfo.getSex()) {
            logger.error("【开户预约接口数据完整性校验】：请填写性别");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写性别");
            return responseVO;
        }
        if (null == openAccountInfo.getEmail() || StringUtils.isBlank(openAccountInfo.getEmail())) {
            logger.error("【开户预约接口数据完整性校验】：请填写用邮箱");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写用邮箱");
            return responseVO;
        }

        if (null == openAccountInfo.getPhoneNumber() || StringUtils.isBlank(openAccountInfo.getPhoneNumber())) {
            logger.error("【开户预约接口数据完整性校验】：请填写手机号码");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写手机号码");
            return responseVO;
        }

        if (null == openAccountInfo.getBirthday() || StringUtils.isBlank(openAccountInfo.getBirthday())) {
            logger.error("【开户预约接口数据完整性校验】：请填写生日");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写生日");
            return responseVO;
        }

        if (null == openAccountInfo.getApplicationTime()) {
            logger.error("【开户预约接口数据完整性校验】：请填写预约申请时间");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写预约申请时间");
            return responseVO;
        }

        if (null == openAccountInfo.getInviterId() || StringUtils.isBlank(openAccountInfo.getInviterId())) {
            logger.error("【开户预约接口数据完整性校验】：请填写推荐人小神号");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写推荐人小神号");
            return responseVO;
        }

        if (null == openAccountInfo.getBankType()) {
            logger.error("【开户预约接口数据完整性校验】：请填写银行类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写银行类型");
            return responseVO;
        }

//        if (null == openAccountInfo.getBankId()) {
//            logger.error("【开户预约接口数据完整性校验】：请填写银行编号");
//            responseVO.setCode(-1);
//            responseVO.setMessage("请填写银行编号");
//            return responseVO;
//        }
//        if (null == openAccountInfo.getBankNo() || StringUtils.isBlank(openAccountInfo.getBankNo())) {
//            logger.error("【开户预约接口数据完整性校验】：请填写银行卡号");
//            responseVO.setCode(-1);
//            responseVO.setMessage("请填写银行卡号");
//            return responseVO;
//        }
//
//        //香港账户 = 0  非香港账户 = 1
//        if ("0".equals(openAccountInfo.getBankType())) {
//            if (null == openAccountInfo.getBankAccountName() || StringUtils.isBlank(openAccountInfo.getBankAccountName())) {
//                logger.error("【开户预约接口数据完整性校验】：请填写银行户名");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写银行户名");
//                return responseVO;
//            }
//        }

        if (1 == openAccountInfo.getBankType()) {
            if (null == openAccountInfo.getBankCurrency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写银行币种");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写银行编号");
                return responseVO;
            }

            if (null == openAccountInfo.getBankNo() || StringUtils.isBlank(openAccountInfo.getBankNo())) {
                logger.error("【开户预约接口数据完整性校验】：请填写银行卡号");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写银行卡号");
                return responseVO;
            }
        }


        if (null == openAccountInfo.getPropertyTypeList() || openAccountInfo.getPropertyTypeList().size() < 1) {
            logger.error("【开户预约接口数据完整性校验】：请填写财产种类");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写财产种类");
            return responseVO;
        }
        if (null == openAccountInfo.getOtherDisclosureList() || openAccountInfo.getOtherDisclosureList().size() < 1) {
            logger.error("【开户预约接口数据完整性校验】：请填写其他信息披露");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写其他信息披露");
            return responseVO;
        }

        if (null == openAccountInfo.getTaxationInfoList() || openAccountInfo.getTaxationInfoList().size() < 1) {
            logger.error("【开户预约接口数据完整性校验】：请填写税务信息");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写税务信息");
            return responseVO;
        }
        if (null == openAccountInfo.getIsAllowProvidePrivacy()) {
            logger.error("【开户预约接口数据完整性校验】：请填写私隐信息");
            responseVO.setCode(-1);
            responseVO.setMessage("");
            return responseVO;
        }
        if (StringUtils.isEmpty(openAccountInfo.getFamilyAddress())) {
            logger.error("【开户预约接口数据完整性校验】：请填写住宅住址");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写住宅住址");
            return responseVO;
        }

        if (null == openAccountInfo.getContactAddress() || StringUtils.isBlank(openAccountInfo.getContactAddress())) {
            logger.error("【开户预约接口数据完整性校验】：请填写通讯地址");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写通讯地址");
            return responseVO;
        }


        if (null == openAccountInfo.getProfessionCode()) {
            logger.error("【开户预约接口数据完整性校验】：请填写就业信息");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写就业信息");
            return responseVO;
        }

        if (1 == openAccountInfo.getProfessionCode() || 2 == openAccountInfo.getProfessionCode()) {
            if (null == openAccountInfo.getCompanyName() || StringUtils.isBlank(openAccountInfo.getCompanyName())) {
                logger.error("【开户预约接口数据完整性校验】：请填写公司名称");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写公司名称");
                return responseVO;
            }
//            if (null == openAccountInfo.getCompanyAddress() || StringUtils.isBlank(openAccountInfo.getCompanyAddress())) {
//                logger.error("【开户预约接口数据完整性校验】：请填写公司地址");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写公司地址");
//                return responseVO;
//            }

            if (null == openAccountInfo.getProfessionType()) {
                logger.error("【开户预约接口数据完整性校验】：请填写所属行业");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写所属行业");
                return responseVO;
            }

//            if (1 == openAccountInfo.getProfessionCode()) {
//                if (null == openAccountInfo.getJobPosition() || StringUtils.isBlank(openAccountInfo.getJobPosition())) {
//                    logger.error("【开户预约接口数据完整性校验】：请填写职位");
//                    responseVO.setCode(-1);
//                    responseVO.setMessage("请填写职位");
//                    return responseVO;
//                }
//            }
        }

        if (null == openAccountInfo.getCapitalSource() || StringUtils.isBlank(openAccountInfo.getCapitalSource())) {
            logger.error("【开户预约接口数据完整性校验】：请填写收入来源");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写收入来源");
            return responseVO;
        }

//        if (null == openAccountInfo.getProfessionType()) {
//            if (null == openAccountInfo.getJobPosition() || StringUtils.isBlank(openAccountInfo.getJobPosition())) {
//                logger.error("【开户预约接口数据完整性校验】：请填写所属行业");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写所属行业");
//                return responseVO;
//            }
//        }

        if (null == openAccountInfo.getAnnualIncome()) {
            logger.error("【开户预约接口数据完整性校验】：请填写年收入");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写年收入");
            return responseVO;
        }


        if (null == openAccountInfo.getInvestTarget() || StringUtils.isBlank(openAccountInfo.getInvestTarget())) {
            logger.error("【开户预约接口数据完整性校验】：请填写投资目标");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写投资目标");
            return responseVO;
        }

        if (openAccountInfo.getInvestTarget().contains("4")) {
            if (null == openAccountInfo.getInvestTargetOther() || StringUtils.isBlank(openAccountInfo.getInvestTargetOther())) {
                logger.error("【开户预约接口数据完整性校验】：请填写其他投资目标");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写其他投资目标");
                return responseVO;
            }
        }

        if (null == openAccountInfo.getStocksInvestmentExperienceType()) {
            logger.error("【开户预约接口数据完整性校验】：请填写股票投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写股票投资经验");
            return responseVO;
        }
        if (null == openAccountInfo.getWarrantsInvestmentExperienceType()) {
            logger.error("【开户预约接口数据完整性校验】：请填写认证股权投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写认证股权投资经验");
            return responseVO;
        }
        if (null == openAccountInfo.getFuturesInvestmentExperienceType()) {
            logger.error("【开户预约接口数据完整性校验】：请填写期货投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写期货投资经验");
            return responseVO;
        }
        if (null == openAccountInfo.getIsKnowDerivativeProducts()) {
            logger.error("【开户预约接口数据完整性校验】：请填写是否了解衍生品性质和风险");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写是否了解衍生品性质和风险");
            return responseVO;
        }

        if (1 == openAccountInfo.getIsKnowDerivativeProducts()) {
            if (null != openAccountInfo.getDerivativeProductsStudyType() || null != openAccountInfo.getFinancingInstitutionWorkExperienceType()
                    || null != openAccountInfo.getIsTradedDerivativeProducts()) {
                if (null != openAccountInfo.getDerivativeProductsStudyType() && 7 == openAccountInfo.getDerivativeProductsStudyType()) {
                    if (null == openAccountInfo.getDerivativeProductsStudyTypeOther() || StringUtils.isBlank(openAccountInfo.getDerivativeProductsStudyTypeOther())) {
                        logger.error("【开户预约接口数据完整性校验】：请填写衍生产品其它学习方式");
                        responseVO.setCode(-1);
                        responseVO.setMessage("请填写衍生产品其它学习方式");
                        return responseVO;
                    }
                }
                if (null != openAccountInfo.getFinancingInstitutionWorkExperienceType() && 4 == openAccountInfo.getFinancingInstitutionWorkExperienceType()) {
                    if (null == openAccountInfo.getFinancingInstitutionWorkExperienceTypeOther() || StringUtils.isBlank(openAccountInfo.getFinancingInstitutionWorkExperienceTypeOther())) {
                        logger.error("【开户预约接口数据完整性校验】：请填写在金融机构其它工作经验类型");
                        responseVO.setCode(-1);
                        responseVO.setMessage("请填写在金融机构其它工作经验类型");
                        return responseVO;
                    }
                }
            } else {
                logger.error("【开户预约接口数据完整性校验】：请填写衍生品相关内容");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写衍生品相关内容");
                return responseVO;
            }

        }

        if (1 == openAccountInfo.getBankType()) {
            if (null == openAccountInfo.getOpenAccountBankVerityList() || openAccountInfo.getOpenAccountBankVerityList().size() < 1) {
                logger.error("【开户预约接口数据完整性校验】：请填写四要素信息");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写四要素信息");
                return responseVO;
            }
        }

//        if (null == openAccountInfo.getAddressType()) {
//            logger.error("【开户预约接口数据完整性校验】：请填写地址类型");
//            responseVO.setCode(-1);
//            responseVO.setMessage("请填写地址类型");
//            return responseVO;
//        }

//        if (null == openAccountInfo.getAcceptRisk()) {
//            logger.error("【开户预约接口数据完整性校验】：请填写风险接受程度");
//            responseVO.setCode(-1);
//            responseVO.setMessage("请填写风险接受程度");
//            return responseVO;
//        }

//        if (null == openAccountInfo.getFatca()) {
//            logger.error("【开户预约接口数据完整性校验】：请填写FATCA信息");
//            responseVO.setCode(-1);
//            responseVO.setMessage("请填写FATCA信息");
//            return responseVO;
//        }

        if (null == openAccountInfo.getNorthTrade()) {
            logger.error("【开户预约接口数据完整性校验】：请填写北向交易信息");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写北向交易信息");
            return responseVO;
        }

        //2020-7-22 16:30添加------------------
        if (null == openAccountInfo.getLanguage()) {
            logger.error("【开户预约接口数据完整性校验】：请填写语言信息");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写语言信息");
            return responseVO;
        }

        if (null == openAccountInfo.getAccountType()) {
            logger.error("【开户预约接口数据完整性校验】：请填写账户类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写账户类型");
            return responseVO;
        }

        if (null == openAccountInfo.getFamilyPhone() || StringUtils.isBlank(openAccountInfo.getFamilyPhone())) {
            logger.error("【开户预约接口数据完整性校验】：请填写住所电话");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写住所电话");
            return responseVO;
        }

        if (null == openAccountInfo.getEducationLevel()) {
            logger.error("【开户预约接口数据完整性校验】：请填写教育程度");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写教育程度");
            return responseVO;
        }

        if (null == openAccountInfo.getIsBankrupted()) {
            logger.error("【开户预约接口数据完整性校验】：请填写你是否曾经破产或被送达要将你破产的申请");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写你是否曾经破产或被送达要将你破产的申请");
            return responseVO;
        }

        if (null == openAccountInfo.getdStatementReceiveMode()) {
            logger.error("【开户预约接口数据完整性校验】：请填写日结单及月结单发送方式");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写日结单及月结单发送方式");
            return responseVO;
        }

        if (null == openAccountInfo.getUnitTrustsExperience()) {
            logger.error("【开户预约接口数据完整性校验】：请填写单位信托基金/互惠基金");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写单位信托基金/互惠基金");
            return responseVO;
        }

        if (null == openAccountInfo.getOtherProductsExperience()) {
            logger.error("【开户预约接口数据完整性校验】：请填写其它投资产品");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写其它投资产品");
            return responseVO;
        }

        if (null == openAccountInfo.getOptionsExperience()) {
            logger.error("【开户预约接口数据完整性校验】：请填写期权投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写期权投资经验");
            return responseVO;
        }

        if (openAccountInfo.getOtherProductsExperience() > 0) {
            if (openAccountInfo.getOtherProductsName() == null || StringUtils.isBlank(openAccountInfo.getOtherProductsName())) {
                logger.error("【开户预约接口数据完整性校验】：请填写其它投资产品名称");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写其它其它投资产品名称");
                return responseVO;
            }
        }

        if (openAccountInfo.getStocksInvestmentExperienceType() > 0) {
            if (null == openAccountInfo.getTradeStockFrequency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写股票交易频率");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写股票交易频率");
                return responseVO;
            }
        }

        if (openAccountInfo.getWarrantsInvestmentExperienceType() > 0){
            if (null == openAccountInfo.getTradeWarrantsFrequency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写认股证交易频");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写认股证交易频");
                return responseVO;
            }
        }

        if (openAccountInfo.getOptionsExperience() > 0){
            if (null == openAccountInfo.getTradeOptionsFrequency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写期权交易频率");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写期权交易频率");
                return responseVO;
            }
        }

        if (openAccountInfo.getOptionsExperience() > 0){
            if (null == openAccountInfo.getTradeOptionsFrequency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写期货交易频率");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写期货交易频率");
                return responseVO;
            }
        }

        if (openAccountInfo.getUnitTrustsExperience() > 0){
            if (null == openAccountInfo.getTradeUnitTrustsFrequency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写单位信托基金/互惠基金交易频率");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写单位信托基金/互惠基金交易频率");
                return responseVO;
            }
        }

        if (openAccountInfo.getOtherProductsExperience() > 0){
            if (null == openAccountInfo.getTradeOtherProductsFrequency()) {
                logger.error("【开户预约接口数据完整性校验】：请填写其它投资产品交易频率");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写其它投资产品交易频率");
                return responseVO;
            }
        }

        if (null == openAccountInfo.getIsOpenOptions()){
            logger.error("【开户预约接口数据完整性校验】：请填写开通期权");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写开通期权");
            return responseVO;
        }

        if (null == openAccountInfo.getOptionsAccUsageScenarios()){
            logger.error("【开户预约接口数据完整性校验】：请填写期权账号使用场景");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写期权账号使用场景");
            return responseVO;
        }

        if (null == openAccountInfo.getIsOpenFutures()){
            logger.error("【开户预约接口数据完整性校验】：请填写开通期货");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写开通期货");
            return responseVO;
        }

        if (null == openAccountInfo.getFuturesAccUsageScenarios()){
            logger.error("【开户预约接口数据完整性校验】：请填写期货账号使用场景");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写期货账号使用场景");
            return responseVO;
        }

        //2020-7-22 16:30添加------------------

        responseVO.setCode(0);
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }


    /**
     * 用户开户图片验证
     *
     * @param openAccountImagesInfo
     * @return
     */
    public static boolean openAccountImagesValidate(List<OpenAccountImageInfo> openAccountImagesInfo) {
        for (OpenAccountImageInfo openAccountImageInfo : openAccountImagesInfo) {
            if (!CustomerAccountOpenHelper.imageLocationTypeValidate(openAccountImageInfo.getImageLocationType())) {
                return false;
            }
            if (!CustomerAccountOpenHelper.imageLocationValidate(openAccountImageInfo.getImageLocation())) {
                return false;
            }
        }

        return true;
    }


    /**
     * 线下开户 资料验证
     *
     * @param customerAccountOpenInfoEntity
     * @return
     */
    public static ResponseVO openAccEnteringValidate(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity) {
        ResponseVO vo = new ResponseVO();
        if (null == customerAccountOpenInfoEntity.getIdKind()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写证件类型");
            vo.setCode(-1);
            vo.setMessage("请填写证件类型");
            return vo;
        }

        if (1 == customerAccountOpenInfoEntity.getIdKind()) {
            if (null == customerAccountOpenInfoEntity.getClientName() || StringUtils.isBlank(customerAccountOpenInfoEntity.getClientName())) {
                logger.error("【线下开户手工录入接口数据完整性校验】：请填写用户姓名");
                vo.setCode(-1);
                vo.setMessage("请填写用户姓名");
                return vo;
            }
            if (null == customerAccountOpenInfoEntity.getIdCardAddress() || StringUtils.isBlank(customerAccountOpenInfoEntity.getIdCardAddress())) {
                logger.error("【线下开户手工录入接口数据完整性校验】：请填写证件地址");
                vo.setCode(-1);
                vo.setMessage("请填写证件地址");
                return vo;
            }
            if (null == customerAccountOpenInfoEntity.getIdCardValidDateEnd() || StringUtils.isBlank(customerAccountOpenInfoEntity.getIdCardValidDateEnd())) {
                logger.error("【线下开户手工录入接口数据完整性校验】：请填写证件失效日期");
                vo.setCode(-1);
                vo.setMessage("请填写证件失效日期");
                return vo;
            }
        } else if (3 == customerAccountOpenInfoEntity.getIdKind()) {
            if (null == customerAccountOpenInfoEntity.getIdCardValidDateEnd() || StringUtils.isBlank(customerAccountOpenInfoEntity.getIdCardValidDateEnd())) {
                logger.error("【线下开户手工录入接口数据完整性校验】：请填写证件失效日期");
                vo.setCode(-1);
                vo.setMessage("请填写证件失效日期");
                return vo;
            }
        }

        if (null == customerAccountOpenInfoEntity.getSourceChannelId() || StringUtils.isBlank(customerAccountOpenInfoEntity.getSourceChannelId())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写用户渠道号");
            vo.setCode(-1);
            vo.setMessage("请填写用户渠道号");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getClientNameSpell() || StringUtils.isBlank(customerAccountOpenInfoEntity.getClientNameSpell())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写用户英文名");
            vo.setCode(-1);
            vo.setMessage("请填写用户英文名");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getSex()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写性别");
            vo.setCode(-1);
            vo.setMessage("请填写性别");
            return vo;
        }

        if (null == customerAccountOpenInfoEntity.getIdNo() || StringUtils.isBlank(customerAccountOpenInfoEntity.getIdNo())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写身份证号码");
            vo.setCode(-1);
            vo.setMessage("请填写身份证号码");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getPhoneNumber() || StringUtils.isBlank(customerAccountOpenInfoEntity.getPhoneNumber())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写手机号码");
            vo.setCode(-1);
            vo.setMessage("请填写手机号码");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getEmail() || StringUtils.isBlank(customerAccountOpenInfoEntity.getEmail())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写用邮箱");
            vo.setCode(-1);
            vo.setMessage("请填写用邮箱");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getBirthday() || StringUtils.isBlank(customerAccountOpenInfoEntity.getBirthday())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写生日");
            vo.setCode(-1);
            vo.setMessage("请填写生日");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getFamilyAddress() || StringUtils.isBlank(customerAccountOpenInfoEntity.getFamilyAddress())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写住宅地址");
            vo.setCode(-1);
            vo.setMessage("请填写住宅地址");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getContactAddress() || StringUtils.isBlank(customerAccountOpenInfoEntity.getContactAddress())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写通讯地址");
            vo.setCode(-1);
            vo.setMessage("请填写通讯地址");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getNationality() || StringUtils.isBlank(customerAccountOpenInfoEntity.getNationality())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写国家/地区");
            vo.setCode(-1);
            vo.setMessage("请填写国家/地区");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getFundAccountType()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写账户类型");
            vo.setCode(-1);
            vo.setMessage("请填写账户类型");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getAnnualIncome()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写年收入");
            vo.setCode(-1);
            vo.setMessage("请填写年收入");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getCapitalSource() || StringUtils.isBlank(customerAccountOpenInfoEntity.getCapitalSource())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写收入来源");
            vo.setCode(-1);
            vo.setMessage("请填写收入来源");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getPropertyTypeList() || customerAccountOpenInfoEntity.getPropertyTypeList().size() < 1) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写财产种类");
            vo.setCode(-1);
            vo.setMessage("请填写财产种类");
            return vo;
        }

        if (null == customerAccountOpenInfoEntity.getInvestTarget()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写投资目标");
            vo.setCode(-1);
            vo.setMessage("请填写投资目标");
            return vo;
        }

        if (customerAccountOpenInfoEntity.getInvestTarget().contains("4")) {
            if (null == customerAccountOpenInfoEntity.getInvestTargetOther() || StringUtils.isBlank(customerAccountOpenInfoEntity.getInvestTargetOther())) {
                logger.error("【线下开户手工录入接口数据完整性校验】：请填写其他投资目标");
                vo.setCode(-1);
                vo.setMessage("请填写其他投资目标");
                return vo;
            }
        }

        if (null == customerAccountOpenInfoEntity.getStocksInvestmentExperienceType()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写股票投资经验");
            vo.setCode(-1);
            vo.setMessage("请填写股票投资经验");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getWarrantsInvestmentExperienceType()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写认证股权投资经验");
            vo.setCode(-1);
            vo.setMessage("请填写认证股权投资经验");
            return vo;
        }

        if (null == customerAccountOpenInfoEntity.getFuturesInvestmentExperienceType()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写期货投资经验");
            vo.setCode(-1);
            vo.setMessage("请填写期货投资经验");
            return vo;
        }
        if (null == customerAccountOpenInfoEntity.getBankType()) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写银行类型");
            vo.setCode(-1);
            vo.setMessage("请填写银行类型");
            return vo;
        }

        if (null == customerAccountOpenInfoEntity.getWitnessUser() || StringUtils.isBlank(customerAccountOpenInfoEntity.getWitnessUser())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写见证人姓名");
            vo.setCode(-1);
            vo.setMessage("请填写见证人姓名");
            return vo;
        }
//        if (null == customerAccountOpenInfoEntity.getWitnessesType() || StringUtils.isBlank(customerAccountOpenInfoEntity.getWitnessesType())) {
//            logger.error("【线下开户手工录入接口数据完整性校验】：请填写见证人类型");
//            vo.setCode(-1);
//            vo.setMessage("请填写见证人类型");
//            return vo;
//        }
        if (null == customerAccountOpenInfoEntity.getSubmitApprovalUser() || StringUtils.isBlank(customerAccountOpenInfoEntity.getSubmitApprovalUser())) {
            logger.error("【线下开户手工录入接口数据完整性校验】：请填写审批人姓名");
            vo.setCode(-1);
            vo.setMessage("请填写审批人姓名");
            return vo;
        }
//        if (null == customerAccountOpenInfoEntity.getLicenseNumber() || StringUtils.isBlank(customerAccountOpenInfoEntity.getLicenseNumber())) {
//            logger.error("【线下开户手工录入接口数据完整性校验】：请填写牌照号码");
//            vo.setCode(-1);
//            vo.setMessage("请填写牌照号码");
//            return vo;
//        }

        if (customerAccountOpenInfoEntity.getIsKnowDerivativeProducts() != null && 1 == customerAccountOpenInfoEntity.getIsKnowDerivativeProducts()) {
            if (null != customerAccountOpenInfoEntity.getDerivativeProductsStudyType() || null != customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceType()
                    || null != customerAccountOpenInfoEntity.getIsTradedDerivativeProducts()) {
                if (null != customerAccountOpenInfoEntity.getDerivativeProductsStudyType() && 7 == customerAccountOpenInfoEntity.getDerivativeProductsStudyType()) {
                    if (null == customerAccountOpenInfoEntity.getDerivativeProductsStudyTypeOther() || StringUtils.isBlank(customerAccountOpenInfoEntity.getDerivativeProductsStudyTypeOther())) {
                        logger.error("【线下开户手工录入接口数据完整性校验】：请填写衍生产品其它学习方式");
                        vo.setCode(-1);
                        vo.setMessage("请填写衍生产品其它学习方式");
                        return vo;
                    }
                }
                if (null != customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceType() && 4 == customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceType()) {
                    if (null == customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceTypeOther() || StringUtils.isBlank(customerAccountOpenInfoEntity.getFinancingInstitutionWorkExperienceTypeOther())) {
                        logger.error("【线下开户手工录入接口数据完整性校验】：请填写在金融机构其它工作经验类型");
                        vo.setCode(-1);
                        vo.setMessage("请填写在金融机构其它工作经验类型");
                        return vo;
                    }
                }
            } else {
                logger.error("【线下开户手工录入接口数据完整性校验】：请填写衍生品相关内容");
                vo.setCode(-1);
                vo.setMessage("请填写衍生品相关内容");
                return vo;
            }

        }
        vo.setCode(0);
        return vo;
    }

    /**
     * 修改 开户数据完整性校验
     *
     * @param openAccountInfo
     * @return
     */
    public static ResponseVO validateUpdateAccOpenInfo(CustomerAccOpenInfoModel openAccountInfo) {

        ResponseVO responseVO = new ResponseVO();

        if (null == openAccountInfo.getOpenAccountType()) {
            logger.error("【开户编辑资料数据完整性校验】：开户类型为空");
            responseVO.setCode(-1);
            responseVO.setMessage("开户类型为空");
            return responseVO;
        }

        if (null == openAccountInfo.getOpenAccountAccessWay()) {

            logger.error("【开户编辑资料数据完整性校验】：开户接入方式为空");
            responseVO.setCode(-1);
            responseVO.setMessage("开户接入方式为空");
            return responseVO;
        }

        if (null == openAccountInfo.getFundAccountType()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写账户类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写账户类型");
            return responseVO;
        }

        if (null == openAccountInfo.getSourceChannelId() || StringUtils.isBlank(openAccountInfo.getSourceChannelId())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写渠道号");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写渠道号");
            return responseVO;
        }

        if (null == openAccountInfo.getClientNameSpell() || StringUtils.isBlank(openAccountInfo.getClientNameSpell())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写用户英文名");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写用户英文名");
            return responseVO;
        }

        if (null == openAccountInfo.getNationality() || StringUtils.isBlank(openAccountInfo.getNationality())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写国籍");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写国籍");
            return responseVO;
        }

        if (null == openAccountInfo.getIdKind()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写身份证类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写身份证类型");
            return responseVO;
        }
        if (null == openAccountInfo.getIdNo() || StringUtils.isBlank(openAccountInfo.getIdNo())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写身份证号码");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写身份证号码");
            return responseVO;
        }
        if (null == openAccountInfo.getSex()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写性别");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写性别");
            return responseVO;
        }
        if (null == openAccountInfo.getEmail() || StringUtils.isBlank(openAccountInfo.getEmail())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写用邮箱");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写用邮箱");
            return responseVO;
        }

        if (null == openAccountInfo.getPhoneNumber() || StringUtils.isBlank(openAccountInfo.getPhoneNumber())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写手机号码");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写手机号码");
            return responseVO;
        }

        if (null == openAccountInfo.getBirthday() || StringUtils.isBlank(openAccountInfo.getBirthday())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写生日");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写生日");
            return responseVO;
        }

        if (null == openAccountInfo.getApplicationTime()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写预约申请时间");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写预约申请时间");
            return responseVO;
        }

        if (null == openAccountInfo.getInviterId() || StringUtils.isBlank(openAccountInfo.getInviterId())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写推荐人小神号");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写推荐人小神号");
            return responseVO;
        }

        if (null == openAccountInfo.getBankType()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写银行类型");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写银行类型");
            return responseVO;
        }

        if (1 == openAccountInfo.getBankType()) {
//            if (null == openAccountInfo.getBankId() || StringUtils.isBlank(openAccountInfo.getBankId())) {
//                logger.error("【开户编辑资料数据完整性校验】：请填写银行编号");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写银行编号");
//                return responseVO;
//            }
            if (null == openAccountInfo.getBankNo() || StringUtils.isBlank(openAccountInfo.getBankNo())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写银行卡号");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写银行卡号");
                return responseVO;
            }
        }

        if (1 == openAccountInfo.getIdKind()) {
            if (null == openAccountInfo.getClientName() || StringUtils.isBlank(openAccountInfo.getClientName())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写用户中文名");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写用户中文名");
                return responseVO;
            }
            if (null == openAccountInfo.getIdCardAddress() || StringUtils.isBlank(openAccountInfo.getIdCardAddress())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写证件地址");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写证件地址");
                return responseVO;
            }

            if (null == openAccountInfo.getIdCardValidDateStart() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateStart())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写身份证生效日期");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写身份证生效日期");
                return responseVO;
            }
            if (null == openAccountInfo.getIdCardValidDateEnd() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateEnd())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写身份证失效日期");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写身份证失效日期");
                return responseVO;
            }
        }
        if (3 == openAccountInfo.getIdKind()) {
//            if (null == openAccountInfo.getIdCardValidDateStart() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateStart())) {
//                logger.error("【开户编辑资料数据完整性校验】：请填写身份证生效日期");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写身份证生效日期");
//                return responseVO;
//            }
            if (null == openAccountInfo.getIdCardValidDateEnd() || StringUtils.isBlank(openAccountInfo.getIdCardValidDateEnd())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写证件失效日期");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写证件失效日期");
                return responseVO;
            }
        }

        if (null == openAccountInfo.getPropertyTypeList() || openAccountInfo.getPropertyTypeList().size() < 1) {
            logger.error("【开户编辑资料数据完整性校验】：请填写财产种类");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写财产种类");
            return responseVO;
        }
        if (null == openAccountInfo.getOtherDisclosureList() || openAccountInfo.getOtherDisclosureList().size() < 1) {
            logger.error("【开户编辑资料数据完整性校验】：请填写其他信息披露");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写其他信息披露");
            return responseVO;
        }

        if (null == openAccountInfo.getTaxationInfoList() || openAccountInfo.getTaxationInfoList().size() < 1) {
            logger.error("【开户编辑资料数据完整性校验】：请填写税务信息");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写税务信息");
            return responseVO;
        }
        if (null == openAccountInfo.getIsAllowProvidePrivacy()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写私隐信息");
            responseVO.setCode(-1);
            responseVO.setMessage("");
            return responseVO;
        }
        if (StringUtils.isEmpty(openAccountInfo.getFamilyAddress())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写住宅住址");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写住宅住址");
            return responseVO;
        }

        if (null == openAccountInfo.getContactAddress() || StringUtils.isBlank(openAccountInfo.getContactAddress())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写通讯地址");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写通讯地址");
            return responseVO;
        }


        if (null == openAccountInfo.getProfessionCode()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写就业信息");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写就业信息");
            return responseVO;
        }

        if (1 == openAccountInfo.getProfessionCode() || 2 == openAccountInfo.getProfessionCode()) {
            if (null == openAccountInfo.getCompanyName() || StringUtils.isBlank(openAccountInfo.getCompanyName())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写公司名称");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写公司名称");
                return responseVO;
            }
//            if (null == openAccountInfo.getCompanyAddress() || StringUtils.isBlank(openAccountInfo.getCompanyAddress())) {
//                logger.error("【开户编辑资料数据完整性校验】：请填写公司地址");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写公司地址");
//                return responseVO;
//            }

            if (null == openAccountInfo.getProfessionType()) {
                logger.error("【开户编辑资料数据完整性校验】：请填写所属行业");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写职业类型");
                return responseVO;
            }

            if (null == openAccountInfo.getWorkingSeniority()) {
                logger.error("【开户预约接口数据完整性校验】：请填写从业年限");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写从业年限");
                return responseVO;
            }

//            if (1 == openAccountInfo.getProfessionCode()) {
//                if (null == openAccountInfo.getJobPosition() || StringUtils.isBlank(openAccountInfo.getJobPosition())) {
//                    logger.error("【开户编辑资料数据完整性校验】：请填写职位");
//                    responseVO.setCode(-1);
//                    responseVO.setMessage("请填写职位");
//                    return responseVO;
//                }
//            }


            /*if (null == openAccountInfo.getOfficePhone() || StringUtils.isBlank(openAccountInfo.getOfficePhone())) {
                logger.error("【开户预约接口数据完整性校验】：请填写办公室电话");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写办公室电话");
                return responseVO;
            }*/
        }

        if (4 == openAccountInfo.getProfessionCode() && null == openAccountInfo.getFreelanceCode()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写自由职业名称");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写自由职业名称");
            return responseVO;
        }

        if (null != openAccountInfo.getFreelanceCode() && 0 == openAccountInfo.getFreelanceCode()) {
            if (StringUtils.isBlank(openAccountInfo.getFreelanceOther())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写其他职业名称");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写其他职业名称");
                return responseVO;
            }
        }


        if (null == openAccountInfo.getCapitalSource() || StringUtils.isBlank(openAccountInfo.getCapitalSource())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写收入来源");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写收入来源");
            return responseVO;
        }

//        if (null == openAccountInfo.getProfessionType()) {
//            if (null == openAccountInfo.getJobPosition() || StringUtils.isBlank(openAccountInfo.getJobPosition())) {
//                logger.error("【开户编辑资料数据完整性校验】：请填写职业类型");
//                responseVO.setCode(-1);
//                responseVO.setMessage("请填写职业类型");
//                return responseVO;
//            }
//        }

        if (null == openAccountInfo.getAnnualIncome()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写年收入");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写年收入");
            return responseVO;
        }


        if (null == openAccountInfo.getInvestTarget() || StringUtils.isBlank(openAccountInfo.getInvestTarget())) {
            logger.error("【开户编辑资料数据完整性校验】：请填写投资目标");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写投资目标");
            return responseVO;
        }

        if (openAccountInfo.getInvestTarget().contains("4")) {
            if (null == openAccountInfo.getInvestTargetOther() || StringUtils.isBlank(openAccountInfo.getInvestTargetOther())) {
                logger.error("【开户编辑资料数据完整性校验】：请填写其他投资目标");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写其他投资目标");
                return responseVO;
            }
        }

        if (null == openAccountInfo.getStocksInvestmentExperienceType()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写股票投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写股票投资经验");
            return responseVO;
        }
        if (null == openAccountInfo.getWarrantsInvestmentExperienceType()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写认证股权投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写认证股权投资经验");
            return responseVO;
        }
        if (null == openAccountInfo.getFuturesInvestmentExperienceType()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写期货投资经验");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写期货投资经验");
            return responseVO;
        }
        if (null == openAccountInfo.getIsKnowDerivativeProducts()) {
            logger.error("【开户编辑资料数据完整性校验】：请填写是否了解衍生品性质和风险");
            responseVO.setCode(-1);
            responseVO.setMessage("请填写是否了解衍生品性质和风险");
            return responseVO;
        }

        if (1 == openAccountInfo.getIsKnowDerivativeProducts()) {
            if (null != openAccountInfo.getDerivativeProductsStudyType() || null != openAccountInfo.getFinancingInstitutionWorkExperienceType()
                    || null != openAccountInfo.getIsTradedDerivativeProducts()) {
                if (null != openAccountInfo.getDerivativeProductsStudyType() && 7 == openAccountInfo.getDerivativeProductsStudyType()) {
                    if (null == openAccountInfo.getDerivativeProductsStudyTypeOther() || StringUtils.isBlank(openAccountInfo.getDerivativeProductsStudyTypeOther())) {
                        logger.error("【开户编辑资料数据完整性校验】：请填写衍生产品其它学习方式");
                        responseVO.setCode(-1);
                        responseVO.setMessage("请填写衍生产品其它学习方式");
                        return responseVO;
                    }
                }
                if (null != openAccountInfo.getFinancingInstitutionWorkExperienceType() && 4 == openAccountInfo.getFinancingInstitutionWorkExperienceType()) {
                    if (null == openAccountInfo.getFinancingInstitutionWorkExperienceTypeOther() || StringUtils.isBlank(openAccountInfo.getFinancingInstitutionWorkExperienceTypeOther())) {
                        logger.error("【开户编辑资料数据完整性校验】：请填写在金融机构其它工作经验类型");
                        responseVO.setCode(-1);
                        responseVO.setMessage("请填写在金融机构其它工作经验类型");
                        return responseVO;
                    }
                }
            } else {
                logger.error("【开户编辑资料数据完整性校验】：请填写衍生品相关内容");
                responseVO.setCode(-1);
                responseVO.setMessage("请填写衍生品相关内容");
                return responseVO;
            }

        }

        responseVO.setCode(0);
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        return responseVO;
    }

}
