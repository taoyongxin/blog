package com.niit.web.blog.service;

import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class TopicServiceTest {

    private TopicService topicService = ServiceFactory.getTopicServiceInstance();

    /**
     * 查询热门专题
     */
    @Test
    public void listtopic() {
        List<Topic> topics = topicService.listtopic();
        topics.forEach(topic -> System.out.println(topic));
    }

    @Test
    public void ListAllTopic() {
        List<Topic> topics = topicService.ListAllTopic();
        topics.forEach(topic -> System.out.println(topic));
        System.out.println(topics.size());
    }
}