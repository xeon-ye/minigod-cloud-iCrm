package com.sunline.modules.api.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.account.online.hundsun.UserInfo;
import com.sunline.modules.account.online.manager.CustomerAccountOpenManager;
import com.sunline.modules.analysis.dao.ClientTradeFlowInfoDao;
import com.sunline.modules.analysis.entity.ClientAssetFlowInfoEntity;
import com.sunline.modules.analysis.entity.ClientFundDepositEntity;
import com.sunline.modules.analysis.entity.ClientIpoEntity;
import com.sunline.modules.analysis.entity.ClientTradeFlowInfoEntity;
import com.sunline.modules.analysis.service.ClientAssetFlowInfoService;
import com.sunline.modules.analysis.service.ClientFundDepositService;
import com.sunline.modules.analysis.service.ClientIpoService;
import com.sunline.modules.analysis.service.ClientTradeFlowInfoService;
import com.sunline.modules.api.entity.CrmExternalCommonModel;
import com.sunline.modules.api.protocol.ChannelUserInfoProto;
import com.sunline.modules.api.protocol.CrmExternalCommonProto;
import com.sunline.modules.api.protocol.DonatedStockProto;
import com.sunline.modules.api.protocol.SecuritiesUserInfoProto;
import com.sunline.modules.api.service.ChannelApiService;
import com.sunline.modules.api.service.UserApiService;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.FarePackageSetupEntity;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.commission.service.FarePackageSetupService;
import com.sunline.modules.common.annotation.SystemLog;
import com.sunline.modules.common.common.BpmCommonEnum;
import com.sunline.modules.common.common.CommonResponse;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.entity.StkTrdCaleEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.pojo.rest.GenericHsRequest;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.service.StkTrdCaleService;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.customer.entity.SecuritiesUserInfoEntity;
import com.sunline.modules.customer.service.SecUserInfoService;
import com.sunline.modules.hundsun.protocol.request.ClientFareManageRequest;
import com.sunline.modules.hundsun.protocol.response.SysArgResponse;
import com.sunline.modules.hundsun.service.HsCommManageService;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;
import com.sunline.modules.marker.service.UserChannelInfoService;
import com.sunline.modules.stock.entity.DonatedStockApplicationInfoEntity;
import com.sunline.modules.stock.service.DonatedStockApplicationInfoService;
import com.sunline.modules.sys.entity.CodeEntity;
import com.sunline.modules.sys.entity.UserEntity;
import com.sunline.modules.sys.service.CodeService;
import com.sunline.modules.sys.service.UserService;
import com.sunline.security.SecurityKey;
import com.sunline.security.util.AESUtil;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @description: CRM外部接口
 * @author: Larry Lai
 * @date: 2018/12/26 10:36
 * @version: v1.0
 */
@Controller
@RequestMapping("/crm_api")
public class CrmExternalCommonController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 金额格式化
     */
    private final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####################0.00");
    @Autowired
    private UserChannelInfoService userChannelInfoService;
    @Autowired
    private ClientAssetFlowInfoService clientAssetFlowInfoService;
    @Autowired
    private UserApiService uerApiService;
    @Autowired
    private StkTrdCaleService stkTrdCaleService;
    @Autowired
    private ChannelApiService channelApiService;
    @Autowired
    private UserService userService;
    @Autowired
    private FarePackageSetupService farePackageSetupService;
    @Autowired
    DonatedStockApplicationInfoService donatedStockService;
    @Autowired
    private ClientTradeFlowInfoDao clientTradeFlowInfoDao;
    @Autowired
    private CodeService codeService;
    @Autowired
    private ClientTradeFlowInfoService clientTradeFlowInfoService;
    @Autowired
    private ClientFundDepositService clientFundDepositService;
    @Autowired
    private SecUserInfoService secUserInfoService;
    @Autowired
    private ClientIpoService clientIpoService;
    @Autowired
    CustomerAccountOpenManager customerAccountOpenManager;
    @Autowired
    private ChannelFareSetupService channelFareSetupService;

    /**
     * 获取总资产大于0的客户名单
     *
     * @param request
     * @return
     */
    @RequestMapping("/getAssetGtZeroClientList")
