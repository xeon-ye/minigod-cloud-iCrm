package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.OpenAccountOperatorLogEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户开户业务操作员日志表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-01 09:34:03
 */
@Mapper
public interface OpenAccountOperatorLogDao extends BaseDao<OpenAccountOperatorLogEntity> {
	
}
