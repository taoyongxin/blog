package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName TopicDao
 * @Description TODO
 * @Date 2019/11/17
 * @Version 1.0
 **/
public interface TopicDao {
    /**
     * 爬取简书网专题
     * @param topicList
     * @return
     * @throws SQLException
     */
    int[] bathInsert(List<Topic> topicList) throws SQLException;

    List<Topic> selectHotTopics() throws SQLException;

}
