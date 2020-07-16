package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.ClientIpoEntity;
import com.sunline.modules.analysis.entity.ClientIpoIncomeEntity;
import com.sunline.modules.analysis.model.ClientIpoIncomeModel;
import com.sunline.modules.analysis.model.ClientIpoModel;
import com.sunline.modules.analysis.service.ClientIpoService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.marker.service.UserChannelInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 打新查询
 *
 * @author lcs
 * @date 2018-06-22 14:00:00
 * @
 */
@Controller
@RequestMapping("clientIpo")
public class ClientIpoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final SimpleDateFormat DATE_FROMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private ClientIpoService clientIpoService;
    @Autowired
    private UserChannelInfoService channelService;

    @RequestMapping("/list")
    @RequiresPermissions("clientIpo:list")
    public String hitNewQuery(Model model, ClientIpoEntity clientIpoEntity, HttpServletRequest request) {
        if ((clientIpoEntity.getBeginDate() == null || "".equals(clientIpoEntity.getBeginDate())) || (clientIpoEntity.getEndDate() == null || "".equals(clientIpoEntity.getEndDate()))) {
            clientIpoEntity.setBeginDate(DATE_FROMAT.format(DateUtil.lastMonth()));
            clientIpoEntity.setEndDate(DateUtil.today());
        }

        if (clientIpoEntity.getCheckedChannelId() != null && !"".equals(clientIpoEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientIpoEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                clientIpoEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (getUserId().equals(Constant.SUPERR_USER)) {
            clientIpoEntity.setChannelIds(null);
        } else {
            clientIpoEntity.setChannelIds(getChannelIds());
        }
        Page<ClientIpoEntity> page = clientIpoService.queryList(clientIpoEntity, pageNum);

        //是否为敏感信息组
        model.addAttribute("shield", UserUtils.isSensitiveUser());
        model.addAttribute("page", page);
        model.addAttribute("model", clientIpoEntity);
        return "analysis/clientIpoList";
    }

    /**
     * 打新查询 导出
     *
     * @param clientIpoEntity
     * @param request
     * @return
     */
    @RequestMapping("/export")
    @RequiresPermissions("clientIpo:exp")
    @SysLog("打新查询导出")
    public void export(ClientIpoEntity clientIpoEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientIpoEntity.setChannelIds(null);
            } else {
                clientIpoEntity.setChannelIds(getChannelIds());
            }
            List<ClientIpoEntity> list = clientIpoService.hitNewQqueryList(clientIpoEntity);

            List<ClientIpoModel> modelList = Lists.newArrayList();

            boolean sensitiveUser = UserUtils.isSensitiveUser();
            for (int i = 0; i < list.size(); i++) {
                ClientIpoModel model = new ClientIpoModel();
                // 填充数据
                BeanUtils.copyProperties(list.get(i), model);
                model.setId(String.valueOf(i + 1));
                model.setPhoneNumber(sensitiveUser == true ? "******" : list.get(i).getPhoneNumber());
                model.setType(list.get(i).getType() != null ? CodeUtils.getCodeName("SEC_CURR_TYPE", list.get(i).getType()) : "");
                model.setExchangeType(list.get(i).getExchangeType() != null ? CodeUtils.getCodeName("SEC_EXCHANGE_TYPE", list.get(i).getExchangeType()) : "");
                model.setStatus(list.get(i).getStatus() != null ? CodeUtils.getCodeName("SEC_CURR_STATUS", list.get(i).getStatus()) : "");

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientIpoModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }


    /**
     * 活动打新 2018-09-19
     *
     * @param model
     * @param clientIpoIncomeEntity
     * @return
     */
    @RequestMapping("/ipoIncomeList")
    @RequiresPermissions("clientIpo:ipoIncomeList")
    public String ipoIncomeList(Model model, ClientIpoIncomeEntity clientIpoIncomeEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        if (null == clientIpoIncomeEntity.getEndDate() || "".equals(clientIpoIncomeEntity.getEndDate())) {
            clientIpoIncomeEntity.setEndDate(DATE_FROMAT.format(new Date()));
        }

        if (null == clientIpoIncomeEntity.getBeginDate() || "".equals(clientIpoIncomeEntity.getBeginDate())) {
            clientIpoIncomeEntity.setBeginDate(DATE_FROMAT.format(DateUtil.lastMonth()));
        }

        Page<ClientIpoIncomeEntity> page = clientIpoService.getIpoIncomeList(clientIpoIncomeEntity, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("model", clientIpoIncomeEntity);

        return "analysis/clientIpoIncomeList";
    }

    /**
     * 活动打新 2018-09-19 导出
     *
     * @param clientIpoIncomeEntity
     * @return
     */
    @RequestMapping("/ipoIncomeListExp")
    @RequiresPermissions("clientIpo:ipoIncomeListExp")
    @SysLog("打新活动导出")
    public void ipoIncomeListExp(ClientIpoIncomeEntity clientIpoIncomeEntity, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientIpoIncomeEntity.setChannelIds(null);
            } else {
                clientIpoIncomeEntity.setChannelIds(getChannelIds());
            }

            List<ClientIpoIncomeEntity> list = clientIpoService.getIpoIncomeList(clientIpoIncomeEntity);

            List<ClientIpoIncomeModel> modelList = Lists.newArrayList();

            for (int i = 0; i < list.size(); i++) {
                ClientIpoIncomeModel model = new ClientIpoIncomeModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(list.get(i).getUserId());
                model.setRegisterDate(list.get(i).getRegisterDate());
                model.setOpenAccountDate(list.get(i).getOpenAccountDate());
                model.setFirstIncomeDate(list.get(i).getFirstIncomeDate());
                model.setFirstIncomeMoney(list.get(i).getFirstIncomeMoney());
                model.setIpoIncomeMoney(list.get(i).getIpoIncomeMoney());
                model.setIpoApplyCount(list.get(i).getIpoApplyCount());
                model.setInviteCount(list.get(i).getInviteCount());
                model.setInviteIncomeMoney(list.get(i).getInviteIncomeMoney());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientIpoIncomeModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }

}