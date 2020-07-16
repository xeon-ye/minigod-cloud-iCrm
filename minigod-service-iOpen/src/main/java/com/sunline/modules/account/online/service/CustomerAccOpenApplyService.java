package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;

import java.util.List;
import java.util.Map;

/**
 * 客户开户申请表
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
public interface CustomerAccOpenApplyService {

    CustomerAccountOpenApplyEntity queryObject(String gid);

    List<CustomerAccountOpenApplyEntity> queryList(Map<String, Object> map);

    List<CustomerAccountOpenApplyEntity> queryListByBean(CustomerAccountOpenApplyEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(CustomerAccountOpenApplyEntity customerAccountOpenApplication);

    int update(CustomerAccountOpenApplyEntity customerAccountOpenApplication);

    int delete(String gid);

    int deleteBatch(String[] gids);
    
    CustomerAccountOpenApplyEntity queryObjectByApplicationId(String applicationId);

    /**
     * 通过预约流水号更新开户申请信息
     * @param entity
     * @return
     */
    int updateByApplicationId(CustomerAccountOpenApplyEntity entity);

    //加急处理任务
    int updateBatchByApplicationIds(String applicationIds);

    /**
     * 查询开户异常数据
     * @param queryCondition
     * @return
     */
    List<CustomerAccountOpenApplyEntity> qryAbnormalData(CustomerAccountOpenApplyEntity queryCondition);
}
