package com.sunline.modules.fund.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.DbsIccDepositConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * DBS入金参数配置
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-04 16:45:18
 */
public interface DbsIccDepositConfigService {

    DbsIccDepositConfigEntity queryObject(Long id);

    List<DbsIccDepositConfigEntity> queryList(Map<String, Object> map);

    List<DbsIccDepositConfigEntity> queryListByBean(DbsIccDepositConfigEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(DbsIccDepositConfigEntity dbsIccDepositConfig);

    int update(DbsIccDepositConfigEntity dbsIccDepositConfig);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    /**
     * 分页查询
     * @param entity
     * @param pageNum
     * @return
     */
    Page<DbsIccDepositConfigEntity> findPage(DbsIccDepositConfigEntity entity, int pageNum);
}
