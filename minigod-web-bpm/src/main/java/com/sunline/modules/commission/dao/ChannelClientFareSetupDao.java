package com.sunline.modules.commission.dao;

import com.sunline.modules.commission.entity.ChannelClientFareSetupEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道客户佣金套餐还原历史表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-28 15:51:06
 */
@Mapper
public interface ChannelClientFareSetupDao extends BaseDao<ChannelClientFareSetupEntity> {
	
}
