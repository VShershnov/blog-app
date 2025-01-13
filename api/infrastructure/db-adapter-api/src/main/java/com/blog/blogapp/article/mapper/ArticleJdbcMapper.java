package com.blog.blogapp.article.mapper;

import com.blog.blogapp.article.Article;
import com.blog.blogapp.article.entity.ArticleJdbc;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ArticleJdbcMapper {

    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ArticleJdbc toJdbc(Article article);

    Article toDomain(ArticleJdbc articleJdbc);

//    List<Article> toDomain(List<ArticleJdbc> articleJdbcList);
}
