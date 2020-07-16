package com.sunline.modules.marker.service;


import com.sunline.modules.common.page.Page;
import com.sunline.modules.marker.entity.CompBusiPersonEntity;

import java.util.List;
import java.util.Map;

/**
 * 公司业务人员信息表
 * 
 * @author jim
 * @email 
 * @date 2018-04-27 17:19:01
 */
public interface CompBusiPersonService {
	
	CompBusiPersonEntity queryObject(Integer id);
	
	List<CompBusiPersonEntity> queryList(Map<String, Object> map);

    List<CompBusiPersonEntity> queryListByBean(CompBusiPersonEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(CompBusiPersonEntity companyBusinessPersonnel);
	
	int update(CompBusiPersonEntity companyBusinessPersonnel);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);

    Page<CompBusiPersonEntity> findPage(CompBusiPersonEntity compBusiPersonEntity, int pageNum);

    /**
     *  营销人员管理导出excel
     * @param compBusiPersonEntity
     * @return
     */
    List<CompBusiPersonEntity> comBusPerListExcelList (CompBusiPersonEntity compBusiPersonEntity);
}
