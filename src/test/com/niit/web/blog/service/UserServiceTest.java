package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();


    @Test
    public void signIn() {
        UserDto userDto = new UserDto("13909840579","0644be9a0826f445ad1f95a0346b52bb");
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
}