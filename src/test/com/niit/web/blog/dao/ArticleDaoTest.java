package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoTest {
//    private static Logger logger = LoggerFactory.getLogger(ArticleDao.class);
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void selectAll() throws SQLException {
        List<Article> articles = articleDao.selectAll();
        articles.forEach(article -> System.out.println(article));
    }
    @Test
    public void batchInsert() throws SQLException {
        List<Article> articles = JSoupSpider.getArticles();
        int[] result = articleDao.batchInsert(articles);
        System.out.println(result.length);
    }

    @Test
    public void selectAuthorNickname() throws SQLException{
        List<ArticleVo> articleVoList = articleDao.selectAuthorNickName();
        articleVoList.forEach(a -> System.out.println(a));
    }

    @Test
    public void getArticle() throws SQLException{
        ArticleVo article = articleDao.getArticle(5);
        System.out.println(article);
    }

    @Test
    public void selectByTopicId() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectByTopicId(53);
        articleVoList.forEach(a -> System.out.println(a));
    }
}