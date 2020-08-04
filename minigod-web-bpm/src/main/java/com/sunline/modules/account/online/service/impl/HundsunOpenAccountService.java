package com.sunline.modules.account.online.service.impl;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.hundsun.*;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.utils.CharacterStringGenerate;
import com.sunline.modules.common.utils.ProtocolUtils;
import com.sunline.modules.quartz.entity.UpstreamInterfaceLog;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2017/3/22
 * @description
 * @email justbelyf@gmail.com
 */
@Service("hundsunOpenAccountService")
public class HundsunOpenAccountService {
    private static final Logger logger = LoggerFactory.getLogger(HundsunOpenAccountService.class);

    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    CustomerAccOpenApplyService customerAccountOpenApplicationService;
    @Autowired
    private ChannelFareSetupService channelFareSetupService;

    private final String hundsunClientUri = ConfigUtils.get("hundsun.interface.service.url");
    private UpstreamInterfaceLog upstreamInterfaceLog = new UpstreamInterfaceLog();
    private BpmCommonEnum.OpenAccountStep currentOpenAccountStep;
    private BpmCommonEnum.CommonProcessStatus currentOpenAccountStepStatus;
    private BpmCommonEnum.CommonProcessStatus openAccountResultStatus;
    private Map<String, String> needUpdateInfo = Maps.newHashMap();
    private boolean isEnd;
    private AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo;


    /**
     * 恒生后台开户流程
     *
     * @param customerAccountOpenApplicationId
     * @return
     */
    public boolean doOpenAccount(String customerAccountOpenApplicationId) {

        loadUserInfo(customerAccountOpenApplicationId);

        if (!validateStatus(accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity())) {
            return false;
        }

        currentOpenAccountStep = getNextStep();
        currentOpenAccountStepStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_IN_PROCESS;

        CommonResponse commonResponse = doBiz();

        currentOpenAccountStepStatus = "0".equals(commonResponse.getCommonErrorCode().getErrorCode()) ?
                BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED : BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED;

        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED == currentOpenAccountStepStatus) {
            openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED;
            isEnd = true;
        } else if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED == currentOpenAccountStepStatus) {
            if (isLastStep(currentOpenAccountStep)) {
                openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;
                isEnd = true;
            } else {
                openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_IN_PROCESS;
                isEnd = false;
            }
        }

        accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().setCurrentAccountOpenStep(currentOpenAccountStep.getNumber());
        accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().setCurrentAccountOpenStepStatus(currentOpenAccountStepStatus.getNumber());
        accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().setAccountOpenResultStatus(openAccountResultStatus.getNumber());


        if (!updateUserInfo()) {
            return false;
        }

        if (!isEnd) {
            dataReset();
            doOpenAccount(customerAccountOpenApplicationId);
        }

        return BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED == currentOpenAccountStepStatus;
    }


    /**
     * 数据重置
     *
     * @return
     */
    public boolean dataReset() {
        accountOpenApplicationDetailInfo = null;
        accountOpenApplicationDetailInfo = null;
        currentOpenAccountStep = null;
        currentOpenAccountStepStatus = null;
        openAccountResultStatus = null;
//        upstreamInterfaceLog = new UpstreamInterfaceLog();
        isEnd = false;
        return true;
    }


    /**
     * 加载开户数据
     *
     * @param customerAccountOpenApplicationId
     */
    private void loadUserInfo(String customerAccountOpenApplicationId) {
        AccountOpenApplyQuery queryCondition = new AccountOpenApplyQuery();
        queryCondition.setApplicationId(customerAccountOpenApplicationId);
        accountOpenApplicationDetailInfo = customerAccountOpenService.findList(queryCondition).get(0);
    }

    /**
     * 更新用户信息
     *
     * @return
     */
    private boolean updateUserInfo() {
        customerAccountOpenApplicationService.update(accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity());
        customerAccountOpenInfoService.update(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity());
        return true;
    }


    /**
     * 验证该用户是否符合开户需求
     *
     * @param applicationInfo
     * @return
     */
    private boolean validateStatus(CustomerAccountOpenApplyEntity applicationInfo) {
        if (null == applicationInfo) {
            return false;
        }

        // 开户流程还未开始
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE == applicationInfo.getAccountOpenResultStatus()) {
            return true;
        }

