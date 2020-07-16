package com.sunline.modules.group.dao;

import com.sunline.modules.group.entity.ClientGroupManagerEntity;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Mapper
public interface ClientGroupManagerDao extends BaseDao<ClientGroupManagerEntity> {

    /**
     *  分组编号查询
     * @param clientGroupManagerEntity
     * @return
     */
    int queryByGroupNo(ClientGroupManagerEntity clientGroupManagerEntity);
    /**
     * 分组名查询
     * @param clientGroupManagerEntity
     * @return
     */
    int queryByGroupName(ClientGroupManagerEntity clientGroupManagerEntity);
}
