package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.util.Result;

import java.util.List;
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

    /**
     * 用户注册
     * @param userDto
     * @return
     */
    Map<String,Object> signUp(UserDto userDto);
    /**
     * 查询所有用户
     * @return
     */
    List<User> listUser();

    /**
     * 查询前十高粉丝量用户
     * @return
     */
    List<User> listHotUsers();

    Result getUser(long id);
}
