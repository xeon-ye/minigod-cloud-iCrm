package com.minigod.account.service;

import com.minigod.protocol.account.vo.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.vo.request.params.OpenImgReqParams;
import com.minigod.protocol.account.vo.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.vo.request.params.OpenInfoReqParams;
import com.minigod.protocol.account.vo.response.OpenCacheDataResVo;
import com.minigod.protocol.account.vo.response.OpenImgResVo;

public interface OpenAccountOnlineHkService {
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params);

    public OpenImgResVo saveOrUpdateImg(Integer userId, OpenImgReqParams params);

    public String getImgUrl(Integer userId, String locationKey, String locationType);

    public OpenCacheDataResVo getCacheData(Integer userId, OpenCacheDataReqParams params);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);
}
