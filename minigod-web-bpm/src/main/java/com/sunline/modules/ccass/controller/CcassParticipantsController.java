package com.sunline.modules.ccass.controller;

import com.google.common.collect.Lists;
import com.sunline.modules.ccass.entity.CcassParticipantsEntity;
import com.sunline.modules.ccass.model.CcassParticipantsInfoModel;
import com.sunline.modules.ccass.service.CcassParticipantsService;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.ObjectExcelView;
import com.sunline.modules.common.utils.Utils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * CCASS
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-17 16:05:58
 */
@Controller
@RequestMapping("ccassParticipants")
public class CcassParticipantsController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CcassParticipantsService ccassParticipantsService;


    /**
     * 获取CCASS参与者信息列表
     *
     * @param model
     * @param ccassParticipantsEntity
     * @param request
     * @return
     */
    @RequestMapping("/getCcassParticiInfoList")
    @RequiresPermissions("getCcassParticiInfoList:list")
    public String getCcassParticiInfoList(Model model, CcassParticipantsEntity ccassParticipantsEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<CcassParticipantsEntity> page = ccassParticipantsService.findPage(ccassParticipantsEntity, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("params", ccassParticipantsEntity);
        return "ccass/ccassParticipantsInfoList";
    }

    /**
     * CCASS参与者信息列表导出列表
     * @param ccassParticipantsEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/ccassParticiInfoListExpExcel")
    @RequiresPermissions("ccassParticiInfoListExpExcel:exp")
    public void ccassParticiInfoListExpExcel(CcassParticipantsEntity ccassParticipantsEntity, HttpServletRequest request, HttpServletResponse response) {
        try {

            List<CcassParticipantsEntity> ccassParticipantsList = ccassParticipantsService.findCcassParticiInfoExcelList(ccassParticipantsEntity);

            List<CcassParticipantsInfoModel> modelList = Lists.newArrayList();
            for (int i = 0; i < ccassParticipantsList.size(); i++) {
                CcassParticipantsInfoModel model = new CcassParticipantsInfoModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setCcassId(ccassParticipantsList.get(i).getCcassId());
                model.setCcassNameEn(ccassParticipantsList.get(i).getCcassNameEn());
                model.setCcassNameTc(ccassParticipantsList.get(i).getCcassNameTc());
                model.setCreateTime(ccassParticipantsList.get(i).getCreateTime());
                model.setUpdateTime(ccassParticipantsList.get(i).getUpdateTime());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, CcassParticipantsInfoModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }
}
