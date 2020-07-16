package com.sunline.modules.stock.controller;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.commission.entity.FarePackageSetupEntity;
import com.sunline.modules.commission.service.FarePackageSetupService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.quotation.protocol.request.StockQuotRequest;
import com.sunline.modules.quotation.service.StockQuotService;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.helper.DonatedStockReportGenerate;
import com.sunline.modules.stock.model.DonatedStockAppInfoModel;
import com.sunline.modules.stock.model.DonatedStockApplicationInfoModel;
import com.sunline.modules.stock.model.DonatedStockExpModel;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.service.RoleService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 类的功能描述.
 * 增股管理
 *
 * @Auther fuyy
 * @Date 2018/12/6
 */
@RequestMapping("donatedStock")
@Controller
public class DonatedStockController {
    private static final Logger logger = LoggerFactory.getLogger(DonatedStockController.class);

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    DonatedStockApplicationInfoService donatedStockService;

    @Autowired
    ActModelerService actModelerService;

    @Autowired
    RoleService roleService;

    @Autowired
    TaskService taskService;

    @Autowired
    DonatedStockReportGenerate donatedStockReportGenerate;

    @Autowired
    CustomerAccOpenReportGenerate customerAccOpenReportGenerate;

    @Autowired
    FarePackageSetupService farePackageService;

