package com.sunline.modules.sys.dao;


import com.sunline.modules.common.dao.BaseDao;
import com.sunline.modules.sys.entity.CodeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;
import java.util.List;

/**
 * 系统数据字典
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2017-07-14 13:42:42
 */
@Mapper
public interface CodeDao extends BaseDao<CodeEntity> {
    /**
     * 查询所有的字典及子字典(用做字典缓存)
     * @return
     */
    List<CodeEntity> queryAllCode();

    /**
     * 查询所有的字典及子字典(用做字典缓存)
     * @return
     */
    LinkedList<CodeEntity> queryChildsByMark(CodeEntity entity);

    /**
     * 根据字典标识查询
     * @param mark
     * @return
     */
    CodeEntity queryByMark(String mark);


}
