package com.sunline.modules.activiti.controller;

import com.google.common.collect.Maps;
import com.sunline.modules.account.online.entity.CustomerAccountOpenInfoEntity;
import com.sunline.modules.account.online.service.CustomerAccOpenApplyService;
import com.sunline.modules.account.online.service.CustomerAccOpenInfoService;
import com.sunline.modules.activiti.dto.ProcessNodeDto;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActFlowbusEntity;
import com.sunline.modules.activiti.entity.ExtendActModelEntity;
import com.sunline.modules.activiti.entity.ExtendActNodesetEntity;
import com.sunline.modules.activiti.entity.ExtendActTasklogEntity;
import com.sunline.modules.activiti.helper.ExtendActBusinessHelper;
import com.sunline.modules.activiti.service.*;
import com.sunline.modules.common.exception.MyException;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.sys.entity.UserEntity;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类的功能描述.
 * 流程办理相关操作
 *
 * @Auther hxy
 * @Date 2017/7/11
 */
@Controller
@RequestMapping("act/deal")
public class ExtendActDealController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ExtendActModelerService extendActModelService;

    @Autowired
    ActModelerService actModelerService;

    @Autowired
    ExtendActNodesetService nodesetService;

    @Autowired
    ExtendActTasklogService tasklogService;

    @Autowired
    TaskService taskService;

    @Autowired
    ExtendActFlowbusService flowbusService;

    @Autowired
    CustomerAccOpenApplyService customerAccOpenApplyService;

    @Autowired
    CustomerAccOpenInfoService customerAccOpenInfoService;

    /**
     * 列表
     *
     * @param model
     * @param actModelEntity
     * @param request
     * @return
     */
    @RequestMapping("list")
    public String list(Model model, ExtendActModelEntity actModelEntity, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<ExtendActModelEntity> page = extendActModelService.findPage(actModelEntity, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("model", actModelEntity);
        return "activiti/extendActModelList";
    }

    /**
     * 根据流程key 获取业务可用的流程
     *
     * @param model
     * @param actKey
     * @param busId
     * @return
     */
    @RequestMapping("queryFlowsByActKey")
    public String queryFlowsByActKey(Model model, String actKey, String busId) {
        List<Map<String, Object>> defs = actModelerService.queryFlowsByActKey(actKey);
        model.addAttribute("defList", defs);
        model.addAttribute("busId", busId);
        model.addAttribute("actKey", actKey);
        return "activiti/flowSubmit";
    }

    /**
     * 获取当前节点可选择的审批人
     *
     * @param model
     * @param actKey
     * @param busId
     * @return
     */
    @RequestMapping("getUsers")
    public String getUsers(Model model, String actKey, String busId) {
        List<Map<String, Object>> defs = actModelerService.queryFlowsByActKey(actKey);
        model.addAttribute("defList", defs);
        model.addAttribute("busId", busId);
        model.addAttribute("actKey", actKey);
        return "activiti/flowSubmit";
    }

    /**
     * 获取流程第一个节点信息
     *
     * @param deployId 部署id
     * @return
     */
    @RequestMapping(value = "getStartFlowInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result getStartFlowInfo(String deployId) {
        Result result = new Result();
        try {
            result = actModelerService.getStartFlowInfo(deployId);
        } catch (IOException e) {
            logger.error("获取第一个节点信息失败", e);
            result = Result.error("获取第一个节点信息失败");
        }
        return result;
    }

    /**
     * 流程选择审批人窗口
     *
     * @param nodeId
     * @param user
     * @return
     */
    @RequestMapping(value = "userWindow")
    public String userWindow(String nodeId, String nodeAction, HttpServletRequest request, UserEntity user, Model model) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<UserEntity> mapPage = actModelerService.userWindowPage(nodeId, pageNum, user.getUserName());
        model.addAttribute("page", mapPage);
        model.addAttribute("url", "/act/deal/userWindow");
        model.addAttribute("flag", nodeAction);
        model.addAttribute("user", user);
        return "activiti/userWindow";
    }

    /**
     * 转办变更人选择弹框
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "turnUserWindow")
    public String turnUserWindow(UserEntity user, HttpServletRequest request, Model model) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Page<UserEntity> mapPage = actModelerService.turnWindowPage(pageNum, user);
        model.addAttribute("page", mapPage);
        //1 为单选 2为复选
        model.addAttribute("flag", "1");
        model.addAttribute("url", "/act/deal/turnUserWindow");
        model.addAttribute("user", user);
        return "activiti/userWindow";
    }

    /**
     * 启动流程
     *
     * @param processTaskDto 完成任务dto
     * @return
     */
    @RequestMapping(value = "startFlow", method = RequestMethod.POST)
    @ResponseBody
    public Result startFlow(ProcessTaskDto processTaskDto) {
        Result result = null;
        try {
            actModelerService.startFlow(processTaskDto);
            result = Result.ok("提交成功!");
        } catch (Exception e) {
            logger.error("提交失败", e);
            result = Result.error("提交失败");
        }
        return result;
    }

    /**
     * 获取实时流程图
     *
     * @param processInstanceId 流程实例
     * @return
     */
    @RequestMapping(value = "showFlowImg", method = RequestMethod.GET)
    @ResponseBody
    public Result showFlowImg(String processInstanceId, HttpServletResponse response) {
        if (org.apache.commons.lang3.StringUtils.isBlank(processInstanceId)) {
            return new Result().put("-1", "流程实例为空");
        }
        try {
            InputStream inputStream = actModelerService.getFlowImgByInstantId(processInstanceId);
            //输出到页面
            byte[] b = new byte[1024];
            int len;
            while ((len = inputStream.read(b, 0, 1024)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
        } catch (IOException e) {
            logger.error("获取实时流程图异常", e);
        }
        return null;
    }


    /**
     * 我的待办列表
     *
     * @param model
     * @param code
     * @param busId
     * @param request
     * @return
     */
    @RequestMapping("myUpcoming")
    @RequiresPermissions("act:model:myUpcoming")
    public String myUpcoming(Model model, String code, String busId, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Map<String, Object> params = Maps.newHashMap();
        params.put("code", code);
        params.put("busId", busId);
        Page<ExtendActModelEntity> page = actModelerService.findMyUpcomingPage(params, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("code", code);
        model.addAttribute("busId", busId);
        return "activiti/myUpcoming";
    }

    /**
     * 我的已办列表
     *
     * @param model
     * @param code
     * @param busId
     * @param request
     * @return
     */
    @RequestMapping("myDoneList")
    @RequiresPermissions("act:model:myUpcoming")
    public String myDoneList(Model model, String code, String busId, HttpServletRequest request) {
        int pageNum = Utils.parseInt(request.getParameter("pageNum"), 1);
        Map<String, Object> params = Maps.newHashMap();
        params.put("code", code);
        params.put("busId", busId);
        Page<ExtendActModelEntity> page = actModelerService.myDonePage(params, pageNum);
        model.addAttribute("page", page);
        model.addAttribute("code", code);
        model.addAttribute("busId", busId);
        return "activiti/myDoneList";
    }

    /**
     * 办理任务Tab
     *
     * @param model
     * @param flag    1为查看审批记录，2为办理任务
     * @param request
     * @return
     */
    @RequestMapping("flowInfoTab")
    public String flowInfoTab(String flag, ProcessTaskDto processTaskDto, Model model, HttpServletRequest request) {
        String approveTaskPageUri = ExtendActBusinessHelper.getApproveTaskPageUri(processTaskDto.getActKey());
        model.addAttribute("approveTaskPageUri", approveTaskPageUri);
        model.addAttribute("flag", flag);
        model.addAttribute("taskDto", processTaskDto);

        return "activiti/flowInfoTab";
    }


    /**
     * 流程信息
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "flowInfoHtml", method = RequestMethod.POST)
    public String flowInfoHtml(Model model, HttpServletRequest request, String busId, String instanceId) {
    	
        Map<String, Object> params = Maps.newHashMap();
        params.put("busId", busId);
        List<ExtendActTasklogEntity> tasklogEntities = tasklogService.queryList(params);
        model.addAttribute("taskLogs", tasklogEntities);
        model.addAttribute("instanceId", instanceId);
         
        
        return "activiti/taskLogImg";
    }

    /**
     * 办理任务时查询业务可更改的字段和必要的流程相关信息
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "getChangeFileds", method = RequestMethod.POST)
    @ResponseBody
    public Result getChangeFileds(ProcessTaskDto processTaskDto) {
        if (StringUtils.isEmpty(processTaskDto.getTaskId())) {
            throw new MyException("任务id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getInstanceId())) {
            throw new MyException("流程实例id不能为空");
        }
        if (StringUtils.isEmpty(processTaskDto.getDefId())) {
            throw new MyException("流程定义id不能为空");
        }
        Task task = taskService.createTaskQuery().taskId(processTaskDto.getTaskId()).singleResult();
        //查询可更改字段
        ExtendActNodesetEntity nodesetEntity = nodesetService.queryByNodeId(task.getTaskDefinitionKey());
        //查询需要作为流程条件判断的字段
        Set<String> nextVarNams = actModelerService.getNextVarNams(task.getTaskDefinitionKey(), processTaskDto.getDefId());
        String[] changFile = {};
        if (!StringUtils.isEmpty(nodesetEntity.getChangeFiles())) {
            changFile = nodesetEntity.getChangeFiles().split(",");
        }
        return Result.ok().put("changeFields", changFile).put("vars", nextVarNams);
    }

    /**
     * 办理任务时，获取下一个节点的信息
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "getNextActNodes", method = RequestMethod.POST)
    @ResponseBody
    public Result getNextActNodes(ProcessTaskDto processTaskDto) {
        List<ProcessNodeDto> nextActNodes = actModelerService.getNextActNodes(processTaskDto);
        return Result.ok().put("nextActNodes", nextActNodes);
    }

    /**
     * 转到审批任务选择下一级审批者页面
     *
     * @param processTaskDto
     * @param model
     * @return
     */
    @RequestMapping(value = "toDoActTaskView")
    public String toDoActTaskView(ProcessTaskDto processTaskDto, Model model) {
        Task task = taskService.createTaskQuery().taskId(processTaskDto.getTaskId()).singleResult();
        //查询需要作为流程条件判断的字段
        Set<String> nextVarNams = actModelerService.getNextVarNams(task.getTaskDefinitionKey(), processTaskDto.getDefId());
        //查询可更改字段
        ExtendActNodesetEntity nodesetEntity = nodesetService.queryByNodeId(task.getTaskDefinitionKey());
        //查询流程基本信息
        ExtendActFlowbusEntity flowbus = flowbusService.queryByBusIdInsId(processTaskDto.getInstanceId(), processTaskDto.getBusId());
        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("nodeSet", nodesetEntity);
        model.addAttribute("flowbus", flowbus);
        return "activiti/doActTask";
    }

    /**
     * 办理任务
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "doActTask", method = RequestMethod.POST)
    @ResponseBody
    public Result doActTask(ProcessTaskDto processTaskDto, HttpServletRequest request) {
        Result result = null;
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
                for (String key : parameterMap.keySet()) {
                params.put(key, parameterMap.get(key)[0]);
            }

            actModelerService.doActTask(processTaskDto, params);

            if ("2".equals(params.get("applicationStatus"))){
                CustomerAccountOpenInfoEntity customerAccountOpenInfo = new CustomerAccountOpenInfoEntity();
                customerAccountOpenInfo.setApplicationId((String) params.get("applicationId"));
                String stockTradeAccount = (String) params.get("stockTradeAccount");
                if (org.apache.commons.lang3.StringUtils.isNotBlank(stockTradeAccount)){
                    customerAccountOpenInfo.setStockTradeAccount(stockTradeAccount);
                }
                String futuresTradeAccount = (String) params.get("futuresTradeAccount");
                if (org.apache.commons.lang3.StringUtils.isNotBlank(futuresTradeAccount)){
                    customerAccountOpenInfo.setFuturesTradeAccount((String) params.get("futuresTradeAccount"));
                }

                boolean setTradeAccount = (stockTradeAccount == null && futuresTradeAccount == null);
                if (setTradeAccount){
                    customerAccOpenInfoService.setTradeAccount(customerAccountOpenInfo);
                }
            }
            result = Result.ok("操作成功");
        } catch (Exception e) {
            logger.error("操作失败", e);
            result = Result.error("办理任务失败");
        }
        return result;
    }

    /**
     * 驳回到任务发起人，重新编辑提交
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "backStartUser", method = RequestMethod.POST)
    @ResponseBody
    public Result backStartUser(ProcessTaskDto processTaskDto, HttpServletRequest request) {
        Result result = null;
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
            for (String key : parameterMap.keySet()) {
                params.put(key, parameterMap.get(key)[0]);
            }
            actModelerService.endFailFolw(processTaskDto, params);
            result = Result.ok("驳回到发起人成功");
        } catch (Exception e) {
            logger.error("驳回到发起人失败", e);
            result = Result.error("驳回到发起人失败");
        }
        return result;
    }

    /**
     * 退回任务上一处理节点
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "backPrevious", method = RequestMethod.POST)
    @ResponseBody
    public Result backPrevious(ProcessTaskDto processTaskDto, HttpServletRequest request) {
        Result result = null;
        try {

            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, Object> params = new LinkedCaseInsensitiveMap<>();
            for (String key : parameterMap.keySet()) {
                params.put(key, parameterMap.get(key)[0]);
            }

            actModelerService.backPreviousNode(processTaskDto);
            result = Result.ok("退回上一步成功");
        } catch (Exception e) {
            logger.error("退回上一步失败", e);
            result = Result.error("退回上一步失败");
        }
        return result;
    }

    /**
     * 转到转办页面
     *
     * @param processTaskDto
     * @param model
     * @return
     */
    @RequestMapping(value = "toTurnToDo")
    public String toTurnToDo(ProcessTaskDto processTaskDto, Model model) {
        //查询流程基本信息
        ExtendActFlowbusEntity flowbus = flowbusService.queryByBusIdInsId(processTaskDto.getInstanceId(), processTaskDto.getBusId());
        model.addAttribute("taskDto", processTaskDto);
        model.addAttribute("flowbus", flowbus);
        return "activiti/trunTask";
    }

    /**
     * 转办
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "turnToDo", method = RequestMethod.POST)
    @ResponseBody
    public Result turnToDo(ProcessTaskDto processTaskDto, String toUserId, HttpServletRequest request) {
        Result result;
        try {
            actModelerService.turnToDo(processTaskDto, toUserId);
            result = Result.ok("转办任务成功");
        } catch (Exception e) {
            logger.error("转办任务失败", e);
            result = Result.error("转办任务失败");
        }
        return result;
    }

    /**
     * 申请办理任务
     *
     * @param processTaskDto
     * @return
     */
    @RequestMapping(value = "applyTaskHandle", method = RequestMethod.POST)
    @ResponseBody
    public Result applyTaskHandle(ProcessTaskDto processTaskDto, String toUserId, HttpServletRequest request) {
        Result result;
        try {
            result = actModelerService.applyTaskHandle(processTaskDto, toUserId);
        } catch (Exception e) {
            logger.error("申请办理失败", e);
            result = Result.error("申请办理失败");
        }
        return result;
    }
  

}
