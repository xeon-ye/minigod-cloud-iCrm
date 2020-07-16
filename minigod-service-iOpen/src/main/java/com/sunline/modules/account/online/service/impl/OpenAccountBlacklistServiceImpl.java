package com.sunline.modules.account.online.service.impl;

import com.sunline.modules.account.online.service.*;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunline.modules.account.online.dao.OpenAccountBlacklistDao;
import com.sunline.modules.account.online.entity.OpenAccountBlacklistEntity;
import com.sunline.modules.common.utils.UserUtils;


/**
 * 黑名单信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-10-11 12:19:54
 */

@Service("openAccountBlacklistService")
public class OpenAccountBlacklistServiceImpl implements OpenAccountBlacklistService {

    private final static Logger logger = LoggerFactory.getLogger(OpenAccountBlacklistServiceImpl.class);

    @Autowired
    private OpenAccountBlacklistDao openAccountBlacklistDao;
    @Autowired
    private CustomerAccOpenApplyService customerAccOpenApplyService;
    @Autowired
    private CustomerAccOpenInfoService customerAccOpenInfoService;
    @Autowired
    private ActModelerService actModelerService;
    @Autowired
    private CustomerAccOpenService customerAccountOpenService;
    @Autowired
    private OpenAccountProcessLogService openAccountProcessLogService;

    @Override
    public OpenAccountBlacklistEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.queryObject(id);
    }

    @Override
    public List<OpenAccountBlacklistEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.queryList(map);
    }

    @Override
    public List<OpenAccountBlacklistEntity> queryListByBean(OpenAccountBlacklistEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.queryTotal(map);
    }

    @Override
    public int save(OpenAccountBlacklistEntity openAccountBlacklist) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        openAccountBlacklist.setCreateUser(UserUtils.getCurrentUserId());
        openAccountBlacklist.setCreateTime(new Date());
        openAccountBlacklist.setUpdateTime(new Date());
        return openAccountBlacklistDao.save(openAccountBlacklist);
    }

    @Override
    public int update(OpenAccountBlacklistEntity openAccountBlacklist) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.update(openAccountBlacklist);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.deleteBatch(ids);
    }

    @Override
    public OpenAccountBlacklistEntity isExistedBlacklist(OpenAccountBlacklistEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return openAccountBlacklistDao.isExistedBlacklist(entity);
    }

	@Override
	public int saveByCustomerAccountOpenInfo(OpenAccountBlacklistEntity openAccountBlacklist,
			com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity customerAccountOpenInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		openAccountBlacklist.setApplicationId(customerAccountOpenInfo.getApplicationId());
        openAccountBlacklist.setClientName(customerAccountOpenInfo.getClientName());
        openAccountBlacklist.setIdKind(customerAccountOpenInfo.getIdKind());
        openAccountBlacklist.setIdNo(customerAccountOpenInfo.getIdNo());
        openAccountBlacklist.setPhoneNumber(customerAccountOpenInfo.getPhoneNumber());
        openAccountBlacklist.setEmail(customerAccountOpenInfo.getEmail());
        openAccountBlacklist.setCreateUser(UserUtils.getCurrentUserId());
        openAccountBlacklist.setCreateTime(new Date());
        openAccountBlacklist.setUpdateTime(new Date());
        return openAccountBlacklistDao.save(openAccountBlacklist);
	}

}
