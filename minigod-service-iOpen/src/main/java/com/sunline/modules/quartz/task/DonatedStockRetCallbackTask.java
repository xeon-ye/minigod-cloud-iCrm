package com.sunline.modules.quartz.task;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.protocol.DonatedStockResultCallbackProto;
import com.sunline.modules.stock.protocol.DonatedStockSendMsgAppProto;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuyy
 * @createDate 2018/12/11
 * @description 赠股领取回调
 * @email
 */
@Component("donatedStockRetCallbackTask")
public class DonatedStockRetCallbackTask {

    private final Logger logger = LoggerFactory.getLogger(DonatedStockRetCallbackTask.class);

    @Autowired
    DonatedStockApplicationInfoService donatedStockService;


    /**
     * 赠股领取回调
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");

        DonatedStockApplicationInfoEntity queryCondition = new DonatedStockApplicationInfoEntity();
        queryCondition.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);

        List<DonatedStockApplicationInfoEntity> donatedStockApplicationInfoEntityList = donatedStockService.queryListByBean(queryCondition);
        for (DonatedStockApplicationInfoEntity applyEntity : donatedStockApplicationInfoEntityList) {

            DonatedStockResultCallbackProto proto = new DonatedStockResultCallbackProto();
            proto.setApplicationId(applyEntity.getApplicationId());

            // 入账成功
            if (2 == applyEntity.getAccountEntryStatus()) {
                proto.setHandselStatus(1);
            }

            // 审核被拒绝
            if (BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_APPROVAL_REJECT_VALUE == applyEntity.getApplicationStatus()) {
                proto.setHandselStatus(2);
            }

            JSONObject paraMap = new JSONObject();
            paraMap.put("params", proto);

            if (1 != applyEntity.getAccountEntryStatus() && 3 != applyEntity.getAccountEntryStatus()) {

                logger.info("赠股领取审核结果回调内容：" + JSON.toJSONString(paraMap));

                String response = HttpClientUtils.postJson(ConfigUtils.get("donatedStock.result.callback.url"), JSON.toJSONString(paraMap));

                logger.info("赠股领取审核回调下游接收结果：" + response);

                if (BpmCommonEnum.CodeType.OK.getCode() == JSON.parseObject(response).getIntValue("code")) {
                    applyEntity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
                    int isSucceed = donatedStockService.update(applyEntity);

                    List<String> paramList = Lists.newArrayList();

                    // 生成赠股入帐通知
                    if (BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_PASS_VALUE == applyEntity.getApplicationStatus()) {

                        // 发送邮件通知
                        donatedStockService.sendDonatedStockEmail(applyEntity);

                        paramList.clear();
                        paramList.add(applyEntity.getClientName() != null ? applyEntity.getClientName() : applyEntity.getClientNameSpell());
                        paramList.add(applyEntity.getStockName());
                        paramList.add(applyEntity.getStockQuantity().toString());

                        // 发送短信
                        donatedStockService.generateDonatedStockRetSendSms(1099, applyEntity.getPhoneNumber(), paramList);
                    }

                    // 已拒绝
                    if (BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_APPROVAL_REJECT_VALUE == applyEntity.getApplicationStatus()) {

                        paramList.clear();
                        paramList.add(applyEntity.getClientName() != null ? applyEntity.getClientName() : applyEntity.getClientNameSpell());

                        // 发送短信
                        donatedStockService.generateDonatedStockRetSendSms(1100, applyEntity.getPhoneNumber(), paramList);

                        // 推送app消息
                        sendPushMsg(applyEntity.getUserId(), applyEntity.getClientName() != null ? applyEntity.getClientName() : applyEntity.getClientNameSpell());

                        //发送发送邮件通知
                        donatedStockService.sendDonatedStockRefuseEmail(applyEntity);

                    }

                    logger.info("赠股领取审核回调下游最终处理结果：" + isSucceed);
                }
            }
        }
    }

    /**
     * 入账拒绝推送app消息
     */
    public void sendPushMsg(Integer userId, String clientName) {
        try {
            DonatedStockSendMsgAppProto msgAppProto = new DonatedStockSendMsgAppProto();
            List<Object> lstToUserIdList = new ArrayList<>();
            lstToUserIdList.add(userId);

            List<Object> clientNameList = new ArrayList<>();
            clientNameList.add(clientName);

            msgAppProto.setTemplateCode(1102);
            msgAppProto.setDisplayGroup(12007);
            msgAppProto.setMsgCode(1902);
            msgAppProto.setLstToUserId(lstToUserIdList);
            msgAppProto.setParams(clientNameList);

            String response = HttpClientUtils.postJson(ConfigUtils.get("donatedStock.sendPushMsg.url"), JSON.toJSONString(msgAppProto));

            ResponseVO responseVO = JSON.parseObject(response, ResponseVO.class);
            if (BpmCommonEnum.CodeType.OK.getCode() != responseVO.getCode()) {
                logger.error("入账拒绝推送app消息失败：" + responseVO.getMessage());
            }

        } catch (Exception e) {
            logger.error("入账拒绝推送app消息异常：", e);
        }
    }


}
