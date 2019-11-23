package com.niit.web.blog.service;

import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.util.Result;
import org.junit.Test;

import java.util.List;



public class ArticleServiceTest {
    private ArticleService articleService = ServiceFactory.getArticleServiceInstance();
    @Test
    public void listarticle() {
        List<Article> articles = articleService.listarticle();
        articles.forEach(article -> System.out.println(article));
    }

    @Test
    public void getArticle() {
        Result result = articleService.getArticle(5);
        System.out.println(result.getData());
    }
}