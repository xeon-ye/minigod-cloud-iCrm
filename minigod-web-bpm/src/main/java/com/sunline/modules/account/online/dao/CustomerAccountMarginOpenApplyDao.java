package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.CustomerAccountMarginOpenApplyEntity;
import com.sunline.modules.account.online.model.AccountOpenApplyDetailInfo;
import com.sunline.modules.account.online.model.AccountOpenApplyQuery;
import com.sunline.modules.account.online.model.query.AccountOpenApplyAllotQuery;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 账户增开
 *
 * @author Tim
 * @date 2020-8-5 16:30:00
 */
@Mapper
public interface CustomerAccountMarginOpenApplyDao extends BaseDao<CustomerAccountMarginOpenApplyEntity> {
    List<AccountOpenApplyDetailInfo> selectAccountOpenApplicationDetailInfo(AccountOpenApplyQuery accountOpenApplicationQuery);

    List<CustomerAccountMarginOpenApplyEntity> selectSelective(CustomerAccountMarginOpenApplyEntity queryCondition);

    List<AccountOpenApplyDetailInfo> selectUnProcessAccountOpenApplicationRecord(AccountOpenApplyAllotQuery queryCondition);

    int updateAssignDrafter(CustomerAccountMarginOpenApplyEntity record);

    CustomerAccountMarginOpenApplyEntity queryObjectByApplicationId(String applicationId);

    /**
     * 通过预约流水号更新开户申请信息
     *
     * @param entity
     * @return
     */
    int updateByApplicationId(CustomerAccountMarginOpenApplyEntity entity);


    List<AccountOpenApplyDetailInfo> selectAccountOpenApplicationDetailInfoCheck(AccountOpenApplyQuery accountOpenApplicationQuery);

    /*
     * 通过流水号更新AssignDrafter
     */
    int updateAssignDrafterByApplicationId(CustomerAccountMarginOpenApplyEntity record);

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
    List<CustomerAccountMarginOpenApplyEntity> qryAbnormalData(CustomerAccountMarginOpenApplyEntity queryCondition);

    List<AccountOpenApplyDetailInfo> selectAccOpenDetailInfoByApplicationIds(Map<String, Object> params);
}
