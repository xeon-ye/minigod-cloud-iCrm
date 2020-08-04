package com.sunline.modules.quartz.task;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyResultRequest;
import com.sunline.modules.account.professional.service.ProfessionalInvestorApplicationService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.fund.entity.ClientBankCardInfoEntity;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import com.sunline.modules.fund.proxy.request.FundDepositResultRequest;
import com.sunline.modules.fund.service.ClientBankCardInfoService;
import com.sunline.modules.fund.service.ClientFundDepositApplicationService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.request.FundAccountRequest;
import com.sunline.modules.hundsun.protocol.request.FundCashDeposit;
import com.sunline.modules.hundsun.protocol.response.FundAccountResponse;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 专业投资者状态同步恒生柜台
 */
@Component("professionalSyscHsTask")
public class ProfessionalSyscHsTask {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProfessionalInvestorApplicationService professionalInvestorApplicationService;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    SecUserInfoService secUserInfoService;

    /**
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
        logger.info(params + "任务开始");

        //查询列表数据
        Map<String, Object> param = new HashMap<>();
        param.put("callbackStatus",BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        param.put("applicationStatus", BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE);

        List<ProfessionalInvestorApplicationEntity> entityList = professionalInvestorApplicationService.queryList(param);
        logger.info("专业投资者认定同步恒生柜台，待处理条数：" + entityList.size());
        if(entityList.size()>0) {
            //先获取柜台状态
            ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
            if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
                SysArgResponse result = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
                if ("6".equals(result.getSysStatus()) || "0".equals(result.getBankStatus())) {
                    return;
                }
            } else {
                logger.info("获取柜台状态失败");
                return;
            }
        }
        for (ProfessionalInvestorApplicationEntity entity : entityList) {
            try {
                FundAccountRequest.FundAccountGetRequest fundAccountGetRequest = new FundAccountRequest.FundAccountGetRequest();
                fundAccountGetRequest.setClientId(entity.getClientId());
                fundAccountGetRequest.setFundAccount(Integer.valueOf(entity.getFundAccount()));

                CommonResponse response = professionalInvestorApplicationService.sysApplyToHs(fundAccountGetRequest,4);
                if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {
                    entity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "1")));

                    //回调中台
                    professionalInvestorApplicationService.pushFundDepositResult(new ProfessionalApplyResultRequest(entity.getApplicationId(), BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE,null));

                    List<String> paramList = Lists.newArrayList();
                    paramList.add(StringUtils.isNotBlank(entity.getClientName()) ? entity.getClientName() : entity.getClientNameSpell());
                    professionalInvestorApplicationService.generateSendSms(2036, entity.getPhoneNumber(), paramList);

                    //更新securities_user_info表
                    SecuritiesUserInfoEntity userInfo  = new SecuritiesUserInfoEntity();
                    userInfo.setUserId(entity.getUserId());
                    SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryByUserId(userInfo);
                    if(null != userInfoEntity){
                        SecuritiesUserModel request = new SecuritiesUserModel();
                        request.setTradeAccount(userInfoEntity.getTradeAccount());
                        request.setFundAccount(userInfoEntity.getFundAccount());
                        request.setIdKind(userInfoEntity.getIdKind());
                        request.setIdNo(userInfoEntity.getIdNo());
                        request.setRoomCode(4);
                        securitiesUserInfoService.modifySecuritiesUserInfo(request);
                    }
//                    //todo 邮件通知
//                    Map<String, String> emailModel = Maps.newHashMap();
//                    VelocityUtil.fillTemplate(VelocityUtil.PROFESSIONAL_INVERSTO_SUCCEED_EMAIL_TEMPLATE, emailModel);
//                    professionalInvestorApplicationService.generateSendEmail("","",userInfoEntity.getEmail());
                } else {
                    logger.info("专业投资者认定同步恒生柜台失败，预约号：{}",entity.getApplicationId());
                    entity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                    String msg = "系统预约号"+entity.getApplicationId() + ",同步柜台失败,异常信息：" + JSON.toJSONString(response != null ? response : "");
                    generateSendEmail("【系统异常】cubp专业投资者", msg);
                }
            } catch (Exception e) {
                logger.info("专业投资者认定同步恒生柜台异常，预约号：{}",entity.getApplicationId());
                e.printStackTrace();
                entity.setHsDealStatus(Integer.valueOf(CodeUtils.getCodeValue("FUND_WITHDRAW_HS_DEAL_STATUS", "2")));
                String msg = "系统预约号"+entity.getApplicationId() + ",同步柜台失败,异常信息：" + e;
                generateSendEmail("【系统异常】cubp专业投资者", msg);
            }
            entity.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);
            entity.setUpdateTime(new Date());
            professionalInvestorApplicationService.update(entity);
        }
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
