package com.sunline.modules.quartz.task;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyResultRequest;
import com.sunline.modules.account.professional.service.ProfessionalInvestorApplicationService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.request.FundAccountRequest;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 专业投资者认定提醒信息发送调度任务
 * @author: jim
 * @date: 2019/12/23 13:14
 */
@Component("professionalHintMsgTask")
public class ProfessionalHintMsgTask {

    private static final Logger logger = LoggerFactory.getLogger(ProfessionalHintMsgTask.class);
    @Autowired
    private ProfessionalInvestorApplicationService professionalInvestorApplicationService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    SecUserInfoService secUserInfoService;

    /**
     * 调度任务
     *
     * @param params
     */
    public void excute(String params) {

        logger.info(params + "任务开始");

        //查询列表数据
        Map<String, Object> param = new HashMap<>();
        param.put("applicationStatus", BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE);
        param.put("expireDateSt", DateUtil.beginOfDay(DateUtil.date()).toString());
        param.put("expireDateEd", DateUtil.endOfDay(DateUtil.offsetDay(DateUtil.date(), 21)).toString());

        List<ProfessionalInvestorApplicationEntity> entityList = professionalInvestorApplicationService.queryList(param);

        logger.info("专业投资者认定到期处理任务，待处理数据条数：" + entityList.size());

        for (ProfessionalInvestorApplicationEntity entity : entityList) {
            if (null != entity.getExpireTime()) {
                // 计算自然日之差
                Date backTime = DateUtil.beginOfDay(entity.getExpireTime());
                long betweenDay = DateUtil.between(new Date(), backTime, DateUnit.DAY);
                //T-20日
                if (19 == betweenDay) {
                    //查询近345天内资产值
                    ClientFundCountEntity queryAaaets = new ClientFundCountEntity();
                    queryAaaets.setClientId(entity.getClientId());
//                    queryAaaets.setFundAccount(entity.getFundAccount());
                    queryAaaets.setStDate(DateUtil.format(DateUtil.offsetDay(DateUtil.date(), -345), "yyyy-MM-dd"));
                    queryAaaets.setEdDate(DateUtil.today());
                    ClientFundCountEntity max = professionalInvestorApplicationService.queryTotalAssetByDate(queryAaaets);
                    if (null == max) {
                        //资产<800万港币，通知快到期
                        List<String> paramList = Lists.newArrayList();
                        paramList.add(StringUtils.isNotBlank(entity.getClientName()) ? entity.getClientName() : entity.getClientNameSpell());
                        paramList.add(DateUtil.format(entity.getExpireTime(), "yyyy-MM-dd"));
                        generateSendSms(2038, entity.getPhoneNumber(), paramList);
                        professionalInvestorApplicationService.pushFundDepositResult(new ProfessionalApplyResultRequest(entity.getApplicationId(), BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_WELL_INVALID_VALIUE, null));
                    }
                }
                //T日
                if (0 == betweenDay) {
                    ClientFundCountEntity queryAaaets = new ClientFundCountEntity();
                    queryAaaets.setClientId(entity.getClientId());
//                    queryAaaets.setFundAccount(entity.getFundAccount());
                    queryAaaets.setStDate(DateUtil.format(DateUtil.offset(new Date(), DateField.YEAR, -1), "yyyy-MM-dd"));
                    queryAaaets.setEdDate(DateUtil.today());
                    ClientFundCountEntity max = professionalInvestorApplicationService.queryTotalAssetByDate(queryAaaets);
                    if (null != max) {
                        //资产>=800万港币，生成新纪录，通知保留专业投资者身份
                        ProfessionalInvestorApplicationEntity commit = new ProfessionalInvestorApplicationEntity();
                        commit.setUserId(entity.getUserId());
                        commit.setClientId(entity.getClientId());
                        commit.setFundAccount(entity.getFundAccount());
                        commit.setApplyTime(new Date());
                        commit.setTotalAssets(max.getTotalAssets());
                        commit.setTotalAssetsDate(DateUtil.parseDate(max.getTradeDate()));
                        commit.setPortfolios("1");
                        String applicationId = professionalInvestorApplicationService.commitApply(commit, null, null);
                        if (StringUtils.isNotBlank(applicationId)) {
                            try {
                                ProcessTaskDto taskDto1 = actModelerService.findProcessTaskByBusId(applicationId);
                                actModelerService.doActTask(taskDto1, null);//初审通过
                                ProcessTaskDto taskDto2 = actModelerService.findProcessTaskByBusId(applicationId);
                                actModelerService.doActTask(taskDto2, null);//复审通过
                            } catch (Exception e) {
                                logger.error("专业投资者后台审核失败,客户号：{}", commit.getClientId(), e);
                                String msg = "专业投资者用户身份到期后台重提记录失败，clientId:" + commit.getClientId() + ";失败信息：" + e.getMessage();
                                generateSendEmail("【系统异常】专业投资者认定】", msg);
                            }
                        } else {
                            logger.error("专业投资者认定后台生成记录失败,客户号：{}", commit.getClientId());

                            generateSendEmail("【专业投资者认定后台生成记录失败】", "用户身份到期后台重提记录失败，clientId:" + commit.getClientId());
                        }
                    } else {
                        //如果用户重新发起申请并已通过，则不更改用户状态，且不推送短信和app
                        Map<String, Object> q = new HashMap<>();
                        q.put("userId", entity.getUserId());
                        q.put("clientId", entity.getClientId());
                        q.put("sidx", "apply_time");
                        q.put("order", "DESC");
                        List<ProfessionalInvestorApplicationEntity> lastAppliction = professionalInvestorApplicationService.queryList(q);
                        ProfessionalInvestorApplicationEntity lastApp = lastAppliction.get(0);
                        if ((!entity.getApplicationId().equals(lastApp.getApplicationId())) && lastApp.getApplicationStatus() == BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE) {
                            continue;
                        }

                        //资产<800万港币，更新状态为失效,通知sunline
                        //先在里面获取柜台状态，数据量很大时可移到for循环外部
                        ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
                        if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
                            SysArgResponse result = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
                            if ("6".equals(result.getSysStatus()) || "0".equals(result.getBankStatus())) {
                                generateSendEmail("【系统异常】CUBP专业投资者到期", "CUBP专业投资者到期同步柜台失败，请处理!原因是柜台状态不可用，clientId:" + entity.getClientId());
                                return;
                            }
                        } else {
                            logger.info("获取柜台状态失败");
                            generateSendEmail("【系统异常】CUBP专业投资者到期", "CUBP专业投资者到期同步柜台失败，请处理!原因是查询柜台状态失败，clientId:" + entity.getClientId());
                            return;
                        }

                        try {
                            FundAccountRequest.FundAccountGetRequest fundAccountGetRequest = new FundAccountRequest.FundAccountGetRequest();
                            fundAccountGetRequest.setClientId(entity.getClientId());
                            fundAccountGetRequest.setFundAccount(Integer.valueOf(entity.getFundAccount()));

                            CommonResponse response = professionalInvestorApplicationService.sysApplyToHs(fundAccountGetRequest, 1);
                            if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {
                                professionalInvestorApplicationService.pushFundDepositResult(new ProfessionalApplyResultRequest(entity.getApplicationId(), BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_INVALID_VALIUE, null));

                                List<String> paramList = Lists.newArrayList();
                                paramList.add(StringUtils.isNotBlank(entity.getClientName()) ? entity.getClientName() : entity.getClientNameSpell());
                                generateSendSms(2035, entity.getPhoneNumber(), paramList);

                                //更新securities_user_info表
                                SecuritiesUserInfoEntity userInfo = new SecuritiesUserInfoEntity();
                                userInfo.setUserId(entity.getUserId());
                                SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryByUserId(userInfo);
                                if (null != userInfoEntity) {
                                    SecuritiesUserModel request = new SecuritiesUserModel();
                                    request.setTradeAccount(userInfoEntity.getTradeAccount());
                                    request.setFundAccount(userInfoEntity.getFundAccount());
                                    request.setIdKind(userInfoEntity.getIdKind());
                                    request.setIdNo(userInfoEntity.getIdNo());
                                    request.setRoomCode(1);
                                    ResponseVO vo = securitiesUserInfoService.modifySecuritiesUserInfo(request);
                                    logger.info("更新至统一用户中心结果:{}", JSON.toJSONString(vo != null ? vo : ""));
                                }
                            } else {
                                logger.error("专业投资者到期同步柜台失败，ClientId:{}", entity.getClientId());
                                generateSendEmail("【系统异常】CUBP专业投资者到期", "专业投资者到期同步柜台失败,clientId:" + entity.getClientId() + ";失败信息：" + JSON.toJSONString(response != null ? response.getDataResult() : ""));
                            }
                        } catch (Exception e) {
                            logger.error("专业投资者到期同步柜台异常，ClientId:{}", entity.getClientId());
                            e.printStackTrace();
                            generateSendEmail("【系统异常】CUBP专业投资者到期", "专业投资者到期同步柜台异常,clientId:" + entity.getClientId() + ";异常信息：" + e.getMessage());
                        }
                    }
                    ProfessionalInvestorApplicationEntity update = new ProfessionalInvestorApplicationEntity();
                    update.setApplicationId(entity.getApplicationId());
                    update.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_INVALID_VALIUE);
                    update.setUpdateTime(new Date());
                    update.setUpdateUser(UserUtils.getBackgroundWorkflowUser().getId());
                    professionalInvestorApplicationService.update(update);

                }

            }
        }

    }

    private boolean generateSendSms(Integer templateCode, String phoneNumber, List<String> paramList) {
        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("userType", 1);
            paraMap.put("sendType", 0);
            paraMap.put("phone", phoneNumber);
            paraMap.put("params", paramList);
            paraMap.put("templateCode", templateCode);

            MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
            messageSendInfoEntity.setRecipients(ConfigUtils.get("message.center.sms.url"));
            messageSendInfoEntity.setMessageTitle("专业投资者认定业务通知");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            messageSendInfoEntity.setMessageContent(JSON.toJSONString(paraMap, SerializerFeature.WriteMapNullValue));
            messageSendInfoEntity.setContentType(1);
            messageSendInfoEntity.setAttachmentUris("");
            int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

            return 1 == isSucceed;
        } catch (Exception e) {
            logger.error("专业投资者认定业务通知异常", e);
        }

        return false;
    }

    /**
     * 发送邮件通知
     *
     * @param title
     * @param message
     */
    private void generateSendEmail(String title, String message) {
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(SysConfigUtil.getSysConfigValue("SYSTEM_NOTICE_EMAIL_GROUP", "it@zszhizhu.com;laijieqiang@zszhizhu.com"));
        messageSendInfoEntity.setMessageTitle(title);
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(message);
        messageSendInfoEntity.setContentType(0);

        messageSendInfoService.save(messageSendInfoEntity);
    }
}
