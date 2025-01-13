package com.blog.blogapp.filter;

import com.blog.blogapp.config.properties.WebApiProperties;
import com.google.common.base.Stopwatch;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static jakarta.servlet.http.HttpServletResponse.SC_OK;
import static java.util.Objects.isNull;

@Order(2)
@Component
@Slf4j
public class RequestLoggerFilter extends BlogAppApiFilter {
    private static final String LOGGER_STOPWATCH = "request_logger_stopwatch";

    public RequestLoggerFilter(WebApiProperties webApiProperties) {
        super(webApiProperties);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String msg = buildRequestString(request);

        try {
            request.setAttribute(LOGGER_STOPWATCH, Stopwatch.createStarted());
            log.info("BEGIN: {}", msg);
            chain.doFilter(request, response);
        } finally {
            Stopwatch sw = (Stopwatch) request.getAttribute(LOGGER_STOPWATCH);
            request.removeAttribute(LOGGER_STOPWATCH);

            int status = response.getStatus();
            if (status == SC_OK) {
                log.info("END: {} {} [{}]", msg, status, sw.stop());
            } else {
                log.error("END: {} {} [{}]", msg, status, sw.stop());
            }
        }
    }

    private String buildRequestString(HttpServletRequest request) {
        return request.getMethod()
            .concat(" ")
            .concat(request.getRequestURI())
            .concat(isNull(request.getQueryString()) ? "" : "?" + request.getQueryString());
    }

}
