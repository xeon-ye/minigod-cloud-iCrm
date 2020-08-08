package com.minigod.persist.notify.mapper;

import com.minigod.protocol.notify.model.StatisticCallDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticCallDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StatisticCallDetail record);

    int insertOrUpdate(StatisticCallDetail record);

    int insertOrUpdateSelective(StatisticCallDetail record);

    int insertSelective(StatisticCallDetail record);

    StatisticCallDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatisticCallDetail record);

    int updateByPrimaryKey(StatisticCallDetail record);

    int updateBatch(List<StatisticCallDetail> list);

    int batchInsert(@Param("list") List<StatisticCallDetail> list);
}