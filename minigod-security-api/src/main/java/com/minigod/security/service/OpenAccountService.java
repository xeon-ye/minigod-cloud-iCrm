package com.minigod.security.service;

import com.minigod.security.protocol.model.CustomOpenInfo;
import com.minigod.security.protocol.vo.request.params.*;
import com.minigod.security.protocol.vo.response.OpenUserInfoResVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "minigod-security-service")
public interface OpenAccountService {
    public List<Object> getDictionaryData(DictionaryDataReqParams params);

    public Boolean isCanUpdateOpenInfo(Integer userId);

    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params);

    public OpenUserInfoResVo getOpenProgress(Integer userId, OpenProgressReqParams params);

    public Object ocrByCardType(Integer userId, OcrReqParams ocrReqParams);

    public Object ocrByImage(Integer userId, OpenImgReqParams ocrReqParams);

}
