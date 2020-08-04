package com.sunline.modules.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.sunline.modules.commission.entity.ClientFareSetupEntity;
import com.sunline.modules.commission.entity.ClientFareSetupLogEntity;
import com.sunline.modules.commission.service.ClientFareSetupLogService;
import com.sunline.modules.commission.service.ClientFareSetupService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.hundsun.protocol.request.ClientTradeFareRequest;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.common.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @description: 客户设佣套餐同步恒生柜台调度任务
 * @author: Larry Lai
 * @date: 2018/8/23 17:38
 * @version: v1.0
 */

@Component("singleClientFareSyncHsJob")
public class SingleClientFareSyncHsJob {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientFareSetupService clientFareSetupService;
    @Autowired
    private ClientFareSetupLogService clientFareSetupLogService;

    /**
     * 客户设佣套餐同步恒生柜台
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
        logger.info(params + "任务开始");

        try {
            // 获取客户设佣信息
            ClientFareSetupEntity clientFareSetupParams = new ClientFareSetupEntity();
            clientFareSetupParams.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
            clientFareSetupParams.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_UNTREATED.getIndex());
            clientFareSetupParams.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_SEHK.getIndex());

            // 港股
            List<ClientFareSetupEntity> clientFareSetupEntityHkList = clientFareSetupService.getClientFareSetupInfo(clientFareSetupParams);
            setupClientFare(clientFareSetupEntityHkList, CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_SEHK.getIndex());

            // 美股
            clientFareSetupParams.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_US.getIndex());
            List<ClientFareSetupEntity> clientFareSetupEntityUsList = clientFareSetupService.getClientFareSetupInfo(clientFareSetupParams);
            setupClientFare(clientFareSetupEntityUsList, CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_US.getIndex());

        } catch (Exception e) {
            logger.error("客户设佣套餐同步恒生柜台异常", e);
        }
    }

    /**
     * 调用交易接口对接恒生柜台设置客户佣金套餐
     *
     * @param clientFareSetupEntityList
     * @param exchangeType
     */
    public void setupClientFare(List<ClientFareSetupEntity> clientFareSetupEntityList, String exchangeType) {
        try {
            List<ClientTradeFareRequest> clientTradeFareProtoList = Lists.newArrayList();
            List<Integer> clientFareSetupIdList = Lists.newArrayList();

            // 同步客户设佣套餐
            clientTradeFareProtoList.clear();
            clientFareSetupIdList.clear();

            for (ClientFareSetupEntity clientFareSetupEntity : clientFareSetupEntityList) {

                ClientTradeFareRequest clientTradeFareProto = new ClientTradeFareRequest();

                clientFareSetupIdList.add(clientFareSetupEntity.getId());

                clientTradeFareProto.setUserType("3");
                clientTradeFareProto.setClientId(clientFareSetupEntity.getClientId());
                clientTradeFareProto.setFundAccount(clientFareSetupEntity.getFundAccount());
                clientTradeFareProto.setFareKindStr(clientFareSetupEntity.getFareKind());

                clientTradeFareProtoList.add(clientTradeFareProto);
            }

            if (clientTradeFareProtoList.size() > 0) {

                // 更新同步状态为正在同步
                updateSyncStatus(clientFareSetupIdList, exchangeType, CrmCommonEnum.SyncStatus.SYNC_STATUS_PROCESSING.getIndex());

                // 调用交易接口对接恒生柜台设置客户佣金套餐
                ResponseVO addClientFareReq = HsRestManageService.setupTradeFare(clientTradeFareProtoList);

                // 处理同步结果
                if (addClientFareReq != null && addClientFareReq.getCode() == CrmCommonEnum.CodeType.OK.getCode() && !StringUtils.isEmpty(addClientFareReq.getResult())) {
                    JSONArray addSucClientList = JSON.parseArray(JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("successFundAccount").toString());

                    List<Integer> clientFareSetupSucIdList = Lists.newArrayList();
                    List<String> fundAccountList = Lists.newArrayList();
                    List<String> busIdList = Lists.newArrayList();

                    if (addSucClientList.size() > 0) {

                        clientFareSetupSucIdList.clear();
                        fundAccountList.clear();
                        busIdList.clear();

                        for (int i = 0; i < addSucClientList.size(); i++) {

                            for (ClientFareSetupEntity clientFareSetupEntity : clientFareSetupEntityList) {

                                if (String.valueOf(addSucClientList.get(i)).equals(clientFareSetupEntity.getFundAccount())) {
                                    clientFareSetupSucIdList.add(clientFareSetupEntity.getId());
                                    fundAccountList.add(addSucClientList.get(i).toString());
                                    busIdList.add(clientFareSetupEntity.getBusId());
                                }
                            }
                        }

                        // 更新同步状态为同步成功
                        updateSyncStatus(clientFareSetupSucIdList, exchangeType, CrmCommonEnum.SyncStatus.SYNC_STATUS_COMPLETE.getIndex());
                        // 更新日志表同步状态为同步成功
                        updateSyncStatusLog(busIdList, exchangeType, CrmCommonEnum.SyncStatus.SYNC_STATUS_COMPLETE.getIndex());

                        logger.info("设置" + fundAccountList.toString() + "客户[" + clientFareSetupEntityList.get(0).getFareKind() + "]套餐成功");

                    }

                    JSONArray addFailedClientList = JSON.parseArray(JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("failedFundAccount").toString());

                    if (addFailedClientList.size() > 0) {

                        clientFareSetupSucIdList.clear();
                        fundAccountList.clear();
                        busIdList.clear();

                        for (int i = 0; i < addFailedClientList.size(); i++) {

                            for (ClientFareSetupEntity clientFareSetupEntity : clientFareSetupEntityList) {

                                if (String.valueOf(addFailedClientList.get(i)).equals(clientFareSetupEntity.getFundAccount())) {
                                    clientFareSetupSucIdList.add(clientFareSetupEntity.getId());
                                    fundAccountList.add(addSucClientList.get(i).toString());
                                    busIdList.add(clientFareSetupEntity.getBusId());
                                }
                            }
                        }

                        // 更新同步状态为同步失败
                        updateSyncStatus(clientFareSetupSucIdList, CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_SEHK.getIndex(), CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());
                        // 更新日志表同步状态为同步失败
                        updateSyncStatusLog(busIdList, exchangeType, CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());

                        logger.info("设置" + fundAccountList.toString() + "客户[" + clientFareSetupEntityList.get(0).getFareKind() + "]套餐失败，错误原因：" + JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("failedMsg").toString());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("调用交易接口对接恒生柜台设置客户佣金套餐异常", e);
        }
    }

    /**
     * 更新同步状态
     *
     * @param clientFareSetupIdList
     * @param syncStatus
     * @param exchangeType
     * @return
     */

    public boolean updateSyncStatus(List<Integer> clientFareSetupIdList, String exchangeType, Integer syncStatus) {

        boolean returnValue = false;

        try {

            for (Integer clientFareSetupId : clientFareSetupIdList) {

                ClientFareSetupEntity clientFareSetupEntity = new ClientFareSetupEntity();
                clientFareSetupEntity.setId(clientFareSetupId);
                clientFareSetupEntity.setExchangeType(exchangeType);
                clientFareSetupEntity.setSyncStatus(syncStatus);
                clientFareSetupEntity.setSyncTime(new Date());

                returnValue = clientFareSetupService.update(clientFareSetupEntity) > 0;
            }

        } catch (Exception e) {
            logger.error("更新同步状态异常", e);
        }

        return returnValue;
    }


    /**
     * 更新日志表同步状态
     *
     * @param busIdList
     * @param exchangeType
     * @param syncStatus
     * @return
     */
    public boolean updateSyncStatusLog(List<String> busIdList, String exchangeType, Integer syncStatus) {
        boolean returnValue = false;

        try {

            for (String busId : busIdList) {

                ClientFareSetupLogEntity clientFareSetupLogEntity = new ClientFareSetupLogEntity();
                clientFareSetupLogEntity.setBusId(busId);
                clientFareSetupLogEntity.setSyncStatus(syncStatus);
                clientFareSetupLogEntity.setSyncTime(new Date());

                returnValue = clientFareSetupLogService.updateByBusId(clientFareSetupLogEntity) > 0;
            }

        } catch (Exception e) {
            logger.error("更新日志表同步状态异常", e);
        }

        return returnValue;
    }

}
