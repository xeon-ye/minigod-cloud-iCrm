package com.sunline.modules.activiti.service;

import com.sunline.modules.activiti.dto.ProcessNodeDto;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.entity.ExtendActModelEntity;
import com.sunline.modules.common.page.Page;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.sys.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 类的功能描述.
 * activiti模型接口类
 *
 * @Auther hxy
 * @Date 2017/7/18
 */

public interface ActModelerService {
    /**
     * 创建模型
     *
     * @param extendActModelEntity
     * @return
     */
    String createModeler(ExtendActModelEntity extendActModelEntity) throws Exception;

    /**
     * 获取流程图所有节点和连线
     *
     * @param modelId 模型id
     * @return
     */
    List<Map<String, String>> getFlows(String modelId) throws Exception;

    /**
     * 查看流程图片
     *
     * @param modelId
     * @return
     */
    ResponseEntity<byte[]> showFlowImg(String modelId);

    /**
     * 根据流程key 获取业务可用的流程
     *
     * @param actKey
     * @return
     */
    List<Map<String, Object>> queryFlowsByActKey(String actKey);

    /**
     * 获取流程第一个节点信息
     *
     * @param deployId
     * @return
     */
    Result getStartFlowInfo(String deployId) throws IOException;

    /**
     * 根据节点id分页查询可以选择的审批人
     *
     * @param nodeId
     * @param pageNum
     * @param userName
     * @return
     */
    Page<UserEntity> userWindowPage(String nodeId, int pageNum, String userName);

    /**
     * 转办变更人选择 目前做成 可以选择所有人
     *
     * @param pageNum
     * @param userEntity
     * @return
     */
    Page<UserEntity> turnWindowPage(int pageNum, UserEntity userEntity);

    /**
     * 启动流程
     *
     * @param processTaskDto
     */
    void startFlow(ProcessTaskDto processTaskDto) throws Exception;

    /**
     * 根据流程实例id查询实时的流程图
     *
     * @param processInstanceId
     * @return
     */
    InputStream getFlowImgByInstantId(String processInstanceId);

    /**
     * 我的待办列表
     *
     * @param params
     * @param pageNum
     * @return
     */
    Page<ExtendActModelEntity> findMyUpcomingPage(Map<String, Object> params, int pageNum);

    /**
     * 我的代办条数
     *
     * @return
     */
    int myUpcomingCount();


    /**
     * 我的已办列表
     *
     * @param params
     * @param pageNum
     * @return
     */
    Page<ExtendActModelEntity> myDonePage(Map<String, Object> params, int pageNum);


    /**
     * 根据流程节点id 获取流程下一流向节点集合
     *
     * @param processTaskDto
     * @return
     */
    List<ProcessNodeDto> getNextActNodes(ProcessTaskDto processTaskDto);

    /**
     * 根据当前节点,获取下一流向所有的字段变量名
     *
     * @param nodeId 当前节点id
     * @param defId  流程定义id
     * @return
     */
    Set<String> getNextVarNams(String nodeId, String defId);

    /**
     * 办理任务
     *
     * @param processTaskDto
     * @param params
     */
    void doActTask(ProcessTaskDto processTaskDto, Map<String, Object> params) throws Exception;

    /**
     * 驳回到流程上一步
     *
     * @param processTaskDto
     */
    void backPreviousNode(ProcessTaskDto processTaskDto);

    /**
     * 不同意,直接结束流程,业务记录进入可编辑状态，可以修改业务数据后再提交流程
     *
     * @param processTaskDto
     * @param map
     */
    void endFailFolw(ProcessTaskDto processTaskDto, Map<String, Object> map) throws Exception;

    /**
     * 转办
     *
     * @param processTaskDto
     * @param toUserId       被转办人
     */
    void turnToDo(ProcessTaskDto processTaskDto, String toUserId);

    /**
     * 驱动流程下一步
     *
     * @param processTaskDto
     */
    void doNextFlow(ProcessTaskDto processTaskDto);

    /**
     * 驱动流程下一步
     *
     * @param instanceId 实例id
     * @param assignee   当前处理人
     */
    void doNextFlow(String bizId, String instanceId, String assignee);

    /**
     * 申请办理
     *
     * @param processTaskDto
     * @param toUserId       被转办人
     */
    Result applyTaskHandle(ProcessTaskDto processTaskDto, String toUserId);

    /**
     * 释放办理
     *
     * @param processTaskDto
     * @param
     */
    Result deliverTaskHandle(ProcessTaskDto processTaskDto);

    ProcessTaskDto findProcessTaskByBusId(String busId);

    /**
     * 终止流程
     *
     * @param processTaskDto
     */
    void terminationFlow(ProcessTaskDto processTaskDto);

    /**
     * 终止流程（自定义审批结果）
     *
     * @param processTaskDto
     * @param actTaskResult
     */
    void terminationFlow(ProcessTaskDto processTaskDto, String actTaskResult);

    /**
     * 根据busId查询待申领的开户记录
     *
     * @param busIds
     * @return
     */
    List<ProcessTaskDto> findByBusIds(String busIds);

    /**
     * 根据model获取节点审批人员信息
     *
     * @param modelId
     * @return
     * @throws Exception
     */
    Map<String, List<String>> getModelNodeUser(String modelId) throws Exception;

    /**
     * 查询待申领记录
     *
     * @param processTaskDto
     * @return
     */
    List<ProcessTaskDto> queryValidApplyTask(ProcessTaskDto processTaskDto);
}
