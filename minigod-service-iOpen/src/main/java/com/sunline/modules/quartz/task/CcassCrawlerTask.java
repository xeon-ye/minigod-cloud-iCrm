package com.sunline.modules.quartz.task;

import com.sunline.modules.ccass.crawler.CcassHoldingsCrawler;
import com.sunline.modules.ccass.crawler.CcassParticipantsCrawler;
import com.sunline.modules.ccass.entity.CcassHoldingsEntity;
import com.sunline.modules.ccass.entity.CcassParticipantsEntity;
import com.sunline.modules.ccass.service.CcassParticipantsService;
import com.sunline.modules.common.annotation.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 爬取CCASS Data
 * @author: Larry Lai
 * @date: 2018/5/17 16:15
 * @version: v1.0
 */

@Component("ccassCrawlerTask")
public class CcassCrawlerTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CcassParticipantsService ccassParticipantsService;

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 种子页面
     */
    private static String HOLDINGS_URL = "https://webb-site.com/ccass/cholder.asp?part=${}&d=${}";

//    @SysLog("CCASS数据爬取")
    public void excute(String params) throws Exception {

        logger.info(params + "任务开始");

        // 爬取参与者信息
        CcassParticipantsCrawler ccassParticipantsCrawler = new CcassParticipantsCrawler("crawl", true);
        ccassParticipantsCrawler.setThreads(5);
        ccassParticipantsCrawler.setTopN(50);
        //crawler.setResumable(true);
        // 网页爬取深度为4
        ccassParticipantsCrawler.start(4);

        // 判断ccassParticipantsCrawler是否结束
        if (!ccassParticipantsCrawler.isResumable()) {

            // 从DB获取参与者信息列表
            CcassParticipantsEntity ccassParticipants = new CcassParticipantsEntity();
//            ccassParticipants.setPartId(1151);

            List<CcassParticipantsEntity> ccassParticipantsEntityList = ccassParticipantsService.queryListByBean(ccassParticipants);

            if (null != ccassParticipantsEntityList) {
                int partId;
                int partcipantId;
                String url;

                for (CcassParticipantsEntity ccassParticipantsEntity : ccassParticipantsEntityList) {
                    partcipantId = ccassParticipantsEntity.getId();
                    partId = ccassParticipantsEntity.getPartId();

                    CcassHoldingsEntity ccassHoldingsEntity = new CcassHoldingsEntity();
                    ccassHoldingsEntity.setParticipantId(partcipantId);

                    // 拼接URL
                    url = HOLDINGS_URL.replaceFirst("\\$\\{\\}", String.valueOf(partId)).replaceFirst("\\$\\{\\}", sdf.format(new Date()));

                    CcassHoldingsCrawler ccassHoldingsCrawler = new CcassHoldingsCrawler("crawl", true);
                    ccassHoldingsCrawler.addSeed(url);
                    ccassHoldingsCrawler.setThreads(5);
                    ccassHoldingsCrawler.setTopN(50);
                    //crawler.setResumable(true);
                    // 网页爬取深度为4
                    ccassHoldingsCrawler.start(4);
                }
            }
        }

        logger.info(params + "任务结束");
    }
}
