package com.niit.web.blog.dao;

import com.niit.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName UserDao
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 批量新增用户
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<User> userList ) throws SQLException;
    /**
     * 根据手机号查找用户
     */
    User findUserByMobile(String mobile)throws SQLException;

    /**
     * 查看所有用户
     * @return
     * @throws SQLException
     */
    List<User> selectAll() throws SQLException;

    /**
     * 查询粉丝数量前十的用户
     * @return
     * @throws SQLException
     */
    List<User> selectHotUsers() throws SQLException;

    /**
     * 根据id获取用户详情
     * @param id
     * @return
     * @throws SQLException
     */
    User getUser(long id) throws SQLException;
}
