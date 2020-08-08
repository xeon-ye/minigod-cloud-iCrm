package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.minigod.account.helper.BpmOpenInfoHelper;
import com.minigod.account.service.*;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.JSONUtil;
import com.minigod.account.helper.FileStorageHelper;
import com.minigod.account.helper.RestBpmHelper;
import com.minigod.account.helper.TencentApiOcrHelper;
import com.minigod.persist.account.mapper.*;
import com.minigod.persist.common.mapper.ConfigLanguageMapper;
import com.minigod.protocol.account.bpm.callback.BpmOpenInfoCallbackVo;
import com.minigod.protocol.account.bpm.request.BpmOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.bpm.request.BpmOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.bpm.request.BpmOpenAccountUserInfoReqVo;
import com.minigod.protocol.account.bpm.response.BpmOpenAccountUserInfoResVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum.*;
import com.minigod.protocol.account.enums.OcrEnum;
import com.minigod.protocol.account.model.*;
import com.minigod.protocol.account.pojo.OpenStatusPojo;
import com.minigod.protocol.account.request.params.*;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.protocol.account.response.OpenUserInfoResVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@Slf4j
public class OpenAccountOnlineServiceImpl extends BaseBeanFactory implements OpenAccountOnlineService {

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
    CustomOpenCnImgMapper customOpenCnImgMapper;
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


