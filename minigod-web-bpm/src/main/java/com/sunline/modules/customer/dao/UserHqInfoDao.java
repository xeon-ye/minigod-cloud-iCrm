package com.sunline.modules.customer.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.customer.entity.UserHqInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行情
 * 
 * @author lcs
 * @email 
 * @date 2018-11-14 16:47:30
 */
@Mapper
public interface UserHqInfoDao extends BaseDao<UserHqInfoEntity> {

    /**
     * 获取客户行情套餐
     */
    List<UserHqInfoEntity> getUserHqInfo(UserHqInfoEntity entity);
	
}
