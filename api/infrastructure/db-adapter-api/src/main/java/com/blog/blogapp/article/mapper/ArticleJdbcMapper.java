package com.blog.blogapp.article.mapper;

import com.blog.blogapp.article.Article;
import com.blog.blogapp.article.entity.ArticleJdbc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ArticleJdbcMapper {

    @Mapping(target = "deleted", ignore = true)
    ArticleJdbc toJdbc(Article article, int accountId);

    Article toDomain(ArticleJdbc articleJdbc);
}
