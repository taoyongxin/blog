package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.listener.MySessionContext;
import com.niit.web.blog.service.UserService;
import com.niit.web.blog.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author Tao
 * @ClassName UserController
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/user", "/api/user/*"})
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();

    private void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestBody = HttpUtil.getRequestBody(req);
        logger.info("登录用户信息："+requestBody);
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(requestBody,UserDto.class);
        //客户端输入的验证码
        String inputCode = userDto.getCode().trim();
        //取得客户端请求头里带来的token
        String sessionId = req.getHeader("Access-Token");
        //从自定义的监听代码中取得之前的session对象
        MySessionContext myc = MySessionContext.getInstance();
        HttpSession session = myc.getSession(sessionId);
        //取得当时存入的验证码
        String correctCode = session.getAttribute("code").toString();
        //忽略大小些对比
        if (inputCode.equalsIgnoreCase(correctCode)){
            HttpUtil.getResponseBody(resp,userService.signIn(userDto));
            //验证码正确进入登录业务逻辑调用
        } else {
            //验证码错误，直接将错误的信息返回给客户端，不要继续登录流程了
            HttpUtil.getResponseBody(resp,Result.failure(ResultCode.USER_VERIFY_CODE_ERROR));
        }
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
        String uri = req.getRequestURI().trim();
        System.out.println(uri);
        switch (uri) {
            case UrlPatten.USER:
                String page = req.getParameter("page");
                String keywords = req.getParameter("keywords");
                String count = req.getParameter("count");
                if (page != null) {
                    HttpUtil.getResponseBody(resp, userService.selectByPage(Integer.parseInt(page), Integer.parseInt(count)));
                } else if (keywords != null) {
                    HttpUtil.getResponseBody(resp, userService.selectByKeywords(keywords));
                } else {
                    HttpUtil.getResponseBody(resp, userService.getHotUsers());
                }
                break;
            case UrlPatten.USER_SUB:
                HttpUtil.getResponseBody(resp, userService.getUser(Long.parseLong(HttpUtil.getPathParam(req))));
            default:
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().trim();
        switch (uri) {
            case UrlPatten.USER_SIGN_IN:
                signIn(req,resp);
                break;
            case UrlPatten.USER_SIGN_UP:
                signUp(req, resp);
                break;
            default:
        }
    }

}
