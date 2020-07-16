package com.sunline.modules.api.dao;

import com.sunline.modules.api.entity.ChannelQueryModel;
import com.sunline.modules.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author jim
 * @email
 * @date 2018-07-26
 */
@Mapper
public interface ChannelApiDao extends BaseDao<ChannelQueryModel> {

    ChannelQueryModel queryLastInfo(@Param("channelIds") List<String> channelIds);

    ChannelQueryModel queryTotalInfo(@Param("channelIds") List<String> channelIds);
}
