package com.sunline.modules.notice.service;

import com.sunline.modules.notice.entity.UserNoticeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */
public interface UserNoticeService {
	
	UserNoticeEntity queryObject(String userId);
	
	List<UserNoticeEntity> queryList(Map<String, Object> map);

    List<UserNoticeEntity> queryListByBean(UserNoticeEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(UserNoticeEntity userNotice);
	
	int update(UserNoticeEntity userNotice);
	
	int delete(String userId);

	int deleteByNoticeId(String noticeCaseId);

	int deleteBatch(String[] userIds);
}
