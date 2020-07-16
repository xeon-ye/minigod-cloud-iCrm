package com.sunline.modules.marker.controller;

import com.google.common.collect.Maps;
import com.sunline.modules.activiti.dto.ProcessTaskDto;
import com.sunline.modules.activiti.service.ActModelerService;
import com.sunline.modules.activiti.utils.ActUtils;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.UserUtils;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.marker.entity.UserChannelInfoEntity;
import com.sunline.modules.marker.service.UserChannelInfoService;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.StringUtils;
import io.swagger.models.auth.In;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


/**
 * 渠道信息表
 *
 * @author lcs
 * @email
 * @date 2018-04-25 09:31:43
 */
@RestController
@RequestMapping("userChannelInfo")
public class UserChannelInfoController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserChannelInfoService userChannelInfoService;
    @Autowired
    private ChannelFareSetupService channelFareService;
    @Autowired
    private ChannelFareSetupLogService channelFareLogService;

    @Autowired
    ActModelerService actModelerService;
    private final String CHANNEL_FARE_SET_FLOW_MODEL_KEY = "channelFareSetApprove";

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @SysLog("查看菜单")
    public Result info(@PathVariable("id") String id) {
        UserChannelInfoEntity userChannelInfo = userChannelInfoService.queryObject(id);
        ChannelFareSetupEntity channelFare = new ChannelFareSetupEntity();
        channelFare.setChannelId(Integer.parseInt(userChannelInfo.getChannelId()));
        channelFare.setChannelFareType("1");
        channelFare.setRecordStatus(1);
        ChannelFareSetupEntity channelFareResult = channelFareService.queryByParams(channelFare);
        if (channelFareResult != null) {
            userChannelInfo.setNextFreeCommission(channelFareResult.getIsFreeCommission());
            userChannelInfo.setNextBeginDate(DATE_FORMAT.format(channelFareResult.getBeginDate()));
            userChannelInfo.setNextEndDate(DATE_FORMAT.format(channelFareResult.getEndDate()));
            userChannelInfo.setNextFareKind(channelFareResult.getFareKind());
            userChannelInfo.setAuditStatus(channelFareResult.getAuditStatus().toString());
            userChannelInfo.setSyncStatus(channelFareResult.getSyncStatus().toString());
            return Result.ok().put("menu", userChannelInfo).put("channelFare", true);
        }
        return Result.ok().put("menu", userChannelInfo).put("channelFare", false);
    }

    /**
     * 查询渠道号是否存在
     *
     * @param id
     * @param userChannelInfoEntity
     * @return
     */
    @RequestMapping(value = "/queryByChannelId")
    public Result queryByChannelId(@RequestBody String id, UserChannelInfoEntity userChannelInfoEntity) {
        userChannelInfoEntity.setChannelId(id);
        int count = userChannelInfoService.queryByChannelId(userChannelInfoEntity);
        return Result.ok().put("code", count);
    }

    /**
     * 查询渠道名是否存在
     *
     * @param name
     * @param userChannelInfoEntity
     * @return
     */
    @RequestMapping(value = "/queryByChannelName")
    public Result queryByChannelName(@RequestBody String name, UserChannelInfoEntity userChannelInfoEntity) {
        userChannelInfoEntity.setChannelName(name);
        int count = userChannelInfoService.queryByChannelName(userChannelInfoEntity);
        return Result.ok().put("code", count);
    }


    /**
     * 保存
     */
    @RequestMapping(value = "/save")
    @RequiresPermissions("userChannelInfo:update")
    @Transactional(rollbackFor = Exception.class)
    @SysLog("新增渠道")
    public Result save(@RequestBody UserChannelInfoEntity userChannelInfo) {
        int count = 0;
        try {
            count = userChannelInfoService.save(userChannelInfo);
            if (count > 0 && Integer.parseInt(userChannelInfo.getChannelId())>0) {
                //新增渠道佣金方案
                String busId = UUID.randomUUID().toString().replace("-", "");
                String code = Utils.getCode("D");
                ChannelFareSetupEntity channelFare = new ChannelFareSetupEntity();
                channelFare.setChannelId(Integer.parseInt(userChannelInfo.getChannelId()));
                channelFare.setBusId(busId);
                channelFare.setCode(code);
                channelFare.setRecordStatus(1);
                channelFare.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                channelFare.setFareKind(userChannelInfo.getFareKind());
                channelFare.setIsFreeCommission(Integer.parseInt(userChannelInfo.getIsFreeCommission()));
                channelFare.setChannelFareType("0");

                channelFare.setBeginDate(DATE_FORMAT.parse(userChannelInfo.getBeginDate()));
                channelFare.setEndDate(DATE_FORMAT.parse(userChannelInfo.getEndDate()));

                channelFare.setCreateUser(UserUtils.getCurrentUser().getUserName());
                channelFare.setUpdateUser(UserUtils.getCurrentUser().getUserName());
                channelFare.setCreateTime(new Date());
                channelFare.setUpdateTime(new Date());
                count = channelFareService.save(channelFare);
                if (count > 0) {
                    //新增渠道佣金方案  日志
                    ChannelFareSetupLogEntity channelFareLog = new ChannelFareSetupLogEntity();
                    channelFareLog.setChannelId(channelFare.getChannelId());
                    channelFareLog.setBusId(channelFare.getBusId());
                    channelFareLog.setCode(code);
                    channelFareLog.setRecordStatus(1);
                    channelFareLog.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                    channelFareLog.setFareKind(channelFare.getFareKind());
                    channelFareLog.setLastFareKind(null);
                    channelFareLog.setIsFreeCommission(channelFare.getIsFreeCommission());
                    channelFareLog.setBeginDate(channelFare.getBeginDate());
                    channelFareLog.setEndDate(channelFare.getEndDate());
                    channelFareLog.setChannelFareType("0");
                    channelFareLog.setOpFlag("0");
                    channelFareLog.setCreateUser(UserUtils.getCurrentUser().getUserName());
                    channelFareLog.setUpdateUser(UserUtils.getCurrentUser().getUserName());
                    channelFareLog.setCreateTime(new Date());
                    channelFareLog.setUpdateTime(new Date());
                    count = channelFareLogService.save(channelFareLog);
                    if (count > 0) {
                        if (null != userChannelInfo.getNextFareKind() && !"".equals(userChannelInfo.getNextFareKind())) {
                            //新增渠道佣金方案   （下一方案）
                            channelFare.setBusId(busId);
                            channelFare.setCode(code);
                            channelFare.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                            channelFare.setChannelFareType("1");
                            channelFare.setFareKind(userChannelInfo.getNextFareKind());
                            channelFare.setIsFreeCommission(userChannelInfo.getNextFreeCommission());
                            try {
                                channelFare.setBeginDate(DATE_FORMAT.parse(userChannelInfo.getNextBeginDate()));
                                channelFare.setEndDate(DATE_FORMAT.parse(userChannelInfo.getNextEndDate()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            count = channelFareService.save(channelFare);
                            if (count > 0) {
                                //新增渠道佣金方案  日志 （下一方案）
                                channelFareLog.setBusId(channelFare.getBusId());
                                channelFareLog.setCode(code);
                                channelFareLog.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                                channelFareLog.setChannelFareType("1");
                                channelFareLog.setBeginDate(channelFare.getBeginDate());
                                channelFareLog.setEndDate(channelFare.getEndDate());
                                channelFareLog.setLastFareKind(null);
                                channelFareLog.setFareKind(userChannelInfo.getNextFareKind());
                                channelFareLog.setIsFreeCommission(channelFareLog.getIsFreeCommission());
                                count = channelFareLogService.save(channelFareLog);
                            }
                        }
                    }

                    ProcessDefinition channelFareSetupDefinition = ActUtils.getlastProcessDefinition(CHANNEL_FARE_SET_FLOW_MODEL_KEY);
                    ProcessTaskDto processTaskDto = new ProcessTaskDto();
                    processTaskDto.setDefId(channelFareSetupDefinition.getId());
                    processTaskDto.setBusId(busId);
                    processTaskDto.setActKey(channelFareSetupDefinition.getKey());
                    processTaskDto.setNodeType("2");

                    actModelerService.startFlow(processTaskDto);
                }
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("渠道方案新增失败", e);
            return Result.error("渠道佣金方案新增失败!");
        }
        if (count > 0) {
            return Result.ok("保存成功！");
        } else {
            return Result.error("新增渠道佣金方案失败！");
        }
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @RequiresPermissions("userChannelInfo:update")
    @SysLog("修改渠道")
    public Result update(@RequestBody UserChannelInfoEntity userChannelInfo) {
        int count = 0;
        try {
            //修改渠道信息
            count = userChannelInfoService.update(userChannelInfo);
            if (count > 0) {
                //修改渠道佣金方案
                String busId = UUID.randomUUID().toString().replace("-", "");
                String code = Utils.getCode("D");
                ChannelFareSetupEntity channelFare = new ChannelFareSetupEntity();

                channelFare.setChannelId(Integer.parseInt(userChannelInfo.getChannelId()));
                channelFare.setChannelFareType("0");
                channelFare.setFareKind(userChannelInfo.getFareKind());
                channelFare.setBusId(busId);
                channelFare.setCode(code);
                channelFare.setRecordStatus(0);
                channelFare.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                channelFare.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_UNTREATED.getIndex());
                channelFare.setIsFreeCommission(Integer.parseInt(userChannelInfo.getIsFreeCommission()));
                channelFare.setBeginDate(DATE_FORMAT.parse(userChannelInfo.getBeginDate()));
                channelFare.setEndDate(DATE_FORMAT.parse(userChannelInfo.getEndDate()));
                channelFare.setCreateUser(UserUtils.getCurrentUser().getUserName());
                channelFare.setUpdateUser(UserUtils.getCurrentUser().getUserName());
                channelFare.setCreateTime(new Date());
                channelFare.setUpdateTime(new Date());
//                //在原有渠道上修改时 做新增
//                ChannelFareSetupEntity queryParams = new ChannelFareSetupEntity();
//                queryParams.setChannelId(channelFare.getChannelId());
//                queryParams.setChannelFareType(channelFare.getChannelFareType());
//                ChannelFareSetupEntity queryResult = channelFareService.queryByParams(queryParams);
//                if (queryResult != null) {
//                    channelFareService.updateByChannelId(channelFare);
//                } else {
//                    channelFareService.save(channelFare);
//                }
                channelFareService.save(channelFare);

                //新增渠道佣金方案  日志
                ChannelFareSetupLogEntity channelFareLog = new ChannelFareSetupLogEntity();
                channelFareLog.setChannelId(channelFare.getChannelId());
                channelFareLog.setChannelFareType("0");
                //将前面的日志置为无效状态（改到审核后操作）
//                channelFareLogService.updateStatus(channelFareLog);
                channelFareLog.setBusId(channelFare.getBusId());
                channelFareLog.setCode(code);
                channelFareLog.setRecordStatus(0);
                channelFareLog.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                channelFareLog.setFareKind(channelFare.getFareKind());
                channelFareLog.setIsFreeCommission(channelFare.getIsFreeCommission());
                channelFareLog.setBeginDate(channelFare.getBeginDate());
                channelFareLog.setEndDate(channelFare.getEndDate());
                channelFareLog.setLastFareKind(userChannelInfo.getLastFareKind());
                channelFareLog.setOpFlag("1");
                channelFareLog.setCreateUser(UserUtils.getCurrentUser().getUserName());
                channelFareLog.setUpdateUser(UserUtils.getCurrentUser().getUserName());
                channelFareLog.setCreateTime(new Date());
                channelFareLog.setUpdateTime(new Date());
                count = channelFareLogService.save(channelFareLog);
                if (count > 0) {
                    if (null != userChannelInfo.getNextFareKind() && !"".equals(userChannelInfo.getNextFareKind())) {
                        //修改渠道佣金方案 （下一方案）
                        channelFare.setBusId(busId);
                        channelFare.setCode(code);
                        channelFare.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                        channelFare.setChannelFareType("1");
                        channelFare.setFareKind(userChannelInfo.getNextFareKind());
                        channelFare.setIsFreeCommission(userChannelInfo.getNextFreeCommission());
                        channelFare.setBeginDate(DATE_FORMAT.parse(userChannelInfo.getNextBeginDate()));
                        channelFare.setEndDate(DATE_FORMAT.parse(userChannelInfo.getNextEndDate()));
                        channelFareService.save(channelFare);
                        //新增渠道佣金方案  日志 （下一方案）
                        channelFareLog.setChannelFareType("1");
//                        channelFareLogService.updateStatus(channelFareLog);
                        channelFareLog.setBeginDate(channelFare.getBeginDate());
                        channelFareLog.setEndDate(channelFare.getEndDate());
                        channelFareLog.setLastFareKind(userChannelInfo.getLastNextFareKind());
                        channelFareLog.setFareKind(userChannelInfo.getNextFareKind());
                        channelFareLog.setLastFareKind(userChannelInfo.getLastNextFareKind());
                        channelFareLog.setIsFreeCommission(channelFareLog.getIsFreeCommission());
                        channelFareLog.setBusId(channelFare.getBusId());
                        channelFareLog.setCode(code);
                        channelFareLog.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PROCESSING.getIndex());
                        channelFareLogService.save(channelFareLog);
                    }
                }

                ProcessDefinition channelFareSetupDefinition = ActUtils.getlastProcessDefinition(CHANNEL_FARE_SET_FLOW_MODEL_KEY);
                ProcessTaskDto processTaskDto = new ProcessTaskDto();
                processTaskDto.setDefId(channelFareSetupDefinition.getId());
                processTaskDto.setBusId(busId);
                processTaskDto.setActKey(channelFareSetupDefinition.getKey());
                processTaskDto.setNodeType("2");

                actModelerService.startFlow(processTaskDto);
            }
        } catch (Exception e) {
            logger.error("修改渠道佣金方案失败", e);
            return Result.error("修改渠道佣金方案失败!");
        }
        if (count > 0) {
            return Result.ok().put("menu", userChannelInfo);
        }
        return Result.error("修改渠道佣金方案失败!");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @RequiresPermissions("userChannelInfo:delete")
    @SysLog("删除渠道")
    public Result delete(@RequestBody String ids) {
        userChannelInfoService.deleteBatch(StringUtils.getArrayByArray(ids.split(",")));
        return Result.ok();
    }


    /**
     * 列表
     *
     * @return
     */
    @RequestMapping(value = "/perms")
    public Result perms() {
        //查询列表数据
        List<UserChannelInfoEntity> userChannelList = userChannelInfoService.queryList(Maps.newHashMap());
        return Result.ok().put("userChannelList", userChannelList);
    }

    /**
     * 列表
     *
     * @return
     */
    @RequestMapping(value = "/areaPerms")
    public Result areaPerms() {
        //查询列表数据
        List<UserChannelInfoEntity> userChannelList = userChannelInfoService.areaQueryList(Maps.newHashMap());
        return Result.ok().put("userChannelList", userChannelList);
    }

    /**
     * 查询除按钮个的其它资源菜单
     *
     * @return
     */
    @RequestMapping(value = "/selectMenu")
    public Result selectMenu() {
        List<UserChannelInfoEntity> userChannelList = userChannelInfoService.queryNotButtonnList();
        return Result.ok().put("userChannelList", userChannelList);
    }

    /**
     * 渠道弹出按钮
     *
     * @return
     */
    @RequestMapping(value = "/channelButton")
    public Result channelButton() {
        UserChannelInfoEntity entity = new UserChannelInfoEntity();
        if (getUserId().equals(Constant.SUPERR_USER)) {
            entity.setChannelIds(null);
        } else {
            entity.setChannelIds(getChannelIds());
        }
        List<UserChannelInfoEntity> userChannelList = userChannelInfoService.queryButtonList(entity);
        return Result.ok().put("userChannelList", userChannelList);
    }

    /**
     * 添加上级渠道的树查询
     *
     * @return
     */
    @RequestMapping(value = "/areaSelectMenu")
    public Result areaSelectMenu() {
        List<UserChannelInfoEntity> userChannelList = userChannelInfoService.areaQueryNotButtonnList();
        return Result.ok().put("userChannelList", userChannelList);
    }
}
