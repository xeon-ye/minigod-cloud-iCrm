package com.minigod.storage.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.minigod.storage.protocol.model.SysStorage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysStorageMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(SysStorage record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysStorage record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    SysStorage selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysStorage record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysStorage record);

    SysStorage selectOneByKey(@Param("key")String key);



}