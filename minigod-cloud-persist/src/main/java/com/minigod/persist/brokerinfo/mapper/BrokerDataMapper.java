package com.minigod.persist.brokerinfo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.minigod.protocol.brokerinfo.model.BrokerData;

public interface BrokerDataMapper {
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
    int insert(BrokerData record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BrokerData record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    BrokerData selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BrokerData record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BrokerData record);

    List<BrokerData> selectAll();

    List<BrokerData> selectAllByCode(@Param("code")String code);




}