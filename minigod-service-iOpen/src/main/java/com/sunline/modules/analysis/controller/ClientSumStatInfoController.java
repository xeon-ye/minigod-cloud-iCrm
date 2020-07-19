package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.analysis.entity.ClientSumStatInfoEntity;
import com.sunline.modules.analysis.service.ClientSumStatInfoService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.SumDateUtil;
import net.sf.json.JSONArray;
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
 * 客户数汇总统计
 *
 * @author lcs
 * @email
 * @date 2018-05-04 10:26:17
 */
@Controller
@RequestMapping("clientSumStatInfo")
public class ClientSumStatInfoController extends BaseController {
    @Autowired
    private ClientSumStatInfoService clientSumStatInfoService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取客户数汇总统计信息
     *
     * @param model
     * @param clientSumStatInfoEntity
     * @param request
     * @return
     */
    @RequestMapping("/list")
    @RequiresPermissions("getClientSumStatInfoList:list")
    public String getClientSumStatInfoList(Model model, ClientSumStatInfoEntity clientSumStatInfoEntity, HttpServletRequest request) {

        if (getUserId().equals(Constant.SUPERR_USER)) {
            clientSumStatInfoEntity.setChannelIds(null);
        } else {
            clientSumStatInfoEntity.setChannelIds(getChannelIds());
        }

        //截止当前客户统计
        ClientSumStatInfoEntity clientResultEntity1 = clientSumStatInfoService.clientTotalCount(clientSumStatInfoEntity);
        model.addAttribute("totalInfo", clientResultEntity1);

        //昨日客户统计
        if (!"".equals(clientSumStatInfoEntity.getBeginDate()) && null != clientSumStatInfoEntity.getBeginDate()) {
            clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.parse(clientSumStatInfoEntity.getBeginDate()))));
        } else {
            clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.yesterday())));
        }
        if (!"".equals(clientSumStatInfoEntity.getEndDate()) && null != clientSumStatInfoEntity.getEndDate()) {
            clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(DateUtil.endOfDay(DateUtil.parse(clientSumStatInfoEntity.getEndDate()))));
        } else {
            clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(DateUtil.endOfDay(DateUtil.yesterday())));
        }

        ClientSumStatInfoEntity yesterdayClientCount = clientSumStatInfoService.clientTotalCount(clientSumStatInfoEntity);
        model.addAttribute("yesterdayClientCount", yesterdayClientCount);

        // 查询上周客户统计
        clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(SumDateUtil.todayFirstDate(SumDateUtil.getLastMondy())));
        clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(SumDateUtil.todayLastDate(SumDateUtil.getLastSundy())));
        ClientSumStatInfoEntity lastWeekCountInfo = clientSumStatInfoService.clientTotalCount(clientSumStatInfoEntity);
        model.addAttribute("lastWeekCountInfo", lastWeekCountInfo);

        // 查询上月客户统计
        clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(SumDateUtil.todayFirstDate(SumDateUtil.getFirstDayOfMonth())));
        clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(SumDateUtil.todayLastDate(SumDateUtil.getLastDayOfMonth())));
        ClientSumStatInfoEntity lastMonthCountInfo = clientSumStatInfoService.clientTotalCount(clientSumStatInfoEntity);
        model.addAttribute("lastMonthCountInfo", lastMonthCountInfo);


        //昨天客户统计 安卓和ios分类
        clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.yesterday())));
        clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(DateUtil.endOfDay(DateUtil.yesterday())));
        ClientSumStatInfoEntity yesterdayCountInfo = clientSumStatInfoService.clientTotalGroupCount(clientSumStatInfoEntity);
        model.addAttribute("yesterdayCountInfo", yesterdayCountInfo);

        //近一周客户统计 安卓和ios分类
        clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.lastWeek())));
        clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(DateUtil.endOfDay(DateUtil.yesterday())));
        ClientSumStatInfoEntity nearWeekCountInfo = clientSumStatInfoService.clientTotalGroupCount(clientSumStatInfoEntity);
        model.addAttribute("nearWeekCountInfo", nearWeekCountInfo);

        //近一个月客户统计 安卓和ios分类
        clientSumStatInfoEntity.setBeginDate(DATE_TIME_FORMAT.format(DateUtil.beginOfDay(DateUtil.lastMonth())));
        clientSumStatInfoEntity.setEndDate(DATE_TIME_FORMAT.format(DateUtil.endOfDay(DateUtil.yesterday())));
        ClientSumStatInfoEntity nearMonthCountInfo = clientSumStatInfoService.clientTotalGroupCount(clientSumStatInfoEntity);
        model.addAttribute("nearMonthCountInfo", nearMonthCountInfo);
        return "analysis/clientCount";
    }

    @RequestMapping("graphicShow")
    @ResponseBody
    public Result graphicShow(ClientSumStatInfoEntity entity, HttpServletRequest request) {

        if (getUserId().equals(Constant.SUPERR_USER)) {
            entity.setChannelIds(null);
        } else {
            entity.setChannelIds(getChannelIds());
        }

        String cale = request.getParameter("cale");
        String dataType = request.getParameter("dataType");
        List<ClientSumStatInfoEntity> list = null;
        if ("month".equals(cale)) {
            entity.setType(dataType);
            list = clientSumStatInfoService.queryDataMonth(entity);
        } else if ("week".equals(cale)) {
            entity.setType(dataType);
            list = clientSumStatInfoService.queryDataWeek(entity);
            for (ClientSumStatInfoEntity client : list) {
                client.setDateTime(client.getMonday() + "~" + client.getSunday());
            }
        } else if ("day".equals(cale)) {
            entity.setType(dataType);
            list = clientSumStatInfoService.queryDataDay(entity);
        }
        JSONArray jsonArray = JSONArray.fromObject(list);
        return Result.ok().put("jsonArray", jsonArray).put("cale", "month");
    }
}