//    @SystemLog(description = "获取总资产大于0的客户名单")
    public
    @ResponseBody
    ResponseVO getAssetGtZeroClientList(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            ClientAssetFlowInfoEntity clientAssetFlowInfoEntity = new ClientAssetFlowInfoEntity();

            // 获取交易日历
            StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

            if (stkTrdCaleEntity.getIsTradeDay()) {
                clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getNormalDate());
            } else {
                clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getLastTrd());
            }

            // 生成表名
            clientAssetFlowInfoEntity.setTableName("client_asset_flow_info_" + DateUtil.format(DateUtil.parse(clientAssetFlowInfoEntity.getTradeDate()), "yyyyMM"));
            List<ClientAssetFlowInfoEntity> clientAssetFlowInfoEntityList = clientAssetFlowInfoService.getAssetGtZeroClientList(clientAssetFlowInfoEntity);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientAssetFlowInfoEntity clientAssetFlowInfo : clientAssetFlowInfoEntityList) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", clientAssetFlowInfo.getUserId() == null ? "" : clientAssetFlowInfo.getUserId().toString());
                resultMap.put("clientId", clientAssetFlowInfo.getClientId());
                resultMap.put("fundAccount", clientAssetFlowInfo.getFundAccount());
                resultMap.put("totalAsset", clientAssetFlowInfo.getTotalAssets().toString());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取总资产大于0的客户名单异常", e);
        }

        return vo;
    }

    /**
     * 获取渠道佣金套餐信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getChannelFareInfo")
//    @SystemLog(description = "获取渠道佣金套餐信息")
    public
    @ResponseBody
    ResponseVO getChannelFareInfo(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            FarePackageSetupEntity entity = new FarePackageSetupEntity();


            if (null == request.getParams().getChannelId()) {

                ResponseVO responseVO = new ResponseVO();

                responseVO.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                responseVO.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());

                return responseVO;
            } else {
                entity.setChannelId(request.getParams().getChannelId());
            }

            if (null != request.getParams().getExchangeType() || !"".equals(request.getParams().getExchangeType())) {
                entity.setExchangeType(request.getParams().getExchangeType());
            }

            List<FarePackageSetupEntity> channelFareSetupInfoList = farePackageSetupService.getChannelFareInfo(entity);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (FarePackageSetupEntity channelFareSetupInfo : channelFareSetupInfoList) {
                resultMap = Maps.newHashMap();
                resultMap.put("channelId", channelFareSetupInfo.getChannelId());
                resultMap.put("channelName", channelFareSetupInfo.getChannelName());
                resultMap.put("exchangeType", channelFareSetupInfo.getExchangeType());
                resultMap.put("feeType", channelFareSetupInfo.getFeeType());
                resultMap.put("balanceRatio", channelFareSetupInfo.getBalanceRatio());
                resultMap.put("feeCountFix", channelFareSetupInfo.getFeeCountFix());
                resultMap.put("minFare", channelFareSetupInfo.getMinFare());
                resultMap.put("maxFare", channelFareSetupInfo.getMaxFare());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取渠道佣金套餐信息异常", e);
        }

        return vo;
    }

    /**
     * 获取赠股发放配置信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getDonatedStkConfig")
    @SystemLog(description = "获取赠股发放配置信息")
    public
    @ResponseBody
    ResponseVO getDonatedStkConfig(@RequestBody(required = false) GenericSunlineRequest<DonatedStockProto.DonatedStockProtoRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (StringUtils.isBlank(request.getParams().getApplicationId())) {

                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());

                return vo;
            }

            // 获取赠股业务信息
            DonatedStockApplicationInfoEntity donatedStockInfo = donatedStockService.queryDetailByApplicationId(request.getParams().getApplicationId());

            DonatedStockProto.DonatedStockProtoResponse donatedStockProtoResponse = new DonatedStockProto.DonatedStockProtoResponse();

            Map<String, Object> resultMap = Maps.newHashMap();

            if (null != donatedStockInfo) {

                donatedStockProtoResponse.setApplicationId(donatedStockInfo.getApplicationId());
                donatedStockProtoResponse.setClientId(donatedStockInfo.getClientId());
                donatedStockProtoResponse.setFundAccount(donatedStockInfo.getFundAccount());
                donatedStockProtoResponse.setStockCode(donatedStockInfo.getStockCode());
                donatedStockProtoResponse.setStockName(donatedStockInfo.getStockName());
                donatedStockProtoResponse.setStockQuantity(donatedStockInfo.getStockQuantity());
                donatedStockProtoResponse.setActivityId(Integer.parseInt(donatedStockInfo.getActivityId()));

                resultMap.put("donatedStkConfig", donatedStockProtoResponse);

                // 获取活动配置信息
                String response = HttpClientUtils.postJson(ConfigUtils.get("sunline.service.url") + "reward_center_api/find_stock_record", JSON.toJSONString(request));

                ResponseVO responseVO = JSON.parseObject(response, ResponseVO.class);

                if (null != responseVO && responseVO.getCode() == CrmCommonEnum.CodeType.OK.getCode()) {
                    resultMap.put("activiConfig", responseVO.getResult());
                } else {
                    resultMap.put("activiConfig", null);
                }
            }

            vo = buildMapResult(resultMap);

        } catch (Exception e) {
            vo.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]获取赠股发放配置信息异常", e);
            return vo;
        }
        return vo;
    }

    /**
     * 获取渠道信息列表
     *
     * @param request
     * @return
     */
    @RequestMapping("/getChannelNodes")
