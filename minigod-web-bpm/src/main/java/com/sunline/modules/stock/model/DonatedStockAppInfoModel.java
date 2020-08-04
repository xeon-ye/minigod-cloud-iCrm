package com.sunline.modules.stock.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 赠股申请信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-12-07 15:05:58
 */
@Data
public class DonatedStockAppInfoModel {

    //自增ID
    private Long id;
    //流水号
    private String applicationId;
    //小神号
    private Integer userId;
    //渠道号
    private String channelId;
    //交易帐号/客户帐号
    private String clientId;
    //客户名称
    private String clientName;
    //证券手机号
    private String phoneNumber;
    //股票代码
    private String stockCode;
    //股票名称
    private String stockName;
    //股票数量
    private Integer stockQuantity;
    //总成本HKD
    private BigDecimal totalCost;
    //活动ID
    private String activityId;
    //活动名称
    private String activityName;
    //方案ID
    private String programmeId;
    //领取时间
    private String receiveTime;
    //打印状态[1-未打印 2-已打印]
    private String printStatus;
    //打印操作人
    private String printOperator;
    //印花税状态[1-待缴纳 2-已缴纳]
    private String stampDutyStatus;
    //缴纳印花税操作人
    private String stampDutyOperator;
    //入账状态[0-未知 1-待入账 2-已入账 3-入账失败]
    private String accountEntryStatus;

    //领取开始时间时间
    private String receiveTimeStart;

    //领取开始时间时间
    private String receiveTimeEnd;
    //渠道名字
    private String channelName;
    //注册时间
    private String registerTime;
    //开户时间
    private Date openAccountTime;
    //首次入金
    private String firstIncome;
    //首转仓
    private String firstTransfer;
    //平均成本HKD
    private String averageCost;
    //英文名称
    private String clientNameSpell;

    //资金帐号
    private String fundAccount;
    private String firstIncomeDate;
    private String firstTransferDate;

    //奖励类型
    private String activType;

    private String bankType;

    //开户方式
    private String openAccountType;

    //打印序号
    private int num;

}
