package com.sunline.modules.group.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.group.entity.ClientGroupMemberInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jim
 * @email
 * @date 2018-03-12 11:14:27
 */
@Mapper
public interface ClientGroupMemberInfoDao extends BaseDao<ClientGroupMemberInfoEntity> {
    List<ClientGroupMemberInfoEntity> quertListByGroup(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity);

    /**
     * 删除全部分组成员
     * @param groupNo
     * @return
     */
    int deleteAll(Integer groupNo);

    /**
     * 批量修改成员的分组
     * @param clientGroupMemberInfoEntity
     * @return
     */
    int updateGroup(ClientGroupMemberInfoEntity clientGroupMemberInfoEntity);

    /**
     * 查询重复的数据 的id
     * @return
     */
    List<ClientGroupMemberInfoEntity> selectRepeat();
}
