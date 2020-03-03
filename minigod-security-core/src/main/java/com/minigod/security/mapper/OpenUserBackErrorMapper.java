package com.minigod.security.mapper;

import com.minigod.security.protocol.model.OpenUserBackError;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OpenUserBackErrorMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OpenUserBackError record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OpenUserBackError record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    OpenUserBackError selectByPrimaryKey(Long id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OpenUserBackError record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OpenUserBackError record);
}