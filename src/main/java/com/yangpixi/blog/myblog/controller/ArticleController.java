package com.yangpixi.blog.myblog.controller;

import com.yangpixi.blog.myblog.entity.Article;
import com.yangpixi.blog.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/create")
    public int creatArticles(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PostMapping("/update")
    public int updateArticles(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }
}
