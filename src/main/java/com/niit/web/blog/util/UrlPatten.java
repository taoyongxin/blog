package com.niit.web.blog.util;

/**
 * @author Tao
 * @ClassName UrlPatten
 * @Description UrlPatten字符串常量
 * @Date 2019/11/30
 * @Version 1.0
 **/
public class UrlPatten {
    public static final String USER = "/api/user";
    public static final String USER_SIGN_IN = "/api/user/sign-in";
    public static final String USER_SIGN_UP = "/api/user/sign-up";
    public static final String USER_CHECK_MOBILE = "/api/user/check";
    public static final String USER_SUB = "/api/user/*";

    public static final String TOPIC = "/api/topic";
    public static final String TOPIC_SUB = "/api/topic/*";
    public static final String ARTICLE = "/api/article";
    public static final String ARTICLE_SUB = "/api/article/*";

    public static final String WEATHER = "/api/weather";

}
