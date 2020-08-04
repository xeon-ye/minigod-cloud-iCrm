package com.sunline.modules.common.utils;

import com.google.common.collect.Lists;
import com.sunline.modules.sys.entity.NoticeEntity;
import com.sunline.modules.sys.entity.NoticeUserEntity;
import com.sunline.modules.sys.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class NoticeUtil {
    private final static Logger logger = LoggerFactory.getLogger(NoticeUtil.class);

    @Autowired
    private NoticeService sendNoticeService;
    private static NoticeService noticeService;

    @PostConstruct
    public void init() {
        noticeService = sendNoticeService;
    }


    /**
     * 批量发送通知
     */
    public static int sendNotice(NoticeEntity noticeParam, List<String> userIds) {
        int count = 0;
        try {
            List<NoticeEntity> noticeList = Lists.newArrayList();
            List<NoticeUserEntity> noticeUserList = Lists.newArrayList();
            for (String userId : userIds) {
                NoticeEntity notice = new NoticeEntity();
                NoticeUserEntity noticeUser = new NoticeUserEntity();
                String uuid = Utils.uuid();
                notice.setId(uuid);
                notice.setSoucre(noticeParam.getSoucre());
                notice.setStatus(noticeParam.getStatus());
                notice.setCreateId(noticeParam.getCreateId());
                notice.setUpdateId(noticeParam.getCreateId());
                notice.setContext(noticeParam.getContext());
                notice.setTitle(noticeParam.getTitle());
                notice.setIsUrgent(noticeParam.getIsUrgent());
                notice.setRemark(noticeParam.getRemark());
                noticeList.add(notice);
                noticeUser.setNoticeId(uuid);
                noticeUser.setUserId(userId);
                noticeUser.setRemark(noticeParam.getRemark());
                noticeUserList.add(noticeUser);
            }
            count = noticeService.saveBatch(noticeList);
            count += noticeService.saveBatchUserNotice(noticeUserList);
        } catch (Exception e) {
            logger.error("发送通知失败", e);
        }
        return count;
    }
}
