package com.minigod.account.service.impl;

import com.minigod.account.helper.FileStorageHelper;
import com.minigod.account.utils.SzcaHttpClient;
import com.minigod.common.utils.JSONUtil;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.account.helper.RestCubpHelper;
import com.minigod.account.helper.TencentApiFaceIdHelper;
import com.minigod.persist.account.mapper.*;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.*;
import com.minigod.protocol.account.request.params.VerifyReqParams;
import com.minigod.protocol.account.response.VerifyResVo;
import com.minigod.account.service.VerifyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.request.*;
import com.minigod.protocol.account.szca.response.*;
import com.tencentcloudapi.faceid.v20180301.models.BankCard4EVerificationResponse;
import com.tencentcloudapi.faceid.v20180301.models.IdCardVerificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class VerifyServiceImpl extends BaseBeanFactory implements VerifyService {
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;
    @Autowired
    VerifyIdCardMapper verifyIdCardMapper;
    @Autowired
    VerifyAuthCaMapper verifyAuthCaMapper;
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    RestCubpHelper restCubpHelper;
    @Autowired
    TencentApiFaceIdHelper tencentApiFaceIdHelper;

    @Autowired
    FileStorageHelper fileStorageHelper;

    @Value("${minigod.openAccount.isVerifyFromCubp}")
    private Boolean IS_VERIFY_FROM_CUBP;

    @Value("${minigod.openAccount.isVerifyIdCardFromThird}")
    private Boolean IS_VERIFY_ID_CARD_FROM_THIRD;

    @Value("${minigod.openAccount.isVerifyBankCardFromThird}")
    private Boolean IS_VERIFY_BANK_CARD_FROM_THIRD;

    @Value("${minigod.szca.isRemote}")
    private Boolean isRemote;

    @Value("${minigod.szca.orgName}")
    private String SZCA_ORG_NAME;

    @Value("${minigod.szca.orgCode}")
    private String SZCA_ORG_CORD;

    @Value("${minigod.szca.applyType}")
    private String SZCA_ORG_APPLY_TYPE;

    @Value("${minigod.szca.tokenType}")
    private String SZCA_ORG_TOKEN_TYPE;

    @Value("${minigod.szca.url}")
    private String SZCA_API_URL;

    @Value("${minigod.szca.getToken}")
    private String API_GET_TOKEN;

    @Value("${minigod.szca.getCert}")
    private String API_GET_CERT;

    @Value("${minigod.szca.getCertApplyP10}")
    private String API_GET_CERT_APPLY_P10;

    @Value("${minigod.szca.getSignP7ForPdf}")
    private String API_GET_SIGN_P7_FOR_PDF;

    @Value("${minigod.szca.getPDFInfoForSign}")
    private String API_GET_PDF_INFO_FOR_SIGN;

    private String API_GET_SEAL_PDF = "/SecuritiesAccount/service/reqGetSealPDFFile";

    private String URL_GET_TOKEN = "";
    private String URL_GET_CERT = "";
    private String URL_GET_CERT_APPLY_P10 = "";
    private String URL_GET_SIGN_P7_FOR_PDF = "";
    private String URL_GET_PDF_INFO_FOR_SIGN = "";
    private String URL_GET_SEAL_PDF = "";


    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    Integer MAX_VERIFY_COUNT_DAILY = 5;

    @PostConstruct
    private void init() {
        URL_GET_TOKEN = SZCA_API_URL + API_GET_TOKEN;
        URL_GET_CERT = SZCA_API_URL + API_GET_CERT;
        URL_GET_CERT_APPLY_P10 = SZCA_API_URL + API_GET_CERT_APPLY_P10;
        URL_GET_SIGN_P7_FOR_PDF = SZCA_API_URL + API_GET_SIGN_P7_FOR_PDF;
        URL_GET_PDF_INFO_FOR_SIGN = SZCA_API_URL + API_GET_PDF_INFO_FOR_SIGN;
        URL_GET_SEAL_PDF = SZCA_API_URL + API_GET_SEAL_PDF;
    }


    private VerifyResVo verifyResVoChecked() {
        // 默认校验通过
        VerifyResVo verifyResVo = new VerifyResVo();
        verifyResVo.setIsValid(true);
        verifyResVo.setRemark("");

        return verifyResVo;
    }

    @Override
    public Boolean isPhoneUsed(String phone) {
        // 参数校验
        if (StringUtils.isBlank(phone) || !VerifyUtil.verifyMobile(phone)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_PHONE);
        }

        if (IS_VERIFY_FROM_CUBP) {
            // cubp中心校验
            return !restCubpHelper.verifyPhone(phone);
        }

        return false;
    }

    @Override
    public Boolean isEmailUsed(String email) {
        // 参数校验
        if (StringUtils.isBlank(email) || !VerifyUtil.isEmail(email)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_EMAIL);
        }

        if (IS_VERIFY_FROM_CUBP) {
            // cubp中心校验
            return !restCubpHelper.verifyEmail(email);
        }

        return false;
    }

    @Override
    public Boolean isIdCardUsed(String idCard) {
        // 参数校验
        if (StringUtils.isBlank(idCard) || !VerifyUtil.isIDNo(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }

        if (IS_VERIFY_FROM_CUBP) {
            // 调用cubp中心校验（黑名单/已开户）
            return !restCubpHelper.verifyIdCard(idCard);
        }
        return false;
    }

    @Override
    public Boolean isIdCardValid(String idCard, String userName) {
        // 参数校验
        if (StringUtils.isBlank(idCard) || !VerifyUtil.isIDNo(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }

        List<VerifyIdCard> localVerifyIdCards = verifyIdCardMapper.selectByIdCardAndStatus(idCard, null);

        // 本地无记录
        if (localVerifyIdCards.size() == 0) {
            return false;
        }

        // 启用身份证公安校验，判断本地记录是否认证通过
        if (IS_VERIFY_ID_CARD_FROM_THIRD) {
            // 本地唯一数据
            VerifyIdCard localVerifiedIdCard = null;
            for (VerifyIdCard localVerifyIdCard : localVerifyIdCards) {
                if (localVerifyIdCard.getStatus().equals(1)) {
                    localVerifiedIdCard = localVerifyIdCard;
                }
            }

            return (localVerifiedIdCard != null && localVerifiedIdCard.getUserName().equals(userName));
        }

        return true;
    }

    @Override
    public Boolean isBankCardValid(String idCard, String userName, String bankCard) {
        // 参数校验
        if (StringUtils.isBlank(idCard) || !VerifyUtil.isIDNo(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }
        if (StringUtils.isBlank(bankCard) || !VerifyUtil.isNumber(bankCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }

        List<VerifyBankCard> localVerifyBankCards = verifyBankCardMapper.selectByBankCardAndStatus(bankCard, null);

        // 本地无记录
        if (localVerifyBankCards.size() == 0) {
            return false;
        }

        // 启用银行卡公安校验，判断本地记录是否认证通过
        if (IS_VERIFY_BANK_CARD_FROM_THIRD) {
            // 本地唯一数据
            VerifyBankCard localVerifiedBankCard = null;
            for (VerifyBankCard localVerifyBankCard : localVerifyBankCards) {
                if (localVerifyBankCard.getStatus().equals(1)) {
                    localVerifiedBankCard = localVerifyBankCard;
                }
            }

            return (localVerifiedBankCard != null && localVerifiedBankCard.getIdCard().equals(idCard) && localVerifiedBankCard.getUserName().equals(userName));
        }

        return true;
    }

    @Override
    public VerifyResVo verifyPhone(VerifyReqParams params) {
        // 参数校验
        if (params == null || StringUtils.isBlank(params.getPhone())) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        String phone = params.getPhone();

        if (!VerifyUtil.verifyMobile(phone)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_PHONE);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用cubp中心校验
            if (IS_VERIFY_FROM_CUBP && !restCubpHelper.verifyPhone(phone)) {
                // cubp校验不通过，返回手机号已使用
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.PHONE_IS_USED));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_PHONE));
        }
        return verifyResVo;
    }

    @Override
    public VerifyResVo verifyEmail(VerifyReqParams params) {
        // 参数校验
        if (params == null || StringUtils.isBlank(params.getEmail())) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        String email = params.getEmail();

        if (!VerifyUtil.isEmail(email)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_EMAIL);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用cubp中心校验
            if (IS_VERIFY_FROM_CUBP && !restCubpHelper.verifyEmail(email)) {
                // cubp校验不通过，返回邮箱已使用
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.EMAIL_IS_USED));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_EMAIL));
        }
        return verifyResVo;
    }

    @Override
    public VerifyResVo verifyIdCard(VerifyReqParams params) {
        // 参数校验
        if (params == null || StringUtils.isBlank(params.getIdCard()) || StringUtils.isBlank(params.getUserName())) {
            log.error("身份证校验参数错误：params = ", JSONUtil.toJson(params));
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = params.getIdCard();
        String userName = params.getUserName();

        if (!VerifyUtil.isIDNo(idCard)) {
            log.error("身份证校验参数错误：idCard = ", idCard);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用cubp中心校验（黑名单/已开户）
            if (IS_VERIFY_FROM_CUBP && !restCubpHelper.verifyIdCard(params.getIdCard())) {
                // cubp校验不通过，返回账号已使用/不支持
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.ID_CARD_USED_OR_UNSUPPORT));
                return verifyResVo;
            }


            // 本地唯一数据
            VerifyIdCard localVerifyIdCard = verifyIdCardMapper.selectOneByIdCardAndUserName(idCard, userName);

            // 本地无相关记录，直接插入
            if (localVerifyIdCard == null) {
                localVerifyIdCard = new VerifyIdCard();
                localVerifyIdCard.setIdCard(idCard);
                localVerifyIdCard.setUserName(userName);
                localVerifyIdCard.setCreateTime(new Date());
                localVerifyIdCard.setUpdateTime(new Date());
                localVerifyIdCard.setStatus(-1);
                verifyIdCardMapper.insertSelective(localVerifyIdCard);
            }

            // 不启用身份证公安校验，直接返回成功，并记录本地记录
            if (!IS_VERIFY_ID_CARD_FROM_THIRD) {
                return verifyResVo;
            }

            // 启用身份证公安校验
            // 获取本地白名单
            List<VerifyIdCard> validIdCardList = verifyIdCardMapper.selectByIdCardAndStatus(idCard, 1);

            // 数据异常
            if (validIdCardList.size() > 1) {
                log.error("身份证本地校验数据异常：validIdCardList = ", JSONUtil.toJson(validIdCardList));
                throw new InternalApiException(StaticType.CodeType.ERROR_UNKNOWN, StaticType.MessageResource.ERROR_UNKNOWN);
            }

            VerifyIdCard validIdCard = null;

            // 白名单数据存在
            if (validIdCardList.size() == 1) {
                validIdCard = validIdCardList.get(0);
                // 校验不通过
                if (!validIdCard.getUserName().equals(userName)) {
                    verifyResVo.setIsValid(false);
                    verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_ID_CARD));
                }
                // 校验通过，增加校验次数
                else {
                    validIdCard.setCheckCount(validIdCard.getCheckCount() + 1);
                    validIdCard.setUpdateTime(new Date());
                    verifyIdCardMapper.updateByPrimaryKey(validIdCard);
                }
                return verifyResVo;
            }

            // 本地错误记录
            List<VerifyIdCard> errorIdCardList = verifyIdCardMapper.selectByIdCardAndStatus(idCard, 0);

            // 本地存在错误记录
            if (errorIdCardList.size() > 0) {
                int cnt = 0;
                String nowDateStr = dateFormat.format(new Date());
                for (VerifyIdCard errorIdCard : errorIdCardList) {
                    if (errorIdCard.getUserName().equals(userName)) {
                        verifyResVo.setIsValid(false);
                        verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_ID_CARD));
                        return verifyResVo;
                    }
                    Date createDate = errorIdCard.getCheckDate();
                    String createDateStr = dateFormat.format(createDate);
                    if (nowDateStr.equals(createDateStr)) {
                        cnt = cnt + 1;
                    }
                }

                // 超过次数
                if (cnt >= MAX_VERIFY_COUNT_DAILY) {
                    throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_VERIFY_ID_CARD_COUNT);
                }
            }

            boolean isValid = true;
            String remark = null;

            // 本地无相关记录，是否进行公安系统校验
            IdCardVerificationResponse idCardVerificationResponse = tencentApiFaceIdHelper.verifyIdCard(idCard, userName);

            if (idCardVerificationResponse == null) {
                log.error("第三方身份证校验错误，无认证信息返回");
                isValid = false;
                remark = "调用远程认证失败";
            } else if (!idCardVerificationResponse.getResult().equals("0")) {
                log.error("第三方身份证校验错误，认证不通过：", JSONUtil.toJson(idCardVerificationResponse));
                isValid = false;
                remark = idCardVerificationResponse.getRequestId() + "-" + idCardVerificationResponse.getDescription();
            }

            // 校验完成
            localVerifyIdCard.setUpdateTime(new Date());
            localVerifyIdCard.setCheckDate(new Date());
            localVerifyIdCard.setCheckCount(1);
            localVerifyIdCard.setStatus(isValid ? 1 : 0);
            localVerifyIdCard.setRemark(remark);

            verifyIdCardMapper.updateByPrimaryKeySelective(localVerifyIdCard);

            verifyResVo.setIsValid(isValid);

            if (!isValid) {
                log.error("身份证校验失败");
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_ID_CARD));
            }

        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_ID_CARD));
        }
        return verifyResVo;
    }

    @Override
    public VerifyResVo verifyBankCard4E(VerifyReqParams params) {
        // 参数校验
        if (params == null ||
                StringUtils.isBlank(params.getIdCard()) ||
                StringUtils.isBlank(params.getUserName()) ||
                StringUtils.isBlank(params.getBankCard()) ||
                StringUtils.isBlank(params.getPhone())) {
            log.error("四要素校验参数错误：params = ", JSONUtil.toJson(params));
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = params.getIdCard();
        String userName = params.getUserName();
        String phone = params.getPhone();
        String bankCard = params.getBankCard();

        if (!VerifyUtil.isIDNo(idCard)) {
            log.error("四要素校验参数错误：idCard = ", idCard);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }

        if (!VerifyUtil.verifyMobile(phone)) {
            log.error("四要素校验参数错误：phone = ", phone);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_PHONE);
        }

        if (!VerifyUtil.isNumber(bankCard)) {
            log.error("四要素校验参数错误：bankCard = ", bankCard);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_BANK_CARD);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {

            // 本地唯一数据
            VerifyBankCard localVerifyBankCard = verifyBankCardMapper.selectOneByIdCardAndUserNameAndBankCardAndPhone(idCard, userName, bankCard, phone);

            // 本地无相关记录，直接插入
            if (localVerifyBankCard == null) {
                localVerifyBankCard = new VerifyBankCard();
                localVerifyBankCard.setIdCard(idCard);
                localVerifyBankCard.setUserName(userName);
                localVerifyBankCard.setBankCard(bankCard);
                localVerifyBankCard.setPhone(phone);
                localVerifyBankCard.setCreateTime(new Date());
                localVerifyBankCard.setUpdateTime(new Date());
                localVerifyBankCard.setStatus(-1);
                verifyBankCardMapper.insertSelective(localVerifyBankCard);
            }

            // 不启用银行卡四要素公安校验，直接返回成功，并记录本地记录
            if (!IS_VERIFY_BANK_CARD_FROM_THIRD) {
                return verifyResVo;
            }

            // 启用银行卡四要素公安校验
            // 获取本地白名单列表
            List<VerifyBankCard> validBankCardList = verifyBankCardMapper.selectByBankCardAndStatus(bankCard, 1);

            // 数据异常
            if (validBankCardList.size() > 1) {
                log.error("四要素本地校验数据异常：validBankCardList = ", JSONUtil.toJson(validBankCardList));
                throw new InternalApiException(StaticType.CodeType.ERROR_UNKNOWN, StaticType.MessageResource.ERROR_UNKNOWN);
            }

            // 获取本地白名单
            VerifyBankCard validBankCard = null;

            // 白名单数据存在
            if (validBankCardList.size() == 1) {
                validBankCard = validBankCardList.get(0);
                // 校验不通过
                if (!validBankCard.getIdCard().equals(idCard) || !validBankCard.getUserName().equals(userName) || !validBankCard.getPhone().equals(phone)) {
                    verifyResVo.setIsValid(false);
                    verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_BANK_CARD));
                }
                // 校验通过，增加校验次数
                else {
                    validBankCard.setCheckCount(validBankCard.getCheckCount() + 1);
                    validBankCard.setUpdateTime(new Date());
                    verifyBankCardMapper.updateByPrimaryKey(validBankCard);
                }
                return verifyResVo;
            }


            // 获取本地错误校验记录
            List<VerifyBankCard> errorVerifyList = verifyBankCardMapper.selectByBankCardAndStatus(bankCard, 0);

            // 本地存在错误记录
            if (errorVerifyList.size() > 0) {
                int cnt = 0;
                String nowDateStr = dateFormat.format(new Date());
                for (VerifyBankCard errorBankCard : errorVerifyList) {
                    if (errorBankCard.getIdCard().equals(idCard) && errorBankCard.getUserName().equals(userName) && errorBankCard.getPhone().equals(phone)) {
                        verifyResVo.setIsValid(false);
                        verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_BANK_CARD));
                        return verifyResVo;
                    }

                    Date createDate = errorBankCard.getCheckDate();
                    String createDateStr = dateFormat.format(createDate);
                    if (nowDateStr.equals(createDateStr)) {
                        cnt = cnt + 1;
                    }
                }

                // 超过次数
                if (cnt >= MAX_VERIFY_COUNT_DAILY) {
                    throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_VERIFY_BANK_CARD_COUNT);
                }
            }

            Boolean isValid = true;
            String remark = null;

            // 本地无相关记录，进行公安系统校验
            BankCard4EVerificationResponse bankCard4EVerificationResponse = tencentApiFaceIdHelper.verifyBankCard4E(idCard, userName, phone, bankCard);

            if (bankCard4EVerificationResponse == null) {
                log.error("第三方四要素校验错误，无认证信息返回");
                isValid = false;
                remark = "调用远程认证失败";
            } else if (!bankCard4EVerificationResponse.getResult().equals("0")) {
                log.error("第三方四要素校验错误，认证失败：", JSONUtil.toJson(bankCard4EVerificationResponse));
                isValid = false;
                remark = bankCard4EVerificationResponse.getRequestId() + "-" + bankCard4EVerificationResponse.getDescription();
            }

            // 校验完成
            localVerifyBankCard.setStatus(isValid ? 1 : 0);
            localVerifyBankCard.setCheckCount(1);
            localVerifyBankCard.setRemark(remark);
            localVerifyBankCard.setUpdateTime(new Date());
            localVerifyBankCard.setCheckDate(new Date());

            verifyBankCardMapper.updateByPrimaryKeySelective(localVerifyBankCard);

            verifyResVo.setIsValid(isValid);
            if (!isValid) {
                log.error("银行卡四要素公安系统校验失败");
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_BANK_CARD));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_BANK_CARD));
        }
        return verifyResVo;
    }

    @Override
    public VerifySzcaPojo getTokenBySzca() {
        SzcaTokenReqVo reqVo = new SzcaTokenReqVo();

        reqVo.setOrgCode(SZCA_ORG_CORD);
        reqVo.setOrgName(SZCA_ORG_NAME);
        reqVo.setApplyType(SZCA_ORG_APPLY_TYPE);
        reqVo.setTokenType(SZCA_ORG_TOKEN_TYPE);

        SzcaTokenResVo szcaTokenResVo = SzcaHttpClient.getResult(URL_GET_TOKEN, "token", reqVo, SzcaTokenResVo.class);
        VerifySzcaPojo resVo = new VerifySzcaPojo();

        // CA 已经存在用户认证信息
        if (szcaTokenResVo.getRetCode().equals("0")) {
            resVo.setToken(szcaTokenResVo.getToken());
        }

        return resVo;
    }

    @Override
    public VerifyAuthCa getCertDnBySzca(SzcaCertDnReqVo reqVo) {
        // 参数校验
        if (reqVo == null) {
            log.error("SZCA_获取主题参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String token = reqVo.getToken();
        String idCard = reqVo.getIdNo();
        String userName = reqVo.getUserName();

        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || !VerifyUtil.isIDNo(idCard)) {
            log.error("SZCA_获取主题参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByIdCard(idCard);

        if (localAuthCa == null) {
            localAuthCa = new VerifyAuthCa();
            localAuthCa.setIdCard(idCard);
            localAuthCa.setUserName(userName);
            localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW);
            localAuthCa.setCreateTime(new Date());
            localAuthCa.setUpdateTime(new Date());

            verifyAuthCaMapper.insertSelective(localAuthCa);
        }


        // 本地记录未校验，进行SZCA远程校验
        if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P10)) {
            SzcaCertDnResVo szcaCertDnResVo = SzcaHttpClient.getResult(URL_GET_CERT, "getCertDN", reqVo, SzcaCertDnResVo.class);

            if (szcaCertDnResVo.getRetCode().equals("0")) {
                String resState = szcaCertDnResVo.getState();
                String resCertDn = szcaCertDnResVo.getCertDN();
                String resCertSn = szcaCertDnResVo.getCertSn();


                // CA 已经存在用户认证信息
                if (resState.equals("loseCert") && StringUtils.isNotEmpty(resCertSn)) {
                    localAuthCa.setCertSn(resCertSn);
                    localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW + VerifyAuthCaStatusEnum.CA_P10);
                } else {
                    localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW);
                }

                localAuthCa.setIdCard(idCard);
                localAuthCa.setUserName(userName);
                localAuthCa.setCertDn(resCertDn);
                localAuthCa.setUpdateTime(new Date());

                verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
            }
        }

        return localAuthCa;

    }

    @Override
    public VerifyAuthCa getCertApplyP10BySzca(SzcaCertApplyP10ReqVo reqVo) {
        // 参数校验
        if (reqVo == null) {
            log.error("SZCA_申请证书参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = reqVo.getIdNo();
        String userName = reqVo.getUserName();
        String certDn = reqVo.getCertDn();

        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(certDn) || !VerifyUtil.isIDNo(idCard)) {
            log.error("SZCA_申请证书参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByIdCard(idCard);

        if (localAuthCa == null || !certDn.equals(localAuthCa.getCertDn()) || !userName.equals(localAuthCa.getUserName())) {
            // 数据异常
            log.error("SZCA_申请证书参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 本地记录未校验，进行SZCA远程校验
        if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P10)) {

            SzcaCertApplyP10ResVo szcaCertApplyP10ResVo = SzcaHttpClient.getResult(URL_GET_SIGN_P7_FOR_PDF, "apply", reqVo, SzcaCertApplyP10ResVo.class);

            if (szcaCertApplyP10ResVo.getRetCode().equals("0")) {
                localAuthCa.setCertSn(szcaCertApplyP10ResVo.getCertSn());
                localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW + VerifyAuthCaStatusEnum.CA_P10);
                localAuthCa.setUpdateTime(new Date());

                verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
            }
        }

        return localAuthCa;
    }

    @Override
    public VerifyAuthCa getSignP7ForPdfBySzca(SzcaSignP7ForPdfReqVo reqVo) {
        // 参数校验
        if (reqVo == null) {
            log.error("SZCA_合成pdv参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String certDn = reqVo.getCertDn();
        String certSn = reqVo.getCertSn();
        String fileId = reqVo.getFileID();

        if (StringUtils.isEmpty(certDn)) {
            log.error("SZCA_合成pdv参数错误， reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByCertDn(certDn);

        if (localAuthCa == null || !certDn.equals(localAuthCa.getCertDn()) || !certSn.equals(localAuthCa.getCertSn()) || !fileId.equals(localAuthCa.getFileId())) {
            log.error("SZCA_合成pdv参数错误：reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 本地记录未校验，进行SZCA远程校验
        if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P7_PDF)) {
            SzcaSignP7ForPdfResVo szcaSignP7ForPdfResVo = SzcaHttpClient.getResult(URL_GET_SIGN_P7_FOR_PDF, "sign", reqVo, SzcaSignP7ForPdfResVo.class);

            if (szcaSignP7ForPdfResVo.getRetCode().equals("0")) {
                // 上传文件
                String fileName = fileId + "_" + System.currentTimeMillis() + ".pdf";
                String fileUrl = fileStorageHelper.uploadPdf(fileName, szcaSignP7ForPdfResVo.getFile());
                localAuthCa.setFilePdfUrl(fileUrl);
                localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW + VerifyAuthCaStatusEnum.CA_P10 + VerifyAuthCaStatusEnum.CA_SIGN + VerifyAuthCaStatusEnum.CA_P7_PDF);
                localAuthCa.setUpdateTime(new Date());

                verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
            }
        }

        return localAuthCa;
    }

    @Override
    public VerifyAuthCa getPdfInfoForSignBySzca(SzcaPdfInfoForSignReqVo reqVo, InputStream fileInput) {
        // 参数校验
        if (reqVo == null || fileInput == null) {
            log.error("SZCA_针对 PDF 文件生成签名域参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        String idCard = reqVo.getIdCode();
        String certDn = reqVo.getCertDn();
        String certSn = reqVo.getCertSn();

        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(certDn) || StringUtils.isEmpty(certSn) || !VerifyUtil.isIDNo(idCard)) {
            log.error("SZCA_针对 PDF 文件生成签名域错误：reqVo = {}", reqVo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        try {
            VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectOneByIdCard(idCard);

            if (localAuthCa == null || !certDn.equals(localAuthCa.getCertDn()) || !certSn.equals(localAuthCa.getCertSn())) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
            }

            // 本地记录未校验，进行SZCA远程校验
            if (localAuthCa.getStatus() == null || !VerifyAuthCaStatusEnum.isFlag(localAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_SIGN)) {


                SzcaPdfInfoForSignResVo szcaPdfInfoForSignResVo = SzcaHttpClient.getResult(URL_GET_PDF_INFO_FOR_SIGN, "getPdf", reqVo, fileInput, SzcaPdfInfoForSignResVo.class);

                if (szcaPdfInfoForSignResVo.getRetCode().equals("0")) {

                    localAuthCa.setFileHash(szcaPdfInfoForSignResVo.getFileHash());
                    localAuthCa.setFileId(szcaPdfInfoForSignResVo.getFileID());
                    localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW + VerifyAuthCaStatusEnum.CA_P10 + VerifyAuthCaStatusEnum.CA_SIGN);
                    localAuthCa.setUpdateTime(new Date());

                    verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
                }
            }

            return localAuthCa;


        } catch (Exception e) {
        }


        return null;
    }
}
