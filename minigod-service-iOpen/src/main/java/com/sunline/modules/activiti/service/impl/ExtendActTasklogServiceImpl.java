package com.sunline.modules.activiti.service.impl;

import com.sunline.modules.activiti.dao.ExtendActTasklogDao;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ExtendActTasklogService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("extendActTasklogService")
public class ExtendActTasklogServiceImpl implements ExtendActTasklogService {
    @Autowired
    private ExtendActTasklogDao extendActTasklogDao;

    @Override
    public ExtendActTasklogEntity queryObject(String id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.queryObject(id);
    }

    @Override
    public List<ExtendActTasklogEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.queryTotal(map);
    }

    @Override
    public void save(ExtendActTasklogEntity extendActTasklog) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        extendActTasklogDao.save(extendActTasklog);
    }

    @Override
    public void update(ExtendActTasklogEntity extendActTasklog) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        extendActTasklogDao.update(extendActTasklog);
    }

    @Override
    public void delete(String id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        extendActTasklogDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        extendActTasklogDao.deleteBatch(ids);
    }

    @Override
    public int updateByTaskId(ExtendActTasklogEntity extendActTasklogEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.updateByTaskId(extendActTasklogEntity);
    }

    @Override
    public int updateByTaskIdOpinion(ExtendActTasklogEntity extendActTasklogEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.updateByTaskIdOpinion(extendActTasklogEntity);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ExtendActTasklogEntity> queryListProcessLog(ExtendActTasklogEntity extendActTasklogEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.queryListProcessLog(extendActTasklogEntity);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ExtendActTasklogEntity> queryListProcessLogHis(ExtendActTasklogEntity extendActTasklogEntity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.queryListProcessLogHis(extendActTasklogEntity);
    }

    /**
     * 获取客户开户申请审核信息
     *
     * @param value
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ExtendActTasklogEntity> getOpenAccountAuditInfo(Object value) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return extendActTasklogDao.getOpenAccountAuditInfo(value);
    }
}
