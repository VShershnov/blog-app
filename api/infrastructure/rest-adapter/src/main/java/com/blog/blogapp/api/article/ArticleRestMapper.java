package com.blog.blogapp.api.article;

import com.blog.blogapp.article.Article;
import com.blog.blogapp.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ArticleRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Article toDomain(ArticleCreateDto articleDto);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Article toDomain(Long id, ArticleCreateDto articleDto);

    ArticleDto toRest(Article article);

    ArticleIdDto toRest(Long id);

    ArticlesByAccountDto toRest(Integer accountId, List<Article> articles);

    ArticlesFilteredByDateDto toRest(Integer accountId, String createdAfter, List<Article> articles);
}