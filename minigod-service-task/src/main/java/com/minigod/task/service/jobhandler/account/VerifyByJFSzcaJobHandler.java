package com.minigod.task.service.jobhandler.account;

import com.alibaba.fastjson.JSONObject;
import com.minigod.account.service.OpenAccountOnlineService;
import com.minigod.account.service.VerifyJFSzcaService;
import com.minigod.account.utils.SzcaHttpClient;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.security.PKCSUtil;
import com.minigod.common.utils.ImageUtils;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenHkImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.persist.account.mapper.VerifyBankCardMapper;
import com.minigod.protocol.account.cubp.request.CubpOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.model.VerifyBankCard;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.request.*;
import com.minigod.protocol.account.szca.jfrequest.*;
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
@JobHandler(value = "verifyByJFSZCAJobHandler")
@Component
@Slf4j
public class VerifyByJFSzcaJobHandler extends IJobHandler {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;
    @Autowired
    VerifyJFSzcaService verifySzcaService;
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
        String utoken = szcaPojo.getUtoken();
        String token = szcaPojo.getToken();

        // 参数校验
        if (StringUtils.isEmpty(utoken) || StringUtils.isEmpty(token)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        JFSzcaCertDnReqVo szcaCertDnReqVo = new JFSzcaCertDnReqVo();

        CubpOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormdata(), CubpOpenAccountAppointmentReqVo.class);

        szcaCertDnReqVo.setUtoken(utoken);
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
        String utoken = szcaPojo.getUtoken();
        String token = szcaPojo.getToken();

        // 参数校验
       /* if (StringUtils.isEmpty(utoken) || StringUtils.isEmpty(token) || StringUtils.isEmpty(certDn)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }*/


        try {
            JFSzcaCertApplyP10ReqVo reqVo = new JFSzcaCertApplyP10ReqVo();
            CubpOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormdata(), CubpOpenAccountAppointmentReqVo.class);

            // 获取开户图片
//            List<CustomOpenCnImg> customOpenImgs = customOpenCnImgMapper.selectByUserId(customOpenInfo.getUserId());
//            List<VerifyBankCard> verifyBankCards = verifyBankCardMapper.selectByBankCardAndStatus(openInfo.getBankNo(), 1);
//
//            if(verifyBankCards.size() == 1){
//                reqVo.setCard(verifyBankCards.get(0).getBankCard());
//                reqVo.setMobileNo(verifyBankCards.get(0).getPhone());
//            }
//
//            reqVo.setUtoken(utoken);
//            reqVo.setCarrier("0");
//            reqVo.setAppType("apply");
//            reqVo.setToken(token);
//            reqVo.setCertDn(certDn);
//            reqVo.setIdNo(openInfo.getIdNo());
//            reqVo.setUserName(openInfo.getClientName());
//            // 性别[0=男 1=女 2=其它]
//            reqVo.setSex(openInfo.getSex() == 0 ? "男" : "女");
////            reqVo.setMobileNo(openInfo.getPhoneNumber());
//            reqVo.setProvince(SzcaHttpClient.parseCertDN(certDn, "ST"));
//            reqVo.setCity(SzcaHttpClient.parseCertDN(certDn, "L"));
//            reqVo.setContactAddr(openInfo.getIdCardAddress());
//            reqVo.setCardedPlace(openInfo.getSigningOrganization());
//            reqVo.setCardedExpiryDate(openInfo.getIdCardValidDateStart().replace("-", ".") + "-" + openInfo.getIdCardValidDateEnd().replace("-", "."));
//            // TODO：图片数量校验？
//            if (CollectionUtils.isNowtEmpty(customOpenImgs)) {
//                for (CustomOpenCnImg customOpenImg : customOpenImgs) {
//                    int locationKey = Integer.parseInt(customOpenImg.getLocationKey());
//                    int locationType = Integer.parseInt(customOpenImg.getLocationType());
//                    String imgUrl = customOpenImg.getUrl();
//
//                    if (StringUtils.isEmpty(imgUrl)) {
//                        // 图片不存在
//                        return;
//                    }
//                    String imgBase = ImageUtils.loadImgBase64ByUrl(imgUrl);
//
//                    if (StringUtils.isEmpty(imgBase)) {
//                        // 图片解析错误
//                        return;
//                    }
//
//                    if (locationType == 101) {
//                        reqVo.setIdentityImgTwo(imgBase);
//                    }
//                    if (locationType == 102) {
//                        reqVo.setIdentityImgOne(imgBase);
//                    }
//                    if (locationKey == 5) {
//                        reqVo.setHumanBodyImg(imgBase);
//                    }
//                    if (locationType == 301) {
//                        reqVo.setSignImg(imgBase);
//                    }
//                }
//            }

