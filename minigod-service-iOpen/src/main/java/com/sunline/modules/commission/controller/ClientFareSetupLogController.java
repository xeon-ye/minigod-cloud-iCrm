package com.sunline.modules.commission.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.commission.entity.*;
import com.sunline.modules.commission.service.ClientFareSetupLogService;
import com.sunline.modules.commission.service.ClientFareSetupService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.page.PageHelper;
import com.sunline.modules.common.utils.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 客户佣金套餐设置日志表
 *
 * @author LCS
 * @date 2018-08-24 14:09:42
 */
@Controller
@RequestMapping("clientFareSetupLog")
public class ClientFareSetupLogController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientFareSetupLogService clientFareSetupLogService;
    @Autowired
    private ClientFareSetupService clientFareSetupService;

    @Autowired
    ActModelerService actModelerService;

    /**
     * 历史记录列表
     */
    @RequestMapping("/list")
//	@RequiresPermissions("clientFareSetupLog:list")
    public String list(Model model, HttpServletRequest request, ClientFareSetupLogEntity entity) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page page = clientFareSetupLogService.queryList(entity, pageNum);

        model.addAttribute("page", page);
        model.addAttribute("model", entity);
        return "commission/clientFareHistory";
    }

    /**
     * 个人业务受理页面
     */
    @RequestMapping("/acceptList")
	@RequiresPermissions("clientFareSetupLog:acceptList")
    public String acceptList(Model model, HttpServletRequest request, ClientFareSetupLogEntity entity) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page page = clientFareSetupLogService.queryAcceptList(entity, pageNum);
//        ProcessTaskDto processTaskDto = actModelerService.findProcessTaskByBusId(entity.getBusId());
//
//        model.addAttribute("processTaskDto", processTaskDto);
        model.addAttribute("page", page);
        model.addAttribute("model", entity);
        return "commission/clientAccept";
    }

    @RequestMapping("/info")
    public String info(Model model, HttpServletRequest request, ProcessTaskDto processTaskDto, ClientFareSetupLogEntity entity, String flag) {
        if (processTaskDto.getBusId() != null && !"".equals(processTaskDto.getBusId())) {
            entity.setBusId(processTaskDto.getBusId());
        }
        ClientFareSetupLogEntity clientFareInfo = clientFareSetupLogService.queryClientFareInfo(entity);
        model.addAttribute("clientFareInfo", clientFareInfo);
        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("flag", flag);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        return "commission/clientAcceptDetail";
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("clientFareSetupLog:save")
    public Result save(@RequestBody ClientFareSetupLogEntity clientFareSetupLog) {
        clientFareSetupLogService.save(clientFareSetupLog);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("clientFareSetupLog:update")
    public Result update(@RequestBody ClientFareSetupLogEntity clientFareSetupLog) {
        clientFareSetupLogService.update(clientFareSetupLog);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("clientFareSetupLog:delete")
    public Result delete(@RequestBody Integer[] ids) {
        clientFareSetupLogService.deleteBatch(ids);

        return Result.ok();
    }

    @RequestMapping("/viewReject")
    public String viewReject(Model model, HttpServletRequest request, ProcessTaskDto processTaskDto, ClientFareSetupLogEntity entity, String flag) {
        if (processTaskDto.getBusId() != null && !"".equals(processTaskDto.getBusId())) {
            entity.setBusId(processTaskDto.getBusId());
        }

        processTaskDto = actModelerService.findProcessTaskByBusId(entity.getBusId());

        ClientFareSetupLogEntity clientFareInfo = clientFareSetupLogService.queryClientFareInfo(entity);
        model.addAttribute("clientFareInfo", clientFareInfo);
        model.addAttribute("processTaskDto", processTaskDto);
        model.addAttribute("flag", flag);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        return "commission/clientAcceptDetailViewReject";
    }

    /**
     * 终止流程页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/reject")
    @RequiresPermissions("clientFareSetupLog:reject")
    @ResponseBody
    public Result reject(Model model, String id, String remark, String busId, String taskId, String defId, String instanceId) {
        Result result;

        try {

            ProcessTaskDto processTaskDto = new ProcessTaskDto();
            processTaskDto.setBusId(busId);
            processTaskDto.setTaskId(taskId);
            processTaskDto.setDefId(defId);
            processTaskDto.setInstanceId(instanceId);
            processTaskDto.setRemark(remark);

            ClientFareSetupEntity clientFareSetupEntity = new ClientFareSetupEntity();
            ClientFareSetupLogEntity clientFareSetupLogEntity = new ClientFareSetupLogEntity();

            clientFareSetupEntity.setBusId(processTaskDto.getBusId());
            clientFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex());
            clientFareSetupEntity.setSyncTime(new Date());
            clientFareSetupEntity.setUpdateTime(new Date());

            clientFareSetupLogEntity.setBusId(processTaskDto.getBusId());
            clientFareSetupLogEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex());
            clientFareSetupLogEntity.setSyncTime(new Date());
            clientFareSetupLogEntity.setUpdateTime(new Date());

            clientFareSetupService.updateByBusId(clientFareSetupEntity);
            clientFareSetupLogService.updateByBusId(clientFareSetupLogEntity);

            actModelerService.terminationFlow(processTaskDto);
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "终止成功");
        } catch (Exception e) {
            result = Result.error("终止失败");
            logger.error("终止失败", e);
        }

        return result;
    }

}
