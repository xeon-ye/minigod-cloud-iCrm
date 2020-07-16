package com.sunline.modules.fund.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 入金凭证表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:30
 */
@Mapper
public interface ClientFundDepositImageDao extends BaseDao<ClientFundDepositImageEntity> {
    List<ClientFundDepositImageEntity> queryByApplicationId(String applicationId);
}
