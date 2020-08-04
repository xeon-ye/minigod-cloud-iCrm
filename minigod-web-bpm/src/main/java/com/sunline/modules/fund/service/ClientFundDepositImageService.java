package com.sunline.modules.fund.service;


import com.sunline.modules.fund.entity.ClientFundDepositImageEntity;

import java.util.List;
import java.util.Map;

/**
 * 入金凭证表
 * 
 * @author lidh
 * @email jim@zszhizhu.com
 * @date 2019-06-01 14:52:30
 */
public interface ClientFundDepositImageService {
	
	ClientFundDepositImageEntity queryObject(Long id);

    List<ClientFundDepositImageEntity> queryByApplicationId(String applicationId);

	List<ClientFundDepositImageEntity> queryList(Map<String, Object> map);

    List<ClientFundDepositImageEntity> queryListByBean(ClientFundDepositImageEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFundDepositImageEntity clientFundDepositImage);
	
	int update(ClientFundDepositImageEntity clientFundDepositImage);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);
}
