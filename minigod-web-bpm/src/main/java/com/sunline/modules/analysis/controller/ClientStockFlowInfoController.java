package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.ClientStockFlowInfoEntity;
import com.sunline.modules.analysis.model.ClientStkFlowInfoDetailModel;
import com.sunline.modules.analysis.model.ClientStkFlowInfoGroupModel;
import com.sunline.modules.analysis.service.ClientStockFlowInfoService;
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
 * 股份查询/股份统计
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-02 17:12:17
 */
@Controller
@RequestMapping("clientStockFlowInfo")
public class ClientStockFlowInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat DATE_FORMAT_YYYYMM = new SimpleDateFormat("yyyyMM");

    @Autowired
    private ClientStockFlowInfoService clientStockFlowInfoService;
    @Autowired
    private StkTrdCaleService stkTrdCaleService;

    /**
     * 股份查询
     *
     * @param model
     * @param clientStockFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientStkFlowInfoDetailList")
    @RequiresPermissions("getClientStkFlowInfoDetailList:list")
    public String getClientStkFlowInfoDetailList(Model model, ClientStockFlowInfoEntity clientStockFlowInfoEntity, HttpServletRequest request) {

        try {

            // 获取交易日历
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

            // 如果查询日期为null则默认查前一日交易数据
            if (!"".equals(clientStockFlowInfoEntity.getTradeDate()) && null != clientStockFlowInfoEntity.getTradeDate()) {
                clientStockFlowInfoEntity.setTradeDate(clientStockFlowInfoEntity.getTradeDate());
            } else {
                if (stkTrdCaleEntity.getIsTradeDay()) {
                    clientStockFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    clientStockFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getLastTrd());
                }
            }

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientStockFlowInfoEntity.setChannelIds(null);
            } else {
                clientStockFlowInfoEntity.setChannelIds(getChannelIds());
            }

            if (clientStockFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientStockFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientStockFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientStockFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }

            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_stock_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientStockFlowInfoEntity.getTradeDate())));

            clientStockFlowInfoEntity.setTableName(tableName.toString());

            Page<ClientStockFlowInfoEntity> page = clientStockFlowInfoService.findPage(clientStockFlowInfoEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("params", clientStockFlowInfoEntity);

        } catch (Exception e) {
            logger.error("股份查询出现异常", e);
        }
        return "analysis/clientStkFlowInfoDetailList";
    }

    /**
     * 股份统计
     *
     * @param model
     * @param clientStockFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientStkFlowInfoGroupList")
    @RequiresPermissions("getClientStkFlowInfoGroupList:list")
    public String getClientStkFlowInfoGroupList(Model model, ClientStockFlowInfoEntity clientStockFlowInfoEntity, HttpServletRequest request) {

        try {

            // 获取交易日历
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

            // 如果查询日期为null则默认查前一日交易数据
            if (!"".equals(clientStockFlowInfoEntity.getTradeDate()) && null != clientStockFlowInfoEntity.getTradeDate()) {
                clientStockFlowInfoEntity.setTradeDate(clientStockFlowInfoEntity.getTradeDate());
            } else {
                if (stkTrdCaleEntity.getIsTradeDay()) {
                    clientStockFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    clientStockFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getLastTrd());
                }
            }

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientStockFlowInfoEntity.setChannelIds(null);
            } else {
                clientStockFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientStockFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientStockFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientStockFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientStockFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_stock_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientStockFlowInfoEntity.getTradeDate())));

            clientStockFlowInfoEntity.setTableName(tableName.toString());

            Page<ClientStockFlowInfoEntity> page = clientStockFlowInfoService.findGroupPage(clientStockFlowInfoEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("params", clientStockFlowInfoEntity);
        } catch (Exception e) {
            logger.error("股份统计出现异常", e);
        }

        return "analysis/clientStkFlowInfoGroupList";
    }

    /**
     * 股份查询导出Excel
     *
     * @param clientStockFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/stkDetailListExpExcel")
    @RequiresPermissions("stkDetailListExpExcel:exp")
    @SysLog("股份查询导出")
    public void assetDetailListExpExcel(ClientStockFlowInfoEntity clientStockFlowInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientStockFlowInfoEntity.setChannelIds(null);
            } else {
                clientStockFlowInfoEntity.setChannelIds(getChannelIds());
            }

            if (clientStockFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientStockFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientStockFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientStockFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_stock_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientStockFlowInfoEntity.getTradeDate())));

            clientStockFlowInfoEntity.setTableName(tableName.toString());
            List<ClientStockFlowInfoEntity> clientStockFlowInfoList = clientStockFlowInfoService.findStkDetailListExcelList(clientStockFlowInfoEntity);

            List<ClientStkFlowInfoDetailModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientStockFlowInfoList.size(); i++) {
                ClientStkFlowInfoDetailModel model = new ClientStkFlowInfoDetailModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientStockFlowInfoList.get(i).getUserId() != null ? clientStockFlowInfoList.get(i).getUserId().toString() : "");
                model.setClientName(clientStockFlowInfoList.get(i).getClientName());
                model.setClientId(clientStockFlowInfoList.get(i).getClientId().toString());
                model.setFundAccount(clientStockFlowInfoList.get(i).getFundAccount().toString());
                model.setChannelId(clientStockFlowInfoList.get(i).getChannelId());
                model.setTradeDate(clientStockFlowInfoList.get(i).getTradeDate());

                model.setExchangeType(clientStockFlowInfoList.get(i).getExchangeType() != null ? CrmCommonEnum.SecDataDictionary.getName(clientStockFlowInfoList.get(i).getExchangeType()) : "");
                model.setStockCode(clientStockFlowInfoList.get(i).getStockCode());
                model.setStockName(clientStockFlowInfoList.get(i).getStockName());
                model.setStockType(clientStockFlowInfoList.get(i).getStockType() != null ? CrmCommonEnum.SecStockType.getName(clientStockFlowInfoList.get(i).getStockType()) : "");
                model.setMoneyType(clientStockFlowInfoList.get(i).getMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(clientStockFlowInfoList.get(i).getMoneyType()) : "");
                model.setBeginAmount(clientStockFlowInfoList.get(i).getBeginAmount().toString());
                model.setCurrentAmount(clientStockFlowInfoList.get(i).getCurrentAmount().toString());
                model.setFrozenAmount(clientStockFlowInfoList.get(i).getFrozenAmount().toString());
                model.setUnfrozenAmount(clientStockFlowInfoList.get(i).getUnfrozenAmount().toString());
                model.setCostPrice(clientStockFlowInfoList.get(i).getCostPrice().toString());
                model.setStockMktValue(clientStockFlowInfoList.get(i).getStockMktValue().toString());
                model.setReferProfitCost(clientStockFlowInfoList.get(i).getReferProfitCost().toString());

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, ClientStkFlowInfoDetailModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 股份统计导出Excel
     *
     * @param clientStockFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/stkGroupListExpExcel")
    @RequiresPermissions("stkGroupListExpExcel:exp")
    @SysLog("股份统计导出")
    public void stkGroupListExpExcel(ClientStockFlowInfoEntity clientStockFlowInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientStockFlowInfoEntity.setChannelIds(null);
            } else {
                clientStockFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientStockFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientStockFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientStockFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientStockFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_stock_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientStockFlowInfoEntity.getTradeDate())));

            clientStockFlowInfoEntity.setTableName(tableName.toString());
            List<ClientStockFlowInfoEntity> clientStockFlowInfoList = clientStockFlowInfoService.findStkGroupListExcelList(clientStockFlowInfoEntity);

            List<ClientStkFlowInfoGroupModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientStockFlowInfoList.size(); i++) {
                ClientStkFlowInfoGroupModel model = new ClientStkFlowInfoGroupModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientStockFlowInfoList.get(i).getUserId() != null ? clientStockFlowInfoList.get(i).getUserId().toString() : "");
                model.setClientName(clientStockFlowInfoList.get(i).getClientName());
                model.setClientId(clientStockFlowInfoList.get(i).getClientId().toString());
                model.setFundAccount(clientStockFlowInfoList.get(i).getFundAccount().toString());
                model.setChannelId(clientStockFlowInfoList.get(i).getChannelId());
                model.setTradeDate(clientStockFlowInfoList.get(i).getTradeDate());
                model.setExchangeType(clientStockFlowInfoList.get(i).getExchangeType() != null ? CrmCommonEnum.SecDataDictionary.getName(clientStockFlowInfoList.get(i).getExchangeType()) : "");
                model.setStockType(clientStockFlowInfoList.get(i).getStockType() != null ? CrmCommonEnum.SecStockType.getName(clientStockFlowInfoList.get(i).getStockType()) : "");
                model.setMoneyType(clientStockFlowInfoList.get(i).getMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(clientStockFlowInfoList.get(i).getMoneyType()) : "");
                model.setStockMktValue(clientStockFlowInfoList.get(i).getStockMktValue().toString());
                model.setReferProfitCost(clientStockFlowInfoList.get(i).getReferProfitCost().toString());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientStkFlowInfoGroupModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

}
