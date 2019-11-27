package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.TopicService;
import com.niit.web.blog.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Tao
 * @ClassName TopicController
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/topic","/api/topic/all"})
public class TopicController extends HttpServlet {
    TopicService topicService = ServiceFactory.getTopicServiceInstance();
    private static Logger logger = LoggerFactory.getLogger(TopicController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI().trim();
        System.out.println(reqPath);
        if (reqPath.equals("/api/topic")){
            getHotTopic(req,resp);
        }
        else if (reqPath.equals("/api/topic/all")){
            getAllTopic(req,resp);
        }
    }

    /**
     * 获取热门专题
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void getHotTopic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /**
         * 未封装之前
         */
        /*List<Topic> topics = topicService.listtopic();
        ResponseObject ro = new ResponseObject();
        Gson gson = new GsonBuilder().create();
        ro.setCode(resp.getStatus());
        if (resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else {
            ro.setMsg("请求失败");
        }
        ro.setData(topics);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();*/
        Gson gson = new GsonBuilder().create();
        Result result = topicService.getHotTopics();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    /**
     * 获取所有专题
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void getAllTopic(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /**
         * 未封装
         */
      /*  List<Topic> topics = topicService.ListAllTopic();
        ResponseObject ro = new ResponseObject();
        Gson gson = new GsonBuilder().create();
        ro.setCode(resp.getStatus());
        if (resp.getStatus()==200){
            ro.setMsg("请求成功");
        }else {
            ro.setMsg("请求失败");
        }
        ro.setData(topics);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();*/
      Gson gson = new GsonBuilder().create();
      Result result = topicService.getAllTopic();
      PrintWriter out = resp.getWriter();
      out.print(gson.toJson(result));
      out.close();
    }
}
