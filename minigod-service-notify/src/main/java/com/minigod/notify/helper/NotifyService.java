package com.minigod.notify.helper;

import com.minigod.common.forkjoin.threadpool.impl.ThreadPoolImpl;
import com.minigod.common.utils.FileUtils;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.common.utils.URIUtil;
import com.minigod.mail.builder.SendCloudBuilder;
import com.minigod.mail.config.Config;
import com.minigod.mail.core.SendCloud;
import com.minigod.mail.model.MailAddressReceiver;
import com.minigod.mail.model.MailBody;
import com.minigod.mail.model.SendCloudMail;
import com.minigod.mail.model.TextContent;
import com.minigod.mail.util.ResponseData;
import com.minigod.protocol.notify.enums.CaptchaSmsTypeEnum;
import com.minigod.protocol.notify.request.params.EmailFileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商城通知服务类
 */
public class NotifyService {
    private static Logger logger = LoggerFactory.getLogger(NotifyService.class);

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
     * @param emailFileInfos   附件路径
     * @throws Throwable
     */
    public ResponseData notifySendCloudMail(String subject, String content, List<EmailFileInfo> emailFileInfos) throws Throwable {
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
        //创建目录
        String localPath =  Config.file_path+System.currentTimeMillis()+"/";
        File fileDir = new File(localPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        for (EmailFileInfo emailFileInfo : emailFileInfos) {
            body.addAttachments(getFileByUrl(localPath,emailFileInfo.getPath(), emailFileInfo.getFileName(), emailFileInfo.getSuffix()));
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

    private File getFileByUrl(String localPath,String fileUrl, String fileName, String suffix) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        BufferedOutputStream stream = null;
        InputStream inputStream = null;
        File file = null;
        try {
            String url1 = URLEncoder.encode(fileUrl, "utf-8").replaceAll("\\+", "%20");
            String url2 = url1.replaceAll("%3A", ":").replaceAll("%2F", "/")
                    .replaceAll("%3F","?").replaceAll("%3D","=");
            URL uFile = new URL(url2);
            HttpURLConnection conn = (HttpURLConnection) uFile.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inputStream = conn.getInputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }

            file = new File(localPath+fileName+"." + suffix);
            if (!file.exists()) {
                file.createNewFile();
            }

            logger.info("临时文件创建成功={}", file.getCanonicalPath());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            stream = new BufferedOutputStream(fileOutputStream);
            stream.write(outStream.toByteArray());

        } catch (Exception e) {
            logger.error("读取文件异常", e);
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (stream != null) stream.close();
                outStream.close();
            } catch (Exception e) {
                logger.error("关闭流异常", e);
            }
        }
        return file;
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
