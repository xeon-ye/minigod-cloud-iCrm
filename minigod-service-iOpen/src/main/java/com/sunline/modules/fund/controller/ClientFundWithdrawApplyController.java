package com.sunline.modules.fund.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
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
import com.sunline.modules.fund.entity.HsCompanyBankEntity;
import com.sunline.modules.fund.helper.ClientFundWithdrawApplyHelper;
import com.sunline.modules.fund.helper.ClientFundWithdrawGenerate;
import com.sunline.modules.fund.helper.DrawChequeGenerate;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyAuditModel;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyDealModel;
import com.sunline.modules.fund.model.ClientFundWithdrawApplyModel;
import com.sunline.modules.fund.service.ClientFundWithdrawApplyService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


/**
 * 客户出金申请控制类
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-01 16:23:18
 */
@Controller
@RequestMapping("/clientFundWithdraw")
public class ClientFundWithdrawApplyController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ClientFundWithdrawApplyController.class);

    @Autowired
    private ClientFundWithdrawApplyService clientFundWithdrawApplyService;
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
    ClientFundWithdrawGenerate clientFundWithdrawGenerate;

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###,##0.00#");

    /**
     * 出金申请列表查询
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("clientFundWithdraw:list")
    public String list(Model model, ClientFundWithdrawApplyEntity queryCondition, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<ClientFundWithdrawApplyEntity> page = clientFundWithdrawApplyService.findPage(queryCondition, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("params", queryCondition);

        return "fund/clientFundWithdrawList";
    }

    /**
     * 查看/办理出金申请
     *
     * @param processTaskDto
     * @param model
     * @param flag
     * @return
     */
    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approve(ProcessTaskDto processTaskDto, Model model, String flag) {

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

        GenericHsRequest<FundRequest> requestGenericHsRequest = new GenericHsRequest<>();
        FundRequest fundRequest = new FundRequest();
        fundRequest.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
        fundRequest.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
        requestGenericHsRequest.setParams(fundRequest);

        ResponseVO responseVO = HsFundManageService.getFundTotal(requestGenericHsRequest);

        if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
            HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
            clientFundWithdrawApplyInfo.setCurrentBalance(hsFundEntity.getSpecialFetchBalance());
        }

        if (StringUtils.isNotBlank(clientFundWithdrawApplyInfo.getHsBankId())
                && StringUtils.isNotBlank(clientFundWithdrawApplyInfo.getHsBankAccount())) {
            HsCompanyBankEntity query = new HsCompanyBankEntity();
            query.setBankId(clientFundWithdrawApplyInfo.getHsBankId());
            query.setBankAccount(clientFundWithdrawApplyInfo.getHsBankAccount());
            List<HsCompanyBankEntity> hsCompanyBankEntity = hsCompanyBankService.queryListByBean(query);
            if (CollectionUtil.isNotEmpty(hsCompanyBankEntity)) {
                HsCompanyBankEntity entity = hsCompanyBankEntity.get(0);
                clientFundWithdrawApplyInfo.setHsBankName(entity.getBankName());
            }
        }

        boolean operationFlag = false;

        if ("1".equals(flag)) {
            operationFlag = true;
            ProcessTaskDto taskDto = actModelerService.findProcessTaskByBusId(processTaskDto.getBusId());
            model.addAttribute("taskDto", taskDto);
        }

        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        model.addAttribute("operationFlag", operationFlag);

        if ("1".equals(flag)) {
            return "fund/clientFundWithdrawAuditInfo";
        } else {
            return "fund/clientFundWithdrawInfo";
        }
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

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        ExtendActTasklogEntity extendActTasklogEntity = new ExtendActTasklogEntity();
        extendActTasklogEntity.setBusId(busId);
        List<ExtendActTasklogEntity> tasklogList = tasklogService.queryListProcessLog(extendActTasklogEntity);

        model.addAttribute("taskLogs", tasklogList);
        model.addAttribute("instanceId", instanceId);

        return "fund/taskLogInfo";
    }

    /**
     * 出金申请记录导出
     *
     * @param clientFundWithdrawApplyEntity
     * @param request
     * @param response
     */
    @RequestMapping(value = "/expList")
    @RequiresPermissions("clientFundWithdraw:expList")
    @SysLog("出金申请记录导出")
    public void expList(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity, HttpServletRequest request, HttpServletResponse response) {

        try {

            List<ClientFundWithdrawApplyEntity> clientFundWithdrawApplyList = clientFundWithdrawApplyService.queryList(clientFundWithdrawApplyEntity);

            List<ClientFundWithdrawApplyModel> modelList = Lists.newArrayList();

            for (ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo : clientFundWithdrawApplyList) {

                ClientFundWithdrawApplyModel model = new ClientFundWithdrawApplyModel();

                model.setCreateTime(DateUtil.format(clientFundWithdrawApplyInfo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                model.setUserId(String.valueOf(clientFundWithdrawApplyInfo.getUserId()));
                model.setClientId(clientFundWithdrawApplyInfo.getClientId());
                model.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
                model.setClientName(clientFundWithdrawApplyInfo.getClientName());
                model.setClientNameSpell(clientFundWithdrawApplyInfo.getClientNameSpell());
                model.setSex(CodeUtils.getCodeName("COMMON_SEX", String.valueOf(clientFundWithdrawApplyInfo.getSex())));
                model.setPhoneNumber(clientFundWithdrawApplyInfo.getPhoneNumber());
                model.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                model.setOccurBalance(DECIMAL_FORMAT.format(clientFundWithdrawApplyInfo.getOccurBalance()));
//                model.setWithdrawType(CodeUtils.getCodeName("FUND_BANK_TYPE", String.valueOf(clientFundWithdrawApplyInfo.getWithdrawType())));
                model.setBankName(clientFundWithdrawApplyInfo.getBankName());
                model.setSourceChannelId(String.valueOf(clientFundWithdrawApplyInfo.getSourceChannelId()));
                model.setApplicationStatus(CodeUtils.getCodeName("FUND_WITHDRAW_STATUS", String.valueOf(clientFundWithdrawApplyInfo.getApplicationStatus())));
                model.setChargeMoney(DECIMAL_FORMAT.format(clientFundWithdrawApplyInfo.getChargeMoney()));
                model.setActualBalance(DECIMAL_FORMAT.format(clientFundWithdrawApplyInfo.getActualBalance()));
                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientFundWithdrawApplyModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 出金详情打印
     *
     * @param clientFundWithdrawApplyEntity
     * @param applicationIds
     * @param response
     */
    @RequestMapping(value = "/printDetail")
//    @RequiresPermissions("clientFundWithdraw:printDetail")
    @SysLog("出金详情打印")
    public ResponseEntity<byte[]> printDetail(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity, String applicationIds, HttpServletResponse response) {
        List<String> pdfFilePathList = new ArrayList<String>();
        try {
            if (StringUtils.isNotBlank(applicationIds)) {
                String[] applicationIdArray = applicationIds.split(",");
                List<String> applicationIdList = new ArrayList<>(Arrays.asList(applicationIdArray));
                clientFundWithdrawApplyEntity.setApplicationIds(applicationIdList);
            }
            List<ClientFundWithdrawApplyEntity> clientFundWithdrawApplyList = clientFundWithdrawApplyService.queryList(clientFundWithdrawApplyEntity);

            for (ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo : clientFundWithdrawApplyList) {
                //获取当前可取余额
                GenericHsRequest<FundRequest> requestGenericHsRequest = new GenericHsRequest<>();
                FundRequest fundRequest = new FundRequest();
                fundRequest.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
                fundRequest.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                requestGenericHsRequest.setParams(fundRequest);

                ResponseVO responseVO = HsFundManageService.getFundTotal(requestGenericHsRequest);

                if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
                    HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
                    clientFundWithdrawApplyInfo.setCurrentBalance(hsFundEntity.getSpecialFetchBalance());
                }

                String pdfFilePath = clientFundWithdrawGenerate.generateReport(clientFundWithdrawApplyInfo);
                pdfFilePathList.add(pdfFilePath);
            }

            if (pdfFilePathList.size() > 0) {
                String[] pdfPaths = pdfFilePathList.toArray(new String[pdfFilePathList.size()]);
                String pdfMergePath = ConfigUtils.get("crm.file.path") + "出金详细信息_" + DateUtil.format(new Date(), "yyyyMMdd") + ".pdf";
                PdfboxUtils.mergePdfFiles(pdfPaths, pdfMergePath);

                //导出pdf文件
                File reportFile = new File(pdfMergePath);
                if (!reportFile.exists()) {
                    return null;
                }

                String defaultDownloadName = reportFile.getName();

                FileDownload.fileDownload(response, pdfMergePath, URLEncoder.encode(defaultDownloadName, "UTF-8"));
            }

        } catch (Exception e) {
            logger.error("出金详情打印", e);
        } finally {
            if (pdfFilePathList.size() > 0) {
                for (String path : pdfFilePathList) {
                    File file = new File(path);
                    if (file.exists()) {
                        boolean delete = file.delete();
                    }
                }
            }
        }
        return null;
    }

    /**
     * 出金审核记录导出
     *
     * @param clientFundWithdrawApplyEntity
     * @param request
     * @param response
     */
    @RequestMapping(value = "/expAuditList")
    @RequiresPermissions("clientFundWithdraw:expAuditList")
    @SysLog("出金审核记录导出")
    public void expAuditList(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity, HttpServletRequest request, HttpServletResponse response) {

        try {

            clientFundWithdrawApplyEntity.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_MODEL_ID", null));
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
                clientFundWithdrawApplyEntity.setCurrentNode(null);
            } else {
                clientFundWithdrawApplyEntity.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
            }

            clientFundWithdrawApplyEntity.setAssignDrafter(UserUtils.getCurrentUserId());

            List<ClientFundWithdrawApplyEntity> clientFundWithdrawApplyList = clientFundWithdrawApplyService.queryAuditList(clientFundWithdrawApplyEntity);

            List<ClientFundWithdrawApplyAuditModel> modelList = Lists.newArrayList();

            for (ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo : clientFundWithdrawApplyList) {

                ClientFundWithdrawApplyAuditModel model = new ClientFundWithdrawApplyAuditModel();

                model.setCreateTime(DateUtil.format(clientFundWithdrawApplyInfo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
                model.setClientId(clientFundWithdrawApplyInfo.getClientId());
                model.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
                model.setClientName(clientFundWithdrawApplyInfo.getClientName());
                model.setClientNameSpell(clientFundWithdrawApplyInfo.getClientNameSpell());
                model.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                model.setFrozenBalance(DECIMAL_FORMAT.format(clientFundWithdrawApplyInfo.getFrozenBalance()));
                model.setWithdrawType(CodeUtils.getCodeName("FUND_BANK_TYPE", String.valueOf(clientFundWithdrawApplyInfo.getWithdrawType())));
                model.setBankName(clientFundWithdrawApplyInfo.getBankName());
                model.setBankNo(clientFundWithdrawApplyInfo.getBankNo());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientFundWithdrawApplyAuditModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 出金处理记录导出
     *
     * @param clientFundWithdrawApplyEntity
     * @param request
     * @param response
     */
    @RequestMapping(value = "/expDealList")
    @RequiresPermissions("clientFundWithdraw:expDealList")
    @SysLog("出金处理记录导出")
    public void expDealList(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity, HttpServletRequest request, HttpServletResponse response) {

        try {

            clientFundWithdrawApplyEntity.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_MODEL_ID", null));
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
                clientFundWithdrawApplyEntity.setCurrentNode(null);
            } else {
                clientFundWithdrawApplyEntity.setCurrentNodes(currentNodes.size() > 0 ? currentNodes : Lists.newArrayList());
            }

            clientFundWithdrawApplyEntity.setAssignDrafter(UserUtils.getCurrentUserId());

            List<ClientFundWithdrawApplyEntity> clientFundWithdrawApplyList = clientFundWithdrawApplyService.queryAuditList(clientFundWithdrawApplyEntity);

            List<ClientFundWithdrawApplyDealModel> modelList = Lists.newArrayList();
            StringBuilder applicationIdsBuilder = new StringBuilder();
            int num=0;
            for (ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo : clientFundWithdrawApplyList) {

                applicationIdsBuilder.append(clientFundWithdrawApplyInfo.getApplicationId()).append(",");

                ClientFundWithdrawApplyDealModel model = new ClientFundWithdrawApplyDealModel();
                model.setNo(++num);
                model.setClientId(clientFundWithdrawApplyInfo.getClientId());
                model.setClientNameSpell(clientFundWithdrawApplyInfo.getClientNameSpell());
                model.setClientName(clientFundWithdrawApplyInfo.getClientName());

                //获取可取金额结余
                GenericHsRequest<FundRequest> requestGenericHsRequest = new GenericHsRequest<>();
                FundRequest fundRequest = new FundRequest();
                fundRequest.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
                fundRequest.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                requestGenericHsRequest.setParams(fundRequest);
                ResponseVO responseVO = HsFundManageService.getFundTotal(requestGenericHsRequest);
                if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
                    HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
                    model.setCurrentBalance(String.valueOf(hsFundEntity.getSpecialFetchBalance()));
                }else{
                    model.setCurrentBalance("");
                }

                model.setCcy(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                model.setOccurBalance(String.valueOf(clientFundWithdrawApplyInfo.getActualBalance()));
                model.setEmptyField1("");
                model.setCcy1(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                model.setFrozenBalance(String.valueOf(clientFundWithdrawApplyInfo.getActualBalance()));
                model.setEmptyField2("");
                model.setEmptyField3("");
                model.setBankCode("");
                model.setBank(clientFundWithdrawApplyInfo.getBankName());
                model.setBankAccount(clientFundWithdrawApplyInfo.getBankNo());
                model.setMark("ZSDP PRIMASIA-"+clientFundWithdrawApplyInfo.getClientId());
                model.setValueDate(DateUtil.format(new Date(),"yyyy/MM/dd"));
//                model.setParticulars("出金" + "-" + clientFundWithdrawApplyInfo.getBankName() + "-" + clientFundWithdrawApplyInfo.getBankNo());
//                model.setEmptyField4("");

                modelList.add(model);

                BigDecimal chargeMoney = clientFundWithdrawApplyInfo.getChargeMoney();
                if(chargeMoney!=null && chargeMoney.compareTo(new BigDecimal(0))>0){
                    ClientFundWithdrawApplyDealModel chargeModel = new ClientFundWithdrawApplyDealModel();
                    chargeModel.setNo(++num);
                    chargeModel.setClientId(clientFundWithdrawApplyInfo.getClientId());
                    chargeModel.setClientNameSpell(clientFundWithdrawApplyInfo.getClientNameSpell());
                    chargeModel.setClientName(clientFundWithdrawApplyInfo.getClientName());
                    if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
                        HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
                        chargeModel.setCurrentBalance(String.valueOf(hsFundEntity.getSpecialFetchBalance()));
                    }else{
                        chargeModel.setCurrentBalance("");
                    }

                    chargeModel.setCcy(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                    chargeModel.setOccurBalance(String.valueOf(clientFundWithdrawApplyInfo.getChargeMoney()));
                    chargeModel.setEmptyField1("");
                    chargeModel.setCcy1(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                    chargeModel.setFrozenBalance(String.valueOf(clientFundWithdrawApplyInfo.getChargeMoney()));
                    chargeModel.setEmptyField2("");
                    chargeModel.setEmptyField3("");
                    chargeModel.setBankCode("");
                    chargeModel.setBank(clientFundWithdrawApplyInfo.getBankName());
                    chargeModel.setBankAccount(clientFundWithdrawApplyInfo.getBankNo());
                    chargeModel.setMark("FUND WITHDRAWAL FEE-"+clientFundWithdrawApplyInfo.getClientId());
                    chargeModel.setValueDate(DateUtil.format(new Date(),"yyyy/MM/dd"));

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

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientFundWithdrawApplyDealModel.class,DateUtil.format(new Date(),"yyyyMMdd")+"-Cash Voucher");

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
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
    @RequiresPermissions("clientFundWithdraw:checkAuditList")
    public String checkAuditList(Model model, ClientFundWithdrawApplyEntity queryCondition, HttpServletRequest request) {

        try {

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            queryCondition.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_MODEL_ID", null));
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

            if (StringUtils.isBlank(queryCondition.getFlag())) {
                queryCondition.setFlag("0");
            }

            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<ClientFundWithdrawApplyEntity> page = clientFundWithdrawApplyService.queryAuditList(queryCondition, pageNum);

            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
            model.addAttribute("doPassTaskBatchFlag", currentNodes.contains("汇款"));

        } catch (Exception e) {
            logger.error("查看出金审核列表异常", e);
        }

        return "fund/clientFundWithdrawAuditList";
    }

    /**
     * 待汇款列表
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/checkRemList")
    @RequiresPermissions("clientFundWithdraw:checkRemList")
    public String checkRemList(Model model, ClientFundWithdrawApplyEntity queryCondition, HttpServletRequest request) {

        try {

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            queryCondition.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_MODEL_ID", null));
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

            if (StringUtils.isBlank(queryCondition.getFlag())) {
                queryCondition.setFlag("1");
            }

            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<ClientFundWithdrawApplyEntity> page = clientFundWithdrawApplyService.queryAuditList(queryCondition, pageNum);

            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
            model.addAttribute("doPassTaskBatchFlag", currentNodes.contains("汇款"));

        } catch (Exception e) {
            logger.error("查看出金汇款列表异常", e);
        }

        return "fund/clientFundWithdrawRemList";
    }

    /**
     * 待出账列表
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping("/checkBillList")
    @RequiresPermissions("clientFundWithdraw:checkBillList")
    public String checkDealList(Model model, ClientFundWithdrawApplyEntity queryCondition, HttpServletRequest request) {

        try {

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            queryCondition.setUpdateUser(UserUtils.getCurrentUserId());

            //根据当前角色所拥有权限进入
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_MODEL_ID", null));
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

            if (StringUtils.isBlank(queryCondition.getFlag())) {
                queryCondition.setFlag("2");
            }

            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<ClientFundWithdrawApplyEntity> page = clientFundWithdrawApplyService.queryAuditList(queryCondition, pageNum);

            model.addAttribute("page", page);
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
            model.addAttribute("doPassTaskBatchFlag", currentNodes.contains("汇款"));

        } catch (Exception e) {
            logger.error("查看出金汇款列表异常", e);
        }

        return "fund/clientFundWithdrawBillList";
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
            modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("FUND_WITHDRAW_MODEL_ID", null));

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
            parms.setTableName("client_fund_withdraw_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                // 超级管理员不做权限验证，判断当前用户审核权限
                if (!currentNodes.toString().contains(clientFundWithdrawApplyInfo.getCurrentNode()) && !UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                // 校验任务是否已被申领
                if(StringUtils.isNotBlank(clientFundWithdrawApplyInfo.getAssignDrafter())){
                    errorMsg.append(processTaskDto.getBusId()).append(",");
                    continue;
                }

                result = actModelerService.applyTaskHandle(processTaskDto, UserUtils.getCurrentUserId());
                if ("0".equals(result.get("code"))) {
                    // 更新申请表指定处理人
                    clientFundWithdrawApplyInfo.setAssignDrafter(UserUtils.getCurrentUserId());
                    clientFundWithdrawApplyInfo.setUpdateTime(new Date());
                    clientFundWithdrawApplyService.updateAssignDrafter(clientFundWithdrawApplyInfo);
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
        parms.setTableName("client_fund_withdraw_application");
        List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);
        for (ProcessTaskDto processTaskDto : processTaskDtoList) {
            try {
                result = actModelerService.deliverTaskHandle(processTaskDto);

                // 更新申请表指定处理人

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                clientFundWithdrawApplyInfo.setAssignDrafter(null);
                clientFundWithdrawApplyInfo.setUpdateTime(new Date());
                clientFundWithdrawApplyService.updateAssignDrafter(clientFundWithdrawApplyInfo);

            } catch (Exception e) {
                logger.error("批量释放办理任务异常", e);
                result = Result.error("释放失败");
            }
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

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        List<CodeEntity> fundWithdrawRejectTypes = codeService.queryChildsByMark("FUND_WITHDRAW_REJECT_TYPE");

        model.addAttribute("fundWithdrawRejectTypes", fundWithdrawRejectTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        return "fund/doTaskRejectView";
    }

    /**
     * 跳转退回页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param model
     * @return
     */
    @RequestMapping("/goBackView")
    public String goBackView(String busId, String taskId, String defId, String instanceId, String remark, Model model) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        List<CodeEntity> fundWithdrawBackTypes = codeService.queryChildsByMark("FUND_WITHDRAW_BACK_TYPE");

        model.addAttribute("fundWithdrawBackTypes", fundWithdrawBackTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        return "fund/doTaskBackView";
    }

    /**
     * 跳转出金失败页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param model
     * @return
     */
    @RequestMapping("/goWithdrawFailView")
    public String goWithdrawFailView(String busId, String taskId, String defId, String instanceId, String remark, Model model) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        List<CodeEntity> fundWithdrawFailTypes = codeService.queryChildsByMark("FUND_WITHDRAW_FAILURE_TYPE");

        model.addAttribute("fundWithdrawFailTypes", fundWithdrawFailTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        return "fund/doTaskWithdrawFailView";
    }

    /**
     * 跳转出金成功页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param model
     * @return
     */
    @RequestMapping("/goWithdrawSucView")
    public String goWithdrawSucView(String busId, String taskId, String defId, String instanceId, String remark, Model model, HttpServletRequest request) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        List<CodeEntity> fundWithdrawFailTypes = codeService.queryChildsByMark("FUND_WITHDRAW_FAILURE_TYPE");

        Page<HsCompanyBankEntity> page = hsCompanyBankService.findPage(new HsCompanyBankEntity(), pageNum);

        model.addAttribute("fundWithdrawFailTypes", fundWithdrawFailTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        model.addAttribute("page", page);
        return "fund/doTaskWithdrawSucView";
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
    Result doReject(ProcessTaskDto processTaskDto, String errorContentTypes, String otherReason, HttpServletRequest request) {

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();
                StringBuilder approvalOpinion = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("4".equals(errorContentType) && isNotBlank(otherReason)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_REJECT_TYPE", errorContentType)).append("：").append(otherReason);
                        approvalOpinion.append(CodeUtils.getCodeName("FUND_WITHDRAW_REJECT_TYPE", errorContentType)).append("：").append(otherReason);
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_REJECT_TYPE", errorContentType));
                        approvalOpinion.append(CodeUtils.getCodeName("FUND_WITHDRAW_REJECT_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                    approvalOpinion.append(",");
                }

                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1));

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());
                clientFundWithdrawApplyInfo.setApprovalOpinion(approvalOpinion.substring(0, approvalOpinion.length() - 1));

                clientFundWithdrawApplyService.terminateApplication(clientFundWithdrawApplyInfo, processTaskDto);

                actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());
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
     * 流程退回
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doBack")
    public
    @ResponseBody
    Result doBack(ProcessTaskDto processTaskDto, String errorContentTypes, String otherReason, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("2".equals(errorContentType) && isNotBlank(otherReason)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_BACK_TYPE", errorContentType)).append("：").append(otherReason);
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_BACK_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                }

                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1));

                actModelerService.endFailFolw(processTaskDto, params);
                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

            } else {
                result = Result.error("操作失败");
            }
        } catch (Exception e) {
            logger.error("退回失败", e);
            result = Result.error("操作失败");
        }

        return result;
    }

    /**
     * 出金失败
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doWithdrawFail")
    public
    @ResponseBody
    Result doWithdrawFail(ProcessTaskDto processTaskDto, String errorContentTypes, String otherReason, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();
                StringBuilder approvalOpinion = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("2".equals(errorContentType) && isNotBlank(otherReason)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_FAILURE_TYPE", errorContentType)).append("：").append(otherReason);
                        approvalOpinion.append(CodeUtils.getCodeName("FUND_WITHDRAW_FAILURE_TYPE", errorContentType));
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_FAILURE_TYPE", errorContentType));
                        approvalOpinion.append(CodeUtils.getCodeName("FUND_WITHDRAW_FAILURE_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                    approvalOpinion.append(",");
                }

                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1));

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());
                clientFundWithdrawApplyInfo.setWithdrawStatus(BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_FAILURE_VALUE);
                clientFundWithdrawApplyInfo.setApprovalOpinion(approvalOpinion.substring(0, approvalOpinion.length() - 1));

                clientFundWithdrawApplyService.updateProcessInfo(clientFundWithdrawApplyInfo, processTaskDto);

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
     * 出金成功
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doWithdrawSuc")
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

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());
                HsCompanyBankEntity hsCompanyBankEntity = hsCompanyBankService.queryObject(Long.parseLong(itemId));

                clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());
                clientFundWithdrawApplyInfo.setWithdrawStatus(BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_SUCCESS_VALUE);
                clientFundWithdrawApplyInfo.setHsBankId(hsCompanyBankEntity.getBankId());
                clientFundWithdrawApplyInfo.setHsBankAccount(hsCompanyBankEntity.getBankAccount());

                clientFundWithdrawApplyService.updateProcessInfo(clientFundWithdrawApplyInfo, processTaskDto);

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
     * 终审通过
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doFinalAuditPass")
    public
    @ResponseBody
    Result doFinalAuditPass(ProcessTaskDto processTaskDto, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

                clientFundWithdrawApplyService.updateProcessInfo(clientFundWithdrawApplyInfo, processTaskDto);

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
     * 跳转终审退回
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param model
     * @return
     */
    @RequestMapping("/goReturnView")
    public String goReturnView(String busId, String taskId, String defId, String instanceId, String remark, Model model) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        List<CodeEntity> fundWithdrawReturnTypes = codeService.queryChildsByMark("FUND_WITHDRAW_BACK_TYPE");

        model.addAttribute("fundWithdrawReturnTypes", fundWithdrawReturnTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        return "fund/doTaskWithdrawReturnView";
    }

    /**
     * 流程退回上一步
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doReturn")
    public
    @ResponseBody
    Result doReturn(ProcessTaskDto processTaskDto, String errorContentTypes, String otherReason, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("2".equals(errorContentType) && isNotBlank(otherReason)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_BACK_TYPE", errorContentType)).append("：").append(otherReason);
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_BACK_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                }

                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1));

                actModelerService.backPreviousNode(processTaskDto);

                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
            } else {
                result = Result.error("操作失败");
            }
        } catch (Exception e) {
            logger.error("退回失败", e);
            result = Result.error("操作失败");
        }

        return result;
    }

    /**
     * 批量办理任务
     *
     * @param applicationIds
     * @param remittanceType
     * @param itemId
     * @param request
     * @return
     */
    @RequestMapping(value = "/doPassTaskBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result doPassTaskBatch(String applicationIds, Integer remittanceType, String itemId, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            if (StringUtils.isEmpty(applicationIds)) {
                throw new MyException("没有勾选需要记录");
            }

            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("client_fund_withdraw_application");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                if (StringUtils.isBlank(clientFundWithdrawApplyInfo.getAssignDrafter())) {
                    return Result.error("存在未被申领任务，请先申领任务");
                }

                if (!UserUtils.getCurrentUserId().equals(clientFundWithdrawApplyInfo.getAssignDrafter())) {
                    return Result.error("存在已被其他用户申领的任务，请刷新页面后重新提交");
                }

                GenericHsRequest<FundRequest> requestGenericHsRequest = new GenericHsRequest<>();
                FundRequest fundRequest = new FundRequest();
                fundRequest.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
                fundRequest.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                requestGenericHsRequest.setParams(fundRequest);

//                ResponseVO responseVO = HsFundManageService.getFundTotal(requestGenericHsRequest);
//
//                if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
//                    HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
//                    if (hsFundEntity.getSpecialFetchBalance().doubleValue() < 0) {
//                        return Result.error("【" + clientFundWithdrawApplyInfo.getClientId() + "】客户当前可提资金小于0，请确认是否允许出金");
//                    }
//                }

                // 更新申请表指定处理人
                clientFundWithdrawApplyInfo.setAssignDrafter(UserUtils.getCurrentUserId());
                clientFundWithdrawApplyInfo.setUpdateTime(new Date());
                clientFundWithdrawApplyInfo.setRemittanceType(remittanceType);

                if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "4").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {
                    clientFundWithdrawApplyInfo.setWithdrawStatus(BpmCommonEnum.FundWithdrawStatus.FUND_WITHDRAW_STATUS_SUCCESS_VALUE);
                }

                if (StringUtils.isNotBlank(itemId)) {
                    HsCompanyBankEntity hsCompanyBankEntity = hsCompanyBankService.queryObject(Long.parseLong(itemId));

                    clientFundWithdrawApplyInfo.setHsBankId(hsCompanyBankEntity.getBankId());
                    clientFundWithdrawApplyInfo.setHsBankAccount(hsCompanyBankEntity.getBankAccount());
                }

                clientFundWithdrawApplyService.updateProcessInfo(clientFundWithdrawApplyInfo, processTaskDto);

                actModelerService.doActTask(processTaskDto, params);

//                if (CodeUtils.getCodeName("FUND_WITHDRAW_NODE_NAME", "1").equals(clientFundWithdrawApplyInfo.getCurrentNode())) {
//                    // 驱动流程下一步
//                    actModelerService.doNextFlow(processTaskDto.getBusId(), clientFundWithdrawApplyInfo.getInstanceId(), "");
//                }
            }

            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");

        } catch (Exception e) {
            logger.error("批量办理任务异常", e);
            return Result.error("批量办理任务失败");
        }
        return result;
    }

    /**
     * 初审通过
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doInitialAuditPass")
    public
    @ResponseBody
    Result doInitialAuditPass(ProcessTaskDto processTaskDto, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

                clientFundWithdrawApplyService.updateProcessInfo(clientFundWithdrawApplyInfo, processTaskDto);

                actModelerService.doActTask(processTaskDto, params);

                // 驱动流程下一步
                actModelerService.doNextFlow(processTaskDto.getBusId(), clientFundWithdrawApplyInfo.getInstanceId(), "");

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
     * 转入复审页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param model
     * @return
     */
    @RequestMapping("/goTurnToRecheckAuditView")
    public String goTurnToRecheckAuditView(String busId, String taskId, String defId, String instanceId, String remark, Model model) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        List<CodeEntity> fundWithdrawBackTypes = codeService.queryChildsByMark("FUND_WITHDRAW_RECHECK_TYPE");

        model.addAttribute("fundWithdrawBackTypes", fundWithdrawBackTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        return "fund/doTurnToRecheckAuditView";
    }

    /**
     * 转入复审
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doTurnToRecheck")
    public
    @ResponseBody
    Result doTurnToRecheck(ProcessTaskDto processTaskDto, String errorContentTypes, String otherReason, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {
                String[] errorContentTypeList = errorContentTypes.split(",");

                StringBuilder errorContent = new StringBuilder();

                for (String errorContentType : errorContentTypeList) {
                    if ("3".equals(errorContentType) && isNotBlank(otherReason)) {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_RECHECK_TYPE", errorContentType)).append("：").append(otherReason);
                    } else {
                        errorContent.append(CodeUtils.getCodeName("FUND_WITHDRAW_RECHECK_TYPE", errorContentType));
                    }

                    errorContent.append(",");
                }

                processTaskDto.setRemark(errorContent.substring(0, errorContent.length() - 1));

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
     * 汇款成功
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping("/doRemittance")
    public
    @ResponseBody
    Result doRemittance(ProcessTaskDto processTaskDto, Integer remittanceType, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {
            boolean isSecceed = ClientFundWithdrawApplyHelper.validateProcessTaskDtoIsFull(processTaskDto);

            if (isSecceed) {

                ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(processTaskDto.getBusId());

                GenericHsRequest<FundRequest> requestGenericHsRequest = new GenericHsRequest<>();
                FundRequest fundRequest = new FundRequest();
                fundRequest.setFundAccount(clientFundWithdrawApplyInfo.getFundAccount());
                fundRequest.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", String.valueOf(clientFundWithdrawApplyInfo.getMoneyType())));
                requestGenericHsRequest.setParams(fundRequest);

//                ResponseVO responseVO = HsFundManageService.getFundTotal(requestGenericHsRequest);
//
//                if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
//                    HsFundEntity hsFundEntity = JSON.parseObject(JSON.toJSONString(responseVO.getResult()), HsFundEntity.class);
//                    if (hsFundEntity.getSpecialFetchBalance().doubleValue() < 0) {
//                        return Result.error("【" + clientFundWithdrawApplyInfo.getClientId() + "】客户当前可提资金小于0，请确认是否允许出金");
//                    }
//                }

                clientFundWithdrawApplyInfo.setLastApprovalUser(UserUtils.getCurrentUserId());
                clientFundWithdrawApplyInfo.setRemittanceType(remittanceType);

                clientFundWithdrawApplyService.update(clientFundWithdrawApplyInfo);

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
     * 跳转批量汇款页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param applicationIds
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/goPassRemBatchView")
    public String goPassRemBatchView(String busId, String taskId, String defId, String instanceId, String remark, String applicationIds, Model model, HttpServletRequest request) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        List<CodeEntity> fundWithdrawRemTypes = codeService.queryChildsByMark("FUND_WITHDRAW_REMITTANCE_TYPE");

        model.addAttribute("fundWithdrawRemTypes", fundWithdrawRemTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        model.addAttribute("applicationIds", applicationIds);
        return "fund/doPassRemBatchView";
    }

    /**
     * 跳转批量出账页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param applicationIds
     * @param model
     * @return
     */
    @RequestMapping("/goPassBillBatchView")
    public String goPassBillBatchView(String busId, String taskId, String defId, String instanceId, String remark, String applicationIds, Model model, HttpServletRequest request) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        List<CodeEntity> fundWithdrawFailTypes = codeService.queryChildsByMark("FUND_WITHDRAW_FAILURE_TYPE");

        Page<HsCompanyBankEntity> page = hsCompanyBankService.findPage(new HsCompanyBankEntity(), pageNum);

        model.addAttribute("fundWithdrawFailTypes", fundWithdrawFailTypes);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        model.addAttribute("page", page);
        model.addAttribute("applicationIds", applicationIds);
        return "fund/doPassBillBatchView";
    }

    /**
     * 跳转批量打印支票页面
     *
     * @param busId
     * @param taskId
     * @param defId
     * @param instanceId
     * @param remark
     * @param applicationIds
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/goPrintChequeView")
    public String goPrintChequeView(String busId, String taskId, String defId, String instanceId, String remark, String applicationIds, Model model, HttpServletRequest request) {

        ProcessTaskDto taskDto = new ProcessTaskDto();
        taskDto.setBusId(busId);
        taskDto.setTaskId(taskId);
        taskDto.setInstanceId(instanceId);
        taskDto.setDefId(defId);
        taskDto.setRemark(remark);

        ClientFundWithdrawApplyEntity clientFundWithdrawApplyInfo = clientFundWithdrawApplyService.queryByApplicationId(busId);
        List<CodeEntity> codeList = codeService.queryChildsByMark("FUND_WITHDRAW_CHEQUE_TYPE");

        model.addAttribute("codeList", codeList);
        model.addAttribute("info", clientFundWithdrawApplyInfo);
        model.addAttribute("taskDto", taskDto);
        model.addAttribute("applicationIds", applicationIds);
        return "fund/doPrintChequeView";
    }

    /**
     * 打印支票
     *
     * @param applicationIds
     * @param chequeType
     * @param day
     * @param month
     * @param year
     * @param nameType
     * @param request
     * @return
     */
    @RequestMapping(value = "/doPrintCheque", method = RequestMethod.GET)
    public ResponseEntity<byte[]> doPrintCheque(String applicationIds, String chequeType, String day, String month, String year, String nameType
            , HttpServletRequest request, HttpServletResponse response) {

        try {

            if (StringUtils.isEmpty(applicationIds)) {
                throw new MyException("没有勾选需要记录");
            }

            Map<String, String> params = Maps.newHashMap();
            params.put("chequeType", chequeType);

            if (StringUtils.isNotBlank(day) && StringUtils.isNotBlank(month) && StringUtils.isNotBlank(year)) {
                params.put("day", day);
                params.put("month", month);
                params.put("year", year);
            } else {

                DateFormat df = new SimpleDateFormat("MMM", Locale.ENGLISH);
                params.put("day", DateUtil.format(new Date(), "dd"));
                params.put("month", df.format(new Date()));
                params.put("year", DateUtil.format(new Date(), "yyyy"));
            }

            params.put("nameType", nameType);

            List<ClientFundWithdrawApplyEntity> clientFundWithdrawApplyList = clientFundWithdrawApplyService.queryByApplicationIds(applicationIds);

            String filePath = DrawChequeGenerate.draw(clientFundWithdrawApplyList, params);
//            File[] files = FileUtil.ls(filePath);
            File[] files = ClientFundWithdrawApplyHelper.orderByName(filePath);

            // 存储文件
            String srcFilePath = ConfigUtils.get("template.file.path") + "/fund/fund_withdraw_cheque_template.pdf";
            String destFilePath = ConfigUtils.get("crm.file.path") + "/fund/" + DateUtil.format(new Date(), "yyyyMMdd") + "/" + Utils.uuid() + "/";

            int i = 1;

            for (File file : files) {
                ByteArrayOutputStream bos = DrawChequeGenerate.fillTemplate(srcFilePath, ImageIO.read(file));

                String fileName = i + ".pdf";
                if (!FileOperaterUtil.fileUpload(destFilePath + fileName, bos.toByteArray())) {
                    logger.error("生成支票PDF文件失败");
                }

                i++;
            }

            File[] pdfFiles = ClientFundWithdrawApplyHelper.orderByName(destFilePath);
            List<String> pdfPaths = Lists.newArrayList();
            for (File file : pdfFiles) {
                pdfPaths.add(file.getPath().replace("\\", "/"));
            }

            String mergePdfName = Utils.uuid() + ".pdf";
            PdfboxUtils.mergePdfFiles(pdfPaths.toArray(new String[pdfPaths.size()]), destFilePath + mergePdfName);

            FileDownload.fileDownload(response, destFilePath + mergePdfName, mergePdfName);
        } catch (Exception e) {
            logger.error("打印支票异常", e);
        }

        return null;
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result updateApplication(ClientFundWithdrawApplyEntity update) {

        int update1 = clientFundWithdrawApplyService.updateByApplicationId(update);
        if (update1 > 0) {
            return Result.ok();
        } else {
            return Result.error("更新失败");
        }
    }
}
