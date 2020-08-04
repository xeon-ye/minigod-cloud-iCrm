package com.sunline.modules.customer.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.customer.entity.TmkCustomerEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 电销客户管理信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-23 10:17:43
 */
@Mapper
public interface TmkCustomerDao extends BaseDao<TmkCustomerEntity> {

}
