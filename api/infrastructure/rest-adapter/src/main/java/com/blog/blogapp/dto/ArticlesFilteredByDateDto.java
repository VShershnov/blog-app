package com.blog.blogapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticlesFilteredByDateDto {
    private int accountId;
    private String createdAfter;
    private List<ArticleDto> articles;
}
