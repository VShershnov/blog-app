package com.blog.blogapp.article.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class ArticleJdbc {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String imageFilePath;

    @NotNull
    private int accountId;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;
}
