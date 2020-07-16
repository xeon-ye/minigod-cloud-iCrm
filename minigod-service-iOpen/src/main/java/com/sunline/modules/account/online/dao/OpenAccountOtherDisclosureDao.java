package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.OpenAccountOtherDisclosureEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 其他信息披露表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
@Mapper
public interface OpenAccountOtherDisclosureDao extends BaseDao<OpenAccountOtherDisclosureEntity> {
    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
    int deleteByApplicationId(String applicationId);
}
