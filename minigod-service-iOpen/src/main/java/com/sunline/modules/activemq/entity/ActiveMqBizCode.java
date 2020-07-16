package com.sunline.modules.activemq.entity;

/**
 * @description: MQ主题
 * @author: Larry Lai
 * @date: 2020/1/3 09:38
 * @version: v1.0
 */

public class ActiveMqBizCode {

    /**
     * 入金业务消息
     */
    public static final String FUND_DEPOSIT = "fundDeposit";

    /**
     * 入金回调消息
     */
    public static final String FUND_DEPOSIT_CALLBACK = "fundDepositCallBack";

    /**
     * 用户中心扩展信息
     */
    public static final String USER_INFO_EXT = "userInfo_cubp";

    /**
     * DBS API ICC
     */
    public static final String CUBP_DBS_ICC_MSG_QUEUE = "cubpDbsIccMsgQueue";
}
