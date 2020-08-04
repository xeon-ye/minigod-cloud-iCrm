package com.sunline.modules.commission.service.impl;

import com.sunline.modules.commission.dao.FarePackageSetupDao;
import com.sunline.modules.commission.entity.FarePackageSetupEntity;
import com.sunline.modules.commission.service.FarePackageSetupService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 *  * @author lcs
 * @email
 * @date 2018-08-20 13:17:13
 */

@Service("farePackageSetupService")
public class FarePackageSetupServiceImpl implements FarePackageSetupService {
	@Autowired
	private FarePackageSetupDao farePackageSetupDao;
	
	@Override
	public FarePackageSetupEntity queryObject(String id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return farePackageSetupDao.queryObject(id);
	}

    @Override
    public FarePackageSetupEntity queryObject(FarePackageSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return farePackageSetupDao.queryObjectByBean(entity);
    }

    @Override
	public List<FarePackageSetupEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return farePackageSetupDao.queryList(map);
	}

    @Override
    public List<FarePackageSetupEntity> queryListByBean(FarePackageSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return farePackageSetupDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return farePackageSetupDao.queryTotal(map);
	}
	
	@Override
	public int save(FarePackageSetupEntity farePackageSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        farePackageSetup.setId(Utils.uuid());
		return farePackageSetupDao.save(farePackageSetup);
	}
	
	@Override
	public int update(FarePackageSetupEntity farePackageSetup){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return farePackageSetupDao.update(farePackageSetup);
	}
	
	@Override
	public int delete(Integer id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return farePackageSetupDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Integer[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return farePackageSetupDao.deleteBatch(ids);
	}

    @Override
    public List<FarePackageSetupEntity> getChannelFareInfo(FarePackageSetupEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return farePackageSetupDao.getChannelFareInfo(entity);
    }

}
