package com.sunline.modules.quartz.manager;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.utils.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sunline.modules.common.common.BpmCommonEnum;


import java.util.HashMap;
import java.util.Map;

public  class HundsunOpenAccountManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(HundsunOpenAccountManager.class);

    public BpmCommonEnum.OpenAccountStep currentOpenAccountStep;
    public BpmCommonEnum.CommonProcessStatus currentOpenAccountStepStatus;
    public BpmCommonEnum.CommonProcessStatus openAccountResultStatus;
    public boolean isEnd;


    public HundsunOpenAccountManager(BpmCommonEnum.OpenAccountStep currentOpenAccountStep, BpmCommonEnum.CommonProcessStatus currentOpenAccountStepStatus, BpmCommonEnum.CommonProcessStatus openAccountResultStatus) {
        this(currentOpenAccountStep, currentOpenAccountStepStatus, openAccountResultStatus, false);
    }

    public HundsunOpenAccountManager(BpmCommonEnum.OpenAccountStep currentOpenAccountStep, BpmCommonEnum.CommonProcessStatus currentOpenAccountStepStatus, BpmCommonEnum.CommonProcessStatus openAccountResultStatus, boolean isEnd) {
        this.openAccountResultStatus = openAccountResultStatus;
        this.currentOpenAccountStep = currentOpenAccountStep;
        this.currentOpenAccountStepStatus = currentOpenAccountStepStatus;
        this.isEnd = isEnd;
    }


    /**
     * 验证该用户是否符合开户需求
     *
     * @return
     */
    public boolean validateStatus() {
        // 开户流程还未开始
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING == openAccountResultStatus) {
            return true;
        }

        // 当前开户步奏待处理或者失败
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING == currentOpenAccountStepStatus || BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED == currentOpenAccountStepStatus) {
            return true;
        }

        // 正在开户且当前步奏处理成功
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_IN_PROCESS == openAccountResultStatus
                && BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED == currentOpenAccountStepStatus) {
            return true;
        }

        return false;
    }


    public boolean isFirstStep(BpmCommonEnum.OpenAccountStep openAccountStep) {

        return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT == openAccountStep;
    }


    public boolean isLastStep(BpmCommonEnum.OpenAccountStep openAccountStep) {

        return BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY == openAccountStep;
    }


    /**
     * 获取下一步
     *
     * @return
     */
    public void nextStep() {

        // 还未开始开户业务，则从第一步开始
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING == openAccountResultStatus) {
            currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT;
            return;
        }

        // 当前步奏待处理责继续处理
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING == currentOpenAccountStepStatus) {
            currentOpenAccountStep = currentOpenAccountStep;
            return;
        }

        // 处理失败的步奏则继续处理当前步奏
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED == currentOpenAccountStepStatus) {
            currentOpenAccountStep = currentOpenAccountStep;
            return;
        }

        switch (currentOpenAccountStep) {
            case OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT;
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT;
                break;
            case OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT;
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY;
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD;
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD;
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK;
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US;
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION;
                break;
            case OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES;
                break;
            case OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_ADDRESS;
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_ADDRESS:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY;
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY;
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_UN_KNOWN;
                break;
            default:
                currentOpenAccountStep = BpmCommonEnum.OpenAccountStep.OPEN_ACCOUNT_STEP_UN_KNOWN;
        }
    }


    public void setProcessResult(Boolean isProcessSucceed) {
        currentOpenAccountStepStatus = isProcessSucceed ? BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED : BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED;
        // 处理失败
        if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED == currentOpenAccountStepStatus) {
            openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED;
            isEnd = true;
        } else if (BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED == currentOpenAccountStepStatus) {

            //处理成功
            if (isLastStep(currentOpenAccountStep)) {
                openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED;
                isEnd = true;
            } else {
                openAccountResultStatus = BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_IN_PROCESS;
                isEnd = false;
            }
        }
    }

    public String getRequestUrl(BpmCommonEnum.OpenAccountStep currentStep) {
//        String requestUri = Global.getConfig("hundsun.interface.service.url");
        String requestUri = ConfigUtils.get("hundsun.interface.service.url");
        switch (currentStep) {
            case OPEN_ACCOUNT_STEP_CRATE_USER_ACCOUNT:
                requestUri += "/hundsunProxyService/createUserAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_USER_ACCOUNT:
                requestUri += "/hundsunProxyService/identifyUserAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_FUND_ACCOUNT:
                requestUri += "/hundsunProxyService/createFundAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_IDENTIFY_FUND_ACCOUNT:
                requestUri += "/hundsunProxyService/identifyFundAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_CNY:
                requestUri += "/hundsunProxyService/createCurrencyAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_HKD:
                requestUri += "/hundsunProxyService/createCurrencyAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_CURRENCY_ACCOUNT_USD:
                requestUri += "/hundsunProxyService/createCurrencyAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_HK:
                requestUri += "/hundsunProxyService/createStockAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_CREATE_STOCK_ACCOUNT_US:
                requestUri += "/hundsunProxyService/createStockAccount.do";
                break;
            case OPEN_ACCOUNT_STEP_SETTING_USER_BROKER_RELATION:
                requestUri += "/hundsunProxyService/settingUserBrokerRelation.do";
                break;
            case OPEN_ACCOUNT_STEP_SETTING_TRANSACTION_EXPENSES:
                requestUri += "/hundsunProxyService/settingTransactionExpenses.do";
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_DAILY:
                requestUri += "/hundsunProxyService/manageNotification.do";
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_NOTIFICATION_MONTHLY:
                requestUri += "/hundsunProxyService/manageNotification.do";
                break;
            case OPEN_ACCOUNT_STEP_MANAGE_ADDRESS:
                requestUri += "/hundsunProxyService/manageAddress.do";
                break;
            default:
                return null;
        }

        return requestUri;
    }


    public CommonResponse send(String requestUri, Object obj) {
        Map<String, String> parameterMap = Maps.newHashMap();
        parameterMap.put("requestParametersData", JSON.toJSONString(obj));


        String result = null;
        try {
            result = HttpClientUtils.post(requestUri, parameterMap);
        } catch (Exception e) {
            LOGGER.error("开户失败", e);
            return CommonResponse.getResponse("88888", "HTTP请求异常");
        }

        LOGGER.info("interface response info =" + result);

        return JSON.parseObject(result, CommonResponse.class);
    }


    public BpmCommonEnum.OpenAccountStep getCurrentOpenAccountStep() {
        return currentOpenAccountStep;
    }

    public BpmCommonEnum.CommonProcessStatus getCurrentOpenAccountStepStatus() {
        return currentOpenAccountStepStatus;
    }

    public BpmCommonEnum.CommonProcessStatus getOpenAccountResultStatus() {
        return openAccountResultStatus;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
