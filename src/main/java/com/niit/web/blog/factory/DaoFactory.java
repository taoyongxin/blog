package com.niit.web.blog.factory;

import com.niit.web.blog.dao.*;
import com.niit.web.blog.dao.impl.*;


/**
 * @author Tao
 * @ClassName DaoFactory
 * @Description TODO
 * @Date 2019/11/5
 * @Version 1.0
 **/
public class DaoFactory {
    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }

    public static ArticleDao getArticleDaoInstance() {
        return new ArticleDaoImpl();
    }

    public static TopicDao getTopicDaoInstance() {
        return new TopicDaoImpl();
    }

    public static RegionDao getRegionDaoInstance() {
        return new RegionDaoImpl();
    }
}
