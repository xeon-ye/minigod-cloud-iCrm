package com.sunline.modules.fund.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.service.ExtendActTasklogService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import com.sunline.modules.fund.entity.FundWithdrawRefundApplyEntity;
import com.sunline.modules.fund.entity.HsCompanyBankEntity;
import com.sunline.modules.fund.helper.ClientFundWithdrawApplyHelper;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyDealModel;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyModel;
import com.sunline.modules.fund.model.ClientWithfrawRefundExportModel;
import com.sunline.modules.fund.service.ClientFundWithdrawApplyService;
import com.sunline.modules.fund.service.FundWithdrawRefundApplyService;
import com.sunline.modules.fund.service.HsCompanyBankService;
import com.sunline.modules.hundsun.protocol.request.FundRequest;
import com.sunline.modules.hundsun.service.HsFundManageService;
import com.sunline.modules.stock.entity.HsFundEntity;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.service.CodeService;
import com.sunline.modules.sys.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 客户出金退款申请表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-05-23 13:23:38
 */
@Controller
@RequestMapping("fundWithdrawRefund")
public class FundWithdrawRefundApplyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(FundWithdrawRefundApplyController.class);

    @Autowired
    private FundWithdrawRefundApplyService fundWithdrawRefundApplyService;
    @Autowired
    private ClientFundWithdrawApplyService clientFundWithdrawApplyService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    RoleService roleService;
    @Autowired
    CodeService codeService;
    @Autowired
    HsCompanyBankService hsCompanyBankService;
    @Autowired
    ExtendActTasklogService tasklogService;

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####################0.00");

    /**
     * 发起退款申请
     *
     * @param applicationId
     * @return
     */
    @RequestMapping("/doRefund")
    public
    @ResponseBody
    Result doRefund(String applicationId) {

        Result result = null;

        try {
            FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity = new FundWithdrawRefundApplyEntity();
            fundWithdrawRefundApplyEntity.setWithdrawApplicationId(applicationId);

            String retApplicationId = fundWithdrawRefundApplyService.commitFundWithdrawRefundApply(fundWithdrawRefundApplyEntity);

            if (StringUtils.isNotBlank(retApplicationId)) {
                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setApplicationId(applicationId);
                clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_REFUND_PROGRESS_VALUE);

                int count = clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);

                if (count > 0) {

                    FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(retApplicationId);

                    // 驱动流程下一步
                    actModelerService.doNextFlow(fundWithdrawRefundApplyInfo.getApplicationId(), fundWithdrawRefundApplyInfo.getInstanceId(), "");

                    result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
                }
            }
        } catch (Exception e) {
            logger.error("发起退款申请任务异常", e);
            return Result.error("发起退款申请任务异常");
        }
        return result;
    }

    /**
     * 出金退款申请列表查询
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("fundWithdrawRefund:list")
    public String list(Model model, FundWithdrawRefundApplyEntity queryCondition, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<FundWithdrawRefundApplyEntity> page = fundWithdrawRefundApplyService.findPage(queryCondition, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("params", queryCondition);

        return "fund/refund/fundWithdrawRefundList";
    }

    /**
     * 出金退款申请记录导出
     *
     * @param fundWithdrawRefundApplyEntity
     * @param request
     * @param response
     */
    @RequestMapping(value = "/expList")
    @RequiresPermissions("fundWithdrawRefund:expList")
    @SysLog("出金申请记录导出")
    public void expList(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity, HttpServletRequest request, HttpServletResponse response) {

        try {

            List<FundWithdrawRefundApplyEntity> fundWithdrawRefundApplyList = fundWithdrawRefundApplyService.queryList(fundWithdrawRefundApplyEntity);

            List<ClientFundWithdrawApplyModel> modelList = Lists.newArrayList();

            for (FundWithdrawRefundApplyEntity undWithdrawRefundApplyInfo : fundWithdrawRefundApplyList) {

                ClientFundWithdrawApplyModel model = new ClientFundWithdrawApplyModel();

                model.setCreateTime(DateUtil.format(undWithdrawRefundApplyInfo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                model.setUserId(String.valueOf(undWithdrawRefundApplyInfo.getUserId()));
                model.setClientId(undWithdrawRefundApplyInfo.getClientId());
                model.setFundAccount(undWithdrawRefundApplyInfo.getFundAccount());
                model.setClientName(undWithdrawRefundApplyInfo.getClientName());
                model.setClientNameSpell(undWithdrawRefundApplyInfo.getClientNameSpell());
                model.setSex(CodeUtils.getCodeName("COMMON_SEX", String.valueOf(undWithdrawRefundApplyInfo.getSex())));
                model.setPhoneNumber(undWithdrawRefundApplyInfo.getPhoneNumber());
                model.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(undWithdrawRefundApplyInfo.getMoneyType())));
                model.setOccurBalance(DECIMAL_FORMAT.format(undWithdrawRefundApplyInfo.getOccurBalance()));
//                model.setWithdrawType(CodeUtils.getCodeName("FUND_BANK_TYPE", String.valueOf(clientFundWithdrawApplyInfo.getWithdrawType())));
                model.setBankName(undWithdrawRefundApplyInfo.getBankName());
                model.setSourceChannelId(String.valueOf(undWithdrawRefundApplyInfo.getSourceChannelId()));
                model.setApplicationStatus(CodeUtils.getCodeName("FUND_WITHDRAW_REFUND_STATUS", String.valueOf(undWithdrawRefundApplyInfo.getApplicationStatus())));
                model.setChargeMoney(DECIMAL_FORMAT.format(undWithdrawRefundApplyInfo.getChargeMoney()));
                model.setActualBalance(DECIMAL_FORMAT.format(undWithdrawRefundApplyInfo.getActualBalance()));
                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientFundWithdrawApplyModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 出金退款处理记录导出
     *
     * @param fundWithdrawRefundApplyEntity
     * @param request
     * @param response
     */
    @RequestMapping(value = "/expDealList")
    @RequiresPermissions("fundWithdrawRefund:expDealList")
    @SysLog("出金退款处理记录导出")
    public void expDealList(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity, HttpServletRequest request, HttpServletResponse response) {

        try {

            fundWithdrawRefundApplyEntity.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_REFUND_MODEL_ID", null));
            List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
            for (String key : modelNodeRoleList.keySet()) {
                List<String> modelNodeRole = modelNodeRoleList.get(key);
                for (String aModelNodeRole : modelNodeRole) {
                    for (RoleEntity role : roleList) {
                        if (role.getId().equals(aModelNodeRole)) {
                            currentNodes.add(key);
                        }
                    }
                }
            }

            //超级管理员不做权限验证
            if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                fundWithdrawRefundApplyEntity.setCurrentNode(null);
            } else {
                fundWithdrawRefundApplyEntity.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
            }

            fundWithdrawRefundApplyEntity.setAssignDrafter(UserUtils.getCurrentUserId());

            List<FundWithdrawRefundApplyEntity> fundWithdrawRefundApplyList = fundWithdrawRefundApplyService.queryAuditList(fundWithdrawRefundApplyEntity);

            List<ClientWithfrawRefundExportModel> modelList = Lists.newArrayList();
            StringBuilder applicationIdsBuilder = new StringBuilder();

            for (FundWithdrawRefundApplyEntity clientFundWithdrawApplyInfo : fundWithdrawRefundApplyList) {

                applicationIdsBuilder.append(clientFundWithdrawApplyInfo.getApplicationId()).append(",");

                ClientWithfrawRefundExportModel model = new ClientWithfrawRefundExportModel();

                model.setClientId(clientFundWithdrawApplyInfo.getClientId());
                model.setClientNameSpell(clientFundWithdrawApplyInfo.getClientNameSpell());
                model.setCcy(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                model.setOccurBalance(String.valueOf(clientFundWithdrawApplyInfo.getActualBalance()));
                model.setEmptyField1("");
                model.setCcy1(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                model.setFrozenBalance(String.valueOf(clientFundWithdrawApplyInfo.getActualBalance()));
                model.setEmptyField2("");
                model.setEmptyField3("");
                model.setParticulars("出金" + "-" + clientFundWithdrawApplyInfo.getBankName() + "-" + clientFundWithdrawApplyInfo.getBankNo());
                model.setEmptyField4("");
                modelList.add(model);

                BigDecimal chargeMoney = clientFundWithdrawApplyInfo.getChargeMoney();
                if(chargeMoney!=null && chargeMoney.compareTo(new BigDecimal(0))>0){
                    ClientWithfrawRefundExportModel chargeModel = new ClientWithfrawRefundExportModel();
                    chargeModel.setClientId(clientFundWithdrawApplyInfo.getClientId());
                    chargeModel.setClientNameSpell(clientFundWithdrawApplyInfo.getClientNameSpell());
                    chargeModel.setCcy(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                    chargeModel.setOccurBalance(String.valueOf(clientFundWithdrawApplyInfo.getChargeMoney()));
                    chargeModel.setEmptyField1("");
                    chargeModel.setCcy1(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                    chargeModel.setFrozenBalance(String.valueOf(clientFundWithdrawApplyInfo.getChargeMoney()));
                    chargeModel.setEmptyField2("");
                    chargeModel.setEmptyField3("");
                    chargeModel.setParticulars("FUND WITHDRAWAL FEE REFUND-"+clientFundWithdrawApplyInfo.getClientId());
                    chargeModel.setEmptyField4("");
                    modelList.add(chargeModel);
                }
            }

            String applicationIds = "";

            if (StringUtils.isNotBlank(applicationIdsBuilder.toString())) {
                applicationIds = applicationIdsBuilder.substring(0, applicationIdsBuilder.length() - 1);
            }

            if (StringUtils.isNotBlank(applicationIds)) {
                clientFundWithdrawApplyService.updateBatchByApplicationIds(applicationIds);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientWithfrawRefundExportModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 查看/办理出金退款申请
     *
     * @param processTaskDto
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approve(ProcessTaskDto processTaskDto, Model model, String flag) {

        FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(processTaskDto.getBusId());

        GenericHsRequest<FundRequest> requestGenericHsRequest = new GenericHsRequest<>();
        FundRequest fundRequest = new FundRequest();
        fundRequest.setFundAccount(fundWithdrawRefundApplyInfo.getFundAccount());
        fundRequest.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(fundWithdrawRefundApplyInfo.getMoneyType())));
        requestGenericHsRequest.setParams(fundRequest);

        ResponseVO responseVO = HsFundManageService.getFundTotal(requestGenericHsRequest);

        if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
            HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
            fundWithdrawRefundApplyInfo.setCurrentBalance(hsFundEntity.getSpecialFetchBalance());
        }

        boolean operationFlag = false;

        if ("1".equals(flag)) {
            operationFlag = true;
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(processTaskDto.getBusId());
            model.addAttribute("taskDto", taskDto);
        }

        model.addAttribute("info", fundWithdrawRefundApplyInfo);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        model.addAttribute("operationFlag", operationFlag);

        if ("1".equals(flag)) {
            return "fund/refund/fundWithdrawRefundAuditInfo";
        } else {
            return "fund/refund/fundWithdrawRefundInfo";
        }
    }

    /**
     * 审核列表
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/checkAuditList")
    @RequiresPermissions("fundWithdrawRefund:checkAuditList")
    public String checkAuditList(Model model, FundWithdrawRefundApplyEntity queryCondition, HttpServletRequest request) {

        try {

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            queryCondition.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_REFUND_MODEL_ID", null));
            List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
            for (String key : modelNodeRoleList.keySet()) {
                List<String> modelNodeRole = modelNodeRoleList.get(key);
                for (String aModelNodeRole : modelNodeRole) {
                    for (RoleEntity role : roleList) {
                        if (role.getId().equals(aModelNodeRole)) {
                            currentNodes.add(key);
                        }
                    }
                }
            }

            //超级管理员不做权限验证
            if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                queryCondition.setCurrentNode(null);
            } else {
                queryCondition.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
            }

            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<FundWithdrawRefundApplyEntity> page = fundWithdrawRefundApplyService.queryAuditList(queryCondition, pageNum);

            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        } catch (Exception e) {
            logger.error("查看出金退款审核列表异常", e);
        }

        return "fund/refund/fundWithdrawRefundAuditList";
    }

    /**
     * 批量申领任务
     *
     * @param applicationIds
     * @param toUserId
     * @param actKey
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batchApplyTaskHandle", method = RequestMethod.POST)
    @ResponseBody
    public Result batchApplyTaskHandle(String applicationIds, String toUserId, String actKey, HttpServletRequest request) {

        Result result = null;

        try {

            if (StringUtils.isEmpty(applicationIds)) {
                throw new MyException("没有勾选需要记录");
            }

            StringBuilder currentNodes = new StringBuilder();

            Map<String, List<String>> modelNodeRoleList;

            // 根据当前角色查询审核任务
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_REFUND_MODEL_ID", null));

            List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
            for (String key : modelNodeRoleList.keySet()) {
                List<String> modelNodeRole = modelNodeRoleList.get(key);
                for (String aModelNodeRole : modelNodeRole) {
                    for (RoleEntity role : roleList) {
                        if (role.getId().equals(aModelNodeRole)) {
                            currentNodes.append(key).append(",");
                        }
                    }
                }
            }

            StringBuffer errorMsg = new StringBuffer();

            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("fund_withdraw_refund_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(processTaskDto.getBusId());

                // 超级管理员不做权限验证，判断当前用户审核权限
                if (!currentNodes.toString().contains(fundWithdrawRefundApplyInfo.getCurrentNode()) && !UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                // 校验任务是否已被申领
                if(StringUtils.isNotBlank(fundWithdrawRefundApplyInfo.getAssignDrafter())){
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                result = actModelerService.applyTaskHandle(processTaskDto, UserUtils.getCurrentUserId());
                if ("0".equals(result.get("code"))) {
                    // 更新申请表指定处理人
                    fundWithdrawRefundApplyInfo.setAssignDrafter(UserUtils.getCurrentUserId());
                    fundWithdrawRefundApplyInfo.setUpdateTime(new Date());
                    fundWithdrawRefundApplyService.updateAssignDrafter(fundWithdrawRefundApplyInfo);
                } else {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                }
            }
            if (!StringUtils.isEmpty(errorMsg)) {
                errorMsg.append("任务已被申请办理");
                return Result.error(errorMsg.toString());
            }
        } catch (Exception e) {
            logger.error("批量申请办理任务异常", e);
            return Result.error("申请办理任务失败");
        }
        return result;
    }

    /**
     * 跳转拒绝页面
     *
     * @param
     * @return
     */
    @RequestMapping("/goRejectView")
    public String goRejectView(String busId, String taskId, String defId, String instanceId, String remark, Model model) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(busId);

        List<CodeEntity> fundWithdrawRejectTypes = codeService.queryChildsByMark("FUND_WITHDRAW_REFUND_REJECT_TYPE");

        model.addAttribute("withdrawRefundRejectTypes", fundWithdrawRejectTypes);
        model.addAttribute("info", fundWithdrawRefundApplyInfo);
        model.addAttribute("taskDto", taskDto);
        return "fund/refund/doTaskRejectView";
    }

    /**
     * 流程终止
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doReject")
    public
    @ResponseBody
    Result doReject(ProcessTaskDto processTaskDto, HttpServletRequest request) {

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(processTaskDto.getBusId());

                fundWithdrawRefundApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

                fundWithdrawRefundApplyService.terminateApplication(fundWithdrawRefundApplyInfo, processTaskDto);

                actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());

                // 更新出金申请记录
                ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity = new ClientFundWithdrawApplyEntity();
                clientFundWithdrawApplyEntity.setApplicationId(fundWithdrawRefundApplyInfo.getWithdrawApplicationId());
                clientFundWithdrawApplyEntity.setApplicationStatus(BpmCommonEnum.FundWithdrawApplicationStatus.FUND_WITHDRAW_APPLY_STATUS_SUCCESS_VALUE);
                clientFundWithdrawApplyEntity.setUpdateTime(new Date());

                clientFundWithdrawApplyService.updateByApplicationId(clientFundWithdrawApplyEntity);

                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

            } else {
                result = Result.error("操作失败");
            }
        } catch (Exception e) {
            logger.error("拒绝失败", e);
            result = Result.error("操作失败");
        }

        return result;
    }

    /**
     * 跳转退款入账页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param model
     * @return
     */
    @RequestMapping("/goRefundView")
    public String goWithdrawSucView(String busId, String taskId, String defId, String instanceId, String remark, Model model, HttpServletRequest request) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(busId);

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<HsCompanyBankEntity> page = hsCompanyBankService.findPage(new HsCompanyBankEntity(), pageNum);

        model.addAttribute("info", fundWithdrawRefundApplyInfo);
        model.addAttribute("taskDto", taskDto);
        model.addAttribute("page", page);
        return "fund/refund/doTaskWithdrawRefundView";
    }

    /**
     * 退款入账
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doRefundSuc")
    public
    @ResponseBody
    Result doRefundSuc(ProcessTaskDto processTaskDto, String itemId, Integer refundType, String currencyType, BigDecimal netRefundAmount, BigDecimal refundAmount, BigDecimal refundBankFee, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(processTaskDto.getBusId());

                if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "1").equals(String.valueOf(refundType))) {
                    if(refundAmount.compareTo(fundWithdrawRefundApplyInfo.getOccurBalance()) > 0){
                        result = Result.error("退款金额不能大于出金金额");
                        return result;
                    }
                }

                if (CodeUtils.getCodeValue("WITHDRAW_REFUND_DOPOSIT_TYPE", "2").equals(String.valueOf(refundType))) {
                    if(netRefundAmount.compareTo(fundWithdrawRefundApplyInfo.getOccurBalance()) > 0){
                        result = Result.error("退款净金额不能大于出金金额");
                        return result;
                    }
                }

                HsCompanyBankEntity hsCompanyBankEntity = hsCompanyBankService.queryObject(Long.parseLong(itemId));

                fundWithdrawRefundApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());
                fundWithdrawRefundApplyInfo.setHsBankId(hsCompanyBankEntity.getBankId());
                fundWithdrawRefundApplyInfo.setHsBankAccount(hsCompanyBankEntity.getBankAccount());
                fundWithdrawRefundApplyInfo.setRefundType(refundType);
                fundWithdrawRefundApplyInfo.setCurrencyType(currencyType);
                fundWithdrawRefundApplyInfo.setNetRefundAmount(netRefundAmount);
                fundWithdrawRefundApplyInfo.setRefundAmount(refundAmount);
                fundWithdrawRefundApplyInfo.setRefundBankFee(refundBankFee);
                fundWithdrawRefundApplyInfo.setUpdateTime(new Date());

                fundWithdrawRefundApplyService.update(fundWithdrawRefundApplyInfo);

                actModelerService.doActTask(processTaskDto, params);

                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
            } else {
                result = Result.error("操作失败");
            }

        } catch (Exception e) {
            logger.error("操作失败", e);
            result = Result.error("办理任务失败");
        }

        return result;
    }

    /**
     * 批量释放办理任务
     *
     * @param applicationIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/deliverApplyTask", method = RequestMethod.POST)
    @ResponseBody
    public Result deliverApplyTask(String applicationIds, HttpServletRequest request) {
        Result result = null;
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("未勾选已申领任务！");
        }

        ProcessTaskDto parms=new ProcessTaskDto();
        parms.setBusId(applicationIds);
        parms.setTableName("fund_withdraw_refund_application");
        List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);
        for (ProcessTaskDto processTaskDto : processTaskDtoList) {
            try {
                result = actModelerService.deliverTaskHandle(processTaskDto);

                // 更新申请表指定处理人

                FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(processTaskDto.getBusId());

                fundWithdrawRefundApplyInfo.setAssignDrafter(null);
                fundWithdrawRefundApplyInfo.setUpdateTime(new Date());
                fundWithdrawRefundApplyService.updateAssignDrafter(fundWithdrawRefundApplyInfo);

            } catch (Exception e) {
                logger.error("批量释放办理任务异常", e);
                result = Result.error("释放失败");
            }
        }
        return result;
    }

    /**
     * 流程信息详情
     *
     * @param model
     * @param request
     * @param busId
     * @param instanceId
     * @return
     */
    @RequestMapping(value = "/taskLogInfo", method = RequestMethod.POST)
    public String taskLogInfo(Model model, HttpServletRequest request, String busId, String instanceId) {

        FundWithdrawRefundApplyEntity fundWithdrawRefundApplyInfo = fundWithdrawRefundApplyService.queryByApplicationId(busId);

        ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
        extendActTasklogEntity.setBusId(busId);
        List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);

        // 获取历史流程信息
        extendActTasklogEntity.setBusId(fundWithdrawRefundApplyInfo.getWithdrawApplicationId());
        List<ExtendActTasklogEntity> tasklogHisList = tasklogService.queryListProcessLog(extendActTasklogEntity);

        model.addAttribute("taskLogs", tasklogList);
        model.addAttribute("tasklogHis", tasklogHisList);
        model.addAttribute("instanceId", instanceId);

        return "fund/refund/taskLogInfo";
    }
}
