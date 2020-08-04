package com.sunline.modules.dbs.service;

import cn.hutool.http.HttpRequest;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.dbs.pgp.BCPGPDecryptor;
import com.sunline.modules.dbs.pgp.BCPGPEncryptor;
import com.sunline.modules.dbs.pgp.Decrypt;
import com.sunline.modules.dbs.pgp.Encrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbsCommManageService {
    private static final Logger logger = LoggerFactory.getLogger(DbsCommManageService.class);

    /**
     * 通用请求发送
     *
     * @param url 当前业务请求url
     * @Param request 请求信息
     * @Param keyId 业务请求keyId
     * @Param business 业务标识
     * @return
     */
    public static String send(String url, String request, String keyId, String business, String msgId) {
        String result = null;

        try {
            String reqUrl = ConfigUtils.get("dbs.request.url") + url;
            String hostname = ConfigUtils.get("dbs.request.hostname");
            String orgId = ConfigUtils.get("dbs.request.orgId");

            logger.info("DBS Interface Request Url：" + reqUrl);
            logger.info("DBS Interface Request Business：" + business+"，msgId："+msgId);
            logger.info("DBS Interface Request Info：" + request);

            //开始发送请求 (调试不同接口需要修改 accountUrl/KeyId)
            if(!business.equals("RefundAPI")){
                result = HttpRequest.post(reqUrl).
                        header("KeyId", keyId).
                        header("Host", hostname).
                        header("ORG_ID", orgId).
                        header("Accept", "application/json").
                        header("Content-Type", "application/json").
                        body(request).
                        execute().body();
            }else{
                result = HttpRequest.post(reqUrl).
                        header("KeyId", keyId).
                        header("Host", hostname).
                        header("ORG_ID", orgId).
                        header("X-DBS-KeyId", keyId).
                        header("X-DBS-ORG_ID", orgId).
                        header("Accept", "application/json").
                        header("Content-Type", "application/json").
                        body(request).
                        execute().body();
            }
            logger.info("BDS Interface Response Info：" + result);
            return result;

        } catch (Exception e) {
            logger.error("请求星展银行接口异常", e);
        }

        return null;
    }

    /**
     * 请求明文信息加密
     * @param inputStr 明文信息
     * @param business 请求业务
     * @param msgId 请求流水号
     * @return
     */
    public static String encrypt(String inputStr, String business, String msgId){
        try {
            logger.info("DBS Encrypt Before Business：" + business +"，msgId："+msgId+"，inputStr："+inputStr);
            String path = DbsCommManageService.class.getResource("/").getPath()+"pgp/";
            //DBS PGP public Key
            String publicKey =path+ ConfigUtils.get("dbs.pgp.pubKey");
            //Customer PGP private Key
            String privateKey = path+ ConfigUtils.get("dbs.pgp.secKey");
            //Customer PGP private Key if any
            String privayeKeyPassword = "";

            //Constructing PGP encryption and signed message
            Encrypt encrypt = new Encrypt();
            encrypt.setArmored(true);
            encrypt.setCheckIntegrity(true);
            encrypt.setPublicKeyFilePath(publicKey);
            encrypt.setSigning(true);
            encrypt.setPrivateKeyFilePath(privateKey);
            encrypt.setPrivateKeyPassword(privayeKeyPassword);
            BCPGPEncryptor bcpgpEnryptor = new BCPGPEncryptor(encrypt);

            String encryptedMessage = bcpgpEnryptor.encryptMessage(inputStr);
            logger.info("DBS Encrypt After Business：" + business +"，msgId："+msgId+"，encryptedMessage："+encryptedMessage);
            return encryptedMessage;

        } catch (Exception e) {
            logger.error("当前业务："+business+"，msgId："+msgId+"，生成星展报文加密异常"+ e);
        }
        return null;
    }

    /**
     * 解密加密
     * @param response
     * @return
     */
    public static String decrypt(String response, String business, String msgId){
        try {
            String path = DbsCommManageService.class.getResource("/").getPath()+"pgp/";
            //DBS PGP public Key
            String publicKey =path+ ConfigUtils.get("dbs.pgp.pubKey");
            //Customer PGP private Key
            String privateKey = path+ ConfigUtils.get("dbs.pgp.secKey");
            //Customer PGP private Key if any
            String privayeKeyPassword = "";

            //Decrypting the api response using PGP decryption and verify
            Decrypt decrypt = new Decrypt();
            decrypt.setPublicKeyFilePath(publicKey);
            decrypt.setVerify(true);
            decrypt.setPrivateKeyFilePath(privateKey);
            decrypt.setPrivateKeyPassword(privayeKeyPassword);
            BCPGPDecryptor bcpgpDecryptor = new BCPGPDecryptor(decrypt);

            String decryptedMessage = bcpgpDecryptor.decryptMessage(response);
            logger.info("DBS Response Decrypt After Business：" + business +"，msgId："+msgId+"，decryptedMessage："+decryptedMessage);
            return decryptedMessage;
        } catch (Exception e) {
            logger.error("当前业务："+business+"，msgId："+msgId+"，星展响应报文解密异常"+ e);
        }
        return null;
    }

}
