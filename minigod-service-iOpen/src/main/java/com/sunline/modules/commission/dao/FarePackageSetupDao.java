package com.sunline.modules.commission.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.commission.entity.FarePackageSetupEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 柜台佣金套餐设置表
 *
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
@Mapper
public interface FarePackageSetupDao extends BaseDao<FarePackageSetupEntity> {
    /**
     * 获取渠道佣金套餐信息
     * @param entity
     * @return
     */
    List<FarePackageSetupEntity> getChannelFareInfo(FarePackageSetupEntity entity);

    /**
     * 查询单个套餐信息
     * @param entity
     * @return
     */
    FarePackageSetupEntity queryObjectByBean(FarePackageSetupEntity entity);
}
