package com.minigod.common.exception;

public class MiniGodException extends RuntimeException {
	private static final long serialVersionUID = -6830494624999358786L;

	public MiniGodException() {
		super();
	}

	public MiniGodException(String message, Throwable cause) {
		super(message, cause);
	}

	public MiniGodException(String message) {
		super(message);
	}

	public MiniGodException(Throwable cause) {
		super(cause);
	}
}
