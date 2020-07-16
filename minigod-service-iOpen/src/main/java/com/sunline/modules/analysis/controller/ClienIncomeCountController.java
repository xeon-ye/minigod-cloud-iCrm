package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONArray;
import com.sunline.modules.analysis.entity.ClienIncomeCountEntity;
import com.sunline.modules.analysis.service.ClienIncomeCountService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.SumDateUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 入金交易统计
 *
 * @author lcs
 * @email
 * @date 2018-06-19 14:56:39
 */
@Controller
@RequestMapping("clientIncomeCount")
public class ClienIncomeCountController extends BaseController {
    @Autowired
    private ClienIncomeCountService clienIncomeCountService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/list")
    @RequiresPermissions("getCountInfo:list")
    public String getCountInfo(Model model, ClienIncomeCountEntity clienIncomeCountEntity, HttpServletRequest request) {

        if (getUserId().equals(Constant.SUPERR_USER)) {
            clienIncomeCountEntity.setChannelIds(null);
        } else {
            clienIncomeCountEntity.setChannelIds(getChannelIds());
        }

        //截止当前入金交易统计
        ClienIncomeCountEntity  clientResultEntityTotal = clienIncomeCountService.queryCount(clienIncomeCountEntity);
        model.addAttribute("totalInfo", clientResultEntityTotal);

        //昨日入金交易统计
        if (!"".equals(clienIncomeCountEntity.getBeginDate()) && null != clienIncomeCountEntity.getBeginDate()) {
            clienIncomeCountEntity.setBeginDate(clienIncomeCountEntity.getBeginDate());
        } else {
            clienIncomeCountEntity.setBeginDate(DATE_FORMAT.format(DateUtil.yesterday()));
        }
        if (!"".equals(clienIncomeCountEntity.getEndDate()) && null != clienIncomeCountEntity.getEndDate()) {
            clienIncomeCountEntity.setEndDate(clienIncomeCountEntity.getEndDate());
        } else {
            clienIncomeCountEntity.setEndDate(DATE_FORMAT.format(DateUtil.yesterday()));
        }
        ClienIncomeCountEntity yesterdayCount = clienIncomeCountService.queryCount(clienIncomeCountEntity);
        model.addAttribute("yesterdayCount",yesterdayCount);

        // 查询上周入金交易统计
        clienIncomeCountEntity.setBeginDate(DATE_FORMAT.format(SumDateUtil.todayFirstDate(SumDateUtil.getLastMondy())));
        clienIncomeCountEntity.setEndDate(DATE_FORMAT.format(SumDateUtil.todayLastDate(SumDateUtil.getLastSundy())));
        ClienIncomeCountEntity  lastWeekCountInfo = clienIncomeCountService.queryCount(clienIncomeCountEntity);
        model.addAttribute("lastWeekCount", lastWeekCountInfo);

        // 查询上月入金交易统计
        clienIncomeCountEntity.setBeginDate(DATE_FORMAT.format(SumDateUtil.todayFirstDate(SumDateUtil.getFirstDayOfMonth())));
        clienIncomeCountEntity.setEndDate(DATE_FORMAT.format(SumDateUtil.todayLastDate(SumDateUtil.getLastDayOfMonth())));
        ClienIncomeCountEntity  lastMonthCountInfo = clienIncomeCountService.queryCount(clienIncomeCountEntity);
        model.addAttribute("lastMonthCount", lastMonthCountInfo);

        return "analysis/incomeTradeCount";
    }

    @RequestMapping("graphicShow")
    @ResponseBody
    public Result graphicShow(ClienIncomeCountEntity entity, HttpServletRequest request) {
        String cale  = request.getParameter("cale");
        List<ClienIncomeCountEntity> list = null;
        if("month".equals(cale)){
            entity.setType(request.getParameter("dataType"));
            list = clienIncomeCountService.queryDataMonth(entity);
        }else if("week".equals(cale)){
            list = clienIncomeCountService.queryDataWeek(entity);
            for(ClienIncomeCountEntity client :list ){
                client.setDateTime(client.getMonday()+"~"+client.getSunday());
            }
        }else if("day".equals(cale)){
            list = clienIncomeCountService.queryDataDay(entity);
        }
        JSONArray jsonArray = new JSONArray(list);
        return Result.ok().put("jsonArray", jsonArray).put("cale","month");
    }

}
