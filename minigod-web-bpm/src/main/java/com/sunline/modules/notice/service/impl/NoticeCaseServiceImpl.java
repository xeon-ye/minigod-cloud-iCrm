package com.sunline.modules.notice.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.notice.dao.NoticeCaseDao;
import com.sunline.modules.notice.entity.NoticeCaseEntity;
import com.sunline.modules.notice.service.NoticeCaseService;

/**
 * 
 *
 * @author lcs
 * @email ${email}
 * @date 2018-12-11 10:28:38
 */

@Service("noticeCaseService")
public class NoticeCaseServiceImpl implements NoticeCaseService {
	@Autowired
	private NoticeCaseDao noticeCaseDao;
	
	@Override
	public NoticeCaseEntity queryObject(String noticeCaseId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeCaseDao.queryObject(noticeCaseId);
	}
	
	@Override
	public List<NoticeCaseEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeCaseDao.queryList(map);
	}

    @Override
    public List<NoticeCaseEntity> queryListByBean(NoticeCaseEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeCaseDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeCaseDao.queryTotal(map);
	}
	
	@Override
	public int save(NoticeCaseEntity noticeCase){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeCaseDao.save(noticeCase);
	}
	
	@Override
	public int update(NoticeCaseEntity noticeCase){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeCaseDao.update(noticeCase);
	}
	
	@Override
	public int delete(String noticeCaseId){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeCaseDao.delete(noticeCaseId);
	}
	
	@Override
	public int deleteBatch(String[] noticeCaseIds){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeCaseDao.deleteBatch(noticeCaseIds);
	}

    @Override
    public NoticeCaseEntity queryByCode(String noticeCaseCode) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeCaseDao.queryByCode(noticeCaseCode);
    }
}
