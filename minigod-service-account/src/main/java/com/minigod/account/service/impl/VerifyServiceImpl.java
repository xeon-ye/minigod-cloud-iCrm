package com.minigod.account.service.impl;

import com.minigod.account.helper.FileStorageHelper;
import com.minigod.account.helper.TencentApiIaiHelper;
import com.minigod.common.utils.ImageUtils;
import com.minigod.common.utils.JSONUtil;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.account.helper.RestBpmHelper;
import com.minigod.account.helper.TencentApiFaceIdHelper;
import com.minigod.persist.account.mapper.*;
import com.minigod.protocol.account.model.*;
import com.minigod.protocol.account.request.params.VerifyReqParams;
import com.minigod.protocol.account.response.VerifyResVo;
import com.minigod.account.service.VerifyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.tencentcloudapi.faceid.v20180301.models.*;
import com.tencentcloudapi.iai.v20200303.models.DetectLiveFaceResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
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
    VerifyLiveFaceMapper verifyLiveFaceMapper;
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    RestBpmHelper restBpmHelper;
    @Autowired
    TencentApiFaceIdHelper tencentApiFaceIdHelper;
    @Autowired
    TencentApiIaiHelper tencentApiIaiHelper;

    @Autowired
    FileStorageHelper fileStorageHelper;

    @Value("${minigod.openAccount.isVerifyFromBpm}")
    private Boolean IS_VERIFY_FROM_BPM;

    @Value("${minigod.openAccount.isVerifyIdCardFromThird}")
    private Boolean IS_VERIFY_ID_CARD_FROM_THIRD;

    @Value("${minigod.openAccount.isVerifyBankCardFromThird}")
    private Boolean IS_VERIFY_BANK_CARD_FROM_THIRD;

    @Value("${minigod.openAccount.isVerifyLiveFaceFromThird}")
    private Boolean IS_VERIFY_LIVE_FACE_FROM_THIRD;

    @Value("${minigod.openAccount.validLiveScore}")
    private Double VALID_LIVE_SCORE_VALUE;

    private String API_GET_SEAL_PDF = "/SecuritiesAccount/service/reqGetSealPDFFile";


    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    Integer MAX_VERIFY_COUNT_DAILY = 5;

    @PostConstruct
    private void init() {
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

        if (IS_VERIFY_FROM_BPM) {
            // bpm中心校验
            return !restBpmHelper.verifyPhone(phone);
        }

        return false;
    }

    @Override
    public Boolean isEmailUsed(String email) {
        // 参数校验
        if (StringUtils.isBlank(email) || !VerifyUtil.isEmail(email)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_EMAIL);
        }

        if (IS_VERIFY_FROM_BPM) {
            // bpm中心校验
            return !restBpmHelper.verifyEmail(email);
        }

        return false;
    }

    @Override
    public Boolean isIdCardUsed(String idCard) {
        // 参数校验
        if (StringUtils.isBlank(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
        }

        if (IS_VERIFY_FROM_BPM) {
            // 调用bpm中心校验（黑名单/已开户）
            return !restBpmHelper.verifyIdCard(idCard);
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
            // 调用bpm中心校验
            if (IS_VERIFY_FROM_BPM && !restBpmHelper.verifyPhone(phone)) {
                // bpm校验不通过，返回手机号已使用
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
            // 调用bpm中心校验
            if (IS_VERIFY_FROM_BPM && !restBpmHelper.verifyEmail(email)) {
                // bpm校验不通过，返回邮箱已使用
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
        if (params == null) {
            log.error("身份证校验参数错误：params = ", JSONUtil.toJson(params));
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = params.getIdCard();
        String userName = params.getUserName();
        Integer cardType = params.getCardType();

        if (StringUtils.isBlank(idCard)) {
            log.error("身份证校验参数错误：params = ", JSONUtil.toJson(params));
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        Boolean isIdCardCn = cardType.equals(1);

        if (isIdCardCn) {
            if (StringUtils.isBlank(userName)) {
                log.error("身份证校验参数错误：params = ", JSONUtil.toJson(params));
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }

            if (!VerifyUtil.isIDNo(idCard)) {
                log.error("身份证校验参数错误：idCard = ", idCard);
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_FORMAT_ID_CARD);
            }
        }
        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用bpm中心校验（黑名单/已开户）
            if (IS_VERIFY_FROM_BPM && !restBpmHelper.verifyIdCard(params.getIdCard())) {
                // bpm校验不通过，返回账号已使用/不支持
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.ID_CARD_USED_OR_UNSUPPORT));
                return verifyResVo;
            }

            // 非境内卡
            if (!isIdCardCn) {
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
            localVerifyBankCard.setCheckDate(new Date());
            localVerifyBankCard.setRemark(remark);
            localVerifyBankCard.setUpdateTime(new Date());

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

    private Boolean isValidLive(Boolean isLiveness, Float score) {
        if (isLiveness == null || score == null) {
            return false;
        }

        if (!isLiveness && score < VALID_LIVE_SCORE_VALUE) {
            return false;
        }
        return true;
    }

    @Override
    public VerifyResVo verifyLiveFace(VerifyReqParams params, Integer userId) {
        // 参数校验
        if (params == null || userId == null || StringUtils.isBlank(params.getLiveImage())) {
            log.error("活体校验参数错误：params = ", JSONUtil.toJson(params));
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String liveImage = params.getLiveImage();

        String imgBase = ImageUtils.loadImgBase64ByUrl(liveImage);

        // 真实照片校验
        if (StringUtils.isEmpty(imgBase)) {
            log.error("活体校验图片解析异常：liveImage = ", liveImage);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 不启用活体校验，直接返回成功，并记录本地记录
            if (!IS_VERIFY_LIVE_FACE_FROM_THIRD) {
                return verifyResVo;
            }

            // 启用活体校验
            // 本地完全匹配数据
            VerifyLiveFace localVerifyLiveFace = verifyLiveFaceMapper.selectOneByUserIdAndImgUrl(userId, liveImage);

            // 本地完全匹配数据，本地核验
            if (localVerifyLiveFace != null) {
                if (!isValidLive(localVerifyLiveFace.getIsLiveness(), localVerifyLiveFace.getScore())) {
                    verifyResVo.setIsValid(false);
                    verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_LIVE_FACE));
                }

                return verifyResVo;
            }

            // 获取本地错误校验记录
            List<VerifyLiveFace> localVerifyListToday = verifyLiveFaceMapper.selectByUserIdAndCheckDate(userId, new Date());

            // 超过当日校验次数
            if (localVerifyListToday.size() >= MAX_VERIFY_COUNT_DAILY) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_VERIFY_LIVE_FACE_COUNT);
            }

            Boolean isValid = false;
            Boolean isLiveness = false;
            Float score = (float) 0;
            String remark = null;

            // 进行公安系统校验
            DetectLiveFaceResponse detectLiveFaceResponse = tencentApiIaiHelper.detectLiveFace(liveImage);

            if (detectLiveFaceResponse == null) {
                log.error("第三方活体校验错误，无认证信息返回");
                remark = "调用远程认证失败";
            } else {
                isLiveness = detectLiveFaceResponse.getIsLiveness() == null ? false : detectLiveFaceResponse.getIsLiveness();
                score = detectLiveFaceResponse.getScore() == null ? 0 : detectLiveFaceResponse.getScore();
                isValid = isValidLive(isLiveness, score);
                if (!isValid) {
                    log.error("第三方活体校验错误，认证失败：", JSONUtil.toJson(detectLiveFaceResponse));
                    remark = detectLiveFaceResponse.getRequestId();
                }
            }

            // 校验完成
            VerifyLiveFace verifyLiveFace = new VerifyLiveFace();
            verifyLiveFace.setUserId(userId);
            verifyLiveFace.setImgUrl(liveImage);
            verifyLiveFace.setIsLiveness(isLiveness);
            verifyLiveFace.setScore(score);
            verifyLiveFace.setRemark(remark);
            verifyLiveFace.setCheckDate(new Date());
            verifyLiveFace.setCreateTime(new Date());
            verifyLiveFace.setUpdateTime(new Date());

            verifyLiveFaceMapper.insertSelective(verifyLiveFace);

            verifyResVo.setIsValid(isValid);
            if (!isValid) {
                log.error("活体校验失败");
                verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_LIVE_FACE));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, StaticType.MessageResource.FAIL_VERIFY_LIVE_FACE));
        }
        return verifyResVo;
    }
}
