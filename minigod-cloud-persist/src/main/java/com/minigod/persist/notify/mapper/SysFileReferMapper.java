package com.minigod.persist.notify.mapper;

import com.minigod.protocol.notify.model.SysFileRefer;

public interface SysFileReferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFileRefer record);

    int insertSelective(SysFileRefer record);

    SysFileRefer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFileRefer record);

    int updateByPrimaryKey(SysFileRefer record);
}