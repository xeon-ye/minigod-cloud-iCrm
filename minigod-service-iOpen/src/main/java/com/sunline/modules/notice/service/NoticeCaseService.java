package com.sunline.modules.notice.service;

import com.sunline.modules.notice.entity.NoticeCaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */
public interface NoticeCaseService {
	
	NoticeCaseEntity queryObject(String noticeCaseId);

	NoticeCaseEntity queryByCode(String noticeCaseCode);

	List<NoticeCaseEntity> queryList(Map<String, Object> map);

    List<NoticeCaseEntity> queryListByBean(NoticeCaseEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(NoticeCaseEntity noticeCase);
	
	int update(NoticeCaseEntity noticeCase);
	
	int delete(String noticeCaseId);
	
	int deleteBatch(String[] noticeCaseIds);
}
