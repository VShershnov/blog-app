package com.blog.blogapp.api.article;

import com.blog.blogapp.article.Article;
import com.blog.blogapp.dto.ArticleCreateDto;
import com.blog.blogapp.dto.ArticleDto;
import com.blog.blogapp.dto.ArticleIdDto;
import com.blog.blogapp.dto.ArticlesByAccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ArticleRestMapper {

    Article toDomain(ArticleDto articleDto);

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
}