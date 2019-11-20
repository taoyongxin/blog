package com.niit.web.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Tao
 * @ClassName VideoController
 * @Description TODO
 * @Date 2019/11/19
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/api/video")
public class VideoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        1.调用字符串生成的方法，生成随机字符串
        File file = new File("D:/fixed.mp4");
//        2.存入session，同时会返回给客户端的cookie
        req.getSession().setAttribute("code",file);
//

//        4.将图片先暂存到服务器指定路径

//        5.
        InputStream inputStream=new FileInputStream(file);
        byte[] b =new byte[(int) file.length()];
        inputStream.read(b);
        resp.setContentType("video/mp4");
//        6.通过输出流，将数组内容传送到客户端
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(b);
//        7.关流
        outputStream.close();
        inputStream.close();
    }
}