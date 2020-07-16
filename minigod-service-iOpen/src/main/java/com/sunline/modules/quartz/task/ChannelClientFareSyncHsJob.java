package com.sunline.modules.quartz.task;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.sunline.modules.commission.entity.ChannelClientFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupEntity;
import com.sunline.modules.commission.entity.ChannelFareSetupLogEntity;
import com.sunline.modules.commission.service.ChannelClientFareSetupService;
import com.sunline.modules.commission.service.ChannelFareSetupLogService;
import com.sunline.modules.commission.service.ChannelFareSetupService;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.common.CrmCommonEnum;
import com.sunline.modules.common.utils.NoticeUtil;
import com.sunline.modules.common.utils.StringUtils;
import com.sunline.modules.common.utils.SysConfigUtil;
import com.sunline.modules.common.utils.Utils;
import com.sunline.modules.common.vo.ResponseVO;
import com.sunline.modules.hundsun.protocol.request.ClientTradeFareRequest;
import com.sunline.modules.hundsun.service.HsRestManageService;
import com.sunline.modules.notice.enums.NoticeEnums;
import com.sunline.modules.sys.entity.NoticeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @description: 渠道设佣套餐同步恒生柜台调度任务
 * @author: Larry Lai
 * @date: 2018/8/27 17:37
 * @version: v1.0
 */

@Component("channelClientFareSyncHsJob")
public class ChannelClientFareSyncHsJob {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private ChannelFareSetupService channelFareSetupService;
    @Autowired
    private ChannelFareSetupLogService channelFareSetupLogService;
    @Autowired
    private ChannelClientFareSetupService channelClientFareSetupService;

    /**
     * 渠道设佣套餐同步恒生柜台
     *
     * @param params
     * @throws Exception
     */
    public void excute(String params) throws Exception {
        logger.info(params + "任务开始");

        try {

            ChannelFareSetupEntity channelFareSetupEntity = new ChannelFareSetupEntity();

            // 不参加开户免佣的新开户设置渠道佣金套餐
//            List<ChannelFareSetupEntity> channelClientFareSetInfoList = channelFareSetupService.getChannelClientFareSetInfo(channelFareSetupEntity);
//            setupClientFare(channelClientFareSetInfoList, true);

            // 免佣到期后的客户设置渠道佣金套餐
//            channelFareSetupEntity = new ChannelFareSetupEntity();
//            List<ChannelFareSetupEntity> clientFreeCommIsDueSetInfoList = channelFareSetupService.getClientFreeCommDueSetInfo(channelFareSetupEntity);
//            setupClientFare(clientFreeCommIsDueSetInfoList, false);

            // 渠道套餐到期提醒（提前30天）
            channelFareSetupEntity.setChannelFareType("0");
            channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
            List<ChannelFareSetupEntity> channelFareDueNotList = channelFareSetupService.queryListByBean(channelFareSetupEntity);

            for (ChannelFareSetupEntity channelFareDueNotInfo : channelFareDueNotList) {

                channelFareSetupEntity = new ChannelFareSetupEntity();
                channelFareSetupEntity.setChannelId(channelFareDueNotInfo.getChannelId());
                channelFareSetupEntity.setChannelFareType("1");
                channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());

                List<ChannelFareSetupEntity> isSetLastFare = channelFareSetupService.queryListByBean(channelFareSetupEntity);

                long betweenDay = DateUtil.between(new Date(), channelFareDueNotInfo.getEndDate(), DateUnit.DAY);

                if (betweenDay <= Integer.parseInt(SysConfigUtil.getSysConfigValue("CHANNEL_FARE_DUE_DAYS","30")) && isSetLastFare.size() <= 0) {
                    NoticeEntity noticeEntity = new NoticeEntity();

                    noticeEntity.setSoucre(NoticeEnums.NoticeSource.SOURCE_SYS.getIndex());
                    noticeEntity.setIsUrgent(NoticeEnums.NoticeUrgent.URGENT_YES.getIndex());
                    noticeEntity.setStatus(NoticeEnums.NoticeStatus.STATUS_PLC.getIndex());
                    noticeEntity.setCreateId(Constant.SUPERR_USER);
                    noticeEntity.setUpdateId(Constant.SUPERR_USER);

                    StringBuffer buf = new StringBuffer();
                    buf.append("{").append(channelFareDueNotInfo.getChannelId()).append("，").append(channelFareDueNotInfo.getChannelName()).append("}").append("渠道佣金方案将于{")
                            .append(DateUtil.format(channelFareDueNotInfo.getEndDate(), "yyyy-MM-dd")).append("}").append("到期，请及时维护；");

                    noticeEntity.setContext(buf.toString());
                    noticeEntity.setTitle("渠道佣金套餐到期通知");
                    noticeEntity.setRemark("");

                    List<String> userIdList = Lists.newArrayList();
                    userIdList.add("d5fc519bd3f447ce93f78649691af24c");
                    userIdList.add("f7527b2535604139a63346906da45747");

                    NoticeUtil.sendNotice(noticeEntity, userIdList);
                }

            }


            // 渠道到期后默认生成下一个新套餐（如无下一套餐，则复制旧套餐）
            channelFareSetupEntity = new ChannelFareSetupEntity();
            channelFareSetupEntity.setChannelFareType("0");
            channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());
            channelFareSetupEntity.setEndDate(new Date());
            List<ChannelFareSetupEntity> channelFareSetupEntityList = channelFareSetupService.queryListByBean(channelFareSetupEntity);

