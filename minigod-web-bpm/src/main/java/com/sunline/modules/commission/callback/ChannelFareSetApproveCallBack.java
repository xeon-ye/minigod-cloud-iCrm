package com.sunline.modules.commission.callback;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunline.common.ConfigUtils;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.HttpClientUtils;
import com.sunline.modules.common.utils.SpringContextUtils;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.marker.entity.ChannelParams;
import com.sunline.modules.marker.entity.ChannelRoleEntity;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;
import com.sunline.modules.marker.service.UserChannelInfoService;
import com.sunline.modules.sys.entity.RoleEntity;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 渠道佣金套餐设置审批回调类
 * @author: Larry Lai
 * @date: 2018/8/30 14:36
 * @version: v1.0
 */

@Component
public class ChannelFareSetApproveCallBack {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void callback(ProcessTaskDto processTaskDto, Map<String, Object> map) {

        try {

            ChannelFareSetupService channelFareSetupService = (ChannelFareSetupService) SpringContextUtils.getBean("channelFareSetupService");
            ChannelFareSetupLogService channelFareSetupLogService = (ChannelFareSetupLogService) SpringContextUtils.getBean("channelFareSetupLogService");
            UserChannelInfoService userChannelInfoService = (UserChannelInfoService) SpringContextUtils.getBean("userChannelInfoService");

            ChannelFareSetupEntity channelFareSetupEntity = new ChannelFareSetupEntity();
            ChannelFareSetupLogEntity channelFareSetupLogEntity = new ChannelFareSetupLogEntity();

            channelFareSetupEntity.setBusId(processTaskDto.getBusId());
            channelFareSetupLogEntity.setBusId(processTaskDto.getBusId());

            List<ChannelFareSetupEntity> channelFareSetInfoList = channelFareSetupService.queryListByBean(channelFareSetupEntity);
            List<ChannelFareSetupLogEntity> channelFareSetLogInfoList = channelFareSetupLogService.queryListByBean(channelFareSetupLogEntity);

            TaskService taskService = (TaskService) SpringContextUtils.getBean("taskService");
            Task task = taskService.createTaskQuery().processInstanceId(processTaskDto.getInstanceId()).singleResult();

            int count = 0;
            String channelId = "";
            String flag = "";

            if (null == task) {

                if (channelFareSetInfoList.size() > 0) {

                    // 审核通过则新方案覆盖旧方案
                    if (channelFareSetInfoList.get(0).getAuditStatus() == CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex()) {

                        if (0 == channelFareSetInfoList.get(0).getRecordStatus()) {

                            channelFareSetupEntity = new ChannelFareSetupEntity();
                            channelFareSetupEntity.setChannelId(channelFareSetInfoList.get(0).getChannelId());
                            channelFareSetupEntity.setRecordStatus(1);

                            channelFareSetupService.deleteByChanneld(channelFareSetupEntity);

                            channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                            channelFareSetupLogEntity.setChannelId(channelFareSetInfoList.get(0).getChannelId());
                            channelFareSetupLogEntity.setRecordStatus(0);
                            channelFareSetupLogEntity.setUpdateTime(new Date());
                            channelFareSetupLogService.updateByChannelId(channelFareSetupLogEntity);
                        }

                        channelFareSetupEntity = new ChannelFareSetupEntity();
                        channelFareSetupEntity.setBusId(channelFareSetInfoList.get(0).getBusId());
                        channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
                        channelFareSetupEntity.setAuditTime(new Date());
                        channelFareSetupEntity.setRecordStatus(1);

                        channelFareSetupService.updateByBusId(channelFareSetupEntity);

                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setBusId(channelFareSetInfoList.get(0).getBusId());
                        channelFareSetupLogEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
                        channelFareSetupLogEntity.setAuditTime(new Date());
                        channelFareSetupLogEntity.setRecordStatus(1);

                        count = channelFareSetupLogService.updateByBusId(channelFareSetupLogEntity);
                        channelId = String.valueOf(channelFareSetInfoList.get(0).getChannelId());
                        flag = channelFareSetLogInfoList.get(0).getOpFlag();
                    }

                    // 审核不通过则删除新方案
                    if (channelFareSetInfoList.get(0).getAuditStatus() == CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex()) {
                        if (0 == channelFareSetInfoList.get(0).getRecordStatus()) {
                            channelFareSetupEntity = new ChannelFareSetupEntity();
                            channelFareSetupEntity.setChannelId(channelFareSetInfoList.get(0).getChannelId());
                            channelFareSetupEntity.setRecordStatus(0);

                            channelFareSetupService.deleteByChanneld(channelFareSetupEntity);
                        }

                        channelFareSetupEntity = new ChannelFareSetupEntity();
                        channelFareSetupEntity.setBusId(channelFareSetInfoList.get(0).getBusId());
                        channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex());
                        channelFareSetupEntity.setAuditTime(new Date());
                        channelFareSetupEntity.setRecordStatus(1);

                        channelFareSetupService.updateByBusId(channelFareSetupEntity);

                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setBusId(channelFareSetInfoList.get(0).getBusId());
                        channelFareSetupLogEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_NOPASS.getIndex());
                        channelFareSetupLogEntity.setAuditTime(new Date());

                        channelFareSetupLogService.updateByBusId(channelFareSetupLogEntity);
                    }
                }

