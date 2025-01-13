package com.blog.blogapp.config;

import com.blog.blogapp.filter.ExceptionHandlerFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    public static final String BLOG_APP_API_BASE_PACKAGE = "com.blog.blogapp.api";

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/", HandlerTypePredicate.forBasePackage(BLOG_APP_API_BASE_PACKAGE));
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        converters
            .stream()
            .filter(MappingJackson2HttpMessageConverter.class::isInstance)
            .forEach(c -> ((MappingJackson2HttpMessageConverter) c).setObjectMapper(objectMapper));
    }

    @Bean
    public Filter exceptionResolverFilter(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        return new ExceptionHandlerFilter(resolver);
    }
}
