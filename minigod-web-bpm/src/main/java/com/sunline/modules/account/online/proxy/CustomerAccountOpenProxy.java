package com.sunline.modules.account.online.proxy;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.modules.account.online.converter.CustomerOpenAccountConverter;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.entity.OpenAccountBlacklistEntity;
import com.sunline.modules.account.online.entity.OpenAccountOtherDisclosureEntity;
import com.sunline.modules.account.online.helper.CustomerAccountOpenHelper;
import com.sunline.modules.account.online.manager.CustomerAccountOpenManager;
import com.sunline.modules.account.online.model.CustomerAccOpenInfoModel;
import com.sunline.modules.account.online.protocol.AccountMarginOpenApplyProtocol;
import com.sunline.modules.account.online.protocol.AccountOpenApplyCallBackProtocol;
import com.sunline.modules.account.online.protocol.AccountOpenApplyProtocol;
import com.sunline.modules.account.online.protocol.OpenAccountOtherDisclosureProtocol;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.account.online.service.CustomerAccOpenService;
import com.sunline.modules.account.online.service.OpenAccountBlacklistService;
import com.sunline.modules.account.online.service.OpenAccountCaVerityInfoService;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @description: 开户申请代理类，负责为其它项目提供服务接口
 * 所有代理类(即非本项目内部调用)，必须以为proxy根路径开头，不做验权处理
 * @author: Larry Lai
 * @date: 2018/9/30 13:17
 * @version: v1.0
 */

@RequestMapping("proxy/customer")
@Controller
public class CustomerAccountOpenProxy {

    private static final Logger logger = LoggerFactory.getLogger(CustomerAccountOpenProxy.class);

    @Autowired
    CustomerAccOpenService customerAccountOpenService;
    @Autowired
    CustomerAccountOpenManager customerAccountOpenManager;
    @Autowired
    OpenAccountBlacklistService openAccountBlacklistService;
    @Autowired
    OpenAccountCaVerityInfoService caVerityInfoService;
    @Autowired
    CustomerAccOpenInfoService customerAccountOpenInfoService;

    /**
     * 开户申请接口，webApp项目调用
     *
     * @param applicationProtocol
     * @return
     */
    @RequestMapping("/accountOpenApplication")
    @SystemLog(description = "提交开户申请")
    public
    @ResponseBody
    ResponseVO applyAccountOpen(@RequestBody GenericSunlineRequest<AccountOpenApplyProtocol> applicationProtocol) {

        ResponseVO responseVO = new ResponseVO();
        CustomerAccOpenInfoModel customerAccountOpenInfoModel = CustomerOpenAccountConverter.protocolToModel(applicationProtocol.getParams());

        ResponseVO baseDataValidateResult = CustomerAccountOpenHelper.validateAccountOpenInfo(customerAccountOpenInfoModel);
        if (CrmCommonEnum.CodeType.ERROR.getCode() == baseDataValidateResult.getCode()) {
            return baseDataValidateResult;
        }

        if (null == customerAccountOpenInfoModel.getOpenAccountImagesInfo() || customerAccountOpenInfoModel.getOpenAccountImagesInfo().isEmpty()) {

            logger.error("【开户预约接口数据完整性校验】：影像资料缺失");
            responseVO.setCode(-1);
            responseVO.setMessage("影像资料缺失");
            return responseVO;
        }

        if (!CustomerAccountOpenHelper.openAccountImagesValidate(customerAccountOpenInfoModel.getOpenAccountImagesInfo())) {
            logger.error("【开户预约接口数据完整性校验】：图片类型错误" + JSON.toJSONString(customerAccountOpenInfoModel.getOpenAccountImagesInfo()));
            responseVO.setCode(-1);
            responseVO.setMessage("图片类型错误");
            return responseVO;
        }

        if (customerAccountOpenManager.isExistedIdCard(customerAccountOpenInfoModel.getIdKind(), customerAccountOpenInfoModel.getIdNo())) {
            responseVO.setCode(1001);
            responseVO.setMessage("证件号码已存在");
            return responseVO;
        }

        if (customerAccountOpenManager.isExistedEmail(customerAccountOpenInfoModel.getEmail())) {
            responseVO.setCode(1002);
            responseVO.setMessage("邮箱已存在");
            return responseVO;
        }

        if (customerAccountOpenManager.isExistedPhoneNumber(customerAccountOpenInfoModel.getPhoneNumber())) {
            responseVO.setCode(1003);
            responseVO.setMessage("手机号码已存在");
            return responseVO;
        }


        CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = CustomerOpenAccountConverter.modelToEntity(customerAccountOpenInfoModel);

        String applicationId = customerAccountOpenService.commitAccountOpenApplication(customerAccountOpenInfoEntity, applicationProtocol.getParams().getOpenAccountImagesInfo());

        if (null != applicationId && !"".equals(applicationId)) {
            logger.info("已成功接收[" + customerAccountOpenInfoEntity.getUserId() + "]用户的开户申请");
            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

            Map<String, Object> resultMap = Maps.newHashMap();
            resultMap.put("applicationId", applicationId);

            responseVO.setResult(resultMap);
        } else {
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        }

        return responseVO;
    }

