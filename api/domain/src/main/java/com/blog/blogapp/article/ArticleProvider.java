package com.blog.blogapp.article;

import java.util.List;
import java.util.Optional;

public interface ArticleProvider {

    long create(Article article);

    Article get(long id);

//    List<Article> getAll();

    void softDelete(long id);
}
