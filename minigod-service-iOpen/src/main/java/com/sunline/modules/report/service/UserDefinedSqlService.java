package com.sunline.modules.report.service;


import com.sunline.modules.common.page.Page;
import com.sunline.modules.report.entity.UserDefinedSqlEntity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户自定义数据库查询表
 * 
 * @author  fuyy
 * @email
 * @date 2018-11-30 14:22:50
 */
public interface UserDefinedSqlService {
	
	UserDefinedSqlEntity queryObject(Integer id);
	
	List<UserDefinedSqlEntity> queryList(Map<String, Object> map);

    List<UserDefinedSqlEntity> queryListByBean(UserDefinedSqlEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(UserDefinedSqlEntity userDefinedSql);
	
	int update(UserDefinedSqlEntity userDefinedSql);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

	public Page<UserDefinedSqlEntity> findPage(UserDefinedSqlEntity query, int pageNum);

	public List<LinkedHashMap<String, Object>> getUserDefinedExecl(Map<String, Object> map);

	public Page<Object> findPageUserDefined(Map<String, Object> map, int pageNum);

}
