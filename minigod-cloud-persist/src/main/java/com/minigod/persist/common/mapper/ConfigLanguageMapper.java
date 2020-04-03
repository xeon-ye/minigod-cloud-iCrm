package com.minigod.persist.common.mapper;

import com.minigod.protocol.common.model.ConfigLanguage;

public interface ConfigLanguageMapper {
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
    int insert(ConfigLanguage record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ConfigLanguage record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ConfigLanguage selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ConfigLanguage record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ConfigLanguage record);
}