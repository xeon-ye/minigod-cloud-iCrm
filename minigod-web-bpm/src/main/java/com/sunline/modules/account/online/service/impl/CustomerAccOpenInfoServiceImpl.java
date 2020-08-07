package com.sunline.modules.account.online.service.impl;

import com.google.common.collect.Maps;
import com.sunline.modules.account.online.dao.CustomerAccountOpenInfoDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("customerAccountOpenInfoService")
public class CustomerAccOpenInfoServiceImpl implements CustomerAccOpenInfoService {
    @Autowired
    private CustomerAccountOpenInfoDao customerAccountOpenInfoDao;

    @Override
    public CustomerAccountOpenInfoEntity queryObject(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.queryObject(applicationId);
    }

    @Override
    public CustomerAccountOpenInfoEntity queryByApplicationId(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.queryByApplicationId(applicationId);
    }

    @Override
    public List<CustomerAccountOpenInfoEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.queryList(map);
    }

    @Override
    public List<CustomerAccountOpenInfoEntity> queryListByBean(CustomerAccountOpenInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.selectSelective(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.queryTotal(map);
    }

    @Override
    public int save(CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        customerAccountOpenInfo.setCreateTime(new Date());
        customerAccountOpenInfo.setUpdateTime(new Date());
        customerAccountOpenInfo.setRecordStatus(BpmCommonEnum.CommonRecordStatus.COMMON_RECORD_STATUS_ENABLE_VALUE);
        return customerAccountOpenInfoDao.save(customerAccountOpenInfo);
    }

    @Override
    public int update(CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        customerAccountOpenInfo.setUpdateTime(new Date());
        return customerAccountOpenInfoDao.update(customerAccountOpenInfo);
    }

    @Override
    public int updateNoProduct(CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.updateNoProduct(customerAccountOpenInfo);
    }

    @Override
    public int delete(String applicationId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.delete(applicationId);
    }

    @Override
    public int deleteBatch(String[] applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.deleteBatch(applicationIds);
    }

    @Override
    public List<CustomerAccountOpenInfoEntity> selectDistinctChannel() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.selectDistinctChannel();
    }

    @Override
    public int validateTradeAccount(CustomerAccountOpenInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.validateTradeAccount(entity);
    }

    @Override
    public List<CustomerAccountOpenInfoEntity> isExistedOpenAccByIdCard(CustomerAccountOpenInfoEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.isExistedOpenAccByIdCard(entity);
    }

    @Override
    public CustomerAccountOpenInfoEntity findByClientId(String clientId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.findByClientId(clientId);
    }

    @Override
    public List<CustomerAccountOpenInfoEntity> queryListByApplicationId(String[] applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        Map<String,Object> params = Maps.newHashMap();
        params.put("applicationIds",applicationIds);

        return customerAccountOpenInfoDao.queryListByApplicationId(params);
    }

    @Override
    public int setTradeAccount(CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.setTradeAccount(customerAccountOpenInfo);
    }

    @Override
    public int updateMarginInfo(CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        customerAccountOpenInfo.setUpdateTime(new Date());
        return customerAccountOpenInfoDao.updateMarginInfo(customerAccountOpenInfo);
    }

    @Override
    public CustomerAccountOpenInfoEntity queryByIdCardNumber(String idCardNumber) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenInfoDao.queryByIdCardNumber(idCardNumber);
    }
}
