package com.blog.blogapp.exception;

public class ArticleValidationException extends DomainException {

    private final ExceptionReason reason;

    public ArticleValidationException(String message, ExceptionReason reason) {
        super(message);
        this.reason = reason;
    }

    @Override
    public ExceptionReason getExceptionReason() {
        return reason;
    }
}
