package com.sunline.modules.customer.service;

import com.sunline.modules.customer.entity.UserHqInfoEntity;

import java.util.List;

/**
 * 行情
 * 
 * @author lcs
 * @email 
 * @date 2018-11-14 16:47:30
 */
public interface UserHqInfoService {

    /**
     * 获取客户行情套餐
     */
    List<UserHqInfoEntity> getUserHqInfo(UserHqInfoEntity entity);
}
