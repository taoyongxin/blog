package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.ArticleService;
import com.niit.web.blog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * @ClassName ArticleController
 * @Description TODO
 * @Date 2019/11/14
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/article","/article/*"})
public class ArticleController extends HttpServlet {
   private ArticleService articleService = ServiceFactory.getArticleServiceInstance();
   private static Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String reqPath = req.getRequestURI().trim();
       System.out.println(reqPath);
       if (reqPath.equals("/article")){
           getArticle(req,resp);
           System.out.println("进入到A1处");
       }else {
           getAuthorNickName(req,resp);
       }

    }
    private void getAuthorNickName(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        Gson gson = new GsonBuilder().create();
        ResponseObject ro = new ResponseObject().success(200,"成功",articleService.getAuthorNickName());
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
    private void  getArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        List<Article> articleList = articleService.listarticle();
        ResponseObject ro =new ResponseObject();
        Gson gson = new GsonBuilder().create();
        ro.setCode(resp.getStatus());
        System.out.println("进入此处b1");
        if (resp.getStatus() == 200){
            ro.setMsg("响应成功");
        }else{
            ro.setMsg("响应失败");
        }
        ro.setData(articleList);
        PrintWriter out =resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
    private void getArticleByWords(HttpServletResponse resp,String keywords) throws ServletException,IOException{

    }
    private void getArticleByCreateTime(HttpServletRequest req , HttpServletResponse resp) {

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
