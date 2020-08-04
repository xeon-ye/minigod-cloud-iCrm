package com.sunline.modules.commission.dao;

import com.sunline.modules.commission.entity.ClientFreeCommInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户免佣套餐信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:55:32
 */
@Mapper
public interface ClientFreeCommInfoDao extends BaseDao<ClientFreeCommInfoEntity> {
	
}
