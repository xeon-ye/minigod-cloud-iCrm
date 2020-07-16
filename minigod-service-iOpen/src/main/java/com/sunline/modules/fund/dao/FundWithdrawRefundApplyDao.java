package com.sunline.modules.fund.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.fund.entity.FundWithdrawRefundApplyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户出金退款申请表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-05-23 13:23:38
 */
@Mapper
public interface FundWithdrawRefundApplyDao extends BaseDao<FundWithdrawRefundApplyEntity> {

    /**
     * 通过预约号查询
     *
     * @param applicationId
     * @return
     */
    FundWithdrawRefundApplyEntity queryByApplicationId(String applicationId);

    int updateByApplicationId(FundWithdrawRefundApplyEntity fundWithdrawRefundApplyEntity);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(FundWithdrawRefundApplyEntity entity);

    /**
     * 查询审核列表
     *
     * @param entity
     * @return
     */
    List<FundWithdrawRefundApplyEntity> queryAuditList(FundWithdrawRefundApplyEntity entity);

}
