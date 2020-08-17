package com.minigod.account.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.minigod.account.helper.FileStorageHelper;
import com.minigod.account.service.VerifyJFSzcaService;
import com.minigod.account.utils.JFSzcaHttpClient;
import com.minigod.account.utils.SzcaHttpClient;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.security.PKCSUtil;
import com.minigod.common.utils.ImageUtils;
import com.minigod.common.verify.utils.VerifyUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.VerifyAuthCaMapper;
import com.minigod.persist.account.mapper.VerifyBankCardMapper;
import com.minigod.protocol.account.bpm.request.BpmOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.model.VerifyBankCard;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.jfrequest.*;
import com.minigod.protocol.account.szca.jfresponse.JFSzcaLoginResVo;
import com.minigod.protocol.account.szca.request.SzcaPdfInfoForSignLocationsVo;
import com.minigod.protocol.account.szca.response.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.testng.collections.Lists;

import javax.annotation.PostConstruct;
import java.security.KeyPair;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class VerifyJFSzcaServiceImpl extends BaseBeanFactory implements VerifyJFSzcaService {

    @Autowired
    VerifyAuthCaMapper verifyAuthCaMapper;
    @Autowired
    FileStorageHelper fileStorageHelper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;

    private final KeyPair kp = PKCSUtil.generageKeyPair();

    @Value("${minigod.jfszca.userName}")
    private String JF_JFSZCA_USER_NAME;

    @Value("${minigod.jfszca.userPwd}")
    private String JF_JFSZCA_USER_PWD;

    @Value("${minigod.jfszca.url}")
    private String JF_JFSZCA_API_URL;

    @Value("${minigod.jfszca.login}")
    private String API_LOGIN;

    @Value("${minigod.jfszca.getToken}")
    private String API_GET_TOKEN;

    @Value("${minigod.jfszca.getCert}")
    private String API_GET_CERT;

    @Value("${minigod.jfszca.getCertApplyP10}")
    private String API_GET_CERT_APPLY_P10;

    @Value("${minigod.jfszca.getSignP7ForPdf}")
    private String API_GET_SIGN_P7_FOR_PDF;

    @Value("${minigod.jfszca.getPDFInfoForSign}")
    private String API_GET_PDF_INFO_FOR_SIGN;


    private String URL_LOGIN = "";
    private String URL_GET_TOKEN = "";
    private String URL_GET_CERT = "";
    private String URL_GET_CERT_APPLY_P10 = "";
    private String URL_GET_SIGN_P7_FOR_PDF = "";
    private String URL_GET_PDF_INFO_FOR_SIGN = "";

    @PostConstruct
    private void init() {
        URL_LOGIN = JF_JFSZCA_API_URL + API_LOGIN;
        URL_GET_TOKEN = JF_JFSZCA_API_URL + API_GET_TOKEN;
        URL_GET_CERT = JF_JFSZCA_API_URL + API_GET_CERT;
        URL_GET_CERT_APPLY_P10 = JF_JFSZCA_API_URL + API_GET_CERT_APPLY_P10;
        URL_GET_SIGN_P7_FOR_PDF = JF_JFSZCA_API_URL + API_GET_SIGN_P7_FOR_PDF;
        URL_GET_PDF_INFO_FOR_SIGN = JF_JFSZCA_API_URL + API_GET_PDF_INFO_FOR_SIGN;
    }

    @Override
    public VerifySzcaPojo login() {
        JFSzcaLoginReqVo reqVo = new JFSzcaLoginReqVo();

        reqVo.setUserAccount(JF_JFSZCA_USER_NAME);
        reqVo.setUserPwd(JF_JFSZCA_USER_PWD);

        JFSzcaLoginResVo jfSzcaLoginResVo = JFSzcaHttpClient.getResult(URL_LOGIN, reqVo, JFSzcaLoginResVo.class);
        VerifySzcaPojo resVo = new VerifySzcaPojo();

        if (StringUtils.isNotEmpty(jfSzcaLoginResVo.getUtoken())) {
            resVo.setUtoken(jfSzcaLoginResVo.getUtoken());
        }

        return resVo;
    }

    @Override
    public VerifySzcaPojo getTokenBySzca(VerifySzcaPojo verifySzcaPojo) {
        // 参数校验
        if (verifySzcaPojo == null || StringUtils.isEmpty(verifySzcaPojo.getUtoken())) {
            log.error("JFSZCA_获取操作标示参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        JFSzcaTokenReqVo reqVo = new JFSzcaTokenReqVo();
        reqVo.setUtoken(verifySzcaPojo.getUtoken());
        SzcaTokenResVo szcaTokenResVo = JFSzcaHttpClient.getResultWrap(URL_GET_TOKEN, reqVo, SzcaTokenResVo.class);

        // CA 已经存在用户认证信息
        if (szcaTokenResVo.getRetCode().equals("0")) {
            verifySzcaPojo.setToken(szcaTokenResVo.getToken());
        }

        return verifySzcaPojo;
    }

    @Override
    public VerifySzcaPojo getCertDnBySzca(VerifySzcaPojo verifySzcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (verifySzcaPojo == null || customOpenInfo == null) {
            log.error("JFSZCA_获取主题参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }
        String utoken = verifySzcaPojo.getUtoken();
        String token = verifySzcaPojo.getToken();


        JFSzcaCertDnReqVo reqVo = new JFSzcaCertDnReqVo();

        BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

        String idCard = openInfo.getIdNo();
        String userName = openInfo.getClientName();

        // 参数校验
        if (StringUtils.isEmpty(utoken) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || !VerifyUtil.isIDNo(idCard)) {
            log.error("JFSZCA_获取主题参数错误， verifySzcaPojo = {}", verifySzcaPojo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        reqVo.setType("query");
        reqVo.setCarrier("0");
        reqVo.setUtoken(utoken);
        reqVo.setToken(token);
        reqVo.setIdNo(idCard);
        reqVo.setUserName(userName);

        // 本地记录未校验，进行SZCA远程校验
        SzcaCertDnResVo szcaCertDnResVo = JFSzcaHttpClient.getResultWrap(URL_GET_CERT, reqVo, SzcaCertDnResVo.class);

        if (szcaCertDnResVo.getRetCode().equals("0")) {
            String resState = szcaCertDnResVo.getState();
            String resCertDn = szcaCertDnResVo.getCertDN();
            String resCertSn = szcaCertDnResVo.getCertSn();

            verifySzcaPojo.setCertDn(resCertDn);
            // CA 已经存在用户认证信息
            if (resState.equals("loseCert") && StringUtils.isNotEmpty(resCertSn)) {
                verifySzcaPojo.setApplyType("loseCert");
                verifySzcaPojo.setCertSn(resCertSn);
                verifySzcaPojo.setStatus(VerifyAuthCaStatusEnum.CA_P10.getCode());
            } else {
                verifySzcaPojo.setApplyType("apply");
                verifySzcaPojo.setStatus(VerifyAuthCaStatusEnum.UN_START.getCode());
            }
        } else {
            VerifyAuthCa localAuthCa = new VerifyAuthCa();
            localAuthCa.setIdCard(idCard);
            localAuthCa.setUserName(userName);
            localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_KNOW.getCode());
            localAuthCa.setCreateTime(new Date());
            localAuthCa.setUpdateTime(new Date());

            verifyAuthCaMapper.insertSelective(localAuthCa);
        }

        return verifySzcaPojo;
    }

    @Override
    public VerifySzcaPojo getCertApplyP10BySzca(VerifySzcaPojo verifySzcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (verifySzcaPojo == null || customOpenInfo == null) {
            log.error("JFSZCA_申请证书参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String certDn = verifySzcaPojo.getCertDn();
        String utoken = verifySzcaPojo.getUtoken();
        String token = verifySzcaPojo.getToken();
        String applyType = verifySzcaPojo.getApplyType();


        BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

        String idCard = openInfo.getIdNo();
        String userName = openInfo.getClientName();

        // 参数校验
        if (StringUtils.isEmpty(utoken) || StringUtils.isEmpty(token) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(userName) || StringUtils.isEmpty(certDn) || !VerifyUtil.isIDNo(idCard)) {
            log.error("JFSZCA_申请证书参数错误， verifySzcaPojo = {}", verifySzcaPojo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        if (StringUtils.isEmpty(applyType)) {
            applyType = "apply";
        }

        JFSzcaCertApplyP10ReqVo reqVo = new JFSzcaCertApplyP10ReqVo();

        // 获取开户图片
        List<CustomOpenCnImg> customOpenImgs = customOpenCnImgMapper.selectByUserId(customOpenInfo.getUserId());
        List<VerifyBankCard> verifyBankCards = verifyBankCardMapper.selectByBankCardAndStatus(openInfo.getBankNo(), 1);

        if (verifyBankCards.size() == 1) {
            reqVo.setCard(verifyBankCards.get(0).getBankCard());
            reqVo.setMobileNo(verifyBankCards.get(0).getPhone());
        } else {
            reqVo.setCard(openInfo.getBankNo());
            reqVo.setMobileNo(openInfo.getPhoneNumber());
        }

        reqVo.setUtoken(utoken);
        reqVo.setCarrier("0");
        reqVo.setAppType(applyType);
        reqVo.setToken(token);
        reqVo.setCertDn(certDn);
        reqVo.setProvince(SzcaHttpClient.parseCertDN(certDn, "ST"));
        reqVo.setCity(SzcaHttpClient.parseCertDN(certDn, "L"));
        reqVo.setIdNo(openInfo.getIdNo());
        // 性别[0=男 1=女 2=其它]
        reqVo.setSex(openInfo.getSex() == 0 ? "男" : "女");
//            reqVo.setMobileNo(openInfo.getPhoneNumber());
        reqVo.setUserName(openInfo.getClientName());
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
                    throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NONE_DATA);
                }
                String imgBase = ImageUtils.loadImgBase64ByUrl(imgUrl);

                if (StringUtils.isEmpty(imgBase)) {
                    // 图片解析错误
                    throw new InternalApiException(StaticType.CodeType.NONE_DATA, StaticType.MessageResource.NONE_DATA);
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
        String p10Code = PKCSUtil.genereatePkcs10(kp, certDn);

        reqVo.setCertP10(p10Code);


        SzcaCertApplyP10ResVo szcaCertApplyP10ResVo = JFSzcaHttpClient.getResultWrap(URL_GET_CERT_APPLY_P10, reqVo, SzcaCertApplyP10ResVo.class);

        if (szcaCertApplyP10ResVo.getRetCode().equals("0")) {
            verifySzcaPojo.setCertSn(szcaCertApplyP10ResVo.getCertSn());
            verifySzcaPojo.setStatus(VerifyAuthCaStatusEnum.CA_P10.getCode());
        } else {
            VerifyAuthCa localAuthCa = new VerifyAuthCa();
            localAuthCa.setIdCard(idCard);
            localAuthCa.setUserName(userName);
            localAuthCa.setCertSn(szcaCertApplyP10ResVo.getCertSn());
            localAuthCa.setStatus(VerifyAuthCaStatusEnum.UN_START.getCode());
            localAuthCa.setCreateTime(new Date());
            localAuthCa.setUpdateTime(new Date());

            verifyAuthCaMapper.insertSelective(localAuthCa);
        }


        return verifySzcaPojo;
    }


    @Override
    public VerifySzcaPojo getPdfInfoForSignBySzca(VerifySzcaPojo verifySzcaPojo, CustomOpenInfo customOpenInfo) {

        // 参数校验
        if (verifySzcaPojo == null || customOpenInfo == null) {
            log.error("JFSZCA_针对 PDF 文件生成签名域参数错误");
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        String certSn = verifySzcaPojo.getCertSn();
        String certDn = verifySzcaPojo.getCertDn();
        String utoken = verifySzcaPojo.getUtoken();

        BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

        String idCard = openInfo.getIdNo();
        String userName = openInfo.getClientName();


        // 参数校验
        if (StringUtils.isEmpty(idCard) || StringUtils.isEmpty(certDn) || StringUtils.isEmpty(certSn) || !VerifyUtil.isIDNo(idCard) || StringUtils.isEmpty(utoken)) {
            log.error("JFSZCA_针对 PDF 文件生成签名域错误：verifySzcaPojo = {}", verifySzcaPojo);
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }


        JFSzcaPdfInfoForSignReqVo szcaPdfInfoForSignReqVo = new JFSzcaPdfInfoForSignReqVo();

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

        SzcaPdfInfoForSignResVo szcaPdfInfoForSignResVo = JFSzcaHttpClient.getResultWrap(URL_GET_PDF_INFO_FOR_SIGN, szcaPdfInfoForSignReqVo, SzcaPdfInfoForSignResVo.class);

//                if (szcaPdfInfoForSignResVo.getRetCode().equals("0")) {
        if (szcaPdfInfoForSignResVo != null) {
            verifySzcaPojo.setFileHash(szcaPdfInfoForSignResVo.getFileHash());
            verifySzcaPojo.setFileId(szcaPdfInfoForSignResVo.getFileID());
            verifySzcaPojo.setStatus(VerifyAuthCaStatusEnum.CA_SIGN.getCode());
        } else {
            VerifyAuthCa localAuthCa = new VerifyAuthCa();
            localAuthCa.setIdCard(idCard);
            localAuthCa.setUserName(userName);
            localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_P10.getCode());
            localAuthCa.setCertSn(certSn);
            localAuthCa.setCertDn(certDn);
            localAuthCa.setCreateTime(new Date());
            localAuthCa.setUpdateTime(new Date());

            verifyAuthCaMapper.insertSelective(localAuthCa);

        }
        return verifySzcaPojo;

    }

    @Override
    public VerifySzcaPojo getSignP7ForPdfBySzca(VerifySzcaPojo verifySzcaPojo, CustomOpenInfo customOpenInfo) {
        // 参数校验
        if (verifySzcaPojo == null || customOpenInfo == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }
        String utoken = verifySzcaPojo.getUtoken();
        String certDn = verifySzcaPojo.getCertDn();
        String certSn = verifySzcaPojo.getCertSn();
        String fileId = verifySzcaPojo.getFileId();
        String fileHash = verifySzcaPojo.getFileHash();

        BpmOpenAccountAppointmentReqVo openInfo = JSONObject.parseObject(customOpenInfo.getFormData(), BpmOpenAccountAppointmentReqVo.class);

        String idCard = openInfo.getIdNo();
        String userName = openInfo.getClientName();

        // 参数校验
        if (StringUtils.isEmpty(utoken) || StringUtils.isEmpty(certDn) || StringUtils.isEmpty(fileId) || StringUtils.isEmpty(fileHash) || StringUtils.isEmpty(certSn)) {
            log.error("JFSZCA_合成pdv参数错误， verifySzcaPojo = {}", verifySzcaPojo);
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
        String p1Code = PKCSUtil.genereatePkcs1(kp, fileHash);

        reqVo.setP1SignData(p1Code);


        SzcaSignP7ForPdfResVo szcaSignP7ForPdfResVo = JFSzcaHttpClient.getResultWrap(URL_GET_SIGN_P7_FOR_PDF, reqVo, SzcaSignP7ForPdfResVo.class);

        VerifyAuthCa localAuthCa = new VerifyAuthCa();
        localAuthCa.setCreateTime(new Date());
        localAuthCa.setUpdateTime(new Date());
        localAuthCa.setIdCard(idCard);
        localAuthCa.setUserName(userName);

        if (szcaSignP7ForPdfResVo.getRetCode().equals("0")) {
            // 上传文件
            String fileName = fileId + "_" + System.currentTimeMillis() + ".pdf";
            String fileUrl = fileStorageHelper.uploadPdf(fileName, szcaSignP7ForPdfResVo.getFile());

            localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_P7_PDF.getCode());
            localAuthCa.setFilePdfUrl(fileUrl);
            verifyAuthCaMapper.insertSelective(localAuthCa);

            verifySzcaPojo.setStatus(VerifyAuthCaStatusEnum.CA_P7_PDF.getCode());
            verifySzcaPojo.setFileUrl(fileUrl);
            verifySzcaPojo.setId(localAuthCa.getId());
        } else {
            localAuthCa.setStatus(VerifyAuthCaStatusEnum.CA_SIGN.getCode());
            verifyAuthCaMapper.insertSelective(localAuthCa);
        }

        return verifySzcaPojo;
    }

}
