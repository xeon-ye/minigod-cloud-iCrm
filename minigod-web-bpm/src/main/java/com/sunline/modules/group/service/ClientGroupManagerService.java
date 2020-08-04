package com.sunline.modules.group.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.group.entity.ClientGroupManagerEntity;

import java.util.List;
import java.util.Map;

/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
public interface ClientGroupManagerService {

    ClientGroupManagerEntity queryObject(Integer id);

    List<ClientGroupManagerEntity> queryList(Map<String, Object> map);

    List<ClientGroupManagerEntity> queryListByBean(ClientGroupManagerEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(ClientGroupManagerEntity clientGroupManager);

    int update(ClientGroupManagerEntity clientGroupManager);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    /**
     * 分页查询
     * @param clientGroupManagerEntity
     * @param pageNum
     * @return
     */
    Page<ClientGroupManagerEntity> findPage(ClientGroupManagerEntity clientGroupManagerEntity, int pageNum);

    /**
     * 分组编号查询
     * @param clientGroupManagerEntity
     * @return
     */
    int queryByGroupNo(ClientGroupManagerEntity clientGroupManagerEntity);

    /**
     * 分组名称查询
     * @param clientGroupManagerEntity
     * @return
     */
    int queryByGroupName(ClientGroupManagerEntity clientGroupManagerEntity);
}