            Integer[] ids = new Integer[10];

            for (ChannelFareSetupEntity channelFareIsDueSetInfo : channelFareSetupEntityList) {

                ids[0] = channelFareIsDueSetInfo.getId();

                if (channelFareSetupService.deleteBatch(ids) > 0) {

                    channelFareSetupEntity = new ChannelFareSetupEntity();
                    channelFareSetupEntity.setChannelId(channelFareIsDueSetInfo.getChannelId());
                    channelFareSetupEntity.setChannelFareType("1");
                    channelFareSetupEntity.setAuditStatus(CrmCommonEnum.AuditStatus.AUDIT_STATUS_PASS.getIndex());

                    ChannelFareSetupEntity channelFareSetInfo = channelFareSetupService.qryInfoByBean(channelFareSetupEntity);

                    // 存在下一套餐设置则更新为当前套餐
                    if (channelFareSetInfo != null) {
                        channelFareSetupEntity = new ChannelFareSetupEntity();
                        channelFareSetupEntity.setId(channelFareSetInfo.getId());
                        channelFareSetupEntity.setChannelFareType("0");
                        channelFareSetupEntity.setUpdateTime(new Date());

                        channelFareSetupService.update(channelFareSetupEntity);

                        // 更新日志表
                        ChannelFareSetupLogEntity channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setChannelId(channelFareIsDueSetInfo.getChannelId());
                        channelFareSetupLogEntity.setBusId(channelFareIsDueSetInfo.getBusId());
                        channelFareSetupLogEntity.setChannelFareType("0");

                        List<ChannelFareSetupLogEntity> channelFareSetupLogList = Lists.newArrayList();
                        channelFareSetupLogList = channelFareSetupLogService.queryListByBean(channelFareSetupLogEntity);

                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setId(channelFareSetupLogList.get(0).getId());
                        channelFareSetupLogEntity.setRecordStatus(0);
                        channelFareSetupLogEntity.setUpdateTime(new Date());
                        channelFareSetupLogService.update(channelFareSetupLogEntity);

                        channelFareSetupLogList.clear();
                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setChannelId(channelFareIsDueSetInfo.getChannelId());
                        channelFareSetupLogEntity.setBusId(channelFareIsDueSetInfo.getBusId());
                        channelFareSetupLogEntity.setChannelFareType("1");
                        channelFareSetupLogList = channelFareSetupLogService.queryListByBean(channelFareSetupLogEntity);

                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setId(channelFareSetupLogList.get(0).getId());
                        channelFareSetupLogEntity.setChannelFareType("0");
                        channelFareSetupLogEntity.setUpdateTime(new Date());

                        channelFareSetupLogService.update(channelFareSetupLogEntity);

                    } else {
                        // 不存在则默认复制当前套餐
                        channelFareSetupEntity = new ChannelFareSetupEntity();
                        BeanUtil.copyProperties(channelFareIsDueSetInfo, channelFareSetupEntity);
                        channelFareSetupEntity.setId(null);
                        channelFareSetupEntity.setCreateTime(new Date());
                        channelFareSetupEntity.setUpdateTime(new Date());
                        channelFareSetupEntity.setCode(Utils.getCode("D"));

                        Date beginDate = DateUtil.offset(channelFareIsDueSetInfo.getEndDate(), DateField.DAY_OF_MONTH, 1);
                        Date endDate = DateUtil.offset(beginDate, DateField.DAY_OF_MONTH, (int) DateUtil.between(channelFareIsDueSetInfo.getBeginDate(), channelFareIsDueSetInfo.getEndDate(), DateUnit.DAY));

                        channelFareSetupEntity.setBeginDate(beginDate);
                        channelFareSetupEntity.setEndDate(endDate);

                        channelFareSetupService.save(channelFareSetupEntity);

                        // 更新日志表
                        ChannelFareSetupLogEntity channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setChannelId(channelFareIsDueSetInfo.getChannelId());
                        channelFareSetupLogEntity.setRecordStatus(1);
                        channelFareSetupLogEntity.setChannelFareType("0");

                        List<ChannelFareSetupLogEntity> channelFareSetupLogList;
                        channelFareSetupLogList = channelFareSetupLogService.queryListByBean(channelFareSetupLogEntity);

                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                        channelFareSetupLogEntity.setId(channelFareSetupLogList.get(0).getId());
                        channelFareSetupLogEntity.setRecordStatus(0);
                        channelFareSetupLogEntity.setUpdateTime(new Date());
                        channelFareSetupLogService.update(channelFareSetupLogEntity);

                        // 记录到日志表
                        channelFareSetupLogEntity = new ChannelFareSetupLogEntity();

                        channelFareSetupLogEntity.setChannelId(channelFareSetupEntity.getChannelId());
                        channelFareSetupLogEntity.setIsFreeCommission(channelFareSetupEntity.getIsFreeCommission());
                        channelFareSetupLogEntity.setFreeCommissionDays(channelFareSetupEntity.getFreeCommissionDays() == null ? null : channelFareIsDueSetInfo.getFreeCommissionDays());
                        channelFareSetupLogEntity.setFareKind(channelFareSetupEntity.getFareKind());
                        channelFareSetupLogEntity.setCode(channelFareSetupEntity.getCode());
                        channelFareSetupLogEntity.setChannelFareType(channelFareSetupEntity.getChannelFareType());
                        channelFareSetupLogEntity.setBeginDate(channelFareSetupEntity.getBeginDate());
                        channelFareSetupLogEntity.setEndDate(channelFareSetupEntity.getEndDate());
                        channelFareSetupLogEntity.setOpFlag("0");
                        channelFareSetupLogEntity.setCreateUser(channelFareSetupEntity.getCreateUser());
                        channelFareSetupLogEntity.setUpdateUser(channelFareSetupEntity.getUpdateUser());
                        channelFareSetupLogEntity.setCreateTime(channelFareSetupEntity.getCreateTime());
                        channelFareSetupLogEntity.setUpdateTime(channelFareSetupEntity.getUpdateTime());
                        channelFareSetupLogEntity.setLastFareKind(channelFareSetupEntity.getFareKind());
                        channelFareSetupLogEntity.setAuditUser(channelFareSetupEntity.getAuditUser());
                        channelFareSetupLogEntity.setAuditStatus(channelFareSetupEntity.getAuditStatus());
                        channelFareSetupLogEntity.setAuditTime(channelFareSetupEntity.getAuditTime());
                        channelFareSetupLogEntity.setRecordStatus(1);
                        channelFareSetupLogEntity.setBusId(channelFareSetupEntity.getBusId());

                        channelFareSetupLogService.save(channelFareSetupLogEntity);
                    }
                }

            }


        } catch (Exception e) {
            logger.error("渠道设佣套餐同步恒生柜台异常", e);
        }
    }

    /**
     * 调用交易接口对接恒生柜台设置渠道佣金套餐
     *
     * @param channelClientFareSetInfoList
     * @param updateFlag
     */
    public void setupClientFare(List<ChannelFareSetupEntity> channelClientFareSetInfoList, boolean updateFlag) {
        try {

            List<ClientTradeFareRequest> clientTradeFareProtoList = Lists.newArrayList();
            List<Integer> channelClientFareSetIdList = Lists.newArrayList();
            List<Integer> channelIdList = Lists.newArrayList();
            List<String> busIdList = Lists.newArrayList();
            List<ChannelClientFareSetupEntity> channelClientFareSetList = Lists.newArrayList();

            // 同步客户设佣套餐

            clientTradeFareProtoList.clear();
            channelClientFareSetIdList.clear();
            busIdList.clear();
            channelIdList.clear();
            channelClientFareSetList.clear();

            for (ChannelFareSetupEntity channelClientFareSetInfo : channelClientFareSetInfoList) {

                ClientTradeFareRequest clientTradeFareProto = new ClientTradeFareRequest();
                ChannelClientFareSetupEntity channelClientFareSetEntity = new ChannelClientFareSetupEntity();

                channelClientFareSetIdList.add(channelClientFareSetInfo.getId() == null ? 0 : channelClientFareSetInfo.getId());
                busIdList.add(channelClientFareSetInfo.getBusId());
                channelIdList.add(channelClientFareSetInfo.getChannelId());

                clientTradeFareProto.setUserType("3");
                clientTradeFareProto.setClientId(channelClientFareSetInfo.getClientId());
                clientTradeFareProto.setFundAccount(channelClientFareSetInfo.getFundAccount());
                clientTradeFareProto.setFareKindStr(channelClientFareSetInfo.getFareKind());

                channelClientFareSetEntity.setChannelId(channelClientFareSetInfo.getChannelId());
                channelClientFareSetEntity.setClientId(channelClientFareSetInfo.getClientId());
                channelClientFareSetEntity.setFundAccount(channelClientFareSetInfo.getFundAccount());
                channelClientFareSetEntity.setFareKind(channelClientFareSetInfo.getFareKind());

                clientTradeFareProtoList.add(clientTradeFareProto);
                channelClientFareSetList.add(channelClientFareSetEntity);
            }

            if (clientTradeFareProtoList.size() > 0) {

                if (updateFlag) {
                    // 更新同步状态为正在同步
                    updateSyncStatus(channelClientFareSetIdList, CrmCommonEnum.SyncStatus.SYNC_STATUS_PROCESSING.getIndex());
                    updateSyncStatusLog(busIdList, CrmCommonEnum.SyncStatus.SYNC_STATUS_PROCESSING.getIndex());
                }

                // 调用交易接口对接恒生柜台设置渠道佣金套餐
                ResponseVO addClientFareReq = HsRestManageService.setupTradeFare(clientTradeFareProtoList);

                // 处理同步结果
                if (addClientFareReq != null && addClientFareReq.getCode() == CrmCommonEnum.CodeType.OK.getCode() && !StringUtils.isEmpty(addClientFareReq.getResult())) {
                    JSONArray addSucClientList = JSON.parseArray(JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("successFundAccount").toString());
                    if (updateFlag) {
                        // 更新同步状态为同步成功
                        updateSyncStatus(channelClientFareSetIdList, CrmCommonEnum.SyncStatus.SYNC_STATUS_COMPLETE.getIndex());
                        updateSyncStatusLog(busIdList, CrmCommonEnum.SyncStatus.SYNC_STATUS_COMPLETE.getIndex());
                    }

                    if (addSucClientList.size() > 0) {
                        for (int i = 0; i < addSucClientList.size(); i++) {
                            for (ChannelClientFareSetupEntity channelClientFareSetEntity : channelClientFareSetList) {
                                if (String.valueOf(addSucClientList.get(i)).equals(channelClientFareSetEntity.getFundAccount())) {
                                    channelClientFareSetEntity.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_COMPLETE.getIndex());
                                    channelClientFareSetEntity.setSyncTime(new Date());
                                    channelClientFareSetEntity.setCreateTime(new Date());
                                    channelClientFareSetEntity.setUpdateTime(new Date());
                                    channelClientFareSetupService.save(channelClientFareSetEntity);

                                    logger.info("设置[" + channelClientFareSetEntity.getFundAccount() + "]客户[" + channelClientFareSetEntity.getFareKind() + "]套餐成功");
                                }
                            }
                        }
                    }

                    JSONArray addFailedClientList = JSON.parseArray(JSON.parseObject(JSON.toJSONString(addClientFareReq.getResult())).get("failedFundAccount").toString());

                    if (addFailedClientList.size() > 0) {
                        for (int i = 0; i < addFailedClientList.size(); i++) {
                            for (ChannelClientFareSetupEntity channelClientFareSetEntity : channelClientFareSetList) {
                                if (String.valueOf(addFailedClientList.get(i)).equals(channelClientFareSetEntity.getFundAccount())) {
                                    channelClientFareSetEntity.setSyncStatus(CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());
                                    channelClientFareSetEntity.setSyncTime(new Date());
                                    channelClientFareSetEntity.setCreateTime(new Date());
                                    channelClientFareSetEntity.setUpdateTime(new Date());
                                    channelClientFareSetupService.save(channelClientFareSetEntity);

                                    logger.info("设置[" + channelClientFareSetEntity.getFundAccount() + "]客户[" + channelClientFareSetEntity.getFareKind() + "]套餐失败");
                                }
                            }
                        }
                    }

                } else {
                    if (updateFlag) {
                        // 更新同步状态为同步失败
                        updateSyncStatus(channelClientFareSetIdList, CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());
                        updateSyncStatusLog(busIdList, CrmCommonEnum.SyncStatus.SYNC_STATUS_FAILURE.getIndex());
                    }

                    logger.info("设置[" + channelIdList.toString() + "]渠道佣金套餐失败");
                }
            }

        } catch (Exception e) {
            logger.error("调用交易接口对接恒生柜台设置渠道佣金套餐异常", e);
        }
    }

    /**
     * 更新同步状态
     *
     * @param channelClientFareSetIdList
     * @param syncStatus
     * @return
     */
    public boolean updateSyncStatus(List<Integer> channelClientFareSetIdList, Integer syncStatus) {
        boolean returnValue = false;

        try {

            for (Integer channelClientFareSetId : channelClientFareSetIdList) {

                ChannelFareSetupEntity channelFareSetupEntity = new ChannelFareSetupEntity();
                channelFareSetupEntity.setId(channelClientFareSetId);
                channelFareSetupEntity.setSyncStatus(syncStatus);
                channelFareSetupEntity.setSyncTime(new Date());

                returnValue = channelFareSetupService.update(channelFareSetupEntity) > 0;
            }

        } catch (Exception e) {
            logger.error("更新渠道设佣当前表同步状态异常", e);
        }

        return returnValue;
    }

    /**
     * 更新日志表同步状态
     *
     * @param busIdList
     * @param syncStatus
     * @return
     */
    public boolean updateSyncStatusLog(List<String> busIdList, Integer syncStatus) {
        boolean returnValue = false;

        try {

            for (String busId : busIdList) {

                ChannelFareSetupLogEntity channelFareSetupLogEntity = new ChannelFareSetupLogEntity();
                channelFareSetupLogEntity.setBusId(busId);
                channelFareSetupLogEntity.setSyncStatus(syncStatus);
                channelFareSetupLogEntity.setSyncTime(new Date());
                channelFareSetupLogEntity.setChannelFareType("0");

                returnValue = channelFareSetupLogService.updateSyncStatus(channelFareSetupLogEntity) > 0;
            }

        } catch (Exception e) {
            logger.error("更新渠道设佣日志表同步状态异常", e);
        }

        return returnValue;
    }
}
