package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;



public class TopicDaoTest {
    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();

    @Test
    public void bathInsert() throws SQLException {
        List<Topic> topics = JSoupSpider.getTopics();
        int[] result = topicDao.bathInsert(topics);
        System.out.println(result.length);
    }

    @Test
    public void selectHotTopics() throws SQLException{
        List<Topic> topicList = topicDao.selectHotTopics();
        System.out.println(topicList.size());
    }
}