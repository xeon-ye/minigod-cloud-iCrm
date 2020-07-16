package com.sunline.modules.account.professional.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.account.online.entity.OpenAccountProcessLogEntity;
import com.sunline.modules.account.online.service.OpenAccountProcessLogService;
import com.sunline.modules.account.professional.entity.ProfessionalInvestorApplicationEntity;
import com.sunline.modules.account.professional.helper.ProfessionalApplyHelper;
import com.sunline.modules.account.professional.model.ProfessionalCancelListExportModel;
import com.sunline.modules.account.professional.model.ProfessionalInvestorApplicationModel;
import com.sunline.modules.account.professional.model.ProfessionalListExportModel;
import com.sunline.modules.account.professional.model.query.ProfessionalAppQueryModel;
import com.sunline.modules.account.professional.protocol.ProfessionalApplyResultRequest;
import com.sunline.modules.account.professional.service.ProfessionalInvestorApplicationService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.service.ExtendActTasklogService;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;
import com.sunline.modules.fund.service.ClientFundDepositImageService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.request.FundAccountRequest;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.service.CodeService;
import com.sunline.modules.sys.service.RoleService;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;


/**
 * 专业投资者认定申请信息表
 *
 * @author jim
 * @email jim@zszhizhu.com
 * @date 2019-12-04 11:31:49
 */
