package com.minigod.account.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.minigod.protocol.account.model.CustomDevice;

public interface CustomDeviceMapper {
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
    int insert(CustomDevice record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomDevice record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomDevice selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomDevice record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomDevice record);

    CustomDevice selectOneByDeviceCodeAndOsType(@Param("deviceCode")String deviceCode,@Param("osType")Byte osType);



}