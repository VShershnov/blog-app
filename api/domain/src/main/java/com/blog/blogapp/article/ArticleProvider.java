package com.blog.blogapp.article;

import java.util.List;

public interface ArticleProvider {

    Article save(Article article, int accountId);

    Article get(long id);

    void softDelete(long id);

    List<Article> getByAccountId(int accountId);

//    Article updateArticle(Article article, int accountId);
}
