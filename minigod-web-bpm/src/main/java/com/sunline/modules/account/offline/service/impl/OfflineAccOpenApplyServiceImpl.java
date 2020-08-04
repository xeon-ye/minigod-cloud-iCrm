package com.sunline.modules.account.offline.service.impl;

import com.google.common.collect.Maps;
import com.sunline.modules.account.offline.service.OfflineAccOpenApplyService;
import com.sunline.modules.account.online.dao.CustomerAccountOpenApplyDao;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.UserService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("offlineAccOpenApplyService")
public class OfflineAccOpenApplyServiceImpl implements OfflineAccOpenApplyService {
    @Autowired
    private CustomerAccountOpenApplyDao customerAccountOpenApplyDao;

    @Autowired
    UserService userService;

    @Override
    public CustomerAccountOpenApplyEntity queryObject(String gid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryObject(gid);
    }

    @Override
    public List<CustomerAccountOpenApplyEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryList(map);
    }

    @Override
    public List<CustomerAccountOpenApplyEntity> queryListByBean(CustomerAccountOpenApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryTotal(map);
    }

    @Override
    public int save(CustomerAccountOpenApplyEntity customerAccountOpenApplication) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        UserEntity supperUser = UserUtils.getManagerUser();

        customerAccountOpenApplication.setCode(customerAccountOpenApplication.getApplicationId());
//        customerAccountOpenApplication.setCreateId(supperUser.getId());
        customerAccountOpenApplication.setCreateUser(supperUser.getId());
        customerAccountOpenApplication.setCreateTime(new Date());
        customerAccountOpenApplication.setUpdateTime(new Date());
        customerAccountOpenApplication.setStatus(Constant.ActStauts.DRAFT.getValue());
        customerAccountOpenApplication.setBapid(supperUser.getBapid());
        customerAccountOpenApplication.setBaid(supperUser.getBaid());
        customerAccountOpenApplication.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_INITIAL_AUDIT_VALUE);
//        customerAccountOpenApplication.setFlowPath("提交");
        return customerAccountOpenApplyDao.save(customerAccountOpenApplication);
    }

    @Override
    public int update(CustomerAccountOpenApplyEntity customerAccountOpenApplication) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        customerAccountOpenApplication.setUpdateTime(new Date());
//        customerAccountOpenApplication.setLastApprovalUser(UserUtils.getCurrentUserId());
        return customerAccountOpenApplyDao.update(customerAccountOpenApplication);
    }

    @Override
    public int delete(String gid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.delete(gid);
    }

    @Override
    public int deleteBatch(String[] gids) {
        return customerAccountOpenApplyDao.deleteBatch(gids);
    }

    @Override
    public int updateByApplicationId(CustomerAccountOpenApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.updateByApplicationId(entity);
    }

    @Override
    public int updateBatchByApplicationIds(String applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        String[] applicationIdArray=applicationIds.split(",");

        Map<String,Object> params = Maps.newHashMap();
        params.put("applicationIds",applicationIdArray);

        return customerAccountOpenApplyDao.updateBatchByApplicationIds(params);
    }

    @Override
    public CustomerAccountOpenApplyEntity queryObjectByApplicationId(String applicationId) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryObjectByApplicationId(applicationId);
    }

}
