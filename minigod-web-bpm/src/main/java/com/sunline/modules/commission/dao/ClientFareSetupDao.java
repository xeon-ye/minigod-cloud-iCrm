package com.sunline.modules.commission.dao;

import com.sunline.modules.commission.entity.ClientFareSetupEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户佣金套餐设置表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-23 17:27:15
 */
@Mapper
public interface ClientFareSetupDao extends BaseDao<ClientFareSetupEntity> {
    /**
     * 获取客户设佣信息
     *
     * @param entity
     * @return
     */
    List<ClientFareSetupEntity> getClientFareSetupInfo(ClientFareSetupEntity entity);

    int updateByBusId(ClientFareSetupEntity clientFareSetup);

    /**
     * 查询是否 处于 审核中的记录
     * @param entity
     * @return
     */
    List<ClientFareSetupEntity> checkAuditStatus(ClientFareSetupEntity entity);
}
