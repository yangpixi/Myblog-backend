package com.yangpixi.blog.myblog.repository;

import com.yangpixi.blog.myblog.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    Article getArticleById(int id);
    Article getArticleByTitle(String title);
    int insertArticle(Article article);
    int updateArticle(Article article);
    int deleteArticle(int id);
    List<Article> getAllArticles();
}
