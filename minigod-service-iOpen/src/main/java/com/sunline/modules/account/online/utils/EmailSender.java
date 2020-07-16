package com.sunline.modules.account.online.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sendcloud.sdk.builder.SendCloudBuilder;
import com.sendcloud.sdk.core.SendCloud;
import com.sendcloud.sdk.model.*;
import com.sendcloud.sdk.util.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @description: SendCloud邮件发送工具类
 * @author: Larry Lai
 * @date: 2018/10/23 11:33
 * @version: v1.0
 */
public class EmailSender {
    private static final Logger logger = LoggerFactory.getLogger(EmailSender.class);

    /**
     * 发送HTML邮件
     *
     * @param acceptEmail
     * @param title
     * @param content
     * @param attachments
     * @return
     */
    public static boolean sendEmailHtml(String acceptEmail, String title, String content, List<File> attachments) {
        ResponseData res;
        MailAddressReceiver receiver = new MailAddressReceiver();
        receiver.addTo(acceptEmail);

        MailBody body = new MailBody();
        body.setFrom("service@zszhizhu.com");
        body.setFromName("智珠证券");
        body.setReplyTo("service@zszhizhu.com");
        body.setSubject(title);

        for (File attachment : attachments) {
            if (attachment.exists()) {
                body.addAttachments(attachment);
            }
        }

        TextContent textContent = new TextContent();
        textContent.setContent_type(TextContent.ScContentType.html);
        textContent.setText(content);

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(textContent);

        SendCloud sc = SendCloudBuilder.build();
        try {
            res = sc.sendMail(mail);

            if (res.getStatusCode() != 200) {
                logger.error("发送邮件错误：" + res);
            }
        } catch (Throwable e) {
            logger.error("邮件发送异常", e);
            return false;
        }

        return 200 == res.getStatusCode();
    }

    /**
     * 发送文本文件邮件
     *
     * @param acceptEmail
     * @param title
     * @param content
     * @param attachments
     * @return
     */
    public static boolean sendEmailText(String acceptEmail, String title, String content, List<File> attachments) {
        ResponseData res;
        MailAddressReceiver receiver = new MailAddressReceiver();
        receiver.addTo(acceptEmail);

        MailBody body = new MailBody();
        body.setFrom("service@zszhizhu.com");
        body.setFromName("智珠证券");
        body.setReplyTo("service@zszhizhu.com");
        body.setSubject(title);

        for (File attachment : attachments) {
            if (attachment.exists()) {
                body.addAttachments(attachment);
            }
        }

        TextContent textContent = new TextContent();
        textContent.setContent_type(TextContent.ScContentType.plain);
        textContent.setText(content);

        SendCloudMail mail = new SendCloudMail();
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(textContent);

        SendCloud sc = SendCloudBuilder.build();
        try {
            res = sc.sendMail(mail);

            if (res.getStatusCode() != 200) {
                logger.error("发送邮件错误：" + res);
            }
        } catch (Throwable e) {
            logger.error("邮件发送异常", e);
            return false;
        }

        return 200 == res.getStatusCode();
    }

    /**
     * 发送模板邮件
     *
     * @param acceptEmail
     * @param title
     * @param content
     * @param attachments
     * @return
     */
    public static boolean sendEmailTemplate(String acceptEmail, String title, String content, List<File> attachments) {

        MailBody body = new MailBody();
        // 设置 From
        body.setFrom("service@zszhizhu.com");
        // 设置 FromName
        body.setFromName("智珠证券");
        // 设置 ReplyTo
        body.setReplyTo("service@zszhizhu.com");
        // 设置标题
        body.setSubject(title);

        List<String> toList = Lists.newArrayList();
        toList.add(acceptEmail);
        List<String> contentList = Lists.newArrayList();
        contentList.add(content);

        Map<String, List<String>> sub = Maps.newHashMap();
        sub.put("%content%", contentList);

        for (File attachment : attachments) {
            if (attachment.exists()) {
                body.addAttachments(attachment);
            }
        }

        // 此时, receiver 中添加的 to, cc, bcc 均会失效
        body.addXsmtpapi("to", toList);
        body.addXsmtpapi("sub", sub);
//        body.addHeader("SC-Custom-test_key1", "test1");
//        body.addHeader("NO-SC-Custom-test_key1", "test2");

        // 使用邮件模板
        TemplateContent templateContent = new TemplateContent();
        templateContent.setTemplateInvokeName("sunline_email");

        SendCloudMail mail = new SendCloudMail();
        // 模板发送时，必须使用 Xsmtpapi 来指明收件人; mail.setTo();
        mail.setBody(body);
        mail.setContent(templateContent);

        ResponseData res;

        SendCloud sc = SendCloudBuilder.build();

        try {
            res = sc.sendMail(mail);

            if (res.getStatusCode() != 200) {
                logger.error("发送邮件错误：" + res);
            }

        } catch (Throwable e) {
            logger.error("邮件发送异常", e);
            return false;
        }

        return 200 == res.getStatusCode();
    }

}
