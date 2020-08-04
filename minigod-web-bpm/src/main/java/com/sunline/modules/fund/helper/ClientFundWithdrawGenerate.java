package com.sunline.modules.fund.helper;


import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.PdfOperater;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.Map;

/**
 * @author fuyy
 * @createDate 2018/12/19
 * @description
 * @email
 */
@Component("clientFundWithdrawGenerate")
public class ClientFundWithdrawGenerate {

    private final static Logger logger = LoggerFactory.getLogger(ClientFundWithdrawGenerate.class);

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00#");


    /**
     * @param entry
     * @return 文件URI
     */
    public String generateReport(ClientFundWithdrawApplyEntity entry) {
        if (null == entry) {
            return null;
        }

        Map<String, Object> reportData = loadAllReportData(entry);

        if (!reportData.isEmpty()) {
            String pdfFilePath = makeOutputPath(entry.getApplicationId());
            if (PdfOperater.fillFile(getReportTemplatePathByReportType(), pdfFilePath, reportData)) {
                return pdfFilePath;
            }
        }

        return null;
    }

    /**
     * 加载报表需要的数据集
     *
     * @param entity
     * @return
     */
    public Map<String, Object> loadAllReportData(ClientFundWithdrawApplyEntity entity) {
        Map<String, Object> reportData = Maps.newHashMap();
        reportData.put("withdrawType", CodeUtils.getCodeName("FUND_BANK_TYPE", String.valueOf(entity.getWithdrawType())));
        reportData.put("clientNameSpell",entity.getClientNameSpell());
        reportData.put("receiveTime",DateUtil.format(entity.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        reportData.put("bankName",entity.getBankName());
        reportData.put("clientId",entity.getClientId());
        reportData.put("bankNo",entity.getBankNo());
        reportData.put("fundAccount",entity.getFundAccount());
        reportData.put("swiftCode",entity.getSwiftCode());
        reportData.put("clientName",entity.getClientName());
        reportData.put("contactAddress",entity.getContactAddress());
        reportData.put("clientNameEn",entity.getClientNameEn());
        reportData.put("moneyType", CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", String.valueOf(entity.getMoneyType())));
        reportData.put("idKind",CodeUtils.getCodeName("AO_ID_KIND", String.valueOf(entity.getIdKind())));
        reportData.put("occurBalance",null == entity.getOccurBalance()? entity.getOccurBalance():DECIMAL_FORMAT.format(entity.getOccurBalance()));
        reportData.put("idNo",entity.getIdNo());
        reportData.put("frozenBalance",null==entity.getFrozenBalance()?entity.getFrozenBalance():DECIMAL_FORMAT.format(entity.getFrozenBalance()));
        reportData.put("phoneNumber",entity.getPhoneNumber());
        reportData.put("currentBalance",null==entity.getCurrentBalance() ? entity.getCurrentBalance() : DECIMAL_FORMAT.format(entity.getCurrentBalance()));
        reportData.put("chargeMoney",null==entity.getChargeMoney()?entity.getChargeMoney() : DECIMAL_FORMAT.format(entity.getChargeMoney()));
        reportData.put("actualBalance",null==entity.getActualBalance()?entity.getActualBalance() : DECIMAL_FORMAT.format(entity.getActualBalance()));
        return reportData;
    }

    /**
     * 获取模板路径
     *
     * @return
     */
    private String getReportTemplatePathByReportType() {
        return ConfigUtils.get("template.file.path") + "/fund/fund_withdraw_detail_template.pdf";
    }

    /**
     * 生成报表输出路径
     *
     * @param applicationId
     * @return
     */
    public String makeOutputPath(String applicationId) {
        StringBuilder outPutPath = new StringBuilder();
        outPutPath.append(ConfigUtils.get("crm.file.path"))
                .append("/template/")
                .append(applicationId)
                .append(".pdf");
        return outPutPath.toString();
    }

}
