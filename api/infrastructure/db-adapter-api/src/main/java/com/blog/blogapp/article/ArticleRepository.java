package com.blog.blogapp.article;

import com.blog.blogapp.article.entity.ArticleJdbc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleJdbc, Long> {

//    @Query(value = "select new com.blog.blogapp.article.Article(t.userId, count(t.entityId), max(t.updatedAt)) from Article as t where t.dataSetId=:dataSetId group by t.userId")
//    List<ArticleJdbc> getCollaborators(@Param("dataSetId") int dataSetId);

    @Modifying
    @Query(value = "UPDATE ArticleJdbc SET deleted = :is_deleted WHERE id = :id ")
    void setArticleJdbcDeletedById(@Param("id") long id, @Param("is_deleted") boolean isDeleted);
}
