package com.sunline.modules.quartz.task;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.protocol.OpenAccResultCallbackProto;
import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.activemq.entity.ActiveMqBizCode;
import com.sunline.modules.activemq.entity.ActiveMsgEntity;
import com.sunline.modules.activemq.protocol.UserInfoExt;
import com.sunline.modules.activemq.service.impl.ActiveMqServiceImpl;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.ProtocolUtils;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.List;

/**
 * @author LiYangFeng
 * @createDate 2018/3/29
 * @description 开户结果回调
 * @email justbelyf@gmail.com
 */
@Component("customerAccOpenRetCallback")
public class CustomerAccOpenRetCallback {

    private final Logger logger = LoggerFactory.getLogger(CustomerAccOpenRetCallback.class);
    @Autowired
    CustomerAccOpenApplyService customerAccountOpenApplyService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    CustomerAccOpenReportGenerate customerAccOpenReportGenerate;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    CustomerAccOpenService customerAccOpenService;
    @Autowired
    private ActiveMqServiceImpl activeMqService;

    /**
     * 开户结果回调
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");

        CustomerAccountOpenApplyEntity queryCondition = new CustomerAccountOpenApplyEntity();
        queryCondition.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        List<CustomerAccountOpenApplyEntity> customerAccountOpenApplyEntities = customerAccountOpenApplyService.queryListByBean(queryCondition);
        for (CustomerAccountOpenApplyEntity customerAccOpenApplyEntity : customerAccountOpenApplyEntities) {

            CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(customerAccOpenApplyEntity.getApplicationId());

            OpenAccResultCallbackProto proto = new OpenAccResultCallbackProto();
            proto.setOpenAccountAccessWay(customerAccountOpenInfo.getOpenAccountAccessWay());

            // 开户成功
            if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE == customerAccOpenApplyEntity.getApplicationStatus()
                    || BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                proto.setOpenStatus(0);
                proto.setClientId(customerAccountOpenInfo.getClientId());
                proto.setOpenDate(DateUtil.formatDateTime(customerAccountOpenInfo.getOpenAccountTime()));
            }

            // 开户退回
            if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RETURN_BACK_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {

                if (null != customerAccOpenApplyEntity.getErrorImages() && null == customerAccOpenApplyEntity.getErrorContentTypes()) {
                    proto.setOpenStatus(4);
                    proto.setErrorImages(JSON.parseArray(customerAccOpenApplyEntity.getErrorImages(), OpenAccountImageInfo.class));
                } else {
                    proto.setOpenStatus(3);
                    proto.setErrorInfo(customerAccOpenApplyEntity.getErrorContentTypes());
                }
            }

            // 开户终止
            if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_TERMINATION_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                proto.setOpenStatus(8);
            }

            // 开户拒绝
            if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_REJECT_VALUE == customerAccOpenApplyEntity.getApplicationStatus()
                    || BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_REJECT_BLACKLIST_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                proto.setOpenStatus(7);
            }

            // 开户终审通过
            if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_PROGRESS_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                proto.setOpenStatus(9);
                proto.setOpenAccountFileUrl(ConfigUtils.get("cubp.extranet.file.url") + ConfigUtils.get("openAccount.user.report.userForm").substring(ConfigUtils.get("openAccount.user.report.userForm").indexOf(":") + 1, ConfigUtils.get("openAccount.user.report.userForm").length()) + customerAccOpenApplyEntity.getApplicationId()
                        + "/" + URLEncoder.encode(ConfigUtils.get("ca.open.account.file.url"), "utf-8") + ".pdf");
            }

            proto.setUserId(customerAccountOpenInfo.getUserId());
            proto.setPhoneNumber(customerAccountOpenInfo.getPhoneNumber());

            logger.info("开户申请结果回调内容：" + JSON.toJSONString(proto));
            String response = HttpClientUtils.postJson(ConfigUtils.get("openAccount.callback.online.url"), JSON.toJSONString(proto), true);
            logger.info("开户结果回调下游接收结果：" + response);

            if (BpmCommonEnum.CodeType.OK.getCode() == JSON.parseObject(response).getIntValue("code")) {
                customerAccOpenApplyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                int isSucceed = customerAccountOpenApplyService.update(customerAccOpenApplyEntity);

                AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo = customerAccOpenService.findByApplicationId(customerAccOpenApplyEntity.getApplicationId());

                List<String> paramList = Lists.newArrayList();

                // 生成开户成功短信/邮件通知
                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE == customerAccOpenApplyEntity.getApplicationStatus()
                        || BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                    // 发送邮件通知
                    customerAccOpenService.sendAccountOpenEmail(accountOpenApplicationDetailInfo);

                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName()) ?
                            accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() : accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientNameSpell());
                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientId());
                    paramList.add(ProtocolUtils.getDecryptPhone(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getInitialAccountPassword()));

                    generateOpenAccRetSendSms(1105, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);

                    // 开户成功推送到用户中心扩展
                    if (0 == proto.getOpenStatus()) {
                        UserInfoExt userInfoExt = new UserInfoExt();
                        userInfoExt.setUserId(customerAccountOpenInfo.getUserId());
                        userInfoExt.setTradeAccount(customerAccountOpenInfo.getClientId());
                        userInfoExt.setFundAccount(customerAccountOpenInfo.getFundAccount());
                        userInfoExt.setFundAccountType(customerAccountOpenInfo.getFundAccountType());
                        userInfoExt.setPhoneNumber(customerAccountOpenInfo.getPhoneNumber());
                        userInfoExt.setEmail(customerAccountOpenInfo.getEmail());
                        userInfoExt.setClientStatus("0");
                        userInfoExt.setOpenAccountStatus(1);
                        userInfoExt.setIdType(customerAccountOpenInfo.getIdKind());
                        userInfoExt.setIdNo(customerAccountOpenInfo.getIdNo());
                        userInfoExt.setOptType(1);

                        GenericSunlineRequest<UserInfoExt> request = new GenericSunlineRequest<>();
                        request.setParams(userInfoExt);

                        ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
                        msg.setBizCode(ActiveMqBizCode.USER_INFO_EXT);
                        msg.setPublishType(1);
                        msg.setMsgType(2);
                        msg.setMessage(JSON.toJSONString(request));

                        activeMqService.sendMessage(msg);
                    }
                }

                // 生成退回短信通知
                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RETURN_BACK_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {

                    paramList.clear();

                    List<String> errorContentTypes = JSON.parseArray(accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getErrorContentTypes(), String.class);

                    StringBuilder errorMsg = new StringBuilder();
                    String reason = "";

                    if (null != errorContentTypes) {
                        for (String type : errorContentTypes) {
                            errorMsg.append(CodeUtils.getCodeName("AO_CONTENT_ERROR_TYPE", type)).append("，");
                        }
                    }

                    List<OpenAccountImageInfo> errorImageTypes = JSON.parseArray(accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getErrorImages(), OpenAccountImageInfo.class);

                    if (null != errorImageTypes) {
                        for (OpenAccountImageInfo imageInfo : errorImageTypes) {
                            errorMsg.append(CodeUtils.getCodeName("AO_IMAGE_ERROR_TYPE", String.valueOf(imageInfo.getImageLocationType()))).append("不符").append("，");
                        }
                    }

                    reason = errorMsg.length() > 0 ? errorMsg.substring(0, errorMsg.length() - 1) : "";


                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName()) ?
                            accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() : accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientNameSpell());

                    if (null != accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getErrorContentTypes() && accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getErrorContentTypes().contains("17")) {
                        if (null == accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getOtherReasons() || "".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getOtherReasons())) {
                            paramList.add("具体原因请拨打客服电话咨询：香港（852）2523-8221或国内400-688-3187");
                        } else {
                            paramList.add("需要修改的资料是" + accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getOtherReasons() + "，请打开小神有财APP进行修改。如有疑问，请拨打客服电话咨询：香港（852）2523-8221或国内400-688-3187");
                        }

                    } else {
                        paramList.add("待修改的信息是：" + reason + "，请打开小神有财APP进行修改。如有疑问，请拨打客服电话咨询：香港（852）2523-8221或国内400-688-3187");
                    }

                    generateOpenAccRetSendSms(1003, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
                }

                // 生成拒绝短信通知
                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_REJECT_VALUE == customerAccOpenApplyEntity.getApplicationStatus()
                        || BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_REJECT_BLACKLIST_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {

                    paramList.clear();
                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName()) ?
                            accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() : accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientNameSpell());

                    generateOpenAccRetSendSms(1094, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
                }

                // 生成终止短信通知
                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_TERMINATION_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                    paramList.clear();
                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName()) ?
                            accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() : accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientNameSpell());

                    generateOpenAccRetSendSms(1095, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
                }

                // 生成终审通过短信通知
                if (BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_PROGRESS_VALUE == customerAccOpenApplyEntity.getApplicationStatus()) {
                    paramList.clear();
                    paramList.add(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() != null && !"".equals(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName()) ?
                            accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientName() : accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getClientNameSpell());

                    generateOpenAccRetSendSms(1104, accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getPhoneNumber(), paramList);
                }

                logger.info("开户结果回调下游最终处理结果：" + isSucceed);
            }
        }
    }

    /**
     * 生成短信发送数据
     *
     * @param phoneNumber
     * @param paramList
     * @param templateCode
     * @return
     */
    private boolean generateOpenAccRetSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {

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
            messageSendInfoEntity.setMessageTitle("智珠证券账户开户申请");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);

            // 开户文件
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("开户短信发送异常", e);
        }

        return false;
    }
}
