package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.domain.vo.ArticleVo;
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
        String sql = "INSERT INTO t_article (title,article_pic,comment,praise,user_id,creat_time,summary,content) VALUES (?,?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        articlesList.forEach(article -> {
            try {
                pstmt.setString(1, article.getTitle());
                pstmt.setString(2, article.getArticle_pic());
                pstmt.setInt(3, article.getComment());
                pstmt.setInt(4, article.getPraise());
                pstmt.setLong(5, article.getUser_id());
                pstmt.setObject(6, article.getCreat_time());
                pstmt.setString(7, article.getSummary());
                pstmt.setString(8, article.getContent());
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
            article.setArticle_pic(rs.getString("article_pic"));
            article.setComment(rs.getInt("comment"));
            article.setPraise(rs.getInt("praise"));
            article.setUser_id(rs.getInt("user_id"));
            article.setCreat_time(rs.getTimestamp("creat_time").toLocalDateTime());
            article.setSummary(rs.getString("summary"));
            article.setContent(rs.getString("content"));
            articleList.add(article);
        }
        return articleList;
    }

    @Override
    public List<ArticleVo> selectAuthorNickName() throws SQLException {
        List<ArticleVo> articleVoList = new ArrayList<>(20);
        Connection connection = DbUtil.getConnection();
        //文章表和用户表进行联查，得到视图对象
        String sql = "SELECT a.id,a.user_id,a.title,a.summary,a.article_pic,a.comment,a.praise,b.id,b.nickname,b.avatar\n"+
                "FROM t_article a\n"+
                "LEFT JOIN t_user b\n"+
                "ON a.user_id = b.id\n"+
                "ORDER BY a.comment DESC LIMIT 20";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            ArticleVo articleVo = new ArticleVo();
            articleVo.setId(rs.getLong("id"));
            articleVo.setUser_id(rs.getLong("user_id"));
            articleVo.setNickname(rs.getString("nickname"));
            articleVo.setAvatar(rs.getString("avatar"));
            articleVo.setTitle(rs.getString("title"));
            articleVo.setSummary(rs.getString("summary"));
            articleVo.setArticle_pic(rs.getString("article_pic"));
            articleVo.setComment(rs.getInt("comment"));
            articleVo.setPraise(rs.getInt("praise"));
            articleVoList.add(articleVo);
        }
        return  articleVoList;
    }
}
