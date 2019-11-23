package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.ArticleService;
import com.niit.web.blog.util.Result;
import com.niit.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
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
    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
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

    @Override
    public List<ArticleVo> getAuthorNickName() {
        List<ArticleVo> articleVoList= new ArrayList<>(20);
        try {
            articleVoList = articleDao.selectAuthorNickName();
        } catch (SQLException e) {
            logger.error("利用文章id查询用户昵称失败");
        }
        return articleVoList;
    }

    @Override
    public Result getArticle(long id) {
        ArticleVo articleVo = null;
        try {
            articleVo = articleDao.getArticle(id);
        } catch (SQLException e) {
            logger.error("根据id查询文章出现异常");
        }
        if(articleVo != null){
            return Result.success(articleVo);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