    /**
     * 开户申请接口，webApp项目调用
     *
     * @param applicationProtocol
     * @return
     */
    @RequestMapping("/accountMarginOpenApplication")
    @SystemLog(description = "提交增开申请")
    public
    @ResponseBody
    ResponseVO applyAccountMarginOpen(@RequestBody GenericSunlineRequest<AccountMarginOpenApplyProtocol> applicationProtocol) {
        ResponseVO responseVO = new ResponseVO();

        try {
            AccountMarginOpenApplyProtocol protocol = applicationProtocol.getParams();
            if (null == protocol.getIdCardNo() || StringUtils.isBlank(protocol.getIdCardNo())) {
                logger.error("【增开预约接口数据完整性校验】：用户不存在");
                responseVO.setCode(-1);
                responseVO.setMessage("用户不存在");
                return responseVO;
            }

            //信用额度为空，则设置默认
            if (null == protocol.getCreditQuota() || StringUtils.isBlank(protocol.getCreditQuota())) {
                protocol.setCreditQuota(String.valueOf(10000));
            }

            //信用比例为空，则设置默认
            if (null == protocol.getCreditRatio() || StringUtils.isBlank(protocol.getCreditRatio())) {
                protocol.setCreditRatio(String.valueOf(20.00));
            }

            CustomerAccountOpenInfoEntity customerAccountOpenInfoEntity = customerAccountOpenInfoService.queryByIdCardNumber(protocol.getIdCardNo());
            customerAccountOpenInfoEntity.setCreditRatio(protocol.getCreditRatio());
            customerAccountOpenInfoEntity.setCreditQuota(protocol.getCreditQuota());
            List<OpenAccountOtherDisclosureEntity> otherDisclosureList = Lists.newArrayList();
            for (OpenAccountOtherDisclosureProtocol temp : protocol.getDisclosure()) {
                otherDisclosureList.add(CustomerOpenAccountConverter.protocolToEntity2(temp));
            }
            customerAccountOpenInfoEntity.setOtherDisclosureList(otherDisclosureList);

            String applicationId = customerAccountOpenService.commitAccountMarginOpenApplication(customerAccountOpenInfoEntity);

            if (null != applicationId && !"".equals(applicationId)) {
                logger.info("已成功接收[" + customerAccountOpenInfoEntity.getUserId() + "]用户的增开申请");
                responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

                Map<String, Object> resultMap = Maps.newHashMap();
                resultMap.put("applicationId", applicationId);

                responseVO.setResult(resultMap);
            } else {
                responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            }

        } catch (Exception e) {
            logger.error("提交增开申请失败:", e);
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        }

        return responseVO;
    }


