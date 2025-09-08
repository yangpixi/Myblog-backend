package com.yangpixi.blog.myblog.service.Impl;

import com.yangpixi.blog.myblog.entity.Article;
import com.yangpixi.blog.myblog.repository.ArticleMapper;
import com.yangpixi.blog.myblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper mapper;

    @Override
    public Article getArticleById(int id) {
        return mapper.getArticleById(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return mapper.getAllArticles();
    }

    @Override
    public int createArticle(Article article) {
        return mapper.insertArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return mapper.updateArticle(article);
    }

    @Override
    public int deleteArticleById(int id) {
        return mapper.deleteArticle(id);
    }
}
