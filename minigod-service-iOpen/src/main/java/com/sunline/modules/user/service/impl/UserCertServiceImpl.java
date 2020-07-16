package com.sunline.modules.user.service.impl;

import com.sunline.modules.user.dao.UserCertDao;
import com.sunline.modules.user.entity.UserCertEntity;
import com.sunline.modules.user.service.UserCertService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户登录凭证表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-22 13:26:40
 */

@Service("userCertService")
public class UserCertServiceImpl implements UserCertService {
    @Autowired
    private UserCertDao userCertDao;

    @Override
    public UserCertEntity queryObject(UserCertEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.queryObject(entity);
    }

    @Override
    public List<UserCertEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.queryList(map);
    }

    @Override
    public List<UserCertEntity> queryListByBean(UserCertEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.queryTotal(map);
    }

    @Override
    public int save(UserCertEntity userCert) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        userCert.setCertId(Utils.uuid());
        return userCertDao.save(userCert);
    }

    @Override
    public int update(UserCertEntity userCert) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.update(userCert);
    }

    @Override
    public int delete(Integer certId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.delete(certId);
    }

    @Override
    public int deleteBatch(Integer[] certIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userCertDao.deleteBatch(certIds);
    }

}
