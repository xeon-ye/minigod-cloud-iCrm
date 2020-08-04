package com.sunline.modules.quartz.task;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 异常检查调度任务
 * @author: Larry Lai
 * @date: 2020/2/12 11:01
 * @version: v1.0
 */

@Component("abnormalMonitorTask")
public class AbnormalMonitorTask {

    private static final Logger logger = LoggerFactory.getLogger(AbnormalMonitorTask.class);

    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;

    public void excute(String params) {

        logger.info(params + "任务开始");

        List<CustomerAccountOpenApplyEntity> abnormalDataList = customerAccOpenApplyService.qryAbnormalData(new CustomerAccountOpenApplyEntity());

        if (null != abnormalDataList && abnormalDataList.size() > 0) {

            StringBuilder stringBuilder = new StringBuilder();
            for (CustomerAccountOpenApplyEntity data : abnormalDataList) {
                stringBuilder.append(data.getApplicationId()).append("|");
            }

            String msg = "预约流水号：" + stringBuilder.toString() + "审核流程出现异常，请及时处理！";

            generateSendEmail("【CUBP异常通知】开户审核业务数据异常", msg);

        }
    }

    /**
     * 发送邮件通知
     *
     * @param title
     * @param message
     */
    private void generateSendEmail(String title, String message) {
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("ABNORMAL_DATA_EMAIL_GROUP", "laijieqiang@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }

}
