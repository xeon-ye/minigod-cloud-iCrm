package com.sunline.modules.market.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.market.entity.ClientMarketPackageInfoEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 行情套餐购买信息表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-05-13 11:07:10
 */
@Mapper
public interface ClientMarketPackageInfoDao extends BaseDao<ClientMarketPackageInfoEntity> {
    ClientMarketPackageInfoEntity queryByApplicationId(String applicationId);
}
