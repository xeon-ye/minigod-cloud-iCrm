package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.CustomSession;
import org.apache.ibatis.annotations.Mapper;

public interface CustomSessionMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CustomSession record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomSession record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CustomSession selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomSession record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomSession record);
}