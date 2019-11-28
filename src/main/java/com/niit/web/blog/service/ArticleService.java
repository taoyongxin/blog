package com.niit.web.blog.service;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.util.Result;

import java.util.List;

/**
 * @author Tao
 * @ClassName ArticleService
 * @Description TODO
 * @Date 2019/11/13
 * @Version 1.0
 **/
public interface ArticleService {
    List<Article> listarticle();

    /**
     * 用id获取用户作者昵称
     * @return
     */
    List<ArticleVo> getAuthorNickName();

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    Result getArticle(long id);

    /**
     * 根据专题id查询所属专题的文章
     * @param topicId
     * @return
     */
    Result selectByTopicId(Long topicId);

    /**
     * 获取热门文章
     * @return
     */
    Result getHotArticles();

    /**
     * 根据用户id查询该用户发布的文章
     * @param userId
     * @return
     */
    Result selectByUserId(Long userId);

    /**
     *获取分页文章
     * @param currentPage
     * @param count
     * @return
     */
    Result getArticlesByPage(int currentPage,int count);
}
