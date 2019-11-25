package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Article;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName ArticleDao
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface ArticleDao {
    /**
     * 批量增加新文章
     * @param articlesList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Article> articlesList ) throws SQLException;

    /**
     * 查询所有数据信息
     * @return
     * @throws SQLException
     */
    List<Article> selectAll() throws SQLException;

    /**
     * 双表联查 文章表用户id 获取 用户表用户昵称
     * @return
     * @throws SQLException
     */
    List<ArticleVo> selectAuthorNickName() throws SQLException;

    /**
     * 根据id获取文章详情
     * @param id
     * @return
     * @throws SQLException
     */
    ArticleVo getArticle(long id) throws SQLException;

    /**
     * 专题ID归类文章
     * @param topicId
     * @return
     * @throws SQLException
     */
    List<ArticleVo> selectByTopicId(long topicId) throws SQLException;

}
