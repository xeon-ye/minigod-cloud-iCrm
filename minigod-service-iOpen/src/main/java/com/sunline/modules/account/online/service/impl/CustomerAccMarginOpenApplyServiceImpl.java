package com.sunline.modules.account.online.service.impl;

import com.google.common.collect.Maps;
import com.sunline.modules.account.online.dao.CustomerAccountMarginOpenApplyDao;
import com.sunline.modules.account.online.entity.CustomerAccountMarginOpenApplyEntity;
import com.sunline.modules.account.online.service.CustomerAccMarginOpenApplyService;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.utils.OrderUtil;
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


@Service("customerAccMarginOpenApplyService")
public class CustomerAccMarginOpenApplyServiceImpl implements CustomerAccMarginOpenApplyService {
    @Autowired
    private CustomerAccountMarginOpenApplyDao customerAccountOpenApplyDao;

    @Autowired
    UserService userService;

    @Override
    public CustomerAccountMarginOpenApplyEntity queryObject(String gid) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryObject(gid);
    }

    @Override
    public List<CustomerAccountMarginOpenApplyEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryList(map);
    }

    @Override
    public List<CustomerAccountMarginOpenApplyEntity> queryListByBean(CustomerAccountMarginOpenApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryTotal(map);
    }

    @Override
    public int save(CustomerAccountMarginOpenApplyEntity customerAccountOpenApplication) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        UserEntity supperUser = UserUtils.getManagerUser();

        // 检验预约流水号的唯一性
        String applicationId = OrderUtil.getOrderNoByAtomic(1);
        CustomerAccountMarginOpenApplyEntity customerAccoOpenApplyInfo = customerAccountOpenApplyDao.queryObjectByApplicationId(applicationId);
        while (null != customerAccoOpenApplyInfo) {
            applicationId = OrderUtil.getOrderNoByAtomic(1);
            customerAccoOpenApplyInfo = customerAccountOpenApplyDao.queryObjectByApplicationId(applicationId);
        }

        customerAccountOpenApplication.setCode(applicationId);
        customerAccountOpenApplication.setApplicationId(customerAccountOpenApplication.getCode());
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
    public int update(CustomerAccountMarginOpenApplyEntity customerAccountOpenApplication) {

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
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.deleteBatch(gids);
    }

    @Override
    public int updateByApplicationId(CustomerAccountMarginOpenApplyEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.updateByApplicationId(entity);
    }

    @Override
    public int updateBatchExpExcelStatus(String[] applicationIds) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);

        Map<String,Object> params = Maps.newHashMap();
        params.put("applicationIds",applicationIds);

        return customerAccountOpenApplyDao.updateBatchExpExcelStatus(params);
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
    public CustomerAccountMarginOpenApplyEntity queryObjectByApplicationId(String applicationId) {

        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.queryObjectByApplicationId(applicationId);
    }

    /**
     * 查询开户异常数据
     *
     * @param queryCondition
     * @return
     */
    @Override
    public List<CustomerAccountMarginOpenApplyEntity> qryAbnormalData(CustomerAccountMarginOpenApplyEntity queryCondition) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return customerAccountOpenApplyDao.qryAbnormalData(queryCondition);
    }

}
