package com.niit.web.blog.util;

import com.niit.web.blog.entity.Address;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.entity.User;

import org.jsoup.Connection;
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
 * @author tao
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
            doc = Jsoup.connect("http://www.ip33.com/area_code.html").get();
            Elements divs = doc.getElementsByClass("ip");
            System.out.println(divs.size());
            divs.forEach(div -> {

                  Element element1= div.children().get(1).children().get(0).children().get(1);
                  Element element2= div.children().get(1);
                  Element element3= div.children().first();

                System.out.println(element1.childNodeSize()/2);

                for (int j=0;j<=(element2.childNodeSize()/2-1);j++) {
                    for (int i = 0; i <= (element1.childNodeSize() / 2 - 1); i++) {
                        String str2 = element2.children().get(j).children().first().toString().substring(4, element2.children().get(j).children().first().toString().indexOf(" "));
                        String str1 = element1.children().get(i).toString().substring(4, element1.children().get(i).toString().indexOf(" "));
                        String str3 = element3.toString().substring(4,element3.toString().indexOf(" "));
                        String str4 = str3+str2+str1;
                        System.out.println(str4);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static List<Article> getArticles1(){
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
    }*/
    public static List<Article> getArticles(){
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int i=1;i<10;i++){
            try {
                document = Jsoup.connect("https://www.jianshu.com/c/87b50a03a96e?order_by=top&count=50&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div ->{
                String articleUrl = div.child(0).attr("href");
                Document document1 = null;
                try {
                    document1 = Jsoup.connect("https://www.jianshu.com" + articleUrl).get();
                } catch (IOException e) {
                    logger.error("连接失败");
                }
                Element articleElement = document1.getElementsByClass("_2rhmJa").first();
                Article article = new Article();
                article.setContent(articleElement.html());
                article.setContent(articleElement.html());
                Elements elements = div.children();
                Element linkElement = elements.get(0);
                Element divElement = elements.get(1);
                article.setTitle(divElement.child(0).text());
                String img = "https:" + linkElement.child(0).attr("src");
                int index = img.indexOf("?");
                article.setArticle_pic(img.substring(0, index));
                article.setSummary(divElement.child(1).text());
                /*article.setComment(DataUtil.getComment());
                article.setPraise(DataUtil.getPraise());*/
                Elements metaChildren = divElement.child(2).children();
                String comments = metaChildren.get(2).text();
                String likes = metaChildren.last().text();
                article.setComment(Integer.parseInt(comments));
                article.setPraise(Integer.parseInt(likes));
                article.setUser_id(DataUtil.getUser_id());
                article.setCreat_time(DataUtil.getPublishtime());
                article.setTopic_id( DataUtil.getTopicId());
                articleList.add(article);
            });
        }
        System.out.println(articleList.size());
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
    public static List<Address> getAddress(){
        Document document = null;
        List<Address> addressList = new ArrayList<>(100);
        try {
            document = Jsoup.connect("http://www.ip33.com/area_code.html").get();
        } catch (IOException e) {
            logger.error("连接失败");
        }
        Elements divs = document.getElementsByClass("ip");
        divs.forEach(div -> {

            Element element1= div.children().get(1).children().get(0).children().get(1);
            Element element2= div.children().get(1);
            Element element3= div.children().first();

            System.out.println(element1.childNodeSize()/2);

            for (int j=0;j<=(element2.childNodeSize()/2-1);j++) {
                for (int i = 0; i <= (element1.childNodeSize() / 2 - 1); i++) {
                    String str2 = element2.children().get(j).children().first().toString().substring(4, element2.children().get(j).children().first().toString().indexOf(" "));
                    String str1 = element1.children().get(i).toString().substring(4, element1.children().get(i).toString().indexOf(" "));
                    String str3 = element3.toString().substring(4,element3.toString().indexOf(" "));
                    String str4 = str3+str2+str1;
                    Address address = new Address();
                    address.setAddress(str4);
                    addressList.add(address);
                }
            }
        });
        System.out.println(addressList.size());
        return addressList;
    }
    public static List<Topic> getTopics(){
        List<Topic> topicList= new ArrayList<>(100);
        Connection connection;
        Document document = null;
        for (int i=1 ; i<=3; i++){
            try {
                connection = Jsoup.connect("https://www.jianshu.com/recommendations/collections?order_by=hot&page=" + i);
                connection.header("X-PJAX","true");
                document = connection.get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            assert document != null;
            Elements list = document.select(".collection-wrap");
            list.forEach(item -> {
                Elements elements = item.children();
                Topic topic = new Topic();
                Element link = elements.select("a").get(0);
                Element logo = link.child(0);
                Element name = link.child(1);
                Element description = link.child(2);
                Element articles = elements.select(".count > a").get(0);
                Element follows = elements.select(".count > a").get(0);
                topic.setAdmin_id(DataUtil.getUserId());
                topic.setTopic_name(name.text());
                topic.setLogo(logo.attr("src"));
                topic.setDescription(description.text());
                String[] str = StringUtil.getDigital(articles.text());
                topic.setArticles(Integer.parseInt(str[0]));
                str = StringUtil.getDigital(follows.text());
                topic.setFollows(Integer.parseInt(str[0]));
                topic.setCreate_time(DataUtil.getPublishtime());
                topicList.add(topic);
            });

        }
        return topicList;

    }
}
