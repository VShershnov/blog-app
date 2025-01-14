package com.blog.blogapp.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultArticleService implements ArticleService {

    private final ArticleProvider articleProvider;
    private final ArticleValidator articleValidator;

    public Article getById(Long id) {
        return articleProvider.get(id);
    }

    @Override
    public List<Article> getByAccountId(int accountId) {
        return articleProvider.getByAccountId(accountId);
    }

    public long create(Article article, int accountId) {
        articleValidator.validate(article);
        return articleProvider.save(article, accountId).getId();
    }

    @Override
    public Article update(Article article, int accountId) {
        articleValidator.validate(article);
        Article existingArticle = articleProvider.get(article.getId());
        article.setId(existingArticle.getId());

        return articleProvider.save(article, accountId);
    }

    @Override
    public void delete(Long id) {
        Article article = articleProvider.get(id);
        articleProvider.softDelete(article.getId());
    }

    @Override
    public List<Article> getByAccountIdAndFilteredByCreateDate(Integer accountId, String createdAfter) {
        return articleProvider.getByAccountIdAndFilteredByCreateDate(accountId, createdAfter);
    }
}
