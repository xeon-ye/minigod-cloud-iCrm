package com.sunline.modules.fund.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;

import java.util.List;
import java.util.Map;

/**
 * DBS银行流水推送
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-02 16:21:13
 */
public interface DbsIccBankFlowService {

    DbsIccBankFlowEntity queryObject(Long id);

    List<DbsIccBankFlowEntity> queryList(Map<String, Object> map);

    List<DbsIccBankFlowEntity> queryListByBean(DbsIccBankFlowEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(DbsIccBankFlowEntity dbsIccBankFlow);

    int update(DbsIccBankFlowEntity dbsIccBankFlow);

    int delete(Long id);

    int deleteBatch(Long[] ids);

    Page<DbsIccBankFlowEntity> queryPage(DbsIccBankFlowEntity entity, int pageNum);

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafterById(DbsIccBankFlowEntity entity);
}
