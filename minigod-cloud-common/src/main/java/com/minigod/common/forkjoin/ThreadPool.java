package com.minigod.common.forkjoin;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Title: ThreadPool.java
 * @Description: 线程池
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-15 下午4:53:37
 * @version v1.0
 */

public interface ThreadPool {

	/** 默认的线程池名称 */
	static final String DEFAULT_THREAD_POOL = "default";
	
	/**
	 * 提交一个不需要返回值的异步任务给默认的线程池执行;
	 * @param task 实现了{@link Runnable}接口的异步任务
	 * @return 异步任务执行的结果
	 * @throws IllegalArgumentException 指定的任务（<code>task</code>）为null
	 * @see #submit(Runnable, String)
	 */
	public Future<?> submit(Runnable task);

	/**
	 * 提交一个不需要返回值的异步任务给指定的线程池执行
	 * @param task 实现了{@link Runnable}接口的异步任务
	 * @param threadPoolName 线程池名称
	 * @return 异步任务执行的结果
	 * @throws IllegalArgumentException 出现以下情况时抛出：
	 * <ul>
	 *     <li>指定的任务（<code>task</code>）为null；</li>
	 *     <li>指定的线程池名称（<code>threadPoolName</code>）为null;""或全是空白字符；</li>
	 *     <li>指定的线程池不存在;</li>
	 * </ul>
	 */
	public Future<?> submit(Runnable task, String threadPoolName);

	/**
	 * 提交一个需要返回值的异步任务给默认的线程池执行;
	 * @param task 实现了{@link Callable}接口的异步任务
	 * @return 异步任务执行的结果
	 * @throws IllegalArgumentException 指定的任务（<code>task</code>）为null
	 * @see #submit(Callable, String)
	 */
	public <T> Future<T> submit(Callable<T> task);

	/**
	 * 提交一个需要返回值的异步任务给指定的线程池执行;
	 * @param task 实现了{@link Callable}接口的异步任务
	 * @param threadPoolName 线程池名称
	 * @return 异步任务执行的结果
	 * @throws IllegalArgumentException 出现以下情况时抛出：
	 * <ul>
	 *     <li>指定的任务（<code>task</code>）为null；</li>
	 *     <li>指定的线程池名称（<code>threadPoolName</code>）为null;""或全是空白字符；</li>
	 *     <li>指定的线程池不存在;</li>
	 * </ul>
	 */
	public <T> Future<T> submit(Callable<T> task, String threadPoolName);

	/**
	 * 在线程池"default"中执行多个需要返回值的异步任务;并设置超时时间;
	 * @param tasks 实现了{@link Runnable}接口的异步任务列表
	 * @param timeout 任务执行超时时间
	 * @param timeoutUnit 超时时间的单位
	 * @return {@link Future}列表;注：如果在指定的时间内;有任务没有执行完;在执行Future.get操作时将抛出{@link CancellationException};
	 * @throws IllegalArgumentException 出现以下情况时抛出：
	 * <ul>
	 *     <li>指定的任务列表（<code>tasks</code>）为null或是空列表；</li>
	 *     <li>指定的线程池不存在;</li>
	 *     <li>指定的超时时间（<code>timeout</code>）小于或等于0</li>
	 * </ul>
	 * @see #invokeAll(List, String, int, TimeUnit)
	 */
	public <T> List<Future<T>> invokeAll(Collection<Callable<T>> tasks, long timeout, TimeUnit timeoutUnit);

	/**
	 * 在指定的线程池中执行多个需要返回值的异步任务;并设置超时时间;
	 * @param tasks 实现了{@link Runnable}接口的异步任务列表
	 * @param timeout 任务执行超时时间
	 * @param timeoutUnit 超时时间的单位
	 * @param threadPoolName 线程池名称
	 * @return {@link Future}列表;注：如果在指定的时间内;有任务没有执行完;在执行Future.get操作时将抛出{@link CancellationException};
	 * @throws IllegalArgumentException 出现以下情况时抛出：
	 * <ul>
	 *     <li>指定的任务列表（<code>tasks</code>）为null或是空列表；</li>
	 *     <li>指定的线程池名称（<code>threadPoolName</code>）为null;""或全是空白字符；</li>
	 *     <li>指定的线程池不存在</li>
	 *     <li>指定的超时时间（<code>timeout</code>）小于或等于0</li>
	 * </ul>
	 */
	public <T> List<Future<T>> invokeAll(Collection<Callable<T>> tasks, long timeout, TimeUnit timeoutUnit, String threadPoolName);

	/**
	 * 查询指定名称的线程池是否存在
	 * @param threadPoolName 线程池名称
	 * @return 如果指定的线程池存在;返回true；否则;返回true
	 * @throws IllegalArgumentException 指定的线程池名称（<code>threadPoolName</code>）为null;""或全是空白字符
	 */
	public boolean isExists(String threadPoolName);

	/**
	 * 获取线程池的信息;如：线程池容量;队列容量
	 * @param threadPoolName 线程池名称
	 * @return 线程池的信息({@link ThreadInfo})
	 */
	public ThreadPoolInfo getThreadPoolInfo(String threadPoolName);
	
	/**
	 * 打印线程的具体信息
	 * @param threadPoolName
	 */
	public void show(String... threadPoolName);
	
	/**
	 * 销毁指定名称的线程池
	 * @param threadPoolName
	 */
	public void destroy(String threadPoolName);

	/**
	 * 销毁所有的线程池
	 */
	public void destroyAll();
}
