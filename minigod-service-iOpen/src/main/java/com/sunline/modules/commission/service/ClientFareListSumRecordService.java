package com.sunline.modules.commission.service;


import com.sunline.modules.commission.entity.ClientFareListSumRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户费率设置汇总表
 *
 * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */
public interface ClientFareListSumRecordService {
	
	ClientFareListSumRecordEntity queryObject(Integer id);
	
	List<ClientFareListSumRecordEntity> queryList(Map<String, Object> map);

    List<ClientFareListSumRecordEntity> queryListByBean(ClientFareListSumRecordEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFareListSumRecordEntity clientFareListSumRecord);
	
	int update(ClientFareListSumRecordEntity clientFareListSumRecord);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
