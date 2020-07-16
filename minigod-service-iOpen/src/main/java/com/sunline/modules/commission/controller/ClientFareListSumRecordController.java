package com.sunline.modules.commission.controller;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.commission.entity.ClientFareListSumRecordEntity;
import com.sunline.modules.commission.service.ClientFareListSumRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;


/**
 * 客户费率设置汇总表
 *
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
@RestController
@RequestMapping("clientfarelistsumrecord")
public class ClientFareListSumRecordController extends BaseController{
	@Autowired
	private ClientFareListSumRecordService clientFareListSumRecordService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("clientfarelistsumrecord:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ClientFareListSumRecordEntity> clientFareListSumRecordList = clientFareListSumRecordService.queryList(query);
		int total = clientFareListSumRecordService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(clientFareListSumRecordList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("clientfarelistsumrecord:info")
	public Result info(@PathVariable("id") Integer id){
		ClientFareListSumRecordEntity clientFareListSumRecord = clientFareListSumRecordService.queryObject(id);
		
		return Result.ok().put("clientFareListSumRecord", clientFareListSumRecord);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("clientfarelistsumrecord:save")
	public Result save(@RequestBody ClientFareListSumRecordEntity clientFareListSumRecord){
		clientFareListSumRecordService.save(clientFareListSumRecord);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("clientfarelistsumrecord:update")
	public Result update(@RequestBody ClientFareListSumRecordEntity clientFareListSumRecord){
		clientFareListSumRecordService.update(clientFareListSumRecord);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("clientfarelistsumrecord:delete")
	public Result delete(@RequestBody Integer[] ids){
		clientFareListSumRecordService.deleteBatch(ids);
		
		return Result.ok();
	}
	
}
