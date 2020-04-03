package com.minigod.securities.web.controller;


import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.securities.annotation.LoginUser;
import com.minigod.protocol.account.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.request.params.OpenImgReqParams;
import com.minigod.protocol.account.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.request.params.OpenInfoReqParams;
import com.minigod.protocol.account.response.OpenCacheDataResVo;
import com.minigod.protocol.account.response.OpenImgResVo;
import com.minigod.account.service.OpenAccountOnlineCnService;
import com.minigod.account.service.OpenAccountOnlineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open_api_cn")
@Validated
@Slf4j
public class OpenAccountCNController {
    @Autowired
    private OpenAccountOnlineService openAccountOnlineService;
    @Autowired
    private OpenAccountOnlineCnService openAccountOnlineCnService;

    /**
     * 保存用户开户缓存数据
     */
    @PostMapping("/save_cache_info")
    public ResResult saveCacheCnInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenCacheInfoReqParams> requestVo) {
        try {
            OpenCacheInfoReqParams params = requestVo.getParams();
            openAccountOnlineCnService.saveOrUpdateCacheInfoStep(userId, params);
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_SAVE_CACHE_INFO);
        }
    }

    /**
     * 保存用户开户图片数据
     */
    @PostMapping("/save_cache_img")
    public ResResult saveCacheCnImg(@LoginUser Integer userId, @RequestBody BaseRequest<OpenImgReqParams> requestVo) {
        try {
            OpenImgReqParams params = requestVo.getParams();
            OpenImgResVo res = openAccountOnlineCnService.saveOrUpdateCnImg(userId, params);
            return ResResult.success(res);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_SAVE_CACHE_IMG);
        }
    }

    /**
     * 获取用户开户缓存数据
     */
    @PostMapping("/get_cache_data")
    public ResResult getCacheCnInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenCacheDataReqParams> requestVo) {
        try {
            OpenCacheDataReqParams params = requestVo.getParams();
            OpenCacheDataResVo resVo = openAccountOnlineCnService.getCacheData(userId, params);
            return ResResult.success(resVo);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_GET_CACHE_DATA);
        }
    }

    /**
     * 提交开户
     */
    @PostMapping("/submit_open_info")
    public ResResult submitOpenInfo(@LoginUser Integer userId, @RequestBody BaseRequest<OpenInfoReqParams> requestVo) {
        try {
            OpenInfoReqParams params = requestVo.getParams();
            openAccountOnlineService.saveOrUpdateOpenInfo(userId, params);
            return ResResult.success();
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_SUBMIT_OPEN_INFO);
        }
    }
}
