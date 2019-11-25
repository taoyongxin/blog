package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.util.Result;
import org.junit.Test;

import java.util.List;
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
    public void ListHotUsers() {
        List<User> users = userService.listHotUsers();
        users.forEach(user -> System.out.println(user));
        System.out.println(users.size());
    }
    @Test
    public void ListAllUsers() {
        List<User> users = userService.listUser();
        users.forEach(user -> System.out.println(user));
        System.out.println(users.size());
    }

    @Test
    public void getUser() {
        Result result  = userService.getUser(1);
        System.out.println(result.getData());
    }
}