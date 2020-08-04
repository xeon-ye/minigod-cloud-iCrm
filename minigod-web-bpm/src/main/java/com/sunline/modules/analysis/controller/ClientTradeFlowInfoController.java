package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.ChannelReturnEntity;
import com.sunline.modules.analysis.entity.ClientTradeFlowInfoEntity;
import com.sunline.modules.analysis.model.ChannelBrokerageReturnModel;
import com.sunline.modules.analysis.model.ClientTrdFlowInfoDetailModel;
import com.sunline.modules.analysis.model.ClientTrdFlowInfoGroupModel;
import com.sunline.modules.analysis.service.ChannelReturnService;
import com.sunline.modules.analysis.service.ClientTradeFlowInfoService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.*;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 交易查询/统计模块
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-24 17:56:39
 */
@Controller
@RequestMapping("clientTradeFlowInfo")
public class ClientTradeFlowInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientTradeFlowInfoService clientTradeFlowInfoService;
    @Autowired
    private StkTrdCaleService stkTrdCaleService;
    @Autowired
    private ChannelReturnService channelReturnService;

    /**
     * 交易查询
     *
     * @param model
     * @param clientTradeFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientTrdFlowInfoDetailList")
    @RequiresPermissions("getClientTrdFlowInfoDetailList:list")
    public String getClientTrdFlowInfoDetailList(Model model, ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, HttpServletRequest request) {

        String name = request.getParameter("name");
        if (name != null && !"".equals(name)) {
            clientTradeFlowInfoEntity.setChannelName(name);
        }

        // 获取交易日历
        StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

        // 如果查询日期为null则默认查前一日交易数据
        if (!"".equals(clientTradeFlowInfoEntity.getBeginDate()) && null != clientTradeFlowInfoEntity.getBeginDate()) {
            clientTradeFlowInfoEntity.setBeginDate(clientTradeFlowInfoEntity.getBeginDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientTradeFlowInfoEntity.setBeginDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientTradeFlowInfoEntity.setBeginDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        if (!"".equals(clientTradeFlowInfoEntity.getEndDate()) && null != clientTradeFlowInfoEntity.getEndDate()) {
            clientTradeFlowInfoEntity.setEndDate(clientTradeFlowInfoEntity.getEndDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientTradeFlowInfoEntity.setEndDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientTradeFlowInfoEntity.setEndDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (getUserId().equals(Constant.SUPERR_USER)) {
            clientTradeFlowInfoEntity.setChannelIds(null);
        } else {
            clientTradeFlowInfoEntity.setChannelIds(getChannelIds());
        }
        if (StringUtils.isNotEmpty(clientTradeFlowInfoEntity.getChannelId())) {
            clientTradeFlowInfoEntity.setChannelId(clientTradeFlowInfoEntity.getChannelId().replace("，", ",").replace("(", "").replace(")", ""));
        }
        if (clientTradeFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientTradeFlowInfoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientTradeFlowInfoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                clientTradeFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }
        Page<ClientTradeFlowInfoEntity> page = clientTradeFlowInfoService.findPage(clientTradeFlowInfoEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("params", clientTradeFlowInfoEntity);
        return "analysis/clientTrdFlowInfoDetailList";
    }


    /**
     * 交易统计
     *
     * @param model
     * @param clientTradeFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientTrdFlowInfoGroupList")
    @RequiresPermissions("getClientTrdFlowInfoGroupList:list")
    public String getClientTrdFlowInfoGroupList(Model model, ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, HttpServletRequest request) {

        // 获取交易日历
        StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

        // 如果查询日期为null则默认查前一日交易数据
        if (!"".equals(clientTradeFlowInfoEntity.getBeginDate()) && null != clientTradeFlowInfoEntity.getBeginDate()) {
            clientTradeFlowInfoEntity.setBeginDate(clientTradeFlowInfoEntity.getBeginDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientTradeFlowInfoEntity.setBeginDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientTradeFlowInfoEntity.setBeginDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        if (!"".equals(clientTradeFlowInfoEntity.getEndDate()) && null != clientTradeFlowInfoEntity.getEndDate()) {
            clientTradeFlowInfoEntity.setEndDate(clientTradeFlowInfoEntity.getEndDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientTradeFlowInfoEntity.setEndDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientTradeFlowInfoEntity.setEndDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (getUserId().equals(Constant.SUPERR_USER)) {
            clientTradeFlowInfoEntity.setChannelIds(null);
        } else {
            clientTradeFlowInfoEntity.setChannelIds(getChannelIds());
        }
        if (clientTradeFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientTradeFlowInfoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientTradeFlowInfoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                clientTradeFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }
        Page<ClientTradeFlowInfoEntity> page = clientTradeFlowInfoService.findGroupPage(clientTradeFlowInfoEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("params", clientTradeFlowInfoEntity);
        return "analysis/clientTrdFlowInfoGroupList";
    }

    /**
     * 交易查询导出Excel
     *
     * @param clientTradeFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/trdDetailListExpExcel")
    @RequiresPermissions("trdDetailListExpExcel:exp")
    @SysLog("交易查询导出")
    public void trdDetailListExpExcel(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientTradeFlowInfoEntity.setChannelIds(null);
            } else {
                clientTradeFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientTradeFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientTradeFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientTradeFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientTradeFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }

            List<ClientTradeFlowInfoEntity> clientTradeFlowInfoList = clientTradeFlowInfoService.findTrdDetailListExcelList(clientTradeFlowInfoEntity);

            List<ClientTrdFlowInfoDetailModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientTradeFlowInfoList.size(); i++) {

                ClientTrdFlowInfoDetailModel model = new ClientTrdFlowInfoDetailModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientTradeFlowInfoList.get(i).getUserId() != null ? clientTradeFlowInfoList.get(i).getUserId().toString() : "");
                model.setClientName(clientTradeFlowInfoList.get(i).getClientName());
                model.setClientId(clientTradeFlowInfoList.get(i).getClientId());
                model.setFundAccount(clientTradeFlowInfoList.get(i).getFundAccount());
                model.setChannelId(clientTradeFlowInfoList.get(i).getChannelId());
                model.setTradeDate(clientTradeFlowInfoList.get(i).getTradeDate());
                model.setExchangeType(CrmCommonEnum.SecDataDictionary.getName(clientTradeFlowInfoList.get(i).getExchangeType()));
                model.setStockCode(clientTradeFlowInfoList.get(i).getStockCode());
                model.setStockName(clientTradeFlowInfoList.get(i).getStockName());
                model.setStockType(CodeUtils.getCodeName("SEC_STOCK_TYPE", clientTradeFlowInfoList.get(i).getStockType()));
                model.setTradeKind(CodeUtils.getCodeName("SEC_TRADE_KIND", clientTradeFlowInfoList.get(i).getTradeKind()));
                model.setEntrustWay(CodeUtils.getCodeName("SEC_ENTRUST_WAY", clientTradeFlowInfoList.get(i).getEntrustWay()));
                model.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", clientTradeFlowInfoList.get(i).getMoneyType()));
                model.setBusinessAmount(String.valueOf(clientTradeFlowInfoList.get(i).getBusinessAmount()));
                model.setBusinessBalance(String.valueOf(clientTradeFlowInfoList.get(i).getBusinessBalance()));
                model.setBusinessPrice(String.valueOf(clientTradeFlowInfoList.get(i).getBusinessPrice()));
                model.setOccurBalance(String.valueOf(clientTradeFlowInfoList.get(i).getOccurBalance()));
                model.setFeeCount(String.valueOf(clientTradeFlowInfoList.get(i).getFeeCount()));
                model.setProfitFeeCount(String.valueOf(clientTradeFlowInfoList.get(i).getProfitFeeCount()));
                model.setFeeCountRatio(String.valueOf(clientTradeFlowInfoList.get(i).getFeeCountRatio()));
                model.setSequenceNo(String.valueOf(clientTradeFlowInfoList.get(i).getSequenceNo()));

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientTrdFlowInfoDetailModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 交易统计导出Excel
     *
     * @param clientTradeFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/trdGroupListExpExcel")
    @RequiresPermissions("trdGroupListExpExcel:exp")
    @SysLog("交易统计导出")
    public void trdGroupListExpExcel(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientTradeFlowInfoEntity.setChannelIds(null);
            } else {
                clientTradeFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientTradeFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientTradeFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientTradeFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientTradeFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            List<ClientTradeFlowInfoEntity> clientTradeFlowInfoList = clientTradeFlowInfoService.findTrdGroupListExcelList(clientTradeFlowInfoEntity);

            List<ClientTrdFlowInfoGroupModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientTradeFlowInfoList.size(); i++) {

                ClientTrdFlowInfoGroupModel model = new ClientTrdFlowInfoGroupModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientTradeFlowInfoList.get(i).getUserId() != null ? clientTradeFlowInfoList.get(i).getUserId().toString() : "");
                model.setClientName(clientTradeFlowInfoList.get(i).getClientName());
                model.setClientId(clientTradeFlowInfoList.get(i).getClientId());
                model.setFundAccount(clientTradeFlowInfoList.get(i).getFundAccount());
                model.setChannelId(clientTradeFlowInfoList.get(i).getChannelId());
                model.setBusinessAmount(String.valueOf(clientTradeFlowInfoList.get(i).getBusinessAmount()));
                model.setBusinessBalance(String.valueOf(clientTradeFlowInfoList.get(i).getBusinessBalance()));
                model.setOccurBalance(String.valueOf(clientTradeFlowInfoList.get(i).getOccurBalance()));
                model.setFeeCount(String.valueOf(clientTradeFlowInfoList.get(i).getFeeCount()));
                model.setProfitFeeCount(String.valueOf(clientTradeFlowInfoList.get(i).getProfitFeeCount()));
                model.setFeeCountRatio(String.valueOf(clientTradeFlowInfoList.get(i).getFeeCountRatio()));

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientTrdFlowInfoGroupModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    @RequestMapping("/showGraphicView")
    public String getListCaseByOpenType(Model model, ClientTradeFlowInfoEntity entity) {
        if (entity.getType() == null || "".equals(entity.getType())) {
            entity.setType("channel_name");
        }
        model.addAttribute("info", entity);
        return "analysis/showGraphicView";
    }

    @RequestMapping("graphicShow")
    @ResponseBody
    public Result graphicShow(ClientTradeFlowInfoEntity entity, HttpServletRequest request) {
        ClientTradeFlowInfoEntity params = new ClientTradeFlowInfoEntity();
        if (entity.getType() == null || "".equals(entity.getType())) {
            entity.setType("channel_name");
        }
        List<ClientTradeFlowInfoEntity> list = clientTradeFlowInfoService.queryListGroupByParam(entity);
        JSONArray jsonArray = new JSONArray(list);
        return Result.ok().put("jsonArray", jsonArray);
    }


    /**
     * 交易历史
     *
     * @param model
     * @param clientTradeFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/tradeList")
    public String tradeList(Model model, ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<ClientTradeFlowInfoEntity> page = clientTradeFlowInfoService.findPage(clientTradeFlowInfoEntity, pageNum);
        for (ClientTradeFlowInfoEntity clientTradeEntity : page.getResult()) {
            clientTradeEntity.setStockCode(StockCodeUtils.securityCode2AssetId(clientTradeEntity.getStockCode(), clientTradeEntity.getExchangeType()));
        }
        model.addAttribute("page", page);
        model.addAttribute("fundAccount", clientTradeFlowInfoEntity.getFundAccount());
        return "stock/tradeList";
    }

    /**
     * 导入渠道返佣数据
     *
     * @param clientTradeFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/impChannelReturn")
    @RequiresPermissions("clientTradeFlowInfo:imp")
    public @ResponseBody
    Result channelBrokerageReturn(ClientTradeFlowInfoEntity clientTradeFlowInfoEntity, HttpServletRequest request) {

        Result result = null;

        try {

            String name = request.getParameter("name");
            if (name != null && !"".equals(name)) {
                clientTradeFlowInfoEntity.setChannelName(name);
            }
            if (StringUtils.isNotEmpty(clientTradeFlowInfoEntity.getChannelId())) {
                clientTradeFlowInfoEntity.setChannelId(clientTradeFlowInfoEntity.getChannelId().replace("，", ",").replace("(", "").replace(")", ""));
            }
            if (clientTradeFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientTradeFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientTradeFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientTradeFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }

            List<ClientTradeFlowInfoEntity> channelReturnInfoList = clientTradeFlowInfoService.findChannelReturnList(clientTradeFlowInfoEntity);

            // 写入
            if (channelReturnInfoList.size() > 0) {
                int count = clientTradeFlowInfoService.saveBatch(channelReturnInfoList);

                if (count > 0) {
                    result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "导入成功");
                } else {
                    result = Result.ok(Constant.RESULT.CODE_NO.getValue(), "导入失败");
                }
            } else {
                result = Result.ok(Constant.RESULT.CODE_NO.getValue(), "存在已被添加入账的数据，请检查！");
            }

        } catch (Exception e) {
            logger.error("导入失败", e);
            result = Result.error("导入失败");
        }

        return result;
    }

    /**
     * 渠道返佣
     *
     * @param model
     * @param channelReturnEntity
     * @param request
     * @return
     */
    @RequestMapping("/channelBrokerageReturn")
    @RequiresPermissions("channelBrokerageReturn:list")
    public String channelBrokerageReturn(Model model, ChannelReturnEntity channelReturnEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        Page<ChannelReturnEntity> page = channelReturnService.findPage(channelReturnEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("params", channelReturnEntity);
        return "analysis/channelBrokerageReturnList";
    }

    /**
     * 授权入账
     *
     * @param ids
     * @param request
     * @return
     */
    @RequestMapping("/doAuthEntryBatch")
    @RequiresPermissions("channelBrokerageReturn:entry")
    public @ResponseBody
    Result doAuthEntryBatch(Long[] ids, HttpServletRequest request) {

        Result result = null;

        try {

            if (ids.length < 1) {
                return Result.error("请选择行");
            }

            int count = channelReturnService.updateBatch(ids);

            if (count > 0) {
                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "授权成功");
            } else {
                result = Result.ok(Constant.RESULT.CODE_NO.getValue(), "授权失败");
            }

        } catch (Exception e) {
            logger.error("操作失败", e);
            result = Result.error("操作失败");
        }

        return result;
    }

    /**
     * 清空名单
     *
     * @param ids
     * @param request
     * @return
     */
    @RequestMapping("/doClean")
    @RequiresPermissions("channelBrokerageReturn:entry")
    public @ResponseBody
    Result doClean(Long[] ids, HttpServletRequest request) {

        Result result = null;

        try {


            int count = channelReturnService.clean();

            if (count > 0) {
                result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "操作成功");
            } else {
                result = Result.ok(Constant.RESULT.CODE_NO.getValue(), "操作失败");
            }

        } catch (Exception e) {
            logger.error("操作失败", e);
            result = Result.error("操作失败");
        }

        return result;
    }

    /**
     * 渠道返佣明细导出
     *
     * @param channelReturnEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/channelReturnExp")
    @RequiresPermissions("channelBrokerageReturn:exp")
    @SysLog("渠道返佣明细导出")
    public void channelReturnExp(ChannelReturnEntity channelReturnEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                channelReturnEntity.setChannelIds(null);
            } else {
                channelReturnEntity.setChannelIds(getChannelIds());
            }

            List<ChannelReturnEntity> channelReturnList = channelReturnService.queryList(channelReturnEntity);

            List<ClientTrdFlowInfoDetailModel> modelList = Lists.newArrayList();

            for (int i = 0; i < channelReturnList.size(); i++) {

                ClientTrdFlowInfoDetailModel model = new ClientTrdFlowInfoDetailModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(channelReturnList.get(i).getUserId() != null ? channelReturnList.get(i).getUserId().toString() : "");
                model.setClientName(channelReturnList.get(i).getClientName());
                model.setClientId(channelReturnList.get(i).getClientId());
                model.setFundAccount(channelReturnList.get(i).getFundAccount());
                model.setChannelId(channelReturnList.get(i).getChannelId());
                model.setTradeDate(DateUtil.format(channelReturnList.get(i).getTradeDate(), "yyyy-MM-dd"));
                model.setExchangeType(CrmCommonEnum.SecDataDictionary.getName(channelReturnList.get(i).getExchangeType()));
                model.setStockCode(channelReturnList.get(i).getStockCode());
                model.setStockName(channelReturnList.get(i).getStockName());
                model.setStockType(CodeUtils.getCodeName("SEC_STOCK_TYPE", channelReturnList.get(i).getStockType()));
                model.setTradeKind(CodeUtils.getCodeName("SEC_TRADE_KIND", channelReturnList.get(i).getTradeKind()));
                model.setEntrustWay(CodeUtils.getCodeName("SEC_ENTRUST_WAY", channelReturnList.get(i).getEntrustWay()));
                model.setMoneyType(CodeUtils.getCodeName("SEC_MONEY_TYPE_TRD", channelReturnList.get(i).getMoneyType()));
                model.setBusinessAmount(String.valueOf(channelReturnList.get(i).getBusinessAmount()));
                model.setBusinessBalance(String.valueOf(channelReturnList.get(i).getBusinessBalance()));
                model.setBusinessPrice(String.valueOf(channelReturnList.get(i).getBusinessPrice()));
                model.setOccurBalance(String.valueOf(channelReturnList.get(i).getOccurBalance()));
                model.setFeeCount(String.valueOf(channelReturnList.get(i).getFeeCount()));
                model.setProfitFeeCount(String.valueOf(channelReturnList.get(i).getProfitFeeCount()));
                model.setFeeCountRatio(String.valueOf(channelReturnList.get(i).getFeeCountRatio()));
                model.setSequenceNo(String.valueOf(channelReturnList.get(i).getSequenceNo()));
                model.setRefund("20");

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientTrdFlowInfoDetailModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 渠道返佣汇总导出
     *
     * @param channelReturnEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/channelReturnGroupExp")
    @RequiresPermissions("channelBrokerageReturn:exp")
    @SysLog("渠道返佣汇总导出")
    public void channelReturnGroupExp(ChannelReturnEntity channelReturnEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                channelReturnEntity.setChannelIds(null);
            } else {
                channelReturnEntity.setChannelIds(getChannelIds());
            }

            List<ChannelReturnEntity> channelReturnList = channelReturnService.queryGroupList(channelReturnEntity);

            List<ChannelBrokerageReturnModel> modelList = Lists.newArrayList();

            for (int i = 0; i < channelReturnList.size(); i++) {

                ChannelBrokerageReturnModel model = new ChannelBrokerageReturnModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(channelReturnList.get(i).getUserId() != null ? channelReturnList.get(i).getUserId().toString() : "");
                model.setClientName(channelReturnList.get(i).getClientName());
                model.setClientId(channelReturnList.get(i).getClientId());
                model.setFundAccount(channelReturnList.get(i).getFundAccount());
                model.setChannelId(channelReturnList.get(i).getChannelId());
                model.setTotalRefund(channelReturnList.get(i).getTotalRefund());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ChannelBrokerageReturnModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

}
