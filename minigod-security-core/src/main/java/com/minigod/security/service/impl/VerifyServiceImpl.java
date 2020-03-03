package com.minigod.security.service.impl;

import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.security.helper.RestCubpHelper;
import com.minigod.security.helper.TencentApiFaceIdHelper;
import com.minigod.security.helper.TencentApiOcrHelper;
import com.minigod.security.mapper.VerifyBankCardMapper;
import com.minigod.security.mapper.VerifyIdCardMapper;
import com.minigod.security.protocol.model.VerifyBankCard;
import com.minigod.security.protocol.model.VerifyIdCard;
import com.minigod.security.protocol.vo.request.params.VerifyReqParams;
import com.minigod.security.protocol.vo.response.VerifyResVo;
import com.minigod.security.protocol.enums.CubpMessageResource;
import com.minigod.security.service.VerifyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.tencentcloudapi.faceid.v20180301.models.BankCard4EVerificationResponse;
import com.tencentcloudapi.faceid.v20180301.models.IdCardVerificationResponse;
import com.tencentcloudapi.ocr.v20181119.models.BankCardOCRResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class VerifyServiceImpl extends BaseBeanFactory implements VerifyService {
    private Boolean isCheck = true;

    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;
    @Autowired
    VerifyIdCardMapper verifyIdCardMapper;
    @Autowired
    RestCubpHelper restCubpHelper;
    @Autowired
    TencentApiFaceIdHelper tencentApiFaceIdHelper;

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    Integer MAX_VERIFY_COUNT_DAILY = 5;


    private VerifyResVo verifyResVoChecked() {
        VerifyResVo verifyResVo = new VerifyResVo();
        verifyResVo.setIsValid(true);
        verifyResVo.setRemark("");

        // 默认校验通过
        if (!isCheck) {
            return verifyResVo;
        }
        return verifyResVo;
    }

    @Override
    public Boolean isPhoneUsed(String phone) {
        // 参数校验
        if (StringUtils.isBlank(phone) || !VerifyUtil.verifyMobile(phone)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_PHONE);
        }

        if (isCheck) {
            // cubp中心校验
            return !restCubpHelper.verifyPhone(phone);
        }

        return false;
    }

    @Override
    public Boolean isEmailUsed(String email) {
        // 参数校验
        if (StringUtils.isBlank(email) || !VerifyUtil.isEmail(email)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_EMAIL);
        }

        if (isCheck) {
            // cubp中心校验
            return !restCubpHelper.verifyEmail(email);
        }

        return false;
    }

    @Override
    public Boolean isIdCardUsed(String idCard) {
        // 参数校验
        if (StringUtils.isBlank(idCard) || !VerifyUtil.isIDNo(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_ID_CARD);
        }

        if (isCheck) {
            // 调用cubp中心校验（黑名单/已开户）
            return !restCubpHelper.verifyIdCard(idCard);
        }
        return false;
    }

    @Override
    public VerifyResVo verifyPhone(VerifyReqParams params) {
        // 参数校验
        if (params == null || StringUtils.isBlank(params.getPhone())) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        String phone = params.getPhone();

        if (!VerifyUtil.verifyMobile(phone)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_PHONE);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用cubp中心校验
            if (!restCubpHelper.verifyPhone(phone)) {
                // cubp校验不通过，返回手机号已使用
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, CubpMessageResource.PHONE_IS_USED));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_PHONE));
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
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_EMAIL);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用cubp中心校验
            if (!restCubpHelper.verifyEmail(email)) {
                // cubp校验不通过，返回邮箱已使用
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, CubpMessageResource.EMAIL_IS_USED));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_EMAIL));
        }
        return verifyResVo;
    }

    @Override
    public VerifyResVo verifyIdCard(VerifyReqParams params) {
        // 参数校验
        if (params == null || StringUtils.isBlank(params.getIdCard()) || StringUtils.isBlank(params.getUserName())) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = params.getIdCard();
        String userName = params.getUserName();

        if (!VerifyUtil.isIDNo(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_ID_CARD);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            // 调用cubp中心校验（黑名单/已开户）
            if (!restCubpHelper.verifyIdCard(params.getIdCard())) {
                // cubp校验不通过，返回账号已使用/不支持
                verifyResVo.setIsValid(false);
                verifyResVo.setRemark(getResMessage(params, CubpMessageResource.ID_CARD_USED_OR_UNSUPPORT));
                return verifyResVo;
            }

            // 获取本地白名单
            List<VerifyIdCard> validIdCardList = verifyIdCardMapper.selectByIdCardAndIsValid(idCard, true);

            // 数据异常
            if (validIdCardList.size() > 1) {
                throw new InternalApiException(StaticType.CodeType.ERROR_UNKNOWN, StaticType.MessageResource.ERROR_UNKNOWN);
            }

            VerifyIdCard validIdCard = null;

            // 白名单数据存在
            if (validIdCardList.size() == 1) {
                validIdCard = validIdCardList.get(0);
                // 校验不通过
                if (!validIdCard.getUserName().equals(userName)) {
                    verifyResVo.setIsValid(false);
                    verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_ID_CARD));
                }
                // 完成校验
                validIdCard.setCheckCount(1);  // TODO:增加校验次数?
                validIdCard.setUpdateTime(new Date());
                verifyIdCardMapper.updateByPrimaryKey(validIdCard);
                return verifyResVo;
            }

            // 本地错误记录
            List<VerifyIdCard> errorIdCardList = verifyIdCardMapper.selectByIdCardAndIsValid(idCard, false);

            // 本地存在错误记录
            if (errorIdCardList.size() > 0) {
                int cnt = 0;
                String nowDateStr = dateFormat.format(new Date());
                for (VerifyIdCard errorIdCard : errorIdCardList) {
                    if (errorIdCard.getUserName().equals(userName)) {
                        verifyResVo.setIsValid(false);
                        verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_ID_CARD));
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
                    throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_ID_CARD_COUNT);
                }
            }

            Boolean isValid = true;
            String remark = null;

            // 本地无相关记录，进行公安系统校验
            IdCardVerificationResponse idCardVerificationResponse = tencentApiFaceIdHelper.verifyIdCard(idCard, userName);

            if (idCardVerificationResponse == null) {
                isValid = false;
                remark = "调用远程认证失败";
            } else if (!idCardVerificationResponse.getResult().equals("0")) {
                isValid = false;
                remark = idCardVerificationResponse.getRequestId() + "-" + idCardVerificationResponse.getDescription();
            }

            // 校验完成
            VerifyIdCard resultVerifyIdCard = new VerifyIdCard();
            resultVerifyIdCard.setIdCard(idCard);
            resultVerifyIdCard.setUserName(userName);
            resultVerifyIdCard.setCreateTime(new Date());
            resultVerifyIdCard.setUpdateTime(new Date());
            resultVerifyIdCard.setCheckDate(new Date());
            resultVerifyIdCard.setIsValid(isValid);
            resultVerifyIdCard.setCheckCount(1);
            resultVerifyIdCard.setRemark(remark);

            verifyIdCardMapper.insertSelective(resultVerifyIdCard);

            verifyResVo.setIsValid(isValid);
            verifyResVo.setRemark("");
            if (!isValid) {
                verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_ID_CARD));
            }

        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_ID_CARD));
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
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String idCard = params.getIdCard();
        String userName = params.getUserName();
        String phone = params.getPhone();
        String bankCard = params.getBankCard();

        if (!VerifyUtil.isIDNo(idCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_ID_CARD);
        }

        if (!VerifyUtil.verifyMobile(phone)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_PHONE);
        }

        if (!VerifyUtil.isNumber(bankCard)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, CubpMessageResource.BAD_FORMAT_BANK_CARD);
        }

        VerifyResVo verifyResVo = verifyResVoChecked();

        try {
            List<VerifyBankCard> validBankCardList = verifyBankCardMapper.selectByBankCardAndIsValid(bankCard, true);

            // 数据异常
            if (validBankCardList.size() > 1) {
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
                    verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_BANK_CARD));
                }
                // 完成校验
                validBankCard.setCheckCount(1); // TODO:增加校验次数?
                validBankCard.setUpdateTime(new Date());
                verifyBankCardMapper.updateByPrimaryKey(validBankCard);

                return verifyResVo;
            }

            // 获取本地错误校验记录
            List<VerifyBankCard> errorVerifyList = verifyBankCardMapper.selectByBankCardAndIsValid(bankCard, false);

            // 本地存在错误记录
            if (errorVerifyList.size() > 0) {
                int cnt = 0;
                String nowDateStr = dateFormat.format(new Date());
                for (VerifyBankCard errorBankCard : errorVerifyList) {
                    if (errorBankCard.getIdCard().equals(idCard) && errorBankCard.getUserName().equals(userName) && errorBankCard.getPhone().equals(phone)) {
                        verifyResVo.setIsValid(false);
                        verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_BANK_CARD));
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
                    throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_BANK_CARD_COUNT);
                }

            }

            Boolean isValid = true;
            String remark = null;

            // 本地无相关记录，进行公安系统校验
            BankCard4EVerificationResponse bankCard4EVerificationResponse = tencentApiFaceIdHelper.verifyBankCard4E(idCard, userName, phone, bankCard);

            if (bankCard4EVerificationResponse == null) {
                isValid = false;
                remark = "调用远程认证失败";
            } else if (!bankCard4EVerificationResponse.getResult().equals("0")) {
                isValid = false;
                remark = bankCard4EVerificationResponse.getRequestId() + "-" +bankCard4EVerificationResponse.getDescription();
            }

            // 校验完成
            VerifyBankCard resultVerifyBankCard = new VerifyBankCard();
            resultVerifyBankCard.setIdCard(idCard);
            resultVerifyBankCard.setUserName(userName);
            resultVerifyBankCard.setBankCard(bankCard);
            resultVerifyBankCard.setPhone(phone);
            resultVerifyBankCard.setCreateTime(new Date());
            resultVerifyBankCard.setUpdateTime(new Date());
            resultVerifyBankCard.setCheckDate(new Date());
            resultVerifyBankCard.setIsValid(isValid);
            resultVerifyBankCard.setCheckCount(1);
            resultVerifyBankCard.setRemark(remark);

            verifyBankCardMapper.insertSelective(resultVerifyBankCard);

            verifyResVo.setIsValid(isValid);
            verifyResVo.setRemark("");
            if (!isValid) {
                verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_BANK_CARD));
            }
        } catch (Exception e) {
            verifyResVo.setIsValid(false);
            verifyResVo.setRemark(getResMessage(params, CubpMessageResource.FAIL_VERIFY_BANK_CARD));
        }
        return verifyResVo;
    }

}
