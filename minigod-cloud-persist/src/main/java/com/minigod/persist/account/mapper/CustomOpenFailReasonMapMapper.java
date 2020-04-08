package com.minigod.persist.account.mapper;
import org.apache.ibatis.annotations.Param;

import com.minigod.protocol.account.model.CustomOpenFailReasonMap;

public interface CustomOpenFailReasonMapMapper {
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
    int insert(CustomOpenFailReasonMap record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenFailReasonMap record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenFailReasonMap selectByPrimaryKey(Long id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenFailReasonMap record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenFailReasonMap record);

    String selectOneConfigKeyByCode(@Param("code")Integer code);


}