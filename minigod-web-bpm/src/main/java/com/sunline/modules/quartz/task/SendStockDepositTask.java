package com.sunline.modules.quartz.task;


import com.google.common.collect.Lists;
import com.sunline.modules.account.online.utils.EmailSender;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.hundsun.protocol.request.StockDepositRequest;
import com.sunline.modules.hundsun.protocol.response.StockDepositResponse;
import com.sunline.modules.hundsun.service.HsStockManageService;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author fuyy
 * @createDate 2018/12/19
 * @description
 * @email 赠股入账
 */
@Component("sendStockDepositTask")
public class SendStockDepositTask {

    private final Logger logger = LoggerFactory.getLogger(SendStockDepositTask.class);

    @Autowired
    DonatedStockApplicationInfoService donatedStockService;

    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;

    /**
     * 赠股入账
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");

        List<DonatedStockApplicationInfoEntity> donatedStockApplicationInfoEntityList = donatedStockService.selectWaitStockDeposit();
        logger.info("增股入账开始，待入账数据条数：" + donatedStockApplicationInfoEntityList.size());
        for (DonatedStockApplicationInfoEntity applyEntity : donatedStockApplicationInfoEntityList) {

            //股票代码把.HK的后缀去掉，去掉前缀0
            String stockCode = applyEntity.getStockCode();
            stockCode = stockCode.toUpperCase().replaceAll(".HK", "").replaceFirst("^0*", "");

            StockDepositRequest stockDepositRequest = new StockDepositRequest();

            stockDepositRequest.setToFundAcct(applyEntity.getFundAccount());
            stockDepositRequest.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_SEHK.getIndex());
            stockDepositRequest.setStockCode(stockCode);
            stockDepositRequest.setOccurAmount(applyEntity.getStockQuantity());
            stockDepositRequest.setEventId(Integer.parseInt(applyEntity.getActivityId()));
            stockDepositRequest.setBusinessNo(applyEntity.getApplicationId());

            StringBuffer remark = new StringBuffer("参与赠股市场活动，资金满10000港币，获赠");
            remark.append(applyEntity.getStockQuantity()).append("股").append(stockCode).append(applyEntity.getStockName());
            stockDepositRequest.setRemark(remark.toString());

            StockDepositResponse stockDepositResponse = HsStockManageService.stockDeposit(stockDepositRequest);

            if (null != stockDepositResponse) {
                if (stockDepositResponse.getCode() == CrmCommonEnum.CodeType.OK.getCode() || stockDepositResponse.getCode() == -55) {
                    //更新为入账成功
                    applyEntity.setAccountEntryStatus(BpmCommonEnum.AccountEntryStatus.ACCOUNT_ENTRY_STATUS_YES_VALUE);
                    applyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                } else {
                    //更新为入账失败
                    applyEntity.setAccountEntryStatus(BpmCommonEnum.AccountEntryStatus.ACCOUNT_ENTRY_STATUS_FAIL_VALUE);

                    StringBuffer errMsg = new StringBuffer("预约流水号：");
                    errMsg.append(applyEntity.getApplicationId()).append(" 入账失败，失败原因：" + stockDepositResponse.getMessage());
                    logger.info(errMsg.toString());

                    // 发送邮件通知
                    boolean isSucceed = EmailSender.sendEmailText(SysConfigUtil.getSysConfigValue("SYSTEM_NOTICE_EMAIL_GROUP", "it@zszhizhu.com;laijieqiang@zszhizhu.com")
                            , "【系统异常】CUBP系統赠股发放", errMsg.toString()+"，请尽快处理！", Lists.newArrayList());
                }
                donatedStockService.update(applyEntity);
            }
        }

    }
}
