package com.minigod.persist.notify.mapper;

import com.minigod.protocol.notify.model.SysMailRecord;

public interface SysMailRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMailRecord record);

    int insertSelective(SysMailRecord record);

    SysMailRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMailRecord record);

    int updateByPrimaryKey(SysMailRecord record);
}