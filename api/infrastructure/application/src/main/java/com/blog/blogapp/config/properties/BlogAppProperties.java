package com.blog.blogapp.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "blogapp")
@Data
public class BlogAppProperties implements WebApiProperties {
    private Api api;

    @Override
    public String getBasePath() {
        return api.basePath;
    }

    @Data
    static class Api {
        private String basePath;
    }
}