package com.sunline.modules.analysis.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.analysis.entity.ClientFundDepositEntity;
import com.sunline.modules.analysis.model.ClientFundDepositModel;
import com.sunline.modules.analysis.service.ClientFundDepositService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.ChannelUtil;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.Utils;
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
import java.util.List;


/**
 * 出入金查询
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 16:22:19
 */
@Controller
@RequestMapping("clientFundDeposit")
public class ClientFundDepositController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日期格式化
     */
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ClientFundDepositService clientFundDepositService;
    @Autowired
    private StkTrdCaleService stkTrdCaleService;

    /**
     * 出入金查询
     *
     * @param model
     * @param clientFundDepositEntity
     * @param request
     * @return
     */
    @RequestMapping("/getClientFundDepositList")
    @RequiresPermissions("getClientFundDepositList:list")
    public String getClientFundDepositList(Model model, ClientFundDepositEntity clientFundDepositEntity, HttpServletRequest request) {

        String name = request.getParameter("name");
        if (name != null && !"".equals(name)) {
            clientFundDepositEntity.setChannelName(name);
        }

        // 获取交易日历
        StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.today(), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

        // 如果查询日期为null则默认查前一日交易数据
        if (!"".equals(clientFundDepositEntity.getBeginDate()) && null != clientFundDepositEntity.getBeginDate()) {
            clientFundDepositEntity.setBeginDate(clientFundDepositEntity.getBeginDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientFundDepositEntity.setBeginDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientFundDepositEntity.setBeginDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        if (!"".equals(clientFundDepositEntity.getEndDate()) && null != clientFundDepositEntity.getEndDate()) {
            clientFundDepositEntity.setEndDate(clientFundDepositEntity.getEndDate());
        } else {
            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientFundDepositEntity.setEndDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientFundDepositEntity.setEndDate(stkTrdCaleEntity.getLastTrd());
            }
        }

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        if (getUserId().equals(Constant.SUPERR_USER)) {
            clientFundDepositEntity.setChannelIds(null);
        } else {
            clientFundDepositEntity.setChannelIds(getChannelIds());
        }
        if (clientFundDepositEntity.getCheckedChannelId() != null && !"".equals(clientFundDepositEntity.getCheckedChannelId())) {
            List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientFundDepositEntity.getCheckedChannelId());
            if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                clientFundDepositEntity.setCheckedChannelIds(checkedChannelIds);
            }
        }
        Page<ClientFundDepositEntity> page = clientFundDepositService.findPage(clientFundDepositEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("params", clientFundDepositEntity);
        return "analysis/clientFundDepositList";
    }


    /**
     * 出入金查询导出Excel
     *
     * @param clientFundDepositEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/clientFundDepListExpExcel")
    @RequiresPermissions("clientFundDepListExpExcel:exp")
    @SysLog("出入金查询导出")
    public void clientFundDepListExpExcel(ClientFundDepositEntity clientFundDepositEntity, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (getUserId().equals(Constant.SUPERR_USER)) {
                clientFundDepositEntity.setChannelIds(null);
            } else {
                clientFundDepositEntity.setChannelIds(getChannelIds());
            }
            if (clientFundDepositEntity.getCheckedChannelId() != null && !"".equals(clientFundDepositEntity.getCheckedChannelId())) {
                List<String> checkedChannelIds = ChannelUtil.getCheckedChannelIds(clientFundDepositEntity.getCheckedChannelId());
                if (checkedChannelIds != null && checkedChannelIds.size() > 0) {
                    clientFundDepositEntity.setCheckedChannelIds(checkedChannelIds);
                }
            }
            List<ClientFundDepositEntity> clientFundDepositList = clientFundDepositService.findClientFundDepExcelList(clientFundDepositEntity);

            List<ClientFundDepositModel> modelList = Lists.newArrayList();

            for (int i = 0; i < clientFundDepositList.size(); i++) {
                ClientFundDepositModel model = new ClientFundDepositModel();

                // 填充数据
                model.setId(String.valueOf(i + 1));
                model.setUserId(clientFundDepositList.get(i).getUserId() != null ? clientFundDepositList.get(i).getUserId().toString() : "");
                model.setClientName(clientFundDepositList.get(i).getClientName());
                model.setClientId(clientFundDepositList.get(i).getClientId());
                model.setFundAccount(clientFundDepositList.get(i).getFundAccount());
                model.setChannelId(clientFundDepositList.get(i).getChannelId());
                model.setInitDate(clientFundDepositList.get(i).getInitDate());
                model.setDepositType(clientFundDepositList.get(i).getDepositType() != null ? CrmCommonEnum.SecDataDictionary.getName(clientFundDepositList.get(i).getDepositType()) : "");
                model.setMoneyType(clientFundDepositList.get(i).getMoneyType() != null ? CrmCommonEnum.SecMoneyType.getName(clientFundDepositList.get(i).getMoneyType()) : "");
                model.setOccurBalance(clientFundDepositList.get(i).getOccurBalance().toString());

                String firstDepFlag = "";
                if (clientFundDepositList.get(i).getFirstDepFlag() != null && !"".equals(clientFundDepositList.get(i).getFirstDepFlag())) {
                    firstDepFlag = Integer.parseInt(clientFundDepositList.get(i).getFirstDepFlag()) < 1 ? "是" : "否";
                }
                model.setFirstDepFlag(firstDepFlag);

                model.setRemark(clientFundDepositList.get(i).getRemark().toString());

                modelList.add(model);
            }

            EasyExcelUtils.exportXlsxFile(modelList, response, ClientFundDepositModel.class);
        } catch (Exception e) {
            logger.error("导出Excel文件异常", e);
        }
    }


    /**
     * 資金历史记录
     *
     * @param model
     * @param clientFundDepositEntity
     * @param request
     * @return
     */
    @RequestMapping("/assetList")
    public String assetList(Model model, ClientFundDepositEntity clientFundDepositEntity, HttpServletRequest request) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<ClientFundDepositEntity> page = clientFundDepositService.findPage(clientFundDepositEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("fundAccount", clientFundDepositEntity.getFundAccount());
        return "stock/assetList";
    }

}