    /**
     * 领取列表
     */
    @RequestMapping("/receiveList")
    @RequiresPermissions("donatedStock:receiveList")
    public String receiveList(Model model, DonatedStockApplicationInfoEntity queryCondition, HttpServletRequest request) throws Exception {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        String receiveTimeStart = queryCondition.getReceiveTimeStart();
        String receiveTimeEnd = queryCondition.getReceiveTimeEnd();
        if (receiveTimeStart != null && StringUtils.isNotBlank(receiveTimeStart)) {
            queryCondition.setReceiveTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(receiveTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }
        if (receiveTimeEnd != null && StringUtils.isNotBlank(receiveTimeEnd)) {
            queryCondition.setReceiveTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(receiveTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        Page<DonatedStockApplicationInfoEntity> page = donatedStockService.findPageList(queryCondition, pageNum);

        if (receiveTimeStart != null && StringUtils.isNotBlank(receiveTimeStart)) {
            queryCondition.setReceiveTimeStart(receiveTimeStart);
        }
        if (receiveTimeEnd != null && StringUtils.isNotBlank(receiveTimeEnd)) {
            queryCondition.setReceiveTimeEnd(receiveTimeEnd);
        }

        model.addAttribute("page", page);
        model.addAttribute("queryCondition", queryCondition);

        return "stock/receiveStockList";
    }

    /**
     * 增股领取详情
     *
     * @param processTaskDto
     * @param model
     * @param
     * @return
     */
    @RequestMapping(value = "donatedStockApprove", method = RequestMethod.POST)
    public String donatedStockApprove(ProcessTaskDto processTaskDto, Model model, String flag) throws Exception {

        DonatedStockApplicationInfoEntity donatedStockApplicationInfo = donatedStockService.queryDetailByApplicationId(processTaskDto.getBusId());

        //状态是待初审、待复审 获取工作流运行时任务ID
        if (donatedStockApplicationInfo.getApplicationStatus() == 1 || donatedStockApplicationInfo.getApplicationStatus() == 2) {
            // 获取工作流运行时任务ID
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).list();
            processTaskDto.setTaskId(tasks.size() > 0 ? tasks.get(0).getId() : null);

            model.addAttribute("flag", "2");
        } else {
            model.addAttribute("flag", "1");
        }

        //超级管理员 不做权限验证
        if (UserUtils.getCurrentUserId().equals(Constant.SUPERR_USER)) {
            model.addAttribute("operationFlag", true);
        } else {

            boolean operationFlag = false;

            //根据model获取节点审批人员信息  根据当前角色跟节点是否匹配，匹配显示同意、拒绝按钮
            List<String> currentNodes = new ArrayList<>();
            Map<String, List<String>> modelNodeRoleList = actModelerService.getModelNodeUser(SysConfigUtil.getSysConfigValue("DONATED_STOCK_MODEL_ID", null));
            List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");
            for (String key : modelNodeRoleList.keySet()) {
                List<String> modelNodeRole = modelNodeRoleList.get(key);
                for (String aModelNodeRole : modelNodeRole) {
                    for (RoleEntity role : roleList) {
                        if (role.getId().equals(aModelNodeRole)) {
                            if (key.equals(donatedStockApplicationInfo.getCurrentNode())) {
                                operationFlag = true;
                            }
                        }
                    }
                }
            }

            model.addAttribute("operationFlag", operationFlag);
        }

        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("donatedStockInfo", donatedStockApplicationInfo);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());

        return "stock/donatedStockApprove";
    }

    /**
     * 流程拒绝
     *
     * @param processTaskDto 办理流程任务dto
     * @return
     */
    @RequestMapping("doReject")
    public
    @ResponseBody
    Result doReject(ProcessTaskDto processTaskDto) {
        Result result = null;
        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            throw new MyException("任务id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            throw new MyException("流程定义id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            throw new MyException("实例id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getBusId())) {
            throw new MyException("业务id不能为空");
        }
        DonatedStockApplicationInfoEntity applicationInfo = donatedStockService.queryByApplicationId(processTaskDto.getBusId());

        applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

        donatedStockService.terminateDonatedApplication(applicationInfo, processTaskDto);

        try {

            actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
        } catch (Exception e) {
            logger.error("拒绝失败", e);
            result = Result.error("操作失败");
        }

        return result;
    }

    /**
     * 领取列表导出Excel
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "/receiveStockExpExcel")
    @RequiresPermissions("donatedStockExpExcel:exp")
    @SysLog("领取列表导出")
    public void receiveStockExpExcel(DonatedStockApplicationInfoEntity queryCondition, HttpServletRequest request, HttpServletResponse response) {
        try {

            String receiveTimeStart = queryCondition.getReceiveTimeStart();
            String receiveTimeEnd = queryCondition.getReceiveTimeEnd();
            if (StringUtils.isNotBlank(receiveTimeStart)) {
                queryCondition.setReceiveTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(receiveTimeStart)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(receiveTimeEnd)) {
                queryCondition.setReceiveTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(receiveTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
            }

            List<DonatedStockApplicationInfoEntity> stockList = donatedStockService.findPageListExecl(queryCondition);

            List<DonatedStockApplicationInfoModel> modelList = Lists.newArrayList();

            for (int i = 0; i < stockList.size(); i++) {
                DonatedStockApplicationInfoModel model = new DonatedStockApplicationInfoModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setReceiveTime(stockList.get(i).getReceiveTime() != null ? DATETIME_FORMAT.format(stockList.get(i).getReceiveTime()) : "");
                model.setActivityId(stockList.get(i).getActivityId());
                model.setChannelId(stockList.get(i).getChannelId());
                model.setChannelName(stockList.get(i).getChannelName());
                model.setBankType(CodeUtils.getCodeName("DONATED_STOCK_AO_WAY", stockList.get(i).getBankType() != null ? stockList.get(i).getBankType().toString() : ""));
                model.setUserId(stockList.get(i).getUserId());
                model.setClientId(stockList.get(i).getClientId());
                model.setClientName(stockList.get(i).getClientName());
                model.setPhoneNumber(stockList.get(i).getPhoneNumber());
                model.setStockCode(stockList.get(i).getStockCode());
                model.setStockName(stockList.get(i).getStockName());
                model.setTotalCost(stockList.get(i).getTotalCost() != null ? stockList.get(i).getTotalCost().toString() : "");
                model.setStockQuantity(stockList.get(i).getStockQuantity().toString());

                model.setApplicationStatus(CodeUtils.getCodeName("AO_DONATED_STOCK_STATUS", stockList.get(i).getApplicationStatus() != null ? stockList.get(i).getApplicationStatus().toString() : ""));

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, DonatedStockApplicationInfoModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }


    /**
     * 待入账列表页
     *
     * @param model
     * @param queryCondition
     * @param request
     * @return
     * @throws Exception
     */

    @RequestMapping("/dealAccountList")
    @RequiresPermissions("donatedStock:dealAccountList")
    public String dealAccountList(Model model, DonatedStockApplicationInfoEntity queryCondition, HttpServletRequest request) throws Exception {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
//
//        String receiveTimeStart = queryCondition.getReceiveTimeStart();
//        String receiveTimeEnd = queryCondition.getReceiveTimeEnd();
//        if (receiveTimeStart != null && StringUtils.isNotBlank(receiveTimeStart)) {
//            queryCondition.setReceiveTimeStart(DateUtil.format(DateUtil.beginOfDay(new Date()), "yyyy-MM-dd HH:mm:ss"));
//        }
//        if (receiveTimeEnd != null && StringUtils.isNotBlank(receiveTimeEnd)) {
//            queryCondition.setReceiveTimeEnd(DateUtil.format(DateUtil.endOfDay(new Date()), "yyyy-MM-dd HH:mm:ss"));
//        }
//
//        Page<DonatedStockApplicationInfoEntity> page = donatedStockService.findPageDealAccount(queryCondition, pageNum);
//
//        if (receiveTimeStart != null && StringUtils.isNotBlank(receiveTimeStart)) {
//            queryCondition.setReceiveTimeStart(receiveTimeStart);
//        }
//        if (receiveTimeEnd != null && StringUtils.isNotBlank(receiveTimeEnd)) {
//            queryCondition.setReceiveTimeEnd(receiveTimeEnd);
//        }

//        model.addAttribute("page", page);
        model.addAttribute("queryCondition", queryCondition);

        return "stock/dealAccountList";
    }

    /**
     * 待入账列表数据
     *
     * @return
     * @throws Exception
     */

    @RequestMapping("/dealAccountListData")
    @RequiresPermissions("donatedStock:dealAccountList")
    @ResponseBody
    public Result dealAccountListData(@RequestParam Map<String, Object> params) throws Exception {
        //查询列表数据
        Query query = new Query(params);
        List<DonatedStockApplicationInfoEntity> entities = donatedStockService.queryEntryListByOrder(query);
        query.put("applicationStatus",3);
        int total = donatedStockService.queryTotal(query);
        List<DonatedStockAppInfoModel> modelList = new ArrayList<DonatedStockAppInfoModel>(entities.size());
        entities.forEach(entity->{
            DonatedStockAppInfoModel model = new DonatedStockAppInfoModel();
            BeanUtils.copyProperties(entity, model);
            model.setAccountEntryStatus(CodeUtils.getCodeName("AO_ACCOUNT_ENTRY_STATUS", String.valueOf(entity.getAccountEntryStatus())));
            model.setPrintStatus(CodeUtils.getCodeName("AO_PRINT_STATUS", String.valueOf(entity.getPrintStatus())));
            model.setStampDutyStatus(CodeUtils.getCodeName("AO_STAMP_DUTY_STATUS", String.valueOf(entity.getStampDutyStatus())));
            model.setReceiveTime(DateUtil.format(entity.getReceiveTime(),"yyyy-MM-dd HH:mm:ss"));
            modelList.add(model);
        });

        PageUtils pageUtil = new PageUtils(modelList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);

    }

    /**
     * 查询是否存在需要打印的数据
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "dealAccountPrintExist", method = RequestMethod.POST)
    @ResponseBody
    public String dealAccountPrintExist(DonatedStockApplicationInfoEntity queryCondition, HttpServletRequest request) {

        String receiveTimeStart = queryCondition.getReceiveTimeStart();
        String receiveTimeEnd = queryCondition.getReceiveTimeEnd();
        if (receiveTimeStart != null && StringUtils.isNotBlank(receiveTimeStart)) {
            queryCondition.setReceiveTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(receiveTimeStart)), "yyyy-MM-dd HH:mm:ss"));
        }

        if (receiveTimeEnd != null && StringUtils.isNotBlank(receiveTimeEnd)) {
            queryCondition.setReceiveTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(receiveTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
        }

        List<DonatedStockApplicationInfoEntity> stockList = donatedStockService.queryDealAccountPrint(queryCondition);
        if (stockList.size() > 0) {
            return CodeUtils.getCodeName("COMMON_STATUS", "-2");
        } else {
            return CodeUtils.getCodeName("COMMON_STATUS", "-1");
        }
    }

    /**
     * 待入账列表 打印
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "dealAccountPrint", method = RequestMethod.GET)
    @RequiresPermissions("dealAccountPrint:exp")
    @SysLog("待入账列表打印")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<byte[]> dealAccountPrint(DonatedStockApplicationInfoEntity queryCondition, HttpServletRequest request, HttpServletResponse response) {
        try {

            String receiveTimeStart = queryCondition.getReceiveTimeStart();
            String receiveTimeEnd = queryCondition.getReceiveTimeEnd();
            if (StringUtils.isNotBlank(receiveTimeStart)) {
                queryCondition.setReceiveTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(receiveTimeStart)), "yyyy-MM-dd HH:mm:ss"));
            }

            if (StringUtils.isNotBlank(receiveTimeEnd)) {
                queryCondition.setReceiveTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(receiveTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
            }

            List<DonatedStockApplicationInfoEntity> stockList = donatedStockService.queryDealAccountPrint(queryCondition);


            List<String> pdfFilePathList = new ArrayList<String>();
            int num=1;
            for (DonatedStockApplicationInfoEntity donatedStockInfo : stockList) {
                donatedStockInfo.setNum(num);
                //生成pdf文件
                String pdfFilePath = donatedStockReportGenerate.generateReport(donatedStockInfo);
                pdfFilePathList.add(pdfFilePath);

                donatedStockInfo.setPrintStatus(BpmCommonEnum.PrintStatus.PRINT_STATUS_YES_VALUE);
                donatedStockInfo.setPrintOperator(UserUtils.getCurrentUserId());
                donatedStockService.update(donatedStockInfo);
                num++;
            }
            pdfFilePathList.removeAll(Collections.singleton(null));
            if (pdfFilePathList.size() > 0) {
                String[] pdfPaths = pdfFilePathList.toArray(new String[pdfFilePathList.size()]);
                String pdfMergePath = ConfigUtils.get("donatedStock.user.report.userForm.merge") + "印花税_" + DateUtil.format(new Date(), "yyyyMMddHHmmssSSS") + ".pdf";
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
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("待入账打印异常", e);
        }
        return null;

    }

    /**
     * 已缴纳印花税
     *
     * @param
     * @return
     */
    @RequestMapping(value = "payStampDuty", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result payStampDuty(String ids, HttpServletRequest request) {
        if (StringUtils.isEmpty(ids)) {
            throw new MyException("未勾选！");
        }

        try {

            List<DonatedStockApplicationInfoEntity> donatedStockList = donatedStockService.queryObjectIds(ids);
            for (DonatedStockApplicationInfoEntity donatedStockInfo : donatedStockList) {
                if (BpmCommonEnum.PrintStatus.PRINT_STATUS_NO_VALUE == donatedStockInfo.getPrintStatus()) {
                    throw new MyException("有未打印的印花税，请先打印");
                }
                //打印状态-已打印 缴纳印花税状态-未缴纳印花税
                if (BpmCommonEnum.PrintStatus.PRINT_STATUS_YES_VALUE == donatedStockInfo.getPrintStatus() && BpmCommonEnum.StampDutyStatus.STAMP_DUTY_STATUS_NO_VALUE == donatedStockInfo.getStampDutyStatus()) {
                    //设置为已缴纳印花税
                    donatedStockInfo.setStampDutyStatus(BpmCommonEnum.StampDutyStatus.STAMP_DUTY_STATUS_YES_VALUE);
                    donatedStockInfo.setStampDutyOperator(UserUtils.getCurrentUserId());

                    //设置为待入账
                    donatedStockInfo.setAccountEntryStatus(BpmCommonEnum.AccountEntryStatus.ACCOUNT_ENTRY_STATUS_NO_VALUE);
                    donatedStockService.update(donatedStockInfo);
                }
            }

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("已缴纳印花税异常!", e);
            return Result.error("操作失败");
        }
        return Result.ok();
    }

    /**
     * 授权入账
     *
     * @param
     * @return
     */
    @RequestMapping(value = "dealAccount", method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    public Result dealAccount(String ids, HttpServletRequest request) {
        if (StringUtils.isEmpty(ids)) {
            throw new MyException("未勾选！");
        }
        try {
            List<DonatedStockApplicationInfoEntity> donatedStockList = donatedStockService.queryObjectIds(ids);
            for (DonatedStockApplicationInfoEntity donatedStockInfo : donatedStockList) {
                //设置为入账中
                donatedStockInfo.setAccountEntryStatus(BpmCommonEnum.AccountEntryStatus.ACCOUNT_ENTRY_STATUS_DEALING_VALUE);
                donatedStockService.update(donatedStockInfo);
            }

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("授权入账异常!", e);
            return Result.error("操作失败");
        }
        return Result.ok();
    }

    /**
     * 待入账列表导出Excel
     *
     * @param queryCondition
     * @param request
     * @return
     */
    @RequestMapping(value = "/dealAccountExcel")
//    @RequiresPermissions("donatedStockExpExcel:exp")
    @SysLog("待入账列表导出Excel")
    public void dealAccountExcel(DonatedStockApplicationInfoEntity queryCondition, HttpServletRequest request, HttpServletResponse response) {
        try {

            String receiveTimeStart = queryCondition.getReceiveTimeStart();
            String receiveTimeEnd = queryCondition.getReceiveTimeEnd();
            if (StringUtils.isNotBlank(receiveTimeStart)) {
                queryCondition.setReceiveTimeStart(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(receiveTimeStart)), "yyyy-MM-dd HH:mm:ss"));
            }
            if (StringUtils.isNotBlank(receiveTimeEnd)) {
                queryCondition.setReceiveTimeEnd(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(receiveTimeEnd)), "yyyy-MM-dd HH:mm:ss"));
            }

            List<DonatedStockApplicationInfoEntity> stockList = donatedStockService.findPageListExecl(queryCondition);
            FarePackageSetupEntity farePackage = new FarePackageSetupEntity();
            farePackage.setFareKind("9999");
            farePackage.setFareType(1);
            farePackage = farePackageService.queryObject(farePackage);

            List<DonatedStockExpModel> modelList = Lists.newArrayList();

            stockList.removeAll(Collections.singleton(null));
            for (int i = 0; i < stockList.size(); i++) {
                DonatedStockExpModel model = new DonatedStockExpModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setApplicationId(stockList.get(i).getApplicationId());
                model.setClientId(stockList.get(i).getClientId());
                model.setFundAccount(stockList.get(i).getFundAccount());
                model.setClientName(stockList.get(i).getClientName());
                model.setClientNameSpell(stockList.get(i).getClientNameSpell());
                model.setOpenAccountTime(DateUtil.format(stockList.get(i).getOpenAccountTime(), "yyyy-MM-dd"));
                model.setActivType(CodeUtils.getCodeName("DONATED_STOCK_TYPE", String.valueOf(stockList.get(i).getActivType())));
                model.setExchangeType("香港");
                model.setStockCode(stockList.get(i).getStockCode());
                model.setStockName(stockList.get(i).getStockName());
                model.setStockQuantity(stockList.get(i).getStockQuantity().toString());
                //查询昨收价
                GenericHsRequest<StockQuotRequest> genericHsRequest = new GenericHsRequest<>();
                StockQuotRequest stockQuotRequest = new StockQuotRequest();

                stockQuotRequest.setAssetId(stockList.get(i).getStockCode());
                genericHsRequest.setParams(stockQuotRequest);
                ResponseVO responseVo = StockQuotService.getStockQuot(genericHsRequest);

                JSONObject result = JSONObject.parseObject(JSON.toJSONString(responseVo.getResult()));

                model.setClosingPrice(result.get("price") != null ? result.get("price").toString() : "");
                model.setClosingPriceDate(DateUtil.formatDate(new Date()));
                model.setStampDutyRatio(String.valueOf(farePackage.getBalanceRatio()));

                //计算印花税
                BigDecimal stampDuty = farePackage.getBalanceRatio().multiply(new BigDecimal(stockList.get(i).getStockQuantity()))
                        .multiply(new BigDecimal(model.getClosingPrice()));
                model.setStampDutyC(String.valueOf(Math.ceil(stampDuty.doubleValue())));
                model.setStampDutyZ(String.valueOf(Math.ceil(stampDuty.doubleValue())));
                double total = Double.parseDouble(model.getStampDutyC()) + Double.parseDouble(model.getStampDutyZ());
                model.setTotal(String.valueOf(total));

                model.setFirstIncomeDate(stockList.get(i).getFirstIncomeDate());
                model.setFirstIncome(stockList.get(i).getFirstIncome());
                model.setFirstTransferDate(stockList.get(i).getFirstTransferDate());
                model.setFirstTransfer(stockList.get(i).getFirstTransfer());
                //设置开户途径
                String type = stockList.get(i).getOpenAccountType();
                String open = "";
                if (org.apache.commons.lang3.StringUtils.isNotEmpty(type)) {
                    if ("0".equals(type)) {
                        open = "未知";
                    } else if ("1".equals(type)) {
                        open = "互联网开户";
                        Integer bankType = stockList.get(i).getBankType();
                        if(null != bankType) {
                            if (0 == bankType) {
                                open = "香港银行卡";
                            } else if (1 == bankType && stockList.get(i).getOpenAccountTime().getTime() < DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                                open = "大陆银行卡";
                            } else if (1 == bankType && stockList.get(i).getOpenAccountTime().getTime() > DateUtil.parse("2019-01-12 16:30:00").getTime()) {
                                open = "SZCA电子证书";
                            }
                        }
                    } else if ("2".equals(type)) {
                        open = "线下开户";
                    } else if ("3".equals(type)) {
                        open = "BPM开户";
                    }
                }
                model.setOpenAccountType(open);
                modelList.add(model);
            }

            DonatedStockExpModel model = new DonatedStockExpModel();
            model.setId("合计");
            model.setClientId("");
            model.setClientName("");
            model.setClientNameSpell("");
            model.setStockCode("");
            model.setStockName("");
            model.setStockQuantity("");
            model.setClosingPrice("");
            model.setClosingPrice("");
            model.setStampDutyRatio("");
            //客户印花税 总和
            double sumC = 0;
            //自营印花税 总和
            double sumZ = 0;
            //印花税汇总
            double sumTotal = 0;
            for (int i = 0; i < modelList.size(); i++) {
                sumC += Double.parseDouble(modelList.get(i).getStampDutyC());
                sumZ += Double.parseDouble(modelList.get(i).getStampDutyZ());
                sumTotal += Double.parseDouble(modelList.get(i).getTotal());
            }
            model.setStampDutyC(String.valueOf(sumC));
            model.setStampDutyZ(String.valueOf(sumZ));
            model.setTotal(String.valueOf(sumTotal));

            modelList.add(model);

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, DonatedStockExpModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 赠股通知
     *
     * @return
     */
    @RequestMapping(value = "/myStockList")
    @ResponseBody
    public Result getStockNotice() {

        List<RoleEntity> roleList = roleService.queryByUserId(UserUtils.getCurrentUserId(), "0");

        for (RoleEntity role : roleList) {
            if ("赠股运营".equals(role.getName())) {
                return Result.ok("donatedStock/receiveList?applicationStatus=1");
            }

            if ("运营主管".equals(role.getName())) {
                return Result.ok("donatedStock/receiveList?applicationStatus=1");
            }

            if ("结算".equals(role.getName())) {
                return Result.ok("donatedStock/dealAccountList?printStatus=1&stampDutyStatus=1");
            }
        }
        return Result.ok("donatedStock/receiveList?applicationStatus=1");
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
    public Result doPassTaskBatch(String applicationIds, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        if (org.apache.commons.lang3.StringUtils.isEmpty(applicationIds)) {
            throw new MyException("没有勾选需要记录");
        }
        try {
            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("donated_stock_application_info");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            StringBuffer message = new StringBuffer("操作成功!");
            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                DonatedStockApplicationInfoEntity applicationInfo = donatedStockService.queryByApplicationId(processTaskDto.getBusId());

                if (applicationInfo.getApplicationStatus() == BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT_VALUE
                        || applicationInfo.getApplicationStatus() == BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT_VALUE) {

                    // 更新申请表指定处理人
                    applicationInfo.setAssignDrafter(UserUtils.getCurrentUserId());
                    applicationInfo.setUpdateTime(new Date());
                    actModelerService.doActTask(processTaskDto, params);
                } else {
                    message.append(applicationInfo.getApplicationId())
                            .append("任务处理失败，原因是当前任务状态为：")
                            .append(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", String.valueOf(applicationInfo.getApplicationStatus())))
                            .append(";");
                }
            }

            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), message.toString());

        } catch (Exception e) {
            logger.error("批量办理任务异常", e);
            return Result.error("批量办理任务失败");
        }
        return result;
    }

    /**
     * 批量拒绝任务
     *
     * @param applicationIds
     * @param request
     * @return
     */
    @RequestMapping(value = "/doRejectTaskBatch", method = RequestMethod.POST)
    @ResponseBody
    public Result doRejectTaskBatch(String applicationIds, HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
        for (String key : parameterMap.keySet()) {
            params.put(key, parameterMap.get(key)[0]);
        }

        Result result = null;

        try {

            if (org.apache.commons.lang3.StringUtils.isEmpty(applicationIds)) {
                throw new MyException("没有勾选需要记录");
            }

            ProcessTaskDto parms = new ProcessTaskDto();
            parms.setBusId(applicationIds);
            parms.setTableName("donated_stock_application_info");
            List<ProcessTaskDto> processTaskDtoList = actModelerService.queryValidApplyTask(parms);

            StringBuffer message = new StringBuffer("操作成功!");
            for (ProcessTaskDto processTaskDto : processTaskDtoList) {

                DonatedStockApplicationInfoEntity applicationInfo = donatedStockService.queryByApplicationId(processTaskDto.getBusId());

                if (applicationInfo.getApplicationStatus() == BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_INITIAL_AUDIT_VALUE
                        || applicationInfo.getApplicationStatus() == BpmCommonEnum.DonatedStockApplicationStatus.DONATED_STK_APPLICATE_STATUS_RECHECK_AUDIT_VALUE) {

                    applicationInfo.setLastApprovalUser(UserUtils.getCurrentUserId());

                    donatedStockService.terminateDonatedApplication(applicationInfo, processTaskDto);

                    actModelerService.terminationFlow(processTaskDto, Constant.ActTaskResult.REJECT.getValue());
                } else {
                    message.append(applicationInfo.getApplicationId())
                            .append("任务处理失败，原因是当前任务状态为：")
                            .append(CodeUtils.getCodeName("OPEN_ACCOUNT_NODE_NAME", String.valueOf(applicationInfo.getApplicationStatus())))
                            .append(";");
                }
            }

            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), message.toString());

        } catch (Exception e) {
            logger.error("批量拒绝任务异常", e);
            return Result.error("批量拒绝任务失败");
        }
        return result;
    }
}
