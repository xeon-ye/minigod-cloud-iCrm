package com.sunline.modules.activemq.service.impl;

import com.sunline.modules.activemq.dao.ActivemqResendDao;
import com.sunline.modules.activemq.entity.ActivemqResendEntity;
import com.sunline.modules.activemq.service.ActivemqResendService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;

/**
 * activemq消息推送失败列表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-07-08 09:12:37
 */

@Service("activemqResendService")
public class ActivemqResendServiceImpl implements ActivemqResendService {
	@Autowired
	private ActivemqResendDao activemqResendDao;
	
	@Override
	public ActivemqResendEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return activemqResendDao.queryObject(id);
	}
	
	@Override
	public List<ActivemqResendEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return activemqResendDao.queryList(map);
	}

    @Override
    public List<ActivemqResendEntity> queryListByBean(ActivemqResendEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return activemqResendDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return activemqResendDao.queryTotal(map);
	}
	
	@Override
	public int save(ActivemqResendEntity activemqResend){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return activemqResendDao.save(activemqResend);
	}
	
	@Override
	public int update(ActivemqResendEntity activemqResend){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return activemqResendDao.update(activemqResend);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return activemqResendDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return activemqResendDao.deleteBatch(ids);
	}
	
}
