package com.minigod.persist.account.mapper;
import java.util.Date;

import com.minigod.protocol.account.model.VerifyLiveFace;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface VerifyLiveFaceMapper {
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
    int insert(VerifyLiveFace record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(VerifyLiveFace record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    VerifyLiveFace selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(VerifyLiveFace record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(VerifyLiveFace record);

    VerifyLiveFace selectOneByUserIdAndImgUrl(@Param("userId") Integer userId, @Param("imgUrl") String imgUrl);

    List<VerifyLiveFace> selectByUserIdAndCheckDate(@Param("userId")Integer userId,@Param("checkDate")Date checkDate);


}