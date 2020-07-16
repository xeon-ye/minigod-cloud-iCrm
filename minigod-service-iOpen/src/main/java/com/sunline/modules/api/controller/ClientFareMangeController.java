package com.sunline.modules.api.controller;

import com.sunline.modules.api.protocol.ClientFareCommonProto;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ClientFreeCommSetEntity;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.commission.service.ClientFreeCommSetService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.pojo.rest.GenericSunlineRequest;
import com.sunline.modules.common.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 客户佣金费率管理外部接口定义
 * @author: Larry Lai
 * @date: 2018/8/21 20:03
 * @version: v1.0
 */

@Controller
@RequestMapping("/crm_api")
public class ClientFareMangeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ClientFreeCommSetService clientFreeCommSetService;

    @Autowired
    private ChannelFareSetupService channelFareSetupService;

    /**
     * 新增客户免佣信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/addClientFreeComm")
    public
    @ResponseBody
    ResponseVO addClientFreeComm(@RequestBody(required = false) GenericSunlineRequest<ClientFareCommonProto.ClientFreeCommRequest> request) {

        ResponseVO vo = new ResponseVO();
        try {

            // 非开户免佣不受客户所属渠道免佣配置限制
            if (request.getParams().getFreeCommType() != 0) {
                ClientFreeCommSetEntity clientFreeCommSetEntity = new ClientFreeCommSetEntity();

                // 构造客户免佣参数
                clientFreeCommSetEntity.setClientId(request.getParams().getClientId());
                clientFreeCommSetEntity.setFundAccount(request.getParams().getFundAccount());
                clientFreeCommSetEntity.setExchangeType(request.getParams().getExchangeType());
                clientFreeCommSetEntity.setFreeCommType(request.getParams().getFreeCommType());
                clientFreeCommSetEntity.setBeginDate(DATE_FORMAT.parse(request.getParams().getBeginDate()));
                clientFreeCommSetEntity.setEndDate(DATE_FORMAT.parse(request.getParams().getEndDate()));
                clientFreeCommSetEntity.setCreateUser(Constant.SUPERR_USER);
                clientFreeCommSetEntity.setUpdateUser(Constant.SUPERR_USER);
                clientFreeCommSetEntity.setAuditUser(Constant.SUPERR_USER);
                clientFreeCommSetEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
                clientFreeCommSetEntity.setAuditTime(new Date());
                clientFreeCommSetEntity.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_UNTREATED.getIndex());
                clientFreeCommSetEntity.setCreateTime(new Date());
                clientFreeCommSetEntity.setUpdateTime(new Date());

                int count = clientFreeCommSetService.save(clientFreeCommSetEntity);

                if (count > 0) {
                    vo.setCode(CrmCommonEnum.CodeType.OK.getCode());
                    vo.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
                } else {
                    vo.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
                    vo.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
                }
            } else {

                // 查询客户所属渠道免佣配置
                ChannelFareSetupEntity channelFareSetupEntity = channelFareSetupService.getClientFreeCommConfig(request.getParams().getClientId());

                if (null != channelFareSetupEntity && channelFareSetupEntity.getIsFreeCommission() == 1) {

                    ClientFreeCommSetEntity clientFreeCommSetEntity = new ClientFreeCommSetEntity();

                    // 构造客户免佣参数
                    clientFreeCommSetEntity.setClientId(request.getParams().getClientId());
                    clientFreeCommSetEntity.setFundAccount(request.getParams().getFundAccount());
                    clientFreeCommSetEntity.setExchangeType(request.getParams().getExchangeType());
                    clientFreeCommSetEntity.setFreeCommType(request.getParams().getFreeCommType());
                    clientFreeCommSetEntity.setBeginDate(DATE_FORMAT.parse(request.getParams().getBeginDate()));
                    clientFreeCommSetEntity.setEndDate(DATE_FORMAT.parse(request.getParams().getEndDate()));
                    clientFreeCommSetEntity.setCreateUser(Constant.SUPERR_USER);
                    clientFreeCommSetEntity.setUpdateUser(Constant.SUPERR_USER);
                    clientFreeCommSetEntity.setAuditUser(Constant.SUPERR_USER);
                    clientFreeCommSetEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
                    clientFreeCommSetEntity.setAuditTime(new Date());
                    clientFreeCommSetEntity.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_UNTREATED.getIndex());
                    clientFreeCommSetEntity.setCreateTime(new Date());
                    clientFreeCommSetEntity.setUpdateTime(new Date());

                    int count = clientFreeCommSetService.save(clientFreeCommSetEntity);

                    if (count > 0) {
                        vo.setCode(CrmCommonEnum.CodeType.OK.getCode());
                        vo.setMessage(CrmCommonEnum.CodeType.OK.getMessage());
                    } else {
                        vo.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
                        vo.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
                    }
                } else {
                    vo.setCode(1001);
                    vo.setMessage("该客户所属渠道不能参与开户免佣活动");
                }
            }

        } catch (Exception e) {
            vo.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]新增客户免佣信息异常", e);
            return vo;
        }
        return vo;
    }


    /**
     * 查询客户开户免佣配置
     * @param request
     * @return
     */
    @RequestMapping("/qryClientFreeCommSetup")
    public
    @ResponseBody
    ResponseVO qryClientFreeCommSetup(@RequestBody(required = false) GenericSunlineRequest<ClientFareCommonProto.ClientFreeCommRequest> request) {

        ResponseVO vo = new ResponseVO();
        try {

                // 查询客户所属渠道免佣配置
                ChannelFareSetupEntity channelFareSetupEntity = channelFareSetupService.getClientFreeCommConfig(request.getParams().getClientId());

                if (null != channelFareSetupEntity && channelFareSetupEntity.getIsFreeCommission() == 1) {
                    vo.setCode(1001);
                    vo.setMessage("该客户所属渠道可以参与开户免佣活动");
                } else {
                    vo.setCode(1002);
                    vo.setMessage("该客户所属渠道不能参与开户免佣活动");
                }

        } catch (Exception e) {
            vo.setCode(CrmCommonEnum.CodeType.INTERNAL_ERROR.getCode());
            vo.setMessage(CrmCommonEnum.CodeType.INTERNAL_ERROR.getMessage());
            logger.error("[crm_api]查询客户开户免佣配置异常", e);
            return vo;
        }
        return vo;
    }
}