//        Enum.CommonProcessStatus openAccountStepStatus = Enum.CommonProcessStatus.valueOf(applicationInfo.getCurrentAccountOpenStepStatus());

        // 当前开户步奏待处理或者失败
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE == applicationInfo.getCurrentAccountOpenStepStatus() || BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE == applicationInfo.getCurrentAccountOpenStepStatus()) {
            return true;
        }

        // 正在开户且当前步奏处理成功
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_IN_PROCESS_VALUE == applicationInfo.getAccountOpenResultStatus()
                && BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE == applicationInfo.getCurrentAccountOpenStepStatus()) {
            return true;
        }

        return false;
    }


    /**
     * 执行具体开户业务
     *
     * @return
     */
    private CommonResponse doBiz() {
        CommonResponse commonResponse = null;
        switch (currentOpenAccountStep) {
            case OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT:
                commonResponse = send(currentOpenAccountStep, createUserAccount());
                if ("0".equals(commonResponse.getCommonErrorCode().getErrorCode())) {
                    JSONObject userAccountInfo = JSON.parseObject(JSON.toJSONString(commonResponse.getDataResult()));
//                    needUpdateInfo.put("tradeAccount", userAccountInfo.getString("client_id"));
                    accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().setClientId(userAccountInfo.getString("client_id"));
                }
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT:
                UserAccount.UserAccountIdentifyRequest userAccountIdentifyRequest = identifyUserAccount();
                commonResponse = send(currentOpenAccountStep, userAccountIdentifyRequest);
                if ("0".equals(commonResponse.getCommonErrorCode().getErrorCode())) {
//                    needUpdateInfo.put("tradeAccountPassword", userAccountIdentifyRequest.getPassword());
//                    accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().setInitialAccountPassword(userAccountIdentifyRequest.getPassword());
                    accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().setInitialAccountPassword(ProtocolUtils.getEncryptPhone(userAccountIdentifyRequest.getPassword()));

                }
                break;
            case OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT:
                commonResponse = send(currentOpenAccountStep, createFundAccount());
                if ("0".equals(commonResponse.getCommonErrorCode().getErrorCode())) {
                    JSONObject fundAccountInfo = JSON.parseObject(JSON.toJSONString(commonResponse.getDataResult()));
//                    needUpdateInfo.put("fundAccount", fundAccountInfo.getString("fund_account"));
                    accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().setFundAccount(fundAccountInfo.getString("fund_account"));
                    accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().setOpenAccountTime(new Date());
                }
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT:
                commonResponse = send(currentOpenAccountStep, identifyFundAccount());
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY:
                commonResponse = send(currentOpenAccountStep, createCurrencyAccount("0"));
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD:
                commonResponse = send(currentOpenAccountStep, createCurrencyAccount("2"));
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD:
                commonResponse = send(currentOpenAccountStep, createCurrencyAccount("1"));
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK:
                commonResponse = send(currentOpenAccountStep, createStockAccount("K"));
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US:
                commonResponse = send(currentOpenAccountStep, createStockAccount("P"));
                break;
            case OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION:
                commonResponse = send(currentOpenAccountStep, settingUserBrokerRelation());
                break;
            case OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES:
                commonResponse = send(currentOpenAccountStep, settingTransactionExpenses());
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY:
                commonResponse = send(currentOpenAccountStep, manageNotification(1));
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY:
                commonResponse = send(currentOpenAccountStep, manageNotification(2));
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_ADDRESS:
                commonResponse = send(currentOpenAccountStep, manageAddress());
                break;
            default:
                return null;

        }

        return commonResponse;
    }


    /**
     * 获取开户步骤的下一步
     *
     * @return
     */
    private BpmCommonEnum.OpenAccountStep getNextStep() {
        CustomerAccountOpenApplyEntity applicationInfo = accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity();
        openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.valueOf(applicationInfo.getAccountOpenResultStatus());

        // 还未开始开户业务，则从第一步开始
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING == openAccountResultStatus) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT;
        }

        BpmCommonEnum.OpenAccountStep currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.valueOf(applicationInfo.getCurrentAccountOpenStep());
        BpmCommonEnum.CommonProcessStatus openAccountStepStatus = BpmCommonEnum.CommonProcessStatus.valueOf(applicationInfo.getCurrentAccountOpenStepStatus());
        // 当前步奏待处理责继续处理
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING == openAccountStepStatus) {
            return currentOpenAccountStep;
        }

        // 处理失败的步奏则继续处理当前步奏
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED == openAccountStepStatus) {
            return currentOpenAccountStep;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US;
        }
        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_ADDRESS;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_ADDRESS) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY) {
            return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY;
        }

        if (currentOpenAccountStep == BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY) {
            return null;
        }

        return null;

    }


    private boolean isFirstStep(BpmCommonEnum.OpenAccountStep openAccountStep) {

        return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT == openAccountStep;
    }

    private boolean isLastStep(BpmCommonEnum.OpenAccountStep openAccountStep) {

        return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY == openAccountStep;
    }


    private CommonResponse send(BpmCommonEnum.OpenAccountStep currentStep, Object obj) {
        String requestUri = hundsunClientUri;
        switch (currentStep) {
            case OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT:
                requestUri += "hundsunProxyService/createUserAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT:
                requestUri += "hundsunProxyService/identifyUserAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT:
                requestUri += "hundsunProxyService/createFundAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT:
                requestUri += "hundsunProxyService/identifyFundAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY:
                requestUri += "hundsunProxyService/createCurrencyAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD:
                requestUri += "hundsunProxyService/createCurrencyAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD:
                requestUri += "hundsunProxyService/createCurrencyAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK:
                requestUri += "hundsunProxyService/createStockAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US:
                requestUri += "hundsunProxyService/createStockAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION:
                requestUri += "hundsunProxyService/settingUserBrokerRelation.do";
                break;
            case OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES:
                requestUri += "hundsunProxyService/settingTransactionExpenses.do";
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY:
                requestUri += "hundsunProxyService/manageNotification.do";
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY:
                requestUri += "hundsunProxyService/manageNotification.do";
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_ADDRESS:
                requestUri += "hundsunProxyService/manageAddress.do";
                break;
            default:
                return null;
        }


        Map<String, Object> parameterMap = Maps.newHashMap();
        parameterMap.put("requestParametersData", JSON.toJSONString(obj));

        String result = null;
        try {

            logger.info("HundSun Interface Request Url：" + requestUri);
            logger.info("HundSun Interface Request Info：" + JSON.toJSONString(parameterMap));

            result = HttpUtil.post(requestUri, parameterMap);

            logger.info("HundSun Interface Response Info：" + result);

        } catch (Exception e) {
            logger.error("开户失败", e);
            return CommonResponse.getResponse("500", "Http请求异常");
        }

        return JSON.parseObject(result, CommonResponse.class);
    }

    /**
     * 创建客户号
     *
     * @return
     */
    private UserAccount.UserAccountCreateRequest createUserAccount() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();
        UserAccount.UserAccountCreateRequest userAccountCreateRequest = new UserAccount.UserAccountCreateRequest();
