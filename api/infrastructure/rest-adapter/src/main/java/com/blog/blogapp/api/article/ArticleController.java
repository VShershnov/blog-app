package com.blog.blogapp.api.article;

import com.blog.blogapp.article.ArticleService;
import com.blog.blogapp.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRestMapper articleRestMapper;

    @GetMapping("/articles/{id}")
    public ArticleDto getArticle(@PathVariable Long id) {
        return articleRestMapper
            .toRest(articleService.getById(id));
    }

//    @PostMapping("/articles/{id}")
////    @PreAuthorize("isAuthenticated()")
//    public Article updateArticle(@PathVariable Long id, Article article, @RequestParam("file") MultipartFile file) {
//
//        Optional<Article> optionalArticle = defaultArticleService.getById(id);
//        if (optionalArticle.isPresent()) {
//            Article existingArticle = optionalArticle.get();
//
//            existingArticle.setTitle(article.getTitle());
//            existingArticle.setContent(article.getContent());
//
//            try {
////                fileService.save(file);
//                existingArticle.setImageFilePath(file.getOriginalFilename());
//            } catch (Exception e) {
//                log.error("Error processing file: {}", file.getOriginalFilename());
//            }
//
//            defaultArticleService.save(existingArticle);
//        }
//
//        return optionalArticle.get();
//    }

//    @GetMapping("/posts/new")
////    @PreAuthorize("isAuthenticated()")
//    public String createNewArticle(Model model) {
//
//        Post post = new Post();
//        model.addAttribute("post", post);
//        return "post_new";
//    }

//    @PostMapping("/articles/new")
////    @PreAuthorize("isAuthenticated()")
//    public Long createNewArticle(@ModelAttribute Article article, @RequestParam("file") MultipartFile file, Principal principal) {
////        String authUsername = "anonymousUser";
////        if (principal != null) {
////            authUsername = principal.getName();
////        }
//
////        Account account = accountService.findOneByEmail(authUsername).orElseThrow(() -> new IllegalArgumentException("Account not found"));
//
//        try {
////            fileService.save(file);
////            post.setImageFilePath(file.getOriginalFilename());
//        } catch (Exception e) {
//            log.error("Error processing file: {}", file.getOriginalFilename());
//        }
//
////        article.setAccount(account);
//        Article response = defaultArticleService.save(article);
//        return response.getId();
//    }

//    @GetMapping("/articles/{id}/edit")
////    @PreAuthorize("isAuthenticated()")
//    public String getArticleForEdit(@PathVariable Long id) {
//
//        // find post by id
//        Optional<Article> optionalPost = postService.getById(id);
//        // if post exist put it in model
//        if (optionalPost.isPresent()) {
//            Article article = optionalPost.get();
//            model.addAttribute("post", post);
//            return "post_edit";
//        } else {
//            return "404";
//        }
//    }

//    @GetMapping("/articles/{id}/delete")
////    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    public void deleteArticle(@PathVariable Long id) {
//
//        // find post by id
//        Optional<Article> optionalArticle = defaultArticleService.getById(id);
//        if (optionalArticle.isPresent()) {
//            Article article = optionalArticle.get();
//
//            defaultArticleService.delete(article);
////            return "redirect:/";
//        } else {
////            return "404";
//        }
//    }
}
