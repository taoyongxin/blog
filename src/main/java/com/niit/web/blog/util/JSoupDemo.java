package com.niit.web.blog.util;

import com.niit.web.blog.entity.Student;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName JSoupDemo
 * @Description TODO
 *  * @Version 1.0
 **/
public class JSoupDemo {
    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
            Elements divs = doc.getElementsByClass("col-xs-8");
            System.out.println(divs.size());
            divs.forEach(div -> {
                Elements links = div.children().first().children().first().children();
                Element element = links.get(1);
                System.out.println(element.text());
                Element img = links.get(0);
                System.out.println("https:"+img.attr("src"));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getData() {
        List<Student> studentList = new ArrayList<>();
        Document doc;
        try {
            doc = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
            Elements divs = doc.getElementsByClass("col-xs-8");
            System.out.println(divs.size());
            divs.forEach(div -> {
                Element element = div.children().first().children().first().children().get(1);
//                System.out.println(element.text());
                Element img = div.children().first().children().first().children().get(0);
//                System.out.println("https:"+img.attr("src"));
                Element element1 = div.children().first().children().first().children().get(2);
                Student student = new Student();
                student.setUsername(element.text());
                student.setAvatar("https:" + img.attr("src"));
                student.setCreateTime(LocalDateTime.now());
                student.setMotto(element1.text());
                studentList.add(student);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}