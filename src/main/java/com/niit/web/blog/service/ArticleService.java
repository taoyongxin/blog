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
}
