package com.sunline.modules.user.controller;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunline.modules.user.entity.UserCertEntity;
import com.sunline.modules.user.service.UserCertService;
import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;


/**
 * 用户登录凭证表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-22 13:26:40
 */
@RestController
@RequestMapping("usercert")
public class UserCertController extends BaseController{
	@Autowired
	private UserCertService userCertService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("usercert:list")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserCertEntity> userCertList = userCertService.queryList(query);
		int total = userCertService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userCertList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("usercert:save")
	public Result save(@RequestBody UserCertEntity userCert){
		userCertService.save(userCert);
		
		return Result.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("usercert:update")
	public Result update(@RequestBody UserCertEntity userCert){
		userCertService.update(userCert);
		
		return Result.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("usercert:delete")
	public Result delete(@RequestBody Integer[] certIds){
		userCertService.deleteBatch(certIds);
		
		return Result.ok();
	}
	
}