//    @SystemLog(description = "获取渠道信息列表")
    public
    @ResponseBody
    ResponseVO getChannelNodes(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {
        ResponseVO vo = new ResponseVO();
        try {
            vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
            String sourceChannelId = request.getParams().getSourceChannelId();
            if (sourceChannelId != null && !"".equals(sourceChannelId)) {
                UserChannelInfoEntity channel = new UserChannelInfoEntity();
                channel.setParentId(sourceChannelId);
                List<UserChannelInfoEntity> channelList = userChannelInfoService.queryByChannelList(channel);
                List<Object> sunlineChannelList = Lists.newArrayList();
                Map<String, Object> sunlineChannelMap;
                for (UserChannelInfoEntity channelEntity : channelList) {
                    sunlineChannelMap = Maps.newHashMap();
                    sunlineChannelMap.put("channelId", channelEntity.getChannelId());
                    sunlineChannelMap.put("channelName", channelEntity.getChannelName());
                    sunlineChannelMap.put("parentId", channelEntity.getParentId());
                    sunlineChannelList.add(sunlineChannelMap);
                    List<UserChannelInfoEntity> sonList = userChannelInfoService.queryByChannelList(channelEntity);
                    if (sonList != null && sonList.size() > 0) {
                        sunlineChannelMap.put("hasNextChannel", "1");
                    } else {
                        sunlineChannelMap.put("hasNextChannel", "0");
                    }
                }

                vo = buildListResult(sunlineChannelList);
            }
        } catch (Exception e) {
            logger.error("[crm_api]获取渠道信息列表异常", e);
        }
        return vo;
    }

    /**
     * 获取客户资产信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getAssetInfo")
//    @SystemLog(description = "获取客户资产信息")
    public
    @ResponseBody
    ResponseVO getAssetInfo(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {
        ResponseVO vo = new ResponseVO();
        try {

            ClientAssetFlowInfoEntity clientAssetFlowInfoEntity = new ClientAssetFlowInfoEntity();

            if (StrUtil.isBlank(request.getParams().getTradeAccount()) && null == request.getParams().getBatchTradeAccountList()) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            if (StrUtil.isNotBlank(request.getParams().getTradeDate())) {
                clientAssetFlowInfoEntity.setTradeDate(request.getParams().getTradeDate());
            } else {
                // 获取交易日历
                StkTrdCaleEntity stkTrdCaleEntity = stkTrdCaleService.getTrdCale(DateUtil.format(DateUtil.yesterday(), "yyyy-MM-dd"), CrmCommonEnum.SecStockTransfer.SEC_EXCHANGE_TYPE_SUFFIX_SEHK.getName());

                if (stkTrdCaleEntity.getIsTradeDay()) {
                    clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getNormalDate());
                } else {
                    clientAssetFlowInfoEntity.setTradeDate(stkTrdCaleEntity.getLastTrd());
                }
            }

            // 生成表名
            clientAssetFlowInfoEntity.setTableName("client_asset_flow_info_" + DateUtil.format(DateUtil.parse(clientAssetFlowInfoEntity.getTradeDate()), "yyyyMM"));

            if (null != request.getParams().getBatchTradeAccountList() && request.getParams().getBatchTradeAccountList().size() > 0) {
                clientAssetFlowInfoEntity.setClientIds(request.getParams().getBatchTradeAccountList());
            }

            if (StrUtil.isNotBlank(request.getParams().getTradeAccount())) {
                clientAssetFlowInfoEntity.setClientId(request.getParams().getTradeAccount());
            }

            List<ClientAssetFlowInfoEntity> assetFlowList = clientAssetFlowInfoService.findAssetGroupListExcelList(clientAssetFlowInfoEntity);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();
            for (ClientAssetFlowInfoEntity entity : assetFlowList) {
                resultMap = Maps.newHashMap();
                resultMap.put("clientId", entity.getClientId());
                resultMap.put("fundAccount", entity.getFundAccount());
                resultMap.put("asset", entity.getTotalAssets().toString());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取客户资产信息异常", e);
        }
        return vo;
    }

    /**
     * 获取获取客户生命周期状态
     *
     * @param request
     * @return
     */
    @RequestMapping("/getUserStatus")
//    @SystemLog(description = "获取客户生命周期状态")
    public
    @ResponseBody
    ResponseVO getUserStatus(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonModel> request) {
        return uerApiService.queryUserStatus(request.getParams());
    }

    /**
     * 渠道信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryLastInfo")
    public
    @ResponseBody
    ResponseVO queryLastInfo(@RequestBody(required = false) String request) {

        ResponseVO vo = new ResponseVO();

        JSONObject jsonObject = new JSONObject(request);
        if (jsonObject.containsKey("channelId") && jsonObject.containsKey("loginName")) {

            String channelId = jsonObject.get("channelId").toString();
            String loginName = jsonObject.get("loginName").toString();
            UserEntity user = (UserEntity) jsonObject.toBean( UserEntity.class);

            if (loginName == null || "".equals(loginName)) {

                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
            }

            user = userService.queryByLoginName(user.getLoginName());
            List<String> channelIds = UserUtils.getChannelIds(user);
            return channelApiService.queryInfo(channelIds, channelId);

        } else {
            vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
            return vo;
        }
    }

    /**
     * 获取客户港美股交易状态
     *
     * @param request
     * @return
     */
    @RequestMapping("/findClientTradeStatus")
    @SystemLog(description = "获取客户港美股交易状态")
    public
    @ResponseBody
    ResponseVO findClientTradeStatus(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (StringUtils.isBlank(request.getParams().getTradeAccount())) {

                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientTradeFlowInfoEntity entity = new ClientTradeFlowInfoEntity();
            entity.setClientId(request.getParams().getTradeAccount());

            entity.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_SEHK.getIndex());
            List<ClientTradeFlowInfoEntity> clientHkTradeFlowInfoList = clientTradeFlowInfoDao.queryList(entity);

            entity.setExchangeType(CrmCommonEnum.SecDataDictionary.SEC_EXCHANGE_TYPE_US.getIndex());
            List<ClientTradeFlowInfoEntity> clientUsTradeFlowInfoList = clientTradeFlowInfoDao.queryList(entity);

            Map<String, Object> resultMap = Maps.newHashMap();

            if (null != clientHkTradeFlowInfoList && clientHkTradeFlowInfoList.size() > 0) {
                resultMap.put("HkTradeStatus", true);
            } else {
                resultMap.put("HkTradeStatus", false);
            }

            if (null != clientUsTradeFlowInfoList && clientUsTradeFlowInfoList.size() > 0) {
                resultMap.put("UsTradeStatus", true);
            } else {
                resultMap.put("UsTradeStatus", false);
            }

            vo = buildMapResult(resultMap);

        } catch (Exception e) {
            vo.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]获取客户港美股交易状态异常", e);
            return vo;
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
            vo.setCode(CrmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(resultMap);
        } else {
            vo.setCode(CrmCommonEnum.CodeType.NONE_DATA.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.NONE_DATA.getMessage());
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
            vo.setCode(CrmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(resultList);
        } else {
            vo.setCode(CrmCommonEnum.CodeType.NONE_DATA.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.NONE_DATA.getMessage());
        }

        return vo;
    }

    /**
     * 获取数据字典
     *
     * @param request
     * @return
     */
    @RequestMapping("/findDataDictionaryByMark")
//    @SystemLog(description = "获取数据字典")
    public
    @ResponseBody
    ResponseVO findDataDictionaryByMark(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getMark() || "".equals(request.getParams().getMark())) {

                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            List<CodeEntity> codeList = codeService.queryChildsByMark(request.getParams().getMark(), request.getParams().getCodeStatus());

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (CodeEntity codeInfo : codeList) {
                resultMap = Maps.newHashMap();
                resultMap.put("name", codeInfo.getName());
                resultMap.put("value", codeInfo.getValue());
                resultMap.put("sort", codeInfo.getSort());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取数据字典异常", e);
        }

        return vo;
    }

    /**
     * 获取客户首次交易信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getFirstTrdInfo")
//    @SystemLog(description = "获取客户首次交易信息")
    public
    @ResponseBody
    ResponseVO getFirstTrdInfo(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            ClientTradeFlowInfoEntity entity = new ClientTradeFlowInfoEntity();

            if (StrUtil.isBlank(request.getParams().getTrdBeginDate()) || StrUtil.isBlank(request.getParams().getTrdEndDate())) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            if (StrUtil.isNotBlank(request.getParams().getTrdBeginDate())) {
                entity.setBeginDate(request.getParams().getTrdBeginDate());
            }

            if (StrUtil.isNotBlank(request.getParams().getTrdEndDate())) {
                entity.setEndDate(request.getParams().getTrdEndDate());
            }

            if (StrUtil.isNotBlank(request.getParams().getTradeAccount())) {
                entity.setClientId(request.getParams().getTradeAccount());
            }

            if (null !=request.getParams().getBatchTradeAccountList() && request.getParams().getBatchTradeAccountList().size()>0) {
                entity.setBatchTradeAccountList(request.getParams().getBatchTradeAccountList());
            }

            List<ClientTradeFlowInfoEntity> clientAssetFlowInfoList = clientTradeFlowInfoService.getFirstTrdInfo(entity);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientTradeFlowInfoEntity clientTradeFlowInfo : clientAssetFlowInfoList) {
                resultMap = Maps.newHashMap();
                resultMap.put("tradeAccount", clientTradeFlowInfo.getClientId());
                resultMap.put("fundAccount", clientTradeFlowInfo.getFundAccount());
                resultMap.put("firstTradeDate", clientTradeFlowInfo.getTradeDate());
                resultMap.put("businessBalance", DECIMAL_FORMAT.format(clientTradeFlowInfo.getBusinessBalance()));
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取客户首次交易信息异常", e);
        }
        return vo;
    }

    /**
     * 获取客户首天累计入金金额
     *
     * @param request
     * @return
     */
    @RequestMapping("/getFirstFundDepTotal")
//    @SystemLog(description = "获取客户首天累计入金金额")
    public
    @ResponseBody
    ResponseVO getFirstFundDepTotal(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (StrUtil.isBlank(request.getParams().getTradeAccount()) && null == request.getParams().getBatchTradeAccountList()) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientFundDepositEntity queryCondition = new ClientFundDepositEntity();
            queryCondition.setDepositType(CrmCommonEnum.SecDataDictionary.SEC_FUND_DEPOSIT_DEP.getIndex());
            queryCondition.setBatchTradeAccountList(request.getParams().getBatchTradeAccountList());

            List<ClientFundDepositEntity> firstFundDepTotalList = clientFundDepositService.queryFirstFundDepTotal(queryCondition);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientFundDepositEntity firstFundDepTotal : firstFundDepTotalList) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", firstFundDepTotal.getUserId());
                resultMap.put("clientId", firstFundDepTotal.getClientId());
                resultMap.put("channelId", firstFundDepTotal.getChannelId());
                resultMap.put("tradeDate", firstFundDepTotal.getInitDate());
                resultMap.put("inviter", firstFundDepTotal.getInviterId());
                resultMap.put("depositMoney", DECIMAL_FORMAT.format(firstFundDepTotal.getOccurBalance()));
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取客户首天累计入金金额异常", e);
        }
        return vo;
    }

    /**
     * 获取客户首天累计出入金金额
     *
     * @param request
     * @return
     */
    @RequestMapping("/getFirstFundTotal")
