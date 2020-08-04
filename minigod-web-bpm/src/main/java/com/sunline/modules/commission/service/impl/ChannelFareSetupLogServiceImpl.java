package com.sunline.modules.commission.service.impl;

import com.sunline.modules.commission.dao.ChannelFareSetupLogDao;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;

@Service("channelFareSetupLogService")
public class ChannelFareSetupLogServiceImpl implements ChannelFareSetupLogService {
	@Autowired
	private ChannelFareSetupLogDao channelFareSetupLogDao;
	
	@Override
	public ChannelFareSetupLogEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return channelFareSetupLogDao.queryObject(id);
	}
	
	@Override
	public List<ChannelFareSetupLogEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return channelFareSetupLogDao.queryList(map);
	}

    @Override
    public Page<ChannelFareSetupLogEntity> queryAcceptList(ChannelFareSetupLogEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        channelFareSetupLogDao.queryAcceptList(entity);
        return PageHelper.endPage();
    }

    @Override
    public List<ChannelFareSetupLogEntity> queryByParams(ChannelFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.queryByParams(entity);
    }

    @Override
    public ChannelFareSetupLogEntity queryByChannelId(ChannelFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.queryByChannelId(entity);
    }

    @Override
    public List<ChannelFareSetupLogEntity> queryListByBean(ChannelFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return channelFareSetupLogDao.queryTotal(map);
	}
	
	@Override
	public int save(ChannelFareSetupLogEntity channelFareSetupLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        channelFareSetupLog.setId(Utils.uuid());
		return channelFareSetupLogDao.save(channelFareSetupLog);
	}
	
	@Override
	public int update(ChannelFareSetupLogEntity channelFareSetupLog){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.update(channelFareSetupLog);
	}

    @Override
    public int updateStatus(ChannelFareSetupLogEntity channelFareSetupLog) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.updateStatus(channelFareSetupLog);
    }

    @Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.deleteBatch(ids);
	}

    @Override
    public int updateByBusId(ChannelFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.updateByBusId(entity);
    }

    @Override
    public int updateSyncStatus(ChannelFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.updateSyncStatus(entity);
    }

    @Override
    public int updateByChannelId(ChannelFareSetupLogEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelFareSetupLogDao.updateByChannelId(entity);
    }

}
