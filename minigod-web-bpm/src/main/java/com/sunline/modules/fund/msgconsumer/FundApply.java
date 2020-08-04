package com.sunline.modules.fund.msgconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;
import com.sunline.modules.activemq.entity.ActiveMqBizCode;
import com.sunline.modules.activemq.entity.ActiveMsgEntity;
import com.sunline.modules.activemq.service.ActiveMqService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.helper.ClientFundDepositApplyHelper;
import com.sunline.modules.fund.protocol.ClientFundDepositApplyProto;
import com.sunline.modules.fund.proxy.ClientFundDepositApplyProxy;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Map;

@Component
public class FundApply {
    private static final Logger logger = LoggerFactory.getLogger(ClientFundDepositApplyProxy.class);

    @Autowired
    private ClientFundDepositApplicationService fundDepositApplicationService;
    @Autowired
    private ActiveMqService producer;

    /**
     * 客户入金申请消费
     */
    @JmsListener(destination = ActiveMqBizCode.FUND_DEPOSIT,containerFactory = "jmsQueueListener")
//    @SendTo(ActiveMqBizCode.FUND_DEPOSIT_CALLBACK)
    public void clientFundDepositApply(final TextMessage jsonStr, Session session) throws JMSException {
        logger.info("客户入金申请提交参数：" + jsonStr.getText());
        GenericSunlineRequest<ClientFundDepositApplyProto> request =
                (GenericSunlineRequest<ClientFundDepositApplyProto>) JSON.parseObject(jsonStr.getText(),new TypeReference<GenericSunlineRequest<ClientFundDepositApplyProto>>(){});

        ResponseVO responseVO = new ResponseVO();
        ClientFundDepositApplyProto depositFundInfo = request.getParams();
        Map<String, Object> resultMap = Maps.newHashMap();
        resultMap.put("appId",depositFundInfo.getAppId());

        ResponseVO baseDataValidateResult = ClientFundDepositApplyHelper.validateClientFundDepositInfo(depositFundInfo);
        if (CrmCommonEnum.CodeType.ERROR.getCode() == baseDataValidateResult.getCode()) {
            responseVO =  baseDataValidateResult;
        }
        ClientFundDepositApplicationEntity funDepositEntity = ClientFundDepositApplyHelper.protocolToEntity(depositFundInfo);
        String applicationId = fundDepositApplicationService.commitFundDepositApply(funDepositEntity,depositFundInfo.getDepositImage());
//        String applicationId = "";
        if(StringUtils.isNotEmpty(applicationId)){
            logger.info("已成功接收用户"+funDepositEntity.getClientId()+"的入金申请，流水号："+applicationId);
            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
            resultMap.put("applicationId", applicationId);
            jsonStr.acknowledge();
        }else {
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
           // 如果不调用session.recover()消息只会在重启服务后重发
            session.recover();
        }
        responseVO.setResult(resultMap);

        ActiveMsgEntity msgEntity = new ActiveMsgEntity();
        msgEntity.setPublishType(1);
        msgEntity.setMsgType(2);
        msgEntity.setBizCode(ActiveMqBizCode.FUND_DEPOSIT_CALLBACK);
        msgEntity.setMessage(responseVO);
        producer.sendMessage(msgEntity);
    }
}
