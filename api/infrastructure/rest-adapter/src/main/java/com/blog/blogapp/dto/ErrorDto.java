package com.blog.blogapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    @JsonProperty("reason")
    private ErrorReasonDto reason;

    @JsonProperty("message")
    private String message;

    ErrorDto(ErrorReasonDto reason, String message) {
        this.reason = reason;
        this.message = message;
    }

    public static ErrorDtoBuilder builder() {
        return new ErrorDtoBuilder();
    }

    public static class ErrorDtoBuilder {
        private ErrorReasonDto reason;
        private String message;

        ErrorDtoBuilder() {
        }

        @JsonProperty("reason")
        public ErrorDtoBuilder reason(ErrorReasonDto reason) {
            this.reason = reason;
            return this;
        }

        @JsonProperty("message")
        public ErrorDtoBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorDto build() {
            return new ErrorDto(this.reason, this.message);
        }

        public String toString() {
            return "ErrorDto.ErrorDtoBuilder(reason=" + this.reason + ", message=" + this.message + ")";
        }
    }
}

