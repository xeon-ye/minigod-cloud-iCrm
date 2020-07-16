package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.StockTransferInfoEntity;
import com.sunline.modules.analysis.model.StkTransferInfoModel;
import com.sunline.modules.analysis.service.StockTransferInfoService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.ChannelUtil;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.Utils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 客户转仓查询
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 10:26:17
 */
@Controller
@RequestMapping("stockTransferInfo")
public class StockTransferInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private StockTransferInfoService stockTransferInfoService;
    @Autowired
    private StkTrdCaleService stkTrdCaleService;

    /**
     * 客户转仓查询
     *
     * @param model
     * @param stockTransferInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getStkTransferInfoList")
    @RequiresPermissions("getStkTransferInfoList:list")
    public String getStkTransferInfoList(Model model, StockTransferInfoEntity stockTransferInfoEntity, HttpServletRequest request) {

        // 获取交易日历
        StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.today(), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

        // 如果查询日期为null则默认查前一日交易数据
        if (!"".equals(stockTransferInfoEntity.getBeginDate()) && null != stockTransferInfoEntity.getBeginDate()) {
            stockTransferInfoEntity.setBeginDate(stockTransferInfoEntity.getBeginDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                stockTransferInfoEntity.setBeginDate(stkTrdCaleEntity.getNormalDate());
            } else {
                stockTransferInfoEntity.setBeginDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        if (!"".equals(stockTransferInfoEntity.getEndDate()) && null != stockTransferInfoEntity.getEndDate()) {
            stockTransferInfoEntity.setEndDate(stockTransferInfoEntity.getEndDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                stockTransferInfoEntity.setEndDate(stkTrdCaleEntity.getNormalDate());
            } else {
                stockTransferInfoEntity.setEndDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (getUserId().equals(Constant.SUPERR_USER)) {
            stockTransferInfoEntity.setChannelIds(null);
        } else {
            stockTransferInfoEntity.setChannelIds(getChannelIds());
        }
        if (stockTransferInfoEntity.getCheckedChannelId() != null && !"".equals(stockTransferInfoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(stockTransferInfoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                stockTransferInfoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }
        Page<StockTransferInfoEntity> page = stockTransferInfoService.findPage(stockTransferInfoEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("params", stockTransferInfoEntity);
        return "analysis/stkTransferInfoList";
    }

    /**
     * 客户转仓查询导出Excel
     *
     * @param stockTransferInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/stkTransferInfoListExpExcel")
    @RequiresPermissions("stkTransferInfoListExpExcel:exp")
    @SysLog("客户转仓查询导出")
    public void stkTransferInfoListExpExcel(StockTransferInfoEntity stockTransferInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                stockTransferInfoEntity.setChannelIds(null);
            } else {
                stockTransferInfoEntity.setChannelIds(getChannelIds());
            }
            if (stockTransferInfoEntity.getCheckedChannelId() != null && !"".equals(stockTransferInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(stockTransferInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    stockTransferInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            List<StockTransferInfoEntity> stockTransferInfoList = stockTransferInfoService.findStkTransferInfoExcelList(stockTransferInfoEntity);

            List<StkTransferInfoModel> modelList = Lists.newArrayList();

            for (int i = 0; i < stockTransferInfoList.size(); i++) {
                StkTransferInfoModel model = new StkTransferInfoModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(stockTransferInfoList.get(i).getUserId() != null ? stockTransferInfoList.get(i).getUserId().toString() : "");
                model.setClientName(stockTransferInfoList.get(i).getClientName());
                model.setClientId(stockTransferInfoList.get(i).getClientId().toString());
                model.setFundAccount(stockTransferInfoList.get(i).getFundAccount().toString());
                model.setChannelId(stockTransferInfoList.get(i).getChannelId());
                model.setTradeDate(stockTransferInfoList.get(i).getTradeDate());
                model.setStockCode(stockTransferInfoList.get(i).getStockCode());
                model.setStockName(stockTransferInfoList.get(i).getStockName());
                model.setStockType(stockTransferInfoList.get(i).getStockType() != null ? CrmCommonEnum.SecStockType.getName(stockTransferInfoList.get(i).getStockType()) : "");
                model.setBusinessFlag(stockTransferInfoList.get(i).getBusinessFlag() != null ? CrmCommonEnum.SecDataDictionary.getName(stockTransferInfoList.get(i).getBusinessFlag()) : "");
                model.setMoneyType(stockTransferInfoList.get(i).getMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(stockTransferInfoList.get(i).getMoneyType()) : "");
                model.setOccurAmount(stockTransferInfoList.get(i).getOccurAmount().toString());
                model.setStockMktValue(stockTransferInfoList.get(i).getStockMktValue().toString());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, StkTransferInfoModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

}
