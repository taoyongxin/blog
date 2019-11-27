package com.niit.web.blog.service;

import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.util.Result;
import org.junit.Test;

import java.util.List;

public class TopicServiceTest {

    private TopicService topicService = ServiceFactory.getTopicServiceInstance();


    /**
     * 测试查询热门专题
     */
    @Test
    public void listtopic() {
        List<Topic> topics = topicService.listtopic();
        topics.forEach(topic -> System.out.println(topic));
    }

    /*@Test
    public void ListAllTopic() {
        List<Topic> topics = topicService.ListAllTopic();
        topics.forEach(topic -> System.out.println(topic));
        System.out.println(topics.size());
    }*/

    /**
     * 测试获取热门专题
     */
    @Test
    public void getHotTopic() {
        Result result = topicService.getHotTopics();
        System.out.println(result);
    }

    /**
     * 测试获取所有专题
     */
    @Test
    public void getAllTopic() {
        Result result = topicService.getAllTopic();
        System.out.println(result);
    }

    @Test
    public void getTopic() {
        Result result = topicService.getTopic(2);
        System.out.println(result.getData());
    }
}