package com.sunline.modules.fund.proxy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.helper.ClientFundWithdrawApplyHelper;
import com.sunline.modules.fund.protocol.ClientFundWithdrawApplyProto;
import com.sunline.modules.fund.service.ClientFundWithdrawApplyService;
import com.sunline.modules.hundsun.protocol.request.FundFrozenRequest;
import com.sunline.modules.hundsun.protocol.response.FundFrozenResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @description: 出金申请代理类
 * @author: Larry Lai
 * @date: 2019/4/1 16:57
 * @version: v1.0
 */

@RequestMapping(value = "proxy/fund")
@Controller
public class ClientFundWithdrawApplyProxy {

    private static final Logger logger = LoggerFactory.getLogger(ClientFundWithdrawApplyProxy.class);

    private static final String CLIENT_FUND_WITHDRAW_FLOW_MODEL_KEY = "clientFundWithdrawApplication";

    @Autowired
    ClientFundWithdrawApplyService clientFundWithdrawApplyService;
    @Autowired
    private TaskService taskService;
    @Autowired
    ActModelerService actModelerService;

    /**
     * 客户出金申请提交接口
     *
     * @param request
     * @return
     */
    @RequestMapping("/clientFundWithdrawApply")
    @SystemLog(description = "提交出金申请")
    public
    @ResponseBody
    ResponseVO clientFundWithdrawApply(@RequestBody GenericSunlineRequest<ClientFundWithdrawApplyProto> request) {

        ResponseVO responseVO = new ResponseVO();

        ClientFundWithdrawApplyProto clientFundWithdrawApplyInfo = request.getParams();

        // 交易数据完整性
        ResponseVO baseDataValidateResult = ClientFundWithdrawApplyHelper.validateClientFundWithdrawInfo(clientFundWithdrawApplyInfo);
        if (CrmCommonEnum.CodeType.ERROR.getCode() == baseDataValidateResult.getCode()) {
            return baseDataValidateResult;
        }

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = ClientFundWithdrawApplyHelper.protocolToEntity(clientFundWithdrawApplyInfo);

        // 资金冻结
        FundFrozenRequest fundFrozenRequest = new FundFrozenRequest();
        fundFrozenRequest.setActionIn(1);
        fundFrozenRequest.setAuditAction("1");
        fundFrozenRequest.setFundAccount(Integer.parseInt(clientFundWithdrawApplyEntity.getFundAccount()));
        fundFrozenRequest.setMoneyType(clientFundWithdrawApplyEntity.getMoneyType());
        fundFrozenRequest.setFrozenReason("0");
        fundFrozenRequest.setOccurbalance(clientFundWithdrawApplyEntity.getOccurBalance());
        fundFrozenRequest.setValidDate(29991231);
        fundFrozenRequest.setRemark("BATCH FROZEN");
        fundFrozenRequest.setLocaleRemark("批量冻结");
        fundFrozenRequest.setOverdraftForcedFlag("0");
        fundFrozenRequest.setRevertFlag("0");

        CommonResponse response = HsCommManageService.send("hundsunProxyService/fundFrozen.do", fundFrozenRequest);

        FundFrozenResponse fundFrozenResponse;
        if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {

            fundFrozenResponse = JSON.parseObject(JSON.toJSONString(response.getDataResult()), FundFrozenResponse.class);

            clientFundWithdrawApplyEntity.setRevertSerialNo(fundFrozenResponse != null ? fundFrozenResponse.getRevertSerialNo() : null);
            clientFundWithdrawApplyEntity.setInitDate(fundFrozenResponse != null ? fundFrozenResponse.getInitDate() : null);
            String applicationId = clientFundWithdrawApplyService.commitClientFundWithdrawApply(clientFundWithdrawApplyEntity);

            if (StringUtils.isNotBlank(applicationId)) {
                logger.info("已成功接收[" + clientFundWithdrawApplyInfo.getClientId() + "]用户的出金申请");
                responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

                Map<String, Object> resultMap = Maps.newHashMap();
                resultMap.put("applicationId", applicationId);

                responseVO.setResult(resultMap);
            } else {
                responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            }

        } else {
            if (null != response) {
                fundFrozenResponse = JSON.parseObject(JSON.toJSONString(response.getDataResult()), FundFrozenResponse.class);
                responseVO.setCode(-1001);
                responseVO.setMessage(fundFrozenResponse.getErrorInfo());
            } else {
                responseVO.setCode(CrmCommonEnum.CodeType.ERROR_UNKNOWN.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.ERROR_UNKNOWN.getMessage());
            }

        }

        return responseVO;
    }

    /**
     * 客户取消出金申请
     *
     * @param request
     * @return
     */
    @RequestMapping("/fundWithdrawApplyCancel")
    @SystemLog(description = "取消出金申请")
    public
    @ResponseBody
    ResponseVO fundWithdrawApplyCancel(@RequestBody GenericSunlineRequest<ClientFundWithdrawApplyProto> request) {

        ResponseVO responseVO = new ResponseVO();
        try {
            ClientFundWithdrawApplyProto requestParams = request.getParams();

            if (StringUtils.isBlank(requestParams.getApplicationId())) {
                responseVO.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return responseVO;
            }

            ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(requestParams.getApplicationId());

            if (null == clientFundWithdrawApplyInfo) {
                responseVO.setCode(CrmCommonEnum.CodeType.ERROR.getCode());
                responseVO.setMessage("预约流水号不存在");
                return responseVO;
            }

            ProcessTaskDto processTaskDto = new ProcessTaskDto();
            List<Task> tasks = taskService.createTaskQuery().processDefinitionId(clientFundWithdrawApplyInfo.getDefid()).processInstanceId(clientFundWithdrawApplyInfo.getInstanceId()).list();
            for (Task task : tasks) {
                processTaskDto.setTaskId(task.getId());
            }

            // 终止出金申请流程
            processTaskDto.setBusId(clientFundWithdrawApplyInfo.getApplicationId());
            processTaskDto.setDefId(clientFundWithdrawApplyInfo.getDefid());
            processTaskDto.setActKey(CLIENT_FUND_WITHDRAW_FLOW_MODEL_KEY);
            processTaskDto.setInstanceId(clientFundWithdrawApplyInfo.getInstanceId());
            processTaskDto.setRemark("客户取消出金申请");

            clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getBackgroundWorkflowUser().getId());
            clientFundWithdrawApplyInfo.setCurrentNode(CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "6"));
            clientFundWithdrawApplyInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            clientFundWithdrawApplyInfo.setWithdrawStatus(BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_FAILURE_VALUE);
            clientFundWithdrawApplyInfo.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_APPROVAL_CANCEL_VALUE);

            clientFundWithdrawApplyService.updateProcessInfo(clientFundWithdrawApplyInfo, processTaskDto);

            actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());

            // 发送短信通知
            List<String> paramList = Lists.newArrayList();

            paramList.clear();
            paramList.add(clientFundWithdrawApplyInfo.getClientName() != null ? clientFundWithdrawApplyInfo.getClientName() : clientFundWithdrawApplyInfo.getClientNameSpell());
            paramList.add(clientFundWithdrawApplyInfo.getOccurBalance() + CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));

            // 发送短信
            clientFundWithdrawApplyService.generateFundWithdrawRetSendSms(2006, clientFundWithdrawApplyInfo.getPhoneNumber(), paramList);

            logger.info("客户[" + clientFundWithdrawApplyInfo.getClientId() + "]取消出金申请已成功处理");
            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

        } catch (Exception e) {
            logger.error("客户取消出金申请处理异常", e);
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        }

        return responseVO;
    }
}
