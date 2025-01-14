package com.blog.blogapp.article;

import com.blog.blogapp.article.entity.ArticleJdbc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleJdbc, Long> {

    List<ArticleJdbc> findByAccountId(int accountId);

    List<ArticleJdbc> findByAccountIdAndCreatedAtAfter(int accountId, LocalDateTime createdAfter);

    @Modifying
    @Query(value = "UPDATE ArticleJdbc SET deleted = :is_deleted WHERE id = :id ")
    void setArticleJdbcDeletedById(@Param("id") long id, @Param("is_deleted") boolean isDeleted);
}
