package com.sunline.modules.sys.controller;

import com.google.common.collect.Maps;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.PageUtils;
import com.sunline.modules.common.utils.Query;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.sys.entity.RoleEntity;
import com.sunline.modules.sys.service.RoleMenuService;
import com.sunline.modules.sys.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 角色权限控制
 * @author: Larry Lai
 * @date: 2018/9/11 14:21
 * @version: v1.0
 */

@RestController
@RequestMapping("sys/role")
public class RoleController extends BaseController {
	@Autowired
	private RoleService roleService;
	@Autowired
    private RoleMenuService roleMenuService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:role:list")
	@SysLog("查看角色列表")
	public Result list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<RoleEntity> roleList = roleService.queryList(query);
		int total = roleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(roleList, total, query.getLimit(), query.getPage());
		
		return Result.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sys:role:info")
	@SysLog("查看角色")
	public Result info(@PathVariable("id") String id){
		RoleEntity role = roleService.queryObject(id);
        List<String> organIdList = roleService.queryOrganRoleByRoleId(id);
        role.setOrganIdList(organIdList);
        List<String> menuIds = roleMenuService.queryListByRoleId(id);
        role.setMenuIdList(menuIds);
        List<String> channelIds = roleMenuService.queryChannelByRoleId(id);
        role.setChannelIdList(channelIds);
        return Result.ok().put("role", role);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sys:role:update")
	@SysLog("新增角色")
	public Result save(@RequestBody RoleEntity role){
        Result result = Result.ok();
        try {
			roleService.save(role);
		} catch (Exception e) {
            result=Result.error();
            e.printStackTrace();
		}
		return result;
	}

	/**
	 * 角色列表
	 */
	@RequestMapping("/select")
	public Result select(RoleEntity role){
		Map<String, Object> map = Maps.newHashMap();

		//如果不是超级管理员，则只查询自己所拥有的角色列表
		if(getUserId() != Constant.SUPERR_USER){
			map.put("createUserId", getUserId());
		}

		map.put("roleType",role.getRoleType());
		List<RoleEntity> list = roleService.queryList(map);

		return Result.ok().put("list", list);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sys:role:update")
	@SysLog("修改角色")
	public Result update(@RequestBody RoleEntity role){
		roleService.updateByOption(role);
		
		return Result.ok();
	}
	
	/**
	 * 禁用
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sys:role:delete")
	@SysLog("禁用角色")
	public Result delete(@RequestBody String[] ids){
        Result result = Result.ok();
        try {
            roleService.updateBatchStatus(ids,Constant.ABLE_STATUS.NO.getValue());
        } catch (Exception e) {
            result=Result.error();
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 启用
	 */
	@RequestMapping("/enabled")
	@RequiresPermissions("sys:role:enabled")
	@SysLog("启用角色")
	public Result enabled(@RequestBody String[] ids){
		Result result = Result.ok();
		try {
			roleService.updateBatchStatus(ids,Constant.ABLE_STATUS.YES.getValue());
		} catch (Exception e) {
			result=Result.error();
			e.printStackTrace();
		}
		return result;
	}
	
}
