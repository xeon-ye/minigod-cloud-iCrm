package com.minigod.task.service.jobhandler.account;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.persist.account.mapper.*;
import com.minigod.protocol.account.cubp.callback.CubpOpenInfoCallbackVo;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountBankVerityInfoReqVo;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.model.*;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 客户开户成功下发
 */
@JobHandler(value = "noticeSuccessOpenInfoJobHandler")
@Component
@Slf4j
public class NoticeSuccessOpenInfoJobHandler extends IJobHandler {
    @Autowired
    CustomInfoMapper customInfoMapper;
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;

    @Value("${minigod.proxy.isSyncOpen}")
    private Boolean PROXY_SYNC_IS_OPEN;
    @Value("${minigod.proxy.syncHost}")
    private String PROXY_SYNC_HOST;
    @Value("${minigod.proxy.syncData}")
    private String PROXY_SYNC_DATA_API;

    private static final String split = " | ";


    private void saveErrorInfo(CustomOpenInfo customOpenInfo, String errorMsg, String body) {
        customOpenInfo.setUpdateTime(new Date());
        // 更新开户调度任务失败次数
        if (customOpenInfo.getNoticeErrCount() < 3) {
            customOpenInfo.setNoticeErrCount(customOpenInfo.getNoticeErrCount() + 1);
        } else {
            // 发送邮件
            if (!customOpenInfo.getIsSend()) {
                // 避免重复发送邮件，已发送邮件的不再发送
//                String title = "用户账号：" + customOpenInfo.getId() + " 开户任务异常";
//                errorMsg = errorMsg + "【" + body + "】";
                // TODO: 发送邮件通知
//                msgService.sendEmailCloud(sender, accept, title, errorMsg, null);
                customOpenInfo.setIsSend(true);
            }
        }
        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        log.info("执行【客户开户成功下发】调度任务");

        if (!PROXY_SYNC_IS_OPEN) {
            log.info("*********************【客户开户成功下发】未启用**************************");
            return FAIL;
        }
        //查询开户信息
        List<CustomOpenInfo> openInfoList = customOpenInfoMapper.selectByStatusAndIsNoticedFalse(CustomOpenAccountEnum.OpenStatus.SUCCESS.getCode());
        if (null == openInfoList || openInfoList.size() <= 0) {
            log.info("*********************【客户开户成功下发】为空**************************");
            return FAIL;
        }

        for (CustomOpenInfo customOpenInfo : openInfoList) {

            Integer userId = customOpenInfo.getUserId();

            Integer openStatus = customOpenInfo.getStatus();

            // 非开户成功的跳出循环
            if (openStatus == null || !openStatus.equals(CustomOpenAccountEnum.OpenStatus.SUCCESS.getCode())) {
                log.error("【客户开户成功下发】用户未完成开户，userId = " + userId);
                continue;
            }

            CustomInfo customInfo = customInfoMapper.selectByPrimaryKey(userId);

            if (customInfo == null || customInfo.getThirdCode() == null || customInfo.getThirdCode() <= 0) {
                log.error("【客户开户成功下发】用户不存在，userId = " + userId);
                continue;
            }

            // 同步错误次数过多
            if (customOpenInfo.getNoticeErrCount()!= null && customOpenInfo.getNoticeErrCount() >= 3) {
                log.error("*********************【客户开户成功下发】开户下发异常超过3次**************************");
                continue;
            }

            CubpOpenInfoCallbackVo openInfoCallbackVo = new CubpOpenInfoCallbackVo();

            openInfoCallbackVo.setUserId(customInfo.getThirdCode());
            openInfoCallbackVo.setOpenStatus(0);
            openInfoCallbackVo.setClientId(customOpenInfo.getTradeAccount());
            openInfoCallbackVo.setOpenDate(DateUtils.formatDate(customOpenInfo.getOpenDate()));
            openInfoCallbackVo.setOpenAccountAccessWay(1);

            try {
                log.info("*********************【客户开户成功下发】回调开始**************************, userId = {}", userId);
                log.info(userId + "【客户开户成功下发】回调传入数据：" + JSONObject.toJSONString(openInfoCallbackVo));
                // 调用cubp开户接口
                String server = PROXY_SYNC_HOST + PROXY_SYNC_DATA_API;
                String result = HttpClientUtils.postJson(server, JSONObject.toJSONString(openInfoCallbackVo), Charset.forName("UTF-8"), true);
                log.info(userId + "【客户开户成功下发】返回结果：" + result);
                log.info("*********************【客户开户成功下发】回调结束**************************, userId = {}", userId);

                if (StringUtils.isNotBlank(result)) {
                    ResResult responseVO = JSONObject.parseObject(result, ResResult.class);
                    if (responseVO.getCode() == 0) {
                        customOpenInfo.setIsNoticed(true);
                        customOpenInfo.setUpdateTime(new Date());
                        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
                        log.info("【客户开户成功下发】上传成功：" + userId);
                    } else {
                        log.info("【客户开户成功下发】上传失败：" + userId + "," + responseVO.getMessage());
                        saveErrorInfo(customOpenInfo, responseVO.getMessage(), result);
                    }

                } else {
                    // 异常，记录操作日志
                    log.error("【客户开户成功下发】连接服务器异常，返回结果为NULL！");
                    saveErrorInfo(customOpenInfo, "【客户开户成功下发】连接服务器异常，返回结果为NULL！", "");
                }
            } catch (Exception e) {
                log.error("*********************【客户开户成功下发】异常**************************,", e);
                saveErrorInfo(customOpenInfo, "【客户开户成功下发】异常！", "服务器异常");
                // 异常，记录操作日志
            }
            log.info("*********************结束用户【客户开户成功下发】**************************, userId = {}", userId);
        }
        log.info("完成【客户开户成功下发】调度任务");

        return SUCCESS;

    }
}
