package com.sunline.modules.analysis.service;

import com.sunline.modules.analysis.entity.ClientFundDepositSendLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户出入金信息发送日志表
 * 
 * @author LiYangFeng
 * @email justbelyf@gmail.com
 * @date 2018-07-10 15:22:34
 */
public interface ClientFundDepositSendLogService {
	
	ClientFundDepositSendLogEntity queryObject(Integer id);
	
	List<ClientFundDepositSendLogEntity> queryList(Map<String, Object> map);

    List<ClientFundDepositSendLogEntity> queryListByBean(ClientFundDepositSendLogEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFundDepositSendLogEntity clientFundDepositSendLog);
	
	int update(ClientFundDepositSendLogEntity clientFundDepositSendLog);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
