package com.minigod.persist.notify.mapper;

import com.minigod.protocol.notify.model.StatisticCall;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StatisticCallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StatisticCall record);

    int insertOrUpdate(StatisticCall record);

    int insertOrUpdateSelective(StatisticCall record);

    int insertSelective(StatisticCall record);

    StatisticCall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StatisticCall record);

    int updateByPrimaryKey(StatisticCall record);

    int updateBatch(List<StatisticCall> list);

    int batchInsert(@Param("list") List<StatisticCall> list);

    int updateUseNumbByIdAndModuleType(@Param("moduleType")String moduleType);


}