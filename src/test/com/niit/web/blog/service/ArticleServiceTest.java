package com.niit.web.blog.service;

import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.util.Result;
import org.junit.Test;

import java.util.List;


public class ArticleServiceTest {
    private ArticleService articleService = ServiceFactory.getArticleServiceInstance();

    /**
     * 查询所有文章数据
     */
    @Test
    public void listarticle() {
        List<Article> articles = articleService.listarticle();
        articles.forEach(article -> System.out.println(article));
    }

    /**
     * 测试指定id查询文章数据
     */
    @Test
    public void getArticle() {
        Result result = articleService.getArticle(5);
        System.out.println(result.getData());
    }

    /**
     * 测试分页
     */
    @Test
    public void getArticlesByPage() {
        Result result = articleService.getArticlesByPage(2,10);
        System.out.println(result.getData());
    }

    /**
     * 测试专题id查询所属专题文章
     */
    @Test
    public void selectByTopicId() {
        Result result = articleService.selectByTopicId((long) 53);
        System.out.println(result.getData());
    }

    /**
     * 测试热门文章
     */
    @Test
    public void getHotArticle() {
        Result result = articleService.getHotArticles();
        System.out.println(result);
    }

    /**
     * 测试根据用户id查询文章数据
     */
    @Test
    public void selectByUserId() {
        Result result = articleService.selectByUserId(Long.parseLong(String.valueOf(8)));
        System.out.println(result.getData());
    }
}