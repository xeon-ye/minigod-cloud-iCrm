package com.sunline.modules.dbs.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.dbs.entity.SecItemaccountApplyEntity;

/**
 * 中银子账号配置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-03 11:22:55
 */
@Mapper
public interface SecItemaccountApplyDao extends BaseDao<SecItemaccountApplyEntity> {
	
}
