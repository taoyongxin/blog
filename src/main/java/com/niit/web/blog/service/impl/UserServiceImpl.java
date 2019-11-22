package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public Map<String, Object> signIn(UserDto userDto) {
        User user = null;
        Map<String,Object> map = new HashMap<>();
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if(user != null){
            if (user.getPassword().equals(userDto.getPassword())){
                map.put("msg","登陆成功");
                map.put("data",user);
            }else {
                map.put("msg","密码错误");
            }
        }else{
            map.put("msg","手机号不存在");
        }
        return map;

    }

    @Override
    public List<User> listUser() {
        List<User> users = null;
        try {
            users = userDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询用户操作失败");
        }
        return users;
    }


}
