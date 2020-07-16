package com.sunline.modules.report.service.impl;


import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.report.dao.UserDefinedSqlDao;
import com.sunline.modules.report.entity.UserDefinedSqlEntity;
import com.sunline.modules.report.service.UserDefinedSqlService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * 用户自定义数据库查询表
 *
 * @author fuyy
 * @email
 * @date 2018-11-30 14:22:50
 */

@Service("userDefinedSqlService")
public class UserDefinedSqlServiceImpl implements UserDefinedSqlService {

	@Autowired
	private UserDefinedSqlDao userDefinedSqlDao;
	
	@Override
	public UserDefinedSqlEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return userDefinedSqlDao.queryObject(id);
	}
	
	@Override
	public List<UserDefinedSqlEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return userDefinedSqlDao.queryList(map);
	}

    @Override
    public List<UserDefinedSqlEntity> queryListByBean(UserDefinedSqlEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return userDefinedSqlDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return userDefinedSqlDao.queryTotal(map);
	}
	
	@Override
	public int save(UserDefinedSqlEntity userDefinedSql){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		userDefinedSql.setCreateOpr(UserUtils.getCurrentUser().getUserName());
		userDefinedSql.setCreateTime(new Date());
		return userDefinedSqlDao.save(userDefinedSql);
	}
	
	@Override
	public int update(UserDefinedSqlEntity userDefinedSql){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		userDefinedSql.setUpdateOpr(UserUtils.getCurrentUser().getUserName());
		userDefinedSql.setUpdateTime(new Date());
        return userDefinedSqlDao.update(userDefinedSql);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userDefinedSqlDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userDefinedSqlDao.deleteBatch(ids);
	}


	@Override
	public Page<UserDefinedSqlEntity> findPage(UserDefinedSqlEntity query, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		PageHelper.startPage(pageNum, Constant.pageSize);
		userDefinedSqlDao.queryUserDefinedList(query);
		return PageHelper.endPage();
	}


	@Override
	public List<LinkedHashMap<String, Object>> getUserDefinedExecl(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		return userDefinedSqlDao.selectUserDefinedSql(map);
	}

	@Override
	public Page<Object> findPageUserDefined(Map<String, Object> map, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
		PageHelper.startPage(pageNum, Constant.pageSize);
		List<LinkedHashMap<String, Object>> resultList = userDefinedSqlDao.selectUserDefinedSql(map);
		return PageHelper.endPage();
	}

}
