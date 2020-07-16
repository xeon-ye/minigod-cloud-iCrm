package com.sunline.modules.commission.controller;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.commission.entity.ClientFareSetupEntity;
import com.sunline.modules.commission.entity.ClientFareSetupLogEntity;
import com.sunline.modules.commission.service.ClientFareSetupLogService;
import com.sunline.modules.commission.service.ClientFareSetupService;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.CodeUtils;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.customer.entity.ClientFareListEntity;
import com.sunline.modules.customer.enums.CustomerEnums;
import com.sunline.modules.customer.service.ClientFareListService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 客户佣金套餐设置表
 *
 * @author LCS
 * @date 2018-08-24 14:09:42
 */
@Controller
@RequestMapping("clientFareSetup")
public class ClientFareSetupController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientFareSetupService clientFareSetupService;
    @Autowired
    private ClientFareListService ClientFareListService;
    @Autowired
    private ClientFareSetupLogService ClientFareLogService;

    @Autowired
    ActModelerService actModelerService;
    private final String CLEINT_FARE_SET_FLOW_MODEL_KEY = "clientFareSetApprove";


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("clientFareSetup:info")
    public Result info(@PathVariable("id") Integer id) {
        ClientFareSetupEntity clientFareSetup = clientFareSetupService.queryObject(id);

        return Result.ok().put("clientFareSetup", clientFareSetup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
//	@RequiresPermissions("clientFareSetup:save")
    public Result save(@RequestBody ClientFareSetupEntity clientFareSetup) {
        try {
            ClientFareListEntity clientFareListEntity = new ClientFareListEntity();
            clientFareListEntity.setClientId(Integer.parseInt(clientFareSetup.getClientId()));
            clientFareListEntity.setExchangeType(clientFareSetup.getExchangeType());
            clientFareListEntity = ClientFareListService.queryByBean(clientFareListEntity);

            String busId = UUID.randomUUID().toString().replace("-", "");
            String code = Utils.getCode("D");

            if (clientFareListEntity != null) {
                clientFareSetup.setBusId(busId);
                clientFareSetup.setCode(code);
                clientFareSetup.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                clientFareSetup.setExchangeType(clientFareListEntity.getExchangeType());
                clientFareSetup.setFundAccount(clientFareListEntity.getFundAccount().toString());
                clientFareSetup.setBeginDate(clientFareListEntity.getBeginDate());
                clientFareSetup.setEndDate(clientFareListEntity.getEndDate());
                clientFareSetup.setCreateUser(UserUtils.getCurrentUser().getUserName());
                clientFareSetup.setUpdateUser(UserUtils.getCurrentUser().getUserName());
                clientFareSetup.setCreateTime(new Date());
                clientFareSetup.setUpdateTime(new Date());
            }
            int count = 0;
            count = clientFareSetupService.save(clientFareSetup);
            if (count > 0) {
                ClientFareSetupLogEntity logEntity = new ClientFareSetupLogEntity();
                logEntity.setBusId(clientFareSetup.getBusId());
                logEntity.setCode(clientFareSetup.getCode());
                logEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                logEntity.setClientId(clientFareSetup.getClientId());
                logEntity.setExchangeType(clientFareSetup.getExchangeType());
                logEntity.setBeginDate(clientFareSetup.getBeginDate());
                logEntity.setEndDate(clientFareSetup.getEndDate());
                logEntity.setFundAccount(clientFareSetup.getFundAccount());
                logEntity.setFareKind(clientFareSetup.getFareKind());
                logEntity.setLastFareKind(clientFareSetup.getLastFareKind());
                logEntity.setOpFlag("0");
                logEntity.setCreateUser(clientFareSetup.getCreateUser());
                logEntity.setUpdateUser(clientFareSetup.getUpdateUser());
                logEntity.setCreateTime(new Date());
                logEntity.setUpdateTime(new Date());
                count = ClientFareLogService.save(logEntity);
            }
            if (count > 0) {
                ProcessDefinition channelFareSetupDefinition = ActUtils.getlastProcessDefinition(CLEINT_FARE_SET_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(channelFareSetupDefinition.getId());
                processTaskDto.setBusId(busId);
                processTaskDto.setActKey(channelFareSetupDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);

                return Result.ok("变更套餐成功！");
            }

        } catch (Exception e) {
            logger.error("变更套餐异常", e);
        }
        return Result.error("变更套餐失败！");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    //	@RequiresPermissions("clientFareSetup:update")
    public Result update(@RequestBody ClientFareSetupEntity clientFareSetup) {
        try {
            String busId = UUID.randomUUID().toString().replace("-", "");
            String code = Utils.getCode("D");
            clientFareSetup.setBusId(busId);
            clientFareSetup.setCode(code);
            clientFareSetup.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
            clientFareSetup.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_UNTREATED.getIndex());
            clientFareSetup.setCreateUser(UserUtils.getCurrentUser().getUserName());
            clientFareSetup.setUpdateUser(UserUtils.getCurrentUser().getUserName());
            clientFareSetup.setCreateTime(new Date());
            clientFareSetup.setUpdateTime(new Date());
            int count = clientFareSetupService.update(clientFareSetup);
            ClientFareListEntity clientFareListEntity = new ClientFareListEntity();
            clientFareListEntity.setClientId(Integer.parseInt(clientFareSetup.getClientId()));
            clientFareListEntity.setExchangeType(clientFareSetup.getExchangeType());
            clientFareListEntity = ClientFareListService.queryByBean(clientFareListEntity);
            if (clientFareListEntity != null) {
                ClientFareSetupLogEntity logEntity = new ClientFareSetupLogEntity();
                logEntity.setBusId(clientFareSetup.getBusId());
                logEntity.setCode(clientFareSetup.getCode());
                logEntity.setAuditStatus(clientFareSetup.getAuditStatus());
                logEntity.setSyncStatus(clientFareSetup.getSyncStatus());
                logEntity.setClientId(clientFareListEntity.getClientId().toString());
                logEntity.setExchangeType(clientFareListEntity.getExchangeType());
                logEntity.setBeginDate(clientFareListEntity.getBeginDate());
                logEntity.setEndDate(clientFareListEntity.getEndDate());
                logEntity.setFundAccount(clientFareListEntity.getFundAccount().toString());
                logEntity.setFareKind(clientFareSetup.getFareKind());
                logEntity.setLastFareKind(clientFareSetup.getLastFareKind());
                logEntity.setOpFlag("1");
                logEntity.setCreateUser(UserUtils.getCurrentUser().getUserName());
                logEntity.setUpdateUser(UserUtils.getCurrentUser().getUserName());
                logEntity.setCreateTime(new Date());
                logEntity.setUpdateTime(new Date());
                count = ClientFareLogService.save(logEntity);
            }
            if (count > 0) {

                ProcessDefinition channelFareSetupDefinition = ActUtils.getlastProcessDefinition(CLEINT_FARE_SET_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(channelFareSetupDefinition.getId());
                processTaskDto.setBusId(busId);
                processTaskDto.setActKey(channelFareSetupDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);

                return Result.ok("变更套餐成功");
            }

        } catch (Exception e) {
            logger.error("变更套餐异常", e);
        }
        return Result.error("变更套餐失败");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clientFareSetup:delete")
    public Result delete(@RequestBody Integer[] ids) {
        clientFareSetupService.deleteBatch(ids);

        return Result.ok();
    }

    /**
     * 查询是否 处于 审核中
     * @param clientId
     * @return
     */
    @RequestMapping("/checkAuditStatus")
    @ResponseBody
    public Result checkAuditStatus(@RequestBody  String clientId) {

        ClientFareSetupEntity params= new ClientFareSetupEntity();
        params.setClientId(clientId);
        params.setAuditStatus(1);

        List<ClientFareSetupEntity>  resultList = clientFareSetupService.checkAuditStatus(params);

        if(null == resultList || resultList.size()==0){
            return Result.ok();
        }
        return Result.error("-2","渠道佣金方案尚未通过审核，暂时无法变更！");
    }

}
