package com.sunline.modules.analysis.dao;

import com.sunline.modules.analysis.entity.ClientFundDepositSendLogEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 客户出入金信息发送日志表
 * 
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-07-10 15:22:34
 */
@Mapper
public interface ClientFundDepositSendLogDao extends BaseDao<ClientFundDepositSendLogEntity> {
	
}
