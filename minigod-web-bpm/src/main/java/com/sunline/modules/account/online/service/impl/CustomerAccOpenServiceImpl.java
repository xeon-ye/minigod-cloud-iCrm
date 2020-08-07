package com.sunline.modules.account.online.service.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.converter.CustomerOpenAccountConverter;
import com.sunline.modules.account.online.dao.CustomerAccountMarginOpenApplyDao;
import com.sunline.modules.account.online.dao.CustomerAccountOpenApplyDao;
import com.sunline.modules.account.online.entity.*;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.helper.CustomerAccountOpenHelper;
import com.sunline.modules.account.online.model.*;
import com.sunline.modules.account.online.model.query.AccountOpenApplyAllotQuery;
import com.sunline.modules.account.online.protocol.AccountOpenApplyCallBackProtocol;
import com.sunline.modules.account.online.protocol.CaVerityInfoProtocol;
import com.sunline.modules.account.online.protocol.OpenAccountImageInfo;
import com.sunline.modules.account.online.service.*;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.notice.entity.MessageSendInfoEntity;
import com.sunline.modules.notice.service.MessageSendInfoService;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.RoleService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiYangFeng
 * @createDate 2018/3/14
 * @description
 * @email justbelyf@gmail.com
 */
@Service("customerAccountOpenService")
public class CustomerAccOpenServiceImpl implements CustomerAccOpenService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccOpenServiceImpl.class);

    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    CustomerAccMarginOpenApplyServiceImpl customerAccMarginOpenApplyService;
    @Autowired
    CustomerAccOpenInfoService customerAccOpenInfoService;
    @Autowired
    CustomerAccOpenImageService customerAccOpenImageService;
    @Autowired
    CustomerAccountOpenApplyDao customerAccountOpenApplyDao;
    @Autowired
    CustomerAccountMarginOpenApplyDao customerAccountMarginOpenApplyDao;
    @Autowired
    MessageSendInfoService messageSendInfoService;
    @Autowired
    CustomerAccOpenReportGenerate customerAccOpenReportGenerate;
    @Autowired
    ActModelerService actModelerService;
    @Autowired
    OpenAccountPropertyTypeService openAccountPropertyTypeService;
    @Autowired
    OpenAccountOtherDisclosureService openAccountOtherDisclosureService;
    @Autowired
    OpenAccountBankVerityInfoService openAccountBankVerityInfoService;
    @Autowired
    OpenAccountTaxationInfoService openAccountTaxationInfoService;
    @Autowired
    OpenAccountProcessLogService openAccountProcessLogService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;
    @Autowired
    OpenAccountAdditionalFileService openAccountAdditionalFileService;
    @Autowired
    RoleService roleService;
    @Autowired
    OpenAccountCaVerityInfoService caVerityInfoService;

    private static final String CUSTOMER_ACCOUNT_OPEN_FLOW_MODEL_KEY = "customerAccountOpenApplication";

    private static final String CUSTOMER_ACCOUNT_MARGIN_OPEN_FLOW_MODEL_KEY = "customerAccountMarginOpenApplication";


    /**
     * 提交增开信息
     *
     * @param customerAccountOpenInfoEntity
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String commitAccountMarginOpenApplication(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity) {
        try {
            int count = 0;

            CustomerAccountMarginOpenApplyEntity customerAccountOpenApplicationEntity = new CustomerAccountMarginOpenApplyEntity();
            customerAccountOpenApplicationEntity.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            customerAccountOpenApplicationEntity.setAccountOpenResultStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            customerAccountOpenApplicationEntity.setApplicationTitle("账户增开申请[" + customerAccountOpenInfoEntity.getClientName() + "]");
            customerAccountOpenApplicationEntity.setIsExpExcel(0);
            customerAccountOpenApplicationEntity.setCurrentNode("提交");
            customerAccountOpenApplicationEntity.setIdCardNo(customerAccountOpenInfoEntity.getIdNo());

            //保存增开申请表信息
            count = customerAccMarginOpenApplyService.save(customerAccountOpenApplicationEntity);

            if (count > 0) {
                //更新用户信息
                count = customerAccOpenInfoService.updateMarginInfo(customerAccountOpenInfoEntity);
            }

            if (count > 0) {
                //其他信息
                if (customerAccountOpenInfoEntity.getOtherDisclosureList() != null && customerAccountOpenInfoEntity.getOtherDisclosureList().size() > 0) {
                    for (OpenAccountOtherDisclosureEntity otherDisclosure : customerAccountOpenInfoEntity.getOtherDisclosureList()) {
                        otherDisclosure.setApplicationId(customerAccountOpenApplicationEntity.getApplicationId());
                        otherDisclosure.setCreateTime(new Date());
                        otherDisclosure.setUpdateTime(new Date());
                    }
                    count = openAccountOtherDisclosureService.saveBatch(customerAccountOpenInfoEntity.getOtherDisclosureList());
                }
            }

            if (count > 0) {
                ProcessDefinition customerAccountOpenProcessDefinition = ActUtils.getlastProcessDefinition(CUSTOMER_ACCOUNT_MARGIN_OPEN_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(customerAccountOpenProcessDefinition.getId());
                processTaskDto.setBusId(customerAccountOpenApplicationEntity.getApplicationId());
                processTaskDto.setActKey(customerAccountOpenProcessDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);

                return customerAccountOpenApplicationEntity.getApplicationId();
            }

            return null;

        } catch (Exception e) {
            logger.error("提交增开申请启动工作流流程失败", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public String commitAccountOpenApplication(CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity, List<OpenAccountImageInfo> openAccountImagesInfo) {

        try {

            boolean isSucceed = false;
            int count = 0;

            CustomerAccountOpenApplyEntity customerAccountOpenApplicationEntity = new CustomerAccountOpenApplyEntity();

            customerAccountOpenApplicationEntity.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            customerAccountOpenApplicationEntity.setAccountOpenResultStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
            customerAccountOpenApplicationEntity.setApplicationTitle("互联网开户申请[" + customerAccountOpenInfoEntity.getClientName() + "]");
            customerAccountOpenApplicationEntity.setIsExpExcel(0);
            customerAccountOpenApplicationEntity.setCurrentNode("提交");

            //客户申请表信息
            count = customerAccOpenApplyService.save(customerAccountOpenApplicationEntity);

            if (count > 0) {
                //客户申请详细表信息
                customerAccountOpenInfoEntity.setApplicationId(customerAccountOpenApplicationEntity.getApplicationId());
                customerAccountOpenInfoEntity.setApplicationTime(new Date());
                count = customerAccOpenInfoService.save(customerAccountOpenInfoEntity);
            }

            if (count > 0) {
                //财产
                if (customerAccountOpenInfoEntity.getPropertyTypeList() != null && customerAccountOpenInfoEntity.getPropertyTypeList().size() > 0) {
                    for (OpenAccountPropertyTypeEntity propertyType : customerAccountOpenInfoEntity.getPropertyTypeList()) {
                        propertyType.setApplicationId(customerAccountOpenApplicationEntity.getApplicationId());
                        propertyType.setCreateTime(new Date());
                        propertyType.setUpdateTime(new Date());
                    }
                    count = openAccountPropertyTypeService.saveBatch(customerAccountOpenInfoEntity.getPropertyTypeList());
                }
            }


            if (count > 0) {
                //税务信息
                if (customerAccountOpenInfoEntity.getTaxationInfoList() != null && customerAccountOpenInfoEntity.getTaxationInfoList().size() > 0) {
                    for (OpenAccountTaxationInfoEntity taxationInfo : customerAccountOpenInfoEntity.getTaxationInfoList()) {
                        taxationInfo.setApplicationId(customerAccountOpenApplicationEntity.getApplicationId());
                        taxationInfo.setCreateTime(new Date());
                        taxationInfo.setUpdateTime(new Date());
                    }
                    count = openAccountTaxationInfoService.saveBatch(customerAccountOpenInfoEntity.getTaxationInfoList());
                }
            }

            if (count > 0) {
                //四要素
                if (customerAccountOpenInfoEntity.getOpenAccountBankVerityList() != null && customerAccountOpenInfoEntity.getOpenAccountBankVerityList().size() > 0) {
                    for (OpenAccountBankVerityInfoEntity bankVerityInfo : customerAccountOpenInfoEntity.getOpenAccountBankVerityList()) {
                        bankVerityInfo.setApplicationId(customerAccountOpenApplicationEntity.getApplicationId());
                    }
                    count = openAccountBankVerityInfoService.saveBatch(customerAccountOpenInfoEntity.getOpenAccountBankVerityList());
                }
            }

            if (count > 0) {
                //其他信息
                if (customerAccountOpenInfoEntity.getOtherDisclosureList() != null && customerAccountOpenInfoEntity.getOtherDisclosureList().size() > 0) {
                    for (OpenAccountOtherDisclosureEntity otherDisclosure : customerAccountOpenInfoEntity.getOtherDisclosureList()) {
                        otherDisclosure.setApplicationId(customerAccountOpenApplicationEntity.getApplicationId());
                        otherDisclosure.setCreateTime(new Date());
                        otherDisclosure.setUpdateTime(new Date());
                    }
                    count = openAccountOtherDisclosureService.saveBatch(customerAccountOpenInfoEntity.getOtherDisclosureList());
                }
            }

            isSucceed = saveOpenAccountImage(customerAccountOpenApplicationEntity.getApplicationId(), openAccountImagesInfo);

//            if (isSucceed) {
//                ProcessDefinition customerAccountOpenProcessDefinition = ActUtils.getlastProcessDefinition(CUSTOMER_ACCOUNT_OPEN_FLOW_MODEL_KEY);
//                ProcessTaskDto processTaskDto = new ProcessTaskDto();
//                processTaskDto.setDefId(customerAccountOpenProcessDefinition.getId());
//                processTaskDto.setBusId(customerAccountOpenApplicationEntity.getApplicationId());
//                processTaskDto.setActKey(customerAccountOpenProcessDefinition.getKey());
//                processTaskDto.setNodeType("2");
//
//                actModelerService.startFlow(processTaskDto);
//
//                return customerAccountOpenApplicationEntity.getApplicationId();
//            } else {
//                return null;
//            }

            if (count > 0) {
                ProcessDefinition customerAccountOpenProcessDefinition = ActUtils.getlastProcessDefinition(CUSTOMER_ACCOUNT_OPEN_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(customerAccountOpenProcessDefinition.getId());
                processTaskDto.setBusId(customerAccountOpenApplicationEntity.getApplicationId());
                processTaskDto.setActKey(customerAccountOpenProcessDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);

                return customerAccountOpenApplicationEntity.getApplicationId();
            }

            return null;

        } catch (Exception e) {
            logger.error("提交开户申请启动工作流流程失败", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
    }

    @Override
    public boolean terminateAccountOpenApplication(CustomerAccountOpenApplyEntity customerAccountOpenApply, ProcessTaskDto processTaskDto, int applicationStatus) {

        customerAccOpenApplyService.update(customerAccountOpenApply);

        CustomerAccOpenApproveInfo customerAccountOpenApproveInfo = new CustomerAccOpenApproveInfo();
        customerAccountOpenApproveInfo.setApplicationId(customerAccountOpenApply.getApplicationId());
        customerAccountOpenApproveInfo.setCurrentNode(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7"));

        // 更新预约申请表相关信息
        CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
        customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
        customerAccOpenApplyEntity.setApplicationStatus(applicationStatus);
        customerAccOpenApplyEntity.setUpdateTime(new Date());
        customerAccOpenApplyEntity.setLastApprovalUser(UserUtils.getCurrentUserId());
        customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
        customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

        approveCallback(customerAccountOpenApproveInfo, processTaskDto, null);


        return true;
    }

    /**
     * 工作流回调业务处理
     * 正常开户流程
     *
     * @param customerAccountOpenApproveInfo
     * @param processTaskDto
     * @param task
     */
    @Override
    public void approveCallback(CustomerAccOpenApproveInfo customerAccountOpenApproveInfo, ProcessTaskDto processTaskDto, Task task) {

        try {

            AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo = findByApplicationId(customerAccountOpenApproveInfo.getApplicationId());
            CustomerAccountOpenApplyEntity applicationInfo = accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity();
            CustomerAccountOpenInfoEntity accountOpenInfo = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

            // 初审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "1").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 开户文件生成
                if (1 == accountOpenInfo.getOpenAccountType()) {
                    customerAccOpenReportGenerate.generateReport(accountOpenInfo.getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_PROVE_REPORT);
                    customerAccOpenReportGenerate.generateReport(accountOpenInfo.getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_W8_REPORT);
//                    customerAccOpenReportGenerate.generateReport(accountOpenInfo.getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_SELF_CERTIFICATION_ON_US_REPORT);
                }

                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_INITIAL_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(UserUtils.getManagerUser().getId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 复审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "2").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RECHECK_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                //openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 终审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "3").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_FINAL_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // CA认证节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "8").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 生成开户表格
                if (1 == accountOpenInfo.getOpenAccountType()) {
                    customerAccOpenReportGenerate.generateReport(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT);
                }

                if (1 == accountOpenInfo.getBankType()) {
                    // 合并PDF
                    if (1 == accountOpenInfo.getOpenAccountType()) {

                        String accountOpenUserReportRootPath = CustomerAccOpenReportGenerate.getAccountOpenUserReportRootPath(accountOpenInfo.getApplicationId());
                        File[] files = new File[0];

                        String pdfMergePath = ConfigUtils.get("openAccount.user.report.userForm") + accountOpenInfo.getApplicationId() + "/" + ConfigUtils.get("ca.open.account.file.url") + ".pdf";

                        if (FileUtil.exist(pdfMergePath)) {
                            FileUtil.del(new File(pdfMergePath));
                        }

                        try {
                            files = FileUtil.ls(accountOpenUserReportRootPath);
                        } catch (Exception e) {
                            logger.error("Not directory", e);
                        }

                        List<String> pdfPaths = Lists.newArrayList();

                        if (!files[0].getPath().contains("开户表格")) {
                            for (File file : files) {
                                if (file.getPath().contains("开户表格")) {
                                    pdfPaths.add(file.getPath().replace("\\", "/"));
                                }
                            }
                            for (File file : files) {
                                if (!file.getPath().contains("开户表格")) {
                                    pdfPaths.add(file.getPath().replace("\\", "/"));
                                }
                            }
                        } else {
                            for (File file : files) {
                                pdfPaths.add(file.getPath().replace("\\", "/"));
                            }
                        }

                        PdfboxUtils.mergePdfFiles(pdfPaths.toArray(new String[pdfPaths.size()]), pdfMergePath);

                    }

                    // 更新流程信息
                    if (1 == accountOpenInfo.getOpenAccountType()) {
                        applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                    } else if (2 == accountOpenInfo.getOpenAccountType()) {
                        applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_PROCESS_VALUE);
                    }

                    applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);

                    // 更新预约申请表相关信息
                    CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                    customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                    customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_PROGRESS_VALUE);
                    customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                    customerAccOpenApplyEntity.setUpdateTime(new Date());
                    customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                    customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());
                    customerAccOpenApplyEntity.setFireAid(0);

                    customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                    // 新增客户开户业务流程日志记录
                    OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                    openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                    openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                    openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                    openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                    openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                    openAccountProcessLogService.save(openAccountProcessLogEntity);
                }
            }

            // 开户节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "4").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_PROGRESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 归档节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "5").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 生成开户表格
                if (1 == accountOpenInfo.getOpenAccountType()) {
                    customerAccOpenReportGenerate.generateReport(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT);
                }

                // 更新流程信息
                if (1 == accountOpenInfo.getOpenAccountType()) {
                    applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                } else if (2 == accountOpenInfo.getOpenAccountType()) {
                    applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_PROCESS_VALUE);
                }

                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);

