package com.minigod.persist.common.mapper;
import java.util.List;
import java.util.Collection;
import org.apache.ibatis.annotations.Param;

import com.minigod.protocol.common.model.ConfigLanguage;

public interface ConfigLanguageMapper {
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
    int insert(ConfigLanguage record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ConfigLanguage record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ConfigLanguage selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ConfigLanguage record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ConfigLanguage record);


    ConfigLanguage selectOneByConfigKeyAndLangKey(@Param("configKey")String configKey,@Param("langKey")String langKey);

    List<String> selectContentByConfigKeyInAndLangKey(@Param("configKeyCollection")String[] configKeyCollection,@Param("langKey")String langKey);




}