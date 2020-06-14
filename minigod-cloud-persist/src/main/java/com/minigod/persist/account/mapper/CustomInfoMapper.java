package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.CustomInfo;import org.apache.ibatis.annotations.Param;

public interface CustomInfoMapper {
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
    int insert(CustomInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomInfo record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomInfo selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomInfo record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomInfo record);

    CustomInfo selectOneByPhone(@Param("phone") String phone);
}