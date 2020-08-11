package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.ChannelUtil;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.customer.entity.ActivityStatisticsEntity;
import com.sunline.modules.customer.model.ActivityStatisticsModel;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.security.SecurityKey;
import com.sunline.security.util.AESUtil;
import org.apache.commons.lang3.StringUtils;
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
 * @description: 活动统计
 * @author: Larry Lai
 * @date: 2019/6/12 15:27
 * @version: v1.0
 */

@Controller
@RequestMapping("/activity")
public class ActivityStatisticsController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecUserInfoService secUserInfoService;

    /**
     * 活动统计报表
     *
     * @param model
     * @param activityStatisticsEntity
     * @param request
     * @return
     */
    @RequestMapping("/activityStatistics")
    @RequiresPermissions("activity:list")
    public String activityStatistics(Model model, ActivityStatisticsEntity activityStatisticsEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        String phoneNumber = activityStatisticsEntity.getRegPhoneNumber();
        if (StringUtils.isNotBlank(phoneNumber)) {
            String encryptPhoneNum = AESUtil.encrypt(activityStatisticsEntity.getRegPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
            activityStatisticsEntity.setRegPhoneNumber(encryptPhoneNum);
        }

        if (getUserId().equals(Constant.SUPERR_USER)) {
            activityStatisticsEntity.setChannelIds(null);
        } else {
            activityStatisticsEntity.setChannelIds(getChannelIds());
        }

        if (StringUtils.isNotBlank(activityStatisticsEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(activityStatisticsEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                activityStatisticsEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }

        String registerStartTime = activityStatisticsEntity.getRegStartTime();
        String registerEndTime = activityStatisticsEntity.getRegEndTime();
        if (null != registerStartTime) {
            activityStatisticsEntity.setRegStartTime(registerStartTime);
        } else {
            activityStatisticsEntity.setRegStartTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.yesterday()), "yyyy-MM-dd"));
        }
        if (null != registerEndTime) {
            activityStatisticsEntity.setRegEndTime(registerEndTime);
        } else {
            activityStatisticsEntity.setRegEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(DateUtil.today())), "yyyy-MM-dd"));
        }


        Page<ActivityStatisticsEntity> page = secUserInfoService.queryActivityStatistics(activityStatisticsEntity, pageNum);

        activityStatisticsEntity.setRegPhoneNumber(phoneNumber);

        model.addAttribute("page", page);
        model.addAttribute("params", activityStatisticsEntity);
        return "analysis/activityStatisticsList";
    }

    /**
     * 活动统计导出
     *
     * @param activityStatisticsEntity
     * @param request
     * @param response
     */
    @RequestMapping(value = "/activityStatisticsExp")
    @RequiresPermissions("activity:exp")
    @SysLog("用户查询导出")
    public void cusUserExpExcel(ActivityStatisticsEntity activityStatisticsEntity, HttpServletRequest request, HttpServletResponse response) {
        try {

            String phoneNumber = activityStatisticsEntity.getRegPhoneNumber();
            if (StringUtils.isNotBlank(phoneNumber)) {
                String encryptPhoneNum = AESUtil.encrypt(activityStatisticsEntity.getRegPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
                activityStatisticsEntity.setRegPhoneNumber(encryptPhoneNum);
            }

            if (getUserId().equals(Constant.SUPERR_USER)) {
                activityStatisticsEntity.setChannelIds(null);
            } else {
                activityStatisticsEntity.setChannelIds(getChannelIds());
            }

            if (StringUtils.isNotBlank(activityStatisticsEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(activityStatisticsEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    activityStatisticsEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }

            String registerStartTime = activityStatisticsEntity.getRegStartTime();
            String registerEndTime = activityStatisticsEntity.getRegEndTime();
            if (null != registerStartTime) {
                activityStatisticsEntity.setRegStartTime(registerStartTime);
            } else {
                activityStatisticsEntity.setRegStartTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.lastMonth()), "yyyy-MM-dd"));
            }
            if (null != registerEndTime) {
                activityStatisticsEntity.setRegEndTime(registerEndTime);
            } else {
                activityStatisticsEntity.setRegEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(DateUtil.today())), "yyyy-MM-dd"));
            }


            List<ActivityStatisticsEntity> activityStatisticsList = secUserInfoService.queryActivityStatistics(activityStatisticsEntity);

            activityStatisticsEntity.setRegPhoneNumber(phoneNumber);

            List<ActivityStatisticsModel> modelList = Lists.newArrayList();

            for (int i = 0; i < activityStatisticsList.size(); i++) {
                ActivityStatisticsModel model = new ActivityStatisticsModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setRegTime(DateUtil.format(activityStatisticsList.get(i).getRegTime(), "yyyy-MM-dd HH:mm:ss"));
                model.setOpenAccountTime(DateUtil.format(activityStatisticsList.get(i).getOpenAccountTime(), "yyyy-MM-dd HH:mm:ss"));
                model.setFirstDepositDate(DateUtil.format(activityStatisticsList.get(i).getFirstDepositDate(), "yyyy-MM-dd"));
                model.setFirstTradeDate(DateUtil.format(activityStatisticsList.get(i).getFirstTradeDate(), "yyyy-MM-dd"));
                model.setFirstDepositBalance(activityStatisticsList.get(i).getFirstDepositBalance() != null ? String.valueOf(activityStatisticsList.get(i).getFirstDepositBalance()) : "");
                model.setAvailablePoints(String.valueOf(activityStatisticsList.get(i).getAvailablePoints()));
                model.setFirstTransferDate(DateUtil.format(activityStatisticsList.get(i).getFirstTransferDate(), "yyyy-MM-dd"));
                model.setFirstTransferBalance(activityStatisticsList.get(i).getFirstTransferBalance() != null ? String.valueOf(activityStatisticsList.get(i).getFirstTransferBalance()) : "");
                model.setUserId(String.valueOf(activityStatisticsList.get(i).getUserId()));
                model.setRegPhoneNumber(activityStatisticsList.get(i).getRegPhoneNumber());
                model.setRegSource(activityStatisticsList.get(i).getRegSource());
                model.setUserSourceChannelId(String.valueOf(activityStatisticsList.get(i).getUserSourceChannelId()));
                model.setLastLoginTime(DateUtil.format(activityStatisticsList.get(i).getLastLoginTime(), "yyyy-MM-dd HH:mm:ss"));

                modelList.add(model);
            }

            // 执行excel操作
            EasyExcelUtils.exportXlsxFile(modelList, response, ActivityStatisticsModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }
}