@Controller
@RequestMapping("professionalInvestor")
public class ProfessionalInvestorApplicationController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ProfessionalInvestorApplicationController.class);

    @Autowired
    private ProfessionalInvestorApplicationService professionalInvestorApplicationService;
    @Autowired
    ExtendActTasklogService tasklogService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    RoleService roleService;
    @Autowired
    CodeService codeService;
    @Autowired
    ClientFundDepositImageService imageService;
    @Autowired
    OpenAccountProcessLogService openAccountProcessLogService;
    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    SecUserInfoService secUserInfoService;
    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00#");

    /**
     * 总记录列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("professionalInvestor:list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ProfessionalInvestorApplicationEntity> entityList = professionalInvestorApplicationService.queryList(query);
        int total = professionalInvestorApplicationService.queryTotal(query);
        List<ProfessionalInvestorApplicationModel> modelList = new ArrayList<ProfessionalInvestorApplicationModel>(entityList.size());
        for (ProfessionalInvestorApplicationEntity entry : entityList) {
            ProfessionalInvestorApplicationModel model = new ProfessionalInvestorApplicationModel();
            BeanUtils.copyProperties(entry, model);
            model.setApplyTime(DateUtil.format(entry.getApplyTime(), "yyyy-MM-dd"));
            model.setAccreditTime(DateUtil.format(entry.getAccreditTime(), "yyyy-MM-dd"));
            model.setExpireTime(DateUtil.format(entry.getExpireTime(), "yyyy-MM-dd"));
            model.setRevokeTime(DateUtil.format(entry.getRevokeTime(), "yyyy-MM-dd"));
            model.setApplicationStatus(CodeUtils.getCodeName("PROFESSIONAL_APPLY_STATUS", String.valueOf(entry.getApplicationStatus())));
            modelList.add(model);
        }

        PageUtils pageUtil = new PageUtils(modelList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 跳转总记录列表
     */
    @RequestMapping("/listPage")
    @RequiresPermissions("professionalInvestor:list")
    public String listPage(Model model) {
        return "account/professional/professionalApplyList";
    }

    /**
     * 跳转可撤销列表
     */
    @RequestMapping("/listCancelPage")
    @RequiresPermissions("professionalInvestor:listCancel")
    public String listCancel(Model model) {
        return "account/professional/professionalCancelList";
    }


    /**
     * 查看/办理申请
     *
     * @param processTaskDto
     * @param model
     * @param flag           0-查看 1-审批 2-修改 3-撤销
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String clientFundDepositApprove(ProcessTaskDto processTaskDto, Model model, String flag) {
        ProfessionalInvestorApplicationEntity applyEntity = professionalInvestorApplicationService.queryByApplicationId(processTaskDto.getBusId());

        //设置凭证图片 3-资产凭证 4-补充凭证
        ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
        query.setApplicationId(processTaskDto.getBusId());

        query.setImageType(3);
        applyEntity.setAssetsImgs(imageService.queryListByBean(query));

        query.setImageType(4);
        applyEntity.setAddImgs(imageService.queryListByBean(query));

        if ("1".equals(flag)) {
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(processTaskDto.getBusId());
            model.addAttribute("taskDto", taskDto);

            //流程审批信息
            ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
            extendActTasklogEntity.setBusId(processTaskDto.getBusId());
            List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);
            tasklogList = professionalInvestorApplicationService.joinBackReasonType(tasklogList);
            model.addAttribute("taskLogs", tasklogList);
        }
        model.addAttribute("info", applyEntity);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        model.addAttribute("operationFlag", flag);
        return "account/professional/professionalApplyInfo";
    }

    /**
     * 审核列表
     */
    @RequestMapping("/checkList")
    @RequiresPermissions("professionalInvestor:checkList")
    public String checkList(ProfessionalAppQueryModel params, Model model, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        //根据当前角色所拥有权限进入
        try {
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("PROFESSIONAL_INVESTOR_MODEL_ID", null));
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
                params.setCurrentNodes(null);
            } else {
                params.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
            }

            String stDate = params.getApplyDateSt();
            String edDate = params.getApplyDateEd();
            if (StringUtils.isNotBlank(stDate)) {
                params.setApplyDateSt(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(stDate)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(edDate)) {
                params.setApplyDateEd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(edDate)), "yyyy-MM-dd HH:mm:ss"));
            }

            params.setAssignDrafter(UserUtils.getCurrentUserId());
            Page page = professionalInvestorApplicationService.queryCheckList(params, pageNum);

            if (StringUtils.isNotBlank(stDate)) {
                params.setApplyDateSt(DateUtil.format(DateUtil.parse(stDate), "yyyy-MM-dd"));
            }
            if (StringUtils.isNotBlank(edDate)) {
                params.setApplyDateEd(DateUtil.format(DateUtil.parse(edDate), "yyyy-MM-dd"));
            }

            model.addAttribute("page", page);
            model.addAttribute("params", params);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        } catch (Exception e) {
            logger.error("查看专业投资者审核列表异常", e);
        }
        return "account/professional/professionalCheckList";

    }

    /**
     * 可撤销列表
     */
    @RequestMapping("/listCancel")
    @RequiresPermissions("professionalInvestor:listCancel")
    @ResponseBody
    public Result listCancel(@RequestParam Map<String, Object> params) {
        params.put("applicationStatus", BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE);
        //查询列表数据
        Query query = new Query(params);

        List<ProfessionalInvestorApplicationEntity> entityList = professionalInvestorApplicationService.queryList(query);
        int total = professionalInvestorApplicationService.queryTotal(query);
        List<ProfessionalInvestorApplicationModel> modelList = new ArrayList<ProfessionalInvestorApplicationModel>(entityList.size());
        for (ProfessionalInvestorApplicationEntity entry : entityList) {
            ProfessionalInvestorApplicationModel model = new ProfessionalInvestorApplicationModel();
            BeanUtils.copyProperties(entry, model);
            model.setApplyTime(DateUtil.format(entry.getApplyTime(), "yyyy-MM-dd"));
            model.setAccreditTime(DateUtil.format(entry.getAccreditTime(), "yyyy-MM-dd"));
            model.setExpireTime(DateUtil.format(entry.getExpireTime(), "yyyy-MM-dd"));
            model.setRevokeTime(DateUtil.format(entry.getRevokeTime(), "yyyy-MM-dd"));
            model.setApplicationStatus(CodeUtils.getCodeName("PROFESSIONAL_APPLY_STATUS", String.valueOf(entry.getApplicationStatus())));
            modelList.add(model);
        }

        PageUtils pageUtil = new PageUtils(modelList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }

    /**
     * 流程信息详情
     *
     * @param model
     * @param busId
     * @param instanceId
     * @return
     */
    @RequestMapping(value = "/taskLogInfo", method = RequestMethod.POST)
    public String taskLogInfo(Model model, String busId, String instanceId) {

        ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
        extendActTasklogEntity.setBusId(busId);
        List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);
        tasklogList = professionalInvestorApplicationService.joinBackReasonType(tasklogList);

        model.addAttribute("taskLogs", tasklogList);
        model.addAttribute("instanceId", instanceId);

        return "account/professional/taskLogInfo";
    }

    /**
     * 跳转退回页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tobackView")
    public String tobackView(Model model, String remark, String applicationId, Integer applicationStatus) {
        try {
            List<CodeEntity> backTypes = codeService.queryChildsByMark("PROFESSIONA_BACK_TYPE");
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(applicationId);
            taskDto.setRemark(remark);
            model.addAttribute("taskDto", taskDto);
            model.addAttribute("applicationStatus", applicationStatus);
            Collections.reverse(backTypes);
            model.addAttribute("backTypes", backTypes);
        } catch (Exception e) {
            logger.error("跳转退回页面", e);
        }
        return "account/professional/doTaskBackView";
    }

    /**
     * 退回
     *
     * @param processTaskDto
     * @param backFlag       退回节点 1-退至客服 2-退回至客户
     * @return
     */
    @RequestMapping(value = "/doBack", method = RequestMethod.POST)
    @ResponseBody
    public Result doBack(ProcessTaskDto processTaskDto, String backFlag, String otherReasons, String backReasonType, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {
            boolean isSecceed = ProfessionalApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);
            if (isSecceed) {
                List<String> backReasonTypeList = JSON.parseArray(backReasonType, String.class);

                //拼接填写内容到其它理由后面
                for (String errorContentType : backReasonTypeList) {
                    if ("0".equals(errorContentType) && StringUtils.isNotBlank(otherReasons)) {
                        StringBuilder errorContent = new StringBuilder(backReasonType);
                        if (StringUtils.isNotBlank(otherReasons)) {
                            errorContent.insert(errorContent.indexOf("0") + 1, ",\"" + otherReasons + "\"");
                            backReasonType = errorContent.toString();
                        }
                    }
                }

                OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();

                //退回至客服
                if ("1".equals(backFlag)) {
                    actModelerService.backPreviousNode(processTaskDto);
                    openAccountProcessLog.setIsBackWorkflow(BpmCommonEnum.YesNo.YES.getIndex());
                }
                //退回至客户 即流程终止
                if ("2".equals(backFlag) || Utils.isEmpty(backFlag)) {
                    actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.TURN_BACK.getValue());
                    professionalInvestorApplicationService.terminateApply(processTaskDto,
                            BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_BACK_VALIUE,backReasonType);
                    openAccountProcessLog.setIsBackApp(BpmCommonEnum.YesNo.YES.getIndex());
                }
                //更新流程日志记录
                openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
                openAccountProcessLog.setBackReasonType(backReasonType);
                openAccountProcessLogService.updateByTaskId(openAccountProcessLog);

                //清空AssignDrafter
                ProfessionalInvestorApplicationEntity updateAssignDrafter = new ProfessionalInvestorApplicationEntity();
                updateAssignDrafter.setApplicationId(processTaskDto.getBusId());
                updateAssignDrafter.setAssignDrafter(null);
                updateAssignDrafter.setUpdateTime(new Date());
                professionalInvestorApplicationService.updateAssignDrafter(updateAssignDrafter);
                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

            } else {
                result = Result.error("操作失败");
            }
        } catch (Exception e) {
            logger.error("退回操作失败", e);
            result = Result.error("操作失败");
        }
        return result;
    }

    /**
     * 终止流程
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "/doTermination", method = RequestMethod.POST)
    @ResponseBody
    public Result doTermination(ProcessTaskDto processTaskDto, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {
            boolean isSecceed = ProfessionalApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);
            if (isSecceed) {
                OpenAccountProcessLogEntity openAccountProcessLog = new OpenAccountProcessLogEntity();
                //流程终止
                actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.TERMINATION.getValue());
                professionalInvestorApplicationService.terminateApply(processTaskDto,
                        BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_TERMINATION_VALIUE,null);
                openAccountProcessLog.setIsBackApp(BpmCommonEnum.YesNo.YES.getIndex());
                //更新流程日志记录
                openAccountProcessLog.setTaskId(Integer.valueOf(processTaskDto.getTaskId()));
                openAccountProcessLogService.updateByTaskId(openAccountProcessLog);

                //清空AssignDrafter
                ProfessionalInvestorApplicationEntity updateAssignDrafter = new ProfessionalInvestorApplicationEntity();
                updateAssignDrafter.setApplicationId(processTaskDto.getBusId());
                updateAssignDrafter.setAssignDrafter(null);
                updateAssignDrafter.setUpdateTime(new Date());
                professionalInvestorApplicationService.updateAssignDrafter(updateAssignDrafter);
                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

            } else {
                result = Result.error("操作失败");
            }
        } catch (Exception e) {
            logger.error("终止操作失败", e);
            result = Result.error("操作失败");
        }
        return result;
    }

    /**
     * 撤销专业投资者身份
     *
     * @param applicationId
     * @param revokeReson
     * @return
     */
    @RequestMapping(value = "/doRevoke", method = RequestMethod.POST)
    @ResponseBody
    public Result doRevoke(String applicationId, String revokeReson) {
        Result result = null;
        if (StringUtils.isBlank(applicationId)) {
            result = Result.error("预约号为空");
        }

        try {
            ProfessionalInvestorApplicationEntity applyEntity = professionalInvestorApplicationService.queryByApplicationId(applicationId);
            if (BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE != applyEntity.getApplicationStatus()) {
                return Result.error("该条申请当前状态为:" + CodeUtils.getCodeName("PROFESSIONAL_APPLY_STATUS", String.valueOf(applyEntity.getApplicationStatus())));
            }

            //先获取柜台状态
            ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
            if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
                SysArgResponse result1 = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
                if ("6".equals(result1.getSysStatus()) || "0".equals(result1.getBankStatus())) {
                    Result.error("柜台当前不可用");
                }
            } else {
                logger.info("获取柜台状态失败");
                Result.error("获取柜台状态失败");
            }

            FundAccountRequest.FundAccountGetRequest fundAccountGetRequest = new FundAccountRequest.FundAccountGetRequest();
            fundAccountGetRequest.setClientId(applyEntity.getClientId());
            fundAccountGetRequest.setFundAccount(Integer.valueOf(applyEntity.getFundAccount()));

            CommonResponse response = professionalInvestorApplicationService.sysApplyToHs(fundAccountGetRequest, 1);
            if (null != response && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(response.getCommonErrorCode().getErrorCode())) {
                //回调中台
                professionalInvestorApplicationService.pushFundDepositResult(new ProfessionalApplyResultRequest(applyEntity.getApplicationId(), BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_REVOKE_VALIUE, null));

                //短信通知
                List<String> paramList = Lists.newArrayList();
                paramList.add(StringUtils.isNotBlank(applyEntity.getClientName()) ? applyEntity.getClientName() : applyEntity.getClientNameSpell());
                professionalInvestorApplicationService.generateSendSms(2037, applyEntity.getPhoneNumber(), paramList);

                //更新securities_user_info表
                SecuritiesUserInfoEntity userInfo = new SecuritiesUserInfoEntity();
                userInfo.setUserId(applyEntity.getUserId());
                SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryByUserId(userInfo);
                if (null != userInfoEntity) {
                    SecuritiesUserModel request = new SecuritiesUserModel();
                    request.setTradeAccount(userInfoEntity.getTradeAccount());
                    request.setFundAccount(userInfoEntity.getFundAccount());
                    request.setIdKind(userInfoEntity.getIdKind());
                    request.setIdNo(userInfoEntity.getIdNo());
                    request.setRoomCode(1);
                    securitiesUserInfoService.modifySecuritiesUserInfo(request);
                }

//                //todo 邮件通知
//                Map<String, String> emailModel = Maps.newHashMap();
//                VelocityUtil.fillTemplate(VelocityUtil.PROFESSIONAL_INVERSTO_CANCEL_EMAIL_TEMPLATE, emailModel);
//                professionalInvestorApplicationService.generateSendEmail("","",userInfoEntity.getEmail());

                ProfessionalInvestorApplicationEntity update = new ProfessionalInvestorApplicationEntity();
                update.setApplicationId(applicationId);
                update.setApprovalOpinion(revokeReson);
                update.setRevokeTime(new Date());
                update.setLastApprovalUser(UserUtils.getCurrentUserId());
                update.setApplicationStatus(BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_REVOKE_VALIUE);
                update.setUpdateTime(new Date());
                professionalInvestorApplicationService.update(update);
                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
            } else {
                logger.info("专业投资者撤销失败，预约号：{}", applyEntity.getApplicationId());
                result = Result.error("操作失败");
            }

        } catch (Exception e) {
            logger.error("终止操作失败", e);
            result = Result.error("操作失败");
        }
        return result;
    }


    /**
     * 批量申领任务
     *
     * @param applicationIds
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batchApplyTaskHandle", method = RequestMethod.POST)
    @ResponseBody
    public Result batchApplyTaskHandle(String applicationIds, HttpServletRequest request) {
        Result result = null;
        if (StringUtils.isEmpty(applicationIds)) {
            return Result.error("没有勾选需要记录");
        }
        int succ = 0;
        try {
            StringBuilder currentNodes = new StringBuilder();
            Map<String, List<String>> modelNodeRoleList;
            // 根据当前角色查询审核任务
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("PROFESSIONAL_INVESTOR_MODEL_ID", null));

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
            parms.setTableName("professional_investor_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);
            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                ProfessionalInvestorApplicationEntity applyEntity = professionalInvestorApplicationService.queryByApplicationId(processTaskDto.getBusId());
                // 超级管理员不做权限验证，判断当前用户审核权限
                if (!currentNodes.toString().contains(applyEntity.getCurrentNode()) && !UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                // 校验任务是否已被申领
                if(StringUtils.isNotBlank(applyEntity.getAssignDrafter())){
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                result = actModelerService.applyTaskHandle(processTaskDto, UserUtils.getCurrentUserId());
                if ("0".equals(result.get("code"))) {
                    // 更新申请表指定处理人
                    ProfessionalInvestorApplicationEntity updateAssignDrafter = new ProfessionalInvestorApplicationEntity();
                    updateAssignDrafter.setApplicationId(applyEntity.getApplicationId());
                    updateAssignDrafter.setAssignDrafter(UserUtils.getCurrentUserId());
                    updateAssignDrafter.setUpdateTime(new Date());
                    professionalInvestorApplicationService.updateAssignDrafter(updateAssignDrafter);
                    succ++;
                } else {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                }
            }
            if (!StringUtils.isEmpty(errorMsg)) {
                errorMsg.append("任务已被申请办理!!");
                return Result.error("成功申领" + succ + "条记录!" + errorMsg.toString());
            }
        } catch (Exception e) {
            return Result.error("申请办理任务失败");
        }
        result = Result.ok("成功申领" + succ + "条记录!");
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
        int succ = 0;

        ProcessTaskDto parms = new ProcessTaskDto();
        parms.setBusId(applicationIds);
        parms.setTableName("professional_investor_application");
        List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);
        for (ProcessTaskDto processTaskDto : processTaskDtoList) {
            try {
                result = actModelerService.deliverTaskHandle(processTaskDto);

                // 更新申请表指定处理人
                ProfessionalInvestorApplicationEntity updateAssignDrafter = new ProfessionalInvestorApplicationEntity();
                updateAssignDrafter.setApplicationId(processTaskDto.getBusId());
                updateAssignDrafter.setAssignDrafter(null);
                updateAssignDrafter.setUpdateTime(new Date());
                professionalInvestorApplicationService.updateAssignDrafter(updateAssignDrafter);
                succ++;
            } catch (Exception e) {
                logger.error("批量释放办理任务异常", e);
                result = Result.error("释放失败");
            }
        }
        result = Result.ok("成功释放" + succ + "条记录!");
        return result;
    }

    /**
     * 专业投资者列表导出
     *
     * @param params
     * @param response
     * @return
     */
    @RequestMapping("/export")
    @RequiresPermissions("professionalInvestor:export")
    public void export(ProfessionalAppQueryModel params, HttpServletResponse response) {
        Map query = new BeanMap(params);

        try {
            if (StringUtils.isNotBlank(params.getApplyDateSt())) {
                params.setApplyDateSt(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(params.getApplyDateSt())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getApplyDateEd())) {
                params.setApplyDateEd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(params.getApplyDateEd())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getAccreditDateSt())) {
                params.setAccreditDateSt(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(params.getAccreditDateSt())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getAccreditDateEd())) {
                params.setAccreditDateEd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(params.getAccreditDateEd())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getExpireDateSt())) {
                params.setExpireDateSt(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(params.getExpireDateSt())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getExpireDateEd())) {
                params.setExpireDateEd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(params.getExpireDateEd())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getRevokeDateSt())) {
                params.setRevokeDateSt(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(params.getRevokeDateSt())), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(params.getRevokeDateEd())) {
                params.setRevokeDateEd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(params.getRevokeDateEd())), "yyyy-MM-dd HH:mm:ss"));
            }

            if ("1".equals(params.getFlag())) {
                List<ProfessionalInvestorApplicationEntity> entityList = professionalInvestorApplicationService.queryList(query);
                List<ProfessionalListExportModel> infoExportModels = Lists.newArrayList();
                entityList.forEach(entry->{
                    ProfessionalListExportModel model = new ProfessionalListExportModel();
                    BeanUtils.copyProperties(entry, model);
                    model.setApplyTime(DateUtil.format(entry.getApplyTime(), "yyyy-MM-dd"));
                    model.setAccreditTime(DateUtil.format(entry.getAccreditTime(), "yyyy-MM-dd"));
                    model.setExpireTime(DateUtil.format(entry.getExpireTime(), "yyyy-MM-dd"));
                    model.setRevokeTime(DateUtil.format(entry.getRevokeTime(), "yyyy-MM-dd"));
                    model.setApplicationStatus(CodeUtils.getCodeName("PROFESSIONAL_APPLY_STATUS", String.valueOf(entry.getApplicationStatus())));
                    infoExportModels.add(model);
                });
                EasyExcelUtils.exportXlsxFile(infoExportModels, response, ProfessionalListExportModel.class, "专业投资者记录" + DateUtil.format(new Date(), "dd/MM/yy"));

            } else if ("2".equals(params.getFlag())) {
                query.put("applicationStatus", BpmCommonEnum.ProfessionalApplicationStatus.PROFESSIONAL_APPLY_STATUS_SUCCESS_VALIUE);
                List<ProfessionalInvestorApplicationEntity> entityList = professionalInvestorApplicationService.queryList(query);
                List<ProfessionalCancelListExportModel> infoExportModels = Lists.newArrayList();
                entityList.forEach(entry->{
                    ProfessionalCancelListExportModel model = new ProfessionalCancelListExportModel();
                    BeanUtils.copyProperties(entry, model);
                    model.setApplyTime(DateUtil.format(entry.getApplyTime(), "yyyy-MM-dd"));
                    model.setAccreditTime(DateUtil.format(entry.getAccreditTime(), "yyyy-MM-dd"));
                    model.setExpireTime(DateUtil.format(entry.getExpireTime(), "yyyy-MM-dd"));
                    infoExportModels.add(model);
                });
                EasyExcelUtils.exportXlsxFile(infoExportModels, response, ProfessionalCancelListExportModel.class, "专业投资者" + DateUtil.format(new Date(), "dd/MM/yy"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
