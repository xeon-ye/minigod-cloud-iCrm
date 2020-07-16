package com.sunline.modules.fund.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.fund.entity.ClientBankCardInfoEntity;
import com.sunline.modules.fund.entity.HsCompanyBankEntity;
import com.sunline.modules.fund.service.ClientBankCardInfoService;
import com.sunline.modules.fund.service.HsCompanyBankService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * 银行卡管理记录表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
@Controller
@RequestMapping("clientBankCardInfo")
public class ClientBankCardInfoController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ClientBankCardInfoController.class);

	@Autowired
	private ClientBankCardInfoService clientBankCardInfoService;

	@Autowired
	HsCompanyBankService hsCompanyBankService;

	@Autowired
	private SecUserInfoService secUserInfoService;
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("clientBankCardInfo:list")
	public String list(Model model, ClientBankCardInfoEntity queryCondition, HttpServletRequest request){
		//查询列表数据
		int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);

		Page<ClientBankCardInfoEntity> page = clientBankCardInfoService.findPage(queryCondition, pageNum);

		model.addAttribute("page", page);
		model.addAttribute("params", queryCondition);

		return "fund/deposit/bankCardInfoList";
	}

	/**
	 * 跳转修改页面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/toEditView")
	public String toEditView(Model model, Long flowId) {
		try {
			ClientBankCardInfoEntity entity = clientBankCardInfoService.queryObject(flowId);
			model.addAttribute("info", entity);
		} catch (Exception e) {
			logger.error("跳转银行卡修改页面", e);
		}
		return "fund/deposit/editBankCardTab";
	}

	/**
	 * 跳转新增页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/toAddView")
	public String toAddView() {
		return "fund/deposit/addBankCardTab";
	}
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("clientBankCardInfo:info")
	public Result info(@PathVariable("id") Long id){
		ClientBankCardInfoEntity clientBankCardInfo = clientBankCardInfoService.queryObject(id);
		
		return Result.ok().put("clientBankCardInfo", clientBankCardInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions("clientBankCardInfo:save")
	public Result save(ClientBankCardInfoEntity clientBankCardInfo){

			SecuritiesUserInfoEntity entity = new SecuritiesUserInfoEntity();
			entity.setTradeAccount(clientBankCardInfo.getClientId());
			entity.setFundAccount(clientBankCardInfo.getFundAccount());
			SecuritiesUserInfoEntity securitiesUserInfo = secUserInfoService.queryObject(entity);
			if (null == securitiesUserInfo) {
				throw new MyException("该用户不存在！");
			}
			ClientBankCardInfoEntity query = new ClientBankCardInfoEntity();
			query.setBankAccount(clientBankCardInfo.getBankAccount());
			query.setBankNo(clientBankCardInfo.getBankNo());
			query.setStatus(1);
			List<ClientBankCardInfoEntity> cards = clientBankCardInfoService.queryListByBean(query);
			if (CollectionUtil.isNotEmpty(cards)) {
				throw new MyException("该银行卡已存在！");
			}
		try {
			clientBankCardInfo.setStatus(1);
			clientBankCardInfo.setCreateUser(UserUtils.getCurrentUserId());
			clientBankCardInfo.setRegisterTime(new Date());
			clientBankCardInfo.setCreateTime(new Date());
			clientBankCardInfoService.save(clientBankCardInfo);

			return Result.ok("新增成功！");
		}catch (Exception e){
			logger.info("新增银行卡信息异常：",e);
			return Result.error("新增失败！");
		}
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	public Result update(ClientBankCardInfoEntity clientBankCardInfo){
		ClientBankCardInfoEntity query = new ClientBankCardInfoEntity();
		query.setBankAccount(clientBankCardInfo.getBankAccount());
		query.setBankNo(clientBankCardInfo.getBankNo());
		query.setBankName(clientBankCardInfo.getBankName());
		query.setStatus(1);
		List<ClientBankCardInfoEntity> cards = clientBankCardInfoService.queryListByBean(query);
		if (CollectionUtil.isNotEmpty(cards)) {
			throw new MyException("该银行卡已存在！");
		}

		clientBankCardInfo.setUpdateTime(new Date());
		clientBankCardInfo.setUpdateUser(UserUtils.getCurrentUserId());
		clientBankCardInfoService.update(clientBankCardInfo);
		
		return Result.ok();
	}

	/**
	 * 解绑
	 */
	@RequestMapping("/untie")
	@ResponseBody
	public Result untie(ClientBankCardInfoEntity clientBankCardInfo){
		clientBankCardInfo.setUpdateTime(new Date());
		clientBankCardInfo.setUntiedTime(new Date());
		clientBankCardInfo.setUpdateUser(UserUtils.getCurrentUserId());
		clientBankCardInfoService.update(clientBankCardInfo);

		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("clientBankCardInfo:delete")
	public Result delete(@RequestBody Long[] ids){
		clientBankCardInfoService.deleteBatch(ids);
		
		return Result.ok();
	}

	/**
	 * 修改恒生银行
	 */
	@RequestMapping("/updateHsCompanyBank")
	@ResponseBody
	public Result updateHsCompanyBank(HsCompanyBankEntity hsCompanyBankEntity){

		hsCompanyBankService.update(hsCompanyBankEntity);

		return Result.ok();
	}
	
}
