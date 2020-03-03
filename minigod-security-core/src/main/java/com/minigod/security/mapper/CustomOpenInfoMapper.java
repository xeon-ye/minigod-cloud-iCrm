package com.minigod.security.mapper;

import com.minigod.security.protocol.model.CustomOpenInfo;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface CustomOpenInfoMapper {
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
    int insert(CustomOpenInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenInfo record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenInfo selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenInfo record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenInfo record);

    List<CustomOpenInfo> selectByIsNeedPush(@Param("isNeedPush") Boolean isNeedPush);

    CustomOpenInfo selectOneById(@Param("id") Integer id);

    CustomOpenInfo selectOneByPhone(@Param("phone") String phone);
}