package com.minigod.persist.account.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.minigod.protocol.account.model.CustomOpenBackErrorMap;

public interface CustomOpenBackErrorMapMapper {
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
    int insert(CustomOpenBackErrorMap record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenBackErrorMap record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenBackErrorMap selectByPrimaryKey(Long id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenBackErrorMap record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenBackErrorMap record);

    String selectOneConfigKeyByCode(@Param("code")Integer code);

}