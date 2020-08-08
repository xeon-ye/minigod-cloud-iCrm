package com.minigod.task.service.jobhandler.account;

import com.alibaba.fastjson.JSONObject;
import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.account.service.VerifySzcaService;
import com.minigod.account.utils.SzcaHttpClient;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.security.PKCSUtil;
import com.minigod.common.utils.ImageUtils;
import com.minigod.persist.account.mapper.*;
import com.minigod.protocol.account.bpm.request.BpmOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.*;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.request.*;
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
import org.testng.collections.Lists;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyPair;
import java.util.Date;
import java.util.List;


/**
 * 开户CA认证
 */
@JobHandler(value = "verifyBySZCAJobHandler")
@Component
@Slf4j
public class VerifyBySzcaJobHandler extends IJobHandler {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifySzcaService verifySzcaService;
    @Autowired
    OpenAccountOnlineService openAccountOnlineService;

    private final Integer CA_STATUS_NEED_VERIFY = CustomOpenAccountEnum.CaStatus.IS_NEED_VERIFY.getCode();
    private final KeyPair kp = PKCSUtil.generageKeyPair();


    @Value("${minigod.openAccount.isVerifyWithCa}")
    private Boolean IS_VERIFY_WITH_CA;


    private void getCertDnBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (szcaPojo == null || customOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }
        String token = szcaPojo.getToken();

        // 参数校验
        if (StringUtils.isEmpty(token)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        SzcaCertDnReqVo szcaCertDnReqVo = new SzcaCertDnReqVo();

        BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

        szcaCertDnReqVo.setToken(token);
        szcaCertDnReqVo.setIdNo(openInfo.getIdNo());
        szcaCertDnReqVo.setUserName(openInfo.getClientName());
        szcaCertDnReqVo.setType("query");
        szcaCertDnReqVo.setCarrier("0");

        VerifyAuthCa verifyAuthCa = verifySzcaService.getCertDnBySzca(szcaCertDnReqVo);
        if (verifyAuthCa != null) {
            szcaPojo.setStatus(verifyAuthCa.getStatus());
            szcaPojo.setCertDn(verifyAuthCa.getCertDn());
            szcaPojo.setCertSn(verifyAuthCa.getCertSn());
        }
    }

    private void getCertApplyP10BySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (szcaPojo == null || customOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String certDn = szcaPojo.getCertDn();
        String token = szcaPojo.getToken();

        // 参数校验
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(certDn)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        try {
            SzcaCertApplyP10ReqVo reqVo = new SzcaCertApplyP10ReqVo();
            BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

            // 获取开户图片
            List<CustomOpenCnImg> customOpenImgs = customOpenCnImgMapper.selectByUserId(customOpenInfo.getUserId());

            reqVo.setCarrier("0");
            reqVo.setAppType("loseCert");
            reqVo.setToken(token);
            reqVo.setCertDn(certDn);
            reqVo.setIdNo(openInfo.getIdNo());
            reqVo.setUserName(openInfo.getClientName());
            // 性别[0=男 1=女 2=其它]
            reqVo.setSex(openInfo.getSex() == 0 ? "男" : "女");
            reqVo.setMobileNo(openInfo.getPhoneNumber());
            reqVo.setCard(openInfo.getBankNo());
            reqVo.setProvince(SzcaHttpClient.parseCertDN(certDn, "ST"));
            reqVo.setCity(SzcaHttpClient.parseCertDN(certDn, "L"));
            reqVo.setContactAddr(openInfo.getIdCardAddress());
            reqVo.setCardedPlace(openInfo.getSigningOrganization());
            reqVo.setCardedExpiryDate(openInfo.getIdCardValidDateStart().replace("-", ".") + "-" + openInfo.getIdCardValidDateEnd().replace("-", "."));
            // TODO：图片数量校验？
            if (CollectionUtils.isNotEmpty(customOpenImgs)) {
                for (CustomOpenCnImg customOpenImg : customOpenImgs) {
                    int locationKey = Integer.parseInt(customOpenImg.getLocationKey());
                    int locationType = Integer.parseInt(customOpenImg.getLocationType());
                    String imgUrl = customOpenImg.getUrl();

                    if (StringUtils.isEmpty(imgUrl)) {
                        // 图片不存在
                        return;
                    }
                    String imgBase = ImageUtils.loadImgBase64ByUrl(imgUrl);

                    if (StringUtils.isEmpty(imgBase)) {
                        // 图片解析错误
                        return;
                    }

                    if (locationType == 101) {
                        reqVo.setIdentityImgTwo(imgBase);
                    }
                    if (locationType == 102) {
                        reqVo.setIdentityImgOne(imgBase);
                    }
                    if (locationKey == 5) {
                        reqVo.setHumanBodyImg(imgBase);
                    }
                    if (locationType == 301) {
                        reqVo.setSignImg(imgBase);
                    }
                }
            }

            // P10签名
            log.info(kp.getPublic().toString());
            String p10Code = PKCSUtil.genereatePkcs10(kp, certDn);

            reqVo.setCertP10(p10Code);


            VerifyAuthCa verifyAuthCa = verifySzcaService.getCertApplyP10BySzca(reqVo);
            if (verifyAuthCa != null) {
                szcaPojo.setStatus(verifyAuthCa.getStatus());
                szcaPojo.setCertSn(verifyAuthCa.getCertSn());
                szcaPojo.setCertDn(verifyAuthCa.getCertDn());
            }

        } catch (Exception e) {

        }
    }

