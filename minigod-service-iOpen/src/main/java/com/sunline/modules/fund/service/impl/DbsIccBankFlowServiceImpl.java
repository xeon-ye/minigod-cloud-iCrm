package com.sunline.modules.fund.service.impl;

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
import com.sunline.modules.fund.dao.DbsIccBankFlowDao;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import com.sunline.modules.fund.service.DbsIccBankFlowService;

/**
 * DBS银行流水推送
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-02 16:21:13
 */

@Service("dbsIccBankFlowService")
public class DbsIccBankFlowServiceImpl implements DbsIccBankFlowService {
	@Autowired
	private DbsIccBankFlowDao dbsIccBankFlowDao;
	
	@Override
	public DbsIccBankFlowEntity queryObject(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsIccBankFlowDao.queryObject(id);
	}
	
	@Override
	public List<DbsIccBankFlowEntity> queryList(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsIccBankFlowDao.queryList(map);
	}

    @Override
    public List<DbsIccBankFlowEntity> queryListByBean(DbsIccBankFlowEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccBankFlowDao.queryListByBean(entity);
    }
	
	@Override
	public int queryTotal(Map<String, Object> map){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
		return dbsIccBankFlowDao.queryTotal(map);
	}
	
	@Override
	public int save(DbsIccBankFlowEntity dbsIccBankFlow){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        dbsIccBankFlow.setId(Utils.uuid());
		return dbsIccBankFlowDao.save(dbsIccBankFlow);
	}
	
	@Override
	public int update(DbsIccBankFlowEntity dbsIccBankFlow){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccBankFlowDao.update(dbsIccBankFlow);
	}
	
	@Override
	public int delete(Long id){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccBankFlowDao.delete(id);
	}
	
	@Override
	public int deleteBatch(Long[] ids){
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccBankFlowDao.deleteBatch(ids);
	}

    @Override
    public Page<DbsIccBankFlowEntity> queryPage(DbsIccBankFlowEntity entity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        PageHelper.startPage(pageNum, Constant.pageSize);
        dbsIccBankFlowDao.queryList(entity);
        return PageHelper.endPage();
    }

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    @Override
    public int updateAssignDrafterById(DbsIccBankFlowEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccBankFlowDao.updateAssignDrafterById(entity);
    }


}
