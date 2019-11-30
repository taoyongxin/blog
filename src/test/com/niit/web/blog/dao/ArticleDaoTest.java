package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ArticleDaoTest {

    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();

    @Test
    public void selectHotArticles() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectHotArticles();
        System.out.println(articleVoList.size());
    }

    @Test
    public void getArticle() throws SQLException{
        ArticleVo article = articleDao.getArticle(5);
        System.out.println(article);
    }

    @Test
    public void selectByTopicId() throws SQLException {
        List<ArticleVo> articleVoList = articleDao.selectByTopicId(9);
        articleVoList.forEach(a -> System.out.println(a));
    }

    /**
     * 测试通过用户id查询此用户发表的文章
     * @throws SQLException
     */
    @Test
    public void selectByUserId() throws SQLException{
        List<ArticleVo> articleVoList =  articleDao.selectByUserId(8);
        articleVoList.forEach(a-> System.out.println(a));
    }

    @Test
    public void selectByPage() throws SQLException{
        List<ArticleVo> articleVoList = articleDao.selectByPage(1, 10);
        articleVoList.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException{
        List<ArticleVo> articleVoList = articleDao.selectByKeywords("架构");
        articleVoList.forEach(a-> System.out.println(a));
    }
}