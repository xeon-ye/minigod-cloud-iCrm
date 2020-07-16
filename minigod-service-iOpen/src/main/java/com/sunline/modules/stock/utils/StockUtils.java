package com.sunline.modules.stock.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.NoticeUtil;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.VelocityUtil;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.entity.NoticeCaseEntity;
import com.sunline.modules.notice.entity.UserNoticeEntity;
import com.sunline.modules.notice.enums.NoticeEnums;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.notice.service.NoticeCaseService;
import com.sunline.modules.notice.service.UserNoticeService;
import com.sunline.modules.stock.entity.StockOrderInfoEntity;
import com.sunline.modules.sys.entity.NoticeEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 赠股 工具类utils
 *
 * @author lcs
 * @date 2018-12-14 10:19:20
 */
@Component
public class StockUtils {

    private static NoticeCaseService noticeCaseService;
    private static UserNoticeService userNoticeService;
    private static UserServiceImpl userService;
    private static MessageSendInfoService messageSendInfoService;
    private static SecUserInfoService secUserInfoService;

    @Autowired
    public void init(NoticeCaseService noticeService, UserNoticeService userNoticeSer, UserServiceImpl userSer, MessageSendInfoService messageSendService, SecUserInfoService secUserService) {
        StockUtils.noticeCaseService = noticeService;
        StockUtils.userNoticeService = userNoticeSer;
        StockUtils.userService = userSer;
        StockUtils.messageSendInfoService = messageSendService;
        StockUtils.secUserInfoService = secUserService;
    }

    /**
     * 发送站内通知
     */
    public static void sendStockNotice(NoticeEntity params, String noticeCaseCode) {
        //发送cubp站内通知 《start》
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setSoucre(NoticeEnums.NoticeSource.SOURCE_SYS.getIndex());
        noticeEntity.setIsUrgent(NoticeEnums.NoticeUrgent.URGENT_YES.getIndex());
        noticeEntity.setStatus(NoticeEnums.NoticeStatus.STATUS_PLC.getIndex());
        noticeEntity.setCreateId(Constant.SUPERR_USER);
        noticeEntity.setUpdateId(Constant.SUPERR_USER);

        noticeEntity.setTitle(params.getTitle());
        noticeEntity.setContext(params.getContext());

        List<String> userList = Lists.newArrayList();
        NoticeCaseEntity noticeCase = noticeCaseService.queryByCode(noticeCaseCode);

        UserNoticeEntity userNotice = new UserNoticeEntity();
        userNotice.setNoticeCaseId(noticeCase.getNoticeCaseId());
        List<UserNoticeEntity> userNoticeList = userNoticeService.queryListByBean(userNotice);

        for (UserNoticeEntity entity : userNoticeList) {
            userList.add(entity.getUserId());
        }

        NoticeUtil.sendNotice(noticeEntity, userList);
        //发送cubp站内通知 《end》
    }

    /**
     * 发送邮件
     */
    public static void sendStockEmail(StockOrderInfoEntity stockOrderInfo, String noticeCaseCode, String templateName) {
        StringBuffer emails = new StringBuffer();
        NoticeCaseEntity noticeCase = noticeCaseService.queryByCode(noticeCaseCode);
        UserNoticeEntity userNotice = new UserNoticeEntity();
        userNotice.setNoticeCaseId(noticeCase.getNoticeCaseId());
        List<UserNoticeEntity> userNoticeList = userNoticeService.queryListByBean(userNotice);

        for (UserNoticeEntity entity : userNoticeList) {
            UserEntity user = userService.queryObject(entity.getUserId());
            emails.append(user.getEmail()).append(";");
        }

        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(emails.toString());
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        Map<String, String> emailModel = Maps.newHashMap();
        if (VelocityUtil.STOCK_ORDER_EMAIL_TEMPLATE.equals(templateName)) {
            messageSendInfoEntity.setMessageTitle("股票下单通知");
            emailModel.put("stockCode", stockOrderInfo.getStockCode());
            emailModel.put("stockName", stockOrderInfo.getStockName());
            emailModel.put("stockDirection", CodeUtils.getCodeName("STOCK_DIRECTION", String.valueOf(stockOrderInfo.getStockDirection())));
            if ("".equals(stockOrderInfo.getStockQuantity()) || null == stockOrderInfo.getStockQuantity()) {
                emailModel.put("stockQuantity", "未知");
            } else {
                emailModel.put("stockQuantity", stockOrderInfo.getStockQuantity());
            }
            if ("".equals(stockOrderInfo.getMinPrice()) || null == stockOrderInfo.getMinPrice()) {
                emailModel.put("minPrice", "不限");
            } else {
                emailModel.put("minPrice", stockOrderInfo.getMinPrice().toString());
            }
            if ("".equals(stockOrderInfo.getMaxPrice()) || null == stockOrderInfo.getMaxPrice()) {
                emailModel.put("maxPrice", "未知");
            } else {
                emailModel.put("maxPrice", stockOrderInfo.getMaxPrice().toString());
            }
            emailModel.put("expiryDate", stockOrderInfo.getExpiryDate());

            //获取自营账户信息
            SecuritiesUserInfoEntity userInfoEntity = new SecuritiesUserInfoEntity();
            userInfoEntity.setFundAccount(SysConfigUtil.getSysConfigValue("DONATED_STK_FUND_ACCOUNT", null));
            SecuritiesUserInfoEntity securitiesUserInfo = secUserInfoService.queryObject(userInfoEntity);
            emailModel.put("accountNo", String.valueOf(securitiesUserInfo.getTradeAccount()));
            emailModel.put("accountName", securitiesUserInfo.getClientName());

            messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.STOCK_ORDER_EMAIL_TEMPLATE, emailModel));
            messageSendInfoEntity.setContentType(1);
        } else if (VelocityUtil.POSITION_INSUFFICIENT_90.equals(templateName)) {
            messageSendInfoEntity.setMessageTitle("[" + stockOrderInfo.getStockName() + "]持仓不足10%通知");
            emailModel.put("stockName", stockOrderInfo.getStockName());
            if ("".equals(stockOrderInfo.getStockQuantity()) || null == stockOrderInfo.getStockQuantity()) {
                emailModel.put("stockQuantity", "未知");
            } else {
                emailModel.put("stockQuantity", stockOrderInfo.getStockQuantity());
            }
            emailModel.put("positionAmount", stockOrderInfo.getPositionAmount().toString());
            messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.POSITION_INSUFFICIENT_90, emailModel));
            messageSendInfoEntity.setContentType(1);
        } else if (VelocityUtil.POSITION_INSUFFICIENT_80.equals(templateName)) {
            messageSendInfoEntity.setMessageTitle("[" + stockOrderInfo.getStockName() + "]持仓不足20%通知");
            emailModel.put("stockName", stockOrderInfo.getStockName());
            if ("".equals(stockOrderInfo.getStockQuantity()) || null == stockOrderInfo.getStockQuantity()) {
                emailModel.put("stockQuantity", "未知");
            } else {
                emailModel.put("stockQuantity", stockOrderInfo.getStockQuantity());
            }
            emailModel.put("positionAmount", stockOrderInfo.getPositionAmount().toString());
            messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.POSITION_INSUFFICIENT_80, emailModel));
            messageSendInfoEntity.setContentType(1);
        }
        messageSendInfoService.save(messageSendInfoEntity);
    }
}
