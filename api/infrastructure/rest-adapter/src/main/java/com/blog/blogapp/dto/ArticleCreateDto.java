package com.blog.blogapp.dto;

import lombok.Data;

@Data
public class ArticleCreateDto {
    private String title;
    private String content;
    private String imageFilePath;
}
