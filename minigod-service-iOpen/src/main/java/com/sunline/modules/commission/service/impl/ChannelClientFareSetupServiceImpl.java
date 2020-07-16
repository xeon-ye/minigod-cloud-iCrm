package com.sunline.modules.commission.service.impl;

import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.commission.dao.ChannelClientFareSetupDao;
import com.sunline.modules.commission.entity.ChannelClientFareSetupEntity;
import com.sunline.modules.commission.service.ChannelClientFareSetupService;

/**
 * 渠道客户佣金套餐还原历史表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-28 15:51:06
 */

@Service("channelClientFareSetupService")
public class ChannelClientFareSetupServiceImpl implements ChannelClientFareSetupService {
	@Autowired
	private ChannelClientFareSetupDao channelClientFareSetupDao;
	
	@Override
	public ChannelClientFareSetupEntity queryObject(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return channelClientFareSetupDao.queryObject(id);
	}
	
	@Override
	public List<ChannelClientFareSetupEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return channelClientFareSetupDao.queryList(map);
	}

    @Override
    public List<ChannelClientFareSetupEntity> queryListByBean(ChannelClientFareSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelClientFareSetupDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return channelClientFareSetupDao.queryTotal(map);
	}
	
	@Override
	public int save(ChannelClientFareSetupEntity channelClientFareSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        channelClientFareSetup.setId(Utils.uuid());
		return channelClientFareSetupDao.save(channelClientFareSetup);
	}
	
	@Override
	public int update(ChannelClientFareSetupEntity channelClientFareSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelClientFareSetupDao.update(channelClientFareSetup);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelClientFareSetupDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return channelClientFareSetupDao.deleteBatch(ids);
	}
	
}
