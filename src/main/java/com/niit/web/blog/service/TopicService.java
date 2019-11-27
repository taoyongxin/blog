package com.niit.web.blog.service;

import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.util.Result;

import java.util.List;

/**
 * @author Tao
 * @ClassName TopicService
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
public interface TopicService {
    /**
     * 热门前十专题
     * @return
     */
    List<Topic> listtopic();

    /**
     * 查询所有专题
     * @return
     */
    /*List<Topic> ListAllTopic();*/
    Result getAllTopic();

    /**
     * 获取热门专题
     * @return
     */
    Result getHotTopics();
    /**
     * 根据id获取专题的详细信息
     * @param id
     * @return
     */
    Result getTopic(long id);

}
