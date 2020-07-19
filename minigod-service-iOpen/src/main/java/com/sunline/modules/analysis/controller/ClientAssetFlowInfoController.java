package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.ClientAssetFlowInfoEntity;
import com.sunline.modules.analysis.entity.ClientFundCountEntity;
import com.sunline.modules.analysis.model.ClientAssetFlowInfoDetailModel;
import com.sunline.modules.analysis.model.ClientAssetFlowInfoGroupModel;
import com.sunline.modules.analysis.service.ClientAssetFlowInfoService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.ChannelUtil;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import net.sf.json.JSONArray;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * 资金查询/资金统计
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-04-28 14:24:52
 */
@Controller
@RequestMapping("clientAssetFlowInfo")
public class ClientAssetFlowInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StkTrdCaleService stkTrdCaleService;
    @Autowired
    private SecUserInfoService secUserInfoService;

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private final SimpleDateFormat DATE_FORMAT_YYYYMM = new SimpleDateFormat("yyyyMM");


    @Autowired
    private ClientAssetFlowInfoService clientAssetFlowInfoService;


    /**
     * 资金查询
     *
     * @param model
     * @param clientAssetFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientAssetFlowInfoDetailList")
    @RequiresPermissions("getClientAssetFlowInfoDetailList:list")
    public String getClientAssetFlowInfoDetailList(Model model, ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, HttpServletRequest request) {

        try {

            // 获取交易日历
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

            // 如果查询日期为null则默认查前一日交易数据
            if (!"".equals(clientAssetFlowInfoEntity.getTradeDate()) && null != clientAssetFlowInfoEntity.getTradeDate()) {
                clientAssetFlowInfoEntity.setTradeDate(clientAssetFlowInfoEntity.getTradeDate());
            } else {
                if (stkTrdCaleEntity.getIsTradeDay()) {
                    clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getLastTrd());
                }
            }

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientAssetFlowInfoEntity.setChannelIds(null);
            } else {
                clientAssetFlowInfoEntity.setChannelIds(getChannelIds());
            }

            if (clientAssetFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientAssetFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientAssetFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientAssetFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientAssetFlowInfoEntity.getTradeDate())));

            clientAssetFlowInfoEntity.setTableName(tableName.toString());

            Page<ClientAssetFlowInfoEntity> page = clientAssetFlowInfoService.findPage(clientAssetFlowInfoEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("params", clientAssetFlowInfoEntity);
        } catch (Exception e) {
            logger.error("资金查询出现异常", e);
        }

        return "analysis/clientAssetFlowInfoDetailList";
    }

    /**
     * 资金统计
     *
     * @param model
     * @param clientAssetFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientAssetFlowInfoGroupList")
    @RequiresPermissions("getClientAssetFlowInfoGroupList:list")
    public String getClientAssetFlowInfoGroupList(Model model, ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, HttpServletRequest request) {

        try {
            // 获取交易日历
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

            // 如果查询日期为null则默认查前一日交易数据
            if (!"".equals(clientAssetFlowInfoEntity.getTradeDate()) && null != clientAssetFlowInfoEntity.getTradeDate()) {
                clientAssetFlowInfoEntity.setTradeDate(clientAssetFlowInfoEntity.getTradeDate());
            } else {
                if (stkTrdCaleEntity.getIsTradeDay()) {
                    clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getLastTrd());
                }
            }

            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientAssetFlowInfoEntity.setChannelIds(null);
            } else {
                clientAssetFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientAssetFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientAssetFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientAssetFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientAssetFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientAssetFlowInfoEntity.getTradeDate())));

            clientAssetFlowInfoEntity.setTableName(tableName.toString());

            Page<ClientAssetFlowInfoEntity> page = clientAssetFlowInfoService.findGroupPage(clientAssetFlowInfoEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("params", clientAssetFlowInfoEntity);
        } catch (Exception e) {
            logger.error("资金查询出现异常", e);
        }

        return "analysis/clientAssetFlowInfoGroupList";
    }

    /**
     * 资金查询导出Excel
     *
     * @param clientAssetFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetDetailListExpExcel")
    @RequiresPermissions("assetDetailListExpExcel:exp")
    @SysLog("资金查询导出")
    public void assetDetailListExpExcel(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientAssetFlowInfoEntity.setChannelIds(null);
            } else {
                clientAssetFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientAssetFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientAssetFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientAssetFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientAssetFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientAssetFlowInfoEntity.getTradeDate())));

            clientAssetFlowInfoEntity.setTableName(tableName.toString());

            List<ClientAssetFlowInfoEntity> clientAssetFlowInfoList = clientAssetFlowInfoService.findAssetDetailListExcelList(clientAssetFlowInfoEntity);

            List<ClientAssetFlowInfoDetailModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientAssetFlowInfoList.size(); i++) {
                ClientAssetFlowInfoDetailModel model = new ClientAssetFlowInfoDetailModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientAssetFlowInfoList.get(i).getUserId() != null ? clientAssetFlowInfoList.get(i).getUserId().toString() : "");
                model.setClientName(clientAssetFlowInfoList.get(i).getClientName());
                model.setClientId(clientAssetFlowInfoList.get(i).getClientId());
                model.setFundAccount(clientAssetFlowInfoList.get(i).getFundAccount());
                model.setChannelId(clientAssetFlowInfoList.get(i).getChannelId());
                model.setTradeDate(clientAssetFlowInfoList.get(i).getTradeDate());
                model.setMoneyType(clientAssetFlowInfoList.get(i).getMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(clientAssetFlowInfoList.get(i).getMoneyType()) : "");
                model.setCurrentBalance(clientAssetFlowInfoList.get(i).getCurrentBalance().toString());
                model.setFrozenBalance(clientAssetFlowInfoList.get(i).getFrozenBalance().toString());
                model.setMarketValueCur(clientAssetFlowInfoList.get(i).getMarketValueCur().toString());
                model.setTotalAssets(clientAssetFlowInfoList.get(i).getTotalAssets().toString());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientAssetFlowInfoDetailModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 资金统计导出Excel
     *
     * @param clientAssetFlowInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/assetGroupListExpExcel")
    @RequiresPermissions("assetGroupListExpExcel:exp")
    @SysLog("资金统计导出")
    public void assetGroupListExpExcel(ClientAssetFlowInfoEntity clientAssetFlowInfoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientAssetFlowInfoEntity.setChannelIds(null);
            } else {
                clientAssetFlowInfoEntity.setChannelIds(getChannelIds());
            }
            if (clientAssetFlowInfoEntity.getCheckedChannelId() != null && !"".equals(clientAssetFlowInfoEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientAssetFlowInfoEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientAssetFlowInfoEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            // 生成表名
            StringBuffer tableName = new StringBuffer();
            tableName.append("client_asset_flow_info_").append(DATE_FORMAT_YYYYMM.format(DATE_FORMAT.parse(clientAssetFlowInfoEntity.getTradeDate())));

            clientAssetFlowInfoEntity.setTableName(tableName.toString());
            List<ClientAssetFlowInfoEntity> clientAssetFlowInfoList = clientAssetFlowInfoService.findAssetGroupListExcelList(clientAssetFlowInfoEntity);

            List<ClientAssetFlowInfoGroupModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientAssetFlowInfoList.size(); i++) {
                ClientAssetFlowInfoGroupModel model = new ClientAssetFlowInfoGroupModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientAssetFlowInfoList.get(i).getUserId() != null ? clientAssetFlowInfoList.get(i).getUserId().toString() : "");
                model.setClientName(clientAssetFlowInfoList.get(i).getClientName());
                model.setClientId(clientAssetFlowInfoList.get(i).getClientId().toString());
                model.setFundAccount(clientAssetFlowInfoList.get(i).getFundAccount().toString());
                model.setChannelId(clientAssetFlowInfoList.get(i).getChannelId());
                model.setTradeDate(clientAssetFlowInfoList.get(i).getTradeDate());
                model.setCurrentBalance(clientAssetFlowInfoList.get(i).getCurrentBalance().toString());
                model.setFrozenBalance(clientAssetFlowInfoList.get(i).getFrozenBalance().toString());
                model.setMarketValueCur(clientAssetFlowInfoList.get(i).getMarketValueCur().toString());
                model.setTotalAssets(clientAssetFlowInfoList.get(i).getTotalAssets().toString());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientAssetFlowInfoGroupModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

    /**
     * 资产统计图数据查询
     *
     * @param entity
     * @return
     */
    @RequestMapping("/getClientFundCountGraphic")
    @ResponseBody
    public Result getClientFundCountGraphic(ClientFundCountEntity entity) {

        try {
            List<ClientFundCountEntity> list = clientAssetFlowInfoService.getClientFundCountGraphic(entity);
            JSONArray jsonArray = JSONArray.fromObject(list);
            return Result.ok().put("jsonArray", jsonArray).put("dateType",entity.getDateType());
        } catch (Exception e) {
            logger.error("资金查询出现异常", e);
            return Result.error("资金查询出现异常");
        }
    }

    /**
     * 资金统计
     *
     * @param model
     * @return
     */
    @RequestMapping("/goCountGraphic")
    public String goCountGraphic(Model model, ClientFundCountEntity entity) {
        if(StringUtils.isEmpty(entity.getDateType())){
            entity.setDateType("1");
        }
        SecuritiesUserInfoEntity query = new SecuritiesUserInfoEntity();
        query.setTradeAccount(entity.getClientId());
        SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryObject(query);
        if(null!=userInfoEntity) {
            entity.setClientName(userInfoEntity.getClientName());
        }
        model.addAttribute("entity",entity);
        return "analysis/fundCountGraphicView";
    }
}
