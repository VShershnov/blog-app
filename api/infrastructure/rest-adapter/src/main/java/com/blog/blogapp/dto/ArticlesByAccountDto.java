package com.blog.blogapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ArticlesByAccountDto {
    private int accountId;
    private List<ArticleDto> articles;
}
