package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.OpenAccountCaVerityInfoEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * CA认证信息表
 * 
 * @author lcs
 * @date 2019-01-17 10:10:43
 */
@Mapper
public interface OpenAccountCaVerityInfoDao extends BaseDao<OpenAccountCaVerityInfoEntity> {

    /**
     * 查询最新的一条记录
     * @param entity
     * @return
     */
    OpenAccountCaVerityInfoEntity queryRecentByApplicationId(OpenAccountCaVerityInfoEntity entity);

}
