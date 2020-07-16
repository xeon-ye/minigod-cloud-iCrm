package com.sunline.modules.api.service;

import com.sunline.modules.common.vo.ResponseVO;

import java.util.List;

/**
 *
 * @author: lcs
 * @date: 2018/7/23
 */
public interface ChannelApiService {

    /**
     * 昨天渠道信息查询
     * @param channelIds
     * @return
     */
    ResponseVO queryInfo(List<String> channelIds, String channelId);


}
