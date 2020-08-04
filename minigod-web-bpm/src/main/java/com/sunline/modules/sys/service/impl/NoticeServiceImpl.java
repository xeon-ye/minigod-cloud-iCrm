package com.sunline.modules.sys.service.impl;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.sys.dao.NoticeDao;
import com.sunline.modules.sys.dao.NoticeUserDao;
import com.sunline.modules.sys.entity.NoticeEntity;
import com.sunline.modules.sys.entity.NoticeUserEntity;
import com.sunline.modules.sys.service.NoticeService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;

	@Autowired
    private NoticeUserDao noticeUserDao;
	
	@Override
	public NoticeEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        NoticeEntity noticeEntity = noticeDao.queryObject(id);
        //如果当前查阅人，是该通知的被通知人，那么就更改查阅状态为已阅
        if(noticeEntity !=null && UserUtils.getCurrentUserId().equals(noticeEntity.getUserId())){
            NoticeUserEntity noticeUserEntity = new NoticeUserEntity();
            noticeUserEntity.setUserId(noticeEntity.getUserId());
            noticeUserEntity.setNoticeId(noticeEntity.getId());
            noticeUserEntity.setStatus(Constant.YESNO.YES.getValue());
            noticeUserDao.updateByNoticeIdUserId(noticeUserEntity);
        }

        return noticeDao.queryObject(id);
	}
	
	@Override
	public List<NoticeEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeDao.queryList(map);
	}

    @Override
    public List<NoticeEntity> queryListByBean(NoticeEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeDao.queryTotal(map);
	}
	
	@Override
	public int save(NoticeEntity notice){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return noticeDao.save(notice);
	}

    @Override
    public int saveBatch(List<NoticeEntity> noticeList) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeDao.saveBatch(noticeList);
    }

    @Override
	public int update(NoticeEntity notice){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeDao.update(notice);
	}
	
	@Override
	public int delete(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeDao.delete(id);
	}
	
	@Override
	public int deleteBatch(String[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeDao.deleteBatch(ids);
	}

	@Override
	public Page<NoticeEntity> findPage(NoticeEntity noticeEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		PageHelper.startPage(pageNum, Constant.pageSize);
		//超级管理员可查看所有通知
		if(!Constant.SUPERR_USER.equals(UserUtils.getCurrentUserId())){
			noticeEntity.setUserId(UserUtils.getCurrentUserId());
		}
		noticeDao.queryListByBean(noticeEntity);
		return PageHelper.endPage();
	}

	@Override
	public Page<NoticeEntity> findMyNoticePage(NoticeEntity noticeEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		PageHelper.startPage(pageNum, Constant.pageSize);
		//超级管理员可查看所有通知
		if(!Constant.SUPERR_USER.equals(UserUtils.getCurrentUserId())){
			noticeEntity.setUserId(UserUtils.getCurrentUserId());
		}
		noticeDao.findMyNotice(noticeEntity);
		return PageHelper.endPage();
	}

	@Override
	public int MyNoticeCount() {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        NoticeEntity noticeEntity = new NoticeEntity();
        int count = 0;
		//超级管理员可查看所有通知
		if(!Constant.SUPERR_USER.equals(UserUtils.getCurrentUserId())){
            noticeEntity.setUserId(UserUtils.getCurrentUserId());
		}
        noticeEntity.setShowStatus(Constant.YESNO.NO.getValue());
        List<NoticeEntity> myNotice = noticeDao.findMyNotice(noticeEntity);
		if(myNotice != null){
		    count=myNotice.size();
        }
        return count;
	}

    @Override
    public int saveBatchUserNotice(List<NoticeUserEntity> noticeUserList) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return noticeUserDao.saveBatch(noticeUserList);
    }
}
