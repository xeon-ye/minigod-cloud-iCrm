package com.minigod.security.service;

import com.minigod.security.protocol.vo.request.params.OpenCacheDataReqParams;
import com.minigod.security.protocol.vo.request.params.OpenImgReqParams;
import com.minigod.security.protocol.vo.request.params.OpenCacheInfoReqParams;
import com.minigod.security.protocol.vo.request.params.OpenInfoReqParams;
import com.minigod.security.protocol.vo.response.OpenCacheDataResVo;
import com.minigod.security.protocol.vo.response.OpenImgResVo;

public interface OpenAccountOnlineHkService {
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params);

    public OpenImgResVo saveOrUpdateImg(Integer userId, OpenImgReqParams params);

    public String getImgUrl(Integer userId, String locationKey, String locationType);

    public OpenCacheDataResVo getCacheData(Integer userId, OpenCacheDataReqParams params);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);
}
