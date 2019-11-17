package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.Student;

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
    List<ArticleVo> selectAuthorNickName() throws SQLException;
}
