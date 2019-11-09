package com.niit.web.blog.service;

import com.niit.web.blog.entity.Student;

import java.util.List;

/**
 * @author Tao
 * @ClassName StudentService
 * @Description TODO
 * @Date 2019/11/5
 * @Version 1.0
 **/
public interface StudentService {
    /**
     * 浏览所有学生信息
     * @return
     */
    List<Student> listStudent();
}
