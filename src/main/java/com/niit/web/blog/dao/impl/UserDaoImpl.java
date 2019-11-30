package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.domain.vo.UserVo;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.util.BeanHandler;
import com.niit.web.blog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Tao
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class UserDaoImpl implements UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public int[] batchInsert(List<User> userList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_user (mobile,password,nickname,avatar,gender,birthday,introduction,create_time,fans,follows,articles) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        userList.forEach(user -> {
            try {
                pstmt.setString(1, user.getMobile());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getNickname());
                pstmt.setString(4, user.getAvatar());
                pstmt.setString(5, user.getGender());
                //日期的设置，可以使用setObject
                pstmt.setObject(6, user.getBirthday());
                pstmt.setString(7, user.getIntroduction());
                pstmt.setObject(8, user.getCreateTime());
                pstmt.setInt(9,user.getFans());
                pstmt.setInt(10,user.getFollows());
                pstmt.setInt(11,user.getArticles());
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
     * 新增
     * @param userDto
     * @return
     * @throws SQLException
     */
    @Override
    public int insert(UserDto userDto) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_user (mobile,password,nickname,create_time) VALUES(?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,userDto.getMobile());
        pstmt.setString(2,userDto.getPassword());
        pstmt.setString(3,userDto.getNickname());
        pstmt.setObject(4, Timestamp.valueOf(LocalDateTime.now()));
        int n = pstmt.executeUpdate();
        System.out.println("受影响条数："+n);
        return n;
    }




    @Override
    public User findUserByMobile(String mobile) throws SQLException {
        /*Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,mobile);
        ResultSet rs = pstmt.executeQuery();
        User user = null;
        if (rs.next()){
           *//* user = new User();*//*
            user = new User();
            user.setId(rs.getLong("id"));
            user.setMobile(rs.getString("mobile"));
            user.setPassword(rs.getString("password"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday").toLocalDate());
            user.setIntroduction(rs.getString("introduction"));
            user.setAddress(rs.getString("address"));
            user.setFollows(rs.getInt("follows"));
            user.setFans(rs.getInt("fans"));
            user.setArticles(rs.getInt("articles"));
            user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
            user.setStatus(rs.getShort("status"));
        }
        return user;*/
        /**
         * 封装后
         */
        Connection  connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE mobile = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,mobile);
        ResultSet rs = pstmt.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        User user = null;
        if (userList.size()!=0){
            user = userList.get(0);
        }
        DbUtil.close(connection,pstmt,rs);
        return user;
    }

    /**
     * 查询所有用户
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> selectAll() throws SQLException {
       /* List<User> userList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql ="SELECT * FROM t_user ORDER BY id DESC";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setNickname(rs.getString("nickname"));
            user.setAvatar(rs.getString("avatar"));
            user.setIntroduction(rs.getString("introduction"));
            userList.add(user);
        }
        return userList;*/
       Connection connection =DbUtil.getConnection();
       String sql = "SELECT * FROM t_user ORDER BY id DESC";
       PreparedStatement pst = connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection,pst,rs);
        return userList;

    }

    @Override
    public List<User> selectHotUsers() throws SQLException {
        /*Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user ORDER BY fans DESC LIMIT 10";
        PreparedStatement pst =  connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = new ArrayList<>(100);
        try {
            while (rs.next()){
                User user= new User();
                user.setNickname(rs.getString("nickname"));
                user.setAvatar(rs.getString("avatar"));
                user.setIntroduction(rs.getString("introduction"));
                user.setFans(rs.getInt("fans"));
                userList.add(user);
            }
        }catch (SQLException e){
            logger.error("查询热门用户数据产生异常");
        }
        DbUtil.close(connection,pst, rs);
        return userList;*/
        /**
         * 封装后
         */
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user ORDER BY fans DESC LIMIT 10";
        PreparedStatement pst =  connection.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        List<User> userList = BeanHandler.convertUser(rs);
        DbUtil.close(connection,pst,rs);
        return  userList;
    }

    @Override
    public UserVo getUser(long id) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_user WHERE id = ? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1,id);
        ResultSet rs = pstmt.executeQuery();
        UserVo userVo = new UserVo();
        User user = BeanHandler.convertUser(rs).get(0);
        userVo.setUser(user);
        DbUtil.close(connection,pstmt,rs);
        return userVo;
    }

   /* @Override
    public User getUser(long id) throws SQLException {
       Connection connection = DbUtil.getConnection();
       String sql = "SELECT * FROM t_user WHERE id = ? ";
       PreparedStatement pstmt = connection.prepareStatement(sql);
       pstmt.setLong(1,id);
       ResultSet rs = pstmt.executeQuery();
       User user = null;
       if (rs.next()){
           user = new User();
           user.setId(rs.getLong("id"));
           user.setMobile(rs.getString("mobile"));
           user.setNickname(rs.getString("nickname"));
           user.setAvatar(rs.getString("avatar"));
           user.setGender(rs.getString("gender"));
           user.setBirthday(rs.getDate("birthday").toLocalDate());
           user.setIntroduction(rs.getString("introduction"));
           user.setAddress(rs.getString("address"));
           user.setFollows(rs.getInt("follows"));
           user.setFans(rs.getInt("fans"));
           user.setArticles(rs.getInt("articles"));
           user.setCreateTime(rs.getTimestamp("create_time").toLocalDateTime());
       }
       return user;
    }*/


}
