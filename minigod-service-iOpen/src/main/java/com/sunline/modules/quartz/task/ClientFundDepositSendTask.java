package com.sunline.modules.quartz.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;
import com.sunline.modules.account.online.service.OpenAccountPropertyTypeService;
import com.sunline.modules.activemq.entity.ActiveMqBizCode;
import com.sunline.modules.activemq.entity.ActiveMsgEntity;
import com.sunline.modules.activemq.protocol.UserInfoExt;
import com.sunline.modules.activemq.service.impl.ActiveMqServiceImpl;
import com.sunline.modules.analysis.dao.StockTransferInfoDao;
import com.sunline.modules.analysis.entity.ClientFundDepositEntity;
import com.sunline.modules.analysis.entity.ClientFundDepositSendLogEntity;
import com.sunline.modules.analysis.entity.StockTransferInfoEntity;
import com.sunline.modules.analysis.service.ClientFundDepositSendLogService;
import com.sunline.modules.analysis.service.ClientFundDepositService;
import com.sunline.modules.analysis.service.StockTransferInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 客户出入金信息发送
 * @author: Larry Lai
 * @date: 2018/7/10 14:21
 * @version: v1.0
 */

@Component("clientFundDepositSendTask")
public class ClientFundDepositSendTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientFundDepositService clientFundDepositService;
    @Autowired
    private ClientFundDepositSendLogService clientFundDepositSendLogService;
    @Autowired
    private StockTransferInfoService stockTransferInfoService;
    @Autowired
    private StockTransferInfoDao stockTransferInfoDao;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    OpenAccountPropertyTypeService openAccountPropertyTypeService;
    @Autowired
    private ActiveMqServiceImpl activeMqService;

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####################0.00");

    /**
     * 客户出入金信息发送
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
        logger.info(params + "任务开始");

        try {

            /**
             * 存入资金
             */
            ClientFundDepositEntity clientFundDepositDepParam = new ClientFundDepositEntity();
            clientFundDepositDepParam.setDepositType(CrmCommonEnum.SecDataDictionary.SEC_FUND_DEPOSIT_DEP.getIndex());

            List<ClientFundDepositEntity> clientFundDepositDepList = clientFundDepositService.queryClientFundDepositSend(clientFundDepositDepParam);

            List<String> userList = Lists.newArrayList();
            List<String> paramList = Lists.newArrayList();

            for (ClientFundDepositEntity clientFundDepositEntity : clientFundDepositDepList) {

                if (null != clientFundDepositEntity.getPhoneNumber() && null != clientFundDepositEntity.getEmail() && null != clientFundDepositEntity.getUserId() && null != clientFundDepositEntity.getChannelId()) {

                    // 发送邮件
                    userList.clear();
                    paramList.clear();

                    String encryptClientId = "";
                    if (clientFundDepositEntity.getClientId() != null) {
                        encryptClientId = clientFundDepositEntity.getClientId().substring(0, 2) + clientFundDepositEntity.getClientId().substring(3, 4)
                                + "**" + clientFundDepositEntity.getClientId().substring(5);
                    }

                    paramList.add(encryptClientId);
                    paramList.add(clientFundDepositEntity.getChannelId() == null ? "" : clientFundDepositEntity.getChannelId());
                    paramList.add(CrmCommonEnum.SecNetCapital.getName(clientFundDepositEntity.getNetCapital()));
                    paramList.add(DECIMAL_FORMAT.format(clientFundDepositEntity.getOccurBalance()));
                    paramList.add(CrmCommonEnum.SecMoneyType.getName(clientFundDepositEntity.getMoneyType()));
                    paramList.add(clientFundDepositEntity.getRemark() == null ? "" : clientFundDepositEntity.getRemark());
                    paramList.add(clientFundDepositEntity.getInitDate() == null ? "" : clientFundDepositEntity.getInitDate());
                    paramList.add(clientFundDepositEntity.getUserId() == null ? "" : String.valueOf(clientFundDepositEntity.getUserId()));

                    String clientName = "";

                    if (null != clientFundDepositEntity.getClientName() && !"".equals(clientFundDepositEntity.getClientName())) {
                        clientName = clientFundDepositEntity.getClientName();
                    }

                    if ("".equals(clientName) && null != clientFundDepositEntity.getClientNameSpell()) {
                        clientName = clientFundDepositEntity.getClientNameSpell();
                    }

                    paramList.add(clientName);

                    ResponseVO sendEmailRet = clientFundDepositSendEmail("1057", paramList, null, clientFundDepositEntity.getEmail(), clientFundDepositEntity.getPhoneNumber());

//                // 发送短信
//                userList.clear();
//                paramList.clear();
//
//                paramList.add(clientFundDepositEntity.getClientName());
//                paramList.add(String.valueOf(DECIMAL_FORMAT.format(clientFundDepositEntity.getOccurBalance())));
//                paramList.add(clientFundDepositEntity.getInitDate());
//                userList.add(String.valueOf(clientFundDepositEntity.getUserId()));
//
//                ResponseVO sendSmsRet = clientFundDepositSendSms("1058", userList, paramList);

                    // 记录日志
                    if (sendEmailRet != null && CrmCommonEnum.CodeType.OK.getCode() == sendEmailRet.getCode()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(clientFundDepositEntity.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(0);
                        clientFundDepositSendLogEntity.setIsFirst(0);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + clientFundDepositEntity.getClientId() + "]客户的入金信息已发送到SNS短信/邮件通道");
                        }
                    }
                }
            }

            /**
             * 取出资金
             */
            ClientFundDepositEntity clientFundDepositWitParam = new ClientFundDepositEntity();
            clientFundDepositWitParam.setDepositType(CrmCommonEnum.SecDataDictionary.SEC_FUND_DEPOSIT_WIT.getIndex());

            List<ClientFundDepositEntity> clientFundDepositWitList = clientFundDepositService.queryClientFundDepositSend(clientFundDepositWitParam);

            for (ClientFundDepositEntity clientFundDepositEntity : clientFundDepositWitList) {

                if (null != clientFundDepositEntity.getPhoneNumber() && null != clientFundDepositEntity.getEmail() && null != clientFundDepositEntity.getUserId() && null != clientFundDepositEntity.getChannelId()) {

                    // 发送邮件
                    userList.clear();
                    paramList.clear();

                    String encryptClientId = "";
                    if (clientFundDepositEntity.getClientId() != null) {
                        encryptClientId = clientFundDepositEntity.getClientId().substring(0, 2) + clientFundDepositEntity.getClientId().substring(3, 4)
                                + "**" + clientFundDepositEntity.getClientId().substring(5);
                    }

                    paramList.add(encryptClientId);
                    paramList.add(clientFundDepositEntity.getChannelId() == null ? "" : clientFundDepositEntity.getChannelId());
                    paramList.add(CrmCommonEnum.SecNetCapital.getName(clientFundDepositEntity.getNetCapital()));
                    paramList.add(DECIMAL_FORMAT.format(clientFundDepositEntity.getOccurBalance()));
                    paramList.add(CrmCommonEnum.SecMoneyType.getName(clientFundDepositEntity.getMoneyType()));
                    paramList.add(clientFundDepositEntity.getRemark() == null ? "" : clientFundDepositEntity.getRemark());
                    paramList.add(clientFundDepositEntity.getInitDate() == null ? "" : clientFundDepositEntity.getInitDate());
                    paramList.add(clientFundDepositEntity.getUserId() == null ? "" : String.valueOf(clientFundDepositEntity.getUserId()));

                    String clientName = "";

                    if (null != clientFundDepositEntity.getClientName() && !"".equals(clientFundDepositEntity.getClientName())) {
                        clientName = clientFundDepositEntity.getClientName();
                    }

                    if ("".equals(clientName) && null != clientFundDepositEntity.getClientNameSpell()) {
                        clientName = clientFundDepositEntity.getClientNameSpell();
                    }

                    paramList.add(clientName);

                    ResponseVO sendEmailRet = clientFundDepositSendEmail("1056", paramList, null, clientFundDepositEntity.getEmail(), clientFundDepositEntity.getPhoneNumber());

                    // 发送短信
//                userList.clear();
//                paramList.clear();
//
//                paramList.add(clientFundDepositEntity.getClientName());
//                paramList.add(String.valueOf(DECIMAL_FORMAT.format(clientFundDepositEntity.getOccurBalance())));
//                paramList.add(clientFundDepositEntity.getInitDate());
//                userList.add(String.valueOf(clientFundDepositEntity.getUserId()));
//
//                ResponseVO sendSmsRet = clientFundDepositSendSms("1059", userList, paramList);

                    // 记录日志
                    if (sendEmailRet != null && CrmCommonEnum.CodeType.OK.getCode() == sendEmailRet.getCode()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(clientFundDepositEntity.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(0);
                        clientFundDepositSendLogEntity.setIsFirst(0);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + clientFundDepositEntity.getClientId() + "]客户的出金信息已发送到SNS短信/邮件通道");
                        }
                    }
                }
            }

            /**
             * 首次存入资金
             */
            clientFundDepositDepParam.setDepositType(CrmCommonEnum.SecDataDictionary.SEC_FUND_DEPOSIT_DEP.getIndex());

            List<ClientFundDepositEntity> clientFirstDepositList = clientFundDepositService.queryClientFirstDepositSend(clientFundDepositDepParam);

            List<Object> clientFirstDepositParams = Lists.newArrayList();

            Map<String, Object> clientFirstDepositMap = Maps.newHashMap();

            // 推送给APP
            for (ClientFundDepositEntity clientFundDepositEntity : clientFirstDepositList) {

                if (!clientFirstDepositMap.containsValue(clientFundDepositEntity.getClientId()) && null != clientFundDepositEntity.getUserId() && null != clientFundDepositEntity.getChannelId()) {

                    clientFirstDepositMap = Maps.newHashMap();

                    clientFirstDepositMap.put("userId", clientFundDepositEntity.getUserId() == null ? "" : clientFundDepositEntity.getUserId());
                    clientFirstDepositMap.put("clientId", clientFundDepositEntity.getClientId() == null ? "" : clientFundDepositEntity.getClientId());
                    clientFirstDepositMap.put("channelId", clientFundDepositEntity.getChannelId() == null ? "" : clientFundDepositEntity.getChannelId());
//                clientFirstDepositMap.put("depositAccount", "");
//                    clientFirstDepositMap.put("currency", clientFundDepositEntity.getMoneyType() == null ? "" : clientFundDepositEntity.getMoneyType());
                    clientFirstDepositMap.put("depositMoney", clientFundDepositEntity.getOccurBalance() == null ? "" : clientFundDepositEntity.getOccurBalance());
                    clientFirstDepositMap.put("inviter", clientFundDepositEntity.getInviterId() == null ? "" : clientFundDepositEntity.getInviterId());

                    clientFirstDepositParams.add(clientFirstDepositMap);

                    // 推送到用户中心扩展
                    UserInfoExt userInfoExt = new UserInfoExt();
                    userInfoExt.setUserId(clientFundDepositEntity.getUserId());
                    userInfoExt.setDepositStatus(1);
                    userInfoExt.setOptType(4);

                    GenericSunlineRequest<UserInfoExt> request = new GenericSunlineRequest<>();
                    request.setParams(userInfoExt);

                    ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
                    msg.setBizCode(ActiveMqBizCode.USER_INFO_EXT);
                    msg.setPublishType(1);
                    msg.setMsgType(2);
                    msg.setMessage(JSON.toJSONString(request));

                    activeMqService.sendMessage(msg);
                }
            }

            ResponseVO sendRet = null;

            if (clientFirstDepositParams.size() > 0) {
                sendRet = sendFirstDepositToApp(clientFirstDepositParams);
            }

            // 记录日志
            if (sendRet != null && CrmCommonEnum.CodeType.OK.getCode() == sendRet.getCode()) {
                for (ClientFundDepositEntity clientFundDepositEntity : clientFirstDepositList) {
                    if (null != clientFundDepositEntity.getUserId() && null != clientFundDepositEntity.getChannelId()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(clientFundDepositEntity.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(0);
                        clientFundDepositSendLogEntity.setIsFirst(1);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + clientFundDepositEntity.getClientId() + "]客户的首次入金信息已推送到APP通道");
                        }
                    }
                }
            }

            /**
             * 首次取出资金
             */
            clientFundDepositDepParam.setDepositType(CrmCommonEnum.SecDataDictionary.SEC_FUND_DEPOSIT_WIT.getIndex());

            List<ClientFundDepositEntity> clientFirstWithdrawList = clientFundDepositService.queryClientFirstDepositSend(clientFundDepositDepParam);

            for (ClientFundDepositEntity clientFundDepositEntity : clientFirstWithdrawList) {

                if (!clientFirstDepositMap.containsValue(clientFundDepositEntity.getClientId()) && null != clientFundDepositEntity.getUserId() && null != clientFundDepositEntity.getChannelId()) {

                    // 推送到用户中心扩展
                    UserInfoExt userInfoExt = new UserInfoExt();
                    userInfoExt.setUserId(clientFundDepositEntity.getUserId());
                    userInfoExt.setWithdrawalStatus(1);
                    userInfoExt.setOptType(5);

                    GenericSunlineRequest<UserInfoExt> request = new GenericSunlineRequest<>();
                    request.setParams(userInfoExt);

                    ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
                    msg.setBizCode(ActiveMqBizCode.USER_INFO_EXT);
                    msg.setPublishType(1);
                    msg.setMsgType(2);
                    msg.setMessage(JSON.toJSONString(request));

                    activeMqService.sendMessage(msg);

                    if (null != clientFundDepositEntity.getUserId() && null != clientFundDepositEntity.getChannelId()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(clientFundDepositEntity.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(0);
                        clientFundDepositSendLogEntity.setIsFirst(1);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + clientFundDepositEntity.getClientId() + "]客户的首次出金信息已推送到APP通道");
                        }
                    }
                }
            }

            /**
             * 首次转入股票
             */
            StockTransferInfoEntity firstStockTransferInfoEntity = new StockTransferInfoEntity();
            firstStockTransferInfoEntity.setBusinessFlag(CrmCommonEnum.SecDataDictionary.SEC_STOCK_TRANSFER_DEP.getIndex());

            List<StockTransferInfoEntity> firstStockTransferInfoList = stockTransferInfoDao.queryFirstStockTransferInfoSend(firstStockTransferInfoEntity);

            List<Object> clientFirstStockTransferParams = Lists.newArrayList();

            Map<String, Object> clientFirstStockTransferMap;

            // 推送给APP
            for (StockTransferInfoEntity firstStockTransferInfo : firstStockTransferInfoList) {

                if (null != firstStockTransferInfo.getUserId() && null != firstStockTransferInfo.getChannelId()) {

                    clientFirstStockTransferMap = Maps.newHashMap();

                    clientFirstStockTransferMap.put("userId", firstStockTransferInfo.getUserId() == null ? "" : firstStockTransferInfo.getUserId());
                    clientFirstStockTransferMap.put("clientId", firstStockTransferInfo.getClientId() == null ? "" : firstStockTransferInfo.getClientId());
                    clientFirstStockTransferMap.put("channelId", firstStockTransferInfo.getChannelId() == null ? "" : firstStockTransferInfo.getChannelId());
//                    clientFirstStockTransferMap.put("currency", firstStockTransferInfo.getMoneyType() == null ? "" : firstStockTransferInfo.getMoneyType());
                    clientFirstStockTransferMap.put("transferredMoney", firstStockTransferInfo.getStockMktValue() == null ? "" : firstStockTransferInfo.getStockMktValue());
                    clientFirstStockTransferMap.put("inviter", firstStockTransferInfo.getInviterId() == null ? "" : firstStockTransferInfo.getInviterId());

                    clientFirstStockTransferParams.add(clientFirstStockTransferMap);

                    // 推送到用户中心扩展
                    UserInfoExt userInfoExt = new UserInfoExt();
                    userInfoExt.setUserId(firstStockTransferInfo.getUserId());
                    userInfoExt.setTransferInStatus(1);
                    userInfoExt.setOptType(2);

                    GenericSunlineRequest<UserInfoExt> request = new GenericSunlineRequest<>();
                    request.setParams(userInfoExt);

                    ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
                    msg.setBizCode(ActiveMqBizCode.USER_INFO_EXT);
                    msg.setPublishType(1);
                    msg.setMsgType(2);
                    msg.setMessage(JSON.toJSONString(request));

                    activeMqService.sendMessage(msg);
                }
            }

            sendRet = null;

            if (clientFirstStockTransferParams.size() > 0) {
                sendRet = sendFirstStockTransferToApp(clientFirstStockTransferParams);
            }

            // 记录日志
            if (sendRet != null && CrmCommonEnum.CodeType.OK.getCode() == sendRet.getCode()) {
                for (StockTransferInfoEntity firstStockTransferInfo : firstStockTransferInfoList) {
                    if (null != firstStockTransferInfo.getUserId() && null != firstStockTransferInfo.getChannelId()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(firstStockTransferInfo.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(1);
                        clientFundDepositSendLogEntity.setIsFirst(1);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + firstStockTransferInfo.getClientId() + "]客户的首次转入股票信息已推送到APP通道");
                        }
                    }
                }
            }

            /**
             * 首次转出股票
             */
            firstStockTransferInfoEntity.setBusinessFlag(CrmCommonEnum.SecDataDictionary.SEC_STOCK_TRANSFER_WIT.getIndex());

            List<StockTransferInfoEntity> firstWitStkInfoList = stockTransferInfoDao.queryFirstStockTransferInfoSend(firstStockTransferInfoEntity);

            // 推送给APP
            for (StockTransferInfoEntity firstStockTransferInfo : firstWitStkInfoList) {

                if (null != firstStockTransferInfo.getUserId() && null != firstStockTransferInfo.getChannelId()) {

                    // 推送到用户中心扩展
                    UserInfoExt userInfoExt = new UserInfoExt();
                    userInfoExt.setUserId(firstStockTransferInfo.getUserId());
                    userInfoExt.setTransferOutStatus(1);
                    userInfoExt.setOptType(3);

                    GenericSunlineRequest<UserInfoExt> request = new GenericSunlineRequest<>();
                    request.setParams(userInfoExt);

                    ActiveMsgEntity<Object> msg = new ActiveMsgEntity<>();
                    msg.setBizCode(ActiveMqBizCode.USER_INFO_EXT);
                    msg.setPublishType(1);
                    msg.setMsgType(2);
                    msg.setMessage(JSON.toJSONString(request));

                    activeMqService.sendMessage(msg);

                    if (null != firstStockTransferInfo.getUserId() && null != firstStockTransferInfo.getChannelId()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(firstStockTransferInfo.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(1);
                        clientFundDepositSendLogEntity.setIsFirst(1);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + firstStockTransferInfo.getClientId() + "]客户的首次转出股票信息已推送到APP通道");
                        }
                    }
                }
            }

            /**
             * 转入股票
             */
            Map<String, String> transferParams = Maps.newHashMap();

            StockTransferInfoEntity stockTransferInfoEntity = new StockTransferInfoEntity();
            List<String> businessFlagList = Lists.newArrayList();
            businessFlagList.add(CrmCommonEnum.SecDataDictionary.SEC_STOCK_TRANSFER_DEP.getIndex());
            businessFlagList.add(CrmCommonEnum.SecDataDictionary.SEC_STOCK_TRANSFER_SI_DEP.getIndex());
            stockTransferInfoEntity.setBusinessFlagList(businessFlagList);

            List<StockTransferInfoEntity> stockTransferInfoDepList = stockTransferInfoService.queryStockTransferInfoSend(stockTransferInfoEntity);

            for (StockTransferInfoEntity stockTransferInfo : stockTransferInfoDepList) {

                if (null != stockTransferInfo.getEmail() && null != stockTransferInfo.getUserId() && null != stockTransferInfo.getChannelId()) {

                    // 发送邮件
                    userList.clear();
                    paramList.clear();
                    transferParams.clear();

                    String encryptClientId = "";
                    if (stockTransferInfo.getClientId() != null) {
                        encryptClientId = stockTransferInfo.getClientId().substring(0, 2) + stockTransferInfo.getClientId().substring(3, 4)
                                + "**" + stockTransferInfo.getClientId().substring(5);
                    }

                    paramList.add(encryptClientId);
                    paramList.add(stockTransferInfo.getChannelId());
                    paramList.add(CrmCommonEnum.SecNetCapital.getName(stockTransferInfo.getNetCapital()));
                    paramList.add(DECIMAL_FORMAT.format(stockTransferInfo.getStockMktValue()));
                    paramList.add(CrmCommonEnum.SecMoneyType.getName(stockTransferInfo.getMoneyType()));
                    paramList.add("");
                    paramList.add(stockTransferInfo.getTradeDate());
                    paramList.add(stockTransferInfo.getUserId() == null ? "" : String.valueOf(stockTransferInfo.getUserId()));

                    String clientName = "";

                    if (null != stockTransferInfo.getClientName() && !"".equals(stockTransferInfo.getClientName())) {
                        clientName = stockTransferInfo.getClientName();
                    }

                    if ("".equals(clientName) && null != stockTransferInfo.getClientNameSpell()) {
                        clientName = stockTransferInfo.getClientNameSpell();
                    }

                    paramList.add(clientName);

                    transferParams.put(StockCodeUtils.securityCode2AssetId(stockTransferInfo.getStockCode(), stockTransferInfo.getExchangeType()), String.valueOf(stockTransferInfo.getOccurAmount()));

                    ResponseVO sendEmailRet = clientFundDepositSendEmail("1062", paramList, transferParams, stockTransferInfo.getEmail(), stockTransferInfo.getPhoneNumber());

                    // 记录日志
                    if (sendEmailRet != null && CrmCommonEnum.CodeType.OK.getCode() == sendEmailRet.getCode()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(stockTransferInfo.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(1);
                        clientFundDepositSendLogEntity.setIsFirst(0);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + stockTransferInfo.getClientId() + "]客户的转入股票信息已发送到邮件通道");
                        }
                    }
                }
            }

            /**
             * 转出股票
             */

            businessFlagList.clear();
            businessFlagList.add(CrmCommonEnum.SecDataDictionary.SEC_STOCK_TRANSFER_WIT.getIndex());
            businessFlagList.add(CrmCommonEnum.SecDataDictionary.SEC_STOCK_TRANSFER_SI_WIT.getIndex());
            stockTransferInfoEntity.setBusinessFlagList(businessFlagList);

            List<StockTransferInfoEntity> stockTransferInfoWitList = stockTransferInfoService.queryStockTransferInfoSend(stockTransferInfoEntity);

            for (StockTransferInfoEntity stockTransferInfo : stockTransferInfoWitList) {

                if (null != stockTransferInfo.getEmail() && null != stockTransferInfo.getUserId() && null != stockTransferInfo.getChannelId()) {
                    // 发送邮件
                    userList.clear();
                    paramList.clear();
                    transferParams.clear();

                    String encryptClientId = "";
                    if (stockTransferInfo.getClientId() != null) {
                        encryptClientId = stockTransferInfo.getClientId().substring(0, 2) + stockTransferInfo.getClientId().substring(3, 4)
                                + "**" + stockTransferInfo.getClientId().substring(5);
                    }

                    paramList.add(encryptClientId);
                    paramList.add(stockTransferInfo.getChannelId());
                    paramList.add(CrmCommonEnum.SecNetCapital.getName(stockTransferInfo.getNetCapital()));
                    paramList.add(DECIMAL_FORMAT.format(stockTransferInfo.getStockMktValue()));
                    paramList.add(CrmCommonEnum.SecMoneyType.getName(stockTransferInfo.getMoneyType()));
                    paramList.add("");
                    paramList.add(stockTransferInfo.getTradeDate());
                    paramList.add(stockTransferInfo.getUserId() == null ? "" : String.valueOf(stockTransferInfo.getUserId()));

                    String clientName = "";

                    if (null != stockTransferInfo.getClientName() && !"".equals(stockTransferInfo.getClientName())) {
                        clientName = stockTransferInfo.getClientName();
                    }

                    if ("".equals(clientName) && null != stockTransferInfo.getClientNameSpell()) {
                        clientName = stockTransferInfo.getClientNameSpell();
                    }

                    paramList.add(clientName);

                    transferParams.put(StockCodeUtils.securityCode2AssetId(stockTransferInfo.getStockCode(), stockTransferInfo.getExchangeType()), String.valueOf(stockTransferInfo.getOccurAmount()));

                    ResponseVO sendEmailRet = clientFundDepositSendEmail("1063", paramList, transferParams, stockTransferInfo.getEmail(), stockTransferInfo.getPhoneNumber());

                    // 记录日志
                    if (sendEmailRet != null && CrmCommonEnum.CodeType.OK.getCode() == sendEmailRet.getCode()) {
                        ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                        clientFundDepositSendLogEntity.setPositionStr(stockTransferInfo.getPositionStr());
                        clientFundDepositSendLogEntity.setSendStatus(1);
                        clientFundDepositSendLogEntity.setSendType(1);
                        clientFundDepositSendLogEntity.setIsFirst(0);
                        clientFundDepositSendLogEntity.setCreateTime(new Date());
                        clientFundDepositSendLogEntity.setUpdateTime(new Date());

                        ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                        if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                            logger.info("[" + stockTransferInfo.getClientId() + "]客户的转出股票信息已发送到邮件通道");
                        }
                    }
                }
            }

            /**
             * 客户累计入金额大于年收入or财产总额发送异常邮件
             */
            clientFundDepositDepParam.setDepositType(CrmCommonEnum.SecDataDictionary.SEC_FUND_DEPOSIT_DEP.getIndex());

            List<ClientFundDepositEntity> clientTotalIncAmountAbnormalList = clientFundDepositService.queryTotalIncAmountAbnormal(clientFundDepositDepParam);

            for (ClientFundDepositEntity clientTotalIncAmountAbnormal : clientTotalIncAmountAbnormalList) {

//                StringBuilder errMsg = new StringBuilder();
//                errMsg.append("<strong>客户姓名：</strong>" + clientTotalIncAmountAbnormal.getClientName() +"<br><strong>客户号：</strong>" + clientTotalIncAmountAbnormal.getClientId()
//                        + "<br><strong>累计入金总额（HKD）：</strong>" + clientTotalIncAmountAbnormal.getTotalIncAmount()
//                        + "<br><strong>全年收入：</strong>" + CodeUtils.getCodeName("AO_INCOME", clientTotalIncAmountAbnormal.getAnnualIncome()));

                List<OpenAccountPropertyTypeEntity> openAccountPropertyTypeEntity = Lists.newArrayList();
                if (null != clientTotalIncAmountAbnormal.getApplicationId()) {
                    openAccountPropertyTypeEntity = openAccountPropertyTypeService.queryByApplicationId(clientTotalIncAmountAbnormal.getApplicationId());
                }

                String propertyAmount1 = "";
                String propertyAmount2 = "";
                String propertyAmount3 = "";

                for (OpenAccountPropertyTypeEntity property : openAccountPropertyTypeEntity) {

                    if (property.getPropertyType() == 1) {
                        propertyAmount1 = CodeUtils.getCodeName("AO_PROPERTY_TYPE_1", property.getPropertyAmount());
                    }

                    if (property.getPropertyType() == 2) {
                        propertyAmount2 = CodeUtils.getCodeName("AO_PROPERTY_TYPE_2", property.getPropertyAmount());
                    }

                    if (property.getPropertyType() == 3) {
                        propertyAmount3 = CodeUtils.getCodeName("AO_PROPERTY_TYPE_3", property.getPropertyAmount());
                    }
                }

                MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
                messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
                messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("TRADE_DEPART_WARNING_GROUP", "dealing@zszhizhu.com"));
                messageSendInfoEntity.setMessageTitle("【客户累计入金总额异常提示】客户号" + clientTotalIncAmountAbnormal.getClientId());
                messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                Map<String, String> emailModel = Maps.newHashMap();
                emailModel.put("clientName", clientTotalIncAmountAbnormal.getClientName());
                emailModel.put("clientId", clientTotalIncAmountAbnormal.getClientId());
                emailModel.put("occurBalance", String.valueOf(clientTotalIncAmountAbnormal.getOccurBalance()));
                emailModel.put("totalAmount", String.valueOf(clientTotalIncAmountAbnormal.getTotalAmount()));
                emailModel.put("totalIncAmount", clientTotalIncAmountAbnormal.getTotalIncAmount());
                emailModel.put("totalOutAmount", clientTotalIncAmountAbnormal.getTotalOutAmount());
                emailModel.put("annualIncome", CodeUtils.getCodeName("AO_INCOME", clientTotalIncAmountAbnormal.getAnnualIncome()));
                emailModel.put("propertyAmount1", propertyAmount1);
                emailModel.put("propertyAmount2", propertyAmount2);
                emailModel.put("propertyAmount3", propertyAmount3);
                messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.TOTAL_INC_AMOUNT_ABNORMAL_EMAIL_TEMPLATE, emailModel));
                messageSendInfoEntity.setContentType(1);

                int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

                if (isSucceed > 0) {

                    // 记录日志
                    ClientFundDepositSendLogEntity clientFundDepositSendLogEntity = new ClientFundDepositSendLogEntity();
                    clientFundDepositSendLogEntity.setPositionStr(clientTotalIncAmountAbnormal.getPositionStr());
                    clientFundDepositSendLogEntity.setSendStatus(1);
                    clientFundDepositSendLogEntity.setSendType(3);
                    clientFundDepositSendLogEntity.setIsFirst(0);
                    clientFundDepositSendLogEntity.setCreateTime(new Date());
                    clientFundDepositSendLogEntity.setUpdateTime(new Date());

                    ResponseVO updateRet = updateSendLog(clientFundDepositSendLogEntity);

                    if (updateRet != null && CrmCommonEnum.CodeType.OK.getCode() == updateRet.getCode()) {
                        logger.info("[" + clientTotalIncAmountAbnormal.getClientId() + "]客户累计入金额大于年收入or财产总额已发送异常邮件");
                    }
                }

            }

        } catch (Exception e) {
            logger.error(params + "任务执行异常：" + e);
        }

    }

    /**
     * 发送邮件
     *
     * @param code
     * @param list
     * @return
     */
    private ResponseVO clientFundDepositSendEmail(String code, List<String> list, Map<String, String> transferParams, String email, String phoneNumber) {

        ResponseVO responseVO = new ResponseVO();

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("code", code);
            paraMap.put("list", list);
            paraMap.put("params", transferParams);
            paraMap.put("accept", email);
            paraMap.put("phone", phoneNumber);

            logger.info("客户出入金发送邮件调用参数：" + JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.fund.deposit.send.email"), JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));

            logger.info("客户出入金发送邮件调用结果：" + JSON.toJSONString(response));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("code").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("客户出入金发送邮件异常", e);
        }
        return null;
    }

    /**
     * 发送短信
     *
     * @param userIds
     * @param list
     * @param templateCode
     * @return
     */
    private ResponseVO clientFundDepositSendSms(String templateCode, List<String> userIds, List<String> list) {

        ResponseVO responseVO = new ResponseVO();

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("userIds", userIds);
            paraMap.put("sendType", 0);
            paraMap.put("params", list);
            paraMap.put("templateCode", templateCode);

            logger.info("客户出入金发送短信调用参数：" + JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.fund.deposit.send.sms"), JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));

            logger.info("客户出入金发送短信调用结果：" + JSON.toJSONString(response));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("code").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("客户出入金发送短信异常", e);
        }
        return null;
    }

    /**
     * 首次入金信息推送给APP
     *
     * @param list
     * @return
     */
    private ResponseVO sendFirstDepositToApp(List<Object> list) {

        ResponseVO responseVO = new ResponseVO();

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("params", list);

            logger.info("首次入金信息推送给APP调用参数：" + JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.fund.deposit.send.app") + "sync_deposit_user_info", JSON.toJSONString(paraMap, SerializerFeature.DisableCircularReferenceDetect));

            logger.info("首次入金信息推送给APP调用结果：" + JSON.toJSONString(response));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("code").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("首次入金信息推送给APP异常", e);
        }
        return null;
    }

    /**
     * 首次转入股票推送给App
     *
     * @param list
     * @return
     */
    private ResponseVO sendFirstStockTransferToApp(List<Object> list) {

        ResponseVO responseVO = new ResponseVO();

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("params", list);

            logger.info("首次转入股票推送给APP调用参数：" + JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.fund.deposit.send.app") + "sync_transferred_stock", JSON.toJSONString(paraMap, SerializerFeature.DisableCircularReferenceDetect));

            logger.info("首次转入股票推送给APP调用结果：" + JSON.toJSONString(response));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("code").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("首次转入股票推送给APP异常", e);
        }
        return null;
    }

    /**
     * 记录日志
     *
     * @param clientFundDepositSendLogEntity
     * @return
     */
    private ResponseVO updateSendLog(ClientFundDepositSendLogEntity clientFundDepositSendLogEntity) {

        ResponseVO responseVO = new ResponseVO();

        try {

            int count = clientFundDepositSendLogService.save(clientFundDepositSendLogEntity);

            if (count > 0) {
                responseVO.setCode(0);
                responseVO.setMessage("更新成功");
            } else {
                responseVO.setCode(0);
                responseVO.setMessage("更新失败");
            }

            return responseVO;

        } catch (Exception e) {
            logger.error("记录日志异常", e);
        }
        return null;
    }
}
