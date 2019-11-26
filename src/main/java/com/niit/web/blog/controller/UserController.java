package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.UserService;
import com.niit.web.blog.util.Message;
import com.niit.web.blog.util.ResponseObject;
import com.niit.web.blog.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 * @ClassName UserController
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/sign-in","/sign-up","/user","/user/hot","/user/*"})
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI().trim();
        if ("/sign-in".equals(reqPath)){
            signIn(req,resp);
        }else if ("/sign-up".equals(reqPath)){
            System.out.println("进入此处");
            signUp(req,resp);
        }
    }
    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null){
            stringBuilder.append(line);
        }
        logger.info("登录用户信息："+ stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(),UserDto.class);
        Map<String,Object> map = userService.signIn(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        if (msg.equals(Message.SIGN_IN_SUCCESS)){
            ro = ResponseObject.success(200, msg, map.get("data"));
        }else{
            ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    protected void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        System.out.println(stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        Map<String, Object> map = null;
        // 获取请求路径
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        String requestPath = req.getRequestURI().trim();
        PrintWriter out = resp.getWriter();
        map = userService.signUp(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        switch (msg) {
            case Message.REGISTER_SUCCESS:
                ro = ResponseObject.success(200, msg, map.get("data"));
                break;
            case Message.REGISTER_DEFEATED:
            default:
                ro = ResponseObject.success(200, msg);
        }
        out.print(gson.toJson(ro));
        out.close();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI().trim();
        System.out.println(reqPath);
        if (reqPath.equals("/user")){
            getUser(req,resp);
        }else if(reqPath.equals("/user/hot")){
            getHotUsers(req,resp);
        }else{
            getUserById(req,resp);
        }
    }
    protected void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList=userService.listUser();
        Gson gson = new GsonBuilder().create();
        ResponseObject ro =new ResponseObject();
        ro.setCode(resp.getStatus());
        if(resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else {
            ro.setMsg("请求失败");
        }
        ro.setData(userList);
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
    protected void getHotUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList=userService.listHotUsers();
        ResponseObject ro =new ResponseObject();
        Gson gson = new GsonBuilder().create();
        ro.setCode(resp.getStatus());
        if(resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else {
            ro.setMsg("请求失败");
        }
        ro.setData(userList);
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
    private void getUserById(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        String info = req.getPathInfo().trim();
        String id = info.substring(info.indexOf("/")+1);
        Result result = userService.getUser(Long.parseLong(id));
        Gson gson = new GsonBuilder().create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }
    @Override
    public void init() throws ServletException {
        logger.info("UserController初始化");
    }
}
