package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.MoneyRateInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 汇率信息表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-03 13:15:29
 */
@Mapper
public interface MoneyRateInfoDao extends BaseDao<MoneyRateInfoEntity> {

    MoneyRateInfoEntity queryObject(MoneyRateInfoEntity entity);
	
}
