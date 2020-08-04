package com.sunline.modules.customer.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.model.FareModel;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.customer.entity.ClientFareListEntity;
import com.sunline.modules.customer.service.ClientFareListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 客户费率设置表
 *
 * @author lcs
 * @email
 * @date 2018-05-10 16:47:30
 */
@Controller
@RequestMapping("clientfarelist")
public class ClientFareListController extends BaseController {
    @Autowired
    private ClientFareListService clientFareListService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("fareList")
    @RequiresPermissions("clientfarelist:list")
    public String fareList(Model model, ClientFareListEntity clientFareListEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (getUserId().equals(Constant.SUPERR_USER)) {
            clientFareListEntity.setChannelIds(null);
        } else {
            clientFareListEntity.setChannelIds(getChannelIds());
        }
        if (clientFareListEntity.getCheckedChannelId() != null && !"".equals(clientFareListEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientFareListEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                clientFareListEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }
        Page<ClientFareListEntity> page = clientFareListService.findPage(clientFareListEntity, pageNum);
        for (ClientFareListEntity client : page.getResult()) {
            //去除小数点后面多余的0
            client.setFeeCount(client.getFeeCount().replaceAll("0+?$", ""));
            client.setFeeCount(client.getFeeCount().replaceAll("[.]$", ""));
            client.setFeeCountFix(client.getFeeCountFix().replaceAll("0+?$", ""));
            client.setFeeCountFix(client.getFeeCountFix().replaceAll("[.]$", ""));
        }
        model.addAttribute("page", page);
        model.addAttribute("model", clientFareListEntity);
        return "customer/fareList";
    }

    /**
     * 客户佣金套餐导出Excel
     *
     * @param clientFareListEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/fareListExpExcel")
    @RequiresPermissions("clientfarelist:exp")
    @SysLog("客户佣金套餐导出")
    public void fareListExpExcel(ClientFareListEntity clientFareListEntity, HttpServletRequest request, HttpServletResponse response) {

        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientFareListEntity.setChannelIds(null);
            } else {
                clientFareListEntity.setChannelIds(getChannelIds());
            }
            if (clientFareListEntity.getCheckedChannelId() != null && !"".equals(clientFareListEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientFareListEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientFareListEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }

            TimeInterval timer = DateUtil.timer();

            List<ClientFareListEntity> fareList = clientFareListService.fareListExcelList(clientFareListEntity);

            List<FareModel> modelList = Lists.newArrayList();

            int i = 0;
            for (ClientFareListEntity clientFare : fareList) {
                FareModel model = new FareModel();
                //去除小数点后多余的0
                clientFare.setFeeCount(clientFare.getFeeCount().replaceAll("0+?$", ""));
                clientFare.setFeeCount(clientFare.getFeeCount().replaceAll("[.]$", ""));
                clientFare.setFeeCountFix(clientFare.getFeeCountFix().replaceAll("0+?$", ""));
                clientFare.setFeeCountFix(clientFare.getFeeCountFix().replaceAll("[.]$", ""));
                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientFare.getUserId() != null ? clientFare.getUserId() : "");
                model.setClientName(clientFare.getClientName());
                model.setClientId(clientFare.getClientId() != null ? clientFare.getClientId().toString() : "");
                model.setFundAccount(clientFare.getFundAccount() != null ? clientFare.getFundAccount().toString() : "");
                model.setChannelId(clientFare.getChannelId());
                model.setExchangeType(clientFare.getExchangeType() != null ? CrmCommonEnum.SecDataDictionary.getName(clientFare.getExchangeType()) : "");
                model.setFareDict(clientFare.getFareDict() != null ? CrmCommonEnum.SecFareDict.getName(clientFare.getFareDict()) : "");
                model.setFeeType(clientFare.getFeeType() != null ? CrmCommonEnum.SecFeeType.getName(clientFare.getFeeType()) : "");
                //收费方式不一样时 付费数值也不一样  --- 收费方式[0-按百分比 1-按固定笔数 5-按固定股数]
                model.setFeeCount("0".equals(clientFare.getFeeType()) ? clientFare.getFeeCount() : clientFare.getFeeCountFix());
                model.setMinFare(clientFare.getMinFare() != null ? clientFare.getMinFare() : "");
                model.setMaxFare(clientFare.getMaxFare() != null ? clientFare.getMaxFare() : "");
                model.setBeginDate(clientFare.getBeginDate() != null ? DATE_FORMAT.format(clientFare.getBeginDate()) : "");
                model.setEndDate(clientFare.getEndDate() != null ? DATE_FORMAT.format(clientFare.getEndDate()) : "");

                modelList.add(model);
                i++;
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, FareModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }

    }

}
