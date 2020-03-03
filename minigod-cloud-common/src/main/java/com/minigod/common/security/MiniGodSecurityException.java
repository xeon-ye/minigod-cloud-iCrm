package com.minigod.common.security;

public class MiniGodSecurityException extends RuntimeException {
	private static final long serialVersionUID = -6830494624999358786L;

	public MiniGodSecurityException() {
		super();
	}

	public MiniGodSecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	public MiniGodSecurityException(String message) {
		super(message);
	}

	public MiniGodSecurityException(Throwable cause) {
		super(cause);
	}
}
