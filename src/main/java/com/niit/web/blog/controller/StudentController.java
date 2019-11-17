package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.niit.web.blog.entity.Student;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.StudentService;

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
 * @ClassName StudentController
 * @Description TODO
 * @Date 2019/11/5
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService studentService = ServiceFactory.getStudentServiceInstance();
        List<Student> students = studentService.listStudent();
        Gson gson = new Gson();
        resp.setContentType("application/json;charset='utf-8'");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(students));
        out.close();
    }
}
