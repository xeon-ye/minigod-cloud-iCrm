package com.sunline.modules.customer.service.impl;

import com.sunline.modules.customer.dao.UserHqInfoDao;
import com.sunline.modules.customer.entity.UserHqInfoEntity;
import com.sunline.modules.customer.service.UserHqInfoService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行情
 *
 * @author lcs
 * @email
 * @date 2018-11-14 16:47:30
 */

@Service("UserHqInfoService")
public class UserHqInfoServiceImpl implements UserHqInfoService {
    @Autowired
    private UserHqInfoDao userHqInfoDao;

    @Override
    public List<UserHqInfoEntity> getUserHqInfo(UserHqInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return userHqInfoDao.getUserHqInfo(entity);
    }
}
