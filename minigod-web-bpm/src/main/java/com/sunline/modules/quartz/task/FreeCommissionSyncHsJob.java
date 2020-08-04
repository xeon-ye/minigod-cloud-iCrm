package com.sunline.modules.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sunline.modules.commission.entity.ClientFreeCommInfoEntity;
import com.sunline.modules.commission.entity.ClientFreeCommSetEntity;
import com.sunline.modules.commission.service.ClientFreeCommInfoService;
import com.sunline.modules.commission.service.ClientFreeCommSetService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsRestManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description: 客户免佣套餐同步恒生柜台调度任务
 * @author: Larry Lai
 * @date: 2018/8/21 15:18
 * @version: v1.0
 */

@Component("freeCommissionSyncHsJob")
public class FreeCommissionSyncHsJob {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");

    /**
     * 交易委托方式集合
     */
    private final String[] ENTRUST_WAY_ARR = {"7", "I", "K", "N", "Q", "S", "T", "W"};

    @Autowired
    private ClientFreeCommSetService clientFreeCommSetService;

    @Autowired
    private ClientFreeCommInfoService clientFreeCommInfoService;

    /**
     * 客户免佣套餐同步恒生柜台
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
        logger.info(params + "任务开始");

        try {
            // 获取符合免佣设置的客户列表
            ClientFreeCommSetEntity clientFreeCommSetParams = new ClientFreeCommSetEntity();

            List<ClientFreeCommSetEntity> isFreeCommClientInfoList = clientFreeCommSetService.getIsFreeCommClientInfo(clientFreeCommSetParams);

            for (ClientFreeCommSetEntity isFreeCommClientInfo : isFreeCommClientInfoList) {

                GenericHsRequest<ClientFareManageRequest> clientFareInfoProtoRequest = new GenericHsRequest<>();

                // 更新同步状态为正在同步
                updateSyncStatus(isFreeCommClientInfo.getId(), CrmCommonEnum.SyncStatus.SYNC_STATUS_PROCESSING.getIndex());

                // 把客户原套餐置为无效
                if (setupOldFareInvalid(isFreeCommClientInfo)) {

                    // 调交易接口对接恒生柜台设置客户免佣套餐
                    ClientFareManageRequest fillFreeCommEntity = fillFreeCommData(isFreeCommClientInfo);
                    clientFareInfoProtoRequest.setParams(fillFreeCommEntity);
                    ResponseVO addClientFareReq = HsRestManageService.addClientFareInfo(clientFareInfoProtoRequest);

                    if (addClientFareReq != null && addClientFareReq.getCode() == CrmCommonEnum.CodeType.OK.getCode() && !StringUtils.isEmpty(addClientFareReq.getResult())) {
                        JSONArray addResult = JSON.parseArray(JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("failedEntrustWay").toString());

                        if (addResult.isEmpty()) {
                            // 更新同步状态为同步完成
                            updateSyncStatus(isFreeCommClientInfo.getId(), CrmCommonEnum.SyncStatus.SYNC_STATUS_COMPLETE.getIndex());

                            for (int i = 0; i < ENTRUST_WAY_ARR.length; i++) {

                                // 记录客户免佣套餐信息
                                ClientFreeCommInfoEntity clientFreeCommInfoEntity = new ClientFreeCommInfoEntity();
                                clientFreeCommInfoEntity.setClientId(fillFreeCommEntity.getClientId());
                                clientFreeCommInfoEntity.setFundAccount(fillFreeCommEntity.getFundAccount());
                                clientFreeCommInfoEntity.setFareDict(fillFreeCommEntity.getFareDict());
                                clientFreeCommInfoEntity.setFeeType(fillFreeCommEntity.getFeeType());
                                clientFreeCommInfoEntity.setFeeCount(BigDecimal.valueOf(Integer.parseInt(fillFreeCommEntity.getFeeCount())));
                                clientFreeCommInfoEntity.setFareType(fillFreeCommEntity.getFareType());
                                clientFreeCommInfoEntity.setExchangeType(fillFreeCommEntity.getExchangeType());
                                clientFreeCommInfoEntity.setStockCode("!");
                                clientFreeCommInfoEntity.setStockType("!");
                                clientFreeCommInfoEntity.setEntrustBs("!");
                                clientFreeCommInfoEntity.setEntrustWay(ENTRUST_WAY_ARR[i]);
                                clientFreeCommInfoEntity.setMoneyType("!");
                                clientFreeCommInfoEntity.setMinFare(BigDecimal.valueOf(Integer.parseInt(fillFreeCommEntity.getMinFare())));
                                clientFreeCommInfoEntity.setMaxFare(BigDecimal.valueOf(Integer.parseInt(fillFreeCommEntity.getMaxFare())));
                                clientFreeCommInfoEntity.setPrecisions(fillFreeCommEntity.getPrecision());
                                clientFreeCommInfoEntity.setPrecisionFlag(fillFreeCommEntity.getPrecisionFlag());
                                clientFreeCommInfoEntity.setFeeCountFix(BigDecimal.valueOf(Integer.parseInt(fillFreeCommEntity.getFeeCountFix())));
                                clientFreeCommInfoEntity.setFareStr(fillFreeCommEntity.getFareStr());
                                clientFreeCommInfoEntity.setBeginDate(DATE_FORMAT.parse(fillFreeCommEntity.getBeginDate()));
                                clientFreeCommInfoEntity.setEndDate(DATE_FORMAT.parse(fillFreeCommEntity.getEndDate()));
                                clientFreeCommInfoEntity.setFreeCommStatus(1);
                                clientFreeCommInfoEntity.setCreateTime(new Date());
                                clientFreeCommInfoEntity.setUpdateTime(new Date());

                                clientFreeCommInfoService.save(clientFreeCommInfoEntity);
                            }

                            logger.info("新增[" + isFreeCommClientInfo.getClientId() + "]客户免佣套餐成功");
                        } else {
                            // 更新同步状态为同步失败
                            updateSyncStatus(isFreeCommClientInfo.getId(), CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());
                            logger.info("新增[" + isFreeCommClientInfo.getClientId() + "]客户免佣套餐错误，错误原因：" + JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("failedMsg").toString() + "");
                        }
                    }
                } else {
                    // 更新同步状态为同步失败
                    updateSyncStatus(isFreeCommClientInfo.getId(), CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());
                    logger.info("[" + isFreeCommClientInfo.getClientId() + "]客户原套餐置为无效状态出现异常");
                }
            }
        } catch (Exception e) {
            logger.error("客户免佣套餐同步恒生柜台异常", e);
        }
    }

    /**
     * 客户免佣套餐参数封装
     *
     * @param clientFreeCommSetEntity
     * @return
     */
    public ClientFareManageRequest fillFreeCommData(ClientFreeCommSetEntity clientFreeCommSetEntity) {

        ResponseVO responseVO = HsRestManageService.getSysArg(new GenericHsRequest<>());
        SysArgResponse sysArgResponse = null;

        if (null != responseVO && CrmCommonEnum.CodeType.OK.getCode() == responseVO.getCode()) {
            sysArgResponse = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), SysArgResponse.class);
        }

        ClientFareManageRequest freeCommEntity = new ClientFareManageRequest();

        freeCommEntity.setClientId(clientFreeCommSetEntity.getClientId());
        freeCommEntity.setFundAccount(clientFreeCommSetEntity.getFundAccount());
        freeCommEntity.setExchangeType(clientFreeCommSetEntity.getExchangeType());

        if (sysArgResponse != null && Integer.valueOf(DATE_FORMAT.format(clientFreeCommSetEntity.getBeginDate())) < Integer.valueOf(sysArgResponse.getInitDate())) {
            freeCommEntity.setBeginDate(sysArgResponse.getInitDate());
        } else {
            freeCommEntity.setBeginDate(DATE_FORMAT.format(clientFreeCommSetEntity.getBeginDate()));
        }

        freeCommEntity.setEndDate(DATE_FORMAT.format(clientFreeCommSetEntity.getEndDate()));

        freeCommEntity.setFareDict("1");
        freeCommEntity.setFeeType("0");
        freeCommEntity.setFeeCount("0");
        freeCommEntity.setFareType("0");
        freeCommEntity.setFareStr("FREE COMMISSION");
        freeCommEntity.setBatchEntrustWay(ENTRUST_WAY_ARR);
        freeCommEntity.setMinFare("0");
        freeCommEntity.setMaxFare("0");
        freeCommEntity.setPrecisionFlag("0");
        freeCommEntity.setPrecision("2");
        freeCommEntity.setFeeCountFix("0");

        return freeCommEntity;
    }

    /**
     * 把客户原套餐置为无效
     *
     * @param clientFreeCommSetEntity
     * @return
     */
    public boolean setupOldFareInvalid(ClientFreeCommSetEntity clientFreeCommSetEntity) {

        GenericHsRequest<ClientFareManageRequest> clientFareInfoProtoRequest = new GenericHsRequest<>();

        try {
            // 获取客户原有佣金套餐信息
            ClientFareManageRequest clientFareEntity = new ClientFareManageRequest();
            clientFareEntity.setClientId(clientFreeCommSetEntity.getClientId());
            clientFareEntity.setFundAccount(clientFreeCommSetEntity.getFundAccount());
            clientFareEntity.setBeginDate(DATE_FORMAT.format(new Date()));
            // 默认传20991231
            clientFareEntity.setEndDate("20991231");

            clientFareInfoProtoRequest.setParams(clientFareEntity);
            ResponseVO getClientFareReq = HsRestManageService.qryClientFareInfo(clientFareInfoProtoRequest);

            if (getClientFareReq != null && getClientFareReq.getCode() == CrmCommonEnum.CodeType.OK.getCode() && !StringUtils.isEmpty(getClientFareReq.getResult())) {
                JSONArray clientFareInfoArr = JSONArray.parseArray(JSON.toJSONString(getClientFareReq.getResult()));

                // 把客户原套餐置为无效
                if (clientFareInfoArr.size() > 0) {
                    ClientFareManageRequest clientFareInfoProto = JSONObject.parseObject(clientFareInfoArr.get(0).toString(), ClientFareManageRequest.class);

                    // 套餐有效期大于当前日期才做更新
                    if (Integer.parseInt(clientFareInfoProto.getEndDate()) > Integer.parseInt(DATE_FORMAT.format(new Date()))) {

                        clientFareInfoProto.setClientId(clientFreeCommSetEntity.getClientId());
                        clientFareInfoProto.setFundAccount(clientFreeCommSetEntity.getFundAccount());
                        clientFareInfoProto.setBatchEntrustWay(ENTRUST_WAY_ARR);
                        clientFareInfoProto.setEndDate(DATE_FORMAT.format(new Date()));

                        clientFareInfoProtoRequest.setParams(clientFareInfoProto);
                        ResponseVO updateClientFareReq = HsRestManageService.updClientFareInfo(clientFareInfoProtoRequest);

                        if (updateClientFareReq != null && updateClientFareReq.getCode() == CrmCommonEnum.CodeType.OK.getCode() && !StringUtils.isEmpty(updateClientFareReq.getResult())) {
                            JSONArray updateResult = JSON.parseArray(JSON.parseObject(JSON.toJSONString(updateClientFareReq.getResult())).get("failedEntrustWay").toString());
                            return updateResult.isEmpty();
                        }
                    } else {
                        return true;
                    }
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            logger.error("把客户原套餐置为无效状态出现异常", e);
        }
        return false;
    }

    /**
     * 更新同步状态
     *
     * @param isFreeCommClientInfoId
     * @param syncStatus
     * @return
     */
    public boolean updateSyncStatus(Integer isFreeCommClientInfoId, Integer syncStatus) {

        try {

            ClientFreeCommSetEntity updClientFreeCommSetEntity = new ClientFreeCommSetEntity();
            updClientFreeCommSetEntity.setId(isFreeCommClientInfoId);
            updClientFreeCommSetEntity.setSyncStatus(syncStatus);
            updClientFreeCommSetEntity.setSyncTime(new Date());
            updClientFreeCommSetEntity.setUpdateTime(new Date());

            int count = clientFreeCommSetService.update(updClientFreeCommSetEntity);

            return count > 0;

        } catch (Exception e) {
            logger.error("更新同步状态异常", e);
        }

        return false;
    }

}
