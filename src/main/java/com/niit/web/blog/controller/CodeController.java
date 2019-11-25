package com.niit.web.blog.controller;

import com.niit.web.blog.util.ImageUtil;
import com.niit.web.blog.util.StringUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

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
       /*String code = CodeUtil.getRandomCode();
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
        //设置resp的响应内容
        resp.setContentType("image/jpg");
        //将图片通过输出流返回给客户端
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(bi,"jpg",out);
        out.close();*/
        //获取随机验证码
        String code = StringUtil.getRandomString();
        //存入session
        HttpSession session = req.getSession();
        session.setAttribute("code", code);
        resp.setHeader("Access-Token",session.getId());
        BufferedImage img = ImageUtil.getImage(200, 100, code);
        //设置resp的响应内容类型
        resp.setContentType("image/jpg");
        //将图片通过输出流返回给客户端
        OutputStream out = resp.getOutputStream();
        ImageIO.write(img, "jpg", out);
        out.close();
    }
}
