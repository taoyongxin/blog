package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.Student;
import com.niit.web.blog.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @ClassName ArticleDaoImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class ArticleDaoImpl implements ArticleDao {
    @Override
    public int[] batchInsert(List<Article> articlesList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_article (title,articlemain,articlepic,comment,praise,userid,publishtime) VALUES (?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        articlesList.forEach(article -> {
            try {
                pstmt.setString(1, article.getTitle());
                pstmt.setString(2, article.getArticlemain());
                pstmt.setString(3, article.getArticlepic());
                pstmt.setLong(4, article.getComment());
                pstmt.setLong(5, article.getPraise());
                pstmt.setLong(6, article.getUserid());
                pstmt.setObject(7, article.getPublishtime());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int[] result = pstmt.executeBatch();
        //别忘记提交
        connection.commit();
        pstmt.close();
        connection.close();
        return result;
    }

    /**
     *查询所有书籍
     * @return
     * @throws SQLException
     */
    @Override
    public List<Article> selectAll() throws SQLException {
        List<Article> articleList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_article ORDER BY id DESC ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            Article article = new Article();
            article.setId(rs.getInt("id"));
            article.setTitle(rs.getString("title"));
            article.setArticlemain(rs.getString("articlemain"));
            article.setArticlepic(rs.getString("articlepic"));
            article.setPublishtime(rs.getTimestamp("publishtime").toLocalDateTime());

            article.setComment(rs.getInt("comment"));
            article.setPraise(rs.getInt("praise"));
            articleList.add(article);
        }
        return articleList;
    }
}
