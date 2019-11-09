package com.niit.web.blog.util;

import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫工具
 * @Date 9:13 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);

    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("https://www.jianshu.com/?page=2").get();
            Elements divs = doc.getElementsByClass("have-img");
            System.out.println(divs.size());
            divs.forEach(div -> {
                Element element = div.children().get(1).children().get(0);
                Element element1 = div.children().get(1).children().get(1);
                Element element2 = div.children().get(1).children().get(2).children().get(2).children().get(1);
                Element img = div.children().get(0).children().get(0);

                System.out.println("https:"+img.attr("src"));
                System.out.println(element.text());
                System.out.println(element1.text());
                System.out.println(element2.text());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Article> getArticles(){
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int j = 1; j <= 3; j++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/?page="+j).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div ->{
                Element element = div.children().get(1).children().get(0);
                Element element1 = div.children().get(1).children().get(1);
                Element img = div.children().get(0).children().get(0);
                Article article = new Article();
                article.setTitle(element.text());
                article.setArticlemain(element1.text());
                article.setArticlepic("https:" + img.attr("src"));
                article.setPublishtime(DataUtil.getPublishtime());
                article.setUserid(DataUtil.getUserid());
                article.setComment(DataUtil.getComment());
                article.setPraise(DataUtil.getPraise());
                articleList.add(article);
            });
        }
        return articleList;
    }
    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(DataUtil.getMobile());
                user.setPassword(DataUtil.getPassword());
                user.setGender(DataUtil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(DataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }
}
