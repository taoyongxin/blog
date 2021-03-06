package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.TopicVo;
import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;



public class TopicDaoTest {
    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();

    /*@Test
    public void bathInsert() throws SQLException {
        List<Topic> topics = JSoupSpider.getTopics();
        int[] result = topicDao.batchInsert(topics);
        System.out.println(result.length);
    }*/

    @Test
    public void selectHotTopics() throws SQLException{
        List<Topic> topicList = topicDao.selectHotTopics();
        System.out.println(topicList.size());
        topicList.forEach(topic -> System.out.println(topic));
    }

    @Test
    public void getTopic() throws SQLException{
        TopicVo topic = topicDao.getTopic(2);
        System.out.println(topic);
    }



    @Test
    public void selectAllTopic() throws SQLException{
        List<Topic> topics = topicDao.selectAllTopic();
        topics.forEach(topic -> System.out.println(topic));
        System.out.println(topics.size());
    }
}