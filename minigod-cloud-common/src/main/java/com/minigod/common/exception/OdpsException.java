package com.minigod.common.exception;

public class OdpsException extends RuntimeException {
    private static final long serialVersionUID = 6470027935132862237L;

    public OdpsException() {
    }

    public OdpsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OdpsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OdpsException(String message) {
        super(message);
    }

    public OdpsException(Throwable cause) {
        super(cause);
    }
}
