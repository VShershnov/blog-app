package com.blog.blogapp.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ArticleCreateDto {
    private String title;
    private String content;
    private String imageFilePath;
}
