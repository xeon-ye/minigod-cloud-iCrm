package com.minigod.statistic.service.impl;

import com.minigod.persist.notify.mapper.StatisticCallDetailMapper;
import com.minigod.persist.notify.mapper.StatisticCallMapper;
import com.minigod.protocol.notify.model.StatisticCall;
import com.minigod.protocol.notify.model.StatisticCallDetail;
import com.minigod.protocol.statistic.model.Statistic;
import com.minigod.statistic.service.StatisticCallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
@Service
public class StatisticCallServiceImpl implements StatisticCallService {
    @Resource
    private StatisticCallMapper statisticCallMapper;
    @Resource
    private StatisticCallDetailMapper statisticCallDetailMapper;

    @Override
    public void save(Statistic statistic) {
        //转换vo
        StatisticCallDetail statisticCallDetail = new StatisticCallDetail();
        statisticCallDetail.setuId(statistic.getUid());
        statisticCallDetail.setModuleType(statistic.getModuleType());
        statisticCallDetail.setOptTime(statistic.getOptTime());
        statisticCallDetail.setCreateTime(new Date());
        statisticCallDetail.setUpdateTime(new Date());
        statisticCallDetailMapper.insert(statisticCallDetail);
        statisticCallMapper.updateUseNumbByIdAndModuleType(statistic.getModuleType());
    }
}
