package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.CustomOpenCnImg;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface CustomOpenCnImgMapper {
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
    int insert(CustomOpenCnImg record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenCnImg record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenCnImg selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenCnImg record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenCnImg record);

    List<CustomOpenCnImg> selectByUserId(@Param("userId") Integer userId);

    Integer selectOneIdByUserIdAndLocationType(@Param("userId") Integer userId, @Param("locationType") String locationType);

    CustomOpenCnImg selectOneByUserIdAndLocationType(@Param("userId") Integer userId, @Param("locationType") String locationType);

    List<CustomOpenCnImg> selectByUserIdAndLocationKeyInAndLocationTypeIn(@Param("userId") Integer userId, @Param("locationKeyCollection") String[] locationKeyCollection, @Param("locationTypeCollection") String[] locationTypeCollection);

    int deleteByUserId(@Param("userId")Integer userId);


}