    @Value("${minigod.szca.getPDFInfoForSign}")
    private String API_GET_PDF_INFO_FOR_SIGN;

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
            return null;
        }

        return localOpenInfo;
    }

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

        return restBpmHelper.findDictionaryData(mark);
    }

    // 必填字段校验
    private boolean verifyOpenInfoData(BpmOpenAccountAppointmentReqVo reqVo) {
        return BpmOpenInfoHelper.openInfoValid(reqVo);
    }

    @Override
    public Boolean isCanUpdateOpenInfo(Integer userId) {
        CustomOpenInfo localOpenInfo = customOpenInfoMapper.selectOneByUserId(userId);

        // 不能重复提交
        if (localOpenInfo != null) {
            OpenStatus statusInfo = OpenStatus.getStatus(localOpenInfo.getStatus());
            return statusInfo.getIsSubmit();
        }

        return true;
    }


    private int getAge(String idnumber) {
        try {
            //如果是，定义正则表达式提取出身份证中的出生日期
            Pattern birthpPattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");
            //通过Pattern获得Matcher
            Matcher birthmMatcher = birthpPattern.matcher(idnumber);
            if (birthmMatcher.find()) {
                String year = birthmMatcher.group(1);
                String month = birthmMatcher.group(2);
                String date = birthmMatcher.group(3);

                String birthday = year + "-" + month + "-" + date + "";

                Date birth = DateUtils.stringToDate(birthday);
                Calendar cal = Calendar.getInstance();
                if (cal.before(birth)) {
                    throw new IllegalArgumentException(
                            "The birthDay is before Now.It's unbelievable!");
                }
                int yearNow = cal.get(Calendar.YEAR);
                int monthNow = cal.get(Calendar.MONTH);
                int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
                cal.setTime(birth);
                int yearBirth = cal.get(Calendar.YEAR);
                int monthBirth = cal.get(Calendar.MONTH);
                int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH) + 1;
                int age = yearNow - yearBirth;
                if (monthNow <= monthBirth) {
                    if (monthNow == monthBirth) {
                        if (dayOfMonthNow < dayOfMonthBirth) age--;
                    } else {
                        age--;
                    }
                }
                return age;
            }
        } catch (Exception e) {
            log.error("获取身份证生日异常", e);
        }
        return 0;
    }

    /**
     * 提交开户申请
     */
    @Override
    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params) {
        // 参数校验
        if (params == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer openType = params.getOpenType();
        Integer accessWay = params.getAccessWay();
        Integer fundAccountType = params.getFundAccountType();
        Integer lang = params.getLanguage();
        Integer activeId = params.getActiveId();
        Integer inviteId = params.getInviteId();
        Integer channelId = params.getChannelId();
        ArrayList<Integer> accountMarkets = params.getAccountMarkets();
        JSONObject formData = params.getFormData();

        OpenType openTypeInfo = OpenType.getType(openType);
//        OpenAccessWay accessWayInfo = OpenAccessWay.getWay(accessWay);
        FundAccountType fundAccountTypeInfo = FundAccountType.getType(fundAccountType);

        // 参数校验 - 基本
        if (openTypeInfo == null || lang == null ||accessWay == null || fundAccountTypeInfo == null || accountMarkets.size() == 0 || formData == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 用户校验
        CustomInfo userInfo = getLocalRealCustom(userId);

        // 本地开户记录
        CustomOpenInfo localOpenInfo = getLocalOpenInfo(userId);

        if (localOpenInfo != null) {

            if (localOpenInfo.getStatus() != null) {
                // 不能重复提交
                if (localOpenInfo.getStatus().equals(OpenStatus.PENDING.getCode()) || localOpenInfo.getStatus().equals(OpenStatus.SUCCESS.getCode())) {
                    OpenStatus statusInfo = OpenStatus.getStatus(localOpenInfo.getStatus());

                    if (!statusInfo.getIsSubmit()) {
                        throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
                    }
                }

                // 异常账户
                if (localOpenInfo.getStatus().equals(OpenStatus.ACCOUNT_ABO.getCode())) {
                    OpenStatus statusInfo = OpenStatus.getStatus(localOpenInfo.getStatus());

                    if (!statusInfo.getIsSubmit()) {
                        throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.ABO_ACCOUNT);
                    }
                }
            }
        }

        // 补充资料
        // TODO: 此处针对minigod平台处理
        if (userInfo.getThirdCode() != null && userInfo.getThirdCode() > 0) {
            formData.put("userId", userInfo.getThirdCode());
        } else {
            formData.put("userId", userId);
        }
        formData.put("phoneNumber", userInfo.getPhone());
        // 交易市场相关
        formData.put("isOpenHkStockMarket", OpenAccountMarket.getFlag(accountMarkets, OpenAccountMarket.HK_TRADE));
        formData.put("isOpenUsaStockMarket", OpenAccountMarket.getFlag(accountMarkets, OpenAccountMarket.US_TRADE));
//        formData.put("northTrade", OpenAccountMarket.getFlag(accountMarkets, OpenAccountMarket.NORTH_TRADE));

        // 账户类型
        formData.put("openAccountType", 1); // 开户类型 [0 = 未知 1 = 互联网 2 = 见证宝 3 = BPM] TODO：此处暂时固定1
        formData.put("openAccountAccessWay", accessWay); // 开户接入方式[1=H5开户 2=App]
        formData.put("fundAccountType", fundAccountTypeInfo.getCode()); // 账户类型 1：现金账户 2：融资账户
        formData.put("language", lang); // 语言

        // 推荐人、渠道等字段，保留，后期可能使用
        formData.put("inviterId", inviteId);
        formData.put("sourceChannelId", channelId);

        if (inviteId == null) {
            formData.put("inviterId", 1);
        }
         if (channelId == null) {
            formData.put("sourceChannelId", 1);
        }

        BpmOpenAccountAppointmentReqVo reqVo = JSONObject.parseObject(JSONObject.toJSONString(formData), BpmOpenAccountAppointmentReqVo.class);

        // 必填字段校验
        if (!verifyOpenInfoData(reqVo)) {
            // 数据不完整
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.MISSING_DATAS);
        }

        Integer idKind = reqVo.getIdKind();

        StringBuilder locationTypeB = new StringBuilder();
        String[] locationTypes = null;
        Integer imageCount = 0;

        // 图片数据校验
        if (openTypeInfo.getCode().equals(OpenType.ONLINE_CN.getCode())) {
            locationTypeB.append(OPEN_IMG_TYPE_SIGNATURE);
            locationTypeB.append(",");
            locationTypeB.append(OPEN_IMG_TYPE_ID_CARD_CN);
            locationTypeB.append(",");
            locationTypeB.append(OPEN_IMG_TYPE_AVATAR);

            locationTypes = locationTypeB.toString().split(",");
            imageCount = OPEN_IMG_COUNT_CN_H5;
            List<CustomOpenCnImg> openUserImgList = null;
            if (locationTypes != null) {
                openUserImgList = customOpenCnImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);
            }

            if (CollectionUtils.isEmpty(openUserImgList) || openUserImgList.size() < imageCount) {
                // 图片不完整
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.MISSING_IMAGES);
            }
        } else if (openType.equals(CustomOpenAccountEnum.OpenType.ONLINE_HK.getCode())) {
            locationTypeB.append(OPEN_IMG_TYPE_SIGNATURE);
            // 证件类型[0=未知 1=大陆居民身份证 2=香港居民身份证 3=护照 4=香港临时身份证]
            // 1=大陆居民身份证
            if (idKind == 1) {
                locationTypeB.append(",");
                locationTypeB.append(OPEN_IMG_TYPE_ID_CARD_CN);
            }
            // 2=香港居民身份证
            else if (idKind == 2) {
                locationTypeB.append(",");
                locationTypeB.append(OPEN_IMG_TYPE_ID_CARD_HK);
            }
            // 3=护照
            else if (idKind == 3) {
                locationTypeB.append(",");
                locationTypeB.append(OPEN_IMG_TYPE_ID_CARD_PASSPORT);
            }
            // 4=香港临时身份证
            else if (idKind == 4) {
                locationTypeB.append(",");
                locationTypeB.append(OPEN_IMG_TYPE_ID_CARD_HK_TEMP);
            }

            locationTypes = locationTypeB.toString().split(",");
            imageCount = locationTypes.length;
            List<CustomOpenHkImg> openUserImgList = null;
            if (locationTypes != null) {
                openUserImgList = customOpenHkImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);
            }

            if (CollectionUtils.isEmpty(openUserImgList) || openUserImgList.size() < imageCount) {
                // 图片不完整
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.MISSING_IMAGES);
            }
        }

        String email = reqVo.getEmail();
        String idCard = reqVo.getIdNo();
        String userName = reqVo.getClientName();
        String bankCard = reqVo.getBankNo();

        // 线上内地开户，判断身份证、银行卡校验情况
        if (openTypeInfo.getCode().equals(OpenType.ONLINE_CN.getCode())) {
            // 18岁成年校验
            int age = getAge(idCard);
            if (age < 18) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.ID_CARD_AGE_LESS_18);
            }

            // 校验身份证是否已校验
            if (!verifyService.isIdCardValid(idCard, userName)) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.ID_CARD_USED_OR_UNSUPPORT);
            }

            // 校验银行卡是否已校验
            if (!verifyService.isBankCardValid(idCard, userName, bankCard)) {
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.BANK_CARD_USED_OR_UNSUPPORT);
            }
        }

        // 校验身份证是否存在
        if (verifyService.isIdCardUsed(idCard)) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.ID_CARD_USED_OR_UNSUPPORT);
        }

        // 校验邮箱是否存在
        if (verifyService.isEmailUsed(email)) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.EMAIL_IS_USED);
        }

        // 把邮箱填入
        userInfo.setEmail(email);
        customInfoMapper.updateByPrimaryKeySelective(userInfo);

        CustomOpenInfo customOpenInfo = new CustomOpenInfo();

        customOpenInfo.setUserId(userId);
        customOpenInfo.setIdKind(idKind);
        customOpenInfo.setIdCard(idCard);
        customOpenInfo.setBankCard(bankCard);
        customOpenInfo.setOpenType(openType);
        customOpenInfo.setAccessWay(accessWay);
        customOpenInfo.setFundAccountType(fundAccountTypeInfo.getCode());
        customOpenInfo.setAccountMarkets(JSONUtil.toJson(accountMarkets));

        customOpenInfo.setFormData(JSONUtil.toJson(formData));

        customOpenInfo.setStatus(OpenStatus.PENDING.getCode()); // 开户中
        customOpenInfo.setPendingType(PendingStatusType.DOING.getCode()); // 预批中
        customOpenInfo.setFailType(FailStatusType.UN_KNOW.getCode());
        customOpenInfo.setCaStatus(CaStatus.NONE.getCode());

        customOpenInfo.setPushErrCount(0);
        customOpenInfo.setIsPushed(false);
        customOpenInfo.setIsNoticed(false);
        customOpenInfo.setIsSend(false);

        customOpenInfo.setCreateTime(new Date());
        customOpenInfo.setUpdateTime(new Date());

        if (localOpenInfo != null) {
            customOpenInfo.setId(localOpenInfo.getId());
            customOpenInfoMapper.updateByPrimaryKey(customOpenInfo);
        } else {
            customOpenInfoMapper.insertSelective(customOpenInfo);
        }

        // TODO: 发送提交开户资料短信
    }


    private OpenStatusPojo getOpenCallbackStatusInfo(String openCallbackStatus) {
        // 开户回调状态
        // 0 - 开户成功
        // 1 - 开户预审中
        // 2 - 开户失败
        // 3 - 基本资料错误
        // 4 - 影像资料错误
        // 5 - 基本资料和影像资料错误
        // 6 - 未提交开户资料
        // 7  - 开户被拒绝
        // 8  - 取消开户
        // 9  - 终审审核通过
        // 10  - 开户预批中
        // 11  - 销户
        OpenStatusPojo openStatusPojo = new OpenStatusPojo();
        openStatusPojo.setOpenStatus(OpenStatus.UN_START);
        openStatusPojo.setPendingStatusType(PendingStatusType.UN_KNOW);
        openStatusPojo.setFailStatusType(FailStatusType.UN_KNOW);

        // 成功
        if (openCallbackStatus.equals("0")) {
            openStatusPojo.setOpenStatus(OpenStatus.SUCCESS);
        }
        // 终审通过，需进行CA认证
        else if (openCallbackStatus.equals("9")) {
            openStatusPojo.setOpenStatus(OpenStatus.PENDING);
            openStatusPojo.setPendingStatusType(PendingStatusType.CA);
        }
        // 基本资料错误
        else if (openCallbackStatus.equals("3")) {
            openStatusPojo.setOpenStatus(OpenStatus.FAILED);
            openStatusPojo.setFailStatusType(FailStatusType.ERROR_INFO);
        }
        // 影像资料错误
        else if (openCallbackStatus.equals("4")) {
            openStatusPojo.setOpenStatus(OpenStatus.FAILED);
            openStatusPojo.setFailStatusType(FailStatusType.ERROR_PIC);
        }
        // 基本资料+影像资料错误
        else if (openCallbackStatus.equals("5")) {
            openStatusPojo.setOpenStatus(OpenStatus.FAILED);
            openStatusPojo.setFailStatusType(FailStatusType.ERROR_INFO_PIC);
        }
        // 其他错误
        else if (openCallbackStatus.equals("2") || openCallbackStatus.equals("7")) {
            openStatusPojo.setOpenStatus(OpenStatus.FAILED);
            openStatusPojo.setFailStatusType(FailStatusType.ERROR_OTHER);
        }
        // 取消开户
        else if (openCallbackStatus.equals("8")) {
            openStatusPojo.setOpenStatus(OpenStatus.CANCELED);
        }
        // 销户
        else if (openCallbackStatus.equals("11")) {
            openStatusPojo.setOpenStatus(OpenStatus.ACCOUNT_OFF);
        }
        // 预批中
        else if (openCallbackStatus.equals("1")) {
            openStatusPojo.setOpenStatus(OpenStatus.PENDING);
            openStatusPojo.setPendingStatusType(PendingStatusType.DOING);
        }
        // 审核中
        else if (openCallbackStatus.equals("10")) {
            openStatusPojo.setOpenStatus(OpenStatus.PENDING);
            openStatusPojo.setPendingStatusType(PendingStatusType.APPROVE);
        }
        // 未提交
        else if (openCallbackStatus.equals("6")) {
            openStatusPojo.setOpenStatus(OpenStatus.UN_SUBMIT);
        }
        // 其他情况，异常
        else {
            openStatusPojo.setOpenStatus(OpenStatus.ACCOUNT_ABO);
        }

        return openStatusPojo;
    }

    @Override
    public void updateOpenInfo(BpmOpenInfoCallbackVo bpmOpenInfoCallbackVo) {
        log.info("请求 /callback/update_open_info：" + JSONUtil.toCompatibleJson(bpmOpenInfoCallbackVo));
        try {
            if (bpmOpenInfoCallbackVo == null) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }

            Integer backUserId = bpmOpenInfoCallbackVo.getUserId();
            String phoneNumber = bpmOpenInfoCallbackVo.getPhoneNumber();

            CustomInfo localCustomInfo = customInfoMapper.selectOneByPhone(phoneNumber);

            if (localCustomInfo == null) {
                log.error("不存在该用户信息：backUserId = " + backUserId + ", phoneNumber=" + phoneNumber);
                throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NONE_DATA);
            }

            Integer userId = localCustomInfo.getId();
            Integer thirdCode = localCustomInfo.getThirdCode();


            if (!userId.equals(backUserId) && !thirdCode.equals(backUserId)) {
                log.error("不存在该用户信息：backUserId = " + backUserId + ", phoneNumber=" + phoneNumber);
                throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NONE_DATA);
            }

            //查询用户开户信息
            CustomOpenInfo localOpenInfo = getLocalOpenInfo(userId);

            if (localOpenInfo == null) {
                log.error("不存在该用户开户信息：backUserId = " + backUserId + ", phoneNumber=" + phoneNumber);
                throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NONE_DATA);
            }

            // 开户状态
            OpenStatusPojo openStatusPojo = getOpenCallbackStatusInfo(String.valueOf(bpmOpenInfoCallbackVo.getOpenStatus()));

            Boolean isClearImg = false;

            if (openStatusPojo == null || openStatusPojo.getOpenStatus().equals(OpenStatus.ACCOUNT_ABO)) {
                log.error("开户状态信息异常：bpmOpenInfoCallbackVo" + JSON.toJSONString(bpmOpenInfoCallbackVo));
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_ARGS);
            }

            // TODO: 开户成功
            if (openStatusPojo.getOpenStatus().equals(OpenStatus.SUCCESS)) {
                String openAccountDate = bpmOpenInfoCallbackVo.getOpenDate();
                if (StringUtils.isNotEmpty(openAccountDate)) {
                    Date openDate = DateUtils.stringToDate(openAccountDate, DateUtils.TimeFormatter.YYYY_MM_DD_HH_MM_SS);
                    localOpenInfo.setOpenDate(openDate);
                    localOpenInfo.setFailReason("");
                }
            }
            // 开户中
            else if (openStatusPojo.getOpenStatus().equals(OpenStatus.PENDING)) {
                localOpenInfo.setPendingType(openStatusPojo.getPendingStatusType().getCode());

                if (openStatusPojo.getPendingStatusType().equals(PendingStatusType.CA)) {
                    localOpenInfo.setCaStatus(CaStatus.IS_NEED_VERIFY.getCode());
                }

                String openAccountFilrUrl = bpmOpenInfoCallbackVo.getOpenAccountFileUrl();
                if (StringUtils.isNotEmpty(openAccountFilrUrl)) {
                    URL url = new URL(openAccountFilrUrl);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    int httpResult = conn.getResponseCode();
                    if (httpResult != HttpURLConnection.HTTP_OK) {
                        log.error("开户文件异常, url = {}", openAccountFilrUrl);
                        throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
                    }
                    InputStream inputStream = conn.getInputStream();
                    // 上传文件
                    String fileName = backUserId + "_" + System.currentTimeMillis() + ".pdf";
                    String fileUrl = fileStorageHelper.uploadPdf(fileName, inputStream);

                    localOpenInfo.setOpenAccountPdfUrl(fileUrl);
                }
            }
            // 开户失败
            else if (openStatusPojo.getOpenStatus().equals(OpenStatus.FAILED)) {
                StringBuffer openAccountResult = new StringBuffer();
                String openResult = "";
                String errorInfo = bpmOpenInfoCallbackVo.getErrorInfo(); // 退回理由

                if (StringUtils.isNotBlank(errorInfo)) {
                    List<String> openResultList = JSONObject.parseArray(errorInfo, String.class);
                    for (String errorCode : openResultList) {
                        String error = customOpenFailReasonMapMapper.selectOneConfigKeyByCode(Integer.valueOf(errorCode));
                        openAccountResult.append(error).append(",");
                    }
                    if (openAccountResult != null) {
                        openResult = openAccountResult.substring(0, openAccountResult.length() - 1);
                    }
                }

                if (openStatusPojo.getFailStatusType().equals(FailStatusType.ERROR_PIC)) {
                    // 图片错误，修改图片错误状态
                    if (CollectionUtils.isNotEmpty(bpmOpenInfoCallbackVo.getErrorImages())) {
                        for (BpmOpenAccountImageInfoReqVo openAccountImageInfo : bpmOpenInfoCallbackVo.getErrorImages()) {
                            // 活体校验图片错误，删除缓存影像资料
                            if (openAccountImageInfo.getImageLocation() == 3) {
                                isClearImg = true;
                            }
                            if (localOpenInfo.getOpenType().equals(OpenType.ONLINE_CN.getCode())) {
                                openAccountOnlineCnService.saveErrorImg(localOpenInfo.getUserId(), openAccountImageInfo);

                            } else if (localOpenInfo.getOpenType().equals(OpenType.ONLINE_HK.getCode())) {
                                openAccountOnlineHkService.saveErrorImg(localOpenInfo.getUserId(), openAccountImageInfo);
                            }
                        }
                    }
                }
                localOpenInfo.setFailReason(openResult);
            }
            // 取消/终止开户 | 销户 | 未提交 | 异常等
            else {
                // 清理开户缓存数据
                // 清理开户图片数据
            }

            String clientId = bpmOpenInfoCallbackVo.getClientId();
            localOpenInfo.setTradeAccount(clientId == null ? localOpenInfo.getTradeAccount() : clientId);

            localOpenInfo.setStatus(openStatusPojo.getOpenStatus().getCode());
            localOpenInfo.setPendingType(openStatusPojo.getPendingStatusType().getCode());
            localOpenInfo.setFailType(openStatusPojo.getFailStatusType().getCode());
            localOpenInfo.setUpdateTime(new Date());

            log.info("更新回调数据：localOpenInfo = {}", localOpenInfo);

            customOpenInfoMapper.updateByPrimaryKeySelective(localOpenInfo);

            if (isClearImg) {
                if (localOpenInfo.getOpenType().equals(OpenType.ONLINE_CN.getCode())) {
                    customOpenCnImgMapper.deleteByUserId(userId);
                }
                if (localOpenInfo.getOpenType().equals(OpenType.ONLINE_HK.getCode())) {
                    customOpenHkImgMapper.deleteByUserId(userId);
                }
            }
