package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClientFundDepositEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;

/**
 * 客户出入金查询
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-04 16:22:19
 */
public interface ClientFundDepositService {

    /**
     * 客户出入金查询
     *
     * @param clientFundDepositEntity
     * @param pageNum
     * @return
     */
    Page<ClientFundDepositEntity> findPage(ClientFundDepositEntity clientFundDepositEntity, int pageNum);

    /**
     * 客户出入金查询导出excel数据
     *
     * @param clientFundDepositEntity
     * @return
     */
    List<ClientFundDepositEntity> findClientFundDepExcelList(ClientFundDepositEntity clientFundDepositEntity);

    /**
     * 客户出入金发送记录查询
     *
     * @param clientFundDepositEntity
     * @return
     */
    List<ClientFundDepositEntity> queryClientFundDepositSend(ClientFundDepositEntity clientFundDepositEntity);

    /**
     * 客户首次入金发送记录查询
     * @param clientFundDepositEntity
     * @return
     */
    List<ClientFundDepositEntity> queryClientFirstDepositSend(ClientFundDepositEntity clientFundDepositEntity);

    /**
     * 客户累计入金额大于年收入or财产总额
     * @param clientFundDepositEntity
     * @return
     */
    List<ClientFundDepositEntity> queryTotalIncAmountAbnormal(ClientFundDepositEntity clientFundDepositEntity);

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
