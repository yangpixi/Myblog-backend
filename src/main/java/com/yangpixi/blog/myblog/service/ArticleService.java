package com.yangpixi.blog.myblog.service;

import com.yangpixi.blog.myblog.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    Article getArticleById(int id);
    List<Article> getAllArticles();
    int createArticle(Article article);
    int updateArticle(Article article);
    int deleteArticleById(int id);
}
