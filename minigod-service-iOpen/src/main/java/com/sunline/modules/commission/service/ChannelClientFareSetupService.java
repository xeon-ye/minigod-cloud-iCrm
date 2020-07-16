package com.sunline.modules.commission.service;

import com.sunline.modules.commission.entity.ChannelClientFareSetupEntity;

import java.util.List;
import java.util.Map;

/**
 * 渠道客户佣金套餐还原历史表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-28 15:51:06
 */
public interface ChannelClientFareSetupService {
	
	ChannelClientFareSetupEntity queryObject(Integer id);
	
	List<ChannelClientFareSetupEntity> queryList(Map<String, Object> map);

    List<ChannelClientFareSetupEntity> queryListByBean(ChannelClientFareSetupEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ChannelClientFareSetupEntity channelClientFareSetup);
	
	int update(ChannelClientFareSetupEntity channelClientFareSetup);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
