package com.blog.blogapp.api.article;

import com.blog.blogapp.article.Article;
import com.blog.blogapp.article.ArticleService;
import com.blog.blogapp.dto.ArticleCreateDto;
import com.blog.blogapp.dto.ArticleDto;
import com.blog.blogapp.dto.ArticleIdDto;
import com.blog.blogapp.dto.ArticlesByAccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRestMapper articleMapper;

    @GetMapping("/articles/{id}")
    public ArticleDto getArticle(@PathVariable Long id) {
        return articleMapper
            .toRest(articleService.getById(id));
    }

    @GetMapping("/articles")
    public ArticlesByAccountDto getArticlesByAccount(@RequestParam Integer accountId) {
        return articleMapper.toRest(accountId, articleService.getByAccountId(accountId));
    }

    @PatchMapping("/articles/{id}/update")
    public ArticleDto updateArticle(@PathVariable Long id, @RequestBody ArticleCreateDto articleDto, @RequestParam Integer accountId) {
        Article updated = articleService.update(articleMapper.toDomain(id, articleDto), accountId);
        return articleMapper.toRest(updated);
    }

    @PostMapping("/articles/new")
    public ArticleIdDto createNewArticle(@RequestBody ArticleCreateDto articleDto, @RequestParam Integer accountId) {
        Article article = articleMapper.toDomain(articleDto);
        long articleId = articleService.create(article, accountId);
        return articleMapper.toRest(articleId);
    }

    @DeleteMapping("/articles/{id}/delete")
    public void deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
    }
}
