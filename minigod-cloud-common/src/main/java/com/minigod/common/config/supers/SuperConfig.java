package com.minigod.common.config.supers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @version v1.0
 * @Title: SuperConfig.java
 * @Description:
 * @Copyright: 2016 minigod
 * @Company: minigod
 * @date 2015-3-19 下午4:13:51
 */

public class SuperConfig {

    private static final Logger logger = LoggerFactory.getLogger(SuperConfig.class);

    public static final int POLLING_INTERVAL_TIME = 15;// 秒

    public static final int ONCE_TIMEOUT = 2000;// 毫秒

    public static final int CONN_TIMEOUT = 2000;// 毫秒

    private volatile boolean isRun = false;

    private ScheduledExecutorService scheduledExecutor = null;

    public synchronized void start(String remoteUrl) {
        if (isRun) {
            return;
        }

        if (null == scheduledExecutor || scheduledExecutor.isTerminated()) {
            scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        }

        logger.info("===== open config found...");
        //轮训
        rotateCheckConfigInfo(remoteUrl);
    }

    /**
     * 循环探测配置信息是否变化，如果变化，则再次向DiamondServer请求获取对应的配置信息
     */
    public void rotateCheckConfigInfo(final String remoteUrl) {

        scheduledExecutor.schedule(new Runnable() {
            public void run() {
                try {
                    System.err.println("ddd:" + remoteUrl);
                    //checkConfigInfo();
                } catch (Exception e) {
                    logger.error("循环探测发生异常", e);
                } finally {
                    rotateCheckConfigInfo(remoteUrl);
                }
            }

        }, POLLING_INTERVAL_TIME, TimeUnit.SECONDS);
    }
}
