package com.sunline.modules.fund.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.fund.entity.ClientFundWithdrawApplyEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户出金申请信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-04-01 16:23:18
 */
@Mapper
public interface ClientFundWithdrawApplyDao extends BaseDao<ClientFundWithdrawApplyEntity> {

    /**
     * 通过预约号查询
     *
     * @param applicationId
     * @return
     */
    ClientFundWithdrawApplyEntity queryByApplicationId(String applicationId);

    /**
     * 通过预约号更新
     *
     * @param clientFundWithdrawApplyEntity
     * @return
     */
    int updateByApplicationId(ClientFundWithdrawApplyEntity clientFundWithdrawApplyEntity);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(ClientFundWithdrawApplyEntity entity);

    /**
     * 查询审核列表
     *
     * @param entity
     * @return
     */
    List<ClientFundWithdrawApplyEntity> queryAuditList(ClientFundWithdrawApplyEntity entity);

    /**
     * 批量更新
     *
     * @param applicationIds
     * @return
     */
    int updateBatchByApplicationIds(String applicationIds);

    /**
     * 通过预约号批量查询
     *
     * @param applicationIds
     * @return
     */
    List<ClientFundWithdrawApplyEntity> queryByApplicationIds(String applicationIds);
}