//        userAccountCreateRequest.setClientName(customerAccountOpenInfoEntity.getClientNameSpell());

        String clientNameSpell = "";
        try {
            if (StringUtils.isNotBlank(customerAccountOpenInfoEntity.getFamilyNameSpell()) && StringUtils.isNotBlank(customerAccountOpenInfoEntity.getGivenNameSpell())) {
                clientNameSpell = customerAccountOpenInfoEntity.getFamilyNameSpell() + " " + customerAccountOpenInfoEntity.getGivenNameSpell();
            } else {
                clientNameSpell = PinyinHelper.convertToPinyinString(customerAccountOpenInfoEntity.getFamilyName(), "", PinyinFormat.WITHOUT_TONE).toUpperCase()
                        + " " + PinyinHelper.convertToPinyinString(customerAccountOpenInfoEntity.getGivenName(), "", PinyinFormat.WITHOUT_TONE).toUpperCase();
            }
        } catch (Exception e) {
            logger.error("客户姓名转换拼音异常", e);
        }

        userAccountCreateRequest.setClientName(clientNameSpell);
        userAccountCreateRequest.setLocaleName(customerAccountOpenInfoEntity.getClientName());

        // 国籍字典转义
        userAccountCreateRequest.setNationality(customerAccountOpenInfoEntity.getNationality());

        userAccountCreateRequest.setClientSex(customerAccountOpenInfoEntity.getSex().toString());

        // 护照字典转义
        if (2 == customerAccountOpenInfoEntity.getIdKind() || 4 == customerAccountOpenInfoEntity.getIdKind()) {
            userAccountCreateRequest.setIdKind("0");
        } else if (3 == customerAccountOpenInfoEntity.getIdKind()) {
            userAccountCreateRequest.setIdKind("2");
        } else {
            userAccountCreateRequest.setIdKind(String.valueOf(customerAccountOpenInfoEntity.getIdKind()));
        }

        userAccountCreateRequest.setIdNo(customerAccountOpenInfoEntity.getIdNo());
        userAccountCreateRequest.setIdAddress(customerAccountOpenInfoEntity.getIdCardAddress());
        userAccountCreateRequest.setBirthday(Integer.valueOf(customerAccountOpenInfoEntity.getBirthday().replace("-", "")));
        if (StringUtils.isNoneBlank(customerAccountOpenInfoEntity.getClientId())) {
            userAccountCreateRequest.setClientId(customerAccountOpenInfoEntity.getClientId());
        }

        if (null != customerAccountOpenInfoEntity.getAcceptRisk()) {
            userAccountCreateRequest.setRiskLevel(customerAccountOpenInfoEntity.getAcceptRisk());
        } else {
            userAccountCreateRequest.setRiskLevel(3);
        }

        return userAccountCreateRequest;

    }

    /**
     * 认证客户号
     *
     * @return
     */
    private UserAccount.UserAccountIdentifyRequest identifyUserAccount() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserAccount.UserAccountIdentifyRequest userAccountIdentifyRequest = new UserAccount.UserAccountIdentifyRequest();
        userAccountIdentifyRequest.setUserID(customerAccountOpenInfoEntity.getClientId());
        userAccountIdentifyRequest.setUserAccount(customerAccountOpenInfoEntity.getClientId());
        String password = CharacterStringGenerate.generate(8);
        userAccountIdentifyRequest.setPassword(password);
        userAccountIdentifyRequest.setQueryPwd(password);

        return userAccountIdentifyRequest;

    }

    /**
     * 创建资金帐号
     *
     * @return
     */
    private UserFundAccount.UserFundAccountCreateRequest createFundAccount() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserFundAccount.UserFundAccountCreateRequest userFundAccountCreateRequest = new UserFundAccount.UserFundAccountCreateRequest();
        userFundAccountCreateRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        String createDate = DateFormatUtils.format(customerAccountOpenInfoEntity.getApplicationTime(), "yyyyMMdd");
        userFundAccountCreateRequest.setContractDate(Integer.valueOf(createDate));
        userFundAccountCreateRequest.setCreditRatio(1d);

        return userFundAccountCreateRequest;

    }

    /**
     * 认证资金帐号
     *
     * @return
     */
    private UserFundAccount.UserFundAccountIdentifyRequest identifyFundAccount() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserFundAccount.UserFundAccountIdentifyRequest userFundAccountIdentifyRequest = new UserFundAccount.UserFundAccountIdentifyRequest();
        userFundAccountIdentifyRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfoEntity.getFundAccount()));
        userFundAccountIdentifyRequest.setRemark("remark");
        userFundAccountIdentifyRequest.setUserID(customerAccountOpenInfoEntity.getClientId());

        return userFundAccountIdentifyRequest;

    }

    /**
     * 开通币种人民币
     *
     * @param moneyType
     * @return
     */
    private UserCurrencyAccount.UserCurrencyAccountCreateRequest createCurrencyAccount(String moneyType) {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserCurrencyAccount.UserCurrencyAccountCreateRequest userCurrencyAccountCreateRequest = new UserCurrencyAccount.UserCurrencyAccountCreateRequest();
        userCurrencyAccountCreateRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        userCurrencyAccountCreateRequest.setEnMoneyType(moneyType);
        userCurrencyAccountCreateRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfoEntity.getFundAccount()));

        return userCurrencyAccountCreateRequest;

    }

    /**
     * 开通港股/美股市场
     *
     * @param exchangeType
     * @return
     */
    private UserStockAccount.UserStockAccountCreateRequest createStockAccount(String exchangeType) {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserStockAccount.UserStockAccountCreateRequest userStockAccountCreateRequest = new UserStockAccount.UserStockAccountCreateRequest();
        userStockAccountCreateRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        userStockAccountCreateRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfoEntity.getFundAccount()));
        userStockAccountCreateRequest.setHolderName(customerAccountOpenInfoEntity.getClientName());
        userStockAccountCreateRequest.setStockAccount(customerAccountOpenInfoEntity.getFundAccount());
        userStockAccountCreateRequest.setIdKind(customerAccountOpenInfoEntity.getIdKind().toString());
        userStockAccountCreateRequest.setIdNo(customerAccountOpenInfoEntity.getIdNo());
        userStockAccountCreateRequest.setExchangeType(exchangeType);

        return userStockAccountCreateRequest;

    }

    /**
     * 设置经纪人关系
     *
     * @return
     */
    private UserInfo.BrokerRelationCreateRequest settingUserBrokerRelation() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserInfo.BrokerRelationCreateRequest brokerRelationCreateRequest = new UserInfo.BrokerRelationCreateRequest();
        brokerRelationCreateRequest.setBrokerAccount("1000");
        brokerRelationCreateRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        brokerRelationCreateRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfoEntity.getFundAccount()));

        return brokerRelationCreateRequest;

    }

    /**
     * 设置交易费用
     *
     * @return
     */
    private UserInfo.TradeFareSettingRequest settingTransactionExpenses() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        // 查询客户所属渠道佣金套餐
        ChannelFareSetupEntity channelFareSetupEntity = channelFareSetupService.getClientFarePackage(customerAccountOpenInfoEntity.getSourceChannelId());

        UserInfo.TradeFareSettingRequest tradeFareSettingRequest = new UserInfo.TradeFareSettingRequest();
        tradeFareSettingRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        tradeFareSettingRequest.setFareKindStr(channelFareSetupEntity == null ? "1000" : channelFareSetupEntity.getFareKind());
        tradeFareSettingRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfoEntity.getFundAccount()));

        return tradeFareSettingRequest;

    }

    /**
     * 1=日结 2=月结
     *
     * @param settlementType
     * @return
     */
    private UserInfo.CommunicationInfoOperateRequest manageNotification(int settlementType) {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserInfo.CommunicationInfoOperateRequest communicationInfoOperateRequest = new UserInfo.CommunicationInfoOperateRequest();
        communicationInfoOperateRequest.setActionIn(0);
//        communicationInfoOperateRequest.setAddressID("1");
        if (1 == settlementType) {
            communicationInfoOperateRequest.setNotificationType("2");
            communicationInfoOperateRequest.setNotificationFormat("4");
        } else if (2 == settlementType) {
            communicationInfoOperateRequest.setNotificationType("3");
            communicationInfoOperateRequest.setNotificationFormat("6");
        }
        communicationInfoOperateRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        communicationInfoOperateRequest.setFundAccount(Integer.valueOf(customerAccountOpenInfoEntity.getFundAccount()));

        return communicationInfoOperateRequest;

    }

    /**
     * 客户通讯地址管理
     *
     * @return
     */
    private UserInfo.AddressOperateRequest manageAddress() {
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

        UserInfo.AddressOperateRequest addressOperateRequest = new UserInfo.AddressOperateRequest();
        addressOperateRequest.setActionIn(0);
//        addressOperateRequest.setAddressID("1");
        addressOperateRequest.setAddressee(customerAccountOpenInfoEntity.getClientName());
        addressOperateRequest.setClientID(customerAccountOpenInfoEntity.getClientId());
        addressOperateRequest.setEmail(customerAccountOpenInfoEntity.getEmail());
        addressOperateRequest.setShortName(customerAccountOpenInfoEntity.getContactAddress());
        addressOperateRequest.setMobile(customerAccountOpenInfoEntity.getPhoneNumber());
        addressOperateRequest.setPhone(customerAccountOpenInfoEntity.getPhoneNumber());
        addressOperateRequest.setLocaleName(customerAccountOpenInfoEntity.getClientName());
        addressOperateRequest.setLocaleAddress1(customerAccountOpenInfoEntity.getContactProvinceName());
        addressOperateRequest.setLocaleAddress2(customerAccountOpenInfoEntity.getContactCityName());
        addressOperateRequest.setLocaleAddress3(customerAccountOpenInfoEntity.getContactCountyName());
        addressOperateRequest.setLocaleAddress4(customerAccountOpenInfoEntity.getContactDetailAddress());

        return addressOperateRequest;

    }
}
