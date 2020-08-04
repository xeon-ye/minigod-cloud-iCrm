package com.sunline.modules.call.service;

import com.sunline.modules.call.entity.CallRecordEntity;
import com.sunline.modules.common.page.Page;

import java.util.List;
import java.util.Map;

/**
 * 通话记录表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-05 10:29:23
 */
public interface CallRecordService {

    Page<CallRecordEntity> findPage(CallRecordEntity entity, int pageNum);

	CallRecordEntity queryObject(Long id);
	
	List<CallRecordEntity> queryList(CallRecordEntity entity);

    List<CallRecordEntity> queryListByBean(CallRecordEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(CallRecordEntity callRecord);
	
	int update(CallRecordEntity callRecord);
	
	int delete(Long id);
	
	int deleteBatch(Long[] ids);

    /**
     * 取消关联 (根据ID将相关字段置空)
     * @param entity
     * @return
     */
	int cancelConnect(CallRecordEntity entity);
}
