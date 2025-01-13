package com.blog.blogapp.article;

import com.blog.blogapp.article.mapper.ArticleJdbcMapper;
import com.blog.blogapp.exception.ArticleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaArticleProvider implements ArticleProvider {

    private final ArticleRepository articleRepository;
    private final ArticleJdbcMapper articleMapper;

    @Override
//    @Transactional
    public long create(Article article) {
//        if (article.getId() == null) {
//            article.setCreatedAt(LocalDateTime.now());
//        }
//        article.setUpdatedAt(LocalDateTime.now());
//        return articleRepository.save(article);
        return articleRepository.save(articleMapper.toJdbc(article)).getId();
    }

//    @Override
//    public List<Article> getAll() {
//    return articleRepository.findAll();
//        return List.of();
//    }

    @Override
    public Article get(long id) {
        return articleRepository.findById(id)
            .map(articleMapper::toDomain)
//            .ifPresentOrElse(articleMapper::toDomain, () -> new ArticleNotFoundException("Article: " + id + " not found"));
            .orElseThrow(() -> new ArticleNotFoundException("Article: " + id + " not found"));
    }

    @Override
//    @Transactional
    public void softDelete(long id) {
        articleRepository.setArticleJdbcDeletedById(id, true);
    }

//    @Override
//    public List<Column> getByIds(Collection<Integer> columnIds) {
//        return columnMapper.toDomain(columnRepository.findAllById(columnIds));
//    }

//    @Override
//    public boolean existsForIdsAndEntityTypeAndName(Set<Integer> columnIds, EntityType entityType, String name) {
//        return columnRepository.existsByIdInAndEntityTypeAndName(columnIds, entityType, name);
//    }
}
