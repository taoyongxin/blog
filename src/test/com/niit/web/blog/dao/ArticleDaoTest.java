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

    @Test
    public void selectHotArticles() throws SQLException {
        List<ArticleVo> articles = articleDao.selectHotArticles();
        articles.forEach(article -> System.out.println(article));
        System.out.println(articles.size());
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
    public void selectByPage() {
        List<ArticleVo> articleVoList = null;
        try {
            articleVoList = articleDao.selectByPage(1,10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        articleVoList.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException{
        List<ArticleVo> articleVoList = articleDao.selectByKeywords("架构");
        articleVoList.forEach(a-> System.out.println(a));
    }
}