//            //生成登录凭证
//            UserCert userCert = userDao.findUserCertByType(clientId, CertTypeEnum.trd.getTypeValue(), true);
//            if (userCert != null) {
//                logger.info("用户号" + userId + "客户号 " + clientId + " , BPM回调minigod返回信息：" + JSON.toJSONString(responseVO));
//            }
//
//            if (Integer.valueOf(openStatus) != OpenAccountEnum.OpenAccountStatus.OPEN_SUCCESS.getCode()) {
//                //开户失败，删除图片信息表
//                if (Integer.valueOf(openStatus) != OpenAccountEnum.OpenAccountStatus.PIC_ERROR.getCode()) {
//                    delImg = true;
//                }
//                if (Integer.valueOf(openStatus) == OpenAccountEnum.OpenAccountStatus.FINAL_REVIEW.getCode()) {
//                    delImg = false;
//                }
//                if (Integer.valueOf(openStatus) == OpenAccountEnum.OpenAccountStatus.PRE_APPROVAL.getCode()) {
//                    delImg = false;
//                }
//            }
//            if (Integer.valueOf(openStatus) == OpenAccountEnum.OpenAccountStatus.FINAL_REVIEW.getCode()) {
//                openUserInfo.setCaPushrecved(null);
//                openUserInfo.setCaVerifyStatus(null);
//            }
//            String openAccountFilrUrl = openAccountResultCallbackProtocol.getOpenAccountFileUrl();
//            if (StringUtils.isNotEmpty(openAccountFilrUrl)) {
//                openUserInfo.setOpenAccountPdfUrl(openAccountFilrUrl);
//            }
//            openAccountOnlineService.saveOpenInfo(openUserInfo, delImg);
//            responseVO = AppUtil.getSuccessMsg();
//
//            //更新登录凭证
//            if ("0".equals(openStatus) && clientId != null) {
//                //保存交易登录凭证
//                if (userCert == null) {
//                    userDao.saveTrdCert(clientId, userInfo.getUserId());
//                }
//
//                NotifyMsg<?> notifymsg = new NotifyMsg<>();
//                notifymsg.setCode(MsgStaticType.MsgCode.SEND_OPEN_ACCOUNT_SC);
//                notifymsg.setMsg("您的交易账户已经开通，重新登录即可买卖股票。");
//                notifymsg.setUserIds(Arrays.asList(userId));
//                platformService.pushNotifyMsg(notifymsg);
//
//                //开户成功，删除用户Session并强制退出.
//                this.logout(userId, request.getSession());
//            }

