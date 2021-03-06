package com.niit.web.blog.service;

import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.util.Result;
import org.junit.Test;

public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();


    @Test
    public void signIn() {
        UserDto userDao = new UserDto();
        userDao.setMobile("13917310803");
        userDao.setPassword("111");
        Result result = userService.signIn(userDao);
        System.out.println("code:"+result.getCode()+",msg"+result.getMsg());
        /*UserDto userDto = new UserDto("13908706554","7081a432bf709392e990207ecfc4b410");
        Map<String,Object> map = userService.signIn(userDto);
        System.out.println(map);*/
    }
    @Test
    public void selectByKeywords() {
        Result result = userService.selectByKeywords("互联网");
        System.out.println(result);
    }
    @Test
    public void getUsersByPage() {
        Result result = userService.selectByPage(2,10);
        System.out.println(result.getData());
    }
    @Test
    public void getHotUsers() {
        Result result = userService.getHotUsers();
        System.out.println(result);
    }
   /* @Test
    public void ListAllUsers() {
        Result result = userService.getAllUsers();
        System.out.println(result);
    }*/

    @Test
    public void getUser() {
        Result result  = userService.getUser(1);
        System.out.println(result.getData());
    }


}