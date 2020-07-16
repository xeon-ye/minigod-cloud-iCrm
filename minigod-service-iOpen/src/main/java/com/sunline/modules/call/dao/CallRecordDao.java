package com.sunline.modules.call.dao;

import com.sunline.modules.call.entity.CallRecordEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 通话记录表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2019-03-05 10:29:23
 */
@Mapper
public interface CallRecordDao extends BaseDao<CallRecordEntity> {

    /**
     * 取消关联 (根据ID将相关字段置空)
     * @param entity
     * @return
     */
    int cancelConnect(CallRecordEntity entity);
}
