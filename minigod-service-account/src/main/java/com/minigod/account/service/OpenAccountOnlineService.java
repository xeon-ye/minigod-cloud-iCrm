package com.minigod.account.service;

import com.minigod.protocol.account.bpm.callback.BpmOpenInfoCallbackVo;
import com.minigod.protocol.account.request.params.*;
import com.minigod.protocol.account.response.OpenUserInfoResVo;
//import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

//@FeignClient(value = "minigod-account-service")
public interface OpenAccountOnlineService {
    public List<Object> getDictionaryData(DictionaryDataReqParams params);

    public Boolean isCanUpdateOpenInfo(Integer userId);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);

    public void updateOpenInfo(BpmOpenInfoCallbackVo callbackVo);

    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressReqParams params);

    public Object ocrByCardType(Integer userId, OcrReqParams ocrReqParams);

    public Object ocrByImage(Integer userId, OpenImgReqParams ocrReqParams);


}
