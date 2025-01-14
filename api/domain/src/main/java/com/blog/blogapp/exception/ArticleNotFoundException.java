package com.blog.blogapp.exception;

import static com.blog.blogapp.exception.ExceptionReason.ARTICLE_NOT_FOUND;

public class ArticleNotFoundException extends DomainException {
    private static final String ARTICLE_NOT_FOUND_MESSAGE = "Article %d not found";

    public ArticleNotFoundException(String message) {
        super(message);
    }

    public ArticleNotFoundException(long articleId) {
        super(String.format(ARTICLE_NOT_FOUND_MESSAGE, articleId));
    }

    @Override
    public ExceptionReason getExceptionReason() {
        return ARTICLE_NOT_FOUND;
    }
}
