package com.sunline.modules.activiti.helper;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author LiYangFeng
 * @createDate 2018/4/11
 * @description
 * @email justbelyf@gmail.com
 */

public class ExtendActBusinessHelper {
    private static Map<String, String> approveTaskUris = Maps.newConcurrentMap();

    public static String getApproveTaskPageUri(String actKey) {

        return approveTaskUris.get(actKey);
    }

    static {
        approveTaskUris.put("customerAccountOpenApplication", "customer/customerAccountOpenInfoApprove");
        approveTaskUris.put("customerAccountMarginOpenApplication", "customer/customerAccountMarginOpenApprove");
        approveTaskUris.put("derivativesTransactionApplication", "userWorkflow/workFlowApproveInfo");
        approveTaskUris.put("usaStockMarketApplication", "userWorkflow/workFlowApproveInfo");
        approveTaskUris.put("employeeLeaveApplication", "employee/employeeLeaveInfoApprove");
        approveTaskUris.put("customerOfflineOpenApplication", "offlineCustomer/customerOfflineOpenInfoApprove");
        approveTaskUris.put("channelFareSetApprove", "channelFareSetupLog/info");
        approveTaskUris.put("clientFareSetApprove", "clientFareSetupLog/info");
        approveTaskUris.put("customerAccountOpenApplicationOffline", "offlineCustAccOpen/custAccOpenInfoApprove");
        approveTaskUris.put("donatedStock", "donatedStock/donatedStockApprove");
        approveTaskUris.put("clientFundWithdrawApplication", "clientFundWithdraw/approve");
        approveTaskUris.put("fundWithdrawRefundApplication", "fundWithdrawRefund/approve");
        approveTaskUris.put("fundDepositApplication", "clientFundDeposit/clientFundDepositApprove");
    }

}
