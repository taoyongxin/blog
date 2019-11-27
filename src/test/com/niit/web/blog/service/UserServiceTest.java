package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.util.Result;
import org.junit.Test;

import java.util.Map;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();


    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13908706554","7081a432bf709392e990207ecfc4b410");
        Map<String,Object> map = userService.signIn(userDto);
        System.out.println(map);
    }

    @Test
    public void getHotUsers() {
        Result result = userService.getHotUsers();
        System.out.println(result);
    }
    @Test
    public void ListAllUsers() {
        Result result = userService.getAllUsers();
        System.out.println(result);
    }

    @Test
    public void getUser() {
        Result result  = userService.getUser(1);
        System.out.println(result.getData());
    }


}