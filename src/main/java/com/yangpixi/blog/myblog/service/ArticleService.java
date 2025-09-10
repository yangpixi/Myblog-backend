package com.yangpixi.blog.myblog.service;

import com.yangpixi.blog.myblog.entity.Article;
import com.yangpixi.blog.myblog.repository.ArticleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    Article getArticleById(int id);
    Article getArticleByTitle(String title);
    List<Article> getAllArticles();
    int createArticle(Article article);
    int updateArticle(Article article);
    int deleteArticleById(int id);
}
