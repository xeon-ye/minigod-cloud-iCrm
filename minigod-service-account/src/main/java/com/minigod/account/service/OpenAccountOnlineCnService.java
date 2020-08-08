package com.minigod.account.service;

import com.minigod.protocol.account.bpm.request.BpmOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.request.params.OpenImgReqParams;
import com.minigod.protocol.account.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.response.OpenImgResVo;
import com.minigod.protocol.account.response.OpenCacheDataResVo;

public interface OpenAccountOnlineCnService {
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params);

    public OpenImgResVo saveOrUpdateCnImg(Integer userId, OpenImgReqParams params);

    public void saveErrorImg(Integer userId, BpmOpenAccountImageInfoReqVo params);

    public String getImgUrl(Integer userId, String locationKey, String locationType);

    public OpenCacheDataResVo getCacheData(Integer userId, OpenCacheDataReqParams params);

}
