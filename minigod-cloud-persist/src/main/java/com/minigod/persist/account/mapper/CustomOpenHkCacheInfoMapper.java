package com.minigod.persist.account.mapper;

import com.minigod.protocol.account.model.CustomOpenCnCacheInfo;
import com.minigod.protocol.account.model.CustomOpenHkCacheInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomOpenHkCacheInfoMapper {
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
    int insert(CustomOpenHkCacheInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CustomOpenHkCacheInfo record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    CustomOpenHkCacheInfo selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CustomOpenHkCacheInfo record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CustomOpenHkCacheInfo record);
    Integer selectOneIdByUserIdAndStep(@Param("userId")Integer userId,@Param("step")Integer step);

    CustomOpenHkCacheInfo selectOneByUserIdAndStep(@Param("userId")Integer userId,@Param("step")Integer step);

    List<CustomOpenHkCacheInfo> selectByUserId(@Param("userId")Integer userId);

}