package com.sunline.modules.customer.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.customer.entity.ClientFareListEntity;

import java.util.List;
import java.util.Map;

/**
 * 客户费率设置表
 * 
 * @author lcs
 * @email 
 * @date 2018-05-10 16:47:30
 */
public interface ClientFareListService {
	
	ClientFareListEntity queryObject(Integer id);
	
	List<ClientFareListEntity> queryList(Map<String, Object> map);

    List<ClientFareListEntity> queryListByBean(ClientFareListEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ClientFareListEntity clientFareList);
	
	int update(ClientFareListEntity clientFareList);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    /**
     * 分页列表
     * @param clientFareList
     * @param pageNum
     * @return
     */
    Page<ClientFareListEntity> findPage(ClientFareListEntity clientFareList, int pageNum);

    /**
     *  客户佣金套餐excle导出
     * @param clientFareListEntity
     * @return
     */
    List<ClientFareListEntity> fareListExcelList(ClientFareListEntity  clientFareListEntity);

    /**
     * 查询单个对象
     * @param clientFareListEntity
     * @return
     */
    ClientFareListEntity queryByBean(ClientFareListEntity  clientFareListEntity);
}