//    @SystemLog(description = "获取客户首天累计出入金金额")
    public
    @ResponseBody
    ResponseVO getFirstFundTotal(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (StrUtil.isBlank(request.getParams().getDepositType()) && null == request.getParams().getBatchTradeAccountList()) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientFundDepositEntity queryCondition = new ClientFundDepositEntity();
            queryCondition.setDepositType(request.getParams().getDepositType());
            queryCondition.setBatchTradeAccountList(request.getParams().getBatchTradeAccountList());

            List<ClientFundDepositEntity> firstFundDepTotalList = clientFundDepositService.queryFirstFundDepTotal(queryCondition);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientFundDepositEntity firstFundDepTotal : firstFundDepTotalList) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", firstFundDepTotal.getUserId());
                resultMap.put("clientId", firstFundDepTotal.getClientId());
                resultMap.put("channelId", firstFundDepTotal.getChannelId());
                resultMap.put("inviter", firstFundDepTotal.getInviterId());
                resultMap.put("tradeDate", firstFundDepTotal.getInitDate());
                resultMap.put("depositMoney", DECIMAL_FORMAT.format(firstFundDepTotal.getOccurBalance()));
                resultList.add(resultMap);
            }
            vo = buildListResult(resultList);
        } catch (Exception e) {
            logger.error("[crm_api]获取客户首天累计出入金金额异常", e);
        }
        return vo;
    }

    /**
     * 获取指定时间内客户出入金金额
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryFundDepTotal")
//    @SystemLog(description = "获取指定时间内客户出入金金额")
    public
    @ResponseBody
    ResponseVO queryFundDepTotal(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getBatchUserIdList() || StrUtil.isBlank(request.getParams().getTrdBeginDate())
                    || StrUtil.isBlank(request.getParams().getTrdEndDate()) || StrUtil.isBlank(request.getParams().getDepositType())) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientFundDepositEntity queryCondition = new ClientFundDepositEntity();
            queryCondition.setDepositType(request.getParams().getDepositType());
            queryCondition.setBeginDate(request.getParams().getTrdBeginDate());
            queryCondition.setEndDate(request.getParams().getTrdEndDate());
            queryCondition.setBatchUserIdList(request.getParams().getBatchUserIdList());

            List<ClientFundDepositEntity> fundDepTotalList = clientFundDepositService.queryFundDepTotal(queryCondition);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientFundDepositEntity fundDepTotal : fundDepTotalList) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", fundDepTotal.getUserId());
                resultMap.put("clientId", fundDepTotal.getClientId());
                resultMap.put("depositType", fundDepTotal.getDepositType());
                resultMap.put("depositMoney", DECIMAL_FORMAT.format(fundDepTotal.getOccurBalance()));
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取指定时间内客户出入金金额异常", e);
        }
        return vo;
    }

    /**
     * 获取小神用户信息列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/userInfoList")
//    @SystemLog(description = "获取小神用户信息列表")
    public
    @ResponseBody
    ResponseVO userList(@RequestBody(required = false) GenericSunlineRequest<ChannelUserInfoProto> request) {
        ResponseVO vo = new ResponseVO();
        if (null == request) {
            vo.setCode(CrmCommonEnum.CodeType.ERROR.getCode());
            return vo;
        }
        try {
            ChannelUserInfoProto userInfoProto = request.getParams();
            int pageNum = Utils.parseInt(userInfoProto.getPageNum(), 1);
            //手机号解码
            String phoneNumber = request.getParams().getPhoneNumber();
            if (phoneNumber != null && !"".equalsIgnoreCase(phoneNumber)) {
                String phoneNumberNew = AESUtil.encrypt(request.getParams().getPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
                userInfoProto.setPhoneNumber(phoneNumberNew);
            }
            UserEntity user = userService.queryByLoginName(userInfoProto.getCurrentUserName());
            List<String> channelIds = UserUtils.getChannelIds(user);
            if (channelIds != null && channelIds.size() > 0) {
                userInfoProto.setCheckedChannelIds(channelIds);
            }
            String registerStartTime = userInfoProto.getRegisterStartTime();
            String registerEndTime = userInfoProto.getRegisterEndTime();
            if (null != registerStartTime && !"".equals(registerStartTime)) {
                userInfoProto.setRegisterStartTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(registerStartTime)), "yyyy-MM-dd HH:mm:ss"));
            } else {
                userInfoProto.setRegisterStartTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.lastMonth()), "yyyy-MM-dd HH:mm:ss"));
            }
            if (null != registerEndTime && !"".equals(registerEndTime)) {
                userInfoProto.setRegisterEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(registerEndTime)), "yyyy-MM-dd HH:mm:ss"));
            } else {
                userInfoProto.setRegisterEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(DateUtil.today())), "yyyy-MM-dd HH:mm:ss"));
            }
            SecuritiesUserInfoEntity queryCondition = new SecuritiesUserInfoEntity();
            BeanUtils.copyProperties(userInfoProto, queryCondition);

            Page<SecuritiesUserInfoEntity> page = secUserInfoService.userPageList(queryCondition, pageNum);
            //手机号脱敏处理
            if (null != page && null != page.getResult()) {
                for (SecuritiesUserInfoEntity s : page.getResult()) {
                    if (StringUtils.isNotBlank(s.getPhoneNumber())) {
                        StringBuffer str = new StringBuffer(s.getPhoneNumber());
                        str.replace(3, 7, "****");
                        s.setPhoneNumber(str.toString());
                    }
                }
            }
            if (null != registerStartTime && !"".equals(registerStartTime)) {
                queryCondition.setRegisterStartTime(registerStartTime);
            } else {
                queryCondition.setRegisterStartTime(DateUtil.format(DateUtil.lastMonth(), "yyyy-MM-dd"));
            }
            if (null != registerEndTime && !"".equals(registerEndTime)) {
                queryCondition.setRegisterEndTime(registerEndTime);
            } else {
                queryCondition.setRegisterEndTime(DateUtil.today());
            }
            queryCondition.setPhoneNumber(phoneNumber);
            Map<String, Object> resultMap = Maps.newHashMap();
            resultMap.put("page", page);
            resultMap.put("info", queryCondition);
            vo = buildMapResult(resultMap);
        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("获取小神用户信息列表异常", e);
        }
        return vo;
    }

    /**
     * 获取小神用户信息列表导出数据
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/userInfoListExcel")
//    @SystemLog(description = "获取小神用户信息列表导出数据")
    public
    @ResponseBody
    ResponseVO userListExcel(@RequestBody(required = false) GenericSunlineRequest<ChannelUserInfoProto> request) {
        ResponseVO vo = new ResponseVO();
        if (null == request) {
            vo.setCode(CrmCommonEnum.CodeType.ERROR.getCode());
            return vo;
        }
        try {
            ChannelUserInfoProto userInfoProto = request.getParams();
            //手机号解码
            String phoneNumber = request.getParams().getPhoneNumber();
            if (phoneNumber != null && !"".equalsIgnoreCase(phoneNumber)) {
                String phoneNumberNew = AESUtil.encrypt(request.getParams().getPhoneNumber(), SecurityKey.MOBILE_PHONE_KEY);
                userInfoProto.setPhoneNumber(phoneNumberNew);
            }
            UserEntity user = userService.queryByLoginName(userInfoProto.getCurrentUserName());
            List<String> channelIds = UserUtils.getChannelIds(user);
            if (channelIds != null && channelIds.size() > 0) {
                userInfoProto.setCheckedChannelIds(channelIds);
            }

            String registerStartTime = userInfoProto.getRegisterStartTime();
            String registerEndTime = userInfoProto.getRegisterEndTime();
            if (null != registerStartTime && !"".equals(registerStartTime)) {
                userInfoProto.setRegisterStartTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.parse(registerStartTime)), "yyyy-MM-dd HH:mm:ss"));
            } else {
                userInfoProto.setRegisterStartTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.lastMonth()), "yyyy-MM-dd HH:mm:ss"));
            }
            if (null != registerEndTime && !"".equals(registerEndTime)) {
                userInfoProto.setRegisterEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(registerEndTime)), "yyyy-MM-dd HH:mm:ss"));
            } else {
                userInfoProto.setRegisterEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.parse(DateUtil.today())), "yyyy-MM-dd HH:mm:ss"));
            }
            SecuritiesUserInfoEntity queryCondition = new SecuritiesUserInfoEntity();
            BeanUtils.copyProperties(userInfoProto, queryCondition);

            List<SecuritiesUserInfoEntity> userList = secUserInfoService.cusUserListExcelList(queryCondition);
            //手机号脱敏处理
            if (null != userList) {
                for (SecuritiesUserInfoEntity s : userList) {
                    if (StringUtils.isNotBlank(s.getPhoneNumber())) {
                        StringBuffer str = new StringBuffer(s.getPhoneNumber());
                        str.replace(3, 7, "****");
                        s.setPhoneNumber(str.toString());
                    }
                }
            }
            vo.setCode(BpmCommonEnum.CodeType.OK.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.OK.getMessage());
            vo.setResult(userList);
        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("获取小神用户信息列表导出数据异常", e);
        }
        return vo;
    }


    /**
     * 查询IPO融资信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryIpoFinancing")
    @SystemLog(description = "查询IPO融资信息")
    public
    @ResponseBody
    ResponseVO queryIpoFinancing(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getBatchStkCodeList()) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientIpoEntity queryCondition = new ClientIpoEntity();
            queryCondition.setBatchStkCodeList(request.getParams().getBatchStkCodeList());
            queryCondition.setType("1");

            List<ClientIpoEntity> clientIpoList = clientIpoService.queryIpoFinancing(queryCondition);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientIpoEntity info : clientIpoList) {
                resultMap = Maps.newHashMap();
                resultMap.put("stockCode", info.getStockCode());
                resultMap.put("finalAmount", info.getFinalAmount());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]查询IPO融资信息异常", e);
        }
        return vo;
    }

    /**
     * 修改客户信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/updateSecuritiesUserInfo")
    @SystemLog(description = "修改统一用户中心客户信息")
    public
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    ResponseVO updateSecuritiesUserInfo(@RequestBody(required = false) GenericSunlineRequest<SecuritiesUserInfoProto> request) {

        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(BpmCommonEnum.CodeType.ERROR.getCode());
        responseVO.setMessage("修改失败");
        SecuritiesUserInfoProto proto = request.getParams();
        if (StringUtils.isBlank(proto.getTradeAccount())) {
            responseVO.setMessage("缺少必填参数");
            return responseVO;
        }
        try {
            SecuritiesUserInfoEntity query = new SecuritiesUserInfoEntity();
            query.setTradeAccount(proto.getTradeAccount());
            SecuritiesUserInfoEntity userInfoEntity = secUserInfoService.queryObject(query);
            if (null == userInfoEntity) {
                responseVO.setMessage("该用户不存在,tradeAccount:" + query.getTradeAccount());

            } else {
                BeanUtil.copyProperties(proto, query);
                query.setId(userInfoEntity.getId());

                if (StringUtils.isNotBlank(proto.getEmail())) {
                    //校验邮箱唯一性
                    if (customerAccountOpenManager.isExistedEmail(proto.getEmail())) {
                        responseVO.setCode(1006);
                        responseVO.setMessage("邮箱地址已存在");
                        return responseVO;
                    }

                    ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
                    if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
                        SysArgResponse result = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
                        if ("6".equals(result.getSysStatus()) || "0".equals(result.getBankStatus())) {
                            responseVO.setMessage("清算时间段内，无法使用该功能");
                        } else {
                            int update = secUserInfoService.update(query);

                            if (update > 0) {
                                //修改柜台资料
                                UserInfo.AddressOperateRequest updateRequest = new UserInfo.AddressOperateRequest();
                                updateRequest.setActionIn(1);
                                updateRequest.setAddressID(userInfoEntity.getAddressId());
                                updateRequest.setClientID(userInfoEntity.getTradeAccount());
                                updateRequest.setEmail(proto.getEmail());

                                updateRequest.setAddressee(userInfoEntity.getClientName());
                                updateRequest.setShortName(userInfoEntity.getContactAddress());
                                updateRequest.setMobile(userInfoEntity.getPhoneNumber());
                                updateRequest.setPhone(userInfoEntity.getPhoneNumber());
                                updateRequest.setLocaleName(userInfoEntity.getClientName());
                                updateRequest.setLocaleAddress1(userInfoEntity.getContactProvinceName());
                                updateRequest.setLocaleAddress2(userInfoEntity.getContactCityName());
                                updateRequest.setLocaleAddress3(userInfoEntity.getContactCountyName());
                                updateRequest.setLocaleAddress4(userInfoEntity.getContactDetailAddress());

                                CommonResponse hsResponse = HsCommManageService.send("hundsunProxyService/manageAddress.do", updateRequest);

                                if (null != hsResponse && String.valueOf(CrmCommonEnum.CodeType.OK.getCode()).equals(hsResponse.getCommonErrorCode().getErrorCode())) {
                                    responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
                                    responseVO.setMessage("修改成功");
                                } else {
                                    int update1 = secUserInfoService.update(userInfoEntity);
                                    responseVO.setMessage("修改失败");
                                    logger.info("修改客户信息接口恒生返回失败：" + JSON.toJSONString(hsResponse));
                                }
                            }
                        }
                    } else {
                        logger.info("修改客户信息接口crm_api/updateSecuritiesUserInfo恒生状态查询失败：" + JSON.toJSONString(sysArg));
                        responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
                        responseVO.setMessage("柜台系统异常");
                    }
                } else {
                    int update = secUserInfoService.update(query);
                    if (update > 0) {
                        responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
                        responseVO.setMessage("修改成功");
                    }
                }
            }
        } catch (Exception e) {
            logger.info("修改客户信息接口crm_api/updateSecuritiesUserInfo异常" + JSON.toJSONString(request));
        }

        return responseVO;
    }

    /**
     * 获取恒生柜台状态
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getHsStauts", method = {RequestMethod.GET})
    @SystemLog(description = "获取恒生柜台状态")
    @ResponseBody
    public ResponseVO getHsStauts() {
        ResponseVO responseVO = new ResponseVO();

//        UserLoginRequest request = new UserLoginRequest();
//        request.setActionIn(1);
//        request.setHostName("WIN-L8UDDPI6PJO");
//        request.setIpAddr("10.2.12.60");
//
//        CommonResponse response = HsCommManageService.send("hundsunProxyService/login.do", request);
        ResponseVO sysArg = HsRestManageService.getSysArg(new GenericHsRequest<ClientFareManageRequest>());
        if (null != sysArg && CrmCommonEnum.CodeType.OK.getCode() == sysArg.getCode()) {
            SysArgResponse result = JSON.parseObject(JSON.toJSONString(sysArg.getResult()), SysArgResponse.class);
            responseVO.setCode(BpmCommonEnum.CodeType.OK.getCode());
            responseVO.setMessage("查询成功");
            Map<String, Object> hsStauts = Maps.newHashMap();
            hsStauts.put("sysStatus", result.getSysStatus());
            hsStauts.put("bankStatus", result.getBankStatus());
            responseVO.setResult(hsStauts);
        } else {
            responseVO.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            responseVO.setMessage("查询失败");
        }
        return responseVO;
    }

    /**
     * 获取客户首次转仓信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getFirstTrsTotal")
//    @SystemLog(description = "获取客户首次转仓信息")
    public
    @ResponseBody
    ResponseVO getFirstTrsTotal(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonModel> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (StrUtil.isBlank(request.getParams().getTransferStatus()) && null == request.getParams().getBatchTradeAccountList()) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            List<CrmExternalCommonModel> firstTrsTotal = uerApiService.getFirstTrsTotal(request.getParams());

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (CrmExternalCommonModel model : firstTrsTotal) {
                resultMap = Maps.newHashMap();
                resultMap.put("clientId", model.getTradeAccount());
                resultMap.put("tradeDate", model.getTradeTate());
                resultList.add(resultMap);
            }
            vo = buildListResult(resultList);
        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]获取客户首次转仓信息异常", e);
        }
        return vo;
    }

    /**
     * 获取永久免佣渠道
     *
     * @param request
     * @return
     */
    @RequestMapping("/getFreeChannel")
