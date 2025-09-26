package com.yangpixi.blog.myblog.controller;

import com.yangpixi.blog.myblog.dto.ArticleRequest;
import com.yangpixi.blog.myblog.entity.Article;
import com.yangpixi.blog.myblog.entity.RestBean;
import com.yangpixi.blog.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/create")
    public RestBean<?> creatArticles(@RequestBody ArticleRequest article) {
        if (articleService.createArticle(article) == 0) {
            return RestBean.failure(409, "已存在相同文章");
        } else {
            return RestBean.success("创建成功");
        }
    }

    @PostMapping("/update")
    public RestBean<?> updateArticles(@RequestBody Article article) {
        return RestBean.success(articleService.updateArticle(article));
    }

    @GetMapping("/getAll")
    public RestBean<?> getAllArticles() {
        return RestBean.success(articleService.getAllArticles());
    }

    @GetMapping("/get/{title}")
    public RestBean<?> getArticleByTitle(@PathVariable String title) {
        return RestBean.success(articleService.getArticleByTitle(title));
    }
}
