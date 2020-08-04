package com.sunline.modules.fund.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import com.google.common.collect.Lists;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.dbs.service.DbsAREBusinessService;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.entity.DepositBankBillFlowEntity;
import com.sunline.modules.fund.model.BankFlowInfoExportModel;
import com.sunline.modules.fund.model.DBSBillFlowModel;
import com.sunline.modules.fund.model.HSBCHKBillFlowModel;
import com.sunline.modules.fund.service.DbsIccBankFlowService;
import com.sunline.modules.fund.service.DepositBankBillFlowService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 入金银行流水记录表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-06-11 14:25:39
 */
@Controller
@RequestMapping("depositBankBillFlow")
public class DepositBankBillFlowController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(DepositBankBillFlowController.class);
    @Autowired
    private DepositBankBillFlowService depositBankBillFlowService;
    @Autowired
    private DbsIccBankFlowService dbsIccBankFlowService;
    @Autowired
    private DbsAREBusinessService dbsAREBusinessService;

    SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yy", Locale.ENGLISH);
    SimpleDateFormat sdfzh = new SimpleDateFormat("d-MMM-yy", Locale.CHINESE);

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00#");

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    /**
     * 跳转审核列表页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/bankCheckList")
    @RequiresPermissions("depositBankBillFlow:bankCheck")
    public String toBankCheckPage(Model model, HttpServletRequest request, DepositBankBillFlowEntity queryCondition) {
        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            //查询未核对的流水
            queryCondition.setFlowSource(0);
            queryCondition.setCheckStatus(0);
            queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
            Page<DepositBankBillFlowEntity> page = depositBankBillFlowService.queryPage(queryCondition, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("bankType", request.getParameter("bankType"));
            model.addAttribute("params", queryCondition);
            model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        } catch (Exception e) {
            logger.error("跳转银行流水列表异常", e);
        }
        return "fund/deposit/depositBankFlowList";
    }

    /**
     * 银行流水列表导出
     *
     * @param queryCondition
     * @param response
     * @return
     */
    @RequestMapping("/export")
    @RequiresPermissions("depositBankBillFlow:export")
    public void export(DepositBankBillFlowEntity queryCondition, HttpServletResponse response) {
        queryCondition.setCheckStatus(0);
        queryCondition.setAssignDrafter(UserUtils.getCurrentUserId());
        List<DepositBankBillFlowEntity> billFlowList = depositBankBillFlowService.queryListByBean(queryCondition);
        List<BankFlowInfoExportModel> infoExportModels = Lists.newArrayList();
        for (DepositBankBillFlowEntity entity : billFlowList) {
            BankFlowInfoExportModel model = new BankFlowInfoExportModel();
            BeanUtils.copyProperties(entity, model);
            model.setBankName(CodeUtils.getCodeName("FUND_DEPOSIT_BANK_EN", entity.getBankName()));
            model.setValueDate(DateUtil.format(entity.getValueDate(), "dd/MM/yyyy"));
            model.setCreditAmount(DECIMAL_FORMAT.format(entity.getCreditAmount()));
            model.setCurrency(CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", entity.getCurrency()));
            infoExportModels.add(model);
        }
        try {
            EasyExcelUtils.exportXlsxFile(infoExportModels, response, BankFlowInfoExportModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转修改页面
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/tobackView")
    public String tobackView(Model model, HttpServletRequest request, Long flowId) {
        try {
            DepositBankBillFlowEntity entity = depositBankBillFlowService.queryObject(flowId);
            model.addAttribute("info", entity);
        } catch (Exception e) {
            logger.error("跳转页面", e);
        }
        return "fund/deposit/editBankFlowTab";
    }

    @RequestMapping(value = "readExcel", method = RequestMethod.POST)
    @ResponseBody
    public Result readExcel(@RequestParam("file") MultipartFile mfile, @RequestParam("bankType") String bankType) {
        InputStream in = null;
        int suss = 0;
        if (StringUtils.isEmpty(bankType)) {
            return Result.error("请选择银行");
        }
        if (mfile.isEmpty()) {
            return Result.error("上传文件不能为空");
        }
        List<DepositBankBillFlowEntity> entities = new ArrayList<DepositBankBillFlowEntity>();
        try {
            in = new BufferedInputStream(mfile.getInputStream());
            if ("1".equals(bankType)) {
                List<DBSBillFlowModel> models = EasyExcelUtils.readExcel(in, DBSBillFlowModel.class, 6);
                if (CollectionUtil.isNotEmpty(models)) {
                    Map<String, String> credit = new HashMap<String, String>();
                    Map<String, String> debit = new HashMap<String, String>();
                    Map<String, DepositBankBillFlowEntity> obj = new HashMap<String, DepositBankBillFlowEntity>();

                    for (DBSBillFlowModel flow : models) {
                        if (StringUtils.isBlank(flow.getDescription2())) {
                            break;
                        }
                        String[] description = flow.getDescription2().split(" ");
                        int lenth = description.length;
                        String referenceNo = description[1];
                        if ("CHGS".equalsIgnoreCase(description[0])) {
                            debit.put(referenceNo, flow.getDebit().replaceAll(",", ""));
                        }
                        if ("CR".equalsIgnoreCase(description[0])) {
                            DepositBankBillFlowEntity fordb = new DepositBankBillFlowEntity();
                            credit.put(referenceNo, flow.getCredit().replaceAll(",", ""));
                            fordb.setReferenceNo(referenceNo);
                            fordb.setCurrency(description[lenth - 3]);
                            fordb.setParticulars(flow.getDescription2());
                            fordb.setBankName(bankType);
                            if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "2").equals(description[lenth - 3])) {
                                fordb.setCurrency("2");
                            } else if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "1").equals(description[lenth - 3])) {
                                fordb.setCurrency("1");
                            } else if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "0").equals(description[lenth - 3])) {
                                fordb.setCurrency("0");
                            }
                            if (description[lenth - 1].startsWith("799")) {
                                fordb.setSubAccname(description[7].split(",")[0]);
                                fordb.setSubAccno(description[lenth - 1].replaceFirst("79963",""));
                            } else {
                                fordb.setAccName("ZSDP PRIMASIA SECURITIES LIMITED - CLIENT A/C 000292053 HKD");
                                fordb.setAccNo("000292053");
                            }
                            Date date;
                            try {
                                date = sdf.parse(flow.getValueDate());
                            } catch (Exception e) {
                                e.printStackTrace();
                                date = sdfzh.parse(flow.getValueDate());
                            }
                            fordb.setValueDate(date);
                            obj.put(referenceNo, fordb);
                        }
                    }
                    obj.forEach((k, v) -> {
                                //有手续费
                                if (null != credit.get(k) && null != debit.get(k)) {
                                    BigDecimal cre = new BigDecimal(credit.get(k));
                                    BigDecimal deb = new BigDecimal(debit.get(k));
                                    v.setCreditAmount(cre.subtract(deb));
                                    //无手续费
                                } else if (null != credit.get(k) && null == debit.get(k)) {
                                    v.setCreditAmount(new BigDecimal(credit.get(k)));
                                }
                                entities.add(v);
                            }
                    );
                }
            }
            if ("2".equals(bankType)) {
                List<HSBCHKBillFlowModel> models = EasyExcelUtils.readExcel(in, HSBCHKBillFlowModel.class, 1);
                if (CollectionUtil.isNotEmpty(models)) {
                    for (HSBCHKBillFlowModel flow : models) {
                        DepositBankBillFlowEntity fordb = new DepositBankBillFlowEntity();
                        BeanUtils.copyProperties(flow, fordb);
                        fordb.setCreditAmount(new BigDecimal(flow.getCreditMount()));
                        fordb.setBankName(bankType);
                        if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "2").equals(flow.getCurrency())) {
                            fordb.setCurrency("2");
                        } else if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "1").equals(flow.getCurrency())) {
                            fordb.setCurrency("1");
                        } else if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "0").equals(flow.getCurrency())) {
                            fordb.setCurrency("0");
                        }
                        entities.add(fordb);
                    }
                }
            }
            if ("3".equals(bankType)) {
                String filePath = ConfigUtils.get("template.file.path") + "/csvTemp/";
                File file = new File(filePath);
                try {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    file = new File(filePath + Math.random());
                    mfile.transferTo(file);
                    // 将MultipartFile存到临时文件中
                    CsvReader reader = CsvUtil.getReader();
                    //从文件中读取CSV数据
                    CsvData data = reader.read(file);
                    List<CsvRow> rows = data.getRows();
                    //遍历行
                    for (CsvRow csvRow : rows) {
                        if (null != csvRow) {
                            if ("C".equalsIgnoreCase(csvRow.get(12).trim())) {
                                DepositBankBillFlowEntity fordb = new DepositBankBillFlowEntity();
                                fordb.setAccName(csvRow.get(0));
                                fordb.setAccNo(csvRow.get(1).replace("'", ""));
                                try {
//									fordb.setValueDate(sdf1.parse(csvRow.get(10).replaceAll(" ","")));
                                    fordb.setValueDate(new Date(csvRow.get(10).replaceAll(" ", "")));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                try {
                                    String processingTime = csvRow.get(9);
                                    if(StringUtils.isNotEmpty(processingTime)){
                                        int index = processingTime.indexOf(" ");
                                        if(index>0) {
                                            fordb.setProcessingTime(processingTime.substring(index + 1));
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                fordb.setCreditAmount(new BigDecimal(csvRow.get(13)));
                                fordb.setReferenceNo(csvRow.get(15));
                                fordb.setParticulars(csvRow.get(16));
                                fordb.setBankName(bankType);
                                if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "2").equals(csvRow.get(3))) {
                                    fordb.setCurrency("2");
                                } else if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "1").equals(csvRow.get(3))) {
                                    fordb.setCurrency("1");
                                } else if (CodeUtils.getCodeName("SEC_MONEY_TYPE_EN", "0").equals(csvRow.get(3))) {
                                    fordb.setCurrency("0");
                                }
                                entities.add(fordb);
                            }
                        }
                    }
                } finally {
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }

        } catch (IOException e) {
            logger.error("解析银行流水文件发生io异常", e);
            return Result.error("文件错误");
        } catch (Exception e) {
            logger.error("解析银行流水文件发生其它异常", e);
            return Result.error("文件错误");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Map<String, Integer> stringIntegerMap = depositBankBillFlowService.saveOrUpdate(entities);
        return Result.ok("成功导入 " + stringIntegerMap.get("suss") + " 条;失败 "
                + stringIntegerMap.get("fail") + " 条;过滤记录 "+stringIntegerMap.get("repeat")+" 条");
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("depositBankBillFlow:info")
    public Result info(@PathVariable("id") Long id) {
        DepositBankBillFlowEntity depositBankBillFlow = depositBankBillFlowService.queryObject(id);

        return Result.ok().put("depositBankBillFlow", depositBankBillFlow);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("depositBankBillFlow:save")
    public Result save(@RequestBody DepositBankBillFlowEntity depositBankBillFlow) {
        depositBankBillFlowService.save(depositBankBillFlow);

        return Result.ok();
    }

    /**
     * 更新
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result updateApplication(DepositBankBillFlowEntity update) {
        DepositBankBillFlowEntity entity = depositBankBillFlowService.queryObject(update.getId());
        if (1 == entity.getCheckStatus()) {
            return Result.error("该流水已匹配入金记录，无法编辑!");
        }

        boolean upRefreNo = entity.getReferenceNo().equals(update.getReferenceNo());
        String oldRefreNo = entity.getReferenceNo();

        entity.setCreditAmount(update.getCreditAmount());
        entity.setReferenceNo(update.getReferenceNo());
        entity.setAccNo(update.getAccNo());
        entity.setAccName(update.getAccName());
        entity.setCurrency(update.getCurrency());
        entity.setParticulars(update.getParticulars());
        entity.setReferenceNo(update.getReferenceNo());
        entity.setSubAccno(update.getSubAccno());
        entity.setSubAccname(update.getSubAccname());
        entity.setValueDate(update.getValueDate());
        entity.setUpdateUser(UserUtils.getCurrentUserId());
        entity.setUpdateTime(new Date());
        depositBankBillFlowService.update(entity);

        //更新重复流水号记录
        if (!upRefreNo) {
            DepositBankBillFlowEntity query = new DepositBankBillFlowEntity();
            query.setReferenceNo(oldRefreNo);
            List<DepositBankBillFlowEntity> oldBankBills = depositBankBillFlowService.queryListByBean(query);
            if (CollectionUtil.isNotEmpty(oldBankBills) && oldBankBills.size() > 1) {
                oldBankBills.forEach(bill -> depositBankBillFlowService.updateRepeat(bill.getId(), 1));
            } else if (oldBankBills.size() == 1) {
                depositBankBillFlowService.updateRepeat(oldBankBills.get(0).getId(), 0);
            }

            query.setReferenceNo(update.getReferenceNo());
            List<DepositBankBillFlowEntity> newBankBills = depositBankBillFlowService.queryListByBean(query);
            if (CollectionUtil.isNotEmpty(newBankBills) && newBankBills.size() > 1) {
                newBankBills.forEach(bill -> depositBankBillFlowService.updateRepeat(bill.getId(), 1));
            } else if (newBankBills.size() == 1) {
                depositBankBillFlowService.updateRepeat(newBankBills.get(0).getId(), 0);
            }
        }

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(Long id) {
        DepositBankBillFlowEntity depositBankBillFlow = depositBankBillFlowService.queryObject(id);
        if (StringUtils.isNotBlank(depositBankBillFlow.getApplicationId())) {
            return Result.error("该条记录已绑定入金申请:" + depositBankBillFlow.getApplicationId());
        } else {
            depositBankBillFlowService.delete(id);

            //更新重复记录
            DepositBankBillFlowEntity query = new DepositBankBillFlowEntity();
            query.setReferenceNo(depositBankBillFlow.getReferenceNo());
            List<DepositBankBillFlowEntity> bankBillFlowEntities = depositBankBillFlowService.queryListByBean(query);
            if (CollectionUtil.isNotEmpty(bankBillFlowEntities) && bankBillFlowEntities.size() == 1) {
                depositBankBillFlowService.updateRepeat(bankBillFlowEntities.get(0).getId(), 0);
            }

            return Result.ok("删除成功");
        }
    }

    /**
     * 批量申领任务
     *
     * @param billIds
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batchApplyTaskHandle", method = RequestMethod.POST)
    @ResponseBody
    public Result batchApplyTaskHandle(String billIds) {
        try {
            if (StringUtils.isEmpty(billIds)) {
                return Result.error("没有勾选需要记录");
            }
            String toUserId = UserUtils.getCurrentUserId();
            StringBuffer errorMsg = new StringBuffer();
            List<DepositBankBillFlowEntity> billFlowEntities = depositBankBillFlowService.queryListByIds(billIds);
            billFlowEntities.forEach(bill->{
                if (1 == bill.getCheckStatus()
                        ||(StringUtils.isNotBlank(bill.getAssignDrafter())&&!toUserId.equals(bill.getAssignDrafter()))) {
                    errorMsg.append(bill.getReferenceNo()).append(",");
                }else{
                    bill.setAssignDrafter(toUserId);
                    bill.setUpdateTime(new Date());
                    depositBankBillFlowService.updateAssignDrafter(bill);
                }

            });
            if (!StringUtils.isEmpty(errorMsg)) {
                errorMsg.append("记录已被申领处理");
                return Result.error(errorMsg.toString());
            }
        } catch (Exception e) {
            logger.error("批量申领银行流水异常", e);
            return Result.error("申领银行流水失败");
        }
        return Result.ok();
    }

    /**
     * 批量释放办理任务
     *
     * @param billIds
     * @return
     */
    @RequestMapping(value = "/deliverApplyTask", method = RequestMethod.POST)
    @ResponseBody
    public Result deliverApplyTask(String billIds) {
        try{
            if (StringUtils.isEmpty(billIds)) {
                throw new MyException("未勾选已申领记录！");
            }
            StringBuffer errorMsg = new StringBuffer();
            List<DepositBankBillFlowEntity> billFlowEntities = depositBankBillFlowService.queryListByIds(billIds);
            billFlowEntities.forEach(bill->{
                if (!UserUtils.getCurrentUserId().equals(bill.getAssignDrafter())) {
                    errorMsg.append(bill.getReferenceNo()).append(",");
                }else{
                    bill.setAssignDrafter(null);
                    bill.setUpdateTime(new Date());
                    depositBankBillFlowService.updateAssignDrafter(bill);
                }
            });
            if (!StringUtils.isEmpty(errorMsg)) {
                errorMsg.append("记录不属于当前办理人");
                return Result.error(errorMsg.toString());
            }
        } catch (Exception e) {
                logger.error("批量释放办理任务异常", e);
                return Result.error("释放失败");
        }
        return Result.ok();
    }

    /**
     * 同DBS获取手续费
     */
    @RequestMapping(value = "/toQueryARE", method = RequestMethod.POST)
    @ResponseBody
    public Result toQueryARE(Long id) {
        DepositBankBillFlowEntity depositBankBillFlow = depositBankBillFlowService.queryObject(id);
        try{
            //查询对应的icc流水
            DbsIccBankFlowEntity dbsIccBankFlow = new DbsIccBankFlowEntity();
            dbsIccBankFlow.setMsgId(depositBankBillFlow.getMsgId());
            dbsIccBankFlow.setTxnRefId(depositBankBillFlow.getReferenceNo());
            List<DbsIccBankFlowEntity> dbsIccBankFlowList = dbsIccBankFlowService.queryListByBean(dbsIccBankFlow);
            boolean iccAre = dbsAREBusinessService.sendICCARE(dbsIccBankFlowList.get(0), UserUtils.getCurrentUserId());
            if(!iccAre){
                return Result.error("获取手续费失败");
            }
        } catch (Exception e) {
            logger.error("获取DBS ICC的ARE接口处理异常", e);
            return Result.error("获取手续费失败");
        }
        return Result.ok();
    }
}
