package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.VerifyIdCard;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface VerifyIdCardMapper {
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
    int insert(VerifyIdCard record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(VerifyIdCard record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    VerifyIdCard selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(VerifyIdCard record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(VerifyIdCard record);

    List<VerifyIdCard> selectByIdCardAndStatus(@Param("idCard")String idCard,@Param("status")Integer status);

    VerifyIdCard selectOneByIdCardAndUserName(@Param("idCard") String idCard, @Param("userName") String userName);
}