//                if (1 == accountOpenInfo.getOpenAccountType()) {
//                    customerAccOpenReportGenerate.generateReport(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT);
//                }

                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);

                // 驱动工作流到下一步
//                actModelerService.doNextFlow(applicationInfo.getApplicationId(), applicationInfo.getInstanceId(), "");
            }

            // 完成节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "6").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                if (!CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7").equals(applicationInfo.getCurrentNode())) {
                    // 新增客户开户业务流程日志记录
                    OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                    openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                    openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                    openAccountProcessLogEntity.setTaskId(null);
                    openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                    openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                    openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                    openAccountProcessLogService.save(openAccountProcessLogEntity);
                }
            }

            // 终止节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "7").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 更新流程信息
                if (1 == accountOpenInfo.getOpenAccountType()) {
                    applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                } else if (3 == accountOpenInfo.getOpenAccountType()) {
                    applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_UN_PROCESS_VALUE);
                }
                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
                applicationInfo.setStatus(Constant.ActStauts.END.getValue());
                applicationInfo.setActResult("2");
                applicationInfo.setFireAid(0);

                // 更新开户信息记录为无效记录
                CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
                customerAccountOpenInfoEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccountOpenInfoEntity.setRecordStatus(BpmCommonEnum.CommonRecordStatus.COMMON_RECORD_STATUS_DISABLE_VALUE);
                customerAccountOpenInfoService.update(customerAccountOpenInfoEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(null);
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);

            }

            // 拼接流程审核记录串
            String flowPath = applicationInfo.getFlowPath() != null ? applicationInfo.getFlowPath() + "-" + customerAccountOpenApproveInfo.getCurrentNode() : customerAccountOpenApproveInfo.getCurrentNode();
            applicationInfo.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
            applicationInfo.setFlowPath(flowPath);
            applicationInfo.setIsBack(null);
            applicationInfo.setApplicationStatus(null);
            applicationInfo.setLastApprovalUser(null);
            applicationInfo.setApprovalOpinion(null);
            applicationInfo.setAssignDrafter(null);
            applicationInfo.setUpdateTime(new Date());

            if (!CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "0").equals(customerAccountOpenApproveInfo.getCurrentNode())
                    && accountOpenInfo.getRecordStatus() != BpmCommonEnum.CommonRecordStatus.COMMON_RECORD_STATUS_DISABLE_VALUE) {
                customerAccOpenApplyService.update(applicationInfo);
            }

            // 重置指定处理人为null
            customerAccountOpenApplyDao.updateAssignDrafter(applicationInfo);

            // 香港银行卡开户不需要做CA验证
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", "8").equals(customerAccountOpenApproveInfo.getCurrentNode()) && 0 == accountOpenInfo.getBankType()) {

                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(applicationInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_SUCCESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
//                    customerAccOpenApplyEntity.setApprovalOpinion("");
                UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
                customerAccOpenApplyEntity.setLastApprovalUser(workflowUser.getId());
                customerAccOpenApplyEntity.setFireAid(0);

                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);

                // 驱动工作流到下一步
                actModelerService.doNextFlow(applicationInfo.getApplicationId(), applicationInfo.getInstanceId(), "");
            }

        } catch (Exception e) {
            logger.error("工作流回调业务处理异常", e);
        }
    }


    /**
     * 生成邮件通知数据
     * (保存数据到message_send_info表，定时任务扫描发磅)
     *
     * @param accountOpenApplicationDetailInfo
     */
    @Override
    public void sendAccountOpenEmail(AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo) {

        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();
        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
        messageSendInfoEntity.setRecipients(customerAccountOpenInfoEntity.getEmail());
        messageSendInfoEntity.setMessageTitle("寶新證券帳戶開戶歡迎函");
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        Map<String, String> emailModel = Maps.newHashMap();
        emailModel.put("clientName", customerAccountOpenInfoEntity.getClientName() != null && !"".equals(customerAccountOpenInfoEntity.getClientName()) ? customerAccountOpenInfoEntity.getClientName() : customerAccountOpenInfoEntity.getClientNameSpell());
        emailModel.put("tradeAccount", customerAccountOpenInfoEntity.getStockTradeAccount());
        emailModel.put("futuresTradeAccount", customerAccountOpenInfoEntity.getFuturesTradeAccount());
        //emailModel.put("tradeAccountPassword", ProtocolUtils.getDecryptPhone(customerAccountOpenInfoEntity.getInitialAccountPassword()));
        messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.ACCOUNT_OPEN_SUCCEED_EMAIL_TEMPLATE, emailModel));
        messageSendInfoEntity.setContentType(2);

        List<String> attachmentUris = Lists.newArrayList();
        String userFormReportFile = customerAccOpenReportGenerate.makeOutputPath(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT);
        attachmentUris.add(userFormReportFile);
        attachmentUris.add(ConfigUtils.get("openAccount.user.report.rootPath") + "/" + ConfigUtils.get("openAccount.user.report.riskDisclosure"));
        attachmentUris.add(ConfigUtils.get("openAccount.user.report.rootPath") + "/" + ConfigUtils.get("openAccount.user.report.cashUserProtocol"));

        // 开户文件
        messageSendInfoEntity.setAttachmentUris(JSON.toJSONString(attachmentUris));
        messageSendInfoService.save(messageSendInfoEntity);

        // 发送一世免佣通知邮件
        if ("275".equals(customerAccountOpenInfoEntity.getSourceChannelId())) {
            /*messageSendInfoEntity = new MessageSendInfoEntity();
            messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_EMAIL_VALUE);
            messageSendInfoEntity.setRecipients(customerAccountOpenInfoEntity.getEmail());
            messageSendInfoEntity.setMessageTitle("寶新證券免傭確認函");
            messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);

            emailModel.clear();
            emailModel.put("clientName", customerAccountOpenInfoEntity.getClientName() != null && !"".equals(customerAccountOpenInfoEntity.getClientName()) ? customerAccountOpenInfoEntity.getClientName() : customerAccountOpenInfoEntity.getClientNameSpell());
            messageSendInfoEntity.setMessageContent(VelocityUtil.fillTemplate(VelocityUtil.ACCOUNT_OPEN_SUCCEED_HK_EMAIL_TEMPLATE, emailModel));
            messageSendInfoEntity.setContentType(2);

            messageSendInfoService.save(messageSendInfoEntity);*/
        }
    }


    /**
     * 生成短信发送数据
     *
     * @param accountOpenApplicationDetailInfo
     * @param result                           是否成功
     * @return
     */
    @Override
    public boolean openAccountResultUserSMSNotice(AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo, boolean result) {

        String msgUrl = ConfigUtils.get("message.center.sms.url");
        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();
        JSONObject messageBody = new JSONObject();
        if (result) {
            JSONObject paraMap = new JSONObject();
            messageBody.put("requestSource", "1");
            messageBody.put("templateCode", "1002");
            paraMap.put("userName", customerAccountOpenInfoEntity.getClientName());
            paraMap.put("cellPhone", customerAccountOpenInfoEntity.getPhoneNumber());
            paraMap.put("trdAccount", customerAccountOpenInfoEntity.getClientId());
            //paraMap.put("trdAccountPwd", customerAccountOpenInfoEntity.getInitialAccountPassword());
            messageBody.put("paramMap", paraMap);
        } else {
            JSONObject paraMap = new JSONObject();
            messageBody.put("requestSource", "1");
            messageBody.put("templateCode", "1003");
            paraMap.put("userName", customerAccountOpenInfoEntity.getClientName());
            paraMap.put("cellPhone", customerAccountOpenInfoEntity.getPhoneNumber());
            paraMap.put("reason", accountOpenApplicationDetailInfo.getCustomerAccountOpenApplyEntity().getErrorContentTypes());
            messageBody.put("paramMap", paraMap);
        }

        MessageSendInfoEntity messageSendInfoEntity = new MessageSendInfoEntity();
        messageSendInfoEntity.setMessageType(BpmCommonEnum.MessageNoticeType.MESSAGE_NOTICE_TYPE_PLATFORM_SEND_SMS_VALUE);
        messageSendInfoEntity.setRecipients(msgUrl);
        messageSendInfoEntity.setMessageTitle("寶新證券帳戶開戶申請");
        messageSendInfoEntity.setSendResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
        messageSendInfoEntity.setMessageContent(messageBody.toJSONString());
        // 开户文件
        messageSendInfoEntity.setAttachmentUris("");
        int isSucceed = messageSendInfoService.save(messageSendInfoEntity);

        return 1 == isSucceed;

    }

    /**
     * 上传开户图片
     *
     * @param accountOpenApplicationId
     * @param openAccountImagesInfo
     * @return
     */
    private boolean saveOpenAccountImage(String accountOpenApplicationId, List<OpenAccountImageInfo> openAccountImagesInfo) {

        boolean isSucceed = true;

        if (null == openAccountImagesInfo) {
            return false;
        }

        for (OpenAccountImageInfo openAccountImageInfo : openAccountImagesInfo) {
            CustomerAccountOpenImgEntity customerAccountOpenImageEntity = new CustomerAccountOpenImgEntity();
            customerAccountOpenImageEntity.setCreateTime(new Date());
            customerAccountOpenImageEntity.setApplicationId(accountOpenApplicationId);
            customerAccountOpenImageEntity.setImageLocation(openAccountImageInfo.getImageLocation());
            customerAccountOpenImageEntity.setImageLocationType(openAccountImageInfo.getImageLocationType());
            customerAccountOpenImageEntity.setFileName(CustomerAccountOpenHelper.getImageName(openAccountImageInfo.getImageLocationType()));
            customerAccountOpenImageEntity.setFileStorageName(Utils.uuid());
            customerAccountOpenImageEntity.setStoragePath(ConfigUtils.get("openAccount.userImage.savePath") + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/");
            customerAccountOpenImageEntity.setUpdateTime(new Date());
            customerAccountOpenImageEntity.setRemark(CustomerAccountOpenHelper.getImageName(customerAccountOpenImageEntity.getImageLocationType()));
            customerAccountOpenImageEntity.setExtName(FileOperaterUtil.getFileExtendName(openAccountImageInfo.getImageUrl()));

            boolean uploadSucceed = FileOperaterUtil.downloadFileByUrl(openAccountImageInfo.getImageUrl(), customerAccountOpenImageEntity.getStoragePath(), customerAccountOpenImageEntity.getFileStorageName());

            if (uploadSucceed) {
                int count = customerAccOpenImageService.save(customerAccountOpenImageEntity);

                if (count <= 0) {
                    isSucceed = false;
                }
            } else {
                isSucceed = false;
            }

            // 保证图片完整性
            if (!isSucceed) {
                logger.error("开户图片上传失败：" + openAccountImageInfo.getImageUrl());
                break;
            }
        }

        return isSucceed;

    }


    @Override
    public Page<AccountOpenApplyDetailInfo> findPage(AccountOpenApplyQuery query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        customerAccountOpenApplyDao.selectAccountOpenApplicationDetailInfo(query);
        return PageHelper.endPage();
    }

    @Override
    public List<AccountOpenApplyDetailInfo> findList(AccountOpenApplyQuery query) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.selectAccountOpenApplicationDetailInfo(query);
    }

    @Override
    public Page<AccountOpenApplyDetailInfo> findDistributePage(AccountOpenApplyAllotQuery query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        customerAccountOpenApplyDao.selectUnProcessAccountOpenApplicationRecord(query);
        return PageHelper.endPage();
    }


    @Override
    public List<AccountOpenApplyDetailInfo> findDistributeList(AccountOpenApplyAllotQuery query) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.selectUnProcessAccountOpenApplicationRecord(query);
    }


    @Override
    public AccountOpenApplyDetailInfo findByApplicationId(String applicationId) {
        AccountOpenApplyQuery query = new AccountOpenApplyQuery();
        query.setApplicationId(applicationId);
        List<AccountOpenApplyDetailInfo> accountOpenApplicationDetailInfos = findList(query);
        if (1 == accountOpenApplicationDetailInfos.size()) {
            return accountOpenApplicationDetailInfos.get(0);
        }

        return null;
    }

    /**
     * 开户影像文件备份
     *
     * @param tradeAccount
     * @param customerAccountOpenInfoId
     */
    @Override
    public void backupAccountOpenImage(String tradeAccount, String customerAccountOpenInfoId) {
        String targetDirectory = ConfigUtils.get("openAccount.files.backupPath") + "/" + tradeAccount;
        List<CustomerAccountOpenImgEntity> customerAccountOpenImages = customerAccOpenImageService.queryByAccountOpenInfoId(customerAccountOpenInfoId);

        for (CustomerAccountOpenImgEntity openAccountImageInfo : customerAccountOpenImages) {
            CustomerAccountOpenHelper.getImageName(openAccountImageInfo.getImageLocationType());
            StringBuffer resourcePath = new StringBuffer();
            resourcePath.append(openAccountImageInfo.getStoragePath()).append(openAccountImageInfo.getFileStorageName()).append(".").append(openAccountImageInfo.getExtName());
            StringBuffer targetFileName = new StringBuffer();
            targetFileName.append(CustomerAccountOpenHelper.getImageName(openAccountImageInfo.getImageLocationType())).append(".").append(openAccountImageInfo.getExtName());

            try {
                FileInputStream inputStream = new FileInputStream(resourcePath.toString());
                FileOperaterUtil.fileUpload(targetFileName.toString(), targetDirectory, inputStream);
            } catch (FileNotFoundException e) {
                logger.error("影像资料备份异常", e);
            }
        }

    }

    /**
     * 开户报表文件备份
     *
     * @param tradeAccount
     * @param customerAccountOpenInfoId
     */
    @Override
    public void backupAccountOpenReport(String tradeAccount, String customerAccountOpenInfoId) {

        String targetDirectory = ConfigUtils.get("openAccount.files.backupPath") + "/" + tradeAccount;
        String sourceDirectory = ConfigUtils.get("openAccount.user.report.userForm") + "/" + customerAccountOpenInfoId;

        File sourceFileDir = new File(sourceDirectory);
        File[] files = sourceFileDir.listFiles();
        if (null == files || files.length == 0) {
            logger.info("报表备份异常:" + customerAccountOpenInfoId);
            return;
        }
        for (File file : files) {
            try {
                FileInputStream inputStream = new FileInputStream(file.getCanonicalPath());
                FileOperaterUtil.fileUpload(file.getName(), targetDirectory, inputStream);
            } catch (Exception e) {
                logger.error("报表资料备份异常", e);
            }

        }
    }

    /**
     * 开户资料审批拒绝错误类型统计
     *
     * @return
     */
    @Override
    public Map<String, Integer> statisticsOpenAccountErrors(List<CustomerAccOpenDetailModel> accountsOpenInfo) {
        Map<String, Integer> contentErrorsTypeStatistics = new LinkedHashMap<>();

        for (CustomerAccOpenDetailModel accountOpenInfo : accountsOpenInfo) {
            // 文本资料内容错误
            if (StringUtils.isNoneBlank(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorContentTypes())) {
                List<String> errorsContentType = JSON.parseArray(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorContentTypes(), String.class);
                for (String errorContentType : errorsContentType) {
                    if (!contentErrorsTypeStatistics.containsKey(errorContentType)) {
                        contentErrorsTypeStatistics.put(errorContentType, 0);
                    }
                    contentErrorsTypeStatistics.put(errorContentType, contentErrorsTypeStatistics.get(errorContentType) + 1);
                }

            }

            // 图片内容错误
            if (StringUtils.isNoneBlank(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorImages())) {
                List<OpenAccountImageInfo> openAccountImagesErrorInfo = JSON.parseArray(accountOpenInfo.getCustomerAccountOpenApplicationModel().getErrorImages(), OpenAccountImageInfo.class);
                for (OpenAccountImageInfo openAccountImageInfo : openAccountImagesErrorInfo) {
                    String imageLocationType = String.valueOf(openAccountImageInfo.getImageLocationType());
                    if (!contentErrorsTypeStatistics.containsKey(imageLocationType)) {
                        contentErrorsTypeStatistics.put(imageLocationType, 0);
                    }

                    contentErrorsTypeStatistics.put(imageLocationType, contentErrorsTypeStatistics.get(imageLocationType) + 1);
                }

            }
        }

        return contentErrorsTypeStatistics;
    }


    /**
     * 分配开户申请给指定处理人员
     *
     * @param accountOpenApplicationsIds
     * @param userIds
     * @return
     */
    @Override
    public boolean distributeTask(List<String> accountOpenApplicationsIds, List<String> userIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        int serviceCount = userIds.size();
        for (int i = 0; i < accountOpenApplicationsIds.size(); i++) {
            String customerServiceId = userIds.get(i % serviceCount);
            CustomerAccountOpenApplyEntity entity = new CustomerAccountOpenApplyEntity();
            entity.setApplicationId(accountOpenApplicationsIds.get(i));
            entity.setAssignDrafter(customerServiceId);
            int succeedCount = customerAccountOpenApplyDao.updateAssignDrafter(entity);
            if (1 != succeedCount) {
                return false;
            }
        }

        return true;
    }


    /**
     * 取消已经分配的任务
     *
     * @param accountOpenApplicationsIds
     * @return
     */
    @Override
    public boolean cancelDistributeTask(List<String> accountOpenApplicationsIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        for (String accountOpenApplicationsId : accountOpenApplicationsIds) {
            CustomerAccountOpenApplyEntity entity = new CustomerAccountOpenApplyEntity();
            entity.setApplicationId(accountOpenApplicationsId);
            int succeedCount = customerAccountOpenApplyDao.updateAssignDrafter(entity);
        }
        return true;
    }

    /**
     * 退回至客服、持牌代表 更新申请表
     *
     * @param processTaskDto
     */
    @Override
    public void backInitialUpdateAccOpenApply(ProcessTaskDto processTaskDto, int applicationStatus) {
        CustomerAccountOpenApplyEntity customerAccountOpenApply = new CustomerAccountOpenApplyEntity();
        customerAccountOpenApply.setApplicationId(processTaskDto.getBusId());
        customerAccountOpenApply.setApplicationStatus(applicationStatus);
        customerAccountOpenApply.setUpdateTime(new Date());
        if (ShiroUtils.getUserEntity() != null) {
            customerAccountOpenApply.setLastApprovalUser(UserUtils.getCurrentUserId());
        } else {
            UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
            customerAccountOpenApply.setLastApprovalUser(workflowUser.getId());
        }
        customerAccountOpenApply.setApprovalOpinion(processTaskDto.getRemark());
        customerAccOpenApplyService.update(customerAccountOpenApply);
    }

    @Override
    public Page<AccountOpenApplyDetailInfo> findPageCheck(AccountOpenApplyQuery query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        customerAccountOpenApplyDao.selectAccountOpenApplicationDetailInfoCheck(query);
        return PageHelper.endPage();
    }

    /**
     * 編輯資料，補充資料后更新日誌表、轉待辦
     */
    @Override
    public void updateOpenAccountProcessLog(String applicationId, Integer isEdit, Integer isAdditional) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        // 设置Assign_Drafter为空
        CustomerAccountOpenApplyEntity cusAccOpenApplication = new CustomerAccountOpenApplyEntity();
        cusAccOpenApplication.setApplicationId(applicationId);
        cusAccOpenApplication.setAssignDrafter(null);
