package com.sunline.modules.fund.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.fund.entity.DbsIccBankFlowEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * DBS银行流水推送
 *
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2020-03-02 16:21:13
 */
@Mapper
public interface DbsIccBankFlowDao extends BaseDao<DbsIccBankFlowEntity> {

    /**
     * 更新指定审核人
     *
     * @param entity
     * @return
     */
    int updateAssignDrafterById(DbsIccBankFlowEntity entity);
}