//    @SystemLog(description = "获取永久免佣渠道")
    public
    @ResponseBody
    ResponseVO getFreeChannel(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonModel> request) {

        ResponseVO vo = new ResponseVO();

        try {

            List<String> fareKindList = Arrays.asList(SysConfigUtil.getSysConfigValue("FREE_COMMISSION_CHANNEL_LIST", "1139,1120").split(","));

            ChannelFareSetupEntity queryCondition = new ChannelFareSetupEntity();
            queryCondition.setFareKindList(fareKindList);
            queryCondition.setAuditStatus(2);

            List<ChannelFareSetupEntity> list = channelFareSetupService.queryListByBean(queryCondition);

            Map<String, Object> resultMap = Maps.newHashMap();
            List<Object> resultList = Lists.newArrayList();

            for (ChannelFareSetupEntity info : list) {
                resultList.add(info.getChannelId());
            }

            resultMap.put("channelList", resultList);

            vo = buildMapResult(resultMap);
        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]获取永久免佣渠道异常", e);
        }
        return vo;
    }

    /**
     * 获取客户新增资金
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryAddAsset")
//    @SystemLog(description = "获取客户新增资金")
    public
    @ResponseBody
    ResponseVO queryAddDayAsset(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getBatchUserIdList() || StrUtil.isBlank(request.getParams().getTrdBeginDate())) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientFundDepositEntity queryCondition = new ClientFundDepositEntity();
            queryCondition.setBeginDate(request.getParams().getTrdBeginDate());
            queryCondition.setBatchUserIdList(request.getParams().getBatchUserIdList());

            List<ClientFundDepositEntity> fundDepTotalList = clientFundDepositService.queryAddAsset(queryCondition);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientFundDepositEntity fundDepTotal : fundDepTotalList) {
                resultMap = Maps.newHashMap();
                resultMap.put("clientId", fundDepTotal.getClientId());
                resultMap.put("addAsset", DECIMAL_FORMAT.format(fundDepTotal.getOccurBalance()));
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]获取客户新增资金异常", e);
        }
        return vo;
    }

    /**
     * 是否首次认购IPO
     *
     * @param request
     * @return
     */
    @RequestMapping("/isFirstBuyIpo")
