package com.sunline.modules.account.online.dao;

import com.sunline.modules.account.online.entity.OpenAccountPropertyTypeEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 财产种类表
 * 
 * @author lcs
 * @email 
 * @date 2018-09-28 14:10:22
 */
@Mapper
public interface OpenAccountPropertyTypeDao extends BaseDao<OpenAccountPropertyTypeEntity> {
   int saveBatch(List<OpenAccountPropertyTypeEntity> list);
   int deleteByApplicationId(String applicationId);
}
