package com.sunline.modules.sys.dao;

import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.sys.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单表
 * 
 * @author chenshun
 * @email huangxianyuan@gmail.com
 * @date 2017-05-03 10:07:59
 */
@Mapper
public interface MenuDao extends BaseDao<MenuEntity> {

    /**
     *根据登录用户Id,查询出所有授权菜单
     * @param userId
     * @return
     */
    List<MenuEntity> queryByUserId(String userId);

    /**
     * 根据父菜单Id查询菜单
     * @param parenId
     * @return
     */
    List<MenuEntity> queryListParentId(String parenId);

    /**
     * 查询所有不包括按钮 的菜单
     * @return
     */
    List<MenuEntity> queryNotButtonnList(String[] types);

}
