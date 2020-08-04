package com.sunline.modules.report.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.SumDateUtil;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.report.entity.TradeReportEntity;
import com.sunline.modules.report.model.TradeReportModel;
import com.sunline.modules.report.service.TradeReportService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 交易统计报表
 *
 * @author LCS
 * @email jim@zszhizhu.com
 * @date 2019-03-19 15:56:19
 */
@Controller
@RequestMapping("tradeReport")
public class TradeReportController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TradeReportService tradeReportService;

	/**
	 * 列表
	 */
	@RequestMapping("/reportList")
//	@RequiresPermissions("tradeReport:reportList")
	public String list(Model model, TradeReportEntity params, HttpServletRequest request){

	    if(params.getDate()==null || "0".equals(params.getDate())){
            params.setDate("0");
            if(params.getEndDate() == null || "".equals(params.getEndDate())){
                params.setEndDate(DateUtil.today());
            }
            if(params.getBeginDate() == null || "".equals(params.getBeginDate())){
                params.setBeginDate(DateUtil.lastMonth().toDateStr());
            }
        }else if("1".equals(params.getDate())){
            if(params.getEndDate() == null || "".equals(params.getEndDate())){
                params.setEndDate(DateUtil.today());
            }
            if(params.getBeginDate() == null || "".equals(params.getBeginDate())){
                params.setBeginDate(SumDateUtil.lastYear(DateUtil.today()));
            }
        }else{
            params.setEndDate(null);
            params.setBeginDate(null);
        }

        if(params.getClientType()==null){
            params.setClientType(0);
        }
        if(params.getEntrustWay() == null){
            params.setEntrustWay("7");
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page page= tradeReportService.queryReport(params,pageNum);

        model.addAttribute("params",params);
        model.addAttribute("page",page);
		return "report/tradeReport";
	}


    /**
     * 交易统计报表导出excel
     *
     * @param params
     * @param response
     * @return
     */
    @RequestMapping(value = "/tradeReportExp")
    @RequiresPermissions("tradeReport:tradeReportExp")
    @SysLog("交易统计报表导出excel")
    public void tradeReportExp(TradeReportEntity params, HttpServletResponse response) {
        try {

            if("1".equals(params.getDate())){
                params.setEndDate(DateUtil.today());
                params.setBeginDate(SumDateUtil.lastYear(DateUtil.today()));
            }

            List<TradeReportEntity> tradeReportList = tradeReportService.queryList(params);

            int i = 0;
            List<TradeReportModel> modelList = Lists.newArrayList();
            for (TradeReportEntity entity : tradeReportList) {
                i++;
                TradeReportModel model = new TradeReportModel();

                // 填充数据
                model.setId(String.valueOf(i));
                model.setDate(entity.getDate());
                if(entity.getClientType() == 0){
                    model.setClientType("个人");
                }else if(entity.getClientType() == 1 || entity.getClientType() == 4){
                    model.setClientType("机构");
                }else{
                    model.setClientType("");
                }
                model.setEntrustClientCount(entity.getEntrustClientCount());
                model.setEntrustWay(CodeUtils.getCodeName("CRM_ENTRUST_WAY",entity.getEntrustWay()));
                model.setEntrustCount(entity.getEntrustCount());
                model.setTradeCount(entity.getTradeCount());
                model.setCountRatioT(entity.getCountRatioT());
                model.setCountRatioH(entity.getCountRatioH());
                model.setTradeBalance(entity.getTradeBalance());
                model.setBalanceRatioT(entity.getBalanceRatioT());
                model.setBalanceRatioH(entity.getBalanceRatioH());

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, TradeReportModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

}
