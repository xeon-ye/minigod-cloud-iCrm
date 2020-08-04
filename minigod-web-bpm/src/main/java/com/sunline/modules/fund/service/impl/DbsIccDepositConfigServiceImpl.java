package com.sunline.modules.fund.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.fund.dao.DbsIccDepositConfigDao;
import com.sunline.modules.fund.entity.DbsIccDepositConfigEntity;
import com.sunline.modules.fund.service.DbsIccDepositConfigService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * DBS入金参数配置
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-04 16:45:18
 */

@Service("dbsIccDepositConfigService")
public class DbsIccDepositConfigServiceImpl implements DbsIccDepositConfigService {
    @Autowired
    private DbsIccDepositConfigDao dbsIccDepositConfigDao;

    @Override
    public DbsIccDepositConfigEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.queryObject(id);
    }

    @Override
    public List<DbsIccDepositConfigEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.queryList(map);
    }

    @Override
    public List<DbsIccDepositConfigEntity> queryListByBean(DbsIccDepositConfigEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.queryTotal(map);
    }

    @Override
    public int save(DbsIccDepositConfigEntity dbsIccDepositConfig) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.save(dbsIccDepositConfig);
    }

    @Override
    public int update(DbsIccDepositConfigEntity dbsIccDepositConfig) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.update(dbsIccDepositConfig);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return dbsIccDepositConfigDao.deleteBatch(ids);
    }

    /**
     * 分页查询
     *
     * @param entity
     * @param pageNum
     * @return
     */
    @Override
    public Page<DbsIccDepositConfigEntity> findPage(DbsIccDepositConfigEntity entity, int pageNum) {
        PageHelper.startPage(pageNum, Constant.pageSize);
        dbsIccDepositConfigDao.queryList(entity);
        return PageHelper.endPage();
    }


}
