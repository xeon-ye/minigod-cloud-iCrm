package com.minigod.notify.helper;

import com.minigod.mail.builder.SendCloudBuilder;
import com.minigod.mail.core.SendCloud;
import com.minigod.mail.model.MailAddressReceiver;
import com.minigod.mail.model.MailBody;
import com.minigod.mail.model.SendCloudMail;
import com.minigod.mail.model.TextContent;
import com.minigod.mail.util.ResponseData;
import com.minigod.protocol.notify.enums.CaptchaSmsTypeEnum;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商城通知服务类
 */
public class NotifyService {
    private MailSender mailSender;
    private String sendFrom;
    private String sendTo;

    private SmsSender smsSender;
    private List<Map<String, String>> smsTemplate = new ArrayList<>();
    private Integer smsExpiresTime = 0;
    private Integer smsIntervalTime = 0;
    private Integer emailExpiresTime = 0;
    private String defaultNationCode = "86";

    public boolean isMailEnable() {
        return mailSender != null;
    }

    public boolean isSmsEnable() {
        return smsSender != null;
    }

    /**
     * 短信消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param message     短消息内容，这里短消息内容必须已经在短信平台审核通过
     */
    @Async
    public void notifySms(String phoneNumber, String message) {
        if (smsSender == null)
            return;

        if (phoneNumber.indexOf("-") != -1) {
            String nationCode = phoneNumber.substring(0, phoneNumber.lastIndexOf("-"));
            String phone = phoneNumber.substring(phoneNumber.lastIndexOf("-") + 1);
            smsSender.send(nationCode, phone, message);
        } else {
            smsSender.send(defaultNationCode, phoneNumber, message);
        }
    }

    /**
     * 短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    @Async
    public void notifySmsTemplate(String phoneNumber, CaptchaSmsTypeEnum notifyType, String[] params) {
        if (smsSender == null) {
            return;
        }

        String templateIdStr = getTemplateId(notifyType, smsTemplate);
        if (templateIdStr == null) {
            return;
        }

        int templateId = Integer.parseInt(templateIdStr);
        if (phoneNumber.indexOf("-") != -1) {
            String nationCode = phoneNumber.substring(0, phoneNumber.lastIndexOf("-"));
            String phone = phoneNumber.substring(phoneNumber.lastIndexOf("-") + 1);
            smsSender.sendWithTemplate(nationCode, phone, templateId, params);
        } else {
            smsSender.sendWithTemplate(defaultNationCode, phoneNumber, templateId, params);
        }
    }

    /**
     * 以同步的方式发送短信模版消息通知
     *
     * @param phoneNumber 接收通知的电话号码
     * @param notifyType  通知类别，通过该枚举值在配置文件中获取相应的模版ID
     * @param params      通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     * @return
     */
    public SmsResult notifySmsTemplateSync(String phoneNumber, CaptchaSmsTypeEnum notifyType, String[] params) {
        if (smsSender == null)
            return null;

        int templateId = Integer.parseInt(getTemplateId(notifyType, smsTemplate));
        if (phoneNumber.indexOf("-") != -1) {
            String nationCode = phoneNumber.substring(0, phoneNumber.lastIndexOf("-"));
            String phone = phoneNumber.substring(phoneNumber.lastIndexOf("-") + 1);
            return smsSender.sendWithTemplate(nationCode, phone, templateId, params);
        } else {
            return smsSender.sendWithTemplate(defaultNationCode, phoneNumber, templateId, params);
        }
    }

    /**
     * 邮件消息通知,
     * 接收者在spring.mail.sendto中指定
     *
     * @param subject 邮件标题
     * @param content 邮件内容
     */
    @Async
    public void notifyMail(String subject, String content) {
        if (mailSender == null)
            return;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendFrom);
        message.setTo(sendTo);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }

    /**
     * 邮件消息通知
     *
     * @param subject 主题
     * @param content 内容
     * @param paths   附件路径
     * @throws Throwable
     */
    public ResponseData notifySendCloudMail(String subject, String content, List<String> paths) throws Throwable {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendFrom);
        message.setTo(sendTo);
        message.setSubject(subject);
        message.setText(content);

        SendCloudMail mail = new SendCloudMail();
        MailAddressReceiver receiver = new MailAddressReceiver();
        receiver.addTo(sendTo);
        MailBody body = new MailBody();
        body.setFrom(sendFrom);
        body.setSubject(subject);
        //附件
        for (String path : paths) {
            body.addAttachments(new File(path));
        }
        TextContent textContent = new TextContent();
        textContent.setContent_type(TextContent.ScContentType.html);
        textContent.setText(content);
        mail.setTo(receiver);
        mail.setBody(body);
        mail.setContent(textContent);

        SendCloud sc = SendCloudBuilder.build();
        return sc.sendMail(mail);
    }

    private String getTemplateId(CaptchaSmsTypeEnum notifyType, List<Map<String, String>> values) {
        for (Map<String, String> item : values) {
            String notifyTypeStr = notifyType.getType();

            if (item.get("name").equals(notifyTypeStr))
                return item.get("templateId");
        }
        return null;
    }

    public Integer getSmsExpiresTime() {
        return smsExpiresTime;
    }

    public void setSmsExpiresTime(Integer smsExpiresTime) {
        this.smsExpiresTime = smsExpiresTime;
    }

    public Integer getEmailExpiresTime() {
        return emailExpiresTime;
    }

    public void setEmailExpiresTime(Integer emailExpiresTime) {
        this.emailExpiresTime = emailExpiresTime;
    }

    public Integer getSmsIntervalTime() {
        return smsIntervalTime;
    }

    public void setSmsIntervalTime(Integer smsIntervalTime) {
        this.smsIntervalTime = smsIntervalTime;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void setSmsTemplate(List<Map<String, String>> smsTemplate) {
        this.smsTemplate = smsTemplate;
    }
}
