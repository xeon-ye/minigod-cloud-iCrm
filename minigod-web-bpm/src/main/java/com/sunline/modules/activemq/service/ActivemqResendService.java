package com.sunline.modules.activemq.service;

import com.sunline.modules.activemq.entity.ActivemqResendEntity;

import java.util.List;
import java.util.Map;

/**
 * activemq消息推送失败列表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-08 09:12:37
 */
public interface ActivemqResendService {
	
	ActivemqResendEntity queryObject(Integer id);
	
	List<ActivemqResendEntity> queryList(Map<String, Object> map);

    List<ActivemqResendEntity> queryListByBean(ActivemqResendEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(ActivemqResendEntity activemqResend);
	
	int update(ActivemqResendEntity activemqResend);
	
	int delete(Integer id);
	
	int deleteBatch(Integer[] ids);
}
