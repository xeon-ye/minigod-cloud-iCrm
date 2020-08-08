package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.minigod.account.helper.FileStorageHelper;
import com.minigod.account.helper.RestBpmHelper;
import com.minigod.account.helper.TencentApiOcrHelper;
import com.minigod.account.service.*;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.utils.JSONUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.persist.account.mapper.*;
import com.minigod.persist.common.mapper.ConfigLanguageMapper;
import com.minigod.protocol.account.bpm.callback.BpmOpenInfoCallbackVo;
import com.minigod.protocol.account.bpm.request.BpmOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.model.*;
import com.minigod.protocol.account.request.params.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class OpenMoreAccountServiceImpl extends BaseBeanFactory implements OpenMoreAccountService {

    @Autowired
    OpenAccountOnlineCnService openAccountOnlineCnService;
    @Autowired
    OpenAccountOnlineHkService openAccountOnlineHkService;
    @Autowired
    VerifyService verifyService;
    @Autowired
    VerifySzcaService verifySzcaService;
    @Autowired
    RestBpmHelper restBpmHelper;
    @Autowired
    FileStorageHelper fileStorageHelper;
    @Autowired
    TencentApiOcrHelper tencentApiOcrHelper;
    @Autowired
    CustomInfoMapper customInfoMapper;
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenMoreAccountMapper customOpenMoreAccountMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyIdCardMapper verifyIdCardMapper;
    @Autowired
    CustomOpenFailReasonMapMapper customOpenFailReasonMapMapper;
    @Autowired
    ConfigLanguageMapper configLanguageMapper;

    @Value("${minigod.openAccount.images.idCardCn}")
    private String OPEN_IMG_TYPE_ID_CARD_CN;
    @Value("${minigod.openAccount.images.idCardHk}")
    private String OPEN_IMG_TYPE_ID_CARD_HK;
    @Value("${minigod.openAccount.images.idCardHkTemp}")
    private String OPEN_IMG_TYPE_ID_CARD_HK_TEMP;
    @Value("${minigod.openAccount.images.idCardPassport}")
    private String OPEN_IMG_TYPE_ID_CARD_PASSPORT;
    @Value("${minigod.openAccount.images.bankCard}")
    private String OPEN_IMG_TYPE_BANK_CARD;
    @Value("${minigod.openAccount.images.signature}")
    private String OPEN_IMG_TYPE_SIGNATURE;
    @Value("${minigod.openAccount.images.avatar}")
    private String OPEN_IMG_TYPE_AVATAR;
    @Value("${minigod.openAccount.images.cnH5ImageCount}")
    private Integer OPEN_IMG_COUNT_CN_H5;

    @Value("${minigod.szca.url}")
    private String SZCA_API_URL;


    private CustomInfo getLocalRealCustom(Integer userId) {
        // 参数校验
        if (userId == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }
        CustomInfo localUserInfo = customInfoMapper.selectByPrimaryKey(userId);

        // 用户不存在
        if (localUserInfo == null) {
            log.error("不存在该用户信息：userId=" + userId);
            throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NO_USER);
        }

        return localUserInfo;
    }

    private CustomOpenInfo getLocalOpenInfo(Integer userId) {
        // 参数校验
        if (userId == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }
        CustomOpenInfo localOpenInfo = customOpenInfoMapper.selectOneByUserId(userId);

        // 用户不存在
        if (localOpenInfo == null) {
            log.info("不存在该用户开户信息：userId=" + userId);
            throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NO_USER);
        }

        return localOpenInfo;
    }

    @Override
    public void saveOrUpdate(Integer userId, OpenMoreAccountReqParams params) {
        // 参数校验
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }
        Integer type = params.getType();
        JSONObject formData = params.getFormData();

        // 参数校验 - 基本
        if (type == null || formData == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 本地开户记录
        CustomOpenInfo localOpenInfo = getLocalOpenInfo(userId);

        // 用户校验
        CustomOpenMoreAccount localMoreAccount = customOpenMoreAccountMapper.selectOneByUserIdAndType(userId, type);

        if (localMoreAccount != null) {

            if (localMoreAccount.getStatus() != null) {
                // 不能重复提交
                if (localMoreAccount.getStatus().equals(CustomOpenAccountEnum.OpenStatus.PENDING.getCode()) || localOpenInfo.getStatus().equals(CustomOpenAccountEnum.OpenStatus.SUCCESS.getCode())) {
                    CustomOpenAccountEnum.OpenStatus statusInfo = CustomOpenAccountEnum.OpenStatus.getStatus(localOpenInfo.getStatus());

                    if (!statusInfo.getIsSubmit()) {
                        throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
                    }
                }

                // 异常账户
                if (localMoreAccount.getStatus().equals(CustomOpenAccountEnum.OpenStatus.ACCOUNT_ABO.getCode())) {
                    CustomOpenAccountEnum.OpenStatus statusInfo = CustomOpenAccountEnum.OpenStatus.getStatus(localOpenInfo.getStatus());

                    if (!statusInfo.getIsSubmit()) {
                        throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.ABO_ACCOUNT);
                    }
                }
            }
        }

        CustomOpenMoreAccount customOpenMoreAccount = new CustomOpenMoreAccount();

        customOpenMoreAccount.setUserId(userId);
        customOpenMoreAccount.setType(type);

        customOpenMoreAccount.setFormData(JSONUtil.toJson(formData));

        customOpenMoreAccount.setStatus(CustomOpenAccountEnum.OpenStatus.PENDING.getCode()); // 开户中


        customOpenMoreAccount.setCreateTime(new Date());
        customOpenMoreAccount.setUpdateTime(new Date());

        customOpenMoreAccount.setIsPushed(false);
        customOpenMoreAccount.setPushErrCount(0);
        customOpenMoreAccount.setIsSend(false);
        customOpenMoreAccount.setIsNoticed(false);

        if (localMoreAccount != null) {
            customOpenMoreAccount.setId(localMoreAccount.getId());
            customOpenMoreAccountMapper.updateByPrimaryKey(customOpenMoreAccount);
        } else {
            customOpenMoreAccountMapper.insertSelective(customOpenMoreAccount);
        }

    }

    @Override
    public void updateByBpm(BpmOpenInfoCallbackVo callbackVo) {

    }
}
