package com.minigod.notify.mapper;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

import com.minigod.protocol.notify.model.CaptchaSms;
import org.apache.ibatis.annotations.Mapper;

public interface CaptchaSmsMapper {
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
    int insert(CaptchaSms record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CaptchaSms record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CaptchaSms selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CaptchaSms record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CaptchaSms record);

    CaptchaSms selectFirstByPhoneOrderByCreateTimeDesc(@Param("phone")String phone);

    CaptchaSms selectOneByIdAndPhoneAndExpiresTimeBefore(@Param("id")Integer id,@Param("phone")String phone,@Param("maxExpiresTime")Date maxExpiresTime);

    CaptchaSms selectOneByIdAndPhoneAndExpiresTimeBeforeAndIsCheckedFalseAndIsUsedFalse(@Param("id")Integer id,@Param("phone")String phone,@Param("maxExpiresTime")Date maxExpiresTime);
}