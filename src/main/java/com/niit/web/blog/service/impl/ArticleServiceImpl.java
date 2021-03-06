package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.ArticleService;
import com.niit.web.blog.util.Result;
import com.niit.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);



    /**
     * 查询指定id的文章信息
     * @param id
     * @return
     */
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

    /**
     * 查询所属专题的文章
     * @param topicId
     * @return
     */
    @Override
    public Result selectByTopicId(Long topicId) {
        List<ArticleVo> articleVo = null;
        try {
            articleVo =  articleDao.selectByTopicId(topicId);
        } catch (SQLException e) {
            logger.error("根据专题id查询文章失败");
        }
        if (articleVo !=null){
            return Result.success(articleVo);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 获取热门用户
     * @return
     */
    @Override
    public Result getHotArticles() {
        List<ArticleVo> articleList = null;
        try {
            articleList = articleDao.selectHotArticles();
        } catch (SQLException e) {
             logger.error("获取热门专题出现异常");
        }
        if(articleList != null){
            return Result.success(articleList);
        }else{
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 通过用户id查询该用户发布的文章
     * @param userId
     * @return
     */
    @Override
    public Result selectByUserId(Long userId) {
        List<ArticleVo> articleVo = null;
        try {
            articleVo = articleDao.selectByUserId(userId);
        } catch (SQLException e) {
            logger.error("根据用户id查询文章失败");
        }
        if(articleVo != null){
            return Result.success(articleVo);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 分页查询
     * @param currentPage
     * @param count
     * @return
     */
    @Override
    public Result getArticlesByPage(int currentPage, int count) {
        List<ArticleVo> articleVoList = null;
        try {
            articleVoList = articleDao.selectByPage(currentPage,count);
        } catch (SQLException e) {
            logger.error("分页查询文章出现异常");
        }
        if(articleVoList != null){
            return Result.success(articleVoList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result selectByKeywords(String keywords) {
        List<ArticleVo> articleVoList = null;
        try {
            articleVoList = articleDao.selectByKeywords(keywords);
        } catch (SQLException e) {
            logger.error("根据关键字查询文章出现异常");
        }
        if(articleVoList != null){
            return Result.success(articleVoList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
