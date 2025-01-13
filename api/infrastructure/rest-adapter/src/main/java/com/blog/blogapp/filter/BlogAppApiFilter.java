package com.blog.blogapp.filter;

import com.blog.blogapp.config.properties.WebApiProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Slf4j
public abstract class BlogAppApiFilter extends OncePerRequestFilter {
    private final WebApiProperties webApiProperties;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getRequestURI().startsWith(webApiProperties.getBasePath());
    }
}
