package com.blog.blogapp.api.article;

import com.blog.blogapp.article.Article;
import com.blog.blogapp.dto.ArticleDto;
import com.blog.blogapp.dto.ArticleIdDto;
import org.mapstruct.Mapper;

@Mapper
public interface ArticleRestMapper {

    Article toDomain(ArticleDto articleDto);

    ArticleDto toRest(Article article);

    ArticleIdDto toRest(Long id);
}