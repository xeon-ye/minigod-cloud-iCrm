package com.sunline.modules.commission.controller;

import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.commission.entity.FarePackageSetupEntity;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.commission.service.FarePackageSetupService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.*;
import com.sunline.modules.marker.service.UserChannelInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 渠道佣金套餐设置日志表
 *
 * @author lcs
 * @date 2018-08-21 17:05:24
 */
@Controller
@RequestMapping("channelFareSetupLog")
public class ChannelFareSetupLogController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ChannelFareSetupLogService channelFareSetupLogService;
    @Autowired
    private ChannelFareSetupService channelFareSetupService;
    @Autowired
    private FarePackageSetupService farePackageSetupService;
    @Autowired
    private UserChannelInfoService channelService;
    @Autowired
    ActModelerService actModelerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @ResponseBody
//	@RequiresPermissions("channelFareSetupLog:list")
    public Result list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<ChannelFareSetupLogEntity> channelFareSetupLogList = channelFareSetupLogService.queryList(query);
        int total = channelFareSetupLogService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(channelFareSetupLogList, total, query.getLimit(), query.getPage());

        return Result.ok().put("page", pageUtil);
    }


    @RequestMapping("/acceptList")
    @RequiresPermissions("channelFareSetupLog:acceptList")
    public String acceptList(Model model, HttpServletRequest request, ChannelFareSetupLogEntity entity) {

        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page page = channelFareSetupLogService.queryAcceptList(entity, pageNum);


//        ProcessTaskDto processTaskDto = actModelerService.findProcessTaskByBusId(entity.getBusId());
//
//        model.addAttribute("processTaskDto", processTaskDto);
        model.addAttribute("page", page);
        model.addAttribute("model", entity);
        return "commission/channelAccept";
    }

    @RequestMapping("/info")
    public String info(Model model, HttpServletRequest request, ProcessTaskDto processTaskDto, ChannelFareSetupLogEntity entity, String flag) {
        if (processTaskDto.getBusId() != null && !"".equals(processTaskDto.getBusId())) {
            entity.setBusId(processTaskDto.getBusId());
        }
        List<ChannelFareSetupLogEntity> fareLogList = channelFareSetupLogService.queryByParams(entity);
        ChannelFareSetupLogEntity fareKindInfo = fareLogList.get(0);
        if (fareLogList.size() > 1) {
            ChannelFareSetupLogEntity nextFareKindInfo = fareLogList.get(1);
            FarePackageSetupEntity nextPackageInfo = farePackageSetupService.queryObject(nextFareKindInfo.getFareKind());
            model.addAttribute("nextFareKindInfo", nextFareKindInfo);
            model.addAttribute("nextPackageInfo", nextPackageInfo);
        }

        if (fareKindInfo.getLastFareKind() == null) {
            model.addAttribute("acceptView", "add");
        } else {
            model.addAttribute("acceptView", "update");
        }
        model.addAttribute("fareKindInfo", fareKindInfo);
        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("flag", flag);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        return "commission/channelAcceptDetail";
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("channelFareSetupLog:save")
    public Result save(@RequestBody ChannelFareSetupLogEntity channelFareSetupLog) {
        channelFareSetupLogService.save(channelFareSetupLog);

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("channelFareSetupLog:update")
    public Result update(@RequestBody ChannelFareSetupLogEntity channelFareSetupLog) {
        channelFareSetupLogService.update(channelFareSetupLog);

        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
//	@RequiresPermissions("channelFareSetupLog:delete")
    public Result delete(@RequestBody Integer channelIds) {
        channelFareSetupLogService.delete(channelIds);
        return Result.ok();
    }

    @RequestMapping("/viewReject")
    public String viewReject(Model model, HttpServletRequest request, ProcessTaskDto processTaskDto, ChannelFareSetupLogEntity entity, String flag) {
        if (processTaskDto.getBusId() != null && !"".equals(processTaskDto.getBusId())) {
            entity.setBusId(processTaskDto.getBusId());
        }
        List<ChannelFareSetupLogEntity> fareLogList = channelFareSetupLogService.queryByParams(entity);
        ChannelFareSetupLogEntity fareKindInfo = fareLogList.get(0);
//        FarePackageSetupEntity packageInfo = farePackageSetupService.queryObject(fareKindInfo.getFareKind());
        if (fareLogList.size() > 1) {
            ChannelFareSetupLogEntity nextFareKindInfo = fareLogList.get(1);
            FarePackageSetupEntity nextPackageInfo = farePackageSetupService.queryObject(nextFareKindInfo.getFareKind());
            model.addAttribute("nextFareKindInfo", nextFareKindInfo);
            model.addAttribute("nextPackageInfo", nextPackageInfo);
        }

        processTaskDto = actModelerService.findProcessTaskByBusId(entity.getBusId());

        if (fareKindInfo.getLastFareKind() == null) {
            model.addAttribute("acceptView", "add");
        } else {
            model.addAttribute("acceptView", "update");
        }
        model.addAttribute("fareKindInfo", fareKindInfo);
//        model.addAttribute("packageInfo", packageInfo);
        model.addAttribute("processTaskDto", processTaskDto);
        model.addAttribute("flag", flag);
        model.addAttribute("currentUserId", UserUtils.getCurrentUserId());
        return "commission/channelAcceptDetailViewReject";
    }

    /**
     * 终止流程页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/reject")
    @RequiresPermissions("channelFareSetupLog:reject")
    @ResponseBody
    public Result reject(Model model, String remark, String busId, String taskId, String defId, String instanceId) {
        Result result;

        try {

            ProcessTaskDto processTaskDto = new ProcessTaskDto();
            processTaskDto.setBusId(busId);
            processTaskDto.setTaskId(taskId);
            processTaskDto.setDefId(defId);
            processTaskDto.setInstanceId(instanceId);
            processTaskDto.setRemark(remark);

            ChannelFareSetupEntity channelFareSetupEntity = new ChannelFareSetupEntity();
            ChannelFareSetupLogEntity channelFareSetupLogEntity = new ChannelFareSetupLogEntity();

            channelFareSetupEntity.setBusId(processTaskDto.getBusId());
            channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex());
            channelFareSetupEntity.setAuditTime(new Date());
            channelFareSetupEntity.setUpdateTime(new Date());

            channelFareSetupLogEntity.setBusId(processTaskDto.getBusId());
            channelFareSetupLogEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex());
            channelFareSetupLogEntity.setAuditTime(new Date());
            channelFareSetupLogEntity.setUpdateTime(new Date());

            channelFareSetupService.updateByBusId(channelFareSetupEntity);
            channelFareSetupLogService.updateByBusId(channelFareSetupLogEntity);

            actModelerService.terminationFlow(processTaskDto);
            result = Result.ok(Constant.RESULT.CODE_YES.getValue(), "终止成功");
        } catch (Exception e) {
            result = Result.error("终止失败");
            logger.error("终止失败", e);
        }

        return result;
    }

}
