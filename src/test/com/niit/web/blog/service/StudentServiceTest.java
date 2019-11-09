package com.niit.web.blog.service;

import com.niit.web.blog.entity.Student;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {
    private StudentService studentService = ServiceFactory.getStudentServiceInstance();

    @Test
    public void listStudent() {
        List<Student> students = studentService.listStudent();
        students.forEach(student -> System.out.println(student));
    }
}