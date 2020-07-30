package com.minigod.account.service;

import com.minigod.protocol.account.model.VerifyAuthCa;
import com.minigod.protocol.account.pojo.VerifySzcaPojo;
import com.minigod.protocol.account.szca.jfrequest.*;
//import org.springframework.cloud.netflix.feign.FeignClient;

import java.io.InputStream;

//@FeignClient(value = "minigod-account-service")
public interface VerifyJFSzcaService {
    // 授权登录
    public VerifySzcaPojo login();

    // 获取操作标示（SZCA）
    public VerifySzcaPojo getTokenBySzca(VerifySzcaPojo reqVo);

    // 获取证书主题
    public VerifyAuthCa getCertDnBySzca(JFSzcaCertDnReqVo reqVo);

    // 申请证书
    public VerifyAuthCa getCertApplyP10BySzca(JFSzcaCertApplyP10ReqVo reqVo);

    // 备案记录合成生成PDF
    public VerifyAuthCa getSignP7ForPdfBySzca(JFSzcaSignP7ForPdfReqVo reqVo);

    // 针对 PDF 文件生成签名域接口-推送 pdf
    public VerifyAuthCa getPdfInfoForSignBySzca(JFSzcaPdfInfoForSignReqVo reqVo);

    public void clearLocalVerifyCa(String idCard);

//    public SzcaSealPdfResVo getSealPdfBySzca(Integer userId);
}
