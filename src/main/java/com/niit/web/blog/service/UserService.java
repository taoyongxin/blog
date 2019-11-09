package com.niit.web.blog.service;

import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.UserDto;

import java.util.Map;

/**
 * @author Tao
 * @ClassName UserService
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserService {
    /**
     * 用户登录
     * @param userDto
     * @return
     */
    Map<String,Object> signIn(UserDto userDto);
}