            // P10签名
            log.info(kp.getPublic().toString());
            String p10Code = PKCSUtil.genereatePkcs10(kp, "CN=周祖盛,OU=430381200008280010,OU=1,O=0,L=湘潭市,ST=湖南省,C=CN");

            reqVo.setCertP10(p10Code);


            VerifyAuthCa verifyAuthCa = verifySzcaService.getCertApplyP10BySzca(reqVo);
            if (verifyAuthCa != null) {
                szcaPojo.setStatus(verifyAuthCa.getStatus());
                szcaPojo.setCertSn(verifyAuthCa.getCertSn());
                szcaPojo.setCertDn(verifyAuthCa.getCertDn());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSignP7ForPdfBySzca(VerifySzcaPojo szcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (szcaPojo == null || customOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }
        String utoken = szcaPojo.getUtoken();

        // 参数校验
        if (StringUtils.isEmpty(utoken)) {
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

        JFSzcaSignP7ForPdfReqVo reqVo = new JFSzcaSignP7ForPdfReqVo();

        reqVo.setUtoken(utoken);
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
        String utoken = szcaPojo.getUtoken();

        // 参数校验
        if (StringUtils.isEmpty(utoken) || StringUtils.isEmpty(certDn) || StringUtils.isEmpty(certSn)) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        try {
            JFSzcaPdfInfoForSignReqVo szcaPdfInfoForSignReqVo = new JFSzcaPdfInfoForSignReqVo();
            CubpOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormdata(), CubpOpenAccountAppointmentReqVo.class);

            szcaPdfInfoForSignReqVo.setUtoken(utoken);
            szcaPdfInfoForSignReqVo.setUserName(openInfo.getClientName());
            szcaPdfInfoForSignReqVo.setIdNo(openInfo.getIdNo());
            szcaPdfInfoForSignReqVo.setCertDn(certDn);
            szcaPdfInfoForSignReqVo.setCertSn(certSn);
            szcaPdfInfoForSignReqVo.setSignImg("");
            szcaPdfInfoForSignReqVo.setOpenAccountPdfUrl(customOpenInfo.getOpenAccountPdfUrl());


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

            VerifyAuthCa verifyAuthCa = verifySzcaService.getPdfInfoForSignBySzca(szcaPdfInfoForSignReqVo);

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
        String p10Code = PKCSUtil.genereatePkcs10(kp, "CN=周祖盛,OU=430381200008280010,OU=1,O=0,L=湘潭市,ST=湖南省,C=CN");

/*
        //查询开户信息
        List<CustomOpenInfo> openInfoList = customOpenInfoMapper.selectByCaStatus(CA_STATUS_NEED_VERIFY);
        if (null == openInfoList || openInfoList.size() <= 0) {
            log.info("*********************【开户CA认证】为空**************************");
            return SUCCESS;
        }

        VerifySzcaPojo verifySzcaPojo = null;

        if (IS_VERIFY_WITH_CA) {
            // step1 授权登录、获取token
            try {
                verifySzcaPojo = verifySzcaService.login();
                verifySzcaPojo = verifySzcaService.getTokenBySzca(verifySzcaPojo);
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
                    //getCertDnBySzca(verifySzcaPojo, customOpenInfo);
//                    if (StringUtils.isEmpty(verifySzcaPojo.getCertDn())) {
//                        log.error("*********************【开户CA认证】获取主题失败**************************, userId = {}", userId);
//                        continue;
//                    }

                    // step3 申请证书(先判断否已申请证书)
//                    if (!VerifyAuthCaStatusEnum.isFlag(verifySzcaPojo.getStatus(), VerifyAuthCaStatusEnum.CA_P10) || StringUtils.isEmpty(verifySzcaPojo.getCertSn())) {
                        getCertApplyP10BySzca(verifySzcaPojo, customOpenInfo);
//                    }

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

        log.info("完成【开户CA认证】调度任务");*/
        return SUCCESS;

    }
}
