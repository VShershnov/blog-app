package com.blog.blogapp.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultArticleService implements ArticleService {

    private final ArticleProvider articleProvider;

    public Article getById(Long id) {
        return articleProvider.get(id);
    }
//
//    public List<Article> getAll() {
//        return articleProvider.getAll();
//    }
//
//    public Article save(Article article) {
//        if (article.getId() == null) {
//            article.setCreatedAt(LocalDateTime.now());
//        }
//        article.setUpdatedAt(LocalDateTime.now());
//        return articleProvider.create(article);
//    }
//
//    public void delete(Article article) {
//        articleProvider.softDelete(article.getId());
//    } ///input just id
}
