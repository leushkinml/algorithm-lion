package com.skypro.algorithmlion.homework;

public class SetIsFullException extends RuntimeException {
    public SetIsFullException() {
    }

    public SetIsFullException(String message) {
        super(message);
    }

    public SetIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public SetIsFullException(Throwable cause) {
        super(cause);
    }

    public SetIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
