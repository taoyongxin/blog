package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.Student;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupDemo;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ArticleDaoTest {
//    private static Logger logger = LoggerFactory.getLogger(ArticleDao.class);
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    @Test
    public void batchInsert() throws SQLException {
        List<Article> articles = JSoupSpider.getArticles();
        int[] result = articleDao.batchInsert(articles);
        System.out.println(result.length);
    }
}