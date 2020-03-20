package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.SysAppAuth;import org.apache.ibatis.annotations.Param;

public interface SysAppAuthMapper {
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
    int insert(SysAppAuth record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(SysAppAuth record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    SysAppAuth selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(SysAppAuth record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(SysAppAuth record);

    SysAppAuth selectOneByAppKeyAndDeletedFalse(@Param("appKey") String appKey);

    SysAppAuth selectOneByAppKeyAndAppSecretAndDeletedFalse(@Param("appKey") String appKey, @Param("appSecret") String appSecret);
}