package com.sunline.modules.notice.service;

import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @description: 消息发送中心
 * @author: Larry Lai
 * @date: 2018/9/29 15:17
 * @version: v1.0
 */

public interface MessageSendInfoService {

    MessageSendInfoEntity queryObject(Integer id);

    List<MessageSendInfoEntity> queryList(Map<String, Object> map);

    List<MessageSendInfoEntity> queryListByBean(MessageSendInfoEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(MessageSendInfoEntity messageSendInfo);

    int update(MessageSendInfoEntity messageSendInfo);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    List<MessageSendInfoEntity> queryUnFinishedMessage();

    int updateMessageNoticeResult(Integer id, BpmCommonEnum.CommonProcessStatus messageSendResult);

    boolean sendMessage(MessageSendInfoEntity messageSendInfo);

    /**
     * 生成短信发送信息（对接sunline）
     *
     * @param templateCode
     * @param phoneNumber
     * @param paramList
     * @param title
     * @return
     */
    boolean generateSunlineSendSms(Integer templateCode, String phoneNumber, List<String> paramList, String title);

    /**
     * 生成邮件(Text)发送信息
     *
     * @param title
     * @param content
     * @param contentType
     * @param acceptEmail
     * @param attachmentUris
     */
    void generateSendEmailText(String title, String content, Integer contentType, String acceptEmail, List<String> attachmentUris);
}
