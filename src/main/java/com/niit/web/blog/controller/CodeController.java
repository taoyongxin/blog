package com.niit.web.blog.controller;

import com.niit.web.blog.util.CodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author Tao
 * @ClassName CodeController
 * @Description 验证码接口
 * @Date 2019/11/19
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/code"})
public class CodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String code = CodeUtil.getRandomCode();
        HttpSession session =req.getSession();
        session.setAttribute("code",code);
        int width = 130;
        int height = 35;
        Random random = new Random();
        Color color = new Color(130,182,45);
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics =bi.getGraphics();
        graphics.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        graphics.setColor(color);
        graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.DARK_GRAY);
        graphics.drawString(code,width/4,height/2);
        resp.setContentType("image/jpg");
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(bi,"jpg",out);
        out.close();
    }
}
