package com.blog.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ErrorReason
 */
public enum ErrorReasonDto {

    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),
    INVALID_PARAMETERS("INVALID_PARAMETERS"),
    ARTICLE_NOT_FOUND("ARTICLE_NOT_FOUND"),
    ARTICLE_TITLE_IS_EMPTY("ARTICLE_TITLE_IS_EMPTY"),
    ARTICLE_TITLE_IS_TOO_LONG("ARTICLE_TITLE_IS_TOO_LONG"),
    ARTICLE_CONTENT_IS_TOO_LONG("ARTICLE_CONTENT_IS_TOO_LONG");

    private final String value;

    ErrorReasonDto(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ErrorReasonDto fromValue(String value) {
        for (ErrorReasonDto b : ErrorReasonDto.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

