package com.sunline.modules.sys.service;


import com.sunline.modules.common.page.Page;
import com.sunline.modules.sys.entity.NoticeEntity;
import com.sunline.modules.sys.entity.NoticeUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 通知
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-08-31 15:59:09
 */
public interface NoticeService {
	
	NoticeEntity queryObject(String id);
	
	List<NoticeEntity> queryList(Map<String, Object> map);

    List<NoticeEntity> queryListByBean(NoticeEntity entity);
	
	int queryTotal(Map<String, Object> map);
	
	int save(NoticeEntity notice);

	int saveBatch(List<NoticeEntity> noticeList);
	
	int update(NoticeEntity notice);
	
	int delete(String id);
	
	int deleteBatch(String[] ids);

	/**
	 * 分页列表
	 * @param noticeEntity
	 * @param pageNum
	 * @return
	 */
	Page<NoticeEntity> findPage(NoticeEntity noticeEntity, int pageNum);

	/**
	 * 我的通知分页列表
	 * @param noticeEntity
	 * @param pageNum
	 * @return
	 */
	Page<NoticeEntity> findMyNoticePage(NoticeEntity noticeEntity, int pageNum);

	/**
	 * 我的通知条数
	 * @return
	 */
	int MyNoticeCount();


    /**
     * 批量新增用户通知关联表
     * @param noticeUserList
     * @return
     */
    int saveBatchUserNotice(List<NoticeUserEntity> noticeUserList);
}
