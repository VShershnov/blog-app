package com.blog.blogapp.errorhandling;

import com.blog.blogapp.dto.ErrorDto;
import com.blog.blogapp.exception.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static com.blog.blogapp.dto.ErrorReasonDto.INTERNAL_SERVER_ERROR;
import static com.blog.blogapp.dto.ErrorReasonDto.INVALID_PARAMETERS;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    private final ErrorReasonRestMapper errorReasonMapper;

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorDto> handleException(DomainException e) {
        log.warn("Domain server error", e);
        ErrorDto errorDto = ErrorDto.builder()
            .reason(errorReasonMapper.toRest(e.getExceptionReason()))
            .message(e.getMessage())
            .build();
        return ResponseEntity.status(e.getCode()).body(errorDto);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorDto handleNoHandlerFoundException(Exception e) {
        log.warn("No Handler Found Exception", e);
        return ErrorDto.builder().reason(INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto handleInvalidParametersException(MethodArgumentNotValidException e) {
        log.warn("Invalid parameters", e);
        return ErrorDto.builder().reason(INVALID_PARAMETERS).build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto handleException(Exception e) {
        log.error("Internal server error", e);
        return ErrorDto.builder().reason(INTERNAL_SERVER_ERROR).build();
    }
}
