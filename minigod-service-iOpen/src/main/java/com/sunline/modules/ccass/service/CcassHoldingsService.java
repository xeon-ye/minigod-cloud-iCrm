package com.sunline.modules.ccass.service;

import com.sunline.modules.ccass.entity.CcassHoldingsEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-05-18 11:12:43
 */
public interface CcassHoldingsService {
	
	CcassHoldingsEntity queryObject(String stockCode);
	
	List<CcassHoldingsEntity> queryList(Map<String, Object> map);

    List<CcassHoldingsEntity> queryListByBean(CcassHoldingsEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(CcassHoldingsEntity ccassHoldings);
	
	int update(CcassHoldingsEntity ccassHoldings);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    /**
     * 获取CCASS参与者持仓信息
     * @param ccassHoldingsEntity
     * @param pageNum
     * @return
     */
    Page<CcassHoldingsEntity> findPage(CcassHoldingsEntity ccassHoldingsEntity, int pageNum);

    /**
     * CCASS参与者持仓信息导出列表
     * @param ccassHoldingsEntity
     * @return
     */
    List<CcassHoldingsEntity> findCcassHoldingsInfoExcelList(CcassHoldingsEntity ccassHoldingsEntity);
}
