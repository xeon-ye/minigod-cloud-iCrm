package com.sunline.modules.notice.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.model.SendEmailModel;
import com.sunline.modules.account.online.model.SendSMSModel;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.IOpenConfigUtils;
import com.sunline.modules.common.utils.JsonUtil;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.notice.dao.MessageSendInfoDao;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @description: 消息发送中心
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

@Service("messageSendInfoService")
public class MessageSendInfoServiceImpl implements MessageSendInfoService {

    private final Logger logger = LoggerFactory.getLogger(MessageSendInfoServiceImpl.class);

    @Autowired
    private MessageSendInfoDao messageSendInfoDao;

    @Override
    public MessageSendInfoEntity queryObject(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.queryObject(id);
    }

    @Override
    public List<MessageSendInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.queryList(map);
    }

    @Override
    public List<MessageSendInfoEntity> queryListByBean(MessageSendInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.queryListByBean(entity);
    }

    @Override
    public List<MessageSendInfoEntity> queryUnFinishedMessage() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.queryUnFinishedMessage();
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.queryTotal(map);
    }

    @Override
    public int save(MessageSendInfoEntity messageSendInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        messageSendInfo.setGid(Utils.uuid());
        messageSendInfo.setCreateTime(new Date());
        messageSendInfo.setUpdateTime(new Date());
        if (null == messageSendInfo.getSendResult()) {
            messageSendInfo.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_KNOW_VALUE);
        }
        return messageSendInfoDao.save(messageSendInfo);
    }

    @Override
    public int update(MessageSendInfoEntity messageSendInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.update(messageSendInfo);
    }

    @Override
    public int updateMessageNoticeResult(Integer id, BpmCommonEnum.CommonProcessStatus messageSendResult) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        MessageSendInfoEntity messageSendInfoEntity = queryObject(id);
        messageSendInfoEntity.setSendResult(messageSendResult.getNumber());
        messageSendInfoEntity.setUpdateTime(new Date());
        return messageSendInfoDao.update(messageSendInfoEntity);
    }

    @Override
    public int delete(Integer id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return messageSendInfoDao.deleteBatch(ids);
    }

    /**
     * 消息发送
     *
     * @param messageSendInfo
     * @return
     */
    @Override
    public boolean sendMessage(MessageSendInfoEntity messageSendInfo) {

        boolean isSucceed = false;
        BpmCommonEnum.MessageNoticeType messageNoticeType = BpmCommonEnum.MessageNoticeType.valueOf(messageSendInfo.getMessageType());

        if (null != messageNoticeType) {
            switch (messageNoticeType) {
                case MESSAGE_NOTICE_TYPE_UNKNOWN:
                    logger.error("未知消息发送类型");
                    break;
                case MESSAGE_NOTICE_TYPE_SMS:
                    break;
                case MESSAGE_NOTICE_TYPE_EMAIL:
                    //old
                    /*List<File> attachments = Lists.newArrayList();
                    if (!StringUtils.isBlank(messageSendInfo.getAttachmentUris())) {
                        List<String> attachmentUris = JSON.parseArray(messageSendInfo.getAttachmentUris(), String.class);
                        for (String uri : attachmentUris) {
                            File attachment = new File(uri);
                            attachments.add(attachment);
                        }
                    }*/
                    //new
                    List<String> attachmentUris = new ArrayList<>();
                    if (!StringUtils.isBlank(messageSendInfo.getAttachmentUris())) {
                        String rulPrefix = ConfigUtils.get("cubp.extranet.file.url");
                        List<String> temp = new ArrayList<>();
                        temp = JSON.parseArray(messageSendInfo.getAttachmentUris(), String.class);
                        for (String url : temp) {
                            attachmentUris.add(rulPrefix + url);
                        }
                    }

                    //old
                    /*if (0 == messageSendInfo.getContentType()) {
                        isSucceed = EmailSender.sendEmailText(messageSendInfo.getRecipients(), messageSendInfo.getMessageTitle(), messageSendInfo.getMessageContent(), attachments);
                    } else if (1 == messageSendInfo.getContentType()) {
                        isSucceed = EmailSender.sendEmailHtml(messageSendInfo.getRecipients(), messageSendInfo.getMessageTitle(), messageSendInfo.getMessageContent(), attachments);
                    } else if (2 == messageSendInfo.getContentType()) {
                        isSucceed = EmailSender.sendEmailTemplate(messageSendInfo.getRecipients(), messageSendInfo.getMessageTitle(), messageSendInfo.getMessageContent(), attachments);
                    }*/

                    // TODO: 处理发送邮件邮箱号、token等逻辑~！！！！20200803

                    //new
                    String eurl = IOpenConfigUtils.email_url;
                    Map<String, Object> sendEmailParams = new HashMap<>();
                    SendEmailModel sendEmailModel = new SendEmailModel();
                    try {
                        sendEmailModel.setContent(URLEncoder.encode(messageSendInfo.getMessageContent(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    sendEmailModel.setPaths(attachmentUris);
                    sendEmailModel.setSubject(messageSendInfo.getMessageTitle());
                    sendEmailModel.setSendTo(messageSendInfo.getRecipients());
                    sendEmailModel.setSendFrom("service@zszhizhu.com");
                    sendEmailParams.put("token", "123");
                    sendEmailParams.put("params", sendEmailModel);
                    String eResResult = HttpClientUtils.postJson(eurl, JsonUtil.getJsonByObj(sendEmailParams), true);
                    ResponseVO responseVO = JSON.parseObject(eResResult, ResponseVO.class);
                    if (responseVO.getCode() == null) {
                        isSucceed = false;
                    } else {
                        isSucceed = (responseVO.getCode() == 0);
                    }
                    break;
                case MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS:
                    String surl = IOpenConfigUtils.sms_url;
                    Map<String, Object> sendSMSParams = new HashMap<>();
                    SendSMSModel sendSMSModel = new SendSMSModel();
                    sendSMSModel.setCertType(1);
                    sendSMSModel.setCertCode(messageSendInfo.getRecipients());

                    sendSMSParams.put("token", "123");
                    sendSMSParams.put("params", sendSMSModel);

                    String sResResult = HttpClientUtils.postJson(surl, JsonUtil.getJsonByObj(sendSMSParams), true);
                    ResponseVO _responseVO = JSON.parseObject(sResResult, ResponseVO.class);
                    if (_responseVO.getCode() == null) {
                        isSucceed = false;
                    } else {
                        isSucceed = (_responseVO.getCode() == 0);
                    }
                    break;
                default:
                    logger.error("未知消息发送类型");
                    break;
            }

            updateMessageNoticeResult(messageSendInfo.getId(), isSucceed ? BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED : BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED);
        }

        return isSucceed;
    }

    /**
     * 生成短信发送信息（对接sunline）
     *
     * @param templateCode
     * @param phoneNumber
     * @param paramList
     * @param title
     * @return
     */
    @Override
    public boolean generateSunlineSendSms(Integer templateCode, String phoneNumber, List<String> paramList, String title) {

        try {

            DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

            JSONObject paraMap = new JSONObject();

            paraMap.put("userType", 1);
            paraMap.put("sendType", 0);
            paraMap.put("phone", phoneNumber);
            paraMap.put("params", paramList);
            paraMap.put("templateCode", templateCode);

            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
            messageSendInfoEntity.setRecipients(com.sunline.common.ConfigUtils.get("message.center.sms.url"));
            messageSendInfoEntity.setMessageTitle(title);
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(0);
            // 附件
            messageSendInfoEntity.setAttachmentUris("");
            messageSendInfoEntity.setCreateTime(new Date());
            messageSendInfoEntity.setUpdateTime(new Date());

            int isSucceed = messageSendInfoDao.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("开户短信发送异常", e);
        }

        return false;
    }

    /**
     * 生成邮件(Text)发送信息
     *
     * @param title
     * @param content
     * @param contentType
     * @param acceptEmail
     * @param attachmentUris
     */
    @Override
    public void generateSendEmailText(String title, String content, Integer contentType, String acceptEmail, List<String> attachmentUris) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(acceptEmail);
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(content);
        messageSendInfoEntity.setContentType(contentType);
        messageSendInfoEntity.setAttachmentUris(JSON.toJSONString(attachmentUris));
        messageSendInfoEntity.setCreateTime(new Date());
        messageSendInfoEntity.setUpdateTime(new Date());

        messageSendInfoDao.save(messageSendInfoEntity);
    }

}
