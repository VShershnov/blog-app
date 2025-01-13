package com.blog.blogapp.exception;

public abstract class DomainException extends RuntimeException {

    private static final int DEFAULT_DOMAIN_STATUS_CODE = 400;

    protected DomainException(String message) {
        super(message);
    }

    protected DomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getCode() {
        return DEFAULT_DOMAIN_STATUS_CODE;
    }

    public abstract ExceptionReason getExceptionReason();
}
