package com.minigod.persist.brokerinfo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.minigod.protocol.brokerinfo.model.Brokerinfo;

public interface BrokerinfoMapper {
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
    int insert(Brokerinfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Brokerinfo record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Brokerinfo selectByPrimaryKey(Integer id);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Brokerinfo record);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Brokerinfo record);

    List<Brokerinfo> selectAll();


}