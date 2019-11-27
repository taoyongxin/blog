package com.niit.web.blog.dao;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.domain.vo.UserVo;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;


public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void batchInsert() {
        try {
            int[] result = userDao.batchInsert(JSoupSpider.getUsers());
            if (result.length != 0){
                logger.info("批量新增用户成功");
            }
        } catch (SQLException e) {
           logger.error("批量新增用户失败");

        }
    }

    @Test
    public void findUserByMobile() throws SQLException {
        User userList = userDao.findUserByMobile("13908706554");
        System.out.println(userList);
    }

    @Test
    public void selectAll() throws SQLException {
        List<User> userList = userDao.selectAll();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void selectHotUsers() throws SQLException {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void getUser() throws SQLException {
        UserVo userVo = userDao.getUser(1);
        System.out.println(userVo);
    }

    /**
     * 测试用户新增
     * @throws SQLException
     */
    @Test
    public void insertUser() throws SQLException{
        UserDto userDto = new UserDto();
        userDto.setMobile("1427177855");
        userDto.setPassword("111");
        userDto.setNickname("tao");
        int result = userDao.insert(userDto);
        if (result == 1){
            logger.info("成功新增");
        }else{
            logger.info("新增失败");
        }
    }
}