package com.sunline.modules.quartz.task;

import cn.hutool.core.date.DateUtil;
import com.sunline.modules.call.protocol.request.CallRecordRequest;
import com.sunline.modules.call.sync.CallRecordSync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @description: 通话记录数据同步任务
 * @author: Larry Lai
 * @date: 2019/3/5 16:12
 * @version: v1.0
 */

@Component("callRecordSyncTask")
public class CallRecordSyncTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");

        CallRecordRequest request = new CallRecordRequest();
        request.setBeginTime(DateUtil.format(DateUtil.beginOfDay(DateUtil.yesterday()), "yyyy-MM-dd HH:mm:ss"));
        request.setEndTime(DateUtil.format(DateUtil.endOfDay(DateUtil.yesterday()), "yyyy-MM-dd HH:mm:ss"));

        CallRecordSync callRecordSync=new CallRecordSync();

        callRecordSync.syncData(request);
    }

}
