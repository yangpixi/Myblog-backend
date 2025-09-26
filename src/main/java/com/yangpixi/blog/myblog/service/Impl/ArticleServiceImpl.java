package com.yangpixi.blog.myblog.service.Impl;

import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ext.anchorlink.AnchorLinkExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeVisitor;
import com.vladsch.flexmark.util.ast.VisitHandler;
import com.vladsch.flexmark.util.data.MutableDataSet;
import com.yangpixi.blog.myblog.dto.ArticleRequest;
import com.yangpixi.blog.myblog.entity.Article;
import com.yangpixi.blog.myblog.repository.ArticleMapper;
import com.yangpixi.blog.myblog.service.ArticleService;
import com.yangpixi.blog.myblog.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
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
    public ArticleVO getArticleByTitle(String title) {
        MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Arrays.asList(
                AnchorLinkExtension.create(),
                StrikethroughExtension.create()
        )).toImmutable();
        options.set(HtmlRenderer.GENERATE_HEADER_ID, true);
        options.set(AnchorLinkExtension.ANCHORLINKS_SET_ID, true);
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = new HtmlRenderer.Builder(options).build();
        Node document = parser.parse(mapper.getArticleByTitle(title).getContent());
        List<ArticleVO.subtitle> subtitleList = new ArrayList<>();
        NodeVisitor nodeVisitor = new NodeVisitor(
                new VisitHandler<>(Heading.class, (heading -> {
                    int level = heading.getLevel();
                    String text = heading.getText().toString();
                    String id = "toc-heading-" + heading.getText().toString();
                    ArticleVO.subtitle subtitle = new ArticleVO.subtitle(level, text, id);
                    subtitleList.add(subtitle);
                }))
        );
        nodeVisitor.visit(document);
        Article article = mapper.getArticleByTitle(title);
        return new ArticleVO(article.getTitle(), article.getContent(), subtitleList);
    }

    @Override
    public List<Article> getAllArticles() {
        return mapper.getAllArticles();
    }

    @Override
    public int createArticle(ArticleRequest articleRequest) {
        if (this.getArticleByTitle(articleRequest.getTitle()) == null ) {
            Article article = new Article();
            article.setTitle(articleRequest.getTitle());
            article.setContent(articleRequest.getContent());
            return mapper.insertArticle(article);
        } else {
            return 0;
        }
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
