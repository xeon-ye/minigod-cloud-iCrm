package com.sunline.modules.account.online.service;

import com.sunline.modules.account.online.entity.CustomerAccountMarginOpenApplyEntity;

import java.util.List;
import java.util.Map;

/**
 * 账户增开
 *
 * @author Tim
 * @date 2020-8-5 16:20:00
 */
public interface CustomerAccMarginOpenApplyService {

    CustomerAccountMarginOpenApplyEntity queryObject(String gid);

    List<CustomerAccountMarginOpenApplyEntity> queryList(Map<String, Object> map);

    List<CustomerAccountMarginOpenApplyEntity> queryListByBean(CustomerAccountMarginOpenApplyEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(CustomerAccountMarginOpenApplyEntity customerAccountOpenApplication);

    int update(CustomerAccountMarginOpenApplyEntity customerAccountOpenApplication);

    int delete(String gid);

    int deleteBatch(String[] gids);
    
    CustomerAccountMarginOpenApplyEntity queryObjectByApplicationId(String applicationId);

    /**
     * 通过预约流水号更新开户申请信息
     * @param entity
     * @return
     */
    int updateByApplicationId(CustomerAccountMarginOpenApplyEntity entity);

    /**
     * 待确认中导出Excel后，更新导出状态
     */
    int updateBatchExpExcelStatus(String[] applicationIds);

    //加急处理任务
    int updateBatchByApplicationIds(String applicationIds);

    /**
     * 查询开户异常数据
     * @param queryCondition
     * @return
     */
    List<CustomerAccountMarginOpenApplyEntity> qryAbnormalData(CustomerAccountMarginOpenApplyEntity queryCondition);
}
