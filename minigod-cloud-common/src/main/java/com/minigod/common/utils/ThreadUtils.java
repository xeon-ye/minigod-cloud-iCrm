package com.minigod.common.utils;

import com.minigod.common.exception.MiniGodException;

public class ThreadUtils {
	public static final void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			throw new MiniGodException(e);
		}
	}
}