    private void getSignP7ForPdfBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (szcaPojo == null || customOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String fileId = szcaPojo.getFileId();
        String fileHash = szcaPojo.getFileHash();
        String certSn = szcaPojo.getCertSn();
        String certDn = szcaPojo.getCertDn();

        // 参数校验
        if (StringUtils.isEmpty(fileId) || StringUtils.isEmpty(fileHash) || StringUtils.isEmpty(certSn) || StringUtils.isEmpty(certDn)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        SzcaSignP7ForPdfReqVo reqVo = new SzcaSignP7ForPdfReqVo();

        reqVo.setCertDn(certDn);
        reqVo.setCertSn(certSn);
        reqVo.setFileID(fileId);
        reqVo.setApplyType("pdf");
        reqVo.setIfTsa("0");

        // P1签名
//        KeyPair kp = PKCSUtil.generageKeyPair();
        log.info(kp.getPublic().toString());
        String p1Code = PKCSUtil.genereatePkcs1(kp, fileHash);

        reqVo.setP1SignData(p1Code);

        VerifyAuthCa verifyAuthCa = verifySzcaService.getSignP7ForPdfBySzca(reqVo);

        if (verifyAuthCa != null) {

            szcaPojo.setFileUrl(verifyAuthCa.getFilePdfUrl());
        }
    }

    private void getPdfInfoForSignBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (szcaPojo == null || customOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String certSn = szcaPojo.getCertSn();
        String certDn = szcaPojo.getCertDn();

        // 参数校验
        if (StringUtils.isEmpty(certDn) || StringUtils.isEmpty(certSn)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        try {
            SzcaPdfInfoForSignReqVo szcaPdfInfoForSignReqVo = new SzcaPdfInfoForSignReqVo();
            BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

            szcaPdfInfoForSignReqVo.setUserName(openInfo.getClientName());
            szcaPdfInfoForSignReqVo.setIdCode(openInfo.getIdNo());
            szcaPdfInfoForSignReqVo.setCertDn(certDn);
            szcaPdfInfoForSignReqVo.setCertSn(certSn);
            szcaPdfInfoForSignReqVo.setSignImg("");


            // 设置签名位置
            String signCoordinates = "3,60,206|4,60,206|6,60,206|7,60,206|9,60,206";
            String xDpi = "0";
            String yDpi = "0";

            String[] signCoordinateArray = signCoordinates.split("\\|");
            List<SzcaPdfInfoForSignLocationsVo> getPDFInfoForSignLocationList = Lists.newArrayList();
            for (String signCoordinate : signCoordinateArray) {
                String[] coordinateArray = signCoordinate.split(",");
                SzcaPdfInfoForSignLocationsVo szcaPdfInfoForSignLocationsVo = new SzcaPdfInfoForSignLocationsVo();
                szcaPdfInfoForSignLocationsVo.setPageNo(Integer.valueOf(coordinateArray[0]));
                szcaPdfInfoForSignLocationsVo.setX(Integer.valueOf(coordinateArray[1]));
                szcaPdfInfoForSignLocationsVo.setY(Integer.valueOf(coordinateArray[2]));
                getPDFInfoForSignLocationList.add(szcaPdfInfoForSignLocationsVo);
            }

            szcaPdfInfoForSignReqVo.setLocations(getPDFInfoForSignLocationList);


            szcaPdfInfoForSignReqVo.setXDpi(Integer.valueOf(xDpi));
            szcaPdfInfoForSignReqVo.setYDpi(Integer.valueOf(yDpi));

            URL url = new URL(customOpenInfo.getOpenAccountPdfUrl());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            int httpResult = conn.getResponseCode();
            if (httpResult != HttpURLConnection.HTTP_OK) {
                log.error("开户文件异常, url = {}", customOpenInfo.getOpenAccountPdfUrl());
                throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
            }
            InputStream inputStream = conn.getInputStream();

            VerifyAuthCa verifyAuthCa = verifySzcaService.getPdfInfoForSignBySzca(szcaPdfInfoForSignReqVo, inputStream);

            if (verifyAuthCa != null) {
                szcaPojo.setStatus(verifyAuthCa.getStatus());
                szcaPojo.setCertSn(verifyAuthCa.getCertSn());
                szcaPojo.setCertDn(verifyAuthCa.getCertDn());
                szcaPojo.setFileId(verifyAuthCa.getFileId());
                szcaPojo.setFileHash(verifyAuthCa.getFileHash());
            }
        } catch (Exception e) {

        }
    }


    //
//    /**
//     * 拉取服务器签署文件（SZCA）
//     */
//    public SzcaSealPdfResVo getSealPdfBySzca(Integer userId) {
//        SzcaSealPdfReqVo reqVo = new SzcaSealPdfReqVo();
//
//        SzcaSealPdfResVo resVo = szcaApiHelper.getSealPdf(reqVo);
//
//        if (resVo == null) {
//            log.error("拉取服务器签署文件异常");
//            // 优化提示语
//            throw new InternalApiException(StaticType.CodeType.BAD_REQUEST, StaticType.MessageResource.BAD_REQUEST);
//        }
//        return resVo;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        log.info("执行【开户CA认证】调度任务");

        //查询开户信息
        List<CustomOpenInfo> openInfoList = customOpenInfoMapper.selectByCaStatus(CA_STATUS_NEED_VERIFY);
        if (null == openInfoList || openInfoList.size() <= 0) {
            log.info("*********************【开户CA认证】为空**************************");
            return SUCCESS;
        }

        VerifySzcaPojo verifySzcaPojo = null;

        if (IS_VERIFY_WITH_CA) {
            // step1 获取token
            try {
                verifySzcaPojo = verifySzcaService.getTokenBySzca();
            } catch (Exception e) {
                log.error("*********************【开户CA认证】获取token异常**************************", e);
                return FAIL;
            }

            if (verifySzcaPojo == null || StringUtils.isEmpty(verifySzcaPojo.getToken())) {
                log.error("*********************【开户CA认证】获取token失败**************************");
                return FAIL;
            }
        }


        // TODO: CA认证多次失败逻辑处理

        for (CustomOpenInfo customOpenInfo : openInfoList) {
            Integer userId = customOpenInfo.getUserId();
            try {
                if (IS_VERIFY_WITH_CA) {

                    // step2 获取主题


                    getCertDnBySzca(verifySzcaPojo, customOpenInfo);
                    if (StringUtils.isEmpty(verifySzcaPojo.getCertDn())) {
                        log.error("*********************【开户CA认证】获取主题失败**************************, userId = {}", userId);
                        continue;
                    }

                    // step3 申请证书(先判断否已申请证书)
                    if (!VerifyAuthCaStatusEnum.isFlag(verifySzcaPojo.getStatus(), VerifyAuthCaStatusEnum.CA_P10) || StringUtils.isEmpty(verifySzcaPojo.getCertSn())) {
                        getCertApplyP10BySzca(verifySzcaPojo, customOpenInfo);
                    }

                    if (StringUtils.isEmpty(verifySzcaPojo.getCertSn())) {
                        log.error("*********************【开户CA认证】申请证书失败**************************, userId = {}", userId);
                        continue;
                    }

                    // step4 签名pdf文件
                    getPdfInfoForSignBySzca(verifySzcaPojo, customOpenInfo);

                    if (StringUtils.isEmpty(verifySzcaPojo.getFileId()) || StringUtils.isEmpty(verifySzcaPojo.getFileHash())) {
                        log.error("*********************【开户CA认证】签名pdf文件失败**************************, userId = {}", userId);
                        continue;
                    }

                    // step5 备案记录合成生成 PDF 接口
                    getSignP7ForPdfBySzca(verifySzcaPojo, customOpenInfo);
                    if (StringUtils.isEmpty(verifySzcaPojo.getFileUrl())) {
                        log.error("*********************【开户CA认证】备案记录合成生成PDF失败**************************, userId = {}", userId);
                        continue;
                    }
                }

                CustomOpenInfo localCustomOpenInfo = new CustomOpenInfo();

                // 更新用户数据
                localCustomOpenInfo.setId(customOpenInfo.getId());
                localCustomOpenInfo.setCaStatus(CustomOpenAccountEnum.CaStatus.IS_NEED_PUSH.getCode());
                localCustomOpenInfo.setUpdateTime(new Date());
                customOpenInfoMapper.updateByPrimaryKeySelective(localCustomOpenInfo);

            } catch (Exception e) {
                log.error("*********************【开户CA认证】异常**************************, userId = {}", userId);
                continue;
            }
        }

        log.info("完成【开户CA认证】调度任务");
        return SUCCESS;

    }
}
