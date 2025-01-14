package com.blog.blogapp.article;

import com.blog.blogapp.article.mapper.ArticleJdbcMapper;
import com.blog.blogapp.exception.ArticleNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaArticleProvider implements ArticleProvider {

    private final ArticleRepository articleRepository;
    private final ArticleJdbcMapper articleMapper;

    @Override
    @Transactional
    public Article save(Article article, int accountId) {
        if (article.getId() == null) {
            article.setCreatedAt(LocalDateTime.now());
        }
        article.setUpdatedAt(LocalDateTime.now());

        return articleMapper.toDomain(
            articleRepository.save(articleMapper.toJdbc(article, accountId)));
    }

    @Override
    public Article get(long id) {
        return articleRepository.findById(id)
            .map(articleMapper::toDomain)
            .orElseThrow(() -> new ArticleNotFoundException("Article: " + id + " not found"));
    }

    @Override
    @Transactional
    public void softDelete(long id) {
        articleRepository.setArticleJdbcDeletedById(id, true);
    }

    @Override
    public List<Article> getByAccountId(int accountId) {
        return articleRepository.findByAccountId(accountId).stream()
            .map(articleMapper::toDomain)
            .toList();
    }
}
