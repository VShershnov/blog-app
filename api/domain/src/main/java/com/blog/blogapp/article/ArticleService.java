package com.blog.blogapp.article;

import java.util.List;

public interface ArticleService {

    Article getById(Long id);

    List<Article> getByAccountId(int accountId);

    long create(Article article, int accountId);

    Article update(Article article, int accountId);

    void delete(Long id);

    List<Article> getByAccountIdAndFilteredByCreateDate(Integer accountId, String createdAfter);
}