//            logger.info("用户号" + userId + "  , BPM回调minigod返回信息：" + JSON.toJSONString(responseVO));
//            return responseVO;
        } catch (InternalApiException e) {
            log.error("开户结果回调异常", e);
            throw new InternalApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            log.error("开户结果回调异常", e);
            throw new InternalApiException(StaticType.CodeType.ERROR_INTERNAL, StaticType.MessageResource.ERROR_INTERNAL);
        }
    }

    @Override
    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressReqParams params) {
        // 参数校验
        if (params == null || params.getFlag() == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String langKey = params.getLangKey();

        OpenUserInfoResVo response = new OpenUserInfoResVo();
        // 查询本地用户数据
        CustomInfo userInfo = getLocalRealCustom(userId);
        CustomOpenInfo customOpenInfo = getLocalOpenInfo(userId);

        String phone = userInfo.getPhone();
        Integer thirdCode = userInfo.getThirdCode();
        // 查询用户开户信息
        OpenStatus openStatusInfo = null;

        Integer openType = null;
        Integer fundAccountType = null;
        String tradeAccount = null;
        String fundAccount = null;

        // 查询bpm用户中心开户数据（根据手机号）
        BpmOpenAccountUserInfoReqVo bpmOpenAccountUserInforeqVo = new BpmOpenAccountUserInfoReqVo();
        if (thirdCode != null && thirdCode > 0) {
            bpmOpenAccountUserInforeqVo.setUserId(thirdCode);
        } else {
            bpmOpenAccountUserInforeqVo.setPhoneNumber(phone);
        }
        BpmOpenAccountUserInfoResVo bpmOpenAccountUserInfoResVo = restBpmHelper.selectSecuritiesUserInfo(bpmOpenAccountUserInforeqVo);

        // 查询到bpm用户数据
        if (bpmOpenAccountUserInfoResVo != null) {
            // clientStatus 客户状态[0-正常 1-冻结 2-挂失 3-销户 D-休眠 E-不合格 F-锁定]
            String clientStatus = bpmOpenAccountUserInfoResVo.getClientStatus();

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

            openType = bpmOpenAccountUserInfoResVo.getOpenAccountType();
            fundAccountType = bpmOpenAccountUserInfoResVo.getFundAccountType();
            fundAccount = bpmOpenAccountUserInfoResVo.getFundAccount();
            tradeAccount = bpmOpenAccountUserInfoResVo.getTradeAccount();
        } else if (customOpenInfo != null) {
            Integer openStatus = customOpenInfo.getStatus();
            openStatusInfo = OpenStatus.getStatus(openStatus);

            openType = customOpenInfo.getOpenType();
            fundAccountType = customOpenInfo.getFundAccountType();
            tradeAccount = customOpenInfo.getTradeAccount();
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
        response.setFundAccountType(fundAccountType);
        response.setTradeAccount(tradeAccount);
        response.setFundAccount(fundAccount);

        response.setOpenStatus(openStatusInfo.getCode());

        // 审核中
        if (openStatusInfo.equals(OpenStatus.PENDING)) {
            // 审核中状态
            Integer openUserInfoPendingType = customOpenInfo.getPendingType();
            PendingStatusType pendingStatusType = PendingStatusType.getType(openUserInfoPendingType);

            // 设置回包 审核中type
            response.setPendType(pendingStatusType.getCode());
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
            String failReason = customOpenInfo.getFailReason();
            String[] failReasonList = failReason.split(",");

            List<String> failReasonInfo = configLanguageMapper.selectContentByConfigKeyInAndLangKey(failReasonList, langKey);

            response.setFailReason(failReasonInfo);
        }

        response.setPhone(phone);
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
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_OCR);
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
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_OCR);
        }

        return ocrResponse;
    }
}
