package com.sunline.modules.group.service;

import com.sunline.modules.common.page.Page;
import com.sunline.modules.group.entity.ClientGroupMemberInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
public interface ClientGroupMemberInfoService {

    ClientGroupMemberInfoEntity queryObject(Integer id);

    List<ClientGroupMemberInfoEntity> queryList(Map<String, Object> map);

    List<ClientGroupMemberInfoEntity> query(ClientGroupMemberInfoEntity entity);

    List<ClientGroupMemberInfoEntity> queryListByBean(ClientGroupMemberInfoEntity entity);

    int queryTotal(Map<String, Object> map);

    int save(ClientGroupMemberInfoEntity clientGroupMemberInfo);

    int update(ClientGroupMemberInfoEntity clientGroupMemberInfo);

    int updateGroup(ClientGroupMemberInfoEntity clientGroupMemberInfo);

    int delete(Integer id);

    int deleteBatch(Integer[] ids);

    Page<ClientGroupMemberInfoEntity> findPage(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, int pageNum);

    /**
     * 分页查询分组信息
     * @param clientGroupMemberInfoEntity
     * @param pageNum
     * @return
     */
    Page<ClientGroupMemberInfoEntity> groupListPage(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity, int pageNum);

    /**
     * 删除全部分组成员
     * @param id
     * @return
     */
    int deleteAll(Integer id);

    List<ClientGroupMemberInfoEntity> clientGroupExpExcelList(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity);

    List<ClientGroupMemberInfoEntity>  selectRepeat();

}
