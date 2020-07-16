package com.sunline.modules.sys.service.impl;


import com.sunline.modules.sys.dao.RoleMenuDao;
import com.sunline.modules.sys.service.RoleMenuService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("roleMenuService")
public class RoleMenuServiceImpl implements RoleMenuService {
	@Autowired
	private RoleMenuDao roleMenuDao;
	
	@Override
	public List<String> queryListByRoleId(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return roleMenuDao.queryListByRoleId(id);
	}

    @Override
    public List<String> queryChannelByRoleId(String id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return roleMenuDao.queryChannelByRoleId(id);
    }


    @Override
	public void save(Map map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		roleMenuDao.save(map);
	}


	@Override
	public void delete(String roleId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		roleMenuDao.delete(roleId);
	}
	
	@Override
	public void deleteBatch(String[] roleIds){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		roleMenuDao.deleteBatch(roleIds);
	}
	
}
