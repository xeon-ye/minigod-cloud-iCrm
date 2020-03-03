package com.minigod.common.forkjoin.threadpool.impl;

import com.minigod.common.forkjoin.ILifeCycle;
import com.minigod.common.forkjoin.ThreadPo;
import com.minigod.common.forkjoin.ThreadPool;
import com.minigod.common.forkjoin.ThreadPoolInfo;
import com.minigod.common.exception.MiniGodException;
import com.minigod.common.forkjoin.exception.ForkJoinException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.*;

/**
 * @author
 * @version v1.0
 * @Title: ThreadPoolImpl.java
 * @Description: 多线程池处理
 * @Copyright: 2016 minigod
 * @Company: minigod
 * @date 2015-3-15 下午4:53:37
 */

public class ThreadPoolImpl implements ILifeCycle, ThreadPool {

    private static Logger logger = LoggerFactory.getLogger(ThreadPoolImpl.class);

    //缓存线程池
    private static final Map<String, ThreadPo> multiThreadPool = new ConcurrentHashMap<String, ThreadPo>();

    public ThreadPoolImpl(ThreadPoolInfo threadPoolInfo) {
        initThreadPool(threadPoolInfo);
    }

    public void init() {
        throw new ForkJoinException("ThreadPoolImpl init is nothing.");
    }

    /**
     * 初始化线程池
     */
    private void initThreadPool(ThreadPoolInfo threadPoolInfo) {
        if (threadPoolInfo == null || StringUtils.isEmpty(threadPoolInfo.getName())) {
            throw new IllegalArgumentException("threadPoolInfo is handler.");
        }
        if (!multiThreadPool.containsKey(threadPoolInfo.getName())) {
            BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(threadPoolInfo.getQueueSize());
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                    //核心线程数
                    threadPoolInfo.getCoreSize(),
                    //最大线程数
                    threadPoolInfo.getMaxSize(),
                    //线程空闲生存时间
                    threadPoolInfo.getThreadKeepAliveTime(), TimeUnit.SECONDS,
                    //线程池队列的容量
                    workQueue, new DefaultThreadFactory(threadPoolInfo.getName()));
            multiThreadPool.put(threadPoolInfo.getName(), new ThreadPo(threadPool, threadPoolInfo));
            logger.info(String.format("initialization thread pool %s success.", threadPoolInfo.getName()));
        }
    }

    public Future<?> submit(Runnable task) {
        return submit(task, DEFAULT_THREAD_POOL);
    }

    public Future<?> submit(Runnable task, String threadPoolName) {
        if (null == task) {
            throw new IllegalArgumentException("task is null.");
        }
        ExecutorService threadPool = getExistsThreadPool(threadPoolName);
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("submit a task to thread pool %s.", threadPoolName));
        }
        if (threadPool == null) {
            throw new MiniGodException(String.format("not found thread pool %s.", threadPoolName));
        }
        return threadPool.submit(task);
    }

    private ExecutorService getThreadPool(String threadPoolName) {
        if (StringUtils.isBlank(threadPoolName)) {
            throw new IllegalArgumentException("thread pool name is empty.");
        }
        logger.info("" + threadPoolName);
        ThreadPo threadPool = multiThreadPool.get(threadPoolName);
        if (threadPool == null) {
            throw new MiniGodException(String.format("not found thread pool %s.", threadPoolName));
        }
        return threadPool.getExecutorService();
    }

    private ExecutorService getExistsThreadPool(String threadPoolName) {
        ExecutorService threadPool = getThreadPool(threadPoolName);
        if (null == threadPool) {
            throw new IllegalArgumentException(String.format("thread pool %s not exists.", threadPoolName));
        }
        return threadPool;
    }

    public <T> Future<T> submit(Callable<T> task) {
        return submit(task, DEFAULT_THREAD_POOL);
    }

    public <T> Future<T> submit(Callable<T> task, String threadPoolName) {
        if (null == task) {
            throw new IllegalArgumentException("task is null.");
        }
        ExecutorService threadPool = getExistsThreadPool(threadPoolName);
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("submit a task to thread pool %s", threadPoolName));
        }
        if (threadPool == null) {
            throw new MiniGodException(String.format("not found thread pool %s.", threadPoolName));
        }
        return threadPool.submit(task);
    }

    public <T> List<Future<T>> invokeAll(Collection<Callable<T>> tasks, long timeout, TimeUnit timeoutUnit) {
        return invokeAll(tasks, timeout, timeoutUnit, DEFAULT_THREAD_POOL);
    }

    public <T> List<Future<T>> invokeAll(Collection<Callable<T>> tasks, long timeout, TimeUnit timeoutUnit, String threadPoolName) {
        if (null == tasks || tasks.isEmpty()) {
            throw new IllegalArgumentException("task list is null or empty.");
        }
        if (timeout <= 0) {
            throw new IllegalArgumentException("timeout less than or equals zero.");
        }

        ExecutorService threadPool = getExistsThreadPool(threadPoolName);
        if (logger.isDebugEnabled()) {
            logger.debug(String.format("invoke task list in thread pool %s", threadPoolName));
            //打印线程信息
            show(threadPoolName);
        }

        try {
            return threadPool.invokeAll(tasks, timeout, timeoutUnit);
        } catch (Exception e) {
            throw new ForkJoinException("invoke task list occurs handler.", e);
        }
    }

    public boolean isExists(String threadPoolName) {
        ExecutorService threadPool = getThreadPool(threadPoolName);
        return (null == threadPool ? false : true);
    }

    //打印线程使用情况
    public void show(String... threadPoolName) {
        String threadName = DEFAULT_THREAD_POOL;
        if (threadPoolName != null && threadPoolName.length > 0) {
            threadName = threadPoolName[0];
        }
        ExecutorService executorService = getExistsThreadPool(threadName);
        ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
        logger.info(String.format("ThreadPoolName:%s, ActiveThread:%d, TotalTask:%d, CompletedTask:%d, Queue:%d", threadName, pool.getActiveCount(), pool.getTaskCount(),
                pool.getCompletedTaskCount(), pool.getQueue().size()));
    }

    public ThreadPoolInfo getThreadPoolInfo(String threadPoolName) {
        ThreadPo info = multiThreadPool.get(threadPoolName);
        return info.getThreadPoolInfo();
    }

    public void destroy(String threadPoolName) {
        ExecutorService executorService = getExistsThreadPool(threadPoolName);
        executorService.shutdown();
        multiThreadPool.remove(threadPoolName);
    }

    public void destroy() {
        destroyAll();
    }

    public void destroyAll() {
        for (Entry<String, ThreadPo> entry : multiThreadPool.entrySet()) {
            logger.info("shutdown the thread pool " + entry.getKey());
            entry.getValue().getExecutorService().shutdown();
            multiThreadPool.clear();
        }
    }
}
