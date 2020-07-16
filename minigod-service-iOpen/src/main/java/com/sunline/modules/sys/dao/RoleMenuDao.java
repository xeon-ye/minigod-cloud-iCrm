package com.sunline.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 权限角色表
 * 
 * @author chenshun
 * @email huangxianyuan@gmail.com
 * @date 2017-05-03 10:07:59
 */
@Mapper
public interface RoleMenuDao {
    int delete(Map<String, Object> map);

    int deleteBatch(Object[] ids);

    int delete(Object id);

    int deleteChannel(Object id);

    void save(Map<String, Object> map);

    void saveChannel(Map<String, Object> map);

    List<String> queryListByRoleId(String roleId);

    List<String> queryChannelByRoleId(String roleId);
}
