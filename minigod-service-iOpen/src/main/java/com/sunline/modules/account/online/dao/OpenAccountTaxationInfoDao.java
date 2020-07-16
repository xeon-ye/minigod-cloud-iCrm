package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.OpenAccountTaxationInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 税务信息表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
@Mapper
public interface OpenAccountTaxationInfoDao extends BaseDao<OpenAccountTaxationInfoEntity> {

    /**
     * 按applicationId删除
     * @param applicationId
     * @return
     */
    int deleteByApplicationId(String applicationId);

}
