package com.sunline.modules.report.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.report.entity.UserDefinedSqlEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户自定义数据库查询表
 * 
 * @author fuyy
 * @email aljqiang@163.com
 * @date 2018-11-30 14:22:50
 */
@Mapper
public interface UserDefinedSqlDao extends BaseDao<UserDefinedSqlEntity> {

    List<UserDefinedSqlEntity> queryUserDefinedList(UserDefinedSqlEntity userDefinedSqlEntity);

//    public List<LinkedHashMap<String, Object>> selectUserDefinedSqlTest(String defSql);

    public List<LinkedHashMap<String, Object>> selectUserDefinedSql(Map<String,Object> map);
}
