package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.CustomOpenMoreAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomOpenMoreAccountMapper {
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
    int insert(CustomOpenMoreAccount record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenMoreAccount record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenMoreAccount selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenMoreAccount record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenMoreAccount record);


    CustomOpenMoreAccount selectOneByUserIdAndType(@Param("userId") Integer userId, @Param("type") Integer type);

    List<CustomOpenMoreAccount> selectByIsPushedFalse();

    List<CustomOpenMoreAccount> selectByIsNoticedFalse();

    CustomOpenMoreAccount selectOneByTradeAccount(@Param("tradeAccount") String tradeAccount);

    List<CustomOpenMoreAccount> selectByStatusAndIsNoticedFalse(@Param("status") Integer status);

}