    /**
     * 开户申请回调接口，webApp项目调用
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/accountOpenApplicationCallBack")
    @SystemLog(description = "开户CA验证结果回调")
    public
    @ResponseBody
    ResponseVO accountOpenApplicationCallBack(@RequestBody(required = false) GenericSunlineRequest<AccountOpenApplyCallBackProtocol> request) {

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

        //  CA认证申请结果业务处理
        boolean isSucceed = customerAccountOpenService.doCaVerityCallBack(request.getParams());

        if (isSucceed) {
            responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
        } else {
            responseVO.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
        }

        return responseVO;
    }

    /**
     * 证件号码唯一性验证
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/openAccountIdCardValidate")
    @SystemLog(description = "证件号码唯一性验证")
    public
    @ResponseBody
    ResponseVO openAccountIdCardValidate(@RequestBody(required = false) GenericSunlineRequest<AccountOpenApplyProtocol> request) {

        ResponseVO responseVO = new ResponseVO();

        Integer idCardKind = request.getParams().getIdKind();
        String idCardNumber = request.getParams().getIdNo();

        if (null == idCardNumber) {
            responseVO.setCode(-1);
            responseVO.setMessage("证件类型为空");
            return responseVO;
        }

        if (StringUtils.isBlank(idCardNumber)) {
            responseVO.setCode(-1);
            responseVO.setMessage("证件号码为空");
            return responseVO;
        }

        OpenAccountBlacklistEntity entity = new OpenAccountBlacklistEntity();
        entity.setIdKind(idCardKind);
        entity.setIdNo(idCardNumber);

        if (null != openAccountBlacklistService.isExistedBlacklist(entity)) {
            responseVO.setCode(1004);
            responseVO.setMessage("证件号码已被纳入黑名单");
            return responseVO;
        }

        if (customerAccountOpenManager.isExistedIdCard(idCardKind, idCardNumber)) {
            responseVO.setCode(1005);
            responseVO.setMessage("证件号码已存在");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

        return responseVO;
    }


    /**
     * 邮箱地址唯一性验证
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/openAccountEmailValidate")
    @SystemLog(description = "邮箱地址唯一性验证")
    public
    @ResponseBody
    ResponseVO openAccountEmailValidate(@RequestBody(required = false) GenericSunlineRequest<AccountOpenApplyProtocol> request) {

        ResponseVO responseVO = new ResponseVO();

        String email = request.getParams().getEmail();
        if (StringUtils.isBlank(email)) {

            responseVO.setCode(-1);
            responseVO.setMessage("邮箱地址为空");
            return responseVO;
        }

        if (customerAccountOpenManager.isExistedEmail(request.getParams().getEmail())) {
            responseVO.setCode(1006);
            responseVO.setMessage("邮箱地址已存在");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

        return responseVO;
    }

    /**
     * 手机号码唯一性验证
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/openAccountPhoneValidate")
    @SystemLog(description = "手机号码唯一性验证")
    public
    @ResponseBody
    ResponseVO openAccountPhoneValidate(@RequestBody(required = false) GenericSunlineRequest<AccountOpenApplyProtocol> request) {

        ResponseVO responseVO = new ResponseVO();

        String phoneNumber = request.getParams().getPhoneNumber();
        if (StringUtils.isBlank(phoneNumber)) {

            responseVO.setCode(-1);
            responseVO.setMessage("手机号码为空");
            return responseVO;
        }

        if (customerAccountOpenManager.isExistedPhoneNumber(request.getParams().getPhoneNumber())) {
            responseVO.setCode(1007);
            responseVO.setMessage("手机号码已存在");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

        return responseVO;
    }

    /**
     * 是否集体户地址验证
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/collectivelyAccountValidate")
    @SystemLog(description = "是否集体户地址验证")
    public
    @ResponseBody
    ResponseVO collectivelyAccountValidate(@RequestBody(required = false) GenericSunlineRequest<AccountOpenApplyProtocol> request) {

        ResponseVO responseVO = new ResponseVO();

        String contactAddress = request.getParams().getContactAddress();
        if (StringUtils.isBlank(contactAddress)) {
            responseVO.setCode(-1);
            responseVO.setMessage("集体户地址验证-地址为空");
            return responseVO;
        }

        if (customerAccountOpenManager.collectivelyAccountValidate(contactAddress)) {
            responseVO.setCode(1008);
            responseVO.setMessage("该地址为集体户地址");
            return responseVO;
        }

        responseVO.setCode(CrmCommonEnum.CodeType.OK.getCode());
        responseVO.setMessage(CrmCommonEnum.CodeType.OK.getMessage());

        return responseVO;
    }
}
