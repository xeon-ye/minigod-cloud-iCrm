package com.sunline.modules.fund.service.impl;

import com.sunline.modules.fund.dao.ClientFundDepositImageDao;
import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;
import com.sunline.modules.fund.service.ClientFundDepositImageService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 入金凭证表
 *
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:30
 */

@Service("clientFundDepositImageService")
public class ClientFundDepositImageServiceImpl implements ClientFundDepositImageService {
    @Autowired
    private ClientFundDepositImageDao clientFundDepositImageDao;

    @Override
    public ClientFundDepositImageEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.queryObject(id);
    }

    @Override
    public List<ClientFundDepositImageEntity> queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        List<ClientFundDepositImageEntity> entities = clientFundDepositImageDao.queryByApplicationId(applicationId);
        if (null != entities && entities.size() > 0) {
            return entities;
        }
        return null;
    }

    @Override
    public List<ClientFundDepositImageEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.queryList(map);
    }

    @Override
    public List<ClientFundDepositImageEntity> queryListByBean(ClientFundDepositImageEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.queryTotal(map);
    }

    @Override
    public int save(ClientFundDepositImageEntity clientFundDepositImage) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        clientFundDepositImage.setId(Utils.uuid());
        return clientFundDepositImageDao.save(clientFundDepositImage);
    }

    @Override
    public int update(ClientFundDepositImageEntity clientFundDepositImage) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.update(clientFundDepositImage);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return clientFundDepositImageDao.deleteBatch(ids);
    }

}
