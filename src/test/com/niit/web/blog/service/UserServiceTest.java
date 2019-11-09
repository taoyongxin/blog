package com.niit.web.blog.service;

import com.niit.web.blog.domain.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();


    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13909840579","0644be9a0826f445ad1f95a0346b52bb");
        Map<String,Object> map = userService.signIn(userDto);
        System.out.println(map);
    }
}