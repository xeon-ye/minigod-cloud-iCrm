package com.minigod.security.mapper;

import com.minigod.security.protocol.model.CustomOpenCnCacheInfo;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface CustomOpenCnCacheInfoMapper {
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
    int insert(CustomOpenCnCacheInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenCnCacheInfo record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenCnCacheInfo selectByPrimaryKey(Integer id);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenCnCacheInfo record);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenCnCacheInfo record);

    Integer selectOneIdByUserIdAndStep(@Param("userId") Integer userId, @Param("step") Integer step);

    CustomOpenCnCacheInfo selectOneByUserIdAndStep(@Param("userId") Integer userId, @Param("step") Integer step);

    List<CustomOpenCnCacheInfo> selectByUserId(@Param("userId") Integer userId);
}