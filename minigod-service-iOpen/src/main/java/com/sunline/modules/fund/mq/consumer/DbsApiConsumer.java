package com.sunline.modules.fund.mq.consumer;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.sunline.modules.activemq.entity.ActiveMqBizCode;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.DateConverUtil;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.dbs.protocol.DbsReqPackag;
import com.sunline.modules.dbs.service.DbsAREBusinessService;
import com.sunline.modules.fund.dao.DepositBankBillFlowDao;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import com.sunline.modules.fund.helper.DbsApiHelper;
import com.sunline.modules.fund.protocol.DbsApiProtocol;
import com.sunline.modules.fund.service.DbsIccBankFlowService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: DBS API服务
 * @author: Larry Lai
 * @date: 2020/3/2 15:17
 * @version: v1.0
 */

@Service
public class DbsApiConsumer {

    private static final Logger logger = LoggerFactory.getLogger(DbsApiConsumer.class);

    @Autowired
    private DbsIccBankFlowService dbsIccBankFlowService;
    @Autowired
    private DepositBankBillFlowDao depositBankBillFlowDao;
    @Autowired
    private DbsAREBusinessService dbsAREBusinessService;

    /**
     * 接收星展银行流水推送
     *
     * @param text
     */
    @JmsListener(destination = ActiveMqBizCode.CUBP_DBS_ICC_MSG_QUEUE)
    public void icc(String text) {

        logger.info("DBS API ICC push data：" + text);

        DbsApiProtocol protocol = JSON.parseObject(text, DbsApiProtocol.class);

        // 保存DBS银行流水原始数据
        DbsIccBankFlowEntity dbsIccBankFlowEntity = DbsApiHelper.protocolToEntity(protocol);
        dbsIccBankFlowEntity.setIsCheck(0);
        dbsIccBankFlowEntity.setIsApply(0);
        dbsIccBankFlowEntity.setCreateTime(new Date());
        dbsIccBankFlowEntity.setUpdateTime(new Date());

        dbsIccBankFlowService.save(dbsIccBankFlowEntity);

        // 同步写入到银行流水表
        DepositBankBillFlowEntity queryCondition = new DepositBankBillFlowEntity();
        queryCondition.setMsgId(dbsIccBankFlowEntity.getMsgId());
        List<DepositBankBillFlowEntity> depositBankBillFlowEntityList = depositBankBillFlowDao.queryListByBean(queryCondition);

        if (null == depositBankBillFlowEntityList || depositBankBillFlowEntityList.isEmpty()) {
            DepositBankBillFlowEntity depositBankBillFlowEntity = new DepositBankBillFlowEntity();
            depositBankBillFlowEntity.setReferenceNo(dbsIccBankFlowEntity.getTxnRefId());
            depositBankBillFlowEntity.setValueDate(dbsIccBankFlowEntity.getValueDt());
            //depositBankBillFlowEntity.setCreditAmount(dbsIccBankFlowEntity.getTxnAmt());
            depositBankBillFlowEntity.setActualMoney(dbsIccBankFlowEntity.getTxnAmt());
            depositBankBillFlowEntity.setBankName("1");
            depositBankBillFlowEntity.setSubAccname(dbsIccBankFlowEntity.getReceiveAccName());

            if (StringUtils.isNotBlank(dbsIccBankFlowEntity.getReceiveVirtualAccNo())) {
                depositBankBillFlowEntity.setSubAccno(dbsIccBankFlowEntity.getReceiveVirtualAccNo());
            }else{
                depositBankBillFlowEntity.setSubAccno(dbsIccBankFlowEntity.getReceiveAccNo());
            }

//            depositBankBillFlowEntity.setSubAccno(dbsIccBankFlowEntity.getReceiveAccNo());
            depositBankBillFlowEntity.setCurrency(CrmCommonEnum.SecMoneyTypeEn.getName(dbsIccBankFlowEntity.getTxnCcy()));

            depositBankBillFlowEntity.setMsgId(dbsIccBankFlowEntity.getMsgId());
            depositBankBillFlowEntity.setCustomerReference(dbsIccBankFlowEntity.getCustomerReference());
            depositBankBillFlowEntity.setTimeStamp(dbsIccBankFlowEntity.getTimeStamp());
            depositBankBillFlowEntity.setTxnType(dbsIccBankFlowEntity.getTxnType());
            depositBankBillFlowEntity.setSenderAccName(dbsIccBankFlowEntity.getSenderAccName().trim());
            depositBankBillFlowEntity.setSenderAccNo(dbsIccBankFlowEntity.getSenderAccNo());
            depositBankBillFlowEntity.setSenderBankId(dbsIccBankFlowEntity.getSenderBankId());
            depositBankBillFlowEntity.setFlowSource(1);
            depositBankBillFlowEntity.setCheckStatus(0);
            depositBankBillFlowEntity.setRepeat(0);
            depositBankBillFlowEntity.setCreateUser(UserUtils.getBackgroundWorkflowUser().getId());
            depositBankBillFlowEntity.setCreateTime(new Date());

            depositBankBillFlowDao.save(depositBankBillFlowEntity);
            dbsAREBusinessService.sendICCARE(dbsIccBankFlowEntity, UserUtils.getBackgroundWorkflowUser().getId());
        }

        logger.info("DBS API Msg ID[" + dbsIccBankFlowEntity.getMsgId() + "] data be put in storage");
    }

}
