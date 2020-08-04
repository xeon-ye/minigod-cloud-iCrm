package com.sunline.modules.sys.service.impl;


import com.google.common.collect.Maps;
import com.sunline.modules.sys.dao.UserRoleDao;
import com.sunline.modules.sys.entity.UserRoleEntity;
import com.sunline.modules.sys.service.UserRoleService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Override
	public UserRoleEntity queryObject(String userId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userRoleDao.queryObject(userId);
	}
	
	@Override
	public List<UserRoleEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userRoleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userRoleDao.queryTotal(map);
	}
	
	@Override
	public void save(UserRoleEntity userRole){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		userRoleDao.save(userRole);
	}
	
	@Override
	public void update(UserRoleEntity userRole){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		userRoleDao.update(userRole);
	}
	
	@Override
	public void delete(String userId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		userRoleDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(String[] userIds){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		userRoleDao.deleteBatch(userIds);
	}

	@Override
	public void saveOrUpdate(String userId, List<String> roleIdList) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		//先删除用户与角色关系
		userRoleDao.delete(userId);
		if(roleIdList.size() == 0){
			return ;
		}
		//保存用户与角色关系
		Map<String, Object> map = Maps.newHashMap();
		map.put("userId", userId);
		map.put("roleIdList", roleIdList);
		userRoleDao.save(map);
	}

	@Override
	public List<String> queryRoleIdList(String userId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userRoleDao.queryRoleIdList(userId);
	}


}
