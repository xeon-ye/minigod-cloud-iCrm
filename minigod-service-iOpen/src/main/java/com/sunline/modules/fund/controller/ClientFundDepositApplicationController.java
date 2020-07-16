package com.sunline.modules.fund.controller;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.util.StringUtil;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenImgEntity;
import com.sunline.modules.account.online.service.CustomerAccOpenImageService;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.service.ExtendActTasklogService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.RRException;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.fund.entity.*;
import com.sunline.modules.fund.helper.ClientFundDepositApplyHelper;
import com.sunline.modules.fund.helper.ClientFundWithdrawApplyHelper;
import com.sunline.modules.fund.model.ClientFundDepositEntryExportModel;
import com.sunline.modules.fund.model.ClientFundDepositInfoExportModel;
import com.sunline.modules.fund.service.*;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 客户入金申请信息表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
@Controller
@RequestMapping("clientFundDeposit")
public class ClientFundDepositApplicationController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ClientFundDepositApplicationController.class);
    @Autowired
    private ClientFundDepositApplicationService clientFundDepositApplicationService;
    @Autowired
    ClientFundDepositImageService depositImageService;
    @Autowired
    DepositBankBillFlowService bankBillFlowService;
    @Autowired
    ExtendActTasklogService tasklogService;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    RoleService roleService;
    @Autowired
    CodeService codeService;
    @Autowired
    HsCompanyBankService hsCompanyBankService;
    @Autowired
    private ClientBankCardInfoService clientBankCardInfoService;
    @Autowired
    private CustomerAccOpenImageService customerAccountOpenImageService;

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00#");

    /**
     * 入金申请列表查询
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("clientFundDeposit:list")
    public String list(Model model, ClientFundDepositApplicationEntity queryCondition, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
//        String benefitBank = queryCondition.getBenefitBank();
//        if (StringUtils.isNotEmpty(benefitBank)) {
//            queryCondition.setBenefitBank(CodeUtils.getCodeName("FUND_DEPOSIT_BANK", benefitBank));
//        }
        String clientNameSpell = queryCondition.getClientNameSpell();
        if (StringUtils.isNotEmpty(clientNameSpell)) {
            queryCondition.setClientNameSpell(clientNameSpell.replace(" ", ""));
        }

        String beginTime = queryCondition.getBeginTime();
        String endTime = queryCondition.getEndTime();
        if (StringUtils.isNotBlank(beginTime)) {
            queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(beginTime)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(endTime)) {
            queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(endTime)), "yyyy-MM-dd HH:mm:ss"));
        }

        String entryStTime = queryCondition.getEntryStTime();
        String entryEdTime = queryCondition.getEntryEdTime();
        if (StringUtils.isNotBlank(entryStTime)) {
            queryCondition.setEntryStTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(entryStTime)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (StringUtils.isNotBlank(entryEdTime)) {
            queryCondition.setEntryEdTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(entryEdTime)), "yyyy-MM-dd HH:mm:ss"));
        }

        Page<ClientFundDepositApplicationEntity> page = clientFundDepositApplicationService.queryInfoList(queryCondition, pageNum);
        for (ClientFundDepositApplicationEntity e : page.getResult()) {
            ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
            query.setApplicationId(e.getApplicationId());
            //客户凭证
            query.setImageType(0);
            e.setDespositImage(depositImageService.queryListByBean(query));
            //银行凭证
            query.setImageType(1);
            e.setBankImage(depositImageService.queryListByBean(query));
            //设置开户途径
            String type = e.getOpenAccountType();
            String open = "";
            if (StringUtils.isNotEmpty(type)) {
                if ("0".equals(type)) {
                    open = "未知";
                } else if ("1".equals(type)) {
                    open = "互联网开户";
                    String bankType = e.getBankType();
                    if ("0".equals(bankType)) {
                        open = "香港银行卡";
                    } else if ("1".equals(bankType) && e.getOpenAccountTime().getTime() < DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                        open = "大陆银行卡";
                    } else if ("1".equals(bankType) && e.getOpenAccountTime().getTime() > DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                        open = "SZCA电子证书";
                    }
                } else if ("2".equals(type)) {
                    open = "线下开户";
                } else if ("3".equals(type)) {
                    open = "BPM开户";
                }
            }
            e.setOpenAccountType(open);
        }
        queryCondition.setClientNameSpell(clientNameSpell);
        queryCondition.setBeginTime(beginTime);
        queryCondition.setEndTime(endTime);
        queryCondition.setEntryStTime(entryStTime);
        queryCondition.setEntryEdTime(entryEdTime);
//        queryCondition.setBenefitBank(benefitBank);
        model.addAttribute("page", page);
        model.addAttribute("params", queryCondition);

        return "fund/deposit/fundDepositInfoList";
    }

    /**
     * 查看/办理/修改入金申请
     *
     * @param processTaskDto
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping(value = "/clientFundDepositApprove", method = RequestMethod.POST)
    public String clientFundDepositApprove(ProcessTaskDto processTaskDto, Model model, String flag) {

        ClientFundDepositApplicationEntity applicationEntity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());
        //设置开户途径
        String type = applicationEntity.getOpenAccountType();
        String open = "";
        if (StringUtils.isNotEmpty(type)) {
            if ("0".equals(type)) {
                open = "未知";
            } else if ("1".equals(type)) {
                open = "互联网开户";
                String bankType = applicationEntity.getBankType();
                if ("0".equals(bankType)) {
                    open = "香港银行卡";
                } else if ("1".equals(bankType) && applicationEntity.getOpenAccountTime().getTime() < DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                    open = "大陆银行卡";
                } else if ("1".equals(bankType) && applicationEntity.getOpenAccountTime().getTime() > DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                    open = "SZCA电子证书";
                }
            } else if ("2".equals(type)) {
                open = "线下开户";
            } else if ("3".equals(type)) {
                open = "BPM开户";
            }
        }
        applicationEntity.setOpenAccountType(open);
        //设置客户凭证
        ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
        query.setApplicationId(processTaskDto.getBusId());
        //客户凭证
        query.setImageType(0);
        applicationEntity.setDespositImage(depositImageService.queryListByBean(query));
        query.setImageType(1);
        applicationEntity.setBankImage(depositImageService.queryListByBean(query));

        //开户图片
        List<CustomerAccountOpenImgEntity> openImgs = Lists.newArrayList();
        if (StringUtils.isNotBlank(applicationEntity.getOpenApplicationId())) {
            List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccountOpenImageService.queryByAccountOpenInfoId(applicationEntity.getOpenApplicationId());
            for (CustomerAccountOpenImgEntity openImg : customerAccountOpenImages) {
                if (openImg.getImageLocationType() == 201) {
                    openImgs.add(openImg);
                }
            }
        }

        if ("0".equals(flag) || ("1".equals(flag) && applicationEntity.getApplicationStatus() == 4)) {
            ClientBankCardInfoEntity queryCondition = new ClientBankCardInfoEntity();
            queryCondition.setStatus(1);
            queryCondition.setClientId(applicationEntity.getClientId());
            queryCondition.setFundAccount(applicationEntity.getFundAccount());
            List<ClientBankCardInfoEntity> cardInfoEntities = clientBankCardInfoService.queryListByBean(queryCondition);
            model.addAttribute("cards", cardInfoEntities);
        }

        if ("1".equals(flag)) {
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(processTaskDto.getBusId());
            model.addAttribute("taskDto", taskDto);
        }
        model.addAttribute("info", applicationEntity);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        model.addAttribute("operationFlag", flag);
        model.addAttribute("bankCards", openImgs);
        //添加DBS 审核流水
        DepositBankBillFlowEntity depositBankBillFlow = new DepositBankBillFlowEntity();
        depositBankBillFlow.setReferenceNo(applicationEntity.getReferenceNo());
        depositBankBillFlow.setApplicationId(applicationEntity.getApplicationId());
        List<DepositBankBillFlowEntity> bankBillFlowList = new ArrayList<>();
        bankBillFlowList = bankBillFlowService.queryListByBean(depositBankBillFlow);
        if(bankBillFlowList!=null && bankBillFlowList.size()>0 && bankBillFlowList.get(0).getFlowSource()==1){
            model.addAttribute("flowSource", 1);
            model.addAttribute("bankBill", bankBillFlowList);
        }else{
            model.addAttribute("flowSource", 0);
        }

        return "fund/deposit/depositDetailInfo";
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

        ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
        extendActTasklogEntity.setBusId(busId);
        List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);

        model.addAttribute("taskLogs", tasklogList);
        model.addAttribute("instanceId", instanceId);

        return "fund/taskLogInfo";
    }


    /**
     * 凭证处理列表
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/checkList")
    @RequiresPermissions("clientFundDeposit:checkList")
    public String checkAuditList(Model model, ClientFundDepositApplicationEntity queryCondition, HttpServletRequest request) {
        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_DEPOSIT_MODEL_ID", null));
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

//            String benefitBank = queryCondition.getBenefitBank();
//            if (StringUtils.isNotEmpty(benefitBank)) {
//                queryCondition.setBenefitBank(CodeUtils.getCodeName("FUND_DEPOSIT_BANK", benefitBank));
//            }

            String clientNameSpell = queryCondition.getClientNameSpell();
            if (StringUtils.isNotEmpty(clientNameSpell)) {
                queryCondition.setClientNameSpell(clientNameSpell.replace(" ", ""));
            }

            String beginTime = queryCondition.getBeginTime();
            String endTime = queryCondition.getEndTime();
            if (StringUtils.isNotBlank(beginTime)) {
                queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(beginTime)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(endTime)) {
                queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(endTime)), "yyyy-MM-dd HH:mm:ss"));
            }

            queryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_WAIT_VALUE);
            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<ClientFundDepositApplicationEntity> page = clientFundDepositApplicationService.findPage(queryCondition, pageNum);
            for (ClientFundDepositApplicationEntity e : page.getResult()) {
                ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
                query.setApplicationId(e.getApplicationId());
                //客户凭证
                query.setImageType(0);
                e.setDespositImage(depositImageService.queryListByBean(query));
//                银行凭证
//                query.setImageType(1);
//                e.setBankImage(depositImageService.queryListByBean(query));
                String type = e.getOpenAccountType();
                String open = "";
                if (StringUtils.isNotEmpty(type)) {
                    if ("0".equals(type)) {
                        open = "未知";
                    } else if ("1".equals(type)) {
                        open = "互联网开户";
                        String bankType = e.getBankType();
                        if ("0".equals(bankType)) {
                            open = "香港银行卡";
                        } else if ("1".equals(bankType) && e.getOpenAccountTime().getTime() < DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                            open = "大陆银行卡";
                        } else if ("1".equals(bankType) && e.getOpenAccountTime().getTime() > DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                            open = "SZCA电子证书";
                        }
                    } else if ("2".equals(type)) {
                        open = "线下开户";
                    } else if ("3".equals(type)) {
                        open = "BPM开户";
                    }
                }
                e.setOpenAccountType(open);

            }
            queryCondition.setClientNameSpell(clientNameSpell);
            queryCondition.setBeginTime(beginTime);
            queryCondition.setEndTime(endTime);
//            queryCondition.setBenefitBank(benefitBank);
            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        } catch (Exception e) {
            logger.error("查看入金审核列表异常", e);
        }

        return "fund/deposit/depositInfoCheckList";
    }

    /**
     * 入账列表
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/accEntryList")
    @RequiresPermissions("clientFundDeposit:accEntryList")
    public String accEntryList(Model model, ClientFundDepositApplicationEntity queryCondition, HttpServletRequest request) {
        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_DEPOSIT_MODEL_ID", null));
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

//            String benefitBank = queryCondition.getBenefitBank();
//            if (StringUtils.isNotEmpty(benefitBank)) {
//                queryCondition.setBenefitBank(CodeUtils.getCodeName("FUND_DEPOSIT_BANK", benefitBank));
//            }
            String clientNameSpell = queryCondition.getClientNameSpell();
            if (StringUtils.isNotEmpty(clientNameSpell)) {
                queryCondition.setClientNameSpell(clientNameSpell.replace(" ", ""));
            }
            String beginTime = queryCondition.getBeginTime();
            String endTime = queryCondition.getEndTime();
            if (StringUtils.isNotBlank(beginTime)) {
                queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(beginTime)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(endTime)) {
                queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(endTime)), "yyyy-MM-dd HH:mm:ss"));
            }
            queryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT_VALUE);
            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<ClientFundDepositApplicationEntity> page = clientFundDepositApplicationService.findPage(queryCondition, pageNum);
            for (ClientFundDepositApplicationEntity e : page.getResult()) {
                ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
                query.setApplicationId(e.getApplicationId());
                //客户凭证
                query.setImageType(0);
                e.setDespositImage(depositImageService.queryListByBean(query));
                //银行凭证
                query.setImageType(1);
                e.setBankImage(depositImageService.queryListByBean(query));
            }
            queryCondition.setClientNameSpell(clientNameSpell);
            queryCondition.setBeginTime(beginTime);
            queryCondition.setEndTime(endTime);
//            queryCondition.setBenefitBank(benefitBank);
            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        } catch (Exception e) {
            logger.error("查看入金入账列表异常", e);
        }

        return "fund/deposit/depositAccEntryList";
    }


    /**
     * 跳转审核详情页面
     *
     * @param model
     * @param request
     * @return
     * @isload 1-流水匹配 空-搜索/加载
     */
    @RequestMapping(value = "/toCheckTab")
    public String toCheckTab(Model model, HttpServletRequest request, ClientFundDepositApplicationEntity queryCondition, String billId, String isload, String jump) {
        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_DEPOSIT_MODEL_ID", null));
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

            String beginTime = queryCondition.getBeginTime();
            String endTime = queryCondition.getEndTime();
            String clientNameSpell = queryCondition.getClientNameSpell();

            DepositBankBillFlowEntity flowEntity = bankBillFlowService.queryObject(Long.valueOf(billId));
//            String benefitBank;
            if ("1".equals(isload)) {
                queryCondition.setDepositBalance(flowEntity.getCreditAmount());
                //判断如果是DBS核对页面，需要使用原汇款金额
                if("1".equals(jump)){
                    queryCondition.setDepositBalance(flowEntity.getActualMoney());
                }
                queryCondition.setBenefitBank(flowEntity.getBankName());
                queryCondition.setMoneyType(flowEntity.getCurrency());
                queryCondition.setDepositAccount(flowEntity.getSenderAccName());
                queryCondition.setDepositNo(flowEntity.getSenderAccNo());

                if (StringUtils.isNotEmpty(flowEntity.getAccNo())) {
                    queryCondition.setBenefitNo(flowEntity.getAccNo().replace("-", "").trim());
                } else {
                    queryCondition.setBenefitNo(flowEntity.getSubAccno().replace("-", "").trim());
                }
            } else {
//                benefitBank = queryCondition.getBenefitBank();
//                if (StringUtils.isNotEmpty(benefitBank)) {
//                    queryCondition.setBenefitBank(CodeUtils.getCodeName("FUND_DEPOSIT_BANK", benefitBank));
//                }
                if (StringUtils.isNotEmpty(clientNameSpell)) {
                    queryCondition.setClientNameSpell(clientNameSpell.replace(" ", ""));
                }

                if (StringUtils.isNotBlank(beginTime)) {
                    queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(beginTime)), "yyyy-MM-dd HH:mm:ss"));
                }
                if (StringUtils.isNotBlank(endTime)) {
                    queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(endTime)), "yyyy-MM-dd HH:mm:ss"));
                }

            }

            //超级管理员不做权限验证
            if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                queryCondition.setCurrentNode(null);
            } else {
                queryCondition.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
            }

            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            queryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_CHECK_VALUE);

            Page<ClientFundDepositApplicationEntity> page = clientFundDepositApplicationService.queryBankCheckList(queryCondition, pageNum);
            for (ClientFundDepositApplicationEntity e : page.getResult()) {
                ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
                query.setApplicationId(e.getApplicationId());
                //客户凭证
                query.setImageType(0);
                e.setDespositImage(depositImageService.queryListByBean(query));
                //银行凭证
//                query.setImageType(1);
//                e.setBankImage(depositImageService.queryListByBean(query));
            }
            queryCondition.setBeginTime(beginTime);
            queryCondition.setEndTime(endTime);
            queryCondition.setClientNameSpell(clientNameSpell);
