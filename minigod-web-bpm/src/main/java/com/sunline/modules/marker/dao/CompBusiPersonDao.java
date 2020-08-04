package com.sunline.modules.marker.dao;

import com.sunline.modules.marker.entity.CompBusiPersonEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公司业务人员信息表
 * 
 * @author jim
 * @email 
 * @date 2018-04-27 17:19:01
 */
@Mapper
public interface CompBusiPersonDao extends BaseDao<CompBusiPersonEntity> {
    /**
     * 邀请码查询用户  邀请码是否重复
     * @param aeCode
     * @return
     */
	int getObjectByAeCode(String aeCode);
}
