package com.minigod.task.service.jobhandler.account;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.account.service.VerifyService;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenHkImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.persist.account.mapper.VerifyAuthCaMapper;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountCaVerityInfoVo;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountCaVeritySnInfoVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 客户CA证书上传
 */
@JobHandler(value = "pushVerifiedAuthCaInfoJobHandler")
@Component
@Slf4j
public class PushVerifiedAuthCaInfoJobHandler extends IJobHandler {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyAuthCaMapper verifyAuthCaMapper;
    @Autowired
    VerifyService verifyService;
    @Autowired
    OpenAccountOnlineService openAccountOnlineService;

    @Value("${minigod.cubp.url}")
    private String CUBP_API_URL;
    @Value("${minigod.openAccount.isVerifyWithCa}")
    private Boolean IS_VERIFY_WITH_CA;

    private final Integer CA_STATUS_NEED_PUSH = CustomOpenAccountEnum.CaStatus.IS_NEED_PUSH.getCode();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        log.info("执行【客户CA证书上传】调度任务");

        //查询开户信息
        List<CustomOpenInfo> openInfoList = customOpenInfoMapper.selectByCaStatus(CA_STATUS_NEED_PUSH);
        if (null == openInfoList || openInfoList.size() <= 0) {
            log.info("*********************【客户CA证书上传】为空**************************");
            return SUCCESS;
        }

        String server = CUBP_API_URL + "/proxy/customer/accountOpenApplicationCallBack";

        for (CustomOpenInfo customOpenInfo : openInfoList) {
            Integer userId = customOpenInfo.getUserId();

            if (!customOpenInfo.getCaStatus().equals(CustomOpenAccountEnum.CaStatus.IS_NEED_PUSH.getCode())) {
                continue;
            }

            VerifyAuthCa verifyAuthCa = verifyAuthCaMapper.selectOneByIdCard(customOpenInfo.getIdCard());
            // 开启认证，且认证为空（标识未认证，数据异常）
            if (IS_VERIFY_WITH_CA && verifyAuthCa == null) {
                log.error("*********************【客户CA证书上传】CA认证数据为空**************************");
                // 重置开户状态
                customOpenInfo.setCaStatus(CustomOpenAccountEnum.CaStatus.IS_NEED_VERIFY.getCode());
                customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
                continue;
            }

            if (verifyAuthCa == null) {
                verifyAuthCa = new VerifyAuthCa();
            }

            String applicationId = customOpenInfo.getRemoteId();
            String caVerifyStatus = "-1";
            String caVerifyMsg = "";

            // 认证通过
            if (!IS_VERIFY_WITH_CA || VerifyAuthCaStatusEnum.isFlag(verifyAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P7_PDF)) {
                caVerifyStatus = "0";
                caVerifyMsg = "成功";
            }

            // TODO: CA接口多次失败逻辑处理？？？
            CubpOpenAccountCaVerityInfoVo openAccountCaVerityInfoVo = new CubpOpenAccountCaVerityInfoVo();
            openAccountCaVerityInfoVo.setApplicationId(applicationId);
            openAccountCaVerityInfoVo.setCaVerifyStatus(caVerifyStatus);
            openAccountCaVerityInfoVo.setCaVerifyMsg(caVerifyMsg);
            openAccountCaVerityInfoVo.setCaSignHashCode(verifyAuthCa.getFileHash());

            List<CubpOpenAccountCaVeritySnInfoVo> openAccountCaVeritySnInfoVoList = Lists.newArrayList();

            CubpOpenAccountCaVeritySnInfoVo openAccountCaVeritySnInfoVo = new CubpOpenAccountCaVeritySnInfoVo();
            openAccountCaVeritySnInfoVo.setCaCertDn(verifyAuthCa.getCertDn());
            openAccountCaVeritySnInfoVo.setCaCertSn(verifyAuthCa.getCertSn());
            openAccountCaVeritySnInfoVo.setCertTime(verifyAuthCa.getUpdateTime());
            openAccountCaVeritySnInfoVoList.add(openAccountCaVeritySnInfoVo);
            openAccountCaVerityInfoVo.setCaVerityInfoList(openAccountCaVeritySnInfoVoList);
            openAccountCaVerityInfoVo.setCaVerifyFileUrl(verifyAuthCa.getFilePdfUrl());

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("params", openAccountCaVerityInfoVo);

            try {
                log.info("*********************【客户CA证书上传】回调开始**************************, userId = {}", userId);
                log.info(userId + "【客户CA证书上传】回调传入数据：" + JSONObject.toJSONString(map));
                String result = HttpClientUtils.postJson(server, JSONObject.toJSONString(map), Charset.forName("UTF-8"), true);
                log.info(userId + "【客户CA证书上传】返回结果：" + result);
                log.info("*********************【客户CA证书上传】回调结束**************************, userId = {}", userId);

                if (StringUtils.isNotBlank(result)) {
                    ResResult responseVO = JSONObject.parseObject(result, ResResult.class);
                    if (responseVO.getCode() == 0) {
                        if (caVerifyStatus.equals("0")) {
                            customOpenInfo.setPendingType(CustomOpenAccountEnum.PendingStatusType.OPEN.getCode());
                        } else {
                            customOpenInfo.setPendingType(CustomOpenAccountEnum.PendingStatusType.DOING.getCode());
                        }
                        customOpenInfo.setCaStatus(CustomOpenAccountEnum.CaStatus.IS_PUSHED.getCode());
                        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
                        log.info("【预批客户上传BPM】上传成功：" + userId);
                    } else {
                        log.info("【预批客户上传BPM】上传失败：" + userId + "," + responseVO.getMessage());
                    }
                } else {
                    log.error("*********************【客户CA证书上传】连接服务器异常，BPM返回结果为NULL！**************************, userId = {}", userId);
                }
            } catch (Exception e) {
                log.error("*********************【客户CA证书上传】异常**************************, userId = {}", userId);
            }
        }
        log.info("完成【客户CA证书上传】调度任务");

        return SUCCESS;

    }
}
