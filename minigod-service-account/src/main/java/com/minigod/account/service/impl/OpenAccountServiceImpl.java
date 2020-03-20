package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.common.utils.JSONUtil;
import com.minigod.account.helper.ImageStorageHelper;
import com.minigod.account.helper.RestCubpHelper;
import com.minigod.account.helper.TencentApiOcrHelper;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.protocol.account.cubp.vo.callback.CubpOpenInfoCallbackVo;
import com.minigod.protocol.account.cubp.vo.request.CubpOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.cubp.vo.request.CubpOpenAccountUserInfoReqVo;
import com.minigod.protocol.account.cubp.vo.response.CubpOpenAccountUserInfoResVo;
import com.minigod.protocol.account.enums.CubpMessageResource;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum.*;
import com.minigod.protocol.account.enums.OcrEnum;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.vo.request.params.*;
import com.minigod.protocol.account.vo.response.OpenUserInfoResVo;
import com.minigod.account.service.OpenAccountOnlineCnService;
import com.minigod.account.service.OpenAccountOnlineHkService;
import com.minigod.account.service.OpenAccountService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.account.service.VerifyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class OpenAccountServiceImpl extends BaseBeanFactory implements OpenAccountService {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    RestCubpHelper restCubpHelper;
    @Autowired
    OpenAccountOnlineCnService openAccountOnlineCnService;
    @Autowired
    OpenAccountOnlineHkService openAccountOnlineHkService;
    @Autowired
    VerifyService verifyService;
    @Autowired
    ImageStorageHelper imageStorageHelper;
    @Autowired
    TencentApiOcrHelper tencentApiOcrHelper;

    @Value("${minigod.openAccount.isVerifyOpenData}")
    private Boolean IS_VERIFY_OPEN_DATA;

    @Value("${minigod.openAccount.images.h5.type}")
    private String H5_OPEN_IMG_TYPE;

    @Value("${minigod.openAccount.images.h5.count}")
    private Integer H5_OPEN_IMG_COUNT;

    @Value("${minigod.openAccount.images.app.type}")
    private String APP_OPEN_IMG_TYPE;

    @Value("${minigod.openAccount.images.app.count}")
    private Integer APP_OPEN_IMG_COUNT;


    @Override
    public List<Object> getDictionaryData(DictionaryDataReqParams params) {
        // 参数校验
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String mark = params.getMark();

        if (StringUtils.isEmpty(mark)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        return restCubpHelper.findDictionaryData(mark);
    }

    // TODO
    private boolean verifyOpenInfoData(CubpOpenAccountAppointmentReqVo reqVo) {
        return true;
    }

    @Override
    public Boolean isCanUpdateOpenInfo(Integer userId) {
        CustomOpenInfo localOpenInfo = customOpenInfoMapper.selectOneById(userId);

        // 不能重复提交
        if (localOpenInfo != null) {
            OpenStatus statusInfo = OpenStatus.getStatus(localOpenInfo.getStatus());
            return statusInfo.getIsSubmit();
        }

        return true;
    }

    @Override
    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params) {
        // 参数校验
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        CustomOpenInfo localOpenInfo = customOpenInfoMapper.selectOneById(userId);

        // 用户不存在
        if (localOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NONE_DATA);
        }

        Integer openType = params.getOpenType();
        JSONObject info = params.getInfo();

        OpenType openTypeInfo = OpenType.getType(openType);

        // 参数校验 - 基本
        if (info == null || openTypeInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 不能重复提交
        if (localOpenInfo.getStatus().equals(OpenStatus.PENDING.getCode()) || localOpenInfo.getStatus().equals(OpenStatus.SUCCESS.getCode())) {
            OpenStatus statusInfo = OpenStatus.getStatus(localOpenInfo.getStatus());

            if (!statusInfo.getIsSubmit()) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
            }
        }

        // 异常账户
        if (localOpenInfo.getStatus().equals(OpenStatus.ACCOUNT_ABO.getCode())) {
            OpenStatus statusInfo = OpenStatus.getStatus(localOpenInfo.getStatus());

            if (!statusInfo.getIsSubmit()) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.ABO_ACCOUNT);
            }
        }

        info.put("userId", userId);
        info.put("phoneNumber", localOpenInfo.getPhone());
        info.put("inviterId", 1);
        info.put("sourceChannelId", 1);

        CubpOpenAccountAppointmentReqVo reqVo = JSONObject.parseObject(JSONObject.toJSONString(info), CubpOpenAccountAppointmentReqVo.class);

        Integer openAccessWay = reqVo.getOpenAccountAccessWay();

        String email = reqVo.getEmail();
        String idCard = reqVo.getIdNo();
        String bankCard = reqVo.getBankNo();

        if (IS_VERIFY_OPEN_DATA) {
            // TODO: 18岁成年校验
            // 校验身份证是否存在
            if (verifyService.isIdCardUsed(idCard)) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.ID_CARD_USED_OR_UNSUPPORT);
            }

            // 校验邮箱是否存在
            if (verifyService.isEmailUsed(email)) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.EMAIL_IS_USED);
            }
        }

        if (openTypeInfo.getCode().equals(OpenType.ONLINE_CN.getCode())) {
            String[] locationTypes = null;
            int openaccountImgCnt = 0;
            // 判断图片是否足够
            if (openAccessWay == OpenAccessWay.APP.getCode()) {
                locationTypes = APP_OPEN_IMG_TYPE.split(",");
                openaccountImgCnt = APP_OPEN_IMG_COUNT;
            }
            if (openAccessWay == OpenAccessWay.H5.getCode()) {
                locationTypes = H5_OPEN_IMG_TYPE.split(",");
                openaccountImgCnt = H5_OPEN_IMG_COUNT;
            }

            List<CustomOpenCnImg> openUserImgList = null;

            if (locationTypes != null) {
                openUserImgList = customOpenCnImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);
            }

            if (CollectionUtils.isEmpty(openUserImgList)) {
                // 图片不完整
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.EMAIL_IS_USED);
            } else {
                if (openUserImgList.size() < openaccountImgCnt) {
                    // 图片不完整
                    throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.EMAIL_IS_USED);
                }
            }
        }

        // TODO:必填字段校验
        if (!verifyOpenInfoData(reqVo)) {
            // 数据不完整
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.EMAIL_IS_USED);
        }

        CustomOpenInfo customOpenInfo = new CustomOpenInfo();

        Date now = new Date();
        String jsonInfo = JSONUtil.toJson(info);

        customOpenInfo.setInfo(jsonInfo);
        customOpenInfo.setAccessWay(openAccessWay);
        customOpenInfo.setEmail(email);
        customOpenInfo.setBankCard(bankCard);
        customOpenInfo.setIdCard(idCard);
        customOpenInfo.setPushErrCount(0);
        customOpenInfo.setIsNeedPush(true);
        customOpenInfo.setIsSend(false);
        customOpenInfo.setStatus(OpenStatus.PENDING.getCode()); // 开户中
        customOpenInfo.setPendingType(PendingStatusType.DOING.getCode()); // 预批中
        customOpenInfo.setFailType(FailStatusType.UN_KNOW.getCode());
        customOpenInfo.setOpenResult("");
        customOpenInfo.setOpenType(openType);

        customOpenInfo.setUpdateTime(now);


        // 更新
        customOpenInfo.setId(localOpenInfo.getId());
        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);

        // 发送提交开户资料短信


    }

    @Override
    public void updateOpenInfo(CubpOpenInfoCallbackVo cubpOpenInfoCallbackVo) {
        log.info("请求 /callback/update_open_info：" + JSONUtil.toCompatibleJson(cubpOpenInfoCallbackVo));
        
    }

    @Override
    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressReqParams params) {
        // 参数校验
        if (params == null || params.getFlag() == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        OpenUserInfoResVo response = new OpenUserInfoResVo();
        // 查询本地用户数据
        CustomOpenInfo customOpenInfo = null;
        customOpenInfo = customOpenInfoMapper.selectOneById(userId);

        String phone = "";
        if (customOpenInfo != null) {
            phone = customOpenInfo.getPhone();
        }
        response.setPhone(phone);


        // 查询用户开户信息
        OpenStatus openStatusInfo = null;

        Integer openType = null;
        Integer accountType = null;

        String tradeAccount = null;
        String fundAccount = null;

        // 查询cubp用户中心开户数据
        CubpOpenAccountUserInfoReqVo cubpOpenAccountUserInforeqVo = new CubpOpenAccountUserInfoReqVo();
        cubpOpenAccountUserInforeqVo.setUserId(userId);
        CubpOpenAccountUserInfoResVo cubpOpenAccountUserInfoResVo = restCubpHelper.selectSecuritiesUserInfo(cubpOpenAccountUserInforeqVo);

        // 查询到cubp用户数据
        if (cubpOpenAccountUserInfoResVo != null) {
            // clientStatus 客户状态[0-正常 1-冻结 2-挂失 3-销户 D-休眠 E-不合格 F-锁定]
            String clientStatus = cubpOpenAccountUserInfoResVo.getClientStatus();

            if (clientStatus.equals("0")) {
                // 正常
                openStatusInfo = OpenStatus.SUCCESS;
            } else if (clientStatus.equals("3")) {
                // 销户
                openStatusInfo = OpenStatus.ACCOUNT_OFF;
            } else {
                // 异常
                openStatusInfo = OpenStatus.ACCOUNT_ABO;
            }

            openType = cubpOpenAccountUserInfoResVo.getOpenAccountType();
            accountType = cubpOpenAccountUserInfoResVo.getFundAccountType();
            fundAccount = cubpOpenAccountUserInfoResVo.getFundAccount();
            tradeAccount = cubpOpenAccountUserInfoResVo.getTradeAccount();
        } else if (customOpenInfo != null) {
            Integer openStatus = customOpenInfo.getStatus();
            openStatusInfo = OpenStatus.getStatus(openStatus);

            openType = customOpenInfo.getOpenType();
            accountType = customOpenInfo.getAccountType();
        }

        // 无开户状态数据
        if (openStatusInfo == null) {
            openStatusInfo = OpenStatus.UN_START;
        }

        // 无开户方式
        if (openType == null) {
            openType = 0;
        }

        // 设置回包 status/message
        response.setOpenType(openType);
        response.setAccountType(accountType);
        response.setTradeAccount(tradeAccount);
        response.setFundAccount(fundAccount);

        response.setOpenStatus(openStatusInfo.getCode());
        response.setOpenResult(openStatusInfo.getMessage());

        // 审核中
        if (openStatusInfo.equals(OpenStatus.PENDING)) {
            // 审核中状态
            Integer openUserInfoPendingType = customOpenInfo.getPendingType();
            PendingStatusType pendingStatusType = PendingStatusType.getType(openUserInfoPendingType);

            // 设置回包 审核中type
            response.setPendType(pendingStatusType.getCode());
            // 修改回包 message
            response.setOpenResult(pendingStatusType.getMessage());
        }

        // 失败
        if (openStatusInfo.equals(OpenStatus.FAILED)) {
            // 失败中状态
            Integer openUserInfoFailType = customOpenInfo.getFailType();
            FailStatusType failStatusType = FailStatusType.getType(openUserInfoFailType);

            // 设置回包 失败中type
            response.setFailType(failStatusType.getCode());
            // 修改回包 message
//            openProgressResVo.setOpenResult(failStatusType.getMessage());
            response.setOpenResult(customOpenInfo.getOpenResult());
        }


        return response;
    }

    private String getOcrImageUrl(Integer userId, Integer openType, OcrEnum.ImageLocation locationInfo) {
        String imageUrl = "";
        // 内地身份证开户
        if (openType.equals(OpenType.ONLINE_CN.getCode())) {
            imageUrl = openAccountOnlineCnService.getImgUrl(userId, locationInfo.getLocationKey(), locationInfo.getLocationType());
        }
        // 香港银行卡开户
        else if (openType.equals(OpenType.ONLINE_HK.getCode())) {
            imageUrl = openAccountOnlineHkService.getImgUrl(userId, locationInfo.getLocationKey(), locationInfo.getLocationType());
        }

        if (StringUtils.isBlank(imageUrl)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        return imageUrl;
    }

    @Override
    public Object ocrByCardType(Integer userId, OcrReqParams params) {
        // 参数校验
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer openType = params.getOpenType();
        Integer cardType = params.getCardType();
        OcrReqParams.IdCardOptions idCardOptions = params.getIdCardOptions();
        OcrReqParams.PassportOptions passportOptions = params.getPassportOptions();

        if (!OcrEnum.CardType.isContainCertType(cardType) || !CustomOpenAccountEnum.OpenType.isContainCertType(openType)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        Object ocrResponse = null;


        // 身份证识别
        if (cardType.equals(OcrEnum.CardType.IdCardOCR.getCode())) {
            // 身份证识别参数校验
            if (idCardOptions == null) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }

            OcrEnum.IdCardSide idCardSide = OcrEnum.IdCardSide.getData(idCardOptions.getCardSide());

            if (idCardSide == null) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.IdCardFront;
            if (idCardSide.getCode().equals(OcrEnum.IdCardSide.BACK.getCode())) {
                locationInfo = OcrEnum.ImageLocation.IdCardBack;
            }

            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getIdCardOCR(imageUrl, idCardSide.getValue(), idCardOptions.getConfig());

        }
        // 银行卡识别
        else if (cardType.equals(OcrEnum.CardType.BankCardOCR.getCode())) {
            // 银行卡识别参数校验

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.BankCard;
            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getBankCardOCR(imageUrl);
        }
        // 港澳通行证识别
        else if (cardType.equals(OcrEnum.CardType.PermitOCR.getCode())) {
            // 港澳通行证识别参数校验

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.Permit;
            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getPermitOCR(imageUrl);

        }
        // 护照识别
        else if (cardType.equals(OcrEnum.CardType.PassportOCR.getCode())) {
            // 护照识别参数校验
            if (passportOptions == null) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }
            OcrEnum.PassportType passportType = OcrEnum.PassportType.getData(passportOptions.getPassportType());

            if (passportType == null) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.Passport;
            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getPassportOCR(imageUrl, passportType.getValue());
        }


        if (ocrResponse == null) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_OCR);
        }

        return ocrResponse;
    }

    @Override
    public Object ocrByImage(Integer userId, OpenImgReqParams params) {
        // 参数校验
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer openType = params.getOpenType();
        String location = params.getLocation();
        String type = params.getType();

        if (!CustomOpenAccountEnum.OpenType.isContainCertType(openType)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        Object ocrResponse = null;


        // 身份证识别
        if (type.equals("101") || type.equals("102")) {
            // 身份证识别参数校验

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.IdCardFront;
            String idCardSide = "FRONT";

            if (type.equals("102")) {
                locationInfo = OcrEnum.ImageLocation.IdCardBack;
                idCardSide = "BACK";
            }

            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getIdCardOCR(imageUrl, idCardSide, null);

        }
        // 银行卡识别
        else if (type.equals("201")) {
            // 银行卡识别参数校验

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.BankCard;
            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getBankCardOCR(imageUrl);
        }
        // 港澳通行证识别
        else if (type.equals("103")) {
            // 港澳通行证识别参数校验

            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.Permit;
            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getPermitOCR(imageUrl);

        }
        // 护照识别
        else if (type.equals("104")) {
            // 护照识别参数校验
            OcrEnum.ImageLocation locationInfo = OcrEnum.ImageLocation.Passport;
            String imageUrl = getOcrImageUrl(userId, openType, locationInfo);

            ocrResponse = tencentApiOcrHelper.getPassportOCR(imageUrl, "CN");
        }


        if (ocrResponse == null) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_OCR);
        }

        return ocrResponse;
    }

}
