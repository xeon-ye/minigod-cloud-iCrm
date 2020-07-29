package com.sunline.modules.quartz.task;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;
import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.VelocityUtil;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.enums.CustomerEnums;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 开户提醒信息发送调度任务
 * @author: jim
 * @date: 2019/05/20 13:14
 */
@Component("openAccountHintMsgTask")
public class OpenAccountHintMsgTask {

    private static final Logger logger = LoggerFactory.getLogger(OpenAccountHintMsgTask.class);
    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    private SecUserInfoService secUserInfoService;

    /**
     * 调度任务
     *
     * @param params
     */
    public void excute(String params) {

        logger.info(params + "任务开始");

        // CA验证通知
        AccountOpenApplyQuery queryCondition = new AccountOpenApplyQuery();
        queryCondition.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "8"));
        queryCondition.setApplicationStatus(Integer.valueOf(CodeUtils.getCodeValue("AO_OPEN_ACCOUNT_STATUS", "12")));
        List<AccountOpenApplyDetailInfo> list = customerAccountOpenService.findList(queryCondition);

        logger.info("CA验证通知待处理数据条数：" + list.size());
        for (AccountOpenApplyDetailInfo info : list) {
            CustomerAccountOpenApplyEntity entity = info.getCustomerAccountOpenApplyEntity();
            //计算自然日之差
            Date caTime = DateUtil.beginOfDay(entity.getUpdateTime());
            long betweenDay = DateUtil.between(caTime, new Date(), DateUnit.DAY);
            if (1 == betweenDay || 2 == betweenDay || 4 == betweenDay) {
                List<String> paramList = Lists.newArrayList();
                paramList.add(info.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(info.getCustomerAccountOpenInfoEntity().getClientName()) ?
                        info.getCustomerAccountOpenInfoEntity().getClientName() : info.getCustomerAccountOpenInfoEntity().getClientNameSpell());
                generateSendSms(2009, info.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
            }
        }

        // 开户退回提交开户申请通知
        AccountOpenApplyQuery backQueryCondition = new AccountOpenApplyQuery();
        backQueryCondition.setApplicationStatus(Integer.valueOf(CodeUtils.getCodeValue("AO_OPEN_ACCOUNT_STATUS", "7")));
        List<AccountOpenApplyDetailInfo> waitingForOpenAccBackData = customerAccountOpenService.selectAccountOpenBackDetailInfo(backQueryCondition);
        logger.info("开户退回提交开户申请通知待处理数据条数：" + waitingForOpenAccBackData.size());

        for (AccountOpenApplyDetailInfo openAccBackData : waitingForOpenAccBackData) {

            CustomerAccountOpenApplyEntity customerAccountOpenApplyInfo = openAccBackData.getCustomerAccountOpenApplyEntity();

            // 计算自然日之差
            Date backTime = DateUtil.beginOfDay(customerAccountOpenApplyInfo.getUpdateTime());
            long betweenDay = DateUtil.between(backTime, new Date(), DateUnit.DAY);
            if (2 == betweenDay || 3 == betweenDay || 5 == betweenDay) {

                List<String> paramList = Lists.newArrayList();

                List<String> errorContentTypes = JSON.parseArray(openAccBackData.getCustomerAccountOpenApplyEntity().getErrorContentTypes(), String.class);

                StringBuilder errorMsg = new StringBuilder();
                String reason = "";

                if (null != errorContentTypes) {
                    for (String type : errorContentTypes) {
                        errorMsg.append(CodeUtils.getCodeName("AO_CONTENT_ERROR_TYPE", type)).append("，");
                    }
                }

                List<OpenAccountImageInfo> errorImageTypes = JSON.parseArray(openAccBackData.getCustomerAccountOpenApplyEntity().getErrorImages(), OpenAccountImageInfo.class);

                if (null != errorImageTypes) {
                    for (OpenAccountImageInfo imageInfo : errorImageTypes) {
                        errorMsg.append(CodeUtils.getCodeName("AO_IMAGE_ERROR_TYPE", String.valueOf(imageInfo.getImageLocationType()))).append("不符").append("，");
                    }
                }

                reason = errorMsg.length() > 0 ? errorMsg.substring(0, errorMsg.length() - 1) : "";


                paramList.add(openAccBackData.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(openAccBackData.getCustomerAccountOpenInfoEntity().getClientName()) ?
                        openAccBackData.getCustomerAccountOpenInfoEntity().getClientName() : openAccBackData.getCustomerAccountOpenInfoEntity().getClientNameSpell());

                if (null != openAccBackData.getCustomerAccountOpenApplyEntity().getErrorContentTypes() && openAccBackData.getCustomerAccountOpenApplyEntity().getErrorContentTypes().contains("17")) {
                    if (null == openAccBackData.getCustomerAccountOpenApplyEntity().getOtherReasons() || "".equals(openAccBackData.getCustomerAccountOpenApplyEntity().getOtherReasons())) {
                        paramList.add("具体原因请拨打客服电话咨询：香港(852) 2379 8888或国内400-636-0620");
                    } else {
                        paramList.add("需要修改的资料是" + openAccBackData.getCustomerAccountOpenApplyEntity().getOtherReasons() + "，请打开小神有财APP进行修改。如有疑问，请拨打客服电话咨询：香港(852) 2379 8888或国内400-636-0620");
                    }

                } else {
                    paramList.add("待修改的信息是：" + reason + "，请打开小神有财APP进行修改。如有疑问，请拨打客服电话咨询：香港(852) 2379 8888或国内400-636-0620");
                }

                generateSendSms(2014, openAccBackData.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
            }
        }


        //销户通知函发送
        SecuritiesUserInfoEntity query = new SecuritiesUserInfoEntity();
        query.setClientStatus(CustomerEnums.ClientStatus.CLIENT_STATUS_CLO.getIndex());
        query.setCancelDate(DateUtil.format(DateUtil.yesterday(),"yyyy-MM-dd"));
        List<SecuritiesUserInfoEntity> waitingForDealData = secUserInfoService.customerListExcelList(query);

        logger.info("销户通知函发送任务，待处理数据条数：" + waitingForDealData.size());

        for (SecuritiesUserInfoEntity entity : waitingForDealData) {
            int message = sendCancelEmailMessage(entity);
            if(message<0){
                logger.info("用户"+entity.getTradeAccount()+"-"+entity.getFundAccount()+"销户通知函发送失败！");
            }
        }

    }

    private boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("userType", 1);
            paraMap.put("sendType", 0);
            paraMap.put("phone", phoneNumber);
            paraMap.put("params", paramList);
            paraMap.put("templateCode", templateCode);

            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
            messageSendInfoEntity.setRecipients(ConfigUtils.get("message.center.sms.url"));
            messageSendInfoEntity.setMessageTitle("智珠证券开户通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("智珠证券开户通知异常", e);
        }

        return false;
    }

    /**
     * 销户通知邮件
     * */
    private int sendCancelEmailMessage(SecuritiesUserInfoEntity entity){
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(entity.getEmail());
        messageSendInfoEntity.setMessageTitle("【智珠证券】销户通知函");
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        Map<String, String> emailModel = Maps.newHashMap();
        emailModel.put("clientName",  entity.getClientName() != null && !"".equals(entity.getClientName()) ? entity.getClientName() : entity.getClientNameSpell());
        emailModel.put("clientAccount", entity.getTradeAccount());
        emailModel.put("fundAccount", entity.getFundAccount());
        emailModel.put("canceltDate", entity.getCancelDate());
        emailModel.put("currentDate", DateUtil.format(new Date(),"yyyy-MM-dd"));
        messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.ACCOUNT_CANCEL_SUCCEED_EMAIL_TEMPLATE, emailModel));
        messageSendInfoEntity.setContentType(2);

        return messageSendInfoService.save(messageSendInfoEntity);
    }
}
