package com.sunline.modules.commission.service;


import com.sunline.modules.commission.entity.FarePackageSetupEntity;

import java.util.List;
import java.util.Map;

/**
 * 柜台佣金套餐设置表
 * 
 ** @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
public interface FarePackageSetupService {
	
	FarePackageSetupEntity queryObject(String fareKind);

    /**
     * 查询单个套餐信息
     * @param entity
     * @return
     */
	FarePackageSetupEntity queryObject(FarePackageSetupEntity entity);

	List<FarePackageSetupEntity> queryList(Map<String, Object> map);

    List<FarePackageSetupEntity> queryListByBean(FarePackageSetupEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(FarePackageSetupEntity farePackageSetup);
	
	int update(FarePackageSetupEntity farePackageSetup);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    /**
     * 获取渠道佣金套餐信息
     * @param entity
     * @return
     */
    List<FarePackageSetupEntity> getChannelFareInfo(FarePackageSetupEntity entity);
}
