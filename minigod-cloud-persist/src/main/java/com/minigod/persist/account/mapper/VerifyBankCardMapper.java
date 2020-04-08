package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.VerifyBankCard;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface VerifyBankCardMapper {
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
    int insert(VerifyBankCard record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(VerifyBankCard record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    VerifyBankCard selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(VerifyBankCard record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(VerifyBankCard record);

    List<VerifyBankCard> selectByBankCardAndStatus(@Param("bankCard")String bankCard,@Param("status")Integer status);

    VerifyBankCard selectOneByIdCardAndUserNameAndBankCardAndPhone(@Param("idCard") String idCard, @Param("userName") String userName, @Param("bankCard") String bankCard, @Param("phone") String phone);

    List<VerifyBankCard> selectByIdCard(@Param("idCard")String idCard);

}