package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.minigod.account.service.VerifyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;

import java.util.*;

import com.minigod.common.utils.JSONUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.account.helper.FileStorageHelper;
import com.minigod.persist.account.mapper.CustomOpenCnCacheInfoMapper;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.model.CustomOpenCnCacheInfo;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.request.params.OpenImgReqParams;
import com.minigod.protocol.account.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.request.params.VerifyReqParams;
import com.minigod.protocol.account.response.OpenImgResVo;
import com.minigod.protocol.account.response.OpenCacheDataResVo;
import com.minigod.account.service.OpenAccountOnlineCnService;
import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.protocol.account.response.VerifyResVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mortbay.util.ajax.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OpenAccountOnlineCnServiceImpl extends BaseBeanFactory implements OpenAccountOnlineCnService {

    @Autowired
    CustomOpenCnCacheInfoMapper openCnCacheInfoMapper;

    @Autowired
    CustomOpenCnImgMapper openCnImgMapper;

    @Autowired
    CustomOpenInfoMapper openInfoMapper;

    @Autowired
    OpenAccountOnlineService openAccountOnlineService;

    @Autowired
    FileStorageHelper fileStorageHelper;
    @Autowired
    VerifyService verifyService;

    private void saveOrUpdateCnStepInfo(Integer userId, Integer step, Object json) {
        // 查询当前步骤缓存数据
        Integer cacheId = openCnCacheInfoMapper.selectOneIdByUserIdAndStep(userId, step);

        CustomOpenCnCacheInfo cacheInfo = new CustomOpenCnCacheInfo();

        Date date = new Date();
        String jsonInfo = JSONUtil.toJson(json);

        cacheInfo.setUpdateTime(date);
        cacheInfo.setJsonInfo(jsonInfo);

        if (cacheId != null) {
            cacheInfo.setId(cacheId);
            openCnCacheInfoMapper.updateByPrimaryKeySelective(cacheInfo);
        } else {
            cacheInfo.setUserId(userId);
            cacheInfo.setStep(step);
            cacheInfo.setCreateTime(date);
            openCnCacheInfoMapper.insertSelective(cacheInfo);
        }
    }

    private void saveOrUpdateCnLastStepInfo(Integer userId, Integer step) {
        Integer baseStep = -1;
        Map<String, Integer> lastStepInfo = new HashMap<>();
        lastStepInfo.put("lastStep", step);
        saveOrUpdateCnStepInfo(userId, baseStep, lastStepInfo);
    }

    @Override
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: OpenCacheInfoReqParams_CN", JSON.toString(params));
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }
        Integer step = params.getStep();
        Object info = params.getInfo();

        // 参数校验 - 基本
        if (step == null || info == null || step < 1) {
            log.error("参数异常: OpenCacheInfoReqParams_Value_CN");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        if (!openAccountOnlineService.isCanUpdateOpenInfo(userId)) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
        }

        saveOrUpdateCnStepInfo(userId, step, info);
        saveOrUpdateCnLastStepInfo(userId, step);
    }

    @Override
    public OpenImgResVo saveOrUpdateCnImg(Integer userId, OpenImgReqParams params) {
        // 参数校验
        if (userId == null || params == null) {
            log.error("参数异常: OpenImgResVo_CN", JSON.toString(params));
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        String location = params.getLocation();
        String type = params.getType();
        String base64Img = params.getImgBase64();

        // 参数校验 - 基本
        if (StringUtils.isBlank(location) || StringUtils.isBlank(type) || StringUtils.isBlank(base64Img)) {
            log.error("参数异常: OpenImgResVo_Value_CN");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        if (!openAccountOnlineService.isCanUpdateOpenInfo(userId)) {
            log.error("重复提交：saveOrUpdateImg_CN");
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
        }

        String fileName = userId + "_" + type + System.currentTimeMillis() + ".jpg";

        String imgPath = fileStorageHelper.uploadImage(fileName, base64Img);

        // 活体照片校验(指定动作照、手持身份证照、正面照）
        if (location.equals("4") || location.equals("5")) {
            VerifyReqParams verifyReqParams = new VerifyReqParams();
            verifyReqParams.setLiveImage(imgPath);
            VerifyResVo verifyResVo = verifyService.verifyLiveFace(verifyReqParams, userId);

            if (verifyResVo == null || !verifyResVo.getIsValid()) {
                log.error("活体校验失败");
                throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, StaticType.MessageResource.FAIL_VERIFY_LIVE_FACE);
            }
        }

        // 查询当前步骤缓存数据
        Integer cacheId = openCnImgMapper.selectOneIdByUserIdAndLocationType(userId, type);

        CustomOpenCnImg openCnImg = new CustomOpenCnImg();
        openCnImg.setUserId(userId);
        openCnImg.setLocationKey(location);
        openCnImg.setLocationType(type);
        openCnImg.setUrl(imgPath);
        openCnImg.setIsError(false);
        openCnImg.setCreateTime(new Date());

        if (cacheId != null) {
            openCnImg.setId(cacheId);
            openCnImgMapper.updateByPrimaryKey(openCnImg);
        } else {
            openCnImgMapper.insert(openCnImg);
        }

        OpenImgResVo resVo = new OpenImgResVo();
        resVo.setImgId(openCnImg.getId());
        resVo.setImgUrl(imgPath);
        return resVo;
    }

    @Override
    public void saveErrorImg(Integer userId, CubpOpenAccountImageInfoReqVo params) {
        // 参数校验
        if (userId == null || params == null) {
            log.error("saveErrorImg参数异常: OpenImgResVo_CN", JSON.toString(params));
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer location = params.getImageLocation();
        Integer type = params.getImageLocationType();

        // 参数校验 - 基本
        if (location == null || type == null) {
            log.error("saveErrorImg参数异常: OpenImgResVo_Value_CN");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        CustomOpenCnImg openCnImg = openCnImgMapper.selectOneByUserIdAndLocationType(userId, String.valueOf(type));

        if (openCnImg != null) {
            openCnImg.setLocationKey(String.valueOf(location));
            openCnImg.setLocationType(String.valueOf(type));
            openCnImg.setCreateTime(new Date());
            openCnImg.setIsError(true);
            openCnImgMapper.updateByPrimaryKeySelective(openCnImg);
        }
    }

    @Override
    public String getImgUrl(Integer userId, String locationKey, String locationType) {
        // 参数校验
        if (userId == null || StringUtils.isBlank(locationKey) || StringUtils.isBlank(locationType)) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        // 查询当前步骤缓存数据
        CustomOpenCnImg cacheImg = openCnImgMapper.selectOneByUserIdAndLocationType(userId, locationType);


        if (cacheImg == null) {
            return null;
        }

        return cacheImg.getUrl();
    }

    @Override
    public OpenCacheDataResVo getCacheData(Integer userId, OpenCacheDataReqParams params) {

        // 参数校验
        if (params == null) {
            log.error("参数异常: OpenCacheDataReqParams_CN", JSON.toString(params));
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer step = params.getStep();

        // 参数校验 - 基本
        if (step == null || step < 0) {
            log.error("参数异常: OpenCacheDataReqParams_Value_CN");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        OpenCacheDataResVo resVo = new OpenCacheDataResVo();

        // 查询所有
        if (step.equals(0)) {
            List<CustomOpenCnCacheInfo> list = openCnCacheInfoMapper.selectByUserId(userId);

            Integer lastStep = 0;

            if (CollectionUtils.isNotEmpty(list)) {
                StringBuffer str = new StringBuffer();
                if (list.size() == 1) {
                    CustomOpenCnCacheInfo cache = list.get(0);
                    str.append(cache.getJsonInfo());
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        CustomOpenCnCacheInfo cache = list.get(i);
                        str.append(cache.getJsonInfo());
                    }
                }
                String jsonInfo = str.toString().replace("}{", ",");
                JSONObject json = JSONObject.parseObject(jsonInfo);

                lastStep = json.getIntValue("lastStep");
                json.remove("lastStep");

                resVo.setCacheInfos(json);
            }

            resVo.setLastStep(lastStep);
        } else {
            CustomOpenCnCacheInfo cache = openCnCacheInfoMapper.selectOneByUserIdAndStep(userId, step);
            if (cache != null) {
                JSONObject json = JSONObject.parseObject(cache.getJsonInfo());
                resVo.setCacheInfos(json);
            }
        }

        List<OpenImgResVo> resImgList = new ArrayList<>();

        //查询图片信息
        List<CustomOpenCnImg> imgList = openCnImgMapper.selectByUserId(userId);
        for (CustomOpenCnImg img : imgList) {
            if (!img.getIsError()) {
                OpenImgResVo imgResVo = new OpenImgResVo();
                imgResVo.setImgUrl(img.getUrl());
                imgResVo.setLocation(img.getLocationKey());
                imgResVo.setType(img.getLocationType());
                resImgList.add(imgResVo);
            }
        }

        resVo.setCacheImages(resImgList);

        return resVo;
    }

    private boolean verifyOpenInfoData() {
        return true;
    }
}
