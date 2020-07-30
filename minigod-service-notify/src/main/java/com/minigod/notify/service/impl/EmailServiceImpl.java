package com.minigod.notify.service.impl;


import com.minigod.common.pojo.response.ResResult;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.mail.util.ResponseData;
import com.minigod.notify.helper.NotifyService;
import com.minigod.notify.service.EmailService;
import com.minigod.persist.notify.mapper.SysFileReferMapper;
import com.minigod.persist.notify.mapper.SysMailRecordMapper;
import com.minigod.protocol.notify.model.SysFileRefer;
import com.minigod.protocol.notify.model.SysMailRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@FeignClient(value = "minigod-service-notify")
public class EmailServiceImpl extends BaseBeanFactory implements EmailService {
    @Autowired
    private NotifyService notifyService;

    private SysMailRecordMapper sysMailRecordMapper;
    private SysFileReferMapper sysFileReferMapper;

    /**
     * 发送邮件
     *
     * @param sendTo
     * @param sendFrom
     * @param subject
     * @param content
     * @param paths
     * @return
     */
    public ResResult sendMail(String sendTo, String sendFrom, String subject, String content, List<String> paths) {
        try {
            if (StringUtils.isEmpty(sendTo) || StringUtils.isEmpty(sendFrom)
                    || StringUtils.isEmpty(subject) || StringUtils.isEmpty(content)) {
                return ResResult.parameterErrorMessage();
            }

            //保存数据
            SysMailRecord sysMailRecord = new SysMailRecord();
            sysMailRecord.setSendFrom(sendFrom);
            sysMailRecord.setSendTo(sendTo);
            sysMailRecord.setSubject(subject);
            sysMailRecord.setContent(content);
            int mailId = sysMailRecordMapper.insert(sysMailRecord);
            //保存附件
            if (paths != null && paths.size() > 0) {
                for (String path : paths) {
                    SysFileRefer sysFileRefer = new SysFileRefer();
                    sysFileRefer.setReferId(mailId);
                    sysFileRefer.setFilePath(path);
                    sysFileReferMapper.insert(sysFileRefer);
                }
            }
            notifyService.setSendTo(sendTo);
            notifyService.setSendFrom(sendFrom);
            ResponseData re = notifyService.notifySendCloudMail(subject, content, paths);
            if (re != null && re.getResult()) {
                return ResResult.success();
            } else {
                ResResult resResult = new ResResult();
                resResult.setCode(re.getStatusCode());
                resResult.setMessage(re.getMessage());
                return resResult;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ResResult.errorWithMessage("发送失败");
        }

    }
}