//            queryCondition.setBenefitBank(benefitBank);
            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("bankBill", flowEntity);
            model.addAttribute("isload", isload);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        } catch (Exception e) {
            logger.error("跳转审核详情异常", e);
        }

        if ("1".equals(jump)) {
            return "fund/deposit/dbs/depositDbsBankDetail";
        } else {
            return "fund/deposit/depositBankDetail";
        }
    }

    /**
     * 跳转审核批量拒绝列表
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/bankCheckList")
    public String bankCheckList(Model model, HttpServletRequest request, ClientFundDepositApplicationEntity queryCondition, String billId, String isload) {
        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_DEPOSIT_MODEL_ID", null));
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

//            String benefitBank = queryCondition.getBenefitBank();
//            if (StringUtils.isNotEmpty(benefitBank)) {
//                queryCondition.setBenefitBank(CodeUtils.getCodeName("FUND_DEPOSIT_BANK", benefitBank));
//            }
            String clientNameSpell = queryCondition.getClientNameSpell();
            if (StringUtils.isNotEmpty(clientNameSpell)) {
                queryCondition.setClientNameSpell(clientNameSpell.replace(" ", ""));
            }

            String beginTime = queryCondition.getBeginTime();
            String endTime = queryCondition.getEndTime();
            if (StringUtils.isNotBlank(beginTime)) {
                queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(beginTime)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(endTime)) {
                queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(endTime)), "yyyy-MM-dd HH:mm:ss"));
            }

            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            queryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_CHECK_VALUE);
            Page<ClientFundDepositApplicationEntity> page = clientFundDepositApplicationService.findPage(queryCondition, pageNum);
            for (ClientFundDepositApplicationEntity e : page.getResult()) {
                ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
                query.setApplicationId(e.getApplicationId());
                //客户凭证
                query.setImageType(0);
                e.setDespositImage(depositImageService.queryListByBean(query));
                //银行凭证
//                query.setImageType(1);
//                e.setBankImage(depositImageService.queryListByBean(query));
            }
            queryCondition.setClientNameSpell(clientNameSpell);
            queryCondition.setBeginTime(beginTime);
            queryCondition.setEndTime(endTime);
//            queryCondition.setBenefitBank(benefitBank);
            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        } catch (Exception e) {
            logger.error("跳转审核批量拒绝列表异常", e);
        }
        return "fund/deposit/depositBankCheckList";
    }

    /**
     * 入金申请列表导出
     *
     * @param queryCondition
     * @param response
     * @return
     */
    @RequestMapping("/export")
    @RequiresPermissions("clientFundDeposit:export")
    public void export(ClientFundDepositApplicationEntity queryCondition, HttpServletResponse response) {

//        String benefitBank = queryCondition.getBenefitBank();
//        if (StringUtils.isNotEmpty(benefitBank)) {
//            queryCondition.setBenefitBank(CodeUtils.getCodeName("FUND_DEPOSIT_BANK", benefitBank));
//        }
        if (queryCondition.getBeginTime() != null && StringUtils.isNotBlank(queryCondition.getBeginTime())) {
            queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(queryCondition.getBeginTime())), "yyyy-MM-dd HH:mm:ss"));
        }
        if (queryCondition.getEndTime() != null && StringUtils.isNotBlank(queryCondition.getEndTime())) {
            queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(queryCondition.getEndTime())), "yyyy-MM-dd HH:mm:ss"));
        }
        String clientNameSpell = queryCondition.getClientNameSpell();
        if (StringUtils.isNotEmpty(clientNameSpell)) {
            queryCondition.setClientNameSpell(clientNameSpell.replace(" ", ""));
        }

        //待处理列表
        if ("1".equals(queryCondition.getFlag())) {
            queryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_WAIT_VALUE);
        }

        //入账列表
        if ("3".equals(queryCondition.getFlag())) {
            queryCondition.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT_VALUE);
        }

        List<ClientFundDepositApplicationEntity> applicationEntities = clientFundDepositApplicationService.queryList(queryCondition);
        try {
            if ("3".equals(queryCondition.getFlag())) {
                List<ClientFundDepositEntryExportModel> infoExportModels = Lists.newArrayList();
                for (ClientFundDepositApplicationEntity model : applicationEntities) {
                    ClientFundDepositEntryExportModel info = new ClientFundDepositEntryExportModel();
                    info.setApplicationId(model.getApplicationId());
                    info.setApplicationTime(model.getApplicationTime());
                    info.setBenefitBalance(DECIMAL_FORMAT.format(model.getBenefitBalance()));
                    info.setClientNameSpell(model.getClientNameSpell());
                    info.setDepositBank(model.getDepositBank());
                    info.setDepositNo(model.getDepositNo());
                    info.setDepositBalance(DECIMAL_FORMAT.format(model.getDepositBalance()));
                    info.setFundAccount(model.getFundAccount());
                    info.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", model.getMoneyType()));
                    infoExportModels.add(info);
                }
                EasyExcelUtils.exportXlsxFile(infoExportModels, response, ClientFundDepositEntryExportModel.class);
            } else {
                List<ClientFundDepositInfoExportModel> infoExportModels = Lists.newArrayList();
                for (ClientFundDepositApplicationEntity model : applicationEntities) {
                    ClientFundDepositInfoExportModel info = new ClientFundDepositInfoExportModel();
                    info.setApplicationId(model.getApplicationId());
                    info.setApplicationTime(model.getApplicationTime());
                    info.setClientName(model.getClientName());
                    info.setClientNameSpell(model.getClientNameSpell());
                    info.setDepositBalance(DECIMAL_FORMAT.format(model.getDepositBalance()));
                    info.setDepositBank(model.getDepositBank());
                    info.setDepositNo(model.getDepositNo());
                    info.setPhoneNumber(model.getPhoneNumber());
                    info.setUserId(model.getUserId());
                    info.setSourceChannelId(model.getSourceChannelId());
                    info.setSex(CodeUtils.getCodeName("COMMON_SEX", String.valueOf(model.getSex())));
                    info.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", model.getMoneyType()));
                    info.setApplicationStatus(CodeUtils.getCodeName("FUND_DEPOSIT_STATUS", String.valueOf(model.getApplicationStatus())));
                    info.setFirstDepFlag(Integer.valueOf(model.getFirstDepFlag()) < 1 ? "是" : "否");
                    //设置开户途径
                    String type = model.getOpenAccountType();
                    String open = "";
                    if (StringUtils.isNotEmpty(type)) {
                        if ("0".equals(type)) {
                            open = "未知";
                        } else if ("1".equals(type)) {
                            open = "互联网开户";
                            String bankType = model.getBankType();
                            if ("0".equals(bankType)) {
                                open = "香港银行卡";
                            } else if ("1".equals(bankType) && model.getOpenAccountTime().getTime() < DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                                open = "大陆银行卡";
                            } else if ("1".equals(bankType) && model.getOpenAccountTime().getTime() > DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                                open = "SZCA电子证书";
                            }
                        } else if ("2".equals(type)) {
                            open = "线下开户";
                        } else if ("3".equals(type)) {
                            open = "BPM开户";
                        }
                    }
                    info.setOpenAccountType(open);
                    infoExportModels.add(info);
                }
                EasyExcelUtils.exportXlsxFile(infoExportModels, response, ClientFundDepositInfoExportModel.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转上传银行凭证页面
     *
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "/toCheckView")
    public String toCheckView(Model model, String flowId, String applicationId, String remark) {
        try {
            ClientFundDepositApplicationEntity entity = clientFundDepositApplicationService.queryByApplicationId(applicationId);
            ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
            query.setApplicationId(applicationId);
            query.setImageType(1);
            List<ClientFundDepositImageEntity> bankImages = depositImageService.queryListByBean(query);
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(applicationId);
            taskDto.setRemark(remark);
            model.addAttribute("taskDto", taskDto);
            model.addAttribute("info", entity);
            model.addAttribute("bankImages", bankImages);
            model.addAttribute("flowId", flowId);
        } catch (Exception e) {
            logger.error("跳转上传初审银行凭证页面", e);
        }
        return "fund/deposit/uploadBankImage";
    }

    /**
     * 跳转退回页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tobackView")
    public String tobackView(Model model, String remark, String applicationId) {
        try {
            ClientFundDepositApplicationEntity entity = clientFundDepositApplicationService.queryByApplicationId(applicationId);
            List<CodeEntity> backTypes = codeService.queryChildsByMark("FUND_DEPOSIT_BACK_TYPE");
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(applicationId);
            taskDto.setRemark(remark);
            model.addAttribute("taskDto", taskDto);
            model.addAttribute("info", entity);
            Collections.reverse(backTypes);
            model.addAttribute("backTypes", backTypes);
        } catch (Exception e) {
            logger.error("跳转退回页面", e);
        }
        return "fund/deposit/doTaskBackView";
    }

    /**
     * 跳转批量退回页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/toBatchBackView")
    public String toBatchbackView(Model model, String applicationIds) {
        try {
            List<CodeEntity> backTypes = codeService.queryChildsByMark("FUND_DEPOSIT_BACK_TYPE");
            Collections.reverse(backTypes);
            model.addAttribute("applicationIds", applicationIds);
            model.addAttribute("backTypes", backTypes);
        } catch (Exception e) {
            logger.error("跳转退回页面", e);
        }
        return "fund/deposit/doBatchBackView";
    }

    /**
     * 跳转选择入账银行页面
     *
     * @param processTaskDto
     * @param applicationIds
     * @return
     */
    @RequestMapping("/toChooseDepositBank")
    public String toChooseDepositBank(ProcessTaskDto processTaskDto, Model model, String applicationIds, HttpServletRequest request) {

        ClientFundDepositApplicationEntity query = new ClientFundDepositApplicationEntity();

        if (StringUtils.isNotBlank(applicationIds)) {
            String[] applicationIdArray = applicationIds.split(",");
            List<String> applicationIdList = new ArrayList<>(Arrays.asList(applicationIdArray));
            query.setApplicationIds(applicationIdList);
        } else {
            List<String> applicationIdList = new ArrayList<>();
            applicationIdList.add(processTaskDto.getBusId());
            query.setApplicationIds(applicationIdList);
        }
        query.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT_VALUE);
        query.setAssignDrafter(UserUtils.getCurrentUserId());
        List<ClientFundDepositApplicationEntity> applicationEntities = clientFundDepositApplicationService.queryList(query);

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<HsCompanyBankEntity> page = hsCompanyBankService.findPage(new HsCompanyBankEntity(), pageNum);

        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("page", page);
        model.addAttribute("applicationIds", applicationIds);
        model.addAttribute("applicationEntities", applicationEntities);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        return "fund/deposit/chooseDespositBankView";
    }

    /**
     * 授权入账
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doDepositEntry")
    public
    @ResponseBody
    Result doWithdrawSuc(ProcessTaskDto processTaskDto, String itemId, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                ClientFundDepositApplicationEntity entity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());
                if (BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE == entity.getApplicationStatus()) {
                    return Result.error("该入金记录已被忽略，请至忽略列表处理");
                }
                HsCompanyBankEntity hsCompanyBankEntity = hsCompanyBankService.queryObject(Long.parseLong(itemId));

                entity.setLastApprovalUser(UserUtils.getCurrentUserId());
                entity.setHsBankId(hsCompanyBankEntity.getBankId());
                entity.setHsBankAccount(hsCompanyBankEntity.getBankAccount());
                entity.setApprovalOpinion(processTaskDto.getRemark());
                clientFundDepositApplicationService.update(entity);

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
     * 退回
     *
     * @param processTaskDto
     * @param backFlag       退回节点 1-退至客服  2-退至结算 3或者空 退回至客户
     * @return
     */
    @RequestMapping(value = "/doBack", method = RequestMethod.POST)
    @ResponseBody
    public Result doBack(ProcessTaskDto processTaskDto, String backFlag, String otherReasons, String errorContentTypes, HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {
            boolean isSecceed = ClientFundDepositApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);
            if (isSecceed) {
                ClientFundDepositApplicationEntity entity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());
                if (entity == null) {
                    logger.error("[退回操作]查询申请表失败");
                    return Result.error("操作失败");
                }

                if (BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE == entity.getApplicationStatus()) {
                    return Result.error("该入金记录已被忽略，请至忽略列表处理");
                }
                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("0".equals(errorContentType) && StringUtils.isNotBlank(otherReasons)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_DEPOSIT_BACK_TYPE", errorContentType)).append("：").append(otherReasons);
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_DEPOSIT_BACK_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                }
                entity.setApprovalOpinion(errorContent.substring(0, errorContent.length() - 1));
                //退回结算和客服之后加急申请
                if ("1".equals(backFlag) || "2".equals(backFlag)) {
                    entity.setFireAid(1);
                }
                clientFundDepositApplicationService.update(entity);
                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1) + (StringUtils.isNotBlank(processTaskDto.getRemark()) ? "," + processTaskDto.getRemark() : ""));
                //退回至客服  相当于退回到流程发起人
                if ("1".equals(backFlag)) {
                    actModelerService.endFailFolw(processTaskDto, params);
                    bankBillFlowService.backBankFlow(entity.getApplicationId());
                }
                //退回至结算
                if ("2".equals(backFlag)) {
                    actModelerService.backPreviousNode(processTaskDto);
                    bankBillFlowService.backBankFlow(entity.getApplicationId());
                }
                //退回至客户  即流程终止
                if ("3".equals(backFlag) || Utils.isEmpty(backFlag)) {
                    clientFundDepositApplicationService.terminateApplication(entity, processTaskDto);
                    actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.TURN_BACK.getValue());
                    bankBillFlowService.backBankFlow(entity.getApplicationId());
                }

                //清空AssignDrafter
                entity.setAssignDrafter(null);
                entity.setUpdateTime(new Date());
                clientFundDepositApplicationService.updateAssignDrafter(entity);
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
                return Result.error("没有勾选需要记录");
            }
            StringBuilder currentNodes = new StringBuilder();
            Map<String, List<String>> modelNodeRoleList;
            // 根据当前角色查询审核任务
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_DEPOSIT_MODEL_ID", null));

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
            StringBuffer ignoreMsg = new StringBuffer();

            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("client_fund_deposit_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());
                // 超级管理员不做权限验证，判断当前用户审核权限
                if (!currentNodes.toString().contains(depositApplicationEntity.getCurrentNode()) && !UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                if (BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE == depositApplicationEntity.getApplicationStatus()) {
                    ignoreMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }
                result = actModelerService.applyTaskHandle(processTaskDto, UserUtils.getCurrentUserId());
                if ("0".equals(result.get("code"))) {
                    // 更新申请表指定处理人
                    depositApplicationEntity.setAssignDrafter(UserUtils.getCurrentUserId());
                    depositApplicationEntity.setUpdateTime(new Date());
                    clientFundDepositApplicationService.updateAssignDrafter(depositApplicationEntity);
                } else {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                }
            }
            if (!StringUtils.isEmpty(errorMsg)) {
                errorMsg.append("任务已被申请办理");
            }
            if (!StringUtils.isEmpty(ignoreMsg)) {
                ignoreMsg.append("已被忽略，请至忽略列表处理");
            }
            if (!StringUtils.isEmpty(errorMsg) || !StringUtils.isEmpty(ignoreMsg)) {
                return Result.error(errorMsg.toString() + " " + ignoreMsg.toString());
            }
        } catch (Exception e) {
            logger.error("批量申请办理任务异常", e);
            return Result.error("申请办理任务失败");
        }
        return result;
    }

    /**
     * 批量办理任务
     *
     * @param applicationIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/doPassTaskBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result doPassTaskBatch(String applicationIds, String itemId, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("没有勾选需要记录");
        }

        try {
            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("client_fund_deposit_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());

                if (StringUtils.isBlank(depositApplicationEntity.getAssignDrafter())) {
                    return Result.error("存在未被申领任务，请先申领任务");
                }

                if (!UserUtils.getCurrentUserId().equals(depositApplicationEntity.getAssignDrafter())) {
                    return Result.error("存在已被其他用户申领的任务，请刷新页面后重新提交");
                }

                if (BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE == depositApplicationEntity.getApplicationStatus()) {
                    return Result.error(depositApplicationEntity.getApplicationId() + "入金记录已被忽略，请至忽略列表处理");
                }

                if (StringUtils.isNotBlank(itemId)) {
                    HsCompanyBankEntity hsCompanyBankEntity = hsCompanyBankService.queryObject(Long.parseLong(itemId));

                    depositApplicationEntity.setHsBankId(hsCompanyBankEntity.getBankId());
                    depositApplicationEntity.setHsBankAccount(hsCompanyBankEntity.getBankAccount());
                    clientFundDepositApplicationService.update(depositApplicationEntity);
                }

                // 更新申请表指定处理人
//                depositApplicationEntity.setAssignDrafter(UserUtils.getCurrentUserId());
//                depositApplicationEntity.setUpdateTime(new Date());
//                clientFundDepositApplicationService.updateAssignDrafter(depositApplicationEntity);

                actModelerService.doActTask(processTaskDto, params);
            }

            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

        } catch (Exception e) {
            logger.error("批量办理任务异常", e);
            return Result.error("批量办理任务失败");
        }
        return result;
    }

    /**
     * 批量退回任务
     *
     * @param applicationIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/doRejectTaskBatch", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions("clientFundDeposit:batchReject")
    public Result doRejectTaskBatch(String applicationIds, String otherReasons, String errorContentTypes, String backReasonType, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("没有勾选需要记录");
        }

        try {
            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("client_fund_deposit_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());

                if (StringUtils.isBlank(depositApplicationEntity.getAssignDrafter())) {
                    return Result.error("存在未被申领任务，请先申领任务");
                }

                if (!UserUtils.getCurrentUserId().equals(depositApplicationEntity.getAssignDrafter())) {
                    return Result.error("存在已被其他用户申领的任务，请刷新页面后重新提交");
                }

                if (BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE == depositApplicationEntity.getApplicationStatus()) {
                    return Result.error(depositApplicationEntity.getApplicationId() + "入金记录已被忽略，请至忽略列表处理");
                }

                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("0".equals(errorContentType) && StringUtils.isNotBlank(otherReasons)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_DEPOSIT_BACK_TYPE", errorContentType)).append("：").append(otherReasons);
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_DEPOSIT_BACK_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                }
                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1));
                depositApplicationEntity.setApprovalOpinion(errorContent.substring(0, errorContent.length() - 1));
                clientFundDepositApplicationService.update(depositApplicationEntity);

                actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.TURN_BACK.getValue());
                clientFundDepositApplicationService.terminateApplication(depositApplicationEntity, processTaskDto);
                bankBillFlowService.backBankFlow(depositApplicationEntity.getApplicationId());

                // 更新申请表指定处理人
                depositApplicationEntity.setAssignDrafter(UserUtils.getCurrentUserId());
                depositApplicationEntity.setUpdateTime(new Date());
                clientFundDepositApplicationService.updateAssignDrafter(depositApplicationEntity);

            }

            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

        } catch (Exception e) {
            logger.error("批量办理任务异常", e);
            return Result.error("批量办理任务失败");
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

        ProcessTaskDto parms = new ProcessTaskDto();
        parms.setBusId(applicationIds);
        parms.setTableName("client_fund_deposit_application");
        List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);
        for (ProcessTaskDto processTaskDto : processTaskDtoList) {
            try {
                result = actModelerService.deliverTaskHandle(processTaskDto);

                // 更新申请表指定处理人
                ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());

                depositApplicationEntity.setAssignDrafter(null);
                depositApplicationEntity.setUpdateTime(new Date());
                clientFundDepositApplicationService.updateAssignDrafter(depositApplicationEntity);

            } catch (Exception e) {
                logger.error("批量释放办理任务异常", e);
                result = Result.error("释放失败");
            }
        }
        return result;
    }

    /**
     * 银行流水核对通过
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doBankCheckPass")
    public
    @ResponseBody
    Result doInitialAuditPass(ProcessTaskDto processTaskDto, HttpServletRequest request, String flowId) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }
        Result result = null;
        try {
            boolean isSecceed = ClientFundDepositApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);
            if (!isSecceed) {
                ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(processTaskDto.getBusId());
                taskDto.setRemark(processTaskDto.getRemark());
                isSecceed = ClientFundDepositApplyHelper.validateProcessTaskDtoIsFull(taskDto);
                processTaskDto = taskDto;
            }
            if (isSecceed) {
                ClientFundDepositApplicationEntity depositApplicationEntity = clientFundDepositApplicationService.queryByApplicationId(processTaskDto.getBusId());
                DepositBankBillFlowEntity flowEntity = bankBillFlowService.queryObject(Long.parseLong(flowId));
                if (StringUtils.isNotBlank(flowEntity.getApplicationId())) {
                    return Result.error("该条流水已绑定入金申请:" + flowEntity.getApplicationId());
                }

                if (StringUtils.isNotBlank(depositApplicationEntity.getAssignDrafter()) && !UserUtils.getCurrentUserId().equals(depositApplicationEntity.getAssignDrafter())) {
                    return Result.error("该条申请已被他人申领处理");
                }
                //判断星展icc自动入账数据 校验流水手续费必须获取成功
                if(StringUtil.isNotEmpty(depositApplicationEntity.getBenefitBank())
                        && "1".equals(depositApplicationEntity.getBenefitBank())
                        && flowEntity.getFlowSource()==1){
                    if(flowEntity.getAreChargeMoney()==null || StringUtils.isEmpty(flowEntity.getAreEnqStatus()) || !"ACSP".equals(flowEntity.getAreEnqStatus())){
                        return Result.error("该条流水手续费未获取成功");
                    }
                }


                if (3 != depositApplicationEntity.getApplicationStatus()) {
                    return Result.error("该条申请当前状态为:" + CodeUtils.getCodeName("FUND_DEPOSIT_STATUS", String.valueOf(depositApplicationEntity.getApplicationStatus())));
                } else {
                    depositApplicationEntity.setLastApprovalUser(UserUtils.getCurrentUserId());
                    depositApplicationEntity.setApprovalOpinion(processTaskDto.getRemark());
                    clientFundDepositApplicationService.update(depositApplicationEntity);
                    actModelerService.doActTask(processTaskDto, params);
                    // 驱动流程下一步
//                actModelerService.doNextFlow(processTaskDto.getBusId(), depositApplicationEntity.getInstanceId(), "");
                    flowEntity.setCheckStatus(1);
                    flowEntity.setApplicationId(processTaskDto.getBusId());
                    flowEntity.setUpdateTime(new Date());
                    flowEntity.setUpdateUser(UserUtils.getCurrentUserId());
                    int update = bankBillFlowService.update(flowEntity);
                    result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
                }
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
     * 新增凭证
     */
    @RequestMapping("/uploadImage")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result uploadImage(@RequestParam("file") MultipartFile file, int imageType, String applicationId) {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        ClientFundDepositImageEntity entity = new ClientFundDepositImageEntity();
        entity.setApplicationId(applicationId);
        if (1 == imageType) {
            entity.setFileName("银行凭证");
            entity.setImageType(1);
        } else {
            entity.setFileName("客户凭证");
            entity.setImageType(0);
        }
        entity.setFileStorageName(Utils.uuid());
        entity.setStoragePath(ConfigUtils.get("crm.file.path") + "/deposit/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/");
        entity.setExtName(FileOperaterUtil.getFileExtendName(file.getOriginalFilename()));
        entity.setCreateUser(UserUtils.getCurrentUserId());
        entity.setUpdateUser(UserUtils.getCurrentUserId());
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        boolean b = FileUpload.fileUpload(file, entity.getStoragePath(), entity.getFileStorageName());
        depositImageService.save(entity);
        return Result.ok();
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result updateApplication(ClientFundDepositApplicationEntity update) {

        int update1 = clientFundDepositApplicationService.update(update);

        return Result.ok();
    }


    /**
     * 删除凭证
     */
    @RequestMapping(value = "/deleteImage", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result deleteImage(long id) {
//        long iid = Long.valueOf(id);
        depositImageService.delete(id);
        return Result.ok();
    }

    /**
     * 更改凭证
     */
    @RequestMapping(value = "/reUpload", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result updateImage(@RequestParam("file") MultipartFile file, String gid) {
        if (file.isEmpty()) {
            throw new RRException("上传文件不能为空");
        }
        ClientFundDepositImageEntity entity = depositImageService.queryObject(Long.valueOf(gid));
        entity.setUpdateUser(UserUtils.getCurrentUserId());
        entity.setUpdateTime(new Date());
//        String fileSavePath = entity.getStoragePath() + entity.getFileStorageName() + "." + entity.getExtName();
//        boolean b = FileOperaterUtil.fileUpload(fileSavePath, file);
        boolean b = FileUpload.fileUpload(file, entity.getStoragePath(), entity.getFileStorageName());
        depositImageService.update(entity);
        return Result.ok("保存成功");
    }

    /**
     * 加急处理
     *
     * @param
     * @return
     */
    @RequestMapping(value = "fireAidTask", method = RequestMethod.POST)
    @ResponseBody
    public Result fireAidTask(String applicationIds, HttpServletRequest request) {
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("未勾选任务！");
        }
        try {
            clientFundDepositApplicationService.updateBatchByApplicationIds(applicationIds);
        } catch (Exception e) {
            logger.error("加急任务异常!", e);
            return Result.error("加急任务异常!");
        }
        return Result.ok();
    }

    /**
     * 忽略处理
     *
     * @param
     * @return
     */
    @RequestMapping(value = "doIgnore", method = RequestMethod.POST)
    @ResponseBody
    public Result doIgnore(String applicationIds) {
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("未勾选任务！");
        }
        try {
            Result result = deliverApplyTask(applicationIds,null);
            if("0".equals(result.get("code"))) {
                String[] applicationId = applicationIds.split(",");
                for (String appId : applicationId) {
                    ClientFundDepositApplicationEntity applicationEntity = clientFundDepositApplicationService.queryByApplicationId(appId);
                    if (applicationEntity.getApplicationStatus() > BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_ENTRY_WAIT_VALUE) {
                        continue;
                    }
                    ClientFundDepositApplicationEntity update = new ClientFundDepositApplicationEntity();
                    update.setApplicationId(appId);
                    update.setApplicationStatus(BpmCommonEnum.FundDepositApplicationStatus.FUND_DEPOSIT_APPLY_STATUS_IGNORE_VALUE);
                    update.setBeforeStatus(applicationEntity.getApplicationStatus());
                    clientFundDepositApplicationService.update(update);
                }
            }
        } catch (Exception e) {
            logger.error("忽略入金申请异常!", e);
            return Result.error("忽略失败!");
        }
        return Result.ok();
    }

    /**
     * 取消忽略处理
     *
     * @param
     * @return
     */
    @RequestMapping(value = "cancelIgnore", method = RequestMethod.POST)
    @ResponseBody
    public Result cancelIgnore(String applicationIds) {
        if (StringUtils.isEmpty(applicationIds)) {
            throw new MyException("未勾选任务！");
        }
        try {
            String[] applicationId = applicationIds.split(",");
            for (String appId : applicationId) {
                ClientFundDepositApplicationEntity applicationEntity = clientFundDepositApplicationService.queryByApplicationId(appId);
                ClientFundDepositApplicationEntity update = new ClientFundDepositApplicationEntity();
                update.setApplicationId(appId);
                update.setApplicationStatus(applicationEntity.getBeforeStatus());
//                update.setBeforeStatus(null);
                clientFundDepositApplicationService.update(update);
            }
        } catch (Exception e) {
            logger.error("取消忽略入金申请异常!", e);
            return Result.error("取消忽略失败!");
        }
        return Result.ok();
    }

    /**
     * 局部刷新入金凭证
     *
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping(value = "/depositImgRefresh", method = RequestMethod.GET)
    public String depositImgRefresh(String applicationId, Model model, String flag) {

        ClientFundDepositApplicationEntity applicationEntity = clientFundDepositApplicationService.queryByApplicationId(applicationId);

        //设置客户凭证
        ClientFundDepositImageEntity query = new ClientFundDepositImageEntity();
        query.setApplicationId(applicationId);
        //客户凭证
        query.setImageType(0);
        applicationEntity.setDespositImage(depositImageService.queryListByBean(query));
//        query.setImageType(1);
//        applicationEntity.setBankImage(depositImageService.queryListByBean(query));

        model.addAttribute("info", applicationEntity);
        model.addAttribute("operationFlag", flag);
        model.addAttribute("random", Math.random());

        return "fund/deposit/depositImgRefresh";
    }
}
