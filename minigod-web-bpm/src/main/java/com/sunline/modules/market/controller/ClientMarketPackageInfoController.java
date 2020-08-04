package com.sunline.modules.market.controller;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.EasyExcelUtils;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.market.entity.ClientMarketPackageInfoEntity;
import com.sunline.modules.market.model.MarketPackageExportModel;
import com.sunline.modules.market.service.ClientMarketPackageInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 行情套餐购买信息表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */
@Controller
@RequestMapping("clientMarketPackageInfo")
public class ClientMarketPackageInfoController extends BaseController {
	@Autowired
	private ClientMarketPackageInfoService clientMarketPackageInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("clientMarketPackageInfo:list")
	public String list(Model model, ClientMarketPackageInfoEntity queryCondition, HttpServletRequest request){
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

        if (getUserId().equals(Constant.SUPERR_USER)) {
            queryCondition.setChannelIds(null);
        } else {
            queryCondition.setChannelIds(getChannelIds());
        }
        if (queryCondition.getBeginTime() != null && StringUtils.isNotBlank(queryCondition.getBeginTime())) {
            queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(queryCondition.getBeginTime())), "yyyy-MM-dd HH:mm:ss"));
        }
        if (queryCondition.getEndTime() != null && StringUtils.isNotBlank(queryCondition.getEndTime())) {
            queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(queryCondition.getEndTime())), "yyyy-MM-dd HH:mm:ss"));
        }

        Page<ClientMarketPackageInfoEntity> page = clientMarketPackageInfoService.findPage(queryCondition, pageNum);

        if (queryCondition.getBeginTime() != null && StringUtils.isNotBlank(queryCondition.getBeginTime())) {
            queryCondition.setBeginTime(DateUtil.format(DateUtil.parse(queryCondition.getBeginTime()), "yyyy-MM-dd"));
        }
        if (queryCondition.getEndTime() != null && StringUtils.isNotBlank(queryCondition.getEndTime())) {
            queryCondition.setEndTime(DateUtil.format(DateUtil.parse(queryCondition.getEndTime()), "yyyy-MM-dd"));
        }
        model.addAttribute("page", page);
        model.addAttribute("params", queryCondition);

        return "market/marketList";
	}


    /**
     * 列表导出
     */
    @RequestMapping("/expList")
    @RequiresPermissions("clientMarketPackageInfo:expList")
    public void listExport(ClientMarketPackageInfoEntity queryCondition, HttpServletResponse response){

        if (getUserId().equals(Constant.SUPERR_USER)) {
            queryCondition.setChannelIds(null);
        } else {
            queryCondition.setChannelIds(getChannelIds());
        }
        if (queryCondition.getBeginTime() != null && StringUtils.isNotBlank(queryCondition.getBeginTime())) {
            queryCondition.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(queryCondition.getBeginTime())), "yyyy-MM-dd HH:mm:ss"));
        }
        if (queryCondition.getEndTime() != null && StringUtils.isNotBlank(queryCondition.getEndTime())) {
            queryCondition.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(queryCondition.getEndTime())), "yyyy-MM-dd HH:mm:ss"));
        }

        List<ClientMarketPackageInfoEntity> entityList = clientMarketPackageInfoService.queryList(queryCondition);
        List<MarketPackageExportModel> modelList = Lists.newArrayList();

        for (ClientMarketPackageInfoEntity entity : entityList) {
            MarketPackageExportModel model = new MarketPackageExportModel();
            model.setBuyDate(DateUtil.format(entity.getBuyDate(), "yyyy-MM-dd"));
            model.setClientId(entity.getClientId());
            model.setClientName(entity.getClientName());
            model.setFundAccount(entity.getFundAccount());
            model.setUserId(entity.getUserId());
            model.setPhoneNumber(entity.getPhoneNumber());
            model.setPackagePrice(String.valueOf(entity.getPackagePrice()));
            model.setTotalCost(String.valueOf(entity.getTotalCost()));
            model.setValidityPeriod(entity.getValidityPeriod());
            model.setPackageName(CodeUtils.getCodeName("MARKET_TYPE", String.valueOf(entity.getPackageName())));
            model.setDeductionStatus(CodeUtils.getCodeName("MARKET_BUY_TYPE", String.valueOf(entity.getDeductionStatus())));
            modelList.add(model);
        }

        try {
            EasyExcelUtils.exportXlsxFile(modelList, response, MarketPackageExportModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("clientMarketPackageInfo:info")
	public Result info(@PathVariable("id") Long id){
		ClientMarketPackageInfoEntity clientMarketPackageInfo = clientMarketPackageInfoService.queryObject(id);
		
		return Result.ok().put("clientMarketPackageInfo", clientMarketPackageInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("clientMarketPackageInfo:save")
	public Result save(@RequestBody ClientMarketPackageInfoEntity clientMarketPackageInfo){
		clientMarketPackageInfoService.save(clientMarketPackageInfo);

		return Result.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("clientMarketPackageInfo:update")
	public Result update(@RequestBody ClientMarketPackageInfoEntity clientMarketPackageInfo){
		clientMarketPackageInfoService.update(clientMarketPackageInfo);

		return Result.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("clientMarketPackageInfo:delete")
	public Result delete(@RequestBody Long[] ids){
		clientMarketPackageInfoService.deleteBatch(ids);

		return Result.ok();
	}

}
