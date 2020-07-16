package com.sunline.modules.ccass.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.analysis.model.ClientTrdFlowInfoDetailModel;
import com.sunline.modules.ccass.entity.CcassHoldingsEntity;
import com.sunline.modules.ccass.model.CcassHoldingsModel;
import com.sunline.modules.ccass.service.CcassHoldingsService;
import com.sunline.modules.common.common.ERegion;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageData;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.ObjectExcelView;
import com.sunline.modules.common.utils.Utils;
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
import java.util.*;

/**
 * CCASS
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-18 11:12:43
 */

@Controller
@RequestMapping("ccassHoldings")
public class CcassHoldingsController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private CcassHoldingsService ccassHoldingsService;

    @Autowired
    private StkTrdCaleService stkTrdCaleService;


    /**
     * 获取CCASS参与者持仓信息
     *
     * @param model
     * @param ccassHoldingsEntity
     * @param request
     * @return
     */
    @RequestMapping("/getCcassHoldingsInfoList")
    public String getCcassHoldingsInfoList(Model model, CcassHoldingsEntity ccassHoldingsEntity, HttpServletRequest request) {

        if (null != request.getParameter("participantId") && !"".equals(request.getParameter("participantId"))) {
            ccassHoldingsEntity.setParticipantId(Integer.parseInt(request.getParameter("participantId")));
        }

        if (null == ccassHoldingsEntity.getUpdateDate() || "".equals(ccassHoldingsEntity.getUpdateDate())) {
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getLastNextDay(DATE_FORMAT.format(new Date()), ERegion.HK.name());
            ccassHoldingsEntity.setUpdateDate(stkTrdCaleEntity.getLastTrd());
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<CcassHoldingsEntity> page = ccassHoldingsService.findPage(ccassHoldingsEntity, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("params", ccassHoldingsEntity);
        return "ccass/ccassHoldingsInfoList";
    }

    /**
     * CCASS参与者持仓信息导出列表
     *
     * @param ccassHoldingsEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/ccassHoldingsInfoListExpExcel")
    public void ccassHoldingsInfoListExpExcel(CcassHoldingsEntity ccassHoldingsEntity, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        try {

            List<CcassHoldingsEntity> ccassHoldingsList = ccassHoldingsService.findCcassHoldingsInfoExcelList(ccassHoldingsEntity);

            List<CcassHoldingsModel> modelList = Lists.newArrayList();

            for (int i = 0; i < ccassHoldingsList.size(); i++) {
                CcassHoldingsModel model = new CcassHoldingsModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setStockCode(ccassHoldingsList.get(i).getStockCode());
                model.setStockNameEn(ccassHoldingsList.get(i).getStockNameEn());
                model.setStockHolding(ccassHoldingsList.get(i).getStockHolding().toString());
                model.setStockValue(ccassHoldingsList.get(i).getStockValue().toString());
                model.setStakePercentage(ccassHoldingsList.get(i).getStakePercentage());
                model.setHoldDate(ccassHoldingsList.get(i).getHoldDate());
                model.setUpdateDate(ccassHoldingsList.get(i).getUpdateDate());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, CcassHoldingsModel.class);

        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }
}
