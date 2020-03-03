package com.minigod.common.forkjoin;

/**
 * @Title: ILifeCycle.java
 * @Description: 生命周期
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-15 下午4:53:37
 * @version v1.0
 */

public abstract interface ILifeCycle {
	
	//初始化
	public abstract void init();
	
	public abstract void destroy();
	
	//按线程名称销毁
	public abstract void destroy(String threadPoolName);

	//销毁
	public abstract void destroyAll();
}