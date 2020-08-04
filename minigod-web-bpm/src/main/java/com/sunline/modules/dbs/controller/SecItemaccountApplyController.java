package com.sunline.modules.dbs.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.dbs.entity.SecItemaccountApplyEntity;
import com.sunline.modules.dbs.service.SecItemaccountApplyService;


/**
 * 中银子账号配置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-03 11:22:55
 */
@RestController
@RequestMapping("secitemaccountapply")
public class SecItemaccountApplyController extends BaseController{
	@Autowired
	private SecItemaccountApplyService secItemaccountApplyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("secitemaccountapply:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<SecItemaccountApplyEntity> secItemaccountApplyList = secItemaccountApplyService.queryList(query);
		int total = secItemaccountApplyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(secItemaccountApplyList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("secitemaccountapply:info")
	public Result info(@PathVariable("id") Long id){
		SecItemaccountApplyEntity secItemaccountApply = secItemaccountApplyService.queryObject(id);
		
		return Result.ok().put("secItemaccountApply", secItemaccountApply);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("secitemaccountapply:save")
	public Result save(@RequestBody SecItemaccountApplyEntity secItemaccountApply){
		secItemaccountApplyService.save(secItemaccountApply);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("secitemaccountapply:update")
	public Result update(@RequestBody SecItemaccountApplyEntity secItemaccountApply){
		secItemaccountApplyService.update(secItemaccountApply);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("secitemaccountapply:delete")
	public Result delete(@RequestBody Long[] ids){
		secItemaccountApplyService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
