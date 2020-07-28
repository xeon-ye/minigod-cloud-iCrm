package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;
import com.sunline.modules.account.online.model.query.AccountOpenApplyAllotQuery;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 客户开户申请表
 *
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-03-20 16:45:27
 */
@Mapper
public interface CustomerAccountOpenApplyDao extends BaseDao<CustomerAccountOpenApplyEntity> {
    List<AccountOpenApplyDetailInfo> selectAccountOpenApplicationDetailInfo(AccountOpenApplyQuery accountOpenApplicationQuery);

    List<CustomerAccountOpenApplyEntity> selectSelective(CustomerAccountOpenApplyEntity queryCondition);

    List<AccountOpenApplyDetailInfo> selectUnProcessAccountOpenApplicationRecord(AccountOpenApplyAllotQuery queryCondition);

    int updateAssignDrafter(CustomerAccountOpenApplyEntity record);

    CustomerAccountOpenApplyEntity queryObjectByApplicationId(String applicationId);

    /**
     * 通过预约流水号更新开户申请信息
     *
     * @param entity
     * @return
     */
    int updateByApplicationId(CustomerAccountOpenApplyEntity entity);


    List<AccountOpenApplyDetailInfo> selectAccountOpenApplicationDetailInfoCheck(AccountOpenApplyQuery accountOpenApplicationQuery);

    /*
     * 通过流水号更新AssignDrafter
     */
    int updateAssignDrafterByApplicationId(CustomerAccountOpenApplyEntity record);

    //加急处理任务
    int updateBatchByApplicationIds(Map<String, Object> params);

    /**
     * 待确认中导出Excel后，更新导出状态
     */
    int updateBatchExpExcelStatus(Map<String, Object> params);

    /**
     * 查询开户退回记录
     *
     * @param accountOpenApplicationQuery
     * @return
     */
    List<AccountOpenApplyDetailInfo> selectAccountOpenBackDetailInfo(AccountOpenApplyQuery accountOpenApplicationQuery);

    /**
     * 查询开户异常数据
     * @param queryCondition
     * @return
     */
    List<CustomerAccountOpenApplyEntity> qryAbnormalData(CustomerAccountOpenApplyEntity queryCondition);

    List<AccountOpenApplyDetailInfo> selectAccOpenDetailInfoByApplicationIds(Map<String, Object> params);
}