//    @SystemLog(description = "是否首次认购IPO")
    public
    @ResponseBody
    ResponseVO isFirstBuyIpo(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getTradeAccount()) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientIpoEntity queryCondition = new ClientIpoEntity();
            queryCondition.setClientId(request.getParams().getTradeAccount());
            queryCondition.setBeginDate(request.getParams().getTrdBeginDate());
            queryCondition.setEndDate(request.getParams().getTrdEndDate());

            List<ClientIpoEntity> list = clientIpoService.queryFirstBuyIpo(queryCondition);

            Map<String, Object> resultMap = Maps.newHashMap();

            resultMap.put("tradeAccount", request.getParams().getTradeAccount());
            if (list.size() > 0) {
                resultMap.put("isFirstBuyIpo", false);
            } else {
                resultMap.put("isFirstBuyIpo", true);
            }

            vo = buildMapResult(resultMap);

        } catch (Exception e) {
            vo.setCode(BpmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(BpmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]获取客户是否首次认购IPO异常", e);
        }
        return vo;
    }

    /**
     * 获取客户资金流水
     * @param request
     * @return
     */
    @RequestMapping("/queryFundFlow")
//    @SystemLog(description = "获取指定时间内客户出入金金额")
    public
    @ResponseBody
    ResponseVO queryFundFlow(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (null == request.getParams().getBatchUserIdList() || StrUtil.isBlank(request.getParams().getTrdBeginDate())
                    || StrUtil.isBlank(request.getParams().getTrdEndDate()) || StrUtil.isBlank(request.getParams().getDepositType())) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }

            ClientFundDepositEntity queryCondition = new ClientFundDepositEntity();
            queryCondition.setDepositType(request.getParams().getDepositType());
            queryCondition.setBeginDate(request.getParams().getTrdBeginDate());
            queryCondition.setEndDate(request.getParams().getTrdEndDate());
            queryCondition.setBatchUserIdList(request.getParams().getBatchUserIdList());

            List<ClientFundDepositEntity> list = clientFundDepositService.findClientFundDepExcelList(queryCondition);

            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientFundDepositEntity info : list) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", info.getUserId());
                resultMap.put("channelId", info.getChannelId());
                resultMap.put("initDate", info.getInitDate());
                resultMap.put("depositType", info.getDepositType());
                resultMap.put("occurBalance", DECIMAL_FORMAT.format(info.getOccurBalance()));
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取指定时间内客户出入金金额异常", e);
        }
        return vo;
    }

    /**
     * 获取指定时间内客户交易汇总金额
     * @param request
     * @return
     */
    @RequestMapping("/queryFundFlowGroupList")
