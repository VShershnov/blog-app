package com.blog.blogapp.article;

import com.blog.blogapp.exception.ArticleValidationException;
import org.springframework.stereotype.Service;

import static com.blog.blogapp.exception.ExceptionReason.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class DefaultArticleValidator implements ArticleValidator {

    public static final int ARTICLE_TITLE_LENGTH_LIMIT = 20;
    public static final int ARTICLE_CONTENT_LENGTH_LIMIT = 200;

    private static final String EMPTY_TITLE_ERR_MESSAGE = "Article title can't be empty or null";
    private static final String LENGTH_TITLE_ERR_MESSAGE = "Article title can't be longer then " + ARTICLE_TITLE_LENGTH_LIMIT + " symbols";
    private static final String LENGTH_CONTENT_ERR_MESSAGE = "Article content can't be longer then " + ARTICLE_CONTENT_LENGTH_LIMIT + " symbols";

    @Override
    public void validate(Article article) {
        emptyValidation(article.getTitle())
            .titleLengthValidation(article.getTitle())
            .contentLengthValidation(article.getContent());
    }

    private DefaultArticleValidator emptyValidation(String title) {
        if (isNull(title) || title.isBlank()) {
            throw new ArticleValidationException(EMPTY_TITLE_ERR_MESSAGE, ARTICLE_TITLE_IS_EMPTY);
        }
        return this;
    }

    private DefaultArticleValidator titleLengthValidation(String title) {
        if (nonNull(title) && ARTICLE_TITLE_LENGTH_LIMIT < title.length()) {
            throw new ArticleValidationException(LENGTH_TITLE_ERR_MESSAGE, ARTICLE_TITLE_IS_TOO_LONG);
        }
        return this;
    }

    private void contentLengthValidation(String content) {
        if (nonNull(content) && ARTICLE_CONTENT_LENGTH_LIMIT < content.length()) {
            throw new ArticleValidationException(LENGTH_CONTENT_ERR_MESSAGE, ARTICLE_CONTENT_IS_TOO_LONG);
        }
    }
}
