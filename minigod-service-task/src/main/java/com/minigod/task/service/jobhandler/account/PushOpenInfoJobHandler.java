package com.minigod.task.service.jobhandler.account;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.minigod.common.pojo.response.ResResult;
import com.minigod.common.utils.HttpClientUtils;
import com.minigod.persist.account.mapper.CustomOpenCnImgMapper;
import com.minigod.persist.account.mapper.CustomOpenHkImgMapper;
import com.minigod.persist.account.mapper.CustomOpenInfoMapper;
import com.minigod.persist.account.mapper.VerifyBankCardMapper;
import com.minigod.protocol.account.cubp.vo.request.CubpOpenAccountAppointmentReqVo;
import com.minigod.protocol.account.cubp.vo.request.CubpOpenAccountBankVerityInfoReqVo;
import com.minigod.protocol.account.cubp.vo.request.CubpOpenAccountImageInfoReqVo;
import com.minigod.protocol.account.enums.CustomOpenAccountEnum;
import com.minigod.protocol.account.model.CustomOpenCnImg;
import com.minigod.protocol.account.model.CustomOpenHkImg;
import com.minigod.protocol.account.model.CustomOpenInfo;
import com.minigod.protocol.account.model.VerifyBankCard;
import com.minigod.task.ServiceTaskApplication;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 任务Handler示例（Bean模式）
 * <p>
 * 开发步骤：
 * 1、继承"IJobHandler"：“com.xxl.job.core.handler.IJobHandler”；
 * 2、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 3、注册到执行器工厂：添加“@JobHandler(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 4、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2015-12-19 19:43:36
 */
@JobHandler(value = "pushOpenInfoJobHandler")
@Component
@Slf4j
public class PushOpenInfoJobHandler extends IJobHandler {
    @Autowired
    CustomOpenInfoMapper customOpenInfoMapper;
    @Autowired
    CustomOpenCnImgMapper customOpenCnImgMapper;
    @Autowired
    CustomOpenHkImgMapper customOpenHkImgMapper;
    @Autowired
    VerifyBankCardMapper verifyBankCardMapper;

    @Value("${minigod.cubp.url}")
    private String CUBP_API_URL;

    @Value("${minigod.openAccount.isVerifyOpenData}")
    private Boolean IS_VERIFY_OPEN_DATA;

    @Value("${minigod.openAccount.images.h5.type}")
    private String H5_OPEN_IMG_TYPE;

    @Value("${minigod.openAccount.images.h5.count}")
    private Integer H5_OPEN_IMG_COUNT;

    @Value("${minigod.openAccount.images.app.type}")
    private String APP_OPEN_IMG_TYPE;

    @Value("${minigod.openAccount.images.app.count}")
    private Integer APP_OPEN_IMG_COUNT;

    private static final String split = " | ";


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnT<String> execute(String param) throws Exception {
        log.info("执行开户信息调度任务");

        //查询开户信息
        List<CustomOpenInfo> openUserInfos = customOpenInfoMapper.selectByIsNeedPush(true);
        if (null == openUserInfos || openUserInfos.size() <= 0) {
            log.info("*********************开户信息为空**************************");
            return FAIL;
        }

        //调用cubp开户接口
        String server = CUBP_API_URL + "/proxy/customer/accountOpenApplication";
        String errMsg = "";

        for (CustomOpenInfo openUserInfo : openUserInfos) {
            Integer openStatus = openUserInfo.getStatus();
            String idCard = openUserInfo.getIdCard();
            String bankCard = openUserInfo.getBankCard();

            // 非开户中的跳出循环
            if (openStatus == null || !openStatus.equals(CustomOpenAccountEnum.OpenStatus.PENDING.getCode())) {
                continue;
            }

            // 同步错误次数过多
            if (openUserInfo.getPushErrCount() >= 3 && openUserInfo.getIsSend()) {
                log.info("用户号：" + openUserInfo.getId() + "  开户同步异常超过3次");
                continue;
            }

            Integer userId = openUserInfo.getId();
            CubpOpenAccountAppointmentReqVo obj = JSONObject.parseObject(openUserInfo.getInfo(), CubpOpenAccountAppointmentReqVo.class);
            obj.setOpenAccountAccessWay(openUserInfo.getAccessWay());
            obj.setApplicationTime(openUserInfo.getUpdateTime());

            List<CubpOpenAccountImageInfoReqVo> openAccountImageInfoProtocolList = Lists.newArrayList();

            Integer openType = openUserInfo.getOpenType(); // 开户方式：1、线上预约开户，2、线下（开户宝）3、香港预约开户
            boolean isRealImage = true;
            StringBuffer errorImages = new StringBuffer();

            if (openType.equals(CustomOpenAccountEnum.OpenType.ONLINE_CN.getCode())) {
                //查询用户图像
                String[] locationTypes = null;
                if (openUserInfo.getAccessWay() == CustomOpenAccountEnum.OpenAccessWay.H5.getCode()) {
                    locationTypes = H5_OPEN_IMG_TYPE.split(",");
                }
                if (openUserInfo.getAccessWay() == CustomOpenAccountEnum.OpenAccessWay.APP.getCode()) {
                    locationTypes = APP_OPEN_IMG_TYPE.split(",");
                }
                List<CustomOpenCnImg> customOpenImgs = customOpenCnImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);

                double confidence = 90;
                obj.setIdentitySimilarityPercent(confidence);
                obj.setIsPassIdentityAuthentication(1);

                // 图片数据处理
                if (CollectionUtils.isNotEmpty(customOpenImgs)) {
                    for (CustomOpenCnImg customOpenImg : customOpenImgs) {
                        // 检查图片
                        CubpOpenAccountImageInfoReqVo openAccountImageInfoProtocol = new CubpOpenAccountImageInfoReqVo();
                        int locationKey = Integer.parseInt(customOpenImg.getLocationKey());
                        int locationType = Integer.parseInt(customOpenImg.getLocationType());
                        String imgUrl = customOpenImg.getUrl();

//                        FileInputStream realImg = isRealImg(imgUrl, userId);
                        // 图片校验
//                        if (realImg == null) {
//                            isRealImage = false;
//                            // 记录错误图片
//                            errorImages.append(imgUrl).append(split);
//                        }
                        // TODO: 人证比对

                        openAccountImageInfoProtocol.setImageLocation(locationKey);
                        openAccountImageInfoProtocol.setImageLocationType(locationType);
                        openAccountImageInfoProtocol.setImageUrl(imgUrl);
                        openAccountImageInfoProtocolList.add(openAccountImageInfoProtocol);
                    }

                    if (!isRealImage) {
                        log.info(userId + "********************图片错误");
                        // 记录操作日志
                        errMsg = "图片错误 : " + errorImages;
                        saveErrorInfo(openUserInfo, errMsg, "");
                        continue;
                    }
                } else {
                    log.info(openUserInfo.getId() + "开户图片数据不完整");
                    errMsg = "开户图片数据不完整";
                    saveErrorInfo(openUserInfo, errMsg, "");
                    continue;
                }

                // 四要素认证信息
                List<CubpOpenAccountBankVerityInfoReqVo> openAccountBankVerityInfoProtocols = Lists.newArrayList();

                List<VerifyBankCard> verifyBankCards = verifyBankCardMapper.selectByIdCardAndIsValidTrue(idCard);
                if (CollectionUtils.isNotEmpty(verifyBankCards)) {
                    for (VerifyBankCard verifyBankCard : verifyBankCards) {
                        CubpOpenAccountBankVerityInfoReqVo openAccountBankVerityInfoProtocol = new CubpOpenAccountBankVerityInfoReqVo();
                        openAccountBankVerityInfoProtocol.setClientName(verifyBankCard.getUserName());
                        openAccountBankVerityInfoProtocol.setIdNo(verifyBankCard.getIdCard());
                        openAccountBankVerityInfoProtocol.setBankCard(verifyBankCard.getBankCard());
                        openAccountBankVerityInfoProtocol.setPhoneNumber(verifyBankCard.getPhone());
                        openAccountBankVerityInfoProtocol.setVerifyCount(verifyBankCard.getCheckCount());
                        openAccountBankVerityInfoProtocol.setVerifyStatus(1);
                        openAccountBankVerityInfoProtocol.setVerityTime(new Date());
                        openAccountBankVerityInfoProtocols.add(openAccountBankVerityInfoProtocol);
                    }
                    obj.setBankVerityInfo(openAccountBankVerityInfoProtocols);
                }
            } else if (openType.equals(CustomOpenAccountEnum.OpenType.ONLINE_HK.getCode())) {
                //查询用户图像
                String[] locationTypes = null;
                if (openUserInfo.getAccessWay() == CustomOpenAccountEnum.OpenAccessWay.H5.getCode()) {
                    locationTypes = H5_OPEN_IMG_TYPE.split(",");
                }
                if (openUserInfo.getAccessWay() == CustomOpenAccountEnum.OpenAccessWay.APP.getCode()) {
                    locationTypes = APP_OPEN_IMG_TYPE.split(",");
                }
                List<CustomOpenHkImg> customOpenImgs = customOpenHkImgMapper.selectByUserIdAndLocationKeyInAndLocationTypeIn(userId, null, locationTypes);

                double confidence = 90;
                obj.setIdentitySimilarityPercent(confidence);
                obj.setIsPassIdentityAuthentication(1);

                // 图片数据处理
                if (CollectionUtils.isNotEmpty(customOpenImgs)) {
                    for (CustomOpenHkImg customOpenImg : customOpenImgs) {
                        // 检查图片
                        CubpOpenAccountImageInfoReqVo openAccountImageInfoProtocol = new CubpOpenAccountImageInfoReqVo();
                        int locationKey = Integer.parseInt(customOpenImg.getLocationKey());
                        int locationType = Integer.parseInt(customOpenImg.getLocationType());
                        String imgUrl = customOpenImg.getUrl();

                        openAccountImageInfoProtocol.setImageLocation(locationKey);
                        openAccountImageInfoProtocol.setImageLocationType(locationType);
                        openAccountImageInfoProtocol.setImageUrl(imgUrl);
                        openAccountImageInfoProtocolList.add(openAccountImageInfoProtocol);
                    }

                    if (!isRealImage) {
                        log.info(userId + "********************图片错误");
                        // 记录操作日志
                        errMsg = "图片错误 : " + errorImages;
                        saveErrorInfo(openUserInfo, errMsg, "");
                        continue;
                    }
                } else {
                    log.info(openUserInfo.getId() + "开户图片数据不完整");
                    errMsg = "开户图片数据不完整";
                    saveErrorInfo(openUserInfo, errMsg, "");
                    continue;
                }


            }
            obj.setOpenAccountImagesInfo(openAccountImageInfoProtocolList);

            try {
                log.info("***************************************************************开户回调开始*************************************************");
                log.info(userId + "回调CUBP传入开户信息参数：" + JSONObject.toJSONString(obj));
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("params", obj);
                String result = HttpClientUtils.postJson(server, JSONObject.toJSONString(map), Charset.forName("UTF-8"), true);
                log.info("开户任务，CUBP返回结果：" + result);
                log.info("***************************************************************开户回调结束*************************************************");
                if (StringUtils.isNotBlank(result)) {
                    ResResult responseVO = JSONObject.parseObject(result, ResResult.class);
                    if (responseVO.getCode() == 0) {
                        String applicationId = JSONObject.parseObject(responseVO.getResult().toString()).get("applicationId").toString();
                        openUserInfo.setRemoteId(applicationId);
                        openUserInfo.setIsNeedPush(false);
                        customOpenInfoMapper.updateByPrimaryKeySelective(openUserInfo);
                        log.info("开户提交成功：: " + userId);
                    } else {
                        log.info("开户提交失败: " + userId + "," + responseVO.getMessage());
                        errMsg = responseVO.getMessage();
                        saveErrorInfo(openUserInfo, errMsg, result);
                    }

                } else {
                    log.info("连接服务器异常，CUBP返回结果为NULL！");
                    // 异常，记录操作日志
                    errMsg = "连接服务器异常，CUBP返回结果为NULL";
                    saveErrorInfo(openUserInfo, errMsg, result);
                }
            } catch (Exception e) {
                log.error("连接服务器异常！", e);
                // 异常，记录操作日志
                errMsg = "连接服务器异常";
                saveErrorInfo(openUserInfo, errMsg, "CUBP服务器异常");
            }
        }
        return SUCCESS;
    }

    private FileInputStream isRealImg(String imgUrl, Integer userId) throws IOException {
        FileInputStream fileInputStream = null;
        log.info("传送的图片：userId=" + userId + ",imgUrl=" + imgUrl);

        try {
            fileInputStream = new FileInputStream(imgUrl);
            return fileInputStream;
        } catch (FileNotFoundException e) {
            log.info(userId + "图片资源不存在！");
            return null;
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    private void saveErrorInfo(CustomOpenInfo customOpenInfo, String errorMsg, String body) {
        customOpenInfo.setUpdateTime(new Date());
        // 更新开户调度任务失败次数
        if (customOpenInfo.getPushErrCount() < 3) {
            customOpenInfo.setPushErrCount(customOpenInfo.getPushErrCount() + 1);
        } else {
            // 发送邮件
            if (!customOpenInfo.getIsSend()) {
                // 避免重复发送邮件，已发送邮件的不再发送
                String title = "用户账号：" + customOpenInfo.getId() + " 开户任务异常";
                errorMsg = errorMsg + "【" + body + "】";
                // TODO: 发送邮件通知
//                msgService.sendEmailCloud(sender, accept, title, errorMsg, null);
                customOpenInfo.setIsSend(true);
            }
        }
        customOpenInfoMapper.updateByPrimaryKeySelective(customOpenInfo);
    }

    public static void main(String[] args) {
        try {
            new PushOpenInfoJobHandler().execute(null);
        } catch (Exception e) {
            log.error("error = ", e);
        }
    }

}
