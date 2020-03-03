package com.minigod.security.mapper;

import com.minigod.security.protocol.model.CustomOpenHkInfoTemp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomOpenHkInfoTempMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(CustomOpenHkInfoTemp record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenHkInfoTemp record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenHkInfoTemp selectByPrimaryKey(Long id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenHkInfoTemp record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenHkInfoTemp record);
}