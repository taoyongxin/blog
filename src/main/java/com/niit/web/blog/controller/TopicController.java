package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.TopicService;
import com.niit.web.blog.util.ResponseObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Tao
 * @ClassName TopicController
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/topic")
public class TopicController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TopicService topicService = ServiceFactory.getTopicServiceInstance();
        List<Topic> topics = topicService.listtopic();
        Gson gson = new GsonBuilder().create();
        ResponseObject ro = new ResponseObject();
        ro.setCode(resp.getStatus());
        if (resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else {
            ro.setMsg("请求失败");
        }
        ro.setData(topics);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
}
