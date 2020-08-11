package com.sunline.modules.api.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.entity.CustomerAccountOpenApplyEntity;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.entity.OpenAccountCaVerityInfoEntity;
import com.sunline.modules.account.online.helper.CustomerAccOpenReportGenerate;
import com.sunline.modules.account.online.helper.IdCardHelper;
import com.sunline.modules.account.online.protocol.AccountOpenApplyCallBackProtocol;
import com.sunline.modules.account.online.protocol.CaVerityInfoProtocol;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.OpenAccountCaVerityInfoService;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.service.ExtendActTasklogService;
import com.sunline.modules.api.dao.SecuritiesUserInfoDao;
import com.sunline.modules.api.entity.SecuritiesUserModel;
import com.sunline.modules.api.protocol.AccountOpenInfoProto;
import com.sunline.modules.api.protocol.CustomerAccOpenInfoProto;
import com.sunline.modules.api.protocol.SecuritiesUserInfoProto;
import com.sunline.modules.api.service.SecuritiesUserInfoService;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.PdfboxUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.notice.service.MessageSendInfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: BPM外部接口
 * @author: Larry Lai
 * @date: 2018/12/11 15:49
 * @version: v1.0
 */

@Controller
@RequestMapping("/bpm_api")
public class BpmExternalCommonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExtendActTasklogService tasklogService;
    @Autowired
    private SecuritiesUserInfoService securitiesUserInfoService;
    @Autowired
    private CustomerAccOpenInfoService customerAccOpenInfoService;
    @Autowired
    private SecuritiesUserInfoDao securitiesUserInfoDao;
    @Autowired
    private MessageSendInfoService messageSendInfoService;
    @Autowired
    OpenAccountCaVerityInfoService openAccountCaVerityInfoService;
    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;

    /**
     * 获取客户开户申请审核信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getOpenAccountAuditInfo")
    @SystemLog(description = "获取客户开户申请审核信息")
    public
    @ResponseBody
    ResponseVO getOpenAccountAuditInfo(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {
        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getTradeAccount()) {

                vo.setCode(BpmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());

                return vo;
            }

            List<ExtendActTasklogEntity> tasklogList = tasklogService.getOpenAccountAuditInfo(request.getParams().getTradeAccount());

            Map<String, Object> resultMap = Maps.newHashMap();

            if (tasklogList.size() == 1) {
                resultMap.put("auditTime", DateUtil.format(tasklogList.get(0).getDealTime(), "yyyy-MM-dd HH:mm:ss"));
            }

            vo = buildMapResult(resultMap);

        } catch (Exception e) {
            logger.error("[bpm_api]获取客户开户申请审核信息异常", e);
        }

        return vo;
    }

    /**
     * 验证客户帐号是否是受限开户帐户
     *
     * @param request
     * @return
     */
    @RequestMapping("/verifyIsRestrictOpenAccount")
    @SystemLog(description = "验证客户帐号是否是受限开户帐户")
    public
    @ResponseBody
    ResponseVO verifyIsRestrictOpenAccount(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {
        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getTradeAccount()) {

                vo.setCode(BpmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());

                return vo;
            }

            SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
            securitiesUserModel.setTradeAccount(request.getParams().getTradeAccount());
            securitiesUserModel.setOpenAccountStartTime(DateUtil.parse("2018-12-06 23:59:59"));
            securitiesUserModel.setOpenAccountEndTime(DateUtil.parse("2019-01-12 23:59:59"));
            securitiesUserModel.setBankType(1);
            List<SecuritiesUserModel> securitiesUserInfoList = securitiesUserInfoService.verifyIsRestrictOpenAccount(securitiesUserModel);

            Map<String, Object> resultMap;

            if (securitiesUserInfoList.size() > 0) {
                resultMap = Maps.newHashMap();
                resultMap.put("verifyIsRestrictOpenAccount", true);
            } else {
                resultMap = Maps.newHashMap();
                resultMap.put("verifyIsRestrictOpenAccount", false);
            }

            vo = buildMapResult(resultMap);

        } catch (Exception e) {
            logger.error("[bpm_api]验证客户帐号是否是受限开户账户异常", e);
        }

        return vo;
    }

    /**
     * 获取受限开户帐户名单
     *
     * @param request
     * @return
     */
    @RequestMapping("/findRestrictOpenAccount")
    @SystemLog(description = "获取受限开户帐户名单")
    public
    @ResponseBody
    ResponseVO findRestrictOpenAccount(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {
        ResponseVO vo = new ResponseVO();

        try {

            SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
            securitiesUserModel.setOpenAccountStartTime(DateUtil.parse("2018-12-06 23:59:59"));
            securitiesUserModel.setOpenAccountEndTime(DateUtil.parse("2019-01-12 23:59:59"));
            securitiesUserModel.setBankType(1);
            List<SecuritiesUserModel> securitiesUserInfoList = securitiesUserInfoService.verifyIsRestrictOpenAccount(securitiesUserModel);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (SecuritiesUserModel securitiesUserInfo : securitiesUserInfoList) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", securitiesUserInfo.getUserId());
                resultMap.put("clientName", securitiesUserInfo.getClientName());
                resultMap.put("phoneNumber", securitiesUserInfo.getPhoneNumber());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[bpm_api]获取受限开户帐户名单", e);
        }

        return vo;
    }

    /**
     * 构建Map结果集
     *
     * @param resultMap
     * @return
     */
    private ResponseVO buildMapResult(Map<String, Object> resultMap) {

        ResponseVO vo = new ResponseVO();

        if (null != resultMap && resultMap.size() > 0) {
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(resultMap);
        } else {
            vo.setCode(BpmCommonEnum.CodeType.NONE_DATA.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.NONE_DATA.getMessage());
        }

        return vo;
    }

    /**
     * 构建List结果集
     *
     * @param resultList
     * @return
     */
    private ResponseVO buildListResult(List<Object> resultList) {

        ResponseVO vo = new ResponseVO();

        if (null != resultList && resultList.size() > 0) {
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(resultList);
        } else {
            vo.setCode(BpmCommonEnum.CodeType.NONE_DATA.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.NONE_DATA.getMessage());
        }

        return vo;
    }

    /**
     * 获取客户CA认证开户资料
     *
     * @param request
     * @return
     */
    @RequestMapping("/getCustomerAccOpenInfo")
    @SystemLog(description = "获取客户CA认证开户资料")
    public
    @ResponseBody
    ResponseVO getCustomerAccOpenInfo(@RequestBody(required = false) GenericSunlineRequest<CustomerAccOpenInfoProto.CustomerAccOpenInfoRequest> request) {
        ResponseVO vo = new ResponseVO();

        try {

            if (StringUtils.isBlank(request.getParams().getApplicationId())) {

                vo.setCode(BpmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());

                return vo;
            }

            CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccOpenInfoService.queryByApplicationId(request.getParams().getApplicationId());

            CustomerAccOpenInfoProto.CustomerAccOpenInfoResponse response = new CustomerAccOpenInfoProto.CustomerAccOpenInfoResponse();

            if (null != customerAccountOpenInfo) {

                response.setUserName(customerAccountOpenInfo.getClientName());
                response.setIdNo(customerAccountOpenInfo.getIdNo());
                response.setSex(CodeUtils.getCodeName("COMMON_SEX", String.valueOf(customerAccountOpenInfo.getSex())));
                response.setMobileNo(customerAccountOpenInfo.getPhoneNumber());
                response.setProvince(IdCardHelper.getProvinceName(customerAccountOpenInfo.getIdCardAddress()));
                response.setCity(IdCardHelper.getCityName(customerAccountOpenInfo.getIdCardAddress()));
                response.setContactAddr(IdCardHelper.getCountyName(customerAccountOpenInfo.getIdCardAddress()) +
                        IdCardHelper.getAddressDetailName(customerAccountOpenInfo.getIdCardAddress()));
                response.setCardedPlace(customerAccountOpenInfo.getSigningOrganization());

                String cardedExpiryDate = null;
                if (!"长期".equals(customerAccountOpenInfo.getIdCardValidDateEnd()) && !"長期".equals(customerAccountOpenInfo.getIdCardValidDateEnd())) {
                    cardedExpiryDate = DateUtil.format(DateUtil.parse(customerAccountOpenInfo.getIdCardValidDateStart()), "yyyy.MM.dd") + "-"
                            + DateUtil.format(DateUtil.parse(customerAccountOpenInfo.getIdCardValidDateEnd()), "yyyy.MM.dd");
                } else {
                    cardedExpiryDate = DateUtil.format(DateUtil.parse(customerAccountOpenInfo.getIdCardValidDateStart()), "yyyy.MM.dd") + "-"
                            + customerAccountOpenInfo.getIdCardValidDateEnd();
                }
                response.setCardedExpiryDate(cardedExpiryDate);
                response.setCard(customerAccountOpenInfo.getBankNo().replaceAll("\\s*", ""));
                response.setBirthday(customerAccountOpenInfo.getBirthday());
                response.setFolk(customerAccountOpenInfo.getNation());
                response.setWholeAddr(customerAccountOpenInfo.getIdCardAddress());

                vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
                vo.setResult(response);
            } else {
                vo.setCode(BpmCommonEnum.CodeType.NONE_DATA.getCode());
                vo.setMessage(BpmCommonEnum.CodeType.NONE_DATA.getMessage());
            }


        } catch (Exception e) {
            logger.error("[bpm_api]获取客户CA认证开户资料异常", e);
        }

        return vo;
    }

    /**
     * 补录客户开户资料
     *
     * @param request
     * @return
     */
    @RequestMapping("/modifyAccountOpenInfo")
    @SystemLog(description = "补录客户开户资料")
    public
    @ResponseBody
    ResponseVO modifyAccountOpenInfo(@RequestBody GenericSunlineRequest<AccountOpenInfoProto.AccountOpenInfoRequest> request) {
        ResponseVO responseVO = new ResponseVO();

        if (StringUtils.isBlank(request.getParams().getTradeAccount())) {

            responseVO.setCode(-1);
            responseVO.setMessage("交易帐号为空");
            return responseVO;
        }

        if (StringUtils.isBlank(request.getParams().getNation())) {

            responseVO.setCode(-1);
            responseVO.setMessage("民族为空");
            return responseVO;
        }

        if (StringUtils.isBlank(request.getParams().getSigningOrganization())) {

            responseVO.setCode(-1);
            responseVO.setMessage("签发为空");
            return responseVO;
        }

        try {

            CustomerAccountOpenInfoEntity customerAccountOpenInfo;

            SecuritiesUserModel securitiesUserModel = new SecuritiesUserModel();
            securitiesUserModel.setTradeAccount(request.getParams().getTradeAccount());

            SecuritiesUserModel securitiesUserInfo = securitiesUserInfoDao.queryObject(securitiesUserModel);

            if (null != securitiesUserInfo) {

                // 补全开户资料
                customerAccountOpenInfo = customerAccOpenInfoService.queryByApplicationId(securitiesUserInfo.getApplicationId());

                CustomerAccountOpenInfoEntity entity = new CustomerAccountOpenInfoEntity();

                entity.setApplicationId(customerAccountOpenInfo.getApplicationId());
                entity.setNation(request.getParams().getNation());
                entity.setSigningOrganization(request.getParams().getSigningOrganization());

                customerAccOpenInfoService.update(entity);

                // 合成PDF文件
                if (1 == customerAccountOpenInfo.getBankType()) {

                    if (1 == customerAccountOpenInfo.getOpenAccountType()) {

                        String accountOpenUserReportRootPath = CustomerAccOpenReportGenerate.getAccountOpenUserReportRootPath(customerAccountOpenInfo.getApplicationId());
                        File[] files = new File[0];

                        String pdfMergePath = ConfigUtils.get("openAccount.user.report.userForm") + customerAccountOpenInfo.getApplicationId() + "/" + ConfigUtils.get("ca.open.account.file.url") + ".pdf";

                        if (FileUtil.exist(pdfMergePath)) {
                            FileUtil.del(new File(pdfMergePath));
                        }

                        try {
                            files = FileUtil.ls(accountOpenUserReportRootPath);
                        } catch (Exception e) {
                            logger.error("Not directory", e);
                        }

                        List<String> pdfPaths = Lists.newArrayList();

                        if (!files[0].getPath().contains("开户表格")) {
                            for (File file : files) {
                                if (file.getPath().contains("开户表格")) {
                                    pdfPaths.add(file.getPath().replace("\\", "/"));
                                }
                            }
                            for (File file : files) {
                                if (!file.getPath().contains("开户表格")) {
                                    pdfPaths.add(file.getPath().replace("\\", "/"));
                                }
                            }
                        } else {
                            for (File file : files) {
                                pdfPaths.add(file.getPath().replace("\\", "/"));
                            }
                        }

                        boolean isSuccessed = PdfboxUtils.mergePdfFiles(pdfPaths.toArray(new String[pdfPaths.size()]), pdfMergePath);

                        if (isSuccessed) {
                            AccountOpenInfoProto.AccountOpenInfoResponse response = new AccountOpenInfoProto.AccountOpenInfoResponse();
                            response.setApplicationId(customerAccountOpenInfo.getApplicationId());
                            response.setOpenAccountFileUrl(ConfigUtils.get("cubp.extranet.file.url") + ConfigUtils.get("openAccount.user.report.userForm").substring(ConfigUtils.get("openAccount.user.report.userForm").indexOf(":") + 1, ConfigUtils.get("openAccount.user.report.userForm").length()) + customerAccountOpenInfo.getApplicationId()
                                    + "/" + URLEncoder.encode(ConfigUtils.get("ca.open.account.file.url"), "utf-8") + ".pdf");

                            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
                            responseVO.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
                            responseVO.setResult(response);
                        } else {
                            responseVO.setCode(BpmCommonEnum.CodeType.ERROR_UNKNOWN.getCode());
                            responseVO.setMessage(BpmCommonEnum.CodeType.ERROR_UNKNOWN.getMessage());
                        }
                    }
                }
            } else {
                responseVO.setCode(BpmCommonEnum.CodeType.NONE_DATA.getCode());
                responseVO.setMessage(BpmCommonEnum.CodeType.NONE_DATA.getMessage());
            }

            return responseVO;

        } catch (Exception e) {
            logger.error("补录客户开户资料异常", e);
        }

        return responseVO;
    }

    /**
     * 开户申请CA认证结果回调接口(CA补录)
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/accountOpenCaVerifyCallBack")
    @SystemLog(description = "开户申请CA认证结果回调接口(CA补录)")
    public
    @ResponseBody
    ResponseVO accountOpenCaVerifyCallBack(@RequestBody(required = false) GenericSunlineRequest<AccountOpenApplyCallBackProtocol> request) {

        ResponseVO responseVO = new ResponseVO();

        if (StringUtils.isBlank(request.getParams().getApplicationId())) {

            responseVO.setCode(-1);
            responseVO.setMessage("预约流水号为空");
            return responseVO;
        }

        if (null == request.getParams().getCaVerifyStatus()) {

            responseVO.setCode(-1);
            responseVO.setMessage("CA认证状态为空");
            return responseVO;
        }

        try {

            if (BpmCommonEnum.CodeType.OK.getCode() == request.getParams().getCaVerifyStatus()) {

                // 更新预约申请表相关信息
                CustomerAccountOpenApplyEntity customerAccOpenApplyEntity = new CustomerAccountOpenApplyEntity();
                customerAccOpenApplyEntity.setApplicationId(request.getParams().getApplicationId());
                customerAccOpenApplyEntity.setApplicationStatus(BpmCommonEnum.ApplicationStatus.APPLICATION_STATUS_OPEN_ACCOUNT_VALUE);
                customerAccOpenApplyService.updateByApplicationId(customerAccOpenApplyEntity);

                // 更新账户等级
                CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = new CustomerAccountOpenInfoEntity();
                customerAccountOpenInfoEntity.setApplicationId(request.getParams().getApplicationId());
                customerAccountOpenInfoEntity.setAccountLevel(3);
                customerAccountOpenInfoEntity.setCaSignHashCode(request.getParams().getCaSignHashCode());
                customerAccOpenInfoService.update(customerAccountOpenInfoEntity);

                // 记录CA认证信息
                List<CaVerityInfoProtocol> caVerityInfoList = request.getParams().getCaVerityInfoList();

                if (caVerityInfoList != null && caVerityInfoList.size() > 0) {
                    for (CaVerityInfoProtocol caVerity : caVerityInfoList) {

                        OpenAccountCaVerityInfoEntity entity = new OpenAccountCaVerityInfoEntity();
                        entity.setApplicationId(request.getParams().getApplicationId());
                        entity.setCaCertDn(caVerity.getCaCertDn());
                        entity.setCaCertSn(caVerity.getCaCertSn());
                        entity.setCertTime(caVerity.getCertTime());
                        entity.setCreateTime(new Date());
                        entity.setUpdateTime(new Date());

                        openAccountCaVerityInfoService.save(entity);
                    }
                }

                // 发送短信
                CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccOpenInfoService.queryByApplicationId(request.getParams().getApplicationId());
                List<String> paramList = Lists.newArrayList();
                paramList.add(customerAccountOpenInfo.getClientName());

                messageSendInfoService.generateSunlineSendSms(1106, customerAccountOpenInfo.getPhoneNumber(), paramList, "宝新证券账户开户申请");

            } else {
                // 发送邮件
                CustomerAccountOpenInfoEntity customerAccountOpenInfo = customerAccOpenInfoService.queryByApplicationId(request.getParams().getApplicationId());
                StringBuilder errMsg = new StringBuilder();
                errMsg.append("用户号：" + customerAccountOpenInfo.getUserId() + "<br>客户号：" + customerAccountOpenInfo.getClientId() + "<br>姓名：" + customerAccountOpenInfo.getClientName()
                        + "<br>证券手机号码：" + customerAccountOpenInfo.getPhoneNumber() + "<br>返回错误码：" + request.getParams().getCaVerifyStatus() + "<br>错误描述：" + request.getParams().getCaVerifyMsg());

                errMsg.append("<br>烦请尽快处理！");

                messageSendInfoService.generateSendEmailText("【CA认证失败通知】用户号" + customerAccountOpenInfo.getUserId(), errMsg.toString(), 1
                        , SysConfigUtil.getSysConfigValue("CA_EMAIL_WARNING_GROUP", "warning@zszhizhu.com"), Lists.newArrayList());
            }

            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

            return responseVO;

        } catch (Exception e) {
            logger.error("开户申请CA认证结果回调接口异常", e);
        }

        return responseVO;
    }
}
