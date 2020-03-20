package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;

import java.util.*;

import com.minigod.common.utils.JSONUtil;
import com.minigod.common.bean.BaseBeanFactory;
import com.minigod.account.helper.ImageStorageHelper;
import com.minigod.persist.account.mapper.CustomOpenCnCacheInfoMapper;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.protocol.account.enums.CubpMessageResource;
import com.minigod.protocol.account.model.CustomOpenCnCacheInfo;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.vo.request.params.OpenCacheDataReqParams;
import com.minigod.protocol.account.vo.request.params.OpenImgReqParams;
import com.minigod.protocol.account.vo.request.params.OpenCacheInfoReqParams;
import com.minigod.protocol.account.vo.request.params.OpenInfoReqParams;
import com.minigod.protocol.account.vo.response.OpenImgResVo;
import com.minigod.protocol.account.vo.response.OpenCacheDataResVo;
import com.minigod.account.service.OpenAccountOnlineCnService;
import com.minigod.account.service.OpenAccountService;
import com.minigod.storage.helper.StorageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
    OpenAccountService openAccountService;

    @Autowired
    ImageStorageHelper imageStorageHelper;

    @Autowired
    StorageHelper storageService;

    private void saveOrUpdateStepInfo(Integer userId, Integer step, Object json) {
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

    private void saveOrUpdateLastStepInfo(Integer userId, Integer step) {
        Integer baseStep = -1;
        Map<String, Integer> lastStepInfo = new HashMap<>();
        lastStepInfo.put("lastStep", step);
        saveOrUpdateStepInfo(userId, baseStep, lastStepInfo);
    }

    @Override
    public void saveOrUpdateCacheInfoStep(Integer userId, OpenCacheInfoReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: OpenCacheInfoReqParams");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }
        Integer step = params.getStep();
        Object info = params.getInfo();

        // 参数校验 - 基本
        if (step == null || info == null || step < 1) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        if (!openAccountService.isCanUpdateOpenInfo(userId)) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
        }

        saveOrUpdateStepInfo(userId, step, info);
        saveOrUpdateLastStepInfo(userId, step);
    }

    @Override
    public OpenImgResVo saveOrUpdateCnImg(Integer userId, OpenImgReqParams params) {
        // 参数校验
        if (userId == null || params == null) {
            log.error("参数异常: OpenImgResVo");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        String location = params.getLocation();
        String type = params.getType();
        String base64Img = params.getImgBase64();

        // 参数校验 - 基本
        if (StringUtils.isBlank(location) || StringUtils.isBlank(type) || StringUtils.isBlank(base64Img)) {
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        if (!openAccountService.isCanUpdateOpenInfo(userId)) {
            throw new InternalApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.NO_SUBMIT_OPEN_INFO_REPEAT);
        }

        String fileName = userId + "_" + type + System.currentTimeMillis() + ".jpg";

        String imgPath = imageStorageHelper.uploadImage(fileName, base64Img);

        // 查询当前步骤缓存数据
        Integer cacheId = openCnImgMapper.selectOneIdByUserIdAndLocationType(userId, type);

        CustomOpenCnImg openCnImg = new CustomOpenCnImg();
        openCnImg.setUserId(userId);
        openCnImg.setLocationKey(location);
        openCnImg.setLocationType(type);
        openCnImg.setUrl(imgPath);
        openCnImg.setErrorStatus(0);
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
            log.error("参数异常: OpenCacheDataReqParams");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

        Integer step = params.getStep();

        // 参数校验 - 基本
        if (step == null || step < 0) {
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
            OpenImgResVo imgResVo = new OpenImgResVo();
            imgResVo.setImgUrl(img.getUrl());
            imgResVo.setLocation(img.getLocationKey());
            imgResVo.setType(img.getLocationType());

            resImgList.add(imgResVo);
        }

        resVo.setCacheImages(resImgList);

        return resVo;
    }

    private boolean verifyOpenInfoData() {
        return true;
    }

    @Override
    public void saveOrUpdateOpenInfo(Integer userId, OpenInfoReqParams params) {
        // 参数校验
        if (params == null) {
            log.error("参数异常: OpenCacheDataReqParams");
            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
        }

//        Integer openType = params.getOpenType();
//        Object info = params.getInfo();
//
//        CustomOpenAccountEnum.OpenType openWayInfo = CustomOpenAccountEnum.OpenType.getType(openType);
//
//        // 参数校验 - 基本
//        if (info == null || openWayInfo == null) {
//            throw new InternalApiException(StaticType.CodeType.BAD_PARAMS, StaticType.MessageResource.BAD_PARAMS);
//        }


        // String info, String infoSt, Integer openType , Integer actId


    }
}