                // 审核通过后同步渠道至APP（新增渠道）
                if (count > 0 && "0".equals(flag)) {
                    UserChannelInfoEntity userChannelInfoEntity = new UserChannelInfoEntity();
                    userChannelInfoEntity.setChannelId(channelId);

                    UserChannelInfoEntity userChannelInfo = userChannelInfoService.queryInfo(userChannelInfoEntity);

                    if (null != userChannelInfo) {

                        ChannelParams channelParams = new ChannelParams();
                        channelParams.setChannelId(userChannelInfo.getChannelId());
                        channelParams.setChannelName(userChannelInfo.getChannelName());

                        addUserChannelInfo(channelParams);
//                        addChannelInfo(channelParams);
                    }
                }

                // 审核通过后自动授权拥有父节点的角色
                if (count > 0 && "0".equals(flag)) {
                    UserChannelInfoEntity channelParams = new UserChannelInfoEntity();
                    channelParams.setChannelId(channelId);
                    UserChannelInfoEntity channelInfo = userChannelInfoService.queryInfo(channelParams);
                    try {
                        if(null!=channelInfo){
                            if(null!=channelInfo.getParentId() && !"".equals(channelInfo.getParentId())){
                                List<String> roleList = userChannelInfoService.queryRoleIdsByChannelId(channelInfo.getParentId());
                                for (String roleId : roleList){
                                    ChannelRoleEntity channelRoleEntity  = new ChannelRoleEntity();
                                    channelRoleEntity.setRoleId(roleId);
                                    channelRoleEntity.setChannelId(channelId);
                                    channelRoleEntity.setCreateUser(Constant.SUPERR_USER);
                                    userChannelInfoService.saveChannelRole(channelRoleEntity);
                                }
                            }
                        }else{
                            logger.error("渠道佣金设置 自动授权角色失败！");
                        }
                    }catch (Exception e){
                        logger.error("渠道佣金设置 自动授权角色失败！",e);
                    }
                }

                // 审核通过后同步渠道至APP（修改渠道）
                if (count > 0 && "1".equals(flag)) {
                    UserChannelInfoEntity userChannelInfoEntity = new UserChannelInfoEntity();
                    userChannelInfoEntity.setChannelId(channelId);

                    UserChannelInfoEntity userChannelInfo = userChannelInfoService.queryInfo(userChannelInfoEntity);

                    if (null != userChannelInfo) {

                        ChannelParams channelParams = new ChannelParams();
                        channelParams.setChannelId(userChannelInfo.getChannelId());
                        channelParams.setChannelName(userChannelInfo.getChannelName());

                        updateUserChannelInfo(channelParams);
//                        modifyChannelInfo(channelParams);
                    }

                }
            }
        } catch (Exception e) {
            logger.error("渠道佣金套餐设置审批回调异常", e);
        }
    }

    /**
     * SNS新增渠道信息
     *
     * @param channelParams
     */
    public ResponseVO addUserChannelInfo(ChannelParams channelParams) {

        ResponseVO responseVO = new ResponseVO();

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("params", channelParams);

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.add.user.channel.info"), JSON.toJSONString(paraMap));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("code").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("SNS新增[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return null;
    }

    /**
     * SNS修改渠道信息
     *
     * @param channelParams
     */
    public ResponseVO updateUserChannelInfo(ChannelParams channelParams) {

        ResponseVO responseVO = new ResponseVO();

        try {

            JSONObject paraMap = new JSONObject();

            paraMap.put("params", channelParams);

            String response = HttpClientUtils.postJson(ConfigUtils.get("sns.update.user.channel.info"), JSON.toJSONString(paraMap));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("code").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("SNS修改[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return null;
    }

    /**
     * BPM新增渠道信息同步
     *
     * @param channelParams
     */
    public ResponseVO addChannelInfo(ChannelParams channelParams) {
        ResponseVO responseVO = new ResponseVO();
        try {

            String response = HttpClientUtils.postJson(ConfigUtils.get("bpm.add.channel.info"), JSON.toJSONString(channelParams));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("errorCode").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("BPM新增[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return null;
    }

    /**
     * BPM修改渠道信息同步
     *
     * @param channelParams
     */
    public ResponseVO modifyChannelInfo(ChannelParams channelParams) {
        ResponseVO responseVO = new ResponseVO();
        try {


            String response = HttpClientUtils.postJson(ConfigUtils.get("bpm.modify.channel.info"), JSON.toJSONString(channelParams));

            JSONObject retList = JSON.parseObject(response);

            responseVO.setCode(Integer.parseInt(retList.get("errorCode").toString()));

            return responseVO;

        } catch (Exception e) {
            logger.error("BPM修改[" + channelParams.getChannelName() + "]渠道异常：", e);
        }
        return null;
    }
}
