package com.minigod.persist.account.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.minigod.protocol.account.model.CustomOpenHkImg;

public interface CustomOpenHkImgMapper {
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
    int insert(CustomOpenHkImg record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenHkImg record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenHkImg selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenHkImg record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenHkImg record);

    List<CustomOpenHkImg> selectByUserId(@Param("userId")Integer userId);

    Integer selectOneIdByUserIdAndLocationType(@Param("userId")Integer userId,@Param("locationType")String locationType);

    List<CustomOpenHkImg> selectByUserIdAndLocationKeyInAndLocationTypeIn(@Param("userId")Integer userId, @Param("locationKeyCollection")String[] locationKeyCollection, @Param("locationTypeCollection")String[] locationTypeCollection);

    CustomOpenHkImg selectOneByUserIdAndLocationType(@Param("userId")Integer userId,@Param("locationType")String locationType);


}