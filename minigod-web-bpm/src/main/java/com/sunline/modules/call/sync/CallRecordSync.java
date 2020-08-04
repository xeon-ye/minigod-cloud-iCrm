package com.sunline.modules.call.sync;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.call.entity.CallRecordEntity;
import com.sunline.modules.call.protocol.request.CallRecordRequest;
import com.sunline.modules.call.protocol.response.CallRecordResponse;
import com.sunline.modules.call.service.CallRecordService;
import com.sunline.modules.common.utils.FileOperaterUtil;
import com.sunline.modules.common.utils.ProtocolUtils;
import com.sunline.modules.common.utils.SpringBeanLoader;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.user.entity.UserCertEntity;
import com.sunline.modules.user.service.UserCertService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.Date;

/**
 * @description: 通话记录数据同步
 * @author: Larry Lai
 * @date: 2019/3/4 17:12
 * @version: v1.0
 */

public class CallRecordSync {

    private static Log logger = LogFactory.getLog(CallRecordSync.class);

    /**
     * 用户中心帐户名
     */
    private static final String ACCOUNT = "N00000037188";

    /**
     * API密码
     */
    private static final String SECRET = "f44900d0-3a3a-11e9-b9ea-3da3f718cfed";

    /**
     * 服务器地址
     */
    private static final String HOST = "http://apis.7moor.com";

    private ApplicationContext applicationContext = SpringBeanLoader.getApplicationContext();

    private CallRecordService callRecordService = applicationContext.getBean(CallRecordService.class);
    private UserCertService userCertService = applicationContext.getBean(UserCertService.class);

    /**
     * 通话记录数据同步
     *
     * @param request
     */
    public void syncData(CallRecordRequest request) {

        String time = DateUtil.format(new Date(), "yyyyMMddHHmmss");
        String sig = md5(ACCOUNT + SECRET + time);
        // 查询坐席状态接口
        String interfacePath = "/v20170704/cdr/getCCCdr/";
        String url = HOST + interfacePath + ACCOUNT + "?sig=" + sig;
        String auth = base64(ACCOUNT + ":" + time);

        HttpClientBuilder builder = HttpClientBuilder.create();
        CloseableHttpClient client = builder.build();
        HttpPost post = new HttpPost(url);
        post.addHeader("Accept", "application/json");
        post.addHeader("Content-Type", "application/json;charset=utf-8");
        post.addHeader("Authorization", auth);
        StringEntity requestEntity = null;

        // 封装参数
        requestEntity = new StringEntity(JSON.toJSONString(request), "UTF-8");
        post.setEntity(requestEntity);
        CloseableHttpResponse response = null;

        try {
            response = client.execute(post);
            HttpEntity entity = response.getEntity();

            String result = EntityUtils.toString(entity, "utf8");

            CallRecordResponse callRecordResponse = JSON.parseObject(result, CallRecordResponse.class);

            if (callRecordResponse.getSuccess()) {

                // 写入数据库
                for (CallRecordResponse.CallRecordData data : callRecordResponse.getData()) {

                    // 本地存储录音文件
                    CallRecordEntity callRecordEntity = new CallRecordEntity();

                    if (null != data.getRECORD_FILE_NAME() && "dealing".equals(data.getSTATUS())) {

                        // 防止503错误
                        Thread.sleep(1000);

                        String fileUrl = data.getFILE_SERVER() + "/" + data.getRECORD_FILE_NAME();

                        String fileStoragePath = ConfigUtils.get("call.file.path") + DateUtil.format(DateUtil.yesterday(), "yyyyMMdd") + "/";

                        String fileName = Utils.uuid();

                        String fileSuffixName = FileOperaterUtil.getFileExtendName(fileUrl);

                        FileOperaterUtil.downloadFileByUrl(fileUrl, fileStoragePath, fileName);

                        callRecordEntity.setLocalFilePath(fileStoragePath + fileName + "." + fileSuffixName);
                    }

                    // 获取手机号码对应的用户资料
                    UserCertEntity userCertEntity = new UserCertEntity();
                    UserCertEntity userCertInfo=new UserCertEntity();
                    if ("normal".equals(data.getCONNECT_TYPE())) {
                        userCertEntity.setCertCode(ProtocolUtils.getEncryptPhone(data.getCALL_NO()));
                        userCertInfo=userCertService.queryObject(userCertEntity);
                    }

                    if ("dialout".equals(data.getCONNECT_TYPE())) {
                        userCertEntity.setCertCode(ProtocolUtils.getEncryptPhone(data.getCALLED_NO()));
                        userCertInfo=userCertService.queryObject(userCertEntity);
                    }


                    if (null != userCertInfo) {
                        callRecordEntity.setUserId(userCertInfo.getUserId());
                        callRecordEntity.setRelationState(1);
                    }else {
                        callRecordEntity.setRelationState(-1);
                    }

                    callRecordEntity.setCallSheetId(data.getCALL_SHEET_ID());
                    callRecordEntity.setCallNo(data.getCALL_NO());
                    callRecordEntity.setCalledNo(data.getCALLED_NO());
                    callRecordEntity.setCallId(data.getCALL_ID());
                    callRecordEntity.setBeginTime(data.getBEGIN_TIME());
                    callRecordEntity.setEndTime(data.getEND_TIME());
                    callRecordEntity.setConnectType(data.getCONNECT_TYPE());
                    callRecordEntity.setStatus(data.getSTATUS());
                    callRecordEntity.setExten(data.getEXTEN());
                    callRecordEntity.setDisposalAgent(data.getDISPOSAL_AGENT());
                    callRecordEntity.setOfferingTime(data.getOFFERING_TIME());
                    callRecordEntity.setRecordFileName(data.getRECORD_FILE_NAME());
                    callRecordEntity.setCustomerName(data.getCUSTOMER_NAME());
                    callRecordEntity.setRefCallSheetId(data.getREF_CALL_SHEET_ID());
                    callRecordEntity.setPbx(data.getPBX());
                    callRecordEntity.setQueueName(data.getQUEUE_NAME());
                    callRecordEntity.setFileServer(data.getFILE_SERVER());
                    callRecordEntity.setProvince(data.getPROVINCE());
                    callRecordEntity.setDistrict(data.getDISTRICT());
                    callRecordEntity.setDisposalAgent(data.getDISPOSAL_AGENT());
                    callRecordEntity.setKeyTag(data.getKEY_TAG());
                    callRecordEntity.setCallTimeLength(String.valueOf(data.getCALL_TIME_LENGTH()));
                    callRecordEntity.setInvestigate(data.getINVESTIGATE());
                    callRecordEntity.setActionId(data.getACTION_ID());
                    callRecordEntity.setCreateTime(new Date());
                    callRecordEntity.setUpdateTime(new Date());

                    callRecordService.save(callRecordEntity);
                }

            } else {
                logger.error("查询通话记录接口调用异常：" + callRecordResponse.getMessage());
            }


        } catch (Exception e) {
            logger.error("通话记录数据同步异常", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("关闭流异常", e);
                }
            }
        }
    }

    private static String md5(String text) {
        return DigestUtils.md5Hex(text).toUpperCase();
    }

    private static String base64(String text) {
        byte[] bytes = text.getBytes();
        Base64 base64 = new Base64();
        bytes = base64.encode(bytes);
        return new String(bytes);
    }
}