//        cusAccOpenApplication.setFireAid(0);
        customerAccountOpenApplyDao.updateAssignDrafterByApplicationId(cusAccOpenApplication);

        //任务转办
        ProcessTaskDto processTaskDto = actModelerService.findProcessTaskByBusId(cusAccOpenApplication.getApplicationId());
        actModelerService.turnToDo(processTaskDto, null);

        //更新日志
        OpenAccountProcessLogEntity openAccountProcessLog = openAccountProcessLogService.queryObjectByApplicationId(cusAccOpenApplication.getApplicationId());
        if (isEdit == BpmCommonEnum.YesNo.YES.getIndex()) {
            openAccountProcessLog.setIsEdit(isEdit);
            openAccountProcessLog.setIsEditUser(UserUtils.getCurrentUserId());
        }
        if (isAdditional == BpmCommonEnum.YesNo.YES.getIndex()) {
            openAccountProcessLog.setIsAdditional(isAdditional);
            openAccountProcessLog.setIsAdditionalUser(UserUtils.getCurrentUserId());
        }
        openAccountProcessLog.setUpdateUser(UserUtils.getCurrentUserId());
        openAccountProcessLog.setUpdateTime(new Date());
        openAccountProcessLogService.update(openAccountProcessLog);
    }

    @Override
    public List<ExtendActTasklogEntity> joinBackReasonType(List<ExtendActTasklogEntity> tasklogList) {
        for (int i = 0; i < tasklogList.size(); i++) {
            List<String> backReasonTypeList = JSON.parseArray(tasklogList.get(i).getBackReasonType(), String.class);
            StringBuilder backReasonType = new StringBuilder();
            if (null != backReasonTypeList) {
                for (String type : backReasonTypeList) {
                    String conErrorType = CodeUtils.getCodeName("AO_ALL_ERROR_TYPE", type);
                    if (StringUtils.isNotBlank(conErrorType)) {
                        backReasonType.append(conErrorType).append("，");
                    } else if (StringUtils.isNotBlank(backReasonType)) {
                        backReasonType.deleteCharAt(backReasonType.length() - 1).append("：").append(type).append("，");
                    }
                }
                tasklogList.get(i).setBackReasonType(backReasonType.length() > 0 ? backReasonType.substring(0, backReasonType.length() - 1) : "");
            }
        }
        return tasklogList;
    }

    /**
     * 备份AML开户文件
     *
     * @param tradeAccount
     * @param customerAccountOpenInfoId
     */
    @Override
    public void backupAccountOpenAml(String tradeAccount, String customerAccountOpenInfoId) {

        String targetDirectory = ConfigUtils.get("openAccount.files.backupPath") + "/" + tradeAccount;

        OpenAccountAdditionalFileEntity amlFileParams = new OpenAccountAdditionalFileEntity();
        amlFileParams.setApplicationId(customerAccountOpenInfoId);
        amlFileParams.setFileType(2);
        List<OpenAccountAdditionalFileEntity> amlFileList = openAccountAdditionalFileService.queryListByEntity(amlFileParams);

        int i = 1;
        for (OpenAccountAdditionalFileEntity amlFile : amlFileList) {
            StringBuffer resourcePath = new StringBuffer();
            resourcePath.append(amlFile.getFilePath()).append(amlFile.getFileStorageName()).append(".").append(amlFile.getFileExtName());
            StringBuffer targetFileName = new StringBuffer();
            targetFileName.append("AML文件(").append(i).append(")").append(".").append(amlFile.getFileExtName());

            try {
                FileInputStream inputStream = new FileInputStream(resourcePath.toString());
                FileOperaterUtil.fileUpload(targetFileName.toString(), targetDirectory, inputStream);
            } catch (FileNotFoundException e) {
                logger.error("AML文件备份异常", e);
            }

            i++;
        }
    }

    @Override
    public int myOpenApplicationCount() throws Exception {

        AccountOpenApplyQuery queryCondition = new AccountOpenApplyQuery();
        queryCondition.setUpdateUser(UserUtils.getCurrentUserId());

        //根据当前角色所拥有权限进入 审核页面分别为（初审 复审 终审）
        List<String> currentNodes = new ArrayList<>();
        Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("ONLINE_OPEN_ACCOUNT_MODEL_ID", null));
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

        //开户类型设置互联网
        queryCondition.setOpenAccountType(1);

        //超级管理员  不做权限验证
        if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            queryCondition.setCurrentNode(null);
        } else {
            queryCondition.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
        }

        queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());

        int count = 0;
        List<AccountOpenApplyDetailInfo> accountOpenApplyDetailInfoList = customerAccountOpenApplyDao.selectAccountOpenApplicationDetailInfoCheck(queryCondition);
        if (accountOpenApplyDetailInfoList != null) {
            count = accountOpenApplyDetailInfoList.size();
        }
        return count;
    }

    /**
     * 开户CA验证结果处理
     *
     * @param protocol
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean doCaVerityCallBack(AccountOpenApplyCallBackProtocol protocol) {

        try {

            List<CaVerityInfoProtocol> caVerityInfoList = protocol.getCaVerityInfoList();

            CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccountOpenInfoService.queryByApplicationId(protocol.getApplicationId());

            if (caVerityInfoList != null && caVerityInfoList.size() > 0) {
                for (CaVerityInfoProtocol caVerity : caVerityInfoList) {

                    OpenAccountCaVerityInfoEntity entity = new OpenAccountCaVerityInfoEntity();
                    entity.setApplicationId(protocol.getApplicationId());
                    entity.setUserId(customerAccountOpenInfo.getUserId());
                    entity.setCaCertDn(caVerity.getCaCertDn());
                    entity.setCaCertSn(caVerity.getCaCertSn());
                    entity.setCertTime(caVerity.getCertTime());
                    entity.setCreateTime(new Date());
                    entity.setUpdateTime(new Date());

                    caVerityInfoService.save(entity);
                }
            } else {

                OpenAccountCaVerityInfoEntity entity = new OpenAccountCaVerityInfoEntity();
                entity.setApplicationId(protocol.getApplicationId());
                entity.setUserId(customerAccountOpenInfo.getUserId());
                entity.setCaCertDn(null);
                entity.setCaCertSn(CharacterStringGenerate.generateCaSn(16));
                entity.setCertTime(new Date());
                entity.setCreateTime(new Date());
                entity.setUpdateTime(new Date());

                caVerityInfoService.save(entity);
            }

            CustomerAccountOpenApplyEntity customerAccOpenApp = customerAccOpenApplyService.queryObjectByApplicationId(protocol.getApplicationId());

            if (customerAccOpenApp.getApplicationStatus() == BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_PROGRESS_VALUE) {

                OpenAccountCaVerityInfoEntity queryCondition = new OpenAccountCaVerityInfoEntity();
                queryCondition.setUserId(customerAccountOpenInfo.getUserId());
                List<OpenAccountCaVerityInfoEntity> caVerityList = caVerityInfoService.queryListByBean(queryCondition);

                // CA认证成功
                if (BpmCommonEnum.CodeType.OK.getCode() == protocol.getCaVerifyStatus() || caVerityList.size() >= 2) {

                    // 更新预约申请表相关信息
                    CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                    customerAccOpenApplyEntity.setApplicationId(customerAccOpenApp.getApplicationId());
                    customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_SUCCESS_VALUE);
                    customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                    customerAccOpenApplyEntity.setUpdateTime(new Date());
                    customerAccOpenApplyEntity.setApprovalOpinion(protocol.getCaVerifyMsg());
                    UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
                    customerAccOpenApplyEntity.setLastApprovalUser(workflowUser.getId());
                    customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                    // 更新账户等级
                    CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
                    customerAccountOpenInfoEntity.setApplicationId(protocol.getApplicationId());
                    customerAccountOpenInfoEntity.setCaSignHashCode(StringUtils.isNotBlank(protocol.getCaSignHashCode()) ? protocol.getCaSignHashCode() : CharacterStringGenerate.generateCaHashNo(27) + "=");
                    customerAccOpenInfoService.update(customerAccountOpenInfoEntity);

                    // 保存CA签署文件
                    if (StringUtils.isNotBlank(protocol.getCaVerifyFileUrl())) {
                        String outPath = ConfigUtils.get("openAccount.user.report.userForm") + customerAccountOpenInfo.getApplicationId() + "/";

                        boolean uploadSucceed = FileOperaterUtil.downloadFileByUrl(protocol.getCaVerifyFileUrl(), outPath, ConfigUtils.get("ca.open.account.file.url"));
                    }

                    // 驱动工作流到下一步
                    actModelerService.doNextFlow(customerAccOpenApp.getApplicationId(), customerAccOpenApp.getInstanceId(), "");
                } else {

                    // 更新预约申请表相关信息
                    CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                    customerAccOpenApplyEntity.setApplicationId(customerAccOpenApp.getApplicationId());
                    customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_CA_VERIFY_FAILURE_VALUE);
                    customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                    customerAccOpenApplyEntity.setUpdateTime(new Date());
                    customerAccOpenApplyEntity.setApprovalOpinion(protocol.getCaVerifyMsg());
                    UserEntity workflowUser = UserUtils.getBackgroundWorkflowUser();
                    customerAccOpenApplyEntity.setLastApprovalUser(workflowUser.getId());
                    customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                    // 退回至客服
                    Map<String, Object> params = new LinkedCaseInsensitiveMap<>();

                    ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(customerAccOpenApp.getApplicationId());
                    taskDto.setRemark(protocol.getCaVerifyMsg());

                    params.put("busId", protocol.getApplicationId());

                    actModelerService.endFailFolw(taskDto, params);

                    backInitialUpdateAccOpenApply(taskDto, BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_INITIAL_AUDIT_VALUE);

                    // 新增客户开户业务流程日志记录
                    OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                    openAccountProcessLogEntity.setApplicationId(customerAccOpenApp.getApplicationId());
                    openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.YES.getIndex());
                    openAccountProcessLogEntity.setTaskId(Integer.parseInt(taskDto.getTaskId()));
                    List<String> backReasonType = Lists.newArrayList();
                    backReasonType.add("0");
                    openAccountProcessLogEntity.setBackReasonType(backReasonType.toString());
                    openAccountProcessLogEntity.setUpdateTime(new Date());
                    openAccountProcessLogService.updateByTaskId(openAccountProcessLogEntity);
                }
            }

            return true;
        } catch (Exception e) {
            logger.error("CA认证结果回调异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    /**
     * 查询开户退回记录
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<AccountOpenApplyDetailInfo> selectAccountOpenBackDetailInfo(AccountOpenApplyQuery queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.selectAccountOpenBackDetailInfo(queryCondition);
    }

    @Override
    public List<AccountOpenApplyDetailInfo> selectAccOpenDetailInfoByApplicationIds(String[] applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        Map<String, Object> params = Maps.newHashMap();
        params.put("applicationIds", applicationIds);

        return customerAccountOpenApplyDao.selectAccOpenDetailInfoByApplicationIds(params);
    }

    @Override
    public Page<AccountOpenApplyDetailInfo> findMarginPage(AccountOpenApplyQuery query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        customerAccountMarginOpenApplyDao.selectAccountOpenApplicationDetailInfo(query);
        return PageHelper.endPage();
    }

    @Override
    public void approveMarginCallback(CustomerAccOpenApproveInfo customerAccountOpenApproveInfo, ProcessTaskDto processTaskDto, Task task) {
        try {

            AccountOpenApplyDetailInfo accountOpenApplicationDetailInfo = null;
            AccountOpenApplyQuery query = new AccountOpenApplyQuery();
            query.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
            List<AccountOpenApplyDetailInfo> accountOpenApplicationDetailInfos = findMarginApplyList(query);
            if (1 == accountOpenApplicationDetailInfos.size()) {
                accountOpenApplicationDetailInfo = accountOpenApplicationDetailInfos.get(0);
            }

            if (accountOpenApplicationDetailInfo == null) {
                logger.error("增开工作流回调业务处理异常", "未查询到预约用户");
                return;
            }

            CustomerAccountMarginOpenApplyEntity applicationInfo = accountOpenApplicationDetailInfo.getCustomerAccountMarginOpenApplyEntity();
            CustomerAccountOpenInfoEntity accountOpenInfo = accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity();

            // 初审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "1").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountMarginOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountMarginOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_INITIAL_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccMarginOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(UserUtils.getManagerUser().getId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 复审节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "2").equals(customerAccountOpenApproveInfo.getCurrentNode())) {
                // 更新预约申请表相关信息
                CustomerAccountMarginOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountMarginOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_RECHECK_AUDIT_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccMarginOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                //openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 开户节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "3").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 生成开户表格
                /*if (1 == accountOpenInfo.getOpenAccountType()) {
                    String path = customerAccOpenReportGenerate.generateReport(accountOpenApplicationDetailInfo.getCustomerAccountOpenInfoEntity().getApplicationId(), BpmCommonEnum.AccountOpenReport.ACCOUNT_OPEN_REPORT_USER_FORM_REPORT);
                }*/

                // 更新预约申请表相关信息
                CustomerAccountMarginOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountMarginOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_PROGRESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccMarginOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 归档节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "4").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 更新流程信息
                applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);

                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_SUCCEED_VALUE);

                // 更新预约申请表相关信息
                CustomerAccountMarginOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountMarginOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_APPROVAL_SUCCESS_VALUE);
                customerAccOpenApplyEntity.setIsBack(BpmCommonEnum.YesNo.NO.getIndex());
                customerAccOpenApplyEntity.setUpdateTime(new Date());
                customerAccOpenApplyEntity.setLastApprovalUser(processTaskDto.getDealId());
                customerAccOpenApplyEntity.setApprovalOpinion(processTaskDto.getRemark());

                customerAccMarginOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(Integer.valueOf(task.getId()));
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);
            }

            // 终止节点回调业务处理
            if (CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "5").equals(customerAccountOpenApproveInfo.getCurrentNode())) {

                // 更新流程信息
                applicationInfo.setCallbackStatus(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_WAITING_VALUE);
                applicationInfo.setApproveResult(BpmCommonEnum.CommonProcessStatus.COMMON_PROCESS_STATUS_FAILED_VALUE);
                applicationInfo.setStatus(Constant.ActStauts.END.getValue());
                applicationInfo.setActResult("2");
                applicationInfo.setFireAid(0);

                // 新增客户开户业务流程日志记录
                OpenAccountProcessLogEntity openAccountProcessLogEntity = new OpenAccountProcessLogEntity();
                openAccountProcessLogEntity.setApplicationId(customerAccountOpenApproveInfo.getApplicationId());
                openAccountProcessLogEntity.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
                openAccountProcessLogEntity.setTaskId(null);
                openAccountProcessLogEntity.setIsEdit(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsAdditional(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackWorkflow(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsBackApp(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsReject(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setIsRejectBlacklist(BpmCommonEnum.YesNo.NO.getIndex());
                openAccountProcessLogEntity.setCreateUser(processTaskDto.getDealId());
                openAccountProcessLogEntity.setCreateTime(new Date());
//                openAccountProcessLogEntity.setUpdateTime(new Date());
                openAccountProcessLogService.save(openAccountProcessLogEntity);

            }


            // 拼接流程审核记录串
            String flowPath = applicationInfo.getFlowPath() != null ? applicationInfo.getFlowPath() + "-" + customerAccountOpenApproveInfo.getCurrentNode() : customerAccountOpenApproveInfo.getCurrentNode();
            applicationInfo.setCurrentNode(customerAccountOpenApproveInfo.getCurrentNode());
            applicationInfo.setFlowPath(flowPath);
            applicationInfo.setIsBack(null);
            applicationInfo.setApplicationStatus(null);
            applicationInfo.setLastApprovalUser(null);
            applicationInfo.setApprovalOpinion(null);
            applicationInfo.setAssignDrafter(null);
            applicationInfo.setUpdateTime(new Date());

            if (!CodeUtils.getCodeName("OPEN_ACCOUNT_MARGIN_NODE_NAME", "0").equals(customerAccountOpenApproveInfo.getCurrentNode())
                    && accountOpenInfo.getRecordStatus() != BpmCommonEnum.CommonRecordStatus.COMMON_RECORD_STATUS_DISABLE_VALUE) {
                customerAccMarginOpenApplyService.update(applicationInfo);
            }

            // 重置指定处理人为null
            customerAccountMarginOpenApplyDao.updateAssignDrafter(applicationInfo);

        } catch (Exception e) {
            logger.error("增开工作流回调业务处理异常", e);
        }
    }

    @Override
    public List<AccountOpenApplyDetailInfo> findMarginApplyList(AccountOpenApplyQuery query) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountMarginOpenApplyDao.selectAccountOpenApplicationDetailInfo(query);
    }

    @Override
    public Page<AccountOpenApplyDetailInfo> findMarginPageCheck(AccountOpenApplyQuery query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        customerAccountMarginOpenApplyDao.selectAccountOpenApplicationDetailInfoCheck(query);
        return PageHelper.endPage();
    }
}
