package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.utils.DateUtils;
import com.minigod.common.utils.JSONUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.account.service.OpenAccountOfflineService;
import com.minigod.persist.account.mapper.CustomInfoMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.protocol.account.cubp.callback.CubpOpenInfoCallbackVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.model.CustomInfo;
import com.minigod.protocol.account.model.CustomOpenInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class OpenAccountOfflineServiceImpl extends BaseBeanFactory implements OpenAccountOfflineService {
    @Autowired
    CustomInfoMapper customInfoMapper;
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;

    @Override
    public Integer saveOrUpdateOpenInfo(CubpOpenInfoCallbackVo cubpOpenInfoCallbackVo) {
        log.info("请求 /callback/offline：" + JSONUtil.toCompatibleJson(cubpOpenInfoCallbackVo));
        try {
            if (cubpOpenInfoCallbackVo == null) {
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }

            String backClientId = cubpOpenInfoCallbackVo.getClientId();
            Integer userId = null;

            CustomOpenInfo localOpenInfo = customOpenInfoMapper.selectOneByTradeAccount(backClientId);

            // 未注册
            if (localOpenInfo == null) {
                CustomInfo userInfo = new CustomInfo();
                userInfo.setCreateTime(new Date());
                userInfo.setUpdateTime(new Date());
                customInfoMapper.insertSelective(userInfo);
                userId = userInfo.getId();
            }
            // 已注册
            else {
                userId = localOpenInfo.getId();
            }

            if (userId != null) {
                // 生成开户表信息
                CustomOpenInfo openInfo = new CustomOpenInfo();
                openInfo.setUserId(userId);
                openInfo.setOpenType(CustomOpenAccountEnum.OpenType.OFFLINE.getCode());
                openInfo.setStatus(CustomOpenAccountEnum.OpenStatus.SUCCESS.getCode());
                openInfo.setIsPushed(true);
                openInfo.setIsNoticed(false);
                localOpenInfo.setFailReason("");
                openInfo.setCreateTime(new Date());
                openInfo.setUpdateTime(new Date());
                if (StringUtils.isNotEmpty(cubpOpenInfoCallbackVo.getOpenDate())) {
                    Date openDate = DateUtils.stringToDate(cubpOpenInfoCallbackVo.getOpenDate(), DateUtils.TimeFormatter.YYYY_MM_DD_HH_MM_SS);
                    localOpenInfo.setOpenDate(openDate);
                }
                customOpenInfoMapper.insertSelective(openInfo);
            }

            return userId;

        } catch (InternalApiException e) {
            log.error("开户结果回调异常", e);
            throw new InternalApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            log.error("开户结果回调异常", e);
            throw new InternalApiException(StaticType.CodeType.ERROR_INTERNAL, StaticType.MessageResource.ERROR_INTERNAL);
        }
    }

}
