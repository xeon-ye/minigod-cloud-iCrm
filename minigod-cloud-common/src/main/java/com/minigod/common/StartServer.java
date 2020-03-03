package com.minigod.common;

import com.minigod.common.utils.ThreadUtils;

/**
 * 启动服务
 */

public abstract class StartServer {

	public abstract void execute();
	
	public void start() {
		execute();
		while (true) {
			ThreadUtils.sleep(5000);
		}
	}
}
