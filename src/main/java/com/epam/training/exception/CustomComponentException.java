package com.epam.training.exception;

public class CustomComponentException extends Exception {

    public CustomComponentException() {
    }

    public CustomComponentException(String message) {
        super(message);
    }

    public CustomComponentException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomComponentException(Throwable cause) {
        super(cause);
    }

    public CustomComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
