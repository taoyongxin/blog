package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.ArticleService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Date 2019/11/13
 * @Version 1.0
 **/
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    @Override
    public List<Article> listarticle() {
        List<Article> articles = null;
        try {
            articles = articleDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询所有书籍操作出现异常");
        }
        return articles;
    }
}
