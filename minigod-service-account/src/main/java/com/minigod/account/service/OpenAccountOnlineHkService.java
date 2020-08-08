package com.minigod.account.service;

import com.minigod.protocol.account.bpm.request.BpmOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.request.params.OpenImgReqParams;
import com.minigod.protocol.account.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.response.OpenCacheDataResVo;
import com.minigod.protocol.account.response.OpenImgResVo;

public interface OpenAccountOnlineHkService {
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params);

    public OpenImgResVo saveOrUpdateImg(Integer userId, OpenImgReqParams params);

    public void saveErrorImg(Integer userId, BpmOpenAccountImageInfoReqVo params);

    public String getImgUrl(Integer userId, String locationKey, String locationType);

    public OpenCacheDataResVo getCacheData(Integer userId, OpenCacheDataReqParams params);
}
