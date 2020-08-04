package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientFundDepositEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户账户存款记录表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 16:22:19
 */
@Mapper
public interface ClientFundDepositDao extends BaseDao<ClientFundDepositEntity> {

    /**
     * 客户出入金发送记录查询
     *
     * @param obj
     * @return
     */
    List<ClientFundDepositEntity> queryClientFundDepositSend(Object obj);

    /**
     * 客户首次入金发送记录查询
     *
     * @param obj
     * @return
     */
    List<ClientFundDepositEntity> queryClientFirstDepositSend(Object obj);

    /**
     * 客户累计入金额大于年收入or财产总额
     *
     * @param obj
     * @return
     */
    List<ClientFundDepositEntity> queryTotalIncAmountAbnormal(Object obj);

    /**
     * 获取客户首天累计入金金额
     *
     * @param entity
     * @return
     */
    List<ClientFundDepositEntity> queryFirstFundDepTotal(ClientFundDepositEntity entity);

    /**
     * 获取指定时间内客户出/入金金额
     *
     * @param entity
     * @return
     */
    List<ClientFundDepositEntity> queryFundDepTotal(ClientFundDepositEntity entity);

    /**
     * 获取客户新增资金
     * @param entity
     * @return
     */
    List<ClientFundDepositEntity> queryAddAsset(ClientFundDepositEntity entity);
}
