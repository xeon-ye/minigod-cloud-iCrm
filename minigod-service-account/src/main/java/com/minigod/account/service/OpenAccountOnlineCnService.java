package com.minigod.account.service;

import com.minigod.protocol.account.vo.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.vo.request.params.OpenImgReqParams;
import com.minigod.protocol.account.vo.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.vo.request.params.OpenInfoReqParams;
import com.minigod.protocol.account.vo.response.OpenImgResVo;
import com.minigod.protocol.account.vo.response.OpenCacheDataResVo;

public interface OpenAccountOnlineCnService {
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params);

    public OpenImgResVo saveOrUpdateCnImg(Integer userId, OpenImgReqParams params);

    public String getImgUrl(Integer userId, String locationKey, String locationType);

    public OpenCacheDataResVo getCacheData(Integer userId, OpenCacheDataReqParams params);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);


}
