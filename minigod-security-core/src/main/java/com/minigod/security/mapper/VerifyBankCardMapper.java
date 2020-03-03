package com.minigod.security.mapper;

import com.minigod.security.protocol.model.VerifyBankCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;import java.util.List;

@Mapper
public interface VerifyBankCardMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

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
    VerifyBankCard selectByPrimaryKey(Long id);

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

    List<VerifyBankCard> selectByBankCardAndIsValid(@Param("bankCard") String bankCard, @Param("isValid") Boolean isValid);

    List<VerifyBankCard> selectByIdCardAndIsValidTrue(@Param("idCard") String idCard);
}