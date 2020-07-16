package com.sunline.modules.stock.helper;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.manager.CustomerAccountOpenManager;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.common.ERegion;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.PdfOperater;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.quotation.protocol.request.StockQuotRequest;
import com.sunline.modules.quotation.service.StockQuotService;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * @author fuyy
 * @createDate 2018/12/19
 * @description
 * @email
 */
@Component("donatedStockReportGenerate")
public class DonatedStockReportGenerate {

    private final static Logger logger = LoggerFactory.getLogger(DonatedStockReportGenerate.class);
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);

    @Autowired
    CustomerAccountOpenManager customerAccountOpenManager;

    @Autowired
    SecuritiesUserInfoService securitiesUserInfoService;

    @Autowired
    StkTrdCaleService stkTrdCaleService;

    /**
     * @param donatedStock
     * @return 文件URI
     */
    public String generateReport(DonatedStockApplicationInfoEntity donatedStock) {
        if (null == donatedStock) {
            return null;
        }

        Map<String, Object> reportData = loadAllReportData(donatedStock);

        if (!reportData.isEmpty()) {
            String pdfFilePath = makeOutputPath(donatedStock.getApplicationId());
            if (PdfOperater.fillFile(getReportTemplatePathByReportType(), pdfFilePath, reportData)) {
                return pdfFilePath;
            }
        }

        return null;
    }

    /**
     * 加载报表需要的数据集
     *
     * @param donatedStock
     * @return
     */
    public Map<String, Object> loadAllReportData(DonatedStockApplicationInfoEntity donatedStock) {
        Map<String, Object> reportData = Maps.newHashMap();

        reportData.put("companyName", "ZSDP PRIMASIA Securities Ltd.");
        reportData.put("stockCode", donatedStock.getStockName() + donatedStock.getStockCode());
        reportData.put("stockQuantity", donatedStock.getStockQuantity());
        reportData.put("clientName", donatedStock.getClientName());
        reportData.put("num", donatedStock.getNum());


        //查询下一个交易日
        StkTrdCaleEntity stkTrdCale = stkTrdCaleService.getLastNextDay(DateUtil.format(new Date(), "yyyy-MM-dd"), ERegion.HK.name());
        reportData.put("printDate", DATE_FORMAT.format(DateUtil.parseDate(stkTrdCale.getNextTrd())));

        //查询昨收价
        GenericHsRequest<StockQuotRequest> genericHsRequest = new GenericHsRequest<>();

        StockQuotRequest request = new StockQuotRequest();
        request.setAssetId(donatedStock.getStockCode());

        genericHsRequest.setParams(request);

        ResponseVO responseVo = StockQuotService.getStockQuot(genericHsRequest);
        JSONObject result = JSONObject.parseObject(JSON.toJSONString(responseVo.getResult()));
        reportData.put("closingPrice", result.get("price"));

        reportData.put("totalValue", NumberUtil.round(Double.parseDouble(result.get("price").toString()) * donatedStock.getStockQuantity(), 2));

        //获取签名照  通过小神号获取开户预约流水号查询签名信息
        SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
        securitiesUserModel.setUserId(donatedStock.getUserId());
        ResponseVO responseVO = securitiesUserInfoService.querySecuritiesUserInfo(securitiesUserModel);
        SecuritiesUserModel securitiesUserInfoEntity = (SecuritiesUserModel) responseVO.getResult();

        String userSignImage = "";
        if (securitiesUserInfoEntity != null) {
            if (StringUtils.isNotBlank(securitiesUserInfoEntity.getApplicationId())) {
                userSignImage = customerAccountOpenManager.getAccountOpenCustomerSignImage(securitiesUserInfoEntity.getApplicationId());
                if (StringUtils.isNotBlank(userSignImage)) {
                    reportData.put("signImage", userSignImage);
                } else {
                    // 老客户签名处理
                    userSignImage = "/home/data/bpm/backup/openAccountFiles/" + securitiesUserInfoEntity.getTradeAccount() + "/电子签名照.jpg";
                    reportData.put("signImage", userSignImage);
                }
            } else {
                // 老客户签名处理
                userSignImage = "/home/data/bpm/backup/openAccountFiles/" + securitiesUserInfoEntity.getTradeAccount() + "/电子签名照.jpg";
                reportData.put("signImage", userSignImage);
            }
        }
        reportData.put("settleSign", ConfigUtils.get("donatedStock.user.report.rootPath")+"/settleSign-J.png");
        reportData.put("companySign", ConfigUtils.get("donatedStock.user.report.rootPath")+"/companySign.png");

        return reportData;
    }

    /**
     * 获取模板路径
     *
     * @return
     */
    private String getReportTemplatePathByReportType() {

        String contextRoot = ConfigUtils.get("donatedStock.user.report.rootPath");
        String reportTemplatePath = ConfigUtils.get("donatedStock.user.report.template");

        if (null == reportTemplatePath) {
            throw new UnsupportedOperationException("无法获取报表模板信息");
        }

        return contextRoot + "/" + reportTemplatePath;
    }


    /**
     * 生成报表输出路径
     *
     * @param applicationId
     * @return
     */
    public String makeOutputPath(String applicationId) {
        StringBuilder outPutPath = new StringBuilder(getUserReportRootPath(applicationId));
        outPutPath.append("Bought and Sold Note.pdf");
        return outPutPath.toString();
    }

    public static String getUserReportRootPath(String applicationId) {
        return ConfigUtils.get("donatedStock.user.report.userForm.single") + applicationId + "/";
    }

}
