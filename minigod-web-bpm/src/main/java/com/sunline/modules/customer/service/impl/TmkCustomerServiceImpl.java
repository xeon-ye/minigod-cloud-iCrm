package com.sunline.modules.customer.service.impl;

import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.customer.dao.TmkCustomerDao;
import com.sunline.modules.customer.entity.TmkCustomerEntity;
import com.sunline.modules.customer.service.TmkCustomerService;
import com.sunline.mutidatasource.DataSourceContextHolder;
import com.sunline.mutidatasource.constant.DataSourceEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 电销客户管理信息表
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-11-23 10:17:43
 */

@Service("tmkCustomerServiceImpl.java")
public class TmkCustomerServiceImpl implements TmkCustomerService {
    @Autowired
    private TmkCustomerDao tmkCustomerDao;

    @Override
    public TmkCustomerEntity queryObject(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return tmkCustomerDao.queryObject(id);
    }

    @Override
    public List<TmkCustomerEntity> queryList(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return tmkCustomerDao.queryList(map);
    }

    @Override
    public List<TmkCustomerEntity> queryListByBean(TmkCustomerEntity entity) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return tmkCustomerDao.queryListByBean(entity);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        return tmkCustomerDao.queryTotal(map);
    }

    @Override
    public int save(TmkCustomerEntity telemarketingCustomerManageInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
//        telemarketingCustomerManageInfo.setId(Utils.uuid());
        return tmkCustomerDao.save(telemarketingCustomerManageInfo);
    }

    @Override
    public int update(TmkCustomerEntity telemarketingCustomerManageInfo) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return tmkCustomerDao.update(telemarketingCustomerManageInfo);
    }

    @Override
    public int delete(Long id) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return tmkCustomerDao.delete(id);
    }

    @Override
    public int deleteBatch(Long[] ids) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_MASTER);
        return tmkCustomerDao.deleteBatch(ids);
    }

    @Override
    public Page<TmkCustomerEntity> findPage(TmkCustomerEntity tmkCustomerEntity, int pageNum) {
        DataSourceContextHolder.setDataSourceType(DataSourceEnum.DATA_SOURCE_SALVE);
        PageHelper.startPage(pageNum, Constant.pageSize);
        tmkCustomerDao.queryList(tmkCustomerEntity);
        return PageHelper.endPage();
    }

}
