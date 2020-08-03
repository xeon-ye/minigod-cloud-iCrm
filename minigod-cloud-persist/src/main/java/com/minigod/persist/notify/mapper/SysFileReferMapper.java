package com.minigod.persist.notify.mapper;

import com.minigod.protocol.notify.model.SysFileRefer;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysFileReferMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysFileRefer record);

    int insertOrUpdate(SysFileRefer record);

    int insertOrUpdateSelective(SysFileRefer record);

    int insertSelective(SysFileRefer record);

    SysFileRefer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysFileRefer record);

    int updateByPrimaryKey(SysFileRefer record);

    int updateBatch(List<SysFileRefer> list);

    int batchInsert(@Param("list") List<SysFileRefer> list);

    int updateBatchSelective(List<SysFileRefer> list);
}