//    @SystemLog(description = "获取指定时间内客户交易汇总金额")
    public
    @ResponseBody
    ResponseVO queryFundFlowGroupList(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {
        ResponseVO vo = new ResponseVO();
        try {
            if (null == request.getParams().getBatchTradeAccountList() || StrUtil.isBlank(request.getParams().getTrdBeginDate())
                    || StrUtil.isBlank(request.getParams().getTrdEndDate())) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }
            ClientTradeFlowInfoEntity queryCondition = new ClientTradeFlowInfoEntity();
            queryCondition.setBeginDate(request.getParams().getTrdBeginDate());
            queryCondition.setEndDate(request.getParams().getTrdEndDate());
            queryCondition.setBatchTradeAccountList(request.getParams().getBatchTradeAccountList());
            List<ClientTradeFlowInfoEntity> list = clientTradeFlowInfoService.findTrdGroupListExcelList(queryCondition);


            Map<String, Object> resultMap;
            List<Object> resultList = Lists.newArrayList();

            for (ClientTradeFlowInfoEntity info : list) {
                resultMap = Maps.newHashMap();
                resultMap.put("userId", info.getUserId());
                resultMap.put("clientId", info.getClientId());
                //计算用户总交易金额
                resultMap.put("businessBalance", info.getBusinessBalance());
                resultList.add(resultMap);
            }

            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取指定时间内客户交易汇总金额异常", e);
        }
        return vo;
    }


    /**
     * 获取连续交易日客户资产都>X的用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryAssetGtDateClientList")
//    @SystemLog(description = "获取指定时间内客户资产流水")
    public
    @ResponseBody
    ResponseVO queryAssetGtDateClientList(@RequestBody(required = false) GenericSunlineRequest<CrmExternalCommonProto.CrmExternalCommonRequest> request) {

        ResponseVO vo = new ResponseVO();

        try {

            if (StrUtil.isBlank(request.getParams().getTrdBeginDate())
                    || StrUtil.isBlank(request.getParams().getTrdEndDate())
                    || ObjectUtil.isNull(request.getParams().getAmount())
                    ||request.getParams().getAmount().compareTo(new BigDecimal(0))<=0) {
                vo.setCode(CrmCommonEnum.CodeType.PARAMETER_ERROR.getCode());
                vo.setMessage(CrmCommonEnum.CodeType.PARAMETER_ERROR.getMessage());
                return vo;
            }
            //查询交易时间段涉及到的交易日数量
            Integer trdDayNum = stkTrdCaleService.getTrdDayNumByTrdDate(request.getParams().getTrdBeginDate(),request.getParams().getTrdEndDate());
            List<Object> resultList = Lists.newArrayList();
            if(trdDayNum>0){
                //查询满足连续交易日每天资产都大于amount 的客户
                ClientAssetFlowInfoEntity clientAssetFlowInfoEntity = new ClientAssetFlowInfoEntity();
                clientAssetFlowInfoEntity.setBeginDate(request.getParams().getTrdBeginDate());
                clientAssetFlowInfoEntity.setEndDate(request.getParams().getTrdEndDate());
                clientAssetFlowInfoEntity.setMinTotalAssets(request.getParams().getAmount());
                clientAssetFlowInfoEntity.setTradeDateNum(trdDayNum);

                resultList = clientAssetFlowInfoService.getAssetGtTradeDateClientInfoList(clientAssetFlowInfoEntity);
            }
            vo = buildListResult(resultList);

        } catch (Exception e) {
            logger.error("[crm_api]获取指定时间", e);
        }

        return vo;
    }
}
