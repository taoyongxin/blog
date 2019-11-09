package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.StudentDao;
import com.niit.web.blog.entity.Student;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Date 2019/11/5
 * @Version 1.0
 **/
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = DaoFactory.getStudentDaoInstance();
    @Override
    public List<Student> listStudent() {
        List<Student> students = null;
        try {
            students = studentDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询所有学生操作出现异常");
        }
        return students;
    }
}
