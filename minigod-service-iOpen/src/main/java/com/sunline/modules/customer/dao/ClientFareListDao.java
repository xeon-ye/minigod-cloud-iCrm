package com.sunline.modules.customer.dao;

import com.sunline.modules.customer.entity.ClientFareListEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户费率设置表
 * 
 * @author lcs
 * @email 
 * @date 2018-05-10 16:47:30
 */
@Mapper
public interface ClientFareListDao extends BaseDao<ClientFareListEntity> {
    /**
     * 查询单个对象
     * @param clientFareListEntity
     * @return
     */
    ClientFareListEntity queryByBean(ClientFareListEntity clientFareListEntity);
	
}
