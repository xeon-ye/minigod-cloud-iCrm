package com.sunline.modules.commission.dao;

import com.sunline.modules.commission.entity.ClientFreeCommSetEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 客户免佣套餐设置表
 * 
 * @author Larry Lai
 * @email aljqiang@163.com
 * @date 2018-08-21 19:40:27
 */
@Mapper
public interface ClientFreeCommSetDao extends BaseDao<ClientFreeCommSetEntity> {

    /**
     * 获取符合免佣设置的客户列表
     * @param entity
     * @return
     */
    List<ClientFreeCommSetEntity> getIsFreeCommClientInfo(ClientFreeCommSetEntity entity);
}
