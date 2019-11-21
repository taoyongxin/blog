package com.niit.web.blog.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

/**
 * @author Tao
 * @ClassName UploadController
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
@MultipartConfig(maxFileSize = 1024 * 1024 * 50)
@WebServlet(urlPatterns = "/api/upload")
public class UploadController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            String name = part.getSubmittedFileName();
            System.out.println(name);
            String path = req.getSession().getServletContext().getRealPath("");
            System.out.println(path);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String time = df.format(new Date());
            System.out.println(time);
            File dif = new File(path+time);
            dif.mkdirs();
            System.out.println("此刻目录："+path+time);

            int i=name.indexOf(".");
            String name1 = name.substring(i,name.length());

            part.write(path+time+"\\"+ UUID.randomUUID()+name1);
            System.out.println(path + time+"\\"+name);
            req.setAttribute("msg","上传成功！");
            req.getRequestDispatcher("/upload.jsp").forward(req,resp);
        }

    }
}
