package com.yangpixi.blog.myblog.service;

import com.yangpixi.blog.myblog.dto.ArticleRequest;
import com.yangpixi.blog.myblog.entity.Article;
import com.yangpixi.blog.myblog.repository.ArticleMapper;
import com.yangpixi.blog.myblog.vo.ArticleVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    Article getArticleById(int id);
    ArticleVO getArticleByTitle(String title);
    List<Article> getAllArticles();
    int createArticle(ArticleRequest article);
    int updateArticle(Article article);
    int deleteArticleById(int id);
}
