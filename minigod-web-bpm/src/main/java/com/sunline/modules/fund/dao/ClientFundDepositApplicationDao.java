package com.sunline.modules.fund.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.fund.entity.ClientFundDepositApplicationEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 客户入金申请信息表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:31
 */
@Mapper
public interface ClientFundDepositApplicationDao extends BaseDao<ClientFundDepositApplicationEntity> {
    /**
     *根据流水号查询申请记录
     * @param applicationid
     */
    ClientFundDepositApplicationEntity queryByApplicationId(String applicationid);
    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafter(ClientFundDepositApplicationEntity entity);

    /**
     * 查询申请记录列表
     * */
    List<ClientFundDepositApplicationEntity> queryInfoList(Object entity);

    /**
     * 查询审核列表
     * 审核列表的排序等与其他审批页面不同，故单独列出
     * */
    List<ClientFundDepositApplicationEntity> queryBankCheckList(Object entity);

    /**
     * 查询申请数量
     * */
    int myFundDepositCount(ClientFundDepositApplicationEntity entity);

    /**
     * 加急处理任务
     */
    int updateBatchByApplicationIds(String[] applicationIds);

}
