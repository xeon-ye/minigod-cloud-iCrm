package com.minigod.common.forkjoin.exception;

/**
 * @Title: ForJoinException.java
 * @Description: 并行计算异常
 * @Copyright:  2016 minigod
 * @Company: minigod
 *
 * @author
 * @date 2015-3-13 下午4:53:37
 * @version v1.0
 */

public class ForkJoinException extends RuntimeException {

	private static final long serialVersionUID = 2432097628701678505L;

	public ForkJoinException() {
		super();
	}

	public ForkJoinException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForkJoinException(String message) {
		super(message);
	}

	public ForkJoinException(Throwable cause) {
		super(cause);
	}
}
