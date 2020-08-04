package com.sunline.modules.report.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.report.entity.ChannelPerformanceStatEntity;
import com.sunline.modules.report.model.ChannelPerStatModel;
import com.sunline.modules.report.service.ChannelPerStatService;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @description: 渠道业绩统计报表
 * @author: Larry Lai
 * @date: 2018-07-28 16:45
 * @version: v1.0
 */

@Controller
@RequestMapping("/channelPerStat")
public class ChannelPerStatController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ChannelPerStatService channelPerStatService;
    @Autowired
    private StkTrdCaleService stkTrdCaleService;


    /**
     * 渠道业绩统计报表查询
     */
    @RequestMapping("/list")
    @RequiresPermissions("channelPerStat:list")
    public String getChannelPerformanceInfo(Model model, HttpServletRequest request, ChannelPerformanceStatEntity channelPerformanceStatEntity) {

        try {
            int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

            // 获取交易日历
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

            if (channelPerformanceStatEntity.getBeginDate() == null || "".equals(channelPerformanceStatEntity.getBeginDate())) {
                if (stkTrdCaleEntity.getIsTradeDay()) {
                    channelPerformanceStatEntity.setBeginDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    channelPerformanceStatEntity.setBeginDate(stkTrdCaleEntity.getLastTrd());
                }
            } else {
                channelPerformanceStatEntity.setBeginDate(channelPerformanceStatEntity.getBeginDate());
            }

            if (channelPerformanceStatEntity.getEndDate() == null || "".equals(channelPerformanceStatEntity.getEndDate())) {
                if (stkTrdCaleEntity.getIsTradeDay()) {
                    channelPerformanceStatEntity.setEndDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    channelPerformanceStatEntity.setEndDate(stkTrdCaleEntity.getLastTrd());
                }

            } else {
                channelPerformanceStatEntity.setEndDate(channelPerformanceStatEntity.getEndDate());
            }

            if (getUserId().equals(Constant.SUPERR_USER)) {
                channelPerformanceStatEntity.setChannelIds(null);
            } else {
                channelPerformanceStatEntity.setChannelIds(getChannelIds());
            }

            channelPerformanceStatEntity.setBeginDate(channelPerformanceStatEntity.getBeginDate());
            channelPerformanceStatEntity.setEndDate(channelPerformanceStatEntity.getEndDate());

            Page<ChannelPerformanceStatEntity> page = channelPerStatService.findPage(channelPerformanceStatEntity, pageNum);
            model.addAttribute("page", page);
            model.addAttribute("info", channelPerformanceStatEntity);

        } catch (Exception e) {
            logger.error("开户报表查询出现异常", e);
        }
        return "report/channelPerStatReport";
    }

    /**
     * 渠道业绩统计报表导出excle
     *
     * @param channelPerformanceStatEntity
     * @param request
     * @return
     */
    @RequestMapping("/channelPerInfoExpExcel")
    @RequiresPermissions("channelPerInfoExpExcel:exp")
    @SysLog("渠道业绩统计报表导出")
    public void channelPerInfoExpExcel(ChannelPerformanceStatEntity channelPerformanceStatEntity, HttpServletRequest request, HttpServletResponse response) {
        try {

            if (getUserId().equals(Constant.SUPERR_USER)) {
                channelPerformanceStatEntity.setChannelIds(null);
            } else {
                channelPerformanceStatEntity.setChannelIds(getChannelIds());
            }

            List<ChannelPerformanceStatEntity> list = channelPerStatService.channelPerInfoExpExcel(channelPerformanceStatEntity);

            List<ChannelPerStatModel> modelList = Lists.newArrayList();

            for (int i = 0; i < list.size(); i++) {
                ChannelPerStatModel model = new ChannelPerStatModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setChannelId(list.get(i).getChannelId() != null ? list.get(i).getChannelId().toString() : "");
                model.setAddUserQuantity(list.get(i).getAddUserQuantity() != null ? list.get(i).getAddUserQuantity().toString() : "");
                model.setTotalUserQuantity(list.get(i).getTotalUserQuantity() != null ? list.get(i).getTotalUserQuantity().toString() : "");
                model.setAddClientQuantity(list.get(i).getAddClientQuantity() != null ? list.get(i).getAddClientQuantity().toString() : "");
                model.setTotalClientQuantity(list.get(i).getTotalClientQuantity() != null ? list.get(i).getTotalClientQuantity().toString() : "");
                model.setAddDepClientQuantity(list.get(i).getAddDepClientQuantity() != null ? list.get(i).getAddDepClientQuantity().toString() : "");
                model.setTotalDepClientQuantity(list.get(i).getTotalDepClientQuantity() != null ? list.get(i).getTotalDepClientQuantity().toString() : "");
                model.setAddWitClientQuantity(list.get(i).getAddWitClientQuantity() != null ? list.get(i).getAddWitClientQuantity().toString() : "");
                model.setTotalWitClientQuantity(list.get(i).getTotalWitClientQuantity() != null ? list.get(i).getTotalWitClientQuantity().toString() : "");
                model.setAddStkTranQuantity(list.get(i).getAddStkTranQuantity() != null ? list.get(i).getAddStkTranQuantity().toString() : "");
                model.setTotalStkTranQuantity(list.get(i).getTotalStkTranQuantity() != null ? list.get(i).getTotalStkTranQuantity().toString() : "");
                model.setAddTradeClientQuantity(list.get(i).getAddTradeClientQuantity() != null ? list.get(i).getAddTradeClientQuantity().toString() : "");
                model.setTotalTradeClientQuantity(list.get(i).getTotalTradeClientQuantity() != null ? list.get(i).getTotalTradeClientQuantity().toString() : "");
                model.setAddIncomeBalance(list.get(i).getAddIncomeBalance() != null ? list.get(i).getAddIncomeBalance().toString() : "");
                model.setTotalIncomeBalance(list.get(i).getTotalIncomeBalance() != null ? list.get(i).getTotalIncomeBalance().toString() : "");
                model.setAddOutBalance(list.get(i).getAddOutBalance() != null ? list.get(i).getAddOutBalance().toString() : "");
                model.setTotalOutBalance(list.get(i).getTotalOutBalance() != null ? list.get(i).getTotalOutBalance().toString() : "");
                model.setAddTradeAmount(list.get(i).getAddTradeAmount() != null ? list.get(i).getAddTradeAmount().toString() : "");
                model.setTotalTradeAmount(list.get(i).getTotalTradeAmount() != null ? list.get(i).getTotalTradeAmount().toString() : "");
                model.setAddTradeBalance(list.get(i).getAddTradeBalance() != null ? list.get(i).getAddTradeBalance().toString() : "");
                model.setTotalTradeBalance(list.get(i).getTotalTradeBalance() != null ? list.get(i).getTotalTradeBalance().toString() : "");
                model.setAddTradeBrokerage(list.get(i).getAddTradeBrokerage() != null ? list.get(i).getAddTradeBrokerage().toString() : "");
                model.setTotalTradeBrokerage(list.get(i).getTotalTradeBrokerage() != null ? list.get(i).getTotalTradeBrokerage().toString() : "");
                model.setAddClientAsset(list.get(i).getAddClientAsset() != null ? list.get(i).getAddClientAsset().toString() : "");
                model.setTotalClientAsset(list.get(i).getTotalClientAsset() != null ? list.get(i).getTotalClientAsset().toString() : "");

                modelList.add(model);

            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ChannelPerStatModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }


}
