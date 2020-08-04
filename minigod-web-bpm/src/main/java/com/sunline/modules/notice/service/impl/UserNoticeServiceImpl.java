package com.sunline.modules.notice.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.notice.dao.UserNoticeDao;
import com.sunline.modules.notice.entity.UserNoticeEntity;
import com.sunline.modules.notice.service.UserNoticeService;

/**
 * 
 *
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */

@Service("userNoticeService")
public class UserNoticeServiceImpl implements UserNoticeService {
	@Autowired
	private UserNoticeDao userNoticeDao;
	
	@Override
	public UserNoticeEntity queryObject(String userId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userNoticeDao.queryObject(userId);
	}
	
	@Override
	public List<UserNoticeEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userNoticeDao.queryList(map);
	}

    @Override
    public List<UserNoticeEntity> queryListByBean(UserNoticeEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userNoticeDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userNoticeDao.queryTotal(map);
	}
	
	@Override
	public int save(UserNoticeEntity userNotice){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return userNoticeDao.save(userNotice);
	}
	
	@Override
	public int update(UserNoticeEntity userNotice){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userNoticeDao.update(userNotice);
	}
	
	@Override
	public int delete(String userId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userNoticeDao.delete(userId);
	}
	
	@Override
	public int deleteBatch(String[] userIds){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userNoticeDao.deleteBatch(userIds);
	}

    @Override
    public int deleteByNoticeId(String noticeCaseId) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return userNoticeDao.deleteByNoticeId(noticeCaseId);
    }
}
